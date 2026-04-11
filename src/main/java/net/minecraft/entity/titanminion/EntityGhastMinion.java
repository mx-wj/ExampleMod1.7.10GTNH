/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIArrowAttack
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityPotion
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.stats.AchievementList
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titanminion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EntityGhastMinionFireball;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.ITemplar;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGhastMinion
extends EntityCreature
implements IMob,
IRangedAttackMob,
ITemplar {
    public EntityLiving master;
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    protected int explosionStrength = 1;
    public EntityLiving entityToHeal;
    private int attackPattern;
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 5, 64.0f);
    public int deathTicks;

    public EntityGhastMinion(World worldIn) {
        super(worldIn);
        this.setSize(4.5f, 4.5f);
        this.isImmuneToFire = true;
        this.experienceValue = 20;
        this.tasks.addTask(0, (EntityAIBase)new EntityAIFindEntityNearestInjuredAlly(this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.GhastTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    public void setDead() {
        super.setDead();
        if (this.master != null && this.master instanceof EntityTitan) {
            ((EntityTitan)this.master).retractMinionNumFromType(this.getMinionType());
        }
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != EntityGhastMinion.class && p_70686_1_ != EntityGhastTitan.class;
    }

    protected void fall(float p_70069_1_) {
    }

    protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
    }

    public boolean attackEntityAsMob(Entity p_70652_1_) {
        boolean flag;
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int i = 0;
        if (p_70652_1_ instanceof EntityLivingBase) {
            f += EnchantmentHelper.getEnchantmentModifierLiving((EntityLivingBase)this, (EntityLivingBase)((EntityLivingBase)p_70652_1_));
            i += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)this, (EntityLivingBase)((EntityLivingBase)p_70652_1_));
        }
        if (flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), f)) {
            int j;
            if (p_70652_1_ instanceof EntityLivingBase && this.getMinionTypeInt() >= 3) {
                int b0 = 10;
                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                    b0 = 20;
                } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                    b0 = 30;
                }
                if (b0 > 0) {
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(ClientProxy.electricJudgment.id, b0 * 20, 0));
                }
            }
            if (i > 0) {
                p_70652_1_.addVelocity((double)(-MathHelper.sin((float)(this.rotationYaw * (float)Math.PI / 180.0f)) * (float)i * 0.5f), 0.1, (double)(MathHelper.cos((float)(this.rotationYaw * (float)Math.PI / 180.0f)) * (float)i * 0.5f));
                this.motionX *= 0.6;
                this.motionZ *= 0.6;
            }
            if ((j = EnchantmentHelper.getFireAspectModifier((EntityLivingBase)this)) > 0) {
                p_70652_1_.setFire(j * 4);
            }
            if (p_70652_1_ instanceof EntityLivingBase) {
                EnchantmentHelper.func_151384_a((EntityLivingBase)((EntityLivingBase)p_70652_1_), (Entity)this);
            }
            EnchantmentHelper.func_151385_b((EntityLivingBase)this, (Entity)p_70652_1_);
        }
        return flag;
    }

    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
        if (this.isInWater()) {
            this.moveFlying(p_70612_1_, p_70612_2_, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)0.8f;
            this.motionY *= (double)0.8f;
            this.motionZ *= (double)0.8f;
        } else if (this.handleLavaMovement()) {
            this.moveFlying(p_70612_1_, p_70612_2_, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        } else {
            float f2 = 0.91f;
            if (this.onGround) {
                f2 = this.worldObj.getBlock((int)MathHelper.floor_double((double)this.posX), (int)(MathHelper.floor_double((double)this.boundingBox.minY) - 1), (int)MathHelper.floor_double((double)this.posZ)).slipperiness * 0.91f;
            }
            float f3 = 0.16277136f / (f2 * f2 * f2);
            this.moveFlying(p_70612_1_, p_70612_2_, this.onGround ? 0.1f * f3 : 0.02f);
            f2 = 0.91f;
            if (this.onGround) {
                f2 = this.worldObj.getBlock((int)MathHelper.floor_double((double)this.posX), (int)(MathHelper.floor_double((double)this.boundingBox.minY) - 1), (int)MathHelper.floor_double((double)this.posZ)).slipperiness * 0.91f;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)f2;
            this.motionY *= (double)f2;
            this.motionZ *= (double)f2;
        }
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

    @SideOnly(value=Side.CLIENT)
    public boolean func_110182_bF() {
        return this.dataWatcher.getWatchableObjectByte(16) != 0;
    }

    public void func_175454_a(boolean p_175454_1_) {
        this.dataWatcher.updateObject(16, (Object)((byte)(p_175454_1_ ? 1 : 0)));
    }

    public int func_175453_cd() {
        return this.explosionStrength;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.getAttackTarget() != null) {
            this.getLookHelper().setLookPosition(this.getAttackTarget().posX, this.getAttackTarget().posY + (double)this.getAttackTarget().getEyeHeight(), this.getAttackTarget().posZ, 180.0f, 180.0f);
        }
    }

    protected void updateAITasks() {
        byte b0;
        byte b1;
        EntityLivingBase e;
        if (this.rand.nextInt(60) == 0 && this.getAttackTarget() != null) {
            this.setCombatTask();
            this.attackPattern = !this.onGround ? 0 : 1;
        }
        if (this.getAttackTarget() != null && this.worldObj.rand.nextInt(5) == 1 && (e = this.getAttackTarget()) != null && this.getDistanceSqToEntity((Entity)e) < (double)(this.width * this.width + e.width * e.width) + 36.0 && (this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(2) == 1)) {
            this.attackEntityAsMob((Entity)e);
        }
        if (this.master != null) {
            if (this.master.getAttackTarget() != null) {
                if (this.master.getAttackTarget().height < 6.0f) {
                    this.setAttackTarget(this.master.getAttackTarget());
                } else {
                    this.getLookHelper().setLookPositionWithEntity((Entity)this.master.getAttackTarget(), 10.0f, 40.0f);
                }
            }
        } else {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
            if (list != null && !list.isEmpty()) {
                for (int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity == null || !(entity instanceof EntityGhastTitan)) continue;
                    this.master = (EntityGhastTitan)entity;
                }
            }
        }
        if (this.getAttackTarget() != null && !this.canEntityBeSeen((Entity)this.getAttackTarget()) && this.rand.nextInt(150) == 0) {
            this.setAttackTarget(null);
        }
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        this.despawnEntity();
        this.prevAttackCounter = this.attackCounter;
        double d0 = this.waypointX - this.posX;
        double d1 = this.waypointY - this.posY;
        double d2 = this.waypointZ - this.posZ;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;
        if (d3 < 1.0 || d3 > 10000.0) {
            if (this.master != null) {
                double extra = 0.0;
                if (this.getAttackTarget() != null && this.getAttackTarget().height > 4.0f) {
                    extra = 64.0;
                }
                double x = this.master.posX;
                double y = this.master.posY + 32.0 + extra;
                double z = this.master.posZ;
                this.waypointX = x + (d0 += this.rand.nextDouble() * 96.0 - 48.0);
                this.waypointY = y + (d1 += this.rand.nextDouble() * 96.0 - 48.0);
                this.waypointZ = z + (d2 += this.rand.nextDouble() * 96.0 - 48.0);
            } else if (this.getAttackTarget() != null) {
                this.waypointX = this.getAttackTarget().posX + (this.rand.nextDouble() * 2.0 - 1.0) * 16.0;
                this.waypointY = this.getAttackTarget().posY + 32.0 + (this.rand.nextDouble() * 2.0 - 1.0) * 16.0;
                this.waypointZ = this.getAttackTarget().posZ + (this.rand.nextDouble() * 2.0 - 1.0) * 16.0;
            } else {
                EntityPlayer player = this.worldObj.getClosestPlayerToEntity((Entity)this, 512.0);
                if (player != null) {
                    this.waypointX = player.posX + (this.rand.nextDouble() * 2.0 - 1.0) * 16.0;
                    this.waypointY = player.posY + 32.0 + (this.rand.nextDouble() * 2.0 - 1.0) * 16.0;
                    this.waypointZ = player.posZ + (this.rand.nextDouble() * 2.0 - 1.0) * 16.0;
                } else {
                    this.waypointX = this.posX + (this.rand.nextDouble() * 2.0 - 1.0) * 16.0;
                    this.waypointY = this.posY + (this.rand.nextDouble() * 2.0 - 1.0) * 16.0;
                    this.waypointZ = this.posZ + (this.rand.nextDouble() * 2.0 - 1.0) * 16.0;
                }
            }
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3 = (double)MathHelper.sqrt_double((double)d3))) {
                if (this.master != null && this.getDistanceSqToEntity((Entity)this.master) > 4096.0) {
                    this.motionX += d0 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.8 : 0.2);
                    this.motionY += d1 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.8 : 0.2);
                    this.motionZ += d2 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.8 : 0.2);
                } else {
                    this.motionX += d0 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.4 : 0.1);
                    this.motionY += d1 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.4 : 0.1);
                    this.motionZ += d2 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.4 : 0.1);
                }
            } else {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }
        if (this.targetedEntity != null && this.targetedEntity.isDead) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.getAttackTarget();
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }
        double d4 = 100.0;
        if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity((Entity)this) < d4 * d4) {
            double d8 = 2.0;
            Vec3 vec3 = this.getLook(1.0f);
            double d5 = this.targetedEntity.posX + this.targetedEntity.motionX - (this.posX + vec3.xCoord * d8);
            double d6 = this.targetedEntity.posY + 1.0 - (this.posY + vec3.yCoord * d8 + 1.0);
            double d7 = this.targetedEntity.posZ + this.targetedEntity.motionZ - (this.posZ + vec3.zCoord * d8);
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0f / (float)Math.PI;
            if (this.canEntityBeSeen(this.targetedEntity)) {
                EntityGhastMinionFireball entitylargefireball;
                if (this.attackCounter == 10) {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1007, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                }
                ++this.attackCounter;
                if (this.attackCounter > 20 && this.getMinionType() == EnumMinionType.TEMPLAR) {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    entitylargefireball = new EntityGhastMinionFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7);
                    entitylargefireball.field_92057_e = this.explosionStrength;
                    entitylargefireball.posX = this.posX + vec3.xCoord * d8;
                    entitylargefireball.posY = this.posY + vec3.yCoord * d8 + 1.0;
                    entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
                    this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
                }
                if (this.attackCounter >= (this.getMinionType() == EnumMinionType.TEMPLAR ? 40 : 20)) {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    entitylargefireball = new EntityGhastMinionFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7);
                    entitylargefireball.field_92057_e = this.explosionStrength;
                    entitylargefireball.posX = this.posX + vec3.xCoord * d8;
                    entitylargefireball.posY = this.posY + vec3.yCoord * d8 + 1.0;
                    entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
                    this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
                    this.attackCounter = this.getMinionType() == EnumMinionType.ZEALOT ? 0 : -40;
                }
            } else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        } else {
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0f / (float)Math.PI;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        if (!this.worldObj.isRemote && (b1 = this.dataWatcher.getWatchableObjectByte(16)) != (b0 = (byte)(this.attackCounter > 10 ? 1 : 0))) {
            this.dataWatcher.updateObject(16, (Object)b0);
        }
        super.updateAITasks();
    }

    public void moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
        if (this.deathTicks > 0) {
            super.moveEntity(0.0, (double)0.1f, 0.0);
        } else {
            super.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
        }
    }

    protected void onDeathUpdate() {
        if (this.getMinionTypeInt() == 4) {
            float f1;
            --this.ticksExisted;
            ++this.deathTicks;
            if (this.master != null) {
                double mx = this.posX - this.master.posX;
                double my = this.posY + (double)this.getEyeHeight() - (this.master.posY + (double)this.master.getEyeHeight());
                double mz = this.posZ - this.master.posZ;
                int short1 = (int)(this.getDistanceToEntity((Entity)this.master) * 2.0f);
                for (int f = 0; f < short1; ++f) {
                    double d9 = (double)f / ((double)short1 - 1.0);
                    double d6 = this.posX + mx * -d9;
                    double d7 = this.posY + (double)this.getEyeHeight() + my * -d9;
                    double d8 = this.posZ + mz * -d9;
                    this.worldObj.spawnParticle("fireworksSpark", d6, d7, d8, this.master.motionX, this.master.motionY + 0.2, this.master.motionZ);
                }
            }
            if (!this.worldObj.isRemote) {
                if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                    this.dropFewItems(true, 0);
                }
                if (this.deathTicks == 1) {
                    this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                }
            }
            if (this.deathTicks >= 180 && this.deathTicks <= 200) {
                float f = (this.rand.nextFloat() - 0.5f) * this.width;
                f1 = (this.rand.nextFloat() - 0.5f) * this.height;
                float f2 = (this.rand.nextFloat() - 0.5f) * this.width;
                this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + (double)this.getEyeHeight() + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            }
            this.moveEntity(0.0, 0.1f, 0.0);
            float f = (this.rand.nextFloat() - 0.5f) * this.width;
            f1 = (this.rand.nextFloat() - 0.5f) * this.height;
            float f2 = (this.rand.nextFloat() - 0.5f) * this.width;
            this.worldObj.spawnParticle("largeexplode", this.posX + (double)f, this.posY + (double)this.getEyeHeight() + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("lava", this.posX + (double)f, this.posY + (double)this.getEyeHeight() + (double)f1, this.posZ + (double)f2, this.rand.nextGaussian(), this.rand.nextGaussian(), this.rand.nextGaussian());
            if (this.deathTicks == 200 && !this.worldObj.isRemote) {
                int j;
                int i;
                if (this.master != null) {
                    this.master.heal(this.master.getMaxHealth() / 100.0f);
                    for (i = 0; i < 100; ++i) {
                        double d2 = this.rand.nextGaussian() * 0.02;
                        double d0 = this.rand.nextGaussian() * 0.02;
                        double d1 = this.rand.nextGaussian() * 0.02;
                        this.worldObj.spawnParticle("largeexplode", this.master.posX + (double)(this.rand.nextFloat() * this.master.width * 2.0f) - (double)this.master.width, this.master.posY + (double)(this.rand.nextFloat() * this.master.height), this.master.posZ + (double)(this.rand.nextFloat() * this.master.width * 2.0f) - (double)this.master.width, d2, d0, d1);
                    }
                }
                for (i = this.experienceValue; i > 0; i -= j) {
                    j = EntityXPOrb.getXPSplit((int)i);
                    this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
                }
                this.setDead();
            }
        } else {
            super.onDeathUpdate();
        }
    }

    private boolean isCourseTraversable(double p_70790_1_, double p_70790_3_, double p_70790_5_, double p_70790_7_) {
        double d4 = (this.waypointX - this.posX) / p_70790_7_;
        double d5 = (this.waypointY - this.posY) / p_70790_7_;
        double d6 = (this.waypointZ - this.posZ) / p_70790_7_;
        AxisAlignedBB axisalignedbb = this.boundingBox.copy();
        int i = 1;
        while ((double)i < p_70790_7_) {
            axisalignedbb.offset(d4, d5, d6);
            if (!this.worldObj.getCollidingBoundingBoxes((Entity)this, axisalignedbb).isEmpty()) {
                return false;
            }
            ++i;
        }
        return true;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)Byte.valueOf((byte)0));
        this.dataWatcher.addObject(19, (Object)0);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100.0);
    }

    protected String getLivingSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanGhastLiving" : "mob.ghast.moan";
    }

    protected String getHurtSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanGhastGrunt" : "mob.ghast.scream";
    }

    protected String getDeathSound() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanGhastDeath" : "mob.ghast.death";
    }

    protected float getSoundPitch() {
        return this.getMinionTypeInt() == 4 ? super.getSoundPitch() + 0.3f : super.getSoundPitch();
    }

    protected Item getDropItem() {
        return Items.gunpowder;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int k;
        int j = this.rand.nextInt(2) + this.rand.nextInt(1 + p_70628_2_);
        for (k = 0; k < j; ++k) {
            this.dropItem(Items.ghast_tear, 1);
        }
        j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);
        for (k = 0; k < j; ++k) {
            this.dropItem(Items.gunpowder, 1);
        }
        if (this.getMinionTypeInt() >= 1) {
            j = 1 + this.rand.nextInt(4);
            if (p_70628_2_ > 0) {
                j += this.rand.nextInt(p_70628_2_ + 1);
            }
            for (k = 0; k < j; ++k) {
                this.dropItem(Items.experience_bottle, 1);
            }
            if (this.getMinionTypeInt() >= 2) {
                j = this.rand.nextInt(2);
                if (p_70628_2_ > 0) {
                    j += this.rand.nextInt(p_70628_2_ + 1);
                }
                for (k = 0; k < j; ++k) {
                    if (this.rand.nextInt(10) == 0) {
                        this.entityDropItem(new ItemStack(Items.golden_apple, 1, 1), 0.0f);
                        continue;
                    }
                    this.dropItem(Items.golden_apple, 1);
                }
                if (this.getMinionTypeInt() >= 3) {
                    j = this.rand.nextInt(2);
                    if (p_70628_2_ > 0) {
                        j += this.rand.nextInt(p_70628_2_ + 1);
                    }
                    block16: for (k = 0; k < j; ++k) {
                        switch (this.rand.nextInt(5)) {
                            case 0: {
                                this.entityDropItem(new ItemStack(Blocks.emerald_block, 1, 0), 0.0f);
                                continue block16;
                            }
                            case 1: {
                                this.entityDropItem(new ItemStack(Blocks.diamond_block, 1, 0), 0.0f);
                                continue block16;
                            }
                            case 2: {
                                this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                                continue block16;
                            }
                            case 3: {
                                this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                                continue block16;
                            }
                            case 4: {
                                this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                            }
                        }
                    }
                    this.entityDropItem(new ItemStack(Blocks.obsidian), 0.0f);
                    if (this.getMinionTypeInt() >= 4) {
                        if (this.rand.nextInt(5) == 0) {
                            this.entityDropItem(new ItemStack(TitanItems.pleasantBladeSeed), 0.0f);
                        }
                        if (this.rand.nextInt(100) == 0) {
                            this.entityDropItem(new ItemStack(TitanItems.malgrumSeeds), 0.0f);
                        }
                        j = 2 + this.rand.nextInt(5);
                        if (p_70628_2_ > 0) {
                            j += this.rand.nextInt(p_70628_2_ + 1);
                        }
                        block17: for (k = 0; k < j; ++k) {
                            switch (this.rand.nextInt(3)) {
                                case 0: {
                                    this.entityDropItem(new ItemStack(Blocks.emerald_block, 1, 0), 0.0f);
                                    continue block17;
                                }
                                case 1: {
                                    this.entityDropItem(new ItemStack(Blocks.diamond_block, 1, 0), 0.0f);
                                    continue block17;
                                }
                                case 2: {
                                    this.entityDropItem(new ItemStack(Blocks.gold_block, 1, 0), 0.0f);
                                }
                            }
                        }
                        this.entityDropItem(new ItemStack(Blocks.obsidian), 0.0f);
                    }
                }
            }
        }
    }

    protected float getSoundVolume() {
        return 10.0f;
    }

    public boolean getCanSpawnHere() {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere() && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }

    public int getMaxSpawnedInChunk() {
        return 1;
    }

    protected float applyPotionDamageCalculations(DamageSource p_70672_1_, float p_70672_2_) {
        if (this.getMinionTypeInt() == 4) {
            p_70672_2_ = super.applyPotionDamageCalculations(p_70672_1_, p_70672_2_);
            if (p_70672_1_.getEntity() == this) {
                p_70672_2_ = 0.0f;
            }
            if (p_70672_1_.isMagicDamage()) {
                p_70672_2_ = (float)((double)p_70672_2_ * 0.15);
            }
            return p_70672_2_;
        }
        return super.applyPotionDamageCalculations(p_70672_1_, p_70672_2_);
    }

    public int getTotalArmorValue() {
        switch (this.getMinionTypeInt()) {
            case 1: {
                return 2;
            }
            case 2: {
                return 15;
            }
            case 3: {
                return 18;
            }
            case 4: {
                return 22;
            }
        }
        return 0;
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("ExplosionPower", this.explosionStrength);
        tagCompound.setInteger("MinionType", this.getMinionTypeInt());
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        if (tagCompund.hasKey("ExplosionPower", 99)) {
            this.explosionStrength = tagCompund.getInteger("ExplosionPower");
        }
        this.setMinionType(tagCompund.getInteger("MinionType"));
    }

    public int getMinionTypeInt() {
        return this.dataWatcher.getWatchableObjectInt(19);
    }

    @Override
    public EnumMinionType getMinionType() {
        switch (this.getMinionTypeInt()) {
            case 1: {
                return EnumMinionType.PRIEST;
            }
            case 2: {
                return EnumMinionType.ZEALOT;
            }
            case 3: {
                return EnumMinionType.BISHOP;
            }
            case 4: {
                return EnumMinionType.TEMPLAR;
            }
        }
        return EnumMinionType.LOYALIST;
    }

    public void setMinionType(int miniontype) {
        this.dataWatcher.updateObject(19, (Object)miniontype);
        if (miniontype == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45);
            this.explosionStrength = 2;
            this.setHealth(90.0f);
            this.experienceValue = 30;
        } else if (miniontype == 2) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
            this.explosionStrength = 4;
            this.setHealth(700.0f);
            this.experienceValue = 200;
        } else if (miniontype == 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(40.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
            this.explosionStrength = 6;
            this.setHealth(1600.0f);
            this.experienceValue = 500;
        } else if (miniontype == 4) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(3000.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(100.0);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.75);
            this.explosionStrength = 9;
            this.setHealth(3000.0f);
            this.experienceValue = 3000;
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4);
            this.setHealth(60.0f);
            this.explosionStrength = 1;
            this.experienceValue = 15;
        }
    }

    public float getEyeHeight() {
        return 3.0f;
    }

    public void onLivingUpdate() {
        EntityGhastMinion entitychicken;
        if (this.getMinionTypeInt() == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45);
            this.explosionStrength = 2;
            this.experienceValue = 30;
        } else if (this.getMinionTypeInt() == 2) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
            this.explosionStrength = 4;
            this.experienceValue = 200;
        } else if (this.getMinionTypeInt() == 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(40.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
            this.explosionStrength = 6;
            this.experienceValue = 500;
        } else if (this.getMinionTypeInt() == 4) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(3000.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(100.0);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.75);
            this.explosionStrength = 9;
            this.experienceValue = 3000;
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4);
            this.explosionStrength = 1;
            this.experienceValue = 15;
        }
        if (this.isEntityAlive() || this.getMinionTypeInt() != 4) {
            super.onLivingUpdate();
        }
        if (this.getMinionTypeInt() == 3) {
            if (this.rand.nextInt(120) == 0 && this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                entitychicken = new EntityGhastMinion(this.worldObj);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(0);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            }
            if (this.rand.nextInt(240) == 0 && this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                entitychicken = new EntityGhastMinion(this.worldObj);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                entitychicken.onSpawnWithEgg(null);
                entitychicken.setMinionType(1);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            }
        }
        if (this.getMinionTypeInt() == 4) {
            if (this.ticksExisted % 40 == 0) {
                this.heal(1.0f);
            }
            if (this.worldObj.rand.nextInt(150) == 1) {
                this.heal(2.0f);
            }
            if (this.worldObj.rand.nextInt(100) == 1 && (double)this.getHealth() < (double)this.getMaxHealth() * 0.75) {
                this.heal(2.0f);
            }
            if (this.worldObj.rand.nextInt(35) == 1 && (double)this.getHealth() < (double)this.getMaxHealth() * 0.5) {
                this.heal(5.0f);
            }
            if (this.worldObj.rand.nextInt(30) == 1 && (double)this.getHealth() < (double)this.getMaxHealth() * 0.25) {
                this.heal(5.0f);
            }
            if (this.worldObj.rand.nextInt(30) == 1 && (double)this.getHealth() < (double)this.getMaxHealth() * 0.05) {
                this.heal(200.0f);
            }
            if (!this.onGround && this.motionY < 0.0) {
                this.motionY *= 0.6;
            }
            if (this.master == null && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                if (this.rand.nextInt(60) == 0) {
                    entitychicken = new EntityGhastMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(0);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
                if (this.rand.nextInt(120) == 0) {
                    entitychicken = new EntityGhastMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(1);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
                if (this.rand.nextInt(240) == 0) {
                    entitychicken = new EntityGhastMinion(this.worldObj);
                    entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    entitychicken.onSpawnWithEgg(null);
                    entitychicken.setMinionType(2);
                    this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                }
            }
            if (this.worldObj.isRemote && !this.onGround) {
                for (int i = 0; i < 3; ++i) {
                    this.worldObj.spawnParticle("explode", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                }
            }
            if (this.rand.nextInt(60) == 0 && this.getAttackTarget() != null) {
                this.setCombatTask();
                this.attackPattern = !this.onGround ? 0 : 1;
            }
            if (this.isEntityAlive() && !this.worldObj.isRemote && this.rand.nextInt(1000) == 0 && this.getAttackTarget() != null && this.getHealth() < this.getMaxHealth() / 2.0f && this.master == null) {
                for (int i = 0; i < 16; ++i) {
                    this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                }
                this.playSound("thetitans:titanland", 10000.0f, 1.0f);
                this.TransformEntity((Entity)this);
            }
            if (this.onGround) {
                this.isAirBorne = false;
            }
            List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(8.0, 8.0, 8.0));
            if (!this.worldObj.isRemote && list11 != null && !list11.isEmpty() && this.ticksExisted % (this.getHealth() < this.getMaxHealth() / 2.0f ? 40 : 160) == 0) {
                this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 8.0f, false);
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity = (Entity)list11.get(i1);
                    if (entity == null || !(entity instanceof EntityLivingBase) || !this.canAttackClass(entity.getClass())) continue;
                    entity.motionY += this.rand.nextDouble();
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(ClientProxy.electricJudgment.id, 10, 1));
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1017, (int)entity.posX, (int)entity.posY, (int)entity.posZ, 0);
                }
            }
        }
        if (this.getMinionTypeInt() == 1 && this.ticksExisted % 40 == 0 && this.entityToHeal != null) {
            if (this.entityToHeal.getHealth() < this.entityToHeal.getMaxHealth()) {
                this.swingItem();
                this.faceEntity((Entity)this.entityToHeal, 180.0f, this.getVerticalFaceSpeed());
                this.entityToHeal.heal(4.0f);
                this.playSound("mob.wither.shoot", 1.0f, 3.0f);
            } else {
                this.entityToHeal = null;
            }
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable() || source.getDamageType() == "thorns" || this.getMinionTypeInt() >= 4 && source == DamageSourceExtra.radiation) {
            return false;
        }
        if (source.getEntity() instanceof EntityGhastMinion || source.getEntity() instanceof EntityGhastTitan) {
            return false;
        }
        if ("fireball".equals(source.getDamageType()) && source.getEntity() instanceof EntityPlayer) {
            super.attackEntityFrom(source, 1000.0f);
            ((EntityPlayer)source.getEntity()).triggerAchievement((StatBase)AchievementList.ghast);
            return true;
        }
        Entity entity = source.getEntity();
        if (source.getEntity() instanceof EntityLivingBase) {
            this.setAttackTarget((EntityLivingBase)entity);
            this.setRevengeTarget((EntityLivingBase)entity);
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public void TransformEntity(Entity entity) {
        entity.worldObj.newExplosion(entity, entity.posX, entity.posY, entity.posZ, 8.0f, true, entity.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        EntityGhastTitan entitytitan = new EntityGhastTitan(entity.worldObj);
        entitytitan.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, 0.0f);
        entity.setDead();
        entitytitan.func_82206_m();
        entity.worldObj.spawnEntityInWorld((Entity)entitytitan);
        entitytitan.playSound("thetitans:titanGhastLiving", 10000.0f, 0.8f);
    }

    public void setCombatTask() {
        this.tasks.removeTask((EntityAIBase)this.aiArrowAttack);
        if (this.attackPattern == 0 && this.getMinionTypeInt() == 4) {
            this.tasks.addTask(0, (EntityAIBase)this.aiArrowAttack);
        }
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
        super.onSpawnWithEgg(p_110161_1_);
        if (!this.worldObj.isRemote) {
            this.setMinionType(0);
            if (this.rand.nextInt(2) == 0) {
                this.setMinionType(1);
                if (this.rand.nextInt(2) == 0) {
                    this.setMinionType(2);
                    if (this.rand.nextInt(2) == 0) {
                        this.setMinionType(3);
                        if (this.rand.nextInt(2) == 0) {
                            this.setMinionType(4);
                        }
                    }
                }
            }
        }
        return p_110161_1_;
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.attackCounter = 10;
        this.swingItem();
        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1007, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        if (this.getDistanceSqToEntity((Entity)p_82196_1_) < (double)(p_82196_1_.width * p_82196_1_.width) + 36.0) {
            this.attackEntityAsMob((Entity)p_82196_1_);
        } else {
            switch (this.rand.nextInt(4)) {
                case 0: {
                    for (int i = 0; i < 100; ++i) {
                        EntityHarcadiumArrow entityarrow = new EntityHarcadiumArrow(this.worldObj, (EntityLivingBase)this, p_82196_1_, 4.0f, 16.0f);
                        entityarrow.setIsCritical(true);
                        entityarrow.setDamage((double)(p_82196_2_ * 2.0f) + this.rand.nextGaussian() * 0.25 + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11f));
                        this.worldObj.spawnEntityInWorld((Entity)entityarrow);
                        double d8 = 4.0;
                        Vec3 vec3 = this.getLook(1.0f);
                        entityarrow.posX = this.posX + vec3.xCoord * d8;
                        entityarrow.posY = this.posY + vec3.yCoord * d8 + 1.0;
                        entityarrow.posZ = this.posZ + vec3.zCoord * d8;
                    }
                    break;
                }
                case 1: {
                    for (int i = 0; i < 200; ++i) {
                        EntityPotion entitypotion = new EntityPotion(this.worldObj, (EntityLivingBase)this, this.rand.nextInt(5) == 0 ? 32660 : (this.rand.nextInt(4) == 0 ? 32696 : (this.rand.nextInt(3) == 0 ? 32698 : 32732)));
                        if (p_82196_1_.isEntityUndead()) {
                            entitypotion.setPotionDamage(32725);
                        }
                        double d0 = p_82196_1_.posY + 0.5;
                        entitypotion.rotationPitch -= -20.0f;
                        double d1 = p_82196_1_.posX + p_82196_1_.motionX - this.posX;
                        double d2 = d0 - this.posY;
                        double d3 = p_82196_1_.posZ + p_82196_1_.motionZ - this.posZ;
                        float f1 = MathHelper.sqrt_double((double)(d1 * d1 + d3 * d3));
                        entitypotion.setThrowableHeading(d1, d2 + (double)(f1 * 0.2f), d3, 2.0f, 25.0f);
                        this.worldObj.spawnEntityInWorld((Entity)entitypotion);
                        double d8 = 4.0;
                        Vec3 vec3 = this.getLook(1.0f);
                        entitypotion.posX = this.posX + vec3.xCoord * d8;
                        entitypotion.posY = this.posY + vec3.yCoord * d8 + 1.0;
                        entitypotion.posZ = this.posZ + vec3.zCoord * d8;
                    }
                    break;
                }
                case 2: {
                    this.worldObj.newExplosion((Entity)this, p_82196_1_.posX, p_82196_1_.posY + 1.0, p_82196_1_.posZ, 2.0f, false, false);
                    p_82196_1_.attackEntityFrom(DamageSourceExtra.lightningBolt, 100.0f);
                    this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                    this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                    this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                    this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, p_82196_1_.posX, p_82196_1_.posY, p_82196_1_.posZ));
                    break;
                }
                case 3: {
                    for (int i = 0; i < 50; ++i) {
                        double d8 = 4.0;
                        Vec3 vec3 = this.getLook(1.0f);
                        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                        double d01 = this.getDistanceSqToEntity((Entity)p_82196_1_);
                        double d11 = p_82196_1_.posX + p_82196_1_.motionX - (this.posX + vec3.xCoord * d8);
                        double d21 = p_82196_1_.posY + 1.0 - (this.posY + vec3.yCoord * d8 + 1.0);
                        double d31 = p_82196_1_.posZ + p_82196_1_.motionZ - (this.posZ + vec3.zCoord * d8);
                        EntityGhastMinionFireball entityfireball = new EntityGhastMinionFireball(this.worldObj, (EntityLivingBase)this, d11 + this.getRNG().nextGaussian() * 9.0, d21, d31 + this.getRNG().nextGaussian() * 9.0);
                        entityfireball.field_92057_e = this.explosionStrength;
                        this.worldObj.spawnEntityInWorld((Entity)entityfireball);
                        entityfireball.posX = this.posX + vec3.xCoord * d8;
                        entityfireball.posY = this.posY + vec3.yCoord * d8 + 1.0;
                        entityfireball.posZ = this.posZ + vec3.zCoord * d8;
                    }
                    break;
                }
            }
        }
    }

    public class EntityAIFindEntityNearestInjuredAlly
    extends EntityAIBase {
        private EntityGhastMinion field_179434_b;
        private EntityLivingBase field_179433_e;

        public EntityAIFindEntityNearestInjuredAlly(EntityGhastMinion entityCaveSpiderPriest) {
            this.field_179434_b = entityCaveSpiderPriest;
        }

        public boolean shouldExecute() {
            if (!this.field_179434_b.isEntityAlive()) {
                return false;
            }
            if (this.field_179434_b.getMinionType() != EnumMinionType.PRIEST) {
                return false;
            }
            if (this.field_179433_e != null) {
                return false;
            }
            double d0 = this.func_179431_f();
            List list = this.field_179434_b.worldObj.getEntitiesWithinAABB(EntityGhastMinion.class, this.field_179434_b.boundingBox.expand(d0, d0, d0));
            if (list.isEmpty()) {
                return false;
            }
            for (int i = 0; i < list.size(); ++i) {
                EntityGhastMinion entity = (EntityGhastMinion)list.get(i);
                if (!(entity.getHealth() < entity.getMaxHealth()) || !entity.isEntityAlive()) continue;
                this.field_179433_e = entity;
            }
            return true;
        }

        public boolean continueExecuting() {
            EntityLiving entitylivingbase = this.field_179434_b.entityToHeal;
            if (entitylivingbase == null) {
                return false;
            }
            if (!entitylivingbase.isEntityAlive()) {
                return false;
            }
            if (entitylivingbase.getHealth() >= entitylivingbase.getMaxHealth()) {
                return false;
            }
            double d0 = this.func_179431_f();
            return this.field_179434_b.getDistanceSqToEntity((Entity)entitylivingbase) <= d0 * d0;
        }

        public void startExecuting() {
            this.field_179434_b.entityToHeal = (EntityLiving)this.field_179433_e;
            super.startExecuting();
        }

        public void resetTask() {
            this.field_179434_b.entityToHeal = null;
            this.field_179433_e = null;
            super.resetTask();
        }

        protected double func_179431_f() {
            return 100.0;
        }
    }
}

