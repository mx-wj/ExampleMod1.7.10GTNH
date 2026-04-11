/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(value=Side.CLIENT)
public class ModelSlimeTitan
extends ModelBase {
    ModelRenderer slimeBodies;
    ModelRenderer slimeRightEye;
    ModelRenderer slimeLeftEye;
    ModelRenderer slimeMouth;

    public ModelSlimeTitan(int p_i1157_1_) {
        this.slimeBodies = new ModelRenderer((ModelBase)this, 0, p_i1157_1_);
        this.slimeBodies.addBox(-4.0f, 16.0f, -4.0f, 8, 8, 8);
        if (p_i1157_1_ > 0) {
            this.slimeBodies = new ModelRenderer((ModelBase)this, 0, p_i1157_1_);
            this.slimeBodies.addBox(-3.0f, 17.0f, -3.0f, 6, 6, 6);
            this.slimeRightEye = new ModelRenderer((ModelBase)this, 32, 0);
            this.slimeRightEye.addBox(-1.0f, -1.0f, -1.0f, 2, 2, 2);
            this.slimeRightEye.setRotationPoint(-2.25f, 19.0f, -2.5f);
            this.slimeLeftEye = new ModelRenderer((ModelBase)this, 32, 4);
            this.slimeLeftEye.addBox(-1.0f, -1.0f, -1.0f, 2, 2, 2);
            this.slimeLeftEye.setRotationPoint(2.25f, 19.0f, -2.5f);
            this.slimeMouth = new ModelRenderer((ModelBase)this, 32, 8);
            this.slimeMouth.addBox(0.0f, 21.0f, -3.5f, 1, 1, 1);
        }
    }

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.slimeBodies.render(p_78088_7_);
        if (this.slimeRightEye != null) {
            this.slimeRightEye.render(p_78088_7_);
            this.slimeLeftEye.render(p_78088_7_);
            this.slimeMouth.render(p_78088_7_);
        }
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        if (this.slimeRightEye != null) {
            this.slimeRightEye.rotateAngleY = p_78087_4_ / 57.295776f;
            this.slimeRightEye.rotateAngleX = p_78087_5_ / 57.295776f;
        }
        if (this.slimeLeftEye != null) {
            this.slimeLeftEye.rotateAngleY = p_78087_4_ / 57.295776f;
            this.slimeLeftEye.rotateAngleX = p_78087_5_ / 57.295776f;
        }
    }
}

