/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.util.Vec3
 */
package net.minecraft.entity.titan.animation.spidertitan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.util.Vec3;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationSpiderTitanShootLightning
extends AIAnimation {
    private EntitySpiderTitan entity;

    public AnimationSpiderTitanShootLightning(EntitySpiderTitan test) {
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
        return 140;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() == 68) {
            this.entity.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.entity.worldObj, this.entity.posX, this.entity.posY + 3.0, this.entity.posZ, 0.6f, 0.1f, 0.2f));
        }
        if (this.entity.getAnimTick() == 68 && this.entity.getAttackTarget() != null) {
            double d8 = -2.0;
            Vec3 vec3 = this.entity.getLook(1.0f);
            double dx = vec3.xCoord * d8;
            double dz = vec3.zCoord * d8;
            float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
            int i = this.entity.getKnockbackAmount();
            this.entity.attackChoosenEntity((Entity)this.entity.getAttackTarget(), f, i);
            this.entity.getAttackTarget().motionY += 2.0;
            net.minecraft.theTitans.util.FastExplosion.newExplosion(this.entity.worldObj, (Entity)this.entity, this.entity.getAttackTarget().posX, this.entity.getAttackTarget().posY, this.entity.getAttackTarget().posZ, 2.0f, false, false);
            net.minecraft.theTitans.util.FastExplosion.newExplosion(this.entity.worldObj, (Entity)this.entity, this.entity.posX + dx, this.entity.posY + 8.0, this.entity.posZ + dz, 1.0f, false, false);
            this.entity.getAttackTarget().attackEntityFrom(DamageSourceExtra.lightningBolt, f);
            this.entity.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.entity.worldObj, this.entity.posX + dx, this.entity.posY + 3.0, this.entity.posZ + dz, 0.6f, 0.1f, 0.2f));
            this.entity.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.entity.worldObj, this.entity.getAttackTarget().posX, this.entity.getAttackTarget().posY, this.entity.getAttackTarget().posZ, 0.6f, 0.1f, 0.2f));
            List list1 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity.getAttackTarget(), this.entity.getAttackTarget().boundingBox.expand(6.0, 3.0, 6.0));
            if (list1 != null && !list1.isEmpty()) {
                for (int i1 = 0; i1 < list1.size(); ++i1) {
                    Entity entity1 = (Entity)list1.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    net.minecraft.theTitans.util.FastExplosion.newExplosion(this.entity.worldObj, (Entity)this.entity, entity1.posX, entity1.posY, entity1.posZ, 2.0f, false, false);
                    this.entity.attackChoosenEntity(entity1, f, i);
                    entity1.attackEntityFrom(DamageSourceExtra.lightningBolt, f);
                    this.entity.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.entity.worldObj, entity1.posX, entity1.posY, entity1.posZ));
                }
            }
        }
    }
}

