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
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.theTitans.models.ModelIronGolemTitan;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderUltimaIronGolemTitan
extends RenderLiving {
    private static final ResourceLocation ironGolemTextures = new ResourceLocation("thetitans", "textures/entities/titans/iron_golem_titan.png");
    private ModelIronGolemTitan golemModel;

    public RenderUltimaIronGolemTitan() {
        super((ModelBase)new ModelIronGolemTitan(), 1.0f);
        this.golemModel = (ModelIronGolemTitan)this.mainModel;
        this.setRenderPassModel(this.golemModel);
    }

    protected ResourceLocation getEntityTexture(EntityIronGolemTitan entity) {
        return ironGolemTextures;
    }

    protected void func_180588_a(EntityIronGolemTitan p_180588_1_, float p_180588_2_, float p_180588_3_, float p_180588_4_) {
        super.rotateCorpse((EntityLivingBase)p_180588_1_, p_180588_2_, p_180588_3_, p_180588_4_);
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        this.func_180588_a((EntityIronGolemTitan)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityIronGolemTitan)entity);
    }

    protected void func_180592_a(EntityIronGolemTitan p_180592_1_, float p_180592_2_) {
        float f1 = 24.0f;
        int i = p_180592_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 440.0f * 7.75f;
        }
        GL11.glScalef((float)f1, (float)f1, (float)f1);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntityIronGolemTitan)p_77041_1_, p_77041_2_);
    }

    public void func_180579_a(EntityIronGolemTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.doRender((EntityLiving)p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityIronGolemTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityIronGolemTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityIronGolemTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

