/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.monster.EntitySnowman
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySnowGolemTitan
extends EntityTitan
implements IRangedAttackMob {
    public EntitySnowGolemTitan(World worldIn) {
        super(worldIn);
        this.setSize(10.0f, 30.0f);
        this.getNavigator().setAvoidsWater(true);
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, IMob.mobSelector));
        EntityIronGolemTitan.addTitanTargetingTaskToEntity(this);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(60.0);
    }

    @Override
    public void onKillCommand() {
        this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
        this.setDead();
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        double doub = this.getDistanceSqToEntity(p_70652_1_);
        if (doub < 600.0) {
            return super.attackEntityAsMob(p_70652_1_);
        }
        return false;
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.SnowGolemMinionSpawnrate;
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != EntityPlayer.class && p_70686_1_ != EntitySnowman.class && p_70686_1_ != EntitySnowGolemTitan.class;
    }

    @Override
    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        double d0;
        if (this.getAttackTarget() != null && this.ticksExisted % 30 == 0 && (d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget())) <= this.getMeleeRange()) {
            this.swingItem();
            this.getLookHelper().setLookPositionWithEntity((Entity)this.getAttackTarget(), 180.0f, 30.0f);
            this.attackEntityAsMob((Entity)this.getAttackTarget());
        }
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4000.0);
        this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.SnowManTitan.name"));
        List list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(128.0, 128.0, 128.0));
        if (list1 != null && !list1.isEmpty() && !this.worldObj.isRemote) {
            for (int i1 = 0; i1 < list1.size(); ++i1) {
                Entity entity = (Entity)list1.get(i1);
                if (entity == null || !(entity instanceof EntitySnowman) || this.getAttackTarget() == null) continue;
                if (!this.getAttackTarget().canEntityBeSeen(entity)) {
                    ((EntitySnowman)entity).getMoveHelper().setMoveTo(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 2.0);
                }
                ((EntitySnowman)entity).setAttackTarget(this.getAttackTarget());
                ((EntitySnowman)entity).getLookHelper().setLookPositionWithEntity((Entity)this.getAttackTarget(), 40.0f, 40.0f);
                if (((EntitySnowman)entity).isCollidedHorizontally) {
                    ((EntitySnowman)entity).motionY = 0.25;
                }
                if ((entity.ticksExisted + entity.getEntityId()) % 20 != 0) continue;
                ((EntitySnowman)entity).attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
            }
        }
        if (this.getAttackTarget() != null && (this.ticksExisted + this.getEntityId()) % 20 == 0 && !this.worldObj.isRemote) {
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 0.0f);
        }
        if (this.rand.nextInt(this.getMinionSpawnRate()) == 0 && this.getHealth() > 0.0f && !this.worldObj.isRemote) {
            EntitySnowman entitychicken = new EntitySnowman(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.posY + (double)this.getEyeHeight(), this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            entitychicken.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
            entitychicken.setHealth(20.0f);
            entitychicken.setCustomNameTag("Reinforced Snow Golem");
        }
        if (!this.worldObj.isRemote) {
            int i = MathHelper.floor_double((double)this.posX);
            int j = MathHelper.floor_double((double)this.posY);
            int k = MathHelper.floor_double((double)this.posZ);
            if (this.isWet() && this.ticksExisted % 40 == 0) {
                this.attackEntityFrom(DamageSource.drown, 1.0f);
            }
            if (this.worldObj.getBiomeGenForCoords(i, k).getFloatTemperature(i, j, k) > 1.5f) {
                this.attackEntityFrom(DamageSource.onFire, 1.0f);
            }
            for (int l = 0; l < 1024; ++l) {
                i = MathHelper.floor_double((double)(this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width));
                if (this.worldObj.getBlock(i, j = MathHelper.floor_double((double)this.posY), k = MathHelper.floor_double((double)(this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width))).getMaterial() != Material.air || !(this.worldObj.getBiomeGenForCoords(i, k).getFloatTemperature(i, j, k) < 1.3f) || !Blocks.snow_layer.canPlaceBlockAt(this.worldObj, i, j, k)) continue;
                this.worldObj.setBlock(i, j, k, Blocks.snow_layer);
            }
        }
        super.onLivingUpdate();
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    protected Item getDropItem() {
        return Items.snowball;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int l;
        this.entityDropItem(new ItemStack(Blocks.lit_pumpkin), 12.0f);
        Item item = this.getDropItem();
        for (l = 0; l < 256 + this.rand.nextInt(256 + p_70628_2_); ++l) {
            this.entityDropItem(new ItemStack(item), 12.0f);
        }
        for (l = 0; l < 0 + this.rand.nextInt(4 + p_70628_2_); ++l) {
            this.entityDropItem(new ItemStack(Items.emerald), 12.0f);
        }
        for (l = 0; l < 0 + this.rand.nextInt(4 + p_70628_2_); ++l) {
            this.entityDropItem(new ItemStack(Items.diamond), 12.0f);
        }
    }

    @Override
    protected String getHurtSound() {
        return "step.snow";
    }

    @Override
    protected String getDeathSound() {
        return "dig.snow";
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        if (this.getHealth() > 0.0f && !this.worldObj.isRemote) {
            EntitySnowman entitychicken = new EntitySnowman(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.posY + (double)this.getEyeHeight(), this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            entitychicken.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
            entitychicken.setHealth(20.0f);
            entitychicken.setCustomNameTag("Reinforced Snow Golem");
        }
        this.faceEntity((Entity)p_82196_1_, 180.0f, 30.0f);
        double doub = this.getDistanceToEntity((Entity)p_82196_1_);
        double d8 = 6.0;
        Vec3 vec3 = this.getLook(1.0f);
        double d1 = p_82196_1_.posX - (this.posX + vec3.xCoord * d8);
        double d2 = p_82196_1_.posY + (double)p_82196_1_.height * 0.33 - (this.posY + 20.0 + vec3.yCoord * d8);
        double d3 = p_82196_1_.posZ - (this.posZ + vec3.zCoord * d8);
        EntityTitanFireball entitylargefireball = new EntityTitanFireball(this.worldObj, (EntityLivingBase)this, d1, d2, d3, 6);
        entitylargefireball.posX = this.posX + vec3.xCoord * d8;
        entitylargefireball.posY = this.posY + 20.0 + vec3.yCoord * d8;
        entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
        this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
        entitylargefireball.setFireballID(6);
        this.playSound("random.bow", 10.0f, 0.5f);
        this.playSound("random.bow", 10.0f, 0.5f);
    }

    @Override
    public int getTotalArmorValue() {
        return 15;
    }

    public float getEyeHeight() {
        return 27.2f;
    }

    @Override
    protected void updateAITasks() {
        long perfNs = TitansPerf.begin();
        try {
        super.updateAITasks();
        List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox);
        if (list11 != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (!(entity instanceof EntityLivingBase) || !entity.onGround || entity instanceof EntityTitan || entity instanceof EntitySnowman) continue;
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                entity.attackEntityFrom(DamageSourceExtra.causeSquishingDamage((Entity)this), f / 2.0f);
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
        }
    }
}

