/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.Loader
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.monster.EntityGiantZombie
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 *  thehippomaster.MutantCreatures.MutantZombie
 */
package net.minecraft.entity.titanminion;

import cpw.mods.fml.common.Loader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EntityZombieMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.IMinion;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TargetingSorter;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import thehippomaster.MutantCreatures.MutantZombie;
import net.minecraft.theTitans.util.MinionOptimizationHelper;

public class EntityGiantZombieBetter
extends EntityGiantZombie
implements IMinion {
    public EntityLiving master;
    private TargetingSorter TargetSorter = null;

    public EntityGiantZombieBetter(World worldIn) {
        super(worldIn);
        this.setSize(3.0f, 12.0f);
        this.stepHeight = 3.0f;
        this.func_110163_bv();
        this.TargetSorter = new TargetingSorter((Entity)this);
        this.isImmuneToFire = true;
        this.experienceValue = 1000;
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, false, ITitan.ZombieTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan((EntityCreature)this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    public int getTotalArmorValue() {
        return 20;
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
        return p_70686_1_ != EntityZombieMinion.class && p_70686_1_ != EntityGiantZombieBetter.class && p_70686_1_ != EntityZombieTitan.class || Loader.isModLoaded((String)"MutantCreatures") && p_70686_1_ == MutantZombie.class;
    }

    protected void despawnEntity() {
        this.entityAge = 0;
    }

    public float getEyeHeight() {
        return 10.440001f;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(48.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4000.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
    }

    private EntityLivingBase doJumpDamage(double X, double Y, double Z, double dist, double damage, int knock) {
        AxisAlignedBB bb = AxisAlignedBB.getBoundingBox((double)(X - dist), (double)(Y - 10.0), (double)(Z - dist), (double)(X + dist), (double)(Y + 10.0), (double)(Z + dist));
        List var5 = this.worldObj.selectEntitiesWithinAABB(EntityLivingBase.class, bb, ITitan.ZombieTitanSorter);
        Collections.sort(var5, this.TargetSorter);
        Iterator var2 = var5.iterator();
        Entity var3 = null;
        EntityLivingBase var4 = null;
        while (var2.hasNext()) {
            var3 = (Entity)var2.next();
            var4 = (EntityLivingBase)var3;
            if (var4 == null || var4 == this || !var4.isEntityAlive() || var4 instanceof EntityZombieTitan || var4 instanceof EntityGiantZombieBetter || var4 instanceof EntityZombieMinion) continue;
            DamageSource var21 = null;
            var21 = DamageSource.setExplosionSource(null);
            var21.setExplosion();
            if (this.rand.nextInt(2) == 0) {
                var21.setDamageBypassesArmor();
            }
            var4.attackEntityFrom(var21, (float)damage);
            var4.attackEntityFrom(DamageSource.fall, (float)damage / 4.0f);
            this.worldObj.playSoundAtEntity((Entity)var4, "random.explode", 0.85f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
            if (knock == 0) continue;
            double ks = 0.75 + this.rand.nextDouble() + this.rand.nextDouble();
            double inair = 0.75;
            float f3 = (float)Math.atan2(var4.posZ - this.posZ, var4.posX - this.posX);
            var4.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            if (this.rand.nextInt(5) != 0) continue;
            var4.hurtResistantTime = 0;
        }
        return null;
    }

    public void onLivingUpdate() {
        int k;
        int j;
        int i;
        Block block;
        super.onLivingUpdate();
        if (!(this.ticksExisted % 20 != 0 || this.worldObj.isDaytime() && this.rand.nextInt(5) != 0)) {
            this.heal(this.worldObj.isDaytime() ? 1.0f + this.rand.nextFloat() * 4.0f : 5.0f + this.rand.nextFloat() * 15.0f);
        }
        if (this.worldObj.isRemote) {
            this.setSize(3.0f, 12.0f);
        } else {
            this.setSize(1.5f, 6.0f);
        }
        this.ignoreFrustumCheck = true;
        if (this.motionX != 0.0 && this.motionZ != 0.0 && this.rand.nextInt(5) == 0 && (block = this.worldObj.getBlock(i = MathHelper.floor_double((double)this.posX), j = MathHelper.floor_double((double)(this.posY - (double)0.2f - (double)this.yOffset)), k = MathHelper.floor_double((double)this.posZ))).getMaterial() != Material.air) {
            this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock((Block)block) + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.boundingBox.minY + 0.1, this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, 4.0 * ((double)this.rand.nextFloat() - 0.5), 0.5, ((double)this.rand.nextFloat() - 0.5) * 4.0);
        }
    }

    public float getBlockPathWeight(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
        return 0.5f - this.worldObj.getLightBrightness(p_70783_1_, p_70783_2_, p_70783_3_);
    }

    protected String getLivingSound() {
        return "mob.zombie.say";
    }

    protected String getHurtSound() {
        return "mob.zombie.hurt";
    }

    protected String getDeathSound() {
        return "mob.zombie.death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.playSound("mob.irongolem.walk", 2.0f, 0.9f);
        double dx = this.posX + 4.0 * -Math.sin(Math.toRadians(this.renderYawOffset));
        double dz = this.posZ - 4.0 * -Math.cos(Math.toRadians(this.renderYawOffset));
        this.doJumpDamage(dx, this.posY, dz, 6.0, 10 + this.rand.nextInt(90), 1);
    }

    protected float getSoundVolume() {
        return 7.0f;
    }

    protected Item getDropItem() {
        return Items.rotten_flesh;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int k;
        int j = this.rand.nextInt(13) + this.rand.nextInt(1 + p_70628_2_);
        for (k = 0; k < j; ++k) {
            this.dropItem(Items.feather, 1);
        }
        j = this.rand.nextInt(13) + this.rand.nextInt(2 + p_70628_2_);
        for (k = 0; k < j; ++k) {
            this.dropItem(Items.rotten_flesh, 1);
        }
        if (p_70628_1_ && (this.rand.nextInt(5) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0)) {
            this.dropItem(Items.iron_ingot, 1);
        }
        if (p_70628_1_ && (this.rand.nextInt(5) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0)) {
            this.dropItem(Items.carrot, 1);
        }
        if (p_70628_1_ && (this.rand.nextInt(5) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0)) {
            this.dropItem(Items.potato, 1);
        }
    }

    protected void addRandomArmor() {
        switch (this.rand.nextInt(3)) {
            case 0: {
                this.dropItem(Items.iron_shovel, 1);
                break;
            }
            case 1: {
                this.dropItem(Items.iron_sword, 1);
                break;
            }
            case 2: {
                this.dropItem((Item)Items.iron_helmet, 1);
            }
        }
    }

    protected float getSoundPitch() {
        return this.isChild() ? (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f + 1.0f : (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f + 0.5f;
    }

    public void onKillEntity(EntityLivingBase entityLivingIn) {
        super.onKillEntity(entityLivingIn);
        if ((double)entityLivingIn.getMaxHealth() <= 100.0) {
            entityLivingIn.motionY += 15.0;
        }
        this.heal(this.worldObj.isDaytime() ? 5.0f + this.rand.nextFloat() * 15.0f : 15.0f + this.rand.nextFloat() * 30.0f);
        if (entityLivingIn instanceof EntityVillager) {
            EntityZombieMinion entityzombie = new EntityZombieMinion(this.worldObj);
            entityzombie.copyLocationAndAnglesFrom((Entity)entityLivingIn);
            this.worldObj.removeEntity((Entity)entityLivingIn);
            entityzombie.onSpawnWithEgg(null);
            entityzombie.setVillager(true);
            if (entityLivingIn.isChild()) {
                entityzombie.setChild(true);
            }
            this.worldObj.spawnEntityInWorld((Entity)entityzombie);
            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        }
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                if (par1Entity.onGround) {
                    double ks = 1.25;
                    double inair = 1.25;
                    float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
                    par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                } else {
                    double ks = 3.0;
                    double inair = 0.25;
                    int var2 = 6;
                    float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
                    par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                }
            }
            return true;
        }
        return false;
    }

    public void addVelocity(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
        this.motionX += p_70024_1_ * 0.1;
        this.motionY += p_70024_3_ * 0.1;
        this.motionZ += p_70024_5_ * 0.1;
    }

    protected void updateAITasks() {
        if (!MinionOptimizationHelper.shouldRunHeavyAI(this)) {
            return;
        }
        block12: {
            block10: {
                block11: {
                    if (this.getAttackTarget() != null && this.onGround) {
                        this.getMoveHelper().setMoveTo(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1.0);
                    }
                    if (this.isCollidedHorizontally && this.master != null) {
                        this.motionY = 0.2;
                    }
                    if (this.motionY < -0.95) {
                        double df = 1.0;
                        if (this.motionY < -1.5) {
                            df = 1.5;
                        }
                        this.doJumpDamage(this.posX, this.posY, this.posZ, 12.0, 100.0 * df, 0);
                        this.doJumpDamage(this.posX, this.posY, this.posZ, 14.0, 50.0 * df, 0);
                        this.doJumpDamage(this.posX, this.posY, this.posZ, 16.0, 25.0 * df, 0);
                    }
                    if (!this.worldObj.isRemote && this.getAttackTarget() != null && this.ticksExisted % 30 == 0 && this.worldObj.rand.nextInt(3) == 0) {
                        this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
                        this.motionY += 1.25;
                        this.posY += (double)1.55f;
                        double d1 = this.getAttackTarget().posX - this.posX;
                        double d2 = this.getAttackTarget().posZ - this.posZ;
                        float d = (float)Math.atan2(d2, d1);
                        this.faceEntity((Entity)this.getAttackTarget(), 10.0f, this.getVerticalFaceSpeed());
                        d1 = Math.sqrt(d1 * d1 + d2 * d2);
                        if (this.getDistanceSqToEntity((Entity)this.getAttackTarget()) > (double)((10.0f + this.getAttackTarget().width / 2.0f) * (10.0f + this.getAttackTarget().width / 2.0f)) + 45.0) {
                            this.motionX += d1 * 0.05 * Math.cos(d);
                            this.motionZ += d1 * 0.05 * Math.sin(d);
                        }
                    }
                    if (this.getAttackTarget() != null) {
                        this.getLookHelper().setLookPositionWithEntity((Entity)this.getAttackTarget(), 10.0f, 40.0f);
                    }
                    if (this.getAttackTarget() != null && this.ticksExisted % 20 == 0 && this.getDistanceSqToEntity((Entity)this.getAttackTarget()) <= (double)((14.0f + this.getAttackTarget().width / 2.0f) * (14.0f + this.getAttackTarget().width / 2.0f))) {
                        this.attackEntityAsMob((Entity)this.getAttackTarget());
                    }
                    if (this.master == null) break block10;
                    if (this.master.getAttackTarget() == null) break block11;
                    this.setAttackTarget(this.master.getAttackTarget());
                    break block12;
                }
                if (!(this.getDistanceSqToEntity((Entity)this.master) > 5000.0)) break block12;
                this.getMoveHelper().setMoveTo(this.master.posX, this.master.posY, this.master.posZ, 2.0);
                break block12;
            }
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
            if (list != null && !list.isEmpty()) {
                for (int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity == null || !(entity instanceof EntityZombieTitan)) continue;
                    this.master = (EntityZombieTitan)entity;
                }
            }
        }
        super.updateAITasks();
    }

    protected void fall(float par1) {
    }

    protected void updateFallState(double par1, boolean par3) {
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source.getEntity() instanceof EntityZombieMinion || source.getEntity() instanceof EntityZombieTitan || source.getEntity() instanceof EntityGiantZombieBetter) {
            return false;
        }
        Entity entity = source.getEntity();
        if (source.getEntity() instanceof EntityLivingBase) {
            this.setAttackTarget((EntityLivingBase)entity);
            this.setRevengeTarget((EntityLivingBase)entity);
            if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(4) == 0) {
                this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
                this.motionY += 1.75;
                this.posY += (double)1.55f;
                double d1 = ((EntityLivingBase)entity).posX - this.posX;
                double d2 = ((EntityLivingBase)entity).posZ - this.posZ;
                float d = (float)Math.atan2(d2, d1);
                this.faceEntity((Entity)((EntityLivingBase)entity), 10.0f, this.getVerticalFaceSpeed());
                d1 = Math.sqrt(d1 * d1 + d2 * d2);
                if (this.getDistanceSqToEntity((Entity)((EntityLivingBase)entity)) > (double)((10.0f + ((EntityLivingBase)entity).width / 2.0f) * (10.0f + ((EntityLivingBase)entity).width / 2.0f)) + 45.0) {
                    this.motionX += d1 * 0.1 * Math.cos(d);
                    this.motionZ += d1 * 0.1 * Math.sin(d);
                }
            }
        }
        return super.attackEntityFrom(source, amount);
    }
}

