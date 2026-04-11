/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.spidertitan;

import net.minecraft.entity.titan.EntitySpiderTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationSpiderTitanCreation
extends AIAnimation {
    private EntitySpiderTitan entity;

    public AnimationSpiderTitanCreation(EntitySpiderTitan test) {
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

