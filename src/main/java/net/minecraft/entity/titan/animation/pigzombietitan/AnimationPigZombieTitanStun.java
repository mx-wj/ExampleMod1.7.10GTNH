/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.pigzombietitan;

import net.minecraft.entity.titan.EntityPigZombieTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationPigZombieTitanStun
extends AIAnimation {
    private EntityPigZombieTitan entity;

    public AnimationPigZombieTitanStun(EntityPigZombieTitan test) {
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
        return 540;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 540 ? false : super.continueExecuting();
    }
}

