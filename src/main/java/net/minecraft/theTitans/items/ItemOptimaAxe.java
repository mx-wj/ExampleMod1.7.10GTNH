/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockOre
 *  net.minecraft.block.IGrowable
 *  net.minecraft.block.material.Material
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.storage.WorldInfo
 *  net.minecraftforge.common.util.EnumHelper
 */
package net.minecraft.theTitans.items;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockOre;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
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
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.util.EnumHelper;

public class ItemOptimaAxe
extends ItemSword {
    public static Item.ToolMaterial enumToolMaterialOptima = EnumHelper.addToolMaterial((String)"Optima", (int)Integer.MAX_VALUE, (int)2, (float)9999999.0f, (float)999996.0f, (int)0);

    public ItemOptimaAxe(String unlocalizedName) {
        super(enumToolMaterialOptima);
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
        if (p_77624_1_.getItemDamage() > 0) {
            p_77624_3_.add("\u00a73\u00a7lThe ultimate weapon.");
            p_77624_3_.add("\u00a73\u00a7lCuts through all defences, even hacks.");
            p_77624_3_.add("\u00a73\u00a7lNormally owned by Clarigatio");
        } else {
            p_77624_3_.add("\u00a7l\u00a7k\u00a73\u00a7lThe ultimate weapon.");
            p_77624_3_.add("\u00a7l\u00a7k\u00a73\u00a7lCuts through all defences, even hacks.");
            p_77624_3_.add("\u00a7l\u00a7k\u00a73\u00a7lNormally owned by Clarigatio");
        }
    }

    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
        return true;
    }

    private void giveAdvice(EntityPlayer player) {
        List list1 = player.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)player, player.boundingBox.expand(16.0, 16.0, 16.0));
        if (list1 != null && !list1.isEmpty()) {
            for (int i1 = 0; i1 < list1.size(); ++i1) {
                Entity entity = (Entity)list1.get(i1);
                if (!(entity instanceof IMob) && !(entity instanceof EntityPlayer)) continue;
                if (player.canEntityBeSeen(entity)) {
                    player.addChatMessage((IChatComponent)new ChatComponentText("Optima Axe: \u00a7l\u00a7oThe " + ((EntityLivingBase)entity).getCommandSenderName() + " is " + player.getDistanceToEntity(entity) + "\u00a7l\u00a7o blocks away from you."));
                    continue;
                }
                player.addChatMessage((IChatComponent)new ChatComponentText("Optima Axe: \u00a7l\u00a7oAn unseen mob is located out of your \u00a7l\u00a7osight " + player.getDistanceToEntity(entity) + " blocks away from you."));
                player.addChatMessage((IChatComponent)new ChatComponentText("Optima Axe: \u00a7l\u00a7oThe mob's health: " + ((EntityLivingBase)entity).getHealth() + "/" + ((EntityLivingBase)entity).getMaxHealth()));
                player.addChatMessage((IChatComponent)new ChatComponentText("Optima Axe: \u00a7l\u00a7oThe mob's name: " + ((EntityLivingBase)entity).getCommandSenderName()));
                player.playSound("mob.wither.hurt", 10.0f, (player.getRNG().nextFloat() - player.getRNG().nextFloat()) * 0.2f + 0.5f);
            }
        }
    }

    private void offerAdvice(EntityPlayer player) {
        int y = MathHelper.floor_double((double)player.posY);
        int x = MathHelper.floor_double((double)player.posX);
        int z = MathHelper.floor_double((double)player.posZ);
        for (int l1 = -8; l1 <= 8; ++l1) {
            for (int i2 = -8; i2 <= 8; ++i2) {
                for (int j = -8; j <= 8; ++j) {
                    int j2 = x + l1;
                    int k = y + j;
                    int l = z + i2;
                    Block block = player.worldObj.getBlock(j2, k, l);
                    if (!(block instanceof BlockOre)) continue;
                    player.addChatMessage((IChatComponent)new ChatComponentText("Optima Axe: \u00a7l\u00a7oI sense a " + block.getLocalizedName() + "\u00a7l\u00a7o within atleast " + player.getDistance((double)j2, (double)k, (double)l) + " blocks of you."));
                    player.playSound("mob.wither.hurt", 10.0f, 0.6f);
                }
            }
        }
    }

    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        if (p_77659_3_.worldObj.isRemote) {
            if (p_77659_3_.isSneaking()) {
                this.giveAdvice(p_77659_3_);
            } else {
                this.offerAdvice(p_77659_3_);
            }
        }
        if (p_77659_3_.inventory.hasItem(TitanItems.ultimaBlade)) {
            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
            WorldInfo worldinfo = worldserver.getWorldInfo();
            worldinfo.setRainTime(9999999);
            worldinfo.setThunderTime(1000000);
            worldinfo.setRaining(true);
            worldinfo.setThundering(true);
            List list = p_77659_3_.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)p_77659_3_, p_77659_3_.boundingBox.expand(200.0, 100.0, 200.0));
            if (list != null && !list.isEmpty()) {
                for (int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity == null || !entity.isEntityAlive() || !(entity instanceof EntityLivingBase) || entity instanceof EntityTitan || entity == p_77659_3_) continue;
                    entity.copyLocationAndAnglesFrom((Entity)p_77659_3_);
                    entity.attackEntityFrom(DamageSourceExtra.lightningBolt, 49.0f);
                    p_77659_3_.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(p_77659_3_.worldObj, entity.posX, entity.posY + (double)entity.height, entity.posZ, p_77659_3_.getRNG().nextFloat(), p_77659_3_.getRNG().nextFloat(), p_77659_3_.getRNG().nextFloat()));
                    entity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)p_77659_3_).setDamageBypassesArmor().setDamageIsAbsolute(), 49.0f);
                    if (!(entity instanceof EntityLivingBase) || entity instanceof EntityTitan || !(entity.height >= 6.0f) && !entity.isEntityInvulnerable()) continue;
                    ((EntityLivingBase)entity).setDead();
                    ((EntityLivingBase)entity).getDataWatcher().updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)0.0f, (float)0.0f, (float)((EntityLivingBase)entity).getMaxHealth())));
                    ((EntityLivingBase)entity).attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
                }
            }
        }
        return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        attacker.worldObj.getGameRules().setOrCreateGameRule("keepInventory", "true");
        float extradamage = EnchantmentHelper.func_152377_a((ItemStack)attacker.getHeldItem(), (EnumCreatureAttribute)target.getCreatureAttribute());
        int knockbackAmount = EnchantmentHelper.getKnockbackModifier((EntityLivingBase)attacker, (EntityLivingBase)target);
        int bonusdamage = 1;
        if (target != null) {
            target.setFire(Integer.MAX_VALUE);
            target.addPotionEffect(new PotionEffect(ClientProxy.electricJudgment.id, Integer.MAX_VALUE, 19));
            target.hurtResistantTime = 0;
            if (target instanceof EntityTitan && ((EntityTitan)target).canBeHurtByPlayer()) {
                if (target instanceof EntityWitherzilla) {
                    bonusdamage = 10;
                }
                if (attacker instanceof EntityPlayer) {
                    ((EntityTitan)target).attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)((EntityPlayer)attacker)), this.func_150931_i());
                }
                ((EntityTitan)target).setTitanHealth(((EntityTitan)target).getHealth() - 3000.0f * (float)bonusdamage - extradamage);
                ((EntityTitan)target).playSound("thetitans:titanpunch", 10.0f, 1.0f);
                ((EntityTitan)target).setAttackTarget(attacker);
                ((EntityTitan)target).addTitanVelocity(-MathHelper.sin((float)(attacker.rotationYaw * (float)Math.PI / 180.0f)) * 2.0f + (float)knockbackAmount, 0.5 + (double)knockbackAmount, MathHelper.cos((float)(attacker.rotationYaw * (float)Math.PI / 180.0f)) * 2.0f + (float)knockbackAmount);
            } else if (!(target instanceof EntityTitan)) {
                if (target.height == 50.0f && target.width == 15.0f || EntityTitan.isOreSpawnBossToExempt((Entity)target)) {
                    try {
                        ReflectionHelper.findField(target.getClass(), (String[])new String[]{"hurt_timer"}).setInt(target, 0);
                    }
                    catch (Exception e) {
                        target.hurtResistantTime = 0;
                    }
                    double originalHealth = target.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
                    target.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(0.0);
                    target.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)attacker).setDamageBypassesArmor().setDamageIsAbsolute(), 40.0f);
                    target.addPotionEffect(new PotionEffect(ClientProxy.death.id, Integer.MAX_VALUE, 19));
                    ++target.deathTime;
                    target.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(originalHealth);
                }
                target.getDataWatcher().updateObject(6, (Object)Float.valueOf(MathHelper.clamp_float((float)(target.getHealth() - this.func_150931_i() - extradamage), (float)0.0f, (float)target.getMaxHealth())));
                target.playSound("thetitans:slashFlesh", 10.0f, 1.0f);
                target.motionX = -MathHelper.sin((float)(attacker.rotationYaw * (float)Math.PI / 180.0f)) * 6.0f + (float)knockbackAmount;
                target.motionY = 6.0 + (double)knockbackAmount;
                target.motionZ = MathHelper.cos((float)(attacker.rotationYaw * (float)Math.PI / 180.0f)) * 6.0f + (float)knockbackAmount;
                if (!target.isEntityAlive()) {
                    target.onDeath(DamageSource.magic);
                    target.worldObj.setEntityState((Entity)target, (byte)3);
                }
            }
        }
        return true;
    }

    public EnumRarity getRarity(ItemStack stack) {
        return TheTitans.godly;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        int titanslaying;
        int fire;
        int bug;
        int smite;
        int sharpness = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.sharpness.effectId, (ItemStack)stack);
        if (sharpness <= 0) {
            stack.addEnchantment(Enchantment.sharpness, 100);
        }
        if ((smite = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.smite.effectId, (ItemStack)stack)) <= 0) {
            stack.addEnchantment(Enchantment.smite, 100);
        }
        if ((bug = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.baneOfArthropods.effectId, (ItemStack)stack)) <= 0) {
            stack.addEnchantment(Enchantment.baneOfArthropods, 100);
        }
        if ((fire = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.fireAspect.effectId, (ItemStack)stack)) <= 0) {
            stack.addEnchantment(Enchantment.fireAspect, 100);
        }
        if ((titanslaying = EnchantmentHelper.getEnchantmentLevel((int)Enchantment.looting.effectId, (ItemStack)stack)) <= 0) {
            stack.addEnchantment(Enchantment.looting, 100);
        }
    }

    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        } else {
            stack.getTagCompound().setBoolean("Unbreakable", true);
        }
        entityIn.extinguish();
        if (entityIn instanceof EntityPlayer && !worldIn.isRemote) {
            if (stack.getItemDamage() == 0 && entityIn.ticksExisted % 2 == 0) {
                ((EntityPlayer)entityIn).addChatMessage((IChatComponent)new ChatComponentText("Optima Axe: You are unworthy of my power."));
                ((EntityPlayer)entityIn).inventory.consumeInventoryItem(TitanItems.optimaAxe);
                ((EntityPlayer)entityIn).addChatMessage((IChatComponent)new ChatComponentText("\u00a77\u00a7lYou are unworthy of this weapon."));
            } else {
                ((EntityPlayer)entityIn).triggerAchievement((StatBase)TitansAchievments.ultimaBlade);
                if (((EntityPlayer)entityIn).inventory.hasItem(TitanItems.ultimaBlade)) {
                    List list;
                    WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
                    WorldInfo worldinfo = worldserver.getWorldInfo();
                    worldinfo.setRainTime(9999999);
                    worldinfo.setThunderTime(1000000);
                    worldinfo.setRaining(true);
                    worldinfo.setThundering(true);
                    if (((EntityPlayer)entityIn).getRNG().nextInt(5) == 0) {
                        for (int l = 0; l < 5; ++l) {
                            int i = MathHelper.floor_double((double)(((EntityPlayer)entityIn).posX + (double)(((EntityPlayer)entityIn).getRNG().nextInt() * 200 - 100)));
                            int j = MathHelper.floor_double((double)(((EntityPlayer)entityIn).posY + (double)(((EntityPlayer)entityIn).getRNG().nextInt() * 100 - 50)));
                            int k = MathHelper.floor_double((double)(((EntityPlayer)entityIn).posZ + (double)(((EntityPlayer)entityIn).getRNG().nextInt() * 200 - 100)));
                            EntityGammaLightning entitylightning = new EntityGammaLightning(((EntityPlayer)entityIn).worldObj, i, j, k, ((EntityPlayer)entityIn).getRNG().nextFloat(), ((EntityPlayer)entityIn).getRNG().nextFloat(), ((EntityPlayer)entityIn).getRNG().nextFloat());
                            if (!World.doesBlockHaveSolidTopSurface((IBlockAccess)((EntityPlayer)entityIn).worldObj, (int)i, (int)(j - 1), (int)k) || !((EntityPlayer)entityIn).worldObj.checkNoEntityCollision(entitylightning.boundingBox) || !((EntityPlayer)entityIn).worldObj.getCollidingBoundingBoxes((Entity)entitylightning, entitylightning.boundingBox).isEmpty() || ((EntityPlayer)entityIn).worldObj.isAnyLiquid(entitylightning.boundingBox)) continue;
                            ((EntityPlayer)entityIn).worldObj.addWeatherEffect((Entity)entitylightning);
                        }
                    }
                    if ((list = ((EntityPlayer)entityIn).worldObj.getEntitiesWithinAABBExcludingEntity((Entity)((EntityPlayer)entityIn), ((EntityPlayer)entityIn).boundingBox.expand(200.0, 100.0, 200.0))) != null && !list.isEmpty()) {
                        for (int i1 = 0; i1 < list.size(); ++i1) {
                            Entity entity = (Entity)list.get(i1);
                            if (entity == null || !entity.isEntityAlive() || !(entity instanceof EntityLivingBase) || entity instanceof EntityTitan || ((EntityPlayer)entityIn).getRNG().nextInt(60) != 0 || entity == entityIn) continue;
                            entity.addVelocity((double)(-MathHelper.sin((float)(entityIn.rotationYaw * (float)Math.PI / 180.0f)) * 1.25f), 1.0, (double)(MathHelper.cos((float)(entityIn.rotationYaw * (float)Math.PI / 180.0f)) * 1.25f));
                            entity.attackEntityFrom(DamageSourceExtra.lightningBolt, 49.0f);
                            ((EntityPlayer)entityIn).worldObj.addWeatherEffect((Entity)new EntityGammaLightning(((EntityPlayer)entityIn).worldObj, entity.posX, entity.posY + (double)entity.height, entity.posZ, ((EntityPlayer)entityIn).getRNG().nextFloat(), ((EntityPlayer)entityIn).getRNG().nextFloat(), ((EntityPlayer)entityIn).getRNG().nextFloat()));
                            entity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)((EntityPlayer)entityIn)).setDamageBypassesArmor().setDamageIsAbsolute(), 49.0f);
                        }
                    }
                }
            }
        }
        if (entityIn.posY < -45.0) {
            entityIn.motionY += 10.0;
        }
        stack.setStackDisplayName("\u00a7lThe Optima Axe");
        for (int i = 0; i < 3; ++i) {
            entityIn.worldObj.spawnParticle("portal", ((EntityLivingBase)entityIn).posX + (((EntityLivingBase)entityIn).getRNG().nextDouble() - 0.5) * (double)((EntityLivingBase)entityIn).width, ((EntityLivingBase)entityIn).posY + ((EntityLivingBase)entityIn).getRNG().nextDouble() * (double)((EntityLivingBase)entityIn).height, ((EntityLivingBase)entityIn).posZ + (((EntityLivingBase)entityIn).getRNG().nextDouble() - 0.5) * (double)((EntityLivingBase)entityIn).width, (((EntityLivingBase)entityIn).getRNG().nextDouble() - 0.5) * 2.0, 1.0, (((EntityLivingBase)entityIn).getRNG().nextDouble() - 0.5) * 2.0);
            entityIn.worldObj.spawnParticle("largesmoke", ((EntityLivingBase)entityIn).posX + (((EntityLivingBase)entityIn).getRNG().nextDouble() - 0.5) * (double)((EntityLivingBase)entityIn).width, ((EntityLivingBase)entityIn).posY + ((EntityLivingBase)entityIn).getRNG().nextDouble() * (double)((EntityLivingBase)entityIn).height, ((EntityLivingBase)entityIn).posZ + (((EntityLivingBase)entityIn).getRNG().nextDouble() - 0.5) * (double)((EntityLivingBase)entityIn).width, (((EntityLivingBase)entityIn).getRNG().nextDouble() - 0.5) * 2.0, 1.0, (((EntityLivingBase)entityIn).getRNG().nextDouble() - 0.5) * 2.0);
        }
        if (entityIn instanceof EntityPlayer && entityIn != null) {
            List list1;
            if (((EntityPlayer)entityIn).isBlocking() && (list1 = entityIn.worldObj.getEntitiesWithinAABBExcludingEntity(entityIn, entityIn.boundingBox.expand(16.0, 16.0, 16.0))) != null && !list1.isEmpty()) {
                for (int i11 = 0; i11 < list1.size(); ++i11) {
                    Entity entity1 = (Entity)list1.get(i11);
                    if (entity1 == null || !(entityIn.getDistanceSqToEntity(entity1) < 100.0) || !(entity1 instanceof EntityArrow) && !(entity1 instanceof EntityFireball) && !(entity1 instanceof EntityThrowable) && !(entity1 instanceof EntityTNTPrimed)) continue;
                    entity1.worldObj.newExplosion(entityIn, entity1.posX, entity1.posY, entity1.posZ, entity1.width, false, false);
                    entity1.setDead();
                }
            }
            ((EntityPlayer)entityIn).heal(((EntityPlayer)entityIn).getMaxHealth());
            if (((EntityPlayer)entityIn).getActivePotionEffect(Potion.field_76444_x) == null || ((EntityPlayer)entityIn).getActivePotionEffect(Potion.field_76444_x).getDuration() <= 1) {
                ((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 5, 249, false));
            }
        }
    }

    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        double dz;
        double dy;
        List list;
        if (!entityLiving.worldObj.isRemote && entityLiving instanceof EntityPlayer && ((EntityPlayer)entityLiving).isSneaking() && (list = entityLiving.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)entityLiving, entityLiving.boundingBox.expand(64.0, 64.0, 64.0))) != null && !list.isEmpty()) {
            for (int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity = (Entity)list.get(i1);
                if (entity == null || entity instanceof EntityTitan) continue;
                entity.playSound("thetitans:titanpunch", 2.0f, 0.5f + entityLiving.getRNG().nextFloat() * 0.25f);
                entity.playSound("random.fizz", 2.0f, 2.0f);
                entity.attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
                if (entity instanceof EntityLivingBase) {
                    this.hitEntity(stack, (EntityLivingBase)entity, entityLiving);
                    continue;
                }
                if (entity instanceof EntityTitanSpirit || entity instanceof EntityTitanPart) continue;
                entity.setDead();
            }
        }
        if (!entityLiving.worldObj.isRemote && entityLiving instanceof EntityPlayer) {
            ((EntityPlayer)entityLiving).setItemInUse(stack, this.getMaxItemUseDuration(stack));
            Vec3 vec3 = ((EntityPlayer)entityLiving).getLook(1.0f);
            double dx = vec3.xCoord * 16.0;
            dy = (double)entityLiving.getEyeHeight() + vec3.yCoord * 16.0;
            dz = vec3.zCoord * 16.0;
            for (int k1 = -4; k1 <= 4; ++k1) {
                for (int l1 = -2; l1 <= 2; ++l1) {
                    for (int i2 = -4; i2 <= 4; ++i2) {
                        int y = MathHelper.floor_double((double)(entityLiving.posY + dy + (double)l1));
                        int x = MathHelper.floor_double((double)(entityLiving.posX + dx + (double)k1));
                        int z = MathHelper.floor_double((double)(entityLiving.posZ + dz + (double)i2));
                        if (entityLiving.worldObj.isRemote || entityLiving.worldObj.isAirBlock(x, y, z)) continue;
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
                        entityitem.addVelocity((double)(-MathHelper.sin((float)(entityLiving.rotationYaw * (float)Math.PI / 180.0f)) * 1.0f), 0.75, (double)(MathHelper.cos((float)(entityLiving.rotationYaw * (float)Math.PI / 180.0f)) * 1.0f));
                    }
                }
            }
        }
        if (!entityLiving.worldObj.isRemote && entityLiving instanceof EntityPlayer) {
            ((EntityPlayer)entityLiving).setItemInUse(stack, this.getMaxItemUseDuration(stack));
            for (int i1 = 0; i1 < 12; ++i1) {
                int z;
                Vec3 vec3 = ((EntityPlayer)entityLiving).getLook(1.0f);
                double dx = vec3.xCoord * (double)i1;
                double dy2 = (double)entityLiving.getEyeHeight() + vec3.yCoord * (double)i1;
                double dz2 = vec3.zCoord * (double)i1;
                int y = MathHelper.floor_double((double)(entityLiving.posY + dy2));
                int x = MathHelper.floor_double((double)(entityLiving.posX + dx));
                if (!entityLiving.worldObj.isAirBlock(x, y, z = MathHelper.floor_double((double)(entityLiving.posZ + dz2)))) {
                    entityLiving.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, x, y, z, 0);
                }
                if (entityLiving.worldObj.isRemote || entityLiving.worldObj.isAirBlock(x, y, z)) continue;
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
                entityitem.addVelocity((double)(-MathHelper.sin((float)(entityLiving.rotationYaw * (float)Math.PI / 180.0f)) * 1.0f), 0.75, (double)(MathHelper.cos((float)(entityLiving.rotationYaw * (float)Math.PI / 180.0f)) * 1.0f));
            }
        }
        entityLiving.playSound("thetitans:titanSwing", 10.0f, 1.0f);
        Vec3 vec3 = entityLiving.getLook(1.0f);
        double dx = vec3.xCoord * 12.0;
        dy = (double)entityLiving.getEyeHeight() + vec3.yCoord * 12.0;
        dz = vec3.zCoord * 12.0;
        List list1 = entityLiving.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)entityLiving, entityLiving.boundingBox.expand(12.0, 8.0, 12.0).offset(dx, dy, dz));
        if (list1 != null && !list1.isEmpty()) {
            for (int i11 = 0; i11 < list1.size(); ++i11) {
                Entity entity1 = (Entity)list1.get(i11);
                if (entity1 instanceof EntityTNTPrimed && !entity1.isEntityInvulnerable()) {
                    entity1.worldObj.newExplosion((Entity)entityLiving, entity1.posX, entity1.posY, entity1.posZ, 4.0f, false, false);
                    entity1.setDead();
                }
                if (entity1 instanceof EntityFireball && !entity1.isEntityInvulnerable()) {
                    entity1.worldObj.newExplosion((Entity)entityLiving, entity1.posX, entity1.posY, entity1.posZ, 0.0f, false, false);
                    entity1.setDead();
                }
                if (!(entity1 instanceof EntityLivingBase) || !entity1.isEntityAlive() || entity1 == entityLiving) continue;
                entity1.setFire(Integer.MAX_VALUE);
                entityLiving.worldObj.getGameRules().setOrCreateGameRule("keepInventory", "true");
                float extradamage = EnchantmentHelper.func_152377_a((ItemStack)entityLiving.getHeldItem(), (EnumCreatureAttribute)((EntityLivingBase)entity1).getCreatureAttribute());
                int knockbackAmount = EnchantmentHelper.getKnockbackModifier((EntityLivingBase)entityLiving, (EntityLivingBase)((EntityLivingBase)entity1));
                if (entity1 == null) continue;
                entity1.attackEntityFrom(DamageSourceExtra.causeAntiTitanDamage((Entity)entityLiving), 20000.0f + extradamage);
                entity1.hurtResistantTime = 0;
                this.hitEntity(stack, (EntityLivingBase)entity1, entityLiving);
                if (!(entity1 instanceof EntityTitan)) continue;
                ((EntityTitan)entity1).setAttackTarget(entityLiving);
                if (!((EntityTitan)entity1).canBeHurtByPlayer() && entityLiving instanceof EntityPlayer) {
                    ((EntityPlayer)entityLiving).addChatMessage((IChatComponent)new ChatComponentText(((EntityTitan)entity1).getCommandSenderName() + ": Quit flailing that giant axe at me."));
                }
                return true;
            }
        }
        return false;
    }
}

