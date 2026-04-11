/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package net.minecraft.entity.titan.animation.gargoyletitan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityGargoyleTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationGargoyleTitanLavaSpit
extends AIAnimation {
    private EntityGargoyleTitan entity;

    public AnimationGargoyleTitanLavaSpit(EntityGargoyleTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 6;
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
        return this.entity.animTick > 60 ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 40.0f, 40.0f);
        }
    }
}

