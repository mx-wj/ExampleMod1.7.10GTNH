/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.storage.WorldInfo
 */
package net.minecraft.entity.titan.animation.endercolossus;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import thehippomaster.AnimationAPI.AIAnimation;

public class AnimationEnderColossusScream
extends AIAnimation {
    private EntityEnderColossus entity;

    public AnimationEnderColossusScream(EntityEnderColossus test) {
        super(test);
        this.entity = test;
    }

    @Override
    public int getAnimID() {
        return 5;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public int getDuration() {
        return 200;
    }

    @Override
    public boolean continueExecuting() {
        return this.entity.animTick > this.getDuration() || this.entity.isStunned ? false : super.continueExecuting();
    }

    public void updateTask() {
        if (this.entity.getAnimTick() > 200) {
            this.entity.setAttackTarget(null);
        }
        if (this.entity.getAnimTick() < 60 && this.entity.getAttackTarget() != null) {
            this.entity.getLookHelper().setLookPositionWithEntity((Entity)this.entity.getAttackTarget(), 5.0f, 40.0f);
        }
        if (this.entity.getAnimTick() > 80) {
            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
            WorldInfo worldinfo = worldserver.getWorldInfo();
            worldinfo.setRainTime(0);
            worldinfo.setThunderTime(0);
            worldinfo.setRaining(false);
            worldinfo.setThundering(false);
            this.entity.setScreaming(false);
            this.entity.collideWithEntities(this.entity.body, this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.body.boundingBox.expand(16.0, 8.0, 16.0)));
            List list11 = this.entity.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this.entity, this.entity.boundingBox.expand(256.0, 256.0, 256.0));
            if (list11 != null && !list11.isEmpty()) {
                for (int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (!this.entity.canAttackClass(entity1.getClass())) continue;
                    this.entity.attackChoosenEntity(entity1, this.entity.getAnimTick(), 0);
                    this.entity.attackChoosenEntity(entity1, this.entity.getAnimTick(), 0);
                    this.entity.attackChoosenEntity(entity1, this.entity.getAnimTick(), 0);
                    this.entity.attackChoosenEntity(entity1, 1.0E7f, 0);
                    entity1.motionX = 0.0;
                    entity1.motionZ = 0.0;
                    entity1.rotationPitch += 1.0f;
                    if (!(entity1 instanceof EntityLivingBase)) continue;
                    ((EntityLivingBase)entity1).addPotionEffect(new PotionEffect(Potion.confusion.id, 400, 1));
                    ((EntityLivingBase)entity1).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 400, 99));
                    ((EntityLivingBase)entity1).addPotionEffect(new PotionEffect(Potion.blindness.id, 400, 1));
                }
            }
        }
        if (this.entity.getAnimTick() == 80) {
            this.entity.playSound("thetitans:titanEnderColossusScreamLong", Float.MAX_VALUE, 1.0f);
        }
    }
}

