package net.minecraft.theTitans.util;

import net.minecraft.entity.Entity;

public final class MinionOptimizationHelper {
    private MinionOptimizationHelper() {}

    public static boolean shouldRunHeavyAI(Entity entity) {
        if (entity == null || entity.worldObj == null || entity.worldObj.isRemote) {
            return true;
        }
        return (entity.ticksExisted + entity.getEntityId()) % 3 == 0;
    }
}
