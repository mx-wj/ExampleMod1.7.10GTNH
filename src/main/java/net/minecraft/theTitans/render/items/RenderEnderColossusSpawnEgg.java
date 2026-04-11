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
import net.minecraft.theTitans.models.ModelTitanSpawnEgg;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderEnderColossusSpawnEgg
implements IItemRenderer {
    private static final ResourceLocation eggTextures = new ResourceLocation("thetitans", "textures/entities/eggs/ender_colossus_egg.png");
    ModelTitanSpawnEgg eggmodel = new ModelTitanSpawnEgg();

    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object ... data) {
        switch (type) {
            case EQUIPPED: {
                GL11.glPushMatrix();
                GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
                Minecraft.getMinecraft().renderEngine.bindTexture(eggTextures);
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)0.0f, (float)-0.1f, (float)0.2f);
                this.eggmodel.render(5, (Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GL11.glPushMatrix();
                GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
                Minecraft.getMinecraft().renderEngine.bindTexture(eggTextures);
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)125.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)-0.45f, (float)-0.2f, (float)0.5f);
                this.eggmodel.render(5, (Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case ENTITY: {
                GL11.glPushMatrix();
                GL11.glScalef((float)3.0f, (float)3.0f, (float)3.0f);
                Minecraft.getMinecraft().renderEngine.bindTexture(eggTextures);
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)0.02f, (float)-0.15f, (float)0.02f);
                this.eggmodel.render(5, (Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case INVENTORY: {
                GL11.glPushMatrix();
                GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
                Minecraft.getMinecraft().renderEngine.bindTexture(eggTextures);
                GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                this.eggmodel.render(0.0625f, 5);
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

