/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.IBlockAccess
 */
package net.minecraft.theTitans.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.IBlockAccess;

public class BlockCompactBedrock
extends Block {
    public BlockCompactBedrock(Material materialIn, String name) {
        super(materialIn);
        this.setHarvestLevel("pickaxe", 10000);
        this.setHardness(-1.0f);
        this.setResistance(1.8E8f);
        this.setCreativeTab(TheTitans.titansTab);
        this.setBlockName(name);
        this.setBlockTextureName("thetitans:" + name);
        this.setStepSound(soundTypeStone);
    }

    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return false;
    }
}

