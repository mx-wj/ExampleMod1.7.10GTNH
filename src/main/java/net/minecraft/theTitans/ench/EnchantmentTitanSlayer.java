/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnumEnchantmentType
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.item.ItemAxe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 */
package net.minecraft.theTitans.ench;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.util.ResourceLocation;

public class EnchantmentTitanSlayer
extends Enchantment {
    public EnchantmentTitanSlayer(int enchID, ResourceLocation enchName, int enchWeight) {
        super(enchID, enchWeight, EnumEnchantmentType.weapon);
    }

    public int getMinEnchantability(int enchantmentLevel) {
        return 1 + (enchantmentLevel - 1) * 3;
    }

    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 30;
    }

    public int getMaxLevel() {
        return 10;
    }

    public String getName() {
        return "enchantment.damage.titanSlayer";
    }

    public boolean canApply(ItemStack stack) {
        return stack.getItem() instanceof ItemAxe ? true : super.canApply(stack);
    }

    public float func_152376_a(int level, EnumCreatureAttribute creatureType) {
        return 25.0f;
    }

    public void func_151368_a(EntityLivingBase user, Entity target, int level) {
        float f = (float)user.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        if (target instanceof EntityLivingBase) {
            EntityLivingBase entitylivingbase1 = (EntityLivingBase)target;
            if (target.height >= 6.0f || target instanceof EntityTitan || !target.onGround) {
                entitylivingbase1.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)user), f + (float)level * 100.0f);
                entitylivingbase1.playSound("thetitans:titanpunch", 2.0f, 1.0f);
            }
        }
    }
}

