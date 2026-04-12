/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityMagmaCube
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraftforge.common.ForgeHooks
 */
package net.minecraft.entity.titan;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityMagmaCubeTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class EntitySlimeTitan
extends EntityTitan {
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private boolean field_175452_bi;
    private int slimeJumpDelay;
    public boolean doubleJumped;

    public EntitySlimeTitan(World worldIn) {
        super(worldIn);
        this.setSize(8.0f * (float)this.getSlimeSize(), 8.0f * (float)this.getSlimeSize());
        this.slimeJumpDelay = 0;
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
    }

    @Override
    public boolean canAttack() {
        return true;
    }

    @Override
    protected void applyEntityAI() {
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SlimeTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    @Override
    protected void updateAITasks() {
        long perfNs = TitansPerf.begin();
        try {
        super.updateAITasks();
        EntityLivingBase entity = this.getAttackTarget();
        if (this.onGround && this.slimeJumpDelay-- <= 0 && this.getInvulTime() <= 0) {
            this.slimeJumpDelay = this.getJumpDelay();
            if (entity != null) {
                this.slimeJumpDelay /= 3;
                this.getLookHelper().setLookPositionWithEntity((Entity)entity, 180.0f, 60.0f);
            }
            this.jump();
            if (this.makesSoundOnJump()) {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 0.8f);
            }
            this.moveForward = 2 * this.getSlimeSize();
            this.moveEntityWithHeading(this.moveStrafing, this.moveForward);
        } else {
            this.isJumping = false;
            if (this.onGround) {
                this.moveForward = 0.0f;
                this.moveStrafing = 0.0f;
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
        }
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return !(p_70686_1_ != EntityMagmaCube.class && p_70686_1_ == EntitySlime.class || p_70686_1_ != EntityMagmaCubeTitan.class && p_70686_1_ == EntitySlimeTitan.class);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(20) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.SlimeTitanMinionSpawnrate;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)Byte.valueOf((byte)1));
    }

    protected void setSlimeSize(int p_70799_1_) {
        this.dataWatcher.updateObject(16, (Object)((byte)p_70799_1_));
        this.setSize(8.0f * (float)p_70799_1_, 8.0f * (float)p_70799_1_);
        this.setPosition(this.posX, this.posY, this.posZ);
        if (TheTitans.NightmareMode) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)p_70799_1_ * 2000.0);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)p_70799_1_ * 1000.0);
        }
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)this.getAttackStrength());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)(0.5f + 0.1f * (float)p_70799_1_));
        this.setTitanHealth(this.getMaxHealth());
        this.experienceValue = this instanceof EntityMagmaCubeTitan ? p_70799_1_ * 3000 : p_70799_1_ * 1000;
    }

    @Override
    public int getParticleCount() {
        return 4;
    }

    @Override
    public String getParticles() {
        return this.func_180487_n();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)this.getAttackStrength());
    }

    public int getSlimeSize() {
        return this.dataWatcher.getWatchableObjectByte(16);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("Size", this.getSlimeSize() - 1);
        tagCompound.setBoolean("wasOnGround", this.field_175452_bi);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        int i = tagCompund.getInteger("Size");
        if (i < 0) {
            i = 0;
        }
        this.setSlimeSize(i + 1);
        this.field_175452_bi = tagCompund.getBoolean("wasOnGround");
    }

    protected String func_180487_n() {
        return "slime";
    }

    protected String getJumpSound() {
        return "mob.slime.big";
    }

    protected String getSlimeParticle() {
        return "slime";
    }

    @Override
    public void onUpdate() {
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5f;
        this.prevSquishFactor = this.squishFactor;
        boolean flag = this.onGround;
        super.onUpdate();
        if (this.onGround && !flag) {
            int i = this.getSlimeSize();
            for (int j = 0; j < i * 32; ++j) {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0f;
                float f1 = this.rand.nextFloat() * 8.0f + 8.0f;
                float f2 = MathHelper.sin((float)f) * (float)i * 0.5f * f1;
                float f3 = MathHelper.cos((float)f) * (float)i * 0.5f * f1;
                this.worldObj.spawnParticle(this.getSlimeParticle(), this.posX + (double)f2, this.boundingBox.minY, this.posZ + (double)f3, 0.0, 0.0, 0.0);
            }
            if (this.makesSoundOnLand()) {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) / 0.8f);
            }
            this.squishAmount = -0.5f;
        } else if (!this.onGround && flag) {
            this.squishAmount = 1.0f;
        }
        this.alterSquishAmount();
    }

    @Override
    public boolean shouldMove() {
        return false;
    }

    @Override
    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        List list1;
        super.onLivingUpdate();
        this.renderYawOffset = this.rotationYaw;
        if (!this.isEntityAlive()) {
            this.squishAmount = this instanceof EntityMagmaCubeTitan ? 1.0f : -0.5f;
        }
        this.destroyBlocksInAABB(this.boundingBox.offset(this.motionX, this.motionY > 0.0 ? this.motionY : 0.0, this.motionZ));
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(0.1, 0.1, 0.1));
        if (list != null && !list.isEmpty() && this.isEntityAlive()) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (entity == null || !(entity instanceof EntityLivingBase) || !this.canAttackClass(entity.getClass())) continue;
                this.func_175451_e((EntityLivingBase)entity);
            }
        }
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)this.getAttackStrength());
        this.meleeTitan = true;
        if (this.createProtoInstance() instanceof EntityMagmaCube) {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.LavaSlimeTitan.name"));
            this.jumpMovementFactor = 0.75f;
            list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(128.0, 128.0, 128.0));
            if (list1 != null && !list1.isEmpty()) {
                for (int i1 = 0; i1 < list1.size(); ++i1) {
                    Entity entity = (Entity)list1.get(i1);
                    if (entity == null || !(entity instanceof EntityMagmaCube) || this.getAttackTarget() == null) continue;
                    ((EntityMagmaCube)entity).faceEntity((Entity)this.getAttackTarget(), 180.0f, 180.0f);
                    if (((EntityMagmaCube)entity).onGround || ((EntityMagmaCube)entity).isInWater() || ((EntityMagmaCube)entity).handleLavaMovement()) {
                        ((EntityMagmaCube)entity).motionY = 0.6f + (float)((EntityMagmaCube)entity).getSlimeSize() * 0.1f;
                    }
                    ((EntityMagmaCube)entity).setMoveForward(2.0f);
                }
            }
        } else {
            this.setCustomNameTag(StatCollector.translateToLocal((String)"entity.SlimeTitan.name"));
            this.jumpMovementFactor = 0.5f;
            list1 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(128.0, 128.0, 128.0));
            if (list1 != null && !list1.isEmpty()) {
                for (int i1 = 0; i1 < list1.size(); ++i1) {
                    Entity entity = (Entity)list1.get(i1);
                    if (entity == null || !(entity instanceof EntitySlime) || entity instanceof EntityMagmaCube || this.getAttackTarget() == null) continue;
                    ((EntitySlime)entity).faceEntity((Entity)this.getAttackTarget(), 180.0f, 180.0f);
                    if (((EntitySlime)entity).onGround || ((EntitySlime)entity).isInWater() || ((EntitySlime)entity).handleLavaMovement()) {
                        ((EntitySlime)entity).motionY = 0.5;
                    }
                    ((EntitySlime)entity).setMoveForward(2.0f);
                }
            }
        }
        if (this.getAttackTarget() != null) {
            this.faceEntity((Entity)this.getAttackTarget(), 180.0f, 40.0f);
        }
        if (this.getAttackTarget() == null && this.doubleJumped || this.onGround) {
            this.doubleJumped = false;
        }
        if (this.getAttackTarget() != null && !this.doubleJumped && this.rand.nextInt(100) == 0 && !this.onGround) {
            this.squishAmount = 2.0f;
            this.jump();
            this.doubleJumped = true;
            this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.getRNG().nextFloat() - this.getRNG().nextFloat()) * 0.2f + 1.0f) * 0.8f);
        }
        if (this.rand.nextInt(this.getMinionSpawnRate()) == 0 && this.getHealth() > 0.0f && !this.worldObj.isRemote) {
            EntitySlime entitychicken = this.createProtoInstance();
            entitychicken.onSpawnWithEgg((IEntityLivingData)null);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 4, false));
            entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    protected void alterSquishAmount() {
        this.squishAmount *= 0.85f;
    }

    protected int getJumpDelay() {
        return this.rand.nextInt(40) + 20;
    }

    protected EntitySlimeTitan createInstance() {
        return new EntitySlimeTitan(this.worldObj);
    }

    protected EntitySlime createProtoInstance() {
        return new EntitySlime(this.worldObj);
    }

    public void func_145781_i(int p_145781_1_) {
        if (p_145781_1_ == 16) {
            int j = this.getSlimeSize();
            this.setSize(8.0f * (float)j, 8.0f * (float)j);
        }
        super.func_145781_i(p_145781_1_);
    }

    @Override
    public void applyEntityCollision(Entity entityIn) {
        if (entityIn instanceof EntityTitan) {
            super.applyEntityCollision(entityIn);
        }
        if (this.canAttackClass(entityIn.getClass())) {
            int i = this.getSlimeSize();
            if (this.ticksExisted % 5 == 0 && this.isEntityAlive()) {
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                int i1 = this.getKnockbackAmount();
                this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
                this.attackChoosenEntity(entityIn, f, i1);
                if (!entityIn.isEntityAlive() && !(entityIn instanceof EntityTitan)) {
                    this.playSound("mob.slime.attack", 100.0f, 0.5f);
                    if (entityIn instanceof EntityLivingBase) {
                        this.heal(((EntityLivingBase)entityIn).getMaxHealth());
                    }
                    entityIn.isDead = true;
                    if (!this.worldObj.isRemote) {
                        EntitySlime entitychicken = this.createProtoInstance();
                        entitychicken.onSpawnWithEgg((IEntityLivingData)null);
                        entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 4, false));
                        entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                        this.worldObj.spawnEntityInWorld((Entity)entitychicken);
                    }
                }
            }
        }
    }

    public void onCollideWithPlayer(EntityPlayer entityIn) {
        this.func_175451_e((EntityLivingBase)entityIn);
    }

    protected void func_175451_e(EntityLivingBase p_175451_1_) {
    }

    public float getEyeHeight() {
        return 0.625f * this.height;
    }

    protected int getAttackStrength() {
        if (TheTitans.NightmareMode) {
            return this.getSlimeSize() * 90;
        }
        return this.getSlimeSize() * 30;
    }

    @Override
    protected String getHurtSound() {
        return "mob.slime.big";
    }

    @Override
    protected String getDeathSound() {
        return "mob.slime.big";
    }

    protected Item getDropItem() {
        return Items.slime_ball;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for (int x = 0; x < this.getSlimeSize(); ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.motionY += 0.5;
                entitylargefireball.setXPCount(this instanceof EntityMagmaCubeTitan ? 2000 : 1000);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            if (this.getSlimeSize() <= 1) {
                EntityItem entityitem;
                int l;
                for (l = 0; l < 64 + this.rand.nextInt(64 + p_70628_2_) + p_70628_2_; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(this.getDropItem()));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 16 + this.rand.nextInt(16 + p_70628_2_) + p_70628_2_; ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.coal));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 0 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.emerald));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 0 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.diamond));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
                for (l = 0; l < 0 + this.rand.nextInt(4 + p_70628_2_); ++l) {
                    entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanItems.harcadiumWaflet));
                    entityitem.delayBeforeCanPickup = 40;
                    this.worldObj.spawnEntityInWorld((Entity)entityitem);
                }
            }
        }
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    public int getVerticalFaceSpeed() {
        return 30;
    }

    protected boolean makesSoundOnJump() {
        return true;
    }

    protected boolean makesSoundOnLand() {
        return true;
    }

    @Override
    protected void jump() {
        this.motionY = 1.5 + (double)((float)this.getSlimeSize() * 0.2f);
        this.isAirBorne = true;
        if (this.getAttackTarget() != null) {
            double d01 = this.getAttackTarget().posX - this.posX;
            double d11 = this.getAttackTarget().posZ - this.posZ;
            float f21 = MathHelper.sqrt_double((double)(d01 * d01 + d11 * d11));
            double hor = 1.5 + (double)((float)this.getSlimeSize() * 0.25f);
            this.motionX = d01 / (double)f21 * hor * hor + this.motionX * hor;
            this.motionZ = d11 / (double)f21 * hor * hor + this.motionZ * hor;
        }
    }

    @Override
    protected void fall(float p_70069_1_) {
        this.onGround = true;
        this.isAirBorne = false;
        if (!this.worldObj.isRemote && this.rand.nextInt(5) == 0 && this.getAttackTarget() == null) {
            this.rotationYaw = this.rotationYawHead = this.rand.nextFloat() * 360.0f;
            this.renderYawOffset = this.rotationYawHead;
        }
        if ((p_70069_1_ = ForgeHooks.onLivingFall((EntityLivingBase)this, (float)p_70069_1_)) <= 0.0f) {
            return;
        }
        PotionEffect potioneffect = this.getActivePotionEffect(Potion.jump);
        float f1 = potioneffect != null ? (float)(potioneffect.getAmplifier() + 1) : 0.0f;
        int i = MathHelper.ceiling_float_int((float)(p_70069_1_ - 12.0f - f1));
        if (i > 0) {
            this.playSound("thetitans:titanSlam", 5.0f * (float)this.getSlimeSize(), 2.0f - (float)(this.getSlimeSize() / 4));
            this.playSound("mob.slime.big", 5.0f * (float)this.getSlimeSize(), 2.0f - (float)(this.getSlimeSize() / 8));
            List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(6.0 * (double)this.getSlimeSize(), 6.0 * (double)this.getSlimeSize(), 6.0 * (double)this.getSlimeSize()));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity = (Entity)list11.get(i1);
                    if (!(entity instanceof EntityLivingBase) || !this.canAttackClass(entity.getClass()) || !(this.getDistanceSqToEntity(entity) <= (double)(this.width * this.width + this.width * this.width))) continue;
                    float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    int i11 = this.getKnockbackAmount();
                    this.attackChoosenEntity(entity, f, i11);
                    double d0 = this.boundingBox.minX + this.boundingBox.maxX;
                    double d1 = this.boundingBox.minZ + this.boundingBox.maxZ;
                    double d2 = entity.posX - d0;
                    double d3 = entity.posZ - d1;
                    double d4 = d2 * d2 + d3 * d3;
                    if (this.doubleJumped) {
                        entity.addVelocity(d2 / d4 * 16.0, 2.0, d3 / d4 * 16.0);
                        continue;
                    }
                    entity.addVelocity(d2 / d4 * 8.0, 1.0, d3 / d4 * 8.0);
                }
            }
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!this.worldObj.isRemote) {
            EntitySlime entitychicken = this.createProtoInstance();
            entitychicken.onSpawnWithEgg((IEntityLivingData)null);
            entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 4, false));
            entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
        }
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (this instanceof EntityMagmaCubeTitan ? source.getEntity() instanceof EntityMagmaCubeTitan : source.getEntity() instanceof EntitySlimeTitan && !(source.getEntity() instanceof EntityMagmaCubeTitan)) {
            return false;
        }
        Entity entity = source.getEntity();
        if (entity instanceof EntityLivingBase && !this.isEntityInvulnerable() && amount > 25.0f) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (this instanceof EntityMagmaCubeTitan ? entity1 instanceof EntityMagmaCubeTitan : entity1 instanceof EntitySlimeTitan && !(entity1 instanceof EntityMagmaCubeTitan)) {
                    EntitySlimeTitan entitypigzombie = (EntitySlimeTitan)entity1;
                    entitypigzombie.setAttackTarget((EntityLivingBase)entity);
                    entitypigzombie.setRevengeTarget((EntityLivingBase)entity);
                }
                this.setAttackTarget((EntityLivingBase)entity);
                this.setRevengeTarget((EntityLivingBase)entity);
            }
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_180482_2_) {
        int i = this.rand.nextInt(3);
        if (i < 2 && this.rand.nextFloat() < 0.5f) {
            ++i;
        }
        int j = 1 << i;
        this.setSlimeSize(j);
        return super.onSpawnWithEgg(p_180482_2_);
    }

    @Override
    public StatBase getAchievement() {
        if (this.createProtoInstance() instanceof EntityMagmaCube) {
            return TitansAchievments.magmacubetitan;
        }
        return TitansAchievments.slimetitan;
    }

    @Override
    protected void inactDeathAction() {
        this.worldObj.newExplosion((Entity)this, this.posX, this.posY + 3.0, this.posZ, 0.0f, false, false);
        if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
            this.dropFewItems(true, 0);
            this.dropEquipment(true, 0);
            this.dropRareDrop(1);
        }
        int i = this.getSlimeSize();
        if (!this.worldObj.isRemote) {
            for (int i1 = 0; i1 < 8 * this.getSlimeSize() + this.worldObj.rand.nextInt(8 * this.getSlimeSize()); ++i1) {
                EntitySlime entitychicken = this.createProtoInstance();
                entitychicken.onSpawnWithEgg((IEntityLivingData)null);
                entitychicken.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 4, false));
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            }
        }
        if (!this.worldObj.isRemote && i > 1) {
            int j = 2 + this.rand.nextInt(3);
            for (int k = 0; k < j; ++k) {
                float f = ((float)(k % 2) - 0.5f) * (float)i / 4.0f;
                float f1 = ((float)(k / 2) - 0.5f) * (float)i / 4.0f;
                EntitySlimeTitan entityslime = this.createInstance();
                if (this.hasCustomNameTag()) {
                    entityslime.setCustomNameTag(this.getCustomNameTag());
                }
                if (this.isNoDespawnRequired()) {
                    entityslime.func_110163_bv();
                }
                entityslime.setSlimeSize(i / 2);
                entityslime.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5, this.posZ + (double)f1, this.rand.nextFloat() * 360.0f, 0.0f);
                this.worldObj.spawnEntityInWorld((Entity)entityslime);
            }
        }
    }
}

