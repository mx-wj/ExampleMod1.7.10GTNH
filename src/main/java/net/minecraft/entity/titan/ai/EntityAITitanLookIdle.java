/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.ai.EntityAIBase
 */
package net.minecraft.entity.titan.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.titan.EntityTitan;

public class EntityAITitanLookIdle
extends EntityAIBase {
    private EntityTitan idleEntity;
    private double lookX;
    private double lookZ;
    private int idleTime;

    public EntityAITitanLookIdle(EntityTitan p_i1647_1_) {
        this.idleEntity = p_i1647_1_;
        this.setMutexBits(3);
    }

    public boolean shouldExecute() {
        return !this.idleEntity.getWaiting() && this.idleEntity.animID == 0 && this.idleEntity.getAttackTarget() == null && this.idleEntity.getRNG().nextFloat() < 0.1f;
    }

    public boolean continueExecuting() {
        return this.idleTime >= 0;
    }

    public void startExecuting() {
        double d0 = 24.0 * this.idleEntity.getRNG().nextDouble();
        this.lookX = Math.cos(d0);
        this.lookZ = Math.sin(d0);
        this.idleTime = 80 + this.idleEntity.getRNG().nextInt(40);
    }

    public void updateTask() {
        --this.idleTime;
        this.idleEntity.getLookHelper().setLookPosition(this.idleEntity.posX + this.lookX, this.idleEntity.posY + (double)this.idleEntity.getEyeHeight(), this.idleEntity.posZ + this.lookZ, 2.0f, (float)this.idleEntity.getVerticalFaceSpeed());
    }
}

