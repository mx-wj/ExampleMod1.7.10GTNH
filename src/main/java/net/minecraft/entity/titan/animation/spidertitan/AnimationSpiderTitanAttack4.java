/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 */
package net.minecraft.entity.titan.animation.spidertitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntitySpiderTitan;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationSpiderTitanAttack4
extends AIAnimation {
    private EntitySpiderTitan entity;

    public AnimationSpiderTitanAttack4(EntitySpiderTitan test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 4;
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
        if (this.entity.getAnimTick() < 20 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 180.0f, 40.0f);
            this.entity.renderYawOffset = this.entity.rotationYaw = this.entity.rotationYawHead;
        }
        if (this.entity.getAnimTick() == 20) {
            this.entity.playSound("thetitans:titanEnderColossusChomp", 5.0f, 1.1f);
        }
        if (this.entity.getAnimTick() == 26 && this.entity.getAttackTarget() != null) {
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.entity.getKnockbackAmount() * 2;
            this.entity.collideWithEntities(this.entity.head, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.head.boundingBox.expand(8.0, 8.0, 8.0)));
            this.entity.attackChoosenEntity((Entity)this.entity.getAttackTarget(), f, i);
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity.getAttackTarget(), this.entity.getAttackTarget().boundingBox.expand(8.0, 8.0, 8.0));
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

