/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityXPBomb
extends EntityThrowable {
    public int xpColor;

    public EntityXPBomb(World p_i1773_1_) {
        super(p_i1773_1_);
        this.setSize(3.0f, 3.0f);
        this.rotationYaw = (float)(Math.random() * 360.0);
        this.motionX = (float)(Math.random() * (double)0.2f - (double)0.1f) * 2.0f;
        this.motionY = (double)((float)(Math.random() * 0.2) * 2.0f) + 0.5;
        this.motionZ = (float)(Math.random() * (double)0.2f - (double)0.1f) * 2.0f;
    }

    public EntityXPBomb(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        this(p_i1775_1_);
        this.setPosition(p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object)new Integer(0));
    }

    public int getXPCount() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setXPCount(int p_82215_1_) {
        this.dataWatcher.updateObject(20, (Object)p_82215_1_);
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setShort("Value", (short)this.getXPCount());
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
        super.readEntityFromNBT(p_70037_1_);
        this.setXPCount(p_70037_1_.getShort("Value"));
    }

    public boolean isBurning() {
        return false;
    }

    protected float getGravityVelocity() {
        return 0.05f;
    }

    protected void onImpact(MovingObjectPosition movingObject) {
        this.playSound("random.explode", 5.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
        this.playSound("random.orb", 5.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
        if (!this.worldObj.isRemote) {
            for (int i1 = 0; i1 < 20; ++i1) {
                int i = this.getXPCount() / 20;
                EntityXPOrb orb = new EntityXPOrb(this.worldObj, this.posX, this.posY + 0.5, this.posZ, i);
                orb.motionY += 0.5;
                orb.xpValue = i;
                this.worldObj.spawnEntityInWorld((Entity)orb);
            }
            this.setDead();
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        float f1 = 0.5f;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        if (f1 > 1.0f) {
            f1 = 1.0f;
        }
        int i = super.getBrightnessForRender(p_70070_1_);
        int j = i & 0xFF;
        int k = i >> 16 & 0xFF;
        if ((j += (int)(f1 * 15.0f * 16.0f)) > 240) {
            j = 240;
        }
        return j | k << 16;
    }

    public void setDead() {
        super.setDead();
        this.worldObj.spawnParticle(this.getXPCount() >= 2000 ? "hugeexplosion" : "largeexplode", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + 3.0 + (this.rand.nextDouble() - 0.5) * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
    }

    public void onUpdate() {
        super.onUpdate();
        ++this.xpColor;
        if (this.getXPCount() <= 100) {
            this.setXPCount(100);
        }
    }
}

