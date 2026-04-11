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

public class ModelBeam
extends ModelBase {
    public ModelRenderer shape1;

    public ModelBeam() {
        this.textureWidth = 32;
        this.textureHeight = 256;
        this.shape1 = new ModelRenderer((ModelBase)this, 0, -8);
        this.shape1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.shape1.addBox(-4.0f, -256.0f, -4.0f, 8, 256, 8, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.shape1.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

