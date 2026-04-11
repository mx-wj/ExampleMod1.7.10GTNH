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
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;

public class ModelOmegafish
extends ModelBase {
    public ModelRenderer BodyCenter;
    public ModelRenderer Tail1;
    public ModelRenderer Fuzz1;
    public ModelRenderer FrontBody;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Fuzz3;
    public ModelRenderer TailTip;
    public ModelRenderer Head;
    public ModelRenderer Fuzz2;
    private Animator animator;

    public ModelOmegafish() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.TailTip = new ModelRenderer((ModelBase)this, 13, 4);
        this.TailTip.setRotationPoint(0.0f, 0.0f, 2.0f);
        this.TailTip.addBox(-0.5f, -0.5f, 0.0f, 1, 1, 2, 0.0f);
        this.Fuzz1 = new ModelRenderer((ModelBase)this, 20, 0);
        this.Fuzz1.setRotationPoint(0.0f, 2.0f, 0.0f);
        this.Fuzz1.addBox(-5.0f, -8.0f, -1.5f, 10, 8, 3, 0.0f);
        this.Tail3 = new ModelRenderer((ModelBase)this, 11, 0);
        this.Tail3.setRotationPoint(0.0f, 0.5f, 3.0f);
        this.Tail3.addBox(-1.0f, -0.5f, 0.0f, 2, 1, 2, 0.0f);
        this.Fuzz3 = new ModelRenderer((ModelBase)this, 20, 11);
        this.Fuzz3.setRotationPoint(0.0f, 1.0f, 1.5f);
        this.Fuzz3.addBox(-3.0f, -4.0f, -1.5f, 6, 4, 3, 0.0f);
        this.Head = new ModelRenderer((ModelBase)this, 0, 0);
        this.Head.setRotationPoint(0.0f, 0.5f, -2.0f);
        this.Head.addBox(-1.5f, -1.0f, -2.0f, 3, 2, 2, 0.0f);
        this.BodyCenter = new ModelRenderer((ModelBase)this, 0, 9);
        this.BodyCenter.setRotationPoint(0.0f, 22.0f, 1.0f);
        this.BodyCenter.addBox(-3.0f, -2.0f, -1.5f, 6, 4, 3, 0.0f);
        this.FrontBody = new ModelRenderer((ModelBase)this, 0, 4);
        this.FrontBody.setRotationPoint(0.0f, 0.5f, -1.5f);
        this.FrontBody.addBox(-2.0f, -1.5f, -2.0f, 4, 3, 2, 0.0f);
        this.Tail2 = new ModelRenderer((ModelBase)this, 0, 22);
        this.Tail2.setRotationPoint(0.0f, 0.5f, 3.0f);
        this.Tail2.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3, 0.0f);
        this.Tail1 = new ModelRenderer((ModelBase)this, 0, 16);
        this.Tail1.setRotationPoint(0.0f, 0.5f, 1.5f);
        this.Tail1.addBox(-1.5f, -1.5f, 0.0f, 3, 3, 3, 0.0f);
        this.Fuzz2 = new ModelRenderer((ModelBase)this, 20, 18);
        this.Fuzz2.setRotationPoint(0.0f, 1.5f, -0.5f);
        this.Fuzz2.addBox(-3.0f, -5.0f, -1.5f, 6, 5, 2, 0.0f);
        this.Tail3.addChild(this.TailTip);
        this.BodyCenter.addChild(this.Fuzz1);
        this.Tail2.addChild(this.Tail3);
        this.Tail2.addChild(this.Fuzz3);
        this.FrontBody.addChild(this.Head);
        this.BodyCenter.addChild(this.FrontBody);
        this.Tail1.addChild(this.Tail2);
        this.BodyCenter.addChild(this.Tail1);
        this.FrontBody.addChild(this.Fuzz2);
        this.animator = new Animator(this);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animate((IAnimatedEntity)entity, f, f1, f2, f3, f4, f5);
        this.BodyCenter.render(f5);
    }

    public void setAngles() {
        this.BodyCenter.rotationPointY = 22.0f;
        this.BodyCenter.rotationPointX = 0.0f;
        this.BodyCenter.rotationPointZ = 1.0f;
        this.FrontBody.rotationPointY = 0.5f;
        this.FrontBody.rotationPointX = 0.0f;
        this.FrontBody.rotationPointZ = -1.5f;
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        this.setAngles();
        EntitySilverfishTitan entitytitan = (EntitySilverfishTitan)entity;
        if (entitytitan.deathTicks <= 0) {
            if (entitytitan.getAnimID() == 0) {
                this.FrontBody.rotateAngleX = (-0.01f + 0.01f * MathHelper.cos((float)(f2 * 0.1f))) * (float)Math.PI;
                this.Head.rotateAngleX = (0.01f + -0.01f * MathHelper.cos((float)(f2 * 0.1f))) * (float)Math.PI;
                this.Head.rotateAngleY = -(MathHelper.cos((float)(f * 0.25f)) * 0.25f * f1);
                this.FrontBody.rotateAngleY = MathHelper.cos((float)(f * 0.25f - 0.5f)) * 0.25f * f1;
                this.BodyCenter.rotateAngleY = MathHelper.cos((float)(f * 0.25f - 1.0f)) * 0.25f * f1;
                this.Tail1.rotateAngleY = -(f3 * (float)Math.PI / 180.0f / 4.0f) + 0.01f * MathHelper.cos((float)(f2 * 0.1f - 1.0f)) * (float)Math.PI + MathHelper.cos((float)(f * 0.5f - 1.5f)) * 0.25f * f1;
                this.Tail2.rotateAngleY = -(f3 * (float)Math.PI / 180.0f / 4.0f) + 0.01f * MathHelper.cos((float)(f2 * 0.1f - 1.5f)) * (float)Math.PI + MathHelper.cos((float)(f * 0.5f - 2.0f)) * 0.25f * f1;
                this.Tail3.rotateAngleY = -(f3 * (float)Math.PI / 180.0f / 4.0f) + 0.01f * MathHelper.cos((float)(f2 * 0.1f - 2.0f)) * (float)Math.PI + MathHelper.cos((float)(f * 0.5f - 2.5f)) * 0.25f * f1;
                this.TailTip.rotateAngleY = -(f3 * (float)Math.PI / 180.0f / 4.0f) + 0.01f * MathHelper.cos((float)(f2 * 0.1f - 2.5f)) * (float)Math.PI + MathHelper.cos((float)(f * 0.5f - 3.0f)) * 0.25f * f1;
            }
            if (!entitytitan.onGround && !this.isRiding && entitytitan.getAnimID() != 2) {
                this.Head.rotateAngleY = -(MathHelper.cos((float)(f * 0.35f)) * 0.5f * f1);
                this.FrontBody.rotateAngleY = MathHelper.cos((float)(f * 0.35f - 0.5f)) * 0.25f * f1;
                this.BodyCenter.rotateAngleY = MathHelper.cos((float)(f * 0.35f - 1.0f)) * 0.25f * f1;
                this.Tail1.rotateAngleY = MathHelper.cos((float)(f * 0.35f - 1.5f)) * 0.5f * f1;
                this.Tail2.rotateAngleY = MathHelper.cos((float)(f * 0.35f - 2.0f)) * 0.5f * f1;
                this.Tail3.rotateAngleY = MathHelper.cos((float)(f * 0.35f - 2.5f)) * 0.5f * f1;
                this.TailTip.rotateAngleY = MathHelper.cos((float)(f * 0.35f - 3.0f)) * 0.5f * f1;
                this.Tail1.rotateAngleX += MathHelper.cos((float)(f * 0.35f - 1.5f)) * 0.1f * f1 - 0.25f + entitytitan.limbSwingAmount / 4.0f;
                this.Tail2.rotateAngleX += MathHelper.cos((float)(f * 0.35f - 2.0f)) * 0.1f * f1 - 0.25f + entitytitan.limbSwingAmount / 4.0f;
                this.Tail3.rotateAngleX += MathHelper.cos((float)(f * 0.35f - 2.5f)) * 0.1f * f1 - 0.25f + entitytitan.limbSwingAmount / 4.0f;
                this.TailTip.rotateAngleX += MathHelper.cos((float)(f * 0.35f - 3.0f)) * 0.1f * f1 - 0.25f + entitytitan.limbSwingAmount / 4.0f;
            }
            float faceYaw = f3 * (float)Math.PI / 180.0f;
            float facePitch = f4 * (float)Math.PI / 180.0f;
            this.Head.rotateAngleX += facePitch * 0.45f;
            this.Head.rotateAngleY += faceYaw * 0.45f;
            this.FrontBody.rotateAngleX += facePitch * 0.45f;
            this.FrontBody.rotateAngleY += faceYaw * 0.45f;
            if (entitytitan.getAnimID() == 11) {
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
            this.animateBodySlam();
            this.animateIncapacitated();
            this.animateLightningShot();
            this.animateTailSwipeL();
            this.animateTailSwipeR();
            this.animateHeadButt();
            this.animateTailSmash();
            this.animateUnburrow();
            this.animateBurrow();
            this.animateBirth();
        } else {
            this.animateDeath();
        }
    }

    private void animateAntiTitanAttack1() {
        this.animator.setAnim(11);
        this.animator.startPhase(10);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, 6.0f);
        this.animator.rotate(this.Tail1, -0.05f, -0.6f, 0.0f);
        this.animator.rotate(this.Tail2, -0.05f, -0.6f, 0.0f);
        this.animator.rotate(this.Tail3, -0.05f, -0.6f, 0.0f);
        this.animator.rotate(this.TailTip, -0.05f, -0.6f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, -0.75f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, 0.15f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.15f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, -12.0f);
        this.animator.rotate(this.Tail1, 1.0f, 0.6f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, 0.6f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, 0.6f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.6f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 4.0f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, -0.15f, -0.2f);
        this.animator.rotate(this.FrontBody, 0.0f, -0.15f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.BodyCenter, 0.0f, 6.3f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateAntiTitanAttack2() {
        this.animator.setAnim(11);
        this.animator.startPhase(10);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, 6.0f);
        this.animator.rotate(this.Tail1, -0.05f, 0.6f, 0.0f);
        this.animator.rotate(this.Tail2, -0.05f, 0.6f, 0.0f);
        this.animator.rotate(this.Tail3, -0.05f, 0.6f, 0.0f);
        this.animator.rotate(this.TailTip, -0.05f, 0.6f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.75f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, -0.15f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, -0.15f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, -12.0f);
        this.animator.rotate(this.Tail1, 1.0f, -0.6f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, -0.6f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, -0.6f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, -0.6f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, -4.0f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, 0.15f, 0.2f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.15f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.BodyCenter, 0.0f, -6.3f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateAntiTitanAttack3() {
        this.animator.setAnim(11);
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.4f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.4f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.4f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.4f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0f, 0.0f, -0.3f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, -0.5f);
        this.animator.rotate(this.Tail1, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 2.0f, 0.0f, -1.0f);
        this.animator.move(this.BodyCenter, 0.0f, -8.0f, -16.0f);
        this.animator.endPhase();
        this.animator.resetPhase(10);
    }

    private void animateAntiTitanAttack4() {
        this.animator.setAnim(11);
        this.animator.startPhase(10);
        this.animator.rotate(this.Tail1, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -0.6f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.8f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyCenter, 0.0f, -8.0f, -16.0f);
        this.animator.rotate(this.Tail1, -0.5f, 0.2f, 0.0f);
        this.animator.rotate(this.Tail2, -0.5f, 0.2f, 0.0f);
        this.animator.rotate(this.Tail3, -0.5f, 0.2f, 0.0f);
        this.animator.rotate(this.TailTip, -0.5f, 0.2f, 0.0f);
        this.animator.rotate(this.BodyCenter, 1.5f, -4.0f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, 0.15f, 0.2f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.15f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.BodyCenter, 6.8f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateBurrow() {
        this.animator.setAnim(1);
        this.animator.startPhase(0);
        this.animator.move(this.BodyCenter, 0.0f, -8.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -2.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, -8.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, -0.4f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, -0.3f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.3f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, -0.4f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.4f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.4f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -0.4f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -0.4f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, -28.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 1.6f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, -6.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, -0.4f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, -0.3f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, -0.3f, 0.0f);
        this.animator.rotate(this.BodyCenter, 1.6f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, -2.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, 0.4f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, 0.3f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.3f, 0.0f);
        this.animator.rotate(this.BodyCenter, 1.6f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 2.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, -0.4f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, -0.3f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, -0.3f, 0.0f);
        this.animator.rotate(this.BodyCenter, 1.6f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 6.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, 0.4f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, 0.3f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.3f, 0.0f);
        this.animator.rotate(this.BodyCenter, 1.6f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 10.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateUnburrow() {
        this.animator.setAnim(2);
        this.animator.startPhase(0);
        this.animator.rotate(this.Head, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 8.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, -0.4f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, -0.3f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.3f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(10);
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -0.4f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, -24.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateTailSmash() {
        this.animator.setAnim(3);
        this.animator.startPhase(30);
        this.animator.rotate(this.Tail1, -0.05f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail2, -0.05f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail3, -0.05f, -0.5f, 0.0f);
        this.animator.rotate(this.TailTip, -0.05f, -0.5f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, -0.75f, 0.0f);
        this.animator.rotate(this.Head, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.25f, 0.75f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.9f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.7f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail3, 0.6f, -0.5f, 0.0f);
        this.animator.rotate(this.TailTip, 0.6f, -0.5f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, -0.8f, 0.0f);
        this.animator.rotate(this.Head, 0.4f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -0.4f, 0.8f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, -0.75f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.8f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateHeadButt() {
        this.animator.setAnim(4);
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -2.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, 2.0f);
        this.animator.rotate(this.Tail1, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, -0.4f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, -0.3f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.3f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Head, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, -4.0f);
        this.animator.rotate(this.Tail1, 0.0f, 0.75f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, 0.6f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.5f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(15);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateTailSwipeR() {
        this.animator.setAnim(5);
        this.animator.startPhase(20);
        this.animator.rotate(this.Tail1, -0.05f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail2, -0.05f, -0.4f, 0.0f);
        this.animator.rotate(this.Tail3, -0.05f, -0.3f, 0.0f);
        this.animator.rotate(this.TailTip, -0.05f, -0.3f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, 0.15f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.15f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Tail1, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, 0.4f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, 0.3f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.3f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 3.0f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, -0.15f, -0.2f);
        this.animator.rotate(this.FrontBody, 0.0f, -0.15f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateTailSwipeL() {
        this.animator.setAnim(6);
        this.animator.startPhase(20);
        this.animator.rotate(this.Tail1, -0.05f, 0.5f, 0.0f);
        this.animator.rotate(this.Tail2, -0.05f, 0.4f, 0.0f);
        this.animator.rotate(this.Tail3, -0.05f, 0.3f, 0.0f);
        this.animator.rotate(this.TailTip, -0.05f, 0.3f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, -0.15f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, -0.15f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Tail1, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, -0.4f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, -0.3f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, -0.3f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, -3.0f, 0.0f);
        this.animator.rotate(this.Head, 0.0f, 0.15f, -0.2f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.15f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateLightningShot() {
        this.animator.setAnim(7);
        this.animator.startPhase(20);
        this.animator.rotate(this.Tail1, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.25f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.2f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.4f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.1f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Tail1, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.25f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(25);
    }

    private void animateIncapacitated() {
        this.animator.setAnim(8);
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -0.7f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.7f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.0f, -1.25f);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 0.5f, 0.5f, -0.3f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, -0.3f);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.0f, -1.25f);
        this.animator.rotate(this.Tail1, 0.1f, -0.1f, 0.1f);
        this.animator.rotate(this.Tail2, 0.0f, -0.2f, -0.2f);
        this.animator.rotate(this.Tail3, 0.0f, 0.1f, 0.2f);
        this.animator.rotate(this.TailTip, 0.0f, 0.2f, 0.3f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(300);
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 3.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.3f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 0.0f, 0.5f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 0.0f, -0.5f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateBodySlam() {
        this.animator.setAnim(9);
        this.animator.startPhase(30);
        this.animator.rotate(this.Tail1, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -0.6f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.6f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.5f, -0.25f, 0.0f);
        this.animator.rotate(this.Tail2, 0.5f, -0.25f, 0.0f);
        this.animator.rotate(this.Tail3, 0.5f, -0.25f, 0.0f);
        this.animator.rotate(this.TailTip, 0.5f, -0.25f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.5f, 0.25f, 0.0f);
        this.animator.rotate(this.Tail2, 0.5f, 0.25f, 0.0f);
        this.animator.rotate(this.Tail3, 0.5f, 0.25f, 0.0f);
        this.animator.rotate(this.TailTip, 0.5f, 0.25f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.5f, -0.25f, 0.0f);
        this.animator.rotate(this.Tail2, 0.5f, -0.25f, 0.0f);
        this.animator.rotate(this.Tail3, 0.5f, -0.25f, 0.0f);
        this.animator.rotate(this.TailTip, 0.5f, -0.25f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Tail1, 0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Head, -0.6f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.8f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(60);
        this.animator.rotate(this.Head, 1.0f, 0.0f, -0.3f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, -0.5f);
        this.animator.rotate(this.Tail1, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -0.8f, 0.0f, -1.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(140);
        this.animator.rotate(this.Head, 1.5f, 0.0f, -0.5f);
        this.animator.rotate(this.FrontBody, 1.5f, 0.0f, -0.75f);
        this.animator.rotate(this.Tail1, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -2.0f, 0.0f, -1.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(40);
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 1.0f, 0.0f, -0.3f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, -0.75f);
        this.animator.rotate(this.Tail1, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 1.0f, 0.0f, -1.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 1.0f, 0.0f, -0.3f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, -0.75f);
        this.animator.rotate(this.Tail1, -0.75f, 1.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 1.0f, 0.0f, -1.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(40);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateDeath() {
        this.animator.setAnim(10);
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -0.7f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.25f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -3.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, -12.0f, 0.0f);
        this.animator.rotate(this.Tail1, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -3.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.Tail1, -0.2f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.2f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.2f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -0.2f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -3.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.2f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.1f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.1f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(40);
        this.animator.rotate(this.Head, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -3.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.Tail1, -0.6f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -0.3f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.4f);
        this.animator.rotate(this.FrontBody, 1.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -3.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.Tail1, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.3f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.3f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.4f);
        this.animator.rotate(this.FrontBody, 2.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -3.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.Tail1, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0f, 0.0f, 0.4f);
        this.animator.rotate(this.FrontBody, 0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -3.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.Tail1, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.5f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -0.5f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, -0.6f, 0.0f, 0.5f);
        this.animator.rotate(this.FrontBody, -0.5f, 0.0f, 0.3f);
        this.animator.rotate(this.BodyCenter, -3.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.rotate(this.Tail1, 0.2f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.1f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.1f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(1760);
        this.animator.resetPhase(0);
    }

    private void animateBirth() {
        this.animator.setAnim(13);
        this.animator.startPhase(0);
        this.animator.rotate(this.Head, 1.5f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail1, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -2.0f, 0.0f, -1.5f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.endPhase();
        this.animator.setStationaryPhase(60);
        this.animator.startPhase(40);
        this.animator.rotate(this.Head, 1.25f, 0.0f, -0.5f);
        this.animator.rotate(this.FrontBody, 1.25f, 0.0f, -0.5f);
        this.animator.rotate(this.Tail1, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -1.25f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, -2.0f, 0.0f, -1.5f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(40);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.3f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.75f);
        this.animator.rotate(this.Tail1, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail2, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 1.0f, 0.0f, -1.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, -1.0f, 0.0f, 0.3f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.75f);
        this.animator.rotate(this.Tail1, -0.75f, 1.0f, 0.0f);
        this.animator.rotate(this.Tail2, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.Tail3, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.TailTip, -0.75f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 1.0f, 0.0f, -1.0f);
        this.animator.move(this.BodyCenter, 0.0f, 1.0f, 0.0f);
        this.animator.endPhase();
        this.animator.startPhase(40);
        this.animator.rotate(this.Head, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.FrontBody, 0.0f, 0.0f, 0.0f);
        this.animator.rotate(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.move(this.BodyCenter, 0.0f, 0.0f, 0.0f);
        this.animator.endPhase();
        this.animator.resetPhase(40);
    }
}

