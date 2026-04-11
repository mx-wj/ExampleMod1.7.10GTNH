/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  danger.orespawn.ModelEmperorScorpion
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import danger.orespawn.ModelEmperorScorpion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.orespawnaddon.EntityOverlordScorpion;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderOverlordScorpion
extends RenderLiving {
    protected ModelEmperorScorpion model = (ModelEmperorScorpion)this.mainModel;
    private float scale = 1.5f;
    private static final ResourceLocation texture = new ResourceLocation("thetitans", "textures/entities/overlordscorpion.png");

    public RenderOverlordScorpion() {
        super((ModelBase)new ModelEmperorScorpion(0.22f), 1.75f);
    }

    protected void preRenderScale(EntityOverlordScorpion par1Entity, float par2) {
        GL11.glScalef((float)3.0f, (float)3.0f, (float)3.0f);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
        this.preRenderScale((EntityOverlordScorpion)par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}

