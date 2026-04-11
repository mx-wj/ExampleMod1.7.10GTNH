/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelKraken
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import danger.orespawn.ModelKraken;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.orespawnaddon.EntityMethuselahKraken;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderMethuselahKraken
extends RenderLiving {
    protected ModelKraken model = (ModelKraken)this.mainModel;
    private float scale = 2.0f;
    private static final ResourceLocation texture = new ResourceLocation("thetitans", "textures/entities/methuselahkraken.png");

    public RenderMethuselahKraken() {
        super((ModelBase)new ModelKraken(1.0f), 2.0f);
    }

    public void renderKraken(EntityMethuselahKraken par1EntityKraken, double par2, double par4, double par6, float par8, float par9) {
        super.doRender((EntityLiving)par1EntityKraken, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderKraken((EntityMethuselahKraken)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderKraken((EntityMethuselahKraken)par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(EntityMethuselahKraken par1Entity, float par2) {
        if (par1Entity != null && par1Entity.getPlayNicely() != 0) {
            GL11.glScalef((float)(this.scale / 3.0f), (float)(this.scale / 3.0f), (float)(this.scale / 3.0f));
            return;
        }
        GL11.glScalef((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
        this.preRenderScale((EntityMethuselahKraken)par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}

