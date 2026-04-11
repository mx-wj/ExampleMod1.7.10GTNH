/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.common.Loader
 *  cpw.mods.fml.common.eventhandler.Event
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.AntRobot
 *  danger.orespawn.Basilisk
 *  danger.orespawn.CaterKiller
 *  danger.orespawn.Cephadrome
 *  danger.orespawn.EmperorScorpion
 *  danger.orespawn.GiantRobot
 *  danger.orespawn.Godzilla
 *  danger.orespawn.GodzillaHead
 *  danger.orespawn.Hammerhead
 *  danger.orespawn.HerculesBeetle
 *  danger.orespawn.KingHead
 *  danger.orespawn.Kraken
 *  danger.orespawn.Leon
 *  danger.orespawn.Nastysaurus
 *  danger.orespawn.PitchBlack
 *  danger.orespawn.PurplePower
 *  danger.orespawn.QueenHead
 *  danger.orespawn.Robot2
 *  danger.orespawn.Robot3
 *  danger.orespawn.Robot4
 *  danger.orespawn.SpiderRobot
 *  danger.orespawn.TRex
 *  danger.orespawn.TheKing
 *  danger.orespawn.ThePrince
 *  danger.orespawn.ThePrinceAdult
 *  danger.orespawn.ThePrinceTeen
 *  danger.orespawn.ThePrincess
 *  danger.orespawn.TheQueen
 *  danger.orespawn.TrooperBug
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.particle.EntityFX
 *  net.minecraft.crash.CrashReport
 *  net.minecraft.crash.CrashReportCategory
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.IProjectile
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityWither
 *  net.minecraft.entity.boss.IBossDisplayData
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.passive.EntityWaterMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ReportedException
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.EnumSkyBlock
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.EnderTeleportEvent
 */
package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.AntRobot;
import danger.orespawn.Basilisk;
import danger.orespawn.CaterKiller;
import danger.orespawn.Cephadrome;
import danger.orespawn.EmperorScorpion;
import danger.orespawn.GiantRobot;
import danger.orespawn.Godzilla;
import danger.orespawn.GodzillaHead;
import danger.orespawn.Hammerhead;
import danger.orespawn.HerculesBeetle;
import danger.orespawn.KingHead;
import danger.orespawn.Kraken;
import danger.orespawn.Leon;
import danger.orespawn.Nastysaurus;
import danger.orespawn.PitchBlack;
import danger.orespawn.PurplePower;
import danger.orespawn.QueenHead;
import danger.orespawn.Robot2;
import danger.orespawn.Robot3;
import danger.orespawn.Robot4;
import danger.orespawn.SpiderRobot;
import danger.orespawn.TRex;
import danger.orespawn.TheKing;
import danger.orespawn.ThePrince;
import danger.orespawn.ThePrinceAdult;
import danger.orespawn.ThePrinceTeen;
import danger.orespawn.ThePrincess;
import danger.orespawn.TheQueen;
import danger.orespawn.TrooperBug;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.orespawnaddon.EntityMethuselahKraken;
import net.minecraft.entity.orespawnaddon.EntityOverlordScorpion;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityFallingBlockTitan;
import net.minecraft.entity.titan.EntityGargoyleTitan;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityLightningBall;
import net.minecraft.entity.titan.EntityProtoBall;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySkeletonTitanGiantArrow;
import net.minecraft.entity.titan.EntitySlimeTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWebShot;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAITitanLookIdle;
import net.minecraft.entity.titan.ai.EntityAITitanWatchClosest;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.entity.titanminion.EntityGiantZombieBetter;
import net.minecraft.entity.titanminion.EntityWitherMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.IMinion;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.items.ItemHarcadiumArmor;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import thehippomaster.AnimationAPI.AnimationAPI;

public abstract class EntityTitan
extends EntityCreature
implements ITitan,
IBossDisplayData {
    public boolean shouldParticlesBeUpward;
    public int deathTicks;
    public boolean isRejuvinating;
    public int animID;
    public int animTick;
    public boolean meleeTitan;
    protected int nextStepDistanceTitan;
    public int antiTitanAttackAnimeID;
    protected int numMinions;
    protected int numPriests;
    protected int numZealots;
    protected int numBishop;
    protected int numTemplar;
    protected int numSpecialMinions;
    public int footID;

    public EntityTitan(World worldIn) {
        super(worldIn);
        this.width = 1.0f;
        this.height = 6.0f;
        this.func_110163_bv();
        this.applyEntityAI();
        this.isImmuneToFire = true;
        this.ignoreFrustumCheck = true;
        this.maxHurtResistantTime = 30;
        this.tasks.addTask(7, (EntityAIBase)new EntityAITitanWatchClosest(this, EntityTitanSpirit.class, 128.0f, 0.25f));
        this.tasks.addTask(8, (EntityAIBase)new EntityAITitanWatchClosest(this, EntityTitan.class, 128.0f, 0.5f));
        this.tasks.addTask(9, (EntityAIBase)new EntityAITitanWatchClosest(this, EntityPlayer.class, 128.0f));
        this.tasks.addTask(10, (EntityAIBase)new EntityAITitanLookIdle(this));
        this.renderDistanceWeight = 1000.0;
    }

    public boolean alreadyHasAName() {
        return false;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Double.MAX_VALUE);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(512.0);
    }

    public void setFire(int p_70015_1_) {
    }

    public boolean allowLeashing() {
        return false;
    }

    public void moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
        if (this.noClip) {
            this.boundingBox.offset(p_70091_1_, p_70091_3_, p_70091_5_);
            this.posX = (this.boundingBox.minX + this.boundingBox.maxX) / 2.0;
            this.posY = this.boundingBox.minY + (double)this.yOffset - (double)this.ySize;
            this.posZ = (this.boundingBox.minZ + this.boundingBox.maxZ) / 2.0;
        } else {
            int k;
            double d11;
            double d10;
            double d12;
            int j;
            this.worldObj.theProfiler.startSection("move");
            this.ySize *= 0.4f;
            double d3 = this.posX;
            double d4 = this.posY;
            double d5 = this.posZ;
            double d6 = p_70091_1_;
            double d7 = p_70091_3_;
            double d8 = p_70091_5_;
            AxisAlignedBB axisalignedbb = this.boundingBox.copy();
            List list = this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox.addCoord(p_70091_1_, p_70091_3_, p_70091_5_));
            for (int i = 0; i < list.size(); ++i) {
                p_70091_3_ = ((AxisAlignedBB)list.get(i)).calculateYOffset(this.boundingBox, p_70091_3_);
            }
            this.boundingBox.offset(0.0, p_70091_3_, 0.0);
            if (!this.field_70135_K && d7 != p_70091_3_) {
                p_70091_5_ = 0.0;
                p_70091_3_ = 0.0;
                p_70091_1_ = 0.0;
            }
            boolean flag1 = this.onGround || d7 != p_70091_3_ && d7 < 0.0;
            for (j = 0; j < list.size(); ++j) {
                p_70091_1_ = ((AxisAlignedBB)list.get(j)).calculateXOffset(this.boundingBox, p_70091_1_);
            }
            this.boundingBox.offset(p_70091_1_, 0.0, 0.0);
            if (!this.field_70135_K && d6 != p_70091_1_) {
                p_70091_5_ = 0.0;
                p_70091_3_ = 0.0;
                p_70091_1_ = 0.0;
            }
            for (j = 0; j < list.size(); ++j) {
                p_70091_5_ = ((AxisAlignedBB)list.get(j)).calculateZOffset(this.boundingBox, p_70091_5_);
            }
            this.boundingBox.offset(0.0, 0.0, p_70091_5_);
            if (!this.field_70135_K && d8 != p_70091_5_) {
                p_70091_5_ = 0.0;
                p_70091_3_ = 0.0;
                p_70091_1_ = 0.0;
            }
            if (this.stepHeight > 0.0f && flag1 && this.ySize < 0.05f && (d6 != p_70091_1_ || d8 != p_70091_5_)) {
                d12 = p_70091_1_;
                d10 = p_70091_3_;
                d11 = p_70091_5_;
                p_70091_1_ = d6;
                p_70091_3_ = this.stepHeight;
                p_70091_5_ = d8;
                AxisAlignedBB axisalignedbb1 = this.boundingBox.copy();
                this.boundingBox.setBB(axisalignedbb);
                list = this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox.addCoord(d6, p_70091_3_, d8));
                for (k = 0; k < list.size(); ++k) {
                    p_70091_3_ = ((AxisAlignedBB)list.get(k)).calculateYOffset(this.boundingBox, p_70091_3_);
                }
                this.boundingBox.offset(0.0, p_70091_3_, 0.0);
                if (!this.field_70135_K && d7 != p_70091_3_) {
                    p_70091_5_ = 0.0;
                    p_70091_3_ = 0.0;
                    p_70091_1_ = 0.0;
                }
                for (k = 0; k < list.size(); ++k) {
                    p_70091_1_ = ((AxisAlignedBB)list.get(k)).calculateXOffset(this.boundingBox, p_70091_1_);
                }
                this.boundingBox.offset(p_70091_1_, 0.0, 0.0);
                if (!this.field_70135_K && d6 != p_70091_1_) {
                    p_70091_5_ = 0.0;
                    p_70091_3_ = 0.0;
                    p_70091_1_ = 0.0;
                }
                for (k = 0; k < list.size(); ++k) {
                    p_70091_5_ = ((AxisAlignedBB)list.get(k)).calculateZOffset(this.boundingBox, p_70091_5_);
                }
                this.boundingBox.offset(0.0, 0.0, p_70091_5_);
                if (!this.field_70135_K && d8 != p_70091_5_) {
                    p_70091_5_ = 0.0;
                    p_70091_3_ = 0.0;
                    p_70091_1_ = 0.0;
                }
                if (!this.field_70135_K && d7 != p_70091_3_) {
                    p_70091_5_ = 0.0;
                    p_70091_3_ = 0.0;
                    p_70091_1_ = 0.0;
                } else {
                    p_70091_3_ = -this.stepHeight;
                    for (k = 0; k < list.size(); ++k) {
                        p_70091_3_ = ((AxisAlignedBB)list.get(k)).calculateYOffset(this.boundingBox, p_70091_3_);
                    }
                    this.boundingBox.offset(0.0, p_70091_3_, 0.0);
                }
                if (d12 * d12 + d11 * d11 >= p_70091_1_ * p_70091_1_ + p_70091_5_ * p_70091_5_) {
                    p_70091_1_ = d12;
                    p_70091_3_ = d10;
                    p_70091_5_ = d11;
                    this.boundingBox.setBB(axisalignedbb1);
                }
            }
            this.worldObj.theProfiler.endSection();
            this.worldObj.theProfiler.startSection("rest");
            this.posX = (this.boundingBox.minX + this.boundingBox.maxX) / 2.0;
            this.posY = this.boundingBox.minY + (double)this.yOffset - (double)this.ySize;
            this.posZ = (this.boundingBox.minZ + this.boundingBox.maxZ) / 2.0;
            this.isCollidedHorizontally = d6 != p_70091_1_ || d8 != p_70091_5_;
            this.isCollidedVertically = d7 != p_70091_3_;
            this.onGround = d7 != p_70091_3_ && d7 < 0.0 || this.posY <= 0.0;
            this.isCollided = this.isCollidedHorizontally || this.isCollidedVertically;
            this.updateFallState(p_70091_3_, this.onGround);
            if (d6 != p_70091_1_) {
                this.motionX = 0.0;
            }
            if (d7 != p_70091_3_) {
                this.motionY = 0.0;
            }
            if (d8 != p_70091_5_) {
                this.motionZ = 0.0;
            }
            d12 = this.posX - d3;
            d10 = this.posY - d4;
            d11 = this.posZ - d5;
            if (this.ridingEntity == null && this.onGround) {
                int j1 = MathHelper.floor_double((double)this.posX);
                k = MathHelper.floor_double((double)(this.posY - 0.5 - (double)this.yOffset));
                int l = MathHelper.floor_double((double)this.posZ);
                Block block = this.worldObj.getBlock(j1, k, l);
                int i1 = this.worldObj.getBlock(j1, k - 1, l).getRenderType();
                if (i1 == 11 || i1 == 32 || i1 == 21) {
                    block = this.worldObj.getBlock(j1, k - 1, l);
                }
                if (block != Blocks.ladder) {
                    d10 = 0.0;
                }
                this.distanceWalkedModified = (float)((double)this.distanceWalkedModified + (double)MathHelper.sqrt_double((double)(d12 * d12 + d11 * d11)) * 0.6);
                this.distanceWalkedOnStepModified = (float)((double)this.distanceWalkedOnStepModified + (double)MathHelper.sqrt_double((double)(d12 * d12 + d10 * d10 + d11 * d11)) * 0.6);
                if (this.distanceWalkedOnStepModified > (float)this.nextStepDistanceTitan) {
                    this.nextStepDistanceTitan = (int)this.distanceWalkedOnStepModified + this.getFootStepModifer();
                    this.func_145780_a(j1, k, l, block);
                    block.onEntityWalking(this.worldObj, j1, k, l, (Entity)this);
                }
            } else if (this.ridingEntity != null || !this.onGround) {
                this.nextStepDistanceTitan = this.getFootStepModifer();
                this.distanceWalkedModified = 0.0f;
                this.distanceWalkedOnStepModified = 0.0f;
                this.footID = 0;
            }
            try {
                this.func_145775_I();
            }
            catch (Throwable throwable) {
                CrashReport crashreport = CrashReport.makeCrashReport((Throwable)throwable, (String)"Checking entity block collision");
                CrashReportCategory crashreportcategory = crashreport.makeCategory("Entity being checked for collision");
                this.addEntityCrashInfo(crashreportcategory);
                throw new ReportedException(crashreport);
            }
            this.worldObj.theProfiler.endSection();
        }
    }

    public int getFootStepModifer() {
        return 2;
    }

    public double getDistanceSqToEntity(Entity p_70068_1_) {
        double d0 = this.posX - p_70068_1_.posX;
        double d1 = this.posY + (double)(this.height * 0.5f) - p_70068_1_.posY;
        double d2 = this.posZ - p_70068_1_.posZ;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    protected void collideWithNearbyEntities() {
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(0.1, 0.1, 0.1));
        if (list != null && !list.isEmpty() && !this.getWaiting() && this.animID != 13) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (!this.isEntityAlive() || !entity.isEntityAlive() || !entity.canBePushed() && !(entity instanceof EntityTitan) && (!(entity instanceof EntityThrowable) || ((EntityThrowable)entity).getThrower() == this) && (!(entity instanceof EntityFireball) || ((EntityFireball)entity).shootingEntity == this) || !(entity.height > 6.0f) || entity instanceof EntityPlayer) continue;
                this.collideWithEntity(entity);
            }
        }
    }

    public void applyEntityCollision(Entity p_70108_1_) {
        double d1;
        double d0;
        double d2;
        if (!(!this.canAttackClass(p_70108_1_.getClass()) || this.getWaiting() || this.animID == 13 || p_70108_1_ instanceof EntitySkeletonTitanGiantArrow || p_70108_1_ instanceof EntityHarcadiumArrow || p_70108_1_ instanceof EntityFireball || p_70108_1_ instanceof EntityThrowable || p_70108_1_ instanceof EntityTitanPart || !this.isEntityAlive() || p_70108_1_.riddenByEntity == this || p_70108_1_.ridingEntity == this || !((d2 = MathHelper.abs_max((double)(d0 = p_70108_1_.posX - this.posX), (double)(d1 = p_70108_1_.posZ - this.posZ))) >= (double)0.01f))) {
            d2 = MathHelper.sqrt_double((double)d2);
            d0 /= d2;
            d1 /= d2;
            double d3 = 1.0 / d2;
            if (d3 > 1.0) {
                d3 = 1.0;
            }
            d0 *= d3;
            d1 *= d3;
            d0 *= 0.25;
            d1 *= 0.25;
            d0 *= (double)(1.0f - this.entityCollisionReduction);
            d1 *= (double)(1.0f - this.entityCollisionReduction);
            if (p_70108_1_.height >= 6.0f || p_70108_1_ instanceof EntityTitan) {
                this.addTitanVelocity(-d0, 0.0, -d1);
            }
            p_70108_1_.addVelocity(d0 *= 4.0, 0.75, d1 *= 4.0);
        }
    }

    public void setTitanHealth(float p_70606_1_) {
        if (!this.worldObj.isRemote) {
            this.dataWatcher.updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)p_70606_1_, (float)0.0f, (float)this.getMaxHealth())));
            this.dataWatcher.updateObject(5, (Object)Float.valueOf(MathHelper.clamp_float((float)p_70606_1_, (float)0.0f, (float)this.getMaxHealth())));
        }
    }

    @SideOnly(value=Side.CLIENT)
    public float getShadowSize() {
        return 0.0f;
    }

    public boolean isEntityAlive() {
        return !this.isDead && this.dataWatcher.getWatchableObjectFloat(5) > 0.0f;
    }

    public void setHealth(float p_70606_1_) {
        this.dataWatcher.updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)this.dataWatcher.getWatchableObjectFloat(5), (float)0.0f, (float)this.getMaxHealth())));
    }

    public Vec3 getLook(float p_70676_1_) {
        if (p_70676_1_ == 1.0f) {
            float f1 = MathHelper.cos((float)(-this.rotationYawHead * ((float)Math.PI / 180) - (float)Math.PI));
            float f2 = MathHelper.sin((float)(-this.rotationYawHead * ((float)Math.PI / 180) - (float)Math.PI));
            float f3 = -MathHelper.cos((float)(-this.rotationPitch * ((float)Math.PI / 180)));
            float f4 = MathHelper.sin((float)(-this.rotationPitch * ((float)Math.PI / 180)));
            return Vec3.createVectorHelper((double)(f2 * f3), (double)f4, (double)(f1 * f3));
        }
        float f1 = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * p_70676_1_;
        float f2 = this.prevRotationYawHead + (this.rotationYawHead - this.prevRotationYawHead) * p_70676_1_;
        float f3 = MathHelper.cos((float)(-f2 * ((float)Math.PI / 180) - (float)Math.PI));
        float f4 = MathHelper.sin((float)(-f2 * ((float)Math.PI / 180) - (float)Math.PI));
        float f5 = -MathHelper.cos((float)(-f1 * ((float)Math.PI / 180)));
        float f6 = MathHelper.sin((float)(-f1 * ((float)Math.PI / 180)));
        return Vec3.createVectorHelper((double)(f4 * f5), (double)f6, (double)(f3 * f5));
    }

    public void heal(float p_70691_1_) {
        float f1 = this.getHealth();
        if (f1 > 0.0f && this.dataWatcher.getWatchableObjectFloat(5) > 0.0f) {
            this.setTitanHealth(f1 + p_70691_1_);
        }
    }

    protected void damageEntity(DamageSource p_70665_1_, float p_70665_2_) {
        float f = TheTitans.NightmareMode ? 400.0f : 800.0f;
        if (p_70665_2_ > f && !(this instanceof EntitySlimeTitan)) {
            float f2 = p_70665_2_ = TheTitans.NightmareMode ? 400.0f : 800.0f;
        }
        if (!this.isEntityInvulnerable()) {
            if ((p_70665_2_ = ForgeHooks.onLivingHurt((EntityLivingBase)this, (DamageSource)p_70665_1_, (float)p_70665_2_)) <= 0.0f) {
                return;
            }
            p_70665_2_ = this.applyArmorCalculations(p_70665_1_, p_70665_2_);
            float f1 = p_70665_2_ = this.applyPotionDamageCalculations(p_70665_1_, p_70665_2_);
            p_70665_2_ = Math.max(p_70665_2_ - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (f1 - p_70665_2_));
            if (p_70665_2_ != 0.0f) {
                float f2 = this.getHealth();
                this.setTitanHealth(f2 - p_70665_2_);
                this.func_110142_aN().func_94547_a(p_70665_1_, f2, p_70665_2_);
                this.setAbsorptionAmount(this.getAbsorptionAmount() - p_70665_2_);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_) {
        if (p_70103_1_ == 2) {
            this.limbSwingAmount = 1.5f;
            this.hurtResistantTime = this.maxHurtResistantTime;
            this.maxHurtTime = 10;
            this.hurtTime = 10;
            this.attackedAtYaw = 0.0f;
            this.playSound(this.getHurtSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            this.attackEntityFrom(DamageSource.generic, 0.0f);
        }
    }

    public void setDead() {
        if (this.deathTicks > 0 || this instanceof EntitySlimeTitan || this.dataWatcher.getWatchableObjectFloat(5) <= 0.0f) {
            this.inactDeathAction();
            ArrayList listp = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
            if (!(listp == null || listp.isEmpty() || this.worldObj.isRemote || this instanceof EntitySlimeTitan || this instanceof EntityGargoyleTitan || this instanceof EntityIronGolemTitan || this instanceof EntitySnowGolemTitan)) {
                for (int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity == null || !(entity instanceof EntityPlayer)) continue;
                    this.playLivingSound();
                    ((EntityPlayer)entity).addChatMessage((IChatComponent)new ChatComponentText(this.getCommandSenderName() + ": I will return, " + entity.getCommandSenderName()));
                }
            }
            super.setDead();
        }
    }

    protected void inactDeathAction() {
        this.worldObj.newExplosion((Entity)this, this.posX, this.posY + 3.0, this.posZ, 0.0f, false, false);
        if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
            this.dropFewItems(true, 0);
            this.dropEquipment(true, 0);
            this.dropRareDrop(1);
        }
    }

    public void func_82206_m() {
        this.setInvulTime(this.getTitanStatus() == EnumTitanStatus.GOD ? 7100 : (this.getTitanStatus() == EnumTitanStatus.GREATER ? 1310 : (this instanceof EntitySnowGolemTitan || this instanceof EntitySlimeTitan ? 150 : 850)));
        this.setWaiting(false);
    }

    protected void applyEntityAI() {
    }

    public boolean isAIEnabled() {
        return true;
    }

    public void setAttackTarget(EntityLivingBase p_70624_1_) {
        if (p_70624_1_ != EntityList.createEntityByName((String)"MobzillaHead", (World)this.worldObj) && p_70624_1_ != EntityList.createEntityByName((String)"KingHead", (World)this.worldObj) && p_70624_1_ != EntityList.createEntityByName((String)"QueenHead", (World)this.worldObj) && !this.getWaiting() && this.animID != 13 && p_70624_1_ != null && p_70624_1_.posY < 256.0 && p_70624_1_.isEntityAlive() && this.canAttackClass(p_70624_1_.getClass()) && p_70624_1_ != this.ridingEntity && p_70624_1_ != this.riddenByEntity) {
            super.setAttackTarget(p_70624_1_);
            if (!this.worldObj.isRemote && p_70624_1_ instanceof EntityPlayer && p_70624_1_.ticksExisted > 100 && !((EntityPlayer)p_70624_1_).inventory.hasItem(TitanItems.ultimaBlade) && ((EntityPlayer)p_70624_1_).isEntityAlive() && ((EntityPlayer)p_70624_1_).hurtResistantTime <= 10) {
                if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
                    MinecraftServer.getServer().func_147139_a(EnumDifficulty.EASY);
                }
                if (!((EntityPlayer)p_70624_1_).attackEntityFrom(new DamageSource("other").setDamageBypassesArmor().setDamageIsAbsolute().setDamageAllowedInCreativeMode(), 1.0f)) {
                    ((EntityPlayer)p_70624_1_).inventory.dropAllItems();
                    ((EntityPlayer)p_70624_1_).setHealth(0.0f);
                    MinecraftServer.getServer().getConfigurationManager().func_152612_a((String)((EntityPlayer)p_70624_1_).getCommandSenderName()).playerNetServerHandler.kickPlayerFromServer(this.getCommandSenderName() + " has kicked you for cheating.");
                }
            }
        } else if (p_70624_1_ instanceof EntityTitan && (this.worldObj.provider instanceof WorldProviderVoid || ((EntityTitan)p_70624_1_).getInvulTime() > 0 || ((EntityTitan)p_70624_1_).getWaiting() || ((EntityTitan)p_70624_1_).animID == 13) && !(p_70624_1_ instanceof EntityWitherzilla)) {
            super.setAttackTarget(null);
        } else {
            super.setAttackTarget(null);
        }
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(5, (Object)Float.valueOf(Float.MAX_VALUE));
        this.dataWatcher.addObject(20, (Object)new Integer(0));
        this.dataWatcher.addObject(21, (Object)new Integer(0));
        this.dataWatcher.addObject(22, (Object)new Integer(0));
        this.dataWatcher.addObject(23, (Object)Byte.valueOf((byte)0));
    }

    protected void jumpAtEntity(EntityLivingBase e) {
        float f2;
        this.motionY += 1.25;
        this.posY += (double)1.55f;
        double d1 = e.posX - this.posX;
        double d2 = e.posZ - this.posZ;
        float d = (float)Math.atan2(d2, d1);
        this.rotationYaw = f2 = (float)((double)d * 180.0 / Math.PI) - 90.0f;
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        this.motionX += d1 * 0.05 * Math.cos(d);
        this.motionZ += d1 * 0.05 * Math.sin(d);
        this.isAirBorne = true;
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.setInvulTime(tagCompund.getInteger("Invul"));
        this.setExtraPower(tagCompund.getInteger("ExtraPower"));
        this.setWaiting(tagCompund.getBoolean("Waiting"));
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("Invul", this.getInvulTime());
        tagCompound.setInteger("ExtraPower", this.getExtraPower());
        tagCompound.setBoolean("Waiting", this.getWaiting());
    }

    public void mountEntity(Entity p_70078_1_) {
        if (p_70078_1_ instanceof EntityLivingBase) {
            super.mountEntity(p_70078_1_);
        }
    }

    public int getMinionCap() {
        return 120;
    }

    public int getPriestCap() {
        return 60;
    }

    public int getZealotCap() {
        return 30;
    }

    public int getBishopCap() {
        return 15;
    }

    public int getTemplarCap() {
        return 6;
    }

    public int getSpecialMinionCap() {
        return 6;
    }

    public int getExtraPower() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public void setExtraPower(int p_82215_1_) {
        this.dataWatcher.updateObject(21, (Object)p_82215_1_);
    }

    public int getRandomName() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public void setRandomName(int p_82215_1_) {
        this.dataWatcher.updateObject(21, (Object)p_82215_1_);
    }

    public boolean getWaiting() {
        return this.dataWatcher.getWatchableObjectByte(23) == 1;
    }

    public void setWaiting(boolean p_82215_1_) {
        this.dataWatcher.updateObject(23, (Object)(p_82215_1_ ? (byte)1 : 0));
    }

    public int getInvulTime() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setInvulTime(int p_82215_1_) {
        if (!this.worldObj.isRemote) {
            if (p_82215_1_ < 0) {
                this.dataWatcher.updateObject(20, (Object)0);
            } else {
                this.dataWatcher.updateObject(20, (Object)p_82215_1_);
                this.prevRotationPitch = this.rotationPitch = 0.0f + (float)p_82215_1_ / ((float)this.getThreashHold() / 180.0f);
            }
        }
    }

    public boolean destroyBlocksInAABBGriefingBypass(AxisAlignedBB p_70972_1_) {
        long perfNs = TitansPerf.begin();
        try {
        int i = MathHelper.floor_double((double)p_70972_1_.minX);
        int j = MathHelper.floor_double((double)p_70972_1_.minY);
        int k = MathHelper.floor_double((double)p_70972_1_.minZ);
        int l = MathHelper.floor_double((double)p_70972_1_.maxX);
        int i1 = MathHelper.floor_double((double)p_70972_1_.maxY);
        int j1 = MathHelper.floor_double((double)p_70972_1_.maxZ);
        TitansPerf.count(this.getClass().getSimpleName() + "#destroyBlocksInAABBGriefingBypass.volume", (l - i + 1) * (i1 - j + 1) * (j1 - k + 1));
        boolean flag = false;
        boolean flag1 = false;
        for (int k1 = i; k1 <= l; ++k1) {
            for (int l1 = j; l1 <= i1; ++l1) {
                for (int i2 = k; i2 <= j1; ++i2) {
                    Block block = this.worldObj.getBlock(k1, l1, i2);
                    if (block.isAir((IBlockAccess)this.worldObj, k1, l1, i2) || this.worldObj.isRemote || block.getBlockHardness(this.worldObj, k1, l1, i2) == -1.0f) continue;
                    flag1 = this.worldObj.setBlockToAir(k1, l1, i2) || flag1;
                }
            }
        }
        return flag;
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.BLOCK_BREAK, this.getClass().getSimpleName() + "#destroyBlocksInAABBGriefingBypass", perfNs);
        }
}

    public void destroyBlocksInAABB(AxisAlignedBB p_70972_1_) {
        long perfNs = TitansPerf.begin();
        try {
        int i = MathHelper.floor_double((double)p_70972_1_.minX);
        int j = MathHelper.floor_double((double)p_70972_1_.minY);
        int k = MathHelper.floor_double((double)p_70972_1_.minZ);
        int l = MathHelper.floor_double((double)p_70972_1_.maxX);
        int i1 = MathHelper.floor_double((double)p_70972_1_.maxY);
        int j1 = MathHelper.floor_double((double)p_70972_1_.maxZ);
        TitansPerf.count(this.getClass().getSimpleName() + "#destroyBlocksInAABB.volume", (l - i + 1) * (i1 - j + 1) * (j1 - k + 1));
        for (int k1 = i; k1 <= l; ++k1) {
            for (int l1 = j; l1 <= i1; ++l1) {
                for (int i2 = k; i2 <= j1; ++i2) {
                    Block block = this.worldObj.getBlock(k1, l1, i2);
                    if (this.ticksExisted <= 5 || p_70972_1_ == null || !this.worldObj.checkChunksExist(k1, l1, i2, k1, l1, i2) || block.isAir((IBlockAccess)this.worldObj, k1, l1, i2) || this.worldObj.isRemote || block.getBlockHardness(this.worldObj, k1, l1, i2) == -1.0f) continue;
                    if (block.getMaterial().isLiquid() || block == Blocks.fire || block == Blocks.web) {
                        this.worldObj.setBlockToAir(k1, l1, i2);
                        continue;
                    }
                    if (this.rand.nextInt(3) == 0) {
                        EntityFallingBlockTitan entityfallingblock = new EntityFallingBlockTitan(this.worldObj, (double)k1 + 0.5, (double)l1 + 0.5, (double)i2 + 0.5, block, this.worldObj.getBlockMetadata(k1, l1, i2));
                        entityfallingblock.setPosition((double)k1 + 0.5, (double)l1 + 0.5, (double)i2 + 0.5);
                        double d0 = (this.boundingBox.minX + this.boundingBox.maxX) / 2.0;
                        double d1 = (this.boundingBox.minZ + this.boundingBox.maxZ) / 2.0;
                        double d2 = entityfallingblock.posX - d0;
                        double d3 = entityfallingblock.posZ - d1;
                        double d4 = d2 * d2 + d3 * d3;
                        entityfallingblock.setFire(10);
                        entityfallingblock.addVelocity(d2 / d4 * 10.0, 2.0 + this.rand.nextGaussian(), d3 / d4 * 10.0);
                        this.worldObj.spawnEntityInWorld((Entity)entityfallingblock);
                        this.worldObj.setBlockToAir(k1, l1, i2);
                        continue;
                    }
                    if (this.worldObj.getClosestPlayerToEntity((Entity)this, 16.0) != null) {
                        this.worldObj.func_147480_a(k1, l1, i2, true);
                        continue;
                    }
                    this.worldObj.setBlockToAir(k1, l1, i2);
                    block.dropBlockAsItem(this.worldObj, k1, l1, i2, this.worldObj.getBlockMetadata(k1, l1, i2), 0);
                }
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.BLOCK_BREAK, this.getClass().getSimpleName() + "#destroyBlocksInAABB", perfNs);
        }
}

    public void destroyBlocksInAABBTopless(AxisAlignedBB p_70972_1_) {
        long perfNs = TitansPerf.begin();
        try {
        int i = MathHelper.floor_double((double)p_70972_1_.minX);
        int j = MathHelper.floor_double((double)p_70972_1_.minY);
        int k = MathHelper.floor_double((double)p_70972_1_.minZ);
        int l = MathHelper.floor_double((double)p_70972_1_.maxX);
        int i1 = MathHelper.floor_double((double)p_70972_1_.maxY);
        int j1 = MathHelper.floor_double((double)p_70972_1_.maxZ);
        TitansPerf.count(this.getClass().getSimpleName() + "#destroyBlocksInAABBTopless.volume", (l - i + 1) * (i1 - j + 1) * (j1 - k + 1));
        for (int k1 = i; k1 <= l; ++k1) {
            for (int l1 = j; l1 <= i1; ++l1) {
                for (int i2 = k; i2 <= j1; ++i2) {
                    Block block = this.worldObj.getBlock(k1, l1, i2);
                    Block block1 = this.worldObj.getBlock(k1, l1 + 1, i2);
                    if (this.ticksExisted <= 5 || p_70972_1_ == null || !this.worldObj.checkChunksExist(k1, l1, i2, k1, l1, i2) || !block.isOpaqueCube() || block1.isOpaqueCube() || this.worldObj.isRemote || block.getBlockHardness(this.worldObj, k1, l1, i2) == -1.0f) continue;
                    if (block.getMaterial().isLiquid() || block == Blocks.fire || block == Blocks.web) {
                        this.worldObj.setBlockToAir(k1, l1, i2);
                        continue;
                    }
                    if (this.rand.nextInt(3) == 0) {
                        EntityFallingBlockTitan entityfallingblock = new EntityFallingBlockTitan(this.worldObj, (double)k1 + 0.5, (double)l1 + 0.5, (double)i2 + 0.5, block, this.worldObj.getBlockMetadata(k1, l1, i2));
                        entityfallingblock.setPosition((double)k1 + 0.5, (double)l1 + 0.5, (double)i2 + 0.5);
                        double d0 = (this.boundingBox.minX + this.boundingBox.maxX) / 2.0;
                        double d1 = (this.boundingBox.minZ + this.boundingBox.maxZ) / 2.0;
                        double d2 = entityfallingblock.posX - d0;
                        double d3 = entityfallingblock.posZ - d1;
                        double d4 = d2 * d2 + d3 * d3;
                        entityfallingblock.setFire(10);
                        entityfallingblock.addVelocity(d2 / d4 * 10.0, 2.0 + this.rand.nextGaussian(), d3 / d4 * 10.0);
                        this.worldObj.spawnEntityInWorld((Entity)entityfallingblock);
                        this.worldObj.setBlockToAir(k1, l1, i2);
                        continue;
                    }
                    if (this.worldObj.getClosestPlayerToEntity((Entity)this, 16.0) != null) {
                        this.worldObj.func_147480_a(k1, l1, i2, true);
                        continue;
                    }
                    this.worldObj.setBlockToAir(k1, l1, i2);
                    block.dropBlockAsItem(this.worldObj, k1, l1, i2, this.worldObj.getBlockMetadata(k1, l1, i2), 0);
                }
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.BLOCK_BREAK, this.getClass().getSimpleName() + "#destroyBlocksInAABBTopless", perfNs);
        }
}

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
            this.playSound("thetitans:groundSmash", 20.0f, 1.0f);
            this.playSound("thetitans:titanland", 10000.0f, 1.0f);
            this.destroyBlocksInAABBTopless(this.boundingBox.expand(this.getTitanStatus() == EnumTitanStatus.LESSER ? 6.0 : 12.0, 1.0, this.getTitanStatus() == EnumTitanStatus.LESSER ? 6.0 : 12.0));
            List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(48.0, 4.0, 48.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity = (Entity)list11.get(i1);
                    if (!(entity instanceof EntityLivingBase) || !this.canAttackClass(entity.getClass()) || entity instanceof EntityTitan) continue;
                    float smash = 50.0f - this.getDistanceToEntity(entity);
                    if (smash <= 1.0f) {
                        smash = 1.0f;
                    }
                    entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), smash);
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

    public boolean canBePushed() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean canRenderOnFire() {
        return false;
    }

    public int getTotalArmorValue() {
        switch (this.getTitanStatus()) {
            case GOD: {
                return 24;
            }
            case GREATER: {
                return 23;
            }
            case AVERAGE: {
                return 22;
            }
        }
        return 21;
    }

    public int getMaxSpawnedInChunk() {
        return 1;
    }

    public int getTitanExperienceDropAmount() {
        return 1;
    }

    public float getRenderSizeModifier() {
        return this.getTitanStatus() == EnumTitanStatus.GREATER ? 20.0f : 16.0f;
    }

    public void addPotionEffect(PotionEffect p_70690_1_) {
    }

    protected float getSoundVolume() {
        return 100.0f;
    }

    protected void despawnEntity() {
        this.entityAge = 0;
    }

    public int getTalkInterval() {
        return 120;
    }

    public int getMaxFallHeight() {
        return this.worldObj.getHeight();
    }

    public void setInWeb() {
    }

    public int getMinionSpawnRate() {
        return 0;
    }

    public boolean handleWaterMovement() {
        return false;
    }

    public boolean handleLavaMovement() {
        return false;
    }

    protected int decreaseAirSupply(int p_70682_1_) {
        return p_70682_1_;
    }

    public double getSpeed() {
        return 0.3 + (double)this.getExtraPower() * 0.001;
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.getWaiting() && this.animID != 0 && this.deathTicks < this.getThreashHold()) {
            ++this.animTick;
            if (this.isChild() && this.isEntityAlive()) {
                ++this.animTick;
            }
        }
    }

    public double getMeleeRange() {
        return (double)(this.width * this.width + (this.getAttackTarget().width > 48.0f ? 2304.0f : this.getAttackTarget().width * this.getAttackTarget().width)) + 800.0;
    }

    public void addVelocity(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
    }

    public void addTitanVelocity(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
        if (!this.getWaiting() && this.animID != 13) {
            this.motionX += p_70024_1_;
            this.motionY += p_70024_3_;
            this.motionZ += p_70024_5_;
        }
    }

    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        double d0;
        if (this.getAttackTarget() != null && this.getAttackTarget() instanceof EntityLiving) {
            if (EntityTitan.isOreSpawnBossToExempt((Entity)this.getAttackTarget())) {
                ((EntityLiving)this.getAttackTarget()).setAttackTarget((EntityLivingBase)this);
                ((EntityLiving)this.getAttackTarget()).getLookHelper().setLookPositionWithEntity((Entity)this, 180.0f, 180.0f);
            }
        }
        if (this.animID == 13 && this.animTick == 4 && this.worldObj.getClosestPlayerToEntity((Entity)this, 32.0) != null) {
            this.getLookHelper().setLookPositionWithEntity((Entity)this.worldObj.getClosestPlayerToEntity((Entity)this, 32.0), 180.0f, 0.0f);
        }
        boolean bl = this.isAirBorne = !this.onGround;
        if (this.motionX > 1.5) {
            this.motionX = 1.5;
        }
        if (this.motionZ > 1.5) {
            this.motionZ = 1.5;
        }
        if (this.motionX < -1.5) {
            this.motionX = -1.5;
        }
        if (this.motionZ < -1.5) {
            this.motionZ = -1.5;
        }
        Calendar calendar = this.worldObj.getCurrentDate();
        if (!(this.getWaiting() || this.worldObj.getWorldTime() >= 14000L || this.isRejuvinating || this instanceof EntitySlimeTitan || this instanceof EntitySnowGolemTitan || this instanceof EntityIronGolemTitan || this instanceof EntityGargoyleTitan || (this.animID != 13 || this.getWaiting()) && (calendar.get(2) + 1 != 10 || calendar.get(5) < 1 || calendar.get(5) > 31))) {
            this.worldObj.setWorldTime(this.worldObj.getWorldTime() + 50L);
        }
        if (this.worldObj.getWorldTime() > 24000L) {
            this.worldObj.setWorldTime(0L);
        }
        if (this.getAttackTarget() != null && (!this.getAttackTarget().isEntityAlive() || this.getAttackTarget().posY > 256.0 || this.getAttackTarget().posY < -45.0)) {
            this.setAttackTarget(null);
        }
        if (this.getAttackTarget() != null && this.getAttackTarget() instanceof EntityLiving && !(this.getAttackTarget() instanceof EntityTitanSpirit) && !(this.getAttackTarget() instanceof EntityTitan) && this.getAttackTarget().getMaxHealth() > 1.0E9f) {
            this.getAttackTarget().playSound("random.explode", 2.0f, 1.0f + this.rand.nextFloat());
            this.damageBypassEntity(this.getAttackTarget(), new DamageSource("infinity").setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), this.getAttackTarget().getHealth() / 2.0f);
            if (this.getAttackTarget().getHealth() <= 1.0f) {
                this.worldObj.createExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 7.0f, false);
                this.getAttackTarget().setDead();
            }
        }
        if (this != null && !this.worldObj.isRemote && this.getAttackTarget() != null && this.getAttackTarget() instanceof EntityPlayer && ((EntityPlayer)this.getAttackTarget()).capabilities.disableDamage && !((EntityPlayer)this.getAttackTarget()).capabilities.isCreativeMode) {
            MinecraftServer.getServer().getConfigurationManager().func_152612_a((String)((EntityPlayer)this.getAttackTarget()).getCommandSenderName()).playerNetServerHandler.kickPlayerFromServer(this.getCommandSenderName() + " has detected you not taking normal damage out of creative, and kicked you for it.");
        }
        if (this.ridingEntity != null) {
            this.renderYawOffset = this.rotationYaw = this.ridingEntity.rotationYaw;
        }
        if (this.animID == 0) {
            this.animTick = 0;
        } else {
            this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
        }
        if (this.getWaiting()) {
            this.motionX = 0.0;
            this.motionZ = 0.0;
            if (this.motionY > 0.0) {
                this.motionY = 0.0;
            }
        }
        if (this.animID == 0 && !this.worldObj.isRemote && this.getAttackTarget() != null && this.shouldMove() && !(this instanceof EntityGhastTitan)) {
            double d02 = this.getAttackTarget().posX - this.posX;
            double d1 = this.getAttackTarget().posZ - this.posZ;
            float f2 = MathHelper.sqrt_double((double)(d02 * d02 + d1 * d1));
            this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
            this.motionX = d02 / (double)f2 * this.getSpeed() * this.getSpeed() + this.motionX;
            this.motionZ = d1 / (double)f2 * this.getSpeed() * this.getSpeed() + this.motionZ;
        }
        if (this.deathTime == 1) {
            this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
        }
        this.dataWatcher.updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)this.dataWatcher.getWatchableObjectFloat(5), (float)0.0f, (float)this.getMaxHealth())));
        if (TheTitans.TitansFFAMode && this.ridingEntity != null) {
            this.ridingEntity = null;
        }
        if (this.animID < 0) {
            this.animID = 0;
        }
        if (this.dataWatcher.getWatchableObjectFloat(5) <= 0.0f) {
            if (this instanceof EntityWitherzilla && this.getExtraPower() > 5) {
                this.dataWatcher.updateObject(5, (Object)Float.valueOf(MathHelper.clamp_float((float)this.getMaxHealth(), (float)0.0f, (float)this.getMaxHealth())));
            }
            this.onTitanDeathUpdate();
        } else {
            this.dataWatcher.updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)this.dataWatcher.getWatchableObjectFloat(5), (float)0.0f, (float)this.getMaxHealth())));
            this.deathTicks = 0;
            if (this.animID == 10) {
                this.animID = 0;
            }
        }
        if (this.posY > 300.0) {
            this.motionY = 0.0;
            this.setPosition(this.posX + (double)(this.rand.nextFloat() * 32.0f - 16.0f), 60.0, this.posZ + (double)(this.rand.nextFloat() * 32.0f - 16.0f));
        }
        if (this.posY <= 0.0) {
            this.setPosition(this.posX, 0.0, this.posZ);
            this.onGround = true;
            this.isAirBorne = false;
            this.fallDistance = 0.0f;
            if (this.motionY < 0.0) {
                this.motionY = 0.0;
            }
        }
        if (this.numMinions < 0) {
            this.numMinions = 0;
        }
        if (this.numPriests < 0) {
            this.numPriests = 0;
        }
        if (this.numZealots < 0) {
            this.numZealots = 0;
        }
        if (this.numTemplar < 0) {
            this.numTemplar = 0;
        }
        if (this.numSpecialMinions < 0) {
            this.numSpecialMinions = 0;
        }
        if (this.getHealth() <= 0.0f && this.motionY > 0.0) {
            this.motionY = 0.0;
        }
        if (this.animTick < 0) {
            this.animTick = 0;
        }
        this.isInWeb = false;
        this.lastDamage = 2.14748365E9f;
        this.stepHeight = this.height / 2.0f;
        this.updateArmSwingProgress();
        this.ignoreFrustumCheck = true;
        if (this.getAttackTarget() != null && this.animID == 0) {
            this.getLookHelper().setLookPositionWithEntity((Entity)this.getAttackTarget(), 5.0f, (float)this.getVerticalFaceSpeed());
        }
        for (int u = 0; u < 30; ++u) {
            int k;
            int j;
            int i;
            Block block;
            if (this.motionX == 0.0 || this.motionZ == 0.0 || !this.onGround || (block = this.worldObj.getBlock(i = MathHelper.floor_double((double)(this.posX + (this.rand.nextDouble() * (double)this.width - (double)(this.width / 2.0f)))), j = MathHelper.floor_double((double)(this.posY - (double)0.2f)), k = MathHelper.floor_double((double)(this.posZ + (this.rand.nextDouble() * (double)this.width - (double)(this.width / 2.0f)))))).getMaterial() == Material.air) continue;
            this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock((Block)block) + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.boundingBox.minY + 0.1, this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, 4.0 * ((double)this.rand.nextFloat() - 0.5), 0.5, ((double)this.rand.nextFloat() - 0.5) * 4.0);
        }
        super.setHealth(this.dataWatcher.getWatchableObjectFloat(5));
        super.onLivingUpdate();
        if (this.getAttackTarget() != null && this.animID == 0 && this.ticksExisted % 30 == 0 && this.canAttack() && (d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget())) < this.getMeleeRange()) {
            this.swingItem();
            this.getLookHelper().setLookPositionWithEntity((Entity)this.getAttackTarget(), 5.0f, (float)this.getVerticalFaceSpeed());
            this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
            this.attackEntityAsMob((Entity)this.getAttackTarget());
        }
        if (this.getAttackTarget() != null && this.getAttackTarget() == this.ridingEntity || this.getAttackTarget() != null && this.getAttackTarget() == this.riddenByEntity) {
            this.setAttackTarget(null);
        }
        if (this.worldObj.isRemote && this.deathTicks < this.getThreashHold() && !(this instanceof EntityWitherzilla)) {
            int i;
            for (i = 0; i < this.getParticleCount(); ++i) {
                if (this.shouldParticlesBeUpward) {
                    this.worldObj.spawnParticle(this.getParticles(), this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.25, 0.0);
                    continue;
                }
                this.worldObj.spawnParticle(this.getParticles(), this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
            }
            if (TheTitans.TotalDestructionMode && this.rand.nextInt(5) == 0) {
                for (i = 0; i < 5; ++i) {
                    this.worldObj.spawnParticle("largeexplode", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                }
            }
            if (TheTitans.NightmareMode && this.rand.nextInt(20) == 0) {
                for (i = 0; i < 5; ++i) {
                    this.worldObj.spawnParticle("largeexplode", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    this.worldObj.spawnParticle("lava", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    this.worldObj.spawnParticle("smoke", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                }
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
}

    public boolean isNoDespawnRequired() {
        return true;
    }

    public boolean canAttack() {
        return this.meleeTitan;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean shouldMove() {
        if (this instanceof EntityWitherzilla) return false;
        if (this.getAttackTarget() == null) return false;
        double d = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
        double d2 = this.getMeleeRange();
        double d3 = this.meleeTitan ? 0.0 : 10000.0;
        if (!(d > d2 + d3)) return false;
        return true;
    }

    public int getFootID() {
        return this.footID;
    }

    protected void updateAITasks() {
        long perfNs = TitansPerf.begin();
        try {
        List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox);
        TitansPerf.count(this.getClass().getSimpleName() + "#updateAITasks.entityScan", list11 == null ? 0 : list11.size());
        if (list11 != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                this.applyEntityCollision(entity);
            }
        }
        if (this.rand.nextInt(1000) == 0 && this.getHealth() < this.getMaxHealth() / 20.0f && this.deathTicks <= 0 || this.getHealth() < this.getMaxHealth() / 2.0f && this.deathTicks <= 0 && this.getAttackTarget() != null && this.getAttackTarget() instanceof EntityTitan && !this.isRejuvinating && ((EntityTitan)this.getAttackTarget()).isRejuvinating && !(this instanceof EntitySlimeTitan) && !(this instanceof EntitySnowGolemTitan) && !(this instanceof EntityIronGolemTitan) && !(this instanceof EntityGargoyleTitan)) {
            this.isRejuvinating = true;
            this.worldObj.playBroadcastSound(1013, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            this.setExtraPower(this.getExtraPower() + 1);
            this.jump();
        }
        if (this.isRejuvinating) {
            this.setInvulTime(this.getInvulTime() + 5);
            this.performHurtAnimation();
            if (this.getInvulTime() > this.getThreashHold()) {
                this.isRejuvinating = false;
            }
        }
        if (this.getInvulTime() > 0) {
            this.motionX *= 0.0;
            this.motionZ *= 0.0;
            int i = this.getInvulTime() - 1;
            if (i <= 0) {
                if (!(this instanceof EntitySnowGolemTitan || this instanceof EntityIronGolemTitan || this instanceof EntityGargoyleTitan)) {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY + (double)(this.height / 2.0f), this.posZ, this.height, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                }
                this.worldObj.playBroadcastSound(1013, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                this.destroyBlocksInAABB(this.boundingBox);
                if (this instanceof EntityZombieTitan && !((EntityZombieTitan)this).isArmed()) {
                    AnimationAPI.sendAnimPacket((EntityZombieTitan)this, 2);
                }
            }
            this.setInvulTime(i);
            if (this.ticksExisted % 1 == 0) {
                this.heal(this.getMaxHealth() / 1000.0f);
            }
        } else {
            super.updateAITasks();
            if (!(this instanceof EntitySlimeTitan)) {
                float at = this.getTitanStatus() == EnumTitanStatus.AVERAGE ? 3.0f : (this.getTitanStatus() == EnumTitanStatus.GREATER ? 6.0f : (this.getTitanStatus() == EnumTitanStatus.GOD ? 20.0f : 1.0f));
                if ((this instanceof EntityZombieTitan || this instanceof EntitySkeletonTitan) && this.worldObj.isDaytime()) {
                    at /= 3.0f;
                }
                if (this instanceof EntitySnowGolemTitan || this instanceof EntityIronGolemTitan || this instanceof EntityGargoyleTitan) {
                    at = 0.1f;
                }
                this.heal(at);
                for (int u = 0; u < 1 + this.rand.nextInt(10); ++u) {
                    this.heal(at);
                }
            }
            if (this.getAttackTarget() != null && !(this instanceof EntitySlimeTitan) && (this.getAttackTarget() instanceof EntityAmbientCreature || this.getAttackTarget() instanceof EntityAnimal || this.getAttackTarget() instanceof EntityWaterMob)) {
                this.getAttackTarget().setDead();
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
        }
}

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
        this.setTitanHealth(this.getMaxHealth());
        return super.onSpawnWithEgg(p_110161_1_);
    }

    public void onDeath(DamageSource p_70645_1_) {
        Entity entity = p_70645_1_.getEntity();
        ArrayList listp = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
        if (listp != null && !listp.isEmpty() && !this.worldObj.isRemote && entity != null && entity instanceof EntityLivingBase) {
            for (int i1 = 0; i1 < listp.size(); ++i1) {
                EntityPlayer entityplayer = (EntityPlayer)listp.get(i1);
                if (this.dataWatcher.getWatchableObjectFloat(5) > 0.0f) {
                    entityplayer.addChatMessage((IChatComponent)new ChatComponentText(this.getCustomNameTag() + " has refused to let " + entity.getCommandSenderName() + " cheat..."));
                    continue;
                }
                entityplayer.addChatMessage((IChatComponent)new ChatComponentText(this.getCustomNameTag() + " has been defeated by " + entity.getCommandSenderName()));
            }
        }
        if (this.dataWatcher.getWatchableObjectFloat(5) <= 0.0f) {
            EntityLivingBase entitylivingbase = this.func_94060_bK();
            if (this.scoreValue >= 0 && entitylivingbase != null) {
                entitylivingbase.addToPlayerScore((Entity)this, this.scoreValue);
            }
            if (entity != null) {
                entity.onKillEntity((EntityLivingBase)this);
            }
            this.dead = true;
            this.func_110142_aN().func_94549_h();
            if (!this.worldObj.isRemote) {
                int i = 0;
                if (entity instanceof EntityPlayer) {
                    i = EnchantmentHelper.getLootingModifier((EntityLivingBase)((EntityLivingBase)entity));
                }
                this.captureDrops = true;
                this.capturedDrops.clear();
                int j = 0;
                if (this.func_146066_aG() && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                    this.dropFewItems(this.recentlyHit > 0, i);
                    this.dropEquipment(this.recentlyHit > 0, i);
                    if (this.recentlyHit > 0 && (j = this.rand.nextInt(200) - i) < 5) {
                        this.dropRareDrop(j <= 0 ? 1 : 0);
                    }
                }
                this.captureDrops = false;
                if (!ForgeHooks.onLivingDrops((EntityLivingBase)this, (DamageSource)p_70645_1_, (ArrayList)this.capturedDrops, (int)i, (this.recentlyHit > 0 ? 1 : 0) != 0, (int)j)) {
                    for (EntityItem item : this.capturedDrops) {
                        this.worldObj.spawnEntityInWorld((Entity)item);
                    }
                }
            }
            this.worldObj.setEntityState((Entity)this, (byte)3);
        }
    }

    protected void jump() {
        super.jump();
        this.playSound("thetitans:titanSwing", 5.0f, 2.0f);
        this.motionY += 1.0;
        this.motionY += 1.0;
    }

    public int getParticleCount() {
        return 6;
    }

    public String getParticles() {
        switch (this.getTitanStatus()) {
            case GOD: {
                return "fireworksSpark";
            }
            case GREATER: {
                return "magicCrit";
            }
            case AVERAGE: {
                return "crit";
            }
        }
        return "enchantmenttable";
    }

    public int getThreashHold() {
        return this.getTitanStatus() == EnumTitanStatus.GOD ? 7100 : (this.getTitanStatus() == EnumTitanStatus.GREATER ? 1310 : (this instanceof EntitySnowGolemTitan || this instanceof EntitySlimeTitan ? 150 : 850));
    }

    public void collideWithEntities(EntityTitanPart part, List p_70970_1_) {
        if (part != null && part.worldObj != null && !this.getWaiting()) {
            double d0 = (part.boundingBox.minX + part.boundingBox.maxX) / 2.0;
            double d1 = (part.boundingBox.minZ + part.boundingBox.maxZ) / 2.0;
            for (Object entityObj : p_70970_1_) {
                Entity entity = (Entity)entityObj;
                boolean leg;
                boolean bl = leg = part.field_146032_b == "rightleg" || part.field_146032_b == "leftleg" || part.field_146032_b == "leg1" || part.field_146032_b == "leg2" || part.field_146032_b == "leg3" || part.field_146032_b == "leg4";
                if (!this.canAttackClass(entity.getClass()) || entity == null || entity instanceof EntityWebShot || entity instanceof EntitySkeletonTitanGiantArrow || entity instanceof EntityWitherSkull || entity instanceof EntityTitanFireball || entity instanceof EntityProtoBall || entity instanceof EntityLightningBall || entity instanceof EntityTitanPart || entity instanceof EntityHarcadiumArrow || entity instanceof EntityTitan || entity instanceof EntityTitanSpirit) continue;
                double d2 = entity.posX - d0;
                double d3 = entity.posZ - d1;
                double d4 = d2 * d2 + d3 * d3;
                entity.addVelocity(d2 / d4 * (leg ? 5.0 : 1.5), leg ? 1.75 : 0.5, d3 / d4 * (leg ? 5.0 : 1.5));
                if (!this.worldObj.isRemote && this.canAttackClass(entity.getClass()) && entity.posY <= part.posY - (double)part.height - 0.01) {
                    entity.attackEntityFrom(DamageSource.causeThornsDamage((Entity)this), 20.0f);
                }
                if (!(this instanceof EntitySkeletonTitan) || ((EntitySkeletonTitan)this).getSkeletonType() != 1 || !(entity instanceof EntityLivingBase)) continue;
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.wither.id, 1200, 3));
            }
        }
    }

    public int getRegenTime() {
        return 20;
    }

    public int getKnockbackAmount() {
        switch (this.getTitanStatus()) {
            case GOD: {
                return 24;
            }
            case GREATER: {
                return 16;
            }
            case AVERAGE: {
                return 8;
            }
        }
        return 4;
    }

    @Override
    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.LESSER;
    }

    protected String getSwimSound() {
        return "game.hostile.swim";
    }

    protected String getSplashSound() {
        return "game.hostile.swim.splash";
    }

    public boolean isPotionApplicable(PotionEffect p_70687_1_) {
        return false;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity = source.getEntity();
        float f = TheTitans.NightmareMode ? 500.0f : 1000.0f;
        if (amount > f && !(this instanceof EntitySlimeTitan)) {
            amount = TheTitans.NightmareMode ? 500.0f : 1000.0f;
        }
        if (EntityTitan.isOreSpawnBossToExempt(source.getEntity()) || source.getEntity() instanceof EntityIronGolem || source.getEntity() instanceof EntityGiantZombieBetter || source.getEntity() instanceof EntityDragon || source.getEntity() instanceof EntityWither || source.getEntity() instanceof EntityDragonMinion || source.getEntity() instanceof EntityWitherMinion) {
            this.playSound("thetitans:titanpunch", 50.0f, this.isChild() ? 1.5f : 1.0f);
            amount *= 10.0f;
        }
        if (this.isEntityInvulnerable() || source.getEntity() == null || amount <= 20.0f) {
            return false;
        }
        if (source.getEntity() instanceof EntitySnowGolemTitan && this instanceof EntitySnowGolemTitan) {
            return false;
        }
        if (source.getEntity() instanceof EntityPlayer && !this.canBeHurtByPlayer()) {
            return false;
        }
        if (entity != null && entity instanceof EntityLivingBase && (this.riddenByEntity != null && source.getEntity() == this.riddenByEntity || entity.isEntityInvulnerable() || entity.height >= 6.0f || ((EntityLivingBase)entity).getTotalArmorValue() > 24 && !((EntityLivingBase)entity).isPotionActive(Potion.field_76444_x) || ((EntityLivingBase)entity).isEntityInvulnerable() || ((EntityLivingBase)entity).isPotionActive(Potion.damageBoost) && ((EntityLivingBase)entity).getActivePotionEffect(Potion.damageBoost).getAmplifier() > 255) && !EntityTitan.whiteListNoDamage(entity) && !(entity instanceof EntityTameable)) {
            return false;
        }
        if ((source.isMagicDamage() || source.isExplosion() || source.isFireDamage() || source.getDamageType() == "inFire" || source.getDamageType() == "onFire" || source.getDamageType() == "lava" || source.getDamageType() == "inWall" || source.getDamageType() == "drown" || source.getDamageType() == "starve" || source.getDamageType() == "cactus" || source.getDamageType() == "fall" || source.getDamageType() == "generic" || source.getDamageType() == "outOfWorld" || source.getDamageType() == "magic" || source.getDamageType() == "wither" || source.getDamageType() == "anvil" || source.getDamageType() == "fallingBlock" || source.getDamageType() == "explosion.player" || source.getDamageType() == "explosion" || source.getDamageType() == "indirectMagic") && !(this instanceof EntitySlimeTitan)) {
            return false;
        }
        if (super.attackEntityFrom(source, amount)) {
            if (entity != null && entity instanceof EntityLivingBase && this.animTick <= 12 && !(this.worldObj.provider instanceof WorldProviderVoid)) {
                this.setAttackTarget((EntityLivingBase)entity);
                this.setRevengeTarget((EntityLivingBase)entity);
            }
            return true;
        }
        return false;
    }

    protected String getHurtSound() {
        return "game.hostile.hurt";
    }

    protected String getDeathSound() {
        return "game.hostile.die";
    }

    protected String getFallSoundString(int damageValue) {
        return "thetitans:titanStep";
    }

    @SideOnly(value=Side.CLIENT)
    public void shakeNearbyPlayerCameras(double distance) {
        Entity entity;
        int l1;
        if (!this.worldObj.playerEntities.isEmpty()) {
            for (l1 = 0; l1 < this.worldObj.playerEntities.size(); ++l1) {
                entity = (Entity)this.worldObj.playerEntities.get(l1);
                if (!(entity instanceof EntityPlayer) || !(entity.getDistanceSqToEntity((Entity)this) < distance)) continue;
                this.worldObj.setEntityState((Entity)((EntityPlayer)entity), (byte)2);
                ((EntityPlayer)entity).hurtResistantTime = 0;
            }
        }
        if (!this.worldObj.loadedEntityList.isEmpty()) {
            for (l1 = 0; l1 < this.worldObj.loadedEntityList.size(); ++l1) {
                entity = (Entity)this.worldObj.loadedEntityList.get(l1);
                if (!(entity instanceof EntityLiving) || entity instanceof EntityTitan || !(entity.getDistanceSqToEntity((Entity)this) < distance)) continue;
                try {
                    ReflectionHelper.findField(entity.getClass(), (String[])new String[]{"hurt_timer"}).setInt((EntityLiving)entity, 0);
                }
                catch (Exception e) {
                    ((EntityLiving)entity).hurtResistantTime = 0;
                }
                ((EntityLiving)entity).hurtResistantTime = 0;
                this.worldObj.setEntityState((Entity)((EntityLiving)entity), (byte)2);
            }
        }
    }

    public static boolean isOreSpawnBossToExempt(Entity entity) {
        if (!(entity instanceof EntityLivingBase)) {
            return false;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof EntityOverlordScorpion) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof EntityMethuselahKraken) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Kraken) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof PitchBlack) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Godzilla) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof GodzillaHead) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof TheKing) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof TheQueen) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof KingHead) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof QueenHead) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof ThePrinceAdult) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof GiantRobot) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof AntRobot) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Basilisk) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof CaterKiller) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Cephadrome) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof EmperorScorpion) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof HerculesBeetle) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Hammerhead) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Leon) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Robot2) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Robot3) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Robot4) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof ThePrince) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof ThePrinceTeen) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof ThePrincess) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof SpiderRobot) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof TrooperBug) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Nastysaurus) {
            return true;
        }
        return Loader.isModLoaded((String)"OreSpawn") && entity instanceof TRex;
    }

    public static boolean whiteListNoDamage(Entity entity) {
        if (entity instanceof EntityPlayer) {
            return true;
        }
        if (entity instanceof EntityTitan) {
            return true;
        }
        if (entity instanceof EntityGiantZombieBetter) {
            return true;
        }
        if (entity instanceof EntityDragonMinion) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof EntityOverlordScorpion) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof EntityMethuselahKraken) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Kraken) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof PitchBlack) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Godzilla) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof GodzillaHead) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof TheKing) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof TheQueen) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof KingHead) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof QueenHead) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof ThePrinceAdult) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof GiantRobot) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof AntRobot) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Basilisk) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof CaterKiller) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Cephadrome) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof EmperorScorpion) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof HerculesBeetle) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Hammerhead) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Leon) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Robot2) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Robot3) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Robot4) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof ThePrince) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof ThePrinceTeen) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof ThePrincess) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof SpiderRobot) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof TrooperBug) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof Nastysaurus) {
            return true;
        }
        if (Loader.isModLoaded((String)"OreSpawn") && entity instanceof TRex) {
            return true;
        }
        if (entity instanceof EntityLivingBase && entity.height > 6.0f) {
            return false;
        }
        return entity instanceof EntityLivingBase || entity instanceof EntityFireball || entity instanceof EntityArrow || entity instanceof EntityThrowable;
    }

    public void attackChoosenEntity(Entity damagedEntity, float damage, int knockbackAmount) {
        float at = this.getTitanStatus() == EnumTitanStatus.AVERAGE ? 20.0f : (this.getTitanStatus() == EnumTitanStatus.GREATER ? 50.0f : (this.getTitanStatus() == EnumTitanStatus.GOD ? 200.0f : 10.0f));
        if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
            at *= 0.5f;
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
            at *= 2.0f;
        }
        if (TheTitans.TotalDestructionMode) {
            at = Float.MAX_VALUE;
            damage = Float.MAX_VALUE;
        }
        damagedEntity.hurtResistantTime = 0;
        if (!(damagedEntity instanceof EntityTitan) && damagedEntity.height < 6.0f && this.canAttackClass(damagedEntity.getClass())) {
            damagedEntity.motionY += this.rand.nextDouble();
            if (knockbackAmount > 0) {
                damagedEntity.addVelocity((double)(-MathHelper.sin((float)(this.renderYawOffset * (float)Math.PI / 180.0f)) * (float)knockbackAmount) * 0.2, (double)knockbackAmount * 0.2, (double)(MathHelper.cos((float)(this.renderYawOffset * (float)Math.PI / 180.0f)) * (float)knockbackAmount) * 0.2);
            }
        }
        if (damagedEntity != null && this.isEntityAlive() && (damagedEntity instanceof EntityPlayer && damagedEntity.getCommandSenderName() != "Umbrella_Ghast" || !(damagedEntity instanceof EntityFX) && !(damagedEntity instanceof EntityTitanPart) && !(damagedEntity instanceof EntityItem) && !(damagedEntity instanceof EntityXPOrb) && !(damagedEntity instanceof IProjectile) && !(damagedEntity instanceof EntityFireball))) {
            if (damagedEntity instanceof EntityEnderCrystal) {
                damagedEntity.attackEntityFrom(new DamageSource("other").setDamageBypassesArmor().setDamageIsAbsolute().setDamageAllowedInCreativeMode(), 100.0f);
            }
            if (damagedEntity instanceof EntityDragon) {
                this.worldObj.newExplosion(null, damagedEntity.posX, damagedEntity.posY, damagedEntity.posZ, 6.0f, false, false);
            }
            this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
            if (EnchantmentHelper.getFireAspectModifier((EntityLivingBase)this) > 0) {
                damagedEntity.setFire(EnchantmentHelper.getFireAspectModifier((EntityLivingBase)this) * 100);
            }
            if (!(damagedEntity instanceof EntityLivingBase)) {
                damagedEntity.attackEntityFrom(new DamageSource("other").setDamageBypassesArmor().setDamageIsAbsolute().setDamageAllowedInCreativeMode(), damage);
                damagedEntity.setDead();
            } else if (damagedEntity.isEntityAlive()) {
                if (EntityTitan.isOreSpawnBossToExempt(damagedEntity)) {
                    damagedEntity.hurtResistantTime = 0;
                    try {
                        ReflectionHelper.findField(damagedEntity.getClass(), (String[])new String[]{"hurt_timer"}).setInt(damagedEntity, 0);
                    }
                    catch (Exception e) {
                        damagedEntity.hurtResistantTime = 0;
                    }
                    try {
                        ReflectionHelper.findField(damagedEntity.getClass(), (String[])new String[]{"large_unknown_detected"}).setInt(this, 0);
                    }
                    catch (Exception e) {
                        damagedEntity.hurtResistantTime = 0;
                    }
                    try {
                        ReflectionHelper.findField(damagedEntity.getClass(), (String[])new String[]{"player_hit_count"}).setInt(this, 10);
                    }
                    catch (Exception e) {
                        damagedEntity.hurtResistantTime = 0;
                    }
                }
                if (damagedEntity.height >= 6.0f || damagedEntity instanceof EntityTitan) {
                    damage *= EntityTitan.isOreSpawnBossToExempt(damagedEntity) ? 2.0f : 10.0f;
                    damagedEntity.playSound("thetitans:titanpunch", 50.0f, this.isChild() ? 1.5f : 1.0f);
                }
                if (damagedEntity instanceof EntityPlayer && ((EntityPlayer)damagedEntity).getCommandSenderName() == "SuperGirlyGamer") {
                    damage *= 100.0f;
                    damagedEntity.motionY += 10.0;
                    damagedEntity.playSound("thetitans:titanpunch", 50.0f, 1.0f);
                }
                if (damagedEntity instanceof EntityLivingBase && this.canAttackClass(damagedEntity.getClass()) && !(this instanceof EntitySlimeTitan) && !(this instanceof EntitySnowGolemTitan) && !(this instanceof EntityGargoyleTitan) && !(this instanceof EntityIronGolemTitan)) {
                    this.damageBypassEntity((EntityLivingBase)damagedEntity, DamageSourceExtra.causeSoulStealingDamage((Entity)this), at);
                    int b0 = 1 + this.worldObj.difficultySetting.getDifficultyId();
                    ((EntityLivingBase)damagedEntity).addPotionEffect(new PotionEffect(ClientProxy.electricJudgment.id, b0 * 20, 2));
                }
                damage += EnchantmentHelper.func_152377_a((ItemStack)this.getHeldItem(), (EnumCreatureAttribute)((EntityLivingBase)damagedEntity).getCreatureAttribute());
                knockbackAmount += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)this, (EntityLivingBase)((EntityLivingBase)damagedEntity));
                if (damagedEntity instanceof EntityLivingBase && Loader.isModLoaded((String)"OreSpawn") && ((EntityLivingBase)damagedEntity).getHealth() <= 2050.0f && (damagedEntity instanceof TheKing || damagedEntity instanceof TheQueen)) {
                    ((EntityLivingBase)damagedEntity).getDataWatcher().updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)1.0f, (float)0.0f, (float)((EntityLivingBase)damagedEntity).getMaxHealth())));
                    damagedEntity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.worldObj.getClosestPlayerToEntity((Entity)this, -1.0)), damage);
                    this.damageBypassEntity((EntityLivingBase)damagedEntity, DamageSourceExtra.destroy, damage);
                    damagedEntity.playSound("orespawn:trex_death", 5.0f, 1.0f);
                }
                if (damagedEntity instanceof EntityLivingBase && Loader.isModLoaded((String)"OreSpawn") && damagedEntity instanceof PurplePower) {
                    ((EntityLivingBase)damagedEntity).getDataWatcher().updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)0.0f, (float)0.0f, (float)((EntityLivingBase)damagedEntity).getMaxHealth())));
                    damagedEntity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.worldObj.getClosestPlayerToEntity((Entity)this, -1.0)), damage);
                    ((PurplePower)damagedEntity).setHealth(0.0f);
                    ((PurplePower)damagedEntity).playSound("orespawn:trex_death", 2.0f, 0.9999f);
                    ((PurplePower)damagedEntity).playSound("orespawn:trex_death", 2.0f, 1.0f);
                    ((PurplePower)damagedEntity).playSound("orespawn:trex_death", 2.0f, 1.0001f);
                }
                if (!(damagedEntity instanceof EntityTitan) && this.canAttackClass(damagedEntity.getClass())) {
                    damagedEntity.motionY += this.rand.nextDouble();
                    if (knockbackAmount > 0) {
                        damagedEntity.addVelocity((double)(-MathHelper.sin((float)(this.renderYawOffset * (float)Math.PI / 180.0f)) * (float)knockbackAmount) * 0.2, (double)knockbackAmount * 0.2, (double)(MathHelper.cos((float)(this.renderYawOffset * (float)Math.PI / 180.0f)) * (float)knockbackAmount) * 0.2);
                    }
                }
                if (damagedEntity instanceof EntityPlayer) {
                    if (!this.worldObj.isRemote && ((EntityPlayer)damagedEntity).getHeldItem() != null && ((EntityPlayer)damagedEntity).getHeldItem().isItemEnchanted() && ((EntityPlayer)damagedEntity).getHeldItem().getItem() != TitanItems.ultimaBlade) {
                        ((EntityPlayer)damagedEntity).getHeldItem().setTagCompound(new NBTTagCompound());
                        this.setAttackTarget((EntityLivingBase)((EntityPlayer)damagedEntity));
                    }
                    for (int i = 0; i < ((EntityPlayer)damagedEntity).inventory.armorInventory.length; ++i) {
                        if (((EntityPlayer)damagedEntity).inventory.armorInventory[i] == null) continue;
                        if (!(((EntityPlayer)damagedEntity).inventory.armorInventory[i].getItem() instanceof ItemHarcadiumArmor)) {
                            ((EntityPlayer)damagedEntity).inventory.armorInventory[i].stackSize = 0;
                            ((EntityPlayer)damagedEntity).inventory.armorInventory[i] = null;
                            ((EntityPlayer)damagedEntity).playSound("random.break", 0.8f, 0.8f + this.worldObj.rand.nextFloat() * 0.4f);
                            this.damageBypassEntity((EntityLivingBase)((EntityPlayer)damagedEntity), new DamageSource("infinity").setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), at);
                            continue;
                        }
                        ((EntityPlayer)damagedEntity).inventory.armorInventory[i].setItemDamage((int)((float)((EntityPlayer)damagedEntity).inventory.armorInventory[i].getItemDamage() + damage));
                    }
                    if (((EntityPlayer)damagedEntity).capabilities.disableDamage || this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
                        damagedEntity.attackEntityFrom(DamageSourceExtra.causeArmorPiercingMobDamage((Entity)this).setDamageIsAbsolute().setDamageAllowedInCreativeMode(), at);
                        this.damageBypassEntity((EntityLivingBase)((EntityPlayer)damagedEntity), new DamageSource("infinity").setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), at);
                        this.damageBypassEntity((EntityLivingBase)((EntityPlayer)damagedEntity), new DamageSource("other").setDamageBypassesArmor().setDamageIsAbsolute().setDamageAllowedInCreativeMode(), at);
                        this.damageBypassEntity((EntityLivingBase)((EntityPlayer)damagedEntity), DamageSource.outOfWorld.setDamageIsAbsolute(), at);
                    }
                }
                if ((((EntityLivingBase)damagedEntity).isEntityInvulnerable() && !(damagedEntity instanceof EntityTitan) || ((EntityLivingBase)damagedEntity).getTotalArmorValue() > 19 || (EntityLivingBase)damagedEntity instanceof EntityPlayer && ((EntityPlayer)damagedEntity).capabilities.disableDamage || ((EntityLivingBase)damagedEntity).isPotionActive(Potion.resistance) && ((EntityLivingBase)damagedEntity).getActivePotionEffect(Potion.resistance).getAmplifier() > 4) && !(damagedEntity instanceof EntityTitan) && !(damagedEntity instanceof IMinion) && !(damagedEntity instanceof EntityTameable)) {
                    if ((EntityLivingBase)damagedEntity instanceof EntityPlayer) {
                        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
                            MinecraftServer.getServer().func_147139_a(EnumDifficulty.HARD);
                        }
                        damagedEntity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this).setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), at);
                        damagedEntity.attackEntityFrom(new DamageSource("infinity").setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), at);
                    } else {
                        damagedEntity.attackEntityFrom(new DamageSource("infinity").setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), at);
                        this.damageBypassEntity((EntityLivingBase)damagedEntity, new DamageSource("infinity").setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), damage);
                    }
                } else if (this.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD && ((EntityLivingBase)damagedEntity).getCreatureAttribute() == EnumCreatureAttribute.UNDEAD && !(damagedEntity instanceof EntityTitan)) {
                    this.damageBypassEntity((EntityLivingBase)damagedEntity, new DamageSource("infinity").setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), damage);
                } else if (damagedEntity.height >= 6.0f && !(damagedEntity instanceof EntityTameable) && !(damagedEntity instanceof EntityTitan) && !(damagedEntity instanceof EntityDragon) && !(damagedEntity instanceof EntityDragonMinion) || ((EntityLivingBase)damagedEntity).getTotalArmorValue() > 9 && !(damagedEntity instanceof EntityPlayer) && !(damagedEntity instanceof EntityTitan) && !(damagedEntity instanceof EntityDragon) && !(damagedEntity instanceof IMinion)) {
                    this.damageBypassEntity((EntityLivingBase)damagedEntity, new DamageSource("infinity").setDamageBypassesArmor().setDamageAllowedInCreativeMode().setDamageIsAbsolute(), damage);
                } else {
                    damagedEntity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), damage);
                }
            }
        }
    }

    private void damageBypassEntity(EntityLivingBase entity, DamageSource p_70665_1_, float p_70665_2_) {
        if (entity.isEntityAlive()) {
            if (p_70665_2_ <= 0.0f) {
                return;
            }
            float f1 = p_70665_2_;
            p_70665_2_ = Math.max(p_70665_2_ - entity.getAbsorptionAmount(), 0.0f);
            entity.setAbsorptionAmount(entity.getAbsorptionAmount() - (f1 - p_70665_2_));
            if (p_70665_2_ != 0.0f) {
                if (entity instanceof EntityCreature) {
                    EntityIronGolemTitan.addTitanTargetingTaskToEntity((EntityCreature)entity);
                }
                float f2 = entity.getHealth();
                if (!entity.attackEntityFrom(p_70665_1_, p_70665_2_)) {
                    entity.getDataWatcher().updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)(f2 - p_70665_2_), (float)0.0f, (float)entity.getMaxHealth())));
                }
                entity.func_110142_aN().func_94547_a(p_70665_1_, f2, p_70665_2_);
                entity.setAbsorptionAmount(entity.getAbsorptionAmount() - p_70665_2_);
                if (!(entity instanceof EntityTitan)) {
                    if (entity.height == 50.0f && entity.width == 15.0f) {
                        entity.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(0.0);
                        entity.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)this).setDamageBypassesArmor().setDamageIsAbsolute(), 40.0f);
                        entity.addPotionEffect(new PotionEffect(ClientProxy.death.id, Integer.MAX_VALUE, 19));
                    }
                    if (!entity.isEntityAlive()) {
                        entity.onDeath(p_70665_1_);
                    }
                }
            }
        }
    }

    public boolean canBeHurtByPlayer() {
        return !this.isEntityInvulnerable();
    }

    public boolean attackEntityAsMob(Entity p_70652_1_) {
        this.swingItem();
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int i = this.getKnockbackAmount();
        if (TheTitans.TotalDestructionMode) {
            f = Float.MAX_VALUE;
        }
        this.attackChoosenEntity(p_70652_1_, f, i);
        if (p_70652_1_ instanceof EntityMob) {
            ((EntityMob)p_70652_1_).setRevengeTarget((EntityLivingBase)this);
        }
        this.getLookHelper().setLookPositionWithEntity(p_70652_1_, 180.0f, (float)this.getVerticalFaceSpeed());
        return true;
    }

    protected boolean isValidLightLevel() {
        int k;
        int j;
        int i = MathHelper.floor_double((double)this.posX);
        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j = MathHelper.floor_double((double)this.boundingBox.minY), k = MathHelper.floor_double((double)this.posZ)) > this.rand.nextInt(32)) {
            return false;
        }
        int l = this.worldObj.getBlockLightValue(i, j, k);
        if (this.worldObj.isThundering()) {
            int i1 = this.worldObj.skylightSubtracted;
            this.worldObj.skylightSubtracted = 10;
            l = this.worldObj.getBlockLightValue(i, j, k);
            this.worldObj.skylightSubtracted = i1;
        }
        return l <= this.rand.nextInt(8);
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }

    public void onKillCommand() {
        if (this.getTitanStatus() != EnumTitanStatus.GOD) {
            this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
            this.setDead();
        }
    }

    protected boolean func_146066_aG() {
        return false;
    }

    public StatBase getAchievement() {
        return null;
    }

    protected void onDeathUpdate() {
    }

    protected void onTitanDeathUpdate() {
        if (this instanceof EntitySnowGolemTitan || this instanceof EntitySlimeTitan) {
            ++this.deathTime;
            this.destroyBlocksInAABB(this.boundingBox);
            if (this.deathTime == 20) {
                this.setDead();
                for (int i = 0; i < 20; ++i) {
                    double d2 = this.rand.nextGaussian() * 0.02;
                    double d0 = this.rand.nextGaussian() * 0.02;
                    double d1 = this.rand.nextGaussian() * 0.02;
                    this.worldObj.spawnParticle("largeexplode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d2, d0, d1);
                }
            }
        }
        this.dataWatcher.updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)this.dataWatcher.getWatchableObjectFloat(5), (float)0.0f, (float)this.getMaxHealth())));
        this.deathTicks = this.dataWatcher.getWatchableObjectFloat(5) <= 0.0f ? ++this.deathTicks : 0;
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
        this.motionX *= 0.0;
        this.motionZ *= 0.0;
        if (!(this instanceof EntitySnowGolemTitan) && !(this instanceof EntitySlimeTitan)) {
            this.rotationYaw = this.rotationYawHead += 10.0f;
            this.renderYawOffset = this.rotationYawHead;
        }
        this.rotationPitch = 0.0f + (float)this.getInvulTime() / 4.8f + (0.01f + 0.01f * MathHelper.cos((float)((float)this.ticksExisted * 0.25f))) * (float)Math.PI;
        this.setAttackTarget(null);
        this.performHurtAnimation();
        this.spawnExplosionParticle();
        if (this.deathTicks > 200 && !this.worldObj.isRemote) {
            this.setInvulTime(this.getInvulTime() + 10);
        }
        if (this.getInvulTime() >= this.getThreashHold()) {
            this.setDead();
        }
    }

    public boolean isEntityInvulnerable() {
        return this.getInvulTime() >= 1 || this.getWaiting() || this.animID == 13 || this.deathTicks > 0 || this instanceof EntityWitherzilla && !(this.worldObj.provider instanceof WorldProviderVoid) && this.getExtraPower() > 5 || super.isEntityInvulnerable();
    }

    protected boolean teleportEntityRandomly(EntityLivingBase entity) {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5) * (72.0 + (double)this.width);
        double d1 = this.posY - (double)this.height + (double)(this.height * 2.0f);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5) * (72.0 + (double)this.width);
        return this.teleportEntityTo(entity, d0, d1, d2);
    }

    protected boolean teleportEntityTo(EntityLivingBase entity, double p_70825_1_, double p_70825_3_, double p_70825_5_) {
        int k;
        int j;
        EnderTeleportEvent event = new EnderTeleportEvent(entity, p_70825_1_, p_70825_3_, p_70825_5_, 0.0f);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return false;
        }
        double d3 = this.posX;
        double d4 = this.posY;
        double d5 = this.posZ;
        entity.posX = event.targetX;
        entity.posY = event.targetY;
        entity.posZ = event.targetZ;
        boolean flag = false;
        int i = MathHelper.floor_double((double)entity.posX);
        if (this.worldObj.blockExists(i, j = MathHelper.floor_double((double)entity.posY), k = MathHelper.floor_double((double)entity.posZ))) {
            boolean flag1 = false;
            while (!flag1 && j > 0) {
                Block block = this.worldObj.getBlock(i, j - 1, k);
                if (block.getMaterial().isSolid()) {
                    flag1 = true;
                    continue;
                }
                entity.posY -= 1.0;
                --j;
            }
            if (flag1) {
                entity.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, this.rotationYaw, this.rotationPitch);
                if (this.worldObj.getCollidingBoundingBoxes((Entity)entity, entity.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(entity.boundingBox)) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            entity.setLocationAndAngles(d3, d4, d5, this.rotationYaw, this.rotationPitch);
            return false;
        }
        return true;
    }

    public void retractMinionNumFromType(EnumMinionType minionType) {
        if (minionType == EnumMinionType.SPECIAL) {
            --this.numSpecialMinions;
        } else if (minionType == EnumMinionType.PRIEST) {
            --this.numPriests;
        } else if (minionType == EnumMinionType.ZEALOT) {
            --this.numZealots;
        } else if (minionType == EnumMinionType.BISHOP) {
            --this.numBishop;
        } else if (minionType == EnumMinionType.TEMPLAR) {
            --this.numTemplar;
        } else if (minionType == EnumMinionType.LOYALIST) {
            --this.numMinions;
        }
    }
}

