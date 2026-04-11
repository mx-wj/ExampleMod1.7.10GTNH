/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityBlaze
 *  net.minecraft.entity.monster.EntityCaveSpider
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntityGhast
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntityMagmaCube
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.monster.EntitySilverfish
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.entity.monster.EntitySnowman
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.monster.EntityZombie
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.titan.EntityBlazeTitan;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityGargoyle;
import net.minecraft.entity.titan.EntityGargoyleTitan;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityMagmaCubeTitan;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySlimeTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrowthSerum
extends EntityThrowable {
    public EntityGrowthSerum(World worldIn) {
        super(worldIn);
        this.setSize(0.5f, 0.5f);
    }

    public EntityGrowthSerum(World worldIn, EntityLivingBase p_i1780_2_) {
        super(worldIn, p_i1780_2_);
        this.setSize(0.5f, 0.5f);
    }

    public EntityGrowthSerum(World worldIn, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_) {
        super(worldIn, p_i1781_2_, p_i1781_4_, p_i1781_6_);
        this.setSize(0.5f, 0.5f);
    }

    protected void onImpact(MovingObjectPosition p_70184_1_) {
        if (!this.worldObj.isRemote && p_70184_1_.entityHit != null) {
            if (p_70184_1_.entityHit instanceof EntityTitan) {
                ((EntityTitan)p_70184_1_.entityHit).playSound("random.fizz", 100.0f, 0.5f);
                ((EntityTitan)p_70184_1_.entityHit).heal(50.0f);
                ((EntityTitan)p_70184_1_.entityHit).setInvulTime(((EntityTitan)p_70184_1_.entityHit).getInvulTime() - 50);
            } else if (p_70184_1_.entityHit instanceof EntityZombie) {
                if (p_70184_1_.entityHit instanceof EntityPigZombie) {
                    EntityPigZombieTitan entitychicken = new EntityPigZombieTitan(this.worldObj);
                    entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                    p_70184_1_.entityHit.setDead();
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.0f);
                    entitychicken.func_82206_m();
                    entitychicken.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
                    entitychicken.setChild(((EntityPigZombie)p_70184_1_.entityHit).isChild());
                } else {
                    EntityZombieTitan entitychicken = new EntityZombieTitan(this.worldObj);
                    entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                    p_70184_1_.entityHit.setDead();
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                    entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.func_82206_m();
                    entitychicken.setChild(((EntityZombie)p_70184_1_.entityHit).isChild());
                    entitychicken.setVillager(((EntityZombie)p_70184_1_.entityHit).isVillager());
                }
            } else if (p_70184_1_.entityHit instanceof EntitySkeleton) {
                EntitySkeletonTitan entitychicken = new EntitySkeletonTitan(this.worldObj);
                entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                p_70184_1_.entityHit.setDead();
                entitychicken.setSkeletonType(((EntitySkeleton)p_70184_1_.entityHit).getSkeletonType());
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.func_82206_m();
                if (p_70184_1_.entityHit.ridingEntity != null && p_70184_1_.entityHit.ridingEntity instanceof EntitySpider) {
                    EntitySpiderTitan entitychicken1 = new EntitySpiderTitan(this.worldObj);
                    entitychicken1.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken1);
                    entitychicken.mountEntity((Entity)entitychicken1);
                    p_70184_1_.entityHit.ridingEntity.setDead();
                    entitychicken1.onSpawnWithEgg(null);
                    entitychicken1.func_82206_m();
                }
            } else if (p_70184_1_.entityHit instanceof EntityCreeper) {
                EntityCreeperTitan entitychicken = new EntityCreeperTitan(this.worldObj);
                entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                p_70184_1_.entityHit.setDead();
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.func_82206_m();
                entitychicken.setPowered(((EntityCreeper)p_70184_1_.entityHit).getPowered());
            } else if (p_70184_1_.entityHit instanceof EntityBlaze) {
                EntityBlazeTitan entitychicken = new EntityBlazeTitan(this.worldObj);
                entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                p_70184_1_.entityHit.setDead();
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.entityHit instanceof EntitySpider) {
                if (p_70184_1_.entityHit instanceof EntityCaveSpider) {
                    EntityCaveSpiderTitan entitychicken = new EntityCaveSpiderTitan(this.worldObj);
                    entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                    p_70184_1_.entityHit.setDead();
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                    entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.25f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.func_82206_m();
                } else {
                    EntitySpiderTitan entitychicken = new EntitySpiderTitan(this.worldObj);
                    entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                    p_70184_1_.entityHit.setDead();
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                    entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.25f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.func_82206_m();
                    if (p_70184_1_.entityHit.riddenByEntity != null && p_70184_1_.entityHit.riddenByEntity instanceof EntitySkeleton) {
                        EntitySkeletonTitan entitychicken1 = new EntitySkeletonTitan(this.worldObj);
                        entitychicken1.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                        entitychicken1.setSkeletonType(((EntitySkeleton)p_70184_1_.entityHit.riddenByEntity).getSkeletonType());
                        this.worldObj.spawnEntityInWorld((Entity)entitychicken1);
                        entitychicken1.onSpawnWithEgg(null);
                        entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.0f);
                        entitychicken1.func_82206_m();
                        entitychicken1.mountEntity((Entity)entitychicken);
                        p_70184_1_.entityHit.riddenByEntity.setDead();
                    }
                }
            } else if (p_70184_1_.entityHit instanceof EntityEnderman) {
                EntityEnderColossus entitychicken = new EntityEnderColossus(this.worldObj);
                entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                p_70184_1_.entityHit.setDead();
                entitychicken.onSpawnWithEgg(null);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                entitychicken.playSound("thetitans:titanBirth", 1000.0f, 0.875f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.entityHit instanceof EntityGhast) {
                EntityGhastTitan entitychicken = new EntityGhastTitan(this.worldObj);
                entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                p_70184_1_.entityHit.setDead();
                entitychicken.onSpawnWithEgg(null);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                entitychicken.playSound("thetitans:titanBirth", 1000.0f, 0.875f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.entityHit instanceof EntitySnowman) {
                EntitySnowGolemTitan entitychicken = new EntitySnowGolemTitan(this.worldObj);
                entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                p_70184_1_.entityHit.setDead();
                entitychicken.onSpawnWithEgg(null);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.playSound("random.break", 10000.0f, 0.5f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.entityHit instanceof EntityGargoyle) {
                EntityGargoyleTitan entitychicken = new EntityGargoyleTitan(this.worldObj);
                entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                p_70184_1_.entityHit.setDead();
                entitychicken.onSpawnWithEgg(null);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.playSound("random.break", 10000.0f, 0.5f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.entityHit instanceof EntityIronGolem) {
                EntityIronGolemTitan entitychicken = new EntityIronGolemTitan(this.worldObj);
                entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                p_70184_1_.entityHit.setDead();
                entitychicken.playSound("random.break", 10000.0f, 0.5f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setPlayerCreated(((EntityIronGolem)p_70184_1_.entityHit).isPlayerCreated());
                entitychicken.onSpawnWithEgg(null);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.entityHit instanceof EntitySilverfish) {
                EntitySilverfishTitan entitychicken = new EntitySilverfishTitan(this.worldObj);
                entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                p_70184_1_.entityHit.setDead();
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.25f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.entityHit instanceof EntitySlime) {
                if (p_70184_1_.entityHit instanceof EntityMagmaCube) {
                    EntityMagmaCubeTitan entitychicken = new EntityMagmaCubeTitan(this.worldObj);
                    entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                    p_70184_1_.entityHit.setDead();
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                    entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.5f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.func_82206_m();
                    entitychicken.setSlimeSize(((EntityMagmaCube)p_70184_1_.entityHit).getSlimeSize());
                } else {
                    EntitySlimeTitan entitychicken = new EntitySlimeTitan(this.worldObj);
                    entitychicken.setLocationAndAngles(p_70184_1_.entityHit.posX, p_70184_1_.entityHit.posY, p_70184_1_.entityHit.posZ, p_70184_1_.entityHit.rotationYaw, 0.0f);
                    p_70184_1_.entityHit.setDead();
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("portal.travel", 10000.0f, 1.0f);
                    entitychicken.playSound("thetitans:titanBirth", 1000.0f, 1.5f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.func_82206_m();
                    entitychicken.setSlimeSize(((EntitySlime)p_70184_1_.entityHit).getSlimeSize());
                }
            } else if (p_70184_1_.entityHit instanceof EntityLivingBase) {
                this.playSound("game.player.hurt", 2.0f, 2.0f);
                ((EntityLivingBase)p_70184_1_.entityHit).setFire(20);
                ((EntityLivingBase)p_70184_1_.entityHit).attackEntityFrom(DamageSourceExtra.wip, 2000.0f);
                if (!this.worldObj.isRemote) {
                    this.dropItem(TitanItems.growthSerum, 1);
                }
            }
        }
        if (!this.worldObj.isRemote) {
            if (p_70184_1_.entityHit == null) {
                this.dropItem(TitanItems.growthSerum, 1);
            }
            this.playSound("game.player.hurt", 2.0f, 2.0f);
            this.setDead();
        }
    }
}

