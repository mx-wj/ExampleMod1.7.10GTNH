/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityHomingWitherSkull;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityChaff
extends Entity {
    public int lifespan;

    public EntityChaff(World worldIn) {
        super(worldIn);
        this.setSize(1.0f, 1.0f);
        this.preventEntitySpawning = true;
    }

    protected void entityInit() {
        this.dataWatcher.addObject(8, (Object)this.lifespan);
    }

    protected void readEntityFromNBT(NBTTagCompound tagCompund) {
    }

    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
    }

    public void onUpdate() {
        List list;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.dataWatcher.updateObject(8, (Object)this.lifespan);
        int i = MathHelper.floor_double((double)this.posX);
        int j = MathHelper.floor_double((double)this.posY);
        int k = MathHelper.floor_double((double)this.posZ);
        float f = (this.rand.nextFloat() - 0.5f) * 16.0f;
        float f1 = (this.rand.nextFloat() - 0.5f) * 16.0f;
        float f2 = (this.rand.nextFloat() - 0.5f) * 16.0f;
        this.worldObj.spawnParticle("smoke", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        this.worldObj.spawnParticle("explode", this.posX + (double)f, this.posY + 2.0 + (double)f1, this.posZ + (double)f2, 0.0, 0.0, 0.0);
        ++this.lifespan;
        if (this.lifespan == 1) {
            this.playSound("thetitans:chaffDeployment", 5.0f, 1.0f);
        }
        if (this.lifespan == 300) {
            this.setDead();
        }
        if ((list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(24.0, 24.0, 24.0))) != null && !list.isEmpty()) {
            for (int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity = (Entity)list.get(i1);
                if (!(entity instanceof EntityHomingWitherSkull) || entity == null) continue;
                ((EntityHomingWitherSkull)entity).assginedEntity = null;
            }
        }
    }

    protected void collideWithNearbyEntities() {
    }
}

