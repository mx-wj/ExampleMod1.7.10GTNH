/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 */
package net.minecraft.theTitans.items;

import net.minecraft.item.Item;
import net.minecraft.theTitans.TheTitans;

public class ItemDiamondString
extends Item {
    public ItemDiamondString(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
        this.setTextureName("thetitans:diamond_string");
    }
}

