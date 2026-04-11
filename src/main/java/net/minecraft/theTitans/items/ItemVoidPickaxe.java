/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.item.ItemStack
 */
package net.minecraft.theTitans.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;

public class ItemVoidPickaxe
extends ItemPickaxe {
    public ItemVoidPickaxe(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.setTextureName("thetitans:void_pickaxe");
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target != null && (target.height >= 7.0f || target instanceof EntitySilverfishTitan || target instanceof EntityCaveSpiderTitan)) {
            target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker), 1000.0f);
            target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
        }
        return true;
    }
}

