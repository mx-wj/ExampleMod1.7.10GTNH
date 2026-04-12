/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.theTitans.world;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.LogManager;

public class WorldGenOmegafish extends WorldGenerator {
    private final Block field_150520_a;

    public WorldGenOmegafish(Block p_i45464_1_) {
        this.field_150520_a = p_i45464_1_;
    }

    public boolean generate(World worldIn, Random rng, int x, int y, int z) {
        if (worldIn == null || worldIn.isRemote) {
            return false;
        }
        if (rng.nextInt(20) != 0) {
            return false;
        }
        if (y <= 1 || y >= worldIn.getActualHeight() - 2) {
            return false;
        }

        if (!worldIn.getBlock(x, y - 1, z).isOpaqueCube()) {
            --y;
        } else if (worldIn.getBlock(x, y, z).isOpaqueCube()) {
            ++y;
        }

        if (y <= 1 || y >= worldIn.getActualHeight() - 2) {
            return false;
        }
        if (!worldIn.blockExists(x, y, z) || !worldIn.blockExists(x, y - 1, z)) {
            return false;
        }
        if (!worldIn.isAirBlock(x, y, z) || !worldIn.getBlock(x, y - 1, z).isOpaqueCube()) {
            return false;
        }

        AxisAlignedBB nearbyBox = AxisAlignedBB.getBoundingBox((double)x - 96.0, (double)y - 48.0, (double)z - 96.0, (double)x + 96.0, (double)y + 48.0, (double)z + 96.0);
        List nearbyTitans = worldIn.getEntitiesWithinAABB(EntityTitan.class, nearbyBox);
        if (nearbyTitans != null && !nearbyTitans.isEmpty()) {
            return false;
        }

        EntitySilverfishTitan entityomegafish = new EntitySilverfishTitan(worldIn);
        entityomegafish.setLocationAndAngles((float)x + 0.5f, y, (float)z + 0.5f, rng.nextFloat() * 360.0f, 0.0f);
        entityomegafish.onSpawnWithEgg(null);

        worldIn.spawnEntityInWorld((Entity)entityomegafish);
        LogManager.getLogger(TheTitans.class).info("Found a succesfully spawned Omegafish at " + x + ", " + y + ", " + z + ", spawning.");
        return true;
    }
}
