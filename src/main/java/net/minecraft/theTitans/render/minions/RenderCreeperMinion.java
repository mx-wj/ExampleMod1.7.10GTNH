/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelCreeper
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render.minions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityCreeperMinion;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderCreeperMinion
extends RenderLiving {
    private static final ResourceLocation armoredCreeperTextures = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    private static final ResourceLocation creeperTextures = new ResourceLocation("textures/entity/creeper/creeper.png");
    private static final ResourceLocation creeperPriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/creepers/creeper_priest.png");
    private static final ResourceLocation creeperZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/creepers/creeper_zealot.png");
    private static final ResourceLocation creeperBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/creepers/creeper_bishop.png");
    private static final ResourceLocation creeperTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/creepers/creeper_templar.png");
    private ModelBase creeperModel = new ModelCreeper(2.0f);

    public RenderCreeperMinion() {
        super((ModelBase)new ModelCreeper(), 0.5f);
        this.setRenderPassModel((ModelBase)new ModelCreeper());
    }

    protected void preRenderCallback(EntityCreeperMinion p_77041_1_, float p_77041_2_) {
        float f1 = p_77041_1_.getCreeperFlashIntensity(p_77041_2_);
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
        GL11.glTranslatef((float)0.0f, (float)0.125f, (float)0.0f);
    }

    protected int getColorMultiplier(EntityCreeperMinion p_77030_1_, float p_77030_2_, float p_77030_3_) {
        float f2 = p_77030_1_.getCreeperFlashIntensity(p_77030_3_);
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

    protected ResourceLocation getEntityTexture(EntityCreeperMinion entity) {
        switch (entity.getMinionTypeInt()) {
            case 1: {
                return creeperPriestTextures;
            }
            case 2: {
                return creeperZealotTextures;
            }
            case 3: {
                return creeperBishopTextures;
            }
            case 4: {
                return creeperTemplarTextures;
            }
        }
        return creeperTextures;
    }

    protected int shouldRenderPass(EntityCreeperMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
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
                float f2 = f1 * 0.01f;
                float f3 = f1 * 0.01f;
                GL11.glTranslatef((float)f2, (float)f3, (float)0.0f);
                this.setRenderPassModel(this.creeperModel);
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

    protected int inheritRenderPass(EntityCreeperMinion p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return -1;
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityCreeperMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityCreeperMinion)p_77041_1_, p_77041_2_);
    }

    protected int getColorMultiplier(EntityLivingBase p_77030_1_, float p_77030_2_, float p_77030_3_) {
        return this.getColorMultiplier((EntityCreeperMinion)p_77030_1_, p_77030_2_, p_77030_3_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityCreeperMinion)entity);
    }
}

