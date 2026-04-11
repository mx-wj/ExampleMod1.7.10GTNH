/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIAttackOnCollide
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;

public class ItemForTheChallengeGames1
extends Item {
    public ItemForTheChallengeGames1(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
        this.setTextureName("thetitans:witherskeletonspawn");
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        playerIn.playSound("thetitans:OMG", 10.0f, 0.25f + playerIn.getRNG().nextFloat() * 2.0f);
        for (int i = 0; i <= 9; ++i) {
            Random rand = new Random();
            EntitySkeleton entity = new EntitySkeleton(worldIn);
            Block block = worldIn.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
            double d0 = 1.0;
            if (p_77648_7_ == 1 && block.getRenderType() == 11) {
                d0 = 1.5;
            }
            entity.motionX = entity.getRNG().nextDouble() * 2.0 - 1.0;
            entity.motionZ = entity.getRNG().nextDouble() * 2.0 - 1.0;
            entity.onSpawnWithEgg((IEntityLivingData)null);
            entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
            entity.setLocationAndAngles((double)p_77648_4_ + 0.5, (double)p_77648_5_ + d0, (double)p_77648_6_ + 0.5, 0.0f, 0.0f);
            entity.setSkeletonType(1);
            entity.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
            entity.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)entity, 1.2, true));
            entity.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)entity, EntityIronGolem.class, 0, true));
            if (worldIn.isRemote) continue;
            worldIn.spawnEntityInWorld((Entity)entity);
        }
        if (!playerIn.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        return true;
    }

    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
    }
}

