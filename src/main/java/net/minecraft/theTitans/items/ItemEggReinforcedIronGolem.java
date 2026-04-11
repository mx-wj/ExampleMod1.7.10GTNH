/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;

public class ItemEggReinforcedIronGolem
extends Item {
    public ItemEggReinforcedIronGolem(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
        this.setTextureName("thetitans:eggultimairongolemtitan");
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        Block block = worldIn.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
        double d0 = 1.0;
        if (p_77648_7_ == 1 && block.getRenderType() == 11) {
            d0 = 1.5;
        }
        if (playerIn.isSneaking()) {
            for (int i = 0; i <= 49; ++i) {
                EntityIronGolem entity = new EntityIronGolem(worldIn);
                entity.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2000.0);
                entity.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
                entity.setHealth(2000.0f);
                entity.motionX = entity.getRNG().nextDouble() * 2.0 - 1.0;
                entity.motionZ = entity.getRNG().nextDouble() * 2.0 - 1.0;
                entity.setCustomNameTag("Reinforced Iron Golem");
                entity.onSpawnWithEgg((IEntityLivingData)null);
                entity.setLocationAndAngles((double)p_77648_4_ + 0.5, (double)p_77648_5_ + d0, (double)p_77648_6_ + 0.5, 0.0f, 0.0f);
                EntityIronGolemTitan.addTitanTargetingTaskToEntity((EntityCreature)entity);
                if (!worldIn.isRemote) {
                    worldIn.spawnEntityInWorld((Entity)entity);
                }
                if (entity == null || !(entity instanceof EntityLivingBase) || !stack.hasDisplayName()) continue;
                entity.setCustomNameTag(stack.getDisplayName());
            }
        } else {
            EntityIronGolem entity = new EntityIronGolem(worldIn);
            entity.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2000.0);
            entity.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            entity.setHealth(2000.0f);
            entity.setCustomNameTag("Reinforced Iron Golem");
            entity.onSpawnWithEgg((IEntityLivingData)null);
            entity.setLocationAndAngles((double)p_77648_4_ + 0.5, (double)p_77648_5_ + d0, (double)p_77648_6_ + 0.5, 0.0f, 0.0f);
            EntityIronGolemTitan.addTitanTargetingTaskToEntity((EntityCreature)entity);
            if (!worldIn.isRemote) {
                worldIn.spawnEntityInWorld((Entity)entity);
            }
            if (entity != null && entity instanceof EntityLivingBase && stack.hasDisplayName()) {
                entity.setCustomNameTag(stack.getDisplayName());
            }
        }
        if (!playerIn.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        return true;
    }
}

