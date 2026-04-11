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

public class AnimationEnderColossusAttack1
extends AIAnimation {
    private EntityEnderColossus entity;

    public AnimationEnderColossusAttack1(EntityEnderColossus test) {
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
        return 60;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAnimTick() > 60) {
            this.entity.setAttackTarget(null);
        }
        if (this.entity.getAnimTick() < 30 && this.entity.getAttackTarget() != null) {
            this.entity.faceEntity((Entity)this.entity.getAttackTarget(), 180.0f, 180.0f);
        }
        if (this.entity.getAnimTick() == 26) {
            this.entity.playSound("thetitans:titanSwing", 10.0f, 1.0f);
        }
        if (this.entity.getAnimTick() == 28 && this.entity.getAttackTarget() != null) {
            this.entity.playSound("thetitans:titanSwing", 10.0f, 1.0f);
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.entity.getKnockbackAmount();
            this.entity.collideWithEntities(this.entity.head, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.head.boundingBox.expand(4.0, 2.0, 4.0)));
            this.entity.attackChoosenEntity((Entity)this.entity.getAttackTarget(), f, i);
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity.getAttackTarget(), this.entity.getAttackTarget().boundingBox.expand(6.0, 2.0, 6.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    this.entity.attackChoosenEntity(entity1, f, i);
                }
            }
        }
    }
}

