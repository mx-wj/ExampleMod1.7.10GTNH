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
import net.minecraft.util.MathHelper;

public class ModelGhastTitan
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer tentacle1;
    public ModelRenderer tentacle2;
    public ModelRenderer tentacle3;
    public ModelRenderer tentacle4;
    public ModelRenderer tentacle5;
    public ModelRenderer tentacle6;
    public ModelRenderer tentacle7;
    public ModelRenderer tentacle8;
    public ModelRenderer tentacle9;
    public ModelRenderer tentacle11;
    public ModelRenderer tentacle111;
    public ModelRenderer tentacle22;
    public ModelRenderer tentacle222;
    public ModelRenderer tentacle2222;
    public ModelRenderer tentacle33;
    public ModelRenderer tentacle333;
    public ModelRenderer tentacle44;
    public ModelRenderer tentacle444;
    public ModelRenderer tentacle55;
    public ModelRenderer tentacle555;
    public ModelRenderer tentacle66;
    public ModelRenderer tentacle666;
    public ModelRenderer tentacle77;
    public ModelRenderer tentacle777;
    public ModelRenderer tentacle7777;
    public ModelRenderer tentacle88;
    public ModelRenderer tentacle888;
    public ModelRenderer tentacle99;
    public ModelRenderer tentacle999;
    public ModelRenderer tentacle9999;

    public ModelGhastTitan() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.tentacle55 = new ModelRenderer((ModelBase)this, 0, 3);
        this.tentacle55.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle55.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle666 = new ModelRenderer((ModelBase)this, 0, 6);
        this.tentacle666.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle666.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.tentacle2222 = new ModelRenderer((ModelBase)this, 0, 10);
        this.tentacle2222.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.tentacle2222.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.tentacle111 = new ModelRenderer((ModelBase)this, 0, 6);
        this.tentacle111.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle111.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.tentacle9999 = new ModelRenderer((ModelBase)this, 0, 10);
        this.tentacle9999.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.tentacle9999.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.tentacle4 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tentacle4.setRotationPoint(-5.0f, 7.0f, 0.0f);
        this.tentacle4.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle7777 = new ModelRenderer((ModelBase)this, 0, 10);
        this.tentacle7777.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.tentacle7777.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.tentacle333 = new ModelRenderer((ModelBase)this, 0, 6);
        this.tentacle333.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle333.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle77 = new ModelRenderer((ModelBase)this, 0, 3);
        this.tentacle77.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle77.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle66 = new ModelRenderer((ModelBase)this, 0, 3);
        this.tentacle66.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle66.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle555 = new ModelRenderer((ModelBase)this, 0, 6);
        this.tentacle555.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle555.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.tentacle88 = new ModelRenderer((ModelBase)this, 0, 3);
        this.tentacle88.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle88.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle6 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tentacle6.setRotationPoint(5.0f, 7.0f, 0.0f);
        this.tentacle6.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tentacle1.setRotationPoint(5.0f, 7.0f, -5.0f);
        this.tentacle1.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle11 = new ModelRenderer((ModelBase)this, 0, 3);
        this.tentacle11.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle11.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle444 = new ModelRenderer((ModelBase)this, 0, 6);
        this.tentacle444.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle444.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.body.addBox(-8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f);
        this.tentacle777 = new ModelRenderer((ModelBase)this, 0, 6);
        this.tentacle777.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle777.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.tentacle7 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tentacle7.setRotationPoint(5.0f, 7.0f, 5.0f);
        this.tentacle7.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle8 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tentacle8.setRotationPoint(0.0f, 7.0f, 5.0f);
        this.tentacle8.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle888 = new ModelRenderer((ModelBase)this, 0, 6);
        this.tentacle888.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle888.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.tentacle222 = new ModelRenderer((ModelBase)this, 0, 6);
        this.tentacle222.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle222.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.tentacle33 = new ModelRenderer((ModelBase)this, 0, 3);
        this.tentacle33.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle33.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tentacle2.setRotationPoint(0.0f, 7.0f, -5.0f);
        this.tentacle2.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tentacle3.setRotationPoint(-5.0f, 7.0f, -5.0f);
        this.tentacle3.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle44 = new ModelRenderer((ModelBase)this, 0, 3);
        this.tentacle44.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle44.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle22 = new ModelRenderer((ModelBase)this, 0, 3);
        this.tentacle22.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle22.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle99 = new ModelRenderer((ModelBase)this, 0, 3);
        this.tentacle99.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle99.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle5 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tentacle5.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.tentacle5.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle9 = new ModelRenderer((ModelBase)this, 0, 0);
        this.tentacle9.setRotationPoint(-5.0f, 7.0f, 5.0f);
        this.tentacle9.addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2, 0.0f);
        this.tentacle999 = new ModelRenderer((ModelBase)this, 0, 6);
        this.tentacle999.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.tentacle999.addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f);
        this.tentacle5.addChild(this.tentacle55);
        this.tentacle66.addChild(this.tentacle666);
        this.tentacle222.addChild(this.tentacle2222);
        this.tentacle11.addChild(this.tentacle111);
        this.tentacle999.addChild(this.tentacle9999);
        this.body.addChild(this.tentacle4);
        this.tentacle777.addChild(this.tentacle7777);
        this.tentacle33.addChild(this.tentacle333);
        this.tentacle7.addChild(this.tentacle77);
        this.tentacle6.addChild(this.tentacle66);
        this.tentacle55.addChild(this.tentacle555);
        this.tentacle8.addChild(this.tentacle88);
        this.body.addChild(this.tentacle6);
        this.body.addChild(this.tentacle1);
        this.tentacle1.addChild(this.tentacle11);
        this.tentacle44.addChild(this.tentacle444);
        this.tentacle77.addChild(this.tentacle777);
        this.body.addChild(this.tentacle7);
        this.body.addChild(this.tentacle8);
        this.tentacle88.addChild(this.tentacle888);
        this.tentacle22.addChild(this.tentacle222);
        this.tentacle3.addChild(this.tentacle33);
        this.body.addChild(this.tentacle2);
        this.body.addChild(this.tentacle3);
        this.tentacle4.addChild(this.tentacle44);
        this.tentacle2.addChild(this.tentacle22);
        this.tentacle9.addChild(this.tentacle99);
        this.body.addChild(this.tentacle5);
        this.body.addChild(this.tentacle9);
        this.tentacle99.addChild(this.tentacle999);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.render(f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        this.body.rotateAngleY = p_78087_4_ / 57.295776f;
        this.body.rotateAngleX = p_78087_5_ / 57.295776f;
        this.tentacle1.rotateAngleX = 0.1f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 1.0f)) + 0.5f;
        this.tentacle11.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 2.0f)) + 0.2f;
        this.tentacle111.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 3.0f)) + 0.2f;
        this.tentacle2.rotateAngleX = 0.1f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 1.5f)) + 0.5f;
        this.tentacle22.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 2.5f)) + 0.2f;
        this.tentacle222.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 3.5f)) + 0.2f;
        this.tentacle2222.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 4.5f)) + 0.2f;
        this.tentacle3.rotateAngleX = 0.1f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 2.0f)) + 0.5f;
        this.tentacle33.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 3.0f)) + 0.2f;
        this.tentacle333.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 4.0f)) + 0.2f;
        this.tentacle4.rotateAngleX = 0.1f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 2.5f)) + 0.5f;
        this.tentacle44.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 3.5f)) + 0.2f;
        this.tentacle444.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 4.5f)) + 0.2f;
        this.tentacle5.rotateAngleX = 0.1f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 3.0f)) + 0.5f;
        this.tentacle55.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 4.0f)) + 0.2f;
        this.tentacle555.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 5.0f)) + 0.2f;
        this.tentacle6.rotateAngleX = 0.1f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 3.5f)) + 0.5f;
        this.tentacle66.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 4.5f)) + 0.2f;
        this.tentacle666.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 5.5f)) + 0.2f;
        this.tentacle7.rotateAngleX = 0.1f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 4.0f)) + 0.5f;
        this.tentacle77.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 5.0f)) + 0.2f;
        this.tentacle777.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 6.0f)) + 0.2f;
        this.tentacle7777.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 7.0f)) + 0.2f;
        this.tentacle8.rotateAngleX = 0.1f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 4.5f)) + 0.5f;
        this.tentacle88.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 5.5f)) + 0.2f;
        this.tentacle888.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 6.5f)) + 0.2f;
        this.tentacle9.rotateAngleX = 0.1f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 5.0f)) + 0.5f;
        this.tentacle99.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 6.0f)) + 0.2f;
        this.tentacle999.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 7.0f)) + 0.2f;
        this.tentacle9999.rotateAngleX = 0.2f * MathHelper.sin((float)(p_78087_3_ * 0.075f - 8.0f)) + 0.2f;
    }
}

