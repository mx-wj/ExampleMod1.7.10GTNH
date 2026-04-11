/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityWebShot
extends EntityFireball {
    private int field_145795_e = -1;
    private int field_145793_f = -1;
    private int field_145794_g = -1;
    private Block field_145796_h;
    private boolean inGround;
    private int ticksAlive;
    private int ticksInAir;

    public EntityWebShot(World worldIn) {
        super(worldIn);
        this.setSize(3.0f, 3.0f);
    }

    public EntityWebShot(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
        this.setSize(3.0f, 3.0f);
    }

    public EntityWebShot(World worldIn, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(worldIn, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
        this.setSize(3.0f, 3.0f);
    }

    protected void onImpact(MovingObjectPosition movingObject) {
        if (!this.worldObj.isRemote) {
            if (movingObject.entityHit != null) {
                if (this.shootingEntity != null && this.shootingEntity instanceof EntitySpiderTitan && ((EntitySpiderTitan)this.shootingEntity).canAttackClass(movingObject.entityHit.getClass())) {
                    ((EntitySpiderTitan)this.shootingEntity).attackChoosenEntity(movingObject.entityHit, (float)((EntitySpiderTitan)this.shootingEntity).getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue(), ((EntitySpiderTitan)this.shootingEntity).getKnockbackAmount());
                    int i1 = MathHelper.floor_double((double)(this.posY + 1.0));
                    int i11 = MathHelper.floor_double((double)this.posX);
                    int j1 = MathHelper.floor_double((double)this.posZ);
                    boolean flag = false;
                    for (int l1 = -2 - this.rand.nextInt(4); l1 <= 2 + this.rand.nextInt(4); ++l1) {
                        for (int i2 = -2 - this.rand.nextInt(4); i2 <= 2 + this.rand.nextInt(4); ++i2) {
                            for (int j = -2 - this.rand.nextInt(4); j <= 2 + this.rand.nextInt(4); ++j) {
                                int j2 = i11 + l1;
                                int k = i1 + j;
                                int l = j1 + i2;
                                Block block1 = this.worldObj.getBlock(j2, k, l);
                                if (block1.isOpaqueCube()) continue;
                                this.worldObj.setBlock(j2, k, l, Blocks.web);
                            }
                        }
                    }
                    this.setDead();
                }
            } else {
                int x = movingObject.blockX;
                int y = movingObject.blockY;
                int z = movingObject.blockZ;
                if (this.worldObj.getBlock(x, y, z) != Blocks.web) {
                    switch (movingObject.sideHit) {
                        case 0: {
                            --y;
                            break;
                        }
                        case 1: {
                            ++y;
                            break;
                        }
                        case 2: {
                            --z;
                            break;
                        }
                        case 3: {
                            ++z;
                            break;
                        }
                        case 4: {
                            --x;
                            break;
                        }
                        case 5: {
                            ++x;
                        }
                    }
                    if (this.worldObj.isAirBlock(x, y, z)) {
                        int i1 = x;
                        int i11 = y;
                        int j1 = z;
                        boolean flag = false;
                        for (int l1 = -2 - this.rand.nextInt(4); l1 <= 2 + this.rand.nextInt(4); ++l1) {
                            for (int i2 = -2 - this.rand.nextInt(4); i2 <= 2 + this.rand.nextInt(4); ++i2) {
                                for (int j = -2 - this.rand.nextInt(4); j <= 2 + this.rand.nextInt(4); ++j) {
                                    int j2 = i11 + l1;
                                    int k = i1 + j;
                                    int l = j1 + i2;
                                    Block block1 = this.worldObj.getBlock(j2, k, l);
                                    if (block1.isOpaqueCube()) continue;
                                    this.worldObj.setBlock(j2, k, l, Blocks.web);
                                }
                            }
                        }
                        this.setDead();
                    }
                }
            }
        }
    }

    public void onUpdate() {
        this.noClip = true;
        if (this.shootingEntity != null && this.shootingEntity.isDead || !this.worldObj.blockExists((int)this.posX, (int)this.posY, (int)this.posZ)) {
            this.setDead();
        } else {
            ArrayList list1;
            this.onEntityUpdate();
            if (this.inGround) {
                if (this.worldObj.getBlock(this.field_145795_e, this.field_145793_f, this.field_145794_g) == this.field_145796_h) {
                    ++this.ticksAlive;
                    if (this.ticksAlive == 600) {
                        this.setDead();
                    }
                    return;
                }
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2f);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2f);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2f);
                this.ticksAlive = 0;
                this.ticksInAir = 0;
            } else {
                ++this.ticksInAir;
            }
            Vec3 vec3 = Vec3.createVectorHelper((double)this.posX, (double)(this.posY + 1.5), (double)this.posZ);
            Vec3 vec31 = Vec3.createVectorHelper((double)(this.posX + this.motionX), (double)(this.posY + 1.5 + this.motionY), (double)(this.posZ + this.motionZ));
            MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31);
            vec3 = Vec3.createVectorHelper((double)this.posX, (double)(this.posY + 1.5), (double)this.posZ);
            vec31 = Vec3.createVectorHelper((double)(this.posX + this.motionX), (double)(this.posY + 1.5 + this.motionY), (double)(this.posZ + this.motionZ));
            if (movingobjectposition != null) {
                vec31 = Vec3.createVectorHelper((double)movingobjectposition.hitVec.xCoord, (double)movingobjectposition.hitVec.yCoord, (double)movingobjectposition.hitVec.zCoord);
            }
            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(2.0, 2.0, 2.0));
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); ++i) {
                    float f;
                    AxisAlignedBB axisalignedbb;
                    MovingObjectPosition movingobjectposition1;
                    Entity entity1 = (Entity)list.get(i);
                    if (!entity1.canBeCollidedWith() || this.ticksInAir < 5 || (movingobjectposition1 = (axisalignedbb = entity1.boundingBox.expand((double)(f = entity1.width), (double)f, (double)f)).calculateIntercept(vec3, vec31)) == null) continue;
                    entity = entity1;
                }
            }
            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }
            if (movingobjectposition != null) {
                this.onImpact(movingobjectposition);
            }
            if ((list1 = Lists.newArrayList((Iterable)this.worldObj.loadedEntityList)) != null && !list1.isEmpty() && this.shootingEntity != null && this.shootingEntity instanceof EntityTitan) {
                for (int i = 0; i < list1.size(); ++i) {
                    Entity entity1 = (Entity)list1.get(i);
                    if (!this.isEntityAlive() || !(entity1 instanceof EntityLivingBase) || entity1 instanceof EntityTitanPart || entity1 instanceof EntityTitan || !((EntityTitan)this.shootingEntity).canAttackClass(entity1.getClass()) || !(this.getDistanceSqToEntity(entity1) <= (double)(this.width * this.width + entity1.width * entity1.width) + 4.0)) continue;
                    this.onImpact(new MovingObjectPosition(entity1));
                }
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            float f1 = MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionZ * this.motionZ));
            this.rotationYaw = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / Math.PI) + 90.0f;
            this.rotationPitch = (float)(Math.atan2(f1, this.motionY) * 180.0 / Math.PI) - 90.0f;
            while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
                this.prevRotationPitch -= 360.0f;
            }
            while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
                this.prevRotationPitch += 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
                this.prevRotationYaw -= 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
                this.prevRotationYaw += 360.0f;
            }
            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
            float f2 = 0.99f;
            if (this.isInWater()) {
                for (int j = 0; j < 4; ++j) {
                    float f3 = 0.25f;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f3, this.posY - this.motionY * (double)f3, this.posZ - this.motionZ * (double)f3, this.motionX, this.motionY, this.motionZ);
                }
            }
            this.motionX += this.accelerationX;
            this.motionY += this.accelerationY;
            this.motionZ += this.accelerationZ;
            this.motionX *= (double)f2;
            this.motionY *= (double)f2;
            this.motionZ *= (double)f2;
            this.worldObj.spawnParticle("explode", this.posX, this.posY + 1.5, this.posZ, 0.0, 0.0, 0.0);
            this.setPosition(this.posX, this.posY, this.posZ);
        }
        for (int l1 = -1; l1 <= 1; ++l1) {
            for (int i2 = -1; i2 <= 1; ++i2) {
                for (int j = -1; j <= 1; ++j) {
                    int j2 = (int)this.posX + l1;
                    int k = (int)this.posY + 1 + j;
                    int l = (int)this.posZ + i2;
                    Block block1 = this.worldObj.getBlock(j2, k, l);
                    if (block1.isOpaqueCube() || this.ticksExisted <= 10) continue;
                    this.worldObj.setBlock(j2, k, l, Blocks.web);
                }
            }
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean isBurning() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    public boolean isInWater() {
        return false;
    }
}

