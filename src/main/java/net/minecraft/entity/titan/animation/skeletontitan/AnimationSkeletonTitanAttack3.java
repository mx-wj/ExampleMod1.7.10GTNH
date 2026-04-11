/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.MathHelper
 */
package net.minecraft.entity.titan.animation.skeletontitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationSkeletonTitanAttack3
extends AIAnimation {
    private EntitySkeletonTitan entity;

    public AnimationSkeletonTitanAttack3(EntitySkeletonTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 7;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 260;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned || this.entity.worldObj.getBlock((int)this.entity.posX, (int)this.entity.posY - 1, (int)this.entity.posZ).getExplosionResistance((Entity)this.entity) > 500.0f ? false : super.continueExecuting();
    }

    public void updateTask() {
        this.entity.renderYawOffset = this.entity.rotationYaw = this.entity.rotationYawHead;
        if (this.entity.getAnimTick() < 10 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 180.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 160 && this.entity.getSkeletonType() == 1) {
            this.entity.playSound("thetitans:swordDrag", 10.0f, 1.0f);
        }
        if (this.entity.getAnimTick() == 90) {
            this.entity.shakeNearbyPlayerCameras(20000.0);
            this.entity.playSound("thetitans:titanSlam", 100.0f, 1.0f);
            this.entity.playSound("thetitans:titanPress", 100.0f, 1.0f);
            float d0 = this.entity.getSkeletonType() == 1 ? 64.0f : 32.0f;
            float f3 = this.entity.renderYawOffset * (float)Math.PI / 180.0f;
            float f11 = MathHelper.sin((float)f3);
            float f4 = MathHelper.cos((float)f3);
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.entity.getKnockbackAmount();
            this.entity.collideWithEntities(this.entity.pelvis, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.pelvis.boundingBox.expand(16.0, 8.0, 16.0)));
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(32.0, 2.0, 32.0).offset(-((double)(f11 * d0)), -8.0, (double)(f4 * d0)));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    this.entity.attackChoosenEntity(entity1, f * 15.0f, i);
                }
            }
        }
    }
}

