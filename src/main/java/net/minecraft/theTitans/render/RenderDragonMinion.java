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
import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.theTitans.models.ModelDragonMinion;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderDragonMinion
extends RenderLiving {
    private static final ResourceLocation enderDragonExplodingTextures = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
    private static final ResourceLocation enderDragonCrystalBeamTextures = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");
    private static final ResourceLocation enderDragonEyesTextures = new ResourceLocation("textures/entity/enderdragon/dragon_eyes.png");
    private static final ResourceLocation enderDragonTextures = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    protected ModelDragonMinion modelDragon;

    public RenderDragonMinion() {
        super((ModelBase)new ModelDragonMinion(0.0f), 8.0f);
        this.modelDragon = (ModelDragonMinion)this.mainModel;
        this.setRenderPassModel(this.mainModel);
    }

    protected void rotateCorpse(EntityDragonMinion p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        float f3 = (float)p_77043_1_.getMovementOffsets(7, p_77043_4_)[0];
        float f4 = (float)(p_77043_1_.getMovementOffsets(5, p_77043_4_)[1] - p_77043_1_.getMovementOffsets(10, p_77043_4_)[1]);
        GL11.glRotatef((float)(-f3), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(f4 * 10.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)1.0f);
        if (p_77043_1_.deathTime > 0) {
            float f5 = ((float)p_77043_1_.deathTime + p_77043_4_ - 1.0f) / 20.0f * 1.6f;
            if ((f5 = MathHelper.sqrt_float((float)f5)) > 1.0f) {
                f5 = 1.0f;
            }
            GL11.glRotatef((float)(f5 * this.getDeathMaxRotation((EntityLivingBase)p_77043_1_)), (float)0.0f, (float)0.0f, (float)1.0f);
        }
    }

    protected void renderModel(EntityDragonMinion p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
        if (p_77036_1_.deathTicks > 0) {
            float f6 = (float)p_77036_1_.deathTicks / 200.0f;
            GL11.glDepthFunc((int)515);
            GL11.glEnable((int)3008);
            GL11.glAlphaFunc((int)516, (float)f6);
            this.bindTexture(enderDragonExplodingTextures);
            this.mainModel.render((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
            GL11.glAlphaFunc((int)516, (float)0.1f);
            GL11.glDepthFunc((int)514);
        }
        this.bindEntityTexture((Entity)p_77036_1_);
        this.mainModel.render((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
        if (p_77036_1_.hurtTime > 0) {
            GL11.glDepthFunc((int)514);
            GL11.glDisable((int)3553);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glColor4f((float)1.0f, (float)0.0f, (float)0.0f, (float)0.5f);
            this.mainModel.render((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
            GL11.glEnable((int)3553);
            GL11.glDisable((int)3042);
            GL11.glDepthFunc((int)515);
        }
    }

    public void doRender(EntityDragonMinion p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        if (p_76986_1_.healingEnderCrystal != null) {
            float f2 = (float)p_76986_1_.healingEnderCrystal.innerRotation + p_76986_9_;
            float f3 = MathHelper.sin((float)(f2 * 0.2f)) / 2.0f + 0.5f;
            f3 = (f3 * f3 + f3) * 0.2f;
            float f4 = (float)(p_76986_1_.healingEnderCrystal.posX - p_76986_1_.posX - (p_76986_1_.prevPosX - p_76986_1_.posX) * (double)(1.0f - p_76986_9_));
            float f5 = (float)((double)f3 + p_76986_1_.healingEnderCrystal.posY - 1.0 - p_76986_1_.posY - (p_76986_1_.prevPosY - p_76986_1_.posY) * (double)(1.0f - p_76986_9_));
            float f6 = (float)(p_76986_1_.healingEnderCrystal.posZ - p_76986_1_.posZ - (p_76986_1_.prevPosZ - p_76986_1_.posZ) * (double)(1.0f - p_76986_9_));
            float f7 = MathHelper.sqrt_float((float)(f4 * f4 + f6 * f6));
            float f8 = MathHelper.sqrt_float((float)(f4 * f4 + f5 * f5 + f6 * f6));
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)p_76986_2_), (float)((float)p_76986_4_ + 2.0f), (float)((float)p_76986_6_));
            GL11.glRotatef((float)((float)(-Math.atan2(f6, f4)) * 180.0f / (float)Math.PI - 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)((float)(-Math.atan2(f7, f5)) * 180.0f / (float)Math.PI - 90.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            Tessellator tessellator = Tessellator.instance;
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable((int)2884);
            this.bindTexture(enderDragonCrystalBeamTextures);
            GL11.glShadeModel((int)7425);
            float f9 = 0.0f - ((float)p_76986_1_.ticksExisted + p_76986_9_) * 0.01f;
            float f10 = MathHelper.sqrt_float((float)(f4 * f4 + f5 * f5 + f6 * f6)) / 32.0f - ((float)p_76986_1_.ticksExisted + p_76986_9_) * 0.01f;
            tessellator.startDrawing(5);
            int b0 = 8;
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

    protected ResourceLocation getEntityTexture(EntityDragonMinion p_110775_1_) {
        return enderDragonTextures;
    }

    protected void renderEquippedItems(EntityDragonMinion p_77029_1_, float p_77029_2_) {
        super.renderEquippedItems((EntityLivingBase)p_77029_1_, p_77029_2_);
        Tessellator tessellator = Tessellator.instance;
        if (p_77029_1_.deathTicks > 0) {
            RenderHelper.disableStandardItemLighting();
            float f1 = ((float)p_77029_1_.deathTicks + p_77029_2_) / 200.0f;
            float f2 = 0.0f;
            if (f1 > 0.8f) {
                f2 = (f1 - 0.8f) / 0.2f;
            }
            Random random = new Random(432L);
            GL11.glDisable((int)3553);
            GL11.glShadeModel((int)7425);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)1);
            GL11.glDisable((int)3008);
            GL11.glEnable((int)2884);
            GL11.glDepthMask((boolean)false);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)0.0f, (float)-1.0f, (float)-2.0f);
            int i = 0;
            while ((float)i < (f1 + f1 * f1) / 2.0f * 60.0f) {
                GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(random.nextFloat() * 360.0f + f1 * 90.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                tessellator.startDrawing(6);
                float f3 = random.nextFloat() * 20.0f + 5.0f + f2 * 10.0f;
                float f4 = random.nextFloat() * 2.0f + 1.0f + f2 * 2.0f;
                tessellator.setColorRGBA_I(0xFFFFFF, (int)(255.0f * (1.0f - f2)));
                tessellator.addVertex(0.0, 0.0, 0.0);
                tessellator.setColorRGBA_I(0xFF00FF, 0);
                tessellator.addVertex(-0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.addVertex(0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.addVertex(0.0, (double)f3, (double)(1.0f * f4));
                tessellator.addVertex(-0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.draw();
                ++i;
            }
            GL11.glPopMatrix();
            GL11.glDepthMask((boolean)true);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3042);
            GL11.glShadeModel((int)7424);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)3008);
            RenderHelper.enableStandardItemLighting();
        }
    }

    protected int shouldRenderPass(EntityDragonMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_2_ == 1) {
            GL11.glDepthFunc((int)515);
        }
        if (p_77032_2_ != 0) {
            return -1;
        }
        this.bindTexture(enderDragonEyesTextures);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)1, (int)1);
        GL11.glDisable((int)2896);
        GL11.glDepthFunc((int)514);
        int c0 = 61680;
        int j = c0 % 65536;
        int k = c0 / 65536;
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)((float)j / 1.0f), (float)((float)k / 1.0f));
        GL11.glEnable((int)2896);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        return 1;
    }

    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityDragonMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityDragonMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_) {
        this.renderEquippedItems((EntityDragonMinion)p_77029_1_, p_77029_2_);
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        this.rotateCorpse((EntityDragonMinion)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected void renderModel(EntityLivingBase p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
        this.renderModel((EntityDragonMinion)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
    }

    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityDragonMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntityDragonMinion)p_110775_1_);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityDragonMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}

