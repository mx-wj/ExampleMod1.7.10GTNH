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

public class ModelUltimaBlade
extends ModelBase {
    public ModelRenderer Handle;
    public ModelRenderer Guard;
    public ModelRenderer BladeLower;
    public ModelRenderer BladeTip;

    public ModelUltimaBlade() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.BladeTip = new ModelRenderer((ModelBase)this, 16, 48);
        this.BladeTip.setRotationPoint(0.0f, -72.0f, 0.0f);
        this.BladeTip.addBox(0.0f, -72.0f, -4.0f, 0, 72, 8, 0.0f);
        this.setRotateAngle(this.BladeTip, (float)(-Math.PI) / 180, 0.0f, 0.0f);
        this.Guard = new ModelRenderer((ModelBase)this, 48, 0);
        this.Guard.setRotationPoint(0.0f, -48.0f, 0.0f);
        this.Guard.addBox(-10.0f, -2.0f, -10.0f, 20, 2, 20, 0.0f);
        this.Handle = new ModelRenderer((ModelBase)this, 0, 0);
        this.Handle.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.Handle.addBox(-4.0f, -48.0f, -4.0f, 8, 48, 8, 0.0f);
        this.BladeLower = new ModelRenderer((ModelBase)this, 0, 48);
        this.BladeLower.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BladeLower.addBox(0.0f, -72.0f, -4.0f, 0, 72, 8, 0.0f);
        this.BladeLower.addChild(this.BladeTip);
        this.Handle.addChild(this.Guard);
        this.Guard.addChild(this.BladeLower);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Handle.render(f5);
    }

    public void render(float f5) {
        this.Handle.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

