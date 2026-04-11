/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.DamageSource
 */
package net.minecraft.theTitans;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.potion.Potion;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.util.DamageSource;

public class TitanPotions
extends Potion {
    protected TitanPotions(int p_i1573_1_, boolean p_i1573_2_, int p_i1573_3_) {
        super(p_i1573_1_, p_i1573_2_, p_i1573_3_);
    }

    public Potion setIconIndex(int p_76399_1_, int p_76399_2_) {
        super.setIconIndex(p_76399_1_, p_76399_2_);
        return this;
    }

    public boolean isBadEffect() {
        return true;
    }

    public boolean isReady(int p_76397_1_, int p_76397_2_) {
        if (this.id == ClientProxy.creeperTitanRadiation.id) {
            int k = 20 >> p_76397_2_;
            return k > 0 ? p_76397_1_ % k == 0 : true;
        }
        if (this.id == ClientProxy.advancedWither.id) {
            int k = 20 >> p_76397_2_;
            return k > 0 ? p_76397_1_ % k == 0 : true;
        }
        if (this.id == ClientProxy.electricJudgment.id) {
            int k = 60 >> p_76397_2_;
            return k > 0 ? p_76397_1_ % k == 0 : true;
        }
        if (this.id == ClientProxy.death.id) {
            int k = 40 >> p_76397_2_;
            return k > 0 ? p_76397_1_ % k == 0 : true;
        }
        return super.isReady(p_76397_1_, p_76397_2_);
    }

    public void performEffect(EntityLivingBase p_76394_1_, int p_76394_2_) {
        if (p_76394_1_.isEntityAlive() && this.id == ClientProxy.electricJudgment.id) {
            if (!p_76394_1_.worldObj.isRemote && p_76394_1_.isEntityAlive()) {
                p_76394_1_.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(p_76394_1_.worldObj, p_76394_1_.posX - 0.5, p_76394_1_.posY, p_76394_1_.posZ - 0.5));
            }
            p_76394_1_.attackEntityFrom(DamageSourceExtra.lightningBolt, 5.0f * (float)p_76394_2_);
            p_76394_1_.setFire(20);
            if (p_76394_1_.getMaxHealth() > 1.0E9f && !(p_76394_1_ instanceof EntityTitanSpirit) && !(p_76394_1_ instanceof EntityTitan) && !(p_76394_1_ instanceof EntityPlayer)) {
                p_76394_1_.playSound("random.explode", 2.0f, 1.0f + p_76394_1_.getRNG().nextFloat());
                p_76394_1_.setHealth(p_76394_1_.getHealth() / 2.0f);
                if (p_76394_1_.getHealth() <= 1.0f) {
                    p_76394_1_.worldObj.createExplosion(null, p_76394_1_.posX, p_76394_1_.posY, p_76394_1_.posZ, 7.0f, false);
                    p_76394_1_.setDead();
                }
            }
        }
        if (p_76394_1_.isEntityAlive() && this.id == ClientProxy.death.id) {
            p_76394_1_.attackEntityFrom(DamageSourceExtra.outOfWorld, 4.0f * (float)p_76394_2_);
            p_76394_1_.setFire(20);
            if (p_76394_1_.deathTime > 0) {
                ++p_76394_1_.deathTime;
                if (p_76394_1_.deathTime > 20) {
                    p_76394_1_.setDead();
                }
            }
            if (p_76394_1_.getMaxHealth() > 1.0E9f && !(p_76394_1_ instanceof EntityTitanSpirit) && !(p_76394_1_ instanceof EntityTitan) && !(p_76394_1_ instanceof EntityPlayer)) {
                p_76394_1_.playSound("random.explode", 2.0f, 1.0f + p_76394_1_.getRNG().nextFloat());
                p_76394_1_.setHealth(p_76394_1_.getHealth() / 2.0f);
                if (p_76394_1_.getHealth() <= 1.0f) {
                    p_76394_1_.worldObj.createExplosion(null, p_76394_1_.posX, p_76394_1_.posY, p_76394_1_.posZ, 7.0f, false);
                    p_76394_1_.setDead();
                }
            }
        }
        if (this.id == ClientProxy.creeperTitanRadiation.id) {
            p_76394_1_.attackEntityFrom(DamageSourceExtra.radiation, 2.0f * (float)p_76394_2_);
            p_76394_1_.worldObj.playSound(p_76394_1_.posX, p_76394_1_.posY, p_76394_1_.posZ, "game.player.hurt", 2.0f, 2.0f, false);
        }
        if (this.id == ClientProxy.advancedWither.id) {
            p_76394_1_.hurtResistantTime = 0;
            p_76394_1_.attackEntityFrom(new DamageSource("advancedwither").setDamageBypassesArmor().setDamageIsAbsolute().setDamageAllowedInCreativeMode(), 2.0f * (float)p_76394_2_);
        }
        super.performEffect(p_76394_1_, p_76394_2_);
    }
}

