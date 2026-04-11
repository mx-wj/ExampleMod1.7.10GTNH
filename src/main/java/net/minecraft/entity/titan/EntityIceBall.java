/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.projectile.EntitySnowball
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityIceBall
extends EntitySnowball {
    public EntityIceBall(World par1World) {
        super(par1World);
    }

    public EntityIceBall(World par1World, EntityLivingBase par3EntityPlayer) {
        super(par1World, par3EntityPlayer);
    }

    public EntityIceBall(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
    }

    public EntityIceBall(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null && this.getThrower() != null) {
            if (!((EntityLiving)this.getThrower()).canAttackClass(par1MovingObjectPosition.entityHit.getClass())) {
                this.setDead();
                return;
            }
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.getThrower()), 50.0f);
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.getThrower()), 50.0f);
            par1MovingObjectPosition.entityHit.motionY += 1.0;
        }
        this.playSound("random.explode", 0.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.worldObj.createExplosion((Entity)(this.getThrower() != null ? this.getThrower() : this), this.posX, this.posY, this.posZ, 3.0f, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            for (int i = 0; i < 5; ++i) {
                int x = this.worldObj.rand.nextInt(3);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    x = -x;
                }
                int y = this.worldObj.rand.nextInt(3);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    y = -y;
                }
                int z = this.worldObj.rand.nextInt(3);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    z = -z;
                }
                if (this.worldObj.getBlock(x = (int)((double)x + par1MovingObjectPosition.hitVec.xCoord), y = (int)((double)y + par1MovingObjectPosition.hitVec.yCoord), z = (int)((double)z + par1MovingObjectPosition.hitVec.zCoord)).isOpaqueCube()) continue;
                this.worldObj.setBlock(x, y, z, Blocks.ice);
            }
        }
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

