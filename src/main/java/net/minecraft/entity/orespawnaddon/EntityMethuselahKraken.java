/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  danger.orespawn.AttackSquid
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.Ghost
 *  danger.orespawn.GhostSkelly
 *  danger.orespawn.Godzilla
 *  danger.orespawn.GodzillaHead
 *  danger.orespawn.Kraken
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.PitchBlack
 *  net.minecraft.block.Block
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 *  net.minecraft.world.storage.WorldInfo
 */
package net.minecraft.entity.orespawnaddon;

import cpw.mods.fml.relauncher.ReflectionHelper;
import danger.orespawn.AttackSquid;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.Ghost;
import danger.orespawn.GhostSkelly;
import danger.orespawn.Godzilla;
import danger.orespawn.GodzillaHead;
import danger.orespawn.Kraken;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.PitchBlack;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityIceBall;
import net.minecraft.entity.titan.EntityThunderboltShot;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class EntityMethuselahKraken
extends Kraken {
    private GenericTargetSorter TargetSorter = null;
    private ChunkCoordinates currentFlightTarget = null;
    private EntityLivingBase caught = null;
    private int newtarget = 0;
    private int release = 0;
    private int weather_set = 10;
    private int long_enough = 3600;
    private int call_reinforcements = 0;
    private boolean hit_by_player = false;
    private int straight_down = 1;
    private int stream_count_l = 0;
    private int stream_count_i = 0;
    private int ticker = 0;

    public EntityMethuselahKraken(World par1World) {
        super(par1World);
        if (OreSpawnMain.PlayNicely == 0) {
            this.setSize(8.0f, 30.0f);
        } else {
            this.setSize(2.6666667f, 10.0f);
        }
        this.getNavigator().setAvoidsWater(false);
        this.experienceValue = 25000;
        this.fireResistance = 120;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth() * 12.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)0.37f);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.Kraken_stats.attack * 15.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
    }

    public int getTotalArmorValue() {
        return 24;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.noClip = true;
        if (OreSpawnMain.PlayNicely == 0) {
            this.setSize(8.0f, 30.0f);
        } else {
            this.setSize(2.6666667f, 10.0f);
        }
    }

    public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName((String)par1, (World)par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving)var8).playLivingSound();
        }
        return var8;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.isDead) {
            return;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)(this.posY - 10.0), (int)this.posZ);
        } else {
            this.motionY = this.posY < (double)this.currentFlightTarget.posY ? (this.motionY *= 0.9) : (this.motionY *= 0.5);
        }
        if (this.weather_set > 0 && OreSpawnMain.PlayNicely == 0) {
            --this.weather_set;
            if (this.weather_set == 0 && !this.worldObj.isRemote) {
                WorldInfo worldinfo = this.worldObj.getWorldInfo();
                if (!this.worldObj.isRaining()) {
                    worldinfo.setRainTime(300);
                    worldinfo.setThunderTime(300);
                    worldinfo.setRaining(true);
                    worldinfo.setThundering(true);
                } else {
                    worldinfo.setRainTime(300);
                    worldinfo.setThunderTime(300);
                }
                this.weather_set = 100;
            }
        }
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("LongEnough", this.long_enough);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.long_enough = par1NBTTagCompound.getInteger("LongEnough");
    }

    protected String getLivingSound() {
        return "orespawn:kraken_living";
    }

    protected String getHurtSound() {
        return "orespawn:king_hit";
    }

    protected String getDeathSound() {
        return "orespawn:trex_death";
    }

    protected float getSoundVolume() {
        return 5.0f;
    }

    protected float getSoundPitch() {
        return 0.95f;
    }

    private ItemStack dropItemRand(Item index, int par1) {
        EntityItem var3 = null;
        ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(12) - (double)OreSpawnMain.OreSpawnRand.nextInt(12), this.posY + 2.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(12) - (double)OreSpawnMain.OreSpawnRand.nextInt(12), is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    protected void dropFewItems(boolean par1, int par2) {
        ItemStack is = null;
        this.dropItemRand(Item.getItemFromBlock((Block)TitanBlocks.void_block), 1);
        int var5 = 400 + this.worldObj.rand.nextInt(400);
        for (int var4 = 0; var4 < var5; ++var4) {
            this.dropItemRand(Items.dye, 1);
        }
        int var6 = 200 + this.worldObj.rand.nextInt(200);
        for (int var4 = 0; var4 < var5; ++var4) {
            this.dropItemRand(Items.gold_ingot, 1);
        }
        int var7 = 100 + this.worldObj.rand.nextInt(100);
        for (int var4 = 0; var4 < var5; ++var4) {
            this.dropItemRand(Items.golden_carrot, 1);
        }
        int var8 = 100 + this.worldObj.rand.nextInt(100);
        for (int var4 = 0; var4 < var5; ++var4) {
            this.dropItemRand(Items.golden_apple, 1);
        }
        int i = 25 + this.worldObj.rand.nextInt(25);
        block59: for (int var4 = 0; var4 < i; ++var4) {
            int var3 = this.worldObj.rand.nextInt(53);
            switch (var3) {
                case 0: {
                    is = this.dropItemRand(TitanItems.voidAxe, 1);
                    continue block59;
                }
                case 1: {
                    is = this.dropItemRand(TitanItems.harcadiumNugget, 1);
                    continue block59;
                }
                case 2: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)TitanBlocks.harcadium_block), 1);
                    continue block59;
                }
                case 3: {
                    is = this.dropItemRand(TitanItems.harcadiumSword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 4: {
                    is = this.dropItemRand(TitanItems.harcadiumSpade, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 5: {
                    is = this.dropItemRand(TitanItems.harcadiumPickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 6: {
                    is = this.dropItemRand(TitanItems.harcadiumAxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 7: {
                    is = this.dropItemRand(TitanItems.harcadiumHoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 8: {
                    is = this.dropItemRand(TitanItems.harcadiumHelmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 9: {
                    is = this.dropItemRand(TitanItems.harcadiumChestplate, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 10: {
                    is = this.dropItemRand(TitanItems.harcadiumLeggings, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 11: {
                    is = this.dropItemRand(TitanItems.harcadiumBoots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 12: {
                    is = this.dropItemRand(TitanItems.harcadiumBow, 1);
                    continue block59;
                }
                case 13: {
                    is = this.dropItemRand(TitanItems.diamondApple, 1);
                    continue block59;
                }
                case 14: {
                    is = this.dropItemRand(Items.diamond, 1);
                    continue block59;
                }
                case 15: {
                    is = this.dropItemRand(TitanItems.voidPickaxe, 1);
                    continue block59;
                }
                case 16: {
                    is = this.dropItemRand(TitanItems.steelSword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 17: {
                    is = this.dropItemRand(TitanItems.steelSpade, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 18: {
                    is = this.dropItemRand(TitanItems.steelPickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 19: {
                    is = this.dropItemRand(TitanItems.steelAxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 20: {
                    is = this.dropItemRand(TitanItems.steelHoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 21: {
                    is = this.dropItemRand(TitanItems.steelHelmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 22: {
                    is = this.dropItemRand(TitanItems.steelChestplate, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 23: {
                    is = this.dropItemRand(TitanItems.steelLeggings, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 24: {
                    is = this.dropItemRand(TitanItems.steelBoots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 25: {
                    is = this.dropItemRand(TitanItems.voidSpade, 1);
                    continue block59;
                }
                case 26: {
                    this.dropItemRand(Item.getItemFromBlock((Block)TitanBlocks.harcadium_ore_end_stone), 1);
                    continue block59;
                }
                case 27: {
                    is = this.dropItemRand(TitanItems.pleasantBladeSeed, 1);
                    continue block59;
                }
                case 28: {
                    is = this.dropItemRand(TitanItems.malgrumSeeds, 1);
                    continue block59;
                }
                case 29: {
                    is = this.dropItemRand(TitanItems.diamondCookie, 1);
                    continue block59;
                }
                case 30: {
                    is = this.dropItemRand(TitanItems.bronzeSword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 31: {
                    is = this.dropItemRand(TitanItems.bronzeSpade, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 32: {
                    is = this.dropItemRand(TitanItems.bronzePickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 33: {
                    is = this.dropItemRand(TitanItems.bronzeAxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 34: {
                    is = this.dropItemRand(TitanItems.bronzeHoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 35: {
                    is = this.dropItemRand(TitanItems.bronzeHelmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 36: {
                    is = this.dropItemRand(TitanItems.bronzeChestplate, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 37: {
                    is = this.dropItemRand(TitanItems.bronzeLeggings, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 38: {
                    is = this.dropItemRand(TitanItems.bronzeBoots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 39: {
                    this.dropItemRand(TitanItems.diamondPumpkinPie, 1);
                    continue block59;
                }
                case 40: {
                    this.dropItemRand(Item.getItemFromBlock((Block)TitanBlocks.harcadium_block), 1);
                    continue block59;
                }
                case 41: {
                    EntityItem var33 = null;
                    is = new ItemStack(TitanItems.diamondApple, 1, 1);
                    var33 = new EntityItem(this.worldObj, this.posX + (double)OreSpawnMain.OreSpawnRand.nextInt(3) - (double)OreSpawnMain.OreSpawnRand.nextInt(3), this.posY + 1.0, this.posZ + (double)OreSpawnMain.OreSpawnRand.nextInt(3) - (double)OreSpawnMain.OreSpawnRand.nextInt(3), is);
                    if (var33 == null) continue block59;
                    this.worldObj.spawnEntityInWorld((Entity)var33);
                    continue block59;
                }
                case 42: {
                    is = this.dropItemRand(OreSpawnMain.MyExperienceSword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 43: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceHelmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 44: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceBody, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 45: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceLegs, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 46: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceBoots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block59;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block59;
                }
                case 47: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystSword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 48: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystShovel, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 49: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystPickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 50: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystAxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 51: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystHoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block59;
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    continue block59;
                }
                case 52: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block)Blocks.diamond_block), 1);
                }
            }
        }
    }

    protected boolean canDespawn() {
        return false;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        boolean var4;
        float s;
        if (!(par1Entity == null || !(par1Entity instanceof EntityLivingBase) || !((s = par1Entity.height * par1Entity.width) > 30.0f) || MyUtils.isRoyalty((Entity)par1Entity) || par1Entity instanceof Godzilla || par1Entity instanceof GodzillaHead || par1Entity instanceof PitchBlack || par1Entity instanceof Kraken)) {
            EntityLivingBase e = (EntityLivingBase)par1Entity;
            e.setHealth(this.rand.nextInt(5) == 0 ? 0.0f : e.getHealth() / 2.0f);
            e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue() * 10.0f);
        }
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            EntityDragon dr = (EntityDragon)par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.setExplosionSource(null);
            var21.setExplosion();
            if (this.worldObj.rand.nextInt(6) == 1) {
                dr.attackEntityFromPart(dr.dragonPartHead, var21, (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
            } else {
                dr.attackEntityFromPart(dr.dragonPartBody, var21, (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
            }
        }
        if (var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue())) {
            double ks = 3.3;
            double inair = 0.25;
            float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            inair += (double)(this.worldObj.rand.nextFloat() * 0.25f);
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 1.5;
            }
            par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return var4;
    }

    private EntityLivingBase doJumpDamage(double X, double Y, double Z, double dist, double damage, int knock) {
        AxisAlignedBB bb = AxisAlignedBB.getBoundingBox((double)(X - dist), (double)(Y - 10.0), (double)(Z - dist), (double)(X + dist), (double)(Y + 10.0), (double)(Z + dist));
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort(var5, this.TargetSorter);
        Iterator var2 = var5.iterator();
        Entity var3 = null;
        EntityLivingBase var4 = null;
        while (var2.hasNext()) {
            var3 = (Entity)var2.next();
            var4 = (EntityLivingBase)var3;
            if (var4 == null || var4 == this || !var4.isEntityAlive() || MyUtils.isRoyalty((Entity)var4) || var4 instanceof Ghost || var4 instanceof GhostSkelly) continue;
            DamageSource var21 = null;
            var21 = DamageSource.setExplosionSource(null);
            var21.setExplosion();
            var4.attackEntityFrom(var21, (float)damage / 2.0f);
            var4.attackEntityFrom(DamageSource.fall, (float)damage / 2.0f);
            this.worldObj.playSoundAtEntity((Entity)var4, "random.explode", 1.0f, 0.5f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.25f);
            if (knock == 0) continue;
            double ks = 2.75;
            double inair = 0.65;
            float f3 = (float)Math.atan2(var4.posZ - this.posZ, var4.posX - this.posX);
            var4.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return null;
    }

    protected void updateAITasks() {
        this.worldObj.theProfiler.startSection("sensing");
        this.getEntitySenses().clearSensingCache();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("targetSelector");
        this.targetTasks.onUpdateTasks();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("goalSelector");
        this.tasks.onUpdateTasks();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("navigation");
        this.getNavigator().onUpdateNavigation();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("mob tick");
        this.updateAITick();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("controls");
        this.worldObj.theProfiler.startSection("move");
        this.getMoveHelper().onUpdateMoveHelper();
        this.worldObj.theProfiler.endStartSection("look");
        this.getLookHelper().onUpdateLook();
        this.worldObj.theProfiler.endStartSection("jump");
        this.getJumpHelper().doJump();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.endSection();
        Field hurt_timer = ReflectionHelper.findField(Kraken.class, (String[])new String[]{"hurt_timer"});
        try {
            hurt_timer.setInt((Object)this, hurt_timer.getInt((Object)this) - 1);
        }
        catch (Exception e) {
            this.setDead();
        }
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        if (this.isDead) {
            return;
        }
        if (this.ticksExisted % 50 == 0) {
            this.stream_count_l = 64;
        }
        if (this.ticksExisted % 80 == 0) {
            this.stream_count_i = 8;
        }
        if (this.long_enough > 0) {
            --this.long_enough;
        }
        EntityLivingBase e = null;
        this.entityToAttack = null;
        if (this.worldObj.rand.nextInt(2) == 0) {
            e = this.getAttackTarget();
            if (e != null && !e.isEntityAlive()) {
                this.setAttackTarget(null);
                e = null;
            }
            if (this.worldObj.rand.nextInt(100) == 0) {
                this.setAttackTarget(null);
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null && !this.worldObj.isRemote) {
                this.faceEntity((Entity)e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity((Entity)e) < (double)(600.0f + e.width / 2.0f * (e.width / 2.0f))) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(2) == 0) {
                        this.attackEntityAsMob((Entity)e);
                        if (this.worldObj.rand.nextInt(2) == 1) {
                            this.doJumpDamage(this.posX, this.posY, this.posZ, 15.0, OreSpawnMain.Kraken_stats.attack, 0);
                        }
                    }
                } else {
                    double rdd;
                    double pi;
                    double rhdir;
                    if (this.worldObj.rand.nextInt(65) == 1) {
                        float var2 = 100.0f;
                        e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
                        e.setFire(5);
                        this.worldObj.playSoundAtEntity((Entity)e, "random.explode", 0.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
                        if (!this.worldObj.isRemote) {
                            net.minecraft.theTitans.util.FastExplosion.createExplosion(this.worldObj, (Entity)this, e.posX, e.posY, e.posZ, 3.0f, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                        }
                        this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, e.posX, e.posY + 1.0, e.posZ));
                        this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, this.posX, this.posY - 30.0, this.posZ));
                    }
                    if (this.stream_count_i > 0) {
                        double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                        rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                        pi = 3.1415926545;
                        rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                        if (rdd > pi) {
                            rdd -= pi * 2.0;
                        }
                        if ((rdd = Math.abs(rdd)) < 0.5) {
                            this.firecanoni(e);
                        }
                    }
                    if (this.stream_count_l > 0) {
                        double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                        rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                        pi = 3.1415926545;
                        rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                        if (rdd > pi) {
                            rdd -= pi * 2.0;
                        }
                        if ((rdd = Math.abs(rdd)) < 0.5) {
                            this.firecanonl(e);
                        }
                    }
                }
                if (this.worldObj.rand.nextInt(55) == 1 || this.worldObj.rand.nextInt(20) == 1) {
                    EntityCreature newent = (EntityCreature)EntityMethuselahKraken.spawnCreature(this.worldObj, "The Kraken", (this.posX + e.posX) / 2.0 + (double)this.worldObj.rand.nextInt(5) - (double)this.worldObj.rand.nextInt(5), (this.posY + e.posY) / 2.0 + 1.01, (this.posZ + e.posZ) / 2.0 + (double)this.worldObj.rand.nextInt(5) - (double)this.worldObj.rand.nextInt(5));
                    newent.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2000.0);
                    newent.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(80.0);
                    newent.heal(2000.0f);
                    newent.setAttackTarget(e);
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.rand.nextInt(35) == 1) {
            this.heal(5.0f);
        }
        this.dataWatcher.updateObject(21, (Object)OreSpawnMain.PlayNicely);
        if (this.worldObj.rand.nextInt(100) == 1 && OreSpawnMain.PlayNicely == 0) {
            this.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.worldObj, this.posX, this.posY - 30.0, this.posZ, 0.0f, 0.75f, 1.0f));
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        if (this.newtarget != 0 || this.rand.nextInt(250) == 1 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 9.1f) {
            int ground_dist = 0;
            this.newtarget = 0;
            for (ground_dist = 0; ground_dist < 31; ++ground_dist) {
                Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY - ground_dist, (int)this.posZ);
                if (bid == Blocks.air) continue;
                this.straight_down = 0;
                break;
            }
            ground_dist = 30 - ground_dist;
            Block bid = Blocks.stone;
            while (bid != Blocks.air && keep_trying != 0) {
                zdir = this.worldObj.rand.nextInt(6) + 12;
                xdir = this.worldObj.rand.nextInt(6) + 12;
                if (this.worldObj.rand.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                if (this.straight_down != 0) {
                    xdir = 0;
                    zdir = 0;
                }
                this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + ground_dist + this.rand.nextInt(4) - 3, (int)this.posZ + zdir);
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
                if (bid == Blocks.air && !this.canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
                    bid = Blocks.stone;
                }
                --keep_trying;
            }
            if (this.long_enough <= 0 || this.posY < 200.0 && this.getHealth() < (float)(this.mygetMaxHealth() / 4)) {
                this.currentFlightTarget.set(this.currentFlightTarget.posX, this.currentFlightTarget.posY + 10, this.currentFlightTarget.posZ);
                if (this.hit_by_player && this.call_reinforcements == 0 && this.getHealth() < (float)(this.mygetMaxHealth() / 8) && this.posY > 130.0) {
                    this.call_reinforcements = 1;
                    for (int i = 0; i < 50; ++i) {
                        EntityCreature newent = (EntityCreature)EntityMethuselahKraken.spawnCreature(this.worldObj, "The Kraken", this.posX + (double)this.worldObj.rand.nextInt(100) - (double)this.worldObj.rand.nextInt(100), 170.0, this.posZ + (double)this.worldObj.rand.nextInt(100) - (double)this.worldObj.rand.nextInt(100));
                    }
                }
            }
        } else if (this.caught == null && this.worldObj.rand.nextInt(4) == 1 && OreSpawnMain.PlayNicely == 0) {
            EntityPlayer target = null;
            target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(80.0, 80.0, 80.0), (Entity)this);
            if (target != null) {
                if (!target.capabilities.isCreativeMode) {
                    if (this.getEntitySenses().canSee((Entity)target)) {
                        this.currentFlightTarget.set((int)target.posX, (int)target.posY + 30, (int)target.posZ);
                        this.attackWithSomething((EntityLivingBase)target);
                    }
                } else {
                    target = null;
                }
            }
            if (target == null && this.worldObj.rand.nextInt(2) == 0 && (e = this.getAttackTarget()) != null) {
                this.currentFlightTarget.set((int)e.posX, (int)e.posY + 30, (int)e.posZ);
                this.attackWithSomething(e);
            }
        }
        if (this.caught != null) {
            if (!this.caught.isDead) {
                this.currentFlightTarget.set((int)this.posX, 200, (int)this.posZ);
                if (this.posY > 190.0) {
                    this.release = 1;
                }
                this.caught.motionX = 0.0;
                this.caught.motionZ = 0.0;
                this.caught.motionY = 0.0;
                this.caught.setPosition(this.posX, this.posY - 30.0, this.posZ);
                this.caught.renderYawOffset = this.caught.rotationYaw = this.rotationYaw;
                this.attackEntityAsMob((Entity)this.caught);
                this.doJumpDamage(this.posX, this.posY, this.posZ, 15.0, OreSpawnMain.Kraken_stats.attack, 0);
                if (this.release != 0 || this.worldObj.rand.nextInt(250) == 1 || this.getAttackTarget() != null && this.caught != this.getAttackTarget()) {
                    this.caught = null;
                    this.newtarget = 1;
                    this.release = 0;
                }
            } else {
                this.caught = null;
                this.newtarget = 1;
                this.release = 0;
            }
        }
        double var1 = (double)this.currentFlightTarget.posX - this.posX;
        double var3 = (double)this.currentFlightTarget.posY - this.posY;
        double var5 = (double)this.currentFlightTarget.posZ - this.posZ;
        this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.5;
        this.motionY += (Math.signum(var3) * 0.5 - this.motionY) * 0.5;
        this.motionZ += (Math.signum(var5) * 0.5 - this.motionZ) * 0.5;
        float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / Math.PI) - 90.0f;
        float var8 = MathHelper.wrapAngleTo180_float((float)(var7 - this.rotationYaw));
        this.moveForward = 0.4f;
        if (Math.abs(this.motionX) + Math.abs(this.motionZ) < 0.15) {
            var8 = 0.0f;
        }
        this.renderYawOffset = this.rotationYaw += var8 / 5.0f;
        double obstruction_factor = 0.0;
        double dx = 0.0;
        double dz = 0.0;
        int dist = 10;
        for (int k = -40; k < 36; k += 2) {
            for (int i = 1; i < dist; i += 2) {
                dx = (double)i * Math.cos(Math.toRadians(this.rotationYaw + 90.0f));
                Block bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY + k, (int)(this.posZ + (dz = (double)i * Math.sin(Math.toRadians(this.rotationYaw + 90.0f)))));
                if (bid == Blocks.air) continue;
                obstruction_factor += 0.1;
            }
        }
        this.motionY += obstruction_factor * 0.08;
        this.posY += obstruction_factor * 0.08;
        if (this.posY > 256.0 && !this.isNoDespawnRequired()) {
            this.setDead();
        }
    }

    public boolean isNoDespawnRequired() {
        return true;
    }

    private void attackWithSomething(EntityLivingBase par1) {
        if (this.caught != null) {
            return;
        }
        double dist = (this.posX - par1.posX) * (this.posX - par1.posX);
        dist += (this.posZ - par1.posZ) * (this.posZ - par1.posZ);
        if ((dist += (this.posY - par1.posY - 30.0) * (this.posY - par1.posY - 30.0)) < 60.0) {
            this.caught = par1;
            this.release = 0;
            this.setAttacking(1);
        }
    }

    private void firecanonl(EntityLivingBase e) {
        double yoff = -12.0;
        double xzoff = 2.0;
        double var3 = 0.0;
        double var5 = 0.0;
        double var7 = 0.0;
        float var9 = 0.0f;
        double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.stream_count_l > 0) {
            this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            for (int i = 0; i < 10; ++i) {
                float r = 8.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                EntityThunderboltShot lb = new EntityThunderboltShot(this.worldObj, cx, this.posY + yoff, cz);
                lb.setLocationAndAngles(cx + (double)r, this.posY + yoff, cz + (double)r, 0.0f, 0.0f);
                var3 = e.posX - lb.posX;
                var5 = e.posY + 0.25 - lb.posY;
                var7 = e.posZ - lb.posZ;
                var9 = MathHelper.sqrt_double((double)(var3 * var3 + var7 * var7)) * 0.2f;
                lb.setThrowableHeading(var3, var5 + (double)var9, var7, 1.25f, 9.0f);
                lb.motionX *= 3.0;
                lb.motionY *= 3.0;
                lb.motionZ *= 3.0;
                this.worldObj.spawnEntityInWorld((Entity)lb);
            }
            --this.stream_count_l;
        }
    }

    private void firecanoni(EntityLivingBase e) {
        double yoff = -12.0;
        double xzoff = 2.0;
        double var3 = 0.0;
        double var5 = 0.0;
        double var7 = 0.0;
        float var9 = 0.0f;
        double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.stream_count_i > 0) {
            this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            for (int i = 0; i < 3; ++i) {
                float r = 8.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                EntityIceBall lb = new EntityIceBall(this.worldObj, cx, this.posY + yoff, cz);
                lb.setLocationAndAngles(cx + (double)r, this.posY + yoff, cz + (double)r, 0.0f, 0.0f);
                var3 = e.posX - lb.posX;
                var5 = e.posY + 0.25 - lb.posY;
                var7 = e.posZ - lb.posZ;
                var9 = MathHelper.sqrt_double((double)(var3 * var3 + var7 * var7)) * 0.2f;
                lb.setThrowableHeading(var3, var5 + (double)var9, var7, 1.25f, 9.0f);
                lb.motionX *= 3.0;
                lb.motionY *= 3.0;
                lb.motionZ *= 3.0;
                this.worldObj.spawnEntityInWorld((Entity)lb);
            }
            --this.stream_count_i;
        }
    }

    private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (MyUtils.isIgnoreable((EntityLivingBase)par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses().canSee((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
            return !p.capabilities.isFlying;
        }
        if (par1EntityLiving instanceof EntitySquid) {
            return false;
        }
        if (par1EntityLiving instanceof AttackSquid) {
            return false;
        }
        return !(par1EntityLiving instanceof Kraken);
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(80.0, 160.0, 80.0));
        Collections.sort(var5, this.TargetSorter);
        Iterator var2 = var5.iterator();
        Entity var3 = null;
        EntityLivingBase var4 = null;
        while (var2.hasNext()) {
            var3 = (Entity)var2.next();
            var4 = (EntityLivingBase)var3;
            if (!this.isSuitableTarget(var4, false)) continue;
            this.setAttackTarget(var4);
            return var4;
        }
        return null;
    }

    public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt) {
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if (!par1DamageSource.getDamageType().equals("cactus") && !par1DamageSource.getDamageType().equals("drown") && super.attackEntityFrom(par1DamageSource, par2)) {
            Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLivingBase) {
                this.setAttackTarget((EntityLivingBase)e);
                this.setTarget(e);
            }
            return true;
        }
        return false;
    }
}

