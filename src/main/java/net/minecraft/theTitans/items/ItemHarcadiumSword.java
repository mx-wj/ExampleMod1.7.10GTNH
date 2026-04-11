/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.eventhandler.Event
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.player.ArrowLooseEvent
 */
package net.minecraft.theTitans.items;

import cpw.mods.fml.common.eventhandler.Event;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemHarcadiumSword
extends ItemSword {
    public ItemHarcadiumSword(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.setTextureName("thetitans:harcadium_sword");
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.bow;
    }

    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof EntityPlayer) {
            ((EntityPlayer)entityIn).triggerAchievement((StatBase)TitansAchievments.harcadiumSword);
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_) {
        int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;
        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return;
        }
        j = event.charge;
        float f = (float)j / 60.0f;
        if ((double)(f = (f * f + f * 2.0f) / 3.0f) < 0.1) {
            return;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        p_77615_3_.playSound("thetitans:titanSwing", 1.0f, 2.0f);
        p_77615_3_.swingItem();
        Vec3 vec3 = p_77615_3_.getLook(1.0f);
        double dx = vec3.xCoord * 4.0;
        double dy = (double)p_77615_3_.getEyeHeight() + vec3.yCoord * 4.0;
        double dz = vec3.zCoord * 4.0;
        List list1 = p_77615_3_.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)p_77615_3_, p_77615_3_.boundingBox.expand(4.0, 4.0, 4.0).offset(dx, dy, dz));
        if (list1 != null && !list1.isEmpty()) {
            for (int i11 = 0; i11 < list1.size(); ++i11) {
                Entity target = (Entity)list1.get(i11);
                if (target == p_77615_3_ || !(target instanceof EntityLivingBase) && !(target instanceof EntityTitanPart)) continue;
                target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)p_77615_3_), 1000.0f * f);
                target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                target.playSound("thetitans:slashFlesh", 2.0f, 1.25f);
            }
        }
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target != null) {
            target.playSound("thetitans:slashFlesh", 2.0f, 1.3f + target.getRNG().nextFloat() * 0.5f);
            if (target.height >= 6.0f || target instanceof EntityTitan || !target.onGround) {
                target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker), 500.0f);
                target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
            }
        }
        return true;
    }
}

