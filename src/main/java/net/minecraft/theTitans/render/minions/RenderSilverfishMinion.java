/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelSilverfish
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 */
package net.minecraft.theTitans.render.minions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntitySilverfishMinion;
import net.minecraft.util.ResourceLocation;

@SideOnly(value=Side.CLIENT)
public class RenderSilverfishMinion
extends RenderLiving {
    private static final ResourceLocation silverfishTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/silverfish/silverfish_templar.png");
    private static final ResourceLocation silverfishBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/silverfish/silverfish_bishop.png");
    private static final ResourceLocation silverfishZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/silverfish/silverfish_zealot.png");
    private static final ResourceLocation silverfishPriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/silverfish/silverfish_priest.png");
    private static final ResourceLocation silverfishTextures = new ResourceLocation("textures/entity/silverfish.png");

    public RenderSilverfishMinion() {
        super((ModelBase)new ModelSilverfish(), 0.3f);
    }

    protected float getDeathMaxRotation(EntitySilverfishMinion p_77037_1_) {
        return 180.0f;
    }

    public void doRender(EntitySilverfishMinion p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(EntitySilverfishMinion p_110775_1_) {
        switch (p_110775_1_.getMinionTypeInt()) {
            case 1: {
                return silverfishPriestTextures;
            }
            case 2: {
                return silverfishZealotTextures;
            }
            case 3: {
                return silverfishBishopTextures;
            }
            case 4: {
                return silverfishTemplarTextures;
            }
        }
        return silverfishTextures;
    }

    protected int shouldRenderPass(EntitySilverfishMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return -1;
    }

    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntitySilverfishMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected float getDeathMaxRotation(EntityLivingBase p_77037_1_) {
        return this.getDeathMaxRotation((EntitySilverfishMinion)p_77037_1_);
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntitySilverfishMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntitySilverfishMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntitySilverfishMinion)p_110775_1_);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntitySilverfishMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}

