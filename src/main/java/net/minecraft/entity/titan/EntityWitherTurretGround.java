/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.command.IEntitySelector
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntityGolem
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityBulletWitherSkull;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWitherTurret;
import net.minecraft.entity.titan.EntityWitherTurretMortar;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityWitherTurretGround
extends EntityGolem
implements IRangedAttackMob {
    public int durabilityLevel;
    public int ferocityLevel;
    public int maniacLevel;
    public int unstabilityLevel;
    public int shurakinLevel;
    public int unbreakingLevel;
    public int shootingTimer;
    public int shots = 14;
    private IEntitySelector attackEntitySelector = new IEntitySelector(){
        private EntityWitherTurretGround turret;
        {
            this.turret = EntityWitherTurretGround.this;
        }

        public boolean isEntityApplicable(Entity p_180027_1_) {
            return p_180027_1_ instanceof EntityLivingBase && this.turret.canTargetEntity((EntityLivingBase)p_180027_1_) && p_180027_1_.isEntityAlive() && p_180027_1_.posY <= this.turret.posY + 6.0;
        }
    };

    public EntityWitherTurretGround(World worldIn) {
        super(worldIn);
        this.isImmuneToFire = true;
        this.preventEntitySpawning = true;
        this.setSize(0.75f, 1.375f);
    }

    public void onKillCommand() {
        this.onDeathUpdate();
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 0xF000F0;
    }

    public float getBrightness(float p_70013_1_) {
        return 1.0f;
    }

    protected void despawnEntity() {
    }

    public boolean isAIEnabled() {
        return true;
    }

    protected boolean canTargetEntity(EntityLivingBase entity) {
        if (this.isPlayerCreated()) {
            return !(entity instanceof EntityTitanSpirit) && !(entity instanceof EntityPlayer) && !(entity instanceof EntityGolem) && !(entity instanceof EntityAgeable) && !(entity instanceof EntityIronGolemTitan) && !(entity instanceof EntitySnowGolemTitan) && !(entity instanceof EntityAnimal);
        }
        return !(entity instanceof EntityTitanSpirit) && entity instanceof EntityLivingBase && entity.getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
    }

    public int getTotalArmorValue() {
        int i = 0 + this.unbreakingLevel * 6;
        if (i > 20) {
            i = 20;
        }
        return i;
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4000.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)Byte.valueOf((byte)0));
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return !this.isPlayerCreated() || p_70686_1_ != EntityPlayer.class && p_70686_1_ != EntityAgeable.class && p_70686_1_ != EntityGolem.class;
    }

    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        int k;
        int j;
        int i;
        super.onLivingUpdate();
        if (this.shots <= 0 && this.shootingTimer <= 10) {
            this.shots = 14;
        }
        this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
        this.onGround = true;
        this.isAirBorne = false;
        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        this.isImmuneToFire = true;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.ticksExisted % 20 == 0) {
            this.heal(1.0f + (float)this.durabilityLevel);
        }
        if (!this.worldObj.isRemote && this.worldObj.getBlock(i = MathHelper.floor_double((double)this.posX), j = MathHelper.floor_double((double)(this.posY - 1.0)), k = MathHelper.floor_double((double)this.posZ)) != Blocks.bedrock) {
            this.worldObj.setBlock(i, j, k, Blocks.bedrock);
        }
        double d8 = 15.0;
        Vec3 vec3 = this.getLook(1.0f);
        double dx = vec3.xCoord * d8;
        double dz = vec3.zCoord * d8;
        List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.getBoundingBox().expand(16.0, 16.0, 16.0).offset(dx, -8.0, dz));
        if (list11 != null && !list11.isEmpty() && this.getAttackTarget() == null) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity instanceof EntityLivingBase && entity != null && entity.isEntityAlive() && this.getAttackTarget() == null && this.canTargetEntity((EntityLivingBase)entity) && this.canEntityBeSeen(entity) && entity.posY <= this.posY + 6.0) {
                    this.setAttackTarget((EntityLivingBase)entity);
                    continue;
                }
                list11.remove(entity);
            }
        }
        if (this.getAttackTarget() != null) {
            if (!this.worldObj.isRemote) {
                this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
                this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
            }
            this.getLookHelper().setLookPositionWithEntity((Entity)this.getAttackTarget(), 20.0f, 180.0f);
            if (!this.getAttackTarget().isEntityAlive() || this.getAttackTarget().isDead || this.getAttackTarget().posY > this.posY + 8.0 || this.getAttackTarget().getDistanceSqToEntity((Entity)this) > 1024.0 || !this.canEntityBeSeen((Entity)this.getAttackTarget())) {
                this.setAttackTarget(null);
            }
            if (!this.canTargetEntity(this.getAttackTarget())) {
                this.setAttackTarget(null);
            }
        }
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    public void onUpdate() {
        super.onUpdate();
        for (int j = 0; j < 3; ++j) {
            double d10 = this.func_82214_u(j);
            double d2 = this.func_82208_v(j);
            double d4 = this.func_82213_w(j);
            this.worldObj.spawnParticle("smoke", d10 + this.rand.nextGaussian() * (double)0.3f, d2 + this.rand.nextGaussian() * (double)0.3f, d4 + this.rand.nextGaussian() * (double)0.3f, 0.0, 0.0, 0.0);
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        int i = MathHelper.floor_double((double)this.posX);
        int j = MathHelper.floor_double((double)this.posY);
        int k = MathHelper.floor_double((double)this.posZ);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        if (this.shootingTimer >= 0) {
            --this.shootingTimer;
        }
        if (this.shootingTimer <= 0) {
            this.shootingTimer = 0;
        }
    }

    public void fall(float distance, float damageMultiplier) {
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        tagCompound.setBoolean("PlayerCreated", this.isPlayerCreated());
        tagCompound.setInteger("Ench1Level", this.durabilityLevel);
        tagCompound.setInteger("Ench2Level", this.ferocityLevel);
        tagCompound.setInteger("Ench3Level", this.maniacLevel);
        tagCompound.setInteger("Ench4Level", this.unstabilityLevel);
        tagCompound.setInteger("Ench5Level", this.shurakinLevel);
        tagCompound.setInteger("Ench6Level", this.unbreakingLevel);
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        if (tagCompund.hasKey("Ench1Level", 99)) {
            this.durabilityLevel = tagCompund.getInteger("Ench1Level");
        }
        if (tagCompund.hasKey("Ench2Level", 99)) {
            this.ferocityLevel = tagCompund.getInteger("Ench2Level");
        }
        if (tagCompund.hasKey("Ench3Level", 99)) {
            this.maniacLevel = tagCompund.getInteger("Ench3Level");
        }
        if (tagCompund.hasKey("Ench4Level", 99)) {
            this.unstabilityLevel = tagCompund.getInteger("Ench4Level");
        }
        if (tagCompund.hasKey("Ench5Level", 99)) {
            this.shurakinLevel = tagCompund.getInteger("Ench5Level");
        }
        if (tagCompund.hasKey("Ench6Level", 99)) {
            this.unbreakingLevel = tagCompund.getInteger("Ench6Level");
        }
        this.setPlayerCreated(tagCompund.getBoolean("PlayerCreated"));
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

    private double func_82214_u(int p_82214_1_) {
        if (p_82214_1_ <= 0) {
            return this.posX;
        }
        float f = (this.renderYawOffset + (float)(180 * (p_82214_1_ - 1))) / 180.0f * (float)Math.PI;
        float f1 = MathHelper.cos((float)f);
        return this.posX + (double)f1 * 1.2;
    }

    private double func_82208_v(int p_82208_1_) {
        return p_82208_1_ <= 0 ? this.posY + 0.5 : this.posY + 1.15;
    }

    private double func_82213_w(int p_82213_1_) {
        if (p_82213_1_ <= 0) {
            return this.posZ;
        }
        float f = (this.renderYawOffset + (float)(180 * (p_82213_1_ - 1))) / 180.0f * (float)Math.PI;
        float f1 = MathHelper.sin((float)f);
        return this.posZ + (double)f1 * 1.2;
    }

    private void launchWitherSkullToEntity(int p_82216_1_, EntityLivingBase p_82216_2_) {
        if (p_82216_2_.getDistanceSqToEntity((Entity)this) > 900.0 || p_82216_2_.posY >= this.posY + 5.0) {
            this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.posX + (this.rand.nextDouble() * 2.0 - 1.0), p_82216_2_.posY + 0.5, p_82216_2_.posZ + (this.rand.nextDouble() * 2.0 - 1.0), false);
        } else {
            this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.posX, p_82216_2_.posY + 0.5, p_82216_2_.posZ, false);
        }
    }

    private void launchWitherSkullToCoords(int p_82209_1_, double p_82209_2_, double p_82209_4_, double p_82209_6_, boolean p_82209_8_) {
        if (this.shootingTimer <= 0) {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 0.15f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 1.8f);
            this.playSound("thetitans:turretShoot2", 3.0f, 1.0f);
            double d3 = this.func_82214_u(1);
            double d4 = this.func_82208_v(1);
            double d5 = this.func_82213_w(1);
            double d6 = p_82209_2_ - d3;
            double d7 = p_82209_4_ - d4;
            double d8 = p_82209_6_ - d5;
            EntityBulletWitherSkull entitywitherskull = new EntityBulletWitherSkull(this.worldObj, (EntityLivingBase)this, d6, d7, d8);
            if (p_82209_8_) {
                entitywitherskull.setInvulnerable(true);
            }
            entitywitherskull.extraDamage = this.ferocityLevel * 2;
            entitywitherskull.explosivePower = (int)((float)this.unstabilityLevel * 0.75f);
            entitywitherskull.speedFactor = (float)this.shurakinLevel * 0.1f;
            entitywitherskull.posY = d4;
            entitywitherskull.posX = d3;
            entitywitherskull.posZ = d5;
            this.worldObj.spawnEntityInWorld((Entity)entitywitherskull);
            this.playSound("thetitans:turretShoot2", 6.0f, 1.0f);
            double d31 = this.func_82214_u(2);
            double d41 = this.func_82208_v(2);
            double d51 = this.func_82213_w(2);
            double d61 = p_82209_2_ - d31;
            double d71 = p_82209_4_ - d41;
            double d81 = p_82209_6_ - d51;
            EntityBulletWitherSkull entitywitherskull1 = new EntityBulletWitherSkull(this.worldObj, (EntityLivingBase)this, d61, d71, d81);
            if (p_82209_8_) {
                entitywitherskull1.setInvulnerable(true);
            }
            entitywitherskull1.extraDamage = this.ferocityLevel * 2;
            entitywitherskull1.explosivePower = (int)((float)this.unstabilityLevel * 0.75f);
            entitywitherskull1.speedFactor = (float)this.shurakinLevel * 0.1f;
            entitywitherskull1.posY = d41;
            entitywitherskull1.posX = d31;
            entitywitherskull1.posZ = d51;
            this.worldObj.spawnEntityInWorld((Entity)entitywitherskull1);
            --this.shots;
            --this.shots;
            if (this.shots > 0) {
                this.shootingTimer = 2;
            } else {
                this.shootingTimer = 14 - this.maniacLevel * 4;
                for (int j = 0; j < 3; ++j) {
                    double d10 = this.func_82214_u(j);
                    double d2 = this.func_82208_v(j);
                    double d24 = this.func_82213_w(j);
                    this.worldObj.spawnParticle("largesmoke", d10 + this.rand.nextGaussian() * (double)0.3f, d2 + this.rand.nextGaussian() * (double)0.3f, d24 + this.rand.nextGaussian() * (double)0.3f, 0.0, 0.0, 0.0);
                }
            }
            int i = MathHelper.floor_double((double)this.posX);
            int j = MathHelper.floor_double((double)(this.posY - 1.0));
            int k = MathHelper.floor_double((double)this.posZ);
            this.worldObj.setBlock(i, j, k, Blocks.glowstone);
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source.getEntity() instanceof EntityWitherTurretMortar || source.getEntity() instanceof EntityWitherTurretGround || source.getEntity() instanceof EntityWitherTurret) {
            return false;
        }
        if (source == DamageSource.anvil || source == DamageSource.generic || source == DamageSource.inFire || source == DamageSource.lava || source == DamageSourceExtra.lightningBolt || source == DamageSource.onFire || source == DamageSource.magic || source == DamageSource.wither || source == DamageSource.fallingBlock || source == DamageSource.drown || source == DamageSource.cactus) {
            return false;
        }
        Entity entity = source.getEntity();
        if (entity instanceof EntityLivingBase && !this.isEntityInvulnerable()) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(100.0, 100.0, 100.0));
            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1 instanceof EntityWitherTurretGround) {
                    EntityWitherTurretGround entitypigzombie = (EntityWitherTurretGround)entity1;
                    entitypigzombie.setAttackTarget((EntityLivingBase)entity);
                    entitypigzombie.setRevengeTarget((EntityLivingBase)entity);
                }
                this.setAttackTarget((EntityLivingBase)entity);
                this.setRevengeTarget((EntityLivingBase)entity);
                this.shootingTimer -= 4;
            }
        }
        return super.attackEntityFrom(source, amount);
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.launchWitherSkullToEntity(1, p_82196_1_);
        this.getLookHelper().setLookPositionWithEntity((Entity)p_82196_1_, 180.0f, 180.0f);
    }

    protected String getLivingSound() {
        return "mob.wither.idle";
    }

    protected String getHurtSound() {
        return "mob.wither.hurt";
    }

    protected String getDeathSound() {
        return this.isPlayerCreated() ? "mob.wither.hurt" : "mob.wither.death";
    }

    protected void onDeathUpdate() {
        int i;
        int j;
        this.setDead();
        if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
            if (this.isPlayerCreated()) {
                ItemStack goodTurret = new ItemStack(TitanItems.goodTurret2);
                if (this.durabilityLevel > 0) {
                    goodTurret.addEnchantment(TheTitans.turretEnchant1, this.durabilityLevel);
                }
                if (this.ferocityLevel > 0) {
                    goodTurret.addEnchantment(TheTitans.turretEnchant2, this.ferocityLevel);
                }
                if (this.maniacLevel > 0) {
                    goodTurret.addEnchantment(TheTitans.turretEnchant3, this.maniacLevel);
                }
                if (this.unstabilityLevel > 0) {
                    goodTurret.addEnchantment(TheTitans.turretEnchant4, this.unstabilityLevel);
                }
                if (this.shurakinLevel > 0) {
                    goodTurret.addEnchantment(TheTitans.turretEnchant5, this.shurakinLevel);
                }
                if (this.unbreakingLevel > 0) {
                    goodTurret.addEnchantment(Enchantment.unbreaking, this.unbreakingLevel);
                }
                this.entityDropItem(goodTurret, 3.0f);
            } else {
                this.entityDropItem(new ItemStack(Items.skull, 1, 1), 6.0f);
                this.entityDropItem(new ItemStack(Items.skull, 1, 1), 3.0f);
            }
            for (i = 10; i > 0; i -= j) {
                j = EntityXPOrb.getXPSplit((int)i);
                this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY + 4.0, this.posZ, j));
            }
            for (i = 20; i > 0; i -= j) {
                j = EntityXPOrb.getXPSplit((int)i);
                this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY + 4.0, this.posZ, j));
            }
        }
        i = MathHelper.floor_double((double)this.posX);
        j = MathHelper.floor_double((double)(this.posY - 1.0));
        int k = MathHelper.floor_double((double)this.posZ);
        this.worldObj.setBlock(i, j, k, Blocks.bedrock);
        if (!this.worldObj.isRemote) {
            this.playSound("thetitans:turretDeath2", 6.0f, 1.0f);
            this.playSound("thetitans:turretDeath2", 6.0f, 1.0f);
            this.playSound("thetitans:turretDeath2", 6.0f, 1.0f);
            this.playSound("thetitans:turretDeath2", 6.0f, 1.0f);
            this.playSound("thetitans:turretDeath2", 6.0f, 1.0f);
            this.playSound("thetitans:turretDeath2", 6.0f, 1.0f);
            this.playSound("thetitans:turretDeath2", 6.0f, 1.0f);
            this.playSound("thetitans:turretDeath2", 6.0f, 1.0f);
            this.worldObj.createExplosion((Entity)null, this.posX, this.posY - 1.0, this.posZ, 2.0f, true);
        }
    }

    public float getEyeHeight() {
        return 1.1f;
    }

    public AxisAlignedBB getCollisionBox(Entity entityIn) {
        return entityIn.boundingBox;
    }

    public AxisAlignedBB getBoundingBox() {
        return this.boundingBox;
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public boolean canBePushed() {
        return false;
    }

    public boolean isEnchanted() {
        return this.durabilityLevel > 0 || this.ferocityLevel > 0 || this.maniacLevel > 0 || this.unstabilityLevel > 0 || this.shurakinLevel > 0 || this.unbreakingLevel > 0;
    }

    public boolean shouldShowEnchants() {
        return this.isEnchanted();
    }

    protected void collideWithNearbyEntities() {
    }

    public void knockBack(Entity p_70653_1_, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
    }

    public void addVelocity(double x, double y, double z) {
    }

    public void moveEntity(double x, double y, double z) {
    }

    protected int decreaseAirSupply(int p_70682_1_) {
        return p_70682_1_;
    }
}

