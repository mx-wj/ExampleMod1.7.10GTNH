/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemSpade
 *  net.minecraft.item.ItemStack
 */
package net.minecraft.theTitans.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;

public class ItemHarcadiumSpade
extends ItemSpade {
    public ItemHarcadiumSpade(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.setTextureName("thetitans:harcadium_spade");
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target != null && (target.height >= 6.0f || target instanceof EntityTitan || !target.onGround)) {
            target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker), 350.0f);
            target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
        }
        return true;
    }
}

