/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 */
package net.minecraft.entity.titan.animation.ultimairongolemtitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationIronGolemTitanAttack4
extends AIAnimation {
    private EntityIronGolemTitan entity;

    public AnimationIronGolemTitanAttack4(EntityIronGolemTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 9;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 90;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 90 ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAnimTick() < 40 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 44) {
            this.entity.playSound("thetitans:titanSwing", 100.0f, 1.0f);
            this.entity.playSound("mob.irongolem.throw", 100.0f, 0.5f);
        }
        if (this.entity.getAnimTick() == 48) {
            this.entity.shakeNearbyPlayerCameras(20000.0);
            double d8 = 24.0;
            Vec3 vec3 = this.entity.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.entity.getKnockbackAmount();
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(32.0, 4.0, 32.0).offset(dx, -2.0, dz));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    this.entity.attackEntityAsMob(entity1);
                    entity1.addVelocity((double)(-MathHelper.sin((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * 3.0f), 0.0, (double)(MathHelper.cos((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * 3.0f));
                }
            }
            this.entity.playSound("thetitans:titanSlam", 20.0f, 1.0f);
            this.entity.playSound("thetitans:titanStep", 20.0f, 1.0f);
            this.entity.playSound("thetitans:titanStep", 20.0f, 1.0f);
            this.entity.playSound("thetitans:titanStep", 20.0f, 1.0f);
            this.entity.playSound("thetitans:titanStep", 20.0f, 1.0f);
        }
    }
}

