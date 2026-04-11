/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.spidertitan;

import net.minecraft.entity.titan.EntitySpiderTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationSpiderTitanStunned
extends AIAnimation {
    private EntitySpiderTitan entity;

    public AnimationSpiderTitanStunned(EntitySpiderTitan test) {
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
        return 660;
    }

    @Override
    public boolean continueExecuting() {
        return !this.entity.isStunned && this.entity.animTick > 660 ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.animTick == 660) {
            this.entity.animID = 0;
            this.entity.animTick = 0;
        }
        if (this.entity.animTick == 420) {
            this.entity.isStunned = false;
        } else {
            this.entity.setAttackTarget(null);
        }
    }
}

