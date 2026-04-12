/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.orespawnaddon.EntityOverlordScorpion;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.EntityBlazeTitan;
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityTitanFireball
extends EntityFireball {
    public float explosionRadius;
    public float impactDamage;
    public boolean canCauseFires;

    public EntityTitanFireball(World worldIn) {
        super(worldIn);
    }

    public EntityTitanFireball(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
    }

    public EntityTitanFireball(World worldIn, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(worldIn, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
    }

    public EntityTitanFireball(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_, int id) {
        this(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
        this.setFireballID(id);
    }

    public void onImpactPublic(EntityLivingBase movingObject) {
        float f = TheTitans.NightmareMode ? this.impactDamage * 3.0f : this.impactDamage;
        if (movingObject != null && this.shootingEntity != null && this.shootingEntity instanceof EntityLiving && ((EntityLiving)this.shootingEntity).canAttackClass(movingObject.getClass())) {
            if (this.shootingEntity instanceof EntityTitan) {
                ((EntityTitan)this.shootingEntity).attackChoosenEntity((Entity)movingObject, f, 3);
                ((EntityTitan)this.shootingEntity).destroyBlocksInAABB(this.boundingBox.expand((double)(this.explosionRadius - this.width) + 1.0, (double)(this.explosionRadius - this.width) + 1.0, (double)(this.explosionRadius - this.width) + 1.0));
            } else if ((EntityLiving)this.shootingEntity instanceof EntityOverlordScorpion && movingObject.getClass() != (Class)EntityList.stringToClassMapping.get("Emperor Scorpion")) {
                ((EntityLiving)this.shootingEntity).attackEntityAsMob((Entity)movingObject);
            }
            this.playSound("random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
            this.setDead();
        }
    }

    protected void onImpact(MovingObjectPosition movingObject) {
        float f = TheTitans.NightmareMode ? this.impactDamage * 3.0f : this.impactDamage;
        if (!this.worldObj.isRemote) {
            if (movingObject.entityHit != null && movingObject.entityHit instanceof EntityFireball) {
                return;
            }
            if (movingObject.entityHit != null) {
                if (this.shootingEntity != null && this.shootingEntity instanceof EntityLiving && ((EntityLiving)this.shootingEntity).canAttackClass(movingObject.entityHit.getClass())) {
                    if (this.shootingEntity instanceof EntityTitan) {
                        ((EntityTitan)this.shootingEntity).attackChoosenEntity(movingObject.entityHit, f, 3);
                        ((EntityTitan)this.shootingEntity).destroyBlocksInAABB(this.boundingBox.expand((double)(this.explosionRadius - this.width) + 1.0, (double)(this.explosionRadius - this.width) + 1.0, (double)(this.explosionRadius - this.width) + 1.0));
                    } else {
                        if ((EntityLiving)this.shootingEntity instanceof EntityOverlordScorpion && movingObject.entityHit.getClass() != (Class)EntityList.stringToClassMapping.get("Emperor Scorpion")) {
                            ((EntityLiving)this.shootingEntity).attackEntityAsMob(movingObject.entityHit);
                        }
                        if (movingObject.entityHit instanceof EntityTitanPart) {
                            movingObject.entityHit.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.shootingEntity), f);
                        }
                    }
                    this.playSound("random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
                    this.setDead();
                }
            } else {
                if (this.shootingEntity != null && this.shootingEntity instanceof EntityTitan && this.getFireballID() != 6) {
                    ((EntityTitan)this.shootingEntity).destroyBlocksInAABB(this.boundingBox.expand((double)(this.explosionRadius - this.width) + 1.0, (double)(this.explosionRadius - this.width) + 1.0, (double)(this.explosionRadius - this.width) + 1.0));
                }
                if (!this.worldObj.isRemote && this.getFireballID() == 6) {
                    for (int l = 0; l < 128; ++l) {
                        int k;
                        int j;
                        int i = MathHelper.floor_double((double)(this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width));
                        if (this.worldObj.getBlock(i, j = MathHelper.floor_double((double)this.posY), k = MathHelper.floor_double((double)(this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width))).getMaterial() != Material.air || !Blocks.snow_layer.canPlaceBlockAt(this.worldObj, i, j, k)) continue;
                        this.worldObj.setBlock(i, j, k, Blocks.snow_layer);
                    }
                }
                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)(this.shootingEntity != null ? this.shootingEntity : this), this.posX, this.posY, this.posZ, this.explosionRadius, this.canCauseFires ? this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing") : false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                this.setDead();
            }
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(21, (Object)new Integer(0));
    }

    public int getFireballID() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public void setFireballID(int p_82215_1_) {
        this.dataWatcher.updateObject(21, (Object)p_82215_1_);
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger("FireballID", this.getFireballID());
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
        super.readEntityFromNBT(p_70037_1_);
        if (p_70037_1_.hasKey("FireballID", 99)) {
            this.setFireballID(p_70037_1_.getInteger("FireballID"));
        }
    }

    public boolean isBurning() {
        return this.canCauseFires;
    }

    public void setFire(int p_70015_1_) {
        if (this.canCauseFires) {
            super.setFire(p_70015_1_);
        }
    }

    public void onUpdate() {
        if (this.shootingEntity != null) {
            if (this.shootingEntity instanceof EntityGhastTitan) {
                this.setFireballID(0);
            }
            if (this.shootingEntity instanceof EntityCreeperTitan) {
                this.setFireballID(1);
            }
            if (this.shootingEntity instanceof EntityBlazeTitan) {
                this.setFireballID(2);
            }
            if (this.shootingEntity instanceof EntityPigZombieTitan) {
                this.setFireballID(3);
            }
            if (this.shootingEntity instanceof EntityEnderColossus) {
                this.setFireballID(4);
            }
            if (this.shootingEntity instanceof EntityIronGolemTitan) {
                this.setFireballID(5);
            }
            if (this.shootingEntity instanceof EntitySnowGolemTitan) {
                this.setFireballID(6);
            }
        }
        switch (this.getFireballID()) {
            case 1: {
                this.setSize(1.5f, 1.5f);
                this.impactDamage = 200.0f;
                this.canCauseFires = false;
                this.explosionRadius = 3.0f;
                break;
            }
            case 2: {
                this.setSize(2.0f, 2.0f);
                this.impactDamage = 600.0f;
                this.canCauseFires = true;
                this.explosionRadius = 3.0f;
                break;
            }
            case 3: {
                this.setSize(1.5f, 1.5f);
                this.impactDamage = 300.0f;
                this.canCauseFires = true;
                this.explosionRadius = 4.0f;
                break;
            }
            case 4: {
                this.setSize(4.0f, 4.0f);
                this.impactDamage = 1500.0f;
                this.canCauseFires = false;
                this.explosionRadius = 8.0f;
                break;
            }
            case 5: {
                this.setSize(6.0f, 6.0f);
                this.impactDamage = 10000.0f;
                this.canCauseFires = false;
                this.explosionRadius = 12.0f;
                break;
            }
            case 6: {
                this.setSize(2.0f, 2.0f);
                this.impactDamage = 60.0f;
                this.canCauseFires = false;
                this.explosionRadius = 1.0f;
                break;
            }
            default: {
                this.setSize(6.0f, 6.0f);
                this.impactDamage = 10000.0f;
                this.canCauseFires = true;
                this.explosionRadius = 12.0f;
            }
        }
        super.onUpdate();
    }
}

