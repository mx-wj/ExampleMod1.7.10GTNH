/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.common.Loader
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProviderHell
 *  thehippomaster.MutantCreatures.MutantSkeleton
 */
package net.minecraft.entity.titan;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.Loader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityLightningBall;
import net.minecraft.entity.titan.EntitySkeletonTitanGiantArrow;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWebShot;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.entity.titan.IEntityMultiPartTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAttack1;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAttack2;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAttack3;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAttack4;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAttack5;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanCreation;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanDeath;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanLightningHand;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanLightningSword;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanRangedAttack1;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanRangedAttack2;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanStun;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.entity.titanminion.EntityWitherMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.MutantCreatures.MutantSkeleton;

public class EntitySkeletonTitan
extends EntityTitan
implements IRangedAttackMob,
IAnimatedEntity,
IEntityMultiPartTitan {
    public boolean shouldBeWitherSkeleton;
    public int attackTimer;
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart pelvis;
    public EntityTitanPart spine;
    public EntityTitanPart ribCage;
    public EntityTitanPart rightArm;
    public EntityTitanPart leftArm;
    public EntityTitanPart rightLeg;
    public EntityTitanPart leftLeg;

    public EntitySkeletonTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0f, 8.0f);
        this.pelvis = new EntityTitanPart(worldIn, this, "pelvis", 8.0f, 6.0f);
        this.spine = new EntityTitanPart(worldIn, this, "spine", 2.0f, 12.0f);
        this.ribCage = new EntityTitanPart(worldIn, this, "ribcage", 8.0f, 8.0f);
        this.rightArm = new EntityTitanPart(worldIn, this, "rightarm", 2.0f, 2.0f);
        this.leftArm = new EntityTitanPart(worldIn, this, "leftarm", 2.0f, 2.0f);
        this.rightLeg = new EntityTitanPart(worldIn, this, "rightleg", 2.0f, 12.0f);
        this.leftLeg = new EntityTitanPart(worldIn, this, "leftleg", 2.0f, 12.0f);
        this.partArray = new EntityTitanPart[]{this.head, this.pelvis, this.spine, this.ribCage, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg};
        if (this.getSkeletonType() == 1) {
            this.setSize(14.0f, 56.0f);
            this.experienceValue = 50000;
        }
        this.setSize(8.0f, 32.0f);
        this.experienceValue = 20000;
        if (worldIn != null && !worldIn.isRemote) {
            this.setCombatTask();
        }
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        worldIn.spawnEntityInWorld((Entity)this.head);
        worldIn.spawnEntityInWorld((Entity)this.pelvis);
        worldIn.spawnEntityInWorld((Entity)this.spine);
        worldIn.spawnEntityInWorld((Entity)this.ribCage);
        worldIn.spawnEntityInWorld((Entity)this.rightArm);
        worldIn.spawnEntityInWorld((Entity)this.leftArm);
        worldIn.spawnEntityInWorld((Entity)this.rightLeg);
        worldIn.spawnEntityInWorld((Entity)this.leftLeg);
    }

    @Override
    protected void applyEntityAI() {
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanCreation(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanDeath(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanLightningHand(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanLightningSword(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanStun(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanAttack3(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanAttack2(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanRangedAttack1(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanRangedAttack2(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanAttack5(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanAttack1(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanAttack4(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSkeletonTitanAntiTitanAttack(this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SkeletonTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public boolean isArmored() {
        return this.getHealth() <= this.getMaxHealth() / 4.0f || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != ((Object)((Object)this.head)).getClass() && p_70686_1_ != ((Object)((Object)this.pelvis)).getClass() && p_70686_1_ != ((Object)((Object)this.rightArm)).getClass() && p_70686_1_ != ((Object)((Object)this.leftArm)).getClass() && p_70686_1_ != ((Object)((Object)this.rightLeg)).getClass() && p_70686_1_ != ((Object)((Object)this.leftLeg)).getClass() && p_70686_1_ != EntitySkeletonMinion.class && p_70686_1_ != EntitySkeletonTitan.class && p_70686_1_ != EntitySkeletonTitanGiantArrow.class && p_70686_1_ != EntityWitherMinion.class || Loader.isModLoaded((String)"MutantCreatures") && p_70686_1_ == MutantSkeleton.class;
    }

    @Override
    public int getMinionCap() {
        return 160;
    }

    @Override
    public int getPriestCap() {
        return 90;
    }

    @Override
    public int getZealotCap() {
        return 40;
    }

    @Override
    public int getBishopCap() {
        return 20;
    }

    @Override
    public int getTemplarCap() {
        return 10;
    }

    @Override
    public int getSpecialMinionCap() {
        return 6;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(100) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    @Override
    public int getMinionSpawnRate() {
        if (this.getSkeletonType() == 1) {
            return TheTitans.WitherSkeletonTitanMinionSpawnrate;
        }
        return TheTitans.SkeletonTitanMinionSpawnrate;
    }

    @Override
    public float getRenderSizeModifier() {
        float f = 16.0f;
        if (this.getSkeletonType() == 1) {
            f *= 1.2f;
        }
        return f;
    }

    @Override
    public int getParticleCount() {
        if (this.getSkeletonType() == 1) {
            return 48;
        }
        return super.getParticleCount();
    }

    @Override
    public String getParticles() {
        if (this.getSkeletonType() == 1) {
            this.shouldParticlesBeUpward = true;
            return "largesmoke";
        }
        return super.getParticles();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(140.0);
    }

    @Override
    public boolean canBeHurtByPlayer() {
        return this.isStunned && !this.isEntityInvulnerable();
    }

    public boolean isEntityUndead() {
        return true;
    }

    @Override
    public EnumTitanStatus getTitanStatus() {
        return this.getSkeletonType() == 1 ? EnumTitanStatus.GREATER : EnumTitanStatus.AVERAGE;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, (Object)Byte.valueOf((byte)0));
    }

    @Override
    public int getFootStepModifer() {
        return this.getSkeletonType() == 1 ? 2 : 3;
    }

    protected String getLivingSound() {
        return this.isStunned || this.getWaiting() || this.animID == 13 ? null : (this.getSkeletonType() == 1 ? "thetitans:titanWitherSkeletonLiving" : "thetitans:titanSkeletonLiving");
    }

    @Override
    protected String getHurtSound() {
        return this.getSkeletonType() == 1 ? "thetitans:titanWitherSkeletonGrunt" : "thetitans:titanSkeletonGrunt";
    }

    @Override
    protected String getDeathSound() {
        return this.getSkeletonType() == 1 ? "thetitans:titanWitherSkeletonDeath" : "thetitans:titanSkeletonDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.playSound("thetitans:titanStep", 10.0f, 1.0f);
        this.playSound("mob.skeleton.step", 10.0f, 0.5f);
        this.shakeNearbyPlayerCameras(4000.0);
        if (!this.getWaiting() && this.animID != 13) {
            float f3 = this.rotationYaw * (float)Math.PI / 180.0f;
            float f11 = MathHelper.sin((float)f3);
            float f4 = MathHelper.cos((float)f3);
            if (this.footID == 0) {
                this.destroyBlocksInAABB(this.rightLeg.boundingBox.offset(0.0, -1.0, 0.0));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(1.0, 1.0, 1.0).offset((double)(f11 * 4.0f), 0.0, (double)(f4 * 4.0f))));
                ++this.footID;
            } else {
                this.destroyBlocksInAABB(this.leftLeg.boundingBox.offset(0.0, -1.0, 0.0));
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(1.0, 1.0, 1.0).offset((double)(f11 * 4.0f), 0.0, (double)(f4 * 4.0f))));
                this.footID = 0;
            }
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        return false;
    }

    @Override
    public double getSpeed() {
        return this.getSkeletonType() == 1 ? 0.4 + (double)this.getExtraPower() * 0.001 : 0.3 + (double)this.getExtraPower() * 0.001;
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    public void becomeWitherSkeleton(boolean skelly) {
        if (skelly) {
            this.setSkeletonType(1);
            this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
        }
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && !this.getWaiting() && this.getAttackTarget() != null ? super.shouldMove() : false;
    }

    @Override
    public double getMeleeRange() {
        return (double)(this.width * this.width + (this.getAttackTarget().width > 48.0f ? 2304.0f : this.getAttackTarget().width * this.getAttackTarget().width)) + (this.getSkeletonType() == 1 ? 2000.0 : 800.0);
    }

    @Override
    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        List list;
        double dz;
        double dx;
        Vec3 vec3;
        this.setCombatTask();
        if (this.ticksExisted == 1) {
            this.setSkeletonType(this.getSkeletonType());
        }
        float dis = this.getSkeletonType() == 1 ? 32.0f : 16.0f;
        float xfac = MathHelper.sin((float)(this.renderYawOffset * (float)Math.PI / 180.0f));
        float zfac = MathHelper.cos((float)(this.renderYawOffset * (float)Math.PI / 180.0f));
        if (!(this.isRiding() || this.getWaiting() || this.isStunned || this.animID != 0)) {
            if (this.getAttackTarget() != null) {
                double d = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
                double d2 = this.getMeleeRange();
                double d3 = !this.getAttackTarget().onGround ? 1000.0 : 8000.0;
                if (d > d2 + d3) {
                    if (this.posY <= this.getAttackTarget().posY + 12.0 && this.posY < 256.0 - (double)this.height) {
                        this.fallDistance = 0.0f;
                        this.motionY += 0.9 - this.motionY;
                        if (this.motionY < 0.0) {
                            this.motionY = 0.0;
                        }
                    }
                    this.motionY *= 0.6;
                }
            }
            if (!this.onGround) {
                float f = (this.rand.nextFloat() - 0.5f) * (this.getSkeletonType() == 1 ? 30.0f : 10.0f);
                float f1 = (this.rand.nextFloat() - 0.5f) * 1.0f;
                float f2 = (this.rand.nextFloat() - 0.5f) * (this.getSkeletonType() == 1 ? 30.0f : 10.0f);
                this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + (this.getSkeletonType() == 1 ? 15.0 : 5.0) + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            }
        }
        if (this.getWaiting()) {
            AnimationAPI.sendAnimPacket(this, 0);
            AnimationAPI.sendAnimPacket(this, 13);
            this.setAnimTick(0);
            EntityPlayer player = this.worldObj.getClosestPlayerToEntity((Entity)this, 16.0);
            if (player != null) {
                this.setWaiting(false);
                this.faceEntity((Entity)player, 180.0f, 0.0f);
                player.triggerAchievement((StatBase)TitansAchievments.locateTitan);
            }
        } else {
            if (this.getAnimID() == 13) {
                this.motionX = 0.0;
                this.motionZ = 0.0;
                if (this.motionY > 0.0) {
                    this.motionY = 0.0;
                }
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 1) {
                this.playSound("thetitans:titanBirth", 1000.0f, this.getSkeletonType() == 1 ? 0.875f : 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 10) {
                this.playSound("thetitans:titanSkeletonAwaken", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 100) {
                this.playSound("thetitans:titanRumble", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 160) {
                this.playSound("thetitans:titanSkeletonBeginMove", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 280) {
                this.playSound("thetitans:titanQuake", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 300) {
                this.playSound("thetitans:titanRumble", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 520) {
                this.playSound("thetitans:titanSkeletonGetUp", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && (this.getAnimTick() == 230 || this.getAnimTick() == 550 || this.getAnimTick() == 590 || this.getAnimTick() == 610)) {
                this.func_145780_a(0, 0, 0, Blocks.stone);
                this.playSound("thetitans:titanPress", this.getSoundVolume(), 1.0f);
            }
        }
        EntityPlayer player = this.worldObj.getClosestPlayerToEntity((Entity)this, -1.0);
        if (player instanceof EntityPlayer && player != null && this.getAttackTarget() != null && player == this.getAttackTarget() && this.getSkeletonType() == 1) {
            if (this.rand.nextInt(200) == 0 && this.getHealth() <= this.getMaxHealth() / 100.0f) {
                player.attackEntityFrom(DamageSourceExtra.wither.setDamageIsAbsolute().setDamageAllowedInCreativeMode(), Float.MAX_VALUE);
            }
            if (player.getAbsorptionAmount() <= 0.0f && this.ticksExisted % 10 == 0) {
                player.attackEntityFrom(DamageSourceExtra.wither.setDamageIsAbsolute().setDamageAllowedInCreativeMode(), 12.0f);
                player.addPotionEffect(new PotionEffect(ClientProxy.advancedWither.id, 1200));
                player.addPotionEffect(new PotionEffect(Potion.wither.id, 1200, 3));
                player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 400, 9));
                if (player.getHealth() <= 5.0f) {
                    player.addPotionEffect(new PotionEffect(Potion.blindness.id, 400, 1));
                }
            } else if (player.getAbsorptionAmount() >= 0.0f && this.ticksExisted % 40 == 0) {
                player.attackEntityFrom(DamageSourceExtra.wither.setDamageIsAbsolute().setDamageAllowedInCreativeMode(), 12.0f);
            }
        }
        if (this.isStunned) {
            this.setAttackTarget(null);
            AnimationAPI.sendAnimPacket(this, 8);
            this.setAnimID(8);
        }
        if (this.animID == 8) {
            if (this.animTick == 70) {
                this.playSound("thetitans:groundSmash", 8.0f, 0.9f);
                this.playSound("thetitans:titanFall", 10.0f, 1.0f);
            }
            if (this.animTick == 74) {
                this.playSound("thetitans:distantLargeFall", 10000.0f, 1.0f);
                this.playSound(this.getHurtSound(), this.getSoundVolume(), this.getSoundPitch());
            }
            if (this.animTick == 480) {
                this.playSound("thetitans:titanFall", 10.0f, 1.0f);
                this.playSound("thetitans:titanStep", 10.0f, 1.0f);
                this.playSound("mob.skeleton.step", 10.0f, 0.5f);
                this.playSound("thetitans:titanStep", 10.0f, 1.0f);
                this.playSound("mob.skeleton.step", 10.0f, 0.5f);
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(16.0, 1.0, 16.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(16.0, 1.0, 16.0)));
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(16.0, 1.0, 16.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(16.0, 1.0, 16.0)));
            }
            if (this.animTick == 450) {
                this.isStunned = false;
            } else {
                this.setAttackTarget(null);
            }
        }
        if (this.animID == 10) {
            if (this.animTick == 30 || this.animTick == 70) {
                this.playSound("thetitans:titanStep", 10.0f, 1.0f);
            }
            if (this.animTick == 190) {
                this.playSound("thetitans:titanFall", 20.0f, 1.0f);
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(16.0, 1.0, 16.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(16.0, 1.0, 16.0)));
            }
            if (this.animTick == 200) {
                this.playSound("thetitans:distantLargeFall", 10000.0f, 1.0f);
            }
        }
        if (this.getAnimID() == 9 && this.getAnimTick() <= 50 && this.getAnimTick() >= 26) {
            this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
            double d8 = this.getAnimTick() - 4;
            vec3 = this.getLook(1.0f);
            dx = vec3.xCoord * d8;
            dz = vec3.zCoord * d8;
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (double)dis + 4.0, this.posZ + dz, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
        }
        if ((this.getAnimID() == 9 && this.getAnimTick() == 48 || this.getAnimID() == 5 && this.getAnimTick() == 230 + this.rand.nextInt(100)) && this.getAttackTarget() != null) {
            double d8 = 46.0;
            vec3 = this.getLook(1.0f);
            dx = vec3.xCoord * d8;
            dz = vec3.zCoord * d8;
            float da = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.getKnockbackAmount();
            this.attackChoosenEntity((Entity)this.getAttackTarget(), da * 3.0f, i);
            this.getAttackTarget().motionY += (double)(2.0f + this.rand.nextFloat());
            this.worldObj.newExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 6.0f, false, false);
            this.worldObj.newExplosion((Entity)this, this.posX + dx, this.posY + (double)dis + 4.0, this.posZ + dz, 3.0f, false, false);
            this.getAttackTarget().attackEntityFrom(DamageSourceExtra.lightningBolt, da);
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (double)dis + 4.0, this.posZ + dz, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (double)dis + 4.0, this.posZ + dz, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (double)dis + 4.0, this.posZ + dz, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (double)dis + 4.0, this.posZ + dz, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
            for (int i1 = 0; i1 < 3; ++i1) {
                List list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getAttackTarget(), this.getAttackTarget().boundingBox.expand(16.0, 16.0, 16.0));
                if (list1 == null || list1.isEmpty()) continue;
                for (int i11 = 0; i11 < list1.size(); ++i11) {
                    Entity entity1 = (Entity)list1.get(i11);
                    if (!(entity1 instanceof EntityLivingBase) || !this.canAttackClass(entity1.getClass())) continue;
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
                    this.attackChoosenEntity(entity1, da, i);
                    entity1.motionY += 2.0 + this.rand.nextDouble();
                }
            }
        }
        if (this.getAnimID() == 12 && this.getAnimTick() == 40) {
            this.playSound("random.explode", 20.0f, 2.0f);
            this.playSound("mob.wither.shoot", 20.0f, 1.0f);
            float da = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.getKnockbackAmount();
            this.worldObj.newExplosion((Entity)this, this.posX - (double)xfac * ((double)dis * 0.9), this.posY + (double)dis * 1.25, this.posZ + (double)zfac * ((double)dis * 0.9), 3.0f, false, false);
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX - (double)xfac * ((double)dis * 0.9), this.posY + (double)dis * 1.25, this.posZ + (double)zfac * ((double)dis * 0.9), this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
            if (this.getAttackTarget() != null) {
                this.attackChoosenEntity((Entity)this.getAttackTarget(), da * 5.0f, i);
                this.getAttackTarget().attackEntityFrom(DamageSourceExtra.lightningBolt, da);
                this.getAttackTarget().motionY += 1.0 + this.rand.nextDouble();
                this.worldObj.newExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 3.0f, false, false);
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f, this.getSkeletonType() == 1 ? 0.0f : 0.5f));
            }
        }
        if (this.getAnimID() == 7 && this.getAnimTick() == 92 && !AnimationAPI.isEffectiveClient()) {
            int z;
            int y = MathHelper.floor_double((double)this.posY);
            int x = MathHelper.floor_double((double)(this.posX - (double)(xfac * (dis * 2.0f))));
            if (this.worldObj.getBlock(x, y - 1, z = MathHelper.floor_double((double)(this.posZ + (double)(zfac * (dis * 2.0f))))).getMaterial() != Material.air) {
                this.playSound("thetitans:titanStrike", 20.0f, 1.0f);
                this.playSound("thetitans:titanSlam", 20.0f, 1.0f);
                this.playSound("thetitans:titanPress", 100.0f, 1.0f);
            }
            for (int l1 = -4; l1 <= 4; ++l1) {
                for (int i2 = -4; i2 <= 4; ++i2) {
                    for (int j = -1; j <= 1; ++j) {
                        int j2 = x + l1;
                        int k = y + j;
                        int l = z + i2;
                        Block block = this.worldObj.getBlock(j2, k, l);
                        if (!block.isAir((IBlockAccess)this.worldObj, j2, k, l)) {
                            this.worldObj.playAuxSFX(2001, j2, k, l, Block.getIdFromBlock((Block)block));
                            if (block == Blocks.grass) {
                                this.worldObj.setBlock(j2, k, l, Blocks.dirt);
                            }
                        }
                        if (!(block.getExplosionResistance((Entity)this) > 500.0f) || !block.isOpaqueCube()) continue;
                        AnimationAPI.sendAnimPacket(this, 8);
                        this.setAnimID(8);
                        this.setAnimTick(0);
                        this.playSound("random.anvil_land", 20.0f, 0.5f);
                        this.isStunned = true;
                    }
                }
            }
        }
        if (this.getSkeletonType() == 1) {
            this.setSize(14.0f, 56.0f);
        } else {
            this.setSize(8.0f, 32.0f);
        }
        float f = this.renderYawOffset * (float)Math.PI / 180.0f;
        float f1 = MathHelper.sin((float)f);
        float f2 = MathHelper.cos((float)f);
        if (this.ticksExisted > 5) {
            this.head.setLocationAndAngles(this.posX, this.posY + (this.getSkeletonType() == 1 ? 42.0 : 24.0), this.posZ, 0.0f, 0.0f);
            this.pelvis.setLocationAndAngles(this.posX, this.posY + (this.getSkeletonType() == 1 ? 21.0 : 12.0), this.posZ, 0.0f, 0.0f);
            this.spine.setLocationAndAngles(this.posX + (double)f1 * (this.getSkeletonType() == 1 ? 3.5 : 2.0), this.posY + (this.getSkeletonType() == 1 ? 21.0 : 12.0), this.posZ - (double)f2 * (this.getSkeletonType() == 1 ? 3.5 : 2.0), 0.0f, 0.0f);
            this.ribCage.setLocationAndAngles(this.posX, this.posY + (this.getSkeletonType() == 1 ? 33.25 : 19.0), this.posZ, 0.0f, 0.0f);
            this.rightArm.setLocationAndAngles(this.posX + (double)f2 * (this.getSkeletonType() == 1 ? 8.75 : 5.0), this.posY + (this.getSkeletonType() == 1 ? 20.125 : 11.5), this.posZ + (double)f1 * (this.getSkeletonType() == 1 ? 8.75 : 5.0), 0.0f, 0.0f);
            this.leftArm.setLocationAndAngles(this.posX - (double)f2 * (this.getSkeletonType() == 1 ? 8.75 : 5.0), this.posY + (this.getSkeletonType() == 1 ? 20.125 : 11.5), this.posZ - (double)f1 * (this.getSkeletonType() == 1 ? 8.75 : 5.0), 0.0f, 0.0f);
            this.rightLeg.setLocationAndAngles(this.posX + (double)f2 * (this.getSkeletonType() == 1 ? 3.5 : 2.0), this.posY, this.posZ + (double)f1 * (this.getSkeletonType() == 1 ? 3.5 : 2.0), 0.0f, 0.0f);
            this.leftLeg.setLocationAndAngles(this.posX - (double)f2 * (this.getSkeletonType() == 1 ? 3.5 : 2.0), this.posY, this.posZ - (double)f1 * (this.getSkeletonType() == 1 ? 3.5 : 2.0), 0.0f, 0.0f);
            if (this.isEntityAlive() && !this.isStunned) {
                this.collideWithEntities(this.head, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.head.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.pelvis, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.pelvis.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.spine, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.spine.boundingBox));
                this.collideWithEntities(this.ribCage, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.ribCage.boundingBox));
                this.collideWithEntities(this.rightArm, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightArm.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.leftArm, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftArm.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(1.0, 0.0, 1.0)));
            }
            this.destroyBlocksInAABB(this.head.boundingBox);
            this.destroyBlocksInAABB(this.pelvis.boundingBox);
            this.destroyBlocksInAABB(this.spine.boundingBox);
            this.destroyBlocksInAABB(this.ribCage.boundingBox);
            this.destroyBlocksInAABB(this.rightArm.boundingBox);
            this.destroyBlocksInAABB(this.leftArm.boundingBox);
            this.destroyBlocksInAABB(this.leftLeg.boundingBox);
            this.destroyBlocksInAABB(this.rightLeg.boundingBox);
            for (int i = 0; i < this.partArray.length; ++i) {
                List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.partArray[i].boundingBox.expand(0.5, 0.5, 0.5));
                if (list2 == null || list2.isEmpty()) continue;
                for (int j = 0; j < list2.size(); ++j) {
                    Entity entity = (Entity)list2.get(j);
                    if (entity instanceof EntityFireball && ((EntityFireball)entity).shootingEntity != this && !(entity instanceof EntityLightningBall) && !(entity instanceof EntityGargoyleTitanFireball) && !(entity instanceof EntityWebShot)) {
                        ((EntityFireball)entity).attackEntityFrom(DamageSource.causeThornsDamage((Entity)this), 0.0f);
                    }
                    if (entity instanceof EntityTitanFireball && ((EntityTitanFireball)entity).shootingEntity != null && ((EntityTitanFireball)entity).shootingEntity != this) {
                        ((EntityTitanFireball)entity).onImpactPublic((EntityLivingBase)this);
                    }
                    if (entity instanceof EntityGargoyleTitanFireball) {
                        this.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                        this.worldObj.newExplosion((Entity)(((EntityGargoyleTitanFireball)entity).shootingEntity != null ? ((EntityGargoyleTitanFireball)entity).shootingEntity : (EntityGargoyleTitanFireball)entity), ((EntityGargoyleTitanFireball)entity).posX, ((EntityGargoyleTitanFireball)entity).posY, ((EntityGargoyleTitanFireball)entity).posZ, 8.0f, false, false);
                        this.attackEntityFromPart(this.partArray[i], DamageSource.causeFireballDamage((EntityFireball)((EntityGargoyleTitanFireball)entity), (Entity)(((EntityGargoyleTitanFireball)entity).shootingEntity != null ? ((EntityGargoyleTitanFireball)entity).shootingEntity : (EntityGargoyleTitanFireball)entity)), 1000.0f);
                        entity.setDead();
                    }
                    if (entity instanceof EntityHarcadiumArrow) {
                        this.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                        this.attackEntityFromPart(this.partArray[i], DamageSourceExtra.causeHarcadiumArrowDamage((EntityHarcadiumArrow)entity, (Entity)(((EntityHarcadiumArrow)entity).shootingEntity != null ? ((EntityHarcadiumArrow)entity).shootingEntity : (EntityHarcadiumArrow)entity)), 500.0f);
                        entity.setDead();
                    }
                    if (!(entity instanceof EntityWebShot) || ((EntityWebShot)entity).shootingEntity == this) continue;
                    this.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                    this.attackEntityFromPart(this.partArray[i], DamageSourceExtra.causeAntiTitanDamage((Entity)(((EntityWebShot)entity).shootingEntity != this ? ((EntityWebShot)entity).shootingEntity : (EntityWebShot)entity)), 300.0f);
                    int i1 = MathHelper.floor_double((double)this.partArray[i].posY);
                    int i11 = MathHelper.floor_double((double)this.partArray[i].posX);
                    int j1 = MathHelper.floor_double((double)this.partArray[i].posZ);
                    boolean flag = false;
                    for (int l1 = -2 - this.rand.nextInt(4); l1 <= 2 + this.rand.nextInt(4); ++l1) {
                        for (int i2 = -2 - this.rand.nextInt(4); i2 <= 2 + this.rand.nextInt(4); ++i2) {
                            for (int h = -2; h <= 2 + this.rand.nextInt(5); ++h) {
                                int j2 = i11 + l1;
                                int k = i1 + h;
                                int l = j1 + i2;
                                Block block1 = this.worldObj.getBlock(j2, k, l);
                                if (block1.isOpaqueCube()) continue;
                                this.worldObj.setBlock(j2, k, l, Blocks.web);
                            }
                        }
                    }
                    entity.setDead();
                }
            }
        }
        if (this.isStunned || this.deathTicks > 0) {
            this.motionX *= 0.0;
            this.motionZ *= 0.0;
        }
        if ((list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0))) != null && !list.isEmpty() && this.ticksExisted % 400 == 0) {
            for (int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity1 = (Entity)list.get(i1);
                if (entity1 == null || !(entity1 instanceof EntityArrow)) continue;
                entity1.setDead();
            }
        }
        if ((this.getAnimID() == 5 || this.getAnimID() == 11) && this.getAnimTick() >= 40) {
            ++this.attackTimer;
        } else if (this.getAnimID() != 5 && this.getAnimID() != 11) {
            this.attackTimer = 0;
        }
        if (this.attackTimer < 0) {
            this.attackTimer = 0;
        }
        if (!this.worldObj.isRemote && this.getAttackTarget() != null && this.getAnimID() == 5 && this.getAnimTick() >= 100 && this.getAnimTick() <= 300) {
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
        }
        if (!this.worldObj.isRemote && this.getAttackTarget() != null && this.getAnimID() == 11 && this.getAnimTick() == 78) {
            this.attackEntityWithEnlargedRangedAttack(this.getAttackTarget(), 1.0f);
        }
        if (!AnimationAPI.isEffectiveClient() && this.getAttackTarget() != null && !this.isStunned && this.getAnimID() == 0) {
            double d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
            if (d0 < this.getMeleeRange()) {
                if (this.getAttackTarget() instanceof EntityTitan || this.getAttackTarget().height >= 6.0f || this.getAttackTarget().posY > this.posY + 6.0) {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                } else {
                    switch (this.rand.nextInt(5)) {
                        case 0: {
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                            break;
                        }
                        case 1: {
                            AnimationAPI.sendAnimPacket(this, 3);
                            this.setAnimID(3);
                            break;
                        }
                        case 2: {
                            AnimationAPI.sendAnimPacket(this, 7);
                            this.setAnimID(7);
                            break;
                        }
                        case 3: {
                            AnimationAPI.sendAnimPacket(this, 2);
                            this.setAnimID(2);
                            break;
                        }
                        case 4: {
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                        }
                    }
                }
            } else if (this.animID == 0 && this.getRNG().nextInt(80) == 0) {
                switch (this.rand.nextInt(6)) {
                    case 0: {
                        if (this.getSkeletonType() != 1) {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                            break;
                        }
                        AnimationAPI.sendAnimPacket(this, 9);
                        this.setAnimID(9);
                        break;
                    }
                    case 1: {
                        AnimationAPI.sendAnimPacket(this, 12);
                        this.setAnimID(12);
                        break;
                    }
                    case 2: {
                        if (this.getSkeletonType() != 1) {
                            AnimationAPI.sendAnimPacket(this, 11);
                            this.setAnimID(11);
                            break;
                        }
                        AnimationAPI.sendAnimPacket(this, 12);
                        this.setAnimID(12);
                    }
                }
            }
        }
        if (this.animID == 1 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.getRNG().nextInt(4);
        }
        if (this.getSkeletonType() == 1) {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.WitherSkeletonTitan.name"));
            if (TheTitans.NightmareMode) {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15000.0 + (double)(this.getExtraPower() * 750));
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400000.0 + (double)(this.getExtraPower() * 40000));
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5000.0 + (double)(this.getExtraPower() * 250));
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200000.0 + (double)(this.getExtraPower() * 20000));
            }
        } else {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.SkeletonTitan.name"));
            if (TheTitans.NightmareMode) {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(360.0 + (double)(this.getExtraPower() * 60));
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40000.0 + (double)(this.getExtraPower() * 2000));
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(120.0 + (double)(this.getExtraPower() * 30));
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20000.0 + (double)(this.getExtraPower() * 1000));
            }
        }
        if (this.rand.nextInt(2) == 0 && this.getSkeletonType() == 1 && this.isWet()) {
            this.playSound("random.fizz", 10.0f, 1.0f);
        }
        if (!this.getWaiting() && this.animID != 13 && !(this.worldObj.provider instanceof WorldProviderVoid)) {
            if ((this.rand.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0 && this.getSkeletonType() == 1) {
                    EntityWitherMinion entitychicken = new EntityWitherMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.addVelocity(0.0, 0.25, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.6f);
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    ++this.numSpecialMinions;
                } else if (this.numMinions < this.getMinionCap()) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.9, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    ++this.numMinions;
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ, Blocks.dirt);
                    }
                    if (this.getSkeletonType() == 1) {
                        entitychicken.setSkeletonType(1);
                    } else {
                        entitychicken.setSkeletonType(0);
                        entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0 && this.getSkeletonType() == 1) {
                    EntityWitherMinion entitychicken = new EntityWitherMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.addVelocity(0.0, 0.25, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.6f);
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    ++this.numSpecialMinions;
                } else if (this.numPriests < this.getPriestCap()) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.9, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(1);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    ++this.numPriests;
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ, Blocks.dirt);
                    }
                    if (this.getSkeletonType() == 1) {
                        entitychicken.setSkeletonType(1);
                    } else {
                        entitychicken.setSkeletonType(0);
                        entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0 && this.getSkeletonType() == 1) {
                    EntityWitherMinion entitychicken = new EntityWitherMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.addVelocity(0.0, 0.25, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.6f);
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    ++this.numSpecialMinions;
                } else if (this.numZealots < this.getZealotCap()) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.9, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(2);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    ++this.numZealots;
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ, Blocks.dirt);
                    }
                    if (this.getSkeletonType() == 1) {
                        entitychicken.setSkeletonType(1);
                    } else {
                        entitychicken.setSkeletonType(0);
                        entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0 && this.getSkeletonType() == 1) {
                    EntityWitherMinion entitychicken = new EntityWitherMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.addVelocity(0.0, 0.25, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.6f);
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    ++this.numSpecialMinions;
                } else if (this.numBishop < this.getBishopCap()) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.9, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(3);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    ++this.numBishop;
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ, Blocks.dirt);
                    }
                    if (this.getSkeletonType() == 1) {
                        entitychicken.setSkeletonType(1);
                    } else {
                        entitychicken.setSkeletonType(0);
                        entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0 && this.getSkeletonType() == 1) {
                    EntityWitherMinion entitychicken = new EntityWitherMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.addVelocity(0.0, 0.25, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.6f);
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    ++this.numSpecialMinions;
                } else if (this.numTemplar < this.getTemplarCap()) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.9, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(4);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    ++this.numTemplar;
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ, Blocks.dirt);
                    }
                    if (this.getSkeletonType() == 1) {
                        entitychicken.setSkeletonType(1);
                    } else {
                        entitychicken.setSkeletonType(0);
                        entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    }
                }
            }
        }
        super.onLivingUpdate();
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    @Override
    public void attackChoosenEntity(Entity damagedEntity, float damage, int knockbackAmount) {
        if (this.getSkeletonType() == 1 && this.isEntityAlive()) {
            damage += (float)this.numSpecialMinions * 150.0f;
            knockbackAmount += this.numSpecialMinions;
        }
        if (this.isArmored()) {
            damage *= 2.0f;
        }
        super.attackChoosenEntity(damagedEntity, damage, knockbackAmount);
        if (this.getSkeletonType() == 1 && damagedEntity instanceof EntityLivingBase) {
            ((EntityLivingBase)damagedEntity).addPotionEffect(new PotionEffect(Potion.wither.id, 800, 3));
            ((EntityLivingBase)damagedEntity).addPotionEffect(new PotionEffect(ClientProxy.advancedWither.id, 100, 3));
        }
    }

    public void updateRidden() {
        super.updateRidden();
        if (this.ridingEntity instanceof EntitySpiderTitan) {
            EntitySpiderTitan entitycreature = (EntitySpiderTitan)this.ridingEntity;
            this.renderYawOffset = entitycreature.renderYawOffset;
            if (this.getAttackTarget() != null) {
                entitycreature.setAttackTarget(this.getAttackTarget());
            }
            if (!entitycreature.isEntityAlive()) {
                this.ridingEntity = null;
            }
        }
    }

    @Override
    public StatBase getAchievement() {
        if (this.ridingEntity != null && this.ridingEntity instanceof EntitySpiderTitan) {
            return TitansAchievments.spiderjockeytitan;
        }
        if (this.getSkeletonType() == 1) {
            return TitansAchievments.witherskeletontitan;
        }
        return TitansAchievments.skeletontitan;
    }

    protected Item getDropItem() {
        return Items.arrow;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            EntityItem entityitem;
            int l;
            EntityXPBomb entitylargefireball;
            int x;
            if (this.getSkeletonType() == 1) {
                for (x = 0; x < 70; ++x) {
                    entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                    entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                    entitylargefireball.motionY += 1.0;
                    entitylargefireball.setXPCount(24000);
                    this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
                }
                for (l = 0; l < 16; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.diamond));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 32; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.iron_ingot));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.bone));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.coal));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 256 + this.rand.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.dye, 1, 15));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.emerald));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.diamond));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 64 + this.rand.nextInt(64 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanItems.harcadium));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 32 + this.rand.nextInt(32 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanItems.voidItem));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 16 + this.rand.nextInt(16 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.bedrock));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
            } else {
                for (x = 0; x < 16; ++x) {
                    entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                    entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                    entitylargefireball.motionY += 1.0;
                    entitylargefireball.setXPCount(14000);
                    this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
                }
                for (l = 0; l < 48; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.stick));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 48; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.string));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.arrow));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 0 + this.rand.nextInt(16 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.emerald));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 0 + this.rand.nextInt(16 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.diamond));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 0 + this.rand.nextInt(4 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanItems.harcadium));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
            }
            for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.bone));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.coal));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 256 + this.rand.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.dye, 1, 15));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
        }
    }

    protected void dropRareDrop(int p_70600_1_) {
        if (this.getSkeletonType() == 1) {
            this.entityDropItem(new ItemStack(Items.skull, 256, 1), 0.0f);
        } else {
            this.entityDropItem(new ItemStack(Items.skull, 256, 0), 0.0f);
        }
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        if (this.getSkeletonType() == 1) {
            this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
        } else {
            this.setCurrentItemOrArmor(0, new ItemStack((Item)Items.bow));
        }
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_180482_2_) {
        Calendar calendar;
        p_180482_2_ = super.onSpawnWithEgg(p_180482_2_);
        this.setCanPickUpLoot(true);
        this.enchantEquipment();
        this.setWaiting(true);
        if (this.worldObj.provider instanceof WorldProviderHell && this.getRNG().nextInt(5) > 0 && !this.worldObj.isRemote || this.shouldBeWitherSkeleton && !this.worldObj.isRemote) {
            this.setSkeletonType(1);
        } else {
            this.setSkeletonType(0);
        }
        if (this.getEquipmentInSlot(4) == null && (calendar = this.worldObj.getCurrentDate()).get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25f) {
            this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1f ? Blocks.lit_pumpkin : Blocks.pumpkin));
            this.equipmentDropChances[4] = 0.0f;
        }
        this.addRandomArmor();
        return p_180482_2_;
    }

    public void setCombatTask() {
        this.meleeTitan = true;
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
        this.faceEntity((Entity)p_82196_1_, 180.0f, 30.0f);
        float dis = 10.0f;
        float xfac = MathHelper.sin((float)(this.renderYawOffset * (float)Math.PI / 180.0f));
        float zfac = MathHelper.cos((float)(this.renderYawOffset * (float)Math.PI / 180.0f));
        EntityHarcadiumArrow entityarrow = new EntityHarcadiumArrow(this.worldObj, (EntityLivingBase)this, p_82196_2_);
        double d0 = p_82196_1_.posX - (this.posX - (double)(xfac * dis));
        double d1 = p_82196_1_.posY - (this.posY + 18.0);
        double d2 = p_82196_1_.posZ - (this.posZ + (double)(zfac * dis));
        float f1 = MathHelper.sqrt_double((double)(d0 * d0 + d2 * d2));
        entityarrow.setThrowableHeading(d0, d1 + (double)f1, d2, f1 / 57.295776f * 1.6f, 36.0f);
        entityarrow.posX = this.posX - (double)(xfac * dis);
        entityarrow.posY = this.posY + 18.0;
        entityarrow.posZ = this.posZ + (double)(zfac * dis);
        int i = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.power.effectId, (ItemStack)this.getHeldItem());
        int j = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.punch.effectId, (ItemStack)this.getHeldItem());
        int f = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.flame.effectId, (ItemStack)this.getHeldItem());
        if (TheTitans.NightmareMode) {
            entityarrow.setDamage(90.0);
        } else {
            entityarrow.setDamage(30.0);
        }
        entityarrow.setIsCritical(true);
        if (i > 0) {
            entityarrow.setDamage(entityarrow.getDamage() + (double)i * 10.0 + 1.0);
        }
        if (j > 1) {
            entityarrow.setKnockbackStrength(j);
        } else {
            entityarrow.setKnockbackStrength(2);
        }
        if (f > 0 || this.getSkeletonType() == 1) {
            entityarrow.setFire(10000);
        }
        this.worldObj.spawnEntityInWorld((Entity)entityarrow);
        this.playSound("random.bow", 3.0f, 1.9f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        if (this.getDistanceSqToEntity((Entity)p_82196_1_) <= this.getMeleeRange()) {
            this.attackChoosenEntity((Entity)p_82196_1_, 10.0f, 5);
        }
    }

    public void attackEntityWithEnlargedRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
        this.faceEntity((Entity)p_82196_1_, 180.0f, 30.0f);
        float dis = 10.0f;
        float xfac = MathHelper.sin((float)(this.renderYawOffset * (float)Math.PI / 180.0f));
        float zfac = MathHelper.cos((float)(this.renderYawOffset * (float)Math.PI / 180.0f));
        double d0 = p_82196_1_.posX - (this.posX - (double)(xfac * dis));
        double d1 = p_82196_1_.posY - (this.posY + 17.0);
        double d2 = p_82196_1_.posZ - (this.posZ + (double)(zfac * dis));
        EntitySkeletonTitanGiantArrow entityarrow = new EntitySkeletonTitanGiantArrow(this.worldObj, (EntityLivingBase)this, d0, d1, d2);
        float f1 = MathHelper.sqrt_double((double)(d0 * d0 + d2 * d2));
        entityarrow.posX = this.posX - (double)(xfac * dis);
        entityarrow.posY = this.posY + 17.0;
        entityarrow.posZ = this.posZ + (double)(zfac * dis);
        this.worldObj.spawnEntityInWorld((Entity)entityarrow);
        this.playSound("random.bow", 10.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        if (this.getDistanceSqToEntity((Entity)p_82196_1_) <= this.getMeleeRange()) {
            this.attackChoosenEntity((Entity)p_82196_1_, 10.0f, 5);
        }
    }

    public int getSkeletonType() {
        return this.dataWatcher.getWatchableObjectByte(13);
    }

    public void setSkeletonType(int p_82201_1_) {
        this.dataWatcher.updateObject(13, (Object)((byte)p_82201_1_));
        if (p_82201_1_ == 1) {
            this.setSize(14.0f, 56.0f);
            this.experienceValue = 50000;
            this.head.height = 14.0f;
            this.head.width = 14.0f;
            this.pelvis.width = 10.5f;
            this.spine.height = 21.0f;
            this.ribCage.height = 8.75f;
            this.ribCage.width = 12.25f;
            this.rightArm.width = 3.5f;
            this.leftArm.width = 3.5f;
            this.leftLeg.width = 3.5f;
            this.rightLeg.width = 3.5f;
            this.spine.width = 3.5f;
            this.pelvis.height = 3.5f;
            this.rightArm.height = 21.0f;
            this.leftArm.height = 21.0f;
            this.leftLeg.height = 21.0f;
            this.rightLeg.height = 21.0f;
            this.rightArm.height = 21.0f;
            this.leftArm.height = 21.0f;
        } else {
            this.setSize(8.0f, 32.0f);
            this.experienceValue = 20000;
            this.head.height = 8.0f;
            this.head.width = 8.0f;
            this.pelvis.width = 6.0f;
            this.spine.height = 12.0f;
            this.ribCage.height = 5.0f;
            this.ribCage.width = 7.0f;
            this.rightArm.width = 2.0f;
            this.leftArm.width = 2.0f;
            this.leftLeg.width = 2.0f;
            this.rightLeg.width = 2.0f;
            this.spine.width = 2.0f;
            this.pelvis.height = 2.0f;
            this.rightArm.height = 12.0f;
            this.leftArm.height = 12.0f;
            this.leftLeg.height = 12.0f;
            this.rightLeg.height = 12.0f;
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        if (tagCompund.hasKey("SkeletonType", 99)) {
            byte b0 = tagCompund.getByte("SkeletonType");
            this.setSkeletonType(b0);
        }
        this.setCombatTask();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setByte("SkeletonType", (byte)this.getSkeletonType());
    }

    public void setCurrentItemOrArmor(int slotIn, ItemStack stack) {
        super.setCurrentItemOrArmor(slotIn, stack);
        if (!this.worldObj.isRemote && slotIn == 0) {
            this.setCombatTask();
        }
    }

    public float getEyeHeight() {
        return this.getSkeletonType() == 1 ? 46.68f : 28.0f;
    }

    @Override
    protected void updateAITasks() {
        long perfNs = TitansPerf.begin();
        try {
        super.updateAITasks();
        List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox);
        if (list11 != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (!(entity instanceof EntityLivingBase) || !entity.onGround || entity instanceof EntityTitan) continue;
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                entity.attackEntityFrom(DamageSourceExtra.causeSquishingDamage((Entity)this), f / 2.0f);
                if (this.getSkeletonType() != 1) continue;
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.wither.id, 1500, 3));
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
        }
    }

    public double getYOffset() {
        if (this.getSkeletonType() == 1) {
            return super.getYOffset() - 12.48;
        }
        return super.getYOffset() - 10.4;
    }

    @Override
    protected void inactDeathAction() {
        if (!this.worldObj.isRemote) {
            this.playSound("mob.skeleton.death", this.getSoundVolume(), this.getSoundPitch());
            if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(true, 0);
                this.dropEquipment(true, 0);
                this.dropRareDrop(1);
            }
            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
            entitytitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitytitan);
            entitytitan.setVesselHunting(false);
            if (this.getSkeletonType() == 1) {
                entitytitan.setSpiritType(5);
            } else {
                entitytitan.setSpiritType(4);
            }
        }
    }

    @Override
    protected void onTitanDeathUpdate() {
        this.dataWatcher.updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)this.dataWatcher.getWatchableObjectFloat(5), (float)0.0f, (float)this.getMaxHealth())));
        if (this.dataWatcher.getWatchableObjectFloat(5) <= 0.0f) {
            ++this.deathTicks;
            AnimationAPI.sendAnimPacket(this, 10);
            this.setAnimID(10);
            this.setTitanHealth(0.0f);
        } else {
            this.attackEntityFrom(DamageSource.outOfWorld, 25.0f);
            this.setTitanHealth(this.dataWatcher.getWatchableObjectFloat(5));
            this.setHealth(this.dataWatcher.getWatchableObjectFloat(5));
            this.deathTicks = 0;
            if (this.animID == 10) {
                this.animID = 0;
            }
        }
        this.motionX *= 0.0;
        this.motionZ *= 0.0;
        this.setAttackTarget(null);
        if (this.deathTicks == 1 && !this.worldObj.isRemote) {
            this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
            ArrayList listp = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
            if (listp != null && !listp.isEmpty()) {
                for (int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity == null || !(entity instanceof EntityPlayer)) continue;
                    ((EntityPlayer)entity).triggerAchievement(this.getAchievement());
                }
            }
        }
        if (this.deathTicks == 1) {
            this.setAnimTick(1);
        }
        if (this.deathTicks >= 500) {
            this.setInvulTime(this.getInvulTime() + 8);
            --this.animTick;
            float f = (this.rand.nextFloat() - 0.5f) * 24.0f;
            float f1 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 24.0f;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        }
        if (this.getInvulTime() >= this.getThreashHold()) {
            this.setDead();
        }
    }

    public boolean attackSkeletonFrom(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 2.0f;
        }
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (!this.isStunned && source.getEntity() instanceof EntityPlayer) {
            return false;
        }
        if (source.getEntity() instanceof EntitySkeletonMinion || this.ridingEntity != null && source.getEntity() == this.ridingEntity && this.ridingEntity instanceof EntitySpiderTitan || source.getEntity() instanceof EntitySkeletonTitan || source.getEntity() instanceof EntityWitherMinion) {
            return false;
        }
        this.recentlyHit = 200;
        Entity entity = source.getEntity();
        if (entity instanceof EntityLivingBase && !this.isEntityInvulnerable() && amount > 25.0f) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1 instanceof EntitySkeletonTitan) {
                    EntitySkeletonTitan entitypigzombie = (EntitySkeletonTitan)entity1;
                    entitypigzombie.setAttackTarget((EntityLivingBase)entity);
                    entitypigzombie.setRevengeTarget((EntityLivingBase)entity);
                }
                this.setAttackTarget((EntityLivingBase)entity);
                this.setRevengeTarget((EntityLivingBase)entity);
            }
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source.getEntity() instanceof EntityPlayer && !this.worldObj.isRemote) {
            this.setAttackTarget((EntityLivingBase)source.getEntity());
            this.setRevengeTarget((EntityLivingBase)source.getEntity());
        }
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (!this.isStunned && source.getEntity() instanceof EntityPlayer) {
            return false;
        }
        if (source.getEntity() instanceof EntitySkeletonMinion || this.ridingEntity != null && source.getEntity() == this.ridingEntity && this.ridingEntity instanceof EntitySpiderTitan || source.getEntity() instanceof EntitySkeletonTitan || source.getEntity() instanceof EntityWitherMinion) {
            return false;
        }
        if (this.getSkeletonType() == 1 && source.isFireDamage()) {
            this.heal(amount);
            return false;
        }
        this.recentlyHit = 200;
        Entity entity = source.getEntity();
        if (entity instanceof EntityLivingBase && !this.isEntityInvulnerable() && amount > 25.0f) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1 instanceof EntitySkeletonTitan) {
                    EntitySkeletonTitan entitypigzombie = (EntitySkeletonTitan)entity1;
                    entitypigzombie.setAttackTarget((EntityLivingBase)entity);
                    entitypigzombie.setRevengeTarget((EntityLivingBase)entity);
                }
                this.setAttackTarget((EntityLivingBase)entity);
                this.setRevengeTarget((EntityLivingBase)entity);
            }
        }
        return super.attackEntityFrom(source, amount);
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        this.func_82195_e(source, amount);
        return true;
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return this.attackEntityFrom(p_82195_1_, p_82195_2_);
    }

    public World func_82194_d() {
        return this.worldObj;
    }

    @Override
    public void setAnimID(int id) {
        this.animID = id;
    }

    @Override
    public void setAnimTick(int tick) {
        this.animTick = tick;
    }

    @Override
    public int getAnimID() {
        return this.animID;
    }

    @Override
    public int getAnimTick() {
        return this.animTick;
    }
}

