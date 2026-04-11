/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenObsidianSpike
extends WorldGenerator {
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        int l1;
        int k1;
        int j1;
        while (p_76484_1_.isAirBlock(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_4_ > 0) {
            --p_76484_4_;
        }
        if (p_76484_1_.getBlock(p_76484_3_, p_76484_4_, p_76484_5_) != Blocks.obsidian) {
            return false;
        }
        int l = p_76484_2_.nextInt(15) + 5;
        int i1 = l / 4 + p_76484_2_.nextInt(2);
        if (i1 > 1 && p_76484_2_.nextInt(50) == 0) {
            if (p_76484_2_.nextFloat() > 0.5f) {
                p_76484_4_ += 30 + p_76484_2_.nextInt(30);
            } else {
                l += 140;
            }
        }
        for (j1 = 0; j1 < l; ++j1) {
            float f = (1.0f - (float)j1 / (float)l) * (float)i1;
            k1 = MathHelper.ceiling_float_int((float)f);
            for (l1 = -k1; l1 <= k1; ++l1) {
                float f1 = (float)MathHelper.abs_int((int)l1) - 0.25f;
                for (int i2 = -k1; i2 <= k1; ++i2) {
                    float f2 = (float)MathHelper.abs_int((int)i2) - 0.25f;
                    if ((l1 != 0 || i2 != 0) && !(f1 * f1 + f2 * f2 <= f * f) || (l1 == -k1 || l1 == k1 || i2 == -k1 || i2 == k1) && !(p_76484_2_.nextFloat() <= 0.75f)) continue;
                    Block block = p_76484_1_.getBlock(p_76484_3_ + l1, p_76484_4_ + j1, p_76484_5_ + i2);
                    if (block.getMaterial() == Material.air || block == Blocks.obsidian) {
                        this.func_150515_a(p_76484_1_, p_76484_3_ + l1, p_76484_4_ + j1, p_76484_5_ + i2, Blocks.obsidian);
                    }
                    if (j1 == 0 || k1 <= 1 || (block = p_76484_1_.getBlock(p_76484_3_ + l1, p_76484_4_ - j1, p_76484_5_ + i2)).getMaterial() != Material.air && block != Blocks.obsidian) continue;
                    this.func_150515_a(p_76484_1_, p_76484_3_ + l1, p_76484_4_ - j1, p_76484_5_ + i2, Blocks.obsidian);
                }
            }
        }
        j1 = i1 - 1;
        if (j1 < 0) {
            j1 = 0;
        } else if (j1 > 1) {
            j1 = 1;
        }
        for (int j2 = -j1; j2 <= j1; ++j2) {
            for (k1 = -j1; k1 <= j1; ++k1) {
                Block block1;
                l1 = p_76484_4_ - 1;
                int k2 = 50;
                if (Math.abs(j2) == 1 && Math.abs(k1) == 1) {
                    k2 = p_76484_2_.nextInt(5);
                }
                while (l1 > 50 && ((block1 = p_76484_1_.getBlock(p_76484_3_ + j2, l1, p_76484_5_ + k1)).getMaterial() == Material.air || block1 == Blocks.obsidian)) {
                    this.func_150515_a(p_76484_1_, p_76484_3_ + j2, l1, p_76484_5_ + k1, Blocks.obsidian);
                    --l1;
                    if (--k2 > 0) continue;
                    l1 -= p_76484_2_.nextInt(5) + 1;
                    k2 = p_76484_2_.nextInt(5);
                }
            }
        }
        return true;
    }
}

