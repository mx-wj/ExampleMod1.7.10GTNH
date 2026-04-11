/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.IWorldGenerator
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.gen.feature.WorldGenMinable
 */
package net.minecraft.theTitans;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class TitansOreGeneration
implements IWorldGenerator {
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int dimensionId = world.provider.dimensionId;
        if (dimensionId != -1 && dimensionId != 1 && dimensionId != 200 && dimensionId != 201) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.void_ore, Blocks.stone, 2, 1, 8);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.harcadium_ore, Blocks.stone, 4, 1, 12);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.copper_ore, Blocks.stone, 16, 10, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.tin_ore, Blocks.stone, 16, 10, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.chromium_ore, Blocks.stone, 9, 8, 48);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.magnesium_ore, Blocks.stone, 9, 8, 48);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.lead_ore, Blocks.stone, 9, 6, 48);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.silver_ore, Blocks.stone, 8, 4, 32);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.platinum_ore, Blocks.stone, 7, 2, 28);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.coal_block, Blocks.stone, 16, 8, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.iron_block, Blocks.stone, 8, 6, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.gold_block, Blocks.stone, 8, 4, 32);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.diamond_block, Blocks.stone, 7, 6, 16);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.emerald_block, Blocks.stone, 7, 6, 16);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.redstone_block, Blocks.stone, 7, 4, 32);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.lapis_block, Blocks.stone, 6, 3, 16);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.coal_ore, Blocks.stone, 32, 8, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.iron_ore, Blocks.stone, 24, 6, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.gold_ore, Blocks.stone, 24, 4, 32);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.diamond_ore, Blocks.stone, 18, 6, 16);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.emerald_ore, Blocks.stone, 18, 6, 16);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.redstone_ore, Blocks.stone, 18, 4, 32);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.lapis_ore, Blocks.stone, 16, 3, 16);
        } else if (dimensionId == -1) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.nether_stone_ore, Blocks.netherrack, 24, 20, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.nether_coal_ore, Blocks.netherrack, 16, 20, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.nether_gold_ore, Blocks.netherrack, 16, 2, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.nether_diamond_ore, Blocks.netherrack, 7, 1, 128);
        } else if (dimensionId == 1) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.void_ore_end_stone, Blocks.end_stone, 7, 10, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.harcadium_ore_end_stone, Blocks.end_stone, 16, 30, 128);
        } else if (dimensionId == 200) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.obsidian, Blocks.bedrock, 32, 20, 128);
        } else if (dimensionId == 201) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.void_ore_obsidian, Blocks.obsidian, 12, 20, 256);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.harcadium_ore_obsidian, Blocks.obsidian, 24, 60, 256);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.coal_ore, Blocks.obsidian, 16, 1, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.iron_ore, Blocks.obsidian, 8, 1, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.gold_ore, Blocks.obsidian, 8, 1, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.diamond_ore, Blocks.obsidian, 7, 1, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.redstone_ore, Blocks.obsidian, 7, 1, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.lapis_ore, Blocks.obsidian, 6, 1, 64);
        }
    }

    private void generateOre(Random rand, World world, int chunkX, int chunkZ, Block state, Block generateIn, int veinSize, int veinsPerChunk, int maxY) {
        for (int vein = 0; vein < veinsPerChunk; ++vein) {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(maxY);
            int randPosZ = chunkZ + rand.nextInt(16);
            WorldGenMinable genMinable = new WorldGenMinable(state, veinSize, generateIn);
            genMinable.generate(world, rand, randPosX, randPosY, randPosZ);
        }
    }
}

