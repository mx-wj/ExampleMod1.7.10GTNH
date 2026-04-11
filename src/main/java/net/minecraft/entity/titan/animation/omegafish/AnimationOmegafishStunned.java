/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.omegafish;

import net.minecraft.entity.titan.EntitySilverfishTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationOmegafishStunned
extends AIAnimation {
    private EntitySilverfishTitan entity;

    public AnimationOmegafishStunned(EntitySilverfishTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 8;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 500;
    }

    @Override
    public boolean continueExecuting() {
        return !this.entity.isStunned && this.entity.animTick > 500 ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.animTick == 500) {
            this.entity.animID = 0;
            this.entity.animTick = 0;
        }
        if (this.entity.animTick == 380) {
            this.entity.isStunned = false;
        } else {
            this.entity.setAttackTarget(null);
        }
    }
}

