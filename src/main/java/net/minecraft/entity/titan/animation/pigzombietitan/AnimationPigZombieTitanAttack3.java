/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.Vec3
 */
package net.minecraft.entity.titan.animation.pigzombietitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.util.Vec3;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationPigZombieTitanAttack3
extends AIAnimation {
    private EntityPigZombieTitan entity;

    public AnimationPigZombieTitanAttack3(EntityPigZombieTitan test) {
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
        return 230;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned || this.entity.worldObj.getBlock((int)this.entity.posX, (int)this.entity.posY - 1, (int)this.entity.posZ).getExplosionResistance((Entity)this.entity) <= 1.5f ? false : super.continueExecuting();
    }

    public void updateTask() {
        this.entity.renderYawOffset = this.entity.rotationYaw = this.entity.rotationYawHead;
        if (this.entity.getAnimTick() == 120) {
            this.entity.shakeNearbyPlayerCameras(20000.0);
            this.entity.playSound("thetitans:titanSlam", 100.0f, 1.0f);
            this.entity.playSound("thetitans:titanPress", 100.0f, 1.0f);
            double d8 = 36.0;
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
                    this.entity.attackChoosenEntity(entity1, f * 15.0f, i);
                }
            }
        }
    }
}

