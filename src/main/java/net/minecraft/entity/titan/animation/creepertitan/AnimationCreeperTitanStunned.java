/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.creepertitan;

import net.minecraft.entity.titan.EntityCreeperTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationCreeperTitanStunned
extends AIAnimation {
    private EntityCreeperTitan entity;

    public AnimationCreeperTitanStunned(EntityCreeperTitan test) {
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
        return 520;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 500 ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.animTick == 520) {
            this.entity.animID = 0;
            this.entity.animTick = 0;
        }
        if (this.entity.animTick == 460) {
            this.entity.isStunned = false;
        } else {
            this.entity.setAttackTarget(null);
        }
    }
}

