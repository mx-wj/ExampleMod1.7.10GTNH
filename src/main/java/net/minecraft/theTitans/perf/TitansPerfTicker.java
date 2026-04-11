package net.minecraft.theTitans.perf;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class TitansPerfTicker {
    private int ticks;

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || !TitansPerf.ENABLED) return;
        ++this.ticks;
        if (this.ticks >= TitansPerf.DUMP_INTERVAL_TICKS) {
            this.ticks = 0;
            TitansPerf.dumpAndReset();
        }
    }
}
