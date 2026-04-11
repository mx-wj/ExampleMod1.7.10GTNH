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

public class ModelWitherMachineGun
extends ModelBase {
    public ModelRenderer pole;
    public ModelRenderer head2;
    public ModelRenderer support;
    public ModelRenderer base;
    public ModelRenderer head1;

    public ModelWitherMachineGun() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.head1 = new ModelRenderer((ModelBase)this, 32, 0);
        this.head1.setRotationPoint(-10.0f, 14.0f, 0.0f);
        this.head1.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.base = new ModelRenderer((ModelBase)this, 0, 0);
        this.base.setRotationPoint(0.0f, 26.0f, 0.0f);
        this.base.addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.head2.setRotationPoint(10.0f, 14.0f, 0.0f);
        this.head2.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.support = new ModelRenderer((ModelBase)this, 0, 16);
        this.support.setRotationPoint(0.0f, 13.0f, 0.0f);
        this.support.addBox(-10.0f, 0.0f, -1.5f, 20, 3, 3, 0.0f);
        this.pole = new ModelRenderer((ModelBase)this, 12, 22);
        this.pole.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.pole.addBox(-1.5f, 0.0f, -1.5f, 3, 6, 3, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head1.render(f5);
        this.base.render(f5);
        this.head2.render(f5);
        this.support.render(f5);
        this.pole.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head1.rotateAngleX = f4 / 57.295776f;
        this.head2.rotateAngleX = f4 / 57.295776f;
        this.head1.rotateAngleY = f3 / 57.295776f;
        this.head2.rotateAngleY = f3 / 57.295776f;
        this.support.rotateAngleX = f4 / 57.295776f;
        this.pole.rotateAngleY = f3 / 57.295776f / 2.0f;
    }
}

