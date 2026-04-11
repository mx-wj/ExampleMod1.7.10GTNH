/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.Vec3
 */
package net.minecraft.entity.titan.animation.zombietitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.util.Vec3;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationZombieTitanReformSword
extends AIAnimation {
    private EntityZombieTitan entity;

    public AnimationZombieTitanReformSword(EntityZombieTitan test) {
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
        return 210;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAnimTick() == 160) {
            this.entity.setArmed(true);
            this.entity.playSound("thetitans:titansummonminion", 10.0f, 0.5f);
        }
        if (this.entity.getAnimTick() == 50) {
            this.entity.shakeNearbyPlayerCameras(20000.0);
            this.entity.playSound("thetitans:titanRumble", 10.0f, 1.0f);
            this.entity.playSound("thetitans:titanQuake", 10.0f, 1.0f);
            double d8 = 8.0;
            Vec3 vec3 = this.entity.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.entity.getKnockbackAmount();
            this.entity.collideWithEntities(this.entity.body, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.body.boundingBox.expand(16.0, 8.0, 16.0)));
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(32.0, 2.0, 32.0).offset(dx, 0.0, dz));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    this.entity.attackChoosenEntity(entity1, f, i);
                }
            }
            this.entity.playSound("thetitans:titanStrike", 20.0f, 1.0f);
        }
    }
}

