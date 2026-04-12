/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.eventhandler.Event
 *  net.minecraft.block.Block
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
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntityGolem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.projectile.EntityPotion
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EntityDamageSource
 *  net.minecraft.util.EntityDamageSourceIndirect
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.EnderTeleportEvent
 */
package net.minecraft.entity.titanminion;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import cpw.mods.fml.common.eventhandler.Event;
import java.util.IdentityHashMap;
import java.util.List;
import net.minecraft.block.Block;
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
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAIBreakDoorMinion;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.entity.titanminion.EntityGhastGuardFireball;
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
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityEndermanMinion
extends EntityEnderman
implements IRangedAttackMob,
ITemplar {
    @Deprecated
    private static boolean[] carriableBlocks = new boolean[256];
    private boolean isAggressive;
    public EntityLiving master;
    public int randomSoundDelay;
    private static IdentityHashMap<Block, Boolean> carriable;
    public EntityLiving entityToHeal;
    private int attackPattern;
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 5, 64.0f);
    private float heightOffset = 0.5f;
    private int heightOffsetUpdateTime;
    public int deathTicks;

    public EntityEndermanMinion(World worldIn) {
        super(worldIn);
        this.setSize(0.5f, 2.88f);
        this.stepHeight = 1.0f;
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setEnterDoors(true);
        this.getNavigator().setCanSwim(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityWitherSkull.class, 2.0f, 1.0, 1.75));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityTitanSpirit.class, 48.0f, 1.5, 1.5));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIBreakDoorMinion((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.2));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0, true));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.5));
        this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 16.0f));
        this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(0, (EntityAIBase)new EntityAIFindEntityNearestInjuredAlly(this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, false, ITitan.EnderColossusSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLiving.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public String getCommandSenderName() {
        switch (this.getMinionTypeInt()) {
            case 1: {
                return StatCollector.translateToLocal((String)"entity.EndermanPriest.name");
            }
            case 2: {
                return StatCollector.translateToLocal((String)"entity.EndermanZealot.name");
            }
            case 3: {
                return StatCollector.translateToLocal((String)"entity.EndermanBishop.name");
            }
            case 4: {
                return StatCollector.translateToLocal((String)"entity.EndermanTemplar.name");
            }
        }
        return StatCollector.translateToLocal((String)"entity.EndermanLoyalist.name");
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

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(48.0);
        this.setMinionType(this.getMinionTypeInt());
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != EntityEnderman.class && p_70686_1_ != EntityEndermanMinion.class && p_70686_1_ != EntityEnderColossus.class && p_70686_1_ != EntityDragon.class && p_70686_1_ != EntityDragonMinion.class && p_70686_1_ != EntityEnderColossusCrystal.class;
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
        return this.getMinionTypeInt() == 4 ? (this.isScreaming() ? "thetitans:titanEnderColossusScreamLong" : "thetitans:titanEnderColossusLiving") : (this.isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle");
    }

    protected String getHurtSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanEnderColossusGrunt" : "mob.endermen.hit";
    }

    protected String getDeathSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanEnderColossusDeath" : "mob.endermen.death";
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
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(90.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(9.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45);
            this.setHealth(90.0f);
            this.experienceValue = 30;
        } else if (miniontype == 2) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(700.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
            this.setHealth(700.0f);
            this.experienceValue = 200;
        } else if (miniontype == 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1600.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(40.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
            this.isImmuneToFire = true;
            this.setHealth(1600.0f);
            this.experienceValue = 500;
        } else if (miniontype == 4) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(3000.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(100.0);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.75);
            this.isImmuneToFire = true;
            this.setHealth(3000.0f);
            this.experienceValue = 3000;
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4);
            this.setHealth(60.0f);
            this.experienceValue = 15;
        }
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("MinionType", this.getMinionTypeInt());
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.setMinionType(tagCompund.getInteger("MinionType"));
    }

    protected Entity findPlayerToLookAt() {
        EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity((Entity)this, 64.0);
        if (entityplayer != null && this.isPlayerRegistered(entityplayer) && !entityplayer.capabilities.disableDamage && this.getAttackTarget() == null) {
            this.playSound("mob.endermen.stare", 10.0f, 1.0f);
            this.setScreaming(true);
            this.setAttackTarget((EntityLivingBase)entityplayer);
            this.faceEntity((Entity)entityplayer, 180.0f, 180.0f);
        }
        return null;
    }

    protected boolean isPlayerRegistered(EntityPlayer p_70821_1_) {
        ItemStack itemstack = p_70821_1_.inventory.armorInventory[3];
        if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock((Block)Blocks.pumpkin)) {
            return false;
        }
        Vec3 vec3 = p_70821_1_.getLook(1.0f).normalize();
        Vec3 vec31 = Vec3.createVectorHelper((double)(this.posX - p_70821_1_.posX), (double)(this.boundingBox.minY + (double)this.getEyeHeight() - (p_70821_1_.posY + (double)p_70821_1_.getEyeHeight())), (double)(this.posZ - p_70821_1_.posZ));
        double d0 = vec31.lengthVector();
        double d1 = vec3.dotProduct(vec31 = vec31.normalize());
        return d1 > 1.0 - 0.025 / d0 ? p_70821_1_.canEntityBeSeen((Entity)this) : false;
    }

    public float getEyeHeight() {
        return 2.55f;
    }

    public boolean attackEntityAsMob(Entity p_70652_1_) {
        boolean flag = super.attackEntityAsMob(p_70652_1_);
        if (flag) {
            if (p_70652_1_ instanceof EntityMob || p_70652_1_ instanceof EntityGolem || p_70652_1_ instanceof EntityPlayer) {
                this.teleportRandomly();
            }
            if (p_70652_1_ instanceof EntityLivingBase && this.getMinionTypeInt() >= 3) {
                int b0 = 10;
                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                    b0 = 20;
                } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                    b0 = 30;
                }
                if (b0 > 0) {
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(ClientProxy.electricJudgment.id, b0 * 20, 1));
                }
            }
        }
        return flag;
    }

    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        float f;
        EntityLivingBase e;
        double d1;
        EntityEndermanMinion entitychicken;
        this.entityToAttack = null;
        if (this.getMinionTypeInt() == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(90.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(9.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45);
            this.experienceValue = 30;
        } else if (this.getMinionTypeInt() == 2) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(700.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
            this.experienceValue = 200;
        } else if (this.getMinionTypeInt() == 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1600.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(40.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
            this.isImmuneToFire = true;
            this.experienceValue = 500;
        } else if (this.getMinionTypeInt() == 4) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(3000.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(100.0);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.75);
            this.isImmuneToFire = true;
            this.experienceValue = 3000;
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4);
            this.experienceValue = 15;
        }
        if (this.getMinionTypeInt() == 3) {
            if (this.rand.nextInt(120) == 0 && this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                entitychicken = new EntityEndermanMinion(this.worldObj);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(0);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            }
            if (this.rand.nextInt(240) == 0 && this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                entitychicken = new EntityEndermanMinion(this.worldObj);
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
                    entitychicken = new EntityEndermanMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
                if (this.rand.nextInt(120) == 0) {
                    entitychicken = new EntityEndermanMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(1);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
                if (this.rand.nextInt(240) == 0) {
                    entitychicken = new EntityEndermanMinion(this.worldObj);
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
            if (this.onGround) {
                this.isAirBorne = false;
            }
            if (this.isEntityAlive() && !this.worldObj.isRemote && this.rand.nextInt(1000) == 0 && this.getAttackTarget() != null && this.getHealth() < this.getMaxHealth() / 2.0f && this.master == null) {
                for (int i = 0; i < 16; ++i) {
                    this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    this.worldObj.spawnParticle("magicCrit", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                }
                this.playSound("thetitans:titanland", 10000.0f, 1.0f);
                this.TransformEntity((Entity)this);
            }
            EntityLivingBase entitylivingbase = this.getAttackTarget();
            if (this.attackPattern == 0 && entitylivingbase != null && !this.worldObj.isRemote) {
                if (this.posY < entitylivingbase.posY + (double)entitylivingbase.height + 4.0) {
                    if (this.motionY < 0.0) {
                        this.motionY = 0.0;
                    }
                    this.motionY += 0.5 - this.motionY;
                }
                this.getLookHelper().setLookPositionWithEntity((Entity)entitylivingbase, 180.0f, 40.0f);
                double d0 = entitylivingbase.posX - this.posX;
                d1 = entitylivingbase.posZ - this.posZ;
                double d3 = d0 * d0 + d1 * d1;
                if (d3 > (double)(entitylivingbase.width * entitylivingbase.width + this.width * this.width) + 16.0) {
                    double d5 = MathHelper.sqrt_double((double)d3);
                    this.motionX += d0 / d5 * 0.6 - this.motionX;
                    this.motionZ += d1 / d5 * 0.6 - this.motionZ;
                }
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
        if (this.getAttackTarget() != null && this.worldObj.rand.nextInt(5) == 1 && (e = this.getAttackTarget()) != null && this.getDistanceSqToEntity((Entity)e) < (double)(this.width * this.width + e.width * e.width) + 25.0 && (this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(2) == 1) && this.attackEntityAsMob((Entity)e) && this.rand.nextInt(5) == 0) {
            this.teleportRandomly();
        }
        if (this.getMinionTypeInt() == 2 && this.getAttackTarget() != null) {
            double d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
            if (d0 < 4.0) {
                this.swingItem();
                this.attackEntityAsMob((Entity)this.getAttackTarget());
            }
            if (this.rand.nextInt(40) == 0 && this.onGround && d0 < 256.0 && this.getAttackTarget().posY > this.posY + 3.0) {
                this.teleportToEntity((Entity)this.getAttackTarget());
                this.teleportRandomly();
                this.attackEntityAsMob((Entity)this.getAttackTarget());
            }
        }
        if (this.getMinionTypeInt() == 1 && this.ticksExisted % 40 == 0 && this.entityToHeal != null) {
            if (this.entityToHeal.getHealth() < this.entityToHeal.getMaxHealth()) {
                this.swingItem();
                this.faceEntity((Entity)this.entityToHeal, 180.0f, this.getVerticalFaceSpeed());
                this.entityToHeal.heal(5.0f);
                this.entityToHeal.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 1));
                this.playSound("mob.wither.shoot", 1.0f, 3.0f);
                for (int i = 0; i < 10; ++i) {
                    double d0 = this.rand.nextGaussian() * 0.02;
                    d1 = this.rand.nextGaussian() * 0.02;
                    double d2 = this.rand.nextGaussian() * 0.02;
                    this.worldObj.spawnParticle("heart", this.entityToHeal.posX + (double)(this.rand.nextFloat() * this.entityToHeal.width * 2.0f) - (double)this.entityToHeal.width, this.entityToHeal.posY + 0.5 + (double)(this.rand.nextFloat() * this.entityToHeal.height), this.entityToHeal.posZ + (double)(this.rand.nextFloat() * this.entityToHeal.width * 2.0f) - (double)this.entityToHeal.width, d0, d1, d2);
                }
            } else {
                this.entityToHeal = null;
            }
        }
        this.findPlayerToLookAt();
        if (this.getAttackTarget() != null && this.getAttackTarget().getDistanceSqToEntity((Entity)this) > 256.0 && this.ticksExisted % 30 == 0 && !this.worldObj.isRemote) {
            this.teleportToEntity((Entity)this.getAttackTarget());
        }
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && (f = this.getBrightness(1.0f)) > 0.5f && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double((double)this.posX), MathHelper.floor_double((double)this.posY), MathHelper.floor_double((double)this.posZ)) && this.rand.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {
            this.entityToAttack = null;
            this.setScreaming(false);
            this.isAggressive = false;
            this.teleportRandomly();
        }
        if ((this.isWet() || this.isBurning()) && this.getMinionType() != EnumMinionType.TEMPLAR) {
            this.setAttackTarget(null);
            this.setScreaming(true);
            this.isAggressive = false;
            this.teleportRandomly();
        }
        if (this.isWet() && this.getMinionType() != EnumMinionType.TEMPLAR) {
            this.setScreaming(true);
            this.teleportRandomly();
            this.attackEntityFrom(DamageSource.onFire, 4.0f);
            this.hurtTime = 1;
            this.limbSwingAmount = 1.5f;
            if (this.worldObj.isRemote) {
                for (int i = 0; i < 15; ++i) {
                    if (this.getHealth() <= 20.0f) {
                        this.worldObj.spawnParticle("lava", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    } else {
                        this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    }
                    this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                }
            }
            if (this.rand.nextInt(10) == 0) {
                this.setFire(1);
            }
            if ((this.rand.nextInt(60) == 0 || this.rand.nextInt(10) == 0 && this.getHealth() <= 15.0f) && !this.worldObj.isRemote) {
                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)this, this.posX + (this.rand.nextDouble() * 1.0 - 0.5), this.posY + this.rand.nextDouble() * 3.0, this.posZ + (this.rand.nextDouble() * 1.0 - 0.5), 0.0f, true, true);
            }
            if ((this.rand.nextInt(1000) == 0 || this.getHealth() <= 1.0f) && !this.worldObj.isRemote) {
                this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)this, this.posX, this.posY + 1.0, this.posZ, 2.0f, true, true);
                this.motionY += 3.0;
                this.attackEntityFrom(DamageSource.onFire, Float.MAX_VALUE);
            }
        }
        if (this.getAttackTarget() != null) {
            this.setScreaming(true);
            this.isAggressive = true;
        } else if (!this.isWet() && !this.isBurning() && this.getHealth() <= this.getMaxHealth() / 10.0f) {
            this.setScreaming(false);
            this.isAggressive = false;
        }
        if (this.worldObj.isRemote) {
            for (int i = 0; i < 2; ++i) {
                this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0);
            }
        }
        this.isJumping = false;
        if (this.getAttackTarget() != null && this.getRNG().nextInt(20) == 0 && this.getAttackTarget().getDistanceSqToEntity((Entity)this) < 2.0 && !this.worldObj.isRemote && this.getMinionType() != EnumMinionType.TEMPLAR) {
            this.teleportRandomly();
        }
        if (this.master != null && this.getDistanceSqToEntity((Entity)this.master) > 1024.0 && !this.worldObj.isRemote) {
            this.teleportToEntity((Entity)this.master);
        }
        super.onLivingUpdate();
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    protected void updateAITasks() {
        long perfNs = TitansPerf.begin();
        try {
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.playSound("mob.endermen.scream", this.getSoundVolume(), this.getSoundPitch() + 0.25f);
        }
        if (this.isCollidedHorizontally && this.master != null) {
            this.motionY = 0.2;
        }
        if (this.getAttackTarget() != null && !this.getAttackTarget().isEntityAlive()) {
            this.setAttackTarget(null);
        }
        if (this.master != null) {
            if (this.master.getAttackTarget() != null) {
                if (this.master.getAttackTarget().height < 6.0f) {
                    this.setAttackTarget(this.master.getAttackTarget());
                } else {
                    this.getLookHelper().setLookPositionWithEntity((Entity)this.master.getAttackTarget(), 10.0f, 40.0f);
                }
            }
        } else {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0));
            if (list != null && !list.isEmpty()) {
                for (int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity == null || !(entity instanceof EntityEnderColossus)) continue;
                    this.master = (EntityEnderColossus)entity;
                }
            }
        }
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

    protected boolean teleportRandomly() {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5) * 64.0;
        double d1 = this.posY + (double)(this.rand.nextInt(64) - 32);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5) * 64.0;
        return this.isEntityAlive() && this.teleportTo(d0, d1, d2);
    }

    protected boolean teleportToEntity(Entity p_70816_1_) {
        Vec3 vec3 = Vec3.createVectorHelper((double)(this.posX - p_70816_1_.posX), (double)(this.boundingBox.minY + (double)(this.height / 2.0f) - p_70816_1_.posY + (double)p_70816_1_.getEyeHeight()), (double)(this.posZ - p_70816_1_.posZ));
        vec3 = vec3.normalize();
        double d0 = 16.0;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5) * 8.0 - vec3.xCoord * d0;
        double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5) * 8.0 - vec3.zCoord * d0;
        return this.isEntityAlive() && this.teleportTo(d1, d2, d3);
    }

    protected boolean teleportTo(double p_70825_1_, double p_70825_3_, double p_70825_5_) {
        int k;
        int j;
        EnderTeleportEvent event = new EnderTeleportEvent((EntityLivingBase)this, p_70825_1_, p_70825_3_, p_70825_5_, 0.0f);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return false;
        }
        double d3 = this.posX;
        double d4 = this.posY;
        double d5 = this.posZ;
        this.posX = event.targetX;
        this.posY = event.targetY;
        this.posZ = event.targetZ;
        boolean flag = false;
        int i = MathHelper.floor_double((double)this.posX);
        if (this.worldObj.blockExists(i, j = MathHelper.floor_double((double)this.posY), k = MathHelper.floor_double((double)this.posZ))) {
            boolean flag1 = false;
            while (!flag1 && j > 0) {
                Block block = this.worldObj.getBlock(i, j - 1, k);
                if (block.getMaterial().blocksMovement()) {
                    flag1 = true;
                    continue;
                }
                this.posY -= 1.0;
                --j;
            }
            if (flag1) {
                this.setPosition(this.posX, this.posY, this.posZ);
                if (this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox)) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            this.setPosition(d3, d4, d5);
            return false;
        }
        int short1 = 128;
        for (int l = 0; l < short1; ++l) {
            double d6 = (double)l / ((double)short1 - 1.0);
            float f = (this.rand.nextFloat() - 0.5f) * 0.2f;
            float f1 = (this.rand.nextFloat() - 0.5f) * 0.2f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 0.2f;
            double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5) * (double)this.width * 2.0;
            double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
            double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5) * (double)this.width * 2.0;
            this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
            if (!this.isWet()) continue;
            if (this.getHealth() <= 20.0f) {
                this.worldObj.spawnParticle("lava", d7, d8, d9, (double)f, (double)f1, (double)f2);
            } else {
                this.worldObj.spawnParticle("flame", d7, d8, d9, (double)f, (double)f1, (double)f2);
            }
            this.worldObj.spawnParticle("largesmoke", d7, d8, d9, (double)f, (double)f1, (double)f2);
        }
        this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0f, 1.0f);
        this.playSound("mob.endermen.portal", 1.0f, 1.0f);
        return true;
    }

    protected Item getDropItem() {
        return Items.ender_pearl;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int k;
        super.dropFewItems(p_70628_1_, p_70628_2_);
        int j = this.rand.nextInt(2 + p_70628_2_);
        for (k = 0; k < j; ++k) {
            this.dropItem(Items.ender_eye, 1);
        }
        j = this.rand.nextInt(3 + p_70628_2_);
        for (k = 0; k < j; ++k) {
            this.dropItem(Items.coal, 1);
        }
        if (this.rand.nextInt(5) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0) {
            this.entityDropItem(new ItemStack(Blocks.end_stone), 0.0f);
        }
        if (this.rand.nextInt(20) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0) {
            this.entityDropItem(new ItemStack(Blocks.obsidian), 0.0f);
        }
        if (this.getMinionTypeInt() >= 1) {
            j = 1 + this.rand.nextInt(4);
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
                    if (this.rand.nextInt(10) == 0) {
                        this.entityDropItem(new ItemStack(Items.golden_apple, 1, 1), 0.0f);
                        continue;
                    }
                    this.dropItem(Items.golden_apple, 1);
                }
                if (this.getMinionTypeInt() >= 3) {
                    j = this.rand.nextInt(2);
                    if (p_70628_2_ > 0) {
                        j += this.rand.nextInt(p_70628_2_ + 1);
                    }
                    block16: for (k = 0; k < j; ++k) {
                        switch (this.rand.nextInt(5)) {
                            case 0: {
                                this.entityDropItem(new ItemStack(Blocks.emerald_block, 1, 0), 0.0f);
                                continue block16;
                            }
                            case 1: {
                                this.entityDropItem(new ItemStack(Blocks.diamond_block, 1, 0), 0.0f);
                                continue block16;
                            }
                            case 2: {
                                this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                                continue block16;
                            }
                            case 3: {
                                this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                                continue block16;
                            }
                            case 4: {
                                this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                            }
                        }
                    }
                    this.entityDropItem(new ItemStack(Blocks.obsidian), 0.0f);
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
                        block17: for (k = 0; k < j; ++k) {
                            switch (this.rand.nextInt(3)) {
                                case 0: {
                                    this.entityDropItem(new ItemStack(Blocks.emerald_block, 1, 0), 0.0f);
                                    continue block17;
                                }
                                case 1: {
                                    this.entityDropItem(new ItemStack(Blocks.diamond_block, 1, 0), 0.0f);
                                    continue block17;
                                }
                                case 2: {
                                    this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                                }
                            }
                        }
                        this.entityDropItem(new ItemStack(Blocks.obsidian), 0.0f);
                    }
                }
            }
        }
    }

    protected void fall(float p_70069_1_) {
        if (this.getMinionTypeInt() != 4) {
            super.fall(p_70069_1_);
        }
        this.moveForward = 0.0f;
        this.moveStrafing = 0.0f;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity;
        if (source instanceof EntityDamageSourceIndirect) {
            this.isAggressive = false;
            if (!this.worldObj.isRemote && this.getMinionType() != EnumMinionType.TEMPLAR) {
                for (int i = 0; i < 64; ++i) {
                    this.teleportRandomly();
                }
            }
            return false;
        }
        if (this.isEntityInvulnerable() || this.getMinionTypeInt() >= 4 && source == DamageSourceExtra.radiation) {
            return false;
        }
        if (source.getEntity() instanceof EntityEndermanMinion || source.getEntity() instanceof EntityEnderColossus || source.getEntity() instanceof EntityDragon) {
            return false;
        }
        if (source.getEntity() != null && this.moveStrafing == 0.0f && this.getMinionType() == EnumMinionType.ZEALOT) {
            this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
            this.playSound("thetitans:titanSwing", 1.0f, 2.0f);
            if (this.rand.nextInt(2) == 0) {
                this.teleportRandomly();
            } else {
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
            }
            this.jump();
            return false;
        }
        if (source.getEntity() == null) {
            if (!this.worldObj.isRemote) {
                this.setScreaming(true);
            }
            if (source instanceof EntityDamageSource && source.getEntity() instanceof EntityPlayer) {
                if (source.getEntity() instanceof EntityPlayerMP && ((EntityPlayerMP)source.getEntity()).theItemInWorldManager.isCreative()) {
                    this.setScreaming(false);
                } else {
                    this.isAggressive = true;
                }
            }
        }
        boolean flag = super.attackEntityFrom(source, amount);
        if (this.rand.nextInt(2) != 0 && this.getMinionType() != EnumMinionType.TEMPLAR) {
            this.teleportRandomly();
        }
        if ((entity = source.getEntity()) instanceof EntityLivingBase) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(64.0, 64.0, 64.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1 instanceof EntityEndermanMinion) {
                    EntityEndermanMinion entitypigzombie = (EntityEndermanMinion)entity1;
                    entitypigzombie.setAttackTarget((EntityLivingBase)entity);
                    entitypigzombie.setRevengeTarget((EntityLivingBase)entity);
                    entitypigzombie.randomSoundDelay = this.rand.nextInt(40);
                }
                this.setAttackTarget((EntityLivingBase)entity);
                this.setRevengeTarget((EntityLivingBase)entity);
                this.randomSoundDelay = this.rand.nextInt(40);
            }
        }
        return flag;
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

    public static void setCarriable(Block block, boolean canCarry) {
        if (carriable == null) {
            carriable = new IdentityHashMap(4096);
        }
        carriable.put(block, canCarry);
    }

    public static boolean getCarriable(Block block) {
        Boolean ret = carriable.get(block);
        return ret != null ? ret : false;
    }

    @Override
    public void TransformEntity(Entity entity) {
        net.minecraft.theTitans.util.FastExplosion.newExplosion(entity.worldObj, entity, entity.posX, entity.posY, entity.posZ, 45.0f, true, entity.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        EntityEnderColossus entitytitan = new EntityEnderColossus(entity.worldObj);
        entitytitan.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, 0.0f);
        entity.setDead();
        entitytitan.func_82206_m();
        entity.worldObj.spawnEntityInWorld((Entity)entitytitan);
        entitytitan.playSound("thetitans:titanEnderColossusRoar", 100.0f, 0.5f);
        entitytitan.setRoarCooldownTimer(1310);
        entitytitan.setScreaming(true);
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.swingItem();
        if (this.getDistanceSqToEntity((Entity)p_82196_1_) < (double)(this.width * this.width + p_82196_1_.width * p_82196_1_.width) + 45.0) {
            this.attackEntityAsMob((Entity)p_82196_1_);
        } else {
            switch (this.rand.nextInt(5)) {
                case 0: {
                    net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)this, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ, 1.0f * p_82196_1_.width, false, false);
                    p_82196_1_.attackEntityFrom(DamageSourceExtra.lightningBolt, 49.0f);
                    this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                    break;
                }
                case 1: {
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
                    break;
                }
                case 2: {
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
                    break;
                }
                case 3: {
                    for (int i = 0; i < 50; ++i) {
                        double d01 = this.getDistanceSqToEntity((Entity)p_82196_1_);
                        double d11 = p_82196_1_.posX - this.posX;
                        double d21 = p_82196_1_.boundingBox.minY + (double)(p_82196_1_.height / 2.0f) - (this.posY + (double)(p_82196_1_.height / 2.0f));
                        double d31 = p_82196_1_.posZ - this.posZ;
                        EntityGhastGuardFireball entitysmallfireball = new EntityGhastGuardFireball(this.worldObj, (EntityLivingBase)this, d11 + this.getRNG().nextGaussian() * 9.0, d21, d31 + this.getRNG().nextGaussian() * 9.0);
                        entitysmallfireball.posY = this.posY + 2.0;
                        this.worldObj.spawnEntityInWorld((Entity)entitysmallfireball);
                    }
                    break;
                }
                case 4: {
                    net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)this, p_82196_1_.posX, p_82196_1_.posY + 1.0, p_82196_1_.posZ, 2.0f, false, false);
                    p_82196_1_.attackEntityFrom(DamageSourceExtra.lightningBolt, 100.0f);
                    this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                    this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                    this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                    this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                }
            }
        }
    }

    static {
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.grass)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.dirt)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.sand)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.gravel)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.yellow_flower)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.red_flower)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.brown_mushroom)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.red_mushroom)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.tnt)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.cactus)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.clay)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.pumpkin)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.melon_block)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.mycelium)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.crafting_table)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.diamond_block)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.furnace)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.lit_furnace)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.chest)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.gold_block)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.log)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.log2)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.leaves)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.leaves2)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.iron_block)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.planks)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.torch)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.anvil)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.brewing_stand)] = true;
        EntityEndermanMinion.carriableBlocks[Block.getIdFromBlock((Block)Blocks.bookshelf)] = true;
        for (int x = 0; x < carriableBlocks.length; ++x) {
            if (!carriableBlocks[x]) continue;
            EntityEndermanMinion.setCarriable(Block.getBlockById((int)x), true);
        }
    }

    public class EntityAIFindEntityNearestInjuredAlly
    extends EntityAIBase {
        private EntityEndermanMinion field_179434_b;
        private EntityLivingBase field_179433_e;

        public EntityAIFindEntityNearestInjuredAlly(EntityEndermanMinion entityCaveSpiderPriest) {
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
            List list = this.field_179434_b.worldObj.getEntitiesWithinAABB(EntityEndermanMinion.class, this.field_179434_b.boundingBox.expand(d0, d0, d0));
            if (list.isEmpty()) {
                return false;
            }
            for (int i = 0; i < list.size(); ++i) {
                EntityEndermanMinion entity = (EntityEndermanMinion)list.get(i);
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
                this.field_179433_e = null;
                return false;
            }
            if (entitylivingbase.getHealth() >= entitylivingbase.getMaxHealth()) {
                this.field_179433_e = null;
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
            return 48.0;
        }
    }
}

