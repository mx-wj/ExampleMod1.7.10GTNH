/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockOre
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.Item
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.IBlockAccess
 */
package net.minecraft.theTitans.blocks;

import java.util.Random;
import net.minecraft.block.BlockOre;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockCustomNonSmeltingOre
extends BlockOre {
    private Item droppingItem;
    private int minXP;
    private int maxXP;
    private Random rand = new Random();

    public BlockCustomNonSmeltingOre(int harvestLevel, String name, float hardness, float resistance, Item item, int minxp, int maxxp) {
        this.droppingItem = item;
        this.minXP = minxp;
        this.maxXP = maxxp;
        this.setHarvestLevel("pickaxe", harvestLevel);
        this.setCreativeTab(TheTitans.titansTab);
        this.setBlockName(name);
        this.setBlockTextureName("thetitans:" + name);
        this.setStepSound(soundTypePiston);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return this.droppingItem;
    }

    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return this == TitanBlocks.adamantium_ore ? false : super.canEntityDestroy(world, x, y, z, entity);
    }

    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
        return MathHelper.getRandomIntegerInRange((Random)this.rand, (int)this.minXP, (int)this.maxXP);
    }
}

