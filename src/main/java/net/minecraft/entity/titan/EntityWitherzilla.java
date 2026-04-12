/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.mojang.authlib.GameProfile
 *  cpw.mods.fml.common.eventhandler.Event
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockEndPortal
 *  net.minecraft.client.particle.EntityFX
 *  net.minecraft.command.IEntitySelector
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.effect.EntityWeatherEffect
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.entity.passive.EntityWaterMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.management.UserListBansEntry
 *  net.minecraft.server.management.UserListEntry
 *  net.minecraft.stats.AchievementList
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProviderEnd
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.storage.WorldInfo
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.EnderTeleportEvent
 */
package net.minecraft.entity.titan;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;
import net.minecraft.theTitans.util.TitanOptimizationHelper;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWitherTurret;
import net.minecraft.entity.titan.EntityWitherTurretGround;
import net.minecraft.entity.titan.EntityWitherTurretMortar;
import net.minecraft.entity.titan.EntityWitherzillaMinion;
import net.minecraft.entity.titan.EntityWitherzillaSkull;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.UserListBansEntry;
import net.minecraft.server.management.UserListEntry;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanBlocks;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityWitherzilla
extends EntityTitan
implements IRangedAttackMob {
    private float[] field_82220_d = new float[2];
    private float[] field_82221_e = new float[2];
    private float[] field_82217_f = new float[2];
    private float[] field_82218_g = new float[2];
    private int[] field_82223_h = new int[2];
    private int[] field_82224_i = new int[2];
    private int blockBreakCounter;
    public int affectTicks;
    private int attackTimer;
    private int omegacounter;
    ArrayList allPlayerList;
    private static final IEntitySelector attackEntitySelector = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_180027_1_) {
            return !(p_180027_1_ instanceof EntityTitanSpirit) && !(p_180027_1_ instanceof EntityWitherzillaMinion) && !(p_180027_1_ instanceof EntityWitherTurret) && !(p_180027_1_ instanceof EntityWitherTurretGround) && !(p_180027_1_ instanceof EntityWitherTurretMortar);
        }
    };

    public EntityWitherzilla(World worldIn) {
        super(worldIn);
        this.allPlayerList = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
        this.setSize(64.0f, 224.0f);
        this.noClip = true;
        this.experienceValue = 5000000;
        this.playSound("thetitans:witherzillaSpawn", Float.MAX_VALUE, 1.0f);
    }

    @Override
    protected void applyEntityAI() {
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, attackEntitySelector));
    }

    @Override
    public int getMinionCap() {
        return 1000;
    }

    @Override
    public boolean alreadyHasAName() {
        return true;
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    protected void fall(float p_70069_1_) {
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.WitherzillaMinionSpawnrate;
    }

    @Override
    public int getParticleCount() {
        return 100;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Double.MAX_VALUE);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
    }

    @Override
    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.GOD;
    }

    @Override
    public float getRenderSizeModifier() {
        return this.isInOmegaForm() ? 128.0f : 64.0f;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(17, (Object)new Integer(0));
        this.dataWatcher.addObject(18, (Object)new Integer(0));
        this.dataWatcher.addObject(19, (Object)new Integer(0));
    }

    public int getTalkInterval2() {
        return 20;
    }

    public void onEntityUpdate() {
        super.onEntityUpdate();
        this.worldObj.theProfiler.startSection("zillaBaseTick");
        if (this.isArmored() && this.isEntityAlive() && this.rand.nextInt(50) < this.livingSoundTime++) {
            this.livingSoundTime = -30;
            this.playLivingSound2();
        }
        this.worldObj.theProfiler.endSection();
    }

    public void playLivingSound2() {
        String s = this.getLivingSound();
        if (s != null) {
            this.playSound(s, this.getSoundVolume(), 0.9f);
        }
    }

    protected String getLivingSound2() {
        return "thetitans:witherzillaLiving2";
    }

    protected String getLivingSound() {
        return "thetitans:witherzillaLiving";
    }

    @Override
    protected String getHurtSound() {
        return "thetitans:witherzillaGrunt";
    }

    @Override
    protected String getDeathSound() {
        return "thetitans:witherzillaDeath";
    }

    @Override
    public boolean getCanSpawnHere() {
        return false;
    }

    @Override
    public boolean canBeHurtByPlayer() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && !this.isEntityInvulnerable();
    }

    protected void kill() {
        this.worldObj.playBroadcastSound(1013, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        if (this.worldObj.provider instanceof WorldProviderVoid || this.worldObj.provider instanceof WorldProviderEnd) {
            this.teleportRandomly(true);
        } else {
            this.teleportRandomly(false);
        }
    }

    public void doLightningAttackTo(Entity entity) {
        if (entity != null && entity.isEntityAlive() && !(entity instanceof EntityFX) && !(entity instanceof EntityTitanPart)) {
            if (entity instanceof EntityPlayer) {
                ((EntityPlayer)entity).addChatMessage((IChatComponent)new ChatComponentText("\u00a7k" + this.rand.nextInt(1234567890)));
            }
            if (entity instanceof EntityLivingBase && !(entity instanceof EntityTitan) && (entity.height >= 6.0f || entity.isEntityInvulnerable() || entity instanceof EntityEnderColossusCrystal)) {
                ((EntityLivingBase)entity).onDeath(DamageSource.outOfWorld);
                ((EntityLivingBase)entity).setDead();
                ((EntityLivingBase)entity).setHealth(0.0f);
                ((EntityLivingBase)entity).attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
            }
            if (entity != null && entity instanceof EntityLivingBase && (this.affectTicks >= 600 || entity.height >= 6.0f) && !(entity instanceof EntityTitan)) {
                ((EntityLivingBase)entity).setHealth(0.0f);
                for (int i = 0; i < 50; ++i) {
                    this.attackChoosenEntity(entity, 2.14748365E9f, 0);
                }
            }
            if (entity instanceof EntityTitan) {
                ((EntityTitan)entity).setInvulTime(((EntityTitan)entity).getInvulTime() - 20);
            } else {
                entity.motionY += 0.5;
            }
            this.attackChoosenEntity(entity, 20.0f, 0);
            if (entity instanceof EntityMob) {
                ((EntityLivingBase)entity).setRevengeTarget((EntityLivingBase)this);
            }
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX, this.posY + (double)(this.rand.nextFloat() * this.getEyeHeight()), this.posZ, this.rand.nextFloat(), this.rand.nextFloat(), this.rand.nextFloat()));
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity.posX, entity.posY, entity.posZ, this.rand.nextFloat(), this.rand.nextFloat(), this.rand.nextFloat()));
            entity.hurtResistantTime = 1;
        }
    }

    @Override
    public void setAttackTarget(EntityLivingBase p_70624_1_) {
        if (this.worldObj.provider instanceof WorldProviderVoid && p_70624_1_ != null && this.posX == 0.0 && this.posY == 200.0 && this.posZ == 0.0) {
            p_70624_1_ = null;
        } else {
            super.setAttackTarget(p_70624_1_);
        }
    }

    @Override
    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        int j;
        int i;
        Entity entity;
        List list;
        ArrayList listp;
        if (!(this.worldObj.provider instanceof WorldProviderVoid) && (this.ticksExisted & 31) == 0) {
            long perfWeatherNs = TitansPerf.begin();
            try {
                WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
                WorldInfo worldinfo = worldserver.getWorldInfo();
                if (this.getAttackTarget() != null && this.getAttackTarget() instanceof EntityEnderColossus) {
                    worldinfo.setRainTime(0);
                    worldinfo.setThunderTime(0);
                    worldinfo.setRaining(false);
                    worldinfo.setThundering(false);
                } else {
                    worldinfo.setRainTime(9999999);
                    worldinfo.setThunderTime(1000000);
                    worldinfo.setRaining(true);
                    worldinfo.setThundering(true);
                }
            } finally {
                TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate.weather", perfWeatherNs);
            }
        }
        if (!(this.worldObj.provider instanceof WorldProviderVoid)) {
            if ((this.ticksExisted & 7) == 0 && this.rand.nextInt(3) == 0) {
                long perfLightningNs = TitansPerf.begin();
                int lightningSpawned = 0;
                try {
                    for (int l = 0; l < 4; ++l) {
                        int i2 = MathHelper.floor_double((double)this.posX);
                        int j2 = MathHelper.floor_double((double)this.posY);
                        int k = MathHelper.floor_double((double)this.posZ);
                        int i1 = i2 + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)10, (int)100) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                        int j1 = j2 + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)10, (int)100) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                        int k1 = k + MathHelper.getRandomIntegerInRange((Random)this.rand, (int)10, (int)100) * MathHelper.getRandomIntegerInRange((Random)this.rand, (int)-1, (int)1);
                        EntityGammaLightning entitylightning = new EntityGammaLightning(this.worldObj, i1, j1, k1, this.rand.nextFloat(), this.rand.nextFloat(), this.rand.nextFloat());
                        if (this.rand.nextInt(5) != 0 || !World.doesBlockHaveSolidTopSurface((IBlockAccess)this.worldObj, (int)i1, (int)(j1 - 1), (int)k1) || !this.worldObj.checkNoEntityCollision(entitylightning.boundingBox) || !this.worldObj.getCollidingBoundingBoxes((Entity)entitylightning, entitylightning.boundingBox).isEmpty() || this.worldObj.isAnyLiquid(entitylightning.boundingBox)) continue;
                        this.worldObj.addWeatherEffect((Entity)entitylightning);
                        ++lightningSpawned;
                    }
                } finally {
                    TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate.lightning", perfLightningNs);
                    TitansPerf.count(this.getClass().getSimpleName() + "#onLivingUpdate.lightningSpawned", lightningSpawned);
                }
            }
        } else {
            if (this.getDistanceSq(0.0, 200.0, 0.0) > 50000.0) {
                this.setPosition(0.0, 200.0, 0.0);
            }
            listp = Lists.newArrayList((Iterable)this.worldObj.loadedEntityList);
            if (!this.worldObj.isRemote && listp != null && !listp.isEmpty() && this.rand.nextInt(4) == 0) {
                long perfVoidLoopNs = TitansPerf.begin();
                int loadedSeen = listp.size();
                int voidResets = 0;
                try {
                    for (int i1 = 0; i1 < listp.size(); ++i1) {
                        Entity entity2 = (Entity)listp.get(i1);
                        if (entity2 == null || !entity2.isEntityAlive()) continue;
                        if (entity2 instanceof EntityWitherTurret && !((EntityWitherTurret)entity2).isPlayerCreated()) {
                            this.setPosition(0.0, 200.0, 0.0);
                            this.rotationYawHead = 0.0f;
                            this.rotationYaw = 0.0f;
                            this.renderYawOffset = 0.0f;
                            this.setAttackTarget(null);
                            ++voidResets;
                        }
                        if (entity2 instanceof EntityWitherTurretGround && !((EntityWitherTurretGround)entity2).isPlayerCreated()) {
                            this.setPosition(0.0, 200.0, 0.0);
                            this.rotationYawHead = 0.0f;
                            this.rotationYaw = 0.0f;
                            this.renderYawOffset = 0.0f;
                            this.setAttackTarget(null);
                            ++voidResets;
                        }
                        if (!(entity2 instanceof EntityWitherTurretMortar) || ((EntityWitherTurretMortar)entity2).isPlayerCreated()) continue;
                        this.setPosition(0.0, 200.0, 0.0);
                        this.rotationYawHead = 0.0f;
                        this.rotationYaw = 0.0f;
                        this.renderYawOffset = 0.0f;
                        this.setAttackTarget(null);
                        ++voidResets;
                    }
                } finally {
                    TitansPerf.endWarn(PerfSection.TARGET_SCAN, this.getClass().getSimpleName() + "#onLivingUpdate.voidLoadedEntityLoop", perfVoidLoopNs);
                    TitansPerf.count(this.getClass().getSimpleName() + "#onLivingUpdate.voidLoadedEntitiesSeen", loadedSeen);
                    TitansPerf.count(this.getClass().getSimpleName() + "#onLivingUpdate.voidResets", voidResets);
                }
            }
        }
        if (this.affectTicks >= 800) {
            this.setInvisible(true);
        } else {
            this.setInvisible(false);
        }
        --this.omegacounter;
        this.setSize(this.omegacounter > 0 ? 128.0f : 64.0f, this.omegacounter > 0 ? 448.0f : 224.0f);
        this.worldObj.setWorldTime(18000L);
        listp = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
        if (listp != null && !listp.isEmpty() && (this.ticksExisted % 40 == 0)) {
            long perfPlayerLoopNs = TitansPerf.begin();
            int playersSeen = listp.size();
            int playersAffected = 0;
            try {
                for (int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity3 = (Entity)listp.get(i1);
                    if (entity3 == null || !(entity3 instanceof EntityPlayer) || this.rand.nextInt(100) != 0) continue;
                    this.playLivingSound();
                    ++playersAffected;
                    if (!(this.worldObj.provider instanceof WorldProviderVoid)) {
                        ((EntityPlayer)entity3).attackEntityFrom(new DamageSource("generic").setDamageAllowedInCreativeMode().setDamageBypassesArmor().setDamageIsAbsolute(), 10.0f);
                        ((EntityPlayer)entity3).addChatMessage((IChatComponent)new ChatComponentText(StatCollector.translateToLocal((String)("dialog.witherzilla.taunt." + this.rand.nextInt(6)))));
                        continue;
                    }
                    ((EntityPlayer)entity3).addChatMessage((IChatComponent)new ChatComponentText(StatCollector.translateToLocal((String)("dialog.witherzilla.plead." + this.rand.nextInt(6)))));
                }
            } finally {
                TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate.playerLoop", perfPlayerLoopNs);
                TitansPerf.count(this.getClass().getSimpleName() + "#onLivingUpdate.playersSeen", playersSeen);
                TitansPerf.count(this.getClass().getSimpleName() + "#onLivingUpdate.playersAffected", playersAffected);
            }
        }
        if ((this.ticksExisted & 2) == 0 && (list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(96.0, 64.0, 96.0))) != null && !list.isEmpty() && !(this.worldObj.provider instanceof WorldProviderVoid)) {
            long perfNearbyNs = TitansPerf.begin();
            int nearbySeen = list.size();
            int minionSync = 0;
            int lightningTargets = 0;
            try {
                for (int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity4 = (Entity)list.get(i1);
                    if (entity4 != null && entity4.isEntityAlive() && this.getAttackTarget() != null && entity4 instanceof EntityWitherzillaMinion) {
                        ((EntityWitherzillaMinion)entity4).setAttackTarget(this.getAttackTarget());
                        ++minionSync;
                    }
                    if (entity4 == null || !entity4.isEntityAlive() || entity4 instanceof EntityWitherzillaMinion || entity4 instanceof EntityWitherSkull || entity4 instanceof EntityWitherTurret || entity4 instanceof EntityWitherTurretGround || entity4 instanceof EntityWitherTurretMortar || entity4 instanceof EntityWeatherEffect || entity4 instanceof EntityWitherzillaMinion || entity4 instanceof EntityTitan || entity4 instanceof EntityTitanSpirit || entity4 instanceof EntityPlayer) continue;
                    if (this.getInvulTime() > 1) {
                        if (entity4 instanceof EntityLivingBase) {
                            if (entity4 instanceof EntityLiving) {
                                ((EntityLiving)entity4).getNavigator().clearPathEntity();
                            }
                            entity4.motionY = 0.05 - this.motionY * 0.2;
                            ((EntityLivingBase)entity4).hurtResistantTime = (int)this.rand.nextGaussian() * 20;
                            ((EntityLivingBase)entity4).moveForward = (float)this.rand.nextGaussian();
                            ((EntityLivingBase)entity4).moveStrafing = (float)this.rand.nextGaussian();
                            ((EntityLivingBase)entity4).rotationYaw = ((EntityLivingBase)entity4).rotationYawHead += (float)this.rand.nextGaussian() * 10.0f;
                            ((EntityLivingBase)entity4).renderYawOffset = ((EntityLivingBase)entity4).rotationYawHead;
                            continue;
                        }
                        entity4.motionX = this.rand.nextGaussian() * 0.5;
                        entity4.motionY = this.rand.nextGaussian() * 0.5;
                        entity4.motionZ = this.rand.nextGaussian() * 0.5;
                        entity4.rotationYaw += 10.0f;
                        entity4.hurtResistantTime = (int)this.rand.nextGaussian() * 20;
                        continue;
                    }
                    this.doLightningAttackTo(entity4);
                    ++lightningTargets;
                }
            } finally {
                TitansPerf.endWarn(PerfSection.TARGET_SCAN, this.getClass().getSimpleName() + "#onLivingUpdate.nearbyEntityLoop", perfNearbyNs);
                TitansPerf.count(this.getClass().getSimpleName() + "#onLivingUpdate.nearbyEntitiesSeen", nearbySeen);
                TitansPerf.count(this.getClass().getSimpleName() + "#onLivingUpdate.minionSync", minionSync);
                TitansPerf.count(this.getClass().getSimpleName() + "#onLivingUpdate.lightningTargets", lightningTargets);
            }
        }
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Double.MAX_VALUE);
        if (TheTitans.NightmareMode) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2.0E7 + (double)this.getExtraPower() * 2.0E7);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0E7 + (double)this.getExtraPower() * 1.0E7);
        }
        if (this.ticksExisted % 3 + this.rand.nextInt(3) == 0 || this.getInvulTime() >= 1000) {
            this.setCustomNameTag("\u00a7kRegnator");
        } else {
            this.setCustomNameTag("\u00a7l" + StatCollector.translateToLocal((String)"entity.WitherBossTitan.name"));
        }
        if (this.getAttackTarget() != null && !(this.worldObj.provider instanceof WorldProviderVoid) && (this.affectTicks >= 600 || this.getAttackTarget().height > 6.0f && !(this.getAttackTarget() instanceof EntityTitan))) {
            this.doLightningAttackTo((Entity)this.getAttackTarget());
            if (this.isInOmegaForm()) {
                for (int i1 = 0; i1 < 19; ++i1) {
                    this.doLightningAttackTo((Entity)this.getAttackTarget());
                    this.getAttackTarget().attackEntityFrom(DamageSource.outOfWorld, 1.0f);
                }
            }
        }
        ++this.affectTicks;
        if (this.affectTicks >= 1010) {
            this.affectTicks = 0;
        }
        if (this.getAttackTarget() != null && !this.getAttackTarget().isEntityAlive()) {
            this.setAttackTarget(null);
        }
        if (this.numMinions < this.getMinionCap() && this.rand.nextInt(this.getMinionSpawnRate()) == 0 && this.getHealth() > 0.0f && !this.worldObj.isRemote) {
            EntityWitherzillaMinion entitychicken = new EntityWitherzillaMinion(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ, this.rotationYaw, 0.0f);
            entitychicken.func_82206_m();
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            entitychicken.addVelocity(-MathHelper.sin((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 3.0f, 0.0, MathHelper.cos((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 3.0f);
            ++this.numMinions;
        }
        if (this.rand.nextInt(120) == 0 && this.getAttackTarget() != null && !this.worldObj.isRemote) {
            if (TheTitans.NightmareMode) {
                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 14.0f, true, true);
            } else {
                net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 7.0f, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            }
        }
        this.motionY = !this.isArmored() ? (this.motionY *= 0.1) : (this.motionY *= 0.9);
        if (!this.worldObj.isRemote && this.getWatchedTargetId(0) > 0 && (entity = this.worldObj.getEntityByID(this.getWatchedTargetId(0))) != null) {
            double d0 = entity.posX - this.posX;
            double d1 = entity.posY + (this.isArmored() ? 2.0 : 12.0) - this.posY;
            double d2 = entity.posZ - this.posZ;
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            this.getLookHelper().setLookPositionWithEntity(entity, 180.0f, 40.0f);
            if (entity instanceof EntityLivingBase && d3 < 10000.0) {
                this.attackEntityWithRangedAttack((EntityLivingBase)entity, 0.0f);
            }
            if (d3 > 64.0) {
                double d5 = MathHelper.sqrt_double((double)d3);
                this.motionX += d0 / d5 * 1.5 - this.motionX;
                this.motionY += d1 / d5 * 1.5 - this.motionY;
                this.motionZ += d2 / d5 * 1.5 - this.motionZ;
                this.renderYawOffset = this.rotationYaw = (float)Math.atan2(this.motionZ, this.motionX) * 57.295776f - 90.0f;
            }
        }
        long perfSuperNs = TitansPerf.begin();
        super.onLivingUpdate();
        TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate.super", perfSuperNs);
        for (i = 0; i < 2; ++i) {
            this.field_82218_g[i] = this.field_82221_e[i];
            this.field_82217_f[i] = this.field_82220_d[i];
        }
        for (i = 0; i < 2; ++i) {
            int j3 = this.getWatchedTargetId(i + 1);
            Entity entity1 = null;
            if (j3 > 0) {
                entity1 = this.worldObj.getEntityByID(j3);
            }
            if (entity1 != null) {
                double d1 = this.func_82214_u(i + 1);
                double d3 = this.func_82208_v(i + 1);
                double d5 = this.func_82213_w(i + 1);
                double d6 = entity1.posX - d1;
                double d7 = entity1.posY + (double)entity1.getEyeHeight() - d3;
                double d8 = entity1.posZ - d5;
                double d9 = MathHelper.sqrt_double((double)(d6 * d6 + d8 * d8));
                float f = (float)(Math.atan2(d8, d6) * 180.0 / Math.PI) - 90.0f;
                float f1 = (float)(-(Math.atan2(d7, d9) * 180.0 / Math.PI));
                this.field_82220_d[i] = this.func_82204_b(this.field_82220_d[i], f1, 5.0f);
                this.field_82221_e[i] = this.func_82204_b(this.field_82221_e[i], f, 5.0f);
                continue;
            }
            if (this.rand.nextInt(120) == 0) {
                for (j3 = 0; j3 < 36; ++j3) {
                    this.field_82220_d[i] = this.func_82204_b(this.field_82220_d[i], this.rand.nextFloat() * 360.0f - 180.0f, 5.0f);
                }
            }
            if (this.rand.nextInt(120) != 0) continue;
            for (j3 = 0; j3 < 36; ++j3) {
                this.field_82221_e[i] = this.func_82204_b(this.field_82221_e[i], this.rand.nextFloat() * 360.0f - 180.0f, 5.0f);
            }
        }
        this.shouldParticlesBeUpward = false;
        boolean flag = this.isArmored();
        for (j = 0; j < 3; ++j) {
            double d10 = this.func_82214_u(j);
            double d2 = this.func_82208_v(j);
            double d4 = this.func_82213_w(j);
            for (int j1 = 0; j1 < 15; ++j1) {
                this.worldObj.spawnParticle("largesmoke", d10 + this.rand.nextGaussian() * 32.0, d2 + this.rand.nextGaussian() * 32.0, d4 + this.rand.nextGaussian() * 32.0, 0.0, 0.0, 0.0);
            }
            if (!flag || this.worldObj.rand.nextInt(4) != 0) continue;
            this.worldObj.spawnParticle("mobSpell", d10 + this.rand.nextGaussian() * 32.0, d2 + this.rand.nextGaussian() * 32.0, d4 + this.rand.nextGaussian() * 32.0, (double)0.7f, (double)0.7f, 0.5);
        }
        if (this.getInvulTime() > 0) {
            for (j = 0; j < 3; ++j) {
                this.worldObj.spawnParticle("mobSpell", this.posX + this.rand.nextGaussian() * 32.0, this.posY + (double)(this.rand.nextFloat() * 210.0f), this.posZ + this.rand.nextGaussian() * 32.0, (double)0.7f, (double)0.7f, (double)0.9f);
            }
        }
        if (this.worldObj.isRemote) {
            for (int i1 = 0; i1 < this.getParticleCount(); ++i1) {
                this.worldObj.spawnParticle(this.getParticles(), this.posX + (this.rand.nextDouble() - 0.5) * ((double)this.width * 3.0), this.posY + this.rand.nextDouble() * 210.0, this.posZ + (this.rand.nextDouble() - 0.5) * ((double)this.width * 3.0), 0.0, 0.5, 0.0);
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        if (p_70652_1_.height >= 6.0f || p_70652_1_ instanceof EntityTitan) {
            float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.getKnockbackAmount();
            for (int it = 0; it < 10; ++it) {
                this.attackChoosenEntity(p_70652_1_, f, 2);
                if (!(p_70652_1_ instanceof EntityTitan) || ((EntityTitan)p_70652_1_).getInvulTime() <= 1) continue;
                ((EntityTitan)p_70652_1_).setInvulTime(((EntityTitan)p_70652_1_).getInvulTime() - 20);
            }
            return super.attackEntityAsMob(p_70652_1_);
        }
        return false;
    }

    @Override
    protected void updateAITasks() {
        long perfNs = TitansPerf.begin();
        try {
        --this.attackTimer;
        if (this.getInvulTime() > 0) {
            if (this.ticksExisted % 1 == 0) {
                this.heal(this.getMaxHealth() / 800.0f);
            }
            int i = this.getInvulTime() - 1;
            this.setInvulTime(i);
            if (i <= 0) {
                this.blockBreakCounter = 1;
                this.worldObj.playBroadcastSound(1013, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                if (this.allPlayerList != null && !this.allPlayerList.isEmpty()) {
                    for (int i1 = 0; i1 < this.allPlayerList.size(); ++i1) {
                        Entity entity = (Entity)this.allPlayerList.get(i1);
                        if (!(entity instanceof EntityPlayer)) continue;
                        this.worldObj.playSound(entity.posX, entity.posY, entity.posZ, "thetitans:witherzillaSpawn", 10.0f, 1.0f, false);
                    }
                }
            }
        } else {
            int i;
            List list;
            Entity entity;
            ArrayList listp;
            double d0;
            int i1;
            long perfSuperNs = TitansPerf.begin();
            super.updateAITasks();
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks.super", perfSuperNs);
            if (!(this.worldObj.provider instanceof WorldProviderVoid)) {
                TitansPerf.count(this.getClass().getSimpleName() + "#updateAITasks.omegaRefresh", 1);
                this.omegacounter = 600;
            }
            if (this.ticksExisted % 400 == 0 && !(this.worldObj.provider instanceof WorldProviderVoid)) {
                long perfTargetAcquireNs = TitansPerf.begin();
                int teleports = 0;
                int bans = 0;
                try {
                    EntityPlayer entity2 = this.worldObj.getClosestPlayerToEntity((Entity)this, -1.0);
                    if (this.allPlayerList != null && !this.allPlayerList.isEmpty() && !(this.worldObj.provider instanceof WorldProviderVoid) && this.getAttackTarget() == null && entity2 != null && this.worldObj.provider == entity2.worldObj.provider) {
                        for (i1 = 0; i1 < this.allPlayerList.size(); ++i1) {
                            this.teleportToEntity((Entity)entity2, true);
                            ++teleports;
                            if (entity2.capabilities.disableDamage) continue;
                            this.setAttackTarget((EntityLivingBase)entity2);
                        }
                    }
                    if (entity2 != null && this.deathTicks <= 0 && this.allPlayerList != null && !this.allPlayerList.isEmpty() && !(this.worldObj.provider instanceof WorldProviderVoid) && this.rand.nextInt(20) == 0 && this.getAttackTarget() != null && this.getAttackTarget() == entity2 && this.isArmored()) {
                        for (i1 = 0; i1 < this.allPlayerList.size(); ++i1) {
                            if (this.worldObj.isRemote) continue;
                            MinecraftServer minecraftserver = MinecraftServer.getServer();
                            GameProfile gameprofile = minecraftserver.func_152358_ax().func_152655_a(entity2.getCommandSenderName());
                            EntityPlayerMP entityplayermp = minecraftserver.getConfigurationManager().func_152612_a(entity2.getCommandSenderName());
                            if (entityplayermp == null || entity2.getCommandSenderName() == "Umbrella_Ghast") continue;
                            this.attackChoosenEntity((Entity)entity2, 2.14748365E9f, 0);
                            entity2.setDead();
                            UserListBansEntry userlistbansentry = new UserListBansEntry(gameprofile, (Date)null, entity2.getCommandSenderName(), (Date)null, null);
                            minecraftserver.getConfigurationManager().func_152608_h().func_152687_a((UserListEntry)userlistbansentry);
                            entityplayermp.playerNetServerHandler.kickPlayerFromServer("You've been banned from this server by Witherzilla for being annoying.");
                            ++bans;
                        }
                    }
                } finally {
                    TitansPerf.endWarn(PerfSection.TARGET_SCAN, this.getClass().getSimpleName() + "#updateAITasks.targetAcquire", perfTargetAcquireNs);
                    TitansPerf.count(this.getClass().getSimpleName() + "#updateAITasks.teleports", teleports);
                    TitansPerf.count(this.getClass().getSimpleName() + "#updateAITasks.bans", bans);
                }
            }
            if (this.getAttackTarget() != null && this.canAttack() && this.getAttackTarget() instanceof EntityLivingBase && (d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget())) < (double)(this.width * this.width + this.getAttackTarget().width * this.getAttackTarget().width) + 6000.0) {
                this.swingItem();
                this.attackEntityAsMob((Entity)this.getAttackTarget());
            }
            if (this.getAttackTarget() != null && (listp = Lists.newArrayList((Iterable)this.worldObj.playerEntities)) != null && !listp.isEmpty()) {
                for (i1 = 0; i1 < listp.size(); ++i1) {
                    entity = (Entity)listp.get(i1);
                    if (entity == null || !(entity instanceof EntityPlayer) || !(this.getAttackTarget() instanceof EntityWitherzilla)) continue;
                    ((EntityPlayer)entity).addChatMessage((IChatComponent)new ChatComponentText("\u00a7l\u00a7kRegnator: There's another me. This is a paradox!"));
                }
            }
            if (this.posY <= 0.0) {
                if (this.worldObj.provider instanceof WorldProviderVoid || this.worldObj.provider instanceof WorldProviderEnd) {
                    this.teleportRandomly(true);
                } else {
                    this.teleportRandomly(false);
                }
            }
            long perfLoadedNs = TitansPerf.begin();
            if ((this.ticksExisted & 7) == 0 && (list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(96.0, 64.0, 96.0))) != null && !list.isEmpty()) {
                TitansPerf.count(this.getClass().getSimpleName() + "#updateAITasks.loadedEntities", list.size());
                for (i1 = 0; i1 < list.size(); ++i1) {
                    entity = (Entity)list.get(i1);
                    if (!(this.worldObj.provider instanceof WorldProviderVoid) && entity != null && entity instanceof EntityPlayer && ((EntityPlayer)entity).getHeldItem() != null && ((EntityPlayer)entity).getHeldItem().getItem() != TitanItems.ultimaBlade) {
                        ((EntityPlayer)entity).renderBrokenItemStack(((EntityPlayer)entity).getHeldItem());
                        ((EntityPlayer)entity).getHeldItem().stackSize = 0;
                        ((EntityPlayer)entity).destroyCurrentEquippedItem();
                        this.doLightningAttackTo(entity);
                    }
                    if ((entity instanceof EntityAgeable || entity instanceof EntityAmbientCreature || entity instanceof EntityWaterMob) && this.getDistanceSqToEntity(entity) < 4096.0) {
                        entity.setDead();
                    }
                }
            }
            TitansPerf.endWarn(PerfSection.TARGET_SCAN, this.getClass().getSimpleName() + "#updateAITasks.loadedEntityLoop", perfLoadedNs);
            long perfHeadNs = TitansPerf.begin();
            int headShots = 0;
            int randomBursts = 0;
            try {
                for (i = 1; i < 3; ++i) {
                    int i12;
                    if (this.ticksExisted < this.field_82223_h[i - 1] || this.getAttackTarget() == null) continue;
                    this.field_82223_h[i - 1] = this.ticksExisted + 40 + this.rand.nextInt(40);
                    int k2 = i - 1;
                    int l2 = this.field_82224_i[i - 1];
                    this.field_82224_i[k2] = this.field_82224_i[i - 1] + 1;
                    if (l2 > 15) {
                        ++randomBursts;
                        for (int i11 = 0; i11 < 4; ++i11) {
                            float f = 100.0f;
                            float f1 = 20.0f;
                            double d02 = MathHelper.getRandomDoubleInRange((Random)this.rand, (double)(this.posX - (double)f), (double)(this.posX + (double)f));
                            double d1 = MathHelper.getRandomDoubleInRange((Random)this.rand, (double)(this.posY - (double)f1), (double)(this.posY + (double)f1));
                            double d2 = MathHelper.getRandomDoubleInRange((Random)this.rand, (double)(this.posZ - (double)f), (double)(this.posZ + (double)f));
                            this.launchWitherSkullToCoords(i + 1, d02, d1, d2, true);
                            ++headShots;
                        }
                        this.field_82224_i[i - 1] = 0;
                    }
                    if ((i12 = this.getWatchedTargetId(i)) > 0) {
                        Entity entity3 = this.worldObj.getEntityByID(i12);
                        if (entity3 != null && entity3.isEntityAlive()) {
                            this.launchWitherSkullToEntity(i + 1, (EntityLivingBase)entity3);
                            ++headShots;
                            this.field_82223_h[i - 1] = this.ticksExisted;
                            this.field_82224_i[i - 1] = 0;
                            continue;
                        }
                        this.func_82211_c(i, 0);
                        continue;
                    }
                    if (this.getAttackTarget() != null && this.getAttackTarget().isEntityAlive()) {
                        this.func_82211_c(i, this.getAttackTarget().getEntityId());
                        continue;
                    }
                    this.func_82211_c(i, 0);
                }
            } finally {
                TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks.secondaryHeads", perfHeadNs);
                TitansPerf.count(this.getClass().getSimpleName() + "#updateAITasks.headShots", headShots);
                TitansPerf.count(this.getClass().getSimpleName() + "#updateAITasks.randomBursts", randomBursts);
            }
            if (this.getAttackTarget() != null) {
                this.func_82211_c(0, this.getAttackTarget().getEntityId());
            } else {
                this.func_82211_c(0, 0);
            }
            if (this.blockBreakCounter > 0) {
                --this.blockBreakCounter;
            }
            if (this.blockBreakCounter <= 0 && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing") && TitanOptimizationHelper.shouldRunHeavyAI(this, 2, 4, 96.0)) {
                this.blockBreakCounter = 8;
                long perfBreakNs = TitansPerf.begin();
                this.destroyBlocksInAABB(this.boundingBox.expand(4.0, 2.0, 4.0));
                TitansPerf.endWarn(PerfSection.BLOCK_BREAK, this.getClass().getSimpleName() + "#updateAITasks.destroyBlocks", perfBreakNs);
                this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
        }
    }

    @Override
    public void onKillCommand() {
        ArrayList list11 = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
        if (list11 != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity == null || !(entity instanceof EntityPlayer)) continue;
                ((EntityPlayer)entity).addChatMessage((IChatComponent)new ChatComponentText(StatCollector.translateToLocal((String)"dialog.witherzilla.killattempt")));
            }
        }
    }

    private double func_82214_u(int p_82214_1_) {
        return this.posX;
    }

    private double func_82208_v(int p_82208_1_) {
        return this.posY + 12.0;
    }

    private double func_82213_w(int p_82213_1_) {
        return this.posZ;
    }

    private float func_82204_b(float p_82204_1_, float p_82204_2_, float p_82204_3_) {
        float f3 = MathHelper.wrapAngleTo180_float((float)(p_82204_2_ - p_82204_1_));
        if (f3 > p_82204_3_) {
            f3 = p_82204_3_;
        }
        if (f3 < -p_82204_3_) {
            f3 = -p_82204_3_;
        }
        return p_82204_1_ + f3;
    }

    private void launchWitherSkullToEntity(int p_82216_1_, EntityLivingBase p_82216_2_) {
        if (p_82216_2_ == null || !p_82216_2_.isEntityAlive()) {
            return;
        }
        if (p_82216_2_ instanceof EntityTitan || p_82216_2_.height >= 6.0f) {
            double d0 = this.getDistanceSqToEntity((Entity)p_82216_2_);
            if (d0 < 1000.0 && this.attackTimer <= 0) {
                this.attackTimer = 20;
                this.attackEntityAsMob((Entity)p_82216_2_);
            }
            return;
        }
        this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.posX, p_82216_2_.posY + (double)p_82216_2_.getEyeHeight() * 0.5, p_82216_2_.posZ, false);
    }

    private void launchWitherSkullToCoords(int p_82209_1_, double p_82209_2_, double p_82209_4_, double p_82209_6_, boolean p_82209_8_) {
        if (this.worldObj.isRemote) {
            return;
        }
        double d3 = this.func_82214_u(p_82209_1_);
        double d4 = this.func_82208_v(p_82209_1_);
        double d5 = this.func_82213_w(p_82209_1_);
        double d6 = p_82209_2_ - d3;
        double d7 = p_82209_4_ - d4;
        double d8 = p_82209_6_ - d5;
        EntityWitherzillaSkull skull = new EntityWitherzillaSkull(this.worldObj, (EntityLivingBase)this, d6, d7, d8);
        if (p_82209_8_) {
            skull.setInvulnerable(true);
        }
        skull.posY = d4;
        skull.posX = d3;
        skull.posZ = d5;
        this.worldObj.playSoundEffect(d3, d4, d5, "mob.wither.shoot", 3.0f, 0.8f);
        this.worldObj.spawnEntityInWorld((Entity)skull);
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        if (p_82196_1_ instanceof EntityTitan || p_82196_1_.height >= 6.0f) {
            double d0 = this.getDistanceSqToEntity((Entity)p_82196_1_);
            if (d0 < 1000.0 && this.attackTimer <= 0) {
                this.attackTimer = 1 + this.rand.nextInt(9);
                this.attackEntityAsMob((Entity)p_82196_1_);
            }
        } else {
            this.launchWitherSkullToEntity(0, p_82196_1_);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.rand.nextInt(10) == 0 && !(this.worldObj.provider instanceof WorldProviderVoid)) {
            this.omegacounter = 600;
        }
        if (this.isEntityInvulnerable() || this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL || this.getExtraPower() > 5) {
            return false;
        }
        if (source.getEntity() instanceof EntityWitherzillaMinion || source.isExplosion() && !(source.getEntity() instanceof EntityWitherTurret)) {
            return false;
        }
        if (this.isArmored() && !(source.getEntity() instanceof EntityPlayer) && !(source.getEntity() instanceof EntityTitan)) {
            if (source.getEntity() != null && this.rand.nextInt(10) == 0) {
                this.teleportToEntity(source.getEntity(), false);
            }
            return false;
        }
        if (this.blockBreakCounter <= 0) {
            this.blockBreakCounter = 1;
        }
        ++this.ticksExisted;
        return super.attackEntityFrom(source, amount);
    }

    public boolean attackWitherzillaFrom(DamageSource source, float amount) {
        if (source.getEntity() instanceof EntityWitherzillaMinion || source.getEntity() instanceof EntityWitherzilla || source.isExplosion() && !(source.getEntity() instanceof EntityWitherTurret)) {
            return false;
        }
        if (this.isArmored() && !(source.getEntity() instanceof EntityPlayer) && !(source.getEntity() instanceof EntityTitan)) {
            return false;
        }
        if (this.blockBreakCounter <= 0) {
            this.blockBreakCounter = 1;
        }
        return super.attackEntityFrom(source, amount);
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            int l;
            for (int x = 0; x < 250; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.motionY += 1.0;
                entitylargefireball.setXPCount(32000);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            Item it = null;
            Block bl = null;
            Iterator ilist = Item.itemRegistry.iterator();
            int icount = 0;
            while (ilist.hasNext()) {
                it = (Item)ilist.next();
                if (it == null) continue;
                ++icount;
            }
            int j = 0;
            while (j < 256) {
                ilist = Item.itemRegistry.iterator();
                for (int k = 1 + this.rand.nextInt(icount); k > 0 && ilist.hasNext(); --k) {
                    it = (Item)ilist.next();
                }
                if (it == null || it == TitanItems.ultimaBlade) continue;
                ++j;
                EntityItem var3 = new EntityItem(this.worldObj, this.posX + (this.rand.nextDouble() - 0.5) * 12.0, this.posY + 12.0 + (this.rand.nextDouble() - 0.5) * 12.0, this.posZ + (this.rand.nextDouble() - 0.5) * 12.0, new ItemStack(it, 1, 0));
                this.worldObj.spawnEntityInWorld((Entity)var3);
            }
            Iterator blist = Block.blockRegistry.iterator();
            int bcount = 0;
            while (blist.hasNext()) {
                bl = (Block)blist.next();
                if (bl == null) continue;
                ++bcount;
            }
            int j2 = 0;
            while (j2 < 256) {
                blist = Block.blockRegistry.iterator();
                for (int k = 1 + this.rand.nextInt(bcount); k > 0 && blist.hasNext(); --k) {
                    bl = (Block)blist.next();
                }
                if (bl == null) continue;
                ++j2;
                EntityItem var3 = new EntityItem(this.worldObj, this.posX + (this.rand.nextDouble() - 0.5) * 12.0, this.posY + 12.0 + (this.rand.nextDouble() - 0.5) * 12.0, this.posZ + (this.rand.nextDouble() - 0.5) * 12.0, new ItemStack(Item.getItemFromBlock((Block)bl), 1, 0));
                this.worldObj.spawnEntityInWorld((Entity)var3);
            }
            for (l = 0; l < 1024; ++l) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.coal_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 512; ++l) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.iron_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 512; ++l) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.gold_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 256; ++l) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.emerald_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 256; ++l) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.diamond_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 128; ++l) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanBlocks.harcadium_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 128; ++l) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanBlocks.void_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 128; ++l) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanBlocks.bedrock_block));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 256; ++l) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.dragon_egg));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
        }
    }

    @Override
    protected void despawnEntity() {
    }

    @Override
    protected float getSoundVolume() {
        return 1000.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 0xF000F0;
    }

    public float getBrightness(float p_70013_1_) {
        return 1.0f;
    }

    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    public void addPotionEffect(PotionEffect p_70690_1_) {
    }

    @SideOnly(value=Side.CLIENT)
    public float func_82207_a(int p_82207_1_) {
        return this.field_82221_e[p_82207_1_];
    }

    @SideOnly(value=Side.CLIENT)
    public float func_82210_r(int p_82210_1_) {
        return this.field_82220_d[p_82210_1_];
    }

    public int getWatchedTargetId(int p_82203_1_) {
        return this.dataWatcher.getWatchableObjectInt(17 + p_82203_1_);
    }

    public void func_82211_c(int p_82211_1_, int p_82211_2_) {
        this.dataWatcher.updateObject(17 + p_82211_1_, (Object)p_82211_2_);
    }

    public boolean isArmored() {
        return this.getHealth() <= this.getMaxHealth() / 2.0f;
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Override
    public void mountEntity(Entity entityIn) {
        this.ridingEntity = null;
    }

    @Override
    public StatBase getAchievement() {
        if (this.worldObj.provider instanceof WorldProviderVoid) {
            return TitansAchievments.witherzilla;
        }
        return TitansAchievments.witherzilla2;
    }

    @Override
    public int getThreashHold() {
        return 210;
    }

    @Override
    protected void inactDeathAction() {
        if (!this.worldObj.isRemote) {
            this.createBeaconPortal(MathHelper.floor_double((double)this.posX), MathHelper.floor_double((double)this.posZ));
            if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(true, 0);
                this.dropEquipment(true, 0);
                this.dropRareDrop(1);
            }
            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
            entitytitan.setLocationAndAngles(this.posX, this.posY + 48.0, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitytitan);
            entitytitan.setVesselHunting(true);
            entitytitan.setSpiritType(12);
        }
    }

    @Override
    protected void onTitanDeathUpdate() {
        this.dataWatcher.updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)this.dataWatcher.getWatchableObjectFloat(5), (float)0.0f, (float)this.getMaxHealth())));
        this.dead = false;
        if (this.dataWatcher.getWatchableObjectFloat(5) <= 0.0f) {
            ++this.deathTicks;
        }
        if (this.deathTicks > 180 && this.deathTicks % 1 == 0) {
            float f = (this.rand.nextFloat() - 0.5f) * 24.0f;
            float f1 = (this.rand.nextFloat() - 0.5f) * 80.0f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 24.0f;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        }
        if (this.worldObj.provider instanceof WorldProviderVoid) {
            this.setLocationAndAngles(0.0, 120.0, 0.0, this.deathTicks * 10, 0.0f);
        }
        if (!this.worldObj.isRemote && this.deathTicks == 1) {
            this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
            this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            MinecraftServer.getServer().func_147139_a(EnumDifficulty.PEACEFUL);
            ArrayList listp = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
            if (listp != null && !listp.isEmpty()) {
                for (int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity == null || !(entity instanceof EntityPlayer)) continue;
                    ((EntityPlayer)entity).triggerAchievement(this.getAchievement());
                    ((EntityPlayer)entity).triggerAchievement((StatBase)AchievementList.field_150964_J);
                    ItemStack item = new ItemStack(TitanItems.ultimaBlade, 1, 1);
                    ((EntityPlayer)entity).entityDropItem(item, 0.0f);
                    this.playLivingSound();
                    if (this.worldObj.provider instanceof WorldProviderVoid) {
                        ((EntityPlayer)entity).addChatMessage((IChatComponent)new ChatComponentText(StatCollector.translateToLocal((String)"dialog.witherzilla.death")));
                        continue;
                    }
                    ((EntityPlayer)entity).addChatMessage((IChatComponent)new ChatComponentText(StatCollector.translateToLocal((String)"dialog.witherzilla.defeat")));
                }
            }
        }
        if (this.deathTicks >= 200) {
            this.setInvulTime(2000);
        }
        if (this.deathTicks >= 400) {
            this.setDead();
        }
    }

    private void createBeaconPortal(int p_70975_1_, int p_70975_2_) {
        int b0 = 64;
        BlockEndPortal.field_149948_a = true;
        int b1 = 4;
        for (int k = b0 - 1; k <= b0 + 32; ++k) {
            for (int l = p_70975_1_ - b1; l <= p_70975_1_ + b1; ++l) {
                for (int i1 = p_70975_2_ - b1; i1 <= p_70975_2_ + b1; ++i1) {
                    double d0 = l - p_70975_1_;
                    double d1 = i1 - p_70975_2_;
                    double d2 = d0 * d0 + d1 * d1;
                    if (!(d2 <= ((double)b1 - 0.5) * ((double)b1 - 0.5))) continue;
                    if (k < b0) {
                        if (!(d2 <= ((double)(b1 - 1) - 0.5) * ((double)(b1 - 1) - 0.5))) continue;
                        this.worldObj.setBlock(l, k, i1, Blocks.bedrock);
                        continue;
                    }
                    if (k > b0) {
                        this.worldObj.setBlock(l, k, i1, Blocks.air);
                        continue;
                    }
                    if (d2 > ((double)(b1 - 1) - 0.5) * ((double)(b1 - 1) - 0.5)) {
                        this.worldObj.setBlock(l, k, i1, Blocks.bedrock);
                        continue;
                    }
                    this.worldObj.setBlock(l, k, i1, Blocks.end_portal);
                }
            }
        }
        this.worldObj.setBlock(p_70975_1_, b0 + 0, p_70975_2_, Blocks.bedrock);
        this.worldObj.setBlock(p_70975_1_, b0 + 1, p_70975_2_, Blocks.bedrock);
        this.worldObj.setBlock(p_70975_1_, b0 + 2, p_70975_2_, Blocks.bedrock);
        this.worldObj.setBlock(p_70975_1_ - 1, b0 + 2, p_70975_2_, Blocks.torch);
        this.worldObj.setBlock(p_70975_1_ + 1, b0 + 2, p_70975_2_, Blocks.torch);
        this.worldObj.setBlock(p_70975_1_, b0 + 2, p_70975_2_ - 1, Blocks.torch);
        this.worldObj.setBlock(p_70975_1_, b0 + 2, p_70975_2_ + 1, Blocks.torch);
        this.worldObj.setBlock(p_70975_1_, b0 + 3, p_70975_2_, Blocks.bedrock);
        this.worldObj.setBlock(p_70975_1_, b0 + 4, p_70975_2_, Blocks.diamond_block);
        this.worldObj.setBlock(p_70975_1_ + 1, b0 + 4, p_70975_2_ + 1, Blocks.diamond_block);
        this.worldObj.setBlock(p_70975_1_ + 1, b0 + 4, p_70975_2_, Blocks.diamond_block);
        this.worldObj.setBlock(p_70975_1_ + 1, b0 + 4, p_70975_2_ - 1, Blocks.diamond_block);
        this.worldObj.setBlock(p_70975_1_ - 1, b0 + 4, p_70975_2_ + 1, Blocks.diamond_block);
        this.worldObj.setBlock(p_70975_1_ - 1, b0 + 4, p_70975_2_, Blocks.diamond_block);
        this.worldObj.setBlock(p_70975_1_ - 1, b0 + 4, p_70975_2_ - 1, Blocks.diamond_block);
        this.worldObj.setBlock(p_70975_1_, b0 + 4, p_70975_2_ + 1, Blocks.diamond_block);
        this.worldObj.setBlock(p_70975_1_, b0 + 4, p_70975_2_ - 1, Blocks.diamond_block);
        this.worldObj.setBlock(p_70975_1_, b0 + 5, p_70975_2_, (Block)Blocks.beacon);
    }

    @Override
    protected void collideWithNearbyEntities() {
    }

    public float getEyeHeight() {
        return this.isInOmegaForm() ? 380.8f : 190.4f;
    }

    protected boolean teleportRandomly(boolean bool) {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5) * 64.0;
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5) * 64.0;
        if (bool) {
            return this.teleportTo(0.0, 200.0, 0.0);
        }
        return this.teleportTo(d0, 200.0, d2);
    }

    protected boolean teleportToEntity(Entity p_70816_1_, boolean bool) {
        Vec3 vec3 = Vec3.createVectorHelper((double)(this.posX - p_70816_1_.posX), (double)(this.boundingBox.minY + (double)(this.height / 2.0f) - p_70816_1_.posY + (double)p_70816_1_.getEyeHeight()), (double)(this.posZ - p_70816_1_.posZ));
        vec3 = vec3.normalize();
        double d0 = 32.0;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5) * 16.0 - vec3.xCoord * d0;
        double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5) * 16.0 - vec3.zCoord * d0;
        if (bool) {
            this.doLightningAttackTo(p_70816_1_);
            return this.teleportTo(p_70816_1_.posX, p_70816_1_.posY, p_70816_1_.posZ);
        }
        return this.teleportTo(d1, d2, d3);
    }

    protected boolean teleportTo(double p_70825_1_, double p_70825_3_, double p_70825_5_) {
        EnderTeleportEvent event = new EnderTeleportEvent((EntityLivingBase)this, p_70825_1_, p_70825_3_, p_70825_5_, 0.0f);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return false;
        }
        if (!this.worldObj.isRemote) {
            this.setPosition(p_70825_1_, p_70825_3_, p_70825_5_);
        }
        return true;
    }

    @Override
    public boolean handleLavaMovement() {
        return false;
    }

    public boolean isInOmegaForm() {
        return !(this.worldObj.provider instanceof WorldProviderVoid);
    }
}

