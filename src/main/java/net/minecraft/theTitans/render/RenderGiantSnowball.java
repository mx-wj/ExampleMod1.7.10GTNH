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
 *  net.minecraft.entity.projectile.EntityPotion
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.potion.PotionHelper
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
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderGiantSnowball
extends Render {
    private Item field_94151_a;
    private int field_94150_f;
    private float field_77002_a;
    private boolean customize;

    public RenderGiantSnowball(Item p_i1259_1_, int p_i1259_2_, float p_i1259_3_) {
        this.field_94151_a = p_i1259_1_;
        this.field_94150_f = p_i1259_2_;
        this.field_77002_a = p_i1259_3_;
    }

    public RenderGiantSnowball(Item p_i1260_1_) {
        this(p_i1260_1_, 0, 4.0f);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        IIcon iicon = this.field_94151_a.getIconFromDamage(this.field_94150_f);
        if (iicon != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)p_76986_2_), (float)((float)p_76986_4_), (float)((float)p_76986_6_));
            GL11.glEnable((int)32826);
            float f1 = this.field_77002_a;
            GL11.glScalef((float)(f1 / 1.0f), (float)(f1 / 1.0f), (float)(f1 / 1.0f));
            this.bindEntityTexture(p_76986_1_);
            Tessellator tessellator = Tessellator.instance;
            if (iicon == ItemPotion.func_94589_d((String)"bottle_splash")) {
                int i = PotionHelper.func_77915_a((int)((EntityPotion)p_76986_1_).getPotionDamage(), (boolean)false);
                float f2 = (float)(i >> 16 & 0xFF) / 255.0f;
                float f3 = (float)(i >> 8 & 0xFF) / 255.0f;
                float f4 = (float)(i & 0xFF) / 255.0f;
                GL11.glColor3f((float)f2, (float)f3, (float)f4);
                GL11.glPushMatrix();
                this.func_77026_a(tessellator, ItemPotion.func_94589_d((String)"overlay"));
                GL11.glPopMatrix();
                GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
            }
            this.func_77026_a(tessellator, iicon);
            GL11.glDisable((int)32826);
            GL11.glPopMatrix();
        }
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

