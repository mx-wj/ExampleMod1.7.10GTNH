/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.zombietitan;

import net.minecraft.entity.titan.EntityZombieTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationZombieTitanCreation
extends AIAnimation {
    private EntityZombieTitan entity;

    public AnimationZombieTitanCreation(EntityZombieTitan test) {
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
        return 600;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 600 ? false : super.continueExecuting();
    }
}

