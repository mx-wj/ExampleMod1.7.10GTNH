/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
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
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.theTitans.items.ItemHarcadiumArmor;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemVoidArmor
extends ItemHarcadiumArmor {
    AttributeModifier modifierHelmet = new AttributeModifier("Helmet modifier", 350.0, 2);
    AttributeModifier modifierChestplate = new AttributeModifier("Chestplate modifier", 400.0, 2);
    AttributeModifier modifierLeggings = new AttributeModifier("Leggings modifier", 350.0, 2);
    AttributeModifier modifierBoots = new AttributeModifier("Boots modifier", 200.0, 2);

    public ItemVoidArmor(String unlocalizedName, ItemArmor.ArmorMaterial material, int type) {
        super(material, 0, type);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName("thetitans:" + unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
        this.modifierHelmet = new AttributeModifier("Helmet modifier", 250.0, 0);
        this.modifierChestplate = new AttributeModifier("Chestplate modifier", 400.0, 0);
        this.modifierLeggings = new AttributeModifier("Leggings modifier", 350.0, 0);
        this.modifierBoots = new AttributeModifier("Boots modifier", 200.0, 0);
    }

    @Override
    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_) {
        return TitanItems.voidItem == p_82789_2_.getItem();
    }

    public ItemVoidArmor(ItemArmor.ArmorMaterial material, int i, int type) {
        super(material, 0, type);
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

    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thetitans:textures/models/armor/absence_layer_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (itemStack.getItem() == TitanItems.voidHelmet) {
            this.effectPlayer(player, Potion.nightVision, 0);
            this.effectPlayer(player, Potion.waterBreathing, 0);
            this.removeEffect(player, Potion.blindness);
            player.playSound("thetitans:harcadiumHum", 5.0f, 0.5f);
        }
        if (itemStack.getItem() == TitanItems.voidChestplate) {
            this.effectPlayer(player, Potion.digSpeed, 99);
            this.effectPlayer(player, Potion.resistance, 3);
            this.effectPlayer(player, Potion.damageBoost, 49);
            this.effectPlayer(player, Potion.fireResistance, 0);
            this.removeEffect(player, Potion.weakness);
            this.removeEffect(player, Potion.digSlowdown);
            player.playSound("thetitans:harcadiumHum", 5.0f, 0.5f);
            if (player.isBurning()) {
                player.extinguish();
            }
        }
        if (itemStack.getItem() == TitanItems.voidLeggings) {
            this.effectPlayer(player, Potion.regeneration, 199);
            this.removeEffect(player, Potion.confusion);
            this.removeEffect(player, Potion.hunger);
            this.removeEffect(player, Potion.poison);
            player.playSound("thetitans:harcadiumHum", 5.0f, 0.0f);
        }
        if (itemStack.getItem() == TitanItems.voidBoots) {
            this.effectPlayer(player, Potion.jump, 5);
            this.effectPlayer(player, Potion.moveSpeed, 19);
            this.removeEffect(player, Potion.moveSlowdown);
            player.playSound("thetitans:harcadiumHum", 5.0f, 0.5f);
        }
        if (this.isWearingFullSet(player, TitanItems.voidHelmet, TitanItems.voidChestplate, TitanItems.voidLeggings, TitanItems.voidBoots)) {
            player.fallDistance *= 0.0f;
            this.effectPlayerLong(player, Potion.field_76444_x, 199);
            this.effectPlayer(player, Potion.field_76443_y, 99);
            player.triggerAchievement((StatBase)TitansAchievments.voidArmor);
            for (int i = 0; i < 4; ++i) {
                player.worldObj.spawnParticle("depthsuspend", player.posX + (player.getRNG().nextDouble() - 0.5) * (double)player.width * 2.0, player.posY - 1.75 + player.getRNG().nextDouble() * (double)player.height, player.posZ + (player.getRNG().nextDouble() - 0.5) * (double)player.width * 2.0, 0.0, 0.05, 0.0);
            }
            List list11 = player.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)player, player.boundingBox.expand(4.0, 4.0, 4.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity = (Entity)list11.get(i1);
                    if (entity == null || !(entity instanceof EntityLivingBase) || entity instanceof EntityTitan || entity instanceof EntityGolem || entity instanceof EntityTameable || entity instanceof EntityVillager) continue;
                    entity.attackEntityFrom(DamageSource.outOfWorld, 4.0f);
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 5000, 1));
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.confusion.id, 5000, 1));
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 5000, 9));
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.wither.id, 5000, 3));
                }
            }
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
            player.addPotionEffect(new PotionEffect(potion.id, 1, amplifier, false));
        }
    }

    private void effectPlayerLong(EntityPlayer player, Potion potion, int amplifier) {
        if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1) {
            player.addPotionEffect(new PotionEffect(potion.id, 800, amplifier, false));
        }
    }

    private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots) {
        return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestplate && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == boots;
    }
}

