/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.OpenGlHelper
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
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.models.ModelSpiderTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderSpiderTitan
extends RenderLiving {
    private static final ResourceLocation spiderEyesTextures = new ResourceLocation("thetitans", "textures/entities/titans/spider_titan_eyes.png");
    private static final ResourceLocation spiderTextures = new ResourceLocation("thetitans", "textures/entities/titans/spider_titan.png");
    private ModelBase overlayingModel = new ModelSpiderTitan(0.1f);

    public RenderSpiderTitan() {
        super((ModelBase)new ModelSpiderTitan(), 1.0f);
        this.setRenderPassModel(new ModelSpiderTitan());
    }

    protected float getDeathMaxRotation(EntitySpiderTitan p_77037_1_) {
        return 180.0f;
    }

    protected ResourceLocation getEntityTexture(EntitySpiderTitan entity) {
        return spiderTextures;
    }

    protected int shouldRenderPass(EntitySpiderTitan p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.isArmored() && p_77032_1_.isEntityAlive()) {
            if (p_77032_1_.isInvisible()) {
                GL11.glDepthMask((boolean)false);
            } else {
                GL11.glDepthMask((boolean)true);
            }
            if (p_77032_2_ == 1) {
                float f1 = (float)p_77032_1_.ticksExisted + p_77032_3_;
                this.bindTexture(TheTitans.genericTitanWhiteTexture64x64);
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                float f2 = MathHelper.cos((float)(f1 * 0.02f)) * 5.0f;
                float f3 = f1 * 0.01f;
                GL11.glTranslatef((float)MathHelper.cos((float)(f1 * 0.2f)), (float)f3, (float)f2);
                this.setRenderPassModel(this.overlayingModel);
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                GL11.glColor4f((float)(0.6f + MathHelper.cos((float)(f1 * 0.05f)) * 0.3f), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glDisable((int)2896);
                GL11.glBlendFunc((int)1, (int)1);
                return 1;
            }
            if (p_77032_2_ == 2) {
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)2896);
                GL11.glDisable((int)3042);
            }
        }
        if (p_77032_2_ != 0) {
            return -1;
        }
        this.bindTexture(spiderEyesTextures);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)1, (int)1);
        if (p_77032_1_.isInvisible()) {
            GL11.glDepthMask((boolean)false);
        } else {
            GL11.glDepthMask((boolean)true);
        }
        int c0 = 0xF000F0;
        int j = c0 % 65536;
        int k = c0 / 65536;
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)((float)j / 1.0f), (float)((float)k / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.setRenderPassModel(this.mainModel);
        if (p_77032_1_.getAnimID() == 10 && p_77032_1_.deathTicks > 200) {
            GL11.glColor4f((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
        }
        return 1;
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntitySpiderTitan)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected float getDeathMaxRotation(EntityLivingBase p_77037_1_) {
        return this.getDeathMaxRotation((EntitySpiderTitan)p_77037_1_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntitySpiderTitan)entity);
    }

    protected void func_180592_a(EntitySpiderTitan p_180592_1_, float p_180592_2_) {
        int i = p_180592_1_.getInvulTime();
        int i2 = p_180592_1_.getExtraPower();
        float f1 = 16.0f;
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 440.0f * 7.75f;
        }
        if (i2 > 0) {
            f1 += (float)i2 * 0.5f;
        }
        GL11.glScalef((float)f1, (float)f1, (float)f1);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntitySpiderTitan)p_77041_1_, p_77041_2_);
    }

    public void func_180579_a(EntitySpiderTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.doRender((EntityLiving)p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySpiderTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySpiderTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySpiderTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

