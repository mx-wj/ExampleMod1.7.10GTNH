/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityWitherTurretGround;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGroundTurretTowers
extends WorldGenerator {
    private Block field_150520_a;

    public WorldGenGroundTurretTowers(Block p_i45464_1_) {
        this.field_150520_a = p_i45464_1_;
    }

    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        if (p_76484_1_.isAirBlock(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_1_.getBlock(p_76484_3_, p_76484_4_ - 1, p_76484_5_) == this.field_150520_a) {
            int i2;
            int l1;
            int k1;
            int j1;
            int l = 2;
            int i1 = 2;
            for (j1 = p_76484_3_ - i1; j1 <= p_76484_3_ + i1; ++j1) {
                for (k1 = p_76484_5_ - i1; k1 <= p_76484_5_ + i1; ++k1) {
                    l1 = j1 - p_76484_3_;
                    i2 = k1 - p_76484_5_;
                    if (l1 * l1 + i2 * i2 > i1 * i1 + 1 || p_76484_1_.getBlock(j1, p_76484_4_ - 1, k1) == this.field_150520_a) continue;
                    return false;
                }
            }
            for (j1 = p_76484_4_; j1 < p_76484_4_ + l && j1 < 256; ++j1) {
                for (k1 = p_76484_3_ - i1; k1 <= p_76484_3_ + i1; ++k1) {
                    for (l1 = p_76484_5_ - i1; l1 <= p_76484_5_ + i1; ++l1) {
                        i2 = k1 - p_76484_3_;
                        int j2 = l1 - p_76484_5_;
                        if (i2 * i2 + j2 * j2 > i1 * i1 + 1) continue;
                        p_76484_1_.setBlock(k1, j1, l1, Blocks.bedrock, 0, 2);
                    }
                }
            }
            EntityWitherTurretGround entityendercrystal = new EntityWitherTurretGround(p_76484_1_);
            entityendercrystal.setLocationAndAngles((float)p_76484_3_ + 0.5f, p_76484_4_ + l, (float)p_76484_5_ + 0.5f, p_76484_2_.nextFloat() * 360.0f, 0.0f);
            p_76484_1_.spawnEntityInWorld((Entity)entityendercrystal);
            return true;
        }
        return false;
    }
}

