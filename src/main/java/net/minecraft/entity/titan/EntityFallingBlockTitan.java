/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockFalling
 *  net.minecraft.block.ITileEntityProvider
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.Minecraft
 *  net.minecraft.crash.CrashReportCategory
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityFallingBlock
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFallingBlockTitan
extends EntityFallingBlock {
    private Block field_145811_e;
    public int field_145814_a;
    public int field_145812_b;
    public boolean field_145813_c = true;
    private boolean field_145808_f;
    private boolean field_145809_g;
    private int field_145815_h = 40;
    private float field_145816_i = 2.0f;
    public NBTTagCompound field_145810_d;

    public EntityFallingBlockTitan(World p_i1706_1_) {
        super(p_i1706_1_);
    }

    public EntityFallingBlockTitan(World p_i45318_1_, double p_i45318_2_, double p_i45318_4_, double p_i45318_6_, Block p_i45318_8_) {
        this(p_i45318_1_, p_i45318_2_, p_i45318_4_, p_i45318_6_, p_i45318_8_, 0);
    }

    public EntityFallingBlockTitan(World p_i45319_1_, double p_i45319_2_, double p_i45319_4_, double p_i45319_6_, Block p_i45319_8_, int p_i45319_9_) {
        super(p_i45319_1_);
        this.field_145811_e = p_i45319_8_;
        this.field_145814_a = p_i45319_9_;
        this.preventEntitySpawning = true;
        this.setSize(0.98f, 0.98f);
        this.yOffset = this.height / 2.0f;
        this.setPosition(p_i45319_2_, p_i45319_4_, p_i45319_6_);
        this.prevPosX = p_i45319_2_;
        this.prevPosY = p_i45319_4_;
        this.prevPosZ = p_i45319_6_;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void entityInit() {
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public void onUpdate() {
        this.field_145809_g = true;
        this.ignoreFrustumCheck = false;
        if (this.field_145811_e.getMaterial() == Material.air) {
            this.field_145811_e = Blocks.sand;
        } else {
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            ++this.field_145812_b;
            this.motionY -= (double)0.04f;
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)0.98f;
            this.motionY *= (double)0.98f;
            this.motionZ *= (double)0.98f;
            if (!this.worldObj.isRemote && this.field_145812_b > 40) {
                int i = MathHelper.floor_double((double)this.posX);
                int j = MathHelper.floor_double((double)this.posY);
                int k = MathHelper.floor_double((double)this.posZ);
                if (this.onGround) {
                    this.motionX *= (double)0.7f;
                    this.motionZ *= (double)0.7f;
                    this.motionY *= -0.5;
                    if (this.worldObj.getBlock(i, j, k) != Blocks.piston_extension) {
                        this.setDead();
                        if (!this.field_145808_f && this.worldObj.canPlaceEntityOnSide(this.field_145811_e, i, j, k, true, 1, (Entity)null, (ItemStack)null) && !BlockFalling.func_149831_e((World)this.worldObj, (int)i, (int)(j - 1), (int)k) && this.worldObj.setBlock(i, j, k, this.field_145811_e, this.field_145814_a, 3)) {
                            TileEntity tileentity;
                            Minecraft.getMinecraft().renderGlobal.spawnParticle("largeexplode", (double)i, (double)j, (double)k, 0.0, 0.0, 0.0);
                            Minecraft.getMinecraft().effectRenderer.addBlockDestroyEffects(i, j, k, this.field_145811_e, Block.getIdFromBlock((Block)this.field_145811_e) >> 12 & 0xFF);
                            if (this.worldObj.getClosestPlayerToEntity((Entity)this, 16.0) != null) {
                                this.playSound("thetitans:titanPress", 1.0f, 1.0f + this.rand.nextFloat() * 0.25f);
                            }
                            if (this.field_145811_e instanceof BlockFalling) {
                                ((BlockFalling)this.field_145811_e).func_149828_a(this.worldObj, i, j, k, this.field_145814_a);
                            }
                            if (this.field_145810_d != null && this.field_145811_e instanceof ITileEntityProvider && (tileentity = this.worldObj.getTileEntity(i, j, k)) != null) {
                                NBTTagCompound nbttagcompound = new NBTTagCompound();
                                tileentity.writeToNBT(nbttagcompound);
                                for (String s : this.field_145810_d.func_150296_c()) {
                                    NBTBase nbtbase = this.field_145810_d.getTag(s);
                                    if (s.equals("x") || s.equals("y") || s.equals("z")) continue;
                                    nbttagcompound.setTag(s, nbtbase.copy());
                                }
                                tileentity.readFromNBT(nbttagcompound);
                                tileentity.markDirty();
                            }
                        } else if (this.field_145813_c && this.field_145808_f) {
                            this.entityDropItem(new ItemStack(this.field_145811_e, 1, this.field_145811_e.damageDropped(this.field_145814_a)), 0.0f);
                        }
                    }
                } else if (!this.worldObj.isRemote && (j < 1 || j > 256) || this.field_145812_b > 1000) {
                    this.entityDropItem(new ItemStack(this.field_145811_e, 1, this.field_145811_e.damageDropped(this.field_145814_a)), 0.0f);
                    Minecraft.getMinecraft().renderGlobal.spawnParticle("largeexplode", (double)i, (double)j, (double)k, 0.0, 0.0, 0.0);
                    Minecraft.getMinecraft().effectRenderer.addBlockDestroyEffects(i, j, k, this.field_145811_e, Block.getIdFromBlock((Block)this.field_145811_e) >> 12 & 0xFF);
                    this.fall(this.field_145812_b);
                    if (this.worldObj.getClosestPlayerToEntity((Entity)this, 16.0) != null) {
                        this.playSound("thetitans:titanPress", 1.0f, 1.25f + this.rand.nextFloat() * 0.25f);
                    }
                    this.setDead();
                }
            }
        }
    }

    protected void fall(float p_70069_1_) {
        int i;
        if (this.field_145809_g && (i = MathHelper.ceiling_float_int((float)(p_70069_1_ - 1.0f))) > 0) {
            ArrayList arraylist = new ArrayList(this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(1.0, 1.0, 1.0)));
            boolean flag = this.field_145811_e == Blocks.anvil;
            DamageSource damagesource = flag ? DamageSource.anvil : DamageSource.fallingBlock;
            for (Entity entity : arraylist) {
                entity.hurtResistantTime = 0;
                entity.attackEntityFrom(damagesource, Math.min((float)MathHelper.floor_float((float)((float)i * this.field_145816_i)), (float)this.field_145815_h * 10.0f));
                if (this.field_145811_e != Blocks.fire) continue;
                entity.setFire(20);
            }
            if (flag && (double)this.rand.nextFloat() < (double)0.05f + (double)i * 0.05) {
                int j = this.field_145814_a >> 2;
                int k = this.field_145814_a & 3;
                if (++j > 2) {
                    this.field_145808_f = true;
                } else {
                    this.field_145814_a = k | j << 2;
                }
            }
        }
    }

    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
        p_70014_1_.setByte("Tile", (byte)Block.getIdFromBlock((Block)this.field_145811_e));
        p_70014_1_.setInteger("TileID", Block.getIdFromBlock((Block)this.field_145811_e));
        p_70014_1_.setByte("Data", (byte)this.field_145814_a);
        p_70014_1_.setByte("Time", (byte)this.field_145812_b);
        p_70014_1_.setBoolean("DropItem", this.field_145813_c);
        p_70014_1_.setBoolean("HurtEntities", this.field_145809_g);
        p_70014_1_.setFloat("FallHurtAmount", this.field_145816_i);
        p_70014_1_.setInteger("FallHurtMax", this.field_145815_h);
        if (this.field_145810_d != null) {
            p_70014_1_.setTag("TileEntityData", (NBTBase)this.field_145810_d);
        }
    }

    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
        this.field_145811_e = p_70037_1_.hasKey("TileID", 99) ? Block.getBlockById((int)p_70037_1_.getInteger("TileID")) : Block.getBlockById((int)(p_70037_1_.getByte("Tile") & 0xFF));
        this.field_145814_a = p_70037_1_.getByte("Data") & 0xFF;
        this.field_145812_b = p_70037_1_.getByte("Time") & 0xFF;
        if (p_70037_1_.hasKey("HurtEntities", 99)) {
            this.field_145809_g = p_70037_1_.getBoolean("HurtEntities");
            this.field_145816_i = p_70037_1_.getFloat("FallHurtAmount");
            this.field_145815_h = p_70037_1_.getInteger("FallHurtMax");
        } else if (this.field_145811_e == Blocks.anvil) {
            this.field_145809_g = true;
        }
        if (p_70037_1_.hasKey("DropItem", 99)) {
            this.field_145813_c = p_70037_1_.getBoolean("DropItem");
        }
        if (p_70037_1_.hasKey("TileEntityData", 10)) {
            this.field_145810_d = p_70037_1_.getCompoundTag("TileEntityData");
        }
        if (this.field_145811_e.getMaterial() == Material.air) {
            this.field_145811_e = Blocks.sand;
        }
    }

    public void func_145806_a(boolean p_145806_1_) {
        this.field_145809_g = p_145806_1_;
    }

    public void addEntityCrashInfo(CrashReportCategory p_85029_1_) {
        super.addEntityCrashInfo(p_85029_1_);
        p_85029_1_.addCrashSection("Immitating block ID", (Object)Block.getIdFromBlock((Block)this.field_145811_e));
        p_85029_1_.addCrashSection("Immitating block data", (Object)this.field_145814_a);
    }

    @SideOnly(value=Side.CLIENT)
    public float getShadowSize() {
        return 0.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public World func_145807_e() {
        return this.worldObj;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean canRenderOnFire() {
        return false;
    }

    public Block func_145805_f() {
        return this.field_145811_e;
    }
}

