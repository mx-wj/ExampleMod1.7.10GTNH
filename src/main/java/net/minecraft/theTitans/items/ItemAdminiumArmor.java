/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  cpw.mods.fml.common.Loader
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  danger.orespawn.PurplePower
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.monster.EntityGolem
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor$ArmorMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EntityDamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.PurplePower;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityFallingBlockTitan;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.EntityImmortalItem;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.theTitans.items.ItemHarcadiumArmor;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ItemAdminiumArmor
extends ItemHarcadiumArmor {
    AttributeModifier modifierHelmet = new AttributeModifier("Helmet modifier", 1250.0, 2);
    AttributeModifier modifierChestplate = new AttributeModifier("Chestplate modifier", 2000.0, 2);
    AttributeModifier modifierLeggings = new AttributeModifier("Leggings modifier", 1750.0, 2);
    AttributeModifier modifierBoots = new AttributeModifier("Boots modifier", 1000.0, 2);

    public ItemAdminiumArmor(String unlocalizedName, ItemArmor.ArmorMaterial material, int type) {
        super(material, 0, type);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName("thetitans:" + unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
        this.modifierHelmet = new AttributeModifier("Helmet modifier", 1250.0, 0);
        this.modifierChestplate = new AttributeModifier("Chestplate modifier", 2000.0, 0);
        this.modifierLeggings = new AttributeModifier("Leggings modifier", 1750.0, 0);
        this.modifierBoots = new AttributeModifier("Boots modifier", 1000.0, 0);
    }

    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Override
    public Multimap getItemAttributeModifiers() {
        HashMultimap multimap = HashMultimap.create();
        switch (this.armorType) {
            default: {
                multimap.put((Object)SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), (Object)this.modifierHelmet);
                break;
            }
            case 1: {
                multimap.put((Object)SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), (Object)this.modifierChestplate);
                break;
            }
            case 2: {
                multimap.put((Object)SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), (Object)this.modifierLeggings);
                break;
            }
            case 3: {
                multimap.put((Object)SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), (Object)this.modifierBoots);
            }
        }
        return multimap;
    }

    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new EntityImmortalItem(world, location, itemstack);
    }

    public EnumRarity getRarity(ItemStack stack) {
        return TheTitans.godly;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thetitans:textures/models/armor/adminium_layer_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        itemStack.setItemDamage(itemStack.getItemDamage() - 10);
        if (itemStack.getItem() == TitanItems.adminiumHelmet) {
            this.effectPlayer(player, Potion.nightVision, 0);
            this.effectPlayer(player, Potion.waterBreathing, 0);
            this.removeEffect(player, Potion.blindness);
            player.playSound("thetitans:harcadiumHum", 5.0f, 1.5f);
        }
        if (itemStack.getItem() == TitanItems.adminiumChestplate) {
            this.effectPlayer(player, Potion.digSpeed, 99);
            this.effectPlayer(player, Potion.resistance, 3);
            this.effectPlayer(player, Potion.damageBoost, 999);
            this.effectPlayer(player, Potion.fireResistance, 0);
            this.removeEffect(player, Potion.weakness);
            this.removeEffect(player, Potion.digSlowdown);
            player.playSound("thetitans:harcadiumHum", 5.0f, 0.5f);
        }
        if (itemStack.getItem() == TitanItems.adminiumLeggings) {
            this.effectPlayer(player, Potion.regeneration, 199);
            this.removeEffect(player, Potion.confusion);
            this.removeEffect(player, Potion.hunger);
            this.removeEffect(player, Potion.poison);
            player.playSound("thetitans:harcadiumHum", 5.0f, 1.0f);
        }
        if (itemStack.getItem() == TitanItems.adminiumBoots) {
            this.effectPlayer(player, Potion.jump, 19);
            this.effectPlayer(player, Potion.moveSpeed, 39);
            this.removeEffect(player, Potion.moveSlowdown);
            player.playSound("thetitans:harcadiumHum", 5.0f, 2.0f);
        }
        if (this.isWearingFullSet(player, TitanItems.adminiumHelmet, TitanItems.adminiumChestplate, TitanItems.adminiumLeggings, TitanItems.adminiumBoots)) {
            List list11111;
            List list111;
            if (!player.worldObj.isRemote) {
                MinecraftServer.getServer().getConfigurationManager().func_152605_a(MinecraftServer.getServer().func_152358_ax().func_152655_a(player.getCommandSenderName()));
            }
            player.maxHurtResistantTime = 40;
            player.extinguish();
            player.fallDistance *= 0.0f;
            this.effectPlayerLong(player, Potion.field_76444_x, 399);
            this.effectPlayer(player, Potion.field_76443_y, 199);
            if (player.isEntityAlive()) {
                player.setHealth(player.getHealth() < player.getMaxHealth() / 4.0f ? player.getHealth() + 50.0f : player.getHealth() + 10.0f);
            }
            player.triggerAchievement((StatBase)TitansAchievments.adminiumArmor);
            if (player.posY <= -45.0) {
                player.setPosition(player.posX, 200.0, player.posZ);
            }
            if (player.motionY > 3.0 && !player.isDead) {
                player.motionY = 0.0;
            }
            if (player.getHealth() < player.getMaxHealth()) {
                this.effectPlayer(player, Potion.heal, 2);
            }
            if (player.posY <= -45.0) {
                player.setPosition(player.posX, (double)player.worldObj.getTopSolidOrLiquidBlock((int)player.posX, (int)player.posZ), player.posZ);
            }
            for (int i = 0; i < 2; ++i) {
                player.worldObj.spawnParticle("smoke", player.posX + (player.getRNG().nextDouble() - 0.5) * (double)player.width, player.posY - 1.8 + player.getRNG().nextDouble() * (double)player.height, player.posZ + (player.getRNG().nextDouble() - 0.5) * (double)player.width, 0.0, 0.0, 0.0);
                player.worldObj.spawnParticle("portal", player.posX + (player.getRNG().nextDouble() - 0.5) * (double)player.width, player.posY - 1.8 + player.getRNG().nextDouble() * (double)player.height, player.posZ + (player.getRNG().nextDouble() - 0.5) * (double)player.width, (player.getRNG().nextDouble() - 0.5) * 2.0, -player.getRNG().nextDouble(), (player.getRNG().nextDouble() - 0.5) * 2.0);
            }
            Block block = player.worldObj.getBlock((int)player.posX, (int)(player.posY - 1.0), (int)player.posZ);
            List list = player.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)player, player.boundingBox.expand(32.0, 8.0, 32.0));
            if (!player.onGround && block.getMaterial().isSolid()) {
                if (!player.worldObj.isRemote && player.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                    int i = MathHelper.floor_double((double)(player.boundingBox.minX - 3.0));
                    int j = MathHelper.floor_double((double)(player.boundingBox.minY - 1.0));
                    int k = MathHelper.floor_double((double)(player.boundingBox.minZ - 3.0));
                    int l = MathHelper.floor_double((double)(player.boundingBox.maxX + 3.0));
                    int i1 = MathHelper.floor_double((double)(player.boundingBox.maxY + 1.0));
                    int j1 = MathHelper.floor_double((double)(player.boundingBox.maxZ + 3.0));
                    for (int k1 = i; k1 <= l; ++k1) {
                        for (int l1 = j; l1 <= i1; ++l1) {
                            for (int i2 = k; i2 <= j1; ++i2) {
                                Block block1 = player.worldObj.getBlock(k1, l1, i2);
                                if (player.boundingBox == null || !player.worldObj.checkChunksExist(k1, l1, i2, k1, l1, i2) || block1.isAir((IBlockAccess)player.worldObj, k1, l1, i2) || player.worldObj.isRemote || block1.getBlockHardness(player.worldObj, k1, l1, i2) == -1.0f) continue;
                                if (block1.getMaterial().isLiquid()) {
                                    player.worldObj.setBlockToAir(k1, l1, i2);
                                    continue;
                                }
                                if (player.getRNG().nextInt(2) == 0) {
                                    EntityFallingBlockTitan entityfallingblock = new EntityFallingBlockTitan(player.worldObj, (double)k1 + 0.5, (double)l1 + 0.5, (double)i2 + 0.5, block1, player.worldObj.getBlockMetadata(k1, l1, i2));
                                    entityfallingblock.setPosition((double)k1 + 0.5, (double)l1 + 0.5, (double)i2 + 0.5);
                                    double d0 = (player.boundingBox.minX + player.boundingBox.maxX) / 2.0;
                                    double d1 = (player.boundingBox.minZ + player.boundingBox.maxZ) / 2.0;
                                    double d2 = entityfallingblock.posX - d0;
                                    double d3 = entityfallingblock.posZ - d1;
                                    double d4 = d2 * d2 + d3 * d3;
                                    entityfallingblock.addVelocity(d2 / d4 * 10.0, 2.0 + player.getRNG().nextGaussian(), d3 / d4 * 10.0);
                                    player.worldObj.spawnEntityInWorld((Entity)entityfallingblock);
                                    player.worldObj.setBlockToAir(k1, l1, i2);
                                    continue;
                                }
                                if (player.worldObj.getClosestPlayerToEntity((Entity)player, 16.0) != null) {
                                    player.worldObj.func_147480_a(k1, l1, i2, true);
                                    continue;
                                }
                                player.worldObj.setBlockToAir(k1, l1, i2);
                                block1.dropBlockAsItem(player.worldObj, k1, l1, i2, player.worldObj.getBlockMetadata(k1, l1, i2), 0);
                            }
                        }
                    }
                }
                player.worldObj.createExplosion((Entity)player, player.posX, player.posY - 2.0, player.posZ, 3.0f, player.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                if (list != null && !list.isEmpty()) {
                    for (int i1 = 0; i1 < list.size(); ++i1) {
                        Entity entity = (Entity)list.get(i1);
                        if (entity == null || entity instanceof EntityTitan || entity instanceof EntityGolem || entity instanceof EntityTameable || entity instanceof EntityVillager) continue;
                        entity.attackEntityFrom(new EntityDamageSource("explosion.player", (Entity)player).setDifficultyScaled().setExplosion().setDamageBypassesArmor(), 300.0f);
                        entity.motionY += 1.0;
                        entity.posY += 1.0;
                    }
                }
            }
            if ((list111 = player.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)player, player.boundingBox.expand(10.0, 10.0, 10.0))) != null && !list111.isEmpty()) {
                for (int i1 = 0; i1 < list111.size(); ++i1) {
                    Entity entity = (Entity)list111.get(i1);
                    if (entity == null || !entity.isEntityAlive() || entity.ticksExisted % 10 != 0 || !(entity instanceof EntityLiving) || entity instanceof EntityTitan || entity instanceof EntityGolem || entity instanceof EntityTameable || entity instanceof EntityVillager) continue;
                    entity.attackEntityFrom(EntityTitan.isOreSpawnBossToExempt(entity) ? DamageSource.causePlayerDamage((EntityPlayer)player).setDamageBypassesArmor() : DamageSourceExtra.radiation, EntityTitan.isOreSpawnBossToExempt(entity) ? 100.0f : 10.0f);
                    entity.hurtResistantTime = 0;
                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(ClientProxy.creeperTitanRadiation.id, 5000, 1));
                    if (!Loader.isModLoaded((String)"OreSpawn") || !(entity instanceof PurplePower)) continue;
                    ((PurplePower)entity).attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)player), 100.0f);
                    ((PurplePower)entity).setHealth(0.0f);
                    ((PurplePower)entity).playSound("orespawn:trex_death", 1.0f, 0.9999f);
                    ((PurplePower)entity).playSound("orespawn:trex_death", 1.0f, 1.0f);
                    ((PurplePower)entity).playSound("orespawn:trex_death", 1.0f, 1.0001f);
                    entity.motionY += 1.0;
                }
            }
            if ((list11111 = player.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)player, player.boundingBox.expand(48.0, 48.0, 48.0))) != null && !list11111.isEmpty()) {
                for (int i1 = 0; i1 < list11111.size(); ++i1) {
                    double d3;
                    double d2;
                    double d1;
                    double d4;
                    double d5;
                    Entity entity = (Entity)list11111.get(i1);
                    if (entity == null || entity instanceof EntityPlayer || entity instanceof EntityTitan || entity instanceof EntityHarcadiumArrow || !((d5 = 1.0 - (d4 = Math.sqrt((d1 = (player.posX - entity.posX) / 48.0) * d1 + (d2 = (player.posY + 1.0 - entity.posY) / 48.0) * d2 + (d3 = (player.posZ - entity.posZ) / 48.0) * d3))) > 0.0)) continue;
                    d5 *= d5;
                    entity.motionX += d1 / d4 * d5 * 0.1;
                    entity.motionY += d2 / d4 * d5 * 0.1;
                    entity.motionZ += d3 / d4 * d5 * 0.1;
                }
            }
            player.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        } else {
            player.maxHurtResistantTime = 20;
            player.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0);
        }
    }

    private void removeEffect(EntityPlayer player, Potion potion) {
        if (player.getActivePotionEffect(potion) != null) {
            player.removePotionEffect(potion.id);
            player.playSound("random.fizz", 0.5f, 2.0f);
        }
    }

    private void effectPlayer(EntityPlayer player, Potion potion, int amplifier) {
        if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1) {
            player.addPotionEffect(new PotionEffect(potion.id, 10, amplifier, true));
        }
    }

    private void effectPlayerLong(EntityPlayer player, Potion potion, int amplifier) {
        if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1) {
            player.addPotionEffect(new PotionEffect(potion.id, 800, amplifier, true));
        }
    }

    private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots) {
        return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestplate && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == boots;
    }
}

