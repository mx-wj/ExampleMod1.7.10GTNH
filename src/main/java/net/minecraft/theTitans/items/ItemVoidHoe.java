/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  cpw.mods.fml.common.eventhandler.Event
 *  cpw.mods.fml.common.eventhandler.Event$Result
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.monster.EntityGolem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.player.UseHoeEvent
 */
package net.minecraft.theTitans.items;

import com.google.common.collect.Multimap;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemVoidHoe
extends ItemSword {
    private float field_150934_a;
    private final Item.ToolMaterial field_150933_b;

    public ItemVoidHoe(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.setTextureName("thetitans:void_hoe");
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
        if (target != null && target instanceof EntityLivingBase) {
            if (target instanceof EntityLiving && target.worldObj.isRemote) {
                ((EntityLiving)target).spawnExplosionParticle();
            }
            if (target.height >= 6.0f || target instanceof EntityTitan || !target.onGround) {
                target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker), 5000.0f);
                target.playSound("thetitans:titanpunch", 10.0f, 1.0f);
            } else if (!(target instanceof EntityPlayer) && !(target instanceof EntityGolem)) {
                attacker.worldObj.removeEntity((Entity)target);
                target.playSound("random.fizz", 1.0f, 0.5f);
                attacker.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 1, 3, false));
                attacker.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)(attacker.getMaxHealth() + target.getMaxHealth()));
                attacker.heal(target.getMaxHealth());
                if (target instanceof EntityMob && target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage) != null) {
                    attacker.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)((float)attacker.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue() + (float)target.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue()));
                }
            }
        }
        return true;
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.block;
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
            p_77648_1_.damageItem(1, (EntityLivingBase)p_77648_2_);
            return true;
        }
        return false;
    }

    public boolean func_150897_b(Block p_150897_1_) {
        return p_150897_1_ == Blocks.farmland;
    }
}

