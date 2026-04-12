package net.minecraft.theTitans.util;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;

public final class TitanOptimizationHelper {
    private TitanOptimizationHelper() {}

    public static boolean shouldRunHeavyAI(Entity entity, int nearStride, int farStride, double nearRange) {
        EntityPlayer player = entity.worldObj.getClosestVulnerablePlayerToEntity(entity, nearRange);
        int stride = player != null ? Math.max(1, nearStride) : Math.max(1, farStride);
        return (entity.ticksExisted + entity.getEntityId()) % stride == 0;
    }

    public static boolean hasNearbyPlayer(Entity entity, double range) {
        return entity.worldObj.getClosestVulnerablePlayerToEntity(entity, range) != null;
    }

    public static boolean isExposedBlock(IBlockAccess world, int x, int y, int z) {
        return world.isAirBlock(x + 1, y, z)
            || world.isAirBlock(x - 1, y, z)
            || world.isAirBlock(x, y + 1, z)
            || world.isAirBlock(x, y - 1, z)
            || world.isAirBlock(x, y, z + 1)
            || world.isAirBlock(x, y, z - 1);
    }

    public static boolean shouldConsiderForTitanFallingBlock(IBlockAccess world, int x, int y, int z, int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        if (x == minX || x == maxX || y == minY || y == maxY || z == minZ || z == maxZ) {
            return true;
        }
        return isExposedBlock(world, x, y, z);
    }

    public static int countNearbyFallingBlocks(Entity entity, AxisAlignedBB box) {
        List list = entity.worldObj.getEntitiesWithinAABB(EntityFallingBlock.class, box);
        return list == null ? 0 : list.size();
    }

    public static int countNearbyItems(Entity entity, AxisAlignedBB box) {
        List list = entity.worldObj.getEntitiesWithinAABB(EntityItem.class, box);
        return list == null ? 0 : list.size();
    }

    public static int countShellVolume(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        int dx = Math.max(1, maxX - minX + 1);
        int dy = Math.max(1, maxY - minY + 1);
        int dz = Math.max(1, maxZ - minZ + 1);
        if (dx == 1 || dy == 1 || dz == 1) {
            return dx * dy * dz;
        }
        return 2 * (dx * dy + dx * dz + dy * dz) - 4 * (dx + dy + dz) + 8;
    }

    public static EntityLivingBase coerceLivingTarget(Entity entity) {
        return entity instanceof EntityLivingBase ? (EntityLivingBase) entity : null;
    }

    public static boolean canDropAsItem(Block block) {
        return block != null;
    }
}
