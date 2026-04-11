/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.texture.TextureMap
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.util.IIcon
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderTitanFireball
extends Render {
    public void doRender(EntityTitanFireball fireball, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        Item item = Items.fire_charge;
        IIcon iicon = item.getIconFromDamage(0);
        switch (fireball.getFireballID()) {
            case 1: {
                item = Items.gunpowder;
                iicon = item.getIconFromDamage(0);
                break;
            }
            case 2: {
                item = Items.blaze_powder;
                iicon = item.getIconFromDamage(0);
                break;
            }
            case 3: {
                item = Items.rotten_flesh;
                iicon = item.getIconFromDamage(0);
                break;
            }
            case 4: {
                item = Items.ender_pearl;
                iicon = item.getIconFromDamage(0);
                break;
            }
            case 5: {
                item = Items.iron_ingot;
                iicon = item.getIconFromDamage(0);
                break;
            }
            case 6: {
                item = Items.snowball;
                iicon = item.getIconFromDamage(0);
                break;
            }
            default: {
                item = Items.fire_charge;
                iicon = item.getIconFromDamage(0);
            }
        }
        if (iicon != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)p_76986_2_), (float)((float)p_76986_4_), (float)((float)p_76986_6_));
            GL11.glEnable((int)32826);
            float f1 = fireball.width * 2.0f;
            GL11.glScalef((float)f1, (float)f1, (float)f1);
            this.bindEntityTexture((Entity)fireball);
            Tessellator tessellator = Tessellator.instance;
            this.func_77026_a(tessellator, iicon);
            GL11.glDisable((int)32826);
            GL11.glPopMatrix();
        }
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityTitanFireball)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return TextureMap.locationItemsTexture;
    }

    private void func_77026_a(Tessellator p_77026_1_, IIcon p_77026_2_) {
        float f = p_77026_2_.getMinU();
        float f1 = p_77026_2_.getMaxU();
        float f2 = p_77026_2_.getMinV();
        float f3 = p_77026_2_.getMaxV();
        float f4 = 1.0f;
        float f5 = 0.5f;
        float f6 = 0.25f;
        GL11.glRotatef((float)(180.0f - this.renderManager.playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-this.renderManager.playerViewX), (float)1.0f, (float)0.0f, (float)0.0f);
        p_77026_1_.startDrawingQuads();
        p_77026_1_.setNormal(0.0f, 1.0f, 0.0f);
        p_77026_1_.addVertexWithUV((double)(0.0f - f5), (double)(0.0f - f6), 0.0, (double)f, (double)f3);
        p_77026_1_.addVertexWithUV((double)(f4 - f5), (double)(0.0f - f6), 0.0, (double)f1, (double)f3);
        p_77026_1_.addVertexWithUV((double)(f4 - f5), (double)(f4 - f6), 0.0, (double)f1, (double)f2);
        p_77026_1_.addVertexWithUV((double)(0.0f - f5), (double)(f4 - f6), 0.0, (double)f, (double)f2);
        p_77026_1_.draw();
    }
}

