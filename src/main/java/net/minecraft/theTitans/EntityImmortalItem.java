/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityImmortalItem
extends EntityItem {
    public EntityImmortalItem(World world, Entity original, ItemStack stack) {
        this(world, original.posX, original.posY, original.posZ, stack);
        this.delayBeforeCanPickup = 20;
        this.motionX = original.motionX;
        this.motionY = original.motionY;
        this.motionZ = original.motionZ;
        this.setEntityItemStack(stack);
        this.ignoreFrustumCheck = true;
    }

    public EntityImmortalItem(World world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z);
        this.setEntityItemStack(stack);
    }

    public EntityImmortalItem(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.isImmuneToFire = true;
    }

    public EntityImmortalItem(World world) {
        super(world);
        this.isImmuneToFire = true;
    }

    protected void dealFireDamage(int damage) {
    }

    public boolean isEntityInvulnerable() {
        return true;
    }

    public boolean attackEntityFrom(DamageSource source, float damage) {
        EntityPlayer player = this.worldObj.getClosestPlayerToEntity((Entity)this, -1.0);
        if (player != null) {
            this.delayBeforeCanPickup = 0;
            this.copyLocationAndAnglesFrom((Entity)player);
        }
        return false;
    }

    public void onUpdate() {
        ItemStack stack = this.getDataWatcher().getWatchableObjectItemStack(10);
        if (stack != null && stack.getItem() != null && stack.getItem().onEntityItemUpdate((EntityItem)this)) {
            return;
        }
        if (this.getEntityItem() == null) {
            this.setDead();
        } else {
            boolean flag;
            this.onEntityUpdate();
            if (this.delayBeforeCanPickup > 0) {
                --this.delayBeforeCanPickup;
            }
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            this.motionY -= (double)0.04f;
            this.noClip = this.func_145771_j(this.posX, (this.boundingBox.minY + this.boundingBox.maxY) / 2.0, this.posZ);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            boolean bl = flag = (int)this.prevPosX != (int)this.posX || (int)this.prevPosY != (int)this.posY || (int)this.prevPosZ != (int)this.posZ;
            if (flag || this.ticksExisted % 25 == 0) {
                if (this.worldObj.getBlock(MathHelper.floor_double((double)this.posX), MathHelper.floor_double((double)this.posY), MathHelper.floor_double((double)this.posZ)).getMaterial() == Material.lava) {
                    this.motionY = 0.2f;
                    this.motionX = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
                    this.motionZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
                    this.playSound("random.fizz", 0.4f, 2.0f + this.rand.nextFloat() * 0.4f);
                }
                if (!this.worldObj.isRemote) {
                    this.searchForOtherItemsNearby2();
                }
            }
            float f = 0.98f;
            if (this.onGround) {
                f = this.worldObj.getBlock((int)MathHelper.floor_double((double)this.posX), (int)(MathHelper.floor_double((double)this.boundingBox.minY) - 1), (int)MathHelper.floor_double((double)this.posZ)).slipperiness * 0.98f;
            }
            this.motionX *= (double)f;
            this.motionY *= (double)0.98f;
            this.motionZ *= (double)f;
            if (this.onGround) {
                this.motionY *= -0.5;
            }
            ++this.age;
            ItemStack item = this.getDataWatcher().getWatchableObjectItemStack(10);
            if (!this.worldObj.isRemote && this.age >= this.lifespan && item == null) {
                this.setDead();
            }
            if (item != null && item.stackSize <= 0) {
                this.setDead();
            }
        }
    }

    private void searchForOtherItemsNearby2() {
        for (EntityItem entityitem : this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.boundingBox.expand(0.5, 0.0, 0.5))) {
            this.combineItems(entityitem);
        }
    }
}

