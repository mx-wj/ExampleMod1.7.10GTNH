/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.spidertitan;

import net.minecraft.entity.titan.EntitySpiderTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationSpiderTitanDeath
extends AIAnimation {
    private EntitySpiderTitan entity;

    public AnimationSpiderTitanDeath(EntitySpiderTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 10;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 2000;
    }

    @Override
    public boolean shouldExecute() {
        return this.entity.deathTicks <= 0 || this.entity.isEntityAlive() ? false : super.shouldExecute();
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.deathTicks <= 0 || this.entity.isEntityAlive() ? false : super.continueExecuting();
    }
}

