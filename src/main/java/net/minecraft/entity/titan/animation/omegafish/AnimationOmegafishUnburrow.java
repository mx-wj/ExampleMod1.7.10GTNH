/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.MathHelper
 */
package net.minecraft.entity.titan.animation.omegafish;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationOmegafishUnburrow
extends AIAnimation {
    private EntitySilverfishTitan entity;

    public AnimationOmegafishUnburrow(EntitySilverfishTitan test) {
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
        return 70;
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
        if (this.entity.getAnimTick() == 10) {
            this.entity.playSound("thetitans:quickApperence", 20.0f, 1.0f);
            this.entity.destroyBlocksInAABB(this.entity.boundingBox.offset(0.0, -2.0, 0.0));
            this.entity.addVelocity(-MathHelper.sin((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * 0.75f, 1.0, MathHelper.cos((float)(this.entity.rotationYawHead * (float)Math.PI / 180.0f)) * 0.75f);
            list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(16.0, 16.0, 16.0));
            if (list11 != null && !list11.isEmpty()) {
                for (i1 = 0; i1 < list11.size(); ++i1) {
                    entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    i = this.entity.getKnockbackAmount();
                    this.entity.attackChoosenEntity(entity1, f, i);
                    this.entity.collideWithEntities(this.entity.body, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.body.boundingBox.expand(32.0, 16.0, 32.0)));
                    this.entity.collideWithEntities(this.entity.body, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.body.boundingBox.expand(32.0, 16.0, 32.0)));
                }
            }
        }
        if (this.entity.getAnimTick() == 45) {
            this.entity.playSound("thetitans:groundSmash", 20.0f, 1.25f);
            list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(16.0, 16.0, 16.0));
            if (list11 != null && !list11.isEmpty()) {
                for (i1 = 0; i1 < list11.size(); ++i1) {
                    entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    i = this.entity.getKnockbackAmount() * 3;
                    this.entity.attackChoosenEntity(entity1, f, i);
                    this.entity.collideWithEntities(this.entity.body, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.body.boundingBox.expand(32.0, 16.0, 32.0)));
                }
            }
        }
    }
}

