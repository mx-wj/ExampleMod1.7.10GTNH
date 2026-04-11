/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package net.minecraft.entity.titan.animation.skeletontitan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationSkeletonTitanLightningHand
extends AIAnimation {
    private EntitySkeletonTitan entity;

    public AnimationSkeletonTitanLightningHand(EntitySkeletonTitan test) {
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
        return 70;
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

