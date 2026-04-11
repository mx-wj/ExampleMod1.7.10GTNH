/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelSpider
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render.minions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityCaveSpiderMinion;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderCaveSpiderMinion
extends RenderLiving {
    private static final ResourceLocation spiderEyesTextures = new ResourceLocation("textures/entity/spider_eyes.png");
    private static final ResourceLocation templarEyes = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_templar_overlay.png");
    private static final ResourceLocation caveSpiderTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/cave_spider_templar.png");
    private static final ResourceLocation caveSpiderBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/cave_spider_bishop.png");
    private static final ResourceLocation caveSpiderZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/cave_spider_zealot.png");
    private static final ResourceLocation caveSpiderPriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/cave_spider_priest.png");
    private static final ResourceLocation caveSpiderTextures = new ResourceLocation("textures/entity/spider/cave_spider.png");

    public RenderCaveSpiderMinion() {
        super((ModelBase)new ModelSpider(), 0.7f);
        this.setRenderPassModel((ModelBase)new ModelSpider());
    }

    protected void preRenderCallback(EntityCaveSpiderMinion p_77041_1_, float p_77041_2_) {
        GL11.glScalef((float)0.7f, (float)0.7f, (float)0.7f);
    }

    protected float getDeathMaxRotation(EntityCaveSpiderMinion p_77037_1_) {
        return 180.0f;
    }

    protected float getDeathMaxRotation(EntityLivingBase p_77037_1_) {
        return this.getDeathMaxRotation((EntityCaveSpiderMinion)p_77037_1_);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityCaveSpiderMinion)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation getEntityTexture(EntityCaveSpiderMinion p_180586_1_) {
        switch (p_180586_1_.getMinionTypeInt()) {
            case 1: {
                return caveSpiderPriestTextures;
            }
            case 2: {
                return caveSpiderZealotTextures;
            }
            case 3: {
                return caveSpiderBishopTextures;
            }
            case 4: {
                return caveSpiderTemplarTextures;
            }
        }
        return caveSpiderTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityCaveSpiderMinion)entity);
    }

    protected int shouldRenderPass(EntityCaveSpiderMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_2_ != 0) {
            return -1;
        }
        this.bindTexture(p_77032_1_.getMinionTypeInt() == 4 ? templarEyes : spiderEyesTextures);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)1, (int)1);
        if (p_77032_1_.isInvisible()) {
            GL11.glDepthMask((boolean)false);
        } else {
            GL11.glDepthMask((boolean)true);
        }
        int c0 = 61680;
        int j = c0 % 65536;
        int k = c0 / 65536;
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)((float)j / 1.0f), (float)((float)k / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        return 1;
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityCaveSpiderMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }
}

