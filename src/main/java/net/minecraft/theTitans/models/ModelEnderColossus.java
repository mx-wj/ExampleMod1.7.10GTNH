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
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;

public class ModelEnderColossus
extends ModelBase {
    public boolean isAttacking;
    public ModelRenderer BodyBottom;
    public ModelRenderer LeftThigh;
    public ModelRenderer RightThigh;
    public ModelRenderer BodyMiddle;
    public ModelRenderer BodyTop;
    public ModelRenderer LeftShoulder;
    public ModelRenderer RightShoulder;
    public ModelRenderer Mouth;
    public ModelRenderer LeftForeArm;
    public ModelRenderer RightForeArm;
    public ModelRenderer Head;
    public ModelRenderer Horn1;
    public ModelRenderer Horn2;
    public ModelRenderer Horn3;
    public ModelRenderer Horn4;
    public ModelRenderer LeftFemur;
    public ModelRenderer RightFemur;
    private Animator animator;

    public ModelEnderColossus() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RightShoulder = new ModelRenderer((ModelBase)this, 32, 0);
        this.RightShoulder.setRotationPoint(-5.0f, -2.0f, 0.0f);
        this.RightShoulder.addBox(-1.0f, -2.0f, -1.0f, 2, 15, 2, 0.0f);
        this.LeftShoulder = new ModelRenderer((ModelBase)this, 32, 0);
        this.LeftShoulder.mirror = true;
        this.LeftShoulder.setRotationPoint(5.0f, -2.0f, 0.0f);
        this.LeftShoulder.addBox(-1.0f, -2.0f, -1.0f, 2, 15, 2, 0.0f);
        this.Horn1 = new ModelRenderer((ModelBase)this, 24, 38);
        this.Horn1.setRotationPoint(4.0f, -4.0f, 0.0f);
        this.Horn1.addBox(0.0f, -1.0f, -1.0f, 4, 2, 2, 0.0f);
        this.Mouth = new ModelRenderer((ModelBase)this, 0, 16);
        this.Mouth.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.Mouth.addBox(-4.0f, -7.5f, -4.0f, 8, 8, 8, -0.25f);
        this.BodyMiddle = new ModelRenderer((ModelBase)this, 0, 40);
        this.BodyMiddle.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.BodyMiddle.addBox(-4.0f, -4.0f, -2.0f, 8, 4, 4, 0.0f);
        this.LeftForeArm = new ModelRenderer((ModelBase)this, 32, 17);
        this.LeftForeArm.mirror = true;
        this.LeftForeArm.setRotationPoint(0.0f, 13.0f, 0.0f);
        this.LeftForeArm.addBox(-1.0f, 0.0f, -1.0f, 2, 15, 2, 0.0f);
        this.RightForeArm = new ModelRenderer((ModelBase)this, 32, 17);
        this.RightForeArm.setRotationPoint(0.0f, 13.0f, 0.0f);
        this.RightForeArm.addBox(-1.0f, 0.0f, -1.0f, 2, 15, 2, 0.0f);
        this.BodyTop = new ModelRenderer((ModelBase)this, 0, 32);
        this.BodyTop.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.BodyTop.addBox(-4.0f, -4.0f, -2.0f, 8, 4, 4, 0.0f);
        this.LeftThigh = new ModelRenderer((ModelBase)this, 32, 0);
        this.LeftThigh.mirror = true;
        this.LeftThigh.setRotationPoint(2.0f, -6.0f, 0.0f);
        this.LeftThigh.addBox(-1.0f, 0.0f, -1.0f, 2, 15, 2, 0.0f);
        this.BodyBottom = new ModelRenderer((ModelBase)this, 0, 48);
        this.BodyBottom.setRotationPoint(0.0f, -6.0f, -0.0f);
        this.BodyBottom.addBox(-4.0f, -4.0f, -2.0f, 8, 4, 4, 0.0f);
        this.RightThigh = new ModelRenderer((ModelBase)this, 32, 0);
        this.RightThigh.setRotationPoint(-2.0f, -6.0f, 0.0f);
        this.RightThigh.addBox(-1.0f, 0.0f, -1.0f, 2, 15, 2, 0.0f);
        this.LeftFemur = new ModelRenderer((ModelBase)this, 32, 17);
        this.LeftFemur.mirror = true;
        this.LeftFemur.setRotationPoint(0.0f, 15.0f, 0.0f);
        this.LeftFemur.addBox(-1.0f, 0.0f, -1.0f, 2, 15, 2, 0.0f);
        this.Head = new ModelRenderer((ModelBase)this, 0, 0);
        this.Head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.25f);
        this.Horn2 = new ModelRenderer((ModelBase)this, 24, 38);
        this.Horn2.setRotationPoint(-4.0f, -4.0f, 0.0f);
        this.Horn2.addBox(-4.0f, -1.0f, -1.0f, 4, 2, 2, 0.0f);
        this.Horn3 = new ModelRenderer((ModelBase)this, 36, 36);
        this.Horn3.setRotationPoint(3.0f, -1.0f, 0.0f);
        this.Horn3.addBox(-1.0f, -4.0f, -1.0f, 2, 4, 2, 0.0f);
        this.RightFemur = new ModelRenderer((ModelBase)this, 32, 17);
        this.RightFemur.setRotationPoint(0.0f, 15.0f, 0.0f);
        this.RightFemur.addBox(-1.0f, 0.0f, -1.0f, 2, 15, 2, 0.0f);
        this.Horn4 = new ModelRenderer((ModelBase)this, 36, 36);
        this.Horn4.setRotationPoint(-3.0f, -1.0f, 0.0f);
        this.Horn4.addBox(-1.0f, -4.0f, -1.0f, 2, 4, 2, 0.0f);
        this.BodyTop.addChild(this.RightShoulder);
        this.BodyTop.addChild(this.LeftShoulder);
        this.Head.addChild(this.Horn1);
        this.BodyTop.addChild(this.Mouth);
        this.BodyBottom.addChild(this.BodyMiddle);
        this.LeftShoulder.addChild(this.LeftForeArm);
        this.RightShoulder.addChild(this.RightForeArm);
        this.BodyMiddle.addChild(this.BodyTop);
        this.LeftThigh.addChild(this.LeftFemur);
        this.Mouth.addChild(this.Head);
        this.Head.addChild(this.Horn2);
        this.Horn1.addChild(this.Horn3);
        this.RightThigh.addChild(this.RightFemur);
        this.Horn2.addChild(this.Horn4);
        this.animator = new Animator(this);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animate((IAnimatedEntity)entity, f, f1, f2, f3, f4, f5);
        this.LeftThigh.render(f5);
        this.BodyBottom.render(f5);
        this.RightThigh.render(f5);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        this.setAngles();
        EntityEnderColossus entitytitan = (EntityEnderColossus)entity;
        if (this.isAttacking) {
            this.Head.setRotationPoint(0.0f, -7.0f, 0.0f);
        } else {
            this.Head.setRotationPoint(0.0f, 0.0f, 0.0f);
        }
        float f6 = MathHelper.cos((float)(f2 * 0.05f));
        this.RightThigh.rotateAngleX = -0.09f;
        this.LeftThigh.rotateAngleX = -0.09f;
        this.RightFemur.rotateAngleX = 0.18f;
        this.LeftFemur.rotateAngleX = 0.18f;
        if (entitytitan.deathTicks <= 0) {
            if (!this.isRiding) {
                this.LeftThigh.rotateAngleX = -0.09f + MathHelper.cos((float)(f * 0.33f + 2.6415927f)) * 0.75f * f1;
                this.RightThigh.rotateAngleX = -0.09f + MathHelper.cos((float)(f * 0.33f - 0.5f)) * 0.75f * f1;
                this.LeftFemur.rotateAngleX = 0.18f + MathHelper.cos((float)(f * 0.33f)) * 0.75f * f1;
                this.RightFemur.rotateAngleX = 0.18f + MathHelper.cos((float)(f * 0.33f + (float)Math.PI)) * 0.75f * f1;
                if (this.RightFemur.rotateAngleX < 0.0f) {
                    this.RightFemur.rotateAngleX = 0.0f;
                }
                if (this.LeftFemur.rotateAngleX < 0.0f) {
                    this.LeftFemur.rotateAngleX = 0.0f;
                }
            }
            float faceYaw = f3 * (float)Math.PI / 180.0f;
            float facePitch = f4 * (float)Math.PI / 180.0f;
            if (entitytitan.getAnimID() == 0) {
                this.BodyMiddle.rotateAngleX = (0.0f + -0.01f * f6) * (float)Math.PI;
                this.BodyTop.rotateAngleX = (0.0f + -0.01f * f6) * (float)Math.PI;
                this.Head.rotateAngleX = (-0.01f + -0.01f * f6) * (float)Math.PI;
                this.Mouth.rotateAngleX = (0.01f + 0.01f * f6) * (float)Math.PI;
                this.BodyBottom.rotateAngleZ = MathHelper.cos((float)(f * 0.33f)) * 0.125f * f1;
                this.BodyMiddle.rotateAngleZ = MathHelper.cos((float)(f * 0.33f)) * 0.125f * f1;
                this.BodyTop.rotateAngleZ = MathHelper.cos((float)(f * 0.33f)) * 0.125f * f1;
                this.Mouth.rotateAngleZ = MathHelper.cos((float)(f * 0.33f + (float)Math.PI)) * 0.375f * f1;
                this.RightForeArm.rotateAngleX = MathHelper.cos((float)(f * 0.33f + (float)Math.PI)) * 0.75f * f1 - 0.3f;
                this.LeftForeArm.rotateAngleX = MathHelper.cos((float)(f * 0.33f)) * 0.75f * f1 - 0.3f;
            }
            this.RightShoulder.rotateAngleX = 0.09f + MathHelper.cos((float)(f * 0.33f + (float)Math.PI)) * 0.75f * f1;
            this.LeftShoulder.rotateAngleX = 0.09f + MathHelper.cos((float)(f * 0.33f)) * 0.75f * f1;
            this.RightShoulder.rotateAngleY = 0.08f;
            this.LeftShoulder.rotateAngleY = -0.08f;
            this.RightShoulder.rotateAngleZ = 0.10471976f - (0.005f + 0.005f * f6) * (float)Math.PI;
            this.LeftShoulder.rotateAngleZ = -0.10471976f + (-0.005f + -0.005f * f6) * (float)Math.PI;
            if (entitytitan.animID == 0 && entitytitan.getEyeLaserTime() < 0) {
                this.Mouth.rotateAngleX += facePitch * 0.3f;
                this.Mouth.rotateAngleY += faceYaw * 0.3f;
                this.BodyTop.rotateAngleX += facePitch * 0.3f;
                this.BodyTop.rotateAngleY += faceYaw * 0.3f;
                this.BodyMiddle.rotateAngleX += facePitch * 0.3f;
                this.BodyMiddle.rotateAngleY += faceYaw * 0.3f;
                this.RightShoulder.rotateAngleX -= facePitch * 0.6f;
                this.LeftShoulder.rotateAngleX -= facePitch * 0.6f;
            } else {
                this.Mouth.rotateAngleX += facePitch * 0.9f;
                this.Mouth.rotateAngleY += faceYaw * 0.9f;
            }
            if (this.RightForeArm.rotateAngleX > -0.3f) {
                this.RightForeArm.rotateAngleX = -0.3f;
            }
            if (this.LeftForeArm.rotateAngleX > -0.3f) {
                this.LeftForeArm.rotateAngleX = -0.3f;
            }
            if (!entitytitan.onGround && !this.isRiding) {
                this.BodyTop.rotateAngleZ = 0.0f;
                this.BodyMiddle.rotateAngleZ = 0.0f;
                this.BodyBottom.rotateAngleZ = 0.0f;
                this.Mouth.rotateAngleZ = 0.0f;
                this.BodyBottom.rotateAngleZ = 0.0f;
                this.BodyMiddle.rotateAngleZ = 0.0f;
                this.BodyTop.rotateAngleZ = 0.0f;
                this.Head.rotateAngleZ = 0.0f;
                this.RightShoulder.rotateAngleX = 0.09f;
                this.LeftShoulder.rotateAngleX = 0.09f;
                this.RightForeArm.rotateAngleX = 0.09f;
                this.LeftForeArm.rotateAngleX = 0.09f;
                this.Mouth.rotateAngleX -= entitytitan.limbSwingAmount;
                this.BodyBottom.rotateAngleX += entitytitan.limbSwingAmount;
                this.RightThigh.rotateAngleX = MathHelper.cos((float)(f2 * 0.1f - 0.5f)) * 0.25f - (float)(entitytitan.motionY / 5.0) + entitytitan.limbSwingAmount;
                this.LeftThigh.rotateAngleX = MathHelper.cos((float)(f2 * 0.1f - 3.6415927f)) * 0.25f - (float)(entitytitan.motionY / 5.0) + entitytitan.limbSwingAmount;
                this.RightFemur.rotateAngleX = 0.5f - MathHelper.cos((float)(f2 * 0.1f)) * 0.5f;
                this.LeftFemur.rotateAngleX = 0.5f - MathHelper.cos((float)(f2 * 0.1f - (float)Math.PI)) * 0.5f;
            }
            if (entitytitan.getAnimID() == 8 && entitytitan.getAnimTick() > 20 && entitytitan.getAnimTick() < 60) {
                this.BodyTop.rotateAngleY = MathHelper.cos((float)f2) * 0.5f;
                this.Mouth.rotateAngleY = MathHelper.cos((float)f2) * 0.25f;
                this.BodyTop.rotateAngleX = MathHelper.cos((float)(f2 * 0.25f - 2.0f)) * 0.25f;
                this.BodyMiddle.rotateAngleX = MathHelper.cos((float)(f2 * 0.25f - 1.0f)) * 0.25f;
                this.BodyBottom.rotateAngleX = MathHelper.cos((float)(f2 * 0.25f)) * 0.25f;
            }
            if (entitytitan.getAnimID() == 8 && entitytitan.getAnimTick() > 100 && entitytitan.getAnimTick() < 340) {
                this.Mouth.rotateAngleY = MathHelper.cos((float)(f2 * 0.05f)) * 0.2f;
            }
            if (entitytitan.getAnimID() == 1) {
                switch (entitytitan.antiTitanAttackAnimeID) {
                    case 0: {
                        this.animateAntiTitanAttack1();
                        break;
                    }
                    case 1: {
                        this.animateAntiTitanAttack2();
                        break;
                    }
                    case 2: {
                        this.animateAntiTitanAttack3();
                        break;
                    }
                    case 3: {
                        this.animateAntiTitanAttack4();
                    }
                }
            }
            this.animateStomp();
            this.animateSwat();
            this.animateSlam();
            this.animateMeteor();
            this.animateChainLightning();
            this.animateLightning();
            this.animateLightningBall();
            this.animateDragonBall();
            this.animateScream();
            this.animateStunned();
            if (this.Head.rotationPointY < -7.0f) {
                this.Head.rotationPointY = -7.0f;
            }
            if (entitytitan.getAnimID() == 3 && entitytitan.getAnimTick() > 30 && entitytitan.getAnimTick() < 50) {
                this.RightForeArm.rotateAngleX += 0.1f * MathHelper.cos((float)f2) * (float)Math.PI;
                this.LeftForeArm.rotateAngleX -= 0.1f * MathHelper.cos((float)f2) * (float)Math.PI;
            }
        } else {
            this.animateDeath();
        }
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setAngles() {
        this.RightShoulder.setRotationPoint(-5.0f, -2.0f, 0.0f);
        this.LeftShoulder.setRotationPoint(5.0f, -2.0f, 0.0f);
        this.Mouth.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.BodyBottom.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.LeftThigh.setRotationPoint(2.0f, -6.0f, 0.0f);
        this.RightThigh.setRotationPoint(-2.0f, -6.0f, 0.0f);
        this.Horn1.setRotationPoint(4.25f, -4.5f, 0.0f);
        this.Horn2.setRotationPoint(-4.25f, -4.5f, 0.0f);
    }

    private void animateAntiTitanAttack1() {
        this.animator.setAnim(1);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.Head, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 1.0f, -1.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, 1.0f, 1.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.25f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 2.0f, -12.0f);
        this.animator.move(this.RightThigh, 0.0f, 2.0f, -12.0f);
        this.animator.move(this.LeftThigh, 0.0f, 2.0f, -12.0f);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -1.0f, 1.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, -1.0f, -1.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(10);
    }

    private void animateAntiTitanAttack2() {
        this.animator.setAnim(1);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 5.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.5f, -0.5f, 0.0f);
        this.animator.rotate(this.BodyMiddle, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.BodyTop, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.RightShoulder, 1.6f, 0.0f, 2.0f);
        this.animator.rotate(this.RightForeArm, -0.9f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 2.0f, -12.0f);
        this.animator.move(this.RightThigh, 0.0f, 2.0f, -12.0f);
        this.animator.move(this.LeftThigh, 0.0f, 2.0f, -12.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -0.5f, 0.5f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.25f, -0.25f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.25f, -0.25f, 0.0f);
        this.animator.rotate(this.RightShoulder, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, 0.0f, 0.0f, -0.75f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateAntiTitanAttack3() {
        this.animator.setAnim(1);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 5.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, -0.8f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, -0.8f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -4.0f, 0.0f, -0.25f);
        this.animator.rotate(this.LeftShoulder, -4.0f, 0.0f, 0.25f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 2.0f, -12.0f);
        this.animator.move(this.RightThigh, 0.0f, 2.0f, -12.0f);
        this.animator.move(this.LeftThigh, 0.0f, 2.0f, -12.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 1.0f, 0.0f, -0.25f);
        this.animator.rotate(this.LeftShoulder, 1.0f, 0.0f, 0.25f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateAntiTitanAttack4() {
        this.animator.setAnim(1);
        this.animator.startPhase(10);
        this.animator.rotate(this.RightThigh, 2.0f, 0.2f, 1.5f);
        this.animator.rotate(this.RightFemur, 1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.0f, -1.0f, -0.2f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, -0.2f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, -0.2f);
        this.animator.rotate(this.BodyBottom, -1.0f, 1.0f, 0.6f);
        this.animator.rotate(this.RightShoulder, -1.5f, 0.0f, 0.75f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftShoulder, -1.5f, 0.0f, -0.75f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.5f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 2.0f, -12.0f);
        this.animator.move(this.RightThigh, 0.0f, 2.0f, -13.0f);
        this.animator.move(this.LeftThigh, 0.0f, 2.0f, -11.0f);
        this.animator.rotate(this.RightThigh, -3.0f, 0.2f, 1.5f);
        this.animator.rotate(this.LeftThigh, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.0f, 0.0f, -0.25f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.5f, -0.25f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.5f, -0.25f);
        this.animator.rotate(this.BodyBottom, -1.0f, -1.0f, 0.75f);
        this.animator.rotate(this.RightShoulder, -1.5f, 0.0f, 0.75f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftShoulder, -1.5f, 0.0f, -0.75f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.5f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateMeteor() {
        this.animator.setAnim(2);
        this.animator.startPhase(30);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 5.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.BodyMiddle, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.BodyTop, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.RightShoulder, -1.5f, 0.0f, 0.5f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftShoulder, -1.5f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.5f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, -8.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, -8.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, -8.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -0.5f, 0.5f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.25f, -0.25f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.25f, -0.25f, 0.0f);
        this.animator.rotate(this.RightShoulder, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(40);
    }

    private void animateLightningBall() {
        this.animator.setAnim(4);
        this.animator.startPhase(30);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 5.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.BodyMiddle, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.BodyTop, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.RightShoulder, -1.5f, 0.0f, 0.5f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftShoulder, -1.5f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.5f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, -8.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, -8.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, -8.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -0.5f, 0.5f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.25f, -0.25f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.25f, -0.25f, 0.0f);
        this.animator.rotate(this.RightShoulder, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(40);
    }

    private void animateChainLightning() {
        this.animator.setAnim(3);
        this.animator.startPhase(30);
        this.animator.rotate(this.Mouth, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -1.5f, 0.0f, 0.75f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, -0.25f);
        this.animator.rotate(this.LeftShoulder, -1.5f, 0.0f, -0.75f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.25f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(30);
        this.animator.startPhase(10);
        this.animator.rotate(this.Mouth, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 0.0f, 0.0f, 0.5f);
        this.animator.rotate(this.LeftShoulder, 0.0f, 0.0f, -0.5f);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateDragonBall() {
        this.animator.setAnim(11);
        this.animator.startPhase(30);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 5.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.BodyMiddle, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.BodyTop, -0.25f, 0.25f, 0.0f);
        this.animator.rotate(this.RightShoulder, -1.5f, 0.0f, 0.5f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftShoulder, -1.5f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.5f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, -8.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, -8.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, -8.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -0.5f, 0.5f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.25f, -0.25f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.25f, -0.25f, 0.0f);
        this.animator.rotate(this.RightShoulder, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(40);
    }

    private void animateLightning() {
        this.animator.setAnim(13);
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftShoulder, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForeArm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, -1.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Mouth, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateScream() {
        this.animator.setAnim(5);
        this.animator.startPhase(25);
        this.animator.move(this.BodyBottom, 0.0f, 2.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 2.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 2.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftShoulder, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForeArm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(25);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 5.0f);
        this.animator.rotate(this.Head, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 1.0f, -1.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, 1.0f, 1.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.25f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(10);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.Head, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -1.5f, 0.0f, 0.5f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.5f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.5f);
        this.animator.rotate(this.BodyBottom, 0.5f, 0.0f, 1.5f);
        this.animator.rotate(this.RightShoulder, 0.0f, 0.0f, 1.0f);
        this.animator.rotate(this.LeftShoulder, 0.0f, 0.0f, -1.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, -0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(100);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.Head, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -1.5f, 0.0f, -0.5f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, -0.5f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, -0.5f);
        this.animator.rotate(this.BodyBottom, 0.5f, 0.0f, -1.5f);
        this.animator.rotate(this.RightShoulder, 0.0f, 0.0f, 1.0f);
        this.animator.rotate(this.LeftShoulder, 0.0f, 0.0f, -1.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, -0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateSlam() {
        this.animator.setAnim(6);
        this.animator.startPhase(15);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 0.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftShoulder, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForeArm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(15);
        this.animator.move(this.BodyBottom, 0.0f, -1.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, -1.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, -1.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -2.0f, 0.2f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.1f, 0.2f, 0.0f);
        this.animator.rotate(this.RightFemur, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.1f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, -0.8f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, -0.8f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -4.0f, 0.0f, -0.25f);
        this.animator.rotate(this.LeftShoulder, -4.0f, 0.0f, 0.25f);
        this.animator.rotate(this.RightForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 16.0f, 1.0f);
        this.animator.move(this.RightThigh, 0.0f, 16.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 16.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -2.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -3.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, -3.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -0.75f, 0.0f, -0.25f);
        this.animator.rotate(this.LeftForeArm, -0.75f, 0.0f, 0.25f);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateStomp() {
        this.animator.setAnim(7);
        this.animator.startPhase(25);
        this.animator.move(this.BodyBottom, 0.0f, 2.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 2.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 2.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftShoulder, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForeArm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(25);
        this.animator.move(this.BodyBottom, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, -2.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -2.0f, 0.2f, 0.75f);
        this.animator.rotate(this.LeftThigh, 0.0f, 0.2f, 0.0f);
        this.animator.rotate(this.RightFemur, 1.0f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftFemur, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 1.0f, 0.0f, 0.5f);
        this.animator.rotate(this.BodyTop, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.0f, 0.0f, 0.25f);
        this.animator.rotate(this.RightShoulder, -0.75f, 0.0f, 0.75f);
        this.animator.rotate(this.LeftShoulder, -0.75f, 0.0f, -0.75f);
        this.animator.rotate(this.RightForeArm, -0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -0.3f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0f, 4.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 4.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 2.0f, 0.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.5f, 0.5f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.1f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -1.0f, 0.0f, 0.5f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.0f, 0.0f, -0.4f);
        this.animator.rotate(this.RightShoulder, 0.5f, 0.0f, 0.25f);
        this.animator.rotate(this.LeftShoulder, 0.5f, 0.0f, -0.25f);
        this.animator.rotate(this.RightForeArm, -0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -0.3f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(5);
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, -2.0f, 0.0f);
        this.animator.move(this.Head, 0.0f, -2.0f, 0.0f);
        this.animator.rotate(this.RightThigh, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -2.0f, 0.0f, -0.75f);
        this.animator.rotate(this.RightFemur, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 1.0f, 0.0f, 0.5f);
        this.animator.rotate(this.Mouth, 1.0f, 0.0f, -0.5f);
        this.animator.rotate(this.BodyTop, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.0f, 0.0f, -0.25f);
        this.animator.rotate(this.RightShoulder, 0.8f, 0.0f, 0.75f);
        this.animator.rotate(this.LeftShoulder, 0.8f, 0.0f, -0.75f);
        this.animator.rotate(this.RightForeArm, -0.8f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -0.8f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0f, 4.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 2.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 4.0f, 0.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.5f, -0.5f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, -1.0f, 0.0f, 0.5f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.0f, 0.0f, 0.4f);
        this.animator.rotate(this.RightShoulder, 0.75f, 0.0f, 0.25f);
        this.animator.rotate(this.LeftShoulder, 0.75f, 0.0f, -0.25f);
        this.animator.rotate(this.RightForeArm, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -0.75f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.resetPhase(20);
    }

    private void animateStunned() {
        this.animator.setAnim(8);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 0.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 0.8f, 0.5f, 0.5f);
        this.animator.rotate(this.LeftShoulder, 0.8f, -0.5f, -0.5f);
        this.animator.rotate(this.RightForeArm, -1.6f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -1.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.move(this.BodyBottom, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.RightThigh, 0.0f, 1.0f, 5.0f);
        this.animator.move(this.LeftThigh, 0.0f, 1.0f, 5.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -2.0f, 0.0f, 0.5f);
        this.animator.rotate(this.RightForeArm, -1.5f, 0.0f, -1.0f);
        this.animator.rotate(this.LeftShoulder, -2.0f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftForeArm, -1.5f, 0.0f, 1.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(40);
        this.animator.startPhase(40);
        this.animator.move(this.BodyBottom, 0.0f, 19.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 19.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 19.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.9f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 2.2f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.6f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -2.0f, 0.5f, -0.25f);
        this.animator.rotate(this.RightForeArm, -0.75f, -0.5f, 0.0f);
        this.animator.rotate(this.LeftShoulder, -2.0f, -0.5f, 0.25f);
        this.animator.rotate(this.LeftForeArm, -0.75f, 0.5f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(240);
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0f, 14.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 14.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 14.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 1.8f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.8f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, -2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, -0.25f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(40);
    }

    private void animateSwat() {
        this.animator.setAnim(9);
        this.animator.startPhase(15);
        this.animator.move(this.BodyBottom, 0.0f, 4.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 4.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 4.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, 0.125f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.125f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.125f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.375f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 1.0f, 1.0f, 1.5f);
        this.animator.rotate(this.LeftShoulder, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -0.2f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftForeArm, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(25);
        this.animator.move(this.BodyBottom, 0.0f, 16.0f, 0.0f);
        this.animator.move(this.RightThigh, 0.0f, 16.0f, 0.0f);
        this.animator.move(this.LeftThigh, 0.0f, 16.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -1.0f, 0.5f, 0.0f);
        this.animator.rotate(this.LeftThigh, -1.0f, -0.5f, 0.0f);
        this.animator.rotate(this.RightFemur, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -2.0f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftShoulder, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -0.25f, 0.0f, -1.0f);
        this.animator.rotate(this.LeftForeArm, -0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateDeath() {
        this.animator.setAnim(10);
        this.animator.startPhase(40);
        this.animator.move(this.BodyBottom, 0.0f, 4.0f, -6.0f);
        this.animator.move(this.RightThigh, 0.0f, 4.0f, -6.0f);
        this.animator.move(this.LeftThigh, 0.0f, 4.0f, -6.0f);
        this.animator.move(this.Head, 0.0f, -2.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -0.5f, 0.0f, -0.5f);
        this.animator.rotate(this.LeftForeArm, -0.5f, 0.0f, -0.3f);
        this.animator.endPhase();
        this.animator.startPhase(40);
        this.animator.move(this.BodyBottom, 0.0f, 4.0f, -16.0f);
        this.animator.move(this.RightThigh, 0.0f, 4.0f, -16.0f);
        this.animator.move(this.LeftThigh, 0.0f, 4.0f, -16.0f);
        this.animator.move(this.Head, 0.0f, -5.0f, 0.0f);
        this.animator.rotate(this.RightThigh, 0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyTop, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyMiddle, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftShoulder, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.RightForeArm, -0.5f, 0.0f, -0.75f);
        this.animator.rotate(this.LeftForeArm, -0.5f, 0.0f, -0.3f);
        this.animator.endPhase();
        this.animator.startPhase(80);
        this.animator.move(this.BodyBottom, 0.0f, 28.0f, 16.0f);
        this.animator.move(this.RightThigh, 0.0f, 28.0f, 16.0f);
        this.animator.move(this.LeftThigh, 0.0f, 28.0f, 16.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -3.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftThigh, -3.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightFemur, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, -1.5f, 0.0f, 0.5f);
        this.animator.rotate(this.LeftShoulder, -1.5f, 0.0f, -0.5f);
        this.animator.rotate(this.RightForeArm, 0.0f, 0.0f, -0.25f);
        this.animator.rotate(this.LeftForeArm, 0.0f, 0.0f, 0.25f);
        this.animator.endPhase();
        this.animator.startPhase(80);
        this.animator.move(this.BodyBottom, 0.0f, 26.0f, 16.0f);
        this.animator.move(this.RightThigh, 0.0f, 28.0f, 16.0f);
        this.animator.move(this.LeftThigh, 0.0f, 28.0f, 16.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -2.0f, 0.25f, 0.0f);
        this.animator.rotate(this.LeftThigh, -2.0f, -0.25f, 0.0f);
        this.animator.rotate(this.RightFemur, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, -1.55f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 0.0f, 0.0f, 0.5f);
        this.animator.rotate(this.LeftShoulder, 0.0f, 0.0f, -0.5f);
        this.animator.rotate(this.RightForeArm, 0.0f, 0.0f, -0.25f);
        this.animator.rotate(this.LeftForeArm, 0.0f, 0.0f, 0.25f);
        this.animator.endPhase();
        this.animator.startPhase(200);
        this.animator.move(this.BodyBottom, 0.0f, 26.0f, 16.0f);
        this.animator.move(this.RightThigh, 0.0f, 28.0f, 16.0f);
        this.animator.move(this.LeftThigh, 0.0f, 28.0f, 16.0f);
        this.animator.move(this.Head, 0.0f, -7.0f, 0.0f);
        this.animator.rotate(this.RightThigh, -1.55f, 0.25f, 0.0f);
        this.animator.rotate(this.LeftThigh, -1.55f, -0.25f, 0.0f);
        this.animator.rotate(this.RightFemur, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.LeftFemur, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Mouth, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.BodyBottom, -1.55f, 0.0f, 0.0f);
        this.animator.rotate(this.RightShoulder, 0.0f, 0.0f, 0.5f);
        this.animator.rotate(this.LeftShoulder, 0.0f, 0.0f, -0.5f);
        this.animator.rotate(this.RightForeArm, 0.0f, 0.0f, -0.3f);
        this.animator.rotate(this.LeftForeArm, 0.0f, 0.0f, 0.3f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(1520);
        this.animator.resetPhase(0);
    }
}

