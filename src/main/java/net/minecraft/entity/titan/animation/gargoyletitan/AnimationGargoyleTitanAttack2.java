/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 */
package net.minecraft.entity.titan.animation.gargoyletitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityGargoyleTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationGargoyleTitanAttack2
extends AIAnimation {
    private EntityGargoyleTitan entity;

    public AnimationGargoyleTitanAttack2(EntityGargoyleTitan test) {
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
            int i = 0;
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(32.0, 8.0, 32.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    entity1.motionY += (double)(1.0f + this.entity.getRNG().nextFloat() + this.entity.getRNG().nextFloat());
                    this.entity.attackChoosenEntity(entity1, f, i);
                }
            }
            this.entity.playSound("thetitans:titanSlam", 20.0f, 1.0f);
        }
    }
}

