/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.pigzombietitan;

import net.minecraft.entity.titan.EntityPigZombieTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationPigZombieTitanCreation
extends AIAnimation {
    private EntityPigZombieTitan entity;

    public AnimationPigZombieTitanCreation(EntityPigZombieTitan entityPigZombieTitan) {
        super(entityPigZombieTitan);
        this.entity = entityPigZombieTitan;
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
        return 360;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 360 ? false : super.continueExecuting();
    }
}

