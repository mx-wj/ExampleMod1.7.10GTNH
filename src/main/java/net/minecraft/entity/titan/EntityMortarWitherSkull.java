/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityDragonPart
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  net.minecraft.init.Blocks
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityMortarWitherSkull
extends EntityWitherSkull {
    public int lifetime;
    public int explosivePower;
    public int extraDamage;
    public float speedFactor;

    public boolean isInvulnerable() {
        return true;
    }

    public EntityMortarWitherSkull(World worldIn) {
        super(worldIn);
        this.setSize(0.5f, 0.5f);
    }

    public EntityMortarWitherSkull(World worldIn, EntityLivingBase p_i1794_2_, double p_i1794_3_, double p_i1794_5_, double p_i1794_7_) {
        super(worldIn, p_i1794_2_, p_i1794_3_, p_i1794_5_, p_i1794_7_);
        this.setSize(0.5f, 0.5f);
    }

    @SideOnly(value=Side.CLIENT)
    public EntityMortarWitherSkull(World worldIn, double p_i1795_2_, double p_i1795_4_, double p_i1795_6_, double p_i1795_8_, double p_i1795_10_, double p_i1795_12_) {
        super(worldIn, p_i1795_2_, p_i1795_4_, p_i1795_6_, p_i1795_8_, p_i1795_10_, p_i1795_12_);
        this.setSize(0.5f, 0.5f);
    }

    public float func_145772_a(Explosion p_145772_1_, World p_145772_2_, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block p_145772_6_) {
        float f = super.func_145772_a(p_145772_1_, p_145772_2_, p_145772_3_, p_145772_4_, p_145772_5_, p_145772_6_);
        if (this.isInvulnerable() && p_145772_6_ != Blocks.bedrock && p_145772_6_ != Blocks.end_portal && p_145772_6_ != Blocks.end_portal_frame && p_145772_6_ != Blocks.command_block) {
            f = Math.min(0.0f, f);
        }
        return f;
    }

    protected void onImpact(MovingObjectPosition movingObject) {
        if (!this.worldObj.isRemote) {
            if (movingObject.entityHit != null) {
                if (this.shootingEntity != null) {
                    if (movingObject.entityHit instanceof EntityLivingBase) {
                        ((EntityLivingBase)movingObject.entityHit).setRevengeTarget(this.shootingEntity);
                        movingObject.entityHit.hurtResistantTime = 0;
                        movingObject.entityHit.addVelocity((double)(-MathHelper.sin((float)(this.shootingEntity.rotationYawHead * (float)Math.PI / 180.0f)) * 1.5f), 0.9, (double)(MathHelper.cos((float)(this.shootingEntity.rotationYawHead * (float)Math.PI / 180.0f)) * 1.5f));
                        if (!(!movingObject.entityHit.isEntityInvulnerable() && !(movingObject.entityHit.height >= 6.0f) && ((EntityLivingBase)movingObject.entityHit).getTotalArmorValue() <= 24 || movingObject.entityHit instanceof EntityTitan || movingObject.entityHit instanceof EntityDragon || movingObject.entityHit instanceof EntityDragonPart || movingObject.entityHit instanceof EntityPlayer)) {
                            movingObject.entityHit.attackEntityFrom(DamageSourceExtra.destroy, 2.14748365E9f);
                        }
                    }
                    if (movingObject.entityHit instanceof EntityDragon || movingObject.entityHit instanceof EntityDragonPart) {
                        if (movingObject.entityHit.height >= 6.0f) {
                            movingObject.entityHit.attackEntityFrom(DamageSourceExtra.causeHomingSkullDamageVSEnderDragon((Entity)this.shootingEntity), 5000.0f + (float)(this.extraDamage * 1000));
                            movingObject.entityHit.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                        } else {
                            movingObject.entityHit.attackEntityFrom(DamageSourceExtra.causeHomingSkullDamageVSEnderDragon((Entity)this.shootingEntity), 500.0f + (float)(this.extraDamage * 100));
                        }
                    } else if (movingObject.entityHit instanceof EntityLivingBase && ((EntityLivingBase)movingObject.entityHit).getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
                        if (movingObject.entityHit.height >= 6.0f || ((EntityLivingBase)movingObject.entityHit).getTotalArmorValue() > 24) {
                            movingObject.entityHit.attackEntityFrom(DamageSource.generic, 5000.0f + (float)(this.extraDamage * 1000));
                            movingObject.entityHit.playSound("thetitans:titanpunch", 10.0f, 0.9f);
                        } else {
                            movingObject.entityHit.attackEntityFrom(DamageSourceExtra.generic, 500.0f + (float)(this.extraDamage * 100));
                        }
                    } else if (movingObject.entityHit.height >= 6.0f) {
                        movingObject.entityHit.attackEntityFrom(DamageSourceExtra.causeHomingSkullDamage((Entity)this.shootingEntity), 5000.0f + (float)(this.extraDamage * 1000));
                        movingObject.entityHit.playSound("thetitans:titanpunch", 10.0f, 0.9f);
                    } else {
                        movingObject.entityHit.attackEntityFrom(DamageSourceExtra.causeHomingSkullDamage((Entity)this.shootingEntity), 500.0f + (float)(this.extraDamage * 100));
                    }
                } else {
                    movingObject.entityHit.attackEntityFrom(DamageSource.magic, 500.0f);
                }
                if (movingObject.entityHit instanceof EntityLivingBase) {
                    int b0 = 30;
                    if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                        b0 = 60;
                    } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                        b0 = 90;
                    }
                    if (b0 > 0) {
                        ((EntityLivingBase)movingObject.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 120, 3));
                        ((EntityLivingBase)movingObject.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, 40 * b0, 3));
                        ((EntityLivingBase)movingObject.entityHit).addPotionEffect(new PotionEffect(Potion.blindness.id, 120, 0));
                        ((EntityLivingBase)movingObject.entityHit).addPotionEffect(new PotionEffect(Potion.confusion.id, 120, 0));
                    }
                }
            }
            net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)(this.shootingEntity != null ? this.shootingEntity : this), this.posX, this.posY, this.posZ, 14.0f, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.6f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "thetitans:mortarHit", 0.5f, 1.0f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "thetitans:mortarHit", 2.0f, 1.0f);
            this.setDead();
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public void onUpdate() {
        super.onUpdate();
        ++this.lifetime;
        if (this.lifetime >= 1000) {
            net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)(this.shootingEntity != null ? this.shootingEntity : this), this.posX, this.posY, this.posZ, 14.0f, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.6f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "thetitans:mortarHit", 0.5f, 1.0f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "thetitans:mortarHit", 2.0f, 1.0f);
            this.setDead();
        }
    }
}

