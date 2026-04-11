/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityDragonPart
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProviderEnd
 *  net.minecraftforge.common.ForgeHooks
 */
package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityLightningBall;
import net.minecraft.entity.titan.EntitySkeletonTitanGiantArrow;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWebShot;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.entity.titan.IEntityMultiPartTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusAntiTitanAttack;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusAttack1;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusAttack2;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusAttack3;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusChainLightning;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusDeath;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusDragonLightningBall;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusLightningAttack;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusLightningBall;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusMeteorRain;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusScream;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusStun;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.ForgeHooks;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityEnderColossus
extends EntityTitan
implements IAnimatedEntity,
IEntityMultiPartTitan {
    private int roarcooldownTimer;
    public boolean isRevealed;
    public EntityEnderColossusCrystal healingEnderCrystal;
    public int numOfCrystals;
    public int maxNumOfCrystals = 20;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart body;
    public EntityTitanPart rightEye;
    public EntityTitanPart leftEye;
    public EntityTitanPart rightArm;
    public EntityTitanPart leftArm;
    public EntityTitanPart rightLeg;
    public EntityTitanPart leftLeg;
    public boolean isStunned;
    public int destroyedCrystals;

    public EntityEnderColossus(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 12.0f, 12.0f);
        this.body = new EntityTitanPart(worldIn, this, "body", 10.0f, 18.0f);
        this.rightEye = new EntityTitanPart(worldIn, this, "righteye", 3.0f, 2.0f);
        this.leftEye = new EntityTitanPart(worldIn, this, "lefteye", 3.0f, 2.0f);
        this.rightArm = new EntityTitanPart(worldIn, this, "rightarm", 4.0f, 4.0f);
        this.leftArm = new EntityTitanPart(worldIn, this, "leftarm", 4.0f, 4.0f);
        this.rightLeg = new EntityTitanPart(worldIn, this, "rightleg", 4.0f, 42.0f);
        this.leftLeg = new EntityTitanPart(worldIn, this, "leftleg", 4.0f, 42.0f);
        this.maxNumOfCrystals = 20;
        this.partArray = new EntityTitanPart[]{this.head, this.body, this.rightEye, this.leftEye, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg};
        this.setSize(12.0f, 72.0f);
        this.experienceValue = 1000000;
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        worldIn.spawnEntityInWorld((Entity)this.head);
        worldIn.spawnEntityInWorld((Entity)this.body);
        worldIn.spawnEntityInWorld((Entity)this.rightArm);
        worldIn.spawnEntityInWorld((Entity)this.leftArm);
        worldIn.spawnEntityInWorld((Entity)this.rightLeg);
        worldIn.spawnEntityInWorld((Entity)this.leftLeg);
        worldIn.spawnEntityInWorld((Entity)this.rightEye);
        worldIn.spawnEntityInWorld((Entity)this.leftEye);
    }

    @Override
    protected void applyEntityAI() {
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusDeath(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusStun(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusScream(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusDragonLightningBall(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusChainLightning(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusLightningBall(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusLightningAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusAntiTitanAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusMeteorRain(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusAttack2(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusAttack3(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationEnderColossusAttack1(this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.EnderColossusSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public int getEyeLaserTime() {
        return this.dataWatcher.getWatchableObjectInt(25);
    }

    public void setEyeLaserTime(int p_82215_1_) {
        this.dataWatcher.updateObject(25, (Object)p_82215_1_);
    }

    @Override
    public boolean alreadyHasAName() {
        return this.isRevealed;
    }

    @Override
    public int getMinionCap() {
        return 160;
    }

    @Override
    public int getPriestCap() {
        return 80;
    }

    @Override
    public int getZealotCap() {
        return 40;
    }

    @Override
    public int getBishopCap() {
        return 30;
    }

    @Override
    public int getTemplarCap() {
        return 20;
    }

    @Override
    public int getSpecialMinionCap() {
        return 10;
    }

    @Override
    public int getTalkInterval() {
        return 100;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.isRevealed = tagCompund.getBoolean("Musmu");
        this.setEyeLaserTime(tagCompund.getInteger("ShootTimer"));
        this.setCanCallBackUp(tagCompund.getBoolean("CallHelp"));
        if (tagCompund.hasKey("DestroyedCrystals", 99)) {
            this.destroyedCrystals = tagCompund.getInteger("DestroyedCrystals");
        }
        this.isStunned = tagCompund.getBoolean("Stunned");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("ShootTimer", this.getEyeLaserTime());
        tagCompound.setBoolean("CallHelp", this.getCanCallBackUp());
        tagCompound.setBoolean("Musmu", this.isRevealed);
        tagCompound.setInteger("DestroyedCrystals", this.destroyedCrystals);
        tagCompound.setBoolean("Stunned", this.isStunned);
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != ((Object)((Object)this.head)).getClass() && p_70686_1_ != ((Object)((Object)this.body)).getClass() && p_70686_1_ != ((Object)((Object)this.rightEye)).getClass() && p_70686_1_ != ((Object)((Object)this.leftEye)).getClass() && p_70686_1_ != ((Object)((Object)this.rightArm)).getClass() && p_70686_1_ != ((Object)((Object)this.leftArm)).getClass() && p_70686_1_ != ((Object)((Object)this.rightLeg)).getClass() && p_70686_1_ != ((Object)((Object)this.leftLeg)).getClass() && p_70686_1_ != EntityEnderman.class && p_70686_1_ != EntityEndermanMinion.class && p_70686_1_ != EntityEnderColossus.class && p_70686_1_ != EntityDragon.class && p_70686_1_ != EntityDragonMinion.class && p_70686_1_ != EntityEnderColossusCrystal.class;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(500) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.EnderColossusMinionSpawnrate;
    }

    @Override
    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.GREATER;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, (Object)Byte.valueOf((byte)0));
        this.dataWatcher.addObject(19, (Object)Byte.valueOf((byte)0));
        this.dataWatcher.addObject(25, (Object)new Integer(0));
    }

    public boolean getCanCallBackUp() {
        return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }

    public void setCanCallBackUp(boolean p_82201_1_) {
        this.dataWatcher.updateObject(19, (Object)((byte)(p_82201_1_ ? 1 : 0)));
    }

    @Override
    public int getParticleCount() {
        return 60;
    }

    @Override
    public String getParticles() {
        return "portal";
    }

    @Override
    protected void fall(float p_70069_1_) {
        this.onGround = true;
        this.isAirBorne = false;
        if ((p_70069_1_ = ForgeHooks.onLivingFall((EntityLivingBase)this, (float)p_70069_1_)) <= 0.0f) {
            return;
        }
        PotionEffect potioneffect = this.getActivePotionEffect(Potion.jump);
        float f1 = potioneffect != null ? (float)(potioneffect.getAmplifier() + 1) : 0.0f;
        int i = MathHelper.ceiling_float_int((float)(p_70069_1_ - 24.0f - f1));
        if (i > 0) {
            this.shakeNearbyPlayerCameras(400000.0);
            this.playSound("thetitans:groundSmash", 20.0f, 0.9f);
            this.playSound("thetitans:titanland", 10000.0f, 1.0f);
            this.destroyBlocksInAABBTopless(this.boundingBox.expand(24.0, 1.0, 24.0));
            List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(48.0, 4.0, 48.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity = (Entity)list11.get(i1);
                    if (!(entity instanceof EntityLivingBase) || entity instanceof EntityDragonPart || !this.canAttackClass(entity.getClass()) || entity instanceof EntityTitan) continue;
                    float smash = 100.0f - this.getDistanceToEntity(entity);
                    if (smash <= 1.0f) {
                        smash = 1.0f;
                    }
                    entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), smash * 4.0f);
                    double d0 = this.boundingBox.minX + this.boundingBox.maxX;
                    double d1 = this.boundingBox.minZ + this.boundingBox.maxZ;
                    double d2 = entity.posX - d0;
                    double d3 = entity.posZ - d1;
                    double d4 = d2 * d2 + d3 * d3;
                    entity.addVelocity(d2 / d4 * 8.0, 1.0, d3 / d4 * 8.0);
                }
            }
        }
    }

    protected void kill() {
        this.playSound("mob.endermen.portal", 100.0f, 0.6f);
        if (this.worldObj.provider instanceof WorldProviderEnd || this.worldObj.provider instanceof WorldProviderVoid) {
            this.setPosition(0.0, 128.0, 0.0);
        } else if (!(this.worldObj.provider instanceof WorldProviderEnd) && !(this.worldObj.provider instanceof WorldProviderVoid)) {
            this.setPosition(this.posX + (this.rand.nextDouble() - 0.5) * 48.0, 128.0, this.posZ + (this.rand.nextDouble() - 0.5) * 48.0);
        }
    }

    @Override
    protected int decreaseAirSupply(int p_70682_1_) {
        return p_70682_1_;
    }

    protected Entity findPlayerToLookAt() {
        EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity((Entity)this, -1.0);
        if (entityplayer != null && !this.worldObj.isRemote && entityplayer.isEntityAlive() && this.isEntityAlive() && (this.isPlayerRegistered(entityplayer, this.rightEye) || this.isPlayerRegistered(entityplayer, this.leftEye)) && entityplayer.isEntityAlive()) {
            this.getLookHelper().setLookPositionWithEntity((Entity)entityplayer, 180.0f, 30.0f);
            this.setAttackTarget((EntityLivingBase)entityplayer);
            if (entityplayer.getHeldItem() != null && entityplayer.getHeldItem().getItem() == TitanItems.ultimaBlade) {
                this.attackEntityFrom(DamageSourceExtra.causeArmorPiercingMobDamage((Entity)entityplayer), 600.0f);
            } else {
                this.attackChoosenEntity((Entity)entityplayer, 20.0f, 100);
                entityplayer.motionY = 1.0;
                entityplayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 400, 1));
                entityplayer.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 400, 99));
                entityplayer.addPotionEffect(new PotionEffect(Potion.blindness.id, 400, 1));
                this.setAttackTarget((EntityLivingBase)entityplayer);
                this.worldObj.newExplosion((Entity)this, entityplayer.posX, entityplayer.posY, entityplayer.posZ, 8.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                this.playSound("thetitans:titanEnderColossusStare", Float.MAX_VALUE, 1.0f);
            }
        }
        return null;
    }

    protected boolean isPlayerRegistered(EntityPlayer p_70821_1_, EntityTitanPart part) {
        Vec3 vec3 = p_70821_1_.getLook(1.0f).normalize();
        Vec3 vec31 = Vec3.createVectorHelper((double)(part.posX + (this.rand.nextDouble() * (double)part.width - (double)part.width * 0.5) - p_70821_1_.posX), (double)(part.boundingBox.minY + this.rand.nextDouble() * (double)part.height - (p_70821_1_.posY + (double)p_70821_1_.getEyeHeight())), (double)(part.posZ + (this.rand.nextDouble() * (double)part.width - (double)part.width * 0.5) - p_70821_1_.posZ));
        double d0 = vec31.lengthVector();
        double d1 = vec3.dotProduct(vec31 = vec31.normalize());
        return d1 > 1.0 - 0.025 / d0 ? p_70821_1_.canEntityBeSeen((Entity)this) : false;
    }

    @Override
    public boolean canBeHurtByPlayer() {
        return this.isStunned && this.animID != 5 && !this.isEntityInvulnerable();
    }

    @Override
    public double getSpeed() {
        return 0.4 + (double)this.getExtraPower() * 0.001;
    }

    @Override
    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && this.getAttackTarget() != null ? super.shouldMove() : false;
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        return false;
    }

    @Override
    public double getMeleeRange() {
        return (double)(this.width * this.width + (this.getAttackTarget().width > 48.0f ? 2304.0f : this.getAttackTarget().width * this.getAttackTarget().width)) + 2000.0;
    }

    public int getVerticalFaceSpeed() {
        return this.getEyeLaserTime() >= 0 ? 180 : 40;
    }

    @Override
    public void onLivingUpdate() {
        List list1111;
        float fl;
        int i;
        EntityPlayer player;
        this.setEyeLaserTime(this.getEyeLaserTime() - 1);
        if (this.getAttackTarget() != null && this.getEyeLaserTime() <= -400 && this.animID == 0 && !this.isStunned && !this.getWaiting() && this.rand.nextInt(40) == 0) {
            this.setEyeLaserTime(200);
        }
        if (!this.worldObj.isRemote && this.getAttackTarget() != null && this.getAttackTarget() instanceof EntityWitherzilla && this.getCanCallBackUp()) {
            for (int i2 = 0; i2 < 24; ++i2) {
                EntityEnderColossus entitylargefireball = new EntityEnderColossus(this.worldObj);
                entitylargefireball.setWaiting(false);
                entitylargefireball.copyLocationAndAnglesFrom((Entity)this);
                entitylargefireball.setAttackTarget(this.getAttackTarget());
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
                this.playSound(this.getRoarSound(), this.getSoundVolume(), this.getSoundPitch());
            }
            this.setCanCallBackUp(false);
        }
        if (this.destroyedCrystals < 0) {
            this.destroyedCrystals = 0;
        }
        if (this.destroyedCrystals > 12) {
            this.destroyedCrystals = 0;
            this.isStunned = true;
        }
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
                float f = (this.rand.nextFloat() - 0.5f) * 16.0f;
                float f1 = (this.rand.nextFloat() - 0.5f) * 5.0f;
                float f2 = (this.rand.nextFloat() - 0.5f) * 16.0f;
                this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 15.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            }
        }
        if ((player = this.worldObj.getClosestPlayerToEntity((Entity)this, -1.0)) != null && this.getAttackTarget() != null && player == this.getAttackTarget()) {
            if (this.rand.nextInt(200) == 0 && this.getHealth() <= this.getMaxHealth() / 100.0f) {
                player.attackEntityFrom(DamageSourceExtra.mindCrush, Float.MAX_VALUE);
            }
            if (player.getAbsorptionAmount() <= 0.0f && this.ticksExisted % 5 == 0) {
                player.hurtResistantTime = 0;
                player.attackEntityFrom(DamageSourceExtra.mindCrush, 12.0f);
                player.addPotionEffect(new PotionEffect(Potion.confusion.id, 400, 1));
                if (player.getHealth() <= 15.0f) {
                    player.motionY = 1.0;
                    player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 400, 9));
                }
                if (player.getHealth() <= 5.0f) {
                    player.addPotionEffect(new PotionEffect(Potion.blindness.id, 400, 1));
                }
            } else if (player.getAbsorptionAmount() >= 0.0f && this.ticksExisted % 20 == 0) {
                player.attackEntityFrom(DamageSourceExtra.mindCrush, 12.0f);
            }
        }
        if (this.animID == 10) {
            if (this.animTick == 30 || this.animTick == 70) {
                this.func_145780_a(0, 0, 0, Blocks.stone);
            }
            if (this.animTick == 150 || this.animTick == 230) {
                this.playSound("thetitans:titanFall", 20.0f, 1.0f);
                this.playSound("thetitans:groundSmash", 20.0f, 1.0f);
                this.shakeNearbyPlayerCameras(10000.0);
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(48.0, 48.0, 48.0)));
            }
            if (this.animTick == 240) {
                this.playSound("thetitans:distantLargeFall", 10000.0f, 1.0f);
            }
        }
        if (this.ticksExisted % 120 == 0 && this.isEntityAlive()) {
            this.playSound("thetitans:titanEnderColossusLiving", this.getSoundVolume(), this.getSoundPitch());
        }
        if (this.numOfCrystals < 0) {
            this.numOfCrystals = 0;
        }
        for (int i3 = 0; i3 < this.getParticleCount() * 5; ++i3) {
            this.findPlayerToLookAt();
            this.worldObj.spawnParticle(this.getParticles(), this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width * 3.0, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width * 3.0, 0.0, 0.25, 0.0);
        }
        if (this.ticksExisted > 5) {
            float f = this.renderYawOffset * (float)Math.PI / 180.0f;
            float f1 = MathHelper.sin((float)f);
            float f2 = MathHelper.cos((float)f);
            this.head.setLocationAndAngles(this.posX, this.posY + 60.0, this.posZ, 0.0f, 0.0f);
            this.body.setLocationAndAngles(this.posX, this.posY + 42.0, this.posZ, 0.0f, 0.0f);
            this.rightEye.setLocationAndAngles(this.posX + (double)(MathHelper.cos((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 4.0f) - (double)(MathHelper.sin((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 7.0f), this.posY + (double)this.getEyeHeight() - 1.0, this.posZ + (double)(MathHelper.sin((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 4.0f) + (double)(MathHelper.cos((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 8.0f), 0.0f, 0.0f);
            this.leftEye.setLocationAndAngles(this.posX - (double)(MathHelper.cos((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 4.0f) - (double)(MathHelper.sin((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 7.0f), this.posY + (double)this.getEyeHeight() - 1.0, this.posZ - (double)(MathHelper.sin((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 4.0f) + (double)(MathHelper.cos((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 8.0f), 0.0f, 0.0f);
            this.rightArm.setLocationAndAngles(this.posX + (double)(f2 * 8.0f), this.posY + 56.0, this.posZ + (double)(f1 * 8.0f), 0.0f, 0.0f);
            this.leftArm.setLocationAndAngles(this.posX - (double)(f2 * 8.0f), this.posY + 56.0, this.posZ - (double)(f1 * 8.0f), 0.0f, 0.0f);
            this.rightLeg.setLocationAndAngles(this.posX + (double)(f2 * 3.0f), this.posY, this.posZ + (double)(f1 * 3.0f), 0.0f, 0.0f);
            this.leftLeg.setLocationAndAngles(this.posX - (double)(f2 * 3.0f), this.posY, this.posZ - (double)(f1 * 3.0f), 0.0f, 0.0f);
            this.head.height = this.isScreaming() ? 22.0f : 12.0f;
            this.head.width = 12.0f;
            this.body.height = 18.0f;
            this.body.width = 10.0f;
            this.leftEye.height = 2.0f;
            this.rightEye.height = 2.0f;
            this.leftEye.width = 3.0f;
            this.rightEye.width = 3.0f;
            this.rightLeg.height = 42.0f;
            this.leftLeg.height = 42.0f;
            this.rightLeg.width = 4.0f;
            this.leftLeg.width = 4.0f;
            this.leftArm.height = 4.0f;
            this.rightArm.height = 4.0f;
            this.leftArm.width = 4.0f;
            this.rightArm.width = 4.0f;
            this.rightEye.rotationYaw = this.rotationYawHead;
            this.leftEye.rotationYaw = this.rotationYawHead;
            this.rightEye.rotationPitch = this.rotationPitch;
            this.leftEye.rotationPitch = this.rotationPitch;
            if (!this.worldObj.isRemote && this.isEntityAlive()) {
                this.collideWithEntities(this.head, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.head.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.body, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.body.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rightArm, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightArm.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.leftArm, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftArm.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(1.0, 0.0, 1.0)));
            }
            this.destroyBlocksInAABB(this.head.boundingBox);
            this.destroyBlocksInAABB(this.body.boundingBox);
            this.destroyBlocksInAABB(this.rightArm.boundingBox);
            this.destroyBlocksInAABB(this.leftArm.boundingBox);
            this.destroyBlocksInAABB(this.leftLeg.boundingBox);
            this.destroyBlocksInAABB(this.rightLeg.boundingBox);
            for (i = 0; i < this.partArray.length; ++i) {
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.partArray[i].boundingBox.expand(0.5, 0.5, 0.5));
                if (list == null || list.isEmpty()) continue;
                for (int j = 0; j < list.size(); ++j) {
                    Entity entity = (Entity)list.get(j);
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
        if ((fl = this.getBrightness(1.0f)) > 0.5f && !this.worldObj.provider.hasNoSky && this.worldObj.isDaytime() && !this.worldObj.isRemote && this.ticksExisted % 1 == 0) {
            this.rotationPitch = this.rotationYawHead / 6.0f;
            this.rotationYawHead = -90.0f;
        }
        this.meleeTitan = true;
        if (this.isStunned || this.deathTicks > 0) {
            this.motionX *= 0.0;
            this.motionZ *= 0.0;
        }
        for (int i4 = 0; i4 < 3; ++i4) {
            if (this.getAnimID() != 2 || this.getAnimTick() < 40 || this.getAnimTick() > 80 || this.getAttackTarget() == null || this.worldObj.isRemote) continue;
            for (int it = 0; it < 2; ++it) {
                double d2 = this.getAttackTarget().posX + this.getRNG().nextGaussian() * 64.0;
                double d3 = this.getAttackTarget().posY + 150.0 + this.getRNG().nextGaussian() * 32.0;
                double d4 = this.getAttackTarget().posZ + this.getRNG().nextGaussian() * 64.0;
                double d5 = this.getAttackTarget().posX - d2;
                double d6 = this.getAttackTarget().posY - d3;
                double d7 = this.getAttackTarget().posZ - d4;
                EntityTitanFireball entitylargefireball1 = new EntityTitanFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7, 4);
                entitylargefireball1.posX = d2;
                entitylargefireball1.posY = d3;
                entitylargefireball1.posZ = d4;
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball1);
                entitylargefireball1.setFireballID(4);
            }
        }
        if (this.getAnimID() == 3 && this.getAnimTick() == 20 || this.getAnimID() == 4 && this.getAnimTick() == 10 || this.getAnimID() == 11 && this.getAnimTick() == 10) {
            this.playSound("thetitans:lightningCharge", 100.0f, 1.0f);
        }
        if (this.getAnimID() == 3 && this.getAnimTick() == 64) {
            this.playSound("thetitans:lightningThrow", 100.0f, 1.0f);
            double d8 = 24.0;
            Vec3 vec3 = this.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            float da = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i1 = this.getKnockbackAmount();
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (this.isChild() ? 9.0 : 18.0), this.posZ + dz, 1.0f, 0.0f, 1.0f));
            if (this.getAttackTarget() != null) {
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1.0f, 0.0f, 1.0f));
                this.attackChoosenEntity((Entity)this.getAttackTarget(), da * 3.0f, i1);
                this.getAttackTarget().motionY += (double)(1.0f + this.rand.nextFloat());
                this.worldObj.newExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 2.0f, false, false);
                this.worldObj.newExplosion((Entity)this, this.posX + dx, this.posY + 26.0, this.posZ + dz, 1.0f, false, false);
                this.getAttackTarget().attackEntityFrom(DamageSourceExtra.lightningBolt, da);
                List list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getAttackTarget(), this.getAttackTarget().boundingBox.expand(4.0, 4.0, 4.0));
                if (list1 != null && !list1.isEmpty()) {
                    for (int i11 = 0; i11 < list1.size(); ++i11) {
                        List list11;
                        Entity entity1 = (Entity)list1.get(i11);
                        if (!(entity1 instanceof EntityLivingBase) || !this.canAttackClass(entity1.getClass())) continue;
                        this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, 1.0f, 0.0f, 1.0f));
                        this.attackChoosenEntity(entity1, da, 0);
                        if (!(entity1 instanceof EntityTitan)) {
                            entity1.motionY += (double)(1.0f + this.rand.nextFloat());
                        }
                        if ((list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity(entity1, entity1.boundingBox.expand(4.0, 4.0, 4.0))) == null || list11.isEmpty()) continue;
                        for (int i111 = 0; i111 < list11.size(); ++i111) {
                            List list111;
                            Entity entity11 = (Entity)list11.get(i111);
                            if (entity11 == entity1 || !(entity11 instanceof EntityLivingBase) || !this.canAttackClass(entity11.getClass())) continue;
                            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity11.posX, entity11.posY, entity11.posZ, 1.0f, 0.0f, 1.0f));
                            this.attackChoosenEntity(entity11, da, 0);
                            if (!(entity11 instanceof EntityTitan)) {
                                entity11.motionY += (double)(1.0f + this.rand.nextFloat());
                            }
                            if ((list111 = this.worldObj.getEntitiesWithinAABBExcludingEntity(entity11, entity11.boundingBox.expand(4.0, 4.0, 4.0))) == null || list111.isEmpty()) continue;
                            for (int i1111 = 0; i1111 < list111.size(); ++i1111) {
                                Entity entity111 = (Entity)list111.get(i1111);
                                if (entity111 == entity11 || !(entity111 instanceof EntityLivingBase) || !this.canAttackClass(entity111.getClass())) continue;
                                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity111.posX, entity111.posY, entity111.posZ, 1.0f, 0.0f, 1.0f));
                                this.attackChoosenEntity(entity111, da, 0);
                                if (entity111 instanceof EntityTitan) continue;
                                entity111.motionY += (double)(1.0f + this.rand.nextFloat());
                            }
                        }
                    }
                }
            }
        }
        if (this.getAnimID() == 4 && this.getAnimTick() == 50 && this.getAttackTarget() != null) {
            this.playSound("thetitans:lightningThrow", 100.0f, 1.0f);
            double d8 = 24.0;
            Vec3 vec3 = this.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            this.worldObj.newExplosion((Entity)this, this.posX + dx, this.posY + d8, this.posZ + dz, 1.0f, false, false);
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + d8, this.posZ + dz, 1.0f, 0.0f, 1.0f));
            this.worldObj.newExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 2.0f, false, false);
            this.getAttackTarget().attackEntityFrom(DamageSourceExtra.lightningBolt, 100.0f);
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1.0f, 0.0f, 1.0f));
            double d5 = this.getAttackTarget().posX - this.posX;
            double d6 = this.getAttackTarget().posY - d8 - this.posY;
            double d7 = this.getAttackTarget().posZ - this.posZ;
            EntityLightningBall entitylargefireball = new EntityLightningBall(this.worldObj, (EntityLivingBase)this, d5, d6, d7);
            entitylargefireball.posX = this.posX + vec3.xCoord * d8;
            entitylargefireball.posY = this.posY + d8;
            entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
            this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
        }
        if (this.getAnimID() == 11 && this.getAnimTick() == 50 && this.getAttackTarget() != null && !this.worldObj.isRemote) {
            this.playSound("thetitans:lightningThrow", 100.0f, 1.0f);
            double d8 = 24.0;
            Vec3 vec3 = this.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            this.worldObj.newExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 2.0f, false, false);
            this.worldObj.newExplosion((Entity)this, this.posX + dx, this.posY + d8, this.posZ + dz, 1.0f, false, false);
            this.getAttackTarget().attackEntityFrom(DamageSourceExtra.lightningBolt, 100.0f);
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + d8, this.posZ + dz, 1.0f, 0.0f, 1.0f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + d8, this.posZ + dz, 1.0f, 0.0f, 1.0f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + d8, this.posZ + dz, 1.0f, 0.0f, 1.0f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + d8, this.posZ + dz, 1.0f, 0.0f, 1.0f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1.0f, 0.0f, 1.0f));
            EntityDragonMinion entitychicken = new EntityDragonMinion(this.worldObj);
            entitychicken.forceNewTarget = false;
            entitychicken.targetX = this.getAttackTarget().posX;
            entitychicken.targetY = this.getAttackTarget().posY;
            entitychicken.targetZ = this.getAttackTarget().posZ;
            entitychicken.setLocationAndAngles(this.posX + dx, this.posY + d8, this.posZ + dz, this.rotationYaw, 0.0f);
            entitychicken.addVelocity(vec3.xCoord * 10.0, vec3.yCoord * 10.0, vec3.zCoord * 10.0);
            entitychicken.onSpawnWithEgg(null);
            entitychicken.setAttackTarget(this.getAttackTarget());
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            entitychicken.master = this;
            entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            ++this.numSpecialMinions;
        }
        if (this.getAnimID() == 13 && this.getAnimTick() == 50 && this.getAttackTarget() != null && !this.worldObj.isRemote) {
            float da = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i1 = this.getKnockbackAmount();
            this.attackChoosenEntity((Entity)this.getAttackTarget(), da * 3.0f, i1);
            this.getAttackTarget().motionY += (double)(1.0f + this.rand.nextFloat());
            this.worldObj.newExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 2.0f, false, false);
            this.getAttackTarget().attackEntityFrom(DamageSourceExtra.lightningBolt, da);
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1.0f, 0.0f, 1.0f));
            List list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getAttackTarget(), this.getAttackTarget().boundingBox.expand(12.0, 12.0, 12.0));
            if (list1 != null && !list1.isEmpty()) {
                for (int i11 = 0; i11 < list1.size(); ++i11) {
                    Entity entity1 = (Entity)list1.get(i11);
                    if (!(entity1 instanceof EntityLivingBase) || !this.canAttackClass(entity1.getClass())) continue;
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, 1.0f, 0.0f, 1.0f));
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, 1.0f, 0.0f, 1.0f));
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, 1.0f, 0.0f, 1.0f));
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, 1.0f, 0.0f, 1.0f));
                    this.attackChoosenEntity(entity1, da, 0);
                    if (entity1 instanceof EntityTitan) continue;
                    entity1.motionY += (double)(1.0f + this.rand.nextFloat());
                }
            }
        }
        if (!AnimationAPI.isEffectiveClient() && this.getEyeLaserTime() < 0 && this.getAttackTarget() != null && !this.isStunned && this.getAnimID() == 0) {
            double d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
            if (d0 < this.getMeleeRange()) {
                if (this.getAttackTarget() instanceof EntityTitan || this.getAttackTarget().height >= 6.0f || this.getAttackTarget().posY > this.posY + 6.0) {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                    this.setAnimTick(0);
                } else {
                    switch (this.rand.nextInt(3)) {
                        case 0: {
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                            break;
                        }
                        case 1: {
                            AnimationAPI.sendAnimPacket(this, 7);
                            this.setAnimID(7);
                            break;
                        }
                        case 2: {
                            AnimationAPI.sendAnimPacket(this, 9);
                            this.setAnimID(9);
                        }
                    }
                }
            } else if (this.getRNG().nextInt(80) == 0) {
                switch (this.rand.nextInt(6)) {
                    case 0: {
                        AnimationAPI.sendAnimPacket(this, 4);
                        this.setAnimID(4);
                        break;
                    }
                    case 1: {
                        if (this.rand.nextInt(25) == 0) {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                            break;
                        }
                        AnimationAPI.sendAnimPacket(this, 2);
                        this.setAnimID(2);
                        break;
                    }
                    case 2: {
                        AnimationAPI.sendAnimPacket(this, 3);
                        this.setAnimID(3);
                        break;
                    }
                    case 3: {
                        AnimationAPI.sendAnimPacket(this, 11);
                        this.setAnimID(11);
                        break;
                    }
                    case 4: {
                        AnimationAPI.sendAnimPacket(this, 13);
                        this.setAnimID(13);
                        break;
                    }
                    case 5: {
                        AnimationAPI.sendAnimPacket(this, 2);
                        this.setAnimID(2);
                    }
                }
            }
        }
        if (this.animID == 1) {
            if (this.animTick == 1) {
                this.antiTitanAttackAnimeID = this.getRNG().nextInt(4);
            }
            if (this.animTick == 4 && this.antiTitanAttackAnimeID == 0) {
                this.playSound("thetitans:titanEnderColossusChomp", 100.0f, 1.0f);
            }
        }
        if (this.animID == 8) {
            if (this.animTick == 15) {
                this.worldObj.playSoundEffect(this.head.posX, this.head.posY, this.head.posZ, "random.explode", 10.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
                for (int i5 = 0; i5 < 50; ++i5) {
                    this.worldObj.spawnParticle("largeexplode", this.head.posX + (this.rand.nextDouble() - 0.5) * (double)this.head.width, this.head.posY + this.rand.nextDouble() * (double)this.head.height, this.head.posZ + (this.rand.nextDouble() - 0.5) * (double)this.head.width, 0.0, 0.0, 0.0);
                    this.worldObj.spawnParticle("explode", this.head.posX + (this.rand.nextDouble() - 0.5) * (double)this.head.width, this.head.posY + this.rand.nextDouble() * (double)this.head.height, this.head.posZ + (this.rand.nextDouble() - 0.5) * (double)this.head.width, 0.0, 0.0, 0.0);
                }
            }
            if (this.animTick == 20) {
                this.playSound("thetitans:titanEnderColossusScream", this.getSoundVolume(), 1.25f);
            }
            if (this.animTick == 90) {
                this.playSound("thetitans:titanFall", 20.0f, 1.0f);
                this.playSound("thetitans:groundSmash", 20.0f, 1.0f);
                this.shakeNearbyPlayerCameras(10000.0);
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(48.0, 48.0, 48.0)));
            }
            if (this.animTick >= 360) {
                this.isStunned = false;
            } else {
                this.setAttackTarget(null);
                this.isStunned = true;
            }
        }
        if (this.isStunned) {
            this.setAttackTarget(null);
            AnimationAPI.sendAnimPacket(this, 8);
        }
        if (TheTitans.NightmareMode) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30000.0 + (double)(this.getExtraPower() * 3000));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(600000.0 + (double)(this.getExtraPower() * 100000));
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10000.0 + (double)(this.getExtraPower() * 1000));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300000.0 + (double)(this.getExtraPower() * 50000));
        }
        if (this.worldObj.isRemote && this.isScreaming()) {
            this.setSize(12.0f, 82.0f);
        } else if (this.worldObj.isRemote && !this.isScreaming()) {
            this.setSize(12.0f, 72.0f);
        }
        if (this.isWet() && !this.isInWater() && this.getAnimID() != 5) {
            AnimationAPI.sendAnimPacket(this, 5);
            this.setAnimID(5);
        }
        this.setCurrentItemOrArmor(0, new ItemStack(Blocks.dragon_egg));
        if (this.isRevealed) {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.EndermanTitan.realname"));
        } else {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.EndermanTitan.name"));
        }
        if (this.ridingEntity != null && this.ridingEntity instanceof EntityDragon) {
            this.renderYawOffset = this.rotationYaw = this.ridingEntity.rotationYaw - 180.0f;
        }
        if (this.rand.nextInt(400) == 0 && this.ridingEntity == null && this.getAttackTarget() != null && this.getHealth() <= this.getMaxHealth() / 100.0f) {
            EntityDragon entitydragon = new EntityDragon(this.worldObj);
            int i6 = MathHelper.floor_double((double)this.posX);
            int j = MathHelper.floor_double((double)this.posY);
            int k = MathHelper.floor_double((double)this.posZ);
            entitydragon.setLocationAndAngles((double)i6 + 0.5, (double)j, (double)k + 0.5, this.rotationYaw, 0.0f);
            entitydragon.onSpawnWithEgg((IEntityLivingData)null);
            this.worldObj.spawnEntityInWorld((Entity)entitydragon);
            entitydragon.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitydragon.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitydragon.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitydragon.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitydragon.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitydragon.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitydragon.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            entitydragon.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
            this.mountEntity((Entity)entitydragon);
        }
        if ((list1111 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0))) != null && !list1111.isEmpty()) {
            for (int i1 = 0; i1 < list1111.size(); ++i1) {
                Entity entity1 = (Entity)list1111.get(i1);
                if (entity1 != null && this.getAttackTarget() != null && entity1 instanceof EntityDragon) {
                    ((EntityDragon)entity1).targetX = this.getAttackTarget().posX;
                    ((EntityDragon)entity1).targetY = this.getAttackTarget().posY;
                    ((EntityDragon)entity1).targetZ = this.getAttackTarget().posZ;
                    continue;
                }
                if (entity1 == null || this.getAttackTarget() != null || !(entity1 instanceof EntityDragon) || entity1.riddenByEntity != null) continue;
                ((EntityDragon)entity1).targetX = this.posX;
                ((EntityDragon)entity1).targetY = this.posY + 60.0;
                ((EntityDragon)entity1).targetZ = this.posZ;
            }
        }
        if (this.worldObj.isDaytime() && this.roarcooldownTimer < -1) {
            this.roarcooldownTimer = -1;
        }
        if (this.isEntityAlive()) {
            ++this.roarcooldownTimer;
        }
        if (this.roarcooldownTimer == 0) {
            this.setScreaming(true);
            if (this.worldObj.isDaytime() && !this.worldObj.provider.hasNoSky && !this.worldObj.isRemote) {
                this.worldObj.setWorldTime(this.worldObj.getWorldTime() + 14000L);
            }
        }
        if (this.roarcooldownTimer >= 60 || !this.isEntityAlive()) {
            this.roarcooldownTimer = -(400 - this.rand.nextInt(200));
            this.setScreaming(false);
        }
        if (!this.getWaiting() && this.animID != 13) {
            if ((this.rand.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityDragonMinion entitychicken = new EntityDragonMinion(this.worldObj);
                    i = MathHelper.floor_double((double)this.posX) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k = MathHelper.floor_double((double)this.posZ) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j = this.worldObj.getTopSolidOrLiquidBlock(i, k) - 8;
                    entitychicken.setLocationAndAngles((double)i + 0.5, j, (double)k + 0.5, this.rotationYaw, 0.0f);
                    entitychicken.addVelocity(0.0, 1.0, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.master = this;
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    ++this.numSpecialMinions;
                } else if (this.numMinions < this.getMinionCap()) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.worldObj);
                    i = MathHelper.floor_double((double)this.posX) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k = MathHelper.floor_double((double)this.posZ) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j = this.worldObj.getTopSolidOrLiquidBlock(i, k);
                    entitychicken.setLocationAndAngles((double)i + 0.5, j, (double)k + 0.5, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("mob.endermen.portal", 1.0f, 1.0f);
                    ++this.numMinions;
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityDragonMinion entitychicken = new EntityDragonMinion(this.worldObj);
                    i = MathHelper.floor_double((double)this.posX) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k = MathHelper.floor_double((double)this.posZ) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j = this.worldObj.getTopSolidOrLiquidBlock(i, k) - 8;
                    entitychicken.setLocationAndAngles((double)i + 0.5, j, (double)k + 0.5, this.rotationYaw, 0.0f);
                    entitychicken.addVelocity(0.0, 1.0, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.master = this;
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    ++this.numSpecialMinions;
                } else if (this.numPriests < this.getPriestCap()) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.worldObj);
                    i = MathHelper.floor_double((double)this.posX) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k = MathHelper.floor_double((double)this.posZ) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j = this.worldObj.getTopSolidOrLiquidBlock(i, k);
                    entitychicken.setLocationAndAngles((double)i + 0.5, j, (double)k + 0.5, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(1);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("mob.endermen.portal", 1.0f, 1.0f);
                    ++this.numPriests;
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityDragonMinion entitychicken = new EntityDragonMinion(this.worldObj);
                    i = MathHelper.floor_double((double)this.posX) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k = MathHelper.floor_double((double)this.posZ) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j = this.worldObj.getTopSolidOrLiquidBlock(i, k) - 8;
                    entitychicken.setLocationAndAngles((double)i + 0.5, j, (double)k + 0.5, this.rotationYaw, 0.0f);
                    entitychicken.addVelocity(0.0, 1.0, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.master = this;
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    ++this.numSpecialMinions;
                } else if (this.numZealots < this.getZealotCap()) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.worldObj);
                    i = MathHelper.floor_double((double)this.posX) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k = MathHelper.floor_double((double)this.posZ) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j = this.worldObj.getTopSolidOrLiquidBlock(i, k);
                    entitychicken.setLocationAndAngles((double)i + 0.5, j, (double)k + 0.5, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(2);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("mob.endermen.portal", 1.0f, 1.0f);
                    ++this.numZealots;
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityDragonMinion entitychicken = new EntityDragonMinion(this.worldObj);
                    i = MathHelper.floor_double((double)this.posX) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k = MathHelper.floor_double((double)this.posZ) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j = this.worldObj.getTopSolidOrLiquidBlock(i, k) - 8;
                    entitychicken.setLocationAndAngles((double)i + 0.5, j, (double)k + 0.5, this.rotationYaw, 0.0f);
                    entitychicken.addVelocity(0.0, 1.0, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.master = this;
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    ++this.numSpecialMinions;
                } else if (this.numBishop < this.getBishopCap()) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.worldObj);
                    i = MathHelper.floor_double((double)this.posX) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k = MathHelper.floor_double((double)this.posZ) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j = this.worldObj.getTopSolidOrLiquidBlock(i, k);
                    entitychicken.setLocationAndAngles((double)i + 0.5, j, (double)k + 0.5, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(3);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("mob.endermen.portal", 1.0f, 1.0f);
                    ++this.numBishop;
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityDragonMinion entitychicken = new EntityDragonMinion(this.worldObj);
                    i = MathHelper.floor_double((double)this.posX) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k = MathHelper.floor_double((double)this.posZ) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j = this.worldObj.getTopSolidOrLiquidBlock(i, k) - 8;
                    entitychicken.setLocationAndAngles((double)i + 0.5, j, (double)k + 0.5, this.rotationYaw, 0.0f);
                    entitychicken.addVelocity(0.0, 1.0, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.master = this;
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    entitychicken.playSound("mob.enderdragon.growl", 10.0f, 1.0f);
                    ++this.numSpecialMinions;
                } else if (this.numTemplar < this.getTemplarCap()) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.worldObj);
                    i = MathHelper.floor_double((double)this.posX) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k = MathHelper.floor_double((double)this.posZ) + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)15, (int)30) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j = this.worldObj.getTopSolidOrLiquidBlock(i, k);
                    entitychicken.setLocationAndAngles((double)i + 0.5, j, (double)k + 0.5, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(4);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("mob.endermen.portal", 1.0f, 1.0f);
                    ++this.numTemplar;
                }
            }
        }
        super.onLivingUpdate();
    }

    @Override
    protected void updateAITasks() {
        List list11;
        if (this.getEyeLaserTime() >= 0 && !this.worldObj.isRemote && this.ticksExisted % 5 == 0) {
            for (int i = 0; i < 2; ++i) {
                Vec3 vec3 = this.getLookVec();
                double x = i == 1 ? this.leftEye.posX : this.rightEye.posX;
                double y = (i == 1 ? this.leftEye.posY : this.rightEye.posY) + 1.0;
                double z = i == 1 ? this.leftEye.posZ : this.rightEye.posZ;
                double dx = x + vec3.xCoord * 300.0;
                double dy = y + vec3.yCoord * 300.0;
                double dz = z + vec3.zCoord * 300.0;
                double d0 = dx - x;
                double d1 = dy - y;
                double d2 = dz - z;
                if (this.getAttackTarget() != null) {
                    d0 = this.getAttackTarget().posX - x;
                    d1 = this.getAttackTarget().posY - y;
                    d2 = this.getAttackTarget().posZ - z;
                }
                EntitySkeletonTitanGiantArrow entityarrow = new EntitySkeletonTitanGiantArrow(this.worldObj, (EntityLivingBase)this, d0, d1, d2);
                entityarrow.posX = x;
                entityarrow.posY = y;
                entityarrow.posZ = z;
                this.worldObj.spawnEntityInWorld((Entity)entityarrow);
                entityarrow.setInvisible(true);
            }
        }
        if ((list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox)) != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (!(entity instanceof EntityLivingBase) || !entity.onGround || entity instanceof EntityTitan) continue;
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                entity.attackEntityFrom(DamageSourceExtra.causeSquishingDamage((Entity)this), f);
            }
        }
        if (this.ticksExisted % 20 == 0 && this.numOfCrystals < this.maxNumOfCrystals && !this.worldObj.isRemote) {
            EntityEnderColossusCrystal entitychicken = new EntityEnderColossusCrystal(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX, this.posY + 92.0, this.posZ, this.rotationYawHead, 0.0f);
            entitychicken.onSpawnWithEgg(null);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numOfCrystals;
            entitychicken.owner = this;
            entitychicken.motionY = 2.0;
            this.worldObj.createExplosion((Entity)entitychicken, entitychicken.posX, entitychicken.posY, entitychicken.posZ, 6.0f, false);
        }
        super.updateAITasks();
    }

    protected String getRoarSound() {
        return "thetitans:titanEnderColossusRoar";
    }

    protected String getLivingSound() {
        return null;
    }

    @Override
    protected String getHurtSound() {
        return "thetitans:titanEnderColossusGrunt";
    }

    @Override
    protected String getDeathSound() {
        return "thetitans:titanEnderColossusDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.playSound("thetitans:titanStep", 10.0f, 0.85f);
        this.shakeNearbyPlayerCameras(6000.0);
        float f3 = this.rotationYaw * (float)Math.PI / 180.0f;
        float f11 = MathHelper.sin((float)f3);
        float f4 = MathHelper.cos((float)f3);
        this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(1.0, 1.0, 1.0).offset((double)(f11 * 10.0f), 0.0, (double)(f4 * 10.0f))));
        this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(1.0, 1.0, 1.0).offset((double)(f11 * 10.0f), 0.0, (double)(f4 * 10.0f))));
    }

    protected Item getDropItem() {
        return Items.ender_eye;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            EntityItem entityitem;
            int l;
            for (int x = 0; x < 90; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.motionY += 1.0;
                entitylargefireball.setXPCount(26000);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            for (l = 0; l < 512 + this.rand.nextInt(512 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.ender_eye));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.ender_pearl));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 256 + this.rand.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.coal));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 256 + this.rand.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.iron_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 256 + this.rand.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.gold_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.emerald_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.diamond_block));
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
            for (l = 0; l < 64 + this.rand.nextInt(64 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.dragon_egg));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 60; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.end_portal_frame));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            EntityItem entityitem2 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanItems.voidSword));
            entityitem2.delayBeforeCanPickup = 40;
            this.worldObj.spawnEntityInWorld((Entity)entityitem2);
        }
    }

    protected void dropRareDrop(int p_70600_1_) {
        switch (this.rand.nextInt(3)) {
            case 0: {
                this.entityDropItem(new ItemStack(Items.golden_apple, 64, 1), 0.0f);
                break;
            }
            case 1: {
                this.dropItem(Items.diamond_sword, 64);
                break;
            }
            case 2: {
                this.dropItem(Items.name_tag, 64);
            }
        }
    }

    @Override
    public StatBase getAchievement() {
        return TitansAchievments.endercolossus;
    }

    public float getEyeHeight() {
        return this.isScreaming() ? 76.0f : 65.0f;
    }

    public boolean isScreaming() {
        return this.dataWatcher.getWatchableObjectByte(18) > 0;
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 0xF000F0;
    }

    public float getBrightness(float p_70013_1_) {
        return 1.0f;
    }

    public void setScreaming(boolean p_70819_1_) {
        if (!this.worldObj.isRemote) {
            this.dataWatcher.updateObject(18, (Object)((byte)(p_70819_1_ ? 1 : 0)));
        }
        if (p_70819_1_) {
            this.playSound(this.getRoarSound(), this.getSoundVolume(), 1.0f);
        }
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_180482_2_) {
        IEntityLivingData p_180482_2_1 = super.onSpawnWithEgg(p_180482_2_);
        this.playSound(this.getRoarSound(), this.getSoundVolume(), 1.0f);
        this.setScreaming(true);
        this.setCanCallBackUp(true);
        this.setRoarCooldownTimer(-20 - this.rand.nextInt(20));
        List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0));
        if (list11 != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                List list111;
                Entity entity = (Entity)list11.get(i1);
                if (entity == null || !(entity instanceof EntityWitherzilla) || (list111 = this.worldObj.getEntitiesWithinAABBExcludingEntity(entity, entity.boundingBox.expand(256.0, 256.0, 256.0))) == null || list111.isEmpty()) continue;
                for (int i11 = 0; i11 < list111.size(); ++i11) {
                    Entity entity1 = (Entity)list111.get(i11);
                    if (entity1 == null || !(entity1 instanceof EntityPlayer)) continue;
                    ((EntityPlayer)entity1).addChatMessage((IChatComponent)new ChatComponentText(StatCollector.translateToLocal((String)"dialog.witherzilla.endercolossus")));
                }
            }
        }
        return p_180482_2_1;
    }

    protected boolean canDespawn() {
        return false;
    }

    public double getYOffset() {
        return super.getYOffset() - 1.0;
    }

    @Override
    protected void inactDeathAction() {
        if (!this.worldObj.isRemote) {
            this.playSound("mob.endermen.death", this.getSoundVolume(), this.getSoundPitch());
            if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(true, 0);
                this.dropEquipment(true, 0);
                this.dropRareDrop(1);
            }
            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
            entitytitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(10);
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
            float f = (this.rand.nextFloat() - 0.5f) * 12.0f;
            float f1 = (this.rand.nextFloat() - 0.5f) * 3.0f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 12.0f;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        }
        if (this.getInvulTime() >= this.getThreashHold()) {
            this.setDead();
        }
    }

    public int getRoarCooldownTimer() {
        return this.roarcooldownTimer;
    }

    public void setRoarCooldownTimer(int roarcooldownTimer) {
        this.roarcooldownTimer = roarcooldownTimer;
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

    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source.getEntity() instanceof EntityPlayer && !this.worldObj.isRemote) {
            this.setAttackTarget((EntityLivingBase)source.getEntity());
            this.setRevengeTarget((EntityLivingBase)source.getEntity());
        }
        if (this.isEntityInvulnerable() || this.animID == 5) {
            return false;
        }
        if (source.getEntity() instanceof EntityEndermanMinion || source.getEntity() instanceof EntityEnderColossus || source.getEntity() instanceof EntityDragon || source.getEntity() instanceof EntityDragonMinion) {
            return false;
        }
        return super.attackEntityFrom(source, amount);
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
}

