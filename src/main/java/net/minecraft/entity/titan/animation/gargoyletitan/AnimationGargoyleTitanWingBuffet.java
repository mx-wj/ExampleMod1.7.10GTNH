/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 */
package net.minecraft.entity.titan.animation.gargoyletitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityGargoyleTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationGargoyleTitanWingBuffet
extends AIAnimation {
    private EntityGargoyleTitan entity;

    public AnimationGargoyleTitanWingBuffet(EntityGargoyleTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 2;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 140;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 140 ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 16) {
            this.entity.addTitanVelocity(-MathHelper.sin((float)(this.entity.renderYawOffset * (float)Math.PI / 180.0f)) * -5.0f, 1.0, MathHelper.cos((float)(this.entity.renderYawOffset * (float)Math.PI / 180.0f)) * -5.0f);
            double d8 = 24.0;
            Vec3 vec3 = this.entity.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.entity.getKnockbackAmount();
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(64.0, 16.0, 64.0).offset(dx, 0.0, dz));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    entity1.motionY += this.entity.getRNG().nextDouble();
                    if (entity1 instanceof EntityTitan) {
                        ((EntityTitan)entity1).addTitanVelocity(-MathHelper.sin((float)(this.entity.renderYawOffset * (float)Math.PI / 180.0f)) * 15.0f, 2.0, MathHelper.cos((float)(this.entity.renderYawOffset * (float)Math.PI / 180.0f)) * 15.0f);
                    }
                    entity1.addVelocity((double)(-MathHelper.sin((float)(this.entity.renderYawOffset * (float)Math.PI / 180.0f)) * 15.0f), 2.0, (double)(MathHelper.cos((float)(this.entity.renderYawOffset * (float)Math.PI / 180.0f)) * 15.0f));
                }
            }
        }
    }
}

