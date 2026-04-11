/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHarcadiumBlock
extends Block {
    public BlockHarcadiumBlock(Material materialIn, String name) {
        super(materialIn);
        this.setHarvestLevel("pickaxe", 3);
        this.setHardness(100.0f);
        this.setResistance(18000.0f);
        this.setLightLevel(1.0f);
        this.setCreativeTab(TheTitans.titansTab);
        this.setBlockName(name);
        this.setBlockTextureName("thetitans:" + name);
        this.setStepSound(soundTypeMetal);
    }

    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return !(entity instanceof EntityDragon);
    }

    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        return true;
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
        if (p_149734_5_.nextInt(10) == 0) {
            p_149734_1_.playSound((double)((float)p_149734_2_ + 0.5f), (double)((float)p_149734_3_ + 0.5f), (double)((float)p_149734_4_ + 0.5f), "thetitans:harcadiumBlockHum", 2.0f, 1.0f, false);
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
            p_150186_1_.spawnParticle("portal", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("portal", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("portal", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("portal", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("portal", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("portal", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("portal", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("portal", d1, d2, d3, 0.0, 0.0, 0.0);
            p_150186_1_.spawnParticle("portal", d1, d2, d3, 0.0, 0.0, 0.0);
        }
    }
}

