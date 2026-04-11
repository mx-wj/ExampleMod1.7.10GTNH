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
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.models.ModelOmegafish;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderOmegafish
extends RenderLiving {
    private static final ResourceLocation silverfishTextures = new ResourceLocation("thetitans", "textures/entities/titans/omegafish.png");

    public RenderOmegafish() {
        super((ModelBase)new ModelOmegafish(), 0.3f);
    }

    protected float func_180584_a(EntitySilverfishTitan p_180584_1_) {
        return 180.0f;
    }

    protected ResourceLocation getEntityTexture(EntitySilverfishTitan entity) {
        return silverfishTextures;
    }

    protected int shouldRenderPass(EntitySilverfishTitan p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.isArmored() && p_77032_1_.isEntityAlive()) {
            if (p_77032_1_.isInvisible()) {
                GL11.glDepthMask((boolean)false);
            } else {
                GL11.glDepthMask((boolean)true);
            }
            if (p_77032_2_ == 1) {
                float f1 = (float)p_77032_1_.ticksExisted + p_77032_3_;
                this.bindTexture(TheTitans.genericTitanWhiteTexture32x64);
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                float f2 = MathHelper.cos((float)(f1 * 0.05f)) * 3.0f;
                float f3 = f1 * 0.01f;
                GL11.glTranslatef((float)f2, (float)f3, (float)0.0f);
                this.setRenderPassModel(this.mainModel);
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                GL11.glColor4f((float)0.5f, (float)0.5f, (float)0.5f, (float)1.0f);
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
        return -1;
    }

    protected int inheritRenderPass(EntitySilverfishTitan p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return -1;
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntitySilverfishTitan)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected int inheritRenderPass(EntityLivingBase p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return this.inheritRenderPass((EntitySilverfishTitan)p_77035_1_, p_77035_2_, p_77035_3_);
    }

    protected float getDeathMaxRotation(EntityLivingBase p_77037_1_) {
        return this.func_180584_a((EntitySilverfishTitan)p_77037_1_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntitySilverfishTitan)entity);
    }

    protected void func_180592_a(EntitySilverfishTitan p_180592_1_, float p_180592_2_) {
        int i2;
        int i = p_180592_1_.getInvulTime();
        boolean flag = p_180592_1_.isBurrowing;
        float f1 = 16.0f;
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 440.0f * 7.75f;
        }
        if ((i2 = p_180592_1_.getExtraPower()) > 0) {
            f1 += (float)i2 * 0.5f;
        }
        if (p_180592_1_.isBurrowing) {
            GL11.glTranslatef((float)0.0f, (float)8.0f, (float)0.0f);
        }
        GL11.glScalef((float)f1, (float)f1, (float)f1);
        GL11.glTranslatef((float)0.0f, (float)0.01f, (float)0.0f);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntitySilverfishTitan)p_77041_1_, p_77041_2_);
    }

    public void func_180579_a(EntitySilverfishTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.doRender((EntityLiving)p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySilverfishTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySilverfishTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySilverfishTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

