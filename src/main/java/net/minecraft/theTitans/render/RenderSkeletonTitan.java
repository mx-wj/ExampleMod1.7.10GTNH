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
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.models.ModelSkeletonTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderSkeletonTitan
extends RenderLiving {
    private static final ResourceLocation skeletonTitanTextures = new ResourceLocation("thetitans", "textures/entities/titans/skeleton_titan.png");
    private static final ResourceLocation skeletonTitanPull1Textures = new ResourceLocation("thetitans", "textures/entities/titans/skeleton_titan_pulling_0.png");
    private static final ResourceLocation skeletonTitanPull2Textures = new ResourceLocation("thetitans", "textures/entities/titans/skeleton_titan_pulling_1.png");
    private static final ResourceLocation skeletonTitanPull3Textures = new ResourceLocation("thetitans", "textures/entities/titans/skeleton_titan_pulling_2.png");
    private static final ResourceLocation skeletonTitanBrokenBowTextures = new ResourceLocation("thetitans", "textures/entities/titans/skeleton_titan_broken_bow.png");
    private static final ResourceLocation witherSkeletonTextures = new ResourceLocation("thetitans", "textures/entities/titans/wither_skeleton_titan.png");
    private ModelSkeletonTitan skeletonModel;
    private ModelBase overlayingModel = new ModelSkeletonTitan(0.1f);

    public RenderSkeletonTitan() {
        super((ModelBase)new ModelSkeletonTitan(), 0.5f);
        this.skeletonModel = (ModelSkeletonTitan)this.mainModel;
    }

    public void doRender(EntitySkeletonTitan entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.skeletonModel.isWither = entity.getSkeletonType() == 1;
        super.doRender((EntityLiving)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected void preRenderCallback(EntitySkeletonTitan p_77041_1_, float p_77041_2_) {
        int i2;
        float f1 = p_77041_1_.getSkeletonType() == 1 ? 28.0f : 16.0f;
        int i = p_77041_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_77041_2_) / 440.0f * 7.75f;
        }
        if ((i2 = p_77041_1_.getExtraPower()) > 0) {
            f1 += (float)i2 * 0.5f;
        }
        GL11.glScalef((float)f1, (float)f1, (float)f1);
        GL11.glTranslatef((float)0.0f, (float)0.0075f, (float)0.0f);
    }

    protected ResourceLocation func_180577_a(EntitySkeletonTitan p_180577_1_) {
        return p_180577_1_.getSkeletonType() == 1 ? witherSkeletonTextures : (p_180577_1_.attackTimer < 20 && p_180577_1_.attackTimer >= 10 ? skeletonTitanPull1Textures : (p_180577_1_.attackTimer < 30 && p_180577_1_.attackTimer >= 20 ? skeletonTitanPull2Textures : (p_180577_1_.attackTimer >= 30 ? skeletonTitanPull3Textures : (p_180577_1_.isStunned ? skeletonTitanBrokenBowTextures : skeletonTitanTextures))));
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return this.func_180577_a((EntitySkeletonTitan)entity);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntitySkeletonTitan)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.func_180577_a((EntitySkeletonTitan)entity);
    }

    protected int shouldRenderPass(EntitySkeletonTitan p_77032_1_, int p_77032_2_, float p_77032_3_) {
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
                ((ModelSkeletonTitan)this.overlayingModel).HeldItem.showModel = false;
                ((ModelSkeletonTitan)this.overlayingModel).HeldItem2.showModel = false;
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                GL11.glColor4f((float)(p_77032_1_.getSkeletonType() == 1 ? 0.1f : 0.0f), (float)(p_77032_1_.getSkeletonType() == 1 ? 0.1f : 0.6f + MathHelper.cos((float)(f1 * 0.05f)) * 0.1f), (float)(p_77032_1_.getSkeletonType() == 1 ? 0.1f : 0.7f + MathHelper.cos((float)(f1 * 0.05f)) * 0.1f), (float)1.0f);
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

    protected int inheritRenderPass(EntitySkeletonTitan p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return -1;
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntitySkeletonTitan)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected int inheritRenderPass(EntityLivingBase p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return this.inheritRenderPass((EntitySkeletonTitan)p_77035_1_, p_77035_2_, p_77035_3_);
    }

    public void func_180579_a(EntitySkeletonTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.doRender((EntityLiving)p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySkeletonTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySkeletonTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySkeletonTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

