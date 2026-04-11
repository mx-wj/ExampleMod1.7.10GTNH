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
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.theTitans.models.ModelCreeperTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderCreeperTitan
extends RenderLiving {
    private static final ResourceLocation armoredCreeperTextures = new ResourceLocation("thetitans", "textures/entities/titans/creeper_titan_charge.png");
    private static final ResourceLocation creeperTextures = new ResourceLocation("thetitans", "textures/entities/titans/creeper_titan.png");
    private ModelBase creeperModel = new ModelCreeperTitan(1.6f);

    public RenderCreeperTitan() {
        super((ModelBase)new ModelCreeperTitan(), 0.75f);
    }

    protected void preRenderCallback(EntityCreeperTitan p_180570_1_, float p_180570_2_) {
        int i2;
        float f1 = p_180570_1_.getCreeperFlashIntensity(p_180570_2_);
        float f2 = 1.0f + MathHelper.sin((float)(f1 * 100.0f)) * f1 * 0.01f;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        if (f1 > 1.0f) {
            f1 = 1.0f;
        }
        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0f + f1 * 0.4f) * f2;
        float f4 = (1.0f + f1 * 0.1f) / f2;
        GL11.glScalef((float)f3, (float)f4, (float)f3);
        float fl = 16.0f;
        int i = p_180570_1_.getInvulTime();
        if (i > 0) {
            fl -= ((float)i - p_180570_2_) / 440.0f * 7.75f;
        }
        if (i > 900) {
            GL11.glScalef((float)1.0f, (float)-1.0f, (float)1.0f);
        }
        if ((i2 = p_180570_1_.getExtraPower()) > 0) {
            f1 += (float)i2 * 0.5f;
        }
        GL11.glScalef((float)fl, (float)fl, (float)fl);
    }

    protected int func_180571_a(EntityCreeperTitan p_180571_1_, float p_180571_2_, float p_180571_3_) {
        float f2 = p_180571_1_.getCreeperFlashIntensity(p_180571_3_);
        if ((int)(f2 * 10.0f) % 2 == 0) {
            return 0;
        }
        int i = (int)(f2 * 0.2f * 255.0f);
        if (i < 0) {
            i = 0;
        }
        if (i > 255) {
            i = 255;
        }
        int short1 = 255;
        int short2 = 255;
        int short3 = 255;
        return i << 24 | short1 << 16 | short2 << 8 | short3;
    }

    protected ResourceLocation getEntityTexture(EntityCreeperTitan entity) {
        return creeperTextures;
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityCreeperTitan)p_77041_1_, p_77041_2_);
    }

    protected int getColorMultiplier(EntityLivingBase p_77030_1_, float p_77030_2_, float p_77030_3_) {
        return this.func_180571_a((EntityCreeperTitan)p_77030_1_, p_77030_2_, p_77030_3_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityCreeperTitan)entity);
    }

    public void func_180579_a(EntityCreeperTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.doRender((EntityLiving)p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityCreeperTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityCreeperTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityCreeperTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected int shouldRenderPass(EntityCreeperTitan p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.getPowered()) {
            if (p_77032_1_.isInvisible()) {
                GL11.glDepthMask((boolean)false);
            } else {
                GL11.glDepthMask((boolean)true);
            }
            if (p_77032_2_ == 1) {
                float f1 = (float)p_77032_1_.ticksExisted + p_77032_3_;
                this.bindTexture(armoredCreeperTextures);
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                float f3 = f1 * 0.01f;
                GL11.glTranslatef((float)0.0f, (float)f3, (float)f3);
                this.setRenderPassModel(this.creeperModel);
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                float f4 = 0.75f;
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

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityCreeperTitan)p_77032_1_, p_77032_2_, p_77032_3_);
    }
}

