/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Facing
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class ItemEggSpiderJockeyTitan
extends Item {
    public ItemEggSpiderJockeyTitan(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
        this.setTextureName("thetitans:eggspiderjockeytitan");
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        EntitySpiderTitan entity = new EntitySpiderTitan(worldIn);
        Block block = worldIn.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
        p_77648_4_ += Facing.offsetsXForSide[p_77648_7_];
        p_77648_5_ += Facing.offsetsYForSide[p_77648_7_];
        p_77648_6_ += Facing.offsetsZForSide[p_77648_7_];
        double d0 = 0.0;
        if (p_77648_7_ == 1 && block.getRenderType() == 11) {
            d0 = 0.5;
        }
        entity.onSpawnWithEgg(null);
        entity.setLocationAndAngles((double)p_77648_4_ + 0.5, (double)p_77648_5_ + d0, (double)p_77648_6_ + 0.5, 0.0f, 0.0f);
        if (TheTitans.NightmareMode) {
            entity.setTitanHealth(10000.0f);
        } else {
            entity.setTitanHealth(5000.0f);
        }
        if (!worldIn.isRemote) {
            worldIn.spawnEntityInWorld((Entity)entity);
            EntitySkeletonTitan entityskeleton = new EntitySkeletonTitan(entity.worldObj);
            entityskeleton.setSkeletonType(0);
            entityskeleton.setCurrentItemOrArmor(0, new ItemStack((Item)Items.bow));
            entityskeleton.onSpawnWithEgg(null);
            entityskeleton.setLocationAndAngles((double)p_77648_4_ + 0.5, (double)p_77648_5_ + d0, (double)p_77648_6_ + 0.5, 0.0f, 0.0f);
            entity.worldObj.spawnEntityInWorld((Entity)entityskeleton);
            entityskeleton.mountEntity((Entity)entity);
            entityskeleton.playLivingSound();
        }
        if (entity != null) {
            entity.playLivingSound();
            if (!playerIn.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
        }
        return true;
    }

    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.uncommon;
    }
}

