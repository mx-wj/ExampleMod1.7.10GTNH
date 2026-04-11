/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.Block$SoundType
 *  net.minecraft.block.BlockOre
 *  net.minecraft.block.material.Material
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.stats.StatList
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.event.ForgeEventFactory
 */
package net.minecraft.theTitans.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class BlockVoidOre
extends BlockOre {
    public static final Block.SoundType soundTypeVoid = new Block.SoundType("stone", 10.0f, 0.5f);
    private Random rand = new Random();

    public BlockVoidOre(Material materialIn, String name) {
        this.setHarvestLevel("pickaxe", 1000);
        this.setHardness(800.0f);
        this.setResistance(6000000.0f);
        this.setCreativeTab(TheTitans.titansTab);
        this.setBlockName(name);
        this.setBlockTextureName("thetitans:" + name);
        this.setStepSound(soundTypeVoid);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
        float f = 0.01f;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }

    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
        float f = 0.01f;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149633_2_ + f), (double)p_149633_3_, (double)((float)p_149633_4_ + f), (double)((float)(p_149633_2_ + 1) - f), (double)(p_149633_3_ + 1), (double)((float)(p_149633_4_ + 1) - f));
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return TitanItems.voidItem;
    }

    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
        return MathHelper.getRandomIntegerInRange((Random)this.rand, (int)12000, (int)12000);
    }

    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
        p_149670_5_.attackEntityFrom(DamageSource.outOfWorld, 4.0f);
        p_149670_5_.motionX *= 0.2;
        p_149670_5_.motionZ *= 0.2;
        if (p_149670_5_ instanceof EntityPlayer) {
            ((EntityPlayer)p_149670_5_).addExhaustion(0.2f);
        }
        if (p_149670_5_ instanceof EntityLivingBase && ((EntityLivingBase)p_149670_5_).getRNG().nextInt(10) == 0) {
            ((EntityLivingBase)p_149670_5_).setFire(40);
        }
        if (p_149670_5_ instanceof EntityLivingBase && ((EntityLivingBase)p_149670_5_).getRNG().nextInt(60) == 0) {
            ((EntityLivingBase)p_149670_5_).addPotionEffect(new PotionEffect(Potion.wither.id, 160, 1));
        }
    }

    public void harvestBlock(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
        p_149636_2_.addStat(StatList.mineBlockStatArray[BlockVoidOre.getIdFromBlock((Block)this)], 1);
        p_149636_2_.addExhaustion(10.0f);
        if (this.canSilkHarvest(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_) && EnchantmentHelper.getSilkTouchModifier((EntityLivingBase)p_149636_2_)) {
            ArrayList<ItemStack> items = new ArrayList<ItemStack>();
            ItemStack itemstack = this.createStackedBlock(p_149636_6_);
            if (itemstack != null) {
                items.add(itemstack);
            }
            ForgeEventFactory.fireBlockHarvesting(items, (World)p_149636_1_, (Block)this, (int)p_149636_3_, (int)p_149636_4_, (int)p_149636_5_, (int)p_149636_6_, (int)0, (float)1.0f, (boolean)true, (EntityPlayer)p_149636_2_);
            for (ItemStack is : items) {
                this.dropBlockAsItem(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, is);
            }
        } else {
            this.harvesters.set(p_149636_2_);
            int i1 = EnchantmentHelper.getFortuneModifier((EntityLivingBase)p_149636_2_);
            this.dropBlockAsItem(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_, i1);
            this.harvesters.set(null);
            p_149636_2_.worldObj.newExplosion(null, p_149636_2_.posX, p_149636_2_.posY, p_149636_2_.posZ, 1.0f, false, p_149636_2_.worldObj.getGameRules().getGameRuleBooleanValue("doTileDrops"));
        }
    }

    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return false;
    }

    public int tickRate(World p_149738_1_) {
        return 30;
    }

    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
        this.randomDisplayTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
    }

    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
        this.func_150186_m(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_);
        if (p_149734_5_.nextInt(20) == 0) {
            p_149734_1_.playSound((double)((float)p_149734_2_ + 0.5f), (double)((float)p_149734_3_ + 0.5f), (double)((float)p_149734_4_ + 0.5f), "thetitans:harcadiumBlockHum", 1.0f, 0.75f, false);
        }
    }

    private void func_150186_m(World p_150186_1_, int p_150186_2_, int p_150186_3_, int p_150186_4_) {
        Random random = p_150186_1_.rand;
        double d0 = 0.0625;
        for (int l = 0; l < 6; ++l) {
            double d1 = (float)p_150186_2_ + random.nextFloat();
            double d2 = (float)p_150186_3_ + random.nextFloat();
            double d3 = (float)p_150186_4_ + random.nextFloat();
            if (l == 0 && !p_150186_1_.getBlock(p_150186_2_, p_150186_3_ + 1, p_150186_4_).isOpaqueCube()) {
                d2 = (double)(p_150186_3_ + 1) + d0;
            }
            if (l == 1 && !p_150186_1_.getBlock(p_150186_2_, p_150186_3_ - 1, p_150186_4_).isOpaqueCube()) {
                d2 = (double)(p_150186_3_ + 0) - d0;
            }
            if (l == 2 && !p_150186_1_.getBlock(p_150186_2_, p_150186_3_, p_150186_4_ + 1).isOpaqueCube()) {
                d3 = (double)(p_150186_4_ + 1) + d0;
            }
            if (l == 3 && !p_150186_1_.getBlock(p_150186_2_, p_150186_3_, p_150186_4_ - 1).isOpaqueCube()) {
                d3 = (double)(p_150186_4_ + 0) - d0;
            }
            if (l == 4 && !p_150186_1_.getBlock(p_150186_2_ + 1, p_150186_3_, p_150186_4_).isOpaqueCube()) {
                d1 = (double)(p_150186_2_ + 1) + d0;
            }
            if (l == 5 && !p_150186_1_.getBlock(p_150186_2_ - 1, p_150186_3_, p_150186_4_).isOpaqueCube()) {
                d1 = (double)(p_150186_2_ + 0) - d0;
            }
            if (!(d1 < (double)p_150186_2_ || d1 > (double)(p_150186_2_ + 1) || d2 < 0.0 || d2 > (double)(p_150186_3_ + 1) || d3 < (double)p_150186_4_) && !(d3 > (double)(p_150186_4_ + 1))) continue;
            p_150186_1_.spawnParticle("smoke", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("largesmoke", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("depthsuspend", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("depthsuspend", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("depthsuspend", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("depthsuspend", d1, d2, d3, 0.0, 0.0, 0.0);
        }
    }
}

