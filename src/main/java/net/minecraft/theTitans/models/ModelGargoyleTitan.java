/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 */
package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityGargoyleTitan;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.client.Animator;

public class ModelGargoyleTitan
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
    public ModelRenderer RightHorn1;
    public ModelRenderer Nose;
    public ModelRenderer LeftHorn1;
    public ModelRenderer RightHorn2;
    public ModelRenderer RightHorn3;
    public ModelRenderer LeftHorn2;
    public ModelRenderer LeftHorn3;
    public ModelRenderer RightArmShoulder;
    public ModelRenderer RightForearm;
    public ModelRenderer LeftArmShoulder;
    public ModelRenderer LeftForearm;
    public ModelRenderer RightWing2;
    public ModelRenderer RightWingSkin1;
    public ModelRenderer RightWingSkin2;
    public ModelRenderer LeftWing2;
    public ModelRenderer LeftWingSkin1;
    public ModelRenderer LeftWingSkin2;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightFoot;
    private Animator animator;

    public ModelGargoyleTitan() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.LeftForearm = new ModelRenderer((ModelBase)this, 68, 16);
        this.LeftForearm.mirror = true;
        this.LeftForearm.setRotationPoint(2.0f, 8.0f, 0.0f);
        this.LeftForearm.addBox(-3.0f, 0.0f, -3.0f, 6, 10, 6, 0.0f);
        this.RightHorn3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.RightHorn3.setRotationPoint(0.0f, -3.0f, -0.5f);
        this.RightHorn3.addBox(-1.0f, -4.0f, -1.5f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.RightHorn3, -0.8651597f, 0.0f, -0.091106184f);
        this.LeftLeg = new ModelRenderer((ModelBase)this, 46, 0);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(5.0f, 0.0f, 0.0f);
        this.LeftLeg.addBox(-3.0f, 0.0f, -3.0f, 6, 7, 5, 0.0f);
        this.Head = new ModelRenderer((ModelBase)this, 0, 0);
        this.Head.setRotationPoint(0.0f, -10.0f, -2.0f);
        this.Head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.LeftArmShoulder = new ModelRenderer((ModelBase)this, 68, 0);
        this.LeftArmShoulder.mirror = true;
        this.LeftArmShoulder.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.LeftArmShoulder.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.LeftArmShoulder, 0.0f, -1.0471976f, -1.0471976f);
        this.Torso = new ModelRenderer((ModelBase)this, 0, 36);
        this.Torso.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.Torso.addBox(-5.0f, -5.0f, -3.0f, 10, 5, 6, 0.5f);
        this.RightArm = new ModelRenderer((ModelBase)this, 68, 0);
        this.RightArm.setRotationPoint(-9.0f, -7.0f, 0.0f);
        this.RightArm.addBox(-5.0f, -2.0f, -3.0f, 6, 10, 6, 0.0f);
        this.Nose = new ModelRenderer((ModelBase)this, 0, 0);
        this.Nose.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Nose.addBox(-1.0f, -3.0f, -6.0f, 2, 4, 2, 0.0f);
        this.Body = new ModelRenderer((ModelBase)this, 0, 16);
        this.Body.setRotationPoint(0.0f, -5.0f, 0.0f);
        this.Body.addBox(-9.0f, -10.0f, -5.0f, 18, 10, 10, 0.0f);
        this.LeftWing2 = new ModelRenderer((ModelBase)this, 0, 47);
        this.LeftWing2.mirror = true;
        this.LeftWing2.setRotationPoint(-18.0f, 0.0f, 0.0f);
        this.LeftWing2.addBox(-18.0f, -1.5f, -1.5f, 18, 3, 3, 0.0f);
        this.setRotateAngle(this.LeftWing2, 0.0f, 0.0f, -0.17453292f);
        this.LeftFoot = new ModelRenderer((ModelBase)this, 46, 12);
        this.LeftFoot.mirror = true;
        this.LeftFoot.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.LeftFoot.addBox(-3.0f, 0.0f, -3.0f, 6, 7, 5, 0.0f);
        this.RightHorn1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.RightHorn1.setRotationPoint(-2.0f, -7.5f, -1.5f);
        this.RightHorn1.addBox(-1.0f, -4.0f, -1.5f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.RightHorn1, 0.22759093f, 0.0f, -0.27314404f);
        this.RightWingSkin1 = new ModelRenderer((ModelBase)this, 0, 53);
        this.RightWingSkin1.mirror = true;
        this.RightWingSkin1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.RightWingSkin1.addBox(-18.0f, 0.0f, 0.0f, 18, 12, 0, 0.0f);
        this.LeftWingSkin2 = new ModelRenderer((ModelBase)this, 0, 65);
        this.LeftWingSkin2.mirror = true;
        this.LeftWingSkin2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.LeftWingSkin2.addBox(-18.0f, 0.0f, 0.0f, 18, 12, 0, 0.0f);
        this.RightForearm = new ModelRenderer((ModelBase)this, 68, 16);
        this.RightForearm.setRotationPoint(-2.0f, 8.0f, 0.0f);
        this.RightForearm.addBox(-3.0f, 0.0f, -3.0f, 6, 10, 6, 0.0f);
        this.LeftHorn1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.LeftHorn1.mirror = true;
        this.LeftHorn1.setRotationPoint(2.0f, -7.5f, -1.5f);
        this.LeftHorn1.addBox(-1.0f, -4.0f, -1.5f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.LeftHorn1, 0.22759093f, 0.0f, 0.27314404f);
        this.RightWing2 = new ModelRenderer((ModelBase)this, 0, 47);
        this.RightWing2.setRotationPoint(-18.0f, 0.0f, 0.0f);
        this.RightWing2.addBox(-18.0f, -1.5f, -1.5f, 18, 3, 3, 0.0f);
        this.setRotateAngle(this.RightWing2, 0.0f, 0.0f, -0.17453292f);
        this.LeftWingSkin1 = new ModelRenderer((ModelBase)this, 0, 53);
        this.LeftWingSkin1.mirror = true;
        this.LeftWingSkin1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.LeftWingSkin1.addBox(-18.0f, 0.0f, 0.0f, 18, 12, 0, 0.0f);
        this.RightLeg = new ModelRenderer((ModelBase)this, 46, 0);
        this.RightLeg.setRotationPoint(-5.0f, 0.0f, 0.0f);
        this.RightLeg.addBox(-3.0f, 0.0f, -3.0f, 6, 7, 5, 0.0f);
        this.LeftWing1 = new ModelRenderer((ModelBase)this, 0, 47);
        this.LeftWing1.mirror = true;
        this.LeftWing1.setRotationPoint(6.0f, -8.0f, 3.0f);
        this.LeftWing1.addBox(-18.0f, -1.5f, -1.5f, 18, 3, 3, 0.0f);
        this.setRotateAngle(this.LeftWing1, -0.34906584f, 2.7925267f, -0.34906584f);
        this.RightFoot = new ModelRenderer((ModelBase)this, 46, 12);
        this.RightFoot.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.RightFoot.addBox(-3.0f, 0.0f, -3.0f, 6, 7, 5, 0.0f);
        this.LeftArm = new ModelRenderer((ModelBase)this, 68, 0);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(9.0f, -7.0f, 0.0f);
        this.LeftArm.addBox(-1.0f, -2.0f, -3.0f, 6, 10, 6, 0.0f);
        this.RightWing1 = new ModelRenderer((ModelBase)this, 0, 47);
        this.RightWing1.setRotationPoint(-6.0f, -8.0f, 3.0f);
        this.RightWing1.addBox(-18.0f, -1.5f, -1.5f, 18, 3, 3, 0.0f);
        this.setRotateAngle(this.RightWing1, 0.34906584f, 0.34906584f, 0.34906584f);
        this.RightHorn2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.RightHorn2.setRotationPoint(0.0f, -3.0f, -0.5f);
        this.RightHorn2.addBox(-1.0f, -4.0f, -1.5f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.RightHorn2, -0.68294734f, 0.0f, -0.091106184f);
        this.RightArmShoulder = new ModelRenderer((ModelBase)this, 68, 0);
        this.RightArmShoulder.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.RightArmShoulder.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.RightArmShoulder, -0.0f, 1.0471976f, 1.0471976f);
        this.LeftHorn2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.LeftHorn2.mirror = true;
        this.LeftHorn2.setRotationPoint(0.0f, -3.0f, -0.5f);
        this.LeftHorn2.addBox(-1.0f, -4.0f, -1.5f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.LeftHorn2, -0.68294734f, 0.0f, 0.091106184f);
        this.LeftHorn3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.LeftHorn3.mirror = true;
        this.LeftHorn3.setRotationPoint(0.0f, -3.0f, -0.5f);
        this.LeftHorn3.addBox(-1.0f, -4.0f, -1.5f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.LeftHorn3, -0.8651597f, 0.0f, 0.091106184f);
        this.RightWingSkin2 = new ModelRenderer((ModelBase)this, 0, 65);
        this.RightWingSkin2.mirror = true;
        this.RightWingSkin2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.RightWingSkin2.addBox(-18.0f, 0.0f, 0.0f, 18, 12, 0, 0.0f);
        this.LeftArm.addChild(this.LeftForearm);
        this.RightHorn2.addChild(this.RightHorn3);
        this.Torso.addChild(this.LeftLeg);
        this.Body.addChild(this.Head);
        this.LeftArm.addChild(this.LeftArmShoulder);
        this.Body.addChild(this.RightArm);
        this.Head.addChild(this.Nose);
        this.Torso.addChild(this.Body);
        this.LeftWing1.addChild(this.LeftWing2);
        this.LeftLeg.addChild(this.LeftFoot);
        this.Head.addChild(this.RightHorn1);
        this.RightWing1.addChild(this.RightWingSkin1);
        this.LeftWing2.addChild(this.LeftWingSkin2);
        this.RightArm.addChild(this.RightForearm);
        this.Head.addChild(this.LeftHorn1);
        this.RightWing1.addChild(this.RightWing2);
        this.LeftWing1.addChild(this.LeftWingSkin1);
        this.Torso.addChild(this.RightLeg);
        this.Body.addChild(this.LeftWing1);
        this.RightLeg.addChild(this.RightFoot);
        this.Body.addChild(this.LeftArm);
        this.Body.addChild(this.RightWing1);
        this.RightHorn1.addChild(this.RightHorn2);
        this.RightArm.addChild(this.RightArmShoulder);
        this.LeftHorn1.addChild(this.LeftHorn2);
        this.LeftHorn2.addChild(this.LeftHorn3);
        this.RightWing2.addChild(this.RightWingSkin2);
        this.animator = new Animator(this);
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

    public void setAngles() {
        this.Torso.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.RightLeg.setRotationPoint(-5.0f, 0.0f, 0.0f);
        this.LeftLeg.setRotationPoint(5.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.LeftArmShoulder, 0.0f, -1.0471976f, -1.0471976f);
        this.setRotateAngle(this.RightArmShoulder, -0.0f, 1.0471976f, 1.0471976f);
        this.setRotateAngle(this.RightWing1, 0.34906584f, 0.34906584f, 0.34906584f);
        this.setRotateAngle(this.LeftWing1, -0.34906584f, 2.7925267f, -0.34906584f);
        this.setRotateAngle(this.RightWing2, 0.0f, 0.0f, -0.17453292f);
        this.setRotateAngle(this.LeftWing2, 0.0f, 0.0f, -0.17453292f);
        this.setRotateAngle(this.RightHorn1, 0.22759093f, 0.0f, -0.27314404f);
        this.setRotateAngle(this.RightHorn2, -0.68294734f, 0.0f, -0.091106184f);
        this.setRotateAngle(this.RightHorn3, -0.8651597f, 0.0f, -0.091106184f);
        this.setRotateAngle(this.LeftHorn1, 0.22759093f, 0.0f, 0.27314404f);
        this.setRotateAngle(this.LeftHorn2, -0.68294734f, 0.0f, 0.091106184f);
        this.setRotateAngle(this.LeftHorn3, -0.8651597f, 0.0f, 0.091106184f);
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        EntityGargoyleTitan entitytitan = (EntityGargoyleTitan)p_78087_7_;
        this.animator.update(entitytitan);
        this.setAngles();
        if (entitytitan.deathTicks <= 0) {
            this.Head.rotateAngleY = p_78087_4_ / 57.295776f;
            this.Head.rotateAngleX = p_78087_5_ / 57.295776f;
            if (entitytitan.animID == 0) {
                this.RightWing1.rotateAngleY += MathHelper.cos((float)(p_78087_3_ * 0.05f)) * 0.1f;
                this.LeftWing1.rotateAngleY -= MathHelper.cos((float)(p_78087_3_ * 0.05f)) * 0.1f;
                this.RightWing2.rotateAngleY += MathHelper.cos((float)(p_78087_3_ * 0.05f - 0.2f)) * 0.2f;
                this.LeftWing2.rotateAngleY -= MathHelper.cos((float)(p_78087_3_ * 0.05f - 0.2f)) * 0.2f;
                this.RightWing1.rotateAngleY += MathHelper.cos((float)(p_78087_3_ * 0.3331f)) * 0.2f * p_78087_2_;
                this.LeftWing1.rotateAngleY -= MathHelper.cos((float)(p_78087_3_ * 0.3331f)) * 0.2f * p_78087_2_;
                this.RightWing2.rotateAngleY += MathHelper.cos((float)(p_78087_3_ * 0.3331f - 0.2f)) * 0.2f * p_78087_2_;
                this.LeftWing2.rotateAngleY -= MathHelper.cos((float)(p_78087_3_ * 0.3331f - 0.2f)) * 0.2f * p_78087_2_;
                this.RightLeg.rotateAngleX = MathHelper.cos((float)(p_78087_1_ * 0.3331f - 0.5f)) * 1.25f * p_78087_2_;
                this.LeftLeg.rotateAngleX = MathHelper.cos((float)(p_78087_1_ * 0.3331f + 2.6415927f)) * 1.25f * p_78087_2_;
                this.RightFoot.rotateAngleX = MathHelper.cos((float)(p_78087_1_ * 0.3331f + (float)Math.PI)) * 1.25f * p_78087_2_;
                this.LeftFoot.rotateAngleX = MathHelper.cos((float)(p_78087_1_ * 0.3331f)) * 1.25f * p_78087_2_;
                this.RightArm.rotateAngleX = MathHelper.cos((float)(p_78087_1_ * 0.25f + (float)Math.PI)) * 1.0f * p_78087_2_;
                this.LeftArm.rotateAngleX = MathHelper.cos((float)(p_78087_1_ * 0.25f)) * 1.0f * p_78087_2_;
                this.RightForearm.rotateAngleX = MathHelper.cos((float)(p_78087_1_ * 0.25f + 2.1415927f)) * 1.0f * p_78087_2_;
                this.LeftForearm.rotateAngleX = MathHelper.cos((float)(p_78087_1_ * 0.25f - 1.0f)) * 1.0f * p_78087_2_;
            }
            if (this.RightFoot.rotateAngleX < 0.0f) {
                this.RightFoot.rotateAngleX = 0.0f;
            }
            if (this.LeftFoot.rotateAngleX < 0.0f) {
                this.LeftFoot.rotateAngleX = 0.0f;
            }
            if (this.RightForearm.rotateAngleX > 0.0f) {
                this.RightForearm.rotateAngleX = 0.0f;
            }
            if (this.LeftForearm.rotateAngleX > 0.0f) {
                this.LeftForearm.rotateAngleX = 0.0f;
            }
            if (!entitytitan.onGround) {
                this.RightWing1.rotateAngleY += MathHelper.cos((float)(p_78087_3_ * 0.2f));
                this.LeftWing1.rotateAngleY -= MathHelper.cos((float)(p_78087_3_ * 0.2f));
                this.RightWing2.rotateAngleY += MathHelper.cos((float)(p_78087_3_ * 0.2f - 2.0f));
                this.LeftWing2.rotateAngleY -= MathHelper.cos((float)(p_78087_3_ * 0.2f - 2.0f));
                this.Torso.rotateAngleX += 1.0f;
                this.Head.rotateAngleX -= 1.0f;
                this.RightArm.rotateAngleX = -0.5f;
                this.LeftArm.rotateAngleX = -0.5f;
                this.RightForearm.rotateAngleX = -0.5f;
                this.LeftForearm.rotateAngleX = -0.5f;
                this.RightLeg.rotateAngleX = 0.5f;
                this.LeftLeg.rotateAngleX = 0.5f;
                this.RightFoot.rotateAngleX = 0.5f;
                this.LeftFoot.rotateAngleX = 0.5f;
            }
            this.animateAntiTitanAttack();
            this.animateWingBuffet();
            this.animateSlam();
            this.animateMeteor();
            this.animateWaterSpout();
            this.animateLavaSpit();
            this.animateStomp();
            this.animateSwat();
            this.animatePunch();
        }
    }

    private void animateAntiTitanAttack() {
        this.animator.setAnim(1);
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0f, 1.0f, 0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, -1.0f, -0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftArm, 2.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0f, -1.0f, -1.0f);
        this.animator.rotate(this.LeftWing1, 0.0f, 1.0f, 1.0f);
        this.animator.rotate(this.RightWing2, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftArm, -2.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(10);
    }

    private void animateWingBuffet() {
        this.animator.setAnim(2);
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.LeftWing1, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.RightWing2, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, -1.0f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, -1.0f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, -0.25f, -1.0f, 0.5f);
        this.animator.rotate(this.LeftWing1, 0.25f, 1.0f, -0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, -1.0f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, -1.0f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0f, -0.75f, -0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, 0.75f, 0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, -0.75f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 0.75f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, -0.5f, -0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Body, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.RightArm, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForearm, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(60);
        this.animator.resetPhase(20);
    }

    private void animateSlam() {
        this.animator.setAnim(3);
        this.animator.startPhase(10);
        this.animator.move(this.Torso, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.RightWing1, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftWing1, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightLeg, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftLeg, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFoot, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFoot, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(15);
        this.animator.move(this.Torso, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.RightWing1, 0.0f, -0.5f, 0.25f);
        this.animator.rotate(this.LeftWing1, 0.0f, 0.5f, -0.25f);
        this.animator.rotate(this.RightWing2, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.RightLeg, -1.6f, 0.2f, 0.0f);
        this.animator.rotate(this.LeftLeg, 0.0f, 0.2f, 0.0f);
        this.animator.rotate(this.RightFoot, 0.9f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFoot, 0.1f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, -2.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftArm, -2.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForearm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(15);
        this.animator.move(this.Torso, 0.0f, 4.0f, -1.0f);
        this.animator.rotate(this.RightWing1, 0.0f, 0.5f, -0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, -0.5f, 0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.RightLeg, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftLeg, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFoot, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFoot, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Torso, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftArm, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForearm, -0.5f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftForearm, -0.5f, 0.0f, 0.5f);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateMeteor() {
        this.animator.setAnim(4);
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0f, -0.75f, -0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, 0.75f, 0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, -0.75f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 0.75f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, -0.5f, -0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Body, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.RightArm, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForearm, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(60);
        this.animator.resetPhase(20);
    }

    private void animateWaterSpout() {
        this.animator.setAnim(5);
        this.animator.startPhase(20);
        this.animator.rotate(this.RightWing1, 0.0f, -0.75f, -0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, 0.75f, 0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, -0.75f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 0.75f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.RightWing1, 0.0f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, -0.5f, -0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Nose, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 0.5f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.5f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateLavaSpit() {
        this.animator.setAnim(6);
        this.animator.startPhase(20);
        this.animator.rotate(this.RightWing1, 0.0f, -0.75f, -0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, 0.75f, 0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, -0.75f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 0.75f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.RightWing1, 0.0f, -0.75f, -0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, 0.75f, 0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, -0.75f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 0.75f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.RightWing1, 0.0f, -0.75f, -0.5f);
        this.animator.rotate(this.LeftWing1, 0.0f, 0.75f, 0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, -0.75f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 0.75f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(10);
        this.animator.resetPhase(20);
    }

    private void animateStomp() {
        this.animator.setAnim(7);
        this.animator.startPhase(25);
        this.animator.rotate(this.RightLeg, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftLeg, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFoot, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFoot, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForearm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(25);
        this.animator.rotate(this.RightLeg, -2.0f, 0.2f, 0.75f);
        this.animator.rotate(this.LeftLeg, 0.0f, 0.2f, 0.0f);
        this.animator.rotate(this.RightFoot, 1.5f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftFoot, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.5f);
        this.animator.rotate(this.Body, -1.0f, 0.0f, 0.25f);
        this.animator.rotate(this.RightArm, -0.75f, 0.0f, 0.5f);
        this.animator.rotate(this.LeftArm, -0.75f, 0.0f, -0.5f);
        this.animator.rotate(this.RightForearm, -0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -0.3f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.RightWing1, -0.25f, -1.0f, 0.5f);
        this.animator.rotate(this.LeftWing1, 0.25f, 1.0f, -0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.RightLeg, -0.5f, 0.5f, 0.0f);
        this.animator.rotate(this.LeftLeg, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFoot, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFoot, 0.1f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, 0.5f, 0.0f, 0.5f);
        this.animator.rotate(this.Body, 0.5f, 0.0f, -0.4f);
        this.animator.rotate(this.RightArm, -0.75f, 0.0f, 0.5f);
        this.animator.rotate(this.LeftArm, -0.75f, 0.0f, -0.5f);
        this.animator.rotate(this.RightForearm, -0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -0.3f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(5);
        this.animator.startPhase(20);
        this.animator.rotate(this.RightLeg, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftLeg, -2.0f, 0.0f, -0.75f);
        this.animator.rotate(this.RightFoot, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFoot, 1.5f, 0.0f, 0.5f);
        this.animator.rotate(this.Head, 1.0f, 0.0f, -0.5f);
        this.animator.rotate(this.Body, -1.0f, 0.0f, -0.25f);
        this.animator.rotate(this.RightArm, 0.8f, 0.0f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.8f, 0.0f, -0.5f);
        this.animator.rotate(this.RightForearm, -0.8f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -0.8f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.RightWing1, -0.25f, -1.0f, 0.5f);
        this.animator.rotate(this.LeftWing1, 0.25f, 1.0f, -0.5f);
        this.animator.rotate(this.RightWing2, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.LeftWing2, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.RightLeg, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftLeg, -0.5f, -0.5f, 0.0f);
        this.animator.rotate(this.RightFoot, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFoot, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, 0.5f, 0.0f, -0.5f);
        this.animator.rotate(this.Body, 0.5f, 0.0f, 0.4f);
        this.animator.rotate(this.RightArm, 0.75f, 0.0f, 0.5f);
        this.animator.rotate(this.LeftArm, 0.75f, 0.0f, -0.5f);
        this.animator.rotate(this.RightForearm, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -0.75f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.resetPhase(20);
    }

    private void animateSwat() {
        this.animator.setAnim(8);
        this.animator.startPhase(20);
        this.animator.move(this.Torso, 0.0f, 2.0f, 0.0f);
        this.animator.rotate(this.RightLeg, -0.5f, 0.25f, 0.0f);
        this.animator.rotate(this.LeftLeg, -0.5f, -0.25f, 0.0f);
        this.animator.rotate(this.RightFoot, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFoot, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -1.5f, 1.0f, 0.0f);
        this.animator.rotate(this.LeftArm, -2.0f, 0.75f, 1.5f);
        this.animator.rotate(this.LeftForearm, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 1.5f, -1.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.move(this.Torso, 0.0f, 6.0f, 0.0f);
        this.animator.rotate(this.RightLeg, -1.0f, 0.5f, 0.0f);
        this.animator.rotate(this.LeftLeg, -1.0f, -0.5f, 0.0f);
        this.animator.rotate(this.RightFoot, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFoot, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftArm, -2.0f, -1.25f, -1.5f);
        this.animator.rotate(this.LeftForearm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 2.25f, 1.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animatePunch() {
        this.animator.setAnim(9);
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 0.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Body, 0.0f, 0.0f, 0.5f);
        this.animator.rotate(this.Head, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftArm, -2.5f, 0.0f, 0.5f);
        this.animator.rotate(this.LeftForearm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForearm, -1.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.move(this.Torso, 0.0f, 4.0f, 0.0f);
        this.animator.rotate(this.RightLeg, -1.0f, 0.5f, 0.0f);
        this.animator.rotate(this.LeftLeg, -1.0f, -0.5f, 0.0f);
        this.animator.rotate(this.RightFoot, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFoot, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Body, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightArm, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForearm, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftArm, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForearm, -0.5f, 0.0f, 0.5f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.resetPhase(20);
    }
}

