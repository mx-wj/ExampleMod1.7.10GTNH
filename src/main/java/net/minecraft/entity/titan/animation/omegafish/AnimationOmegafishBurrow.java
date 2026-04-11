/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 */
package net.minecraft.entity.titan.animation.omegafish;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationOmegafishBurrow
extends AIAnimation {
    private EntitySilverfishTitan entity;

    public AnimationOmegafishBurrow(EntitySilverfishTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 1;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 100;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAnimTick() == 50) {
            this.entity.playSound("thetitans:groundSmash", 20.0f, 1.25f);
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(16.0, 16.0, 16.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    int i = this.entity.getKnockbackAmount() * 3;
                    this.entity.attackChoosenEntity(entity1, f, i);
                    this.entity.collideWithEntities(this.entity.body, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.body.boundingBox.expand(32.0, 16.0, 32.0)));
                }
            }
        }
        if (this.entity.getAnimTick() >= 100) {
            this.entity.animTick = 0;
            this.entity.animID = 0;
        }
    }
}

