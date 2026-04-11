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

public class ModelWitherTurret
extends ModelBase {
    private ModelRenderer Pole1;
    private ModelRenderer Pole2;
    private ModelRenderer Head;

    public ModelWitherTurret(float f) {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Pole1 = new ModelRenderer((ModelBase)this, 0, 22);
        this.Pole1.addBox(-1.5f, -10.0f, -1.5f, 3, 10, 3, f);
        this.Pole1.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.Pole2 = new ModelRenderer((ModelBase)this, 0, 22);
        this.Pole2.addBox(-1.5f, -10.0f, -1.5f, 3, 10, 3, f);
        this.Pole2.setRotationPoint(0.0f, 14.0f, 0.0f);
        this.Head = new ModelRenderer((ModelBase)this, 0, 0);
        this.Head.addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8, f);
        this.Head.setRotationPoint(0.0f, 2.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Pole1.render(f5);
        this.Pole2.render(f5);
        this.Head.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.rotateAngleY = f3 / 57.295776f;
        this.Head.rotateAngleX = f4 / 57.295776f;
    }
}

