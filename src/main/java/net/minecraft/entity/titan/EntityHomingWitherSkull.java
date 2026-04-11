/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityDragonPart
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityHomingWitherSkull
extends EntityWitherSkull {
    public int lifetime;
    public int explosivePower;
    public int extraDamage;
    public float speedFactor;
    public Entity assginedEntity;

    public EntityHomingWitherSkull(World worldIn) {
        super(worldIn);
        this.setSize(0.5f, 0.5f);
    }

    public EntityHomingWitherSkull(World worldIn, EntityLivingBase p_i1794_2_, double p_i1794_3_, double p_i1794_5_, double p_i1794_7_) {
        super(worldIn, p_i1794_2_, p_i1794_3_, p_i1794_5_, p_i1794_7_);
        this.setSize(0.5f, 0.5f);
    }

    @SideOnly(value=Side.CLIENT)
    public EntityHomingWitherSkull(World worldIn, double p_i1795_2_, double p_i1795_4_, double p_i1795_6_, double p_i1795_8_, double p_i1795_10_, double p_i1795_12_) {
        super(worldIn, p_i1795_2_, p_i1795_4_, p_i1795_6_, p_i1795_8_, p_i1795_10_, p_i1795_12_);
        this.setSize(0.5f, 0.5f);
    }

    protected void onImpact(MovingObjectPosition movingObject) {
        if (!this.worldObj.isRemote) {
            if (movingObject.entityHit != null) {
                if (this.shootingEntity != null) {
                    if (movingObject.entityHit instanceof EntityLivingBase) {
                        ((EntityLivingBase)movingObject.entityHit).setRevengeTarget(this.shootingEntity);
                        movingObject.entityHit.hurtResistantTime = 5;
                        if (!(!(movingObject.entityHit.height >= 6.0f) && ((EntityLivingBase)movingObject.entityHit).getTotalArmorValue() <= 24 || movingObject.entityHit instanceof EntityTitan || movingObject.entityHit instanceof EntityDragon || movingObject.entityHit instanceof EntityDragonPart || movingObject.entityHit instanceof EntityPlayer)) {
                            movingObject.entityHit.attackEntityFrom(DamageSourceExtra.destroy, Float.MAX_VALUE);
                        }
                    }
                    if (movingObject.entityHit instanceof EntityDragon || movingObject.entityHit instanceof EntityDragonPart) {
                        if (movingObject.entityHit.height >= 6.0f) {
                            movingObject.entityHit.attackEntityFrom(DamageSourceExtra.causeHomingSkullDamageVSEnderDragon((Entity)this.shootingEntity), 200.0f + (float)(this.extraDamage * 20));
                            movingObject.entityHit.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                        } else {
                            movingObject.entityHit.attackEntityFrom(DamageSourceExtra.causeHomingSkullDamageVSEnderDragon((Entity)this.shootingEntity), 20.0f + (float)this.extraDamage);
                        }
                    } else if (movingObject.entityHit instanceof EntityLivingBase && ((EntityLivingBase)movingObject.entityHit).getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
                        if (movingObject.entityHit.height >= 6.0f || ((EntityLivingBase)movingObject.entityHit).getTotalArmorValue() > 24) {
                            movingObject.entityHit.attackEntityFrom(DamageSourceExtra.radiation, 300.0f + (float)(this.extraDamage * 30));
                            movingObject.entityHit.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                        } else {
                            movingObject.entityHit.attackEntityFrom(DamageSourceExtra.radiation, 20.0f + (float)this.extraDamage);
                        }
                    } else if (movingObject.entityHit.height >= 6.0f) {
                        movingObject.entityHit.attackEntityFrom(DamageSourceExtra.causeHomingSkullDamage((Entity)this.shootingEntity), 100.0f + (float)(this.extraDamage * 10));
                        movingObject.entityHit.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                    } else {
                        movingObject.entityHit.attackEntityFrom(DamageSourceExtra.causeHomingSkullDamage((Entity)this.shootingEntity), 20.0f + (float)this.extraDamage);
                    }
                } else {
                    movingObject.entityHit.attackEntityFrom(DamageSource.magic, 20.0f);
                }
                if (movingObject.entityHit instanceof EntityLivingBase) {
                    int b0 = 20;
                    if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                        b0 = 40;
                    } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                        b0 = 80;
                    }
                    if (b0 > 0) {
                        ((EntityLivingBase)movingObject.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, 20 * b0, 1));
                    }
                }
            }
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 2.0f + (float)this.explosivePower, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            this.setDead();
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public void onUpdate() {
        ++this.lifetime;
        if (this.assginedEntity != null && this.assginedEntity.isEntityAlive()) {
            double d0 = this.assginedEntity.posX - this.posX;
            double d1 = this.assginedEntity.posY + (this.assginedEntity instanceof EntityTitan ? (double)this.assginedEntity.height * 0.5 : (double)this.assginedEntity.getEyeHeight()) - this.posY;
            double d2 = this.assginedEntity.posZ - this.posZ;
            float f2 = MathHelper.sqrt_double((double)(d0 * d0 + d1 * d1 + d2 * d2));
            this.motionX = d0 / (double)f2 * (double)(this.getMotionFactor() * 0.75f) * (double)(this.getMotionFactor() * 0.75f) + this.motionX * 0.75;
            this.motionY = d1 / (double)f2 * (double)(this.getMotionFactor() * 0.75f) * (double)(this.getMotionFactor() * 0.75f) + this.motionY * 0.75;
            this.motionZ = d2 / (double)f2 * (double)(this.getMotionFactor() * 0.75f) * (double)(this.getMotionFactor() * 0.75f) + this.motionZ * 0.75;
            double d = this.assginedEntity.posX;
            double d3 = this.assginedEntity.posY;
            double d4 = this.assginedEntity instanceof EntityTitan ? (double)this.assginedEntity.height * 0.5 : (double)this.assginedEntity.getEyeHeight();
            if (this.getDistanceSq(d, d3 + d4, this.assginedEntity.posZ) < 9.0) {
                this.onImpact(new MovingObjectPosition(this.assginedEntity));
                this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 2.0f + (float)this.explosivePower, false, false);
                this.setDead();
            }
        }
        if (this.lifetime >= 200) {
            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 2.0f + (float)this.explosivePower, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            this.setDead();
        }
        super.onUpdate();
        this.setPosition(this.posX, this.posY, this.posZ);
    }
}

