/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.ai.EntityAITarget
 *  net.minecraft.village.Village
 */
package net.minecraft.entity.titan.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.titan.EntityGargoyle;
import net.minecraft.village.Village;

public class EntityAIDefendVillage
extends EntityAITarget {
    EntityGargoyle irongolem;
    EntityLivingBase villageAgressorTarget;
    private static final String __OBFID = "CL_00001618";

    public EntityAIDefendVillage(EntityGargoyle p_i1659_1_) {
        super((EntityCreature)p_i1659_1_, false, true);
        this.irongolem = p_i1659_1_;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        Village village = this.irongolem.getVillage();
        if (village == null) {
            return false;
        }
        this.villageAgressorTarget = village.findNearestVillageAggressor((EntityLivingBase)this.irongolem);
        if (!this.isSuitableTarget(this.villageAgressorTarget, false)) {
            if (this.taskOwner.getRNG().nextInt(20) == 0) {
                this.villageAgressorTarget = village.func_82685_c((EntityLivingBase)this.irongolem);
                return this.isSuitableTarget(this.villageAgressorTarget, false);
            }
            return false;
        }
        return true;
    }

    public void startExecuting() {
        this.irongolem.setAttackTarget(this.villageAgressorTarget);
        super.startExecuting();
    }
}

