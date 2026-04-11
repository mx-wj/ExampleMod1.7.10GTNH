/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockEndPortal
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IEntityMultiPart
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityDragonPart
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titanminion;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.IMinion;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EntityDragonMinion
extends EntityLiving
implements IEntityMultiPart,
IMinion {
    public EntityLiving master;
    public double targetX;
    public double targetY;
    public double targetZ;
    public double[][] ringBuffer = new double[64][3];
    public int ringBufferIndex = -1;
    public EntityDragonPart[] dragonPartArray;
    public EntityDragonPart dragonPartHead;
    public EntityDragonPart dragonPartBody;
    public EntityDragonPart dragonPartTail1;
    public EntityDragonPart dragonPartTail2;
    public EntityDragonPart dragonPartTail3;
    public EntityDragonPart dragonPartWing1;
    public EntityDragonPart dragonPartWing2;
    public float prevAnimTime;
    public float animTime;
    public boolean forceNewTarget;
    public boolean slowed;
    private EntityLivingBase target;
    public int deathTicks;
    public EntityEnderCrystal healingEnderCrystal;

    public EntityDragonMinion(World p_i1700_1_) {
        super(p_i1700_1_);
        this.func_110163_bv();
        this.dragonPartHead = new EntityDragonPart((IEntityMultiPart)this, "head", 6.0f, 6.0f);
        this.dragonPartBody = new EntityDragonPart((IEntityMultiPart)this, "body", 8.0f, 8.0f);
        this.dragonPartTail1 = new EntityDragonPart((IEntityMultiPart)this, "tail", 4.0f, 4.0f);
        this.dragonPartTail2 = new EntityDragonPart((IEntityMultiPart)this, "tail", 4.0f, 4.0f);
        this.dragonPartTail3 = new EntityDragonPart((IEntityMultiPart)this, "tail", 4.0f, 4.0f);
        this.dragonPartWing1 = new EntityDragonPart((IEntityMultiPart)this, "wing", 4.0f, 4.0f);
        this.dragonPartWing2 = new EntityDragonPart((IEntityMultiPart)this, "wing", 4.0f, 4.0f);
        this.dragonPartArray = new EntityDragonPart[]{this.dragonPartHead, this.dragonPartBody, this.dragonPartTail1, this.dragonPartTail2, this.dragonPartTail3, this.dragonPartWing1, this.dragonPartWing2};
        this.setHealth(this.getMaxHealth());
        this.setSize(14.0f, 3.6f);
        this.noClip = true;
        this.isImmuneToFire = true;
        this.targetY = 100.0;
        this.ignoreFrustumCheck = true;
        if (this.getAttackTarget() != null) {
            this.target = this.getAttackTarget();
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8000.0);
    }

    protected void entityInit() {
        super.entityInit();
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
        return p_70686_1_ != EntityEndermanMinion.class && p_70686_1_ != EntityDragonMinion.class && p_70686_1_ != EntityEnderColossus.class;
    }

    public double[] getMovementOffsets(int p_70974_1_, float p_70974_2_) {
        if (this.getHealth() <= 0.0f) {
            p_70974_2_ = 0.0f;
        }
        p_70974_2_ = 1.0f - p_70974_2_;
        int j = this.ringBufferIndex - p_70974_1_ * 1 & 0x3F;
        int k = this.ringBufferIndex - p_70974_1_ * 1 - 1 & 0x3F;
        double[] adouble = new double[3];
        double d0 = this.ringBuffer[j][0];
        double d1 = MathHelper.wrapAngleTo180_double((double)(this.ringBuffer[k][0] - d0));
        adouble[0] = d0 + d1 * (double)p_70974_2_;
        d0 = this.ringBuffer[j][1];
        d1 = this.ringBuffer[k][1] - d0;
        adouble[1] = d0 + d1 * (double)p_70974_2_;
        adouble[2] = this.ringBuffer[j][2] + (this.ringBuffer[k][2] - this.ringBuffer[j][2]) * (double)p_70974_2_;
        return adouble;
    }

    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        float f12;
        double d2;
        double d10;
        float f2;
        float f1;
        float f;
        this.setSize(14.0f, 3.6f);
        if (this.ticksExisted == 20 || this.ticksExisted == 40) {
            this.attackEntityFromPart(this.dragonPartHead, new DamageSource("none"), 0.0f);
        }
        this.ignoreFrustumCheck = true;
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if (this.worldObj.isRemote) {
            f = MathHelper.cos((float)(this.animTime * (float)Math.PI * 2.0f));
            f1 = MathHelper.cos((float)(this.prevAnimTime * (float)Math.PI * 2.0f));
            if (f1 <= -0.3f && f >= -0.3f) {
                this.worldObj.playSound(this.posX, this.posY, this.posZ, "mob.enderdragon.wings", 5.0f, 0.8f + this.rand.nextFloat() * 0.3f, false);
            }
        }
        this.prevAnimTime = this.animTime;
        if (this.getHealth() <= 0.0f) {
            f = (this.rand.nextFloat() - 0.5f) * 8.0f;
            f1 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            f2 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle("largeexplode", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        } else {
            this.updateDragonEnderCrystal();
            f = 0.2f / (MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionZ * this.motionZ)) * 10.0f + 1.0f);
            this.animTime = this.slowed ? (this.animTime += f * 0.5f) : (this.animTime += (f *= (float)Math.pow(2.0, this.motionY)));
        }
        if (this.getAttackTarget() != null && !this.getAttackTarget().isEntityAlive()) {
            this.setAttackTarget(null);
        }
        if (this.master != null) {
            if (this.getDistanceSqToEntity((Entity)this.master) > 10000.0) {
                this.forceNewTarget = true;
            }
            if (this.master.getAttackTarget() != null) {
                this.setAttackTarget(this.master.getAttackTarget());
            }
        } else {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
            if (list != null && !list.isEmpty()) {
                for (int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity == null || !(entity instanceof EntityEnderColossus)) continue;
                    this.master = (EntityEnderColossus)entity;
                }
            }
        }
        this.rotationYaw = MathHelper.wrapAngleTo180_float((float)this.rotationYaw);
        if (this.ringBufferIndex < 0) {
            for (int i = 0; i < this.ringBuffer.length; ++i) {
                this.ringBuffer[i][0] = this.rotationYaw;
                this.ringBuffer[i][1] = this.posY;
            }
        }
        if (++this.ringBufferIndex == this.ringBuffer.length) {
            this.ringBufferIndex = 0;
        }
        this.ringBuffer[this.ringBufferIndex][0] = this.rotationYaw;
        this.ringBuffer[this.ringBufferIndex][1] = this.posY;
        if (this.worldObj.isRemote) {
            if (this.newPosRotationIncrements > 0) {
                d10 = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
                double d0 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
                double d1 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
                d2 = MathHelper.wrapAngleTo180_double((double)(this.newRotationYaw - (double)this.rotationYaw));
                this.rotationYaw = (float)((double)this.rotationYaw + d2 / (double)this.newPosRotationIncrements);
                this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
                --this.newPosRotationIncrements;
                this.setPosition(d10, d0, d1);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            }
        } else {
            d10 = this.targetX - this.posX;
            double d0 = this.targetY - this.posY;
            double d1 = this.targetZ - this.posZ;
            d2 = d10 * d10 + d0 * d0 + d1 * d1;
            if (this.target != null) {
                this.targetX = this.target.posX;
                this.targetZ = this.target.posZ;
                double d3 = this.targetX - this.posX;
                double d5 = this.targetZ - this.posZ;
                double d7 = Math.sqrt(d3 * d3 + d5 * d5);
                double d8 = 0.5 + d7 / 80.0 - 1.0;
                if (d8 > 10.0) {
                    d8 = 10.0;
                }
                this.targetY = this.target.posY + d8 + 1.0;
            } else {
                this.targetX += this.rand.nextGaussian() * 2.0;
                this.targetZ += this.rand.nextGaussian() * 2.0;
            }
            if (this.forceNewTarget || d2 < 64.0 || d2 > 22500.0 || this.isCollidedHorizontally || this.isCollidedVertically) {
                this.setNewTarget();
            }
            if ((d0 /= (double)MathHelper.sqrt_double((double)(d10 * d10 + d1 * d1))) < (double)(-(f12 = 0.6f))) {
                d0 = -f12;
            }
            if (d0 > (double)f12) {
                d0 = f12;
            }
            this.motionY += d0 * (double)0.1f;
            this.rotationYaw = MathHelper.wrapAngleTo180_float((float)this.rotationYaw);
            double d4 = 180.0 - Math.atan2(d10, d1) * 180.0 / Math.PI;
            double d6 = MathHelper.wrapAngleTo180_double((double)(d4 - (double)this.rotationYaw));
            if (d6 > 50.0) {
                d6 = 50.0;
            }
            if (d6 < -50.0) {
                d6 = -50.0;
            }
            Vec3 vec3 = Vec3.createVectorHelper((double)(this.targetX - this.posX), (double)(this.targetY - this.posY), (double)(this.targetZ - this.posZ)).normalize();
            Vec3 vec32 = Vec3.createVectorHelper((double)MathHelper.sin((float)(this.rotationYaw * (float)Math.PI / 180.0f)), (double)this.motionY, (double)(-MathHelper.cos((float)(this.rotationYaw * (float)Math.PI / 180.0f)))).normalize();
            float f5 = (float)(vec32.dotProduct(vec3) + 0.5) / 1.5f;
            if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            this.randomYawVelocity *= 0.8f;
            float f6 = MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionZ * this.motionZ)) * 1.0f + 1.0f;
            double d9 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0 + 1.0;
            if (d9 > 40.0) {
                d9 = 40.0;
            }
            this.randomYawVelocity = (float)((double)this.randomYawVelocity + d6 * ((double)0.7f / d9 / (double)f6));
            this.rotationYaw += this.randomYawVelocity * 0.1f;
            float f7 = (float)(2.0 / (d9 + 1.0));
            float f8 = 0.06f;
            this.moveFlying(0.0f, -1.0f, f8 * (f5 * f7 + (1.0f - f7)));
            if (this.isEntityAlive()) {
                if (this.target != null) {
                    this.moveEntity(this.motionX * 5.0, this.motionY * 5.0, this.motionZ * 5.0);
                } else if (this.getAttackTarget() != null) {
                    this.moveEntity(this.motionX * 2.0, this.motionY * 2.0, this.motionZ * 2.0);
                } else if (this.slowed) {
                    this.moveEntity(this.motionX * 0.75, this.motionY * 0.75, this.motionZ * 0.75);
                } else {
                    this.moveEntity(this.motionX, this.motionY, this.motionZ);
                }
            }
            Vec3 vec31 = Vec3.createVectorHelper((double)this.motionX, (double)this.motionY, (double)this.motionZ).normalize();
            float f9 = (float)(vec31.dotProduct(vec32) + 1.0) / 2.0f;
            f9 = 0.8f + 0.15f * f9;
            this.motionX *= (double)f9;
            this.motionZ *= (double)f9;
            this.motionY *= (double)0.91f;
        }
        this.renderYawOffset = this.rotationYaw;
        this.dragonPartHead.height = 3.0f;
        this.dragonPartHead.width = 3.0f;
        this.dragonPartTail1.height = 2.0f;
        this.dragonPartTail1.width = 2.0f;
        this.dragonPartTail2.height = 2.0f;
        this.dragonPartTail2.width = 2.0f;
        this.dragonPartTail3.height = 2.0f;
        this.dragonPartTail3.width = 2.0f;
        this.dragonPartBody.height = 3.0f;
        this.dragonPartBody.width = 5.0f;
        this.dragonPartWing1.height = 2.0f;
        this.dragonPartWing1.width = 4.0f;
        this.dragonPartWing2.height = 3.0f;
        this.dragonPartWing2.width = 4.0f;
        f1 = (float)(this.getMovementOffsets(5, 1.0f)[1] - this.getMovementOffsets(10, 1.0f)[1]) * 10.0f / 180.0f * (float)Math.PI;
        f2 = MathHelper.cos((float)f1);
        float f10 = -MathHelper.sin((float)f1);
        float f3 = this.rotationYaw * (float)Math.PI / 180.0f;
        float f11 = MathHelper.sin((float)f3);
        float f4 = MathHelper.cos((float)f3);
        this.dragonPartBody.onUpdate();
        this.dragonPartBody.setLocationAndAngles(this.posX + (double)(f11 * 0.5f), this.posY, this.posZ - (double)(f4 * 0.5f), 0.0f, 0.0f);
        this.dragonPartWing1.onUpdate();
        this.dragonPartWing1.setLocationAndAngles(this.posX + (double)(f4 * 4.5f), this.posY + 2.0, this.posZ + (double)(f11 * 4.5f), 0.0f, 0.0f);
        this.dragonPartWing2.onUpdate();
        this.dragonPartWing2.setLocationAndAngles(this.posX - (double)(f4 * 4.5f), this.posY + 2.0, this.posZ - (double)(f11 * 4.5f), 0.0f, 0.0f);
        this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.dragonPartTail1.boundingBox.expand(1.0, 1.0, 1.0)));
        this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.dragonPartTail2.boundingBox.expand(1.0, 1.0, 1.0)));
        this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.dragonPartTail3.boundingBox.expand(1.0, 1.0, 1.0)));
        this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.dragonPartWing1.boundingBox.expand(1.0, 1.0, 1.0)));
        this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.dragonPartWing2.boundingBox.expand(1.0, 1.0, 1.0)));
        this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.dragonPartBody.boundingBox.expand(1.0, 1.0, 1.0)));
        this.attackEntitiesInList(this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.dragonPartHead.boundingBox.expand(2.0, 2.0, 2.0)));
        double[] adouble1 = this.getMovementOffsets(5, 1.0f);
        double[] adouble = this.getMovementOffsets(0, 1.0f);
        f12 = MathHelper.sin((float)(this.rotationYaw * (float)Math.PI / 180.0f - this.randomYawVelocity * 0.01f));
        float f13 = MathHelper.cos((float)(this.rotationYaw * (float)Math.PI / 180.0f - this.randomYawVelocity * 0.01f));
        this.dragonPartHead.onUpdate();
        this.dragonPartHead.setLocationAndAngles(this.posX + (double)(f12 * 5.5f * f2), this.posY + (adouble[1] - adouble1[1]) * 1.0 + (double)(f10 * 5.5f), this.posZ - (double)(f13 * 5.5f * f2), 0.0f, 0.0f);
        for (int j = 0; j < 3; ++j) {
            EntityDragonPart entitydragonpart = null;
            if (j == 0) {
                entitydragonpart = this.dragonPartTail1;
            }
            if (j == 1) {
                entitydragonpart = this.dragonPartTail2;
            }
            if (j == 2) {
                entitydragonpart = this.dragonPartTail3;
            }
            double[] adouble2 = this.getMovementOffsets(12 + j * 2, 1.0f);
            float f14 = this.rotationYaw * (float)Math.PI / 180.0f + this.simplifyAngle(adouble2[0] - adouble1[0]) * (float)Math.PI / 180.0f * 1.0f;
            float f15 = MathHelper.sin((float)f14);
            float f16 = MathHelper.cos((float)f14);
            float f17 = 1.5f;
            float f18 = (float)(j + 1) * 2.0f;
            entitydragonpart.onUpdate();
            entitydragonpart.setLocationAndAngles(this.posX - (double)((f11 * f17 + f15 * f18) * f2), this.posY + (adouble2[1] - adouble1[1]) * 1.0 - (double)((f18 + f17) * f10) + 1.5, this.posZ + (double)((f4 * f17 + f16 * f18) * f2), 0.0f, 0.0f);
        }
        if (!this.worldObj.isRemote) {
            this.slowed = this.destroyBlocksInAABB(this.dragonPartHead.boundingBox) | this.destroyBlocksInAABB(this.dragonPartBody.boundingBox) | this.destroyBlocksInAABB(this.dragonPartTail1.boundingBox) | this.destroyBlocksInAABB(this.dragonPartTail2.boundingBox) | this.destroyBlocksInAABB(this.dragonPartTail3.boundingBox);
        }
        if (this.targetY >= 240.0) {
            this.targetY = 240.0;
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    private void updateDragonEnderCrystal() {
        if (this.healingEnderCrystal != null) {
            if (this.healingEnderCrystal.isDead) {
                if (!this.worldObj.isRemote) {
                    this.attackEntityFromPart(this.dragonPartHead, DamageSource.setExplosionSource((Explosion)null), 10.0f);
                }
                this.healingEnderCrystal = null;
            } else if (this.ticksExisted % 10 == 0 && this.getHealth() < this.getMaxHealth()) {
                this.setHealth(this.getHealth() + 1.0f);
            }
        }
        if (this.rand.nextInt(10) == 0) {
            float f = 32.0f;
            List<EntityEnderCrystal> list = this.worldObj.getEntitiesWithinAABB(EntityEnderCrystal.class, this.boundingBox.expand((double)f, (double)f, (double)f));
            EntityEnderCrystal entityendercrystal = null;
            double d0 = Double.MAX_VALUE;
            for (EntityEnderCrystal entityendercrystal1 : list) {
                double d1 = entityendercrystal1.getDistanceSqToEntity((Entity)this);
                if (!(d1 < d0)) continue;
                d0 = d1;
                entityendercrystal = entityendercrystal1;
            }
            this.healingEnderCrystal = entityendercrystal;
        }
    }

    private void collideWithEntities(List p_70970_1_) {
        double d0 = (this.dragonPartBody.boundingBox.minX + this.dragonPartBody.boundingBox.maxX) / 2.0;
        double d1 = (this.dragonPartBody.boundingBox.minZ + this.dragonPartBody.boundingBox.maxZ) / 2.0;
        Iterator iterator = p_70970_1_.iterator();
        while (iterator.hasNext() && this.ticksExisted > 20) {
            Entity entity = (Entity)iterator.next();
            if (!(entity instanceof EntityLivingBase) || !this.canAttackClass(entity.getClass()) || entity instanceof EntityTitan || !entity.canBeCollidedWith()) continue;
            double d2 = entity.posX - d0;
            double d3 = entity.posZ - d1;
            double d4 = d2 * d2 + d3 * d3;
            double d5 = 5.0;
            if (this.target != null) {
                d5 = 25.0;
            } else if (this.getAttackTarget() != null) {
                d5 = 10.0;
            } else if (this.slowed) {
                d5 = 3.75;
            }
            entity.addVelocity(d2 / d4 * d5, 0.33, d3 / d4 * d5);
        }
    }

    private void attackEntitiesInList(List p_70971_1_) {
        for (int i = 0; i < p_70971_1_.size(); ++i) {
            Entity entity = (Entity)p_70971_1_.get(i);
            if (!(entity instanceof EntityLivingBase) || !this.canAttackClass(entity.getClass())) continue;
            this.animTime += 1.0f;
            this.playLivingSound();
            entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 200.0f);
            entity.hurtResistantTime = 0;
        }
        this.collideWithEntities(p_70971_1_);
    }

    private void setNewTarget() {
        this.forceNewTarget = false;
        if (this.getAttackTarget() != null) {
            if (this.rand.nextInt(2) == 0) {
                this.target = this.getAttackTarget();
            } else {
                double d2;
                double d1;
                double d0;
                boolean flag = false;
                do {
                    this.targetX = this.getAttackTarget().posX;
                    this.targetY = (double)this.worldObj.getTopSolidOrLiquidBlock((int)this.getAttackTarget().posX, (int)this.getAttackTarget().posZ) + (double)(40.0f + this.rand.nextFloat() * 30.0f);
                    this.targetZ = this.getAttackTarget().posZ;
                    this.targetX += (double)MathHelper.cos((float)(this.ticksExisted / 20 + this.getEntityId())) * 60.0;
                    this.targetZ += (double)MathHelper.sin((float)(this.ticksExisted / 20 + this.getEntityId())) * 60.0;
                } while (!(flag = (d0 = this.posX - this.targetX) * d0 + (d1 = this.posY - this.targetY) * d1 + (d2 = this.posZ - this.targetZ) * d2 > 100.0));
                this.target = null;
            }
        } else if (this.master != null) {
            double d2;
            double d1;
            double d0;
            boolean flag = false;
            do {
                this.targetX = this.master.posX;
                this.targetY = this.master.posY + (double)(70.0f + this.rand.nextFloat() * 30.0f);
                this.targetZ = this.master.posZ;
                this.targetX += (double)(this.rand.nextFloat() * 100.0f - 50.0f);
                this.targetZ += (double)(this.rand.nextFloat() * 100.0f - 50.0f);
            } while (!(flag = (d0 = this.posX - this.targetX) * d0 + (d1 = this.posY - this.targetY) * d1 + (d2 = this.posZ - this.targetZ) * d2 > 100.0));
            this.target = null;
        } else {
            EntityPlayer player = this.worldObj.getClosestPlayerToEntity((Entity)this, 256.0);
            if (player != null) {
                double d2;
                double d1;
                double d0;
                boolean flag = false;
                do {
                    this.targetX = player.posX;
                    this.targetY = (double)this.worldObj.getTopSolidOrLiquidBlock((int)player.posX, (int)player.posZ) + (double)(40.0f + this.rand.nextFloat() * 30.0f);
                    this.targetZ = player.posZ;
                    this.targetX += (double)(this.rand.nextFloat() * 100.0f - 50.0f);
                    this.targetZ += (double)(this.rand.nextFloat() * 100.0f - 50.0f);
                } while (!(flag = (d0 = this.posX - this.targetX) * d0 + (d1 = this.posY - this.targetY) * d1 + (d2 = this.posZ - this.targetZ) * d2 > 100.0));
                this.target = null;
            } else {
                double d2;
                double d1;
                double d0;
                boolean flag = false;
                do {
                    this.targetX = 0.0;
                    this.targetY = 110.0f + this.rand.nextFloat() * 30.0f;
                    this.targetZ = 0.0;
                    this.targetX += (double)(this.rand.nextFloat() * 100.0f - 50.0f);
                    this.targetZ += (double)(this.rand.nextFloat() * 100.0f - 50.0f);
                } while (!(flag = (d0 = this.posX - this.targetX) * d0 + (d1 = this.posY - this.targetY) * d1 + (d2 = this.posZ - this.targetZ) * d2 > 100.0));
                this.target = null;
            }
        }
    }

    private float simplifyAngle(double p_70973_1_) {
        return (float)MathHelper.wrapAngleTo180_double((double)p_70973_1_);
    }

    private boolean destroyBlocksInAABB(AxisAlignedBB p_70972_1_) {
        int i = MathHelper.floor_double((double)p_70972_1_.minX);
        int j = MathHelper.floor_double((double)p_70972_1_.minY);
        int k = MathHelper.floor_double((double)p_70972_1_.minZ);
        int l = MathHelper.floor_double((double)p_70972_1_.maxX);
        int i1 = MathHelper.floor_double((double)p_70972_1_.maxY);
        int j1 = MathHelper.floor_double((double)p_70972_1_.maxZ);
        boolean flag = false;
        boolean flag1 = false;
        for (int k1 = i; k1 <= l; ++k1) {
            for (int l1 = j; l1 <= i1; ++l1) {
                for (int i2 = k; i2 <= j1; ++i2) {
                    Block block = this.worldObj.getBlock(k1, l1, i2);
                    if (block.isAir((IBlockAccess)this.worldObj, k1, l1, i2) || !this.isEntityAlive()) continue;
                    if (block != Blocks.obsidian && block != Blocks.end_stone && block != Blocks.bedrock && block.canEntityDestroy((IBlockAccess)this.worldObj, k1, l1, i2, (Entity)this) && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                        flag1 = this.worldObj.setBlockToAir(k1, l1, i2) || flag1;
                        continue;
                    }
                    flag = true;
                }
            }
        }
        if (flag1) {
            double d1 = p_70972_1_.minX + (p_70972_1_.maxX - p_70972_1_.minX) * (double)this.rand.nextFloat();
            double d2 = p_70972_1_.minY + (p_70972_1_.maxY - p_70972_1_.minY) * (double)this.rand.nextFloat();
            double d0 = p_70972_1_.minZ + (p_70972_1_.maxZ - p_70972_1_.minZ) * (double)this.rand.nextFloat();
            this.worldObj.spawnParticle("largeexplode", d1, d2, d0, 0.0, 0.0, 0.0);
        }
        return flag;
    }

    public boolean attackEntityFromPart(EntityDragonPart p_70965_1_, DamageSource source, float p_70965_3_) {
        if (p_70965_1_ != this.dragonPartHead) {
            p_70965_3_ = p_70965_3_ / 4.0f + 1.0f;
        }
        float f1 = this.rotationYaw * (float)Math.PI / 180.0f;
        float f2 = MathHelper.sin((float)f1);
        float f3 = MathHelper.cos((float)f1);
        this.targetX = this.posX + (double)(f2 * 5.0f) + (double)((this.rand.nextFloat() - 0.5f) * 2.0f);
        this.targetY = this.posY + (double)(this.rand.nextFloat() * 3.0f) + 1.0;
        this.targetZ = this.posZ - (double)(f3 * 5.0f) + (double)((this.rand.nextFloat() - 0.5f) * 2.0f);
        this.target = null;
        if (source.getEntity() != null && source.getEntity() instanceof EntityLivingBase && this.canAttackClass(source.getEntity().getClass())) {
            this.setAttackTarget((EntityLivingBase)source.getEntity());
            if (this.rand.nextInt(3) == 0) {
                this.forceNewTarget = true;
            }
            return this.attackEntityFrom(source, p_70965_3_);
        }
        return false;
    }

    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        if (p_70097_1_.getEntity() instanceof EntityEndermanMinion || p_70097_1_.getEntity() instanceof EntityEnderColossus || p_70097_1_.getEntity() instanceof EntityDragon || p_70097_1_.getEntity() instanceof EntityDragonMinion) {
            return false;
        }
        if (p_70097_1_.getDamageType() == "inFire" || p_70097_1_.getDamageType() == "onFire" || p_70097_1_.getDamageType() == "lava" || p_70097_1_.getDamageType() == "inWall" || p_70097_1_.getDamageType() == "drown" || p_70097_1_.getDamageType() == "starve" || p_70097_1_.getDamageType() == "cactus" || p_70097_1_.getDamageType() == "fall" || p_70097_1_.getDamageType() == "outOfWorld" || p_70097_1_.getDamageType() == "generic" || p_70097_1_.getDamageType() == "outOfWorld" || p_70097_1_.getDamageType() == "magic" || p_70097_1_.getDamageType() == "wither" || p_70097_1_.getDamageType() == "anvil" || p_70097_1_.getDamageType() == "fallingBlock" || p_70097_1_.getDamageType() == "explosion" || p_70097_1_.getDamageType() == "indirectMagic") {
            return false;
        }
        Entity entity = p_70097_1_.getEntity();
        if (entity instanceof EntityLivingBase) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1 instanceof EntityDragonMinion) {
                    EntityDragonMinion entitypigzombie = (EntityDragonMinion)entity1;
                    entitypigzombie.setAttackTarget((EntityLivingBase)entity);
                    entitypigzombie.setRevengeTarget((EntityLivingBase)entity);
                }
                this.setAttackTarget((EntityLivingBase)entity);
                this.setRevengeTarget((EntityLivingBase)entity);
            }
        }
        return super.attackEntityFrom(p_70097_1_, p_70097_2_);
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return true;
    }

    protected void onDeathUpdate() {
        ++this.deathTicks;
        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            float f = (this.rand.nextFloat() - 0.5f) * 8.0f;
            float f1 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        }
        this.moveEntity(this.motionX * 0.2, this.motionY * 0.2 + 0.15, this.motionZ * 0.2);
        this.rotationYaw = this.rotationYawHead += 10.0f;
        this.renderYawOffset = this.rotationYawHead;
        if (!this.worldObj.isRemote) {
            if (this.deathTicks == 1) {
                this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
            if (this.deathTicks >= 200) {
                if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                    int j;
                    for (int i = 500; i > 0; i -= j) {
                        j = EntityXPOrb.getXPSplit((int)i);
                        this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
                    }
                    this.worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, Blocks.dragon_egg);
                }
                this.setDead();
            }
        }
    }

    private void createEnderPortal(int p_70975_1_, int p_70975_2_) {
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
        this.worldObj.setBlock(p_70975_1_, b0 + 4, p_70975_2_, Blocks.dragon_egg);
        BlockEndPortal.field_149948_a = false;
    }

    protected void despawnEntity() {
        this.entityAge = 0;
    }

    public Entity[] getParts() {
        return this.dragonPartArray;
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public World func_82194_d() {
        return this.worldObj;
    }

    protected String getLivingSound() {
        return "mob.enderdragon.growl";
    }

    protected String getHurtSound() {
        return "mob.enderdragon.hit";
    }

    protected float getSoundVolume() {
        return 5.0f;
    }
}

