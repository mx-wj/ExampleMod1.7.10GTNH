/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.eventhandler.Event
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockOre
 *  net.minecraft.block.IGrowable
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.player.ArrowLooseEvent
 */
package net.minecraft.theTitans.items;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.ReflectionHelper;
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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.EntityImmortalItem;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemAdminiumSword
extends ItemSword {
    public ItemAdminiumSword(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.setTextureName("thetitans:adminium_sword");
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.bow;
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target != null && !target.worldObj.isRemote) {
            target.motionY += 1.0;
            target.hurtResistantTime = 0;
            if (target.height >= 6.0f || target instanceof EntityTitan || !target.onGround) {
                try {
                    ReflectionHelper.findField(EntityLivingBase.class, (String[])new String[]{"recentlyHit", "field_70718_bc"}).setInt(target, 100);
                }
                catch (Exception e) {
                    target.hurtResistantTime = 0;
                }
                try {
                    ReflectionHelper.findField(EntityLivingBase.class, (String[])new String[]{"hurt_timer"}).setInt(target, 0);
                    target.hurtResistantTime = 0;
                }
                catch (Exception e) {
                    target.hurtResistantTime = 0;
                }
                target.setHealth(target.getHealth() - 5.0E9f);
                target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker), 5.0E9f);
                target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                if (target.height == 50.0f && target.width == 15.0f) {
                    target.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(0.0);
                    target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker), 40.0f);
                    target.handleHealthUpdate((byte)3);
                    target.addPotionEffect(new PotionEffect(ClientProxy.death.id, Integer.MAX_VALUE, 19));
                    ++target.deathTime;
                }
                if (target instanceof EntityTitan && ((EntityTitan)target).canBeHurtByPlayer() && !(target instanceof EntityWitherzilla) && ((EntityTitan)target).getInvulTime() < 1) {
                    net.minecraft.theTitans.util.FastExplosion.newExplosion(target.worldObj, null, target.posX, target.posY + (double)(target.height * 0.5f), target.posZ, 7.0f, false, false);
                    target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                    ((EntityTitan)target).setTitanHealth(((EntityTitan)target).getHealth() - 1000.0f);
                }
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
                try {
                    ReflectionHelper.findField(EntityLivingBase.class, (String[])new String[]{"recentlyHit", "field_70718_bc"}).setInt(entity1, 100);
                }
                catch (Exception exception) {
                    // empty catch block
                }
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

    public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
        return true;
    }

    public static MovingObjectPosition raytraceFromEntity(World world, Entity player, boolean wut, double range) {
        float f = 1.0f;
        float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
        float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
        double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double)f;
        double d1 = player.prevPosY + (player.posY - player.prevPosY) * (double)f;
        if (!world.isRemote && player instanceof EntityPlayer) {
            d1 += 1.62;
        }
        double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)f;
        Vec3 vec3 = Vec3.createVectorHelper((double)d0, (double)d1, (double)d2);
        float f3 = MathHelper.cos((float)(-f2 * ((float)Math.PI / 180) - (float)Math.PI));
        float f4 = MathHelper.sin((float)(-f2 * ((float)Math.PI / 180) - (float)Math.PI));
        float f5 = -MathHelper.cos((float)(-f1 * ((float)Math.PI / 180)));
        float f6 = MathHelper.sin((float)(-f1 * ((float)Math.PI / 180)));
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        double d3 = range;
        Vec3 vec31 = vec3.addVector((double)f7 * d3, (double)f6 * d3, (double)f8 * d3);
        return world.rayTraceBlocks(vec3, vec31, wut);
    }

    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        MovingObjectPosition raycast = ItemAdminiumSword.raytraceFromEntity(entityLiving.worldObj, (Entity)entityLiving, true, 6.0);
        if (!entityLiving.worldObj.isRemote && raycast != null) {
            Block block = entityLiving.worldObj.getBlock(raycast.blockX, raycast.blockY, raycast.blockZ);
            if (block instanceof IGrowable && !(block instanceof BlockGrass) || block.getMaterial() == Material.circuits || block instanceof BlockOre) {
                entityLiving.worldObj.func_147480_a(raycast.blockX, raycast.blockY, raycast.blockZ, true);
            } else {
                int l = entityLiving.worldObj.getBlockMetadata(raycast.blockX, raycast.blockY, raycast.blockZ);
                entityLiving.worldObj.playAuxSFX(2001, raycast.blockX, raycast.blockY, raycast.blockZ, Block.getIdFromBlock((Block)block) + (l << 12));
                EntityItem entityitem = new EntityItem(entityLiving.worldObj, (double)raycast.blockX, (double)raycast.blockY, (double)raycast.blockZ, new ItemStack(Item.getItemFromBlock((Block)block), 1, l));
                entityLiving.worldObj.spawnEntityInWorld((Entity)entityitem);
                entityLiving.worldObj.setBlockToAir(raycast.blockX, raycast.blockY, raycast.blockZ);
            }
        }
        return false;
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

