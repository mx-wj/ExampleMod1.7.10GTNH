package net.minecraft.theTitans.perf;

import cpw.mods.fml.common.FMLLog;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class TitansPerf {
    public static boolean ENABLED = false;
    public static boolean LOG_SLOW_CALLS = true;
    public static long SLOW_CALL_NS = 5000000L;
    public static int DUMP_INTERVAL_TICKS = 200;
    private static final EnumMap<PerfSection, Stat> TOTAL = new EnumMap<PerfSection, Stat>(PerfSection.class);
    private static final HashMap<String, Stat> BY_KEY = new HashMap<String, Stat>();

    static {
        PerfSection[] values = PerfSection.values();
        int len = values.length;
        for (int i = 0; i < len; ++i) {
            TOTAL.put(values[i], new Stat());
        }
    }

    private TitansPerf() {}

    public static long begin() {
        return ENABLED ? System.nanoTime() : 0L;
    }

    public static void end(PerfSection sec, String key, long startNs) {
        if (!ENABLED) return;
        long cost = System.nanoTime() - startNs;
        TitansPerf.add(sec, key, cost);
    }

    public static void endWarn(PerfSection sec, String key, long startNs) {
        if (!ENABLED) return;
        long cost = System.nanoTime() - startNs;
        TitansPerf.add(sec, key, cost);
        if (LOG_SLOW_CALLS && cost >= SLOW_CALL_NS) {
            FMLLog.info("[TitansPerf][SLOW] %s key=%s cost=%.3fms", new Object[]{sec.name(), key, (double)cost / 1000000.0});
        }
    }

    private static void add(PerfSection sec, String key, long cost) {
        Stat total = TOTAL.get(sec);
        if (total != null) total.add(cost);
        Stat stat = BY_KEY.get(key);
        if (stat == null) {
            stat = new Stat();
            BY_KEY.put(key, stat);
        }
        stat.add(cost);
    }

    public static void count(String key, int amount) {
        if (!ENABLED) return;
        Stat stat = BY_KEY.get(key);
        if (stat == null) {
            stat = new Stat();
            BY_KEY.put(key, stat);
        }
        stat.extraCount += amount;
    }

    public static void dumpAndReset() {
        if (!ENABLED) return;
        FMLLog.info("========== TitansPerf ==========");
        for (Map.Entry<PerfSection, Stat> entry : TOTAL.entrySet()) {
            Stat s = entry.getValue();
            if (s.calls > 0L) {
                FMLLog.info("[TitansPerf][TOTAL] %s calls=%d total=%.3fms avg=%.3fus max=%.3fms", new Object[]{entry.getKey().name(), s.calls, (double)s.totalNs / 1000000.0, s.calls == 0L ? 0.0 : (double)s.totalNs / 1000.0 / (double)s.calls, (double)s.maxNs / 1000000.0});
            }
            s.reset();
        }
        for (Map.Entry<String, Stat> entry : BY_KEY.entrySet()) {
            Stat s = entry.getValue();
            if (s.calls <= 0L && s.extraCount <= 0L) continue;
            FMLLog.info("[TitansPerf][KEY] %s calls=%d extra=%d total=%.3fms avg=%.3fus max=%.3fms", new Object[]{entry.getKey(), s.calls, s.extraCount, (double)s.totalNs / 1000000.0, s.calls == 0L ? 0.0 : (double)s.totalNs / 1000.0 / (double)s.calls, (double)s.maxNs / 1000000.0});
        }
        BY_KEY.clear();
        FMLLog.info("================================");
    }

    private static final class Stat {
        long calls;
        long totalNs;
        long maxNs;
        long extraCount;

        private Stat() {}

        void add(long ns) {
            ++this.calls;
            this.totalNs += ns;
            if (ns > this.maxNs) this.maxNs = ns;
        }

        void reset() {
            this.calls = 0L;
            this.totalNs = 0L;
            this.maxNs = 0L;
            this.extraCount = 0L;
        }
    }
}
