/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  cpw.mods.fml.common.eventhandler.Event
 *  cpw.mods.fml.common.eventhandler.Event$Result
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
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.player.UseHoeEvent
 */
package net.minecraft.theTitans.items;

import com.google.common.collect.Multimap;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockOre;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.EntityImmortalItem;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemAdminiumHoe
extends ItemSword {
    private float field_150934_a;
    private final Item.ToolMaterial field_150933_b;

    public ItemAdminiumHoe(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.setTextureName("thetitans:adminium_hoe");
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TheTitans.titansTab);
        this.field_150934_a = material.getDamageVsEntity();
        this.field_150933_b = material;
    }

    public float func_150931_i() {
        return this.field_150933_b.getDamageVsEntity() - 4.0f;
    }

    public Multimap getItemAttributeModifiers() {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.field_150934_a - 4.0, 0));
        return multimap;
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target != null && (target.height >= 6.0f || target instanceof EntityTitan || !target.onGround)) {
            target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker), 1.0E9f);
            target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
        }
        return true;
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.none;
    }

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
            return false;
        }
        UseHoeEvent event = new UseHoeEvent(p_77648_2_, p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return false;
        }
        if (event.getResult() == Event.Result.ALLOW) {
            p_77648_1_.damageItem(1, (EntityLivingBase)p_77648_2_);
            return true;
        }
        Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
        if (p_77648_7_ != 0 && p_77648_3_.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_).isAir((IBlockAccess)p_77648_3_, p_77648_4_, p_77648_5_ + 1, p_77648_6_) && (block == Blocks.grass || block == Blocks.dirt || block == Blocks.sponge || block == Blocks.mycelium || block == Blocks.gravel)) {
            Block block1 = Blocks.farmland;
            p_77648_3_.playSoundEffect((double)((float)p_77648_4_ + 0.5f), (double)((float)p_77648_5_ + 0.5f), (double)((float)p_77648_6_ + 0.5f), block1.stepSound.getStepResourcePath(), (block.stepSound.getVolume() + 1.0f) / 2.0f, block.stepSound.getPitch() * 0.8f);
            p_77648_3_.playSoundEffect((double)((float)p_77648_4_ + 0.5f), (double)((float)p_77648_5_ + 0.5f), (double)((float)p_77648_6_ + 0.5f), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0f) / 2.0f, block1.stepSound.getPitch() * 0.8f);
            if (p_77648_3_.isRemote) {
                return true;
            }
            p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, block1);
            return true;
        }
        return false;
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

    public boolean func_150897_b(Block p_150897_1_) {
        return p_150897_1_ == Blocks.farmland;
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

