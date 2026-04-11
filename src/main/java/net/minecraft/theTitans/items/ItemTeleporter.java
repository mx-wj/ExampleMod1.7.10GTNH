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

public class ItemTeleporter
extends Item {
    public ItemTeleporter(String unlocalizedName) {
        this.maxStackSize = 1;
        this.setTextureName("thetitans:teleporter");
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
    }

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (!worldIn.isRemote) {
            if (playerIn.worldObj.provider instanceof WorldProviderEnd) {
                List list = playerIn.worldObj.getEntitiesWithinAABB(EntityDragon.class, playerIn.boundingBox.expand(256.0, 256.0, 256.0));
                if (list != null && playerIn.timeUntilPortal <= 0) {
                    if (!list.isEmpty()) {
                        playerIn.addChatMessage((IChatComponent)new ChatComponentText("I can't do that when the Ender Dragon's still here! Kill it first."));
                        playerIn.timeUntilPortal = 20;
                    } else if (playerIn.posX > 5.0 && playerIn.posX < -5.0 && playerIn.posZ > 5.0 && playerIn.posZ < -5.0) {
                        playerIn.addChatMessage((IChatComponent)new ChatComponentText("I can't do that this far away from the center of the island. Get closer."));
                        playerIn.timeUntilPortal = 20;
                    } else if (list.isEmpty() && playerIn.posX < 5.0 && playerIn.posX > -5.0 && playerIn.posZ < 5.0 && playerIn.posZ > -5.0) {
                        playerIn.addChatMessage((IChatComponent)new ChatComponentText("Master! More food is coming for you!"));
                        playerIn.motionY = 3.0;
                        playerIn.travelToDimension(200);
                        playerIn.timeUntilPortal = 300;
                        playerIn.triggerAchievement((StatBase)TitansAchievments.voidTime);
                        return itemStackIn;
                    }
                }
            } else if (playerIn.worldObj.provider instanceof WorldProviderHell) {
                playerIn.addChatMessage((IChatComponent)new ChatComponentText("(You hear the distant crys of a long, forgotten voice. It's very ancient.)"));
            } else if (playerIn.worldObj.provider instanceof WorldProviderVoid) {
                playerIn.addChatMessage((IChatComponent)new ChatComponentText("Stop talking to me and feed my Master!"));
            } else if (playerIn.worldObj.provider instanceof WorldProviderNowhere) {
                playerIn.addChatMessage((IChatComponent)new ChatComponentText("Why have you brought me here? Get me out!"));
            } else if (!(playerIn.worldObj.provider instanceof WorldProviderVoid || playerIn.worldObj.provider instanceof WorldProviderHell || playerIn.worldObj.provider instanceof WorldProviderEnd)) {
                playerIn.addChatMessage((IChatComponent)new ChatComponentText("(The ancient crys still abode. It's as if they are saying 'All things must End')"));
            }
        }
        itemStackIn.hasTagCompound();
        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem((Item)this)]);
        return itemStackIn;
    }
}

