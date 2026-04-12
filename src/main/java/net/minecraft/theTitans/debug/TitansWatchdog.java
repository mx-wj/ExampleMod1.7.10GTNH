package net.minecraft.theTitans.debug;

import cpw.mods.fml.common.FMLLog;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class TitansWatchdog implements Runnable {
    public static volatile boolean ENABLED = true;
    public static volatile long STALL_THRESHOLD_MS = 10000L;
    public static volatile long CHECK_INTERVAL_MS = 1000L;
    public static volatile long DUMP_COOLDOWN_MS = 5000L;
    private static final AtomicBoolean STARTED = new AtomicBoolean(false);
    private static final AtomicLong LAST_DUMP_AT = new AtomicLong(0L);

    public static void start() {
        if (!ENABLED) {
            return;
        }
        if (!STARTED.compareAndSet(false, true)) {
            return;
        }
        Thread t = new Thread(new TitansWatchdog(), "Titans-Watchdog");
        t.setDaemon(true);
        t.start();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(CHECK_INTERVAL_MS);
                if (!ENABLED) {
                    continue;
                }
                if (!ServerHeartbeat.serverSeen) {
                    continue;
                }
                long stalledMs = (System.nanoTime() - ServerHeartbeat.lastTickNano) / 1000000L;
                if (stalledMs < STALL_THRESHOLD_MS) {
                    continue;
                }
                long nowMs = System.currentTimeMillis();
                long prev = LAST_DUMP_AT.get();
                if (nowMs - prev < DUMP_COOLDOWN_MS) {
                    continue;
                }
                if (LAST_DUMP_AT.compareAndSet(prev, nowMs)) {
                    dumpThreads(stalledMs);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    private static void dumpThreads(long stalledMs) {
        PrintWriter pw = null;
        try {
            String ts = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            File dir = new File("titans-watchdog");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File out = new File(dir, "thread-dump-" + ts + ".log");
            pw = new PrintWriter(new FileWriter(out));
            pw.println("=== Titans Watchdog Triggered ===");
            pw.println("stalledMs = " + stalledMs);
            pw.println("tickCounter = " + ServerHeartbeat.tickCounter);
            pw.println();

            ThreadMXBean bean = ManagementFactory.getThreadMXBean();
            ThreadInfo[] infos = bean.dumpAllThreads(true, true);
            int i;
            for (i = 0; i < infos.length; ++i) {
                ThreadInfo info = infos[i];
                if (info == null) {
                    continue;
                }
                pw.println("\"" + info.getThreadName() + "\" Id=" + info.getThreadId() + " State=" + info.getThreadState());
                if (info.getLockName() != null) {
                    pw.println("  waiting on " + info.getLockName());
                }
                if (info.getLockOwnerName() != null) {
                    pw.println("  owned by " + info.getLockOwnerName() + " Id=" + info.getLockOwnerId());
                }
                StackTraceElement[] stack = info.getStackTrace();
                int j;
                for (j = 0; j < stack.length; ++j) {
                    pw.println("    at " + stack[j]);
                }
                pw.println();
            }

            pw.println("=== Raw Thread.getAllStackTraces ===");
            for (Map.Entry<Thread, StackTraceElement[]> e : Thread.getAllStackTraces().entrySet()) {
                Thread t = e.getKey();
                pw.println("\"" + t.getName() + "\" State=" + t.getState());
                StackTraceElement[] stack = e.getValue();
                int j;
                for (j = 0; j < stack.length; ++j) {
                    pw.println("    at " + stack[j]);
                }
                pw.println();
            }
            pw.flush();
            FMLLog.severe("[TitansWatchdog] Server thread appears stalled for %d ms. Dump written to %s", new Object[]{Long.valueOf(stalledMs), out.getAbsolutePath()});
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
