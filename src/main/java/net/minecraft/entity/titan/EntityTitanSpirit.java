/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityFallingBlock
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldServer
 */
package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.EntityBlazeTitan;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titanminion.EntityBlazeMinion;
import net.minecraft.entity.titanminion.EntityCaveSpiderMinion;
import net.minecraft.entity.titanminion.EntityCreeperMinion;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
import net.minecraft.entity.titanminion.EntityGhastMinion;
import net.minecraft.entity.titanminion.EntityPigZombieMinion;
import net.minecraft.entity.titanminion.EntitySilverfishMinion;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.entity.titanminion.EntitySpiderMinion;
import net.minecraft.entity.titanminion.EntityZombieMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityTitanSpirit
extends EntityLiving {
    public int spiritType;
    public int spiritNameID;
    public float tonnage;
    public boolean isSearchingForVessel = true;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private EntityLivingBase prevEntity;

    public EntityTitanSpirit(World worldIn) {
        super(worldIn);
        this.setSize(8.0f, 8.0f);
        this.noClip = true;
        this.isImmuneToFire = true;
        this.ignoreFrustumCheck = true;
        this.playSound("thetitans:titanBirth", 10000.0f, 2.0f);
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.setTonnage(tagCompund.getFloat("Tonnage"));
        this.setSpiritType(tagCompund.getInteger("SpiritType"));
        this.setSpiritNameID(tagCompund.getInteger("SpiritNameID"));
        this.setVesselHunting(tagCompund.getBoolean("ShouldHuntForVessels"));
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setFloat("Tonnage", this.getTonnage());
        tagCompound.setInteger("SpiritType", this.getSpiritType());
        tagCompound.setInteger("SpiritNameID", this.getSpiritNameID());
        tagCompound.setBoolean("ShouldHuntForVessels", this.isVesselHunting());
    }

    protected void fall(float p_70069_1_) {
    }

    protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
    }

    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
        if (this.isInWater()) {
            this.moveFlying(p_70612_1_, p_70612_2_, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)0.8f;
            this.motionY *= (double)0.8f;
            this.motionZ *= (double)0.8f;
        } else if (this.handleLavaMovement()) {
            this.moveFlying(p_70612_1_, p_70612_2_, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        } else {
            float f2 = 0.91f;
            if (this.onGround) {
                f2 = this.worldObj.getBlock((int)MathHelper.floor_double((double)this.posX), (int)(MathHelper.floor_double((double)this.boundingBox.minY) - 1), (int)MathHelper.floor_double((double)this.posZ)).slipperiness * 0.91f;
            }
            float f3 = 0.16277136f / (f2 * f2 * f2);
            this.moveFlying(p_70612_1_, p_70612_2_, this.onGround ? 0.1f * f3 : 0.02f);
            f2 = 0.91f;
            if (this.onGround) {
                f2 = this.worldObj.getBlock((int)MathHelper.floor_double((double)this.posX), (int)(MathHelper.floor_double((double)this.boundingBox.minY) - 1), (int)MathHelper.floor_double((double)this.posZ)).slipperiness * 0.91f;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)f2;
            this.motionY *= (double)f2;
            this.motionZ *= (double)f2;
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d1 = this.posX - this.prevPosX;
        double d0 = this.posZ - this.prevPosZ;
        float f4 = MathHelper.sqrt_double((double)(d1 * d1 + d0 * d0)) * 4.0f;
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }

    public boolean isOnLadder() {
        return false;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Double.MAX_VALUE);
    }

    public boolean isVesselHunting() {
        return this.isSearchingForVessel;
    }

    public void setVesselHunting(boolean p_70819_1_) {
        this.isSearchingForVessel = p_70819_1_;
    }

    public int getSpiritType() {
        return this.spiritType;
    }

    public void setSpiritType(int p_82215_1_) {
        this.spiritType = p_82215_1_;
    }

    public int getSpiritNameID() {
        return this.spiritNameID;
    }

    public void setSpiritNameID(int p_82215_1_) {
        this.spiritNameID = p_82215_1_;
    }

    public float getTonnage() {
        return this.tonnage;
    }

    public void setTonnage(float p_82215_1_) {
        this.tonnage = p_82215_1_;
    }

    public float getMaxTonnage() {
        switch (this.getSpiritType()) {
            case 1: {
                return 8000.0f;
            }
            case 2: {
                return 12000.0f;
            }
            case 3: {
                return 16000.0f;
            }
            case 4: {
                return 20000.0f;
            }
            case 5: {
                return 100000.0f;
            }
            case 6: {
                return 20000.0f;
            }
            case 7: {
                return 25000.0f;
            }
            case 8: {
                return 20000.0f;
            }
            case 9: {
                return 40000.0f;
            }
            case 10: {
                return 150000.0f;
            }
            case 11: {
                return 200000.0f;
            }
            case 12: {
                return 1.0E7f;
            }
        }
        return 1.0f;
    }

    public String getCommandSenderName() {
        switch (this.getSpiritType()) {
            case 1: {
                return StatCollector.translateToLocal((String)"entity.SilverfishTitan.name");
            }
            case 2: {
                return StatCollector.translateToLocal((String)"entity.CaveSpiderTitan.name");
            }
            case 3: {
                return StatCollector.translateToLocal((String)"entity.SpiderTitan.name");
            }
            case 4: {
                return StatCollector.translateToLocal((String)"entity.SkeletonTitan.name");
            }
            case 5: {
                return StatCollector.translateToLocal((String)"entity.WitherSkeletonTitan.name");
            }
            case 6: {
                return StatCollector.translateToLocal((String)"entity.ZombieTitan.name");
            }
            case 7: {
                return StatCollector.translateToLocal((String)"entity.CreeperTitan.name");
            }
            case 8: {
                return StatCollector.translateToLocal((String)"entity.PigZombieTitan.name");
            }
            case 9: {
                return StatCollector.translateToLocal((String)"entity.BlazeTitan.name");
            }
            case 10: {
                return StatCollector.translateToLocal((String)"entity.EndermanTitan.realname");
            }
            case 11: {
                return StatCollector.translateToLocal((String)"entity.GhastTitan.name");
            }
            case 12: {
                return "\u00a7kRegnator";
            }
        }
        return StatCollector.translateToLocal((String)"entity.TitanSpirit.name");
    }

    public void setDead() {
        if (!this.worldObj.isRemote) {
            switch (this.getSpiritType()) {
                case 1: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 18.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntitySilverfishTitan omegafish = new EntitySilverfishTitan(this.worldObj);
                    omegafish.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    omegafish.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)omegafish);
                    break;
                }
                case 2: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 12.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntityCaveSpiderTitan cavespidertitan = new EntityCaveSpiderTitan(this.worldObj);
                    cavespidertitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    cavespidertitan.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)cavespidertitan);
                    break;
                }
                case 3: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 12.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntitySpiderTitan spidertitan = new EntitySpiderTitan(this.worldObj);
                    spidertitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    spidertitan.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)spidertitan);
                    break;
                }
                case 4: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 18.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntitySkeletonTitan skeletontitan = new EntitySkeletonTitan(this.worldObj);
                    skeletontitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    skeletontitan.setSkeletonType(0);
                    skeletontitan.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)skeletontitan);
                    break;
                }
                case 5: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 18.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntitySkeletonTitan witherskeletontitan = new EntitySkeletonTitan(this.worldObj);
                    witherskeletontitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    witherskeletontitan.setSkeletonType(1);
                    witherskeletontitan.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)witherskeletontitan);
                    break;
                }
                case 6: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 18.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntityZombieTitan zombietitan = new EntityZombieTitan(this.worldObj);
                    zombietitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    zombietitan.onSpawnWithEgg(null);
                    zombietitan.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)zombietitan);
                    if (this.prevEntity == null) break;
                    zombietitan.setChild(((EntityZombieMinion)this.prevEntity).isChild());
                    zombietitan.setVillager(((EntityZombieMinion)this.prevEntity).isVillager());
                    break;
                }
                case 7: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 18.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntityCreeperTitan creepertitan = new EntityCreeperTitan(this.worldObj);
                    creepertitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    creepertitan.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)creepertitan);
                    if (this.prevEntity == null) break;
                    creepertitan.setPowered(((EntityCreeperMinion)this.prevEntity).getPowered());
                    break;
                }
                case 8: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 18.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntityPigZombieTitan pigzombietitan = new EntityPigZombieTitan(this.worldObj);
                    pigzombietitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    pigzombietitan.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)pigzombietitan);
                    if (this.prevEntity == null) break;
                    pigzombietitan.setChild(((EntityPigZombieMinion)this.prevEntity).isChild());
                    break;
                }
                case 9: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 16.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntityBlazeTitan blazetitan = new EntityBlazeTitan(this.worldObj);
                    blazetitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    blazetitan.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)blazetitan);
                    break;
                }
                case 10: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 45.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntityEnderColossus endercolossus = new EntityEnderColossus(this.worldObj);
                    endercolossus.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    endercolossus.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)endercolossus);
                    break;
                }
                case 11: {
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 8.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntityGhastTitan ghasttitan = new EntityGhastTitan(this.worldObj);
                    ghasttitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    ghasttitan.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)ghasttitan);
                    break;
                }
                case 12: {
                    if (this.worldObj.provider instanceof WorldProviderVoid) {
                        if (this.prevEntity != null) {
                            ((EntityPlayer)this.prevEntity).addChatMessage((IChatComponent)new ChatComponentText("In the end, you are your own undoing."));
                        }
                        this.worldObj.theProfiler.startSection("changeDimension");
                        MinecraftServer minecraftserver = MinecraftServer.getServer();
                        int j = this.dimension;
                        WorldServer worldserver = minecraftserver.worldServerForDimension(j);
                        WorldServer worldserver1 = minecraftserver.worldServerForDimension(0);
                        this.dimension = 0;
                        this.worldObj.theProfiler.startSection("reposition");
                        minecraftserver.getConfigurationManager().transferEntityToWorld((Entity)this, j, worldserver, worldserver1);
                        this.worldObj.theProfiler.endStartSection("reloading");
                        Entity entity = EntityList.createEntityByName((String)EntityList.getEntityString((Entity)this), (World)worldserver1);
                        if (entity != null) {
                            entity.copyDataFrom((Entity)this, true);
                            worldserver1.spawnEntityInWorld(entity);
                        }
                        this.worldObj.theProfiler.endSection();
                        worldserver.resetUpdateEntityTick();
                        worldserver1.resetUpdateEntityTick();
                        this.worldObj.theProfiler.endSection();
                        break;
                    }
                    if (this.prevEntity != null) {
                        ((EntityPlayer)this.prevEntity).attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
                        ((EntityPlayer)this.prevEntity).setHealth(0.0f);
                        ((EntityPlayer)this.prevEntity).getDataWatcher().updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)0.0f, (float)0.0f, (float)((EntityPlayer)this.prevEntity).getMaxHealth())));
                    }
                    this.worldObj.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 7.0f, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    EntityWitherzilla witherzilla = new EntityWitherzilla(this.worldObj);
                    witherzilla.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    witherzilla.func_82206_m();
                    this.worldObj.spawnEntityInWorld((Entity)witherzilla);
                    if (this.prevEntity == null) break;
                    ((EntityPlayer)this.prevEntity).addChatMessage((IChatComponent)new ChatComponentText("This universe is flawed, Notch. They've corrupted it. It has to go."));
                }
            }
            ArrayList listp = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
            if (this.getSpiritType() != 12 && listp != null && !listp.isEmpty() && !this.worldObj.isRemote) {
                for (int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity == null || !(entity instanceof EntityPlayer)) continue;
                    this.playLivingSound();
                    ((EntityPlayer)entity).addChatMessage((IChatComponent)new ChatComponentText(this.getCommandSenderName() + ": Now to return to where we left off, " + ((EntityPlayer)entity).getCommandSenderName() + "."));
                }
            }
        }
        super.setDead();
    }

    public void onLivingUpdate() {
        int i;
        if (this.getTonnage() >= this.getMaxTonnage()) {
            this.setDead();
        }
        if (this.getTonnage() < 0.0f) {
            this.setTonnage(0.0f);
        } else {
            this.setTonnage(this.getTonnage() - 1.0f);
        }
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(32.0, 32.0, 32.0));
        if (this.isVesselHunting() && list != null && !list.isEmpty()) {
            for (i = 0; i < list.size(); ++i) {
                double mz;
                double my;
                double mx;
                Entity entity = (Entity)list.get(i);
                if (entity != null && entity.isEntityAlive() && entity instanceof EntityLivingBase && !(entity instanceof EntityTitan) && !(entity instanceof EntityTitanSpirit) && !(entity instanceof EntityTitanPart)) {
                    if (this.ticksExisted + this.getEntityId() % 40 == 0) {
                        entity.attackEntityFrom(DamageSourceExtra.causeSoulStealingDamage((Entity)this), 2.0f);
                    }
                    double speed = entity.isSneaking() ? 0.2 : 0.4;
                    double mx2 = this.posX - entity.posX;
                    double my2 = this.posY + 4.0 - (entity.posY + 1.0);
                    double mz2 = this.posZ - entity.posZ;
                    float f2 = MathHelper.sqrt_double((double)(mx2 * mx2 + my2 * my2 + mz2 * mz2));
                    entity.motionX = mx2 / (double)f2 * speed * speed + entity.motionX;
                    entity.motionY = my2 / (double)f2 * speed * speed + entity.motionY;
                    entity.motionZ = mz2 / (double)f2 * speed * speed + entity.motionZ;
                    int short1 = (int)this.getDistanceToEntity(entity);
                    for (int f = 0; f < short1; ++f) {
                        double d9 = (double)f / ((double)short1 - 1.0);
                        double d6 = this.posX + mx2 * -d9;
                        double d7 = this.posY + 4.0 + my2 * -d9;
                        double d8 = this.posZ + mz2 * -d9;
                        this.worldObj.spawnParticle("fireworksSpark", d6, d7, d8, entity.motionX, entity.motionY, entity.motionZ);
                    }
                }
                if (entity != null && entity instanceof EntityItem) {
                    entity.hurtResistantTime = 0;
                    mx = this.posX - entity.posX;
                    my = this.posY + 4.0 - entity.posY;
                    mz = this.posZ - entity.posZ;
                    float f2 = MathHelper.sqrt_double((double)(mx * mx + my * my + mz * mz));
                    entity.motionX = mx / (double)f2 * 0.3 * 0.3 + entity.motionX;
                    entity.motionY = my / (double)f2 * 0.3 * 0.3 + entity.motionY;
                    entity.motionZ = mz / (double)f2 * 0.3 * 0.3 + entity.motionZ;
                }
                if (entity != null && entity instanceof EntityTNTPrimed) {
                    entity.hurtResistantTime = 0;
                    mx = this.posX - entity.posX;
                    my = this.posY + 4.0 - entity.posY;
                    mz = this.posZ - entity.posZ;
                    float f2 = MathHelper.sqrt_double((double)(mx * mx + my * my + mz * mz));
                    entity.motionX = mx / (double)f2 * 0.3 * 0.3 + entity.motionX;
                    entity.motionY = my / (double)f2 * 0.3 * 0.3 + entity.motionY;
                    entity.motionZ = mz / (double)f2 * 0.3 * 0.3 + entity.motionZ;
                }
                if (entity != null && entity instanceof EntityFallingBlock) {
                    entity.hurtResistantTime = 0;
                    float f6 = (float)(entity.ticksExisted + entity.getEntityId()) * (float)Math.PI * -0.5f;
                    double mx3 = this.posX + (double)(MathHelper.cos((float)f6) * 16.0f) - entity.posX;
                    double my3 = this.posY + 4.0 - entity.posY;
                    double mz3 = this.posZ + (double)(MathHelper.sin((float)f6) * 16.0f) - entity.posZ;
                    float f2 = MathHelper.sqrt_double((double)(mx3 * mx3 + my3 * my3 + mz3 * mz3));
                    entity.motionX = mx3 / (double)f2 * 0.4 * 0.4 + entity.motionX;
                    entity.motionY = my3 / (double)f2 * 0.4 * 0.4 + entity.motionY;
                    entity.motionZ = mz3 / (double)f2 * 0.4 * 0.4 + entity.motionZ;
                    List<Entity> arraylist = new ArrayList<Entity>(this.worldObj.getEntitiesWithinAABBExcludingEntity(entity, entity.boundingBox));
                    boolean flag = ((EntityFallingBlock)entity).func_145805_f() == Blocks.anvil;
                    DamageSource damagesource = flag ? DamageSource.anvil : DamageSource.fallingBlock;
                    for (Entity entity1 : arraylist) {
                        entity1.attackEntityFrom(damagesource, 20.0f);
                    }
                }
                if (entity == null || !(entity instanceof EntityFireball)) continue;
                entity.hurtResistantTime = 0;
                double mx4 = this.posX - entity.posX;
                my = this.posY + 4.0 - entity.posY;
                mz = this.posZ - entity.posZ;
                float f2 = MathHelper.sqrt_double((double)(mx4 * mx4 + my * my + mz * mz));
                entity.motionX = mx4 / (double)f2 * 0.3 * 0.3 + entity.motionX;
                entity.motionY = my / (double)f2 * 0.3 * 0.3 + entity.motionY;
                entity.motionZ = mz / (double)f2 * 0.3 * 0.3 + entity.motionZ;
            }
        }
        if (this.spiritNameID <= 0) {
            this.spiritNameID = 1;
        }
        super.onLivingUpdate();
        if (this.posY <= -45.0) {
            this.setPosition(this.posX, 0.0, this.posZ);
        }
        this.setHealth(Float.MAX_VALUE);
        this.deathTime = 0;
        for (i = 0; i < 30; ++i) {
            float f = (this.rand.nextFloat() - 0.5f) * this.width;
            float f1 = (this.rand.nextFloat() - 0.5f) * this.height;
            float f2 = (this.rand.nextFloat() - 0.5f) * this.width;
            this.worldObj.spawnParticle("largeexplode", this.posX + (double)f, this.posY + 4.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("explode", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
            this.worldObj.spawnParticle("fireworksSpark", this.posX + (double)f, this.posY + 4.0 + (double)f1, this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
        }
        List theBoundingBox = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox);
        if (theBoundingBox != null && !theBoundingBox.isEmpty()) {
            for (int i1 = 0; i1 < theBoundingBox.size(); ++i1) {
                Entity entity = (Entity)theBoundingBox.get(i1);
                if (entity == null) continue;
                if (this.spiritType == 1 && entity instanceof EntitySilverfishMinion && ((EntitySilverfishMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntitySilverfishMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 2 && entity instanceof EntityCaveSpiderMinion && ((EntityCaveSpiderMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntityCaveSpiderMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 3 && entity instanceof EntitySpiderMinion && ((EntitySpiderMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntitySpiderMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 4 && entity instanceof EntitySkeletonMinion && ((EntitySkeletonMinion)entity).getSkeletonType() != 1 && ((EntitySkeletonMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntitySkeletonMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 5 && entity instanceof EntitySkeletonMinion && ((EntitySkeletonMinion)entity).getSkeletonType() == 1 && ((EntitySkeletonMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntitySkeletonMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 6 && entity instanceof EntityZombieMinion && ((EntityZombieMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntityZombieMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 7 && entity instanceof EntityCreeperMinion && ((EntityCreeperMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntityCreeperMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 8 && entity instanceof EntityPigZombieMinion && ((EntityPigZombieMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntityPigZombieMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 9 && entity instanceof EntityBlazeMinion && ((EntityBlazeMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntityBlazeMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 10 && entity instanceof EntityEndermanMinion && ((EntityEndermanMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntityEndermanMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 11 && entity instanceof EntityGhastMinion && ((EntityGhastMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                    this.prevEntity = (EntityGhastMinion)entity;
                    this.setDead();
                }
                if (this.spiritType == 12 && entity instanceof EntityPlayer) {
                    this.prevEntity = (EntityPlayer)entity;
                    this.setDead();
                }
                if (entity instanceof EntityLivingBase) {
                    ((EntityLivingBase)entity).attackEntityFrom(DamageSourceExtra.causeSoulStealingDamage((Entity)this), 100.0f);
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.wither.id, 300, 3));
                }
                if (entity instanceof EntityItem && ((EntityItem)entity).delayBeforeCanPickup < 0 && ((EntityItem)entity).getEntityItem().getItem() != Items.nether_star) {
                    ((EntityItem)entity).attackEntityFrom(DamageSourceExtra.causeSoulStealingDamage((Entity)this), 100.0f);
                }
                if (!(entity instanceof EntityEnderCrystal)) continue;
                ((EntityEnderCrystal)entity).attackEntityFrom(DamageSourceExtra.causeSoulStealingDamage((Entity)this), 100.0f);
            }
        }
    }

    protected void updateEntityActionState() {
        block22: {
            block21: {
                block23: {
                    super.updateEntityActionState();
                    if (this.waypointY <= 0.0) {
                        this.waypointY = 0.0;
                    }
                    if (this.waypointY > 255.0) {
                        this.waypointY = 255.0;
                    }
                    if (this.isVesselHunting() && this.ticksExisted % 20 == 0 && this.rand.nextInt(5) == 0) {
                        EntityPlayer player = this.worldObj.getClosestPlayerToEntity((Entity)this, 256.0);
                        if (player != null) {
                            this.waypointX = player.posX + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 32.0f);
                            this.waypointY = player.posY + 32.0 + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f);
                            this.waypointZ = player.posZ + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 32.0f);
                        } else {
                            this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 32.0f);
                            this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 32.0f);
                            this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 32.0f);
                        }
                    }
                    double d0 = this.waypointX - this.posX;
                    double d1 = this.waypointY - this.posY;
                    double d2 = this.waypointZ - this.posZ;
                    double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                    d3 = MathHelper.sqrt_double((double)d3);
                    if (this.isVesselHunting() && this.getDistanceSq(this.waypointX, this.waypointY, this.waypointZ) > 40000.0) {
                        this.waypointX = this.posX;
                        this.waypointY = this.posY;
                        this.waypointZ = this.posZ;
                    }
                    if (this.getDistanceSq(this.waypointX, this.waypointY, this.waypointZ) > 4.0) {
                        this.motionX += d0 / d3 * 0.15;
                        this.motionY += d1 / d3 * 0.15;
                        this.motionZ += d2 / d3 * 0.15;
                    }
                    if (this.isVesselHunting()) break block21;
                    this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 128.0f);
                    this.waypointY = 255.0;
                    this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 128.0f);
                    if (!(this.posY >= 254.0)) break block22;
                    this.setVesselHunting(true);
                    if (this.worldObj.isRemote) break block22;
                    if (this.rand.nextInt(2) != 0 && this.getSpiritType() != 12) break block23;
                    this.worldObj.playBroadcastSound(1013, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    ArrayList listp = Lists.newArrayList((Iterable)this.worldObj.playerEntities);
                    if (listp == null || listp.isEmpty() || this.worldObj.isRemote) break block22;
                    for (int i1 = 0; i1 < listp.size(); ++i1) {
                        Entity entity = (Entity)listp.get(i1);
                        if (entity == null || !(entity instanceof EntityPlayer)) continue;
                        this.playLivingSound();
                        ((EntityPlayer)entity).addChatMessage((IChatComponent)new ChatComponentText(this.getCommandSenderName() + ": I always come back, " + ((EntityPlayer)entity).getCommandSenderName() + "."));
                    }
                    break block22;
                }
                this.setPosition(this.posX + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 1024.0f), 250.0, this.posZ + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 1024.0f));
                break block22;
            }
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0));
            if (list != null && !list.isEmpty()) {
                for (int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity == null) continue;
                    if (this.spiritType == 1 && entity instanceof EntitySilverfishMinion && ((EntitySilverfishMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType == 2 && entity instanceof EntityCaveSpiderMinion && ((EntityCaveSpiderMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType == 3 && entity instanceof EntitySpiderMinion && ((EntitySpiderMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType == 4 && entity instanceof EntitySkeletonMinion && ((EntitySkeletonMinion)entity).getSkeletonType() != 1 && ((EntitySkeletonMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType == 5 && entity instanceof EntitySkeletonMinion && ((EntitySkeletonMinion)entity).getSkeletonType() == 1 && ((EntitySkeletonMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType == 6 && entity instanceof EntityZombieMinion && ((EntityZombieMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType == 7 && entity instanceof EntityCreeperMinion && ((EntityCreeperMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType == 8 && entity instanceof EntityPigZombieMinion && ((EntityPigZombieMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType == 9 && entity instanceof EntityBlazeMinion && ((EntityBlazeMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType == 10 && entity instanceof EntityEndermanMinion && ((EntityEndermanMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType == 11 && entity instanceof EntityGhastMinion && ((EntityGhastMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        ((EntityLiving)entity).setAttackTarget((EntityLivingBase)this);
                        this.waypointX = entity.posX;
                        this.waypointY = entity.posY;
                        this.waypointZ = entity.posZ;
                    }
                    if (this.spiritType != 12 || !(entity instanceof EntityPlayer)) continue;
                    this.waypointX = entity.posX;
                    this.waypointY = entity.posY;
                    this.waypointZ = entity.posZ;
                }
            }
        }
    }

    protected void despawnEntity() {
    }

    protected void collideWithNearbyEntities() {
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(1.0, 1.0, 1.0));
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                float f2;
                double mz;
                double my;
                double mx;
                Entity entity = (Entity)list.get(i);
                if (entity != null && entity instanceof EntityLivingBase && !(entity instanceof EntityTitan) && !(entity instanceof EntityTitanSpirit) && !(entity instanceof EntityTitanPart)) {
                    entity.hurtResistantTime = 0;
                    mx = this.posX - entity.posX;
                    my = this.posY + 4.0 - entity.posY;
                    mz = this.posZ - entity.posZ;
                    f2 = MathHelper.sqrt_double((double)(mx * mx + my * my + mz * mz));
                    entity.motionX = mx / (double)f2 * 0.9 * 0.9 + entity.motionX;
                    entity.motionY = my / (double)f2 * 0.9 * 0.9 + entity.motionY;
                    entity.motionZ = mz / (double)f2 * 0.9 * 0.9 + entity.motionZ;
                    ((EntityLivingBase)entity).attackEntityFrom(DamageSourceExtra.causeSoulStealingDamage((Entity)this), 100.0f);
                    ((EntityLivingBase)entity).setHealth(((EntityLivingBase)entity).getHealth() - 100.0f);
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.wither.id, 100, 3));
                    ((EntityLivingBase)entity).copyLocationAndAnglesFrom((Entity)this);
                    if (((EntityLivingBase)entity).deathTime > 0) {
                        this.worldObj.spawnParticle("hugeexplosion", this.posX, this.posY, this.posZ, 1.0, 0.0, 0.0);
                        this.playSound("random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
                        this.playSound("thetitans:titanCreeperExplosion", 10.0f, this.getSoundPitch() + 0.5f);
                        this.playSound("mob.endermen.portal", 10.0f, this.getSoundPitch() + 0.75f);
                        ((EntityLivingBase)entity).setDead();
                        this.setTonnage(this.getTonnage() + ((EntityLivingBase)entity).getMaxHealth());
                    }
                }
                if (!this.isVesselHunting() || entity == null || !(entity instanceof EntityItem)) continue;
                entity.hurtResistantTime = 0;
                mx = this.posX - entity.posX;
                my = this.posY + 4.0 - entity.posY;
                mz = this.posZ - entity.posZ;
                f2 = MathHelper.sqrt_double((double)(mx * mx + my * my + mz * mz));
                entity.motionX = mx / (double)f2 * 0.9 * 0.9 + entity.motionX;
                entity.motionY = my / (double)f2 * 0.9 * 0.9 + entity.motionY;
                entity.motionZ = mz / (double)f2 * 0.9 * 0.9 + entity.motionZ;
                entity.attackEntityFrom(DamageSourceExtra.causeSoulStealingDamage((Entity)this), 100.0f);
            }
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public boolean canBePushed() {
        return false;
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    protected String getLivingSound() {
        switch (this.getSpiritType()) {
            case 1: {
                return "thetitans:titanSilverfishLiving";
            }
            case 2: {
                return "thetitans:titanSpiderLiving";
            }
            case 3: {
                return "thetitans:titanSpiderLiving";
            }
            case 4: {
                return "thetitans:titanSkeletonLiving";
            }
            case 5: {
                return "thetitans:titanWitherSkeletonLiving";
            }
            case 6: {
                return "thetitans:titanZombieLiving";
            }
            case 7: {
                return "thetitans:titanCreeperLiving";
            }
            case 8: {
                return "thetitans:titanPigZombieLiving";
            }
            case 9: {
                return "thetitans:titanBlazeBreathe";
            }
            case 10: {
                return "thetitans:titanEnderColossusRoar";
            }
            case 11: {
                return "thetitans:titanGhastLiving";
            }
            case 12: {
                return "thetitans:witherzillaLiving";
            }
        }
        return "mob.wither/idle";
    }

    protected String getHurtSound() {
        return "";
    }

    protected String getDeathSound() {
        return "";
    }

    protected float getSoundVolume() {
        return 6.0f;
    }

    protected void damageEntity(DamageSource p_70665_1_, float p_70665_2_) {
    }

    public boolean isEntityInvulnerable() {
        return true;
    }

    protected void onDeathUpdate() {
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }
}

