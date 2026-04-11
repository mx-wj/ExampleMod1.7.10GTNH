/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.titan.animation.creepertitan;

import net.minecraft.entity.titan.EntityCreeperTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationCreeperTitanDeath
extends AIAnimation {
    private EntityCreeperTitan entity;

    public AnimationCreeperTitanDeath(EntityCreeperTitan test) {
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

