/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemArmor$ArmorMaterial
 *  net.minecraft.item.ItemStack
 */
package net.minecraft.theTitans.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;

public class ItemCustomArmor
extends ItemArmor {
    private String armorName;

    public ItemCustomArmor(String unlocalizedName, ItemArmor.ArmorMaterial material, int type, String baseArmorName) {
        super(material, 0, type);
        this.armorName = baseArmorName;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName("thetitans:" + unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
    }

    public ItemCustomArmor(ItemArmor.ArmorMaterial material, int i, int type) {
        super(material, 0, type);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thetitans:textures/models/armor/" + this.armorName + (this.armorType == 2 ? "2" : "1") + ".png";
    }
}

