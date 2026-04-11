/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockOre
 *  net.minecraft.block.material.Material
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.IBlockAccess
 */
package net.minecraft.theTitans.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockNetherStoneOre
extends BlockOre {
    private Random rand = new Random();

    public BlockNetherStoneOre(Material materialIn) {
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(1.5f);
        this.setResistance(10.0f);
        this.setCreativeTab(TheTitans.titansTab);
        this.setBlockName("nether_stone_ore");
        this.setBlockTextureName("thetitans:nether_stone_ore");
        this.setStepSound(soundTypePiston);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock((Block)Blocks.cobblestone);
    }

    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
        return MathHelper.getRandomIntegerInRange((Random)this.rand, (int)0, (int)1);
    }
}

