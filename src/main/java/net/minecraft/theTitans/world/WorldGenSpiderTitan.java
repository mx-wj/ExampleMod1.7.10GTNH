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
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.LogManager;

public class WorldGenSpiderTitan
extends WorldGenerator {
    private Block field_150520_a;

    public WorldGenSpiderTitan(Block p_i45464_1_) {
        this.field_150520_a = p_i45464_1_;
    }

    public boolean generate(World worldIn, Random rng, int x, int y, int z) {
        if (!worldIn.getBlock(x, y - 1, z).isOpaqueCube()) {
            --y;
        } else if (worldIn.getBlock(x, y, z).isOpaqueCube()) {
            ++y;
        } else if (!worldIn.isRemote && worldIn.isAirBlock(x, y, z) && worldIn.getBlock(x, y - 1, z).isOpaqueCube() && rng.nextInt(30) == 0) {
            EntitySpiderTitan entityomegafish = new EntitySpiderTitan(worldIn);
            entityomegafish.destroyBlocksInAABBGriefingBypass(entityomegafish.boundingBox);
            entityomegafish.onSpawnWithEgg(null);
            entityomegafish.setLocationAndAngles((float)x + 0.5f, y, (float)z + 0.5f, rng.nextFloat() * 360.0f, 0.0f);
            worldIn.spawnEntityInWorld((Entity)entityomegafish);
            LogManager.getLogger(TheTitans.class).info("Found a succesfully spawned Spider Titan at " + x + ", " + y + ", " + z + ", spawning.");
            this.generateSpidersWeb(worldIn, x, y, z);
            return true;
        }
        return false;
    }

    private void generateSpidersWeb(World worldIn, int x, int y, int z) {
        for (int l1 = x - 11; l1 <= x + 11; ++l1) {
            for (int j1 = y - 11; j1 <= y; ++j1) {
                for (int i2 = z - 11; i2 <= z + 11; ++i2) {
                    if (worldIn.getBlock(l1, j1, i2).getBlockHardness(worldIn, l1, j1, i2) == -1.0f) continue;
                    worldIn.setBlock(l1, j1, i2, Blocks.web, 0, 2);
                }
            }
        }
    }
}

