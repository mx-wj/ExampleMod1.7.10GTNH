/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.eventhandler.Event
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.Block$SoundType
 *  net.minecraft.block.material.Material
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
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveTowardsRestriction
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAIWander
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityPotion
 *  net.minecraft.entity.projectile.EntitySmallFireball
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
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
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.EnderTeleportEvent
 */
package net.minecraft.entity.titanminion;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAIBreakDoorMinion;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.ITemplar;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraft.theTitans.util.MinionOptimizationHelper;

public class EntitySpiderMinion
extends EntitySpider
implements IRangedAttackMob,
ITemplar {
    public EntityLiving master;
    public boolean isSpeedy;
    public boolean isStrong;
    public boolean isPredator;
    public boolean isWolverine;
    public boolean isSuperSwimmer;
    public boolean isLavaSwimmer;
    public boolean isJumper;
    public boolean isHealthy;
    public boolean isShielded;
    public boolean isTough;
    public int randomSoundDelay;
    public EntityLiving entityToHeal;
    private int attackPattern;
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 10, 64.0f);
    private float heightOffset = 0.5f;
    private int heightOffsetUpdateTime;
    public int deathTicks;

    public EntitySpiderMinion(World worldIn) {
        super(worldIn);
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setEnterDoors(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityWitherSkull.class, 2.0f, 1.2, 1.75));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityTitanSpirit.class, 48.0f, 1.5, 1.5));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIBreakDoorMinion((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.2));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIFindEntityNearestInjuredAlly(this));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, EntityLivingBase.class, 1.2, true));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.tasks.addTask(9, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, false, ITitan.SpiderTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(19, (Object)0);
    }

    public void setDead() {
        super.setDead();
        if (this.master != null && this.master instanceof EntityTitan) {
            ((EntityTitan)this.master).retractMinionNumFromType(this.getMinionType());
        }
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

    protected float applyPotionDamageCalculations(DamageSource p_70672_1_, float p_70672_2_) {
        if (this.getMinionTypeInt() >= 4) {
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

    public String getCommandSenderName() {
        switch (this.getMinionTypeInt()) {
            case 1: {
                return StatCollector.translateToLocal((String)"entity.SpiderPriest.name");
            }
            case 2: {
                return StatCollector.translateToLocal((String)"entity.SpiderZealot.name");
            }
            case 3: {
                return StatCollector.translateToLocal((String)"entity.SpiderBishop.name");
            }
            case 4: {
                return StatCollector.translateToLocal((String)"entity.SpiderTemplar.name");
            }
        }
        return StatCollector.translateToLocal((String)"entity.SpiderLoyalist.name");
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
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0);
            this.tasks.addTask(0, (EntityAIBase)new EntityAIFindEntityNearestInjuredAlly(this));
            this.setHealth(40.0f);
            this.experienceValue = 15;
        } else if (miniontype == 2) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
            this.setHealth(100.0f);
            this.experienceValue = 50;
        } else if (miniontype == 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(240.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0);
            this.isImmuneToFire = true;
            this.setHealth(240.0f);
            this.experienceValue = 100;
        } else if (miniontype == 4) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30.0);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            this.isImmuneToFire = true;
            this.setHealth(1200.0f);
            this.experienceValue = 500;
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0);
            this.setHealth(20.0f);
            this.experienceValue = 6;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return this.getMinionTypeInt() == 4 ? 0xF000F0 : super.getBrightnessForRender(p_70070_1_);
    }

    public float getBrightness(float p_70013_1_) {
        return this.getMinionTypeInt() == 4 ? 1.0f : super.getBrightness(p_70013_1_);
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.isSpeedy = tagCompund.getBoolean("Speedy");
        this.isStrong = tagCompund.getBoolean("Strong");
        this.isPredator = tagCompund.getBoolean("Predator");
        this.isWolverine = tagCompund.getBoolean("Wolverine");
        this.isSuperSwimmer = tagCompund.getBoolean("SuperSwimmer");
        this.isLavaSwimmer = tagCompund.getBoolean("LavaSwimmer");
        this.isJumper = tagCompund.getBoolean("Jumper");
        this.isHealthy = tagCompund.getBoolean("Healthy");
        this.isShielded = tagCompund.getBoolean("Shielded");
        this.isTough = tagCompund.getBoolean("Tough");
        this.setMinionType(tagCompund.getInteger("MinionType"));
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("Speedy", this.isSpeedy);
        tagCompound.setBoolean("Strong", this.isStrong);
        tagCompound.setBoolean("Predator", this.isPredator);
        tagCompound.setBoolean("Wolverine", this.isWolverine);
        tagCompound.setBoolean("SuperSwimmer", this.isSuperSwimmer);
        tagCompound.setBoolean("LavaSwimmer", this.isLavaSwimmer);
        tagCompound.setBoolean("Jumper", this.isJumper);
        tagCompound.setBoolean("Healthy", this.isHealthy);
        tagCompound.setBoolean("Shielded", this.isShielded);
        tagCompound.setBoolean("Tough", this.isTough);
        tagCompound.setInteger("MinionType", this.getMinionTypeInt());
    }

    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        double d3;
        double d1;
        EntitySpiderMinion entitychicken;
        if (this.getMinionTypeInt() == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0);
            this.experienceValue = 15;
        } else if (this.getMinionTypeInt() == 2) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
            this.experienceValue = 50;
        } else if (this.getMinionTypeInt() == 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(240.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0);
            this.isImmuneToFire = true;
            this.experienceValue = 100;
        } else if (this.getMinionTypeInt() == 4) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30.0);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            this.isImmuneToFire = true;
            this.experienceValue = 500;
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0);
            this.experienceValue = 6;
        }
        if (this.isEntityAlive() || this.getMinionTypeInt() != 4) {
            super.onLivingUpdate();
        }
        if (this.getMinionTypeInt() == 3) {
            if (this.rand.nextInt(120) == 0 && this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                entitychicken = new EntitySpiderMinion(this.worldObj);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(0);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            }
            if (this.rand.nextInt(240) == 0 && this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                entitychicken = new EntitySpiderMinion(this.worldObj);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(1);
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
                    entitychicken = new EntitySpiderMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
                if (this.rand.nextInt(120) == 0) {
                    entitychicken = new EntitySpiderMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(1);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
                if (this.rand.nextInt(230) == 0) {
                    entitychicken = new EntitySpiderMinion(this.worldObj);
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
                d1 = entitylivingbase.posZ - this.posZ;
                d3 = d0 * d0 + d1 * d1;
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
                net.minecraft.theTitans.util.FastExplosion.createExplosion(this.worldObj, (Entity)this, this.posX, this.posY, this.posZ, 8.0f, false);
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
            if (d0 < 0.8) {
                this.attackEntityAsMob((Entity)this.getAttackTarget());
            }
            if (this.rand.nextInt(40) == 0 && this.onGround && d0 < 256.0 && this.getAttackTarget().posY > this.posY + 3.0) {
                this.addPotionEffect(new PotionEffect(Potion.jump.id, 60, 7));
                this.faceEntity((Entity)this.getAttackTarget(), 180.0f, 180.0f);
                double d01 = this.getAttackTarget().posX - this.posX;
                double d12 = this.getAttackTarget().posZ - this.posZ;
                float f2 = MathHelper.sqrt_double((double)(d01 * d01 + d12 * d12));
                this.jump();
                this.motionX = d01 / (double)f2 * 0.75 * 0.75 + this.motionX * 0.75;
                this.motionZ = d12 / (double)f2 * 0.75 * 0.75 + this.motionZ * 0.75;
            }
        }
        if (this.getMinionTypeInt() == 1) {
            if (this.ticksExisted % 40 == 0 && this.entityToHeal != null) {
                if (this.entityToHeal.getHealth() < this.entityToHeal.getMaxHealth()) {
                    this.swingItem();
                    this.getLookHelper().setLookPositionWithEntity((Entity)this.entityToHeal, 180.0f, (float)this.getVerticalFaceSpeed());
                    this.entityToHeal.heal(4.0f);
                    this.playSound("mob.wither.shoot", 1.0f, 3.0f);
                } else {
                    this.entityToHeal = null;
                }
            }
            if (this.entityToHeal != null) {
                this.getLookHelper().setLookPositionWithEntity((Entity)this.entityToHeal, 180.0f, (float)this.getVerticalFaceSpeed());
            }
        }
        if (this.getAttackTarget() != null && !this.getAttackTarget().isEntityAlive()) {
            this.setAttackTarget(null);
        }
        if (this.getAttackTarget() != null) {
            if (this.isPredator && this.getAttackTarget().getDistanceSqToEntity((Entity)this) < 25.0 && this.rand.nextInt(10) == 0) {
                double d2;
                Vec3 vec3 = Vec3.createVectorHelper((double)(this.posX - this.getAttackTarget().posX), (double)(this.boundingBox.minY + (double)(this.height / 2.0f) - this.getAttackTarget().posY + (double)this.getAttackTarget().getEyeHeight()), (double)(this.posZ - this.getAttackTarget().posZ));
                vec3 = vec3.normalize();
                double d0 = 16.0;
                d1 = this.posX + (this.rand.nextDouble() - 0.5) * 8.0 - vec3.xCoord * d0;
                EnderTeleportEvent event = new EnderTeleportEvent((EntityLivingBase)this, d1, d2 = (double)this.worldObj.getTopSolidOrLiquidBlock((int)d1, (int)(d3 = this.posZ + (this.rand.nextDouble() - 0.5) * 8.0 - vec3.zCoord * d0)), d3, 0.0f);
                if (!MinecraftForge.EVENT_BUS.post((Event)event)) {
                    this.attackEntityAsMob((Entity)this.getAttackTarget());
                    this.posX = event.targetX;
                    this.posY = event.targetY;
                    this.posZ = event.targetZ;
                    this.setPosition(this.posX, this.posY, this.posZ);
                }
            }
            if (this.getAttackTarget().getDistanceSqToEntity((Entity)this) < 256.0 && this.getAttackTarget().getDistanceSqToEntity((Entity)this) > 9.0 && this.rand.nextInt(10) == 0 && this.onGround) {
                double d0 = this.getAttackTarget().posX - this.posX;
                double d13 = this.getAttackTarget().posZ - this.posZ;
                float f2 = MathHelper.sqrt_double((double)(d0 * d0 + d13 * d13));
                if (this.isSpeedy) {
                    this.motionX = d0 / (double)f2 * 2.0;
                    this.motionZ = d13 / (double)f2 * 2.0;
                } else {
                    this.motionX = d0 / (double)f2 * 0.75;
                    this.motionZ = d13 / (double)f2 * 0.75;
                }
                this.jump();
                this.getLookHelper().setLookPositionWithEntity((Entity)this.getAttackTarget(), 180.0f, 30.0f);
                this.getNavigator().tryMoveToEntityLiving((Entity)this.getAttackTarget(), 1.0);
            }
            if (!this.canEntityBeSeen((Entity)this.getAttackTarget())) {
                double d0 = this.getAttackTarget().posX - this.posX;
                double d14 = this.getAttackTarget().posZ - this.posZ;
                float f2 = MathHelper.sqrt_double((double)(d0 * d0 + d14 * d14));
                if (this.isSpeedy) {
                    this.motionX = d0 / (double)f2 * 1.0;
                    this.motionZ = d14 / (double)f2 * 1.0;
                } else {
                    this.motionX = d0 / (double)f2 * 0.35;
                    this.motionZ = d14 / (double)f2 * 0.35;
                }
            }
        }
        if (this.getAttackTarget() != null && this.getDistanceSqToEntity((Entity)this.getAttackTarget()) > 256.0) {
            this.getMoveHelper().setMoveTo(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1.0);
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
                    if (entity == null || !(entity instanceof EntitySpiderTitan) || entity instanceof EntityCaveSpiderTitan) continue;
                    this.master = (EntitySpiderTitan)entity;
                }
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    protected void fall(float p_70069_1_) {
        this.moveForward = 0.0f;
        this.moveStrafing = 0.0f;
        if ((p_70069_1_ = ForgeHooks.onLivingFall((EntityLivingBase)this, (float)p_70069_1_)) <= 0.0f) {
            return;
        }
        PotionEffect potioneffect = this.getActivePotionEffect(Potion.jump);
        float f1 = potioneffect != null ? (float)(potioneffect.getAmplifier() + 1) : 0.0f;
        int i = MathHelper.ceiling_float_int((float)(p_70069_1_ - 3.0f - f1));
        if (i > 0) {
            this.playSound(this.func_146067_o(i), 1.0f, 1.0f);
            int j = MathHelper.floor_double((double)this.posX);
            int k = MathHelper.floor_double((double)(this.posY - (double)0.2f - (double)this.yOffset));
            int l = MathHelper.floor_double((double)this.posZ);
            Block block = this.worldObj.getBlock(j, k, l);
            if (block.getMaterial() != Material.air) {
                Block.SoundType soundtype = block.stepSound;
                this.playSound(soundtype.getStepResourcePath(), soundtype.getVolume() * 0.5f, soundtype.getPitch() * 0.75f);
            }
        }
    }

    public int getTalkInterval() {
        return this.isPredator ? 600 : 80;
    }

    public void setCombatTask() {
        this.tasks.removeTask((EntityAIBase)this.aiArrowAttack);
        if (this.attackPattern == 0 && this.getMinionTypeInt() == 4) {
            this.tasks.addTask(0, (EntityAIBase)this.aiArrowAttack);
        }
    }

    protected String getLivingSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanSpiderLiving" : (this.isPredator ? "thetitans:predatorSpider" : "mob.spider.say");
    }

    protected String getHurtSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanSpiderGrunt" : "mob.spider.say";
    }

    protected String getDeathSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanSpiderDeath" : "mob.spider.death";
    }

    protected float getSoundPitch() {
        return this.getMinionTypeInt() == 4 ? super.getSoundPitch() + 0.3f : (this.isSpeedy || this.isJumper ? (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.5f : (this.isTough || this.isStrong ? (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 0.8f : super.getSoundPitch()));
    }

    @Override
    public void TransformEntity(Entity entity) {
        net.minecraft.theTitans.util.FastExplosion.newExplosion(entity.worldObj, entity, entity.posX, entity.posY, entity.posZ, 12.0f, true, entity.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        EntitySpiderTitan entitytitan = new EntitySpiderTitan(entity.worldObj);
        entitytitan.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, 0.0f);
        entity.setDead();
        entitytitan.func_82206_m();
        entity.worldObj.spawnEntityInWorld((Entity)entitytitan);
        entitytitan.playSound("thetitans:titanSpiderLiving", 100.0f, 0.8f);
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.swingItem();
        if (this.getDistanceSqToEntity((Entity)p_82196_1_) < (double)(p_82196_1_.width * p_82196_1_.width) + 36.0) {
            this.attackEntityAsMob((Entity)p_82196_1_);
        } else {
            switch (this.rand.nextInt(5)) {
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
                    this.playSound("mob.wither.shoot", 1.0f, 3.0f);
                    int i = MathHelper.floor_double((double)(p_82196_1_.posX + this.rand.nextDouble() * 2.0));
                    int j = MathHelper.floor_double((double)(p_82196_1_.posY + this.rand.nextDouble() * 2.0));
                    int k = MathHelper.floor_double((double)(p_82196_1_.posZ + this.rand.nextDouble() * 2.0));
                    Block block = this.worldObj.getBlock(i, j, k);
                    if (block.getMaterial() == Material.air && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                        this.worldObj.setBlock(i, j, k, Blocks.web);
                        break;
                    }
                    p_82196_1_.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2));
                    break;
                }
                case 4: {
                    this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, 0.8f + this.rand.nextFloat() * 0.2f);
                    this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0f, 0.5f + this.rand.nextFloat() * 0.2f);
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1017, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    this.addPotionEffect(new PotionEffect(Potion.invisibility.id, 200));
                    List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(64.0, 64.0, 64.0));
                    if (list11 == null || list11.isEmpty()) break;
                    for (int i1 = 0; i1 < list11.size(); ++i1) {
                        Entity entity = (Entity)list11.get(i1);
                        if (!(entity instanceof EntitySpiderMinion) || entity == null) continue;
                        ((EntitySpiderMinion)entity).addPotionEffect(new PotionEffect(Potion.invisibility.id, 200));
                        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1017, (int)entity.posX, (int)entity.posY, (int)entity.posZ, 0);
                    }
                    break;
                }
            }
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != EntitySpiderMinion.class && (p_70686_1_ == EntityCaveSpiderTitan.class || p_70686_1_ != EntitySpiderTitan.class);
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable() || this.getMinionTypeInt() >= 4 && source == DamageSourceExtra.radiation) {
            return false;
        }
        if (source.getEntity() instanceof EntitySpiderMinion || source.getEntity() instanceof EntitySpiderTitan && !(source.getEntity() instanceof EntityCaveSpiderTitan)) {
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
                if (entity1 instanceof EntitySpiderMinion) {
                    EntitySpiderMinion entitypigzombie = (EntitySpiderMinion)entity1;
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

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int k;
        super.dropFewItems(p_70628_1_, p_70628_2_);
        int j = this.rand.nextInt(3 + p_70628_2_);
        for (k = 0; k < j; ++k) {
            this.dropItem(Items.melon_seeds, 1);
        }
        if (this.rand.nextInt(60) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0) {
            this.entityDropItem(new ItemStack(Blocks.web), 0.0f);
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

    protected void jump() {
        this.motionY += 0.6;
        if (this.isPotionActive(Potion.jump)) {
            this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1f);
        }
        if (this.isJumper) {
            this.motionY += 0.6;
            float f = this.rotationYaw * ((float)Math.PI / 180);
            this.motionX -= (double)(MathHelper.sin((float)f) * 0.2f);
            this.motionZ += (double)(MathHelper.cos((float)f) * 0.2f);
        }
        this.isAirBorne = true;
        ForgeHooks.onLivingJump((EntityLivingBase)this);
    }

    protected void updateAITasks() {
        if (!MinionOptimizationHelper.shouldRunHeavyAI(this)) {
            return;
        }
        long perfNs = TitansPerf.begin();
        try {
        EntityLivingBase e;
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.playSound(this.getHurtSound(), this.getSoundVolume(), this.getSoundPitch() + 0.25f);
        }
        if (this.getAttackTarget() != null && this.worldObj.rand.nextInt(5) == 1 && (e = this.getAttackTarget()) != null && this.getDistanceSqToEntity((Entity)e) < (double)(this.width * this.width + e.width * e.width) + 16.0 && (this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(2) == 1)) {
            this.attackEntityAsMob((Entity)e);
        }
        if (this.isPredator) {
            this.setInvisible(true);
        }
        if (this.isInWater() && this.isSuperSwimmer) {
            this.motionX *= 1.25;
            this.motionY *= 1.25;
            this.motionZ *= 1.25;
            if (this.ticksExisted % 20 == 0) {
                this.heal(1.0f);
            }
        }
        if (!this.handleLavaMovement() && this.isLavaSwimmer) {
            this.extinguish();
        }
        if (this.handleLavaMovement() && this.isLavaSwimmer) {
            this.motionX *= 2.0;
            this.motionY *= 2.0;
            this.motionZ *= 2.0;
            if (this.ticksExisted % 5 == 0) {
                this.heal(1.0f);
            }
        }
        if (this.isHealthy) {
            this.setSprinting(true);
        }
        if (this.isShielded && this.getAbsorptionAmount() > 0.0f) {
            this.lastDamage = 300.0f;
            this.maxHurtResistantTime = 30;
        }
        if (this.isWolverine) {
            this.heal(1.0f);
        }
        if (this.isTough) {
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        }
        this.stepHeight = 1.0f;
        this.setBesideClimbableBlock(this.isCollidedHorizontally);
        super.updateAITasks();
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
        }
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

    public boolean attackEntityAsMob(Entity p_70652_1_) {
        if (this.isStrong) {
            p_70652_1_.motionY += 0.6;
            this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        }
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

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
        if (this.worldObj.rand.nextInt(100) == 0) {
            EntitySkeletonMinion entityskeleton = new EntitySkeletonMinion(this.worldObj);
            entityskeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            entityskeleton.onSpawnWithEgg(null);
            this.worldObj.spawnEntityInWorld((Entity)entityskeleton);
            entityskeleton.mountEntity((Entity)this);
        }
        if (this.rand.nextInt(this.worldObj.difficultySetting == EnumDifficulty.NORMAL ? 25 : (this.worldObj.difficultySetting == EnumDifficulty.HARD ? 2 : 500)) == 0) {
            switch (this.rand.nextInt(10)) {
                case 0: {
                    this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, Integer.MAX_VALUE, 1));
                    this.isSpeedy = true;
                    break;
                }
                case 1: {
                    this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, Integer.MAX_VALUE, 4));
                    this.isStrong = true;
                    break;
                }
                case 2: {
                    this.addPotionEffect(new PotionEffect(Potion.invisibility.id, Integer.MAX_VALUE, 0, true));
                    this.isPredator = true;
                    break;
                }
                case 3: {
                    this.addPotionEffect(new PotionEffect(Potion.regeneration.id, Integer.MAX_VALUE, 9));
                    this.isWolverine = true;
                    break;
                }
                case 4: {
                    this.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, Integer.MAX_VALUE, 0));
                    this.isSuperSwimmer = true;
                    break;
                }
                case 5: {
                    this.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0));
                    this.isLavaSwimmer = true;
                    break;
                }
                case 6: {
                    this.addPotionEffect(new PotionEffect(Potion.jump.id, Integer.MAX_VALUE, 2));
                    this.isJumper = true;
                    break;
                }
                case 7: {
                    this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 9));
                    this.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, Integer.MAX_VALUE, 9));
                    this.isHealthy = true;
                    break;
                }
                case 8: {
                    this.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, Integer.MAX_VALUE, 9));
                    this.isShielded = true;
                    break;
                }
                case 9: {
                    this.addPotionEffect(new PotionEffect(Potion.resistance.id, Integer.MAX_VALUE, 2));
                    this.isTough = true;
                }
            }
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
        return p_110161_1_;
    }

    public class EntityAIFindEntityNearestInjuredAlly
    extends EntityAIBase {
        private EntitySpiderMinion field_179434_b;
        private EntityLivingBase field_179433_e;

        public EntityAIFindEntityNearestInjuredAlly(EntitySpiderMinion entityCaveSpiderPriest) {
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
            List list = this.field_179434_b.worldObj.getEntitiesWithinAABB(EntitySpiderMinion.class, this.field_179434_b.boundingBox.expand(d0, d0, d0));
            if (list.isEmpty()) {
                return false;
            }
            for (int i = 0; i < list.size(); ++i) {
                EntitySpiderMinion entity = (EntitySpiderMinion)list.get(i);
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
            return 32.0;
        }
    }

    public static class GroupData
    implements IEntityLivingData {
        public int field_111105_a;

        public void func_111104_a(Random p_111104_1_) {
        }
    }
}

