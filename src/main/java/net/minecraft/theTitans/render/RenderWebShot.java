/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.texture.TextureMap
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderWebShot
extends Render {
    private float field_77002_a;

    public RenderWebShot(float p_i1254_1_) {
        this.field_77002_a = p_i1254_1_;
    }

    public void doRender(EntityFireball p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glEnable((int)32826);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)p_76986_2_), (float)((float)p_76986_4_ + 1.5f), (float)((float)p_76986_6_));
        GL11.glScalef((float)this.field_77002_a, (float)this.field_77002_a, (float)this.field_77002_a);
        GL11.glRotatef((float)(((float)p_76986_1_.ticksExisted + p_76986_9_) * (MathHelper.cos((float)(p_76986_9_ * 0.05f)) * 10.0f)), (float)0.0f, (float)1.0f, (float)0.0f);
        this.bindTexture(TextureMap.locationBlocksTexture);
        this.field_147909_c.renderBlockAsItem(Blocks.web, 0, 1.0f);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityFireball p_110775_1_) {
        return TextureMap.locationItemsTexture;
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntityFireball)p_110775_1_);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityFireball)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}

