/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
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
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.theTitans.models.ModelEnderColossusCrystal;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderEnderColossusCrystal
extends Render {
    private static final ResourceLocation enderColossusCrystalBeamTextures = new ResourceLocation("thetitans", "textures/entities/endercrystal_beam.png");
    private static final ResourceLocation enderCrystalTextures = new ResourceLocation("thetitans", "textures/entities/crystal.png");
    private ModelBase field_76995_b;

    public RenderEnderColossusCrystal() {
        this.shadowSize = 1.0f;
        this.field_76995_b = new ModelEnderColossusCrystal(0.0f, true);
    }

    public void doRender(EntityEnderColossusCrystal entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        float f2 = (float)entity.innerRotation + partialTicks;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)x), (float)((float)y), (float)((float)z));
        this.bindTexture(enderCrystalTextures);
        float f3 = MathHelper.sin((float)(f2 * 0.2f)) / 2.0f + 0.5f;
        f3 += f3 * f3;
        this.field_76995_b.render((Entity)entity, 0.0f, f2 * 3.0f, f3 * 0.2f, 0.0f, 0.0f, 0.0625f);
        if (entity.hurtTime > 0 || !entity.isEntityAlive()) {
            GL11.glDepthFunc((int)514);
            GL11.glDisable((int)3553);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glColor4f((float)1.0f, (float)0.0f, (float)0.0f, (float)0.5f);
            this.field_76995_b.render((Entity)entity, 0.0f, f2 * 3.0f, f3 * 0.2f, 0.0f, 0.0f, 0.0625f);
            GL11.glEnable((int)3553);
            GL11.glDisable((int)3042);
            GL11.glDepthFunc((int)515);
        }
        GL11.glPopMatrix();
        if (entity.owner != null && !entity.owner.isStunned && entity.isEntityAlive()) {
            float f1 = (float)entity.ticksExisted + partialTicks;
            float f4 = (float)(entity.owner.posX - entity.posX - (entity.prevPosX - entity.posX) * (double)(1.0f - partialTicks));
            float f5 = (float)(entity.owner.posY - entity.posY + 48.0 + (double)f3 - (entity.prevPosY - entity.posY) * (double)(1.0f - partialTicks));
            float f6 = (float)(entity.owner.posZ - entity.posZ - (entity.prevPosZ - entity.posZ) * (double)(1.0f - partialTicks));
            float f7 = MathHelper.sqrt_float((float)(f4 * f4 + f6 * f6));
            float f8 = MathHelper.sqrt_float((float)(f4 * f4 + f5 * f5 + f6 * f6));
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)x), (float)((float)y + 1.0f), (float)((float)z));
            GL11.glRotatef((float)((float)(-Math.atan2(f6, f4)) * 180.0f / (float)Math.PI - 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)((float)(-Math.atan2(f7, f5)) * 180.0f / (float)Math.PI - 90.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            Tessellator tessellator = Tessellator.instance;
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable((int)2884);
            this.bindTexture(enderColossusCrystalBeamTextures);
            GL11.glShadeModel((int)7425);
            float f9 = f1 * 0.005f;
            float f10 = MathHelper.sqrt_float((float)(f4 * f4 + f5 * f5 + f6 * f6)) / 32.0f - f9;
            tessellator.startDrawing(5);
            int b0 = 64;
            int c0 = 0xF000F0;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)((float)j / 1.0f), (float)((float)k / 1.0f));
            GL11.glEnable((int)2896);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)2.0f);
            for (int i = 0; i <= b0; ++i) {
                float f11 = MathHelper.sin((float)((float)(i % b0) * (float)Math.PI * 2.0f / (float)b0)) * 0.75f;
                float f12 = MathHelper.cos((float)((float)(i % b0) * (float)Math.PI * 2.0f / (float)b0)) * 0.75f;
                float f13 = (float)(i % b0) * 1.0f / (float)b0;
                tessellator.setColorOpaque_I(0);
                tessellator.addVertexWithUV((double)(f11 * 0.2f), (double)(f12 * 0.2f), 0.0, (double)f13, (double)f10);
                tessellator.setColorOpaque_I(0xFFFFFF);
                tessellator.addVertexWithUV((double)f11, (double)f12, (double)f8, (double)f13, (double)f9);
            }
            tessellator.draw();
            GL11.glEnable((int)2884);
            GL11.glShadeModel((int)7424);
            RenderHelper.enableStandardItemLighting();
            GL11.glPopMatrix();
        }
    }

    protected ResourceLocation getEntityTexture(EntityEnderColossusCrystal p_110775_1_) {
        return enderCrystalTextures;
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntityEnderColossusCrystal)p_110775_1_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEnderColossusCrystal)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEnderColossusCrystal)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityEnderColossusCrystal)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}

