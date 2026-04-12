/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titanminion.EntityGhastGuard;
import net.minecraft.entity.titanminion.EntityGiantZombieBetter;
import net.minecraft.entity.titanminion.EntityPigZombieMinion;
import net.minecraft.entity.titanminion.EntityZombieMinion;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityProtoBall
extends EntityThrowable {
    public EntityProtoBall(World worldIn) {
        super(worldIn);
        this.setSize(3.0f, 3.0f);
        this.motionY += 0.25;
    }

    public EntityProtoBall(World worldIn, EntityLivingBase p_i1780_2_) {
        super(worldIn, p_i1780_2_);
        this.setSize(3.0f, 3.0f);
        this.motionY += 0.25;
    }

    public EntityProtoBall(World worldIn, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_) {
        super(worldIn, p_i1781_2_, p_i1781_4_, p_i1781_6_);
        this.setSize(3.0f, 3.0f);
        this.motionY += 0.25;
    }

    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < 15; ++i) {
            float f = (this.rand.nextFloat() - 0.5f) * this.width;
            float f1 = (this.rand.nextFloat() - 0.5f) * this.height;
            float f2 = (this.rand.nextFloat() - 0.5f) * this.width;
            this.worldObj.spawnParticle("largeexplode", this.posX + (double)f, this.posY + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("explode", this.posX + (double)f, this.posY + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("fire", this.posX + (double)f, this.posY + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("smoke", this.posX + (double)f, this.posY + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("lava", this.posX + (double)f, this.posY + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        }
    }

    protected void onImpact(MovingObjectPosition p_70184_1_) {
        if (!this.worldObj.isRemote) {
            boolean flag;
            boolean flag2;
            if (this.getThrower() != null && this.getThrower() instanceof EntityTitan && p_70184_1_.entityHit != null && p_70184_1_.entityHit instanceof EntityLivingBase) {
                ((EntityTitan)this.getThrower()).attackChoosenEntity(p_70184_1_.entityHit, 75.0f, 2);
            }
            if (this.getThrower() != null && this.getThrower() instanceof EntityPigZombieTitan) {
                if (this.rand.nextInt(5) == 0) {
                    EntityGhastGuard entityGhastGuard = new EntityGhastGuard(this.worldObj);
                    entityGhastGuard.setLocationAndAngles(this.posX, this.posY, this.posZ, -this.rotationYaw, -this.rotationPitch);
                    this.worldObj.spawnEntityInWorld((Entity)entityGhastGuard);
                    entityGhastGuard.onSpawnWithEgg(null);
                    entityGhastGuard.motionY += 1.0;
                    flag2 = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                    net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)entityGhastGuard, entityGhastGuard.posX, entityGhastGuard.posY + 6.0, entityGhastGuard.posZ, 12.0f, false, flag2);
                    entityGhastGuard.master = (EntityPigZombieTitan)this.getThrower();
                } else {
                    switch (this.rand.nextInt(4)) {
                        case 0: {
                            for (int l1 = 0; l1 <= 5; ++l1) {
                                EntityPigZombieMinion entitychicken2 = new EntityPigZombieMinion(this.worldObj);
                                entitychicken2.setLocationAndAngles(this.posX, this.posY, this.posZ, -this.rotationYaw, -this.rotationPitch);
                                this.worldObj.spawnEntityInWorld((Entity)entitychicken2);
                                entitychicken2.onSpawnWithEgg(null);
                                entitychicken2.setMinionType(3);
                                flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)entitychicken2, entitychicken2.posX, entitychicken2.posY + 2.0, entitychicken2.posZ, 6.0f, false, flag);
                                entitychicken2.master = (EntityPigZombieTitan)this.getThrower();
                            }
                            break;
                        }
                        case 1: {
                            for (int l1 = 0; l1 <= 10; ++l1) {
                                EntityPigZombieMinion entitychicken3 = new EntityPigZombieMinion(this.worldObj);
                                entitychicken3.setLocationAndAngles(this.posX, this.posY, this.posZ, -this.rotationYaw, -this.rotationPitch);
                                this.worldObj.spawnEntityInWorld((Entity)entitychicken3);
                                entitychicken3.onSpawnWithEgg(null);
                                entitychicken3.setMinionType(2);
                                flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)entitychicken3, entitychicken3.posX, entitychicken3.posY + 2.0, entitychicken3.posZ, 4.0f, false, flag);
                                entitychicken3.master = (EntityPigZombieTitan)this.getThrower();
                            }
                            break;
                        }
                        case 2: {
                            for (int l1 = 0; l1 <= 20; ++l1) {
                                EntityPigZombieMinion entitychicken4 = new EntityPigZombieMinion(this.worldObj);
                                entitychicken4.setLocationAndAngles(this.posX, this.posY, this.posZ, -this.rotationYaw, -this.rotationPitch);
                                this.worldObj.spawnEntityInWorld((Entity)entitychicken4);
                                entitychicken4.onSpawnWithEgg(null);
                                entitychicken4.setMinionType(1);
                                flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)entitychicken4, entitychicken4.posX, entitychicken4.posY + 2.0, entitychicken4.posZ, 3.0f, false, flag);
                                entitychicken4.master = (EntityPigZombieTitan)this.getThrower();
                            }
                            break;
                        }
                        case 3: {
                            for (int l1 = 0; l1 <= 40; ++l1) {
                                EntityPigZombieMinion entitychicken5 = new EntityPigZombieMinion(this.worldObj);
                                entitychicken5.setLocationAndAngles(this.posX, this.posY, this.posZ, -this.rotationYaw, -this.rotationPitch);
                                this.worldObj.spawnEntityInWorld((Entity)entitychicken5);
                                entitychicken5.onSpawnWithEgg(null);
                                entitychicken5.setMinionType(0);
                                flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)entitychicken5, entitychicken5.posX, entitychicken5.posY + 2.0, entitychicken5.posZ, 2.0f, false, flag);
                                entitychicken5.master = (EntityPigZombieTitan)this.getThrower();
                            }
                            break;
                        }
                    }
                }
            }
            if (this.getThrower() != null && this.getThrower() instanceof EntityZombieTitan) {
                if (this.rand.nextInt(5) == 0) {
                    EntityGiantZombieBetter entityGiantZombie = new EntityGiantZombieBetter(this.worldObj);
                    entityGiantZombie.setLocationAndAngles(this.posX, this.posY, this.posZ, -this.rotationYaw, -this.rotationPitch);
                    this.worldObj.spawnEntityInWorld((Entity)entityGiantZombie);
                    entityGiantZombie.onSpawnWithEgg(null);
                    flag2 = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                    net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)entityGiantZombie, entityGiantZombie.posX, entityGiantZombie.posY + 6.0, entityGiantZombie.posZ, 12.0f, false, flag2);
                    entityGiantZombie.master = (EntityZombieTitan)this.getThrower();
                } else {
                    switch (this.rand.nextInt(4)) {
                        case 0: {
                            for (int l1 = 0; l1 <= 5; ++l1) {
                                EntityZombieMinion entitychicken6 = new EntityZombieMinion(this.worldObj);
                                entitychicken6.setLocationAndAngles(this.posX, this.posY, this.posZ, -this.rotationYaw, -this.rotationPitch);
                                this.worldObj.spawnEntityInWorld((Entity)entitychicken6);
                                entitychicken6.onSpawnWithEgg(null);
                                entitychicken6.setMinionType(3);
                                flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)entitychicken6, entitychicken6.posX, entitychicken6.posY + 2.0, entitychicken6.posZ, 6.0f, false, flag);
                                entitychicken6.master = (EntityZombieTitan)this.getThrower();
                            }
                            break;
                        }
                        case 1: {
                            for (int l1 = 0; l1 <= 10; ++l1) {
                                EntityZombieMinion entitychicken7 = new EntityZombieMinion(this.worldObj);
                                entitychicken7.setLocationAndAngles(this.posX, this.posY, this.posZ, -this.rotationYaw, -this.rotationPitch);
                                this.worldObj.spawnEntityInWorld((Entity)entitychicken7);
                                entitychicken7.onSpawnWithEgg(null);
                                entitychicken7.setMinionType(2);
                                flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)entitychicken7, entitychicken7.posX, entitychicken7.posY + 2.0, entitychicken7.posZ, 4.0f, false, flag);
                                entitychicken7.master = (EntityZombieTitan)this.getThrower();
                            }
                            break;
                        }
                        case 2: {
                            for (int l1 = 0; l1 <= 20; ++l1) {
                                EntityZombieMinion entitychicken8 = new EntityZombieMinion(this.worldObj);
                                entitychicken8.setLocationAndAngles(this.posX, this.posY, this.posZ, -this.rotationYaw, -this.rotationPitch);
                                this.worldObj.spawnEntityInWorld((Entity)entitychicken8);
                                entitychicken8.onSpawnWithEgg(null);
                                entitychicken8.setMinionType(1);
                                flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)entitychicken8, entitychicken8.posX, entitychicken8.posY + 2.0, entitychicken8.posZ, 3.0f, false, flag);
                                entitychicken8.master = (EntityZombieTitan)this.getThrower();
                            }
                            break;
                        }
                        case 3: {
                            for (int l1 = 0; l1 <= 40; ++l1) {
                                EntityZombieMinion entitychicken9 = new EntityZombieMinion(this.worldObj);
                                entitychicken9.setLocationAndAngles(this.posX, this.posY, this.posZ, -this.rotationYaw, -this.rotationPitch);
                                this.worldObj.spawnEntityInWorld((Entity)entitychicken9);
                                entitychicken9.onSpawnWithEgg(null);
                                entitychicken9.setMinionType(0);
                                flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)entitychicken9, entitychicken9.posX, entitychicken9.posY + 2.0, entitychicken9.posZ, 2.0f, false, flag);
                                entitychicken9.master = (EntityZombieTitan)this.getThrower();
                            }
                            break;
                        }
                    }
                }
            }
        }
        this.setDead();
    }
}

