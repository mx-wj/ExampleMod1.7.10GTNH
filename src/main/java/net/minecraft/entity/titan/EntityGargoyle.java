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
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIAttackOnCollide
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIWander
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.monster.EntityGolem
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.village.Village
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityGargoyleTitan;
import net.minecraft.entity.titan.ai.EntityAIDefendVillage;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGargoyle
extends EntityGolem {
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private int attackTimer;
    private int field_175479_bo;
    private EntityLivingBase field_175478_bn;
    private int homeCheckTimer;
    Village villageObj;

    public EntityGargoyle(World p_i1694_1_) {
        super(p_i1694_1_);
        this.setCurrentItemOrArmor(0, new ItemStack(Blocks.stone));
        this.setSize(0.75f, 2.5f);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, (EntityAIBase)new AIPerch());
        this.tasks.addTask(2, (EntityAIBase)new AIBeamAttack());
        this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0, true));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.75));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAIDefendVillage(this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, false, IMob.mobSelector));
    }

    protected void updateAITick() {
        if (--this.homeCheckTimer <= 0) {
            this.homeCheckTimer = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double((double)this.posX), MathHelper.floor_double((double)this.posY), MathHelper.floor_double((double)this.posZ), 32);
            if (this.villageObj == null) {
                this.detachHome();
            } else {
                ChunkCoordinates chunkcoordinates = this.villageObj.getCenter();
                this.setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, (int)((float)this.villageObj.getVillageRadius() * 0.6f));
            }
        }
        super.updateAITick();
    }

    public void onDeath(DamageSource p_70645_1_) {
        if (!this.isPlayerCreated() && this.attackingPlayer != null && this.villageObj != null) {
            this.villageObj.setReputationForPlayer(this.attackingPlayer.getCommandSenderName(), -5);
        }
        super.onDeath(p_70645_1_);
    }

    public Village getVillage() {
        return this.villageObj;
    }

    public float getBlockPathWeight(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
        return this.worldObj.getBlock(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == Blocks.planks || this.worldObj.getBlock(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == Blocks.cobblestone ? 10.0f : this.worldObj.getLightBrightness(p_70783_1_, p_70783_2_, p_70783_3_) - 0.5f;
    }

    public float func_175477_p(float p_175477_1_) {
        return ((float)this.field_175479_bo + p_175477_1_) / 80.0f;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, (Object)new Byte(0));
        this.dataWatcher.addObject(16, (Object)0);
        this.dataWatcher.addObject(17, (Object)0);
        this.getDataWatcher().addObject(21, (Object)0);
    }

    public int getGargoyleType() {
        return this.dataWatcher.getWatchableObjectByte(13);
    }

    public void setGargoyleType(int p_82201_1_) {
        this.dataWatcher.updateObject(13, (Object)((byte)p_82201_1_));
        switch (p_82201_1_) {
            default: {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0);
                this.setHealth(50.0f);
            }
            case 1: {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
                this.setHealth(30.0f);
            }
            case 2: {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0);
                this.setHealth(200.0f);
            }
            case 3: {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0);
                this.setHealth(80.0f);
            }
            case 4: {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
                this.setHealth(100.0f);
            }
            case 5: {
                this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(120.0);
                this.setHealth(120.0f);
            }
            case 6: 
        }
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0);
        this.setHealth(60.0f);
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.setPlayerCreated(tagCompund.getBoolean("PlayerCreated"));
        if (tagCompund.hasKey("GargoyleType", 99)) {
            this.setGargoyleType(tagCompund.getByte("GargoyleType"));
        }
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("PlayerCreated", this.isPlayerCreated());
        tagCompound.setByte("GargoyleType", (byte)this.getGargoyleType());
    }

    public void setAggressive(boolean p_82197_1_) {
        this.getDataWatcher().updateObject(21, (Object)((byte)(p_82197_1_ ? 1 : 0)));
    }

    public boolean getAggressive() {
        return this.getDataWatcher().getWatchableObjectByte(21) == 1;
    }

    protected float applyPotionDamageCalculations(DamageSource p_70672_1_, float p_70672_2_) {
        p_70672_2_ = super.applyPotionDamageCalculations(p_70672_1_, p_70672_2_);
        if (p_70672_1_.getEntity() == this) {
            p_70672_2_ = 0.0f;
        }
        if (p_70672_1_.isExplosion()) {
            p_70672_2_ = (float)((double)p_70672_2_ * 2.0);
        }
        if (p_70672_1_.isFireDamage()) {
            p_70672_2_ = 0.0f;
        }
        return p_70672_2_;
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ == EntityGargoyle.class || p_70686_1_ == EntityGargoyleTitan.class ? false : (this.isPlayerCreated() && EntityPlayer.class.isAssignableFrom(p_70686_1_) ? false : super.canAttackClass(p_70686_1_));
    }

    public boolean isPlayerCreated() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setPlayerCreated(boolean p_70849_1_) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        if (p_70849_1_) {
            this.dataWatcher.updateObject(16, (Object)((byte)(b0 | 1)));
        } else {
            this.dataWatcher.updateObject(16, (Object)((byte)(b0 & 0xFFFFFFFE)));
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }

    protected int decreaseAirSupply(int p_70682_1_) {
        return p_70682_1_;
    }

    protected void collideWithEntity(Entity p_82167_1_) {
        if (p_82167_1_ instanceof IMob && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase)p_82167_1_);
        }
        if (p_82167_1_ instanceof EntityGargoyle && this.getAttackTarget() == null && ((EntityGargoyle)p_82167_1_).getAttackTarget() == null && this.onGround && ((EntityGargoyle)p_82167_1_).onGround && this.getDistanceSq(((EntityGargoyle)p_82167_1_).waypointX, ((EntityGargoyle)p_82167_1_).waypointY, ((EntityGargoyle)p_82167_1_).waypointZ) < 4.0) {
            this.waypointY += 1.0;
            this.noClip = false;
        }
        super.collideWithEntity(p_82167_1_);
    }

    public void onLivingUpdate() {
        int k;
        int j;
        int i;
        Block block;
        EntityLivingBase entity;
        double move;
        int i2;
        List list;
        double d1;
        double d0;
        super.onLivingUpdate();
        if (this.getGargoyleType() == 6) {
            this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
        }
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.getVillage() != null && !this.worldObj.isRemote && this.getAttackTarget() == null && this.getDistanceSq(this.getVillage().getCenter().posX, this.getVillage().getCenter().posY, this.getVillage().getCenter().posZ) > 1024.0) {
            d0 = (double)this.getVillage().getCenter().posX - this.posX;
            d1 = (double)this.getVillage().getCenter().posZ - this.posZ;
            double d3 = d0 * d0 + d1 * d1;
            if (this.posY <= (double)this.getVillage().getCenter().posY + 1.0) {
                this.motionY += 0.6 - this.motionY;
            }
            double d5 = MathHelper.sqrt_double((double)d3);
            this.motionX += d0 / d5 * 0.6 - this.motionX;
            this.motionZ += d1 / d5 * 0.6 - this.motionZ;
        }
        if (this.getVillage() != null && !this.worldObj.isRemote && this.getAttackTarget() == null && (list = this.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox((double)(this.getVillage().getCenter().posX - this.getVillage().getVillageRadius()), (double)(this.getVillage().getCenter().posY - 4), (double)(this.getVillage().getCenter().posZ - this.getVillage().getVillageRadius()), (double)(this.getVillage().getCenter().posX + this.getVillage().getVillageRadius()), (double)(this.getVillage().getCenter().posY + 4), (double)(this.getVillage().getCenter().posZ + this.getVillage().getVillageRadius())))) != null && !list.isEmpty() && this.rand.nextInt(2) == 0) {
            for (i2 = 0; i2 < list.size(); ++i2) {
                Entity entity2 = (Entity)list.get(i2);
                if (!this.isEntityAlive() || !entity2.isEntityAlive() || !this.canAttackClass(entity2.getClass()) || !(entity2 instanceof EntityLivingBase) || !(entity2 instanceof IMob)) continue;
                this.setAttackTarget((EntityLivingBase)entity2);
            }
        }
        if (!this.worldObj.isRemote && this.getAttackTarget() == null && (list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(16.0, 32.0, 16.0))) != null && !list.isEmpty() && this.rand.nextInt(20) == 0) {
            for (i2 = 0; i2 < list.size(); ++i2) {
                Entity entity3 = (Entity)list.get(i2);
                if (!this.isEntityAlive() || !entity3.isEntityAlive() || !this.canAttackClass(entity3.getClass()) || !(entity3 instanceof EntityLivingBase) || !(entity3 instanceof IMob)) continue;
                this.setAttackTarget((EntityLivingBase)entity3);
            }
        }
        if (this.getAttackTarget() != null && !this.getAttackTarget().isEntityAlive()) {
            this.setAttackTarget(null);
        }
        if (this.getAttackTarget() == null && this.getNatureBlock(this.worldObj.getBlock((int)this.waypointX, (int)this.waypointY, (int)this.waypointZ)) && this.getNatureBlock(this.worldObj.getBlock((int)this.waypointX, (int)this.waypointY, (int)this.waypointZ)) && this.worldObj.canBlockSeeTheSky((int)this.waypointX, (int)this.waypointY + 1, (int)this.waypointZ)) {
            d0 = this.waypointX - this.posX;
            d1 = this.waypointY + 1.0 - this.posY;
            double d2 = this.waypointZ - this.posZ;
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d3 == 4.0) {
                this.rotationYaw = this.rotationYawHead += 180.0f;
                this.renderYawOffset = this.rotationYawHead;
            }
            if (d3 > 3.0) {
                double d5 = MathHelper.sqrt_double((double)d3);
                this.motionX += d0 / d5 * 0.6 - this.motionX;
                this.motionY += d1 / d5 * 0.6 - this.motionY;
                this.motionZ += d2 / d5 * 0.6 - this.motionZ;
                this.getLookHelper().setLookPosition(this.waypointX, this.waypointY, this.waypointZ, 180.0f, 0.0f);
                this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
                this.noClip = true;
            } else {
                this.setLocationAndAngles(this.waypointX + 0.5, this.waypointY + 1.0, this.waypointZ + 0.5, this.rotationYawHead, 40.0f);
                this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
                this.noClip = false;
                this.extinguish();
                if (this.ticksExisted % (this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ) == this.getFavoriteBlockToPerch() ? 20 : 40) == 0) {
                    this.heal(this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ) == this.getFavoriteBlockToPerch() ? 2.0f : 1.0f);
                }
            }
        }
        double d = move = (entity = this.getAttackTarget()) != null ? 0.2 + this.rand.nextDouble() * 0.6 : 0.6;
        if (entity != null) {
            this.setAggressive(true);
        } else {
            this.setAggressive(false);
        }
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= move;
        }
        if (!this.worldObj.isRemote && entity != null) {
            double d02 = entity.posX - this.posX;
            double d12 = entity.posZ - this.posZ;
            double d3 = d02 * d02 + d12 * d12;
            double d2 = this.getGargoyleType() == 3 ? 256.0 : 4.0;
            if (d3 > d2 && (this.canEntityBeSeen((Entity)entity) || this.isEntityInsideOpaqueBlock() || this.posY <= 0.0)) {
                if (this.posY <= entity.posY + 1.0) {
                    this.motionY += move - this.motionY;
                }
                double d5 = MathHelper.sqrt_double((double)d3);
                this.motionX += d02 / d5 * move - this.motionX;
                this.motionZ += d12 / d5 * move - this.motionZ;
                this.faceEntity((Entity)entity, 180.0f, 40.0f);
                this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
            }
        }
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7 && this.rand.nextInt(5) == 0 && (block = this.worldObj.getBlock(i = MathHelper.floor_double((double)this.posX), j = MathHelper.floor_double((double)(this.posY - (double)0.2f - (double)this.yOffset)), k = MathHelper.floor_double((double)this.posZ))).getMaterial() != Material.air) {
            this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock((Block)block) + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.boundingBox.minY + 0.1, this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, 4.0 * ((double)this.rand.nextFloat() - 0.5), 0.5, ((double)this.rand.nextFloat() - 0.5) * 4.0);
        }
        if (this.getNatureBlock(this.worldObj.getBlock((int)this.waypointX, (int)this.waypointY + 1, (int)this.waypointZ))) {
            this.waypointY += 1.0;
        }
        if (!(this.worldObj.isRemote || this.ticksExisted % 10 != 0 || this.getNatureBlock(this.worldObj.getBlock((int)this.waypointX, (int)this.waypointY, (int)this.waypointZ)) || this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ) == this.getFavoriteBlockToPerch() && this.worldObj.getBlock((int)this.waypointX, (int)this.waypointY, (int)this.waypointZ) == this.getFavoriteBlockToPerch() && this.worldObj.getBlock((int)this.waypointX, (int)this.waypointY + 1, (int)this.waypointZ).getMaterial() == Material.air && this.worldObj.getBlock((int)this.waypointX, (int)this.waypointY + 2, (int)this.waypointZ).getMaterial() == Material.air && this.worldObj.canBlockSeeTheSky((int)this.waypointX, (int)this.waypointY + 1, (int)this.waypointZ))) {
            i = MathHelper.floor_double((double)this.posY);
            int i1 = MathHelper.floor_double((double)this.posX);
            int j1 = MathHelper.floor_double((double)this.posZ);
            boolean flag = false;
            for (int l1 = -6; l1 <= 6; ++l1) {
                for (int i22 = -6; i22 <= 6; ++i22) {
                    for (int j2 = -6; j2 <= 6; ++j2) {
                        int j22 = i1 + l1;
                        int k2 = i + j2;
                        int l = j1 + i22;
                        Block blockmain = this.worldObj.getBlock(j22, k2, l);
                        Block block1 = this.worldObj.getBlock(j22, k2 + 1, l);
                        Block block2 = this.worldObj.getBlock(j22, k2 + 2, l);
                        if (this.worldObj.isRemote || !this.getNatureBlock(blockmain) || (blockmain != this.getFavoriteBlockToPerch() || this.rand.nextInt(20) != 0) && this.rand.nextInt(300) != 0 || !this.worldObj.canBlockSeeTheSky(j22, k2 + 1, l) || block1.getMaterial() != Material.air || block2.getMaterial() != Material.air) continue;
                        this.waypointX = j22;
                        this.waypointY = k2;
                        this.waypointZ = l;
                    }
                }
            }
        }
    }

    public boolean getNatureBlock(Block block) {
        return (block.isOpaqueCube() || block == this.getFavoriteBlockToPerch()) && block != Blocks.stone && block != Blocks.bedrock && block != Blocks.log && block != Blocks.log2 && block != Blocks.sand && block != Blocks.dirt && block != Blocks.gravel && block != Blocks.grass && block != Blocks.mycelium && block != Blocks.netherrack && block != Blocks.soul_sand;
    }

    public boolean getUNNatureBlock(Block block) {
        return !(block.isOpaqueCube() && block == this.getFavoriteBlockToPerch() || block != Blocks.stone && block != Blocks.bedrock && block != Blocks.log && block != Blocks.log2 && block != Blocks.sand && block != Blocks.dirt && block != Blocks.gravel && block != Blocks.grass && block != Blocks.mycelium && block != Blocks.netherrack && block != Blocks.soul_sand);
    }

    public Block getFavoriteBlockToPerch() {
        switch (this.getGargoyleType()) {
            default: {
                return TitanBlocks.stoneperch;
            }
            case 1: {
                return TitanBlocks.sandstoneperch;
            }
            case 2: {
                return TitanBlocks.obsidianperch;
            }
            case 3: {
                return TitanBlocks.goldperch;
            }
            case 4: {
                return TitanBlocks.ironperch;
            }
            case 5: {
                return TitanBlocks.endstoneperch;
            }
            case 6: 
        }
        return TitanBlocks.netherbrickperch;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source == DamageSource.inWall || source == DamageSource.drown || source == DamageSource.onFire || source == DamageSource.inFire) {
            return false;
        }
        if (source.getEntity() != null && (source.getEntity() instanceof EntityGargoyle || source.getEntity() instanceof EntityGargoyleTitan)) {
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }

    public boolean attackEntityAsMob(Entity p_70652_1_) {
        this.attackTimer = 10;
        this.worldObj.setEntityState((Entity)this, (byte)4);
        boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), this.getGargoyleType() == 6 ? 14.0f : (this.getGargoyleType() == 5 ? 26.0f : (this.getGargoyleType() == 4 ? 14.0f : (this.getGargoyleType() == 3 ? 20.0f : (this.getGargoyleType() == 2 ? 18.0f : (this.getGargoyleType() == 1 ? 4.0f : 8.0f))))));
        this.swingItem();
        if (flag) {
            switch (this.getGargoyleType()) {
                default: {
                    p_70652_1_.motionY += 0.3;
                    break;
                }
                case 1: {
                    p_70652_1_.motionY += 0.15;
                    break;
                }
                case 2: {
                    p_70652_1_.motionY += 0.5;
                    break;
                }
                case 3: {
                    p_70652_1_.motionY += 0.6;
                    this.playSound("mob.zombie.remedy", 1.0f + this.rand.nextFloat(), this.rand.nextFloat() * 0.7f + 0.3f);
                    break;
                }
                case 4: {
                    p_70652_1_.motionY += 0.4;
                    break;
                }
                case 5: {
                    p_70652_1_.motionY += 0.5;
                    break;
                }
                case 6: {
                    p_70652_1_.motionY += 0.3;
                    p_70652_1_.setFire(10);
                }
            }
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return flag && this.attackTime <= 0;
    }

    @SideOnly(value=Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_) {
        if (p_70103_1_ == 4) {
            this.attackTimer = 10;
            this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        } else {
            super.handleHealthUpdate(p_70103_1_);
        }
    }

    protected String getLivingSound() {
        return this.getNatureBlock(this.worldObj.getBlock(MathHelper.floor_double((double)this.posX), MathHelper.floor_double((double)(this.boundingBox.minY - 0.5)), MathHelper.floor_double((double)this.posZ))) ? null : "thetitans:gargoyleLiving";
    }

    protected String getHurtSound() {
        return "thetitans:gargoyleGrunt";
    }

    protected String getDeathSound() {
        return "thetitans:gargoyleDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.playSound("mob.irongolem.walk", 1.0f, 1.0f);
    }

    private void func_175463_b(int p_175463_1_) {
        this.dataWatcher.updateObject(17, (Object)p_175463_1_);
    }

    public boolean func_175474_cn() {
        return this.dataWatcher.getWatchableObjectInt(17) != 0;
    }

    public EntityLivingBase getTargetedEntity() {
        if (!this.func_175474_cn()) {
            return null;
        }
        if (this.worldObj.isRemote) {
            if (this.field_175478_bn != null) {
                return this.field_175478_bn;
            }
            Entity entity = this.worldObj.getEntityByID(this.dataWatcher.getWatchableObjectInt(17));
            if (entity instanceof EntityLivingBase) {
                this.field_175478_bn = (EntityLivingBase)entity;
                return this.field_175478_bn;
            }
            return null;
        }
        return this.getAttackTarget();
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int j = this.rand.nextInt(5);
        switch (this.getGargoyleType()) {
            default: {
                for (int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.getItemFromBlock((Block)Blocks.stone), 1, 0.0f);
                }
                break;
            }
            case 1: {
                for (int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.getItemFromBlock((Block)Blocks.sandstone), 1, 0.0f);
                }
                break;
            }
            case 2: {
                for (int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.getItemFromBlock((Block)Blocks.obsidian), 1, 0.0f);
                }
                break;
            }
            case 3: {
                for (int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.getItemFromBlock((Block)Blocks.gold_block), 1, 0.0f);
                }
                break;
            }
            case 4: {
                for (int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.getItemFromBlock((Block)Blocks.iron_block), 1, 0.0f);
                }
                break;
            }
            case 5: {
                for (int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.getItemFromBlock((Block)Blocks.end_stone), 1, 0.0f);
                }
                break;
            }
            case 6: {
                for (int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.getItemFromBlock((Block)Blocks.nether_brick), 1, 0.0f);
                }
            }
        }
    }

    class AIPerch
    extends EntityAIBase {
        public AIPerch() {
            this.setMutexBits(7);
        }

        public boolean shouldExecute() {
            Block blockmain = EntityGargoyle.this.worldObj.getBlock((int)EntityGargoyle.this.waypointX, (int)EntityGargoyle.this.waypointY, (int)EntityGargoyle.this.waypointZ);
            return EntityGargoyle.this.getNatureBlock(blockmain) && EntityGargoyle.this.getAttackTarget() == null;
        }
    }

    class AIBeamAttack
    extends EntityAIBase {
        private EntityGargoyle field_179456_a;
        private int field_179455_b;

        public AIBeamAttack() {
            this.field_179456_a = EntityGargoyle.this;
            this.setMutexBits(3);
        }

        public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.field_179456_a.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive() && this.field_179456_a.getGargoyleType() == 3;
        }

        public boolean continueExecuting() {
            return super.continueExecuting() && this.field_179456_a.getAttackTarget() != null && this.field_179456_a.getGargoyleType() == 3;
        }

        public void startExecuting() {
            this.field_179455_b = -10;
            this.field_179456_a.getNavigator().clearPathEntity();
            this.field_179456_a.getLookHelper().setLookPositionWithEntity((Entity)this.field_179456_a.getAttackTarget(), 90.0f, 90.0f);
            this.field_179456_a.isAirBorne = true;
        }

        public void resetTask() {
            this.field_179456_a.setAttackTarget(null);
        }

        public void updateTask() {
            EntityLivingBase entitylivingbase = this.field_179456_a.getAttackTarget();
            this.field_179456_a.getNavigator().clearPathEntity();
            this.field_179456_a.getLookHelper().setLookPositionWithEntity((Entity)entitylivingbase, 90.0f, 90.0f);
            if (!this.field_179456_a.canEntityBeSeen((Entity)entitylivingbase)) {
                this.field_179456_a.setAttackTarget(null);
            } else {
                ++this.field_179455_b;
                this.field_179456_a.renderYawOffset = this.field_179456_a.rotationYaw = this.field_179456_a.rotationYawHead;
                if (this.field_179455_b > 0) {
                    entitylivingbase.attackEntityFrom(DamageSource.magic, 1.0f);
                    entitylivingbase.setFire(1 + this.field_179455_b);
                }
                if (this.field_179455_b == 0) {
                    this.field_179456_a.worldObj.setEntityState((Entity)this.field_179456_a, (byte)21);
                } else if (this.field_179455_b >= 60) {
                    float f = 12.0f;
                    if (this.field_179456_a.worldObj.difficultySetting == EnumDifficulty.HARD) {
                        f += 4.0f;
                    }
                    this.field_179456_a.attackEntityAsMob((Entity)entitylivingbase);
                    entitylivingbase.attackEntityFrom(DamageSource.causeIndirectMagicDamage((Entity)this.field_179456_a, (Entity)this.field_179456_a), f);
                    this.field_179456_a.setAttackTarget(null);
                } else if (this.field_179455_b < 60 || this.field_179455_b % 20 == 0) {
                    // empty if block
                }
                super.updateTask();
            }
        }
    }
}

