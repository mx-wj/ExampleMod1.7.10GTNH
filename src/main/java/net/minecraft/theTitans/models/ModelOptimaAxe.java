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

public class ModelOptimaAxe
extends ModelBase {
    public ModelRenderer Grip;
    public ModelRenderer Handle;
    public ModelRenderer Blade1;
    public ModelRenderer Blade2;

    public ModelOptimaAxe() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Grip = new ModelRenderer((ModelBase)this, 0, 0);
        this.Grip.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.Grip.addBox(-8.0f, -48.0f, -8.0f, 16, 48, 16, 0.0f);
        this.Handle = new ModelRenderer((ModelBase)this, 96, 0);
        this.Handle.setRotationPoint(0.0f, -48.0f, 0.0f);
        this.Handle.addBox(-4.0f, -120.0f, -4.0f, 8, 120, 8, 0.0f);
        this.Blade2 = new ModelRenderer((ModelBase)this, 0, 16);
        this.Blade2.mirror = true;
        this.Blade2.setRotationPoint(0.0f, -116.0f, 0.0f);
        this.Blade2.addBox(0.0f, -32.0f, 4.0f, 0, 64, 48, 0.0f);
        this.setRotateAngle(this.Blade2, 0.0f, (float)Math.PI, 0.0f);
        this.Blade1 = new ModelRenderer((ModelBase)this, 0, 16);
        this.Blade1.setRotationPoint(0.0f, -116.0f, 0.0f);
        this.Blade1.addBox(0.0f, -32.0f, 4.0f, 0, 64, 48, 0.0f);
        this.Grip.addChild(this.Handle);
        this.Handle.addChild(this.Blade2);
        this.Handle.addChild(this.Blade1);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Grip.render(f5);
    }

    public void render(float f5) {
        this.Grip.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

