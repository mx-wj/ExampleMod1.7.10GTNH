/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 */
package net.minecraft.entity.titan.animation.omegafish;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationOmegafishAttack2
extends AIAnimation {
    private EntitySilverfishTitan entity;

    public AnimationOmegafishAttack2(EntitySilverfishTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 5;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 60;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        int i;
        float f;
        Entity entity1;
        int i1;
        List list11;
        double dz;
        double dx;
        Vec3 vec3;
        double d8;
        if (this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 24) {
            this.entity.playSound("thetitans:titanSwing", 10.0f, 1.75f);
            d8 = 4.0;
            vec3 = this.entity.getLook(1.0f);
            dx = vec3.xCoord * d8;
            dz = vec3.zCoord * d8;
            list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(1.0, 1.0, 1.0).offset(dx, 0.0, dz));
            if (list11 != null && !list11.isEmpty()) {
                for (i1 = 0; i1 < list11.size(); ++i1) {
                    entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    entity1.worldObj.playSoundEffect(this.entity.posX + dx, this.entity.posY, this.entity.posZ + dz, "random.explode", 4.0f, (1.0f + (this.entity.worldObj.rand.nextFloat() - this.entity.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
                    f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    i = this.entity.getKnockbackAmount();
                    this.entity.attackChoosenEntity(entity1, f * 2.0f, i);
                    if (!(entity1 instanceof EntityTitan || entity1 instanceof EntitySnowGolemTitan || entity1 instanceof EntityIronGolemTitan)) {
                        entity1.addVelocity((double)(-MathHelper.sin((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * (float)i), (double)i * 0.5, (double)(MathHelper.cos((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * (float)i));
                    }
                    if (this.entity.getRNG().nextInt(3) != 0) continue;
                    entity1.setFire(20);
                }
            }
        }
        if (this.entity.getAnimTick() == 26) {
            d8 = 8.0;
            vec3 = this.entity.getLook(1.0f);
            dx = vec3.xCoord * d8;
            dz = vec3.zCoord * d8;
            list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(1.0, 1.0, 1.0).offset(dx, 0.0, dz));
            if (list11 != null && !list11.isEmpty()) {
                for (i1 = 0; i1 < list11.size(); ++i1) {
                    entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    entity1.worldObj.playSoundEffect(this.entity.posX + dx, this.entity.posY, this.entity.posZ + dz, "random.explode", 4.0f, (1.0f + (this.entity.worldObj.rand.nextFloat() - this.entity.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
                    f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    i = this.entity.getKnockbackAmount();
                    this.entity.attackChoosenEntity(entity1, f * 2.0f, i);
                    if (!(entity1 instanceof EntityTitan || entity1 instanceof EntitySnowGolemTitan || entity1 instanceof EntityIronGolemTitan)) {
                        entity1.addVelocity((double)(-MathHelper.sin((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * (float)i), (double)i * 0.5, (double)(MathHelper.cos((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * (float)i));
                    }
                    if (this.entity.getRNG().nextInt(3) != 0) continue;
                    entity1.setFire(20);
                }
            }
        }
        if (this.entity.getAnimTick() == 28) {
            d8 = 12.0;
            vec3 = this.entity.getLook(1.0f);
            dx = vec3.xCoord * d8;
            dz = vec3.zCoord * d8;
            list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(1.0, 1.0, 1.0).offset(dx, 0.0, dz));
            if (list11 != null && !list11.isEmpty()) {
                for (i1 = 0; i1 < list11.size(); ++i1) {
                    entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    entity1.worldObj.playSoundEffect(this.entity.posX + dx, this.entity.posY, this.entity.posZ + dz, "random.explode", 4.0f, (1.0f + (this.entity.worldObj.rand.nextFloat() - this.entity.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
                    f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    i = this.entity.getKnockbackAmount();
                    this.entity.attackChoosenEntity(entity1, f * 2.0f, i);
                    if (!(entity1 instanceof EntityTitan || entity1 instanceof EntitySnowGolemTitan || entity1 instanceof EntityIronGolemTitan)) {
                        entity1.addVelocity((double)(-MathHelper.sin((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * (float)i), (double)i * 0.5, (double)(MathHelper.cos((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * (float)i));
                    }
                    if (this.entity.getRNG().nextInt(3) != 0) continue;
                    entity1.setFire(20);
                }
            }
        }
        if (this.entity.getAnimTick() == 30) {
            d8 = 16.0;
            vec3 = this.entity.getLook(1.0f);
            dx = vec3.xCoord * d8;
            dz = vec3.zCoord * d8;
            list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(1.0, 1.0, 1.0).offset(dx, 0.0, dz));
            if (list11 != null && !list11.isEmpty()) {
                for (i1 = 0; i1 < list11.size(); ++i1) {
                    entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    entity1.worldObj.playSoundEffect(this.entity.posX + dx, this.entity.posY, this.entity.posZ + dz, "random.explode", 4.0f, (1.0f + (this.entity.worldObj.rand.nextFloat() - this.entity.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
                    f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    i = this.entity.getKnockbackAmount();
                    this.entity.attackChoosenEntity(entity1, f * 2.0f, i);
                    if (!(entity1 instanceof EntityTitan || entity1 instanceof EntitySnowGolemTitan || entity1 instanceof EntityIronGolemTitan)) {
                        entity1.addVelocity((double)(-MathHelper.sin((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * (float)i), (double)i * 0.5, (double)(MathHelper.cos((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * (float)i));
                    }
                    if (this.entity.getRNG().nextInt(3) != 0) continue;
                    entity1.setFire(20);
                }
            }
        }
    }
}

