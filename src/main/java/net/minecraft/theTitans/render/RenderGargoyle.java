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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityGargoyle;
import net.minecraft.theTitans.models.ModelBeam;
import net.minecraft.theTitans.models.ModelGargoyle;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderGargoyle
extends RenderLiving {
    private static final ResourceLocation stoneGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle1.png");
    private static final ResourceLocation sandstoneGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle2.png");
    private static final ResourceLocation obsidianGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle3.png");
    private static final ResourceLocation goldenGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle4.png");
    private static final ResourceLocation ironGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle5.png");
    private static final ResourceLocation endstoneGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle6.png");
    private static final ResourceLocation nethraticGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle7.png");
    private static final ResourceLocation gargoyleBeamTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle_beam.png");

    public RenderGargoyle() {
        super((ModelBase)new ModelGargoyle(), 0.8f);
    }

    protected ResourceLocation getEntityTexture(EntityGargoyle entity) {
        switch (entity.getGargoyleType()) {
            default: {
                return stoneGargoyleTextures;
            }
            case 1: {
                return sandstoneGargoyleTextures;
            }
            case 2: {
                return obsidianGargoyleTextures;
            }
            case 3: {
                return goldenGargoyleTextures;
            }
            case 4: {
                return ironGargoyleTextures;
            }
            case 5: {
                return endstoneGargoyleTextures;
            }
            case 6: 
        }
        return nethraticGargoyleTextures;
    }

    protected void func_180588_a(EntityGargoyle p_180588_1_, float p_180588_2_, float p_180588_3_, float p_180588_4_) {
        super.rotateCorpse((EntityLivingBase)p_180588_1_, p_180588_2_, p_180588_3_, p_180588_4_);
        if (!p_180588_1_.onGround || p_180588_1_.getAggressive()) {
            GL11.glRotatef((float)75.0f, (float)-1.0f, (float)0.0f, (float)0.0f);
            GL11.glTranslatef((float)0.0f, (float)-1.0f, (float)1.0f);
        }
        if (p_180588_1_.getGargoyleType() == 1) {
            GL11.glScalef((float)0.75f, (float)1.0f, (float)0.75f);
        }
        if (p_180588_1_.getGargoyleType() == 2) {
            GL11.glScalef((float)1.25f, (float)1.0f, (float)1.25f);
        }
        if (p_180588_1_.getGargoyleType() == 3) {
            GL11.glScalef((float)1.1f, (float)1.0f, (float)1.1f);
        }
        if (p_180588_1_.getGargoyleType() == 4) {
            GL11.glScalef((float)1.2f, (float)1.0f, (float)1.2f);
        }
        if (p_180588_1_.getGargoyleType() == 5) {
            GL11.glScalef((float)1.1f, (float)1.1f, (float)1.1f);
        }
        if (p_180588_1_.getGargoyleType() == 6) {
            GL11.glScalef((float)1.05f, (float)0.95f, (float)1.05f);
        }
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        this.func_180588_a((EntityGargoyle)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityGargoyle)entity);
    }

    protected int shouldRenderPass(EntityGargoyle p_77032_1_, int p_77032_2_, float p_77032_3_) {
        int k;
        int j;
        boolean flag;
        int i1 = MathHelper.floor_double((double)p_77032_1_.posX);
        boolean bl = flag = p_77032_1_.worldObj.getBlock(i1, j = MathHelper.floor_double((double)(p_77032_1_.boundingBox.minY - 0.5)), k = MathHelper.floor_double((double)p_77032_1_.posZ)) == p_77032_1_.getFavoriteBlockToPerch();
        if (p_77032_1_.getGargoyleType() == 3) {
            if (p_77032_1_.isInvisible()) {
                GL11.glDepthMask((boolean)false);
            } else {
                GL11.glDepthMask((boolean)true);
            }
            if (p_77032_2_ == 1) {
                ModelBeam modelmatter = new ModelBeam();
                ((ModelGargoyle)this.mainModel).Torso.postRender(0.020833334f);
                ((ModelGargoyle)this.mainModel).Body.postRender(0.020833334f);
                ((ModelGargoyle)this.mainModel).Head.postRender(0.020833334f);
                float f1 = (float)p_77032_1_.ticksExisted + p_77032_3_;
                this.bindTexture(gargoyleBeamTextures);
                GL11.glTranslatef((float)0.0f, (float)-0.5f, (float)0.0f);
                if (!p_77032_1_.onGround) {
                    GL11.glTranslatef((float)0.0f, (float)0.25f, (float)0.0f);
                }
                if (flag) {
                    GL11.glTranslatef((float)0.0f, (float)0.3f, (float)-0.65f);
                }
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glScalef((float)0.75f, (float)10.0f, (float)0.4f);
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                float f3 = f1 * 0.01f;
                GL11.glTranslatef((float)0.0f, (float)f3, (float)0.0f);
                this.setRenderPassModel(modelmatter);
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                float f4 = 0.5f;
                GL11.glColor4f((float)f4, (float)f4, (float)f4, (float)f4);
                modelmatter.render((Entity)p_77032_1_, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glDisable((int)2896);
                GL11.glBlendFunc((int)1, (int)1);
                GL11.glEnable((int)3042);
                GL11.glDisable((int)3008);
                GL11.glBlendFunc((int)1, (int)1);
                GL11.glDisable((int)2896);
                int c0 = 61680;
                int j1 = c0 % 65536;
                int k1 = c0 / 65536;
                OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)((float)j1 / 1.0f), (float)((float)k1 / 1.0f));
                GL11.glEnable((int)2896);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)2.0f);
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

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityGargoyle)p_77032_1_, p_77032_2_, p_77032_3_);
    }
}

