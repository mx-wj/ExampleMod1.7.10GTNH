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

public class AnimationIronGolemTitanAttack3
extends AIAnimation {
    private EntityIronGolemTitan entity;

    public AnimationIronGolemTitanAttack3(EntityIronGolemTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 8;
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
        return this.entity.animTick > 60 ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAnimTick() < 24 && this.entity.getAttackTarget() != null) {
            this.entity.faceEntity((Entity)this.entity.getAttackTarget(), 180.0f, 180.0f);
        }
        if (this.entity.getAnimTick() == 26) {
            this.entity.playSound("thetitans:titanSwing", 100.0f, 1.0f);
            this.entity.playSound("mob.irongolem.throw", 100.0f, 0.5f);
            this.entity.playSound("mob.irongolem.throw", 100.0f, 0.5f);
        }
        if (this.entity.getAnimTick() == 28 && this.entity.getAttackTarget() != null) {
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.entity.getKnockbackAmount();
            this.entity.attackEntityAsMob((Entity)this.entity.getAttackTarget());
            this.entity.attackChoosenEntity((Entity)this.entity.getAttackTarget(), f, i);
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity.getAttackTarget(), this.entity.getAttackTarget().boundingBox.expand(6.0, 2.0, 6.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    this.entity.attackChoosenEntity(entity1, f, i);
                }
            }
        }
    }
}

