/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityChaff;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;

public class ItemChaff
extends Item {
    public ItemChaff(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.maxStackSize = 20;
        this.setCreativeTab(TheTitans.titansTab);
        this.setTextureName("thetitans:chaff");
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!playerIn.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        EntityChaff entity1 = new EntityChaff(worldIn);
        EntityChaff entity2 = new EntityChaff(worldIn);
        if (!worldIn.isRemote) {
            entity1.setLocationAndAngles(playerIn.posX + 6.0, playerIn.posY + 3.0, playerIn.posZ + 6.0, 0.0f, 0.0f);
            entity2.setLocationAndAngles(playerIn.posX - 6.0, playerIn.posY + 3.0, playerIn.posZ - 6.0, 0.0f, 0.0f);
            worldIn.spawnEntityInWorld((Entity)entity1);
            worldIn.spawnEntityInWorld((Entity)entity2);
        }
        return true;
    }
}

