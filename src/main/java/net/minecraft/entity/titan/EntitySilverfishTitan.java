/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.block.Block
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
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
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
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.IEntityMultiPartTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishAntiTitanAttack;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishAttack1;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishAttack2;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishAttack3;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishBodySlam;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishBurrow;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishCreation;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishDeath;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishLightningAttack;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishStunned;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishTailSmash;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishUnburrow;
import net.minecraft.entity.titanminion.EntitySilverfishMinion;
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
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntitySilverfishTitan
extends EntityTitan
implements IAnimatedEntity,
IEntityMultiPartTitan {
    public boolean isSubdued;
    public boolean isBurrowing;
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart body;
    public EntityTitanPart tailbase;
    public EntityTitanPart tail1;
    public EntityTitanPart tail2;
    public EntityTitanPart tailtip;

    public EntitySilverfishTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 3.0f, 2.0f);
        this.body = new EntityTitanPart(worldIn, this, "body", 5.0f, 4.0f);
        this.tailbase = new EntityTitanPart(worldIn, this, "tailbase", 3.0f, 3.0f);
        this.tail1 = new EntityTitanPart(worldIn, this, "tail1", 3.0f, 2.0f);
        this.tail2 = new EntityTitanPart(worldIn, this, "tail2", 2.0f, 1.0f);
        this.tailtip = new EntityTitanPart(worldIn, this, "tailtip", 2.0f, 1.0f);
        this.partArray = new EntityTitanPart[]{this.head, this.body, this.tailbase, this.tail1, this.tail2, this.tailtip};
        this.setSize(9.0f, 6.0f);
        this.experienceValue = 6000 + this.getExtraPower() * 200;
        this.worldObj.spawnEntityInWorld((Entity)this.head);
        this.worldObj.spawnEntityInWorld((Entity)this.body);
        this.worldObj.spawnEntityInWorld((Entity)this.tailbase);
        this.worldObj.spawnEntityInWorld((Entity)this.tail1);
        this.worldObj.spawnEntityInWorld((Entity)this.tail2);
        this.worldObj.spawnEntityInWorld((Entity)this.tailtip);
    }

    @Override
    protected void applyEntityAI() {
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishCreation(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishDeath(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishStunned(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishAntiTitanAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishBodySlam(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishTailSmash(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishLightningAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishAttack2(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishAttack3(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishAttack1(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishUnburrow(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationOmegafishBurrow(this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (!this.isSubdued) {
            if (TheTitans.TitansFFAMode) {
                this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SilverfishTitanSorter));
            } else {
                this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
            }
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.isStunned = tagCompund.getBoolean("Stunned");
        this.isBurrowing = tagCompund.getBoolean("Burrowing");
        this.isSubdued = tagCompund.getBoolean("Subdued");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("Stunned", this.isStunned);
        tagCompound.setBoolean("Burrowing", this.isBurrowing);
        tagCompound.setBoolean("Subdued", this.isSubdued);
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != ((Object)((Object)this.head)).getClass() && p_70686_1_ != ((Object)((Object)this.body)).getClass() && p_70686_1_ != ((Object)((Object)this.tailbase)).getClass() && p_70686_1_ != ((Object)((Object)this.tail1)).getClass() && p_70686_1_ != ((Object)((Object)this.tail2)).getClass() && p_70686_1_ != ((Object)((Object)this.tailtip)).getClass() && p_70686_1_ != EntitySilverfishMinion.class && p_70686_1_ != EntitySilverfishTitan.class;
    }

    public boolean isArmored() {
        return this.getHealth() <= this.getMaxHealth() / 4.0f || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    @Override
    public int getMinionCap() {
        return 240;
    }

    @Override
    public int getPriestCap() {
        return 120;
    }

    @Override
    public int getZealotCap() {
        return 60;
    }

    @Override
    public int getTemplarCap() {
        return 8;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(10) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.OmegafishMinionSpawnrate;
    }

    public float getEyeHeight() {
        return 2.0f;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
    }

    protected String getLivingSound() {
        return this.isStunned || this.getWaiting() || this.animID == 2 ? null : "thetitans:titanSilverfishLiving";
    }

    @Override
    protected String getHurtSound() {
        return "thetitans:titanSilverfishGrunt";
    }

    @Override
    protected String getDeathSound() {
        return "thetitans:titanSilverfishDeath";
    }

    protected Item getDropItem() {
        return Items.paper;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            EntityItem entityitem;
            int l;
            for (int x = 0; x < 6; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.motionY += 1.0;
                entitylargefireball.setXPCount(3000);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            for (l = 0; l < 96 + this.rand.nextInt(96 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.paper));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 32 + this.rand.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.coal));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 4 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.emerald));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 4 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.diamond));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 16 + this.rand.nextInt(48 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.cobblestone));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 16 + this.rand.nextInt(48 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.stone));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 0 + this.rand.nextInt(48 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.mossy_cobblestone));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 0 + this.rand.nextInt(32 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.stonebrick));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 4 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.monster_egg));
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

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    @Override
    public boolean canBeHurtByPlayer() {
        return this.isStunned && !this.isBurrowing && !this.isEntityInvulnerable();
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        return false;
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public boolean shouldMove() {
        return this.getAnimID() == 0 && !this.isStunned && this.getAttackTarget() != null ? super.shouldMove() : false;
    }

    @Override
    public double getSpeed() {
        return this.isBurrowing ? 0.9 + (double)this.getExtraPower() * 0.001 : 0.7 + (double)this.getExtraPower() * 0.001;
    }

    @Override
    public double getMeleeRange() {
        return (double)(this.width * this.width + (this.getAttackTarget().width > 48.0f ? 2304.0f : this.getAttackTarget().width * this.getAttackTarget().width)) + 100.0;
    }

    @Override
    public void onLivingUpdate() {
        EntityPlayer player;
        float f2;
        float f1;
        if (!this.getWaiting() && this.animID != 0 && this.deathTicks < this.getThreashHold() && this.isArmored() && this.isEntityAlive()) {
            ++this.animTick;
        }
        if (!(this.isRiding() || this.isBurrowing || this.getWaiting() || this.isStunned || this.animID != 0)) {
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
            EntityPlayer player2 = this.worldObj.getClosestPlayerToEntity((Entity)this, 24.0);
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
            if (this.getAnimID() == 13 && this.getAnimTick() == 10) {
                this.playSound("thetitans:titanSilverfishLiving", this.getSoundVolume(), 0.7f);
            }
            if (this.getAnimID() == 13 && this.getAnimTick() == 150) {
                this.playSound("thetitans:titanPress", this.getSoundVolume(), 1.0f);
                this.shakeNearbyPlayerCameras(4000.0);
            }
        }
        if (!this.isBurrowing && !this.isStunned && this.animID != 2 && this.animID != 9 && this.getAttackTarget() != null && this.getDistanceSqToEntity((Entity)this.getAttackTarget()) > 4000.0) {
            if (this.posY <= this.getAttackTarget().posY + 24.0) {
                this.motionY += 0.9 - this.motionY;
                if (this.motionY < 0.0) {
                    this.motionY = 0.0;
                }
            }
            this.motionY *= 0.9;
        }
        if (!this.isBurrowing && !this.onGround) {
            float f = (this.rand.nextFloat() - 0.5f) * 8.0f;
            f1 = (this.rand.nextFloat() - 0.5f) * 1.0f;
            f2 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle("largeexplode", this.posX + (double)f, this.posY + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        }
        if (this.isSubdued) {
            this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
        }
        if ((player = this.worldObj.getClosestPlayerToEntity((Entity)this.head, 4.0)) != null && this.head.posY < player.posY - 2.0) {
            this.rotationYawHead += MathHelper.sin((float)this.ticksExisted) * 40.0f;
            this.rotationPitch -= MathHelper.cos((float)this.ticksExisted) * 40.0f;
        }
        if (this.animID == 1) {
            this.isBurrowing = true;
        } else if (this.animID == 2) {
            this.isBurrowing = false;
        }
        if (this.isBurrowing) {
            this.destroyBlocksInAABB(this.boundingBox.expand(2.0, 0.0, 2.0));
            this.worldObj.playAuxSFX(2006, MathHelper.floor_double((double)this.posX), MathHelper.floor_double((double)(this.posY - (double)0.2f - (double)this.yOffset)), MathHelper.floor_double((double)this.posZ), MathHelper.ceiling_float_int((float)128.0f));
            if (this.ticksExisted % 40 == 0) {
                this.playSound("thetitans:titanRumble", 10.0f, 1.0f);
                this.playSound("thetitans:titanRumble", 9.0f, 1.0f);
                this.playSound("thetitans:titanRumble", 8.0f, 1.0f);
                this.playSound("thetitans:titanRumble", 7.0f, 1.0f);
                this.playSound("thetitans:titanRumble", 6.0f, 1.0f);
                this.playSound("thetitans:titanQuake", 5.0f, 1.0f);
                this.playSound("thetitans:titanQuake", 4.0f, 1.0f);
                this.playSound("thetitans:titanQuake", 3.0f, 1.0f);
                this.playSound("thetitans:titanQuake", 2.0f, 1.0f);
                this.playSound("thetitans:titanQuake", 1.0f, 1.0f);
            }
        }
        if (this.isSubdued && this.ticksExisted % 40 == 0) {
            this.targetTasks.removeTask((EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
            this.targetTasks.removeTask((EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
            this.targetTasks.removeTask((EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        }
        this.setSize(9.0f, 6.0f);
        if (this.getAnimID() == 7 && this.getAnimTick() == 20) {
            double d8 = -3.0;
            Vec3 vec3 = this.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.getKnockbackAmount();
            this.worldObj.newExplosion((Entity)this, this.posX + dx, this.posY + 8.0, this.posZ + dz, 1.0f, false, false);
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX + dx, this.posY + 8.0, this.posZ + dz, 0.5f, 0.5f, 0.5f));
            if (this.getAttackTarget() != null) {
                this.attackChoosenEntity((Entity)this.getAttackTarget(), f, i);
                this.getAttackTarget().motionY += 2.0;
                this.worldObj.newExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 2.0f, false, false);
                this.getAttackTarget().attackEntityFrom(DamageSourceExtra.lightningBolt, f);
                this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 0.25f, 0.25f, 0.25f));
                List list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.getAttackTarget(), this.getAttackTarget().boundingBox.expand(2.0, 2.0, 2.0));
                if (list1 != null && !list1.isEmpty()) {
                    for (int i1 = 0; i1 < list1.size(); ++i1) {
                        Entity entity1 = (Entity)list1.get(i1);
                        if (!(entity1 instanceof EntityLivingBase) || entity1 instanceof EntitySilverfishMinion || entity1 instanceof EntitySilverfishTitan) continue;
                        this.attackChoosenEntity(entity1, f, i);
                        entity1.motionY += 1.0;
                    }
                }
            }
        }
        this.meleeTitan = true;
        if (this.isBurrowing) {
            this.destroyBlocksInAABB(this.boundingBox.expand(1.0, 0.0, 1.0));
        }
        if (this.ticksExisted > 5) {
            float f = this.renderYawOffset * (float)Math.PI / 180.0f;
            float f12 = MathHelper.sin((float)f);
            float f22 = MathHelper.cos((float)f);
            this.head.setLocationAndAngles(this.posX - (double)(MathHelper.sin((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 3.0f), this.posY - (double)(MathHelper.sin((float)(this.rotationPitch * (float)Math.PI / 180.0f)) * 2.0f), this.posZ + (double)(MathHelper.cos((float)(this.rotationYawHead * (float)Math.PI / 180.0f)) * 3.0f), 0.0f, 0.0f);
            this.body.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
            this.tailbase.setLocationAndAngles(this.posX + (double)f12 * 4.0, this.posY, this.posZ - (double)f22 * 4.0, 0.0f, 0.0f);
            this.tail1.setLocationAndAngles(this.posX + (double)f12 * 7.0, this.posY, this.posZ - (double)f22 * 7.0, 0.0f, 0.0f);
            this.tail2.setLocationAndAngles(this.posX + (double)f12 * 9.5, this.posY, this.posZ - (double)f22 * 9.5, 0.0f, 0.0f);
            this.tailtip.setLocationAndAngles(this.posX + (double)f12 * 11.5, this.posY, this.posZ - (double)f22 * 11.5, 0.0f, 0.0f);
            if (this.isEntityAlive() && !this.isStunned) {
                this.collideWithEntities(this.head, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.head.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.body, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.head.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.tailbase, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.tailbase.boundingBox));
                this.collideWithEntities(this.tail1, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.tail1.boundingBox));
                this.collideWithEntities(this.tail2, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.tail2.boundingBox));
                this.collideWithEntities(this.tailtip, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.tailtip.boundingBox));
            }
            this.destroyBlocksInAABB(this.head.boundingBox);
            this.destroyBlocksInAABB(this.body.boundingBox);
            this.destroyBlocksInAABB(this.tailbase.boundingBox);
            this.destroyBlocksInAABB(this.tail1.boundingBox);
            this.destroyBlocksInAABB(this.tail2.boundingBox);
            this.destroyBlocksInAABB(this.tailtip.boundingBox);
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
        if (this.isStunned) {
            this.setAttackTarget(null);
            AnimationAPI.sendAnimPacket(this, 8);
        }
        if (this.animID == 11 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.getRNG().nextInt(4);
        }
        if (!AnimationAPI.isEffectiveClient() && this.getAttackTarget() != null && !this.isStunned && this.animID == 0) {
            double d0;
            if (!this.isBurrowing && this.canEntityBeSeen((Entity)this.getAttackTarget())) {
                AnimationAPI.sendAnimPacket(this, 1);
            }
            if ((d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget())) < this.getMeleeRange()) {
                if (this.isBurrowing) {
                    AnimationAPI.sendAnimPacket(this, 2);
                    this.setAnimID(2);
                } else if (this.getAttackTarget() instanceof EntityTitan || this.getAttackTarget().height >= 6.0f || this.getAttackTarget().posY > this.posY + 6.0) {
                    AnimationAPI.sendAnimPacket(this, 11);
                    this.setAnimID(11);
                } else {
                    switch (this.rand.nextInt(5)) {
                        case 0: {
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                            break;
                        }
                        case 1: {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                            break;
                        }
                        case 2: {
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                        }
                    }
                }
            } else {
                int i = 60;
                if (this.isArmored()) {
                    i = 20;
                }
                if (this.animID == 0 && !this.isBurrowing && this.getRNG().nextInt(i) == 0) {
                    if (this.getAttackTarget().posY > this.posY + 12.0) {
                        AnimationAPI.sendAnimPacket(this, 7);
                        this.setAnimID(7);
                    } else {
                        switch (this.rand.nextInt(4)) {
                            case 0: {
                                AnimationAPI.sendAnimPacket(this, 3);
                                this.setAnimID(3);
                                break;
                            }
                            case 1: {
                                AnimationAPI.sendAnimPacket(this, 7);
                                this.setAnimID(7);
                                break;
                            }
                            case 2: {
                                if (!this.isBurrowing) {
                                    AnimationAPI.sendAnimPacket(this, 1);
                                    this.setAnimID(1);
                                    break;
                                }
                                AnimationAPI.sendAnimPacket(this, 3);
                                this.setAnimID(3);
                                break;
                            }
                            case 3: {
                                if (this.getRNG().nextInt(3) == 0) {
                                    AnimationAPI.sendAnimPacket(this, 9);
                                    this.setAnimID(9);
                                    break;
                                }
                                AnimationAPI.sendAnimPacket(this, 3);
                                this.setAnimID(3);
                            }
                        }
                    }
                }
            }
        }
        if (this.isStunned || this.deathTicks > 0) {
            this.motionX *= 0.0;
            this.motionZ *= 0.0;
        }
        if (this.animID == 8) {
            this.setAttackTarget(null);
        }
        if (this.animID == 8) {
            if (this.animTick == 37) {
                this.playSound("thetitans:largeFall", 4.0f, 1.0f);
            }
            if (this.animTick == 37) {
                this.playSound("thetitans:distantLargeFall", 10000.0f, 1.0f);
            }
            if (this.animTick == 380) {
                this.isStunned = false;
            } else {
                this.setAttackTarget(null);
            }
        }
        if (this.animID == 10) {
            if (this.animTick == 74 || this.animTick == 216) {
                this.playSound("thetitans:titanFall", 10.0f, 1.0f);
            }
            if (this.animTick == 76) {
                this.playSound("thetitans:distantLargeFall", 10000.0f, 1.0f);
            }
        }
        if (TheTitans.NightmareMode) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(150.0 + (double)(this.getExtraPower() * 15));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16000.0 + (double)(this.getExtraPower() * 1000));
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0 + (double)(this.getExtraPower() * 5));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8000.0 + (double)(this.getExtraPower() * 500));
        }
        this.setCustomNameTag("\u00a7oOmegafish");
        if (this.rand.nextInt(100) == 0 && this.getAttackTarget() != null && this.animID == 0) {
            this.faceEntity((Entity)this.getAttackTarget(), 180.0f, 180.0f);
            double d0 = this.getAttackTarget().posX - this.posX;
            double d1 = this.getAttackTarget().posZ - this.posZ;
            float f21 = MathHelper.sqrt_double((double)(d0 * d0 + d1 * d1));
            this.motionX = d0 / (double)f21 * 2.0 * 2.0 + this.motionX * 2.0;
            this.motionZ = d1 / (double)f21 * 2.0 * 2.0 + this.motionZ * 2.0;
        }
        if (this.isEntityAlive() && this.rand.nextInt(40) == 0 && this.getAttackTarget() != null && this.isArmored() && !(this.getAttackTarget() instanceof EntityTitan)) {
            this.rotationPitch = -90.0f;
            this.worldObj.newExplosion((Entity)this, this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 2.0f, false, false);
        }
        if (!this.getWaiting() && this.animID != 13 && !(this.worldObj.provider instanceof WorldProviderVoid)) {
            if (this.numMinions < this.getMinionCap() && (this.rand.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.worldObj);
                this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                entitychicken.master = this;
                entitychicken.playSound("thetitans:titansummonminion", 1.0f, 1.0f);
                entitychicken.addVelocity(0.0, 0.5, 0.0);
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
                ++this.numMinions;
                if (this.isSubdued) {
                    entitychicken.isMasterSubdued = true;
                }
                if (this.isSubdued) {
                    entitychicken.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)entitychicken, EntityLivingBase.class, 0, false, true, entitychicken.allowPlayerPresence));
                } else {
                    entitychicken.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)entitychicken, EntityLivingBase.class, 0, false, true, ITitan.SearchForAThingToKill));
                }
            }
            if (this.numPriests < this.getPriestCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.worldObj);
                this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                entitychicken.master = this;
                entitychicken.playSound("thetitans:titansummonminion", 1.0f, 1.0f);
                entitychicken.addVelocity(0.0, 0.5, 0.0);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(1);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ);
                this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                ++this.numMinions;
                if (block == Blocks.grass) {
                    this.worldObj.setBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ, Blocks.dirt);
                }
                ++this.numPriests;
                if (this.isSubdued) {
                    entitychicken.isMasterSubdued = true;
                }
                if (this.isSubdued) {
                    entitychicken.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)entitychicken, EntityLivingBase.class, 0, false, true, entitychicken.allowPlayerPresence));
                } else {
                    entitychicken.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)entitychicken, EntityLivingBase.class, 0, false, true, ITitan.SearchForAThingToKill));
                }
            }
            if (this.numZealots < this.getZealotCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.worldObj);
                this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                entitychicken.master = this;
                entitychicken.playSound("thetitans:titansummonminion", 1.0f, 1.0f);
                entitychicken.addVelocity(0.0, 0.5, 0.0);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(2);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ);
                this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                ++this.numMinions;
                if (block == Blocks.grass) {
                    this.worldObj.setBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ, Blocks.dirt);
                }
                ++this.numZealots;
                if (this.isSubdued) {
                    entitychicken.isMasterSubdued = true;
                }
                if (this.isSubdued) {
                    entitychicken.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)entitychicken, EntityLivingBase.class, 0, false, true, entitychicken.allowPlayerPresence));
                } else {
                    entitychicken.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)entitychicken, EntityLivingBase.class, 0, false, true, ITitan.SearchForAThingToKill));
                }
            }
            if (this.numBishop < this.getBishopCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.worldObj);
                this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                entitychicken.master = this;
                entitychicken.playSound("thetitans:titansummonminion", 1.0f, 1.0f);
                entitychicken.addVelocity(0.0, 0.5, 0.0);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(3);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ);
                this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                ++this.numMinions;
                if (block == Blocks.grass) {
                    this.worldObj.setBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ, Blocks.dirt);
                }
                ++this.numBishop;
                if (this.isSubdued) {
                    entitychicken.isMasterSubdued = true;
                }
                if (this.isSubdued) {
                    entitychicken.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)entitychicken, EntityLivingBase.class, 0, false, true, entitychicken.allowPlayerPresence));
                } else {
                    entitychicken.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)entitychicken, EntityLivingBase.class, 0, false, true, ITitan.SearchForAThingToKill));
                }
            }
            if (this.numTemplar < this.getTemplarCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.worldObj);
                this.teleportEntityRandomly((EntityLivingBase)entitychicken);
                entitychicken.master = this;
                entitychicken.playSound("thetitans:titansummonminion", 1.0f, 1.0f);
                entitychicken.addVelocity(0.0, 0.5, 0.0);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(4);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                Block block = this.worldObj.getBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ);
                this.worldObj.playAuxSFX(2001, (int)entitychicken.posX, (int)entitychicken.posY, (int)entitychicken.posZ, Block.getIdFromBlock((Block)block));
                if (block == Blocks.grass) {
                    this.worldObj.setBlock((int)entitychicken.posX, (int)(entitychicken.posY + 1.0), (int)entitychicken.posZ, Blocks.dirt);
                }
                ++this.numTemplar;
                if (this.isSubdued) {
                    entitychicken.isMasterSubdued = true;
                }
                if (this.isSubdued) {
                    entitychicken.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)entitychicken, EntityLivingBase.class, 0, false, true, entitychicken.allowPlayerPresence));
                } else {
                    entitychicken.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)entitychicken, EntityLivingBase.class, 0, false, true, ITitan.SearchForAThingToKill));
                }
            }
        }
        if (!(this.worldObj.isRemote || this.isStunned || this.getWaiting() || this.animID == 13)) {
            int i = MathHelper.floor_double((double)this.posX);
            int j = MathHelper.floor_double((double)this.posY);
            int k = MathHelper.floor_double((double)this.posZ);
            boolean flag = false;
            int l = 0;
            while (!flag && l <= 20 && l >= -20) {
                int i1 = 0;
                while (!flag && i1 <= 20 && i1 >= -20) {
                    int j1 = 0;
                    while (!flag && j1 <= 20 && j1 >= -20) {
                        if (this.worldObj.getBlock(i + i1, j + l, k + j1) == Blocks.monster_egg) {
                            this.worldObj.func_147480_a(i + i1, j + l, k + j1, false);
                            EntitySilverfishMinion entitysilverfish = new EntitySilverfishMinion(this.worldObj);
                            entitysilverfish.setLocationAndAngles((double)(i + i1) + 0.5, j + l, (double)(k + j1) + 0.5, 0.0f, 0.0f);
                            entitysilverfish.onSpawnWithEgg(null);
                            if (!this.worldObj.isRemote) {
                                this.worldObj.spawnEntityInWorld((Entity)entitysilverfish);
                            }
                            this.worldObj.createExplosion((Entity)entitysilverfish, entitysilverfish.posX, entitysilverfish.posY, entitysilverfish.posZ, 2.0f, false);
                            entitysilverfish.spawnExplosionParticle();
                            this.worldObj.setBlockToAir(i + i1, j + l, k + j1);
                            if (this.rand.nextBoolean()) {
                                flag = true;
                                break;
                            }
                        }
                        j1 = j1 <= 0 ? 1 - j1 : 0 - j1;
                    }
                    i1 = i1 <= 0 ? 1 - i1 : 0 - i1;
                }
                l = l <= 0 ? 1 - l : 0 - l;
            }
        }
        super.onLivingUpdate();
    }

    @Override
    public StatBase getAchievement() {
        return TitansAchievments.omegafish;
    }

    public boolean attackOmegafishFrom(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 2.0f;
        }
        if (source.getEntity() != null && source.getEntity() instanceof EntityPlayer && source.canHarmInCreative()) {
            this.playSound(this.getHurtSound(), this.getSoundVolume(), this.getSoundPitch());
            this.isStunned = true;
            this.setAttackTarget(null);
        }
        if (this.isEntityInvulnerable() || this.isBurrowing) {
            return false;
        }
        if (!this.isStunned && source.getEntity() instanceof EntityPlayer) {
            return false;
        }
        if (source.getEntity() instanceof EntitySilverfishMinion || source.getEntity() instanceof EntitySilverfishTitan) {
            return false;
        }
        this.recentlyHit = 200;
        Entity entity = source.getEntity();
        if (entity instanceof EntityLivingBase && !this.isEntityInvulnerable() && amount > 25.0f) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1 instanceof EntitySilverfishTitan) {
                    EntitySilverfishTitan entitypigzombie = (EntitySilverfishTitan)entity1;
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
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return this.attackOmegafishFrom(source, amount);
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

    protected boolean isMovementBlocked() {
        return this.isSubdued && this.riddenByEntity == null ? true : super.isMovementBlocked();
    }

    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            double d8 = 0.4 + (double)this.getExtraPower() * 0.05;
            Vec3 vec3 = this.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            this.riddenByEntity.setPosition(this.posX + dx, this.posY + (this.isBurrowing ? 0.5 + (double)this.getExtraPower() * 0.05 : 5.0 + (double)this.getExtraPower() * 0.05), this.posZ + dz);
        }
    }

    public boolean interact(EntityPlayer p_70085_1_) {
        ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();
        p_70085_1_.swingItem();
        if (this.isStunned && !this.isSubdued) {
            if (itemstack != null && itemstack.getItem() == Items.golden_apple) {
                this.isSubdued = true;
                this.worldObj.playSoundAtEntity((Entity)this, "random.levelup", 10.0f, 1.0f);
                p_70085_1_.addChatMessage((IChatComponent)new ChatComponentText(this.getCustomNameTag() + " has been subdued by " + p_70085_1_.getCommandSenderName()));
                return super.interact(p_70085_1_);
            }
        } else if (this.isSubdued) {
            if (itemstack == null && p_70085_1_.ridingEntity == null) {
                p_70085_1_.mountEntity((Entity)this);
            } else if (itemstack != null) {
                if (itemstack.getItem() == Items.diamond) {
                    AnimationAPI.sendAnimPacket(this, 9);
                    this.setAnimID(9);
                }
                if (itemstack.getItem() == Items.iron_shovel) {
                    if (this.isBurrowing) {
                        AnimationAPI.sendAnimPacket(this, 2);
                        this.setAnimID(2);
                    } else {
                        AnimationAPI.sendAnimPacket(this, 1);
                        this.setAnimID(1);
                    }
                }
                if (itemstack.getItem() == Items.cooked_chicken) {
                    AnimationAPI.sendAnimPacket(this, 3);
                    this.setAnimID(3);
                }
                if (itemstack.getItem() == Items.bone) {
                    switch (this.rand.nextInt(2)) {
                        case 0: {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                            break;
                        }
                        case 1: {
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    protected void inactDeathAction() {
        if (!this.worldObj.isRemote) {
            this.playSound("mob.silverfish.death", this.getSoundVolume(), this.getSoundPitch());
            if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(true, 0);
                this.dropEquipment(true, 0);
                this.dropRareDrop(1);
            }
            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
            entitytitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(1);
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
        this.isBurrowing = false;
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
        if (this.deathTicks >= 300) {
            this.setInvulTime(this.getInvulTime() + 8);
            --this.animTick;
            float f = (this.rand.nextFloat() - 0.5f) * 8.0f;
            float f1 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        }
        if (this.getInvulTime() >= this.getThreashHold()) {
            this.setDead();
        }
    }

    @Override
    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        this.func_82195_e(source, amount);
        return true;
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return this.attackOmegafishFrom(p_82195_1_, p_82195_2_);
    }

    public World func_82194_d() {
        return this.worldObj;
    }

    @Override
    protected void updateAITasks() {
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

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_180482_2_) {
        IEntityLivingData p_180482_2_1 = super.onSpawnWithEgg(p_180482_2_);
        this.setWaiting(true);
        return p_180482_2_1;
    }

    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase && this.isSubdued) {
            this.setAttackTarget(null);
            this.rotationPitch = this.riddenByEntity.rotationPitch;
            this.rotationYawHead = ((EntityLivingBase)this.riddenByEntity).rotationYawHead;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            p_70612_1_ = ((EntityLivingBase)this.riddenByEntity).moveStrafing;
            p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward;
            if (((EntityLivingBase)this.riddenByEntity).moveForward > 0.0f) {
                this.addVelocity((double)(-MathHelper.sin((float)(((EntityLivingBase)this.riddenByEntity).rotationYawHead * (float)Math.PI / 180.0f))) * this.getSpeed(), 0.0, (double)MathHelper.cos((float)(((EntityLivingBase)this.riddenByEntity).rotationYawHead * (float)Math.PI / 180.0f)) * this.getSpeed());
            }
            if (((EntityLivingBase)this.riddenByEntity).moveForward < 0.0f) {
                this.addVelocity((double)(-MathHelper.sin((float)(((EntityLivingBase)this.riddenByEntity).rotationYawHead * (float)Math.PI / 180.0f))) * -this.getSpeed(), 0.0, (double)MathHelper.cos((float)(((EntityLivingBase)this.riddenByEntity).rotationYawHead * (float)Math.PI / 180.0f)) * -this.getSpeed());
            }
            if (this.onGround && ((EntityLivingBase)this.riddenByEntity).rotationPitch < -80.0f) {
                this.jump();
            }
            if (!this.worldObj.isRemote) {
                super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
            }
            this.prevLimbSwingAmount = this.limbSwingAmount;
            double do1 = this.posX - this.prevPosX;
            double do0 = this.posZ - this.prevPosZ;
            float f4 = MathHelper.sqrt_double((double)(do1 * do1 + do0 * do0)) * 4.0f;
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4f;
            this.limbSwing += this.limbSwingAmount;
        } else {
            super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
        }
    }
}

