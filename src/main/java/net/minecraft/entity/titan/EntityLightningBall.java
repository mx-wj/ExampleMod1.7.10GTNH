/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLightningBall
extends EntityFireball {
    public EntityLightningBall(World worldIn) {
        super(worldIn);
        this.setSize(4.0f, 4.0f);
    }

    public EntityLightningBall(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
        this.setSize(4.0f, 4.0f);
    }

    public EntityLightningBall(World worldIn, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(worldIn, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
        this.setSize(4.0f, 4.0f);
    }

    protected void onImpact(MovingObjectPosition movingObject) {
        if (!this.worldObj.isRemote) {
            float f = TheTitans.NightmareMode ? 6000.0f : 2000.0f;
            if (movingObject.entityHit != null) {
                movingObject.entityHit.attackEntityFrom(DamageSource.causeFireballDamage((EntityFireball)this, (Entity)this.shootingEntity), f);
                boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, 7.0f, true, flag);
            } else {
                this.playSound("random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
            }
            this.setDead();
        }
    }

    public void onUpdate() {
        List list11;
        super.onUpdate();
        this.setFire(4);
        if (this.ticksExisted % 600 == 0) {
            boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
            this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, 7.0f, true, flag);
            this.setDead();
        }
        if (this.rand.nextInt(30) == 0) {
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX, this.posY, this.posZ, 1.0f, 0.0f, 1.0f));
        }
        if ((list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(8.0, 8.0, 8.0))) != null && !list11.isEmpty() && this.shootingEntity != null) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity == null || !entity.isEntityAlive() || !(entity instanceof EntityLivingBase) || !(this.shootingEntity instanceof EntityEnderColossus) || entity instanceof EntityEndermanMinion || entity instanceof EntityEnderColossus || entity instanceof EntityDragon || entity instanceof EntityDragonMinion || entity instanceof EntityEnderColossusCrystal) continue;
                entity.setFire(15);
                entity.attackEntityFrom(DamageSourceExtra.lightningBolt, 100.0f);
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX, this.posY, this.posZ, 1.0f, 0.0f, 1.0f));
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity.posX, entity.posY, entity.posZ, 1.0f, 0.0f, 1.0f));
                ((EntityEnderColossus)this.shootingEntity).attackChoosenEntity(entity, 5.0f, 1);
            }
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean isBurning() {
        return false;
    }

    protected float getMotionFactor() {
        return 0.75f;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }
}

