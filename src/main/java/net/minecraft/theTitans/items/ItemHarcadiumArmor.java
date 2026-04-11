/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemArmor$ArmorMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.stats.StatBase
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.world.World;

public class ItemHarcadiumArmor
extends ItemArmor {
    AttributeModifier modifierHelmet = new AttributeModifier("Helmet modifier", 50.0, 2);
    AttributeModifier modifierChestplate = new AttributeModifier("Chestplate modifier", 80.0, 2);
    AttributeModifier modifierLeggings = new AttributeModifier("Leggings modifier", 70.0, 2);
    AttributeModifier modifierBoots = new AttributeModifier("Boots modifier", 40.0, 2);

    public ItemHarcadiumArmor(String unlocalizedName, ItemArmor.ArmorMaterial material, int type) {
        super(material, 0, type);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName("thetitans:" + unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
        this.modifierHelmet = new AttributeModifier("Helmet modifier", 50.0, 0);
        this.modifierChestplate = new AttributeModifier("Chestplate modifier", 80.0, 0);
        this.modifierLeggings = new AttributeModifier("Leggings modifier", 70.0, 0);
        this.modifierBoots = new AttributeModifier("Boots modifier", 40.0, 0);
    }

    public ItemHarcadiumArmor(ItemArmor.ArmorMaterial material, int i, int type) {
        super(material, 0, type);
    }

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

    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_) {
        return TitanItems.harcadium == p_82789_2_.getItem();
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thetitans:textures/models/armor/harcadium_layer_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (itemStack.getItem() == TitanItems.harcadiumHelmet) {
            this.effectPlayer(player, Potion.nightVision, 0);
            this.effectPlayer(player, Potion.waterBreathing, 0);
            this.removeEffect(player, Potion.blindness);
        }
        if (itemStack.getItem() == TitanItems.harcadiumChestplate) {
            this.effectPlayer(player, Potion.digSpeed, 3);
            this.effectPlayer(player, Potion.resistance, 3);
            this.effectPlayer(player, Potion.damageBoost, 9);
            this.effectPlayer(player, Potion.fireResistance, 0);
            this.removeEffect(player, Potion.weakness);
            this.removeEffect(player, Potion.digSlowdown);
        }
        if (itemStack.getItem() == TitanItems.harcadiumLeggings) {
            this.effectPlayer(player, Potion.regeneration, 9);
            this.removeEffect(player, Potion.confusion);
            this.removeEffect(player, Potion.hunger);
            this.removeEffect(player, Potion.poison);
        }
        if (itemStack.getItem() == TitanItems.harcadiumBoots) {
            this.effectPlayer(player, Potion.jump, 3);
            this.effectPlayer(player, Potion.moveSpeed, 3);
            this.removeEffect(player, Potion.moveSlowdown);
        }
        if (this.isWearingFullSet(player, TitanItems.harcadiumHelmet, TitanItems.harcadiumChestplate, TitanItems.harcadiumLeggings, TitanItems.harcadiumBoots)) {
            this.effectPlayerLong(player, Potion.field_76444_x, 99);
            this.effectPlayer(player, Potion.field_76443_y, 49);
            player.playSound("thetitans:harcadiumHum", 0.2f, 1.0f);
            player.triggerAchievement((StatBase)TitansAchievments.harcadiumArmor);
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

