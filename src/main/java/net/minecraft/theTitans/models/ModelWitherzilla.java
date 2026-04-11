/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.MathHelper
 */
package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.util.MathHelper;

@SideOnly(value=Side.CLIENT)
public class ModelWitherzilla
extends ModelBase {
    private ModelRenderer[] spine;
    public ModelRenderer[] heads;

    public ModelWitherzilla() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.spine = new ModelRenderer[3];
        this.spine[0] = new ModelRenderer((ModelBase)this, 0, 16);
        this.spine[0].addBox(-10.0f, 3.9f, -0.5f, 20, 3, 3);
        this.spine[1] = new ModelRenderer((ModelBase)this).setTextureSize(this.textureWidth, this.textureHeight);
        this.spine[1].setRotationPoint(-2.0f, 6.9f, -0.5f);
        this.spine[1].setTextureOffset(0, 22).addBox(0.0f, 0.0f, 0.0f, 3, 10, 3);
        this.spine[1].setTextureOffset(24, 22).addBox(-4.0f, 1.5f, 0.5f, 11, 2, 2);
        this.spine[1].setTextureOffset(24, 22).addBox(-4.0f, 4.0f, 0.5f, 11, 2, 2);
        this.spine[1].setTextureOffset(24, 22).addBox(-4.0f, 6.5f, 0.5f, 11, 2, 2);
        this.spine[2] = new ModelRenderer((ModelBase)this, 12, 22);
        this.spine[2].addBox(0.0f, 0.0f, 0.0f, 3, 6, 3);
        this.heads = new ModelRenderer[3];
        this.heads[0] = new ModelRenderer((ModelBase)this, 0, 0);
        this.heads[0].addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.heads[1] = new ModelRenderer((ModelBase)this, 32, 0);
        this.heads[1].addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6);
        this.heads[2] = new ModelRenderer((ModelBase)this, 32, 0);
        this.heads[2].addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6);
    }

    public int func_82903_a() {
        return 32;
    }

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        for (ModelRenderer modelrenderer : this.heads) {
            modelrenderer.render(p_78088_7_);
        }
        for (ModelRenderer modelrenderer : this.spine) {
            modelrenderer.render(p_78088_7_);
        }
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        EntityWitherzilla entitytitan = (EntityWitherzilla)p_78087_7_;
        float f6 = MathHelper.cos((float)(p_78087_3_ * 0.025f));
        this.spine[1].rotateAngleX = (0.025f + 0.05f * f6) * (float)Math.PI;
        this.spine[2].setRotationPoint(-2.0f, 6.9f + MathHelper.cos((float)this.spine[1].rotateAngleX) * 10.0f, -0.5f + MathHelper.sin((float)this.spine[1].rotateAngleX) * 10.0f);
        this.spine[2].rotateAngleX = (0.265f + 0.1f * f6) * (float)Math.PI;
        this.heads[0].rotateAngleY = p_78087_4_ / 57.295776f;
        this.heads[0].rotateAngleX = p_78087_5_ / 57.295776f;
        if (entitytitan.getInvulTime() < 1000) {
            this.heads[0].setRotationPoint(0.0f, 0.0f, 0.0f);
            this.heads[1].setRotationPoint(-10.0f, 4.0f, 0.0f);
            this.heads[2].setRotationPoint(10.0f, 4.0f, 0.0f);
            this.spine[0].setRotationPoint(0.0f, 0.0f, 0.0f);
            this.spine[1].setRotationPoint(-2.0f, 6.9f, -0.5f);
        } else {
            this.heads[0].setRotationPoint((float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0));
            this.heads[1].setRotationPoint((float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0));
            this.heads[2].setRotationPoint((float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0));
            this.spine[0].setRotationPoint((float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0));
            this.spine[1].setRotationPoint((float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0));
            this.spine[2].setRotationPoint((float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0), (float)(entitytitan.getRNG().nextGaussian() * 2.0));
        }
    }

    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
        EntityWitherzilla entitywither = (EntityWitherzilla)p_78086_1_;
        for (int i = 1; i < 3; ++i) {
            this.heads[i].rotateAngleY = (entitywither.func_82207_a(i - 1) - p_78086_1_.renderYawOffset) / 57.295776f;
            this.heads[i].rotateAngleX = entitywither.func_82210_r(i - 1) / 57.295776f;
        }
    }
}

