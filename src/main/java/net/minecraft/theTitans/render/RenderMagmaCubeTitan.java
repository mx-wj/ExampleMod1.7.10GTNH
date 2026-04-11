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
import net.minecraft.entity.titan.EntityMagmaCubeTitan;
import net.minecraft.theTitans.models.ModelMagmaCubeTitan;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderMagmaCubeTitan
extends RenderLiving {
    private static final ResourceLocation magmaCubeTextures = new ResourceLocation("textures/entity/slime/magmacube.png");

    public RenderMagmaCubeTitan() {
        super((ModelBase)new ModelMagmaCubeTitan(), 0.25f);
    }

    protected ResourceLocation getEntityTexture(EntityMagmaCubeTitan entity) {
        return magmaCubeTextures;
    }

    protected void preRenderCallback(EntityMagmaCubeTitan p_77041_1_, float p_77041_2_) {
        int i = p_77041_1_.getSlimeSize();
        float f1 = (p_77041_1_.prevSquishFactor + (p_77041_1_.squishFactor - p_77041_1_.prevSquishFactor) * p_77041_2_) / ((float)i * 0.5f + 1.0f);
        float f2 = 1.0f / (f1 + 1.0f);
        float f3 = i;
        GL11.glScalef((float)(f2 * f3), (float)(1.0f / f2 * f3), (float)(f2 * f3));
        float fl = 16.0f;
        int i1 = p_77041_1_.getInvulTime();
        if (i1 > 0) {
            fl -= ((float)i1 - p_77041_2_) / 10.0f;
        }
        GL11.glScalef((float)fl, (float)fl, (float)fl);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityMagmaCubeTitan)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityMagmaCubeTitan)entity);
    }

    public void doRender(EntityMagmaCubeTitan p_177124_1_, double p_177124_2_, double p_177124_4_, double p_177124_6_, float p_177124_8_, float p_177124_9_) {
        this.shadowSize = 0.25f * (float)p_177124_1_.getSlimeSize();
        super.doRender((EntityLiving)p_177124_1_, p_177124_2_, p_177124_4_, p_177124_6_, p_177124_8_, p_177124_9_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityMagmaCubeTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityMagmaCubeTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityMagmaCubeTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

