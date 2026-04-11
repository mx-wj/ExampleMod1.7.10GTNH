/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.zombietitan;

import net.minecraft.entity.titan.EntityZombieTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationZombieTitanStun
extends AIAnimation {
    private EntityZombieTitan entity;

    public AnimationZombieTitanStun(EntityZombieTitan test) {
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
        return 180;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 180 ? false : super.continueExecuting();
    }
}

