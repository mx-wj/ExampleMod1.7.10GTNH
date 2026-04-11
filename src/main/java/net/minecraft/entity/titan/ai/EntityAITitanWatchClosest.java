/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.monster.EntityGiantZombie
 *  net.minecraft.entity.player.EntityPlayer
 */
package net.minecraft.entity.titan.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;

public class EntityAITitanWatchClosest
extends EntityAIBase {
    private EntityTitan theWatcher;
    protected Entity closestEntity;
    private float maxDistanceForPlayer;
    private int lookTime;
    private float field_75331_e;
    private Class watchedClass;

    public EntityAITitanWatchClosest(EntityTitan p_i1631_1_, Class p_i1631_2_, float p_i1631_3_) {
        this.theWatcher = p_i1631_1_;
        this.watchedClass = p_i1631_2_;
        this.maxDistanceForPlayer = p_i1631_3_;
        this.field_75331_e = 0.05f;
        this.setMutexBits(2);
    }

    public EntityAITitanWatchClosest(EntityTitan p_i1632_1_, Class p_i1632_2_, float p_i1632_3_, float p_i1632_4_) {
        this.theWatcher = p_i1632_1_;
        this.watchedClass = p_i1632_2_;
        this.maxDistanceForPlayer = p_i1632_3_;
        this.field_75331_e = p_i1632_4_;
        this.setMutexBits(2);
    }

    public boolean shouldExecute() {
        if (this.theWatcher.getRNG().nextFloat() >= this.field_75331_e) {
            return false;
        }
        this.closestEntity = this.watchedClass == EntityPlayer.class ? this.theWatcher.worldObj.getClosestPlayerToEntity((Entity)this.theWatcher, (double)this.maxDistanceForPlayer) : this.theWatcher.worldObj.findNearestEntityWithinAABB(this.watchedClass, this.theWatcher.boundingBox.expand((double)this.maxDistanceForPlayer, (double)this.maxDistanceForPlayer, (double)this.maxDistanceForPlayer), (Entity)this.theWatcher);
        return !this.theWatcher.getWaiting() && this.theWatcher.animID != 13 && this.theWatcher.getAttackTarget() == null && this.closestEntity != null;
    }

    public boolean continueExecuting() {
        return this.closestEntity.isEntityAlive() && this.lookTime > 0;
    }

    public void startExecuting() {
        this.lookTime = 40 + this.theWatcher.getRNG().nextInt(40);
        if (this.closestEntity instanceof EntityGiantZombie) {
            ((EntityGiantZombie)this.closestEntity).faceEntity((Entity)this.theWatcher, 10.0f, 40.0f);
        }
    }

    public void resetTask() {
        this.closestEntity = null;
    }

    public void updateTask() {
        this.theWatcher.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + (double)this.closestEntity.getEyeHeight(), this.closestEntity.posZ, 5.0f, (float)this.theWatcher.getVerticalFaceSpeed());
        --this.lookTime;
    }
}

