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
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class ItemEggZombiePigmanTitan
extends Item {
    public ItemEggZombiePigmanTitan(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
        this.setTextureName("thetitans:eggzombiepigmantitan");
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        EntityPigZombieTitan entity = new EntityPigZombieTitan(worldIn);
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
        entity.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
        if (!worldIn.isRemote) {
            worldIn.spawnEntityInWorld((Entity)entity);
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

