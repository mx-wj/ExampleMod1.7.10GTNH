/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.command.IEntitySelector
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIArrowAttack
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAIWander
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityWitherTurret;
import net.minecraft.entity.titan.EntityWitherTurretGround;
import net.minecraft.entity.titan.EntityWitherTurretMortar;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.IMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EntityWitherzillaMinion
extends EntityMob
implements IRangedAttackMob,
IMinion {
    private float[] field_82220_d = new float[2];
    private float[] field_82221_e = new float[2];
    private float[] field_82217_f = new float[2];
    private float[] field_82218_g = new float[2];
    private int[] field_82223_h = new int[2];
    private int[] field_82224_i = new int[2];
    private int blockBreakCounter;
    private static final IEntitySelector attackEntitySelector = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_180027_1_) {
            return !(p_180027_1_ instanceof EntityWitherzilla) && !(p_180027_1_ instanceof EntityWitherzillaMinion) && !(p_180027_1_ instanceof EntityWitherTurret) && !(p_180027_1_ instanceof EntityWitherTurretGround) && !(p_180027_1_ instanceof EntityWitherTurretMortar);
        }
    };

    public EntityWitherzillaMinion(World worldIn) {
        super(worldIn);
        this.setHealth(this.getMaxHealth());
        this.setSize(0.9f, 3.5f);
        this.isImmuneToFire = true;
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 40, 64.0f));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.5));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLivingBase.class, 0, false, false, attackEntitySelector));
        this.experienceValue = 20;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(17, (Object)new Integer(0));
        this.dataWatcher.addObject(18, (Object)new Integer(0));
        this.dataWatcher.addObject(19, (Object)new Integer(0));
        this.dataWatcher.addObject(20, (Object)new Integer(0));
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.setInvulTime(tagCompund.getInteger("Invul"));
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("Invul", this.getInvulTime());
    }

    public int getInvulTime() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setInvulTime(int p_82215_1_) {
        this.dataWatcher.updateObject(20, (Object)p_82215_1_);
    }

    public float getBlockPathWeight(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
        return this.worldObj.getBlock(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == Blocks.obsidian ? 10.0f : super.getBlockPathWeight(p_70783_1_, p_70783_2_, p_70783_3_);
    }

    public int getMaxSpawnedInChunk() {
        return 12;
    }

    protected boolean isValidLightLevel() {
        return true;
    }

    public boolean getCanSpawnHere() {
        return true;
    }

    protected String getLivingSound() {
        return "mob.wither.idle";
    }

    protected String getHurtSound() {
        return "mob.wither.hurt";
    }

    protected String getDeathSound() {
        return "mob.wither.death";
    }

    public void onLivingUpdate() {
        int j;
        int i;
        double d5;
        double d1;
        double d3;
        Entity entity;
        if (this.getAttackTarget() instanceof EntityWitherzilla) {
            this.setAttackTarget(null);
        }
        this.motionY *= (double)0.6f;
        if (!this.worldObj.isRemote && this.getWatchedTargetId(0) > 0 && (entity = this.worldObj.getEntityByID(this.getWatchedTargetId(0))) != null) {
            double d0;
            if (this.posY < entity.posY || !this.isArmored() && this.posY < entity.posY + 5.0 + (double)entity.getEyeHeight()) {
                if (this.motionY < 0.0) {
                    this.motionY = 0.0;
                }
                this.motionY += (0.5 - this.motionY) * (double)0.6f;
            }
            if ((d3 = (d0 = entity.posX - this.posX) * d0 + (d1 = entity.posZ - this.posZ) * d1) > 9.0) {
                d5 = MathHelper.sqrt_double((double)d3);
                this.motionX += (d0 / d5 * 0.5 - this.motionX) * (double)0.6f;
                this.motionZ += (d1 / d5 * 0.5 - this.motionZ) * (double)0.6f;
            }
        }
        if (this.motionX * this.motionX + this.motionZ * this.motionZ != 0.0) {
            this.rotationYaw = (float)Math.atan2(this.motionZ, this.motionX) * 57.295776f - 90.0f;
        }
        super.onLivingUpdate();
        for (i = 0; i < 2; ++i) {
            this.field_82218_g[i] = this.field_82221_e[i];
            this.field_82217_f[i] = this.field_82220_d[i];
        }
        for (i = 0; i < 2; ++i) {
            int j2 = this.getWatchedTargetId(i + 1);
            Entity entity1 = null;
            if (j2 > 0) {
                entity1 = this.worldObj.getEntityByID(j2);
            }
            if (entity1 != null) {
                d1 = this.func_82214_u(i + 1);
                d3 = this.func_82208_v(i + 1);
                d5 = this.func_82213_w(i + 1);
                double d6 = entity1.posX - d1;
                double d7 = entity1.posY + (double)entity1.getEyeHeight() - d3;
                double d8 = entity1.posZ - d5;
                double d9 = MathHelper.sqrt_double((double)(d6 * d6 + d8 * d8));
                float f = (float)(Math.atan2(d8, d6) * 180.0 / Math.PI) - 90.0f;
                float f1 = (float)(-(Math.atan2(d7, d9) * 180.0 / Math.PI));
                this.field_82220_d[i] = this.func_82204_b(this.field_82220_d[i], f1, 40.0f);
                this.field_82221_e[i] = this.func_82204_b(this.field_82221_e[i], f, 10.0f);
                continue;
            }
            this.field_82221_e[i] = this.func_82204_b(this.field_82221_e[i], this.renderYawOffset, 10.0f);
        }
        boolean flag = this.isArmored();
        for (j = 0; j < 3; ++j) {
            double d10 = this.func_82214_u(j);
            double d2 = this.func_82208_v(j);
            double d4 = this.func_82213_w(j);
            this.worldObj.spawnParticle("smoke", d10 + this.rand.nextGaussian() * (double)0.3f, d2 + this.rand.nextGaussian() * (double)0.3f, d4 + this.rand.nextGaussian() * (double)0.3f, 0.0, 0.0, 0.0);
            if (!flag || this.worldObj.rand.nextInt(4) != 0) continue;
            this.worldObj.spawnParticle("mobSpell", d10 + this.rand.nextGaussian() * (double)0.3f, d2 + this.rand.nextGaussian() * (double)0.3f, d4 + this.rand.nextGaussian() * (double)0.3f, (double)0.7f, (double)0.7f, 0.5);
        }
        if (this.getInvulTime() > 0) {
            for (j = 0; j < 3; ++j) {
                this.worldObj.spawnParticle("mobSpell", this.posX + this.rand.nextGaussian() * 1.0, this.posY + (double)(this.rand.nextFloat() * 3.3f), this.posZ + this.rand.nextGaussian() * 1.0, (double)0.7f, (double)0.7f, (double)0.9f);
            }
        }
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void updateAITasks() {
        if (this.getInvulTime() > 0) {
            int i = this.getInvulTime() - 1;
            if (i <= 0) {
                this.worldObj.newExplosion((Entity)this, this.posX, this.posY + (double)this.getEyeHeight(), this.posZ, 7.0f, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                this.worldObj.playBroadcastSound(1013, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
            this.setInvulTime(i);
            if (this.ticksExisted % 10 == 0) {
                this.heal(10.0f);
            }
        } else {
            int i1;
            int i;
            super.updateAITasks();
            block0: for (i = 1; i < 3; ++i) {
                if (this.ticksExisted < this.field_82223_h[i - 1]) continue;
                this.field_82223_h[i - 1] = this.ticksExisted + 10 + this.rand.nextInt(10);
                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                    int k2 = i - 1;
                    int l2 = this.field_82224_i[i - 1];
                    this.field_82224_i[k2] = this.field_82224_i[i - 1] + 1;
                    if (l2 > 15) {
                        float f = 10.0f;
                        float f1 = 5.0f;
                        double d0 = MathHelper.getRandomDoubleInRange((Random)this.rand, (double)(this.posX - (double)f), (double)(this.posX + (double)f));
                        double d1 = MathHelper.getRandomDoubleInRange((Random)this.rand, (double)(this.posY - (double)f1), (double)(this.posY + (double)f1));
                        double d2 = MathHelper.getRandomDoubleInRange((Random)this.rand, (double)(this.posZ - (double)f), (double)(this.posZ + (double)f));
                        this.launchWitherSkullToCoords(i + 1, d0, d1, d2, true);
                        this.field_82224_i[i - 1] = 0;
                    }
                }
                if ((i1 = this.getWatchedTargetId(i)) > 0) {
                    Entity entity = this.worldObj.getEntityByID(i1);
                    if (entity != null && entity.isEntityAlive() && this.getDistanceSqToEntity(entity) <= 900.0 && this.canEntityBeSeen(entity)) {
                        this.launchWitherSkullToEntity(i + 1, (EntityLivingBase)entity);
                        this.field_82223_h[i - 1] = this.ticksExisted + 40 + this.rand.nextInt(20);
                        this.field_82224_i[i - 1] = 0;
                        continue;
                    }
                    this.func_82211_c(i, 0);
                    continue;
                }
                List list = this.worldObj.selectEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0, 8.0, 20.0), attackEntitySelector);
                for (int k1 = 0; k1 < 10 && !list.isEmpty(); ++k1) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase)list.get(this.rand.nextInt(list.size()));
                    if (entitylivingbase != this && entitylivingbase.isEntityAlive() && this.canEntityBeSeen((Entity)entitylivingbase)) {
                        if (entitylivingbase instanceof EntityPlayer) {
                            if (((EntityPlayer)entitylivingbase).capabilities.disableDamage) continue block0;
                            this.func_82211_c(i, entitylivingbase.getEntityId());
                            continue block0;
                        }
                        this.func_82211_c(i, entitylivingbase.getEntityId());
                        continue block0;
                    }
                    list.remove(entitylivingbase);
                }
            }
            if (this.getAttackTarget() != null) {
                this.func_82211_c(0, this.getAttackTarget().getEntityId());
            } else {
                this.func_82211_c(0, 0);
            }
            if (this.blockBreakCounter > 0) {
                --this.blockBreakCounter;
                if (this.blockBreakCounter == 0 && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                    i = MathHelper.floor_double((double)this.posY);
                    i1 = MathHelper.floor_double((double)this.posX);
                    int j1 = MathHelper.floor_double((double)this.posZ);
                    boolean flag = false;
                    for (int l1 = -1; l1 <= 1; ++l1) {
                        for (int i2 = -1; i2 <= 1; ++i2) {
                            for (int j = 0; j <= 3; ++j) {
                                int j2 = i1 + l1;
                                int k = i + j;
                                int l = j1 + i2;
                                Block block = this.worldObj.getBlock(j2, k, l);
                                if (block.isAir((IBlockAccess)this.worldObj, j2, k, l) || !this.canEntityDestroy(block, (IBlockAccess)this.worldObj, j2, k, l, (Entity)this)) continue;
                                flag = this.worldObj.func_147480_a(j2, k, l, true) || flag;
                            }
                        }
                    }
                    if (flag) {
                        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    }
                }
            }
            if (this.ticksExisted % 20 == 0) {
                this.heal(1.0f);
            }
        }
    }

    public boolean canEntityDestroy(Block block, IBlockAccess world, int x, int y, int z, Entity entity) {
        return block != Blocks.bedrock && block != Blocks.end_portal && block != Blocks.end_portal_frame && block != Blocks.command_block;
    }

    public void func_82206_m() {
        this.setInvulTime(220);
        this.setHealth(this.getMaxHealth() / 3.0f);
    }

    public void setInWeb() {
    }

    public int getTotalArmorValue() {
        return 4;
    }

    private double func_82214_u(int p_82214_1_) {
        if (p_82214_1_ <= 0) {
            return this.posX;
        }
        float f = (this.renderYawOffset + (float)(180 * (p_82214_1_ - 1))) / 180.0f * (float)Math.PI;
        float f1 = MathHelper.cos((float)f);
        return this.posX + (double)f1 * 1.2;
    }

    private double func_82208_v(int p_82208_1_) {
        return p_82208_1_ <= 0 ? this.posY + 3.0 : this.posY + 2.25;
    }

    private double func_82213_w(int p_82213_1_) {
        if (p_82213_1_ <= 0) {
            return this.posZ;
        }
        float f = (this.renderYawOffset + (float)(180 * (p_82213_1_ - 1))) / 180.0f * (float)Math.PI;
        float f1 = MathHelper.sin((float)f);
        return this.posZ + (double)f1 * 1.2;
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
        this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.posX, p_82216_2_.posY + (double)p_82216_2_.getEyeHeight() * 0.5, p_82216_2_.posZ, p_82216_1_ == 0 && this.rand.nextFloat() < 0.001f);
    }

    private void launchWitherSkullToCoords(int p_82209_1_, double p_82209_2_, double p_82209_4_, double p_82209_6_, boolean p_82209_8_) {
        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1014, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        double d3 = this.func_82214_u(p_82209_1_);
        double d4 = this.func_82208_v(p_82209_1_);
        double d5 = this.func_82213_w(p_82209_1_);
        double d6 = p_82209_2_ - d3;
        double d7 = p_82209_4_ - d4;
        double d8 = p_82209_6_ - d5;
        EntityWitherSkull entitywitherskull = new EntityWitherSkull(this.worldObj, (EntityLivingBase)this, d6, d7, d8);
        if (p_82209_8_) {
            entitywitherskull.setInvulnerable(true);
        }
        entitywitherskull.posY = d4;
        entitywitherskull.posX = d3;
        entitywitherskull.posZ = d5;
        this.worldObj.spawnEntityInWorld((Entity)entitywitherskull);
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.launchWitherSkullToEntity(0, p_82196_1_);
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable() || source.isExplosion()) {
            return false;
        }
        if (source != DamageSource.drown && !(source.getEntity() instanceof EntityWitherzillaMinion) && !(source.getEntity() instanceof EntityWitherzilla)) {
            Entity entity;
            if (this.getInvulTime() > 0 && source != DamageSource.outOfWorld) {
                return false;
            }
            if (this.isArmored() && (entity = source.getSourceOfDamage()) instanceof EntityArrow) {
                return false;
            }
            entity = source.getEntity();
            if (entity instanceof EntityLivingBase) {
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(32.0, 32.0, 32.0));
                for (int i = 0; i < list.size(); ++i) {
                    Entity entity1 = (Entity)list.get(i);
                    if (entity1 instanceof EntityWitherzillaMinion) {
                        EntityWitherzillaMinion entitypigzombie = (EntityWitherzillaMinion)entity1;
                        entitypigzombie.setAttackTarget((EntityLivingBase)entity);
                        entitypigzombie.setRevengeTarget((EntityLivingBase)entity);
                        entitypigzombie.func_82211_c(1, entity.getEntityId());
                        entitypigzombie.func_82211_c(2, entity.getEntityId());
                    }
                    this.setAttackTarget((EntityLivingBase)entity);
                    this.setRevengeTarget((EntityLivingBase)entity);
                    this.func_82211_c(1, entity.getEntityId());
                    this.func_82211_c(2, entity.getEntityId());
                }
            }
            if (entity != null && entity instanceof EntityWitherzilla || entity != null && entity instanceof EntityWitherzillaMinion) {
                return false;
            }
            if (this.blockBreakCounter <= 0) {
                this.blockBreakCounter = 20;
            }
            int i = 0;
            while (i < this.field_82224_i.length) {
                int n = i++;
                this.field_82224_i[n] = this.field_82224_i[n] + 3;
            }
            return super.attackEntityFrom(source, amount);
        }
        return false;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.rand.nextInt(4) == 0) {
            this.dropItem(Items.nether_star, 1);
        }
    }

    protected void despawnEntity() {
        this.entityAge = 0;
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 0xF000F0;
    }

    protected void fall(float p_70069_1_) {
    }

    public void addPotionEffect(PotionEffect p_70690_1_) {
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0);
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

    public void mountEntity(Entity entityIn) {
        this.ridingEntity = null;
    }

    @Override
    public EnumMinionType getMinionType() {
        return EnumMinionType.LOYALIST;
    }
}

