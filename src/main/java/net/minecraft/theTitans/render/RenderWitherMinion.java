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
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityWitherMinion;
import net.minecraft.theTitans.models.ModelWitherMinion;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderWitherMinion
extends RenderLiving {
    private static final ResourceLocation witherEmpowermentBeamTextures = new ResourceLocation("thetitans", "textures/entities/wither_empowerment_beam.png");
    private static final ResourceLocation invulnerableWitherTextures = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
    private static final ResourceLocation witherTextures = new ResourceLocation("textures/entity/wither/wither.png");
    private int field_82419_a;

    public RenderWitherMinion() {
        super((ModelBase)new ModelWitherMinion(), 1.0f);
        this.field_82419_a = ((ModelWitherMinion)this.mainModel).func_82903_a();
    }

    public void doRender(EntityWitherMinion entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        int e = ((ModelWitherMinion)this.mainModel).func_82903_a();
        if (e != this.field_82419_a) {
            this.field_82419_a = e;
            this.mainModel = new ModelWitherMinion();
        }
        super.doRender((EntityLiving)entity, x, y, z, p_76986_8_, partialTicks);
        if (entity.master != null && entity.isEntityAlive()) {
            float f1 = (float)entity.ticksExisted + partialTicks;
            float f4 = (float)(entity.master.posX - entity.posX - (entity.prevPosX - entity.posX) * (double)(1.0f - partialTicks));
            float f5 = (float)(entity.master.posY + (double)entity.master.getEyeHeight() - entity.posY - (entity.prevPosY - entity.posY) * (double)(1.0f - partialTicks));
            float f6 = (float)(entity.master.posZ - entity.posZ - (entity.prevPosZ - entity.posZ) * (double)(1.0f - partialTicks));
            float f7 = MathHelper.sqrt_float((float)(f4 * f4 + f6 * f6));
            float f8 = MathHelper.sqrt_float((float)(f4 * f4 + f5 * f5 + f6 * f6));
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)x), (float)((float)y + entity.getEyeHeight()), (float)((float)z));
            GL11.glRotatef((float)((float)(-Math.atan2(f6, f4)) * 180.0f / (float)Math.PI - 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)((float)(-Math.atan2(f7, f5)) * 180.0f / (float)Math.PI - 90.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            Tessellator tessellator = Tessellator.instance;
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable((int)2884);
            this.bindTexture(witherEmpowermentBeamTextures);
            GL11.glShadeModel((int)7425);
            float f9 = f1 * 0.005f;
            float f10 = MathHelper.sqrt_float((float)(f4 * f4 + f5 * f5 + f6 * f6)) / 32.0f + f9;
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

    protected ResourceLocation getEntityTexture(EntityWitherMinion entity) {
        int i = entity.getInvulTime();
        return i > 0 && (i > 80 || i / 5 % 2 != 1) ? invulnerableWitherTextures : witherTextures;
    }

    protected void preRenderCallback(EntityWitherMinion p_180592_1_, float p_180592_2_) {
        float f1 = 2.0f;
        int i = p_180592_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 220.0f * 0.5f;
        }
        GL11.glScalef((float)f1, (float)f1, (float)f1);
    }

    protected int shouldRenderPass(EntityWitherMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.isArmored()) {
            if (p_77032_1_.isInvisible()) {
                GL11.glDepthMask((boolean)false);
            } else {
                GL11.glDepthMask((boolean)true);
            }
            if (p_77032_2_ == 1) {
                float f1 = (float)p_77032_1_.ticksExisted + p_77032_3_;
                this.bindTexture(invulnerableWitherTextures);
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                float f2 = MathHelper.cos((float)(f1 * 0.02f)) * 3.0f;
                float f3 = f1 * 0.01f;
                GL11.glTranslatef((float)f2, (float)f3, (float)0.0f);
                this.setRenderPassModel(this.mainModel);
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                float f4 = 0.5f;
                GL11.glColor4f((float)f4, (float)f4, (float)f4, (float)1.0f);
                GL11.glDisable((int)2896);
                GL11.glBlendFunc((int)1, (int)1);
                GL11.glTranslatef((float)0.0f, (float)-0.01f, (float)0.0f);
                GL11.glScalef((float)1.1f, (float)1.1f, (float)1.1f);
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

    protected int inheritRenderPass(EntityWitherMinion p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return -1;
    }

    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityWitherMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityWitherMinion)p_77041_1_, p_77041_2_);
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityWitherMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected int inheritRenderPass(EntityLivingBase p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return this.inheritRenderPass((EntityWitherMinion)p_77035_1_, p_77035_2_, p_77035_3_);
    }

    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityWitherMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntityWitherMinion)p_110775_1_);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityWitherMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}

