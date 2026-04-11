/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFoodMalgrum
extends ItemFood {
    public ItemFoodMalgrum(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_) {
        super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(ItemStack p_77636_1_) {
        return true;
    }

    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return EnumRarity.epic;
    }

    protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
        if (!p_77849_2_.isRemote) {
            EntityXPOrb orb = new EntityXPOrb(p_77849_2_, p_77849_3_.posX, p_77849_3_.posY + 0.5, p_77849_3_.posZ, 5 + p_77849_3_.getRNG().nextInt(10) + (int)p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue());
            p_77849_2_.spawnEntityInWorld((Entity)orb);
            p_77849_3_.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 6000, p_77849_3_.isPotionActive(Potion.field_76444_x) && p_77849_3_.getActivePotionEffect(Potion.field_76444_x).getAmplifier() > 9 ? p_77849_3_.getActivePotionEffect(Potion.field_76444_x).getAmplifier() + 9 : 9));
            p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + 40.0);
            p_77849_3_.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2400, 9));
            p_77849_3_.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 18000, 0));
            if (p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() > 100.0) {
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.resistance.id, 18000, 1));
            }
            if (p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() > 200.0) {
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.nightVision.id, 18000, 0));
            }
            if (p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() > 300.0) {
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 18000, 3));
            }
            if (p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() > 400.0) {
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.jump.id, 18000, 1));
            }
            if (p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() > 600.0) {
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 18000, 1));
            }
            if (p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() > 800.0) {
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 18000, 1));
            }
            if (p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() > 1000.0) {
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 18000, 1));
            }
            if (p_77849_3_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() > 1500.0) {
                p_77849_3_.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(p_77849_3_.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue() + 1.0);
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.resistance.id, 18000, 3));
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.regeneration.id, 18000, 99));
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 18000, 99));
            }
        }
    }
}

