/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.eventhandler.Event
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemStack
 *  net.minecraft.stats.StatBase
 *  net.minecraft.stats.StatList
 *  net.minecraft.util.IIcon
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.player.ArrowLooseEvent
 *  net.minecraftforge.event.entity.player.ArrowNockEvent
 */
package net.minecraft.theTitans.items;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemHarcadiumBow
extends ItemBow {
    public static final String[] bowPullIconNameArray = new String[]{"pulling_0", "pulling_1", "pulling_2"};
    @SideOnly(value=Side.CLIENT)
    private IIcon[] iconArray;

    public ItemHarcadiumBow() {
        this.maxStackSize = 1;
        this.setMaxDamage(12000);
        this.setCreativeTab(TheTitans.titansTab);
        this.setUnlocalizedName("harcadium_bow");
    }

    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof EntityPlayer) {
            ((EntityPlayer)entityIn).triggerAchievement((StatBase)TitansAchievments.harcadiumBow);
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target != null && (target.height >= 7.0f || target instanceof EntitySilverfishTitan || target instanceof EntityCaveSpiderTitan)) {
            target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker), 50.0f);
            target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (usingItem == null) {
            return this.itemIcon;
        }
        int ticksInUse = stack.getMaxItemUseDuration() - useRemaining;
        if (ticksInUse > 17) {
            return this.iconArray[2];
        }
        if (ticksInUse > 13) {
            return this.iconArray[1];
        }
        if (ticksInUse > 0) {
            return this.iconArray[0];
        }
        return this.itemIcon;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_) {
        this.itemIcon = p_94581_1_.registerIcon("thetitans:harcadium_bow_standby");
        this.iconArray = new IIcon[bowPullIconNameArray.length];
        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = p_94581_1_.registerIcon("thetitans:harcadium_bow_" + bowPullIconNameArray[i]);
        }
    }

    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft) {
        boolean flag;
        int j = this.getMaxItemUseDuration(stack) - timeLeft;
        ArrowLooseEvent event = new ArrowLooseEvent(playerIn, stack, j);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return;
        }
        j = event.charge;
        boolean bl = flag = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel((int)Enchantment.infinity.effectId, (ItemStack)stack) > 0;
        if (flag || playerIn.inventory.hasItem(TitanItems.harcadiumArrow)) {
            int l;
            int k;
            float f = (float)j / 20.0f;
            if ((double)(f = (f * f + f * 2.0f) / 3.0f) < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            EntityHarcadiumArrow entityarrow = new EntityHarcadiumArrow(worldIn, (EntityLivingBase)playerIn, f * 2.0f);
            if (f == 1.0f) {
                entityarrow.setIsCritical(true);
            }
            if ((k = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.power.effectId, (ItemStack)stack)) > 0) {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 100.0);
            }
            if ((l = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.punch.effectId, (ItemStack)stack)) > 0) {
                entityarrow.setKnockbackStrength(l * 3);
            }
            if (EnchantmentHelper.getEnchantmentLevel((int)Enchantment.flame.effectId, (ItemStack)stack) > 0) {
                entityarrow.setFire(500);
            }
            stack.damageItem(1, (EntityLivingBase)playerIn);
            worldIn.playSoundAtEntity((Entity)playerIn, "random.bow", 1.0f, 1.0f / (itemRand.nextFloat() * 0.4f + 1.2f) + f * 0.5f);
            if (flag) {
                entityarrow.canBePickedUp = 2;
            } else {
                playerIn.inventory.consumeInventoryItem(TitanItems.harcadiumArrow);
            }
            playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem((Item)this)]);
            if (!worldIn.isRemote) {
                worldIn.spawnEntityInWorld((Entity)entityarrow);
                Vec3 vec3 = playerIn.getLook(1.0f);
                entityarrow.posX = playerIn.posX + vec3.xCoord;
                entityarrow.posY = playerIn.posY + vec3.yCoord + 1.0;
                entityarrow.posZ = playerIn.posZ + vec3.zCoord;
            }
        }
    }

    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
        return p_77654_1_;
    }

    public int getMaxItemUseDuration(ItemStack p_77626_1_) {
        return 72000;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.bow;
    }

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        ArrowNockEvent event = new ArrowNockEvent(playerIn, itemStackIn);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return event.result;
        }
        if (playerIn.capabilities.isCreativeMode || playerIn.inventory.hasItem(TitanItems.harcadiumArrow)) {
            playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        }
        return itemStackIn;
    }

    public int getItemEnchantability() {
        return 30;
    }
}

