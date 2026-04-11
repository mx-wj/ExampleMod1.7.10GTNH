/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EntityLavaSpit
extends EntityFireball {
    public EntityLavaSpit(World worldIn) {
        super(worldIn);
        this.setSize(3.0f, 3.0f);
    }

    public EntityLavaSpit(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
        this.setSize(3.0f, 3.0f);
    }

    public EntityLavaSpit(World worldIn, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(worldIn, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
        this.setSize(3.0f, 3.0f);
    }

    protected void onImpact(MovingObjectPosition movingObject) {
        if (!this.worldObj.isRemote) {
            float f = TheTitans.NightmareMode ? 3000.0f : 1000.0f;
            if (movingObject.entityHit != null) {
                if (this.shootingEntity instanceof EntityTitan) {
                    ((EntityTitan)this.shootingEntity).attackChoosenEntity(movingObject.entityHit, f, 3);
                }
                this.playSound("random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
            } else {
                this.playSound("random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
            }
            int i1 = MathHelper.floor_double((double)this.posX);
            int i = MathHelper.floor_double((double)this.posY);
            int j1 = MathHelper.floor_double((double)this.posZ);
            for (int l1 = -2; l1 <= 2; ++l1) {
                for (int i2 = -2; i2 <= 2; ++i2) {
                    for (int j = 0; j < 1; ++j) {
                        int j2 = i1 + l1;
                        int k = i + j;
                        int l = j1 + i2;
                        for (int y = 0; y <= 256 && this.worldObj.getBlock(j2, i - 1, l).getMaterial() == Material.air; ++y) {
                            --i;
                        }
                        Block block = this.worldObj.getBlock(j2, i, l);
                        if (!block.isAir((IBlockAccess)this.worldObj, j2, i, l)) continue;
                        this.worldObj.setBlock(j2, i, l, (Block)Blocks.flowing_lava, 3, 3);
                    }
                }
            }
            this.setDead();
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean isBurning() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    public boolean isInWater() {
        return false;
    }

    protected float getMotionFactor() {
        return 0.975f;
    }
}

