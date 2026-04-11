/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class ModelEnderColossusCrystal
extends ModelBase {
    private ModelRenderer cube;
    private ModelRenderer glass = new ModelRenderer((ModelBase)this, "glass");

    public ModelEnderColossusCrystal(float p_i1170_1_, boolean p_i1170_2_) {
        this.glass.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.cube = new ModelRenderer((ModelBase)this, "cube");
        this.cube.setTextureOffset(32, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
    }

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        GL11.glPushMatrix();
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        GL11.glTranslatef((float)0.0f, (float)-0.5f, (float)0.0f);
        GL11.glRotatef((float)p_78088_3_, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)(0.8f + p_78088_4_), (float)0.0f);
        GL11.glRotatef((float)60.0f, (float)0.7071f, (float)0.0f, (float)0.7071f);
        this.glass.render(p_78088_7_);
        float f6 = 0.875f;
        GL11.glScalef((float)f6, (float)f6, (float)f6);
        GL11.glRotatef((float)60.0f, (float)0.7071f, (float)0.0f, (float)0.7071f);
        GL11.glRotatef((float)p_78088_3_, (float)0.0f, (float)1.0f, (float)0.0f);
        this.glass.render(p_78088_7_);
        GL11.glScalef((float)f6, (float)f6, (float)f6);
        GL11.glRotatef((float)60.0f, (float)0.7071f, (float)0.0f, (float)0.7071f);
        GL11.glRotatef((float)p_78088_3_, (float)0.0f, (float)1.0f, (float)0.0f);
        this.cube.render(p_78088_7_);
        GL11.glPopMatrix();
    }
}

