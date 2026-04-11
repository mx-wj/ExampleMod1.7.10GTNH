/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySkeletonTitanGiantArrow
extends Entity {
    public EntityLivingBase shootingEntity;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;

    @SideOnly(value=Side.CLIENT)
    public boolean isInRangeToRenderDist(double p_70112_1_) {
        double d1 = this.boundingBox.getAverageEdgeLength() * 8.0;
        return p_70112_1_ < (d1 *= 64.0) * d1;
    }

    protected void entityInit() {
    }

    public EntitySkeletonTitanGiantArrow(World worldIn) {
        super(worldIn);
        this.setSize(4.0f, 4.0f);
    }

    public EntitySkeletonTitanGiantArrow(World p_i1761_1_, EntityLivingBase p_i1761_2_, double p_i1761_3_, double p_i1761_5_, double p_i1761_7_) {
        super(p_i1761_1_);
        this.shootingEntity = p_i1761_2_;
        this.setLocationAndAngles(p_i1761_2_.posX, p_i1761_2_.posY, p_i1761_2_.posZ, p_i1761_2_.rotationYaw, p_i1761_2_.rotationPitch);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        double d3 = MathHelper.sqrt_double((double)((p_i1761_3_ += this.rand.nextGaussian() * 0.4) * p_i1761_3_ + (p_i1761_5_ += this.rand.nextGaussian() * 0.4) * p_i1761_5_ + (p_i1761_7_ += this.rand.nextGaussian() * 0.4) * p_i1761_7_));
        this.accelerationX = p_i1761_3_ / d3 * 0.1;
        this.accelerationY = p_i1761_5_ / d3 * 0.1;
        this.accelerationZ = p_i1761_7_ / d3 * 0.1;
        this.setSize(4.0f, 4.0f);
    }

    public EntitySkeletonTitanGiantArrow(World p_i1760_1_, double p_i1760_2_, double p_i1760_4_, double p_i1760_6_, double p_i1760_8_, double p_i1760_10_, double p_i1760_12_) {
        super(p_i1760_1_);
        this.setSize(4.0f, 4.0f);
        this.setLocationAndAngles(p_i1760_2_, p_i1760_4_, p_i1760_6_, this.rotationYaw, this.rotationPitch);
        this.setPosition(p_i1760_2_, p_i1760_4_, p_i1760_6_);
        double d6 = MathHelper.sqrt_double((double)(p_i1760_8_ * p_i1760_8_ + p_i1760_10_ * p_i1760_10_ + p_i1760_12_ * p_i1760_12_));
        this.accelerationX = p_i1760_8_ / d6 * 0.1;
        this.accelerationY = p_i1760_10_ / d6 * 0.1;
        this.accelerationZ = p_i1760_12_ / d6 * 0.1;
    }

    public void onImpact(MovingObjectPosition movingObject) {
        if (!this.worldObj.isRemote) {
            float f = TheTitans.NightmareMode ? 6000.0f : 2000.0f;
            if (movingObject.entityHit != null && this.shootingEntity != null && this.shootingEntity instanceof EntityLiving && movingObject.entityHit instanceof EntityLivingBase && ((EntityLiving)this.shootingEntity).canAttackClass(movingObject.entityHit.getClass())) {
                if (this.shootingEntity instanceof EntityTitan) {
                    ((EntityTitan)this.shootingEntity).attackChoosenEntity(movingObject.entityHit, f, 10);
                } else {
                    movingObject.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.shootingEntity), f);
                }
                this.playSound("thetitans:slashFlesh", 2.0f, 1.5f);
                if (movingObject.entityHit instanceof EntityTitan || movingObject.entityHit instanceof EntityTitanPart) {
                    if (this.shootingEntity instanceof EntityTitan) {
                        ((EntityTitan)this.shootingEntity).attackChoosenEntity(movingObject.entityHit, f, 10);
                        ((EntityTitan)this.shootingEntity).attackChoosenEntity(movingObject.entityHit, f, 10);
                        ((EntityTitan)this.shootingEntity).attackChoosenEntity(movingObject.entityHit, f, 10);
                        ((EntityTitan)this.shootingEntity).destroyBlocksInAABB(this.boundingBox.expand(5.0, 5.0, 5.0));
                    }
                    this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 10.0f, false);
                    this.setDead();
                }
            }
        }
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
        p_70014_1_.setTag("direction", (NBTBase)this.newDoubleNBTList(new double[]{this.motionX, this.motionY, this.motionZ}));
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
        if (p_70037_1_.hasKey("direction", 9)) {
            NBTTagList nbttaglist = p_70037_1_.getTagList("direction", 6);
            this.motionX = nbttaglist.func_150309_d(0);
            this.motionY = nbttaglist.func_150309_d(1);
            this.motionZ = nbttaglist.func_150309_d(2);
        } else {
            this.setDead();
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    protected float getMotionFactor() {
        return 0.99f;
    }

    public boolean isBurning() {
        return false;
    }

    public void onUpdate() {
        ArrayList list;
        this.onEntityUpdate();
        if (!this.worldObj.isRemote && (this.posY <= -100.0 || this.ticksExisted > 300 || this.shootingEntity == null || this.shootingEntity != null && !this.shootingEntity.isEntityAlive())) {
            this.setDead();
        }
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f = MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionZ * this.motionZ));
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0 / Math.PI);
        }
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f1 = MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionZ * this.motionZ));
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / Math.PI);
        this.rotationPitch = (float)(Math.atan2(this.motionY, f1) * 180.0 / Math.PI);
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
        float f2 = this.getMotionFactor();
        this.motionX += this.accelerationX * 5.0;
        this.motionY += this.accelerationY * 5.0;
        this.motionZ += this.accelerationZ * 5.0;
        this.motionX *= (double)f2;
        this.motionY *= (double)f2;
        this.motionZ *= (double)f2;
        this.setPosition(this.posX, this.posY, this.posZ);
        if (this.shootingEntity != null && this.shootingEntity instanceof EntityTitan) {
            ((EntityTitan)this.shootingEntity).destroyBlocksInAABB(this.boundingBox);
        }
        if (this.shootingEntity != null && this.shootingEntity instanceof EntityEnderColossus) {
            this.setInvisible(true);
        }
        this.noClip = true;
        if (this.shootingEntity != null && this.shootingEntity instanceof EntityTitan) {
            ((EntityTitan)this.shootingEntity).destroyBlocksInAABB(this.boundingBox);
        }
        if ((list = Lists.newArrayList((Iterable)this.worldObj.loadedEntityList)) != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (!this.isEntityAlive() || !(this.getDistanceSqToEntity(entity) <= (double)(this.width * this.width + entity.width * entity.width) + 9.0)) continue;
                this.onImpact(new MovingObjectPosition(entity));
            }
        }
    }
}

