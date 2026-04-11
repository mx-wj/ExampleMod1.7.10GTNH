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
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBulletWitherSkull
extends EntityWitherSkull {
    public int lifetime;
    public int explosivePower;
    public int extraDamage;
    public float speedFactor;

    protected float getMotionFactor() {
        return 0.95f;
    }

    public EntityBulletWitherSkull(World worldIn) {
        super(worldIn);
        this.setSize(0.3125f, 0.3125f);
    }

    public EntityBulletWitherSkull(World worldIn, EntityLivingBase p_i1794_2_, double p_i1794_3_, double p_i1794_5_, double p_i1794_7_) {
        super(worldIn, p_i1794_2_, p_i1794_3_, p_i1794_5_, p_i1794_7_);
        this.setSize(0.3125f, 0.3125f);
    }

    @SideOnly(value=Side.CLIENT)
    public EntityBulletWitherSkull(World worldIn, double p_i1795_2_, double p_i1795_4_, double p_i1795_6_, double p_i1795_8_, double p_i1795_10_, double p_i1795_12_) {
        super(worldIn, p_i1795_2_, p_i1795_4_, p_i1795_6_, p_i1795_8_, p_i1795_10_, p_i1795_12_);
        this.setSize(0.3125f, 0.3125f);
    }

    protected void onImpact(MovingObjectPosition movingObject) {
        if (!this.worldObj.isRemote) {
            if (movingObject.entityHit != null) {
                if (this.shootingEntity != null) {
                    if (movingObject.entityHit instanceof EntityLivingBase) {
                        ((EntityLivingBase)movingObject.entityHit).setRevengeTarget(this.shootingEntity);
                        movingObject.entityHit.hurtResistantTime = 1;
                        if (!(((EntityLivingBase)movingObject.entityHit).getTotalArmorValue() <= 24 || movingObject.entityHit instanceof EntityTitan || movingObject.entityHit instanceof EntityDragon || movingObject.entityHit instanceof EntityDragonPart || movingObject.entityHit instanceof EntityPlayer)) {
                            movingObject.entityHit.attackEntityFrom(DamageSourceExtra.destroy, 2.14748365E9f);
                        }
                    }
                    if (movingObject.entityHit instanceof EntityDragon || movingObject.entityHit instanceof EntityDragonPart) {
                        movingObject.entityHit.attackEntityFrom(DamageSourceExtra.causeHomingSkullDamageVSEnderDragon((Entity)this.shootingEntity), 10.0f + (float)this.extraDamage);
                    } else if (movingObject.entityHit instanceof EntityLivingBase && ((EntityLivingBase)movingObject.entityHit).getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
                        movingObject.entityHit.attackEntityFrom(DamageSourceExtra.generic, 10.0f + (float)this.extraDamage);
                    } else {
                        movingObject.entityHit.attackEntityFrom(DamageSourceExtra.causeHomingSkullDamage((Entity)this.shootingEntity), 10.0f + (float)this.extraDamage);
                    }
                    if (!(movingObject.entityHit.isEntityAlive() || movingObject.entityHit instanceof EntityTitan || movingObject.entityHit instanceof EntityDragon || movingObject.entityHit instanceof EntityDragonPart || movingObject.entityHit instanceof EntityPlayer)) {
                        movingObject.entityHit.setDead();
                    }
                } else {
                    movingObject.entityHit.attackEntityFrom(DamageSource.magic, 5.0f);
                }
                if (movingObject.entityHit instanceof EntityLivingBase) {
                    int b0 = 10;
                    if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                        b0 = 20;
                    } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                        b0 = 40;
                    }
                    if (b0 > 0) {
                        ((EntityLivingBase)movingObject.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 40, 3));
                        ((EntityLivingBase)movingObject.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, 20 * b0, 1));
                        if (movingObject.entityHit.posY + (double)movingObject.entityHit.getEyeHeight() - 0.2 < this.posY) {
                            ((EntityLivingBase)movingObject.entityHit).addPotionEffect(new PotionEffect(Potion.blindness.id, 40, 0));
                        }
                    }
                }
            }
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 1.8f);
            this.setDead();
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public void onUpdate() {
        super.onUpdate();
        ++this.lifetime;
        if (this.lifetime >= 100) {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 1.8f);
            this.setDead();
        }
    }
}

