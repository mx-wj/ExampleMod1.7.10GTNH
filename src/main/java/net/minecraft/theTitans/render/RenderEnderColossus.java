/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.Vec3
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.theTitans.models.ModelEnderColossus;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderEnderColossus
extends RenderLiving {
    private static final ResourceLocation endermanEyeBeamTexture = new ResourceLocation("thetitans", "textures/entities/titans/ender_colossus_beam.png");
    private static final ResourceLocation endermanEyesTexture = new ResourceLocation("thetitans", "textures/entities/titans/ender_colossus_eyes.png");
    private static final ResourceLocation endermanTextures = new ResourceLocation("thetitans", "textures/entities/titans/ender_colossus.png");
    private static final ResourceLocation endermanEyesDeadTexture = new ResourceLocation("thetitans", "textures/entities/titans/ender_colossus_eyes_dead.png");
    private static final ResourceLocation endermanDeadTextures = new ResourceLocation("thetitans", "textures/entities/titans/ender_colossus_dead.png");
    private ModelEnderColossus endermanModel;
    private Random rnd = new Random();

    public RenderEnderColossus() {
        super((ModelBase)new ModelEnderColossus(), 0.5f);
        this.endermanModel = (ModelEnderColossus)this.mainModel;
        this.setRenderPassModel(this.endermanModel);
    }

    protected void func_180592_a(EntityEnderColossus p_180592_1_, float p_180592_2_) {
        int i2;
        float f1 = 24.0f;
        int i = p_180592_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 440.0f * 7.75f;
        }
        if ((i2 = p_180592_1_.getExtraPower()) > 0) {
            f1 += (float)i2 * 0.5f;
        }
        GL11.glScalef((float)f1, (float)f1, (float)f1);
        GL11.glTranslatef((float)0.0f, (float)0.015f, (float)0.0f);
        if (p_180592_1_.ridingEntity != null) {
            GL11.glTranslatef((float)0.0f, (float)0.1f, (float)0.0f);
            GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        }
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntityEnderColossus)p_77041_1_, p_77041_2_);
    }

    public void doRender(EntityEnderColossus entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.endermanModel.isAttacking = entity.isScreaming();
        super.doRender((EntityLiving)entity, x, y, z, p_76986_8_, partialTicks);
        if (entity.getEyeLaserTime() >= 0 && entity.getHealth() > 0.0f) {
            Tessellator tessellator = Tessellator.instance;
            this.bindTexture(endermanEyeBeamTexture);
            GL11.glTexParameterf((int)3553, (int)10242, (float)10497.0f);
            GL11.glTexParameterf((int)3553, (int)10243, (float)10497.0f);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3042);
            GL11.glDepthMask((boolean)true);
            OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
            OpenGlHelper.glBlendFunc((int)770, (int)1, (int)1, (int)0);
            float f4 = (float)entity.worldObj.getTotalWorldTime() + partialTicks;
            float f5 = f4 * 0.5f % 1.0f;
            float f6 = entity.getEyeHeight();
            GL11.glPushMatrix();
            float f = entity.rotationYawHead * (float)Math.PI / 180.0f;
            float f1 = MathHelper.sin((float)f);
            float f2 = MathHelper.cos((float)f);
            GL11.glTranslatef((float)((float)x), (float)((float)y + f6 + (0.02f + 0.02f * MathHelper.cos((float)(partialTicks * 0.05f))) * (float)Math.PI), (float)((float)z));
            GL11.glScalef((float)32.0f, (float)32.0f, (float)32.0f);
            Vec3 vec3 = this.func_177110_b((EntityLivingBase)entity, f6, partialTicks);
            Vec3 vec31 = this.func_177110_a((EntityLivingBase)entity, f6, partialTicks);
            Vec3 vec32 = vec3.subtract(vec31);
            double d3 = vec32.lengthVector() + 0.1;
            vec32 = vec32.normalize();
            float f7 = (float)Math.acos(vec32.yCoord);
            float f8 = (float)Math.atan2(vec32.zCoord, vec32.xCoord);
            GL11.glRotatef((float)((1.5707964f + -f8) * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(f7 * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
            double d4 = (double)f4 * 0.005 * -1.5;
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(255, 0, 255, 255);
            double d15 = Math.cos(d4 * 0.0 + Math.PI) * 0.2;
            double d16 = Math.sin(d4 * 0.0 + Math.PI) * 0.2;
            double d17 = Math.cos(d4 * 0.0 + 0.0) * 0.2;
            double d18 = Math.sin(d4 * 0.0 + 0.0) * 0.2;
            double d25 = -1.0f + f5;
            double d26 = d3 * 2.5 + d25;
            tessellator.addVertexWithUV(d15, -d3, d16, 0.5, d26);
            tessellator.addVertexWithUV(d15, 0.0, d16, 0.5, d25);
            tessellator.addVertexWithUV(d17, 0.0, d18, 0.0, d25);
            tessellator.addVertexWithUV(d17, -d3, d18, 0.0, d26);
            tessellator.draw();
            GL11.glPopMatrix();
        }
    }

    private Vec3 func_177110_a(EntityLivingBase p_177110_1_, double p_177110_2_, float p_177110_4_) {
        double d1 = p_177110_1_.lastTickPosX + (p_177110_1_.posX - p_177110_1_.lastTickPosX) * (double)p_177110_4_;
        double d2 = p_177110_2_ + p_177110_1_.lastTickPosY + (p_177110_1_.posY - p_177110_1_.lastTickPosY) * (double)p_177110_4_;
        double d3 = p_177110_1_.lastTickPosZ + (p_177110_1_.posZ - p_177110_1_.lastTickPosZ) * (double)p_177110_4_;
        return Vec3.createVectorHelper((double)d1, (double)d2, (double)d3);
    }

    private Vec3 func_177110_b(EntityLivingBase p_177110_1_, double p_177110_2_, float p_177110_4_) {
        Vec3 vec3 = p_177110_1_.getLookVec();
        double dx = vec3.xCoord * 300.0;
        double dy = vec3.yCoord * 300.0;
        double dz = vec3.zCoord * 300.0;
        double d1 = p_177110_1_.lastTickPosX + (p_177110_1_.posX + dx - p_177110_1_.lastTickPosX) * (double)p_177110_4_;
        double d2 = p_177110_2_ + p_177110_1_.lastTickPosY + (p_177110_1_.posY + dy - p_177110_1_.lastTickPosY) * (double)p_177110_4_;
        double d3 = p_177110_1_.lastTickPosZ + (p_177110_1_.posZ + dz - p_177110_1_.lastTickPosZ) * (double)p_177110_4_;
        return Vec3.createVectorHelper((double)d1, (double)d2, (double)d3);
    }

    protected int shouldRenderPass(EntityEnderColossus p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_2_ != 0) {
            return -1;
        }
        if (p_77032_1_.getAnimID() == 10 && p_77032_1_.deathTicks > 160) {
            this.bindTexture(endermanEyesDeadTexture);
        } else {
            this.bindTexture(p_77032_1_.getEyeLaserTime() >= 0 ? endermanEyesDeadTexture : endermanEyesTexture);
        }
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)1, (int)1);
        GL11.glDisable((int)2896);
        if (p_77032_1_.isInvisible()) {
            GL11.glDepthMask((boolean)false);
        } else {
            GL11.glDepthMask((boolean)true);
        }
        int c0 = 0xF000F0;
        int j = c0 % 65536;
        int k = c0 / 65536;
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)((float)j / 1.0f), (float)((float)k / 1.0f));
        GL11.glEnable((int)2896);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        return 1;
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityEnderColossus)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected ResourceLocation func_180573_a(EntityEnderColossus p_180573_1_) {
        return p_180573_1_.getAnimID() == 10 && p_180573_1_.deathTicks > 200 ? endermanDeadTextures : endermanTextures;
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEnderColossus)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEnderColossus)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.func_180573_a((EntityEnderColossus)entity);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEnderColossus)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

