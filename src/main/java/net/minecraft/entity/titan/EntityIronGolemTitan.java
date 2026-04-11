/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.command.IEntitySelector
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.village.Village
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityGargoyleTitan;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanAttack1;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanAttack2;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanAttack3;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanAttack4;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanDeath;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanRangedAttack;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityIronGolemTitan
extends EntityTitan
implements IAnimatedEntity {
    private int homeCheckTimer;
    Village villageObj;
    private int attackTimer;
    private int holdRoseTick;
    private static final IEntitySelector attackEntitySelector = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_180027_1_) {
            return p_180027_1_.isEntityAlive() && p_180027_1_ instanceof EntityTitan && !(p_180027_1_ instanceof EntityGargoyleTitan) && !(p_180027_1_ instanceof EntityIronGolemTitan) && !(p_180027_1_ instanceof EntitySnowGolemTitan);
        }
    };

    @Override
    public int getMinionCap() {
        return 30;
    }

    public EntityIronGolemTitan(World worldIn) {
        super(worldIn);
        this.setSize(24.0f, 64.0f);
        this.getNavigator().setAvoidsWater(true);
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, IMob.mobSelector));
        EntityIronGolemTitan.addTitanTargetingTaskToEntity(this);
        this.tasks.addTask(1, (EntityAIBase)new AnimationIronGolemTitanDeath(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationIronGolemTitanRangedAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationIronGolemTitanAntiTitanAttack(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationIronGolemTitanAttack4(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationIronGolemTitanAttack3(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationIronGolemTitanAttack2(this));
        this.tasks.addTask(1, (EntityAIBase)new AnimationIronGolemTitanAttack1(this));
    }

    public static void addTitanTargetingTaskToEntity(EntityCreature entity) {
        entity.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(entity, EntityTitan.class, 0, false, false, attackEntitySelector));
    }

    public float getEyeHeight() {
        return 56.0f;
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
        return TheTitans.UltimaIronGolemMinionSpawnrate;
    }

    @Override
    public int getTotalArmorValue() {
        return 24;
    }

    @Override
    public boolean shouldMove() {
        return this.animID == 0 && this.getAttackTarget() != null ? super.shouldMove() : false;
    }

    @Override
    public double getMeleeRange() {
        return (double)(this.width * this.width + (this.getAttackTarget().width > 48.0f ? 2304.0f : this.getAttackTarget().width * this.getAttackTarget().width)) + 2000.0;
    }

    @Override
    public boolean canBeHurtByPlayer() {
        return !this.isPlayerCreated() && !this.isEntityInvulnerable();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.setSize(24.0f, 64.0f);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2000.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500000.0);
        if (this.animID == 10) {
            if (this.animTick == 30 || this.animTick == 70) {
                this.func_145780_a(0, 0, 0, Blocks.stone);
            }
            if (this.animTick == 190) {
                this.playSound("thetitans:titanFall", 20.0f, 0.9f);
                this.playSound("thetitans:groundSmash", 20.0f, 1.0f);
                this.shakeNearbyPlayerCameras(40000.0);
            }
            if (this.animTick == 200) {
                this.playSound("thetitans:distantLargeFall", 10000.0f, 0.5f);
            }
        }
        if (!this.worldObj.isRemote && this.getAnimID() == 5 && this.getAnimTick() == 34 && this.getAttackTarget() != null) {
            this.attackEntityAsMob((Entity)this.getAttackTarget());
            Vec3 vec3 = this.getLook(1.0f);
            double d5 = this.getAttackTarget().posX - (this.posX + vec3.xCoord * 30.0);
            double d6 = this.getAttackTarget().posY - (this.posY + 30.0);
            double d7 = this.getAttackTarget().posZ - (this.posZ + vec3.zCoord * 30.0);
            EntityTitanFireball entitylargefireball = new EntityTitanFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7, 1);
            entitylargefireball.posX = this.posX + vec3.xCoord * 30.0;
            entitylargefireball.posY = this.posY + 30.0;
            entitylargefireball.posZ = this.posZ + vec3.zCoord * 30.0;
            this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            entitylargefireball.setFireballID(5);
            entitylargefireball.playSound("thetitans:titanSwing", 10.0f, 1.0f);
        }
        if (this.deathTicks > 0) {
            this.motionX *= 0.0;
            this.motionZ *= 0.0;
        }
        if (!AnimationAPI.isEffectiveClient() && this.getAttackTarget() != null && this.getAnimID() == 0 && this.ticksExisted > 5) {
            double d0 = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
            if (d0 < this.getMeleeRange()) {
                if (this.getAttackTarget() instanceof EntityTitan || this.getAttackTarget().height >= 6.0f || this.getAttackTarget().posY > this.posY + 6.0) {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                } else {
                    switch (this.rand.nextInt(4)) {
                        case 0: {
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
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
            } else if (this.getAnimID() == 0 && this.getRNG().nextInt(160) == 0) {
                switch (this.rand.nextInt(2)) {
                    case 0: {
                        AnimationAPI.sendAnimPacket(this, 5);
                        this.setAnimID(5);
                        break;
                    }
                    case 1: {
                        AnimationAPI.sendAnimPacket(this, 5);
                        this.setAnimID(5);
                    }
                }
            }
        }
        if (this.motionY > 1.0) {
            this.motionY = 1.0;
        }
        this.meleeTitan = true;
        this.setCustomNameTag("\u00a77\u00a7lUltima Iron Golem Titan");
        List list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(96.0, 96.0, 96.0));
        if (list1 != null && !list1.isEmpty()) {
            for (int i1 = 0; i1 < list1.size(); ++i1) {
                Entity entity = (Entity)list1.get(i1);
                if (entity == null || !(entity instanceof EntityIronGolem)) continue;
                if (((EntityIronGolem)entity).isCollidedHorizontally) {
                    ((EntityIronGolem)entity).motionY = 0.25;
                }
                if (((EntityIronGolem)entity).getAttackTarget() == null && ((EntityIronGolem)entity).getDistanceSqToEntity((Entity)this) > 4096.0) {
                    ((EntityIronGolem)entity).getLookHelper().setLookPositionWithEntity((Entity)this, 180.0f, 40.0f);
                    ((EntityIronGolem)entity).getMoveHelper().setMoveTo(this.posX, this.posY, this.posZ, 1.0);
                }
                if (((EntityIronGolem)entity).ticksExisted != 20) continue;
                EntityIronGolemTitan.addTitanTargetingTaskToEntity(this);
            }
        }
        if (this.rand.nextInt(this.getMinionSpawnRate()) == 0 && this.getHealth() > 0.0f && !this.worldObj.isRemote) {
            EntityIronGolem entitychicken = new EntityIronGolem(this.worldObj);
            entitychicken.setLocationAndAngles(this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.posY + (double)this.getEyeHeight(), this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.rotationYaw, 0.0f);
            entitychicken.setPlayerCreated(this.isPlayerCreated());
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            entitychicken.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2000.0);
            entitychicken.setHealth(2000.0f);
            entitychicken.setCustomNameTag("Reinforced Iron Golem");
            EntityIronGolemTitan.addTitanTargetingTaskToEntity((EntityCreature)entitychicken);
            entitychicken.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0);
            entitychicken.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        }
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.holdRoseTick > 0) {
            --this.holdRoseTick;
        }
    }

    @Override
    protected void updateAITasks() {
        List list11;
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
        if ((list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox)) != null && !list11.isEmpty()) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (!(entity instanceof EntityLiving) && (!(entity instanceof EntityPlayer) || this.isPlayerCreated()) || !entity.onGround || entity instanceof EntityTitan || entity instanceof EntityIronGolem) continue;
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                entity.attackEntityFrom(DamageSourceExtra.causeSquishingDamage((Entity)this), f / 2.0f);
            }
        }
        super.updateAITasks();
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ == EntityVillager.class || p_70686_1_ == EntityIronGolem.class || p_70686_1_ == EntityIronGolemTitan.class ? false : !this.isPlayerCreated() || !EntityPlayer.class.isAssignableFrom(p_70686_1_);
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
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        if (p_70652_1_ instanceof EntityWitherzilla) {
            f *= 5.0f;
        }
        if (p_70652_1_ instanceof EntityGhastTitan && p_70652_1_.posY > this.posY + 32.0) {
            p_70652_1_.motionY -= 1.0;
        }
        for (int l = 0; l < 7 + this.rand.nextInt(14); ++l) {
            this.attackChoosenEntity(p_70652_1_, f, this.getKnockbackAmount());
        }
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source.getEntity() instanceof EntityPlayer && this.isPlayerCreated()) {
            return false;
        }
        if (source.getEntity() instanceof EntityIronGolem || source.getEntity() instanceof EntityIronGolemTitan) {
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_) {
        if (p_70103_1_ == 4) {
            this.attackTimer = 10;
            this.playSound("mob.irongolem.throw", 100.0f, 0.5f);
        } else if (p_70103_1_ == 11) {
            this.holdRoseTick = 800;
        } else {
            super.handleHealthUpdate(p_70103_1_);
        }
    }

    public Village getVillage() {
        return this.villageObj;
    }

    @SideOnly(value=Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    public void setHoldingRose(boolean p_70851_1_) {
        this.holdRoseTick = p_70851_1_ ? 800 : 0;
        this.worldObj.setEntityState((Entity)this, (byte)11);
    }

    @Override
    protected String getHurtSound() {
        return "mob.irongolem.hit";
    }

    @Override
    protected String getDeathSound() {
        return "mob.irongolem.death";
    }

    protected float getSoundPitch() {
        return this.isChild() ? (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f : (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 0.5f;
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
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

    @Override
    protected float getSoundVolume() {
        return 100.0f;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int l;
        for (l = 0; l < 512 + this.rand.nextInt(512 + p_70628_2_); ++l) {
            this.entityDropItem(new ItemStack(Blocks.iron_block), 12.0f);
        }
        for (l = 0; l < 128 + this.rand.nextInt(128 + p_70628_2_); ++l) {
            this.entityDropItem(new ItemStack((Block)Blocks.red_flower), 12.0f);
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

    public int getHoldRoseTick() {
        return this.holdRoseTick;
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
    public void onDeath(DamageSource cause) {
        if (!this.isPlayerCreated() && this.attackingPlayer != null && this.villageObj != null) {
            this.villageObj.setReputationForPlayer(this.attackingPlayer.getDisplayName(), -50000);
        }
        super.onDeath(cause);
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

    @Override
    protected void onTitanDeathUpdate() {
        this.dataWatcher.updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)this.dataWatcher.getWatchableObjectFloat(5), (float)0.0f, (float)this.getMaxHealth())));
        if (this.dataWatcher.getWatchableObjectFloat(5) <= 0.0f) {
            ++this.deathTicks;
            AnimationAPI.sendAnimPacket(this, 10);
            this.setAnimID(10);
            this.setTitanHealth(0.0f);
        } else {
            this.attackEntityFrom(DamageSource.outOfWorld, 25.0f);
            this.setTitanHealth(this.dataWatcher.getWatchableObjectFloat(5));
            this.setHealth(this.dataWatcher.getWatchableObjectFloat(5));
            this.deathTicks = 0;
            if (this.animID == 10) {
                this.animID = 0;
            }
        }
        this.motionX *= 0.0;
        this.motionZ *= 0.0;
        this.setAttackTarget(null);
        if (this.deathTicks == 1 && !this.worldObj.isRemote) {
            this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
            ArrayList listp = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
            if (listp != null && !listp.isEmpty()) {
                for (int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity == null || !(entity instanceof EntityPlayer)) continue;
                    ((EntityPlayer)entity).triggerAchievement(this.getAchievement());
                }
            }
        }
        if (this.deathTicks == 1) {
            this.setAnimTick(1);
        }
        if (this.deathTicks >= 500) {
            this.setInvulTime(this.getInvulTime() + 8);
        }
        if (this.getInvulTime() >= this.getThreashHold()) {
            this.setDead();
        }
    }
}

