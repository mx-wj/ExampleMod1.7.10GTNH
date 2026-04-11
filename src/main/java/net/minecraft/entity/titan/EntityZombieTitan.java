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
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.EntityVillager
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
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EntityDamageSourceIndirect
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.ForgeModContainer
 */
package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityLightningBall;
import net.minecraft.entity.titan.EntityProtoBall;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
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
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAttack1;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAttack2;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAttack3;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAttack4;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAttack5;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanCreation;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanDeath;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanLightningAttack;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanRangedAttack;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanReformSword;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanRoar;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanStun;
import net.minecraft.entity.titanminion.EntityGiantZombieBetter;
import net.minecraft.entity.titanminion.EntityZombieMinion;
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
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityZombieTitan
extends EntityTitan
implements IAnimatedEntity,
IEntityMultiPartTitan {
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart body;
    public EntityTitanPart rightArm;
    public EntityTitanPart leftArm;
    public EntityTitanPart rightLeg;
    public EntityTitanPart leftLeg;

    public EntityZombieTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0f, 8.0f);
        this.body = new EntityTitanPart(worldIn, this, "body", 8.0f, 12.0f);
        this.rightArm = new EntityTitanPart(worldIn, this, "rightarm", 4.0f, 4.0f);
        this.leftArm = new EntityTitanPart(worldIn, this, "leftarm", 4.0f, 4.0f);
        this.rightLeg = new EntityTitanPart(worldIn, this, "rightleg", 4.0f, 12.0f);
        this.leftLeg = new EntityTitanPart(worldIn, this, "leftleg", 4.0f, 12.0f);
        this.partArray = new EntityTitanPart[]{this.head, this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg};
        this.setSize(8.0f, 32.0f);
        this.experienceValue = 10000;
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        worldIn.spawnEntityInWorld((Entity)this.head);
        worldIn.spawnEntityInWorld((Entity)this.body);
        worldIn.spawnEntityInWorld((Entity)this.rightArm);
        worldIn.spawnEntityInWorld((Entity)this.leftArm);
        worldIn.spawnEntityInWorld((Entity)this.rightLeg);
        worldIn.spawnEntityInWorld((Entity)this.leftLeg);
    }

    @Override
    protected void applyEntityAI() {
        this.footID = 1;
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanCreation(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanDeath(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanAttack4(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanStun(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanAttack3(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanAttack2(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanRangedAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanLightningAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanRoar(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanAntiTitanAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanAttack1(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanReformSword(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationZombieTitanAttack5(this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.ZombieTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public boolean isArmored() {
        return this.getHealth() <= this.getMaxHealth() / 4.0f || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != ((Object)((Object)this.head)).getClass() && p_70686_1_ != ((Object)((Object)this.body)).getClass() && p_70686_1_ != ((Object)((Object)this.rightArm)).getClass() && p_70686_1_ != ((Object)((Object)this.leftArm)).getClass() && p_70686_1_ != ((Object)((Object)this.rightLeg)).getClass() && p_70686_1_ != ((Object)((Object)this.leftLeg)).getClass() && p_70686_1_ != EntityZombieMinion.class && p_70686_1_ != EntityGiantZombieBetter.class && p_70686_1_ != EntityZombieTitan.class;
    }

    @Override
    public float getRenderSizeModifier() {
        float f = 16.0f;
        if (this.isChild()) {
            f *= 0.6f;
        }
        return f;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(50) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.ZombieTitanMinionSpawnrate;
    }

    @Override
    public int getRegenTime() {
        if (!this.worldObj.isDaytime()) {
            return 5;
        }
        return super.getRegenTime();
    }

    @Override
    public int getMinionCap() {
        return this.animID == 11 && this.animTick > 80 ? 600 : 200;
    }

    @Override
    public int getPriestCap() {
        return this.animID == 11 && this.animTick > 80 ? 300 : 100;
    }

    @Override
    public int getZealotCap() {
        return this.animID == 11 && this.animTick > 80 ? 100 : 50;
    }

    @Override
    public int getBishopCap() {
        return this.animID == 11 && this.animTick > 80 ? 40 : 20;
    }

    @Override
    public int getTemplarCap() {
        return this.animID == 11 && this.animTick > 80 ? 20 : 10;
    }

    @Override
    public int getSpecialMinionCap() {
        return 10;
    }

    @Override
    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.AVERAGE;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(12, (Object)Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(13, (Object)Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(14, (Object)0);
        this.getDataWatcher().addObject(15, (Object)Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(16, (Object)Byte.valueOf((byte)0));
    }

    @Override
    public int getFootStepModifer() {
        return 3;
    }

    public boolean isEntityUndead() {
        return true;
    }

    public boolean isChild() {
        return this.getDataWatcher().getWatchableObjectByte(12) == 1;
    }

    protected int getExperiencePoints(EntityPlayer player) {
        if (this.isChild()) {
            this.experienceValue = (int)((float)this.experienceValue * 2.5f);
        }
        return super.getExperiencePoints(player);
    }

    public void setChild(boolean childZombie) {
        this.getDataWatcher().updateObject(12, (Object)((byte)(childZombie ? 1 : 0)));
    }

    public boolean isVillager() {
        return this.getDataWatcher().getWatchableObjectByte(13) == 1;
    }

    public void setVillager(boolean villager) {
        this.getDataWatcher().updateObject(13, (Object)((byte)(villager ? 1 : 0)));
    }

    public boolean isArmed() {
        return this.getDataWatcher().getWatchableObjectByte(15) == 1;
    }

    public void setArmed(boolean armed) {
        this.getDataWatcher().updateObject(15, (Object)((byte)(armed ? 1 : 0)));
    }

    public boolean isSwordSoft() {
        return this.getDataWatcher().getWatchableObjectByte(16) == 1;
    }

    public void setSwordSoft(boolean armed) {
        this.getDataWatcher().updateObject(16, (Object)((byte)(armed ? 1 : 0)));
    }

    @Override
    public double getSpeed() {
        return this.isChild() ? 0.6 + (double)this.getExtraPower() * 0.001 : (this.isArmored() ? 0.45 + (double)this.getExtraPower() * 0.001 : 0.3 + (double)this.getExtraPower() * 0.001);
    }

    @Override
    public boolean canBeHurtByPlayer() {
        return !this.isArmed() && !this.isEntityInvulnerable();
    }

    @Override
    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && !this.getWaiting() && this.getAttackTarget() != null ? super.shouldMove() : false;
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        return false;
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
        this.faceEntity((Entity)p_82196_1_, 180.0f, 30.0f);
        double d8 = 12.0;
        Vec3 vec3 = this.getLook(1.0f);
        double dx = vec3.xCoord * d8;
        double dz = vec3.zCoord * d8;
        EntityProtoBall entityarrow = new EntityProtoBall(this.worldObj, (EntityLivingBase)this);
        double d0 = p_82196_1_.posX + p_82196_1_.motionX - (this.head.posX + dx);
        double d1 = p_82196_1_.posY + (double)p_82196_1_.getEyeHeight() - 8.0 - this.head.posY;
        double d2 = p_82196_1_.posZ + p_82196_1_.motionZ - (this.head.posZ + dz);
        float f1 = MathHelper.sqrt_double((double)(d0 * d0 + d2 * d2));
        entityarrow.setThrowableHeading(d0, d1 + (double)f1, d2, 0.95f, 45 - this.worldObj.difficultySetting.getDifficultyId() * 5);
        entityarrow.posX = this.head.posX + dx;
        entityarrow.posY = this.head.posY;
        entityarrow.posZ = this.head.posZ + dz;
        if (!this.worldObj.isRemote) {
            this.worldObj.spawnEntityInWorld((Entity)entityarrow);
        }
        entityarrow.motionX *= 1.5;
        entityarrow.motionZ *= 1.5;
        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        if (this.getDistanceSqToEntity((Entity)p_82196_1_) < 400.0) {
            this.attackChoosenEntity((Entity)p_82196_1_, 10.0f, 5);
        }
    }

    @Override
    public void onLivingUpdate() {
        Block block;
        int l;
        int k;
        int j2;
        int j;
        int l1;
        int x;
        double dz;
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
                float f2 = (this.rand.nextFloat() - 0.5f) * 10.0f;
                this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 5.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
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
            if (this.getAnimID() == 13 && this.getAnimTick() > 4 && this.getAnimTick() <= 48) {
                this.destroyBlocksInAABBGriefingBypass(this.body.boundingBox.offset(0.0, (double)(-24 + this.getAnimTick()), 0.0).expand(0.0, 8.0, 0.0));
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 2) {
                this.playSound("thetitans:titanBirth", 1000.0f, 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 10) {
                this.playSound("thetitans:titanRumble", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 360) {
                this.playSound("thetitans:titanQuake", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 160) {
                this.playSound("thetitans:titanZombieCreation", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 440) {
                this.playSound("thetitans:titanSkeletonGetUp", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && (this.getAnimTick() == 80 || this.getAnimTick() == 150 || this.getAnimTick() == 370 || this.getAnimTick() == 430 || this.getAnimTick() == 470 || this.getAnimTick() == 490)) {
                this.func_145780_a(0, 0, 0, Blocks.stone);
                this.playSound("thetitans:titanPress", this.getSoundVolume(), 1.0f);
            }
        }
        if (this.getAnimID() == 5) {
            if (this.getAnimTick() == 34) {
                this.playSound("thetitans:lightningCharge", 100.0f, 1.0f);
            }
            if (this.getAnimTick() <= 46 && this.getAnimTick() >= 26) {
                float ex = this.isChild() ? 4.5f : 9.5f;
                float fl = this.renderYawOffset * (float)Math.PI / 180.0f;
                float fl1 = MathHelper.sin((float)fl);
                float fl2 = MathHelper.cos((float)fl);
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX - (double)(fl2 * ex), this.posY + (this.isChild() ? 13.0 : 26.0), this.posZ - (double)(fl1 * ex), 0.0f, 0.56f, 0.0f));
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + (double)(fl2 * ex), this.posY + (this.isChild() ? 13.0 : 26.0), this.posZ + (double)(fl1 * ex), 0.0f, 0.56f, 0.0f));
                if (this.getAttackTarget() == null && !this.worldObj.isRemote) {
                    this.heal(50.0f);
                }
            }
            if (this.getAnimTick() == 64) {
                this.playSound("thetitans:lightningThrow", 100.0f, 1.0f);
                double d8 = this.isChild() ? 6.0 : 12.0;
                Vec3 vec3 = this.getLook(1.0f);
                double dx = vec3.xCoord * d8;
                dz = vec3.zCoord * d8;
                this.worldObj.newExplosion((Entity)this, this.posX + dx, this.posY + 26.0, this.posZ + dz, 1.0f, false, false);
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (this.isChild() ? 9.0 : 18.0), this.posZ + dz, 0.0f, 0.56f, 0.0f));
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (this.isChild() ? 9.0 : 18.0), this.posZ + dz, 0.0f, 0.56f, 0.0f));
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (this.isChild() ? 9.0 : 18.0), this.posZ + dz, 0.0f, 0.56f, 0.0f));
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (this.isChild() ? 9.0 : 18.0), this.posZ + dz, 0.0f, 0.56f, 0.0f));
                if (this.getAttackTarget() != null) {
                    this.worldObj.newExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 2.0f, false, false);
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 0.0f, 0.56f, 0.0f));
                    float da = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    int i = this.getKnockbackAmount();
                    this.attackChoosenEntity((Entity)this.getAttackTarget(), da * 3.0f, i);
                    this.getAttackTarget().motionY += (double)(1.0f + this.rand.nextFloat());
                    this.getAttackTarget().attackEntityFrom(DamageSourceExtra.lightningBolt, da);
                    List list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getAttackTarget(), this.getAttackTarget().boundingBox.expand(12.0, 12.0, 12.0));
                    if (list1 != null && !list1.isEmpty()) {
                        for (int i11 = 0; i11 < list1.size(); ++i11) {
                            Entity entity1 = (Entity)list1.get(i11);
                            if (!(entity1 instanceof EntityLivingBase) || !this.canAttackClass(entity1.getClass())) continue;
                            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, 0.2f, 1.0f, 0.0f));
                            this.attackChoosenEntity(entity1, da, i);
                            if (entity1 instanceof EntityTitan) continue;
                            entity1.motionY += (double)(1.0f + this.rand.nextFloat());
                        }
                    }
                }
            }
        }
        if (this.isStunned) {
            this.setAttackTarget(null);
            AnimationAPI.sendAnimPacket(this, 8);
            this.setAnimID(8);
        }
        if (this.animID == 10) {
            if (this.animTick == 30 || this.animTick == 70) {
                this.func_145780_a(0, 0, 0, Blocks.stone);
            }
            if (this.animTick == 190) {
                this.playSound("thetitans:titanFall", 20.0f, 1.0f);
                this.playSound("thetitans:groundSmash", 20.0f, 1.0f);
                this.shakeNearbyPlayerCameras(10000.0);
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(48.0, 48.0, 48.0)));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(48.0, 48.0, 48.0)));
            }
            if (this.animTick == 200) {
                this.playSound("thetitans:distantLargeFall", 10000.0f, 1.0f);
            }
        }
        if (this.animID == 8) {
            this.isStunned = this.animTick <= 138;
        }
        if (this.getAnimID() == 8 && this.getAnimTick() == 4 && !this.worldObj.isRemote) {
            this.dropSword();
        }
        if (this.getAnimID() == 8 && this.getAnimTick() >= 80 && this.getAnimTick() <= 100) {
            this.playSound(this.getLivingSound(), this.getSoundVolume(), 1.1f);
        }
        if (this.getAnimID() == 7 && this.getAnimTick() == 122) {
            int z;
            double d8 = this.isChild() ? 16.0 : 32.0;
            Vec3 vec3 = this.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            dz = vec3.zCoord * d8;
            int y = MathHelper.floor_double((double)this.posY);
            x = MathHelper.floor_double((double)(this.posX + dx));
            if (this.worldObj.getBlock(x, y - 1, z = MathHelper.floor_double((double)(this.posZ + dz))).getMaterial() != Material.air) {
                this.playSound("thetitans:titanStrike", 20.0f, 1.0f);
                this.playSound("thetitans:titanSlam", 20.0f, 1.0f);
                this.playSound("thetitans:titanPress", 100.0f, 1.0f);
            }
            for (l1 = -4; l1 <= 4; ++l1) {
                for (int i2 = -4; i2 <= 4; ++i2) {
                    for (j = -1; j <= 1; ++j) {
                        j2 = x + l1;
                        k = y + j;
                        l = z + i2;
                        block = this.worldObj.getBlock(j2, k, l);
                        if (!block.isAir((IBlockAccess)this.worldObj, j2, k, l)) {
                            this.worldObj.playAuxSFX(2001, j2, k, l, Block.getIdFromBlock((Block)block));
                            if (block == Blocks.grass) {
                                this.worldObj.setBlock(j2, k, l, Blocks.dirt);
                            }
                        }
                        if (block.getExplosionResistance((Entity)this) > 500.0f && block.isOpaqueCube() && !this.isSwordSoft()) {
                            this.setAnimTick(0);
                            AnimationAPI.sendAnimPacket(this, 8);
                            this.setAnimID(8);
                            this.playSound("random.anvil_land", 20.0f, 0.5f);
                            this.isStunned = true;
                            continue;
                        }
                        if (!(block.getExplosionResistance((Entity)this) <= 1.5f) || !block.isOpaqueCube() || !this.isSwordSoft() || block == Blocks.air || block == Blocks.netherrack || block == Blocks.dirt || block == Blocks.grass || block == Blocks.glass || block == Blocks.glass_pane) continue;
                        this.setAnimTick(0);
                        AnimationAPI.sendAnimPacket(this, 8);
                        this.setAnimID(8);
                        this.playSound("random.anvil_land", 20.0f, 0.5f);
                        this.isStunned = true;
                    }
                }
            }
        }
        if (this.getAnimID() == 2 && this.getAnimTick() == 160) {
            double d8 = 12.0;
            Vec3 vec3 = this.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            dz = vec3.zCoord * d8;
            int y = MathHelper.floor_double((double)this.posY);
            x = MathHelper.floor_double((double)(this.posX + dx));
            int z = MathHelper.floor_double((double)(this.posZ + dz));
            for (l1 = -2; l1 <= 2; ++l1) {
                for (int i2 = -2; i2 <= 2; ++i2) {
                    for (j = -1; j <= 1; ++j) {
                        j2 = x + l1;
                        k = y + j;
                        l = z + i2;
                        block = this.worldObj.getBlock(j2, k, l);
                        if (!block.isAir((IBlockAccess)this.worldObj, j2, k, l)) {
                            this.worldObj.playAuxSFX(2001, j2, k, l, Block.getIdFromBlock((Block)block));
                            if (block == Blocks.grass) {
                                this.worldObj.setBlock(j2, k, l, Blocks.dirt);
                            }
                        }
                        if (block.getExplosionResistance((Entity)this) > 500.0f) {
                            this.setSwordSoft(false);
                            continue;
                        }
                        if (!(block.getExplosionResistance((Entity)this) <= 500.0f)) continue;
                        this.setSwordSoft(true);
                    }
                }
            }
        }
        float f = this.renderYawOffset * (float)Math.PI / 180.0f;
        f1 = MathHelper.sin((float)f);
        float f2 = MathHelper.cos((float)f);
        if (this.isChild()) {
            this.setSize(6.0f, 18.0f);
        } else {
            this.setSize(8.0f, 32.0f);
        }
        if (this.ticksExisted > 5) {
            this.head.width = this.isChild() ? 6.0f : 8.0f;
            this.head.height = this.head.width;
            this.body.height = this.isChild() ? 6.0f : 12.0f;
            this.body.width = this.isChild() ? 3.5f : 7.0f;
            this.rightLeg.height = this.isChild() ? 6.0f : 12.0f;
            this.leftLeg.height = this.rightLeg.height;
            this.rightLeg.width = this.isChild() ? 2.0f : 4.0f;
            this.leftLeg.width = this.rightLeg.width;
            this.leftArm.height = this.isChild() ? 2.0f : 4.0f;
            this.rightArm.height = this.leftArm.height;
            this.leftArm.width = this.leftArm.height;
            this.rightArm.width = this.leftArm.height;
            this.head.setLocationAndAngles(this.posX, this.posY + (this.isChild() ? 12.0 : 24.0), this.posZ, 0.0f, 0.0f);
            this.body.setLocationAndAngles(this.posX, this.posY + (this.isChild() ? 6.0 : 12.0), this.posZ, 0.0f, 0.0f);
            this.rightArm.setLocationAndAngles(this.posX + (double)f2 * (this.isChild() ? 3.0 : 6.0), this.posY + (this.isChild() ? 10.0 : 20.0), this.posZ + (double)f1 * (this.isChild() ? 3.0 : 6.0), 0.0f, 0.0f);
            this.leftArm.setLocationAndAngles(this.posX - (double)f2 * (this.isChild() ? 3.0 : 6.0), this.posY + (this.isChild() ? 10.0 : 20.0), this.posZ - (double)f1 * (this.isChild() ? 3.0 : 6.0), 0.0f, 0.0f);
            this.rightLeg.setLocationAndAngles(this.posX + (double)f2 * (this.isChild() ? 1.0 : 2.0), this.posY, this.posZ + (double)f1 * (this.isChild() ? 1.0 : 2.0), 0.0f, 0.0f);
            this.leftLeg.setLocationAndAngles(this.posX - (double)f2 * (this.isChild() ? 1.0 : 2.0), this.posY, this.posZ - (double)f1 * (this.isChild() ? 1.0 : 2.0), 0.0f, 0.0f);
            if (this.isEntityAlive() && !this.isStunned) {
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
            this.destroyBlocksInAABB(this.leftLeg.boundingBox.expand(1.0, 0.0, 1.0));
            this.destroyBlocksInAABB(this.rightLeg.boundingBox.expand(1.0, 0.0, 1.0));
            for (int i = 0; i < this.partArray.length; ++i) {
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.partArray[i].boundingBox.expand(0.5, 0.5, 0.5));
                if (list == null || list.isEmpty()) continue;
                for (int j3 = 0; j3 < list.size(); ++j3) {
                    Entity entity = (Entity)list.get(j3);
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
                    for (int l12 = -2 - this.rand.nextInt(4); l12 <= 2 + this.rand.nextInt(4); ++l12) {
                        for (int i2 = -2 - this.rand.nextInt(4); i2 <= 2 + this.rand.nextInt(4); ++i2) {
                            for (int h = -2; h <= 2 + this.rand.nextInt(5); ++h) {
                                int j22 = i11 + l12;
                                int k2 = i1 + h;
                                int l2 = j1 + i2;
                                Block block1 = this.worldObj.getBlock(j22, k2, l2);
                                if (block1.isOpaqueCube()) continue;
                                this.worldObj.setBlock(j22, k2, l2, Blocks.web);
                            }
                        }
                    }
                    entity.setDead();
                }
            }
        }
        this.meleeTitan = true;
        if (this.getAnimID() == 12 && this.getAttackTarget() != null && this.getAnimTick() == 55) {
            for (int i = 0; i < 4 + 2 * this.worldObj.difficultySetting.getDifficultyId(); ++i) {
                this.attackEntityWithRangedAttack(this.getAttackTarget(), 0.0f);
            }
        }
        if (this.isStunned || this.deathTicks > 0) {
            this.motionX *= 0.0;
            this.motionZ *= 0.0;
        }
        if (!AnimationAPI.isEffectiveClient() && this.getAttackTarget() != null && !this.isStunned && this.getAnimID() == 0 && this.ticksExisted > 5) {
            double d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
            if (d0 < this.getMeleeRange()) {
                if (this.getAttackTarget() instanceof EntityTitan || this.getAttackTarget().height >= 6.0f || this.getAttackTarget().posY > this.posY + 6.0) {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                } else {
                    switch (this.rand.nextInt(6)) {
                        case 0: {
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                            break;
                        }
                        case 1: {
                            if (this.isArmed()) {
                                AnimationAPI.sendAnimPacket(this, 7);
                                this.setAnimID(7);
                                break;
                            }
                            if (this.getRNG().nextInt(2) == 0) {
                                AnimationAPI.sendAnimPacket(this, 2);
                                this.setAnimID(2);
                                break;
                            }
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                            break;
                        }
                        case 2: {
                            AnimationAPI.sendAnimPacket(this, 9);
                            this.setAnimID(9);
                            break;
                        }
                        case 3: {
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                            break;
                        }
                        case 4: {
                            AnimationAPI.sendAnimPacket(this, 3);
                            this.setAnimID(3);
                            break;
                        }
                        case 5: {
                            AnimationAPI.sendAnimPacket(this, 11);
                            this.setAnimID(11);
                        }
                    }
                }
            } else if (this.getAnimID() == 0 && this.getRNG().nextInt(100) == 0) {
                switch (this.rand.nextInt(4)) {
                    case 0: {
                        AnimationAPI.sendAnimPacket(this, 5);
                        this.setAnimID(5);
                        break;
                    }
                    case 1: {
                        AnimationAPI.sendAnimPacket(this, 12);
                        this.setAnimID(12);
                        break;
                    }
                    case 2: {
                        if (this.getRNG().nextInt(4) == 0) {
                            AnimationAPI.sendAnimPacket(this, 11);
                            this.setAnimID(11);
                            break;
                        }
                        AnimationAPI.sendAnimPacket(this, 5);
                        this.setAnimID(5);
                        break;
                    }
                    case 3: {
                        if (this.isArmed()) {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                            break;
                        }
                        if (this.getRNG().nextInt(5) == 0) {
                            AnimationAPI.sendAnimPacket(this, 2);
                            this.setAnimID(2);
                            break;
                        }
                        AnimationAPI.sendAnimPacket(this, 5);
                        this.setAnimID(5);
                    }
                }
            }
        }
        if (this.animID == 1 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.getRNG().nextInt(4);
        }
        if (this.isVillager() && this.isChild()) {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.ZombieTitan.name.babyvillager"));
        } else if (!this.isVillager() && this.isChild()) {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.ZombieTitan.name.baby"));
        } else if (this.isVillager() && !this.isChild()) {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.ZombieTitan.name.villager"));
        } else {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.ZombieTitan.name"));
        }
        if (TheTitans.NightmareMode) {
            if (this.isChild()) {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20000.0 + (double)(this.getExtraPower() * 1000));
                if (this.isArmed()) {
                    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(480.0 + (double)(this.getExtraPower() * 90));
                } else {
                    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(240.0 + (double)(this.getExtraPower() * 45));
                }
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40000.0 + (double)(this.getExtraPower() * 2000));
                if (this.isArmed()) {
                    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(720.0 + (double)(this.getExtraPower() * 180));
                } else {
                    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(360.0 + (double)(this.getExtraPower() * 90));
                }
            }
        } else if (this.isChild()) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10000.0 + (double)(this.getExtraPower() * 500));
            if (this.isArmed()) {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(160.0 + (double)(this.getExtraPower() * 30));
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(80.0 + (double)(this.getExtraPower() * 15));
            }
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20000.0 + (double)(this.getExtraPower() * 1000));
            if (this.isArmed()) {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(240.0 + (double)(this.getExtraPower() * 60));
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(120.0 + (double)(this.getExtraPower() * 30));
            }
        }
        if (this.getAnimID() == 2 && this.motionY > 0.0) {
            this.motionY = 0.0;
        }
        if (!this.isArmed() && this.getAttackTarget() != null && this.getAttackTarget() instanceof EntityTitan && this.animID == 0) {
            AnimationAPI.sendAnimPacket(this, 2);
        }
        if (this.rand.nextInt(120) == 0 && this.getAttackTarget() != null && this.getDistanceSqToEntity((Entity)this.getAttackTarget()) > 512.0 && this.onGround && this.animID == 0) {
            this.playSound(this.getHurtSound(), this.getSoundVolume(), this.getSoundPitch());
            if (this.rand.nextInt(4) == 0) {
                this.jump();
                double d01 = this.getAttackTarget().posX - this.posX;
                double d11 = this.getAttackTarget().posZ - this.posZ;
                float f21 = MathHelper.sqrt_double((double)(d01 * d01 + d11 * d11));
                double hor = 2.0;
                this.motionX = d01 / (double)f21 * hor * hor + this.motionX * hor;
                this.motionZ = d11 / (double)f21 * hor * hor + this.motionZ * hor;
            } else {
                this.jumpAtEntity(this.getAttackTarget());
            }
        }
        if (!this.getWaiting() && this.animID != 13 && !(this.worldObj.provider instanceof WorldProviderVoid)) {
            Block block2;
            if ((this.rand.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addVelocity(0.0, 1.0, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
                    ++this.numSpecialMinions;
                } else if (this.numMinions < this.getMinionCap()) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(0);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    entitychicken.addVelocity(0.0, 0.8, 0.0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    ++this.numMinions;
                    if (this.isVillager()) {
                        entitychicken.setVillager(true);
                    }
                    if (this.isChild()) {
                        entitychicken.setChild(true);
                    }
                    block2 = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block2));
                    if (block2 == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addVelocity(0.0, 1.0, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
                    ++this.numSpecialMinions;
                } else if (this.numPriests < this.getPriestCap()) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(1);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    entitychicken.addVelocity(0.0, 0.8, 0.0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    ++this.numPriests;
                    if (this.isVillager()) {
                        entitychicken.setVillager(true);
                    }
                    if (this.isChild()) {
                        entitychicken.setChild(true);
                    }
                    block2 = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block2));
                    if (block2 == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addVelocity(0.0, 1.0, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
                    ++this.numSpecialMinions;
                } else if (this.numZealots < this.getZealotCap()) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(2);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    entitychicken.addVelocity(0.0, 0.8, 0.0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    ++this.numZealots;
                    if (this.isVillager()) {
                        entitychicken.setVillager(true);
                    }
                    if (this.isChild()) {
                        entitychicken.setChild(true);
                    }
                    block2 = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block2));
                    if (block2 == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addVelocity(0.0, 1.0, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
                    ++this.numSpecialMinions;
                } else if (this.numBishop < this.getBishopCap()) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(3);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    entitychicken.addVelocity(0.0, 0.8, 0.0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    ++this.numBishop;
                    if (this.isVillager()) {
                        entitychicken.setVillager(true);
                    }
                    if (this.isChild()) {
                        entitychicken.setChild(true);
                    }
                    block2 = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block2));
                    if (block2 == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addVelocity(0.0, 1.0, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
                    ++this.numSpecialMinions;
                } else if (this.numTemplar < this.getTemplarCap()) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(4);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    entitychicken.addVelocity(0.0, 0.8, 0.0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    ++this.numTemplar;
                    if (this.isVillager()) {
                        entitychicken.setVillager(true);
                    }
                    if (this.isChild()) {
                        entitychicken.setChild(true);
                    }
                    block2 = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block2));
                    if (block2 == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                    }
                }
            }
        }
        super.onLivingUpdate();
    }

    @Override
    protected void updateAITasks() {
        List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox);
        if (list11 != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (!(entity instanceof EntityLivingBase) || !entity.onGround || entity instanceof EntityTitan || !this.isEntityAlive() || this.isStunned) continue;
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                entity.attackEntityFrom(DamageSourceExtra.causeSquishingDamage((Entity)this), f / 2.0f);
            }
        }
        super.updateAITasks();
    }

    protected String getLivingSound() {
        if (!this.getWaiting() && this.animID != 13) {
            this.playSound("mob.zombie.say", this.getSoundVolume(), this.getSoundPitch() - 0.6f);
        }
        return this.getWaiting() || this.animID == 13 ? null : "thetitans:titanZombieLiving";
    }

    @Override
    protected String getHurtSound() {
        this.playSound("mob.zombie.hurt", this.getSoundVolume(), this.getSoundPitch() - 0.6f);
        return "thetitans:titanZombieGrunt";
    }

    @Override
    protected String getDeathSound() {
        this.playSound("mob.zombie.death", this.getSoundVolume(), this.getSoundPitch() - 0.6f);
        return "thetitans:titanZombieDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.playSound("thetitans:titanStep", 10.0f, 1.0f);
        this.shakeNearbyPlayerCameras(4000.0);
        if (!this.getWaiting() && this.animID != 13) {
            float f3 = this.rotationYaw * (float)Math.PI / 180.0f;
            float f11 = MathHelper.sin((float)f3);
            float f4 = MathHelper.cos((float)f3);
            if (this.footID == 0) {
                this.destroyBlocksInAABB(this.leftLeg.boundingBox.offset(0.0, -1.0, 0.0));
                this.collideWithEntities(this.leftLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.leftLeg.boundingBox.expand(1.0, 1.0, 1.0).offset((double)(f11 * 4.0f), 0.0, (double)(f4 * 4.0f))));
                ++this.footID;
            } else {
                this.destroyBlocksInAABB(this.rightLeg.boundingBox.offset(0.0, -1.0, 0.0));
                this.collideWithEntities(this.rightLeg, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rightLeg.boundingBox.expand(1.0, 1.0, 1.0).offset((double)(f11 * 4.0f), 0.0, (double)(f4 * 4.0f))));
                this.footID = 0;
            }
        }
    }

    protected void dropSword() {
        if (this.isArmed() && !this.worldObj.isRemote) {
            EntityItem entityitem;
            int l;
            for (l = 0; l < 16; ++l) {
                this.playSound("random.break", 100.0f, 0.5f);
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 8.0f - 4.0f), this.posY + 32.0 + (double)(this.rand.nextFloat() * 8.0f), this.posZ + (double)(this.rand.nextFloat() * 8.0f - 4.0f), new ItemStack(Items.stick));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 32; ++l) {
                this.playSound("random.break", 100.0f, 0.5f);
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 8.0f - 4.0f), this.posY + 40.0 + (double)(this.rand.nextFloat() * 16.0f), this.posZ + (double)(this.rand.nextFloat() * 8.0f - 4.0f), new ItemStack(Items.iron_ingot));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            this.setArmed(false);
        }
    }

    protected Item getDropItem() {
        return Items.rotten_flesh;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            EntityItem entityitem;
            int l;
            for (int x = 0; x < 16; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.motionY += 1.0;
                entitylargefireball.setXPCount(12000);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            if (this.isArmed()) {
                for (l = 0; l < 16; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.stick));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 32; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.iron_ingot));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
            }
            for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.rotten_flesh));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 32 + this.rand.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.bone));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 32 + this.rand.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.coal));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 32 + this.rand.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.iron_ingot));
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
            for (l = 0; l < 0 + this.rand.nextInt(4 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanItems.harcadium));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            if (this.rand.nextInt(10) == 0) {
                EntityItem entityitem2 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.bedrock));
                entityitem2.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem2);
            }
        }
    }

    protected void dropRareDrop(int p_70600_1_) {
        switch (this.rand.nextInt(3)) {
            case 0: {
                this.dropItem(Items.iron_ingot, 64);
                break;
            }
            case 1: {
                this.dropItem(Items.carrot, 64);
                break;
            }
            case 2: {
                this.dropItem(Items.potato, 64);
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        if (this.isChild()) {
            tagCompound.setBoolean("IsBaby", true);
        }
        if (this.isVillager()) {
            tagCompound.setBoolean("IsVillager", true);
        }
        if (this.isArmed()) {
            tagCompound.setBoolean("IsArmed", true);
        }
        tagCompound.setBoolean("Stunned", this.isStunned);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        if (tagCompund.getBoolean("IsBaby")) {
            this.setChild(true);
        }
        if (tagCompund.getBoolean("IsVillager")) {
            this.setVillager(true);
        }
        if (tagCompund.getBoolean("IsArmed")) {
            this.setArmed(true);
        }
        this.isStunned = tagCompund.getBoolean("Stunned");
    }

    public void onKillEntity(EntityLivingBase entityLivingIn) {
        super.onKillEntity(entityLivingIn);
        if (entityLivingIn instanceof EntityVillager) {
            EntityZombieMinion entityzombie = new EntityZombieMinion(this.worldObj);
            entityzombie.copyLocationAndAnglesFrom((Entity)entityLivingIn);
            this.worldObj.removeEntity((Entity)entityLivingIn);
            entityzombie.onSpawnWithEgg(null);
            entityzombie.setVillager(true);
            if (entityLivingIn.isChild()) {
                entityzombie.setChild(true);
            }
            this.worldObj.spawnEntityInWorld((Entity)entityzombie);
            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        }
    }

    public float getEyeHeight() {
        float f = 27.6f;
        if (this.isChild()) {
            f = 14.8f;
        }
        return f;
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_180482_2_) {
        Calendar calendar;
        IEntityLivingData p_180482_2_1 = super.onSpawnWithEgg(p_180482_2_);
        this.setCanPickUpLoot(true);
        this.setArmed(true);
        this.setWaiting(true);
        if (p_180482_2_1 == null) {
            p_180482_2_1 = new GroupData(this.worldObj.rand.nextFloat() < ForgeModContainer.zombieBabyChance, this.worldObj.rand.nextFloat() < 0.05f, null);
        }
        if (p_180482_2_1 instanceof GroupData) {
            GroupData groupdata = (GroupData)p_180482_2_1;
            if (groupdata.field_142046_b) {
                this.setVillager(true);
            }
            if (groupdata.field_142048_a) {
                this.setChild(true);
            }
        }
        if (this.getEquipmentInSlot(4) == null && (calendar = this.worldObj.getCurrentDate()).get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25f) {
            this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1f ? Blocks.lit_pumpkin : Blocks.pumpkin));
            this.equipmentDropChances[4] = 0.0f;
        }
        return p_180482_2_1;
    }

    public double getYOffset() {
        return super.getYOffset() - 8.0;
    }

    @Override
    public StatBase getAchievement() {
        return TitansAchievments.zombietitan;
    }

    @Override
    protected void inactDeathAction() {
        if (!this.worldObj.isRemote) {
            this.playSound("mob.zombie.death", this.getSoundVolume(), this.getSoundPitch());
            if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(true, 0);
                this.dropEquipment(true, 0);
                this.dropRareDrop(1);
            }
            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
            entitytitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(6);
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
        if (this.deathTicks >= 80 && this.isArmed()) {
            this.dropSword();
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

    public boolean attackZombieFrom(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 4.0f;
        }
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (this.isArmed() && source.getEntity() instanceof EntityPlayer) {
            return false;
        }
        if (this.isArmored() && source instanceof EntityDamageSourceIndirect) {
            return false;
        }
        if (source.getEntity() instanceof EntityZombieMinion || source.getEntity() instanceof EntityZombieTitan || source.getEntity() instanceof EntityGiantZombieBetter) {
            return false;
        }
        Entity entity = source.getEntity();
        if (entity instanceof EntityLivingBase && !this.isEntityInvulnerable() && amount > 25.0f) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1 instanceof EntityZombieTitan) {
                    EntityZombieTitan entitypigzombie = (EntityZombieTitan)entity1;
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
        return this.attackZombieFrom(source, amount);
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
        return this.attackZombieFrom(p_82195_1_, p_82195_2_);
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

    class GroupData
    implements IEntityLivingData {
        public boolean field_142048_a = false;
        public boolean field_142046_b = false;

        private GroupData(boolean p_i2348_2_, boolean p_i2348_3_) {
            this.field_142048_a = p_i2348_2_;
            this.field_142046_b = p_i2348_3_;
        }

        GroupData(boolean p_i2349_2_, boolean p_i2349_3_, Object p_i2349_4_) {
            this(p_i2349_2_, p_i2349_3_);
        }
    }
}

