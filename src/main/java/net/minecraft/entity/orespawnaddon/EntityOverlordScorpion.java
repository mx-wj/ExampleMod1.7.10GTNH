/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  danger.orespawn.EmperorScorpion
 *  danger.orespawn.EnderKnight
 *  danger.orespawn.EnderReaper
 *  danger.orespawn.GenericTargetSorter
 *  danger.orespawn.Godzilla
 *  danger.orespawn.GodzillaHead
 *  danger.orespawn.Kraken
 *  danger.orespawn.MyUtils
 *  danger.orespawn.OreSpawnMain
 *  danger.orespawn.PitchBlack
 *  danger.orespawn.PurplePower
 *  danger.orespawn.Scorpion
 *  net.minecraft.block.Block
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package net.minecraft.entity.orespawnaddon;

import cpw.mods.fml.relauncher.ReflectionHelper;
import danger.orespawn.EmperorScorpion;
import danger.orespawn.EnderKnight;
import danger.orespawn.EnderReaper;
import danger.orespawn.GenericTargetSorter;
import danger.orespawn.Godzilla;
import danger.orespawn.GodzillaHead;
import danger.orespawn.Kraken;
import danger.orespawn.MyUtils;
import danger.orespawn.OreSpawnMain;
import danger.orespawn.PitchBlack;
import danger.orespawn.PurplePower;
import danger.orespawn.Scorpion;
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
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityIceBall;
import net.minecraft.entity.titan.EntityThunderboltShot;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityOverlordScorpion
extends EmperorScorpion {
    private GenericTargetSorter TargetSorter = null;
    private int stream_count = 0;
    private int stream_count_l = 0;
    private int stream_count_i = 0;

    public EntityOverlordScorpion(World par1World) {
        super(par1World);
        this.setSize(7.0f, 3.0f);
        this.getNavigator().setAvoidsWater(true);
        this.experienceValue = 14000;
        this.fireResistance = 100;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth() * 20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)OreSpawnMain.EmperorScorpion_stats.attack * 10.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
    }

    protected boolean canDespawn() {
        return false;
    }

    public int getTotalArmorValue() {
        return 24;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.setSize(7.0f, 3.0f);
    }

    protected String getHurtSound() {
        return "orespawn:king_hit";
    }

    protected String getDeathSound() {
        return "orespawn:trex_death";
    }

    protected float getSoundVolume() {
        return 3.0f;
    }

    protected float getSoundPitch() {
        return 0.999f;
    }

    protected Item getDropItem() {
        return Items.beef;
    }

    private ItemStack dropItemRand(Item index, int par1) {
        EntityItem var3 = null;
        ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.worldObj, this.posX + (double)this.rand.nextInt(5) - (double)this.rand.nextInt(5), this.posY + 1.0, this.posZ + (double)this.rand.nextInt(5) - (double)this.rand.nextInt(5), is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var4;
        this.dropItemRand(Item.getItemFromBlock((Block)TitanBlocks.void_block), 1);
        int i = 64 + this.worldObj.rand.nextInt(32);
        for (var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Item.getItemFromBlock((Block)Blocks.obsidian), 1);
        }
        i = 24 + this.worldObj.rand.nextInt(24);
        for (var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.beef, 1);
        }
        i = 8 + this.worldObj.rand.nextInt(8);
        for (var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.diamond, 1);
        }
        i = 5 + this.worldObj.rand.nextInt(5);
        block18: for (var4 = 0; var4 < i; ++var4) {
            int var3 = this.worldObj.rand.nextInt(20);
            switch (var3) {
                case 0: {
                    ItemStack is = this.dropItemRand(TitanItems.voidSword, 1);
                    continue block18;
                }
                case 1: {
                    ItemStack is = this.dropItemRand(TitanItems.harcadium, 1);
                    continue block18;
                }
                case 2: {
                    ItemStack is = this.dropItemRand(Item.getItemFromBlock((Block)TitanBlocks.harcadium_block), 1);
                    continue block18;
                }
                case 3: {
                    ItemStack is = this.dropItemRand(TitanItems.harcadiumSword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 10 + this.worldObj.rand.nextInt(10));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block18;
                    is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    continue block18;
                }
                case 4: {
                    ItemStack is = this.dropItemRand(TitanItems.harcadiumSpade, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 12 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block18;
                    is.addEnchantment(Enchantment.efficiency, 12 + this.worldObj.rand.nextInt(5));
                    continue block18;
                }
                case 5: {
                    ItemStack is = this.dropItemRand(TitanItems.harcadiumPickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 12 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 12 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block18;
                    is.addEnchantment(Enchantment.fortune, 12 + this.worldObj.rand.nextInt(5));
                    continue block18;
                }
                case 6: {
                    ItemStack is = this.dropItemRand(TitanItems.harcadiumAxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 12 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block18;
                    is.addEnchantment(Enchantment.efficiency, 12 + this.worldObj.rand.nextInt(5));
                    continue block18;
                }
                case 7: {
                    ItemStack is = this.dropItemRand(TitanItems.harcadiumHoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 12 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) != 1) continue block18;
                    is.addEnchantment(Enchantment.efficiency, 12 + this.worldObj.rand.nextInt(5));
                    continue block18;
                }
                case 8: {
                    ItemStack is = this.dropItemRand(TitanItems.harcadiumHelmet, 1);
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
                    if (this.worldObj.rand.nextInt(6) != 1) continue block18;
                    is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                    continue block18;
                }
                case 9: {
                    ItemStack is = this.dropItemRand(TitanItems.harcadiumChestplate, 1);
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
                    if (this.worldObj.rand.nextInt(2) != 1) continue block18;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block18;
                }
                case 10: {
                    ItemStack is = this.dropItemRand(TitanItems.harcadiumLeggings, 1);
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
                    if (this.worldObj.rand.nextInt(2) != 1) continue block18;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block18;
                }
                case 11: {
                    ItemStack is = this.dropItemRand(TitanItems.harcadiumBoots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) != 1) continue block18;
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    continue block18;
                }
                case 12: {
                    ItemStack itemStack = this.dropItemRand(TitanItems.harcadiumBow, 1);
                }
            }
        }
    }

    private void firecanon(EntityLivingBase e) {
        double yoff = 3.0;
        double xzoff = 9.0;
        EntityTitanFireball bf = null;
        double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.stream_count > 0) {
            bf = new EntityTitanFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx, e.posY + 0.5, e.posZ - cz);
            bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
            bf.setPosition(cx, this.posY + yoff, cz);
            this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)bf);
            for (int i = 0; i < 2; ++i) {
                float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                bf = new EntityTitanFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx + (double)r1, e.posY + (double)(e.height / 2.0f) - (this.posY + yoff) + (double)r2, e.posZ - cz + (double)r3);
                bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
                bf.setPosition(cx, this.posY + yoff, cz);
                this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity)bf);
            }
            --this.stream_count;
        }
    }

    private void firecanonl(EntityLivingBase e) {
        double yoff = 3.0;
        double xzoff = 9.0;
        double var3 = 0.0;
        double var5 = 0.0;
        double var7 = 0.0;
        float var9 = 0.0f;
        double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.stream_count_l > 0) {
            this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            for (int i = 0; i < 2; ++i) {
                float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                EntityThunderboltShot lb = new EntityThunderboltShot(this.worldObj, cx, this.posY + yoff, cz);
                lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0f, 0.0f);
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
        double yoff = 3.0;
        double xzoff = 9.0;
        double var3 = 0.0;
        double var5 = 0.0;
        double var7 = 0.0;
        float var9 = 0.0f;
        double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.stream_count_i > 0) {
            this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            for (int i = 0; i < 2; ++i) {
                float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                EntityIceBall lb = new EntityIceBall(this.worldObj, cx, this.posY + yoff, cz);
                lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0f, 0.0f);
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

    public boolean interact(EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        double ks = 3.2;
        double inair = 0.3;
        int var2 = 6;
        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
        if (var4 && par1Entity != null && par1Entity instanceof EntityLivingBase) {
            float s = par1Entity.height * par1Entity.width;
            if (MyUtils.isRoyalty((Entity)par1Entity)) {
                try {
                    ReflectionHelper.findField(par1Entity.getClass(), (String[])new String[]{"hurt_timer"}).setInt((Object)this, 0);
                    par1Entity.hurtResistantTime = 0;
                    ((EntityLivingBase)par1Entity).attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this).setDamageBypassesArmor(), (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue() * 10.0f);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            if (!(!(s > 30.0f) || MyUtils.isRoyalty((Entity)par1Entity) || par1Entity instanceof Godzilla || par1Entity instanceof GodzillaHead || par1Entity instanceof PitchBlack || par1Entity instanceof Kraken)) {
                EntityLivingBase e = (EntityLivingBase)par1Entity;
                e.setHealth(e.getHealth() / 2.0f);
                e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue() * 10.0f);
            }
            this.getLookHelper().setLookPositionWithEntity(par1Entity, 180.0f, 40.0f);
            if (par1Entity.getClass() == (Class)EntityList.stringToClassMapping.get("Emperor Scorpion")) {
                ((EntityLiving)par1Entity).setAttackTarget(null);
                this.setAttackTarget(null);
            }
            if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
                var2 = 12;
                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                    var2 = 16;
                } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                    var2 = 20;
                }
            }
            if (this.worldObj.rand.nextInt(2) == 0) {
                ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 20, 0));
                ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, var2 * 20, 0));
                ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, var2 * 20, 0));
                ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.wither.id, var2 * 20, 0));
            }
            float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return var4;
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
        Field hurt_timer = ReflectionHelper.findField(EmperorScorpion.class, (String[])new String[]{"hurt_timer"});
        try {
            hurt_timer.setInt((Object)this, hurt_timer.getInt((Object)this) - 1);
        }
        catch (Exception e) {
            this.setDead();
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(PurplePower.class, this.boundingBox.expand(20.0, 20.0, 20.0));
        Collections.sort(var5, this.TargetSorter);
        Iterator var2 = var5.iterator();
        Entity var3 = null;
        PurplePower var4 = null;
        while (var2.hasNext()) {
            var3 = (Entity)var2.next();
            var4 = (PurplePower)var3;
            if (!var4.isEntityAlive()) continue;
            double d1 = var3.posX - this.posX;
            double d2 = var3.posY - this.posY;
            double d3 = var3.posZ - this.posZ;
            double f = d1 * d1 + d2 * d2 + d3 * d3;
            f = Math.sqrt(f);
            if ((f = 20.0 - f) > 20.0) {
                f = 20.0;
            }
            if (f < 0.0) {
                f = 0.0;
            }
            double d = (float)Math.atan2(var3.posX - this.posX, var3.posZ - this.posZ);
            var3.motionX += f * Math.sin(d);
            var3.motionZ += f * Math.cos(d);
            var4.attackEntityFrom(DamageSource.generic, 10.0f);
            var4.hurtResistantTime = 0;
            this.setHealth(this.getHealth() + 10.0f);
            var4.playSound("orespawn:trex_death", 0.25f, 1.5f);
        }
        EntityLivingBase e = null;
        this.entityToAttack = null;
        if (this.isDead) {
            return;
        }
        this.stepHeight = 2.0f;
        if (this.ticksExisted % 80 == 0) {
            this.stream_count = 10;
        }
        if (this.ticksExisted % 90 == 0) {
            this.stream_count_l = 5;
        }
        if (this.ticksExisted % 70 == 0) {
            this.stream_count_i = 8;
        }
        if (this.worldObj.rand.nextInt(4) == 0) {
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
            if (e != null) {
                this.faceEntity((Entity)e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity((Entity)e) < (double)((14.0f + e.width / 2.0f) * (14.0f + e.width / 2.0f))) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(2) == 0) {
                        this.attackEntityAsMob((Entity)e);
                        if (!this.worldObj.isRemote) {
                            if (this.worldObj.rand.nextInt(2) == 0) {
                                this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_attack", 1.4f, 1.0f);
                            } else {
                                this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_living", 1.0f, 1.0f);
                            }
                        }
                    }
                } else {
                    this.getMoveHelper().setMoveTo(e.posX, e.posY, e.posZ, 2.4);
                    if (this.getDistanceSqToEntity((Entity)e) > 512.0 && !this.worldObj.isRemote) {
                        double rdd;
                        double pi;
                        double rhdir;
                        double rr;
                        if (this.stream_count > 0) {
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                            pi = 3.1415926545;
                            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            if ((rdd = Math.abs(rdd)) < 0.5) {
                                this.firecanon(e);
                            }
                        }
                        if (this.stream_count_i > 0) {
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
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
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
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
                }
                if (this.worldObj.rand.nextInt(20) == 1) {
                    EntityCreature newent = (EntityCreature)EntityOverlordScorpion.spawnCreature(this.worldObj, "Emperor Scorpion", (this.posX + e.posX) / 2.0 + (double)this.worldObj.rand.nextInt(5) - (double)this.worldObj.rand.nextInt(5), (this.posY + e.posY) / 2.0 + 1.01, (this.posZ + e.posZ) / 2.0 + (double)this.worldObj.rand.nextInt(5) - (double)this.worldObj.rand.nextInt(5));
                    newent.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(700.0);
                    newent.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(70.0);
                    newent.heal(700.0f);
                    newent.setAttackTarget(e);
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.rand.nextInt(50) == 1) {
            this.heal(2.0f);
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
        if (!this.getEntitySenses().canSee((Entity)par1EntityLiving)) {
            return false;
        }
        if (MyUtils.isIgnoreable((EntityLivingBase)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityEnderman) {
            return false;
        }
        if (par1EntityLiving instanceof EnderKnight) {
            return false;
        }
        if (par1EntityLiving instanceof EnderReaper) {
            return false;
        }
        if (par1EntityLiving instanceof Scorpion) {
            return false;
        }
        if (par1EntityLiving instanceof EmperorScorpion) {
            return false;
        }
        if (par1EntityLiving instanceof PurplePower) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
        }
        return true;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(80.0, 80.0, 80.0));
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

