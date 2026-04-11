/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
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
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityGhastMinion;
import net.minecraft.theTitans.models.ModelGhastGuard;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderGhastMinion
extends RenderLiving {
    private static final ResourceLocation ghastTextures = new ResourceLocation("textures/entity/ghast/ghast.png");
    private static final ResourceLocation ghastShootingTextures = new ResourceLocation("textures/entity/ghast/ghast_shooting.png");
    private static final ResourceLocation ghastPriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_priest.png");
    private static final ResourceLocation ghastPriestShootingTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_priest_shooting.png");
    private static final ResourceLocation ghastZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_zealot.png");
    private static final ResourceLocation ghastZealotShootingTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_zealot_shooting.png");
    private static final ResourceLocation ghastBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_bishop.png");
    private static final ResourceLocation ghastBishopShootingTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_bishop_shooting.png");
    private static final ResourceLocation ghastTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_templar.png");
    private static final ResourceLocation ghastTemplarShootingTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_templar_shooting.png");

    public RenderGhastMinion() {
        super((ModelBase)new ModelGhastGuard(), 3.0f);
    }

    protected ResourceLocation func_180576_a(EntityGhastMinion p_180576_1_) {
        switch (p_180576_1_.getMinionTypeInt()) {
            case 1: {
                return p_180576_1_.func_110182_bF() ? ghastPriestShootingTextures : ghastPriestTextures;
            }
            case 2: {
                return p_180576_1_.func_110182_bF() ? ghastZealotShootingTextures : ghastZealotTextures;
            }
            case 3: {
                return p_180576_1_.func_110182_bF() ? ghastBishopShootingTextures : ghastBishopTextures;
            }
            case 4: {
                return p_180576_1_.func_110182_bF() ? ghastTemplarShootingTextures : ghastTemplarTextures;
            }
        }
        return p_180576_1_.func_110182_bF() ? ghastShootingTextures : ghastTextures;
    }

    protected void preRenderCallback(EntityGhastMinion p_77041_1_, float p_77041_2_) {
        float f1 = ((float)p_77041_1_.prevAttackCounter + (float)(p_77041_1_.attackCounter - p_77041_1_.prevAttackCounter) * p_77041_2_) / 20.0f;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        f1 = 1.0f / (f1 * f1 * f1 * f1 * f1 * 2.0f + 1.0f);
        float f2 = (8.0f + f1) / 2.0f;
        float f3 = (8.0f + 1.0f / f1) / 2.0f;
        GL11.glScalef((float)f3, (float)f2, (float)f3);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glTranslatef((float)0.0f, (float)0.5f, (float)0.0f);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityGhastMinion)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.func_180576_a((EntityGhastMinion)entity);
    }
}

