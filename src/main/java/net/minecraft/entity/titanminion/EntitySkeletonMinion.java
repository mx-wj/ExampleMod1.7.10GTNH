/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
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
 *  net.minecraft.entity.ai.EntityAIFleeSun
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAIMoveTowardsRestriction
 *  net.minecraft.entity.ai.EntityAIRestrictSun
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntitySkeleton
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
 *  net.minecraft.world.WorldProviderHell
 */
package net.minecraft.entity.titanminion;

import java.util.Calendar;
import java.util.List;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
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
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAIBreakDoorMinion;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EntityGhastMinionFireball;
import net.minecraft.entity.titanminion.EntitySpiderMinion;
import net.minecraft.entity.titanminion.EntityWitherMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
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
import net.minecraft.world.WorldProviderHell;

public class EntitySkeletonMinion
extends EntitySkeleton
implements IRangedAttackMob,
ITemplar {
    public EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack((IRangedAttackMob)this, 1.2, 10, 40, 24.0f);
    public EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide((EntityCreature)this, 1.2, true);
    public EntityLiving master;
    public boolean isReadyToAttack;
    public int randomSoundDelay;
    private int attackPattern;
    private float heightOffset = 0.5f;
    private int heightOffsetUpdateTime;
    public EntityLiving entityToHeal;
    public int deathTicks;

    public EntitySkeletonMinion(World worldIn) {
        super(worldIn);
        for (int i = 0; i < this.equipmentDropChances.length; ++i) {
            this.equipmentDropChances[i] = 0.2f;
        }
        this.setSize(0.5f, 1.95f);
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setEnterDoors(true);
        this.tasks.addTask(0, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityWitherSkull.class, 2.0f, 1.2, 1.75));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityTitanSpirit.class, 48.0f, 1.5, 1.5));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIBreakDoorMinion((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.2));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIRestrictSun((EntityCreature)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIFleeSun((EntityCreature)this, 1.2));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIFindEntityNearestInjuredAlly(this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, false, ITitan.SkeletonTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
        if (worldIn != null && !worldIn.isRemote) {
            this.setAttackTask();
        }
    }

    protected int getExperiencePoints(EntityPlayer p_70693_1_) {
        if (this.getSkeletonType() == 1) {
            this.experienceValue = (int)((float)this.experienceValue * 2.5f);
        }
        return super.getExperiencePoints(p_70693_1_);
    }

    public void setDead() {
        super.setDead();
        if (this.master != null && this.master instanceof EntityTitan) {
            ((EntityTitan)this.master).retractMinionNumFromType(this.getMinionType());
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

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != EntitySkeletonMinion.class && p_70686_1_ != EntitySkeletonTitan.class && p_70686_1_ != EntityWitherMinion.class;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
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

    protected String getLivingSound() {
        return this.getMinionTypeInt() == 4 ? (this.getSkeletonType() == 1 ? "thetitans:titanWitherSkeletonLiving" : "thetitans:titanSkeletonLiving") : "mob.skeleton.say";
    }

    protected String getHurtSound() {
        return this.getMinionTypeInt() == 4 ? (this.getSkeletonType() == 1 ? "thetitans:titanWitherSkeletonGrunt" : "thetitans:titanSkeletonGrunt") : "mob.skeleton.hurt";
    }

    protected String getDeathSound() {
        return this.getMinionTypeInt() == 4 ? (this.getSkeletonType() == 1 ? "thetitans:titanWitherSkeletonDeath" : "thetitans:titanSkeletonDeath") : "mob.skeleton.death";
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
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
            this.tasks.addTask(0, (EntityAIBase)new EntityAIFindEntityNearestInjuredAlly(this));
            this.setHealth(80.0f);
            this.experienceValue = 15;
        } else if (miniontype == 2) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
            this.setHealth(300.0f);
            this.experienceValue = 100;
        } else if (miniontype == 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0);
            this.isImmuneToFire = true;
            this.setHealth(1000.0f);
            this.experienceValue = 200;
        } else if (miniontype == 4) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4000.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            this.isImmuneToFire = true;
            this.setHealth(4000.0f);
            this.experienceValue = 1000;
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
            this.setHealth(40.0f);
            this.experienceValue = 6;
        }
        this.setSkeletonType(this.getSkeletonType());
    }

    @Override
    public void TransformEntity(Entity entity) {
        entity.worldObj.newExplosion(entity, entity.posX, entity.posY, entity.posZ, 18.0f, true, entity.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        EntitySkeletonTitan entitytitan = new EntitySkeletonTitan(entity.worldObj);
        entitytitan.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, 0.0f);
        entity.setDead();
        entitytitan.func_82206_m();
        entity.worldObj.spawnEntityInWorld((Entity)entitytitan);
        if (this.getSkeletonType() == 1) {
            entitytitan.becomeWitherSkeleton(true);
        } else {
            entitytitan.setSkeletonType(0);
            entitytitan.setCurrentItemOrArmor(0, new ItemStack((Item)Items.bow));
        }
    }

    public void onLivingUpdate() {
        EntitySkeletonMinion entitychicken;
        if (this.getHealth() > this.getMaxHealth()) {
            this.setHealth(this.getMaxHealth());
        }
        if (this.getSkeletonType() == 1) {
            if (this.getMinionTypeInt() == 1) {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
                this.experienceValue = 15;
            } else if (this.getMinionTypeInt() == 2) {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0);
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
                this.experienceValue = 100;
            } else if (this.getMinionTypeInt() == 3) {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0);
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0);
                this.isImmuneToFire = true;
                this.experienceValue = 200;
            } else if (this.getMinionTypeInt() == 4) {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4000.0);
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0);
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
                this.isImmuneToFire = true;
                this.experienceValue = 1000;
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
                this.experienceValue = 6;
            }
        } else if (this.getMinionTypeInt() == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
            this.experienceValue = 15;
        } else if (this.getMinionTypeInt() == 2) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(180.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
            this.experienceValue = 100;
        } else if (this.getMinionTypeInt() == 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.375);
            this.isImmuneToFire = true;
            this.experienceValue = 200;
        } else if (this.getMinionTypeInt() == 4) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1800.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30.0);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            this.isImmuneToFire = true;
            this.experienceValue = 1000;
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0);
            this.experienceValue = 7;
        }
        this.tasks.removeTask((EntityAIBase)new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 20, 60, 15.0f));
        this.tasks.removeTask((EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, EntityPlayer.class, 1.2, false));
        if (this.getAttackTarget() != null && this.getDistanceSqToEntity((Entity)this.getAttackTarget()) > 256.0) {
            this.getMoveHelper().setMoveTo(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1.0);
        }
        if (this.getAttackTarget() != null) {
            this.setRevengeTarget(this.getAttackTarget());
        }
        if (this.worldObj.isRemote && this.getSkeletonType() == 1) {
            this.setSize(0.6f, 2.39f);
        }
        if (this.isEntityAlive() || this.getMinionTypeInt() != 4) {
            super.onLivingUpdate();
        }
        if (this.getMinionTypeInt() == 3) {
            if (this.rand.nextInt(120) == 0 && this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                entitychicken = new EntitySkeletonMinion(this.worldObj);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(0);
                entitychicken.setSkeletonType(this.getSkeletonType());
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            }
            if (this.rand.nextInt(240) == 0 && this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                entitychicken = new EntitySkeletonMinion(this.worldObj);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(1);
                entitychicken.setSkeletonType(this.getSkeletonType());
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            }
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
                    entitychicken = new EntitySkeletonMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(0);
                    entitychicken.setSkeletonType(this.getSkeletonType());
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
                if (this.rand.nextInt(120) == 0) {
                    entitychicken = new EntitySkeletonMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(1);
                    entitychicken.setSkeletonType(this.getSkeletonType());
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
                if (this.rand.nextInt(240) == 0) {
                    entitychicken = new EntitySkeletonMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(2);
                    entitychicken.setSkeletonType(this.getSkeletonType());
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
        } else {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
            if (list != null && !list.isEmpty()) {
                for (int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity == null || !(entity instanceof EntitySkeletonTitan) || this.getSkeletonType() != ((EntitySkeletonTitan)entity).getSkeletonType()) continue;
                    this.master = (EntitySkeletonTitan)entity;
                }
            }
        }
    }

    protected void updateAITasks() {
        EntityLivingBase e;
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.playSound(this.getHurtSound(), this.getSoundVolume(), this.getSoundPitch() + 0.25f);
        }
        if (this.isCollidedHorizontally && this.master != null) {
            this.motionY = 0.2;
        }
        if (this.getAttackTarget() != null && this.worldObj.rand.nextInt(5) == 1 && (e = this.getAttackTarget()) != null && this.getDistanceSqToEntity((Entity)e) < (double)(this.width * this.width + e.width * e.width) + 16.0 && (this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(2) == 1)) {
            this.attackEntityAsMob((Entity)e);
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

    public void updateRidden() {
        super.updateRidden();
        if (this.ridingEntity instanceof EntitySpiderMinion) {
            EntitySpiderMinion entitycreature = (EntitySpiderMinion)this.ridingEntity;
            entitycreature.renderYawOffset = this.renderYawOffset;
            entitycreature.rotationYaw = this.rotationYaw;
            entitycreature.rotationYawHead = this.rotationYawHead;
            if (this.getAttackTarget() != null) {
                entitycreature.setAttackTarget(this.getAttackTarget());
            }
            if (this.getAttackTarget() == entitycreature) {
                this.ridingEntity = null;
            }
        }
    }

    public String getCommandSenderName() {
        if (this.getSkeletonType() == 1) {
            switch (this.getMinionTypeInt()) {
                case 1: {
                    return StatCollector.translateToLocal((String)"entity.WitherSkeletonPriest.name");
                }
                case 2: {
                    return StatCollector.translateToLocal((String)"entity.WitherSkeletonZealot.name");
                }
                case 3: {
                    return StatCollector.translateToLocal((String)"entity.WitherSkeletonBishop.name");
                }
                case 4: {
                    return StatCollector.translateToLocal((String)"entity.WitherSkeletonTemplar.name");
                }
            }
            return StatCollector.translateToLocal((String)"entity.WitherSkeletonLoyalist.name");
        }
        switch (this.getMinionTypeInt()) {
            case 1: {
                return StatCollector.translateToLocal((String)"entity.SkeletonPriest.name");
            }
            case 2: {
                return StatCollector.translateToLocal((String)"entity.SkeletonZealot.name");
            }
            case 3: {
                return StatCollector.translateToLocal((String)"entity.SkeletonBishop.name");
            }
            case 4: {
                return StatCollector.translateToLocal((String)"entity.SkeletonTemplar.name");
            }
        }
        return StatCollector.translateToLocal((String)"entity.SkeletonLoyalist.name");
    }

    protected Item getDefaultEquipment() {
        switch (this.getMinionTypeInt()) {
            case 1: {
                return Items.iron_axe;
            }
            case 2: {
                return Items.iron_sword;
            }
            case 3: {
                return Items.diamond_axe;
            }
            case 4: {
                return Items.diamond_sword;
            }
        }
        return Items.stone_sword;
    }

    protected Item getDropItem() {
        return Items.arrow;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        block54: {
            int k;
            int j;
            block53: {
                j = this.rand.nextInt(3 + p_70628_2_);
                for (k = 0; k < j; ++k) {
                    this.dropItem(Items.bone, 1);
                }
                j = this.rand.nextInt(5 + p_70628_2_);
                for (k = 0; k < j; ++k) {
                    this.entityDropItem(new ItemStack(Items.dye, 1, 15), 0.0f);
                }
                if (this.getSkeletonType() != 1) break block53;
                j = this.rand.nextInt(3 + p_70628_2_) - 1;
                for (k = 0; k < j; ++k) {
                    this.dropItem(Items.coal, 1);
                }
                if (this.getMinionTypeInt() < 1) break block54;
                j = 1 + this.rand.nextInt(4);
                if (p_70628_2_ > 0) {
                    j += this.rand.nextInt(p_70628_2_ + 1);
                }
                for (k = 0; k < j; ++k) {
                    this.dropItem(Items.experience_bottle, 1);
                }
                if (this.getMinionTypeInt() < 2) break block54;
                j = this.rand.nextInt(2);
                if (p_70628_2_ > 0) {
                    j += this.rand.nextInt(p_70628_2_ + 1);
                }
                for (k = 0; k < j; ++k) {
                    if (this.rand.nextInt(10) == 0) {
                        this.entityDropItem(new ItemStack(Items.golden_apple, 1, 1), 0.0f);
                        continue;
                    }
                    this.dropItem(Items.golden_apple, 1);
                }
                if (this.getMinionTypeInt() < 3) break block54;
                j = this.rand.nextInt(2);
                if (p_70628_2_ > 0) {
                    j += this.rand.nextInt(p_70628_2_ + 1);
                }
                block29: for (k = 0; k < j; ++k) {
                    switch (this.rand.nextInt(5)) {
                        case 0: {
                            this.entityDropItem(new ItemStack(Blocks.emerald_block, 1, 0), 0.0f);
                            continue block29;
                        }
                        case 1: {
                            this.entityDropItem(new ItemStack(Blocks.diamond_block, 1, 0), 0.0f);
                            continue block29;
                        }
                        case 2: {
                            this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                            continue block29;
                        }
                        case 3: {
                            this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                            continue block29;
                        }
                        case 4: {
                            this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                        }
                    }
                }
                this.entityDropItem(new ItemStack(Blocks.obsidian), 0.0f);
                if (this.getMinionTypeInt() < 4) break block54;
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
                block30: for (k = 0; k < j; ++k) {
                    switch (this.rand.nextInt(3)) {
                        case 0: {
                            this.entityDropItem(new ItemStack(Blocks.emerald_block, 1, 0), 0.0f);
                            continue block30;
                        }
                        case 1: {
                            this.entityDropItem(new ItemStack(Blocks.diamond_block, 1, 0), 0.0f);
                            continue block30;
                        }
                        case 2: {
                            this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                        }
                    }
                }
                this.entityDropItem(new ItemStack(Blocks.obsidian), 0.0f);
                break block54;
            }
            j = this.rand.nextInt(3 + p_70628_2_);
            for (k = 0; k < j; ++k) {
                this.dropItem(Items.arrow, 1);
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
                        block34: for (k = 0; k < j; ++k) {
                            switch (this.rand.nextInt(5)) {
                                case 0: {
                                    this.dropItem(Items.emerald, 1);
                                    continue block34;
                                }
                                case 1: {
                                    this.dropItem(Items.diamond, 1);
                                    continue block34;
                                }
                                case 2: {
                                    this.dropItem(Items.gold_ingot, 1);
                                    continue block34;
                                }
                                case 3: {
                                    this.dropItem(Items.gold_ingot, 1);
                                    continue block34;
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
                            block35: for (k = 0; k < j; ++k) {
                                switch (this.rand.nextInt(3)) {
                                    case 0: {
                                        this.dropItem(Items.emerald, 1);
                                        continue block35;
                                    }
                                    case 1: {
                                        this.dropItem(Items.diamond, 1);
                                        continue block35;
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
    }

    protected void dropRareDrop(int p_70600_1_) {
        if (this.getSkeletonType() == 1) {
            this.entityDropItem(new ItemStack(Items.skull, 1, 1), 0.0f);
        } else {
            this.entityDropItem(new ItemStack(Items.skull, 1, 0), 0.0f);
        }
    }

    protected void addRandomArmor() {
        float f = this.rand.nextFloat();
        float f2 = this.worldObj.difficultySetting == EnumDifficulty.NORMAL ? 0.25f : (this.worldObj.difficultySetting == EnumDifficulty.HARD ? 0.95f : 0.05f);
        if (f < f2) {
            float f3;
            int i = this.rand.nextInt(2);
            float f4 = f3 = this.worldObj.difficultySetting == EnumDifficulty.HARD ? 0.75f : 0.05f;
            if (this.rand.nextFloat() < 0.25f) {
                ++i;
            }
            if (this.rand.nextFloat() < 0.25f) {
                ++i;
            }
            if (this.rand.nextFloat() < 0.25f) {
                ++i;
            }
            for (int j = 3; j >= 0; --j) {
                Item item;
                ItemStack itemstack = this.func_130225_q(j);
                if (j < 3 && this.rand.nextFloat() < f3) break;
                if (itemstack != null || (item = EntitySkeletonMinion.getArmorItemForSlot((int)(j + 1), (int)i)) == null) continue;
                this.setCurrentItemOrArmor(j + 1, new ItemStack(item));
            }
        }
        this.setCurrentItemOrArmor(0, new ItemStack((Item)Items.bow));
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_180482_2_) {
        this.addRandomArmor();
        this.enchantEquipment();
        if (this.worldObj.provider instanceof WorldProviderHell && this.getRNG().nextInt(5) > 0 || this.getSkeletonType() == 1) {
            this.tasks.addTask(3, (EntityAIBase)this.aiAttackOnCollide);
            this.setSkeletonType(1);
            this.setCurrentItemOrArmor(0, new ItemStack(this.getDefaultEquipment()));
        } else {
            this.tasks.addTask(3, (EntityAIBase)this.aiArrowAttack);
            this.setSkeletonType(0);
            this.setCurrentItemOrArmor(0, new ItemStack((Item)Items.bow));
        }
        float f = this.worldObj.func_147462_b(this.posX, this.posY, this.posZ);
        this.setCanPickUpLoot(true);
        Calendar calendar = this.worldObj.getCurrentDate();
        if (!this.isChild() && calendar.get(2) + 1 == 10 && calendar.get(5) >= 1 && calendar.get(5) <= 31 && this.rand.nextFloat() < 0.5f) {
            this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1f ? Blocks.lit_pumpkin : Blocks.pumpkin));
            this.equipmentDropChances[4] = 0.0f;
        }
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.1, 0));
        double d0 = this.rand.nextDouble() * 1.5 * (double)f;
        if (d0 > 1.0) {
            this.getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Random zombie-spawn bonus", d0, 2));
        }
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
        this.getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextGaussian() * 0.05, 1));
        return p_180482_2_;
    }

    public void setCombatTask() {
    }

    public void setAttackTask() {
        this.tasks.removeTask((EntityAIBase)this.aiAttackOnCollide);
        this.tasks.removeTask((EntityAIBase)this.aiArrowAttack);
        ItemStack itemstack = this.getHeldItem();
        if (itemstack != null && itemstack.getItem() == Items.bow) {
            this.tasks.addTask(3, (EntityAIBase)this.aiArrowAttack);
        } else {
            this.tasks.addTask(3, (EntityAIBase)this.aiAttackOnCollide);
        }
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("MinionType", this.getMinionTypeInt());
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.setMinionType(tagCompund.getInteger("MinionType"));
        this.setAttackTask();
    }

    public void setCurrentItemOrArmor(int p_70062_1_, ItemStack p_70062_2_) {
        super.setCurrentItemOrArmor(p_70062_1_, p_70062_2_);
        if (!this.worldObj.isRemote && p_70062_1_ == 0) {
            this.setAttackTask();
        }
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        block29: {
            block27: {
                block30: {
                    block28: {
                        if (this.getMinionTypeInt() != 4) break block27;
                        if (!(this.getDistanceSqToEntity((Entity)p_82196_1_) < (double)(p_82196_1_.width * p_82196_1_.width) + 36.0)) break block28;
                        this.attackEntityAsMob((Entity)p_82196_1_);
                        break block29;
                    }
                    if (this.getSkeletonType() != 1) break block30;
                    switch (this.rand.nextInt(5)) {
                        case 0: {
                            for (int i = 0; i < 100; ++i) {
                                EntityHarcadiumArrow entityarrow = new EntityHarcadiumArrow(this.worldObj, (EntityLivingBase)this, p_82196_1_, 4.0f, 45.0f);
                                entityarrow.setIsCritical(true);
                                entityarrow.setDamage((double)(p_82196_2_ * 2.0f) + this.rand.nextGaussian() * 0.25 + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11f));
                                this.worldObj.spawnEntityInWorld((Entity)entityarrow);
                                double d8 = 4.0;
                                Vec3 vec3 = this.getLook(1.0f);
                                entityarrow.posX = this.posX + vec3.xCoord * d8;
                                entityarrow.posY = this.posY + vec3.yCoord * d8 + 1.0;
                                entityarrow.posZ = this.posZ + vec3.zCoord * d8;
                            }
                            break block29;
                        }
                        case 1: {
                            for (int i = 0; i < 200; ++i) {
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
                                entitypotion.setThrowableHeading(d1, d2 + (double)(f1 * 0.2f), d3, 2.0f, 25.0f);
                                this.worldObj.spawnEntityInWorld((Entity)entitypotion);
                            }
                            break block29;
                        }
                        case 2: {
                            for (int i = 0; i < 50; ++i) {
                                double d01 = this.getDistanceSqToEntity((Entity)p_82196_1_);
                                double d11 = p_82196_1_.posX - this.posX;
                                double d21 = p_82196_1_.boundingBox.minY + (double)(p_82196_1_.height / 2.0f) - (this.posY + (double)(p_82196_1_.height / 2.0f));
                                double d31 = p_82196_1_.posZ - this.posZ;
                                EntityGhastMinionFireball entitysmallfireball = new EntityGhastMinionFireball(this.worldObj, (EntityLivingBase)this, d11 + this.getRNG().nextGaussian() * 9.0, d21, d31 + this.getRNG().nextGaussian() * 9.0);
                                double d8 = 2.0;
                                Vec3 vec3 = this.getLook(1.0f);
                                entitysmallfireball.posX = this.posX + vec3.xCoord * d8;
                                entitysmallfireball.posY = this.posY + vec3.yCoord * d8 + 1.0;
                                entitysmallfireball.posZ = this.posZ + vec3.zCoord * d8;
                                entitysmallfireball.field_92057_e = 2;
                                this.worldObj.spawnEntityInWorld((Entity)entitysmallfireball);
                            }
                            break block29;
                        }
                        case 3: {
                            this.worldObj.newExplosion((Entity)this, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ, 2.0f * p_82196_1_.width, false, false);
                            p_82196_1_.attackEntityFrom(DamageSourceExtra.lightningBolt, 100.0f);
                            this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                            this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                            this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                            this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                            break;
                        }
                        case 4: {
                            this.playSound("mob.skeleton.death", 1.0f, 0.5f);
                            this.worldObj.playSoundEffect(p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ, "random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
                            for (int i1 = 0; i1 < 256; ++i1) {
                                EntityItem entityitem = p_82196_1_.dropItem(Items.bone, 1);
                                entityitem.motionY = 1.0;
                                entityitem.delayBeforeCanPickup = 6000;
                                entityitem.lifespan = 40 + this.rand.nextInt(20);
                            }
                            p_82196_1_.addPotionEffect(new PotionEffect(Potion.wither.id, 400, 3));
                            p_82196_1_.attackEntityFrom(DamageSource.wither, 20.0f);
                            p_82196_1_.hurtResistantTime = 1;
                        }
                    }
                    break block29;
                }
                switch (this.rand.nextInt(5)) {
                    case 0: {
                        EntityArrow entityarrow = new EntityArrow(this.worldObj, (EntityLivingBase)this, p_82196_1_, 1.6f, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
                        int i = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.power.effectId, (ItemStack)this.getHeldItem());
                        int j = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.punch.effectId, (ItemStack)this.getHeldItem());
                        entityarrow.setDamage((double)(p_82196_2_ * 2.0f) + this.rand.nextGaussian() * 0.25 + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11f));
                        entityarrow.setIsCritical(true);
                        if (i > 0) {
                            entityarrow.setDamage(entityarrow.getDamage() + (double)i * 0.5 + 0.5);
                        }
                        if (j > 0) {
                            entityarrow.setKnockbackStrength(j);
                        }
                        if (EnchantmentHelper.getEnchantmentLevel((int)Enchantment.flame.effectId, (ItemStack)this.getHeldItem()) > 0 || this.getSkeletonType() == 1) {
                            entityarrow.setFire(100);
                        }
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
                        entitypotion.setThrowableHeading(d1, d2 + (double)(f1 * 0.2f), d3, 1.6f, f1 / 20.0f);
                        this.worldObj.spawnEntityInWorld((Entity)entitypotion);
                        break;
                    }
                    case 2: {
                        double d011 = this.getDistanceSqToEntity((Entity)p_82196_1_);
                        double d111 = p_82196_1_.posX - this.posX;
                        double d211 = p_82196_1_.boundingBox.minY + (double)(p_82196_1_.height / 2.0f) - (this.posY + (double)(p_82196_1_.height / 2.0f));
                        double d311 = p_82196_1_.posZ - this.posZ;
                        float f = MathHelper.sqrt_float((float)MathHelper.sqrt_double((double)d011)) * 0.1f;
                        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                        EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, d111 + this.getRNG().nextGaussian() * (double)f, d211, d311 + this.getRNG().nextGaussian() * (double)f);
                        entitysmallfireball.posY = this.posY + 1.6;
                        this.worldObj.spawnEntityInWorld((Entity)entitysmallfireball);
                        break;
                    }
                    case 3: {
                        this.playSound("mob.skeleton.death", 1.0f, 0.5f);
                        this.worldObj.playSoundEffect(p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ, "random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
                        for (int i1 = 0; i1 < 256; ++i1) {
                            EntityItem entityitem = p_82196_1_.dropItem(Items.bone, 1);
                            entityitem.motionY = 1.0;
                            entityitem.delayBeforeCanPickup = 6000;
                            entityitem.lifespan = 40 + this.rand.nextInt(20);
                        }
                        p_82196_1_.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 2));
                        p_82196_1_.attackEntityFrom(DamageSource.wither, 5.0f);
                        p_82196_1_.hurtResistantTime = 1;
                        break;
                    }
                    case 4: {
                        EntityHarcadiumArrow entityarrow1 = new EntityHarcadiumArrow(this.worldObj, (EntityLivingBase)this, p_82196_1_, 1.6f, 1.0f);
                        entityarrow1.setIsCritical(true);
                        this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                        this.worldObj.spawnEntityInWorld((Entity)entityarrow1);
                    }
                }
                break block29;
            }
            EntityArrow entityarrow = new EntityArrow(this.worldObj, (EntityLivingBase)this, p_82196_1_, 1.6f, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
            int i = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.power.effectId, (ItemStack)this.getHeldItem());
            int j = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.punch.effectId, (ItemStack)this.getHeldItem());
            entityarrow.setDamage((double)(p_82196_2_ * 2.0f) + this.rand.nextGaussian() * 0.25 + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11f) + (double)(this.getMinionTypeInt() * 3));
            if (i > 0) {
                entityarrow.setDamage(entityarrow.getDamage() + (double)i * 0.5 + 0.5);
            }
            if (j > 0) {
                entityarrow.setKnockbackStrength(j);
            }
            if (EnchantmentHelper.getEnchantmentLevel((int)Enchantment.flame.effectId, (ItemStack)this.getHeldItem()) > 0 || this.getSkeletonType() == 1) {
                entityarrow.setFire(100);
            }
            this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)entityarrow);
        }
    }

    public int getSkeletonType() {
        return this.dataWatcher.getWatchableObjectByte(13);
    }

    public void setSkeletonType(int p_82201_1_) {
        this.dataWatcher.updateObject(13, (Object)((byte)p_82201_1_));
        boolean bl = this.isImmuneToFire = p_82201_1_ == 1 || this.getMinionTypeInt() >= 3;
        if (p_82201_1_ == 1) {
            this.setSize(0.6f, 2.39f);
            this.setCurrentItemOrArmor(0, new ItemStack(this.getDefaultEquipment()));
        } else {
            this.setSize(0.5f, 1.95f);
            this.setCurrentItemOrArmor(0, new ItemStack((Item)Items.bow));
        }
    }

    public float getEyeHeight() {
        return this.getSkeletonType() == 1 ? 2.088f : 1.74f;
    }

    public double getYOffset() {
        if (this.getSkeletonType() == 1) {
            return super.getYOffset() - 0.28;
        }
        return super.getYOffset() - 0.15;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable() || this.getMinionTypeInt() >= 4 && source == DamageSourceExtra.radiation) {
            return false;
        }
        if (source == DamageSource.wither && this.getSkeletonType() == 1) {
            return false;
        }
        if (source.getEntity() instanceof EntitySkeletonMinion || source.getEntity() instanceof EntitySkeletonTitan || source.getEntity() instanceof EntityWitherMinion) {
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
                if (entity1 instanceof EntitySkeletonMinion) {
                    EntitySkeletonMinion entitypigzombie = (EntitySkeletonMinion)entity1;
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

    public class EntityAIFindEntityNearestInjuredAlly
    extends EntityAIBase {
        private EntitySkeletonMinion field_179434_b;
        private EntityLivingBase field_179433_e;

        public EntityAIFindEntityNearestInjuredAlly(EntitySkeletonMinion entityCaveSpiderPriest) {
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
            List list = this.field_179434_b.worldObj.getEntitiesWithinAABB(EntitySkeletonMinion.class, this.field_179434_b.boundingBox.expand(d0, d0, d0));
            if (list.isEmpty()) {
                return false;
            }
            for (int i = 0; i < list.size(); ++i) {
                EntitySkeletonMinion entity = (EntitySkeletonMinion)list.get(i);
                if (!(entity.getHealth() < entity.getMaxHealth()) || !entity.isEntityAlive() || entity.getSkeletonType() != this.field_179434_b.getSkeletonType()) continue;
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
            return 32.0;
        }
    }
}

