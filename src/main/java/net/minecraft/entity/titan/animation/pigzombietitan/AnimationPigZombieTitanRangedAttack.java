/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package net.minecraft.entity.titan.animation.pigzombietitan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationPigZombieTitanRangedAttack
extends AIAnimation {
    private EntityPigZombieTitan entity;

    public AnimationPigZombieTitanRangedAttack(EntityPigZombieTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 12;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 110;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
    }
}

