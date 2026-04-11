/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSilverfish
 *  net.minecraft.block.material.Material
 *  net.minecraft.command.IEntitySelector
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIArrowAttack
 *  net.minecraft.entity.ai.EntityAIAttackOnCollide
 *  net.minecraft.entity.ai.EntityAIAvoidEntity
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveTowardsRestriction
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.ai.RandomPositionGenerator
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityWither
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntityBlaze
 *  net.minecraft.entity.monster.EntityCaveSpider
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntityGhast
 *  net.minecraft.entity.monster.EntityGolem
 *  net.minecraft.entity.monster.EntityMagmaCube
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.monster.EntitySilverfish
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.monster.EntityZombie
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.passive.EntityWaterMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityPotion
 *  net.minecraft.entity.projectile.EntitySmallFireball
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  org.apache.commons.lang3.tuple.ImmutablePair
 */
package net.minecraft.entity.titanminion;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EntityWitherzillaMinion;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAIBreakDoorMinion;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.IMinion;
import net.minecraft.entity.titanminion.ITemplar;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class EntitySilverfishMinion
extends EntitySilverfish
implements IRangedAttackMob,
ITemplar {
    public EntityLiving master;
    public boolean isMasterSubdued;
    public int randomSoundDelay;
    private int attackPattern;
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 10, 64.0f);
    private float heightOffset = 0.5f;
    private int heightOffsetUpdateTime;
    public EntityLiving entityToHeal;
    public IEntitySelector allowPlayerPresence = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return p_179983_1_ instanceof EntityWitherzilla || p_179983_1_ instanceof EntityWitherzillaMinion || p_179983_1_ instanceof EntityAnimal || p_179983_1_ instanceof EntityGolem || p_179983_1_ instanceof EntityAgeable || p_179983_1_ instanceof EntityPlayer || p_179983_1_ instanceof EntityAmbientCreature || p_179983_1_ instanceof EntityWaterMob || p_179983_1_ instanceof EntityTameable || !(p_179983_1_ instanceof EntityDragon) && !(p_179983_1_ instanceof EntityBlaze) && !(p_179983_1_ instanceof EntityCaveSpider) && !(p_179983_1_ instanceof EntityCreeper) && !(p_179983_1_ instanceof EntityEnderman) && !(p_179983_1_ instanceof EntityPigZombie) && !(p_179983_1_ instanceof EntitySilverfish) && !(p_179983_1_ instanceof EntitySkeleton) && !(p_179983_1_ instanceof EntitySpider) && !(p_179983_1_ instanceof EntityWither) && !(p_179983_1_ instanceof EntityZombie) && !(p_179983_1_ instanceof EntityTitan) && !(p_179983_1_ instanceof EntityGhast) && !(p_179983_1_ instanceof EntityMagmaCube) && !(p_179983_1_ instanceof EntitySlime) && !(p_179983_1_ instanceof IMinion) && !(p_179983_1_ instanceof EntityTitanSpirit) && !(p_179983_1_ instanceof EntityEnderColossusCrystal) && !(p_179983_1_ instanceof EntityPlayer);
        }
    };
    public int deathTicks;

    public EntitySilverfishMinion(World worldIn) {
        super(worldIn);
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setEnterDoors(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityWitherSkull.class, 2.0f, 1.2, 1.75));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityTitanSpirit.class, 48.0f, 1.5, 1.5));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIBreakDoorMinion((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.2));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIFindEntityNearestInjuredAlly(this));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, EntityLivingBase.class, 1.0, true));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.8));
        this.tasks.addTask(9, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        if (this.isMasterSubdued) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, true, this.allowPlayerPresence));
        } else if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, false, ITitan.SilverfishTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
    }

    public void setDead() {
        super.setDead();
        if (this.master != null && this.master instanceof EntityTitan) {
            ((EntityTitan)this.master).retractMinionNumFromType(this.getMinionType());
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean isPotionApplicable(PotionEffect p_70687_1_) {
        return p_70687_1_.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(p_70687_1_);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != EntitySilverfishMinion.class && p_70686_1_ != EntitySilverfishTitan.class;
    }

    protected void fall(float p_70069_1_) {
        if (this.getMinionTypeInt() != 4) {
            super.fall(p_70069_1_);
        }
        this.moveForward = 0.0f;
        this.moveStrafing = 0.0f;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(19, (Object)0);
    }

    public void setCombatTask() {
        this.tasks.removeTask((EntityAIBase)this.aiArrowAttack);
        if (this.attackPattern == 0 && this.getMinionTypeInt() == 4) {
            this.tasks.addTask(0, (EntityAIBase)this.aiArrowAttack);
        }
    }

    protected String getLivingSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanSilverfishLiving" : "mob.silverfish.say";
    }

    protected String getHurtSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanSilverfishGrunt" : "mob.silverfish.hit";
    }

    protected String getDeathSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanSilverfishDeath" : "mob.silverfish.kill";
    }

    protected float getSoundPitch() {
        return this.getMinionTypeInt() == 4 ? super.getSoundPitch() + 0.3f : super.getSoundPitch();
    }

    protected float applyPotionDamageCalculations(DamageSource p_70672_1_, float p_70672_2_) {
        if (this.getMinionTypeInt() == 4) {
            p_70672_2_ = super.applyPotionDamageCalculations(p_70672_1_, p_70672_2_);
            if (p_70672_1_.getEntity() == this) {
                p_70672_2_ = 0.0f;
            }
            if (p_70672_1_.isMagicDamage()) {
                p_70672_2_ = (float)((double)p_70672_2_ * 0.15);
            }
            return p_70672_2_;
        }
        return super.applyPotionDamageCalculations(p_70672_1_, p_70672_2_);
    }

    public int getTotalArmorValue() {
        switch (this.getMinionTypeInt()) {
            case 1: {
                return 2;
            }
            case 2: {
                return 15;
            }
            case 3: {
                return 18;
            }
            case 4: {
                return 22;
            }
        }
        return 0;
    }

    public int getMinionTypeInt() {
        return this.dataWatcher.getWatchableObjectInt(19);
    }

    @Override
    public EnumMinionType getMinionType() {
        switch (this.getMinionTypeInt()) {
            case 1: {
                return EnumMinionType.PRIEST;
            }
            case 2: {
                return EnumMinionType.ZEALOT;
            }
            case 3: {
                return EnumMinionType.BISHOP;
            }
            case 4: {
                return EnumMinionType.TEMPLAR;
            }
        }
        return EnumMinionType.LOYALIST;
    }

    public void setMinionType(int miniontype) {
        this.dataWatcher.updateObject(19, (Object)miniontype);
        if (miniontype == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0);
            this.setHealth(16.0f);
            this.experienceValue = 15;
        } else if (miniontype == 2) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
            this.setHealth(60.0f);
            this.experienceValue = 100;
        } else if (miniontype == 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0);
            this.isImmuneToFire = true;
            this.setHealth(200.0f);
            this.experienceValue = 200;
        } else if (miniontype == 4) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30.0);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            this.isImmuneToFire = true;
            this.setHealth(1000.0f);
            this.experienceValue = 1000;
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
            this.setHealth(10.0f);
            this.experienceValue = 6;
        }
    }

    public boolean attackEntityAsMob(Entity p_70652_1_) {
        if (super.attackEntityAsMob(p_70652_1_)) {
            if (p_70652_1_ instanceof EntityLivingBase && this.getMinionTypeInt() >= 3) {
                int b0 = 10;
                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                    b0 = 20;
                } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                    b0 = 30;
                }
                if (b0 > 0) {
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(ClientProxy.electricJudgment.id, b0 * 20, 0));
                }
            }
            return true;
        }
        return false;
    }

    public void onLivingUpdate() {
        EntitySilverfishMinion entitychicken;
        if (this.getMinionTypeInt() == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0);
            this.experienceValue = 15;
        } else if (this.getMinionTypeInt() == 2) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
            this.experienceValue = 100;
        } else if (this.getMinionTypeInt() == 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0);
            this.isImmuneToFire = true;
            this.experienceValue = 200;
        } else if (this.getMinionTypeInt() == 4) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30.0);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            this.isImmuneToFire = true;
            this.experienceValue = 1000;
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
            this.experienceValue = 6;
        }
        if (this.isEntityAlive() || this.getMinionTypeInt() != 4) {
            super.onLivingUpdate();
        }
        if (this.getMinionTypeInt() == 3) {
            if (this.rand.nextInt(120) == 0 && this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                entitychicken = new EntitySilverfishMinion(this.worldObj);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(0);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            }
            if (this.rand.nextInt(240) == 0 && this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                entitychicken = new EntitySilverfishMinion(this.worldObj);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(1);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            }
        }
        if (this.onGround && this.isCollidedHorizontally) {
            this.jump();
        }
        if (this.getMinionTypeInt() == 4) {
            if (this.ticksExisted % 40 == 0) {
                this.heal(1.0f);
            }
            if (this.worldObj.rand.nextInt(150) == 1) {
                this.heal(2.0f);
            }
            if (this.worldObj.rand.nextInt(100) == 1 && (double)this.getHealth() < (double)this.getMaxHealth() * 0.75) {
                this.heal(2.0f);
            }
            if (this.worldObj.rand.nextInt(35) == 1 && (double)this.getHealth() < (double)this.getMaxHealth() * 0.5) {
                this.heal(5.0f);
            }
            if (this.worldObj.rand.nextInt(30) == 1 && (double)this.getHealth() < (double)this.getMaxHealth() * 0.25) {
                this.heal(5.0f);
            }
            if (this.worldObj.rand.nextInt(30) == 1 && (double)this.getHealth() < (double)this.getMaxHealth() * 0.05) {
                this.heal(200.0f);
            }
            if (!this.onGround && this.motionY < 0.0) {
                this.motionY *= 0.6;
            }
            if (this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.rand.nextInt(60) == 0) {
                    entitychicken = new EntitySilverfishMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
                if (this.rand.nextInt(120) == 0) {
                    entitychicken = new EntitySilverfishMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(1);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
                if (this.rand.nextInt(240) == 0) {
                    entitychicken = new EntitySilverfishMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(2);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
            }
            if (this.worldObj.isRemote && !this.onGround) {
                for (int i = 0; i < 3; ++i) {
                    this.worldObj.spawnParticle("explode", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                }
            }
            if (this.rand.nextInt(60) == 0 && this.getAttackTarget() != null) {
                this.setCombatTask();
                this.attackPattern = !this.onGround ? 0 : 1;
            }
            --this.heightOffsetUpdateTime;
            if (this.heightOffsetUpdateTime <= 0) {
                this.jump();
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5f + (float)this.rand.nextGaussian() * 3.0f;
                this.attackPattern = 0;
            }
            EntityLivingBase entitylivingbase = this.getAttackTarget();
            if (this.attackPattern == 0 && entitylivingbase != null && !this.worldObj.isRemote) {
                if (entitylivingbase.posY + (double)entitylivingbase.getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset) {
                    this.motionY += 0.4 - this.motionY;
                    this.isAirBorne = true;
                }
                this.getLookHelper().setLookPositionWithEntity((Entity)entitylivingbase, 180.0f, 40.0f);
                double d0 = entitylivingbase.posX - this.posX;
                double d1 = entitylivingbase.posZ - this.posZ;
                double d3 = d0 * d0 + d1 * d1;
                if (d3 > (double)(entitylivingbase.width * entitylivingbase.width + this.width * this.width) + 16.0) {
                    double d5 = MathHelper.sqrt_double((double)d3);
                    this.motionX += d0 / d5 * 0.6 - this.motionX;
                    this.motionZ += d1 / d5 * 0.6 - this.motionZ;
                }
            }
            if (this.isEntityAlive() && !this.worldObj.isRemote && this.rand.nextInt(1000) == 0 && this.getAttackTarget() != null && this.getHealth() < this.getMaxHealth() / 2.0f && this.master == null) {
                for (int i = 0; i < 16; ++i) {
                    this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                }
                this.playSound("thetitans:titanland", 10000.0f, 1.0f);
                this.TransformEntity((Entity)this);
            }
            if (this.onGround) {
                this.isAirBorne = false;
            }
            List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(8.0, 8.0, 8.0));
            if (!this.worldObj.isRemote && list11 != null && !list11.isEmpty() && this.ticksExisted % (this.getHealth() < this.getMaxHealth() / 2.0f ? 40 : 160) == 0) {
                this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 8.0f, false);
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity = (Entity)list11.get(i1);
                    if (entity == null || !(entity instanceof EntityLivingBase) || !this.canAttackClass(entity.getClass())) continue;
                    entity.motionY += this.rand.nextDouble();
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(ClientProxy.electricJudgment.id, 10, 1));
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1017, (int)entity.posX, (int)entity.posY, (int)entity.posZ, 0);
                }
            }
        }
        if (this.getMinionTypeInt() == 2 && this.getAttackTarget() != null) {
            double d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
            if (d0 < 4.0) {
                this.swingItem();
                this.attackEntityAsMob((Entity)this.getAttackTarget());
            }
            if (this.rand.nextInt(40) == 0 && this.onGround && d0 < 256.0 && this.getAttackTarget().posY > this.posY + 3.0) {
                this.addPotionEffect(new PotionEffect(Potion.jump.id, 60, 7));
                this.faceEntity((Entity)this.getAttackTarget(), 180.0f, 180.0f);
                double d01 = this.getAttackTarget().posX - this.posX;
                double d1 = this.getAttackTarget().posZ - this.posZ;
                float f2 = MathHelper.sqrt_double((double)(d01 * d01 + d1 * d1));
                this.jump();
                this.motionX = d01 / (double)f2 * 0.75 * 0.75 + this.motionX * 0.75;
                this.motionZ = d1 / (double)f2 * 0.75 * 0.75 + this.motionZ * 0.75;
            }
        }
        if (this.getMinionTypeInt() == 1 && this.ticksExisted % 40 == 0 && this.entityToHeal != null) {
            if (this.entityToHeal.getHealth() < this.entityToHeal.getMaxHealth()) {
                this.swingItem();
                this.faceEntity((Entity)this.entityToHeal, 180.0f, this.getVerticalFaceSpeed());
                this.entityToHeal.heal(4.0f);
                this.playSound("mob.wither.shoot", 1.0f, 3.0f);
            } else {
                this.entityToHeal = null;
            }
        }
        if (this.getAttackTarget() != null && !this.getAttackTarget().isEntityAlive()) {
            this.setAttackTarget(null);
        }
        if (this.master != null) {
            if (this.getDistanceSqToEntity((Entity)this.master) > 2304.0) {
                this.getMoveHelper().setMoveTo(this.master.posX, this.master.posY, this.master.posZ, 2.0);
            }
            if (this.master.getAttackTarget() != null) {
                if (this.master.getAttackTarget().height < 6.0f) {
                    this.setAttackTarget(this.master.getAttackTarget());
                } else {
                    this.getLookHelper().setLookPositionWithEntity((Entity)this.master.getAttackTarget(), 10.0f, 40.0f);
                }
            }
            if (((EntitySilverfishTitan)this.master).isSubdued && this.getAttackTarget() instanceof EntityPlayer) {
                this.setAttackTarget(null);
                this.isMasterSubdued = true;
            }
        } else {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
            if (list != null && !list.isEmpty()) {
                for (int i11 = 0; i11 < list.size(); ++i11) {
                    Entity entity = (Entity)list.get(i11);
                    if (entity == null || !(entity instanceof EntitySilverfishTitan)) continue;
                    this.master = (EntitySilverfishTitan)entity;
                }
            }
        }
    }

    @Override
    public void TransformEntity(Entity entity) {
        entity.worldObj.newExplosion(entity, entity.posX, entity.posY, entity.posZ, 18.0f, true, entity.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        EntitySilverfishTitan entitytitan = new EntitySilverfishTitan(entity.worldObj);
        entitytitan.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, 0.0f);
        entity.setDead();
        entitytitan.func_82206_m();
        entity.worldObj.spawnEntityInWorld((Entity)entitytitan);
    }

    public String getCommandSenderName() {
        switch (this.getMinionTypeInt()) {
            case 1: {
                return StatCollector.translateToLocal((String)"entity.SilverfishPriest.name");
            }
            case 2: {
                return StatCollector.translateToLocal((String)"entity.SilverfishZealot.name");
            }
            case 3: {
                return StatCollector.translateToLocal((String)"entity.SilverfishBishop.name");
            }
            case 4: {
                return StatCollector.translateToLocal((String)"entity.SilverfishTemplar.name");
            }
        }
        return StatCollector.translateToLocal((String)"entity.SilverfishLoyalist.name");
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("MinionType", this.getMinionTypeInt());
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.setMinionType(tagCompund.getInteger("MinionType"));
    }

    protected Item getDropItem() {
        return Items.paper;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int k;
        Item item = this.getDropItem();
        int j = this.rand.nextInt(2);
        if (p_70628_2_ > 0) {
            j += this.rand.nextInt(p_70628_2_ + 1);
        }
        for (k = 0; k < j; ++k) {
            this.dropItem(item, 1);
        }
        if (this.rand.nextInt(30) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0) {
            this.entityDropItem(new ItemStack(Blocks.stone), 0.0f);
        }
        if (this.getMinionTypeInt() >= 1) {
            j = this.rand.nextInt(2);
            if (p_70628_2_ > 0) {
                j += this.rand.nextInt(p_70628_2_ + 1);
            }
            for (k = 0; k < j; ++k) {
                this.dropItem(Items.experience_bottle, 1);
            }
            if (this.getMinionTypeInt() >= 2) {
                j = this.rand.nextInt(2);
                if (p_70628_2_ > 0) {
                    j += this.rand.nextInt(p_70628_2_ + 1);
                }
                for (k = 0; k < j; ++k) {
                    this.dropItem(Items.golden_apple, 1);
                }
                if (this.getMinionTypeInt() >= 3) {
                    j = this.rand.nextInt(2);
                    if (p_70628_2_ > 0) {
                        j += this.rand.nextInt(p_70628_2_ + 1);
                    }
                    block15: for (k = 0; k < j; ++k) {
                        switch (this.rand.nextInt(5)) {
                            case 0: {
                                this.dropItem(Items.emerald, 1);
                                continue block15;
                            }
                            case 1: {
                                this.dropItem(Items.diamond, 1);
                                continue block15;
                            }
                            case 2: {
                                this.dropItem(Items.gold_ingot, 1);
                                continue block15;
                            }
                            case 3: {
                                this.dropItem(Items.gold_ingot, 1);
                                continue block15;
                            }
                            case 4: {
                                this.dropItem(Items.gold_ingot, 1);
                            }
                        }
                    }
                    if (this.getMinionTypeInt() >= 4) {
                        if (this.rand.nextInt(5) == 0) {
                            this.entityDropItem(new ItemStack(TitanItems.pleasantBladeSeed), 0.0f);
                        }
                        if (this.rand.nextInt(100) == 0) {
                            this.entityDropItem(new ItemStack(TitanItems.malgrumSeeds), 0.0f);
                        }
                        j = 2 + this.rand.nextInt(5);
                        if (p_70628_2_ > 0) {
                            j += this.rand.nextInt(p_70628_2_ + 1);
                        }
                        block16: for (k = 0; k < j; ++k) {
                            switch (this.rand.nextInt(3)) {
                                case 0: {
                                    this.dropItem(Items.emerald, 1);
                                    continue block16;
                                }
                                case 1: {
                                    this.dropItem(Items.diamond, 1);
                                    continue block16;
                                }
                                case 2: {
                                    this.dropItem(Items.gold_ingot, 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable() || this.getMinionTypeInt() >= 4 && source == DamageSourceExtra.radiation) {
            return false;
        }
        if (source.getEntity() instanceof EntitySilverfishMinion || source.getEntity() instanceof EntitySilverfishTitan) {
            return false;
        }
        if (source.getEntity() != null && this.moveStrafing == 0.0f && this.getMinionType() == EnumMinionType.ZEALOT) {
            this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
            this.playSound("thetitans:titanSwing", 1.0f, 2.0f);
            switch (this.rand.nextInt(3)) {
                case 0: {
                    this.moveForward = -2.0f;
                    this.moveFlying(0.0f, -2.0f, 0.99f);
                    this.moveStrafing = 0.01f;
                    break;
                }
                case 1: {
                    this.moveStrafing = 1.0f;
                    this.moveFlying(1.0f, 0.0f, 0.25f);
                    break;
                }
                case 2: {
                    this.moveStrafing = -1.0f;
                    this.moveFlying(-1.0f, 0.0f, 0.25f);
                }
            }
            this.jump();
            return false;
        }
        Entity entity = source.getEntity();
        if (entity instanceof EntityLivingBase) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(32.0, 32.0, 32.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1 instanceof EntitySilverfishMinion) {
                    EntitySilverfishMinion entitypigzombie = (EntitySilverfishMinion)entity1;
                    entitypigzombie.setAttackTarget((EntityLivingBase)entity);
                    entitypigzombie.setRevengeTarget((EntityLivingBase)entity);
                    entitypigzombie.randomSoundDelay = this.rand.nextInt(40);
                }
                this.setAttackTarget((EntityLivingBase)entity);
                this.setRevengeTarget((EntityLivingBase)entity);
                this.randomSoundDelay = this.rand.nextInt(40);
            }
        }
        return super.attackEntityFrom(source, amount);
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.swingItem();
        if (this.getDistanceSqToEntity((Entity)p_82196_1_) < (double)(p_82196_1_.width * p_82196_1_.width) + 36.0) {
            this.attackEntityAsMob((Entity)p_82196_1_);
        } else {
            switch (this.rand.nextInt(4)) {
                case 0: {
                    EntityArrow entityarrow = new EntityArrow(this.worldObj, (EntityLivingBase)this, p_82196_1_, 1.6f, 1.0f);
                    entityarrow.setIsCritical(true);
                    entityarrow.setDamage((double)(p_82196_2_ * 2.0f) + this.rand.nextGaussian() * 0.25 + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11f));
                    this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                    this.worldObj.spawnEntityInWorld((Entity)entityarrow);
                    break;
                }
                case 1: {
                    EntityPotion entitypotion = new EntityPotion(this.worldObj, (EntityLivingBase)this, 32732);
                    if (p_82196_1_.isEntityUndead()) {
                        entitypotion.setPotionDamage(32725);
                    }
                    double d0 = p_82196_1_.posY + 0.5;
                    entitypotion.rotationPitch -= -20.0f;
                    double d1 = p_82196_1_.posX + p_82196_1_.motionX - this.posX;
                    double d2 = d0 - this.posY;
                    double d3 = p_82196_1_.posZ + p_82196_1_.motionZ - this.posZ;
                    float f1 = MathHelper.sqrt_double((double)(d1 * d1 + d3 * d3));
                    entitypotion.setThrowableHeading(d1, d2 + (double)(f1 * 0.2f), d3, 1.0f, f1 / 20.0f);
                    this.worldObj.spawnEntityInWorld((Entity)entitypotion);
                    break;
                }
                case 2: {
                    double d01 = this.getDistanceSqToEntity((Entity)p_82196_1_);
                    double d11 = p_82196_1_.posX - this.posX;
                    double d21 = p_82196_1_.boundingBox.minY + (double)(p_82196_1_.height / 2.0f) - (this.posY + (double)(p_82196_1_.height / 2.0f));
                    double d31 = p_82196_1_.posZ - this.posZ;
                    float f = MathHelper.sqrt_float((float)MathHelper.sqrt_double((double)d01)) * 0.1f;
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, d11 + this.getRNG().nextGaussian() * (double)f, d21, d31 + this.getRNG().nextGaussian() * (double)f);
                    entitysmallfireball.posY = this.posY + (double)this.height + 0.4;
                    this.worldObj.spawnEntityInWorld((Entity)entitysmallfireball);
                    break;
                }
                case 3: {
                    p_82196_1_.attackEntityFrom(DamageSource.magic, 10.0f);
                    this.playSound("mob.wither.shoot", 1.0f, 3.0f);
                    int i = MathHelper.floor_double((double)(p_82196_1_.posX + this.rand.nextDouble()));
                    int j = MathHelper.floor_double((double)(p_82196_1_.posY + this.rand.nextDouble()));
                    int k = MathHelper.floor_double((double)(p_82196_1_.posZ + this.rand.nextDouble()));
                    Block block = this.worldObj.getBlock(i, j, k);
                    if (block.getMaterial() != Material.air) break;
                    this.worldObj.setBlock(i, j, k, Blocks.monster_egg);
                }
            }
        }
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_180482_2_) {
        IEntityLivingData p_180482_2_1 = super.onSpawnWithEgg(p_180482_2_);
        if (!this.worldObj.isRemote) {
            this.setMinionType(0);
            if (this.rand.nextInt(2) == 0) {
                this.setMinionType(1);
                if (this.rand.nextInt(2) == 0) {
                    this.setMinionType(2);
                    if (this.rand.nextInt(2) == 0) {
                        this.setMinionType(3);
                        if (this.rand.nextInt(2) == 0) {
                            this.setMinionType(4);
                        }
                    }
                }
            }
        }
        return p_180482_2_1;
    }

    protected void updateAITasks() {
        EntityLivingBase e;
        this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.playSound(this.getHurtSound(), this.getSoundVolume(), this.getSoundPitch() + 0.25f);
        }
        if (this.getAttackTarget() != null && this.worldObj.rand.nextInt(5) == 1 && (e = this.getAttackTarget()) != null && this.getDistanceSqToEntity((Entity)e) < (double)(this.width * this.width + e.width * e.width) + 4.0 && (this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(2) == 1)) {
            this.attackEntityAsMob((Entity)e);
        }
        if (this.hurtResistantTime == 1) {
            int i = MathHelper.floor_double((double)this.posX);
            int j = MathHelper.floor_double((double)this.posY);
            int k = MathHelper.floor_double((double)this.posZ);
            boolean flag = false;
            int l = 0;
            while (!flag && l <= 10 && l >= -10) {
                int i1 = 0;
                while (!flag && i1 <= 10 && i1 >= -10) {
                    int j1 = 0;
                    while (!flag && j1 <= 10 && j1 >= -10) {
                        if (this.worldObj.getBlock(i + i1, j + l, k + j1) == Blocks.monster_egg) {
                            if (!this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                                int k1 = this.worldObj.getBlockMetadata(i + i1, j + l, k + j1);
                                ImmutablePair immutablepair = BlockSilverfish.func_150197_b((int)k1);
                                this.worldObj.setBlock(i + i1, j + l, k + j1, (Block)immutablepair.getLeft(), ((Integer)immutablepair.getRight()).intValue(), 3);
                            } else {
                                this.worldObj.func_147480_a(i + i1, j + l, k + j1, false);
                            }
                            EntitySilverfishMinion entitysilverfish = new EntitySilverfishMinion(this.worldObj);
                            entitysilverfish.setLocationAndAngles((double)(i + i1) + 0.5, j + l, (double)(k + j1) + 0.5, 0.0f, 0.0f);
                            entitysilverfish.onSpawnWithEgg(null);
                            if (!this.worldObj.isRemote) {
                                this.worldObj.spawnEntityInWorld((Entity)entitysilverfish);
                            }
                            this.worldObj.createExplosion((Entity)entitysilverfish, entitysilverfish.posX, entitysilverfish.posY, entitysilverfish.posZ, 2.0f, false);
                            entitysilverfish.spawnExplosionParticle();
                            this.worldObj.setBlockToAir(i + i1, j + l, k + j1);
                            if (this.rand.nextBoolean()) {
                                flag = true;
                                break;
                            }
                        }
                        j1 = j1 <= 0 ? 1 - j1 : 0 - j1;
                    }
                    i1 = i1 <= 0 ? 1 - i1 : 0 - i1;
                }
                l = l <= 0 ? 1 - l : 0 - l;
            }
        }
        if (this.isCollidedHorizontally && this.master != null) {
            this.motionY = 0.2;
        }
        super.updateAITasks();
    }

    public void moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
        if (this.deathTicks > 0) {
            super.moveEntity(0.0, (double)0.1f, 0.0);
        } else {
            super.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
        }
    }

    protected void onDeathUpdate() {
        if (this.getMinionTypeInt() == 4) {
            float f1;
            --this.ticksExisted;
            ++this.deathTicks;
            if (this.master != null) {
                double mx = this.posX - this.master.posX;
                double my = this.posY + (double)this.getEyeHeight() - (this.master.posY + (double)this.master.getEyeHeight());
                double mz = this.posZ - this.master.posZ;
                int short1 = (int)(this.getDistanceToEntity((Entity)this.master) * 2.0f);
                for (int f = 0; f < short1; ++f) {
                    double d9 = (double)f / ((double)short1 - 1.0);
                    double d6 = this.posX + mx * -d9;
                    double d7 = this.posY + (double)this.getEyeHeight() + my * -d9;
                    double d8 = this.posZ + mz * -d9;
                    this.worldObj.spawnParticle("fireworksSpark", d6, d7, d8, this.master.motionX, this.master.motionY + 0.2, this.master.motionZ);
                }
            }
            if (!this.worldObj.isRemote) {
                if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                    this.dropFewItems(true, 0);
                }
                if (this.deathTicks == 1) {
                    this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                }
            }
            if (this.deathTicks >= 180 && this.deathTicks <= 200) {
                float f = (this.rand.nextFloat() - 0.5f) * this.width;
                f1 = (this.rand.nextFloat() - 0.5f) * this.height;
                float f2 = (this.rand.nextFloat() - 0.5f) * this.width;
                this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + (double)this.getEyeHeight() + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            }
            this.moveEntity(0.0, 0.1f, 0.0);
            float f = (this.rand.nextFloat() - 0.5f) * this.width;
            f1 = (this.rand.nextFloat() - 0.5f) * this.height;
            float f2 = (this.rand.nextFloat() - 0.5f) * this.width;
            this.worldObj.spawnParticle("largeexplode", this.posX + (double)f, this.posY + (double)this.getEyeHeight() + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("lava", this.posX + (double)f, this.posY + (double)this.getEyeHeight() + (double)f1, this.posZ + (double)f2, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
            if (this.deathTicks == 200 && !this.worldObj.isRemote) {
                int j;
                int i;
                if (this.master != null) {
                    this.master.heal(this.master.getMaxHealth() / 100.0f);
                    for (i = 0; i < 100; ++i) {
                        double d2 = this.rand.nextGaussian() * 0.02;
                        double d0 = this.rand.nextGaussian() * 0.02;
                        double d1 = this.rand.nextGaussian() * 0.02;
                        this.worldObj.spawnParticle("largeexplode", this.master.posX + (double)(this.rand.nextFloat() * this.master.width * 2.0f) - (double)this.master.width, this.master.posY + (double)(this.rand.nextFloat() * this.master.height), this.master.posZ + (double)(this.rand.nextFloat() * this.master.width * 2.0f) - (double)this.master.width, d2, d0, d1);
                    }
                }
                for (i = this.experienceValue; i > 0; i -= j) {
                    j = EntityXPOrb.getXPSplit((int)i);
                    this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
                }
                this.setDead();
            }
        } else {
            super.onDeathUpdate();
        }
    }

    public class EntityAIWander
    extends EntityAIBase {
        private EntityCreature entity;
        private double xPosition;
        private double yPosition;
        private double zPosition;
        private double speed;

        public EntityAIWander(EntityCreature p_i1648_1_, double p_i1648_2_) {
            this.entity = p_i1648_1_;
            this.speed = p_i1648_2_;
            this.setMutexBits(1);
        }

        public boolean shouldExecute() {
            if (this.entity.getAge() >= 100) {
                return false;
            }
            if (this.entity.getRNG().nextInt(10) != 0) {
                return false;
            }
            Vec3 vec3 = RandomPositionGenerator.findRandomTarget((EntityCreature)this.entity, (int)10, (int)7);
            if (vec3 == null) {
                return false;
            }
            this.xPosition = vec3.xCoord;
            this.yPosition = vec3.yCoord;
            this.zPosition = vec3.zCoord;
            return true;
        }

        public boolean continueExecuting() {
            return !this.entity.getNavigator().noPath();
        }

        public void startExecuting() {
            this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
        }
    }

    public class EntityAIFindEntityNearestInjuredAlly
    extends EntityAIBase {
        private EntitySilverfishMinion field_179434_b;
        private EntityLivingBase field_179433_e;

        public EntityAIFindEntityNearestInjuredAlly(EntitySilverfishMinion entityCaveSpiderPriest) {
            this.field_179434_b = entityCaveSpiderPriest;
        }

        public boolean shouldExecute() {
            if (!this.field_179434_b.isEntityAlive()) {
                return false;
            }
            if (this.field_179434_b.getMinionType() != EnumMinionType.PRIEST) {
                return false;
            }
            if (this.field_179433_e != null) {
                return false;
            }
            double d0 = this.func_179431_f();
            List list = this.field_179434_b.worldObj.getEntitiesWithinAABB(EntitySilverfishMinion.class, this.field_179434_b.boundingBox.expand(d0, d0, d0));
            if (list.isEmpty()) {
                return false;
            }
            for (int i = 0; i < list.size(); ++i) {
                EntitySilverfishMinion entity = (EntitySilverfishMinion)list.get(i);
                if (!(entity.getHealth() < entity.getMaxHealth()) || !entity.isEntityAlive()) continue;
                this.field_179433_e = entity;
            }
            return true;
        }

        public boolean continueExecuting() {
            EntityLiving entitylivingbase = this.field_179434_b.entityToHeal;
            if (entitylivingbase == null) {
                return false;
            }
            if (!entitylivingbase.isEntityAlive()) {
                return false;
            }
            if (entitylivingbase.getHealth() >= entitylivingbase.getMaxHealth()) {
                return false;
            }
            double d0 = this.func_179431_f();
            return this.field_179434_b.getDistanceSqToEntity((Entity)entitylivingbase) <= d0 * d0;
        }

        public void startExecuting() {
            this.field_179434_b.entityToHeal = (EntityLiving)this.field_179433_e;
            super.startExecuting();
        }

        public void resetTask() {
            this.field_179434_b.entityToHeal = null;
            this.field_179433_e = null;
            super.resetTask();
        }

        public void updateTask() {
            if (this.field_179434_b.entityToHeal != null && (double)this.field_179434_b.getDistanceToEntity((Entity)this.field_179434_b.entityToHeal) > 16.0) {
                this.field_179434_b.getNavigator().tryMoveToEntityLiving((Entity)this.field_179434_b.entityToHeal, 1.0);
                this.field_179434_b.getLookHelper().setLookPositionWithEntity((Entity)this.field_179434_b.entityToHeal, 10.0f, (float)this.field_179434_b.getVerticalFaceSpeed());
            }
        }

        protected double func_179431_f() {
            return 24.0;
        }
    }
}

