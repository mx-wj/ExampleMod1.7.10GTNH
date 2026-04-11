/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.init.Blocks
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityGammaLightning
extends EntityLightningBolt {
    private int lightningState;
    public long boltVertex;
    private int boltLivingTime;

    public EntityGammaLightning(World p_i1703_1_, float red, float green, float blue) {
        super(p_i1703_1_, (double)red, (double)green, (double)blue);
        this.setSize(3.0f, 3.0f);
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
        this.lightningState = 2;
        this.boltVertex = this.rand.nextLong();
        this.boltLivingTime = this.rand.nextInt(3) + 1;
    }

    public EntityGammaLightning(World p_i1703_1_, double p_i1703_2_, double p_i1703_4_, double p_i1703_6_, float red, float green, float blue) {
        this(p_i1703_1_, red, green, blue);
        this.setPosition(p_i1703_2_, p_i1703_4_, p_i1703_6_);
    }

    public void onUpdate() {
        int l;
        if (this.lightningState == 2) {
            float volume = 0.5f + this.rand.nextFloat();
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, volume);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, volume + 0.1f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, volume + 0.2f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, volume + 0.3f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 10.0f, 0.7f);
        }
        --this.lightningState;
        if (this.lightningState < 0) {
            int k;
            int j;
            if (this.boltLivingTime == 0) {
                if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("doFireTick") && this.worldObj.doChunksNearChunkExist(MathHelper.floor_double((double)this.posX), MathHelper.floor_double((double)this.posY), MathHelper.floor_double((double)this.posZ), 10)) {
                    int i = MathHelper.floor_double((double)this.posX);
                    if (this.worldObj.getBlock(i, j = MathHelper.floor_double((double)this.posY), k = MathHelper.floor_double((double)this.posZ)).getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(this.worldObj, i, j, k)) {
                        this.worldObj.setBlock(i, j, k, (Block)Blocks.fire);
                    }
                    for (i = 0; i < 16; ++i) {
                        j = MathHelper.floor_double((double)this.posX) + this.rand.nextInt(6) - 3;
                        if (this.worldObj.getBlock(j, k = MathHelper.floor_double((double)this.posY) + this.rand.nextInt(6) - 3, l = MathHelper.floor_double((double)this.posZ) + this.rand.nextInt(6) - 3).getMaterial() != Material.air || !Blocks.fire.canPlaceBlockAt(this.worldObj, j, k, l)) continue;
                        this.worldObj.setBlock(j, k, l, (Block)Blocks.fire);
                    }
                }
                this.setDead();
            } else if (this.lightningState < -this.rand.nextInt(10)) {
                int i;
                --this.boltLivingTime;
                this.lightningState = 1;
                this.boltVertex = this.rand.nextLong();
                if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("doFireTick") && this.worldObj.doChunksNearChunkExist(MathHelper.floor_double((double)this.posX), MathHelper.floor_double((double)this.posY), MathHelper.floor_double((double)this.posZ), 10) && this.worldObj.getBlock(i = MathHelper.floor_double((double)this.posX), j = MathHelper.floor_double((double)this.posY), k = MathHelper.floor_double((double)this.posZ)).getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(this.worldObj, i, j, k)) {
                    this.worldObj.setBlock(i, j, k, (Block)Blocks.fire);
                }
            }
        }
        if (this.lightningState >= 0) {
            this.worldObj.lastLightningBolt = 2;
            double d0 = 10.0;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, AxisAlignedBB.getBoundingBox((double)(this.posX - d0), (double)(this.posY - d0), (double)(this.posZ - d0), (double)(this.posX + d0), (double)(this.posY + d0), (double)(this.posZ + d0)));
            for (l = 0; l < list.size(); ++l) {
                Entity entity = (Entity)list.get(l);
                if (entity == null || entity instanceof EntityTitanPart || entity instanceof EntityTitan || entity.isImmuneToFire()) continue;
                entity.onStruckByLightning(null);
                entity.setFire(100);
                entity.attackEntityFrom(DamageSourceExtra.lightningBolt, 49.0f);
                entity.hurtResistantTime = 0;
            }
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.onEntityUpdate();
    }

    @SideOnly(value=Side.CLIENT)
    public boolean isInRangeToRenderDist(double p_70112_1_) {
        return true;
    }

    protected void entityInit() {
        this.dataWatcher.addObject(15, (Object)Float.valueOf(1.0f));
        this.dataWatcher.addObject(16, (Object)Float.valueOf(1.0f));
        this.dataWatcher.addObject(17, (Object)Float.valueOf(1.0f));
    }

    public final float getRed() {
        return this.dataWatcher.getWatchableObjectFloat(15);
    }

    public void setRed(float p_70606_1_) {
        this.dataWatcher.updateObject(15, (Object)Float.valueOf(MathHelper.clamp_float((float)p_70606_1_, (float)0.0f, (float)1.0f)));
    }

    public final float getGreen() {
        return this.dataWatcher.getWatchableObjectFloat(16);
    }

    public void setGreen(float p_70606_1_) {
        this.dataWatcher.updateObject(16, (Object)Float.valueOf(MathHelper.clamp_float((float)p_70606_1_, (float)0.0f, (float)1.0f)));
    }

    public final float getBlue() {
        return this.dataWatcher.getWatchableObjectFloat(17);
    }

    public void setBlue(float p_70606_1_) {
        this.dataWatcher.updateObject(17, (Object)Float.valueOf(MathHelper.clamp_float((float)p_70606_1_, (float)0.0f, (float)1.0f)));
    }

    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
        this.setRed(p_70037_1_.getFloat("R"));
        this.setGreen(p_70037_1_.getFloat("G"));
        this.setBlue(p_70037_1_.getFloat("B"));
    }

    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
        p_70014_1_.setFloat("R", this.getRed());
        p_70014_1_.setFloat("G", this.getGreen());
        p_70014_1_.setFloat("B", this.getBlue());
    }
}

