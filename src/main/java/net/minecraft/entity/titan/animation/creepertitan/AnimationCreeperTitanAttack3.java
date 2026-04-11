/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.MathHelper
 */
package net.minecraft.entity.titan.animation.creepertitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationCreeperTitanAttack3
extends AIAnimation {
    private EntityCreeperTitan entity;

    public AnimationCreeperTitanAttack3(EntityCreeperTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 4;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 70;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAnimTick() < 32 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 32) {
            if (this.entity.getAttackTarget() != null) {
                this.entity.doLightningAttackToEntity((Entity)this.entity.getAttackTarget());
            }
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.entity.getKnockbackAmount();
            this.entity.shakeNearbyPlayerCameras(20000.0);
            this.entity.playSound("thetitans:titanStrike", 20.0f, 1.0f);
            float d0 = 16.0f;
            float f3 = this.entity.renderYawOffset * (float)Math.PI / 180.0f;
            float f11 = MathHelper.sin((float)f3);
            float f4 = MathHelper.cos((float)f3);
            this.entity.collideWithEntities(this.entity.head, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.head.boundingBox.expand(48.0, 12.0, 48.0).offset(-((double)(f11 * d0)), -8.0, (double)(f4 * d0))));
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(32.0, 8.0, 32.0).offset(-((double)(f11 * d0)), -4.0, (double)(f4 * d0)));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    this.entity.attackChoosenEntity(entity1, f * 2.0f, i);
                }
            }
        }
    }
}

