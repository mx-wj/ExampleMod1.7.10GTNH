/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.eventhandler.Event
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockOre
 *  net.minecraft.block.IGrowable
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.common.util.EnumHelper
 *  net.minecraftforge.event.entity.player.ArrowLooseEvent
 */
package net.minecraft.theTitans.items;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockOre;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.EntityImmortalItem;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemAdamantiumSword
extends ItemSword {
    public static Item.ToolMaterial enumToolMaterialAdamantium = EnumHelper.addToolMaterial((String)"Adamantium", (int)Integer.MAX_VALUE, (int)2, (float)9999999.0f, (float)1.0E37f, (int)0);

    public ItemAdamantiumSword(String unlocalizedName) {
        super(enumToolMaterialAdamantium);
        this.setTextureName("thetitans:" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
    }

    public boolean isItemTool(ItemStack p_77616_1_) {
        return true;
    }

    public boolean func_150897_b(Block p_150897_1_) {
        return true;
    }

    public boolean isDamageable() {
        return false;
    }

    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new EntityImmortalItem(world, location, itemstack);
    }

    @SideOnly(value=Side.CLIENT)
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
        super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
        p_77624_3_.add("\u00a73\u00a7lThe weapon of the CHOSEN ONE.");
        p_77624_3_.add("\u00a73\u00a7lCan destroy anything. (expect deities)");
        p_77624_3_.add("\u00a73\u00a7lOnly the CHOSEN ONE (you) is allowed to wield it");
    }

    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
        return true;
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (target != null && !target.worldObj.isRemote) {
            target.motionY += 1.0;
            target.hurtResistantTime = 0;
            target.setHealth(0.0f);
            target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker), Float.MAX_VALUE);
            target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
            if (target instanceof EntityTitan && ((EntityTitan)target).canBeHurtByPlayer() && !(target instanceof EntityWitherzilla) && ((EntityTitan)target).getInvulTime() < 1) {
                target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                ((EntityTitan)target).setTitanHealth(((EntityTitan)target).getHealth() - 3000.0f);
            }
        }
        return true;
    }

    public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_) {
        int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;
        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return;
        }
        j = event.charge;
        float f = (float)j / 60.0f;
        if ((double)(f = (f * f + f * 2.0f) / 3.0f) < 0.1) {
            return;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        p_77615_3_.playSound("thetitans:titanSwing", 1.0f, 2.0f);
        p_77615_3_.swingItem();
        Vec3 vec3 = p_77615_3_.getLook(1.0f);
        double dx = vec3.xCoord * 4.0;
        double dy = (double)p_77615_3_.getEyeHeight() + vec3.yCoord * 4.0;
        double dz = vec3.zCoord * 4.0;
        List list1 = p_77615_3_.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)p_77615_3_, p_77615_3_.boundingBox.expand(4.0, 4.0, 4.0).offset(dx, dy, dz));
        if (list1 != null && !list1.isEmpty()) {
            for (int i11 = 0; i11 < list1.size(); ++i11) {
                Entity entity1 = (Entity)list1.get(i11);
                if (entity1 == p_77615_3_ || !(entity1 instanceof EntityLivingBase) && !(entity1 instanceof EntityTitanPart) && !(entity1 instanceof EntityTitan)) continue;
                entity1.motionY += 1.0;
                entity1.hurtResistantTime = 0;
                entity1.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)p_77615_3_), 1.0E10f * f);
                if (entity1 instanceof EntityLivingBase) {
                    ((EntityLivingBase)entity1).setHealth(((EntityLivingBase)entity1).getHealth() - 2000.0f * f);
                }
                entity1.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                if (!(entity1 instanceof EntityTitan) || !((EntityTitan)entity1).canBeHurtByPlayer() || entity1 instanceof EntityWitherzilla || ((EntityTitan)entity1).getInvulTime() >= 1) continue;
                entity1.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                ((EntityTitan)entity1).setTitanHealth(((EntityTitan)entity1).getHealth() - 2000.0f * f);
            }
        }
    }

    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            for (int i1 = 0; i1 < 4; ++i1) {
                int z;
                Vec3 vec3 = ((EntityPlayer)entityLiving).getLook(1.0f);
                double dx = i1 == 0 ? vec3.xCoord : vec3.xCoord * (double)i1;
                double dy = i1 == 0 ? (double)entityLiving.getEyeHeight() + vec3.yCoord : (double)entityLiving.getEyeHeight() + vec3.yCoord * (double)i1;
                double dz = i1 == 0 ? vec3.zCoord : vec3.zCoord * (double)i1;
                int y = MathHelper.floor_double((double)(entityLiving.posY + dy));
                int x = MathHelper.floor_double((double)(entityLiving.posX + dx));
                if (!entityLiving.worldObj.isAirBlock(x, y, z = MathHelper.floor_double((double)(entityLiving.posZ + dz)))) {
                    entityLiving.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, x, y, z, 0);
                }
                if (entityLiving.worldObj.isRemote || entityLiving.worldObj.isAirBlock(x, y, z)) continue;
                stack.damageItem(2, entityLiving);
                Block block = entityLiving.worldObj.getBlock(x, y, z);
                if (block instanceof IGrowable && !(block instanceof BlockGrass) || block.getMaterial() == Material.circuits || block instanceof BlockOre) {
                    entityLiving.worldObj.func_147480_a(x, y, z, true);
                    continue;
                }
                int l = entityLiving.worldObj.getBlockMetadata(x, y, z);
                entityLiving.worldObj.playAuxSFX(2001, x, y, z, Block.getIdFromBlock((Block)block) + (l << 12));
                EntityItem entityitem = new EntityItem(entityLiving.worldObj, (double)x, (double)y, (double)z, new ItemStack(Item.getItemFromBlock((Block)block), 1, l));
                entityLiving.worldObj.spawnEntityInWorld((Entity)entityitem);
                entityLiving.worldObj.setBlockToAir(x, y, z);
            }
        }
        return false;
    }

    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }

    public EnumRarity getRarity(ItemStack stack) {
        return TheTitans.godly;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}

