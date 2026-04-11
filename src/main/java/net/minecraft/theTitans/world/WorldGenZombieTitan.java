/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 *  org.apache.logging.log4j.LogManager
 */
package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.LogManager;

public class WorldGenZombieTitan
extends WorldGenerator {
    private Block field_150520_a;

    public WorldGenZombieTitan(Block p_i45464_1_) {
        this.field_150520_a = p_i45464_1_;
    }

    public boolean generate(World worldIn, Random rng, int x, int y, int z) {
        if (!worldIn.getBlock(x, y - 1, z).isOpaqueCube()) {
            --y;
        } else if (worldIn.getBlock(x, y, z).isOpaqueCube()) {
            ++y;
        } else if (!worldIn.isRemote && worldIn.isAirBlock(x, y, z) && worldIn.getBlock(x, y - 1, z).isOpaqueCube() && rng.nextInt(100) == 0) {
            EntityZombieTitan entityomegafish = new EntityZombieTitan(worldIn);
            entityomegafish.destroyBlocksInAABBGriefingBypass(entityomegafish.boundingBox);
            entityomegafish.onSpawnWithEgg(null);
            entityomegafish.setLocationAndAngles((float)x + 0.5f, y, (float)z + 0.5f, rng.nextFloat() * 360.0f, 0.0f);
            EntityTitan otherTitan = (EntityTitan)worldIn.findNearestEntityWithinAABB(EntityTitan.class, entityomegafish.boundingBox.expand(200.0, 200.0, 200.0), (Entity)entityomegafish);
            if (otherTitan != null) {
                return false;
            }
            LogManager.getLogger(TheTitans.class).info("Found a succesfully spawned Zombie Titan at " + x + ", " + y + ", " + z + ", spawning.");
            worldIn.spawnEntityInWorld((Entity)entityomegafish);
            return true;
        }
        return false;
    }
}

