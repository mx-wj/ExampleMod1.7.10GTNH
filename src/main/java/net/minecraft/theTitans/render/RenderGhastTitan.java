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
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.theTitans.models.ModelGhastTitan;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderGhastTitan
extends RenderLiving {
    private static final ResourceLocation ghastTextures = new ResourceLocation("thetitans", "textures/entities/titans/ghast_titan.png");
    private static final ResourceLocation ghastShootingTextures = new ResourceLocation("thetitans", "textures/entities/titans/ghast_titan_shooting.png");

    public RenderGhastTitan() {
        super((ModelBase)new ModelGhastTitan(), 4.0f);
    }

    protected ResourceLocation func_180576_a(EntityGhastTitan p_180576_1_) {
        return p_180576_1_.func_110182_bF() ? ghastShootingTextures : ghastTextures;
    }

    protected void preRenderCallback(EntityGhastTitan p_77041_1_, float p_77041_2_) {
        int i2;
        float f1 = ((float)p_77041_1_.prevAttackCounter + (float)(p_77041_1_.attackCounter - p_77041_1_.prevAttackCounter) * p_77041_2_) / 20.0f;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        f1 = 1.0f / (f1 * f1 * f1 * f1 * f1 * 2.0f + 1.0f);
        float f2 = (8.0f + f1) / 2.0f;
        float f3 = (8.0f + 1.0f / f1) / 2.0f;
        GL11.glScalef((float)f3, (float)f2, (float)f3);
        float f11 = 24.0f;
        int i = p_77041_1_.getInvulTime();
        if (i > 0) {
            f11 -= ((float)i - p_77041_2_) / 440.0f * 7.75f;
        }
        if ((i2 = p_77041_1_.getExtraPower()) > 0) {
            f1 += (float)i2 * 0.5f;
        }
        GL11.glScalef((float)f11, (float)f11, (float)f11);
        if (p_77041_1_.hurtTime > 0) {
            GL11.glDepthFunc((int)514);
            GL11.glDisable((int)3553);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glColor4f((float)1.0f, (float)0.0f, (float)0.0f, (float)0.5f);
            GL11.glEnable((int)3553);
            GL11.glDisable((int)3042);
            GL11.glDepthFunc((int)515);
        }
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityGhastTitan)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.func_180576_a((EntityGhastTitan)entity);
    }

    public void func_180579_a(EntityGhastTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.doRender((EntityLiving)p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityGhastTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityGhastTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityGhastTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

