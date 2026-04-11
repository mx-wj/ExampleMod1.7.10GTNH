/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.command.IEntitySelector
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.common.ForgeHooks
 */
package net.minecraft.entity.titan;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityGargoyle;
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityLavaSpit;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityWitherTurret;
import net.minecraft.entity.titan.EntityWitherTurretGround;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanAttack1;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanAttack2;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanAttack3;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanAttack4;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanLavaSpit;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanMeteorRain;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanWaterSpout;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanWingBuffet;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityGargoyleTitan
extends EntityTitan
implements IAnimatedEntity {
    private static final IEntitySelector attackEntitySelector = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_180027_1_) {
            return !(p_180027_1_ instanceof EntityGargoyleTitan) && !(p_180027_1_ instanceof EntityIronGolemTitan) && !(p_180027_1_ instanceof EntitySnowGolemTitan) && !(p_180027_1_ instanceof EntityWitherTurret) && !(p_180027_1_ instanceof EntityWitherTurretGround);
        }
    };

    @Override
    public int getMinionCap() {
        return 30;
    }

    public EntityGargoyleTitan(World worldIn) {
        super(worldIn);
        this.meleeTitan = true;
        this.setSize(16.0f, 37.0f);
        this.getNavigator().setAvoidsWater(true);
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, IMob.mobSelector));
        EntityGargoyleTitan.addTitanTargetingTaskToEntity(this);
        this.tasks.addTask(1, (EntityAIBase)new AnimationGargoyleTitanLavaSpit(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationGargoyleTitanWaterSpout(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationGargoyleTitanWingBuffet(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationGargoyleTitanMeteorRain(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationGargoyleTitanAttack4(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationGargoyleTitanAttack3(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationGargoyleTitanAttack2(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationGargoyleTitanAttack1(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationGargoyleTitanAntiTitanAttack(this));
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 0xF000F0;
    }

    public float getBrightness(float p_70013_1_) {
        return 1.0f;
    }

    public static void addTitanTargetingTaskToEntity(EntityCreature entity) {
        entity.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(entity, EntityTitan.class, 0, false, false, attackEntitySelector));
    }

    public float getEyeHeight() {
        return 34.0f;
    }

    @Override
    public void onKillCommand() {
        this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
        this.setDead();
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1000.0);
    }

    @Override
    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.GREATER;
    }

    @Override
    protected int decreaseAirSupply(int p_70682_1_) {
        return p_70682_1_;
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.GargoyleKingMinionSpawnrate;
    }

    @Override
    protected void fall(float p_70069_1_) {
        if ((p_70069_1_ = ForgeHooks.onLivingFall((EntityLivingBase)this, (float)p_70069_1_)) <= 0.0f) {
            return;
        }
        super.fall(p_70069_1_);
        PotionEffect potioneffect = this.getActivePotionEffect(Potion.jump);
        float f1 = potioneffect != null ? (float)(potioneffect.getAmplifier() + 1) : 0.0f;
        int i = MathHelper.ceiling_float_int((float)(p_70069_1_ - 20.0f - f1));
        if (i > 0) {
            this.func_145780_a(0, 0, 0, Blocks.stone);
            List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(48.0, 2.0, 48.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity = (Entity)list11.get(i1);
                    if (!(entity instanceof EntityLivingBase) || !this.canAttackClass(entity.getClass()) || entity instanceof EntityTitan) continue;
                    float smash = 100.0f - this.getDistanceToEntity(entity);
                    if (smash <= 1.0f) {
                        smash = 1.0f;
                    }
                    entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), smash);
                    double d0 = this.boundingBox.minX + this.boundingBox.maxX;
                    double d1 = this.boundingBox.minZ + this.boundingBox.maxZ;
                    double d2 = entity.posX - d0;
                    double d3 = entity.posZ - d1;
                    double d4 = d2 * d2 + d3 * d3;
                    entity.addVelocity(d2 / d4 * 8.0, 1.0, d3 / d4 * 8.0);
                }
            }
        }
    }

    @Override
    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        EntityGargoyleTitanFireball entitylargefireball;
        double d6;
        int i;
        super.onLivingUpdate();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100000.0);
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.75;
        }
        if (this.getAttackTarget() != null && this.animID == 0 && this.posY <= this.getAttackTarget().posY + 16.0) {
            double d = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
            double d2 = !this.getAttackTarget().onGround ? this.getMeleeRange() : 6400.0;
            if (d > d2) {
                this.motionY += 0.42 - this.motionY;
            }
        }
        if (!this.worldObj.isRemote && this.getAnimID() == 5 && this.getAnimTick() == 30 && this.getAttackTarget() != null) {
            int i1 = MathHelper.floor_double((double)this.getAttackTarget().posX);
            int i2 = MathHelper.floor_double((double)this.getAttackTarget().posY);
            int j1 = MathHelper.floor_double((double)this.getAttackTarget().posZ);
            for (int l1 = -16; l1 <= 16; ++l1) {
                for (int i22 = -16; i22 <= 16; ++i22) {
                    for (int j = 0; j <= 1; ++j) {
                        int j2 = i1 + l1;
                        int k = i2 + j;
                        int l = j1 + i22;
                        for (int y = 0; y <= 256 && this.worldObj.getBlock(j2, k - 1, l).getMaterial() == Material.air; ++y) {
                            --k;
                        }
                        Block block = this.worldObj.getBlock(j2, k, l);
                        if (block.getMaterial() != Material.air) continue;
                        this.worldObj.setBlock(j2, k, l, (Block)Blocks.flowing_water, 7, 3);
                    }
                }
            }
            this.attackChoosenEntity((Entity)this.getAttackTarget(), 200.0f, 3);
        }
        if (!this.worldObj.isRemote && this.getAnimID() == 6 && this.getAnimTick() == 20 && this.getAttackTarget() != null) {
            double d8 = 10.0;
            Vec3 vec3 = this.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            double d5 = this.getAttackTarget().posX - (this.posX + dx);
            double d62 = this.getAttackTarget().posY - (this.posY + 28.0);
            double d7 = this.getAttackTarget().posZ - (this.posZ + dz);
            EntityLavaSpit entitylargefireball2 = new EntityLavaSpit(this.worldObj, (EntityLivingBase)this, d5, d62, d7);
            entitylargefireball2.setPosition(this.posX + dx, this.posY + 28.0, this.posZ + dz);
            this.worldObj.spawnEntityInWorld((Entity)entitylargefireball2);
        }
        if (!this.worldObj.isRemote && this.getAnimID() == 2 && this.getAnimTick() > 60 && this.getAttackTarget() != null) {
            for (i = 0; i < 2; ++i) {
                double ranX = this.rand.nextGaussian() * 100.0;
                double ranZ = this.rand.nextGaussian() * 100.0;
                double ranTargetX = this.rand.nextGaussian() * 16.0;
                double ranTargetZ = this.rand.nextGaussian() * 16.0;
                double d5 = this.getAttackTarget().posX + ranTargetX - (this.posX + ranX);
                d6 = this.getAttackTarget().posY - 200.0;
                double d7 = this.getAttackTarget().posZ + ranTargetZ - (this.posZ + ranZ);
                entitylargefireball = new EntityGargoyleTitanFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7);
                entitylargefireball.setPosition(this.posX + ranX, 200.0, this.posZ + ranZ);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
        }
        if (!this.worldObj.isRemote && this.getAnimID() == 4 && this.getAnimTick() > 20 && this.getAttackTarget() != null) {
            for (i = 0; i < 2; ++i) {
                double ranX = this.rand.nextGaussian() * 100.0;
                double ranZ = this.rand.nextGaussian() * 100.0;
                double ranTargetX = this.rand.nextGaussian() * 16.0;
                double ranTargetZ = this.rand.nextGaussian() * 16.0;
                double d5 = this.getAttackTarget().posX + ranTargetX - (this.posX + ranX);
                d6 = this.getAttackTarget().posY - 200.0;
                double d7 = this.getAttackTarget().posZ + ranTargetZ - (this.posZ + ranZ);
                entitylargefireball = new EntityGargoyleTitanFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7);
                entitylargefireball.setPosition(this.posX + ranX, 200.0, this.posZ + ranZ);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
        }
        if (!AnimationAPI.isEffectiveClient() && this.getAttackTarget() != null && this.getAnimID() == 0) {
            double d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
            if (d0 < (double)(this.width * this.width + this.getAttackTarget().width * this.getAttackTarget().width) + 1500.0) {
                if (this.getAttackTarget() instanceof EntityTitan || this.getAttackTarget().height >= 6.0f || this.getAttackTarget().posY > this.posY + 6.0) {
                    if (this.rand.nextInt(7) == 0) {
                        AnimationAPI.sendAnimPacket(this, 2);
                        this.setAnimID(2);
                    } else {
                        AnimationAPI.sendAnimPacket(this, 1);
                        this.setAnimID(1);
                    }
                } else {
                    switch (this.rand.nextInt(6)) {
                        case 0: {
                            AnimationAPI.sendAnimPacket(this, 3);
                            this.setAnimID(3);
                            break;
                        }
                        case 1: {
                            AnimationAPI.sendAnimPacket(this, 7);
                            this.setAnimID(7);
                            break;
                        }
                        case 2: {
                            AnimationAPI.sendAnimPacket(this, 8);
                            this.setAnimID(8);
                            break;
                        }
                        case 3: {
                            AnimationAPI.sendAnimPacket(this, 9);
                            this.setAnimID(9);
                        }
                    }
                }
            } else if (this.getAnimID() == 0 && this.getRNG().nextInt(60) == 0) {
                switch (this.rand.nextInt(2)) {
                    case 0: {
                        if (this.getAttackTarget() instanceof EntityTitan) {
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                            break;
                        }
                        AnimationAPI.sendAnimPacket(this, 5);
                        this.setAnimID(5);
                        break;
                    }
                    case 1: {
                        AnimationAPI.sendAnimPacket(this, 6);
                        this.setAnimID(6);
                    }
                }
            }
        }
        this.setCustomNameTag("\u00a77\u00a7lGargoyle King");
        List list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0));
        if (list1 != null && !list1.isEmpty() && this.rand.nextInt(60) == 0) {
            for (int i1 = 0; i1 < list1.size(); ++i1) {
                Entity entity = (Entity)list1.get(i1);
                if (entity == null || !(entity instanceof EntityGargoyle) || this.getAttackTarget() == null || !(this.getAttackTarget().height <= 6.0f)) continue;
                ((EntityGargoyle)entity).setAttackTarget(this.getAttackTarget());
                ((EntityGargoyle)entity).getLookHelper().setLookPositionWithEntity((Entity)this.getAttackTarget(), 30.0f, 30.0f);
                ((EntityGargoyle)entity).getMoveHelper().setMoveTo(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1.0);
                ((EntityGargoyle)entity).getNavigator().tryMoveToXYZ(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1.0);
            }
        }
        if (this.rand.nextInt(this.getMinionSpawnRate()) == 0 && this.getHealth() > 0.0f && !this.worldObj.isRemote) {
            EntityGargoyle entitychicken = new EntityGargoyle(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.posY + 100.0, this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            entitychicken.setGargoyleType(1);
            if (this.rand.nextInt(2) == 0) {
                entitychicken.setGargoyleType(0);
                if (this.rand.nextInt(2) == 0) {
                    entitychicken.setGargoyleType(6);
                    if (this.rand.nextInt(2) == 0) {
                        entitychicken.setGargoyleType(5);
                        if (this.rand.nextInt(2) == 0) {
                            entitychicken.setGargoyleType(4);
                            if (this.rand.nextInt(2) == 0) {
                                entitychicken.setGargoyleType(2);
                                if (this.rand.nextInt(2) == 0) {
                                    entitychicken.setGargoyleType(3);
                                }
                            }
                        }
                    }
                }
            }
            EntityGargoyleTitan.addTitanTargetingTaskToEntity((EntityCreature)entitychicken);
            entitychicken.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        }
        if (this.rand.nextInt(this.getMinionSpawnRate()) == 0 && this.getHealth() > 0.0f && !this.worldObj.isRemote) {
            EntityGargoyle entitychicken = new EntityGargoyle(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.posY + 100.0, this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            entitychicken.setGargoyleType(1);
            if (this.rand.nextInt(2) == 0) {
                entitychicken.setGargoyleType(0);
                if (this.rand.nextInt(2) == 0) {
                    entitychicken.setGargoyleType(6);
                    if (this.rand.nextInt(2) == 0) {
                        entitychicken.setGargoyleType(5);
                        if (this.rand.nextInt(2) == 0) {
                            entitychicken.setGargoyleType(4);
                            if (this.rand.nextInt(2) == 0) {
                                entitychicken.setGargoyleType(2);
                                if (this.rand.nextInt(2) == 0) {
                                    entitychicken.setGargoyleType(3);
                                }
                            }
                        }
                    }
                }
            }
            EntityGargoyleTitan.addTitanTargetingTaskToEntity((EntityCreature)entitychicken);
            entitychicken.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    @Override
    protected void updateAITasks() {
        long perfNs = TitansPerf.begin();
        try {
        List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox);
        if (list11 != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (!(entity instanceof EntityLivingBase) || !entity.onGround || entity instanceof EntityTitan || entity instanceof EntityGargoyle) continue;
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                entity.attackEntityFrom(DamageSourceExtra.causeSquishingDamage((Entity)this), f / 2.0f);
            }
        }
        super.updateAITasks();
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
        }
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ == EntityGargoyle.class || p_70686_1_ == EntityGargoyleTitan.class ? false : (this.isPlayerCreated() && EntityPlayer.class.isAssignableFrom(p_70686_1_) ? false : super.canAttackClass(p_70686_1_));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("PlayerCreated", this.isPlayerCreated());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.setPlayerCreated(tagCompund.getBoolean("PlayerCreated"));
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source.isExplosion()) {
            return false;
        }
        if (source.getEntity() != null && source.getEntity() instanceof EntityPlayer && this.isPlayerCreated()) {
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }

    protected String getLivingSound() {
        return "thetitans:gargoyleLiving";
    }

    @Override
    protected String getHurtSound() {
        return "thetitans:gargoyleGrunt";
    }

    @Override
    protected String getDeathSound() {
        return "thetitans:gargoyleDeath";
    }

    protected float getSoundPitch() {
        return this.isChild() ? (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f : (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 0.5f;
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        if (this.onGround) {
            this.playSound("mob.irongolem.walk", 10.0f, 0.5f);
            this.playSound("mob.irongolem.walk", 10.0f, 0.5f);
            this.playSound("mob.irongolem.walk", 10.0f, 0.5f);
            this.playSound("mob.irongolem.walk", 10.0f, 0.5f);
            this.playSound("mob.irongolem.walk", 10.0f, 0.5f);
            this.playSound("mob.irongolem.walk", 10.0f, 0.5f);
            this.playSound("mob.irongolem.walk", 10.0f, 0.5f);
            this.playSound("mob.irongolem.walk", 10.0f, 0.5f);
            this.playSound("thetitans:titanStep", 10.0f, 1.0f);
            this.shakeNearbyPlayerCameras(6000.0);
        }
    }

    @Override
    protected float getSoundVolume() {
        return 100.0f;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int l;
        for (l = 0; l < 512 + this.rand.nextInt(512 + p_70628_2_); ++l) {
            this.entityDropItem(new ItemStack(Blocks.stone), 12.0f);
        }
        for (l = 0; l < 32 + this.rand.nextInt(96 + p_70628_2_); ++l) {
            this.entityDropItem(new ItemStack(Items.emerald), 12.0f);
        }
        for (l = 0; l < 32 + this.rand.nextInt(96 + p_70628_2_); ++l) {
            this.entityDropItem(new ItemStack(Items.diamond), 12.0f);
        }
        for (l = 0; l < 0 + this.rand.nextInt(16 + p_70628_2_); ++l) {
            this.entityDropItem(new ItemStack(TitanItems.harcadium), 12.0f);
        }
        for (l = 0; l < 0 + this.rand.nextInt(8); ++l) {
            this.entityDropItem(new ItemStack(Blocks.bedrock), 12.0f);
        }
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

    @Override
    public void setAnimID(int id) {
        this.animID = id;
    }

    @Override
    public void setAnimTick(int tick) {
        this.animTick = tick;
    }

    @Override
    public int getAnimID() {
        return this.animID;
    }

    @Override
    public int getAnimTick() {
        return this.animTick;
    }
}

