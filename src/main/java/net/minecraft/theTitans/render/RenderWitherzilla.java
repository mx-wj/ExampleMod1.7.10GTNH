/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.texture.TextureMap
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.models.ModelWitherzilla;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderWitherzilla
extends RenderLiving {
    private static final ResourceLocation enderDragonExplodingTextures = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
    private static final ResourceLocation witherzillaSheild = new ResourceLocation("thetitans", "textures/entities/wither_aura.png");
    private static final ResourceLocation witherzillaOmegaTextures = new ResourceLocation("thetitans", "textures/entities/titans/witherzilla_omega.png");
    private static final ResourceLocation witherzillaTextures = new ResourceLocation("thetitans", "textures/entities/titans/witherzilla.png");
    private int field_82419_a;
    private ModelWitherzilla model;

    public RenderWitherzilla() {
        super((ModelBase)new ModelWitherzilla(), 1.0f);
        this.model = (ModelWitherzilla)this.mainModel;
        this.field_82419_a = ((ModelWitherzilla)this.mainModel).func_82903_a();
    }

    protected void renderEquippedItems(EntityWitherzilla p_77029_1_, float p_77029_2_) {
        super.renderEquippedItems((EntityLivingBase)p_77029_1_, p_77029_2_);
        GL11.glEnable((int)32826);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)-2.0f, (float)0.0f);
        GL11.glScalef((float)0.05f, (float)0.05f, (float)0.05f);
        int i = p_77029_1_.getBrightnessForRender(p_77029_2_);
        int j = i % 65536;
        int k = i / 65536;
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)((float)j / 1.0f), (float)((float)k / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.bindTexture(TextureMap.locationBlocksTexture);
        this.field_147909_c.renderBlockAsItem(Blocks.glowstone, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glDisable((int)32826);
        Tessellator tessellator = Tessellator.instance;
        if (p_77029_1_.affectTicks > 0 && p_77029_1_.getInvulTime() < 1) {
            RenderHelper.disableStandardItemLighting();
            float f111 = ((float)p_77029_1_.affectTicks + p_77029_2_) / 1000.0f;
            float f211 = 0.0f;
            if (f111 > 0.8f) {
                f211 = (f111 - 0.8f) / 0.2f;
            }
            Random random11 = new Random(432L);
            GL11.glDisable((int)3553);
            GL11.glShadeModel((int)7425);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)1);
            GL11.glDisable((int)3008);
            GL11.glEnable((int)2884);
            GL11.glDepthMask((boolean)false);
            GL11.glTranslatef((float)0.0f, (float)-2.0f, (float)0.0f);
            GL11.glPushMatrix();
            int i1 = 0;
            while ((float)i1 < (f111 + f111 * f111) / 2.0f * 100.0f) {
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f + f111 * 90.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                tessellator.startDrawing(6);
                float f3 = random11.nextFloat() * 10.0f + 5.0f + f211 * 20.0f;
                float f4 = random11.nextFloat() * 2.0f + 1.0f + f211 * 2.0f;
                tessellator.setColorRGBA_I(14809319, (int)(255.0f * (1.0f - f211)));
                tessellator.addVertex(0.0, 0.0, 0.0);
                tessellator.setColorRGBA_I(14809319, 0);
                tessellator.addVertex(-0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.addVertex(0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.addVertex(0.0, (double)f3, (double)(1.0f * f4));
                tessellator.addVertex(-0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.draw();
                ++i1;
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
        } else if (p_77029_1_.deathTicks > 0) {
            RenderHelper.disableStandardItemLighting();
            float f111 = ((float)p_77029_1_.deathTicks + p_77029_2_) / 300.0f;
            float f211 = 0.0f;
            if (f111 > 0.8f) {
                f211 = (f111 - 0.8f) / 0.2f;
            }
            Random random11 = new Random(432L);
            GL11.glDisable((int)3553);
            GL11.glShadeModel((int)7425);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)1);
            GL11.glDisable((int)3008);
            GL11.glEnable((int)2884);
            GL11.glDepthMask((boolean)false);
            GL11.glPushMatrix();
            int i1 = 0;
            while ((float)i1 < (f111 + f111 * f111) / 2.0f * 800.0f) {
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(random11.nextFloat() * 360.0f + f111 * 90.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                tessellator.startDrawing(6);
                float f3 = random11.nextFloat() * 2.0f + 1.0f + f211 * 20.0f;
                float f4 = random11.nextFloat() * 4.0f + 2.0f + f211 * 4.0f;
                tessellator.setColorRGBA_I(14809319, (int)(255.0f * (1.0f - f211)));
                tessellator.addVertex(0.0, 0.0, 0.0);
                tessellator.setColorRGBA_I(14809319, 0);
                tessellator.addVertex(-0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.addVertex(0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.addVertex(0.0, (double)f3, (double)(1.0f * f4));
                tessellator.addVertex(-0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.draw();
                ++i1;
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

    protected void renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_) {
        this.renderEquippedItems((EntityWitherzilla)p_77029_1_, p_77029_2_);
    }

    protected int shouldRenderPass(EntityWitherzilla p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.isArmored() || p_77032_1_.isInOmegaForm()) {
            if (p_77032_1_.isInvisible()) {
                GL11.glDepthMask((boolean)false);
            } else {
                GL11.glDepthMask((boolean)true);
            }
            if (p_77032_2_ == 1) {
                float f1 = (float)p_77032_1_.ticksExisted + p_77032_3_;
                int i = p_77032_1_.getInvulTime();
                this.bindTexture(i > 0 && (i > 300 || i / 10 % 2 != 1) ? TheTitans.genericTitanWhiteTexture64x64 : witherzillaSheild);
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                float f2 = f1 * 0.015f;
                float f3 = f1 * 0.01f;
                GL11.glTranslatef((float)f2, (float)f3, (float)0.0f);
                this.setRenderPassModel(this.mainModel);
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                float f4 = 0.5f;
                GL11.glColor4f((float)f4, (float)f4, (float)f4, (float)1.0f);
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

    protected int inheritRenderPass(EntityWitherzilla p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return -1;
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityWitherzilla)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected int inheritRenderPass(EntityLivingBase p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return this.inheritRenderPass((EntityWitherzilla)p_77035_1_, p_77035_2_, p_77035_3_);
    }

    protected void renderModel(EntityWitherzilla p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
        this.bindEntityTexture((Entity)p_77036_1_);
        if (!p_77036_1_.isInvisible()) {
            this.mainModel.render((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
        } else if (!p_77036_1_.isInvisibleToPlayer((EntityPlayer)Minecraft.getMinecraft().thePlayer)) {
            if (p_77036_1_.deathTicks > 0) {
                float f6 = (float)p_77036_1_.deathTicks / 220.0f;
                GL11.glDepthFunc((int)514);
                GL11.glDisable((int)3553);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                this.bindTexture(TheTitans.genericTitanWhiteTexture64x64);
                this.mainModel.render((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
                GL11.glEnable((int)3553);
                GL11.glDisable((int)3042);
                GL11.glDepthFunc((int)515);
            }
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
        } else {
            this.mainModel.setRotationAngles(p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_, (Entity)p_77036_1_);
        }
    }

    protected void renderModel(EntityLivingBase p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
        this.renderModel((EntityWitherzilla)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
    }

    public void func_180591_a(EntityWitherzilla p_180591_1_, double p_180591_2_, double p_180591_4_, double p_180591_6_, float p_180591_8_, float p_180591_9_) {
        int i = ((ModelWitherzilla)this.mainModel).func_82903_a();
        if (i != this.field_82419_a) {
            this.field_82419_a = i;
            this.mainModel = new ModelWitherzilla();
        }
        super.doRender((EntityLiving)p_180591_1_, p_180591_2_, p_180591_4_, p_180591_6_, p_180591_8_, p_180591_9_);
    }

    protected ResourceLocation getEntityTexture(EntityWitherzilla entity) {
        int i = entity.getInvulTime();
        return i > 0 && (i > 300 || i / 10 % 2 != 1) ? TheTitans.genericTitanWhiteTexture64x64 : (entity.isEntityInvulnerable() || entity.isInOmegaForm() ? witherzillaOmegaTextures : witherzillaTextures);
    }

    protected void func_180592_a(EntityWitherzilla p_180592_1_, float p_180592_2_) {
        int i2;
        float f1 = p_180592_1_.isInOmegaForm() ? 256.0f : 128.0f;
        int i = p_180592_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 440.0f * 7.75f;
        }
        if ((i2 = p_180592_1_.getExtraPower()) > 0) {
            f1 += (float)i2 * 0.5f;
        }
        GL11.glScalef((float)f1, (float)f1, (float)f1);
        if (p_180592_1_.isArmored()) {
            GL11.glTranslatef((float)0.0f, (float)2.0f, (float)0.0f);
        }
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180591_a((EntityWitherzilla)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntityWitherzilla)p_77041_1_, p_77041_2_);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180591_a((EntityWitherzilla)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityWitherzilla)entity);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180591_a((EntityWitherzilla)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

