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
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntitySmallFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
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
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack1;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack2;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack3;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack4;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack5;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack6;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanCreation;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanDeath;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanLightningAttack;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanRangedAttack;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanRoar;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanStun;
import net.minecraft.entity.titanminion.EntityGhastGuard;
import net.minecraft.entity.titanminion.EntityGhastGuardFireball;
import net.minecraft.entity.titanminion.EntityPigZombieMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityPigZombieTitan
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

    public EntityPigZombieTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0f, 8.0f);
        this.body = new EntityTitanPart(worldIn, this, "body", 8.0f, 12.0f);
        this.rightArm = new EntityTitanPart(worldIn, this, "rightarm", 4.0f, 4.0f);
        this.leftArm = new EntityTitanPart(worldIn, this, "leftarm", 4.0f, 4.0f);
        this.rightLeg = new EntityTitanPart(worldIn, this, "rightleg", 4.0f, 12.0f);
        this.leftLeg = new EntityTitanPart(worldIn, this, "leftleg", 4.0f, 12.0f);
        this.partArray = new EntityTitanPart[]{this.head, this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg};
        this.shouldParticlesBeUpward = true;
        this.experienceValue = 100000;
        this.setSize(8.0f, 32.0f);
        this.meleeTitan = true;
        this.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        this.worldObj.spawnEntityInWorld((Entity)this.head);
        this.worldObj.spawnEntityInWorld((Entity)this.body);
        this.worldObj.spawnEntityInWorld((Entity)this.rightArm);
        this.worldObj.spawnEntityInWorld((Entity)this.leftArm);
        this.worldObj.spawnEntityInWorld((Entity)this.rightLeg);
        this.worldObj.spawnEntityInWorld((Entity)this.leftLeg);
    }

    @Override
    protected void applyEntityAI() {
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanCreation(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanRangedAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanRoar(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanDeath(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanAttack4(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanStun(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanAttack3(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanAttack2(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanLightningAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanAntiTitanAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanAttack1(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanAttack6(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationPigZombieTitanAttack5(this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.PigZombieTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(12, (Object)Byte.valueOf((byte)0));
    }

    @Override
    public double getSpeed() {
        return this.isChild() ? 0.9 + (double)this.getExtraPower() * 0.001 : 0.6 + (double)this.getExtraPower() * 0.001;
    }

    public boolean isArmored() {
        return this.getHealth() <= this.getMaxHealth() / 4.0f || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    public boolean isChild() {
        return this.getDataWatcher().getWatchableObjectByte(12) == 1;
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
        return this.animID == 11 && this.animTick > 80 ? 32 : 16;
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

    @Override
    public int getFootStepModifer() {
        return 5;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        if (this.isChild()) {
            tagCompound.setBoolean("IsBaby", true);
        }
        tagCompound.setBoolean("Stunned", this.isStunned);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        if (tagCompund.getBoolean("IsBaby")) {
            this.setChild(true);
        }
        this.isStunned = tagCompund.getBoolean("Stunned");
    }

    @Override
    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.AVERAGE;
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != ((Object)((Object)this.head)).getClass() && p_70686_1_ != ((Object)((Object)this.body)).getClass() && p_70686_1_ != ((Object)((Object)this.rightArm)).getClass() && p_70686_1_ != ((Object)((Object)this.leftArm)).getClass() && p_70686_1_ != ((Object)((Object)this.rightLeg)).getClass() && p_70686_1_ != ((Object)((Object)this.leftLeg)).getClass() && p_70686_1_ != EntityPigZombieMinion.class && p_70686_1_ != EntityGhastGuard.class && p_70686_1_ != EntityPigZombieTitan.class;
    }

    @Override
    public void onLivingUpdate() {
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
                this.playSound("thetitans:titanPigZombieLiving", this.getSoundVolume(), 0.8f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 40) {
                this.playSound("thetitans:titanRumble", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 240) {
                this.playSound("thetitans:titanZombieRoar", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 130) {
                this.playSound("thetitans:titanSkeletonGetUp", this.getSoundVolume(), 1.0f);
            }
            if (this.getAnimID() == 13 && (this.getAnimTick() == 110 || this.getAnimTick() == 150 || this.getAnimTick() == 170)) {
                this.func_145780_a(0, 0, 0, Blocks.stone);
                this.playSound("thetitans:titanPress", this.getSoundVolume(), 1.0f);
            }
        }
        if (this.worldObj.isRemote && this.deathTicks < this.getThreashHold() && this.isWet()) {
            for (int i = 0; i < this.getParticleCount() * 50; ++i) {
                this.worldObj.spawnParticle(this.getParticles(), this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.25, 0.0);
            }
        }
        if (this.rand.nextInt(40) == 0 && this.isWet()) {
            this.playSound("random.fizz", 20.0f, 1.5f);
        }
        if (this.animID == 8) {
            if (this.animTick == 140 || this.animTick == 300 || this.animTick == 330) {
                this.playSound("thetitans:slashFlesh", 20.0f, 1.0f);
                this.attackEntityFromPart(this.head, new DamageSource("other").setDamageBypassesArmor().setDamageIsAbsolute(), 1000.0f);
            }
            if (this.animTick == 400) {
                this.playSound("thetitans:titanZombieRoar", 1000.0f, 0.95f);
            }
            if (this.animTick == 530) {
                this.isStunned = false;
            } else {
                this.setAttackTarget(null);
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
        if (this.rand.nextInt(200) == 0 && this.animID == 0 && this.getAttackTarget() != null && this.onGround && this.getDistanceSqToEntity((Entity)this.getAttackTarget()) > 512.0) {
            this.jump();
            this.playSound(this.getHurtSound(), this.getSoundVolume(), this.getSoundPitch());
        }
        if (this.getAnimID() == 7 && this.getAnimTick() == 122) {
            int z;
            double d8 = 32.0;
            Vec3 vec3 = this.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            int y = MathHelper.floor_double((double)this.posY);
            int x = MathHelper.floor_double((double)(this.posX + dx));
            if (this.worldObj.getBlock(x, y - 1, z = MathHelper.floor_double((double)(this.posZ + dz))).getMaterial() != Material.air) {
                this.playSound("thetitans:titanStrike", 20.0f, 1.0f);
                this.playSound("thetitans:titanSlam", 20.0f, 1.0f);
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
                        if (!(block.getExplosionResistance((Entity)this) <= 1.5f) || !block.isOpaqueCube() || block == Blocks.air || block == Blocks.netherrack || block == Blocks.dirt || block == Blocks.grass || block == Blocks.glass || block == Blocks.glass_pane) continue;
                        AnimationAPI.sendAnimPacket(this, 8);
                        this.setAnimID(8);
                        this.setAnimTick(0);
                        this.playSound("random.anvil_land", 20.0f, 0.5f);
                        if (this.worldObj.isRemote) continue;
                        this.isStunned = true;
                    }
                }
            }
        }
        float f = this.renderYawOffset * (float)Math.PI / 180.0f;
        f1 = MathHelper.sin((float)f);
        f2 = MathHelper.cos((float)f);
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
        this.meleeTitan = true;
        if (this.getAnimID() == 5) {
            if (this.getAnimTick() == 34) {
                this.playSound("thetitans:lightningCharge", 100.0f, 1.0f);
            }
            if (this.getAnimTick() <= 50 && this.getAnimTick() >= 20) {
                float ex = this.isChild() ? 4.5f : 9.5f;
                float fl = this.renderYawOffset * (float)Math.PI / 180.0f;
                float fl1 = MathHelper.sin((float)fl);
                float fl2 = MathHelper.cos((float)fl);
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX - (double)(fl2 * ex), this.posY + (this.isChild() ? 12.0 : 24.0), this.posZ - (double)(fl1 * ex), 1.0f, 0.0f, 0.0f));
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + (double)(fl2 * ex), this.posY + (this.isChild() ? 12.0 : 24.0), this.posZ + (double)(fl1 * ex), 1.0f, 0.0f, 0.0f));
                if (this.getAttackTarget() == null && !this.worldObj.isRemote) {
                    this.heal(50.0f);
                }
            }
            if (this.getAnimTick() == 64) {
                this.playSound("thetitans:lightningThrow", 100.0f, 1.0f);
                double d8 = this.isChild() ? 6.0 : 12.0;
                Vec3 vec3 = this.getLook(1.0f);
                double dx = vec3.xCoord * d8;
                double dz = vec3.zCoord * d8;
                float da = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                int i1 = this.getKnockbackAmount();
                this.worldObj.newExplosion((Entity)this, this.posX + dx, this.posY + 26.0, this.posZ + dz, 1.0f, false, false);
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + (this.isChild() ? 9.0 : 18.0), this.posZ + dz, 1.0f, 0.0f, 0.0f));
                if (this.getAttackTarget() != null) {
                    this.attackChoosenEntity((Entity)this.getAttackTarget(), da, i1);
                    this.attackChoosenEntity((Entity)this.getAttackTarget(), da, i1);
                    this.attackChoosenEntity((Entity)this.getAttackTarget(), da, i1);
                    this.getAttackTarget().motionY += (double)(1.0f + this.rand.nextFloat());
                    this.worldObj.newExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 2.0f, false, false);
                    this.getAttackTarget().attackEntityFrom(DamageSourceExtra.lightningBolt, f);
                    this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1.0f, 0.0f, 0.0f));
                    List list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getAttackTarget(), this.getAttackTarget().boundingBox.expand(12.0, 12.0, 12.0));
                    if (list1 != null && !list1.isEmpty()) {
                        for (int i11 = 0; i11 < list1.size(); ++i11) {
                            Entity entity1 = (Entity)list1.get(i11);
                            if (!(entity1 instanceof EntityLivingBase) || !this.canAttackClass(entity1.getClass())) continue;
                            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, entity1.posX, entity1.posY, entity1.posZ, 1.0f, 0.0f, 0.0f));
                            this.attackChoosenEntity(entity1, da, i1);
                            this.attackChoosenEntity(entity1, da, i1);
                            if (entity1 instanceof EntityTitan) continue;
                            entity1.motionY += (double)(1.0f + this.rand.nextFloat());
                        }
                    }
                    for (int it = 0; it < 300; ++it) {
                        Vec3 vec31 = this.getLook(1.0f);
                        double d5 = this.getAttackTarget().posX + this.rand.nextGaussian() * 8.0 - (this.head.posX + vec31.xCoord * (16.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f)));
                        double d6 = this.getAttackTarget().posY + this.rand.nextGaussian() * 8.0 - (this.head.posY + 32.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f));
                        double d7 = this.getAttackTarget().posZ + this.rand.nextGaussian() * 8.0 - (this.head.posZ + vec31.zCoord * (16.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f)));
                        EntityGhastGuardFireball entitylargefireball = new EntityGhastGuardFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7);
                        entitylargefireball.posX = this.head.posX + vec31.xCoord * (16.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f));
                        entitylargefireball.posY = this.head.posY + 32.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f);
                        entitylargefireball.posZ = this.head.posZ + vec31.zCoord * (16.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f));
                        this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
                        EntityTitanFireball entitylargefireball1 = new EntityTitanFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7, 3);
                        entitylargefireball1.posX = this.head.posX + vec31.xCoord * (16.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f));
                        entitylargefireball1.posY = this.head.posY + 32.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f);
                        entitylargefireball1.posZ = this.head.posZ + vec31.zCoord * (16.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f));
                        this.worldObj.spawnEntityInWorld((Entity)entitylargefireball1);
                        entitylargefireball1.setFireballID(3);
                        EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7);
                        entitysmallfireball.posX = this.head.posX + vec31.xCoord * (16.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f));
                        entitysmallfireball.posY = this.head.posY + 32.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f);
                        entitysmallfireball.posZ = this.head.posZ + vec31.zCoord * (16.0 + (double)((this.getRNG().nextFloat() * 2.0f - 1.0f) * 16.0f));
                        this.worldObj.spawnEntityInWorld((Entity)entitysmallfireball);
                    }
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
                if (this.getAttackTarget() instanceof EntityTitan || this.getAttackTarget().height >= 6.0f || this.getAttackTarget().posY > this.posY + 6.0) {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                } else {
                    switch (this.rand.nextInt(7)) {
                        case 0: {
                            AnimationAPI.sendAnimPacket(this, 11);
                            this.setAnimID(11);
                            break;
                        }
                        case 1: {
                            AnimationAPI.sendAnimPacket(this, 3);
                            this.setAnimID(3);
                            break;
                        }
                        case 2: {
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                            break;
                        }
                        case 3: {
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                            break;
                        }
                        case 4: {
                            AnimationAPI.sendAnimPacket(this, 7);
                            this.setAnimID(7);
                            break;
                        }
                        case 5: {
                            AnimationAPI.sendAnimPacket(this, 9);
                            this.setAnimID(9);
                            break;
                        }
                        case 6: {
                            AnimationAPI.sendAnimPacket(this, 2);
                            this.setAnimID(2);
                        }
                    }
                }
            } else if (this.getAnimID() == 0 && this.getRNG().nextInt(100) == 0) {
                switch (this.rand.nextInt(3)) {
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
                    }
                }
            }
        }
        if (this.animID == 1 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.getRNG().nextInt(4);
        }
        if (this.getAnimID() == 12 && this.getAttackTarget() != null && this.getAnimTick() == 55) {
            for (int i = 0; i < 4 + 2 * this.worldObj.difficultySetting.getDifficultyId(); ++i) {
                this.attackEntityWithRangedAttack(this.getAttackTarget(), 0.0f);
            }
        }
        if (this.rand.nextInt(20) == 0 && this.getAttackTarget() != null) {
            this.playSound("mob.zombiepig.zpigangry", 10000.0f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * (0.6f + this.rand.nextFloat()));
        }
        if (this.isChild()) {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.PigZombieTitan.name.baby"));
        } else {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.PigZombieTitan.name"));
        }
        if (TheTitans.NightmareMode) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1800.0 + (double)(this.getExtraPower() * 180));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40000.0 + (double)(this.getExtraPower() * 2000));
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(600.0 + (double)(this.getExtraPower() * 60));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20000.0 + (double)(this.getExtraPower() * 1000));
        }
        if (!this.getWaiting() && this.animID != 13 && !(this.worldObj.provider instanceof WorldProviderVoid)) {
            if ((this.rand.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addVelocity(0.0, 1.5, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
                    ++this.numSpecialMinions;
                } else if (this.numMinions < this.getMinionCap()) {
                    EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(0);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    entitychicken.addVelocity(0.0, 0.8, 0.0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    if (this.isChild()) {
                        entitychicken.setChild(true);
                    }
                    ++this.numMinions;
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addVelocity(0.0, 1.5, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
                    ++this.numSpecialMinions;
                } else if (this.numPriests < this.getPriestCap()) {
                    EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(1);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    entitychicken.addVelocity(0.0, 0.8, 0.0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    if (this.isChild()) {
                        entitychicken.setChild(true);
                    }
                    ++this.numPriests;
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addVelocity(0.0, 1.5, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
                    ++this.numSpecialMinions;
                } else if (this.numZealots < this.getZealotCap()) {
                    EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(2);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    entitychicken.addVelocity(0.0, 0.8, 0.0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    if (this.isChild()) {
                        entitychicken.setChild(true);
                    }
                    ++this.numZealots;
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addVelocity(0.0, 1.5, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
                    ++this.numSpecialMinions;
                } else if (this.numBishop < this.getBishopCap()) {
                    EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(3);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    entitychicken.addVelocity(0.0, 0.8, 0.0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    if (this.isChild()) {
                        entitychicken.setChild(true);
                    }
                    ++this.numBishop;
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                    }
                }
            }
            if ((this.rand.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.rand.nextInt(100) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.addVelocity(0.0, 1.5, 0.0);
                    entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
                    ++this.numSpecialMinions;
                } else if (this.numTemplar < this.getTemplarCap()) {
                    EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.worldObj);
                    this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                    entitychicken.master = this;
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(4);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                    entitychicken.addVelocity(0.0, 0.8, 0.0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    entitychicken.playSound("thetitans:titansummonminion", 2.0f, 1.0f);
                    entitychicken.addPotionEffect(new PotionEffect(Potion.fireResistance.id, Integer.MAX_VALUE, 0, false));
                    if (this.isChild()) {
                        entitychicken.setChild(true);
                    }
                    ++this.numTemplar;
                    Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ);
                    this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                    if (block == Blocks.grass) {
                        this.worldObj.setBlock((int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Blocks.dirt);
                    }
                }
            }
        }
        super.onLivingUpdate();
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
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(100) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.PigZombieTitanMinionSpawnrate;
    }

    @Override
    public int getRegenTime() {
        return 5;
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
    public boolean canBeHurtByPlayer() {
        return this.isStunned && !this.isEntityInvulnerable();
    }

    @Override
    public String getParticles() {
        if ((double)this.worldObj.rand.nextFloat() < 0.25) {
            return "explode";
        }
        return "smoke";
    }

    public boolean isEntityUndead() {
        return true;
    }

    @Override
    protected void fall(float p_70069_1_) {
        super.fall(p_70069_1_);
        if (!this.worldObj.isRemote) {
            this.addRandomArmor();
        }
    }

    public float getEyeHeight() {
        float f = 27.6f;
        if (this.isChild()) {
            f = 14.8f;
        }
        return f;
    }

    protected String getLivingSound() {
        return this.isStunned || this.getWaiting() || this.animID == 13 ? null : "thetitans:titanPigZombieLiving";
    }

    @Override
    protected String getHurtSound() {
        return "thetitans:titanPigZombieGrunt";
    }

    @Override
    protected String getDeathSound() {
        return "thetitans:titanPigZombieDeath";
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

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            EntityItem entityitem;
            int l;
            for (int x = 0; x < 24; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.motionY += 1.0;
                entitylargefireball.setXPCount(20000);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            for (l = 0; l < 16; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.stick));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 32; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.gold_ingot));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.rotten_flesh));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.gold_nugget));
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
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.gold_ingot));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 12 + this.rand.nextInt(12 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.emerald));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 12 + this.rand.nextInt(12 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.diamond));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 0 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanItems.harcadium));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            if (this.rand.nextInt(5) == 0) {
                EntityItem entityitem2 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.bedrock));
                entityitem2.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem2);
            }
            if (this.rand.nextInt(5) == 0) {
                EntityItem entityitem3 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.bedrock));
                entityitem3.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem3);
            }
        }
    }

    @Override
    public StatBase getAchievement() {
        return TitansAchievments.pigzombietitan;
    }

    public double getYOffset() {
        return super.getYOffset() - 8.0;
    }

    protected void dropRareDrop(int p_70600_1_) {
        this.entityDropItem(new ItemStack(Blocks.gold_block, 64, 1), 0.0f);
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
        for (int i = 0; i < 2; ++i) {
            EntityGhastGuard entitychicken = new EntityGhastGuard(this.worldObj);
            entitychicken.master = this;
            entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            entitychicken.onSpawnWithEgg(null);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            entitychicken.addVelocity(0.0, 1.5, 0.0);
            entitychicken.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
        }
    }

    public boolean attackZombieFrom(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 3.0f;
        }
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (!this.isStunned && source.getEntity() instanceof EntityPlayer) {
            return false;
        }
        if (source.getEntity() instanceof EntityPigZombieMinion || source.getEntity() instanceof EntityPigZombieTitan || source.getEntity() instanceof EntityGhastGuard) {
            return false;
        }
        Entity entity = source.getEntity();
        if (entity instanceof EntityLivingBase && !this.isEntityInvulnerable() && amount > 25.0f) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1 instanceof EntityPigZombieTitan) {
                    EntityPigZombieTitan entitypigzombie = (EntityPigZombieTitan)entity1;
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
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_180482_2_) {
        Calendar calendar;
        IEntityLivingData p_180482_2_1 = super.onSpawnWithEgg(p_180482_2_);
        this.setCanPickUpLoot(true);
        this.setWaiting(true);
        if (this.worldObj.rand.nextFloat() < 0.05f) {
            this.setChild(true);
        }
        this.addRandomArmor();
        this.enchantEquipment();
        if (this.getEquipmentInSlot(4) == null && (calendar = this.worldObj.getCurrentDate()).get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25f) {
            this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1f ? Blocks.lit_pumpkin : Blocks.pumpkin));
            this.equipmentDropChances[4] = 0.0f;
        }
        return p_180482_2_1;
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
    protected void inactDeathAction() {
        if (!this.worldObj.isRemote) {
            this.playSound("mob.zombiepig.zpigdeath", this.getSoundVolume(), this.getSoundPitch());
            if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(true, 0);
                this.dropEquipment(true, 0);
                this.dropRareDrop(1);
            }
            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
            entitytitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(8);
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
                AnimationAPI.sendAnimPacket(this, 0);
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
}

