/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityPotion
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
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityLightningBall;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWebShot;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.IEntityMultiPartTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanAttack1;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanAttack2;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanAttack3;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanAttack4;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanCreation;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanDeath;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanShootLightning;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanShootWeb;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanSpit;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanStunned;
import net.minecraft.entity.titanminion.EntityCaveSpiderMinion;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.entity.titanminion.EntitySpiderMinion;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntitySpiderTitan
extends EntityTitan
implements IAnimatedEntity,
IEntityMultiPartTitan {
    public int damageToLegs;
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart thorax;
    public EntityTitanPart abdomen;
    public EntityTitanPart rightlegs;
    public EntityTitanPart leftlegs;

    public EntitySpiderTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0f, 8.0f);
        this.thorax = new EntityTitanPart(worldIn, this, "thorax", 6.0f, 6.0f);
        this.abdomen = new EntityTitanPart(worldIn, this, "abdomen", 12.0f, 8.0f);
        this.rightlegs = new EntityTitanPart(worldIn, this, "rightleg", 12.0f, 8.0f);
        this.leftlegs = new EntityTitanPart(worldIn, this, "leftleg", 12.0f, 8.0f);
        this.partArray = new EntityTitanPart[]{this.head, this.thorax, this.abdomen, this.rightlegs, this.leftlegs};
        this.setSize(28.0f, 14.0f);
        this.experienceValue = 12000 + this.getExtraPower() * 500;
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanCreation(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanDeath(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanAttack3(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanStunned(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanShootWeb(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanShootLightning(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanAntiTitanAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanAttack2(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanAttack1(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanSpit(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationSpiderTitanAttack4(this));
        worldIn.spawnEntityInWorld((Entity)this.head);
        worldIn.spawnEntityInWorld((Entity)this.thorax);
        worldIn.spawnEntityInWorld((Entity)this.abdomen);
        worldIn.spawnEntityInWorld((Entity)this.rightlegs);
        worldIn.spawnEntityInWorld((Entity)this.leftlegs);
    }

    @Override
    protected void applyEntityAI() {
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SpiderTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public boolean isArmored() {
        return this.getHealth() <= this.getMaxHealth() / 4.0f || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != ((Object)((Object)this.head)).getClass() && p_70686_1_ != ((Object)((Object)this.thorax)).getClass() && p_70686_1_ != ((Object)((Object)this.abdomen)).getClass() && p_70686_1_ != ((Object)((Object)this.rightlegs)).getClass() && p_70686_1_ != ((Object)((Object)this.leftlegs)).getClass() && p_70686_1_ != EntityWebShot.class && p_70686_1_ != EntitySpiderMinion.class && (p_70686_1_ == EntityCaveSpiderTitan.class || p_70686_1_ != EntitySpiderTitan.class);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(25) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.SpiderTitanMinionSpawnrate;
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
        return 20;
    }

    @Override
    public int getTemplarCap() {
        return 7;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)Byte.valueOf((byte)0));
        this.dataWatcher.addObject(17, (Object)Byte.valueOf((byte)0));
    }

    public int getBonusID() {
        return this.dataWatcher.getWatchableObjectByte(17);
    }

    public void setBonusID(int p_70829_1_) {
        this.dataWatcher.updateObject(17, (Object)((byte)p_70829_1_));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        if (tagCompund.hasKey("DamageToLegs", 99)) {
            this.damageToLegs = tagCompund.getInteger("DamageToLegs");
        }
        if (tagCompund.hasKey("SpawnedBonusID", 99)) {
            this.setBonusID(tagCompund.getInteger("SpawnedBonusID"));
        }
        this.isStunned = tagCompund.getBoolean("Stunned");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("DamageToLegs", this.damageToLegs);
        tagCompound.setInteger("SpawnedBonusID", this.getBonusID());
        tagCompound.setBoolean("Stunned", this.isStunned);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.getWaiting() && this.animID != 0 && this.deathTicks < this.getThreashHold() && this.isArmored() && this.isEntityAlive()) {
            ++this.animTick;
        }
        if (!this.worldObj.isRemote) {
            this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(60.0);
    }

    @Override
    public boolean canBeHurtByPlayer() {
        return this.isStunned && !this.isEntityInvulnerable();
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    protected String getLivingSound() {
        return this.isStunned || this.getWaiting() || this.animID == 13 ? null : "thetitans:titanSpiderLiving";
    }

    @Override
    protected String getHurtSound() {
        return "thetitans:titanSpiderGrunt";
    }

    @Override
    protected String getDeathSound() {
        return "thetitans:titanSpiderDeath";
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        return false;
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.playSound("thetitans:titanStep", 10.0f, 1.5f);
        this.playSound("thetitans:titanStep", 10.0f, 1.5f);
        this.shakeNearbyPlayerCameras(4000.0);
        this.shakeNearbyPlayerCameras(4000.0);
    }

    @Override
    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && this.getAttackTarget() != null ? super.shouldMove() : false;
    }

    @Override
    public double getSpeed() {
        return (this.getBonusID() == 1 ? 0.6 : 0.55) + (double)this.getExtraPower() * 0.001;
    }

    public boolean isInvisible() {
        return this.getBonusID() == 4;
    }

    @Override
    public void attackChoosenEntity(Entity damagedEntity, float damage, int knockbackAmount) {
        if (this.getBonusID() == 2) {
            damage *= 2.3f;
            knockbackAmount += 2;
            damagedEntity.playSound("thetitans:titanpunch", 10.0f, 1.0f);
        }
        super.attackChoosenEntity(damagedEntity, damage, knockbackAmount);
    }

    @Override
    public double getMeleeRange() {
        return (double)(this.width * this.width + (this.getAttackTarget().width > 48.0f ? 2304.0f : this.getAttackTarget().width * this.getAttackTarget().width)) + 100.0;
    }

    @Override
    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        EntityPlayer player;
        List list11;
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
                float f1 = (this.rand.nextFloat() - 0.5f) * 1.0f;
                float f2 = (this.rand.nextFloat() - 0.5f) * 10.0f;
                this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 5.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            }
        }
        if (this.getWaiting()) {
            AnimationAPI.sendAnimPacket(this, 0);
            AnimationAPI.sendAnimPacket(this, 13);
            this.setAnimTick(0);
            EntityPlayer player2 = this.worldObj.getClosestPlayerToEntity((Entity)this, 32.0);
            if (player2 != null) {
                this.setWaiting(false);
                this.faceEntity((Entity)player2, 180.0f, 0.0f);
                player2.triggerAchievement((StatBase)TitansAchievments.locateTitan);
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
                this.playSound("thetitans:titanBirth", 100.0f, 1.25f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 40) {
                this.playSound("thetitans:titanRumble", 10.0f, 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 30) {
                this.playSound("thetitans:titanSpiderLiving", this.getSoundVolume(), 0.8f);
            }
            if (this.getAnimID() == 13 && (this.getAnimTick() == 135 || this.getAnimTick() == 155)) {
                this.func_145780_a(0, 0, 0, Blocks.stone);
                this.playSound("thetitans:titanPress", this.getSoundVolume(), 1.0f);
            }
        }
        if (this.getAnimID() == 6 && this.getAnimTick() <= 100 && this.getAnimTick() >= 30 && this.getAnimTick() % 5 == 0 && this.getAttackTarget() != null) {
            this.playSound("mob.wither.shoot", 5.0f, 1.0f);
            double d8 = 2.0;
            float xfac = MathHelper.sin((float)(this.renderYawOffset * (float)Math.PI / 180.0f));
            float zfac = MathHelper.cos((float)(this.renderYawOffset * (float)Math.PI / 180.0f));
            double d0 = this.getAttackTarget().posX - (this.posX - (double)xfac * d8);
            double d1 = this.getAttackTarget().posY - 1.0 - (this.posY + 1.0);
            double d2 = this.getAttackTarget().posZ - (this.posZ + (double)zfac * d8);
            float f1 = MathHelper.sqrt_double((double)(d0 * d0 + d2 * d2));
            EntityWebShot entitysnowball = new EntityWebShot(this.worldObj, (EntityLivingBase)this, d0, d1, d2);
            entitysnowball.posX = this.posX - (double)xfac * d8;
            entitysnowball.posY = this.posY + 1.0;
            entitysnowball.posZ = this.posZ + (double)zfac * d8;
            this.worldObj.spawnEntityInWorld((Entity)entitysnowball);
        }
        if (!this.worldObj.isRemote && this.getAnimID() == 2 && this.getAttackTarget() != null && (list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(64.0, 64.0, 64.0))) != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity1 = (Entity)list11.get(i1);
                if (!(entity1 instanceof EntityLivingBase) || !this.canAttackClass(entity1.getClass())) continue;
                entity1.hurtResistantTime = 0;
                ((EntityLivingBase)entity1).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 1));
            }
        }
        if (!this.worldObj.isRemote && this.getAnimID() == 2 && this.getAnimTick() <= 70 && this.getAnimTick() >= 60 && this.getAttackTarget() != null) {
            this.playSound("mob.wither.shoot", 5.0f, 1.0f);
            this.attackChoosenEntity((Entity)this.getAttackTarget(), 25.0f, 0);
            for (int j = 0; j < 300; ++j) {
                EntityPotion entitypotion = new EntityPotion(this.worldObj, (EntityLivingBase)this, this instanceof EntityCaveSpiderTitan ? 16484 : (this.rand.nextInt(10) == 0 ? 16452 : 16490));
                double d8 = 5.0;
                float xfac = MathHelper.sin((float)(this.renderYawOffset * (float)Math.PI / 180.0f));
                float zfac = MathHelper.cos((float)(this.renderYawOffset * (float)Math.PI / 180.0f));
                double d0 = this.getAttackTarget().posX - (this.head.posX - (double)xfac * d8);
                double d1 = this.getAttackTarget().posY - (this.head.posY + 4.0);
                double d2 = this.getAttackTarget().posZ - (this.head.posZ + (double)zfac * d8);
                float f1 = MathHelper.sqrt_double((double)(d0 * d0 + d2 * d2));
                entitypotion.setThrowableHeading(d0, d1 + (double)(f1 * 0.2f), d2, 1.6f, 1.0f + (float)(this.getAnimTick() * 2 - 60));
                entitypotion.posX = this.head.posX - (double)xfac * d8;
                entitypotion.posY = this.head.posY + 4.0;
                entitypotion.posZ = this.head.posZ + (double)zfac * d8;
                this.worldObj.spawnEntityInWorld((Entity)entitypotion);
            }
        }
        if (this.getAnimID() == 7 && this.getAnimTick() == 68) {
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX, this.posY + 3.0, this.posZ, 0.6f, 0.1f, 0.2f));
        }
        if ((player = this.worldObj.getClosestPlayerToEntity((Entity)this.head, 9.0)) != null && this.head.posY < player.posY - 7.0) {
            this.rotationYawHead += MathHelper.sin((float)this.ticksExisted) * 40.0f;
            this.rotationPitch -= MathHelper.cos((float)this.ticksExisted) * 40.0f;
        }
        this.meleeTitan = true;
        if (this.animID == 10) {
            if (this.animTick == 80 || this.animTick == 210 || this.animTick == 250 || this.animTick == 260) {
                this.shakeNearbyPlayerCameras(10000.0);
                this.playSound("thetitans:titanFall", 20.0f, 1.0f);
                this.playSound("thetitans:distantLargeFall", 10000.0f, 1.0f);
                this.collideWithEntities(this.leftlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftlegs.boundingBox.expand(24.0, 1.0, 24.0)));
                this.collideWithEntities(this.rightlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightlegs.boundingBox.expand(24.0, 1.0, 24.0)));
            }
            if (this.animTick == 420) {
                this.isStunned = false;
            } else {
                this.setAttackTarget(null);
            }
        }
        if (this.animID == 8) {
            if (this.animTick == 58) {
                this.playSound("thetitans:largeFall", 8.0f, 0.9f);
                this.playSound("thetitans:titanFall", 10.0f, 1.0f);
            }
            if (this.animTick == 60) {
                this.playSound("thetitans:distantLargeFall", 10000.0f, 1.0f);
            }
            if (this.animTick == 420) {
                this.isStunned = false;
            } else {
                this.setAttackTarget(null);
            }
        }
        if (this.isStunned) {
            this.setAttackTarget(null);
            AnimationAPI.sendAnimPacket(this, 8);
        }
        if (this.ticksExisted > 5) {
            float f = this.renderYawOffset * (float)Math.PI / 180.0f;
            float f1 = MathHelper.sin((float)f);
            float f2 = MathHelper.cos((float)f);
            this.head.setLocationAndAngles(this.posX - (double)(MathHelper.sin((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * (7.0f * (this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f))), this.posY + (this.animID == 8 ? 0.0 : 5.0) * (double)(this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f) - (double)(MathHelper.sin((float)(this.rotationPitch * (float)Math.PI / 180.0f)) * (4.0f * (this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f))), this.posZ + (double)(MathHelper.cos((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * (7.0f * (this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f))), 0.0f, 0.0f);
            this.thorax.setLocationAndAngles(this.posX, this.posY + (this.animID == 8 ? 1.0 : 6.25) * (double)(this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f), this.posZ, 0.0f, 0.0f);
            this.abdomen.setLocationAndAngles(this.posX + (double)(f1 * (9.0f * (this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f))), this.posY + (this.animID == 8 ? 1.0 : 5.0) * (double)(this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f), this.posZ - (double)(f2 * (9.0f * (this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f))), 0.0f, 0.0f);
            this.rightlegs.setLocationAndAngles(this.posX + (double)(f2 * (10.0f * (this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f))), this.posY, this.posZ + (double)(f1 * (10.0f * (this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f))), 0.0f, 0.0f);
            this.leftlegs.setLocationAndAngles(this.posX - (double)(f2 * (10.0f * (this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f))), this.posY, this.posZ - (double)(f1 * (10.0f * (this instanceof EntityCaveSpiderTitan ? 0.7f : 1.0f))), 0.0f, 0.0f);
            if (this.isEntityAlive() && !this.isStunned) {
                this.collideWithEntities(this.rightlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightlegs.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.leftlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftlegs.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.head, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.head.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.thorax, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.thorax.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.abdomen, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.abdomen.boundingBox.expand(1.0, 0.0, 1.0)));
                if (this.isArmored()) {
                    this.collideWithEntities(this.rightlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightlegs.boundingBox.expand(1.0, 0.0, 1.0)));
                    this.collideWithEntities(this.leftlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftlegs.boundingBox.expand(1.0, 0.0, 1.0)));
                    this.collideWithEntities(this.rightlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightlegs.boundingBox.expand(1.0, 0.0, 1.0)));
                    this.collideWithEntities(this.leftlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftlegs.boundingBox.expand(1.0, 0.0, 1.0)));
                    this.collideWithEntities(this.rightlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightlegs.boundingBox.expand(1.0, 0.0, 1.0)));
                    this.collideWithEntities(this.leftlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftlegs.boundingBox.expand(1.0, 0.0, 1.0)));
                }
            }
            this.destroyBlocksInAABB(this.head.boundingBox);
            this.destroyBlocksInAABB(this.thorax.boundingBox);
            this.destroyBlocksInAABB(this.abdomen.boundingBox);
            this.destroyBlocksInAABB(this.rightlegs.boundingBox);
            this.destroyBlocksInAABB(this.leftlegs.boundingBox);
            for (int i = 0; i < this.partArray.length; ++i) {
                List list;
                if (this.getBonusID() > 0) {
                    double red = 0.4862745098039216;
                    double green = 0.6862745098039216;
                    double blue = 0.7764705882352941;
                    if (this.getBonusID() == 2) {
                        red = 0.5764705882352941;
                        green = 0.1411764705882353;
                        blue = 0.1372549019607843;
                    }
                    if (this.getBonusID() == 3) {
                        red = 0.803921568627451;
                        green = 0.3607843137254902;
                        blue = 0.6705882352941176;
                    }
                    if (this.getBonusID() == 4) {
                        red = 0.4980392156862745;
                        green = 0.5137254901960784;
                        blue = 0.5764705882352941;
                    }
                    for (int i1 = 0; i1 < 50; ++i1) {
                        this.worldObj.spawnParticle("mobSpell", this.partArray[i].posX + (this.rand.nextDouble() - 0.5) * (double)this.partArray[i].width, this.partArray[i].posY + this.rand.nextDouble() * (double)this.partArray[i].height, this.partArray[i].posZ + (this.rand.nextDouble() - 0.5) * (double)this.partArray[i].width, red, green, blue);
                    }
                }
                if ((list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.partArray[i].boundingBox.expand(0.5, 0.5, 0.5))) == null || list.isEmpty()) continue;
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
                        net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)(((EntityGargoyleTitanFireball)entity).shootingEntity != null ? ((EntityGargoyleTitanFireball)entity).shootingEntity : (EntityGargoyleTitanFireball)entity), ((EntityGargoyleTitanFireball)entity).posX, ((EntityGargoyleTitanFireball)entity).posY, ((EntityGargoyleTitanFireball)entity).posZ, 8.0f, false, false);
                        this.attackEntityFromPart(this.partArray[i], DamageSource.causeFireballDamage((EntityFireball)((EntityGargoyleTitanFireball)entity), (Entity)(((EntityGargoyleTitanFireball)entity).shootingEntity != null ? ((EntityGargoyleTitanFireball)entity).shootingEntity : (EntityGargoyleTitanFireball)entity)), 1000.0f);
                        entity.setDead();
                    }
                    if (entity instanceof EntityHarcadiumArrow) {
                        this.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                        this.attackEntityFromPart(this.partArray[i], DamageSourceExtra.causeHarcadiumArrowDamage((EntityHarcadiumArrow)entity, (Entity)(((EntityHarcadiumArrow)entity).shootingEntity != null ? ((EntityHarcadiumArrow)entity).shootingEntity : (EntityHarcadiumArrow)entity)), 500.0f);
                        entity.setDead();
                    }
                    if (!(entity instanceof EntityWebShot) || entity.ticksExisted <= 25 || ((EntityWebShot)entity).shootingEntity == this) continue;
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
        if (!AnimationAPI.isEffectiveClient() && this.getAttackTarget() != null && !this.isStunned && this.getAnimID() == 0) {
            double d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
            if (d0 < this.getMeleeRange()) {
                if (this.getAnimID() == 0) {
                    if (this.getAttackTarget() instanceof EntityTitan || this.getAttackTarget().height >= 6.0f || this.posY + (double)this.getEyeHeight() < this.getAttackTarget().posY + (double)this.getAttackTarget().getEyeHeight()) {
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
                                AnimationAPI.sendAnimPacket(this, 9);
                                this.setAnimID(9);
                                break;
                            }
                            case 2: {
                                AnimationAPI.sendAnimPacket(this, 5);
                                this.setAnimID(5);
                                break;
                            }
                            case 3: {
                                AnimationAPI.sendAnimPacket(this, 6);
                                this.setAnimID(6);
                            }
                        }
                    }
                }
            } else if (this.getAnimID() == 0 && this.getRNG().nextInt(100) == 0) {
                switch (this.rand.nextInt(3)) {
                    case 0: {
                        AnimationAPI.sendAnimPacket(this, 2);
                        this.setAnimID(2);
                        break;
                    }
                    case 1: {
                        AnimationAPI.sendAnimPacket(this, 7);
                        this.setAnimID(7);
                        break;
                    }
                    case 2: {
                        AnimationAPI.sendAnimPacket(this, 6);
                        this.setAnimID(6);
                    }
                }
            }
        }
        if (this.animID == 1 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.getRNG().nextInt(4);
        }
        if (this.rand.nextInt(100) == 0 && this.getAttackTarget() != null && !this.isStunned && this.onGround && this.getAnimID() == 0) {
            this.faceEntity((Entity)this.getAttackTarget(), 180.0f, 180.0f);
            double d01 = this.getAttackTarget().posX - this.posX;
            double d11 = this.getAttackTarget().posZ - this.posZ;
            float f21 = MathHelper.sqrt_double((double)(d01 * d01 + d11 * d11));
            double hor = 2.0;
            double ver = 2.0;
            this.motionX = d01 / (double)f21 * hor * hor + this.motionX * hor;
            this.motionZ = d11 / (double)f21 * hor * hor + this.motionZ * hor;
            this.motionY = ver;
            this.collideWithEntities(this.rightlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightlegs.boundingBox.expand(6.0, 6.0, 6.0)));
            this.collideWithEntities(this.leftlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftlegs.boundingBox.expand(6.0, 6.0, 6.0)));
            this.collideWithEntities(this.rightlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightlegs.boundingBox.expand(6.0, 6.0, 6.0)));
            this.collideWithEntities(this.leftlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftlegs.boundingBox.expand(6.0, 6.0, 6.0)));
            this.collideWithEntities(this.rightlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightlegs.boundingBox.expand(6.0, 6.0, 6.0)));
            this.collideWithEntities(this.leftlegs, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftlegs.boundingBox.expand(6.0, 6.0, 6.0)));
            if (this.getDistanceSqToEntity((Entity)this.getAttackTarget()) < 2000.0) {
                float f11 = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                int i = this.getKnockbackAmount() * 2;
                this.attackChoosenEntity((Entity)this.getAttackTarget(), f11, i);
            }
        }
        if (this.getAttackTarget() != null && this.rand.nextInt(60) == 0 && this.canEntityBeSeen((Entity)this.getAttackTarget())) {
            int k;
            int j;
            int i = MathHelper.floor_double((double)(this.getAttackTarget().posX + this.rand.nextDouble() * 2.0));
            Block block1 = this.worldObj.getBlock(i, j = MathHelper.floor_double((double)(this.getAttackTarget().posY + this.rand.nextDouble() * 2.0)), k = MathHelper.floor_double((double)(this.getAttackTarget().posZ + this.rand.nextDouble() * 2.0)));
            if (block1.getMaterial() == Material.air && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                this.worldObj.setBlock(i, j, k, Blocks.web);
            } else {
                this.getAttackTarget().addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2));
            }
        }
        if (this instanceof EntityCaveSpiderTitan) {
            if (!this.getWaiting() && this.animID != 13 && !(this.worldObj.provider instanceof WorldProviderVoid)) {
                if (this.numMinions < this.getMinionCap() && (this.rand.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                    EntityCaveSpiderMinion entitychicken = new EntityCaveSpiderMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.75, 0.0);
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
                }
                if (this.numPriests < this.getPriestCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                    EntityCaveSpiderMinion entitychicken = new EntityCaveSpiderMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.75, 0.0);
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
                }
                if (this.numZealots < this.getZealotCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                    EntityCaveSpiderMinion entitychicken = new EntityCaveSpiderMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.75, 0.0);
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
                }
                if (this.numBishop < this.getBishopCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                    EntityCaveSpiderMinion entitychicken = new EntityCaveSpiderMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.75, 0.0);
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
                }
                if (this.numTemplar < this.getTemplarCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                    EntityCaveSpiderMinion entitychicken = new EntityCaveSpiderMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.75, 0.0);
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
                }
            }
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.CaveSpiderTitan.name"));
            if (TheTitans.NightmareMode) {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(225.0 + (double)(this.getExtraPower() * 30));
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24000.0 + (double)(this.getExtraPower() * 1600));
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(75.0 + (double)(this.getExtraPower() * 10));
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12000.0 + (double)(this.getExtraPower() * 800));
            }
            this.setSize(20.0f, 10.0f);
        } else {
            if (!this.getWaiting() && this.animID != 13 && !(this.worldObj.provider instanceof WorldProviderVoid)) {
                if (this.numMinions < this.getMinionCap() && (this.rand.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                    EntitySpiderMinion entitychicken = new EntitySpiderMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.75, 0.0);
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
                    if (!(this instanceof EntityCaveSpiderTitan) && this.riddenByEntity != null && this.riddenByEntity instanceof EntitySkeletonTitan && this.rand.nextInt(2) == 0) {
                        EntitySkeletonMinion entitychicken1 = new EntitySkeletonMinion(this.worldObj);
                        entitychicken1.setLocationAndAngles(entitychicken.posX, entitychicken.posY, entitychicken.posZ, entitychicken.rotationYaw, 0.0f);
                        this.worldObj.spawnEntityInWorld((Entity)entitychicken1);
                        entitychicken1.onSpawnWithEgg(null);
                        entitychicken1.mountEntity((Entity)entitychicken);
                        entitychicken1.setMinionType(0);
                        if (((EntitySkeletonTitan)this.riddenByEntity).getSkeletonType() == 1) {
                            entitychicken1.setSkeletonType(1);
                            entitychicken1.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
                            entitychicken1.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
                        }
                    }
                }
                if (this.numPriests < this.getPriestCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                    EntitySpiderMinion entitychicken = new EntitySpiderMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.75, 0.0);
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
                    if (this.riddenByEntity != null && this.riddenByEntity instanceof EntitySkeletonTitan && this.rand.nextInt(2) == 0) {
                        EntitySkeletonMinion entitychicken1 = new EntitySkeletonMinion(this.worldObj);
                        entitychicken1.setLocationAndAngles(entitychicken.posX, entitychicken.posY, entitychicken.posZ, entitychicken.rotationYaw, 0.0f);
                        this.worldObj.spawnEntityInWorld((Entity)entitychicken1);
                        entitychicken1.onSpawnWithEgg(null);
                        entitychicken1.mountEntity((Entity)entitychicken);
                        entitychicken1.setMinionType(1);
                        if (((EntitySkeletonTitan)this.riddenByEntity).getSkeletonType() == 1) {
                            entitychicken1.setSkeletonType(1);
                            entitychicken1.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
                            entitychicken1.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
                        }
                    }
                }
                if (this.numZealots < this.getZealotCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                    EntitySpiderMinion entitychicken = new EntitySpiderMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.75, 0.0);
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
                    if (this.riddenByEntity != null && this.riddenByEntity instanceof EntitySkeletonTitan && this.rand.nextInt(2) == 0) {
                        EntitySkeletonMinion entitychicken1 = new EntitySkeletonMinion(this.worldObj);
                        entitychicken1.setLocationAndAngles(entitychicken.posX, entitychicken.posY, entitychicken.posZ, entitychicken.rotationYaw, 0.0f);
                        this.worldObj.spawnEntityInWorld((Entity)entitychicken1);
                        entitychicken1.onSpawnWithEgg(null);
                        entitychicken1.mountEntity((Entity)entitychicken);
                        if (((EntitySkeletonTitan)this.riddenByEntity).getSkeletonType() == 1) {
                            entitychicken1.setSkeletonType(1);
                        }
                        entitychicken1.setMinionType(2);
                    }
                }
                if (this.numBishop < this.getBishopCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                    EntitySpiderMinion entitychicken = new EntitySpiderMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.75, 0.0);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(3);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    ++this.numTemplar;
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ, Blocks.dirt);
                    }
                    if (this.riddenByEntity != null && this.riddenByEntity instanceof EntitySkeletonTitan && this.rand.nextInt(2) == 0) {
                        EntitySkeletonMinion entitychicken1 = new EntitySkeletonMinion(this.worldObj);
                        entitychicken1.setLocationAndAngles(entitychicken.posX, entitychicken.posY, entitychicken.posZ, entitychicken.rotationYaw, 0.0f);
                        this.worldObj.spawnEntityInWorld((Entity)entitychicken1);
                        entitychicken1.onSpawnWithEgg(null);
                        entitychicken1.mountEntity((Entity)entitychicken);
                        if (((EntitySkeletonTitan)this.riddenByEntity).getSkeletonType() == 1) {
                            entitychicken1.setSkeletonType(1);
                            entitychicken1.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
                            entitychicken1.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
                        }
                    }
                }
                if (this.numTemplar < this.getTemplarCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                    EntitySpiderMinion entitychicken = new EntitySpiderMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addVelocity(0.0, 0.75, 0.0);
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
                    if (this.riddenByEntity != null && this.riddenByEntity instanceof EntitySkeletonTitan && this.rand.nextInt(2) == 0) {
                        EntitySkeletonMinion entitychicken1 = new EntitySkeletonMinion(this.worldObj);
                        entitychicken1.setLocationAndAngles(entitychicken.posX, entitychicken.posY, entitychicken.posZ, entitychicken.rotationYaw, 0.0f);
                        this.worldObj.spawnEntityInWorld((Entity)entitychicken1);
                        entitychicken1.onSpawnWithEgg(null);
                        entitychicken1.mountEntity((Entity)entitychicken);
                        if (((EntitySkeletonTitan)this.riddenByEntity).getSkeletonType() == 1) {
                            entitychicken1.setSkeletonType(1);
                            entitychicken1.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
                            entitychicken1.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
                        }
                    }
                }
            }
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.SpiderTitan.name"));
            if (TheTitans.NightmareMode) {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(270.0 + (double)(this.getExtraPower() * 30));
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(32000.0 + (double)(this.getExtraPower() * 2000));
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(90.0 + (double)(this.getExtraPower() * 10));
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16000.0 + (double)(this.getExtraPower() * 1000));
            }
            this.setSize(28.0f, 14.0f);
        }
        if (this.getBonusID() > 4) {
            this.setBonusID(4);
        }
        if (this.getBonusID() < 0) {
            this.setBonusID(0);
        }
        super.onLivingUpdate();
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    protected Item getDropItem() {
        return Items.string;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            EntityItem entityitem;
            int l;
            for (int x = 0; x < 8; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.motionY += 1.0;
                entitylargefireball.setXPCount(this instanceof EntityCaveSpiderTitan ? 3000 : 4000);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            for (l = 0; l < 256 + this.rand.nextInt(256 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.string));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 32 + this.rand.nextInt(32 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.coal));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 8 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.emerald));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 8 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.diamond));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 48 + this.rand.nextInt(48 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.iron_ingot));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 24 + this.rand.nextInt(24 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.web));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 24 + this.rand.nextInt(24 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.mossy_cobblestone));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 36 + this.rand.nextInt(36 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.leather));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 64 + this.rand.nextInt(64 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.spider_eye));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 24 + this.rand.nextInt(24 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.fermented_spider_eye));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 0 + this.rand.nextInt(4 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanItems.harcadiumNugget));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
        }
    }

    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }

    @Override
    public void setInWeb() {
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    @Override
    public boolean isPotionApplicable(PotionEffect p_70687_1_) {
        return p_70687_1_.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(p_70687_1_);
    }

    public boolean isBesideClimbableBlock() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean p_70839_1_) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        b0 = p_70839_1_ ? (byte)(b0 | 1) : (byte)(b0 & 0xFFFFFFFE);
        this.dataWatcher.updateObject(16, (Object)b0);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_180482_2_) {
        IEntityLivingData p_180482_2_1 = super.onSpawnWithEgg(p_180482_2_);
        this.setWaiting(true);
        if (this.worldObj.rand.nextInt(10) == 0 || TheTitans.NightmareMode) {
            this.setBonusID(this.rand.nextInt(5));
        }
        return p_180482_2_1;
    }

    public float getEyeHeight() {
        return 10.4f;
    }

    @Override
    protected void updateAITasks() {
        long perfNs = TitansPerf.begin();
        try {
        List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox);
        if (list11 != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (!(entity instanceof EntityLivingBase) || !entity.onGround || entity instanceof EntityTitan) continue;
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                entity.attackEntityFrom(DamageSourceExtra.causeSquishingDamage((Entity)this), f / 2.0f);
            }
        }
        if (this.getBonusID() == 2) {
            this.heal(2.0f);
            for (int u = 0; u < 1 + this.rand.nextInt(10); ++u) {
                this.heal(2.0f);
            }
        }
        super.updateAITasks();
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
        }
    }

    @Override
    public StatBase getAchievement() {
        if (this instanceof EntityCaveSpiderTitan) {
            return TitansAchievments.cavespidertitan;
        }
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntitySkeletonTitan) {
            return TitansAchievments.spiderjockeytitan;
        }
        return TitansAchievments.spidertitan;
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
        this.setTitanHealth(0.0f);
        this.setHealth(0.0f);
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
            float f1 = (this.rand.nextFloat() - 0.5f) * 12.0f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 24.0f;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        }
        if (this.getInvulTime() >= this.getThreashHold()) {
            this.setDead();
        }
    }

    @Override
    protected void inactDeathAction() {
        if (!this.worldObj.isRemote) {
            this.playSound("mob.spider.death", this.getSoundVolume(), this.getSoundPitch());
            if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(true, 0);
                this.dropEquipment(true, 0);
                this.dropRareDrop(1);
            }
            if (this instanceof EntityCaveSpiderTitan) {
                EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
                entitytitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                this.worldObj.spawnEntityInWorld((Entity)entitytitan);
                entitytitan.setVesselHunting(false);
                entitytitan.setSpiritType(2);
            } else {
                EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
                entitytitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                this.worldObj.spawnEntityInWorld((Entity)entitytitan);
                entitytitan.setVesselHunting(false);
                entitytitan.setSpiritType(3);
            }
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 2.0f;
        }
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (!this.isStunned && source.getEntity() instanceof EntityPlayer) {
            return false;
        }
        if (this instanceof EntityCaveSpiderTitan ? source.getEntity() instanceof EntityCaveSpiderMinion || source.getEntity() instanceof EntityCaveSpiderTitan : source.getEntity() instanceof EntitySpiderMinion || source.getEntity() instanceof EntitySpiderTitan && !(source.getEntity() instanceof EntityCaveSpiderTitan)) {
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        if (p_70965_1_ == this.head) {
            amount *= 2.0f;
        }
        if (source.getEntity() != null && source.getEntity() instanceof EntityPlayer && source.canHarmInCreative() && this.damageToLegs < 8 && !this.isStunned && (p_70965_1_ == this.leftlegs || p_70965_1_ == this.rightlegs)) {
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

