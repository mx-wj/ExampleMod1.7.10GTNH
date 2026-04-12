/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
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
import net.minecraft.block.Block;
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
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityMortarWitherSkull;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWitherTurret;
import net.minecraft.entity.titan.EntityWitherTurretGround;
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

public class EntityWitherTurretMortar
extends EntityGolem
implements IRangedAttackMob {
    public int durabilityLevel;
    public int ferocityLevel;
    public int maniacLevel;
    public int unstabilityLevel;
    public int shurakinLevel;
    public int unbreakingLevel;
    public int shootingTimer;
    private IEntitySelector attackEntitySelector = new IEntitySelector(){
        private EntityWitherTurretMortar turret;
        {
            this.turret = EntityWitherTurretMortar.this;
        }

        public boolean isEntityApplicable(Entity p_180027_1_) {
            return p_180027_1_ instanceof EntityLivingBase && this.turret.canTargetEntity((EntityLivingBase)p_180027_1_) && p_180027_1_.isEntityAlive() && p_180027_1_.posY <= this.turret.posY + 8.0;
        }
    };

    public EntityWitherTurretMortar(World worldIn) {
        super(worldIn);
        this.isImmuneToFire = true;
        this.preventEntitySpawning = true;
        this.setSize(1.0f, 3.75f);
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
        int i = 2 + this.unbreakingLevel * 7;
        if (i > 24) {
            i = 24;
        }
        return i;
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(7000.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(200.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)0);
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
        this.onGround = true;
        this.isAirBorne = false;
        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        this.isImmuneToFire = true;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.ticksExisted % 40 == 0) {
            this.heal(1.0f + (float)this.durabilityLevel);
        }
        if (!this.worldObj.isRemote && this.worldObj.getBlock(i = MathHelper.floor_double((double)this.posX), j = MathHelper.floor_double((double)(this.posY - 1.0)), k = MathHelper.floor_double((double)this.posZ)) != Blocks.bedrock) {
            this.worldObj.setBlock(i, j, k, Blocks.bedrock);
        }
        double d8 = 49.0;
        Vec3 vec3 = this.getLook(1.0f);
        double dx = vec3.xCoord * d8;
        double dz = vec3.zCoord * d8;
        List list11 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.getBoundingBox().expand(50.0, 100.0, 50.0).offset(dx, 0.0, dz));
        if (list11 != null && !list11.isEmpty() && this.getAttackTarget() == null) {
            for (int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity instanceof EntityLivingBase && entity != null && entity.isEntityAlive() && this.getAttackTarget() == null && this.canTargetEntity((EntityLivingBase)entity) && this.canEntityBeSeen(entity)) {
                    this.setAttackTarget((EntityLivingBase)entity);
                    continue;
                }
                list11.remove(entity);
            }
        }
        if (this.getAttackTarget() != null) {
            if (!this.worldObj.isRemote) {
                this.attackEntityWithRangedAttack(this.getAttackTarget(), 1.0f);
            }
            this.getLookHelper().setLookPositionWithEntity((Entity)this.getAttackTarget(), 10.0f, 180.0f);
            this.renderYawOffset = this.rotationYaw = this.rotationYawHead;
            if (!this.getAttackTarget().isEntityAlive() || this.getAttackTarget().isDead || this.getAttackTarget().getDistanceSqToEntity((Entity)this) > 10000.0 || !this.canEntityBeSeen((Entity)this.getAttackTarget())) {
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
        return this.posX;
    }

    private double func_82208_v(int p_82208_1_) {
        return this.posY + 3.0;
    }

    private double func_82213_w(int p_82213_1_) {
        return this.posZ;
    }

    private void launchWitherSkullToEntity(int p_82216_1_, EntityLivingBase p_82216_2_) {
        this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.posX, p_82216_2_.posY + 0.25, p_82216_2_.posZ, false);
    }

    private void launchWitherSkullToCoords(int p_82209_1_, double p_82209_2_, double p_82209_4_, double p_82209_6_, boolean p_82209_8_) {
        if (this.shootingTimer <= 0) {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 0.5f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.6f);
            this.playSound("thetitans:mortarShoot", 3.0f, 1.0f);
            double d3 = this.func_82214_u(1);
            double d4 = this.func_82208_v(1);
            double d5 = this.func_82213_w(1);
            double d6 = p_82209_2_ - d3;
            double d7 = p_82209_4_ - d4;
            double d8 = p_82209_6_ - d5;
            EntityMortarWitherSkull entitywitherskull = new EntityMortarWitherSkull(this.worldObj, (EntityLivingBase)this, d6, d7, d8);
            entitywitherskull.setInvulnerable(true);
            entitywitherskull.extraDamage = this.ferocityLevel * 2;
            entitywitherskull.explosivePower = (int)((float)this.unstabilityLevel * 0.75f);
            entitywitherskull.speedFactor = (float)this.shurakinLevel * 0.1f;
            entitywitherskull.posY = d4;
            entitywitherskull.posX = d3;
            entitywitherskull.posZ = d5;
            this.worldObj.spawnEntityInWorld((Entity)entitywitherskull);
            this.shootingTimer = 60 - this.maniacLevel * 10;
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
                if (entity1 instanceof EntityWitherTurretMortar) {
                    EntityWitherTurretMortar entitypigzombie = (EntityWitherTurretMortar)entity1;
                    entitypigzombie.setAttackTarget((EntityLivingBase)entity);
                    entitypigzombie.setRevengeTarget((EntityLivingBase)entity);
                }
                this.setAttackTarget((EntityLivingBase)entity);
                this.setRevengeTarget((EntityLivingBase)entity);
            }
        }
        return super.attackEntityFrom(source, amount);
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.launchWitherSkullToEntity(1, p_82196_1_);
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

    protected float getSoundPitch() {
        return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 0.9f;
    }

    protected void onDeathUpdate() {
        int i;
        int j;
        this.setDead();
        if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
            if (this.isPlayerCreated()) {
                ItemStack goodTurret = new ItemStack(TitanItems.goodTurret3);
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
                this.entityDropItem(new ItemStack(Items.skull, 1, 1), 10.0f);
                this.entityDropItem(new ItemStack(Items.skull, 1, 1), 9.0f);
                this.entityDropItem(new ItemStack(Items.skull, 1, 1), 8.0f);
                this.entityDropItem(new ItemStack((Block)Blocks.beacon, 1), 6.0f);
                this.dropItem(Items.nether_star, this.rand.nextInt(3));
            }
            for (i = 600; i > 0; i -= j) {
                j = EntityXPOrb.getXPSplit((int)i);
                this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY + 9.0, this.posZ, j));
            }
            for (i = 300; i > 0; i -= j) {
                j = EntityXPOrb.getXPSplit((int)i);
                this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY + 9.0, this.posZ, j));
            }
        }
        i = MathHelper.floor_double((double)this.posX);
        j = MathHelper.floor_double((double)(this.posY - 1.0));
        int k = MathHelper.floor_double((double)this.posZ);
        this.worldObj.setBlock(i, j, k, Blocks.bedrock);
        if (!this.worldObj.isRemote) {
            this.playSound("thetitans:turretDeath3", 10.0f, 1.0f);
            this.worldObj.createExplosion((Entity)null, this.posX, this.posY - 1.0, this.posZ, 3.0f, true);
        }
    }

    public float getEyeHeight() {
        return 3.0f;
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

