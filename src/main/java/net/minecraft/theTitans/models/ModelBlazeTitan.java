/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 */
package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityBlazeTitan;
import net.minecraft.util.MathHelper;

@SideOnly(value=Side.CLIENT)
public class ModelBlazeTitan
extends ModelBase {
    private ModelRenderer[] blazeSticks = new ModelRenderer[12];
    private ModelRenderer blazeHead;

    public ModelBlazeTitan() {
        this(0.0f);
    }

    public ModelBlazeTitan(float p_i1147_1_) {
        for (int i = 0; i < this.blazeSticks.length; ++i) {
            this.blazeSticks[i] = new ModelRenderer((ModelBase)this, 0, 16);
            this.blazeSticks[i].addBox(-1.0f, -4.0f, -1.0f, 2, 8, 2, p_i1147_1_);
        }
        this.blazeHead = new ModelRenderer((ModelBase)this, 0, 0);
        this.blazeHead.addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8, p_i1147_1_);
    }

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.blazeHead.render(p_78088_7_);
        for (int i = 0; i < this.blazeSticks.length; ++i) {
            this.blazeSticks[i].render(p_78088_7_);
        }
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        int i;
        EntityBlazeTitan entitytitan = (EntityBlazeTitan)p_78087_7_;
        float f6 = p_78087_3_ * (float)Math.PI * -0.008f;
        for (i = 0; i < 4; ++i) {
            this.blazeSticks[i].rotationPointY = 4.0f + MathHelper.cos((float)(((float)(i * 2) + p_78087_3_) * 0.03f));
            this.blazeSticks[i].rotationPointX = MathHelper.cos((float)f6) * 10.0f;
            this.blazeSticks[i].rotationPointZ = MathHelper.sin((float)f6) * 10.0f;
            this.blazeSticks[i].rotateAngleY = MathHelper.sin((float)f6) * 8.0f;
            if (entitytitan.func_70845_n()) {
                this.blazeSticks[i].rotateAngleX = MathHelper.cos((float)(p_78087_3_ * 0.1f)) * (float)Math.PI;
                this.blazeSticks[i].rotateAngleZ = MathHelper.sin((float)(p_78087_3_ * 0.1f)) * (float)Math.PI;
            } else {
                this.blazeSticks[i].rotateAngleX = 0.0f;
                this.blazeSticks[i].rotateAngleZ = 0.0f;
            }
            f6 += 1.0f;
        }
        f6 = 0.7853982f + p_78087_3_ * (float)Math.PI * 0.005f;
        for (i = 4; i < 8; ++i) {
            this.blazeSticks[i].rotationPointY = 10.0f + MathHelper.cos((float)(((float)(i * 3) + p_78087_3_) * 0.05f));
            this.blazeSticks[i].rotationPointX = MathHelper.cos((float)f6) * 7.0f;
            this.blazeSticks[i].rotationPointZ = MathHelper.sin((float)f6) * 7.0f;
            this.blazeSticks[i].rotateAngleY = MathHelper.sin((float)f6) * 12.0f;
            f6 += 1.0f;
        }
        f6 = 0.47123894f + p_78087_3_ * (float)Math.PI * -0.003f;
        for (i = 8; i < 12; ++i) {
            this.blazeSticks[i].rotationPointY = 17.0f + MathHelper.cos((float)(((float)i * 1.5f + p_78087_3_) * 0.02f));
            this.blazeSticks[i].rotationPointX = MathHelper.cos((float)f6) * 4.0f;
            this.blazeSticks[i].rotationPointZ = MathHelper.sin((float)f6) * 4.0f;
            this.blazeSticks[i].rotateAngleY = MathHelper.sin((float)f6) * 20.0f;
            f6 += 1.0f;
        }
        this.blazeHead.rotateAngleY = p_78087_4_ / 57.295776f;
        this.blazeHead.rotateAngleX = p_78087_5_ / 57.295776f;
        this.blazeHead.rotationPointY = 0.0f;
    }
}

