/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpawnEggTitans
extends Item {
    public int my_id = 0;

    public ItemSpawnEggTitans(String unlocalizedName, int j) {
        this.my_id = j;
        this.maxStackSize = 64;
        this.setTextureName("thetitans:" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        if (par3World.isRemote) {
            return true;
        }
        Entity ent = ItemSpawnEggTitans.spawn_something(this.my_id, par3World, (double)par4 + 0.5, (double)par5 + 1.01, (double)par6 + 0.5);
        if (ent != null && ent instanceof EntityLiving && par1ItemStack.hasDisplayName()) {
            ((EntityLiving)ent).setCustomNameTag(par1ItemStack.getDisplayName());
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    public static Entity spawn_something(int id, World world, double d0, double d1, double d2) {
        int entityID = 0;
        boolean skelly_type = false;
        String name = null;
        switch (id) {
            case 384: {
                name = "OverlordScorpion";
                break;
            }
            case 385: {
                name = "MethuselahKraken";
            }
        }
        Entity ent = null;
        if (entityID != 0 || name != null) {
            ent = ItemSpawnEggTitans.spawnCreature(world, entityID, name, d0, d1, d2);
        }
        return ent;
    }

    public static Entity spawnCreature(World par0World, int par1, String name, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = name == null ? EntityList.createEntityByID((int)par1, (World)par0World) : EntityList.createEntityByName((String)name, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving)var8).onSpawnWithEgg(null);
            ((EntityLiving)var8).playLivingSound();
        }
        return var8;
    }
}

