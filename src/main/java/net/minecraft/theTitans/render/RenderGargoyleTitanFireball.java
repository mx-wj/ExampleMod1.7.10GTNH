/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.texture.TextureMap
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderGargoyleTitanFireball
extends Render {
    public RenderGargoyleTitanFireball() {
        this.shadowSize = 0.0f;
    }

    protected ResourceLocation getTextures(EntityGargoyleTitanFireball p_180554_1_) {
        return null;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getTextures((EntityGargoyleTitanFireball)entity);
    }

    public void doRender(EntityGargoyleTitanFireball p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glEnable((int)32826);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)p_76986_2_), (float)((float)p_76986_4_ + 1.5f), (float)((float)p_76986_6_));
        GL11.glScalef((float)3.0f, (float)3.0f, (float)3.0f);
        GL11.glRotatef((float)(((float)p_76986_1_.ticksExisted + p_76986_9_) * 10.0f), (float)1.0f, (float)1.0f, (float)1.0f);
        int i = 0xF000F0;
        int j = i % 65536;
        int k = i / 65536;
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)((float)j / 1.0f), (float)((float)k / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.bindTexture(TextureMap.locationBlocksTexture);
        switch (p_76986_1_.getModelVarient()) {
            case 0: {
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.5f, (float)-0.25f, (float)-0.5f);
                GL11.glRotatef((float)30.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.5f, (float)0.0f, (float)0.25f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.25f, (float)0.5f, (float)0.0f);
                GL11.glRotatef((float)-40.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.0f, (float)-0.25f, (float)0.5f);
                GL11.glRotatef((float)-50.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                break;
            }
            case 1: {
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.5f, (float)0.25f, (float)-0.5f);
                GL11.glRotatef((float)60.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.5f, (float)1.0f, (float)0.25f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.25f, (float)-0.5f, (float)0.0f);
                GL11.glRotatef((float)-40.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.25f, (float)-0.25f, (float)-0.5f);
                GL11.glRotatef((float)-50.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                break;
            }
            case 2: {
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.5f, (float)0.5f, (float)-0.25f);
                GL11.glRotatef((float)15.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.5f, (float)-1.0f, (float)-1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.5f, (float)0.5f, (float)0.5f);
                GL11.glRotatef((float)30.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.0f, (float)-0.25f, (float)-1.5f);
                GL11.glRotatef((float)60.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                break;
            }
            case 3: {
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.5f, (float)0.25f, (float)0.5f);
                GL11.glRotatef((float)-30.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.5f, (float)0.0f, (float)-0.25f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.25f, (float)0.5f, (float)0.0f);
                GL11.glRotatef((float)40.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.0f, (float)0.25f, (float)-0.5f);
                GL11.glRotatef((float)50.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                break;
            }
            case 4: {
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)1.5f, (float)-0.25f, (float)-0.5f);
                GL11.glRotatef((float)30.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-1.5f, (float)0.5f, (float)0.25f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.25f, (float)0.5f, (float)0.0f);
                GL11.glRotatef((float)80.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.0f, (float)-0.25f, (float)0.5f);
                GL11.glRotatef((float)30.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                break;
            }
            case 5: {
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.5f, (float)-0.75f, (float)0.5f);
                GL11.glRotatef((float)30.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.5f, (float)0.0f, (float)-0.25f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.25f, (float)-0.5f, (float)0.0f);
                GL11.glRotatef((float)-40.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.25f, (float)-0.25f, (float)0.5f);
                GL11.glRotatef((float)-50.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                break;
            }
            case 6: {
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.5f, (float)-0.25f, (float)-0.5f);
                GL11.glRotatef((float)-60.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.5f, (float)0.0f, (float)0.25f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)-0.25f, (float)0.5f, (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef((float)0.0f, (float)-0.25f, (float)0.5f);
                GL11.glRotatef((float)-30.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            }
        }
        GL11.glPopMatrix();
    }

    private void renderBlock(EntityGargoyleTitanFireball p_76986_1_) {
        switch (p_76986_1_.getBlockType()) {
            case 0: {
                this.field_147909_c.renderBlockAsItem(Blocks.stone, 0, 1.0f);
                break;
            }
            case 1: {
                this.field_147909_c.renderBlockAsItem(Blocks.coal_ore, 0, 1.0f);
                break;
            }
            case 2: {
                this.field_147909_c.renderBlockAsItem(Blocks.iron_ore, 0, 1.0f);
                break;
            }
            case 3: {
                this.field_147909_c.renderBlockAsItem(Blocks.redstone_ore, 0, 1.0f);
                break;
            }
            case 4: {
                this.field_147909_c.renderBlockAsItem(Blocks.gold_ore, 0, 1.0f);
                break;
            }
            case 5: {
                this.field_147909_c.renderBlockAsItem(Blocks.diamond_ore, 0, 1.0f);
                break;
            }
            case 6: {
                this.field_147909_c.renderBlockAsItem(Blocks.emerald_ore, 0, 1.0f);
            }
        }
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityGargoyleTitanFireball)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}

