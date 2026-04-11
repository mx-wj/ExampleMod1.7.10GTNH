/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package net.minecraft.entity.titan.animation.endercolossus;

import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityEnderColossus;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationEnderColossusMeteorRain
extends AIAnimation {
    private EntityEnderColossus entity;

    public AnimationEnderColossusMeteorRain(EntityEnderColossus test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 2;
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
        if (this.entity.getAnimTick() == 100) {
            this.entity.animTick = 0;
            this.entity.animID = 0;
            this.entity.setAttackTarget(null);
        }
        if (this.entity.getAnimTick() < 24 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
    }
}

