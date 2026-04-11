/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.stats.StatBase
 *  net.minecraft.stats.StatList
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProviderEnd
 *  net.minecraft.world.WorldProviderHell
 */
package net.minecraft.theTitans.items;

import java.util.List;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.theTitans.world.WorldProviderNowhere;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;

public class ItemTeleporter2
extends Item {
    public ItemTeleporter2(String unlocalizedName) {
        this.maxStackSize = 1;
        this.setTextureName("thetitans:teleporter2");
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
    }

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (!worldIn.isRemote) {
            if (playerIn.worldObj.provider instanceof WorldProviderEnd) {
                List list = playerIn.worldObj.getEntitiesWithinAABB(EntityDragon.class, playerIn.boundingBox.expand(256.0, 256.0, 256.0));
                if (list != null && playerIn.timeUntilPortal <= 0) {
                    if (!list.isEmpty()) {
                        playerIn.addChatMessage((IChatComponent)new ChatComponentText("(The Ender Dragon is blocking the use of the Item)"));
                        playerIn.timeUntilPortal = 20;
                    } else if (playerIn.posX > 5.0 && playerIn.posX < -5.0 && playerIn.posZ > 5.0 && playerIn.posZ < -5.0) {
                        playerIn.addChatMessage((IChatComponent)new ChatComponentText("(The item resinates, but nothing happens)"));
                        playerIn.timeUntilPortal = 20;
                    } else if (list.isEmpty() && playerIn.posX < 5.0 && playerIn.posX > -5.0 && playerIn.posZ < 5.0 && playerIn.posZ > -5.0) {
                        playerIn.addChatMessage((IChatComponent)new ChatComponentText("(A rush of energy surges through you as you are sent to another realm.)"));
                        playerIn.motionY = 3.0;
                        playerIn.travelToDimension(201);
                        playerIn.timeUntilPortal = 300;
                        playerIn.triggerAchievement((StatBase)TitansAchievments.nowhereTime);
                        return itemStackIn;
                    }
                }
            } else if (playerIn.worldObj.provider instanceof WorldProviderHell) {
                playerIn.addChatMessage((IChatComponent)new ChatComponentText("(All you hear is the sounds of the Nether.)"));
            } else if (playerIn.worldObj.provider instanceof WorldProviderVoid) {
                playerIn.addChatMessage((IChatComponent)new ChatComponentText("(Some great all-powerful force stops you from leaving.)"));
            } else if (playerIn.worldObj.provider instanceof WorldProviderNowhere) {
                playerIn.addChatMessage((IChatComponent)new ChatComponentText("(The item fails to function.)"));
            } else if (!(playerIn.worldObj.provider instanceof WorldProviderVoid || playerIn.worldObj.provider instanceof WorldProviderHell || playerIn.worldObj.provider instanceof WorldProviderEnd)) {
                playerIn.addChatMessage((IChatComponent)new ChatComponentText("(The item appears to resinate with quantum energy.)"));
            }
        }
        itemStackIn.hasTagCompound();
        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem((Item)this)]);
        return itemStackIn;
    }
}

