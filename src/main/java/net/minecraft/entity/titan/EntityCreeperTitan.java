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
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.storage.WorldInfo
 *  net.minecraftforge.common.ForgeHooks
 */
package net.minecraft.entity.titan;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

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
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityLightningBall;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWebShot;
import net.minecraft.entity.titan.EntityWitherTurret;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.entity.titan.IEntityMultiPartTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAICreeperTitanSwell;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanAttack1;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanAttack2;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanAttack3;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanAttack4;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanCreation;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanDeath;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanSpit;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanStunned;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanThunderClap;
import net.minecraft.entity.titanminion.EntityCreeperMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
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
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.ForgeHooks;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityCreeperTitan
extends EntityTitan
implements IAnimatedEntity,
IEntityMultiPartTitan {
    public int damageToLegs;
    private int lastActiveTime;
    private int timeSinceIgnited;
    private int fuseTime = 200;
    private int field_175494_bm = 0;
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart body;
    public EntityTitanPart leg1;
    public EntityTitanPart leg2;
    public EntityTitanPart leg3;
    public EntityTitanPart leg4;

    public EntityCreeperTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0f, 8.0f);
        this.body = new EntityTitanPart(worldIn, this, "body", 7.0f, 12.0f);
        this.leg1 = new EntityTitanPart(worldIn, this, "leg1", 4.5f, 8.0f);
        this.leg2 = new EntityTitanPart(worldIn, this, "leg2", 4.5f, 8.0f);
        this.leg3 = new EntityTitanPart(worldIn, this, "leg3", 4.5f, 8.0f);
        this.leg4 = new EntityTitanPart(worldIn, this, "leg4", 4.5f, 8.0f);
        this.setTitanHealth(this.getMaxHealth());
        this.partArray = new EntityTitanPart[]{this.head, this.body, this.leg1, this.leg2, this.leg3, this.leg4};
        this.setSize(8.0f, 26.0f);
        this.experienceValue = 50000;
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        worldIn.spawnEntityInWorld((Entity)this.head);
        worldIn.spawnEntityInWorld((Entity)this.body);
        worldIn.spawnEntityInWorld((Entity)this.leg1);
        worldIn.spawnEntityInWorld((Entity)this.leg2);
        worldIn.spawnEntityInWorld((Entity)this.leg3);
        worldIn.spawnEntityInWorld((Entity)this.leg4);
    }

    @Override
    protected void applyEntityAI() {
        this.tasks.addTask(0, (EntityAIBase)new EntityAICreeperTitanSwell(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationCreeperTitanCreation(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationCreeperTitanDeath(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationCreeperTitanStunned(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationCreeperTitanThunderClap(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationCreeperTitanSpit(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationCreeperTitanAttack4(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationCreeperTitanAntiTitanAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationCreeperTitanAttack2(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationCreeperTitanAttack1(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationCreeperTitanAttack3(this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.CreeperTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != ((Object)((Object)this.head)).getClass() && p_70686_1_ != ((Object)((Object)this.body)).getClass() && p_70686_1_ != ((Object)((Object)this.leg1)).getClass() && p_70686_1_ != ((Object)((Object)this.leg2)).getClass() && p_70686_1_ != ((Object)((Object)this.leg3)).getClass() && p_70686_1_ != ((Object)((Object)this.leg4)).getClass() && p_70686_1_ != EntityCreeperMinion.class && p_70686_1_ != EntityCreeperTitan.class;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(250) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.CreeperTitanMinionSpawnrate;
    }

    @Override
    public int getMinionCap() {
        return 120;
    }

    @Override
    public int getPriestCap() {
        return 60;
    }

    @Override
    public int getZealotCap() {
        return 30;
    }

    @Override
    public int getBishopCap() {
        return 15;
    }

    @Override
    public int getTemplarCap() {
        return 8;
    }

    @Override
    public int getParticleCount() {
        if (this.getPowered()) {
            return 28;
        }
        return super.getParticleCount();
    }

    @Override
    public boolean canBeHurtByPlayer() {
        return this.isStunned && !this.isEntityInvulnerable();
    }

    public float getEyeHeight() {
        return 23.6f;
    }

    @Override
    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.AVERAGE;
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
            this.playSound("thetitans:groundSmash", 20.0f, 1.0f);
            this.playSound("thetitans:titanland", 10000.0f, 1.0f);
            this.playSound("thetitans:titanStrike", 10.0f, 1.0f);
            this.playSound("thetitans:titanSlam", 10.0f, 1.0f);
            this.destroyBlocksInAABBTopless(this.boundingBox.expand(24.0, 1.0, 24.0));
            this.collideWithEntities(this.body, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(24.0, 4.0, 24.0)));
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
                    if (this.worldObj.isRemote || !this.isEntityAlive() || this.isStunned) continue;
                    this.collideWithEntities(this.body, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(16.0, 1.0, 16.0)));
                }
            }
        }
        if (this.getCreeperState() > 0) {
            this.timeSinceIgnited += 20;
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)Byte.valueOf((byte)-1));
        this.dataWatcher.addObject(17, (Object)Byte.valueOf((byte)0));
        this.dataWatcher.addObject(18, (Object)Byte.valueOf((byte)0));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        if (this.dataWatcher.getWatchableObjectByte(17) == 1) {
            tagCompound.setBoolean("Charged", true);
        }
        tagCompound.setInteger("DamageToLegs", this.damageToLegs);
        tagCompound.setShort("Fuse", (short)this.fuseTime);
        tagCompound.setBoolean("ignited", this.func_146078_ca());
        tagCompound.setBoolean("Stunned", this.isStunned);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.dataWatcher.updateObject(17, (Object)((byte)(tagCompund.getBoolean("Charged") ? 1 : 0)));
        if (tagCompund.hasKey("DamageToLegs", 99)) {
            this.damageToLegs = tagCompund.getInteger("DamageToLegs");
        }
        this.isStunned = tagCompund.getBoolean("Stunned");
        if (tagCompund.hasKey("Fuse", 99)) {
            this.fuseTime = tagCompund.getShort("Fuse");
        }
        if (tagCompund.getBoolean("ignited")) {
            this.func_146079_cb();
        }
    }

    @Override
    public double getSpeed() {
        return this.getPowered() ? 0.35 + (double)this.getExtraPower() * 0.001 : 0.3 + (double)this.getExtraPower() * 0.001;
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

    @Override
    public void attackChoosenEntity(Entity damagedEntity, float damage, int knockbackAmount) {
        super.attackChoosenEntity(damagedEntity, damage, knockbackAmount);
        if (this.getPowered() && damagedEntity instanceof EntityLivingBase && this.isEntityAlive()) {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, 0.8f + this.rand.nextFloat() * 0.2f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, 0.8f + this.rand.nextFloat() * 0.2f);
            this.worldObj.newExplosion((Entity)this, damagedEntity.posX, damagedEntity.posY + (double)damagedEntity.getEyeHeight(), damagedEntity.posZ, 6.0f, false, false);
            this.worldObj.newExplosion((Entity)this, this.posX, this.head.posY, this.posZ, 2.0f, false, false);
            damagedEntity.attackEntityFrom(DamageSourceExtra.lightningBolt, 49.0f);
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX, this.posY + (double)this.getEyeHeight(), this.posZ, 0.0f, 0.5f, 1.0f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, damagedEntity.posX, damagedEntity.posY, damagedEntity.posZ, 0.0f, 0.5f, 1.0f));
        }
    }

    @Override
    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && this.getAttackTarget() != null ? super.shouldMove() : false;
    }

    public void doLightningAttackToEntity(Entity p_70652_1_) {
        if (this.getPowered()) {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, 0.8f + this.rand.nextFloat() * 0.2f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, 0.8f + this.rand.nextFloat() * 0.2f);
            this.worldObj.newExplosion((Entity)this, p_70652_1_.posX, p_70652_1_.posY + (double)p_70652_1_.getEyeHeight(), p_70652_1_.posZ, 8.0f, false, false);
            this.worldObj.newExplosion((Entity)this, this.posX, this.head.posY + 4.0, this.posZ, 4.0f, false, false);
            p_70652_1_.attackEntityFrom(DamageSourceExtra.lightningBolt, 49.0f);
            float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue() / 3.0f;
            int i = this.getKnockbackAmount();
            if (p_70652_1_ != this) {
                this.attackChoosenEntity(p_70652_1_, f, i);
            }
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX, this.head.posY + 4.0, this.posZ, 0.0f, 0.5f, 1.0f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, p_70652_1_.posX, p_70652_1_.posY, p_70652_1_.posZ, 0.0f, 0.5f, 1.0f));
        } else if (!this.getPowered()) {
            this.worldObj.newExplosion((Entity)this, p_70652_1_.posX, p_70652_1_.posY + (double)p_70652_1_.getEyeHeight(), p_70652_1_.posZ, 4.0f, false, false);
            this.worldObj.newExplosion((Entity)this, this.posX, this.head.posY + 4.0, this.posZ, 2.0f, false, false);
            p_70652_1_.attackEntityFrom(DamageSourceExtra.lightningBolt, 49.0f);
            float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue() / 3.0f;
            int i = this.getKnockbackAmount();
            if (p_70652_1_ != this) {
                this.attackChoosenEntity(p_70652_1_, f, i);
            }
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX, this.head.posY + 4.0, this.posZ, 0.0f, 0.5f, 0.25f));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, p_70652_1_.posX, p_70652_1_.posY, p_70652_1_.posZ, 0.0f, 0.5f, 0.25f));
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        return false;
    }

    @Override
    public double getMeleeRange() {
        return (double)(this.width * this.width + (this.getAttackTarget().width > 48.0f ? 2304.0f : this.getAttackTarget().width * this.getAttackTarget().width)) + 600.0;
    }

    @Override
    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        int in;
        List list;
        float f2;
        float f1;
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
                float f = (this.rand.nextFloat() - 0.5f) * 10.0f;
                f1 = (this.rand.nextFloat() - 0.5f) * 1.0f;
                f2 = (this.rand.nextFloat() - 0.5f) * 10.0f;
                this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 5.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            }
        }
        if (this.getWaiting()) {
            AnimationAPI.sendAnimPacket(this, 0);
            AnimationAPI.sendAnimPacket(this, 13);
            this.setAnimTick(0);
            EntityPlayer player = this.worldObj.getClosestPlayerToEntity((Entity)this, 24.0);
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
                this.playSound("thetitans:titanBirth", 1000.0f, 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 10) {
                this.playSound("thetitans:titanCreeperAwaken", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 130) {
                this.playSound("thetitans:titanRumble", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 160) {
                this.playSound("thetitans:titanCreeperBeginMove", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && (this.getAnimTick() == 260 || this.getAnimTick() == 261 || this.getAnimTick() == 390 || this.getAnimTick() == 410)) {
                this.func_145780_a(0, 0, 0, Blocks.stone);
                this.playSound("thetitans:titanPress", this.getSoundVolume(), 1.0f);
            }
        }
        if (this.isStunned) {
            this.setAttackTarget(null);
            AnimationAPI.sendAnimPacket(this, 8);
        }
        if (this.animID == 10) {
            if (this.animTick == 50 || this.animTick == 70 || this.animTick == 100) {
                this.func_145780_a(0, 0, 0, Blocks.stone);
            }
            if (this.animTick == 120) {
                this.shakeNearbyPlayerCameras(10000.0);
                this.playSound("thetitans:titanFall", 20.0f, 1.0f);
                this.playSound("thetitans:groundSmash", 20.0f, 1.0f);
            }
            if (this.animTick == 160) {
                this.shakeNearbyPlayerCameras(10000.0);
                this.playSound("thetitans:titanFall", 20.0f, 1.0f);
            }
        }
        if (this.animID == 8) {
            if (this.animTick == 120) {
                this.shakeNearbyPlayerCameras(10000.0);
                this.playSound("thetitans:groundSmash", 8.0f, 0.9f);
                this.playSound("thetitans:titanFall", 10.0f, 1.0f);
            }
            if (this.animTick == 20) {
                this.playSound("thetitans:titanCreeperStun", this.getSoundVolume(), this.getSoundPitch());
            }
            this.isStunned = this.animTick <= 500;
            this.setAttackTarget(null);
        }
        if (this.getPowered() && !this.isStunned) {
            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
            WorldInfo worldinfo = worldserver.getWorldInfo();
            worldinfo.setRainTime(9999999);
            worldinfo.setThunderTime(1000000);
            worldinfo.setRaining(true);
            worldinfo.setThundering(true);
            if (this.rand.nextInt(20) == 0) {
                EntityGammaLightning entitylightning = new EntityGammaLightning(this.worldObj, this.posX, this.head.posY + 4.0, this.posZ, 0.0f, 0.5f, 1.0f);
                this.worldObj.addWeatherEffect((Entity)entitylightning);
            }
            if (this.rand.nextInt(40) == 0) {
                for (int l = 0; l < 50; ++l) {
                    int i = MathHelper.floor_double((double)this.posX);
                    int j = MathHelper.floor_double((double)this.posY);
                    int k = MathHelper.floor_double((double)this.posZ);
                    int i1 = i + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)10, (int)100) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int j1 = j + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)10, (int)100) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    int k1 = k + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)10, (int)100) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                    EntityGammaLightning entitylightning = new EntityGammaLightning(this.worldObj, i1, j1, k1, 0.0f, 0.5f, 1.0f);
                    if (!World.doesBlockHaveSolidTopSurface((IBlockAccess)this.worldObj, (int)i1, (int)(j1 - 1), (int)k1) || !this.worldObj.checkNoEntityCollision(entitylightning.boundingBox) || !this.worldObj.getCollidingBoundingBoxes((Entity)entitylightning, entitylightning.boundingBox).isEmpty() || this.worldObj.isAnyLiquid(entitylightning.boundingBox)) continue;
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, i1, j1, k1, 0.0f, 0.5f, 1.0f));
                }
            }
        }
        if (this.ticksExisted > 5) {
            float f = this.renderYawOffset * (float)Math.PI / 180.0f;
            f1 = MathHelper.sin((float)f);
            f2 = MathHelper.cos((float)f);
            float offset = this.animID == 3 && this.animTick > 30 && this.animTick < 70 || this.animID == 7 && this.animTick > 30 && this.animTick < 130 ? 6.0f : 0.0f;
            this.head.setLocationAndAngles(this.posX, this.posY + (this.animID == 8 ? 12.0 : 18.0), this.posZ, 0.0f, 0.0f);
            this.body.setLocationAndAngles(this.posX, this.posY + (this.animID == 8 ? 0.0 : 6.0), this.posZ, 0.0f, 0.0f);
            this.leg1.setLocationAndAngles(this.posX - (double)(f1 * 5.5f) + (double)(f2 * 5.5f), this.posY + (double)offset, this.posZ + (double)(f2 * 5.5f) + (double)(f1 * 5.5f), 0.0f, 0.0f);
            this.leg2.setLocationAndAngles(this.posX - (double)(f1 * 5.5f) - (double)(f2 * 5.5f), this.posY + (double)offset, this.posZ + (double)(f2 * 5.5f) - (double)(f1 * 5.5f), 0.0f, 0.0f);
            this.leg3.setLocationAndAngles(this.posX + (double)(f1 * 5.5f) + (double)(f2 * 5.5f), this.posY, this.posZ - (double)(f2 * 5.5f) + (double)(f1 * 5.5f), 0.0f, 0.0f);
            this.leg4.setLocationAndAngles(this.posX + (double)(f1 * 5.5f) - (double)(f2 * 5.5f), this.posY, this.posZ - (double)(f2 * 5.5f) - (double)(f1 * 5.5f), 0.0f, 0.0f);
            if (this.isEntityAlive() && !this.isStunned) {
                this.collideWithEntities(this.head, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.head.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.body, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.body.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.leg1, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leg1.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.leg2, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leg2.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.leg3, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leg3.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.leg4, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leg4.boundingBox.expand(1.0, 0.0, 1.0)));
            }
            this.destroyBlocksInAABB(this.head.boundingBox);
            this.destroyBlocksInAABB(this.body.boundingBox);
            this.destroyBlocksInAABB(this.leg1.boundingBox);
            this.destroyBlocksInAABB(this.leg2.boundingBox);
            this.destroyBlocksInAABB(this.leg3.boundingBox);
            this.destroyBlocksInAABB(this.leg4.boundingBox);
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
        this.meleeTitan = true;
        if (this.isStunned || this.deathTicks > 0) {
            this.motionX *= 0.0;
            this.motionZ *= 0.0;
        }
        if (!AnimationAPI.isEffectiveClient() && this.getAttackTarget() != null && !this.isStunned && this.getAnimID() == 0) {
            double d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
            if (d0 < this.getMeleeRange()) {
                if (this.getAttackTarget() instanceof EntityTitan || this.getAttackTarget().height >= 6.0f || this.getAttackTarget().posY > this.posY + 6.0) {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                } else {
                    switch (this.rand.nextInt(4)) {
                        case 0: {
                            AnimationAPI.sendAnimPacket(this, 3);
                            this.setAnimID(3);
                            break;
                        }
                        case 1: {
                            AnimationAPI.sendAnimPacket(this, 2);
                            this.setAnimID(2);
                            break;
                        }
                        case 2: {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                            break;
                        }
                        case 3: {
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                        }
                    }
                }
            } else if (this.getAnimID() == 0 && this.getRNG().nextInt(100) == 0) {
                switch (this.rand.nextInt(2)) {
                    case 0: {
                        AnimationAPI.sendAnimPacket(this, 7);
                        this.setAnimID(7);
                        break;
                    }
                    case 1: {
                        AnimationAPI.sendAnimPacket(this, 6);
                        this.setAnimID(6);
                    }
                }
            }
        }
        if (this.animID == 1 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.getRNG().nextInt(4);
        }
        if (this.getAnimID() == 6 && this.getAnimTick() <= 50 && this.getAnimTick() >= 20 && this.getAttackTarget() != null) {
            int it = this.getPowered() ? 50 + this.rand.nextInt(50) : 10 + this.rand.nextInt(10);
            block27: for (int i = 0; i < it; ++i) {
                switch (this.rand.nextInt(3)) {
                    case 0: {
                        Vec3 vec3 = this.getLook(1.0f);
                        double d5 = this.getAttackTarget().posX + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f) - this.head.posX + vec3.xCoord * 6.0;
                        double d6 = this.getAttackTarget().posY - 16.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f) - this.head.posY + 1.0;
                        double d7 = this.getAttackTarget().posZ + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f) - this.head.posZ + vec3.zCoord * 6.0;
                        EntityTitanFireball entitylargefireball = new EntityTitanFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7, 1);
                        entitylargefireball.posX = this.head.posX + vec3.xCoord * 6.0;
                        entitylargefireball.posY = this.head.posY + 1.0;
                        entitylargefireball.posZ = this.head.posZ + vec3.zCoord * 6.0;
                        this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
                        entitylargefireball.setFireballID(1);
                        this.playSound("thetitans:titanGhastFireball", 100.0f, 1.25f);
                        continue block27;
                    }
                    case 1: {
                        if (this.worldObj.isRemote) continue block27;
                        EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(this.worldObj, this.getAttackTarget().posX + 0.5 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 32.0f), this.getAttackTarget().posY + 32.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 32.0f), this.getAttackTarget().posZ + 0.5 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 32.0f), (EntityLivingBase)this);
                        this.worldObj.spawnEntityInWorld((Entity)entitytntprimed);
                        this.playSound("game.tnt.primed", 1.0f, 1.0f);
                        entitytntprimed.fuse = 100 + this.rand.nextInt(60);
                    }
                }
            }
        }
        if ((list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0))) != null && !list.isEmpty() && this.ticksExisted % 20 == 0) {
            for (int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity = (Entity)list.get(i1);
                if (entity == null || !this.getPowered() || !(entity instanceof EntityCreeperMinion)) continue;
                if (!((EntityCreeperMinion)entity).getPowered()) {
                    this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, entity.posX, entity.posY + (double)entity.height, entity.posZ));
                    continue;
                }
                ((EntityCreeperMinion)entity).heal(5.0f);
            }
        }
        if (this.getAttackTarget() != null && this.getAttackTarget() instanceof EntityPlayer && ((EntityPlayer)this.getAttackTarget()).getCommandSenderName() == "Boom337317") {
            this.setAttackTarget(null);
        }
        if (this.getPowered()) {
            switch (this.rand.nextInt(5)) {
                case 0: {
                    this.setCustomNameTag("\u00a72Charged Creeper Titan");
                    break;
                }
                case 1: {
                    this.setCustomNameTag("\u00a74Charged Creeper Titan");
                    break;
                }
                case 2: {
                    this.setCustomNameTag("\u00a76Charged Creeper Titan");
                    break;
                }
                case 3: {
                    this.setCustomNameTag("\u00a7aCharged Creeper Titan");
                    break;
                }
                case 4: {
                    this.setCustomNameTag("\u00a7eCharged Creeper Titan");
                }
            }
        } else {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.CreeperTitan.name"));
        }
        if (this.getAttackTarget() != null && this.onGround && !this.isStunned && this.getDistanceSqToEntity((Entity)this.getAttackTarget()) > 300.0 && this.animID == 0 && this.rand.nextInt(in = this.getPowered() ? 50 : 300) == 0) {
            this.jump();
            this.playSound(this.getHurtSound(), this.getSoundVolume(), this.getSoundPitch());
        }
        if (this.getAttackTarget() != null && this.onGround && !this.isStunned && this.animID == 0 && this.rand.nextInt(in = this.getPowered() ? 50 : 600) == 0) {
            if (this.rand.nextInt(4) == 0) {
                this.jump();
                double d01 = this.getAttackTarget().posX - this.posX;
                double d11 = this.getAttackTarget().posZ - this.posZ;
                float f21 = MathHelper.sqrt_double((double)(d01 * d01 + d11 * d11));
                double hor = f21 / 16.0f;
                double ver = 2.0;
                this.motionX = d01 / (double)f21 * hor * hor + this.motionX * hor;
                this.motionZ = d11 / (double)f21 * hor * hor + this.motionZ * hor;
                this.motionY = ver;
            } else {
                this.jumpAtEntity(this.getAttackTarget());
            }
        }
        if (this.getAttackTarget() != null && !(this.getAttackTarget() instanceof EntityTitan) && (this.rand.nextInt(30) == 0 && this.getPowered() || this.rand.nextInt(150) == 0 && !this.getPowered()) && !this.isStunned) {
            this.doLightningAttackToEntity((Entity)this);
            this.doLightningAttackToEntity((Entity)this.getAttackTarget());
        }
        if (!this.getWaiting() && this.animID != 13 && !(this.worldObj.provider instanceof WorldProviderVoid)) {
            if (this.numMinions < this.getMinionCap() && (this.rand.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntityCreeperMinion entitychicken = new EntityCreeperMinion(this.worldObj);
                this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                entitychicken.master = this;
                entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                entitychicken.addVelocity(0.0, 0.9, 0.0);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(0);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                ++this.numMinions;
                entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                if (block == Blocks.grass) {
                    this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                }
                if (this.rand.nextInt(100) == 0 || this.getPowered()) {
                    entitychicken.getDataWatcher().updateObject(17, (Object)Byte.valueOf((byte)1));
                }
            }
            if (this.numPriests < this.getPriestCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntityCreeperMinion entitychicken = new EntityCreeperMinion(this.worldObj);
                this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                entitychicken.master = this;
                entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                entitychicken.addVelocity(0.0, 0.9, 0.0);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(1);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                ++this.numPriests;
                entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                if (block == Blocks.grass) {
                    this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                }
                if (this.rand.nextInt(100) == 0 || this.getPowered()) {
                    entitychicken.getDataWatcher().updateObject(17, (Object)Byte.valueOf((byte)1));
                }
            }
            if (this.numZealots < this.getZealotCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntityCreeperMinion entitychicken = new EntityCreeperMinion(this.worldObj);
                this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                entitychicken.master = this;
                entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                entitychicken.addVelocity(0.0, 0.9, 0.0);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(2);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                ++this.numZealots;
                entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                if (block == Blocks.grass) {
                    this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                }
                if (this.rand.nextInt(100) == 0 || this.getPowered()) {
                    entitychicken.getDataWatcher().updateObject(17, (Object)Byte.valueOf((byte)1));
                }
            }
            if (this.numBishop < this.getBishopCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntityCreeperMinion entitychicken = new EntityCreeperMinion(this.worldObj);
                this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                entitychicken.master = this;
                entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                entitychicken.addVelocity(0.0, 0.9, 0.0);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(3);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                ++this.numBishop;
                entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                if (block == Blocks.grass) {
                    this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                }
                if (this.rand.nextInt(100) == 0 || this.getPowered()) {
                    entitychicken.getDataWatcher().updateObject(17, (Object)Byte.valueOf((byte)1));
                }
            }
            if (this.numTemplar < this.getTemplarCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntityCreeperMinion entitychicken = new EntityCreeperMinion(this.worldObj);
                this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                entitychicken.master = this;
                entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                entitychicken.addVelocity(0.0, 0.9, 0.0);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(4);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                ++this.numTemplar;
                entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                if (block == Blocks.grass) {
                    this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                }
                if (this.rand.nextInt(100) == 0 || this.getPowered()) {
                    entitychicken.getDataWatcher().updateObject(17, (Object)Byte.valueOf((byte)1));
                }
            }
        }
        if (TheTitans.NightmareMode) {
            if (this.getPowered()) {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1620.0 + (double)(this.getExtraPower() * 270));
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(540.0 + (double)(this.getExtraPower() * 90));
            }
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50000.0 + (double)(this.getExtraPower() * 2500));
        } else {
            if (this.getPowered()) {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(540.0 + (double)(this.getExtraPower() * 90));
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(180.0 + (double)(this.getExtraPower() * 30));
            }
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25000.0 + (double)(this.getExtraPower() * 1250));
        }
        super.onLivingUpdate();
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    protected String getLivingSound() {
        return this.isStunned || this.getWaiting() || this.animID == 13 ? null : "thetitans:titanCreeperLiving";
    }

    @Override
    protected String getHurtSound() {
        return "thetitans:titanCreeperGrunt";
    }

    @Override
    protected String getDeathSound() {
        return "thetitans:titanCreeperDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.playSound("thetitans:titanStep", 10.0f, 1.1f);
        this.playSound("thetitans:titanStep", 10.0f, 1.1f);
        this.shakeNearbyPlayerCameras(4000.0);
        this.shakeNearbyPlayerCameras(4000.0);
        if (!this.getWaiting() && this.animID != 13) {
            if (this.footID == 0) {
                this.destroyBlocksInAABB(this.leg1.boundingBox.offset(0.0, -1.0, 0.0));
                this.destroyBlocksInAABB(this.leg4.boundingBox.offset(0.0, -1.0, 0.0));
                ++this.footID;
            } else {
                this.destroyBlocksInAABB(this.leg2.boundingBox.offset(0.0, -1.0, 0.0));
                this.destroyBlocksInAABB(this.leg3.boundingBox.offset(0.0, -1.0, 0.0));
                this.footID = 0;
            }
        }
    }

    @Override
    public StatBase getAchievement() {
        return TitansAchievments.creepertitan;
    }

    public void setPowered(boolean powered) {
        this.dataWatcher.updateObject(17, (Object)Byte.valueOf((byte)(powered ? 1 : 0)));
    }

    public boolean getPowered() {
        return this.dataWatcher.getWatchableObjectByte(17) == 1;
    }

    @SideOnly(value=Side.CLIENT)
    public float getCreeperFlashIntensity(float p_70831_1_) {
        return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * p_70831_1_) / (float)(this.fuseTime - 2);
    }

    protected Item getDropItem() {
        return Items.gunpowder;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            EntityItem entityitem;
            int l;
            for (int x = 0; x < (this.getPowered() ? 60 : 16); ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.motionY += 1.0;
                entitylargefireball.setXPCount(16000);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            for (l = 0; l < 256 + this.rand.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.gunpowder));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 64 + this.rand.nextInt(64 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.tnt));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 32 + this.rand.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.coal));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 32 + this.rand.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                int t = Item.getIdFromItem((Item)Items.record_13);
                int v = Item.getIdFromItem((Item)Items.record_wait);
                int q = t + this.rand.nextInt(v - t + 1);
                EntityItem entityitem2 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Item.getItemById((int)q)));
                entityitem2.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem2);
            }
            for (l = 0; l < 8 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                EntityItem entityitem3 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.emerald));
                entityitem3.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem3);
            }
            for (l = 0; l < 8 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                EntityItem entityitem4 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.diamond));
                entityitem4.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem4);
            }
            for (l = 0; l < 0 + this.rand.nextInt(4 + p_70628_2_); ++l) {
                EntityItem entityitem5 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanItems.harcadium));
                entityitem5.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem5);
            }
            if (this.rand.nextInt(10) == 0) {
                EntityItem entityitem6 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.bedrock));
                entityitem6.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem6);
            }
        }
    }

    public int getCreeperState() {
        return this.dataWatcher.getWatchableObjectByte(16);
    }

    public void setCreeperState(int p_70829_1_) {
        this.dataWatcher.updateObject(16, (Object)Byte.valueOf((byte)p_70829_1_));
    }

    public void onStruckByLightning(EntityLightningBolt lightningBolt) {
        if (this.rand.nextInt(1000) == 0) {
            this.setPowered(true);
        }
    }

    @Override
    public int getThreashHold() {
        return this.fuseTime;
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_180482_2_) {
        IEntityLivingData p_180482_2_1 = super.onSpawnWithEgg(p_180482_2_);
        this.setWaiting(true);
        return p_180482_2_1;
    }

    private void explode() {
        for (int i = 0; i < 1000; ++i) {
            float f = (this.rand.nextFloat() - 0.5f) * 16.0f;
            float f1 = (this.rand.nextFloat() - 0.5f) * 48.0f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 16.0f;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + (double)f1, this.posZ + (double)f2, this.rand.nextDouble() - 0.5, 0.0, this.rand.nextDouble() - 0.5);
        }
        this.playSound("thetitans:titanCreeperExplosion", Float.MAX_VALUE, 1.0f);
        this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
        boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
        double d1 = this.getPowered() ? 256.0 : 128.0;
        double d2 = this.getPowered() ? 2048.0 : 1024.0;
        this.destroyBlocksInAABBGriefingBypass(this.boundingBox.expand(d1, d1, d1));
        this.worldObj.createExplosion((Entity)this, this.posX, this.posY + 24.0, this.posZ, 12.0f, flag);
        this.worldObj.createExplosion((Entity)this, this.posX, this.posY + 18.0, this.posZ, 12.0f, flag);
        this.worldObj.createExplosion((Entity)this, this.posX, this.posY + 12.0, this.posZ, 12.0f, flag);
        this.worldObj.createExplosion((Entity)this, this.posX, this.posY + 6.0, this.posZ, 12.0f, flag);
        this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 12.0f, flag);
        this.playSound("thetitans:titanland", 10000.0f, 1.0f);
        for (int da = 0; da <= 250; ++da) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(d1, d1, d1));
            if (list == null || list.isEmpty()) continue;
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (entity == null || !(entity instanceof EntityLivingBase)) continue;
                this.attackChoosenEntity(entity, this.getPowered() ? 400.0f : 200.0f, 0);
                entity.attackEntityFrom(DamageSourceExtra.causeCreeperTitanExplosionDamage((Entity)this), this.getPowered() ? 400.0f : 200.0f);
                entity.hurtResistantTime = 0;
                if (!(entity instanceof EntityCreeperTitan)) continue;
                ((EntityCreeperTitan)entity).heal(this.getPowered() ? 400.0f : 200.0f);
                ((EntityCreeperTitan)entity).setPowered(true);
            }
        }
        List list111 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(d2, d2, d2));
        if (list111 != null && !list111.isEmpty()) {
            for (int i = 0; i < list111.size(); ++i) {
                Entity entity = (Entity)list111.get(i);
                if (!(entity instanceof EntityLivingBase)) continue;
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(ClientProxy.creeperTitanRadiation.id, 30000, 1));
            }
        }
    }

    public boolean func_146078_ca() {
        return this.dataWatcher.getWatchableObjectByte(18) != 0;
    }

    public void func_146079_cb() {
        this.dataWatcher.updateObject(18, (Object)Byte.valueOf((byte)1));
    }

    public void func_175493_co() {
        ++this.field_175494_bm;
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
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.getPowered()) {
            amount /= 3.0f;
        }
        if (source.getEntity() instanceof EntityPlayer && !this.worldObj.isRemote) {
            this.setAttackTarget((EntityLivingBase)source.getEntity());
            this.setRevengeTarget((EntityLivingBase)source.getEntity());
        }
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source.getDamageType() == "lightningBolt" || source.getDamageType() == "explosion" || source.getEntity() instanceof EntityCreeperMinion || source.getEntity() instanceof EntityCreeperTitan || source.isExplosion() && !(source.getEntity() instanceof EntityWitherTurret)) {
            this.heal(amount);
            return false;
        }
        if (!this.isStunned && source.getEntity() instanceof EntityPlayer) {
            return false;
        }
        this.recentlyHit = 200;
        Entity entity = source.getEntity();
        if (entity instanceof EntityLivingBase && !this.isEntityInvulnerable() && amount > 25.0f) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1 instanceof EntityCreeperTitan) {
                    EntityCreeperTitan entitypigzombie = (EntityCreeperTitan)entity1;
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
    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        this.func_82195_e(source, amount);
        if (source == DamageSourceExtra.lightningBolt || source.getEntity() instanceof EntityCreeperMinion || source.getEntity() instanceof EntityCreeperTitan || source.isExplosion() && !(source.getEntity() instanceof EntityWitherTurret)) {
            this.heal(amount);
            return false;
        }
        if (source.getEntity() != null && source.getEntity() instanceof EntityPlayer && source.canHarmInCreative() && this.damageToLegs < 8 && !this.isStunned && (p_70965_1_ == this.leg1 || p_70965_1_ == this.leg2 || p_70965_1_ == this.leg3 || p_70965_1_ == this.leg4)) {
            ++this.damageToLegs;
            this.attackEntityFrom(new DamageSource("other").setDamageBypassesArmor().setDamageIsAbsolute(), 100.0f);
            this.setAttackTarget((EntityLivingBase)source.getEntity());
            this.setRevengeTarget((EntityLivingBase)source.getEntity());
            if (this.damageToLegs >= 8) {
                this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
                this.isStunned = true;
                this.damageToLegs = 0;
            }
        }
        return true;
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return this.attackEntityFrom(p_82195_1_, p_82195_2_);
    }

    public World func_82194_d() {
        return this.worldObj;
    }

    @Override
    protected void inactDeathAction() {
        if (!this.worldObj.isRemote) {
            this.explode();
            this.playSound("mob.creeper.death", this.getSoundVolume(), this.getSoundPitch());
            if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(true, 0);
                this.dropEquipment(true, 0);
                this.dropRareDrop(1);
            }
            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
            entitytitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(7);
        }
    }

    @Override
    protected void onTitanDeathUpdate() {
        if (this.timeSinceIgnited >= this.getThreashHold()) {
            this.deathTicks = 200;
            this.setDead();
        } else {
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
            if (this.deathTicks < 300) {
                this.timeSinceIgnited = 0;
            }
            if (this.deathTicks >= 300) {
                if (this.timeSinceIgnited == 1) {
                    this.playSound("thetitans:titanCreeperWarning", Float.MAX_VALUE, 1.0f);
                }
                ++this.timeSinceIgnited;
                --this.animTick;
                this.setCreeperState(1);
                float f = (this.rand.nextFloat() - 0.5f) * 16.0f;
                float f1 = (this.rand.nextFloat() - 0.5f) * 12.0f;
                float f2 = (this.rand.nextFloat() - 0.5f) * 16.0f;
                this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            }
            if (this.timeSinceIgnited >= this.getThreashHold()) {
                this.deathTicks = 200;
                this.setDead();
            }
        }
    }
}

