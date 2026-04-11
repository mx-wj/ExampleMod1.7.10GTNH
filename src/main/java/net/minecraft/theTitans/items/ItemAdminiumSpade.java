/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.minecraft.item.ItemSpade
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.EntityImmortalItem;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemAdminiumSpade
extends ItemSpade {
    public ItemAdminiumSpade(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.setTextureName("thetitans:adminium_spade");
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target != null && (target.height >= 6.0f || target instanceof EntityTitan || !target.onGround)) {
            target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker), 2.0E9f);
            target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
        }
        return true;
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
        MovingObjectPosition raycast = ItemAdminiumSpade.raytraceFromEntity(entityLiving.worldObj, (Entity)entityLiving, true, 10.0);
        if (!entityLiving.worldObj.isRemote && raycast != null && entityLiving.getDistance((double)raycast.blockX, (double)raycast.blockY, (double)raycast.blockZ) <= 6.0) {
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

