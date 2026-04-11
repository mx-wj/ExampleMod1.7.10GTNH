/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.tileentity.TileEntityChest
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.util.WeightedRandomChestContent
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 *  net.minecraftforge.common.ChestGenHooks
 */
package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

public class WorldGenNowhereDungeon
extends WorldGenerator {
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        int i2;
        int l1;
        int k1;
        int b0 = 6;
        int l = 6;
        int i1 = 6;
        int j1 = 0;
        for (k1 = p_76484_3_ - l - 1; k1 <= p_76484_3_ + l + 1; ++k1) {
            for (l1 = p_76484_4_ - 1; l1 <= p_76484_4_ + b0 + 1; ++l1) {
                for (i2 = p_76484_5_ - i1 - 1; i2 <= p_76484_5_ + i1 + 1; ++i2) {
                    Material material = p_76484_1_.getBlock(k1, l1, i2).getMaterial();
                    if (l1 == p_76484_4_ - 1 && !material.isSolid()) {
                        return false;
                    }
                    if (l1 == p_76484_4_ + b0 + 1 && !material.isSolid()) {
                        return false;
                    }
                    if (k1 != p_76484_3_ - l - 1 && k1 != p_76484_3_ + l + 1 && i2 != p_76484_5_ - i1 - 1 && i2 != p_76484_5_ + i1 + 1 || l1 != p_76484_4_ || !p_76484_1_.isAirBlock(k1, l1, i2) || !p_76484_1_.isAirBlock(k1, l1 + 1, i2)) continue;
                    ++j1;
                }
            }
        }
        if (j1 >= 1 && j1 <= 5) {
            for (k1 = p_76484_3_ - l - 1; k1 <= p_76484_3_ + l + 1; ++k1) {
                for (l1 = p_76484_4_ + b0; l1 >= p_76484_4_ - 1; --l1) {
                    for (i2 = p_76484_5_ - i1 - 1; i2 <= p_76484_5_ + i1 + 1; ++i2) {
                        if (k1 != p_76484_3_ - l - 1 && l1 != p_76484_4_ - 1 && i2 != p_76484_5_ - i1 - 1 && k1 != p_76484_3_ + l + 1 && l1 != p_76484_4_ + b0 + 1 && i2 != p_76484_5_ + i1 + 1) {
                            p_76484_1_.setBlockToAir(k1, l1, i2);
                            continue;
                        }
                        if (l1 >= 0 && !p_76484_1_.getBlock(k1, l1 - 1, i2).getMaterial().isSolid()) {
                            p_76484_1_.setBlockToAir(k1, l1, i2);
                            continue;
                        }
                        if (!p_76484_1_.getBlock(k1, l1, i2).getMaterial().isSolid()) continue;
                        p_76484_1_.setBlock(k1, l1, i2, Blocks.obsidian, 0, 2);
                    }
                }
            }
            block6: for (k1 = 0; k1 < 2; ++k1) {
                for (l1 = 0; l1 < 3; ++l1) {
                    int j2;
                    i2 = p_76484_3_ + p_76484_2_.nextInt(l * 2 + 1) - l;
                    if (!p_76484_1_.isAirBlock(i2, p_76484_4_, j2 = p_76484_5_ + p_76484_2_.nextInt(i1 * 2 + 1) - i1)) continue;
                    int k2 = 0;
                    if (p_76484_1_.getBlock(i2 - 1, p_76484_4_, j2).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2 + 1, p_76484_4_, j2).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2, p_76484_4_, j2 - 1).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2, p_76484_4_, j2 + 1).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2 - 1, p_76484_4_, j2 - 1).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2 + 1, p_76484_4_, j2 - 1).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2 - 1, p_76484_4_, j2 - 1).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2 - 1, p_76484_4_, j2 + 1).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2 - 1, p_76484_4_, j2 + 1).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2 + 1, p_76484_4_, j2 + 1).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2 + 1, p_76484_4_, j2 - 1).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (p_76484_1_.getBlock(i2 + 1, p_76484_4_, j2 + 1).getMaterial().isSolid()) {
                        ++k2;
                    }
                    if (k2 != 1) continue;
                    p_76484_1_.setBlock(i2, p_76484_4_, j2, (Block)Blocks.chest, 0, 2);
                    TileEntityChest tileentitychest = (TileEntityChest)p_76484_1_.getTileEntity(i2, p_76484_4_, j2);
                    if (tileentitychest == null) continue block6;
                    WeightedRandomChestContent.generateChestContents((Random)p_76484_2_, (WeightedRandomChestContent[])ChestGenHooks.getItems((String)"pyramidDesertyChest", (Random)p_76484_2_), (IInventory)tileentitychest, (int)ChestGenHooks.getCount((String)"pyramidDesertyChest", (Random)p_76484_2_));
                    continue block6;
                }
            }
            p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_76484_1_.getTileEntity(p_76484_3_, p_76484_4_, p_76484_5_);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a().setEntityName("Enderman");
            } else {
                System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + ", " + p_76484_5_ + ")");
            }
            p_76484_1_.setBlock(p_76484_3_, p_76484_4_ + 1, p_76484_5_, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner1 = (TileEntityMobSpawner)p_76484_1_.getTileEntity(p_76484_3_, p_76484_4_ + 1, p_76484_5_);
            if (tileentitymobspawner1 != null) {
                tileentitymobspawner1.func_145881_a().setEntityName("Enderman");
            } else {
                System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + 1 + ", " + p_76484_5_ + ")");
            }
            p_76484_1_.setBlock(p_76484_3_, p_76484_4_ + 2, p_76484_5_, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner11 = (TileEntityMobSpawner)p_76484_1_.getTileEntity(p_76484_3_, p_76484_4_ + 2, p_76484_5_);
            if (tileentitymobspawner11 != null) {
                tileentitymobspawner11.func_145881_a().setEntityName("Enderman");
            } else {
                System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + 2 + ", " + p_76484_5_ + ")");
            }
            return true;
        }
        return false;
    }
}

