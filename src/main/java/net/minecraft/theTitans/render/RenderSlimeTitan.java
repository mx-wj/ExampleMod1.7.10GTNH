/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntitySlimeTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderSlimeTitan
extends RenderLiving {
    private static final ResourceLocation slimeTextures = new ResourceLocation("textures/entity/slime/slime.png");
    private ModelBase scaleAmount;

    public RenderSlimeTitan(ModelBase p_i1267_1_, ModelBase p_i1267_2_, float p_i1267_3_) {
        super(p_i1267_1_, p_i1267_3_);
        this.scaleAmount = p_i1267_2_;
    }

    protected int shouldRenderPass(EntitySlimeTitan p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.isInvisible()) {
            return 0;
        }
        if (p_77032_2_ == 0) {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable((int)2977);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            return 1;
        }
        if (p_77032_2_ == 1) {
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
        return -1;
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntitySlimeTitan)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    public void doRender(EntitySlimeTitan p_177124_1_, double p_177124_2_, double p_177124_4_, double p_177124_6_, float p_177124_8_, float p_177124_9_) {
        this.shadowSize = 0.25f * (float)p_177124_1_.getSlimeSize();
        super.doRender((EntityLiving)p_177124_1_, p_177124_2_, p_177124_4_, p_177124_6_, p_177124_8_, p_177124_9_);
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        GL11.glRotatef((float)(180.0f - p_77043_3_), (float)0.0f, (float)1.0f, (float)0.0f);
        if (p_77043_1_.deathTime > 0) {
            float f3 = ((float)p_77043_1_.deathTime + p_77043_4_ - 1.0f) / 20.0f * 1.6f;
            if ((f3 = MathHelper.sqrt_float((float)f3)) > 1.0f) {
                f3 = 1.0f;
            }
            GL11.glScalef((float)(1.0f + f3 * 2.0f), (float)(1.0f - f3 * 0.99f), (float)(1.0f + f3 * 2.0f));
        }
    }

    protected void preRenderCallback(EntitySlimeTitan p_77041_1_, float p_77041_2_) {
        float f1 = p_77041_1_.getSlimeSize();
        float f2 = (p_77041_1_.prevSquishFactor + (p_77041_1_.squishFactor - p_77041_1_.prevSquishFactor) * p_77041_2_) / (f1 * 0.5f + 1.0f);
        float f3 = 1.0f / (f2 + 1.0f);
        GL11.glScalef((float)(f3 * f1), (float)(1.0f / f3 * f1), (float)(f3 * f1));
        float fl = 16.0f;
        int i = p_77041_1_.getInvulTime();
        if (i > 0) {
            fl -= ((float)i - p_77041_2_) / 10.0f;
        }
        GL11.glScalef((float)fl, (float)fl, (float)fl);
        float f4 = 0.025f + (p_77041_1_.getDataWatcher().getWatchableObjectFloat(5) - p_77041_1_.getMaxHealth()) / p_77041_1_.getMaxHealth() * 0.5f;
        float f5 = 1.0f + MathHelper.cos((float)(((float)(p_77041_1_.ticksExisted + p_77041_1_.getEntityId()) + p_77041_2_) * f4)) * f4;
        float f6 = 1.0f + MathHelper.sin((float)(((float)(p_77041_1_.ticksExisted + p_77041_1_.getEntityId()) + p_77041_2_) * f4 + 0.785f)) * f4;
        if (p_77041_1_.deathTime <= 0) {
            GL11.glScalef((float)f5, (float)f6, (float)f5);
        }
        GL11.glTranslatef((float)0.0f, (float)0.0075f, (float)0.0f);
    }

    protected ResourceLocation getEntityTexture(EntitySlimeTitan entity) {
        return slimeTextures;
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntitySlimeTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntitySlimeTitan)p_77041_1_, p_77041_2_);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntitySlimeTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntitySlimeTitan)entity);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntitySlimeTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

