/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeDecorator
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.gen.feature.WorldGenSpikes
 */
package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.theTitans.world.WorldGenObsidianSpike;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenSpikes;

public class BiomeNowhereDecorator
extends BiomeDecorator {
    protected World worldObj;

    protected void genDecorations(BiomeGenBase p_150513_1_) {
        int k;
        int j;
        int i;
        this.generateOres();
        if (this.randomGenerator.nextInt(4) == 0) {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            k = this.currentWorld.getTopSolidOrLiquidBlock(i, j);
            new WorldGenSpikes(Blocks.obsidian).generate(this.currentWorld, this.randomGenerator, i, k, j);
        }
        if (this.randomGenerator.nextInt(4) == 0) {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            k = this.currentWorld.getTopSolidOrLiquidBlock(i, j);
            new WorldGenObsidianSpike().generate(this.currentWorld, this.randomGenerator, i, k, j);
        }
        if (this.randomGenerator.nextInt(10) == 0) {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            k = this.currentWorld.getTopSolidOrLiquidBlock(i, j);
            this.generateMelons(this.currentWorld, this.randomGenerator, i, k, j);
        }
        if (this.randomGenerator.nextInt(10) == 0) {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            k = this.currentWorld.getTopSolidOrLiquidBlock(i, j);
            this.generatePumpkins(this.currentWorld, this.randomGenerator, i, k, j);
        }
        if (this.randomGenerator.nextInt(1000) == 0) {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            k = this.currentWorld.getTopSolidOrLiquidBlock(i, j);
            this.generateDesertWell(this.currentWorld, this.randomGenerator, i, k, j);
        }
        if (this.chunk_X == 0 && this.chunk_Z == 0) {
            int k2 = this.currentWorld.getTopSolidOrLiquidBlock(this.chunk_X, this.chunk_Z);
            this.currentWorld.setBlock(0, k2, 0, TitanBlocks.adamantium_ore, 0, 3);
            this.currentWorld.setBlock(0, k2 + 1, 0, TitanBlocks.adamantium_ore, 0, 3);
        }
    }

    public boolean generateMelons(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        for (int l = 0; l < 64; ++l) {
            int k1;
            int j1;
            int i1 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
            if (!p_76484_1_.isAirBlock(i1, j1 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4), k1 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8)) || !Blocks.melon_block.canPlaceBlockAt(p_76484_1_, i1, j1, k1) || !p_76484_1_.getBlock(i1, j1 - 1, k1).getMaterial().isSolid()) continue;
            p_76484_1_.setBlock(i1, j1, k1, Blocks.melon_block, 0, 2);
        }
        return true;
    }

    public boolean generatePumpkins(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        for (int l = 0; l < 64; ++l) {
            int k1;
            int j1;
            int i1 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
            if (!p_76484_1_.isAirBlock(i1, j1 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4), k1 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8)) || !Blocks.pumpkin.canPlaceBlockAt(p_76484_1_, i1, j1, k1) || !p_76484_1_.getBlock(i1, j1 - 1, k1).getMaterial().isSolid()) continue;
            p_76484_1_.setBlock(i1, j1, k1, Blocks.pumpkin, p_76484_2_.nextInt(4), 2);
        }
        return true;
    }

    public boolean generateDesertWell(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        int i1;
        int l;
        for (l = -2; l <= 2; ++l) {
            for (i1 = -2; i1 <= 2; ++i1) {
                if (!p_76484_1_.isAirBlock(p_76484_3_ + l, p_76484_4_ - 1, p_76484_5_ + i1) || !p_76484_1_.isAirBlock(p_76484_3_ + l, p_76484_4_ - 2, p_76484_5_ + i1)) continue;
                return false;
            }
        }
        for (l = -1; l <= 0; ++l) {
            for (i1 = -2; i1 <= 2; ++i1) {
                for (int j1 = -2; j1 <= 2; ++j1) {
                    p_76484_1_.setBlock(p_76484_3_ + i1, p_76484_4_ + l, p_76484_5_ + j1, Blocks.sandstone, 0, 2);
                }
            }
        }
        p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_, (Block)Blocks.flowing_water, 0, 2);
        p_76484_1_.setBlock(p_76484_3_ - 1, p_76484_4_, p_76484_5_, (Block)Blocks.flowing_water, 0, 2);
        p_76484_1_.setBlock(p_76484_3_ + 1, p_76484_4_, p_76484_5_, (Block)Blocks.flowing_water, 0, 2);
        p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_ - 1, (Block)Blocks.flowing_water, 0, 2);
        p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_ + 1, (Block)Blocks.flowing_water, 0, 2);
        for (l = -2; l <= 2; ++l) {
            for (i1 = -2; i1 <= 2; ++i1) {
                if (l != -2 && l != 2 && i1 != -2 && i1 != 2) continue;
                p_76484_1_.setBlock(p_76484_3_ + l, p_76484_4_ + 1, p_76484_5_ + i1, Blocks.sandstone, 0, 2);
            }
        }
        p_76484_1_.setBlock(p_76484_3_ + 2, p_76484_4_ + 1, p_76484_5_, (Block)Blocks.stone_slab, 1, 2);
        p_76484_1_.setBlock(p_76484_3_ - 2, p_76484_4_ + 1, p_76484_5_, (Block)Blocks.stone_slab, 1, 2);
        p_76484_1_.setBlock(p_76484_3_, p_76484_4_ + 1, p_76484_5_ + 2, (Block)Blocks.stone_slab, 1, 2);
        p_76484_1_.setBlock(p_76484_3_, p_76484_4_ + 1, p_76484_5_ - 2, (Block)Blocks.stone_slab, 1, 2);
        for (l = -1; l <= 1; ++l) {
            for (i1 = -1; i1 <= 1; ++i1) {
                if (l == 0 && i1 == 0) {
                    p_76484_1_.setBlock(p_76484_3_ + l, p_76484_4_ + 4, p_76484_5_ + i1, Blocks.sandstone, 0, 2);
                    continue;
                }
                p_76484_1_.setBlock(p_76484_3_ + l, p_76484_4_ + 4, p_76484_5_ + i1, (Block)Blocks.stone_slab, 1, 2);
            }
        }
        for (l = 1; l <= 3; ++l) {
            p_76484_1_.setBlock(p_76484_3_ - 1, p_76484_4_ + l, p_76484_5_ - 1, Blocks.sandstone, 0, 2);
            p_76484_1_.setBlock(p_76484_3_ - 1, p_76484_4_ + l, p_76484_5_ + 1, Blocks.sandstone, 0, 2);
            p_76484_1_.setBlock(p_76484_3_ + 1, p_76484_4_ + l, p_76484_5_ - 1, Blocks.sandstone, 0, 2);
            p_76484_1_.setBlock(p_76484_3_ + 1, p_76484_4_ + l, p_76484_5_ + 1, Blocks.sandstone, 0, 2);
        }
        return true;
    }
}

