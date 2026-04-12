/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.Vec3
 */
package net.minecraft.entity.titan.animation.creepertitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.util.Vec3;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationCreeperTitanThunderClap
extends AIAnimation {
    private EntityCreeperTitan entity;

    public AnimationCreeperTitanThunderClap(EntityCreeperTitan test) {
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
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        Entity entity1;
        int i1;
        List list11;
        int i;
        float f;
        double dz;
        double dx;
        Vec3 vec3;
        double d8;
        if (this.entity.getAnimTick() < 100 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 100) {
            if (this.entity.getAttackTarget() != null) {
                this.entity.doLightningAttackToEntity((Entity)this.entity.getAttackTarget());
            }
            d8 = 12.0;
            vec3 = this.entity.getLook(1.0f);
            dx = vec3.xCoord * d8;
            dz = vec3.zCoord * d8;
            net.minecraft.theTitans.util.FastExplosion.newExplosion(this.entity.worldObj, (Entity)this.entity, this.entity.posX + dx, this.entity.posY + 10.0, this.entity.posZ + dz, 3.0f, false, false);
            f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            i = this.entity.getKnockbackAmount();
            this.entity.shakeNearbyPlayerCameras(20000.0);
            this.entity.playSound("thetitans:titanStrike", 20.0f, 1.1f);
            this.entity.collideWithEntities(this.entity.head, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.head.boundingBox.expand(16.0, 2.0, 16.0)));
            list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(32.0, 2.0, 32.0).offset(dx, 0.0, dz));
            if (list11 != null && !list11.isEmpty()) {
                for (i1 = 0; i1 < list11.size(); ++i1) {
                    entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    this.entity.attackChoosenEntity(entity1, f * 2.0f, i);
                }
            }
        }
        if (this.entity.getAnimTick() == 150) {
            d8 = 12.0;
            vec3 = this.entity.getLook(1.0f);
            dx = vec3.xCoord * d8;
            dz = vec3.zCoord * d8;
            f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            i = 0;
            this.entity.collideWithEntities(this.entity.body, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.body.boundingBox.expand(16.0, 8.0, 16.0)));
            this.entity.shakeNearbyPlayerCameras(20000.0);
            list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(32.0, 2.0, 32.0).offset(dx, 0.0, dz));
            if (list11 != null && !list11.isEmpty()) {
                for (i1 = 0; i1 < list11.size(); ++i1) {
                    entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    entity1.motionY += (double)(1.0f + this.entity.getRNG().nextFloat() + this.entity.getRNG().nextFloat());
                    this.entity.attackChoosenEntity(entity1, f * 2.0f, i);
                    this.entity.attackChoosenEntity(entity1, f * 2.0f, i);
                }
            }
            this.entity.playSound("thetitans:titanSlam", 20.0f, 1.0f);
            this.entity.playSound("thetitans:groundSmash", 20.0f, 1.0f);
        }
    }
}

