/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWitherMortar
extends ModelBase {
    public ModelRenderer support;
    public ModelRenderer Head;
    public ModelRenderer backTripodLeg;
    public ModelRenderer rightFrontTripodLeg;
    public ModelRenderer leftFrontTripodLeg;
    public ModelRenderer backTripodLegTip;
    public ModelRenderer handle;

    public ModelWitherMortar() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.handle = new ModelRenderer((ModelBase)this, 24, 22);
        this.handle.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.handle.addBox(-5.5f, -1.0f, -1.0f, 11, 2, 2, 0.0f);
        this.Head = new ModelRenderer((ModelBase)this, 0, 0);
        this.Head.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.Head.addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8, 0.0f);
        this.backTripodLeg = new ModelRenderer((ModelBase)this, 0, 22);
        this.backTripodLeg.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.backTripodLeg.addBox(-1.5f, 0.0f, -1.5f, 3, 10, 3, 0.0f);
        this.setRotateAngle(this.backTripodLeg, 1.3089969f, 0.0f, 0.0f);
        this.support = new ModelRenderer((ModelBase)this, 0, 22);
        this.support.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.support.addBox(-1.5f, 0.0f, -1.5f, 3, 10, 3, 0.0f);
        this.backTripodLegTip = new ModelRenderer((ModelBase)this, 12, 22);
        this.backTripodLegTip.setRotationPoint(0.0f, 18.0f, 9.0f);
        this.backTripodLegTip.addBox(-1.5f, 0.0f, -1.5f, 3, 6, 3, 0.0f);
        this.rightFrontTripodLeg = new ModelRenderer((ModelBase)this, 24, 22);
        this.rightFrontTripodLeg.mirror = true;
        this.rightFrontTripodLeg.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.rightFrontTripodLeg.addBox(0.0f, -1.0f, -1.0f, 11, 2, 2, 0.0f);
        this.setRotateAngle(this.rightFrontTripodLeg, -0.61086524f, 2.6179938f, -0.87266463f);
        this.leftFrontTripodLeg = new ModelRenderer((ModelBase)this, 24, 22);
        this.leftFrontTripodLeg.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.leftFrontTripodLeg.addBox(-11.0f, -1.0f, -1.0f, 11, 2, 2, 0.0f);
        this.setRotateAngle(this.leftFrontTripodLeg, -0.61086524f, -2.6179938f, 0.87266463f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.handle.render(f5);
        this.Head.render(f5);
        this.backTripodLeg.render(f5);
        this.support.render(f5);
        this.backTripodLegTip.render(f5);
        this.rightFrontTripodLeg.render(f5);
        this.leftFrontTripodLeg.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.rotateAngleY = f3 / 57.295776f;
        this.Head.rotateAngleX = f4 / 57.295776f;
    }
}

