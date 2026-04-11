/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.EnumPlantType
 *  net.minecraftforge.common.IPlantable
 *  net.minecraftforge.common.util.ForgeDirection
 */
package net.minecraft.theTitans.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemMalgrumSeeds
extends Item
implements IPlantable {
    public ItemMalgrumSeeds() {
        this.setUnlocalizedName("malgrum_seeds");
        this.setTextureName("thetitans:malgrum_seeds");
        this.setCreativeTab(TheTitans.titansTab);
    }

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (p_77648_7_ != 1) {
            return false;
        }
        if (p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) {
            if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).canSustainPlant((IBlockAccess)p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, ForgeDirection.UP, (IPlantable)this) && p_77648_3_.isAirBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_)) {
                p_77648_3_.playSound((double)p_77648_4_, (double)p_77648_5_, (double)p_77648_6_, "thetitans:titanPress", 0.5f, 1.0f, false);
                p_77648_3_.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, TitanBlocks.malgrumCrop, 0, 3);
                --p_77648_1_.stackSize;
                return true;
            }
            return false;
        }
        return false;
    }

    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    public Block getPlant(IBlockAccess world, int x, int y, int z) {
        return TitanBlocks.malgrumCrop;
    }

    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
        return 0;
    }
}

