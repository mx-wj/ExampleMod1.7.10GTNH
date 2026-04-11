/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 */
package net.minecraft.entity.titan.animation.endercolossus;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityEnderColossus;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationEnderColossusAttack2
extends AIAnimation {
    private EntityEnderColossus entity;

    public AnimationEnderColossusAttack2(EntityEnderColossus test) {
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
        return 150;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAnimTick() > 150) {
            this.entity.setAttackTarget(null);
        }
        if (this.entity.getAnimTick() < 60 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 60 || this.entity.getAnimTick() == 104) {
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = 0;
            this.entity.collideWithEntities(this.entity.body, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.body.boundingBox.expand(36.0, 8.0, 32.0)));
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(32.0, 8.0, 32.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    entity1.motionY += (double)(2.0f + this.entity.getRNG().nextFloat() + this.entity.getRNG().nextFloat());
                    this.entity.attackChoosenEntity(entity1, f, i);
                }
            }
            this.entity.playSound("thetitans:titanSlam", 20.0f, 1.0f);
            this.entity.playSound("thetitans:titanEnderColossusScream", 100.0f, (this.entity.getRNG().nextFloat() - this.entity.getRNG().nextFloat()) * 0.2f + 1.0f);
        }
    }
}

