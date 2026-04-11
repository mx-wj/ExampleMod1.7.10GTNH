/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockOre
 */
package net.minecraft.theTitans.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.theTitans.TheTitans;

public class BlockCustomOre
extends BlockOre {
    public BlockCustomOre(int harvestLevel, String name, float hardness, float resistance) {
        this.setHarvestLevel("pickaxe", harvestLevel);
        this.setCreativeTab(TheTitans.titansTab);
        this.setBlockName(name);
        this.setBlockTextureName("thetitans:" + name);
        this.setStepSound(soundTypePiston);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }
}

