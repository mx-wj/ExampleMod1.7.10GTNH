/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.projectile.EntitySnowball
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityThunderboltShot
extends EntitySnowball {
    public EntityThunderboltShot(World par1World) {
        super(par1World);
    }

    public EntityThunderboltShot(World par1World, EntityLivingBase par3EntityPlayer) {
        super(par1World, par3EntityPlayer);
    }

    public EntityThunderboltShot(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
    }

    public EntityThunderboltShot(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (!this.worldObj.isRemote && par1MovingObjectPosition.entityHit != null && this.getThrower() != null && par1MovingObjectPosition.entityHit != this.getThrower()) {
            if (!((EntityLiving)this.getThrower()).canAttackClass(par1MovingObjectPosition.entityHit.getClass())) {
                this.setDead();
                return;
            }
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.getThrower()), 50.0f);
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.getThrower()), 50.0f);
            par1MovingObjectPosition.entityHit.setFire(15);
            par1MovingObjectPosition.entityHit.motionY += 1.0;
        }
        this.playSound("random.explode", 0.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            net.minecraft.theTitans.util.FastExplosion.createExplosion(this.worldObj, (Entity)(this.getThrower() != null ? this.getThrower() : this), this.posX, this.posY, this.posZ, 3.0f, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        }
        this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, this.posX, this.posY + 1.0, this.posZ));
        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        int mx = 4;
        for (int i = 0; i < mx; ++i) {
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian() / 10.0, this.worldObj.rand.nextGaussian() / 10.0, this.worldObj.rand.nextGaussian() / 10.0);
        }
    }
}

