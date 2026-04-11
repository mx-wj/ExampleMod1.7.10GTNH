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
import net.minecraft.entity.titanminion.EntitySpiderMinion;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderSpiderMinion
extends RenderLiving {
    private static final ResourceLocation spiderTemplarEyesTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_templar_overlay.png");
    private static final ResourceLocation spiderEyesTextures = new ResourceLocation("textures/entity/spider_eyes.png");
    private static final ResourceLocation spiderTextures = new ResourceLocation("textures/entity/spider/spider.png");
    private static final ResourceLocation spiderPriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_priest.png");
    private static final ResourceLocation spiderZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_zealot.png");
    private static final ResourceLocation spiderBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_bishop.png");
    private static final ResourceLocation spiderTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_templar.png");

    public RenderSpiderMinion() {
        super((ModelBase)new ModelSpider(), 1.0f);
        this.setRenderPassModel((ModelBase)new ModelSpider());
    }

    protected float getDeathMaxRotation(EntitySpiderMinion p_77037_1_) {
        return 180.0f;
    }

    protected int shouldRenderPass(EntitySpiderMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_2_ != 0) {
            return -1;
        }
        this.bindTexture(p_77032_1_.getMinionTypeInt() == 4 ? spiderTemplarEyesTextures : spiderEyesTextures);
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

    protected ResourceLocation getEntityTexture(EntitySpiderMinion p_110775_1_) {
        switch (p_110775_1_.getMinionTypeInt()) {
            case 1: {
                return spiderPriestTextures;
            }
            case 2: {
                return spiderZealotTextures;
            }
            case 3: {
                return spiderBishopTextures;
            }
            case 4: {
                return spiderTemplarTextures;
            }
        }
        return spiderTextures;
    }

    protected float getDeathMaxRotation(EntityLivingBase p_77037_1_) {
        return this.getDeathMaxRotation((EntitySpiderMinion)p_77037_1_);
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntitySpiderMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntitySpiderMinion)p_110775_1_);
    }
}

