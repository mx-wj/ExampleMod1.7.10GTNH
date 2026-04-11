/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.RandomPositionGenerator
 *  net.minecraft.util.Vec3
 */
package net.minecraft.entity.titan.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class EntityAITitanWander
extends EntityAIBase {
    private EntityCreature entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;
    private int randTimer;
    private boolean field_179482_g;

    public EntityAITitanWander(EntityCreature p_i1648_1_, double p_i1648_2_) {
        this(p_i1648_1_, p_i1648_2_, 120);
    }

    public EntityAITitanWander(EntityCreature p_i45887_1_, double p_i45887_2_, int p_i45887_4_) {
        this.entity = p_i45887_1_;
        this.speed = p_i45887_2_;
        this.randTimer = p_i45887_4_;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (!this.field_179482_g && this.entity.getRNG().nextInt(this.randTimer) != 0) {
            return false;
        }
        Vec3 vec3 = RandomPositionGenerator.findRandomTarget((EntityCreature)this.entity, (int)64, (int)5);
        if (vec3 == null) {
            return false;
        }
        this.xPosition = vec3.xCoord;
        this.yPosition = vec3.yCoord;
        this.zPosition = vec3.zCoord;
        this.field_179482_g = false;
        return true;
    }

    public boolean continueExecuting() {
        return !this.entity.getNavigator().noPath();
    }

    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }

    public void func_179480_f() {
        this.field_179482_g = true;
    }

    public void func_179479_b(int p_179479_1_) {
        this.randTimer = p_179479_1_;
    }
}

