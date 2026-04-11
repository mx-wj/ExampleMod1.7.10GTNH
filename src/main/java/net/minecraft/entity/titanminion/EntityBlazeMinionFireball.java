/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.projectile.EntitySmallFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titanminion;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBlazeMinionFireball
extends EntitySmallFireball {
    private static final String __OBFID = "CL_00001721";

    public EntityBlazeMinionFireball(World p_i1770_1_) {
        super(p_i1770_1_);
    }

    public EntityBlazeMinionFireball(World p_i1771_1_, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(p_i1771_1_, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
    }

    public EntityBlazeMinionFireball(World p_i1772_1_, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(p_i1772_1_, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
    }

    protected void onImpact(MovingObjectPosition p_70227_1_) {
        if (!this.worldObj.isRemote) {
            if (p_70227_1_.entityHit != null) {
                if (this.shootingEntity != null && this.shootingEntity instanceof EntityLiving && ((EntityLiving)this.shootingEntity).canAttackClass(p_70227_1_.entityHit.getClass())) {
                    p_70227_1_.entityHit.hurtResistantTime = 0;
                    ((EntityLiving)this.shootingEntity).attackEntityAsMob(p_70227_1_.entityHit);
                    p_70227_1_.entityHit.setFire((int)((EntityLiving)this.shootingEntity).getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue());
                    this.setDead();
                }
            } else {
                int i = p_70227_1_.blockX;
                int j = p_70227_1_.blockY;
                int k = p_70227_1_.blockZ;
                switch (p_70227_1_.sideHit) {
                    case 0: {
                        --j;
                        break;
                    }
                    case 1: {
                        ++j;
                        break;
                    }
                    case 2: {
                        --k;
                        break;
                    }
                    case 3: {
                        ++k;
                        break;
                    }
                    case 4: {
                        --i;
                        break;
                    }
                    case 5: {
                        ++i;
                    }
                }
                if (this.worldObj.isAirBlock(i, j, k)) {
                    this.worldObj.setBlock(i, j, k, (Block)Blocks.fire);
                    this.setDead();
                }
            }
        }
    }
}

