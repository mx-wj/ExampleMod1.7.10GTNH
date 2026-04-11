/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemPleasantBladeFlower
extends ItemFood {
    public ItemPleasantBladeFlower(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_) {
        super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
    }

    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return EnumRarity.rare;
    }

    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
        if (!p_77654_2_.isRemote) {
            p_77654_3_.removePotionEffect(Potion.blindness.id);
            p_77654_3_.removePotionEffect(Potion.confusion.id);
            p_77654_3_.removePotionEffect(Potion.moveSlowdown.id);
            p_77654_3_.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1000, 1));
            p_77654_3_.heal(2.0f);
        }
        return super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
    }

    public int getMaxItemUseDuration(ItemStack p_77626_1_) {
        return 16;
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.eat;
    }
}

