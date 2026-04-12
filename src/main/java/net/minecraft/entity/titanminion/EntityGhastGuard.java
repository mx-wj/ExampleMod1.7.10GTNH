/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.nbt.NBTTagCompound
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
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EntityGhastGuardFireball;
import net.minecraft.entity.titanminion.EntityPigZombieMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.IMinion;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGhastGuard
extends EntityCreature
implements IMob,
IMinion {
    public EntityLiving master;
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    private int explosionStrength = 3;

    public EntityGhastGuard(World worldIn) {
        super(worldIn);
        this.func_110163_bv();
        this.setSize(4.5f, 4.5f);
        this.isImmuneToFire = true;
        this.experienceValue = 20;
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.PigZombieTitanSorter));
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

    @Override
    public EnumMinionType getMinionType() {
        return EnumMinionType.SPECIAL;
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != EntityPigZombieMinion.class && p_70686_1_ != EntityGhastGuard.class && (p_70686_1_ != EntityPigZombieTitan.class || p_70686_1_ == EntityZombieTitan.class);
    }

    protected void despawnEntity() {
        this.entityAge = 0;
    }

    protected void fall(float p_70069_1_) {
    }

    protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
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
        this.ignoreFrustumCheck = true;
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if (this.getAttackTarget() != null) {
            this.getLookHelper().setLookPosition(this.getAttackTarget().posX, this.getAttackTarget().posY + (double)this.getAttackTarget().getEyeHeight(), this.getAttackTarget().posZ, 180.0f, 180.0f);
        }
    }

    protected void updateAITasks() {
        long perfNs = TitansPerf.begin();
        try {
        byte b0;
        byte b1;
        this.explosionStrength = 3;
        if (this.master != null) {
            if (this.master.getAttackTarget() != null) {
                this.setAttackTarget(this.master.getAttackTarget());
            }
        } else {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
            if (list != null && !list.isEmpty()) {
                for (int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity == null || !(entity instanceof EntityPigZombieTitan)) continue;
                    this.master = (EntityPigZombieTitan)entity;
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
        if (d3 < 1.0 || d3 > 3600.0) {
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
                if (this.master != null && this.getDistanceSqToEntity((Entity)this.master) > 2304.0) {
                    this.motionX += d0 / d3 * 0.3;
                    this.motionY += d1 / d3 * 0.3;
                    this.motionZ += d2 / d3 * 0.3;
                } else {
                    this.motionX += d0 / d3 * 0.1;
                    this.motionY += d1 / d3 * 0.1;
                    this.motionZ += d2 / d3 * 0.1;
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
            double d5 = this.targetedEntity.posX - (this.posX + vec3.xCoord * d8);
            double d6 = this.targetedEntity.posY - (this.posY + vec3.yCoord * d8 + 1.0);
            double d7 = this.targetedEntity.posZ - (this.posZ + vec3.zCoord * d8);
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0f / (float)Math.PI;
            if (this.canEntityBeSeen(this.targetedEntity)) {
                if (this.attackCounter == 10) {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1007, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                }
                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    EntityGhastGuardFireball entitylargefireball = new EntityGhastGuardFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7);
                    entitylargefireball.field_92057_e = this.explosionStrength;
                    entitylargefireball.posX = this.posX + vec3.xCoord * d8;
                    entitylargefireball.posY = this.posY + vec3.yCoord * d8 + 1.0;
                    entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
                    this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
                    this.attackCounter = -40;
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
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
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
        this.dataWatcher.addObject(16, (Object)0);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100.0);
    }

    protected String getLivingSound() {
        return "mob.ghast.moan";
    }

    protected String getHurtSound() {
        return "mob.ghast.scream";
    }

    protected String getDeathSound() {
        return "mob.ghast.death";
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

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("ExplosionPower", this.explosionStrength);
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        if (tagCompund.hasKey("ExplosionPower", 99)) {
            this.explosionStrength = tagCompund.getInteger("ExplosionPower");
        }
    }

    public float getEyeHeight() {
        return 3.0f;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source.getEntity() instanceof EntityPigZombieMinion || source.getEntity() instanceof EntityPigZombieTitan || source.getEntity() instanceof EntityGhastGuard) {
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

    class AILookAround
    extends EntityAIBase {
        private EntityGhastGuard field_179472_a;

        public AILookAround() {
            this.field_179472_a = EntityGhastGuard.this;
            this.setMutexBits(2);
        }

        public boolean shouldExecute() {
            return true;
        }

        public void updateTask() {
            if (this.field_179472_a.getAttackTarget() == null) {
                this.field_179472_a.renderYawOffset = this.field_179472_a.rotationYaw = -((float)Math.atan2(this.field_179472_a.motionX, this.field_179472_a.motionZ)) * 180.0f / (float)Math.PI;
            } else {
                EntityLivingBase entitylivingbase = this.field_179472_a.getAttackTarget();
                double d0 = 100.0;
                if (entitylivingbase.getDistanceSqToEntity((Entity)this.field_179472_a) < d0 * d0) {
                    double d1 = entitylivingbase.posX - this.field_179472_a.posX;
                    double d2 = entitylivingbase.posZ - this.field_179472_a.posZ;
                    this.field_179472_a.renderYawOffset = this.field_179472_a.rotationYaw = -((float)Math.atan2(d1, d2)) * 180.0f / (float)Math.PI;
                }
            }
        }
    }
}

