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
import java.util.Random;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderGammaLightning
extends Render {
    public RenderGammaLightning() {
        this.shadowSize = 0.0f;
    }

    public void doRender(EntityGammaLightning p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)p_76986_2_), (float)((float)p_76986_4_), (float)((float)p_76986_6_));
        Tessellator tessellator = Tessellator.instance;
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)1);
        double[] adouble = new double[8];
        double[] adouble1 = new double[8];
        double d3 = 0.0;
        double d4 = 0.0;
        Random random = new Random(p_76986_1_.boltVertex);
        for (int i = 7; i >= 0; --i) {
            adouble[i] = d3;
            adouble1[i] = d4;
            d3 += (double)(random.nextInt(11) - 5);
            d4 += (double)(random.nextInt(11) - 5);
        }
        for (int k1 = 0; k1 < 4; ++k1) {
            Random random1 = new Random(p_76986_1_.boltVertex);
            for (int j = 0; j < 3; ++j) {
                int k = 7;
                int l = 0;
                if (j > 0) {
                    k = 7 - j;
                }
                if (j > 0) {
                    l = k - 2;
                }
                double d5 = adouble[k] - d3;
                double d6 = adouble1[k] - d4;
                for (int i1 = k; i1 >= l; --i1) {
                    double d7 = d5;
                    double d8 = d6;
                    if (j == 0) {
                        d5 += (double)(random1.nextInt(11) - 5);
                        d6 += (double)(random1.nextInt(11) - 5);
                    } else {
                        d5 += (double)(random1.nextInt(31) - 15);
                        d6 += (double)(random1.nextInt(31) - 15);
                    }
                    tessellator.startDrawing(5);
                    tessellator.setColorRGBA_F(p_76986_1_.getRed(), p_76986_1_.getGreen(), p_76986_1_.getBlue(), 0.5f);
                    double d9 = 0.1 + (double)k1 * 0.2;
                    if (j == 0) {
                        d9 *= (double)i1 * 0.1 + 1.0;
                    }
                    double d10 = 0.1 + (double)k1 * 0.2;
                    if (j == 0) {
                        d10 *= (double)(i1 - 1) * 0.1 + 1.0;
                    }
                    for (int j1 = 0; j1 < 5; ++j1) {
                        double d11 = p_76986_2_ + 0.5 - d9;
                        double d12 = p_76986_6_ + 0.5 - d9;
                        if (j1 == 1 || j1 == 2) {
                            d11 += d9 * 2.0;
                        }
                        if (j1 == 2 || j1 == 3) {
                            d12 += d9 * 2.0;
                        }
                        double d13 = p_76986_2_ + 0.5 - d10;
                        double d14 = p_76986_6_ + 0.5 - d10;
                        if (j1 == 1 || j1 == 2) {
                            d13 += d10 * 2.0;
                        }
                        if (j1 == 2 || j1 == 3) {
                            d14 += d10 * 2.0;
                        }
                        tessellator.addVertex(d13 + d5, p_76986_4_ + (double)(i1 * 16), d14 + d6);
                        tessellator.addVertex(d11 + d7, p_76986_4_ + (double)((i1 + 1) * 16), d12 + d8);
                    }
                    tessellator.draw();
                }
            }
        }
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityGammaLightning p_110775_1_) {
        return null;
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntityGammaLightning)p_110775_1_);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityGammaLightning)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}

