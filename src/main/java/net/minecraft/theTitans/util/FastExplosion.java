package net.minecraft.theTitans.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public final class FastExplosion {

    private FastExplosion() {}

    public static void createExplosion(World world, Entity source, double x, double y, double z, float radius, boolean smoking) {
        explode(world, source, x, y, z, radius, false, smoking);
    }

    public static void newExplosion(World world, Entity source, double x, double y, double z, float radius, boolean flaming, boolean smoking) {
        explode(world, source, x, y, z, radius, flaming, smoking);
    }

    private static void explode(World world, Entity source, double x, double y, double z, float radius, boolean flaming, boolean smoking) {
        if (world == null) return;

        float entityRadius = Math.max(0.75F, Math.min(radius, 10.0F));
        float blockRadius = Math.max(0.75F, Math.min(radius, 4.5F));
        float maxDamage = Math.max(4.0F, entityRadius * 2.5F);

        damageEntities(world, source, x, y, z, entityRadius, maxDamage);
        world.playSoundEffect(x, y, z, "random.explode", 2.0F, 0.9F + world.rand.nextFloat() * 0.2F);
        spawnParticles(world, x, y, z, entityRadius);

        if (!world.isRemote && smoking) {
            int budget = Math.min(64, Math.max(6, (int)(blockRadius * blockRadius * 2.0F)));
            breakExposedBlocks(world, x, y, z, blockRadius, budget);
            if (flaming) {
                igniteNearby(world, x, y, z, blockRadius, 4);
            }
        }
    }

    private static void damageEntities(World world, Entity source, double x, double y, double z, float radius, float maxDamage) {
        AxisAlignedBB box = AxisAlignedBB.getBoundingBox(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius);
        List list = world.getEntitiesWithinAABBExcludingEntity(source, box);
        for (int i = 0; i < list.size(); ++i) {
            Entity e = (Entity) list.get(i);
            if (e == null || !e.isEntityAlive() || e == source) continue;

            double dx = e.posX - x;
            double dy = e.posY + (double)e.getEyeHeight() - y;
            double dz = e.posZ - z;
            double distSq = dx * dx + dy * dy + dz * dz;
            double maxDistSq = (double)(radius * radius);
            if (distSq > maxDistSq || distSq < 1.0E-6D) continue;

            double dist = Math.sqrt(distSq);
            double factor = 1.0D - dist / (double)radius;
            if (factor <= 0.0D) continue;

            float damage = (float)((double)maxDamage * factor);
            DamageSource ds = source instanceof EntityLivingBase ? DamageSource.causeMobDamage((EntityLivingBase)source) : DamageSource.magic;
            e.attackEntityFrom(ds, damage);

            double knock = 0.8D * factor;
            e.motionX += dx / dist * knock;
            e.motionY += dy / dist * knock * 0.35D + 0.12D;
            e.motionZ += dz / dist * knock;
        }
    }

    private static void spawnParticles(World world, double x, double y, double z, float radius) {
        int count = Math.min(32, Math.max(8, (int)(radius * 4.0F)));
        for (int i = 0; i < count; ++i) {
            world.spawnParticle("explode",
                    x + (world.rand.nextDouble() - 0.5D) * radius,
                    y + world.rand.nextDouble() * Math.max(1.0F, radius * 0.5F),
                    z + (world.rand.nextDouble() - 0.5D) * radius,
                    0.0D, 0.0D, 0.0D);
            if ((i & 1) == 0) {
                world.spawnParticle("smoke",
                        x + (world.rand.nextDouble() - 0.5D) * radius,
                        y + world.rand.nextDouble() * Math.max(1.0F, radius * 0.5F),
                        z + (world.rand.nextDouble() - 0.5D) * radius,
                        0.0D, 0.02D, 0.0D);
            }
        }
    }

    private static void breakExposedBlocks(World world, double x, double y, double z, float radius, int budget) {
        int r = MathHelper.ceiling_float_int(radius);
        int minX = MathHelper.floor_double(x) - r;
        int minY = MathHelper.floor_double(y) - r;
        int minZ = MathHelper.floor_double(z) - r;
        int maxX = MathHelper.floor_double(x) + r;
        int maxY = MathHelper.floor_double(y) + r;
        int maxZ = MathHelper.floor_double(z) + r;

        int broken = 0;
        for (int bx = minX; bx <= maxX && broken < budget; ++bx) {
            for (int by = minY; by <= maxY && broken < budget; ++by) {
                for (int bz = minZ; bz <= maxZ && broken < budget; ++bz) {
                    if (!world.blockExists(bx, by, bz)) continue;
                    double dx = (bx + 0.5D) - x;
                    double dy = (by + 0.5D) - y;
                    double dz = (bz + 0.5D) - z;
                    if (dx * dx + dy * dy + dz * dz > (double)(radius * radius)) continue;
                    if (!isExposed(world, bx, by, bz)) continue;

                    Block block = world.getBlock(bx, by, bz);
                    if (block == null || block == Blocks.air) continue;
                    float hardness = block.getBlockHardness(world, bx, by, bz);
                    if (hardness < 0.0F || hardness > 20.0F) continue;

                    world.setBlockToAir(bx, by, bz);
                    ++broken;
                }
            }
        }
    }

    private static void igniteNearby(World world, double x, double y, double z, float radius, int budget) {
        int r = MathHelper.ceiling_float_int(radius);
        int minX = MathHelper.floor_double(x) - r;
        int minY = MathHelper.floor_double(y) - r;
        int minZ = MathHelper.floor_double(z) - r;
        int maxX = MathHelper.floor_double(x) + r;
        int maxY = MathHelper.floor_double(y) + r;
        int maxZ = MathHelper.floor_double(z) + r;

        int placed = 0;
        for (int bx = minX; bx <= maxX && placed < budget; ++bx) {
            for (int by = minY; by <= maxY && placed < budget; ++by) {
                for (int bz = minZ; bz <= maxZ && placed < budget; ++bz) {
                    if (!world.blockExists(bx, by, bz)) continue;
                    if (world.getBlock(bx, by, bz) != Blocks.air) continue;
                    if (world.getBlock(bx, by - 1, bz) == Blocks.air) continue;
                    if (world.rand.nextInt(4) != 0) continue;
                    world.setBlock(bx, by, bz, Blocks.fire);
                    ++placed;
                }
            }
        }
    }

    private static boolean isExposed(World world, int x, int y, int z) {
        return isAir(world, x + 1, y, z)
                || isAir(world, x - 1, y, z)
                || isAir(world, x, y + 1, z)
                || isAir(world, x, y - 1, z)
                || isAir(world, x, y, z + 1)
                || isAir(world, x, y, z - 1);
    }

    private static boolean isAir(World world, int x, int y, int z) {
        return world.blockExists(x, y, z) && world.getBlock(x, y, z) == Blocks.air;
    }
}
