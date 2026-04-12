package net.minecraft.theTitans.debug;

public final class ServerHeartbeat {
    public static volatile long lastTickNano = System.nanoTime();
    public static volatile long tickCounter = 0L;
    public static volatile boolean serverSeen = false;

    private ServerHeartbeat() {
    }

    public static void beat() {
        serverSeen = true;
        lastTickNano = System.nanoTime();
        ++tickCounter;
    }
}
