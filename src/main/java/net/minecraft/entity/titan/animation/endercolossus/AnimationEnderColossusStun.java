/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.endercolossus;

import net.minecraft.entity.titan.EntityEnderColossus;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationEnderColossusStun
extends AIAnimation {
    private EntityEnderColossus entity;

    public AnimationEnderColossusStun(EntityEnderColossus test) {
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
        return 400;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 400 ? false : super.continueExecuting();
    }
}

