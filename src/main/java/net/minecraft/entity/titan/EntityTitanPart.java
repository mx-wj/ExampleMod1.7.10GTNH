/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.IEntityMultiPartTitan;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTitanPart
extends Entity {
    public IEntityMultiPartTitan entityDragonObj;
    public String field_146032_b;
    public int numberOfTimesHit;

    public EntityTitanPart(World p_i1698_1_) {
        super(p_i1698_1_);
        this.preventEntitySpawning = true;
    }

    public EntityTitanPart(World p_i1698_1_, IEntityMultiPartTitan p_i1697_1_, String p_i1697_2_, float p_i1697_3_, float p_i1697_4_) {
        this(p_i1698_1_);
        this.setSize(p_i1697_3_, p_i1697_4_);
        this.entityDragonObj = p_i1697_1_;
        this.field_146032_b = p_i1697_2_;
        if (p_i1697_1_ instanceof Entity) {
            this.setPosition(((Entity)p_i1697_1_).posX, ((Entity)p_i1697_1_).posY, ((Entity)p_i1697_1_).posZ);
        }
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public float getRenderSizeModifier() {
        return this.width;
    }

    @SideOnly(value=Side.CLIENT)
    public float getShadowSize() {
        return this.entityDragonObj != null && this.entityDragonObj instanceof EntityLivingBase && this.posY > ((EntityLivingBase)this.entityDragonObj).posY ? (float)(((EntityLivingBase)this.entityDragonObj).posY - this.posY) : 0.0f;
    }

    public boolean isBurning() {
        return this.entityDragonObj != null && this.entityDragonObj instanceof EntityLivingBase ? ((EntityLivingBase)this.entityDragonObj).isBurning() : false;
    }

    protected void entityInit() {
    }

    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
    }

    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
    }

    public boolean canBeCollidedWith() {
        return this.entityDragonObj != null;
    }

    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        return this.isEntityInvulnerable() ? false : (this.entityDragonObj != null ? this.entityDragonObj.attackEntityFromPart(this, p_70097_1_, p_70097_2_) : false);
    }

    public AxisAlignedBB getCollisionBox(Entity entityIn) {
        return this.boundingBox;
    }

    public AxisAlignedBB getBoundingBox() {
        return this.boundingBox;
    }

    public void setLocationAndAngles(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
        if (this.entityDragonObj != null && this.entityDragonObj instanceof EntityLivingBase) {
            p_70012_1_ += ((EntityLivingBase)this.entityDragonObj).motionX;
            p_70012_5_ += ((EntityLivingBase)this.entityDragonObj).motionZ;
        }
        super.setLocationAndAngles(p_70012_1_, p_70012_3_, p_70012_5_, p_70012_7_, p_70012_8_);
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.entityDragonObj != null && this.entityDragonObj instanceof EntityLivingBase) {
            this.rotationYaw = ((EntityLivingBase)this.entityDragonObj).renderYawOffset;
            this.setInvisible(((EntityLivingBase)this.entityDragonObj).isInvisible());
            this.motionX = ((EntityLivingBase)this.entityDragonObj).motionX;
            this.motionY = ((EntityLivingBase)this.entityDragonObj).motionY;
            this.motionZ = ((EntityLivingBase)this.entityDragonObj).motionZ;
        }
        if (this.entityDragonObj == null || this.worldObj == null || this.entityDragonObj != null && this.entityDragonObj instanceof EntityLivingBase && !((EntityLiving)this.entityDragonObj).isEntityAlive()) {
            for (int i = 0; i < 50; ++i) {
                this.worldObj.spawnParticle("largeexplode", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                this.worldObj.spawnParticle("explode", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
            }
            this.setDead();
        }
    }
}

