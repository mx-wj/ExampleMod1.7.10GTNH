/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.world.IBlockAccess
 */
package net.minecraft.entity.titan.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.titan.ai.EntityAIIronDoorInteract;
import net.minecraft.world.IBlockAccess;

public class EntityAIBreakIronDoorMinion
extends EntityAIIronDoorInteract {
    private int breakingTime;
    private int field_75358_j = -1;

    public EntityAIBreakIronDoorMinion(EntityLiving p_i1618_1_) {
        super(p_i1618_1_);
    }

    @Override
    public boolean shouldExecute() {
        return !super.shouldExecute() ? false : this.theEntity.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        this.breakingTime = 0;
    }

    @Override
    public boolean continueExecuting() {
        double d0 = this.theEntity.getDistanceSq((double)this.entityPosX, (double)this.entityPosY, (double)this.entityPosZ);
        return this.breakingTime <= 240 && !this.field_151504_e.func_150015_f((IBlockAccess)this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ) && d0 < 4.0;
    }

    public void resetTask() {
        super.resetTask();
        this.theEntity.worldObj.destroyBlockInWorldPartially(this.theEntity.getEntityId(), this.entityPosX, this.entityPosY, this.entityPosZ, -1);
    }

    @Override
    public void updateTask() {
        int i;
        super.updateTask();
        if (this.theEntity.ticksExisted % 20 == 0) {
            ++this.breakingTime;
            this.theEntity.swingItem();
            this.theEntity.worldObj.playAuxSFX(1011, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
        }
        if ((i = (int)((float)this.breakingTime / 240.0f * 10.0f)) != this.field_75358_j) {
            this.theEntity.worldObj.destroyBlockInWorldPartially(this.theEntity.getEntityId(), this.entityPosX, this.entityPosY, this.entityPosZ, i);
            this.field_75358_j = i;
        }
        if (this.breakingTime == 240) {
            this.theEntity.worldObj.setBlockToAir(this.entityPosX, this.entityPosY, this.entityPosZ);
            this.theEntity.worldObj.playAuxSFX(1012, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
            this.theEntity.worldObj.playAuxSFX(2001, this.entityPosX, this.entityPosY, this.entityPosZ, Block.getIdFromBlock((Block)this.field_151504_e));
        }
    }
}

