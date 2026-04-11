/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockDoor
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.init.Blocks
 *  net.minecraft.pathfinding.PathEntity
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.pathfinding.PathPoint
 *  net.minecraft.util.MathHelper
 */
package net.minecraft.entity.titan.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;

public abstract class EntityAIIronDoorInteract
extends EntityAIBase {
    protected EntityLiving theEntity;
    protected int entityPosX;
    protected int entityPosY;
    protected int entityPosZ;
    protected BlockDoor field_151504_e;
    boolean hasStoppedDoorInteraction;
    float entityPositionX;
    float entityPositionZ;

    public EntityAIIronDoorInteract(EntityLiving p_i1621_1_) {
        this.theEntity = p_i1621_1_;
    }

    public boolean shouldExecute() {
        if (!this.theEntity.isCollidedHorizontally) {
            return false;
        }
        PathNavigate pathnavigate = this.theEntity.getNavigator();
        PathEntity pathentity = pathnavigate.getPath();
        if (pathentity != null && !pathentity.isFinished() && pathnavigate.getCanBreakDoors()) {
            for (int i = 0; i < Math.min(pathentity.getCurrentPathIndex() + 2, pathentity.getCurrentPathLength()); ++i) {
                PathPoint pathpoint = pathentity.getPathPointFromIndex(i);
                this.entityPosX = pathpoint.xCoord;
                this.entityPosY = pathpoint.yCoord + 1;
                this.entityPosZ = pathpoint.zCoord;
                if (!(this.theEntity.getDistanceSq((double)this.entityPosX, this.theEntity.posY, (double)this.entityPosZ) <= 2.25)) continue;
                this.field_151504_e = this.func_151503_a(this.entityPosX, this.entityPosY, this.entityPosZ);
                if (this.field_151504_e == null) continue;
                return true;
            }
            this.entityPosX = MathHelper.floor_double((double)this.theEntity.posX);
            this.entityPosY = MathHelper.floor_double((double)(this.theEntity.posY + 1.0));
            this.entityPosZ = MathHelper.floor_double((double)this.theEntity.posZ);
            this.field_151504_e = this.func_151503_a(this.entityPosX, this.entityPosY, this.entityPosZ);
            return this.field_151504_e != null;
        }
        return false;
    }

    public boolean continueExecuting() {
        return !this.hasStoppedDoorInteraction;
    }

    public void startExecuting() {
        this.hasStoppedDoorInteraction = false;
        this.entityPositionX = (float)((double)((float)this.entityPosX + 0.5f) - this.theEntity.posX);
        this.entityPositionZ = (float)((double)((float)this.entityPosZ + 0.5f) - this.theEntity.posZ);
    }

    public void updateTask() {
        float f = (float)((double)((float)this.entityPosX + 0.5f) - this.theEntity.posX);
        float f1 = (float)((double)((float)this.entityPosZ + 0.5f) - this.theEntity.posZ);
        float f2 = this.entityPositionX * f + this.entityPositionZ * f1;
        if (f2 < 0.0f) {
            this.hasStoppedDoorInteraction = true;
        }
    }

    private BlockDoor func_151503_a(int p_151503_1_, int p_151503_2_, int p_151503_3_) {
        Block block = this.theEntity.worldObj.getBlock(p_151503_1_, p_151503_2_, p_151503_3_);
        return block != Blocks.iron_door ? null : (BlockDoor)block;
    }
}

