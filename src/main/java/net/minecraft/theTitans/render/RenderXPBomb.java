/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderXPBomb
extends Render {
    private static final ResourceLocation experienceOrbTextures = new ResourceLocation("textures/entity/experience_orb.png");

    public RenderXPBomb() {
        this.shadowSize = 1.5f;
    }

    public void doRender(EntityXPBomb p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)p_76986_2_), (float)((float)p_76986_4_), (float)((float)p_76986_6_));
        this.bindEntityTexture((Entity)p_76986_1_);
        int i = 10;
        float f2 = (float)(i % 4 * 16 + 0) / 64.0f;
        float f3 = (float)(i % 4 * 16 + 16) / 64.0f;
        float f4 = (float)(i / 4 * 16 + 0) / 64.0f;
        float f5 = (float)(i / 4 * 16 + 16) / 64.0f;
        float f6 = 1.0f;
        float f7 = 0.5f;
        float f8 = 0.125f;
        int j = p_76986_1_.getBrightnessForRender(p_76986_9_);
        int k = j % 65536;
        int l = j / 65536;
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)((float)k / 1.0f), (float)((float)l / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        float f10 = 255.0f;
        float f11 = ((float)p_76986_1_.xpColor + p_76986_9_) / 2.0f;
        l = (int)((MathHelper.sin((float)(f11 + 0.0f)) + 1.0f) * 0.5f * f10);
        int i1 = (int)f10;
        int j1 = (int)((MathHelper.sin((float)(f11 + 4.1887903f)) + 1.0f) * 0.1f * f10);
        int k1 = l << 16 | i1 << 8 | j1;
        GL11.glRotatef((float)(180.0f - this.renderManager.playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-this.renderManager.playerViewX), (float)1.0f, (float)0.0f, (float)0.0f);
        float f9 = 4.0f;
        GL11.glScalef((float)f9, (float)f9, (float)f9);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(k1, 128);
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.addVertexWithUV((double)(0.0f - f7), (double)(0.0f - f8), 0.0, (double)f2, (double)f5);
        tessellator.addVertexWithUV((double)(f6 - f7), (double)(0.0f - f8), 0.0, (double)f3, (double)f5);
        tessellator.addVertexWithUV((double)(f6 - f7), (double)(1.0f - f8), 0.0, (double)f3, (double)f4);
        tessellator.addVertexWithUV((double)(0.0f - f7), (double)(1.0f - f8), 0.0, (double)f2, (double)f4);
        tessellator.draw();
        GL11.glDisable((int)3042);
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityXPBomb p_110775_1_) {
        return experienceOrbTextures;
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntityXPBomb)p_110775_1_);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityXPBomb)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}

