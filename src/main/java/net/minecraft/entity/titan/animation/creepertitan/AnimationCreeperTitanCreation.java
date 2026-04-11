/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.creepertitan;

import net.minecraft.entity.titan.EntityCreeperTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationCreeperTitanCreation
extends AIAnimation {
    private EntityCreeperTitan entity;

    public AnimationCreeperTitanCreation(EntityCreeperTitan test) {
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
        return 480;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 480 ? false : super.continueExecuting();
    }
}

