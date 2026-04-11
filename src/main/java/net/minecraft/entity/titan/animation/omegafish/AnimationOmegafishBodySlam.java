/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.MathHelper
 */
package net.minecraft.entity.titan.animation.omegafish;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationOmegafishBodySlam
extends AIAnimation {
    private EntitySilverfishTitan entity;

    public AnimationOmegafishBodySlam(EntitySilverfishTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 9;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 410;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAnimTick() < 80 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 80) {
            double ver;
            this.entity.motionY = ver = 9.0;
            if (this.entity.getAttackTarget() != null) {
                double d01 = this.entity.getAttackTarget().posX - this.entity.posX;
                double d11 = this.entity.getAttackTarget().posZ - this.entity.posZ;
                float f21 = MathHelper.sqrt_double((double)(d01 * d01 + d11 * d11));
                double hor = f21 / 16.0f;
                this.entity.motionX = d01 / (double)f21 * hor * hor + this.entity.motionX * hor;
                this.entity.motionZ = d11 / (double)f21 * hor * hor + this.entity.motionZ * hor;
            }
        }
        if (this.entity.getAnimTick() == 240) {
            this.entity.playSound("thetitans:titanSlam", 20.0f, 1.0f);
            this.entity.playSound("thetitans:groundSmash", 20.0f, 1.5f);
            this.entity.playSound("thetitans:titanland", 10000.0f, 1.0f);
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(96.0, 32.0, 96.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    int i = this.entity.getKnockbackAmount();
                    this.entity.attackChoosenEntity(entity1, f * 10.0f, i);
                    this.entity.collideWithEntities(this.entity.body, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.body.boundingBox.expand(96.0, 16.0, 96.0)));
                    this.entity.collideWithEntities(this.entity.body, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.body.boundingBox.expand(96.0, 16.0, 96.0)));
                    entity1.motionY += 1.5;
                    if (this.entity.getRNG().nextInt(3) != 0) continue;
                    entity1.setFire(20);
                }
            }
        }
    }
}

