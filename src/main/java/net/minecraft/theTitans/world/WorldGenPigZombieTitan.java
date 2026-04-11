/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 *  org.apache.logging.log4j.LogManager
 */
package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.LogManager;

public class WorldGenPigZombieTitan
extends WorldGenerator {
    private Block field_150520_a;

    public WorldGenPigZombieTitan(Block p_i45464_1_) {
        this.field_150520_a = p_i45464_1_;
    }

    public boolean generate(World worldIn, Random rng, int x, int y, int z) {
        if (!worldIn.getBlock(x, y - 1, z).isOpaqueCube()) {
            --y;
        } else if (!worldIn.isRemote && worldIn.isAirBlock(x, y, z) && worldIn.getBlock(x, y - 1, z).isOpaqueCube() && rng.nextInt(100) == 0) {
            EntityPigZombieTitan entityomegafish = new EntityPigZombieTitan(worldIn);
            entityomegafish.destroyBlocksInAABBGriefingBypass(entityomegafish.boundingBox);
            entityomegafish.onSpawnWithEgg(null);
            entityomegafish.setLocationAndAngles((float)x + 0.5f, y + 5, (float)z + 0.5f, rng.nextFloat() * 360.0f, 0.0f);
            EntityTitan otherTitan = (EntityTitan)worldIn.findNearestEntityWithinAABB(EntityTitan.class, entityomegafish.boundingBox.expand(200.0, 200.0, 200.0), (Entity)entityomegafish);
            if (otherTitan != null) {
                return false;
            }
            worldIn.spawnEntityInWorld((Entity)entityomegafish);
            LogManager.getLogger(TheTitans.class).info("Found a succesfully spawned Zombie Pigman Titan at " + x + ", " + y + ", " + z + ", spawning.");
            this.generateGold(worldIn, x, y + 4, z, 5, 5);
            this.generateGold(worldIn, x, y + 3, z, 6, 6);
            this.generateGold(worldIn, x, y + 2, z, 7, 7);
            this.generateGold(worldIn, x, y + 1, z, 8, 8);
            this.generateGold(worldIn, x, y, z, 9, 9);
            return true;
        }
        return false;
    }

    private void generateGold(World worldIn, int x, int y, int z, int diax, int diaz) {
        for (int l1 = x - diax; l1 <= x + diax; ++l1) {
            for (int i2 = z - diaz; i2 <= z + diaz; ++i2) {
                if (worldIn.getBlock(l1, y, i2).isOpaqueCube()) continue;
                worldIn.setBlock(l1, y, i2, Blocks.gold_block, 0, 1);
            }
        }
    }
}

