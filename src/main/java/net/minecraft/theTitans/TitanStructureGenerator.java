/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.IWorldGenerator
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package net.minecraft.theTitans;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.world.WorldGenBlazeTitan;
import net.minecraft.theTitans.world.WorldGenCaveSpiderTitan;
import net.minecraft.theTitans.world.WorldGenCreeperTitan;
import net.minecraft.theTitans.world.WorldGenGhastTitan;
import net.minecraft.theTitans.world.WorldGenMagmaCubeTitan;
import net.minecraft.theTitans.world.WorldGenOmegafish;
import net.minecraft.theTitans.world.WorldGenPigZombieTitan;
import net.minecraft.theTitans.world.WorldGenSkeletonTitan;
import net.minecraft.theTitans.world.WorldGenSlimeTitan;
import net.minecraft.theTitans.world.WorldGenSpiderJockeyTitan;
import net.minecraft.theTitans.world.WorldGenSpiderTitan;
import net.minecraft.theTitans.world.WorldGenWitherSkeletonTitan;
import net.minecraft.theTitans.world.WorldGenZombieTitan;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TitanStructureGenerator
implements IWorldGenerator {
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int dimensionId = world.provider.dimensionId;
        if (dimensionId == -1) {
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenMagmaCubeTitan(Blocks.netherrack), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenGhastTitan(Blocks.netherrack), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenWitherSkeletonTitan(Blocks.netherrack), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenBlazeTitan(Blocks.netherrack), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenPigZombieTitan(Blocks.netherrack), 256);
        } else if (dimensionId != 1 && dimensionId != -1 && dimensionId != 200 && dimensionId != 201) {
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenOmegafish(Blocks.stone), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenCaveSpiderTitan(Blocks.stone), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenSpiderTitan(Blocks.stone), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenSpiderJockeyTitan(Blocks.stone), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenZombieTitan(Blocks.stone), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenSkeletonTitan(Blocks.stone), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenCreeperTitan(Blocks.stone), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenSlimeTitan(Blocks.stone), 256);
        }
    }

    private void generateStructure(Random rand, World world, int chunkX, int chunkZ, WorldGenerator worldgen, int maxY) {
        int x = chunkX * 16 + rand.nextInt(16);
        int z = chunkZ * 16 + rand.nextInt(16);
        int randPosY = rand.nextInt(world.getActualHeight());
        if (world.provider.dimensionId != -1) {
            randPosY = world.getTopSolidOrLiquidBlock(x, z);
        }
        if (rand.nextInt(2) == 0) {
            worldgen.generate(world, rand, x, randPosY, z);
        }
    }
}

