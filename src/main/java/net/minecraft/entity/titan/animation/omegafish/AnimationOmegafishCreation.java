/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.omegafish;

import net.minecraft.entity.titan.EntitySilverfishTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationOmegafishCreation
extends AIAnimation {
    private EntitySilverfishTitan entity;

    public AnimationOmegafishCreation(EntitySilverfishTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 13;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 260;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 260 ? false : super.continueExecuting();
    }
}

