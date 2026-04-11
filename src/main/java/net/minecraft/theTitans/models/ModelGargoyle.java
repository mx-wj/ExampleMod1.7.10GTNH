/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.MathHelper
 */
package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityGargoyle;
import net.minecraft.util.MathHelper;

public class ModelGargoyle
extends ModelBase {
    public ModelRenderer Torso;
    public ModelRenderer Body;
    public ModelRenderer LeftLeg;
    public ModelRenderer RightLeg;
    public ModelRenderer Head;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer RightWing1;
    public ModelRenderer LeftWing1;
    public ModelRenderer RightHorn;
    public ModelRenderer LeftHorn;
    public ModelRenderer Nose;
    public ModelRenderer RightArmShoulder;
    public ModelRenderer LeftArm_1;
    public ModelRenderer RightWing2;
    public ModelRenderer RightWingSkin1;
    public ModelRenderer RightWingSkin2;
    public ModelRenderer LeftWing2;
    public ModelRenderer LeftWingSkin1;
    public ModelRenderer LeftWingSkin2;

    public ModelGargoyle() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.RightArm = new ModelRenderer((ModelBase)this, 68, 0);
        this.RightArm.setRotationPoint(-9.0f, -7.0f, 0.0f);
        this.RightArm.addBox(-5.0f, -2.0f, -3.0f, 6, 20, 6, 0.0f);
        this.LeftArm = new ModelRenderer((ModelBase)this, 68, 0);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(9.0f, -7.0f, 0.0f);
        this.LeftArm.addBox(-1.0f, -2.0f, -3.0f, 6, 20, 6, 0.0f);
        this.RightWing1 = new ModelRenderer((ModelBase)this, 0, 47);
        this.RightWing1.setRotationPoint(-6.0f, -8.0f, 3.0f);
        this.RightWing1.addBox(-12.0f, -1.5f, -1.5f, 12, 3, 3, 0.0f);
        this.setRotateAngle(this.RightWing1, 0.34906584f, 0.34906584f, 0.34906584f);
        this.RightArmShoulder = new ModelRenderer((ModelBase)this, 68, 0);
        this.RightArmShoulder.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.RightArmShoulder.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.RightArmShoulder, -0.0f, 1.0471976f, 1.0471976f);
        this.LeftArm_1 = new ModelRenderer((ModelBase)this, 68, 0);
        this.LeftArm_1.mirror = true;
        this.LeftArm_1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.LeftArm_1.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.LeftArm_1, 0.0f, -1.0471976f, -1.0471976f);
        this.LeftWingSkin2 = new ModelRenderer((ModelBase)this, 0, 61);
        this.LeftWingSkin2.mirror = true;
        this.LeftWingSkin2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.LeftWingSkin2.addBox(-12.0f, 0.0f, 0.0f, 12, 8, 0, 0.0f);
        this.Torso = new ModelRenderer((ModelBase)this, 0, 36);
        this.Torso.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.Torso.addBox(-5.0f, -5.0f, -3.0f, 10, 5, 6, 0.5f);
        this.RightWingSkin2 = new ModelRenderer((ModelBase)this, 0, 61);
        this.RightWingSkin2.mirror = true;
        this.RightWingSkin2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.RightWingSkin2.addBox(-12.0f, 0.0f, 0.0f, 12, 8, 0, 0.0f);
        this.LeftLeg = new ModelRenderer((ModelBase)this, 46, 0);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(5.0f, 0.0f, 0.0f);
        this.LeftLeg.addBox(-3.0f, 0.0f, -3.0f, 6, 14, 5, 0.0f);
        this.RightWing2 = new ModelRenderer((ModelBase)this, 0, 47);
        this.RightWing2.setRotationPoint(-12.0f, 0.0f, 0.0f);
        this.RightWing2.addBox(-12.0f, -1.5f, -1.5f, 12, 3, 3, 0.0f);
        this.setRotateAngle(this.RightWing2, 0.0f, 0.0f, -0.17453292f);
        this.LeftHorn = new ModelRenderer((ModelBase)this, 0, 0);
        this.LeftHorn.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.LeftHorn.addBox(1.0f, -12.0f, -3.0f, 2, 4, 2, 0.0f);
        this.RightWingSkin1 = new ModelRenderer((ModelBase)this, 0, 53);
        this.RightWingSkin1.mirror = true;
        this.RightWingSkin1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.RightWingSkin1.addBox(-12.0f, 0.0f, 0.0f, 12, 8, 0, 0.0f);
        this.RightLeg = new ModelRenderer((ModelBase)this, 46, 0);
        this.RightLeg.setRotationPoint(-5.0f, 0.0f, 0.0f);
        this.RightLeg.addBox(-3.0f, 0.0f, -3.0f, 6, 14, 5, 0.0f);
        this.Nose = new ModelRenderer((ModelBase)this, 0, 0);
        this.Nose.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Nose.addBox(-1.0f, -3.0f, -6.0f, 2, 4, 2, 0.0f);
        this.LeftWingSkin1 = new ModelRenderer((ModelBase)this, 0, 53);
        this.LeftWingSkin1.mirror = true;
        this.LeftWingSkin1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.LeftWingSkin1.addBox(-12.0f, 0.0f, 0.0f, 12, 8, 0, 0.0f);
        this.Body = new ModelRenderer((ModelBase)this, 0, 16);
        this.Body.setRotationPoint(0.0f, -5.0f, 0.0f);
        this.Body.addBox(-9.0f, -10.0f, -5.0f, 18, 10, 10, 0.0f);
        this.RightHorn = new ModelRenderer((ModelBase)this, 0, 0);
        this.RightHorn.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.RightHorn.addBox(-3.0f, -12.0f, -3.0f, 2, 4, 2, 0.0f);
        this.LeftWing1 = new ModelRenderer((ModelBase)this, 0, 47);
        this.LeftWing1.mirror = true;
        this.LeftWing1.setRotationPoint(6.0f, -8.0f, 3.0f);
        this.LeftWing1.addBox(-12.0f, -1.5f, -1.5f, 12, 3, 3, 0.0f);
        this.setRotateAngle(this.LeftWing1, -0.34906584f, 2.7925267f, -0.34906584f);
        this.Head = new ModelRenderer((ModelBase)this, 0, 0);
        this.Head.setRotationPoint(0.0f, -10.0f, -2.0f);
        this.Head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.LeftWing2 = new ModelRenderer((ModelBase)this, 0, 47);
        this.LeftWing2.mirror = true;
        this.LeftWing2.setRotationPoint(-12.0f, 0.0f, 0.0f);
        this.LeftWing2.addBox(-12.0f, -1.5f, -1.5f, 12, 3, 3, 0.0f);
        this.setRotateAngle(this.LeftWing2, 0.0f, 0.0f, -0.17453292f);
        this.Body.addChild(this.RightArm);
        this.Body.addChild(this.LeftArm);
        this.Body.addChild(this.RightWing1);
        this.RightArm.addChild(this.RightArmShoulder);
        this.LeftArm.addChild(this.LeftArm_1);
        this.LeftWing2.addChild(this.LeftWingSkin2);
        this.RightWing2.addChild(this.RightWingSkin2);
        this.Torso.addChild(this.LeftLeg);
        this.RightWing1.addChild(this.RightWing2);
        this.Head.addChild(this.LeftHorn);
        this.RightWing1.addChild(this.RightWingSkin1);
        this.Torso.addChild(this.RightLeg);
        this.Head.addChild(this.Nose);
        this.LeftWing1.addChild(this.LeftWingSkin1);
        this.Torso.addChild(this.Body);
        this.Head.addChild(this.RightHorn);
        this.Body.addChild(this.LeftWing1);
        this.Body.addChild(this.Head);
        this.LeftWing1.addChild(this.LeftWing2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Torso.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
        EntityGargoyle entityirongolem = (EntityGargoyle)p_78086_1_;
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        boolean flag;
        this.Torso.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.setRotateAngle(this.RightWing1, 0.34906584f, 0.34906584f, 0.34906584f);
        this.setRotateAngle(this.LeftWing1, -0.34906584f, 2.7925267f, -0.34906584f);
        this.setRotateAngle(this.RightWing2, 0.0f, 0.0f, -0.17453292f);
        this.setRotateAngle(this.LeftWing2, 0.0f, 0.0f, -0.17453292f);
        float f6 = MathHelper.sin((float)(this.onGround * (float)Math.PI));
        float f7 = MathHelper.sin((float)((1.0f - (1.0f - this.onGround) * (1.0f - this.onGround)) * (float)Math.PI));
        this.Head.rotateAngleY = p_78087_4_ / 57.295776f;
        this.Head.rotateAngleX = p_78087_5_ / 57.295776f;
        this.RightArm.rotateAngleZ = 0.0f;
        this.LeftArm.rotateAngleZ = 0.0f;
        this.RightArm.rotateAngleX = 0.0f;
        this.LeftArm.rotateAngleX = 0.0f;
        this.RightLeg.rotateAngleX = -1.5f * this.func_78172_a(p_78087_1_, 13.0f) * p_78087_2_;
        this.LeftLeg.rotateAngleX = 1.5f * this.func_78172_a(p_78087_1_, 13.0f) * p_78087_2_;
        EntityGargoyle entityirongolem = (EntityGargoyle)p_78087_7_;
        int i = entityirongolem.getAttackTimer();
        boolean bl = flag = entityirongolem.worldObj.getBlock(MathHelper.floor_double((double)entityirongolem.posX), MathHelper.floor_double((double)(entityirongolem.boundingBox.minY - 0.5)), MathHelper.floor_double((double)entityirongolem.posZ)) == entityirongolem.getFavoriteBlockToPerch();
        if (i > 0) {
            this.RightArm.rotateAngleX = -2.0f + 1.5f * this.func_78172_a(i, 10.0f);
            this.LeftArm.rotateAngleX = -2.0f + 1.5f * this.func_78172_a(i, 10.0f);
        } else if (entityirongolem.onGround && !entityirongolem.getAggressive()) {
            this.RightArm.rotateAngleX = (-0.2f + 1.5f * this.func_78172_a(p_78087_1_, 13.0f)) * p_78087_2_;
            this.LeftArm.rotateAngleX = (-0.2f - 1.5f * this.func_78172_a(p_78087_1_, 13.0f)) * p_78087_2_;
        }
        this.RightLeg.rotateAngleY = 0.0f;
        this.LeftLeg.rotateAngleY = 0.0f;
        if (!entityirongolem.onGround || entityirongolem.getAggressive()) {
            this.RightWing1.rotateAngleY += MathHelper.cos((float)(p_78087_3_ * 0.5f)) * 0.5f;
            this.LeftWing1.rotateAngleY -= MathHelper.cos((float)(p_78087_3_ * 0.5f)) * 0.5f;
            this.RightWing2.rotateAngleY += MathHelper.cos((float)(p_78087_3_ * 0.5f - 1.5f));
            this.LeftWing2.rotateAngleY -= MathHelper.cos((float)(p_78087_3_ * 0.5f - 1.5f));
            this.Head.rotateAngleX -= 1.25f;
            this.RightArm.rotateAngleX -= 2.5f - (f6 * 1.2f - f7 * 0.4f);
            this.LeftArm.rotateAngleX -= 2.5f - (f6 * 1.2f - f7 * 0.4f);
            this.RightLeg.rotateAngleX = 0.0f;
            this.LeftLeg.rotateAngleX = 0.0f;
        }
        if (flag) {
            this.RightWing1.rotateAngleY += 0.5f;
            this.LeftWing1.rotateAngleY -= 0.5f;
            this.RightWing2.rotateAngleY += -1.5f;
            this.LeftWing2.rotateAngleY -= -1.5f;
            this.RightArm.rotateAngleX -= 0.75f;
            this.LeftArm.rotateAngleX -= 0.75f;
            this.RightArm.rotateAngleZ -= 0.5f;
            this.LeftArm.rotateAngleZ += 0.5f;
            this.RightLeg.rotateAngleX = -0.75f;
            this.LeftLeg.rotateAngleX = -0.75f;
            this.Torso.rotationPointY = 18.0f;
            this.Torso.rotateAngleX = 1.25f;
            this.Head.rotateAngleX -= 1.25f;
        } else {
            this.Torso.rotateAngleX = 0.0f;
        }
    }

    private float func_78172_a(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5f) - p_78172_2_ * 0.25f) / (p_78172_2_ * 0.25f);
    }
}

