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
import net.minecraft.entity.titan.EntityGargoyleTitan;
import net.minecraft.theTitans.models.ModelBeam;
import net.minecraft.theTitans.models.ModelGargoyleTitan;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderGargoyleTitan
extends RenderLiving {
    private static final ResourceLocation ironGolemTextures = new ResourceLocation("thetitans", "textures/entities/titans/gargoyle_titan.png");

    public RenderGargoyleTitan() {
        super((ModelBase)new ModelGargoyleTitan(), 1.0f);
    }

    protected ResourceLocation getEntityTexture(EntityGargoyleTitan entity) {
        return ironGolemTextures;
    }

    protected void func_180588_a(EntityGargoyleTitan p_180588_1_, float p_180588_2_, float p_180588_3_, float p_180588_4_) {
        super.rotateCorpse((EntityLivingBase)p_180588_1_, p_180588_2_, p_180588_3_, p_180588_4_);
        if ((double)p_180588_1_.limbSwingAmount >= 0.01) {
            float f3 = 13.0f;
            float f4 = p_180588_1_.limbSwing - p_180588_1_.limbSwingAmount * (1.0f - p_180588_4_) + 6.0f;
            float f5 = (Math.abs(f4 / 2.0f % f3 - f3 * 0.5f) - f3 * 0.25f) / (f3 * 0.25f);
            GL11.glRotatef((float)(3.5f * f5), (float)0.0f, (float)0.0f, (float)1.0f);
        }
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        this.func_180588_a((EntityGargoyleTitan)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityGargoyleTitan)entity);
    }

    protected int shouldRenderPass(EntityGargoyleTitan p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.animID == 5 && p_77032_1_.animTick > 24 && p_77032_1_.animTick < 36) {
            if (p_77032_1_.isInvisible()) {
                GL11.glDepthMask((boolean)false);
            } else {
                GL11.glDepthMask((boolean)true);
            }
            if (p_77032_2_ == 1) {
                ModelBeam modelmatter = new ModelBeam();
                ((ModelGargoyleTitan)this.mainModel).Torso.postRender(0.020833334f);
                ((ModelGargoyleTitan)this.mainModel).Body.postRender(0.020833334f);
                ((ModelGargoyleTitan)this.mainModel).Head.postRender(0.020833334f);
                float f1 = (float)p_77032_1_.ticksExisted + p_77032_3_;
                this.bindTexture(new ResourceLocation("textures/blocks/water_still.png"));
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glScalef((float)0.5f, (float)10.0f, (float)0.5f);
                GL11.glTranslatef((float)0.0f, (float)-0.035f, (float)0.35f);
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                float f3 = f1 * 0.01f;
                GL11.glTranslatef((float)0.0f, (float)f3, (float)0.0f);
                this.setRenderPassModel(modelmatter);
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                float f4 = 0.9f;
                GL11.glColor4f((float)f4, (float)f4, (float)f4, (float)f4);
                modelmatter.render((Entity)p_77032_1_, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
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
                return -1;
            }
        }
        return -1;
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityGargoyleTitan)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void func_180592_a(EntityGargoyleTitan p_180592_1_, float p_180592_2_) {
        float f1 = 16.0f;
        int i = p_180592_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 440.0f * 7.75f;
        }
        GL11.glScalef((float)f1, (float)f1, (float)f1);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntityGargoyleTitan)p_77041_1_, p_77041_2_);
    }

    public void func_180579_a(EntityGargoyleTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.doRender((EntityLiving)p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityGargoyleTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityGargoyleTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityGargoyleTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

