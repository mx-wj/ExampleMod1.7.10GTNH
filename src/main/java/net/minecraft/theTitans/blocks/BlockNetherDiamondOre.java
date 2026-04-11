/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockOre
 *  net.minecraft.block.material.Material
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.IBlockAccess
 */
package net.minecraft.theTitans.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockNetherDiamondOre
extends BlockOre {
    private Random rand = new Random();

    public BlockNetherDiamondOre(Material materialIn) {
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setCreativeTab(TheTitans.titansTab);
        this.setBlockName("nether_diamond_ore");
        this.setBlockTextureName("thetitans:nether_diamond_ore");
        this.setStepSound(soundTypePiston);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Items.diamond;
    }

    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
        return MathHelper.getRandomIntegerInRange((Random)this.rand, (int)3, (int)7);
    }

    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_) {
        if (p_149679_1_ > 0 && Item.getItemFromBlock((Block)this) != this.getItemDropped(0, p_149679_2_, p_149679_1_)) {
            int j = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;
            if (j < 0) {
                j = 0;
            }
            return this.quantityDropped(p_149679_2_) * (j + 1);
        }
        return this.quantityDropped(p_149679_2_);
    }
}

