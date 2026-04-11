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

public class AnimationGargoyleTitanAntiTitanAttack
extends AIAnimation {
    private EntityGargoyleTitan entity;

    public AnimationGargoyleTitanAntiTitanAttack(EntityGargoyleTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 1;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 30;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > 30 ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 12 && this.entity.getAttackTarget() != null) {
            this.entity.shakeNearbyPlayerCameras(20000.0);
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.entity.getKnockbackAmount();
            this.entity.attackChoosenEntity((Entity)this.entity.getAttackTarget(), f, i);
            this.entity.attackChoosenEntity((Entity)this.entity.getAttackTarget(), f, i);
            this.entity.attackChoosenEntity((Entity)this.entity.getAttackTarget(), f, i);
            this.entity.attackChoosenEntity((Entity)this.entity.getAttackTarget(), f, i);
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity.getAttackTarget(), this.entity.getAttackTarget().boundingBox.expand(8.0, 8.0, 8.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    this.entity.attackChoosenEntity(entity1, f, i);
                    this.entity.attackChoosenEntity(entity1, f, i);
                }
            }
        }
    }
}

