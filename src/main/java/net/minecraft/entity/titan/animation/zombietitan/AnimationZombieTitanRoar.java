/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 */
package net.minecraft.entity.titan.animation.zombietitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationZombieTitanRoar
extends AIAnimation {
    private EntityZombieTitan entity;

    public AnimationZombieTitanRoar(EntityZombieTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 11;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 200;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        Entity entity1;
        int i1;
        List list11;
        if (this.entity.getAnimTick() < 20 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() >= 20 && (list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(64.0, 64.0, 64.0))) != null && !list11.isEmpty()) {
            for (i1 = 0; i1 < list11.size(); ++i1) {
                entity1 = (Entity)list11.get(i1);
                if (this.entity.canAttackClass(entity1.getClass())) {
                    entity1.hurtResistantTime = 0;
                }
                if (this.entity.worldObj.isRemote || !(entity1 instanceof EntityLivingBase) || this.entity.canAttackClass(entity1.getClass())) continue;
                ((EntityLivingBase)entity1).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20, 4));
            }
        }
        if (this.entity.getAnimTick() == 20) {
            this.entity.playSound("thetitans:titanZombieRoar", 1000.0f, 1.0f);
            this.entity.collideWithEntities(this.entity.head, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.head.boundingBox.expand(64.0, 64.0, 64.0)));
            list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(64.0, 64.0, 64.0));
            if (list11 != null && !list11.isEmpty()) {
                for (i1 = 0; i1 < list11.size(); ++i1) {
                    entity1 = (Entity)list11.get(i1);
                    if (!(entity1 instanceof EntityLivingBase) || !this.entity.canAttackClass(entity1.getClass())) continue;
                    entity1.attackEntityFrom(DamageSource.causeThornsDamage((Entity)this.entity), 40.0f);
                }
            }
        }
    }
}

