/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.ai.EntityAIBase
 */
package net.minecraft.entity.titan.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.titan.EntityCreeperTitan;

public class EntityAICreeperTitanSwell
extends EntityAIBase {
    EntityCreeperTitan swellingCreeper;
    EntityLivingBase creeperAttackTarget;

    public EntityAICreeperTitanSwell(EntityCreeperTitan p_i1655_1_) {
        this.swellingCreeper = p_i1655_1_;
        this.setMutexBits(0);
    }

    public boolean shouldExecute() {
        EntityLivingBase entitylivingbase = this.swellingCreeper.getAttackTarget();
        return this.swellingCreeper.getCreeperState() > 0 || entitylivingbase != null && this.swellingCreeper.getDistanceSqToEntity((Entity)entitylivingbase) < 1.0;
    }

    public void startExecuting() {
        this.swellingCreeper.getNavigator().clearPathEntity();
        this.creeperAttackTarget = this.swellingCreeper.getAttackTarget();
    }

    public void resetTask() {
        this.creeperAttackTarget = null;
    }

    public void updateTask() {
        if (this.creeperAttackTarget == null) {
            this.swellingCreeper.setCreeperState(-1);
        } else if (this.swellingCreeper.getDistanceSqToEntity((Entity)this.creeperAttackTarget) > 1.0) {
            this.swellingCreeper.setCreeperState(-1);
        } else if (!this.swellingCreeper.getEntitySenses().canSee((Entity)this.creeperAttackTarget)) {
            this.swellingCreeper.setCreeperState(-1);
        } else {
            this.swellingCreeper.setCreeperState(1);
        }
    }
}

