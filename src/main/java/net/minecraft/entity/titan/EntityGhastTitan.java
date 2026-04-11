/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityLargeFireball
 *  net.minecraft.entity.projectile.EntitySmallFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.ai.EntityAITitanLookIdle;
import net.minecraft.entity.titanminion.EntityGhastMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGhastTitan
extends EntityTitan {
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    private int explosionStrength = 5;

    public EntityGhastTitan(World worldIn) {
        super(worldIn);
        this.shouldParticlesBeUpward = true;
        this.noClip = true;
        this.setSize(110.0f, 110.0f);
        this.experienceValue = 750000;
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        this.tasks.removeTask((EntityAIBase)new EntityAITitanLookIdle(this));
    }

    @Override
    protected void applyEntityAI() {
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.GhastTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public float getEyeHeight() {
        return 60.0f;
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

    @SideOnly(value=Side.CLIENT)
    public boolean func_110182_bF() {
        return this.dataWatcher.getWatchableObjectByte(16) != 0;
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != EntityGhastMinion.class && p_70686_1_ != EntityGhastTitan.class && p_70686_1_ != EntityTitanFireball.class;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(250) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.GhastTitanMinionSpawnrate;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)new Byte(0));
    }

    @Override
    public int getParticleCount() {
        return 100;
    }

    @Override
    public String getParticles() {
        return "largesmoke";
    }

    @Override
    public int getRegenTime() {
        return 5;
    }

    @Override
    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.GREATER;
    }

    protected String getLivingSound() {
        return "thetitans:titanGhastLiving";
    }

    @Override
    protected String getHurtSound() {
        return "thetitans:titanGhastGrunt";
    }

    @Override
    protected String getDeathSound() {
        return "thetitans:titanGhastDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 0xF000F0;
    }

    public float getBrightness(float p_70013_1_) {
        return 1.0f;
    }

    @Override
    public double getSpeed() {
        return 0.5 + (double)this.getExtraPower() * 0.001;
    }

    @Override
    protected void fall(float p_70069_1_) {
    }

    protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
    }

    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.91f;
        this.motionY *= (double)0.91f;
        this.motionZ *= (double)0.91f;
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d1 = this.posX - this.prevPosX;
        double d0 = this.posZ - this.prevPosZ;
        float f4 = MathHelper.sqrt_double((double)(d1 * d1 + d0 * d0)) * 4.0f;
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }

    public boolean isOnLadder() {
        return false;
    }

    @Override
    public void onLivingUpdate() {
        this.setSize(110.0f, 110.0f);
        for (int i = 0; i < 90; ++i) {
            double d0 = this.posX + (double)(this.rand.nextFloat() * 90.0f - 45.0f);
            double d1 = this.posY + (double)(this.rand.nextFloat() * 30.0f);
            double d2 = this.posZ + (double)(this.rand.nextFloat() * 90.0f - 45.0f);
            if (this.worldObj.isRemote || this.worldObj.getBlock((int)d0, (int)d1 + (int)this.getEyeHeight(), (int)d2).getMaterial() == Material.air) continue;
            this.setPosition(this.posX, this.posY + 0.1, this.posZ);
        }
        EntityPlayer entity = this.worldObj.getClosestPlayerToEntity((Entity)this, -1.0);
        if (entity instanceof EntityPlayer && entity != null && entity == this.getAttackTarget() && this.getAttackTarget() != null) {
            entity.setFire(50);
            if (this.rand.nextInt(200) == 0 && this.getAttackTarget() != null && this.getHealth() <= this.getMaxHealth() / 100.0f) {
                entity.attackEntityFrom(DamageSourceExtra.onFire.setDamageIsAbsolute().setDamageAllowedInCreativeMode(), Float.MAX_VALUE);
            }
            if (entity.getAbsorptionAmount() <= 0.0f && this.ticksExisted % 10 == 0) {
                entity.attackEntityFrom(DamageSourceExtra.onFire.setDamageIsAbsolute().setDamageAllowedInCreativeMode(), 12.0f);
                entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 400, 9));
                if (entity.getHealth() <= 5.0f) {
                    entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 400, 1));
                }
            } else if (entity.getAbsorptionAmount() >= 0.0f && this.ticksExisted % 20 == 0) {
                entity.attackEntityFrom(DamageSourceExtra.onFire.setDamageIsAbsolute().setDamageAllowedInCreativeMode(), 12.0f);
            }
        }
        if (TheTitans.NightmareMode) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(9000.0 + (double)(this.getExtraPower() * 1800));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400000.0 + (double)(this.getExtraPower() * 60000));
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3000.0 + (double)(this.getExtraPower() * 600));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200000.0 + (double)(this.getExtraPower() * 30000));
        }
        this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.GhastTitan.name"));
        if (this.numMinions < this.getMinionCap() && (this.rand.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityGhastMinion entitychicken = new EntityGhastMinion(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.teleportEntityRandomly((EntityLivingBase)entitychicken);
            entitychicken.setMinionType(0);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numMinions;
        }
        if (this.numPriests < this.getPriestCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityGhastMinion entitychicken = new EntityGhastMinion(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.teleportEntityRandomly((EntityLivingBase)entitychicken);
            entitychicken.setMinionType(1);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numPriests;
        }
        if (this.numZealots < this.getZealotCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityGhastMinion entitychicken = new EntityGhastMinion(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.teleportEntityRandomly((EntityLivingBase)entitychicken);
            entitychicken.setMinionType(2);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numZealots;
        }
        if (this.numBishop < this.getBishopCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityGhastMinion entitychicken = new EntityGhastMinion(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.teleportEntityRandomly((EntityLivingBase)entitychicken);
            entitychicken.setMinionType(3);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numTemplar;
        }
        if (this.numTemplar < this.getTemplarCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityGhastMinion entitychicken = new EntityGhastMinion(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.teleportEntityRandomly((EntityLivingBase)entitychicken);
            entitychicken.setMinionType(4);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numTemplar;
        }
        if (this.worldObj.isRemote) {
            for (int i1 = 0; i1 < this.getParticleCount(); ++i1) {
                this.worldObj.spawnParticle(this.getParticles(), this.posX + (this.rand.nextDouble() - 0.5) * 96.0, this.posY + this.rand.nextDouble() * 96.0, this.posZ + (this.rand.nextDouble() - 0.5) * 96.0, 0.0, 0.5, 0.0);
            }
        }
        super.onLivingUpdate();
    }

    @Override
    protected void updateAITasks() {
        byte b0;
        byte b1;
        this.prevAttackCounter = this.attackCounter;
        double d0 = this.waypointX - this.posX;
        double d1 = this.waypointY - this.posY;
        double d2 = this.waypointZ - this.posZ;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;
        if (d3 < 36.0 || d3 > 40000.0) {
            if (this.getAttackTarget() != null) {
                this.waypointX = this.getAttackTarget().posX + (this.rand.nextDouble() * 2.0 - 1.0) * 96.0;
                this.waypointY = 160.0 + (this.rand.nextDouble() * 2.0 - 1.0) * 32.0;
                this.waypointZ = this.getAttackTarget().posZ + (this.rand.nextDouble() * 2.0 - 1.0) * 96.0;
            } else {
                EntityPlayer player = this.worldObj.getClosestPlayerToEntity((Entity)this, 512.0);
                if (player != null) {
                    this.waypointX = player.posX + (this.rand.nextDouble() * 2.0 - 1.0) * 96.0;
                    this.waypointY = 160.0 + (this.rand.nextDouble() * 2.0 - 1.0) * 32.0;
                    this.waypointZ = player.posZ + (this.rand.nextDouble() * 2.0 - 1.0) * 96.0;
                } else {
                    this.waypointX = this.posX + (this.rand.nextDouble() * 2.0 - 1.0) * 96.0;
                    this.waypointY = 160.0 + (this.rand.nextDouble() * 2.0 - 1.0) * 32.0;
                    this.waypointZ = this.posZ + (this.rand.nextDouble() * 2.0 - 1.0) * 96.0;
                }
            }
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            d3 = MathHelper.sqrt_double((double)d3);
            this.motionX += d0 / d3 * 0.3;
            this.motionY += d1 / d3 * 0.3;
            this.motionZ += d2 / d3 * 0.3;
        }
        double d4 = 1024.0;
        this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
        if (this.getAttackTarget() != null && this.getAttackTarget().getDistanceSqToEntity((Entity)this) < d4 * d4) {
            this.getLookHelper().setLookPositionWithEntity((Entity)this.getAttackTarget(), 180.0f, 180.0f);
            double d8 = 50.0;
            Vec3 vec3 = this.getLook(1.0f);
            double px = this.posX + vec3.xCoord * d8;
            double py = this.posY + vec3.yCoord * d8 + 10.0;
            double pz = this.posZ + vec3.zCoord * d8;
            double d11 = this.getAttackTarget().posX - px;
            double d21 = this.getAttackTarget().posY - py;
            double d31 = this.getAttackTarget().posZ - pz;
            if (this.canEntityBeSeen((Entity)this.getAttackTarget())) {
                if (this.attackCounter == 10) {
                    this.playSound("thetitans:titanGhastCharge", Float.MAX_VALUE, this.getSoundPitch());
                }
                ++this.attackCounter;
                if (this.attackCounter >= 50) {
                    this.faceEntity((Entity)this.getAttackTarget(), 180.0f, 180.0f);
                    if (this.getAttackTarget() instanceof EntityTitan || this.getAttackTarget().height >= 6.0f) {
                        this.attackChoosenEntity((Entity)this.getAttackTarget(), (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue(), this.getKnockbackAmount());
                    }
                    this.playSound("thetitans:titanGhastFireball", Float.MAX_VALUE, 1.0f);
                    EntityTitanFireball entitysmallfireball = new EntityTitanFireball(this.worldObj, (EntityLivingBase)this, d11 + this.getRNG().nextGaussian() * 16.0, d21, d31 + this.getRNG().nextGaussian() * 16.0);
                    entitysmallfireball.posX = px;
                    entitysmallfireball.posY = py;
                    entitysmallfireball.posZ = pz;
                    this.worldObj.spawnEntityInWorld((Entity)entitysmallfireball);
                    if (this.attackCounter == 100) {
                        this.attackCounter = -80;
                    }
                }
            } else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        } else {
            if (this.getAttackTarget() == null) {
                this.rotationYaw = this.rotationYawHead = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0f / (float)Math.PI;
                this.renderYawOffset = this.rotationYawHead;
            }
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        if (!this.worldObj.isRemote && (b1 = this.dataWatcher.getWatchableObjectByte(16)) != (b0 = (byte)(this.attackCounter > 20 ? 1 : 0))) {
            this.dataWatcher.updateObject(16, (Object)b0);
        }
        super.updateAITasks();
    }

    public int getVerticalFaceSpeed() {
        return 180;
    }

    protected Item getDropItem() {
        return Items.blaze_rod;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            EntityItem entityitem;
            int l;
            for (int x = 0; x < 80; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.motionY += 1.0;
                entitylargefireball.setXPCount(26000);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            for (l = 0; l < 512 + this.rand.nextInt(512 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.gunpowder));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 512 + this.rand.nextInt(512 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.ghast_tear));
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
            for (l = 0; l < 64; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.brewing_stand));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
        }
    }

    protected void addRandomArmor() {
        this.dropItem(Items.brewing_stand, 64);
    }

    public boolean func_70845_n() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void func_70844_e(boolean p_70844_1_) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        b0 = p_70844_1_ ? (byte)(b0 | 1) : (byte)(b0 & 0xFFFFFFFE);
        this.dataWatcher.updateObject(16, (Object)b0);
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    protected void collideWithEntity(Entity p_82167_1_) {
        if (!(p_82167_1_ instanceof EntitySmallFireball) || !(p_82167_1_ instanceof EntityLargeFireball)) {
            p_82167_1_.applyEntityCollision((Entity)this);
        }
    }

    @Override
    public StatBase getAchievement() {
        return TitansAchievments.ghasttitan;
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source.getEntity() instanceof EntityGhastMinion || source.getEntity() instanceof EntityGhastTitan) {
            return false;
        }
        if (source.isFireDamage()) {
            this.heal(amount);
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    protected void inactDeathAction() {
        if (!this.worldObj.isRemote) {
            this.playSound("mob.ghast.death", this.getSoundVolume(), this.getSoundPitch());
            if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(true, 0);
                this.dropEquipment(true, 0);
                this.dropRareDrop(1);
            }
            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
            entitytitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(11);
        }
    }
}

