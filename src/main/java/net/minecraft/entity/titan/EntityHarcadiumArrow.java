/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.S2BPacketChangeGameState
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EntityHarcadiumArrow
extends EntityArrow {
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private Block inTile;
    private int inData;
    private boolean inGround;
    public int canBePickedUp;
    public int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    private double damage = 30.0;
    private int knockbackStrength;

    public EntityHarcadiumArrow(World worldIn) {
        super(worldIn);
        this.renderDistanceWeight = 10.0;
        this.setSize(0.5f, 0.5f);
    }

    public EntityHarcadiumArrow(World worldIn, double x, double y, double z) {
        super(worldIn);
        this.renderDistanceWeight = 10.0;
        this.setSize(0.5f, 0.5f);
        this.setPosition(x, y, z);
    }

    public EntityHarcadiumArrow(World worldIn, EntityLivingBase shooter, EntityLivingBase p_i1755_3_, float p_i1755_4_, float p_i1755_5_) {
        super(worldIn);
        this.renderDistanceWeight = 10.0;
        this.shootingEntity = shooter;
        if (shooter instanceof EntityPlayer) {
            this.canBePickedUp = 1;
        }
        this.posY = shooter.posY + (double)shooter.getEyeHeight() - (double)0.1f;
        double d0 = p_i1755_3_.posX - shooter.posX;
        double d1 = p_i1755_3_.boundingBox.minY + (double)(p_i1755_3_.height / 3.0f) - this.posY;
        double d2 = p_i1755_3_.posZ - shooter.posZ;
        double d3 = MathHelper.sqrt_double((double)(d0 * d0 + d2 * d2));
        if (d3 >= 1.0E-7) {
            float f2 = (float)(Math.atan2(d2, d0) * 180.0 / Math.PI) - 90.0f;
            float f3 = (float)(-(Math.atan2(d1, d3) * 180.0 / Math.PI));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.setLocationAndAngles(shooter.posX + d4, this.posY, shooter.posZ + d5, f2, f3);
            float f4 = (float)(d3 * (double)0.2f);
            this.setThrowableHeading(d0, d1 + (double)f4, d2, p_i1755_4_, p_i1755_5_);
        }
    }

    public EntityHarcadiumArrow(World worldIn, EntityLivingBase shooter, float p_i1756_3_) {
        super(worldIn);
        this.renderDistanceWeight = 10.0;
        this.shootingEntity = shooter;
        if (shooter instanceof EntityPlayer) {
            this.canBePickedUp = 1;
        }
        this.setSize(0.5f, 0.5f);
        this.setLocationAndAngles(shooter.posX, shooter.posY + (double)shooter.getEyeHeight(), shooter.posZ, shooter.rotationYaw, shooter.rotationPitch);
        this.posX -= (double)(MathHelper.cos((float)(this.rotationYaw / 180.0f * (float)Math.PI)) * 0.16f);
        this.posY -= (double)0.1f;
        this.posZ -= (double)(MathHelper.sin((float)(this.rotationYaw / 180.0f * (float)Math.PI)) * 0.16f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionX = -MathHelper.sin((float)(this.rotationYaw / 180.0f * (float)Math.PI)) * MathHelper.cos((float)(this.rotationPitch / 180.0f * (float)Math.PI));
        this.motionZ = MathHelper.cos((float)(this.rotationYaw / 180.0f * (float)Math.PI)) * MathHelper.cos((float)(this.rotationPitch / 180.0f * (float)Math.PI));
        this.motionY = -MathHelper.sin((float)(this.rotationPitch / 180.0f * (float)Math.PI));
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, p_i1756_3_ * 1.5f, 1.0f);
    }

    protected void entityInit() {
        this.dataWatcher.addObject(16, (Object)0);
    }

    public void setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy) {
        float f2 = MathHelper.sqrt_double((double)(x * x + y * y + z * z));
        x /= (double)f2;
        y /= (double)f2;
        z /= (double)f2;
        x += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)inaccuracy;
        y += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)inaccuracy;
        z += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)inaccuracy;
        this.motionX = x *= (double)velocity;
        this.motionY = y *= (double)velocity;
        this.motionZ = z *= (double)velocity;
        float f3 = MathHelper.sqrt_double((double)(x * x + z * z));
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(x, z) * 180.0 / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(y, f3) * 180.0 / Math.PI);
        this.ticksInGround = 0;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
        this.setPosition(p_180426_1_, p_180426_3_, p_180426_5_);
        this.setRotation(p_180426_7_, p_180426_8_);
    }

    @SideOnly(value=Side.CLIENT)
    public void setVelocity(double x, double y, double z) {
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f = MathHelper.sqrt_double((double)(x * x + z * z));
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(x, z) * 180.0 / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(y, f) * 180.0 / Math.PI);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    public void onUpdate() {
        Block block;
        this.onEntityUpdate();
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f = MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionZ * this.motionZ));
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0 / Math.PI);
        }
        if ((block = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile)).getMaterial() != Material.air) {
            block.setBlockBoundsBasedOnState((IBlockAccess)this.worldObj, this.xTile, this.yTile, this.zTile);
            AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
            if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper((double)this.posX, (double)this.posY, (double)this.posZ))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            int j = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
            if (block == this.inTile && j == this.inData) {
                ++this.ticksInGround;
                if (this.shootingEntity != null && (this.shootingEntity instanceof EntitySkeletonTitan || this.shootingEntity instanceof EntityLivingBase && ((EntityLivingBase)this.shootingEntity).getHeldItem() != null && EnchantmentHelper.getEnchantmentLevel((int)Enchantment.infinity.effectId, (ItemStack)((EntityLivingBase)this.shootingEntity).getHeldItem()) > 0) && this.ticksInGround > 80) {
                    switch (this.rand.nextInt(5)) {
                        case 0: {
                            EntityTNTPrimed tnt = new EntityTNTPrimed(this.worldObj, this.posX, this.posY, this.posZ, (EntityLivingBase)this.shootingEntity);
                            tnt.fuse = 40 + this.rand.nextInt(40);
                            tnt.playSound("game.tnt.primed", 1.0f, 1.0f);
                            if (this.worldObj.isRemote) break;
                            this.worldObj.spawnEntityInWorld((Entity)tnt);
                            break;
                        }
                        case 1: {
                            EntityCreeper creeper = new EntityCreeper(this.worldObj);
                            creeper.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
                            creeper.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
                            creeper.func_146079_cb();
                            if (this.worldObj.isRemote) break;
                            this.worldObj.spawnEntityInWorld((Entity)creeper);
                            break;
                        }
                        case 2: {
                            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX, this.posY, this.posZ, this.rand.nextFloat(), this.rand.nextFloat(), this.rand.nextFloat()));
                            break;
                        }
                        case 3: {
                            EntitySkeletonMinion skeleton = new EntitySkeletonMinion(this.worldObj);
                            skeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
                            skeleton.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 4, false));
                            if (this.shootingEntity instanceof EntitySkeletonTitan) {
                                skeleton.master = (EntitySkeletonTitan)this.shootingEntity;
                                skeleton.setSkeletonType(((EntitySkeletonTitan)this.shootingEntity).getSkeletonType());
                            }
                            if (this.rand.nextInt(2) == 0) {
                                skeleton.onSpawnWithEgg(null);
                            }
                            if (this.worldObj.isRemote) break;
                            this.worldObj.spawnEntityInWorld((Entity)skeleton);
                            break;
                        }
                        case 4: {
                            this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 2.0f, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                        }
                    }
                    this.setDead();
                }
                if (this.ticksInGround >= 1200 || this.ticksInGround >= 100 && !(this.shootingEntity instanceof EntityPlayer)) {
                    this.setDead();
                }
            } else {
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2f);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2f);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2f);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        } else {
            int i;
            ++this.ticksInAir;
            Vec3 vec31 = Vec3.createVectorHelper((double)this.posX, (double)this.posY, (double)this.posZ);
            Vec3 vec3 = Vec3.createVectorHelper((double)(this.posX + this.motionX), (double)(this.posY + this.motionY), (double)(this.posZ + this.motionZ));
            MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
            vec31 = Vec3.createVectorHelper((double)this.posX, (double)this.posY, (double)this.posZ);
            vec3 = Vec3.createVectorHelper((double)(this.posX + this.motionX), (double)(this.posY + this.motionY), (double)(this.posZ + this.motionZ));
            if (movingobjectposition != null) {
                vec3 = Vec3.createVectorHelper((double)movingobjectposition.hitVec.xCoord, (double)movingobjectposition.hitVec.yCoord, (double)movingobjectposition.hitVec.zCoord);
            }
            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0, 1.0));
            double d0 = 0.0;
            for (i = 0; i < list.size(); ++i) {
                double d1;
                float f1;
                AxisAlignedBB axisalignedbb1;
                MovingObjectPosition movingobjectposition1;
                Entity entity1 = (Entity)list.get(i);
                if (!entity1.canBeCollidedWith() || entity1 == this.shootingEntity && this.ticksInAir < 5 || (movingobjectposition1 = (axisalignedbb1 = entity1.boundingBox.expand((double)(f1 = 0.3f), (double)f1, (double)f1)).calculateIntercept(vec31, vec3)) == null || !((d1 = vec31.distanceTo(movingobjectposition1.hitVec)) < d0) && d0 != 0.0) continue;
                entity = entity1;
                d0 = d1;
            }
            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }
            if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
                if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)) {
                    movingobjectposition = null;
                }
            }
            if (movingobjectposition != null) {
                if (movingobjectposition.entityHit != null) {
                    float f2 = MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ));
                    int k = MathHelper.ceiling_double_int((double)((double)f2 * this.damage / 2.0));
                    if (this.getIsCritical()) {
                        k += this.rand.nextInt(k / 2 + 2);
                    }
                    DamageSource damagesource = this.shootingEntity == null ? DamageSourceExtra.causeHarcadiumArrowDamage(this, (Entity)this) : DamageSourceExtra.causeHarcadiumArrowDamage(this, this.shootingEntity);
                    if (movingobjectposition.entityHit.height >= 6.0f || movingobjectposition.entityHit instanceof EntityTitan) {
                        movingobjectposition.entityHit.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                        movingobjectposition.entityHit.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage(this.shootingEntity), 300.0f);
                        this.setDead();
                        if (this.canBePickedUp == 1) {
                            movingobjectposition.entityHit.dropItem(TitanItems.harcadiumArrow, 1);
                        }
                    }
                    if (this.isBurning()) {
                        movingobjectposition.entityHit.setFire(15);
                    }
                    if (movingobjectposition.entityHit.attackEntityFrom(damagesource, (float)k)) {
                        if (movingobjectposition.entityHit instanceof EntityLivingBase) {
                            float f4;
                            EntityLivingBase entitylivingbase = (EntityLivingBase)movingobjectposition.entityHit;
                            if (!this.worldObj.isRemote) {
                                entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
                            }
                            if (this.knockbackStrength > 0 && (f4 = MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionZ * this.motionZ))) > 0.0f) {
                                movingobjectposition.entityHit.addVelocity(this.motionX * (double)this.knockbackStrength * 0.8 / (double)f4, 0.5, this.motionZ * (double)this.knockbackStrength * 0.8 / (double)f4);
                            }
                            if (this.shootingEntity instanceof EntityLivingBase) {
                                EnchantmentHelper.func_151384_a((EntityLivingBase)entitylivingbase, (Entity)this.shootingEntity);
                                EnchantmentHelper.func_151385_b((EntityLivingBase)((EntityLivingBase)this.shootingEntity), (Entity)entitylivingbase);
                            }
                            if (this.shootingEntity != null && movingobjectposition.entityHit != this.shootingEntity && movingobjectposition.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
                                ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket((Packet)new S2BPacketChangeGameState(6, 0.0f));
                            }
                        }
                        this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                        if (!(movingobjectposition.entityHit instanceof EntityEnderman)) {
                            this.setDead();
                            if (this.canBePickedUp == 1) {
                                movingobjectposition.entityHit.dropItem(TitanItems.harcadiumArrow, 1);
                            }
                        }
                    } else {
                        if (movingobjectposition.entityHit instanceof EntityLivingBase && movingobjectposition.entityHit != this.shootingEntity && !(movingobjectposition.entityHit instanceof EntityTitan)) {
                            float f4;
                            if (this.knockbackStrength > 0 && (f4 = MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionZ * this.motionZ))) > 0.0f) {
                                movingobjectposition.entityHit.addVelocity(this.motionX * (double)this.knockbackStrength * 0.8 / (double)f4, 0.5, this.motionZ * (double)this.knockbackStrength * 0.8 / (double)f4);
                            }
                            this.worldObj.setEntityState((Entity)((EntityLivingBase)movingobjectposition.entityHit), (byte)2);
                            if (movingobjectposition.entityHit instanceof EntityLiving) {
                                ((EntityLiving)movingobjectposition.entityHit).getDataWatcher().updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)(((EntityLiving)movingobjectposition.entityHit).getHealth() - (float)k), (float)0.0f, (float)((EntityLiving)movingobjectposition.entityHit).getMaxHealth())));
                            }
                            if (!((EntityLivingBase)movingobjectposition.entityHit).isEntityAlive()) {
                                this.worldObj.setEntityState((Entity)((EntityLivingBase)movingobjectposition.entityHit), (byte)3);
                                ((EntityLivingBase)movingobjectposition.entityHit).onDeath(damagesource);
                            }
                        }
                        this.motionX *= (double)-0.1f;
                        this.motionY *= (double)-0.1f;
                        this.motionZ *= (double)-0.1f;
                        this.rotationYaw += 180.0f;
                        this.prevRotationYaw += 180.0f;
                        this.ticksInAir = 0;
                    }
                } else {
                    this.xTile = movingobjectposition.blockX;
                    this.yTile = movingobjectposition.blockY;
                    this.zTile = movingobjectposition.blockZ;
                    this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
                    this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                    this.motionX = (float)(movingobjectposition.hitVec.xCoord - this.posX);
                    this.motionY = (float)(movingobjectposition.hitVec.yCoord - this.posY);
                    this.motionZ = (float)(movingobjectposition.hitVec.zCoord - this.posZ);
                    float f2 = MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ));
                    this.posX -= this.motionX / (double)f2 * (double)0.05f;
                    this.posY -= this.motionY / (double)f2 * (double)0.05f;
                    this.posZ -= this.motionZ / (double)f2 * (double)0.05f;
                    this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.setIsCritical(false);
                    if (this.inTile.getMaterial() != Material.air) {
                        this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, (Entity)this);
                    }
                }
            }
            if (this.getIsCritical()) {
                for (i = 0; i < 4; ++i) {
                    this.worldObj.spawnParticle("critMagic", this.posX + this.motionX * (double)i / 4.0, this.posY + this.motionY * (double)i / 4.0, this.posZ + this.motionZ * (double)i / 4.0, -this.motionX, -this.motionY + 0.2, -this.motionZ);
                }
            }
            for (i = 0; i < 4; ++i) {
                this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double)i / 4.0, this.posY + this.motionY * (double)i / 4.0, this.posZ + this.motionZ * (double)i / 4.0, -this.motionX, -this.motionY + 0.2, -this.motionZ);
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            float f2 = MathHelper.sqrt_double((double)(this.motionX * this.motionX + this.motionZ * this.motionZ));
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / Math.PI);
            this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0 / Math.PI);
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
            float f3 = 0.99f;
            float f1 = 0.05f;
            if (this.isInWater()) {
                for (int l = 0; l < 4; ++l) {
                    float f4 = 0.25f;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f4, this.posY - this.motionY * (double)f4, this.posZ - this.motionZ * (double)f4, this.motionX, this.motionY, this.motionZ);
                }
                f3 = 0.8f;
            }
            if (this.isWet()) {
                this.extinguish();
            }
            this.motionX *= (double)f3;
            this.motionY *= (double)f3;
            this.motionZ *= (double)f3;
            this.motionY -= (double)f1;
            this.setPosition(this.posX, this.posY, this.posZ);
            this.func_145775_I();
        }
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
        p_70014_1_.setShort("xTile", (short)this.xTile);
        p_70014_1_.setShort("yTile", (short)this.yTile);
        p_70014_1_.setShort("zTile", (short)this.zTile);
        p_70014_1_.setShort("life", (short)this.ticksInGround);
        p_70014_1_.setByte("inTile", (byte)Block.getIdFromBlock((Block)this.inTile));
        p_70014_1_.setByte("inData", (byte)this.inData);
        p_70014_1_.setByte("shake", (byte)this.arrowShake);
        p_70014_1_.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        p_70014_1_.setByte("pickup", (byte)this.canBePickedUp);
        p_70014_1_.setDouble("damage", this.damage);
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
        this.xTile = p_70037_1_.getShort("xTile");
        this.yTile = p_70037_1_.getShort("yTile");
        this.zTile = p_70037_1_.getShort("zTile");
        this.ticksInGround = p_70037_1_.getShort("life");
        this.inTile = Block.getBlockById((int)(p_70037_1_.getByte("inTile") & 0xFF));
        this.inData = p_70037_1_.getByte("inData") & 0xFF;
        this.arrowShake = p_70037_1_.getByte("shake") & 0xFF;
        boolean bl = this.inGround = p_70037_1_.getByte("inGround") == 1;
        if (p_70037_1_.hasKey("damage", 99)) {
            this.damage = p_70037_1_.getDouble("damage");
        }
        if (p_70037_1_.hasKey("pickup", 99)) {
            this.canBePickedUp = p_70037_1_.getByte("pickup");
        } else if (p_70037_1_.hasKey("player", 99)) {
            this.canBePickedUp = p_70037_1_.getBoolean("player") ? 1 : 0;
        }
    }

    public void onCollideWithPlayer(EntityPlayer entityIn) {
        if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0) {
            boolean flag;
            boolean bl = flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && entityIn.capabilities.isCreativeMode;
            if (this.canBePickedUp == 1 && !entityIn.inventory.addItemStackToInventory(new ItemStack(TitanItems.harcadiumArrow, 1))) {
                flag = false;
            }
            if (flag) {
                this.playSound("random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                entityIn.onItemPickup((Entity)this, 1);
                this.setDead();
            }
        }
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public void setDamage(double p_70239_1_) {
        this.damage = p_70239_1_;
    }

    public double getDamage() {
        return this.damage;
    }

    public void setKnockbackStrength(int p_70240_1_) {
        this.knockbackStrength = p_70240_1_;
    }

    public boolean canAttackWithItem() {
        return false;
    }

    public void setIsCritical(boolean p_70243_1_) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        if (p_70243_1_) {
            this.dataWatcher.updateObject(16, (Object)((byte)(b0 | 1)));
        } else {
            this.dataWatcher.updateObject(16, (Object)((byte)(b0 & 0xFFFFFFFE)));
        }
    }

    public boolean getIsCritical() {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        return (b0 & 1) != 0;
    }
}

