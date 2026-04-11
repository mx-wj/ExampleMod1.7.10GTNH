/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;

public class ItemPleasantBladeBrew
extends Item {
    public ItemPleasantBladeBrew() {
        this.setUnlocalizedName("pleasant_blade_brew");
        this.setTextureName("thetitans:pleasant_blade_brew");
        this.setCreativeTab(TheTitans.titansTab);
    }

    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
        if (!p_77654_3_.capabilities.isCreativeMode) {
            --p_77654_1_.stackSize;
        }
        if (!p_77654_2_.isRemote) {
            p_77654_3_.removePotionEffect(Potion.poison.id);
            p_77654_3_.removePotionEffect(Potion.hunger.id);
            p_77654_3_.removePotionEffect(Potion.confusion.id);
            p_77654_3_.removePotionEffect(Potion.wither.id);
        }
        return p_77654_1_.stackSize <= 0 ? new ItemStack(Items.glass_bottle) : p_77654_1_;
    }

    public int getMaxItemUseDuration(ItemStack p_77626_1_) {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.drink;
    }

    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        return p_77659_1_;
    }
}

