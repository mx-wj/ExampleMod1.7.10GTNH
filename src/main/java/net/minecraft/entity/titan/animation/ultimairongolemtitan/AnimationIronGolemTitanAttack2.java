/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 */
package net.minecraft.entity.titan.animation.ultimairongolemtitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationIronGolemTitanAttack2
extends AIAnimation {
    private EntityIronGolemTitan entity;

    public AnimationIronGolemTitanAttack2(EntityIronGolemTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 7;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 150;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 150 ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAnimTick() < 60 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 60 || this.entity.getAnimTick() == 104) {
            this.entity.shakeNearbyPlayerCameras(20000.0);
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            boolean i = false;
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(48.0, 16.0, 48.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    entity1.motionY += 2.0 + this.entity.getRNG().nextDouble() + this.entity.getRNG().nextDouble();
                    this.entity.attackEntityAsMob(entity1);
                }
            }
            this.entity.playSound("thetitans:titanSlam", 20.0f, 1.0f);
        }
    }
}

