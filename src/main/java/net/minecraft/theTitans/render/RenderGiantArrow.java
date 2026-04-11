/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntitySkeletonTitanGiantArrow;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderGiantArrow
extends Render {
    private static final ResourceLocation arrowTextures = new ResourceLocation("textures/entity/arrow.png");

    public void doRender(EntitySkeletonTitanGiantArrow p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        if (!p_76986_1_.isInvisible()) {
            GL11.glPushMatrix();
            GL11.glEnable((int)2977);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            this.bindEntityTexture(p_76986_1_);
            GL11.glTranslatef((float)((float)p_76986_2_), (float)((float)p_76986_4_), (float)((float)p_76986_6_));
            GL11.glRotatef((float)(p_76986_1_.prevRotationYaw + (p_76986_1_.rotationYaw - p_76986_1_.prevRotationYaw) * p_76986_9_ - 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(p_76986_1_.prevRotationPitch + (p_76986_1_.rotationPitch - p_76986_1_.prevRotationPitch) * p_76986_9_), (float)0.0f, (float)0.0f, (float)1.0f);
            Tessellator tessellator = Tessellator.instance;
            int b0 = 0;
            float f2 = 0.0f;
            float f3 = 0.5f;
            float f4 = (float)(0 + b0 * 10) / 32.0f;
            float f5 = (float)(5 + b0 * 10) / 32.0f;
            float f6 = 0.0f;
            float f7 = 0.15625f;
            float f8 = (float)(5 + b0 * 10) / 32.0f;
            float f9 = (float)(10 + b0 * 10) / 32.0f;
            float f10 = 0.9f;
            GL11.glEnable((int)32826);
            GL11.glRotatef((float)45.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glScalef((float)f10, (float)f10, (float)f10);
            GL11.glTranslatef((float)-4.0f, (float)1.5f, (float)-1.5f);
            GL11.glNormal3f((float)f10, (float)0.0f, (float)0.0f);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-7.0, -2.0, -2.0, (double)f6, (double)f8);
            tessellator.addVertexWithUV(-7.0, -2.0, 2.0, (double)f7, (double)f8);
            tessellator.addVertexWithUV(-7.0, 2.0, 2.0, (double)f7, (double)f9);
            tessellator.addVertexWithUV(-7.0, 2.0, -2.0, (double)f6, (double)f9);
            tessellator.draw();
            GL11.glNormal3f((float)(-f10), (float)0.0f, (float)0.0f);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-7.0, 2.0, -2.0, (double)f6, (double)f8);
            tessellator.addVertexWithUV(-7.0, 2.0, 2.0, (double)f7, (double)f8);
            tessellator.addVertexWithUV(-7.0, -2.0, 2.0, (double)f7, (double)f9);
            tessellator.addVertexWithUV(-7.0, -2.0, -2.0, (double)f6, (double)f9);
            tessellator.draw();
            for (int i = 0; i < 4; ++i) {
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glNormal3f((float)0.0f, (float)0.0f, (float)f10);
                tessellator.startDrawingQuads();
                tessellator.addVertexWithUV(-8.0, -2.0, 0.0, (double)f2, (double)f4);
                tessellator.addVertexWithUV(8.0, -2.0, 0.0, (double)f3, (double)f4);
                tessellator.addVertexWithUV(8.0, 2.0, 0.0, (double)f3, (double)f5);
                tessellator.addVertexWithUV(-8.0, 2.0, 0.0, (double)f2, (double)f5);
                tessellator.draw();
            }
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    protected ResourceLocation getEntityTexture(EntitySkeletonTitanGiantArrow p_110775_1_) {
        return arrowTextures;
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntitySkeletonTitanGiantArrow)p_110775_1_);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntitySkeletonTitanGiantArrow)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}

