/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIDoorInteract
 *  net.minecraft.item.ItemAxe
 *  net.minecraft.world.IBlockAccess
 */
package net.minecraft.entity.titan.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIDoorInteract;
import net.minecraft.entity.titanminion.EntityCreeperMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.IMinion;
import net.minecraft.item.ItemAxe;
import net.minecraft.world.IBlockAccess;

public class EntityAIBreakDoorMinion
extends EntityAIDoorInteract {
    private int breakingTime;
    private int field_75358_j = -1;

    public EntityAIBreakDoorMinion(EntityLiving p_i1618_1_) {
        super(p_i1618_1_);
    }

    public boolean shouldExecute() {
        return !super.shouldExecute() ? false : (!this.theEntity.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing") ? false : !this.field_151504_e.func_150015_f((IBlockAccess)this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ));
    }

    public void startExecuting() {
        super.startExecuting();
        this.breakingTime = 0;
    }

    public boolean continueExecuting() {
        double d0 = this.theEntity.getDistanceSq((double)this.entityPosX, (double)this.entityPosY, (double)this.entityPosZ);
        return this.breakingTime <= 240 && !this.field_151504_e.func_150015_f((IBlockAccess)this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ) && d0 < 4.0;
    }

    public void resetTask() {
        super.resetTask();
        this.theEntity.worldObj.destroyBlockInWorldPartially(this.theEntity.getEntityId(), this.entityPosX, this.entityPosY, this.entityPosZ, -1);
    }

    public void updateTask() {
        super.updateTask();
        this.theEntity.getLookHelper().setLookPosition(this.field_151504_e.getBlockBoundsMaxX() - this.field_151504_e.getBlockBoundsMinX(), this.field_151504_e.getBlockBoundsMaxY() - this.field_151504_e.getBlockBoundsMinY(), this.field_151504_e.getBlockBoundsMaxZ() - this.field_151504_e.getBlockBoundsMinZ(), 180.0f, 30.0f);
        int dam = (int)this.theEntity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        if (this.theEntity instanceof EntityCreeperMinion && ((EntityCreeperMinion)this.theEntity).getMinionTypeInt() != 3) {
            ((EntityCreeperMinion)this.theEntity).func_146079_cb();
        } else if (this.theEntity.ticksExisted % 20 == 0) {
            this.breakingTime += dam;
            if (this.theEntity.getHeldItem() != null) {
                this.breakingTime += dam;
                if (this.theEntity.getHeldItem().getItem() instanceof ItemAxe) {
                    this.breakingTime += dam * 3;
                }
            }
            this.theEntity.swingItem();
            this.theEntity.worldObj.playAuxSFX(1010, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
        }
        int i = (int)((float)this.breakingTime / 240.0f * 10.0f);
        if (i != this.field_75358_j) {
            this.theEntity.worldObj.destroyBlockInWorldPartially(this.theEntity.getEntityId(), this.entityPosX, this.entityPosY, this.entityPosZ, i);
            this.field_75358_j = i;
        }
        if (this.breakingTime >= 240 || this.theEntity instanceof IMinion && ((IMinion)this.theEntity).getMinionType() == EnumMinionType.TEMPLAR) {
            this.theEntity.worldObj.setBlockToAir(this.entityPosX, this.entityPosY, this.entityPosZ);
            this.theEntity.worldObj.playAuxSFX(1012, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
            this.theEntity.worldObj.playAuxSFX(2001, this.entityPosX, this.entityPosY, this.entityPosZ, Block.getIdFromBlock((Block)this.field_151504_e));
        }
    }
}

