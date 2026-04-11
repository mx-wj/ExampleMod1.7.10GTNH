/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemPickaxe
 */
package net.minecraft.theTitans.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.theTitans.TheTitans;

public class ItemCustomPickaxe
extends ItemPickaxe {
    public ItemCustomPickaxe(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.setTextureName("thetitans:" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
    }
}

