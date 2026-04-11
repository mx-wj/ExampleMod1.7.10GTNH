/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.IItemRenderer$ItemRenderType
 *  net.minecraftforge.client.IItemRenderer$ItemRendererHelper
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.models.ModelOptimaAxe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderOptimaAxe
implements IItemRenderer {
    private static final ResourceLocation optimaAxeTextures = new ResourceLocation("thetitans", "textures/entities/optima_axe.png");
    ModelOptimaAxe swordmodel = new ModelOptimaAxe();

    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object ... data) {
        switch (type) {
            case EQUIPPED: {
                GL11.glPushMatrix();
                GL11.glScalef((float)1.5f, (float)1.5f, (float)1.5f);
                Minecraft.getMinecraft().renderEngine.bindTexture(optimaAxeTextures);
                GL11.glRotatef((float)80.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)-20.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)-80.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)0.0f, (float)-1.0f, (float)-0.3f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GL11.glPushMatrix();
                GL11.glScalef((float)1.5f, (float)1.5f, (float)1.5f);
                Minecraft.getMinecraft().renderEngine.bindTexture(optimaAxeTextures);
                GL11.glRotatef((float)-30.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)-60.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)-240.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)-0.75f, (float)-1.5f, (float)-0.25f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case ENTITY: {
                GL11.glPushMatrix();
                GL11.glScalef((float)3.0f, (float)3.0f, (float)3.0f);
                Minecraft.getMinecraft().renderEngine.bindTexture(optimaAxeTextures);
                GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glTranslatef((float)0.0f, (float)-1.5f, (float)0.0f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case INVENTORY: {
                GL11.glPushMatrix();
                GL11.glScalef((float)0.8f, (float)0.8f, (float)0.8f);
                Minecraft.getMinecraft().renderEngine.bindTexture(optimaAxeTextures);
                GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)-30.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)-30.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glTranslatef((float)0.0f, (float)-1.0f, (float)0.0f);
                this.swordmodel.render(0.0625f);
                GL11.glPopMatrix();
                break;
            }
        }
    }

    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
        switch (type) {
            case ENTITY: 
            case INVENTORY: {
                return true;
            }
        }
        return false;
    }
}

