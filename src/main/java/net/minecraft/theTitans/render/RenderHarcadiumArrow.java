/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.renderer.entity.RenderArrow
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.util.ResourceLocation
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.ResourceLocation;

@SideOnly(value=Side.CLIENT)
public class RenderHarcadiumArrow
extends RenderArrow {
    private static final ResourceLocation arrowTextures = new ResourceLocation("thetitans", "textures/entities/harcadium_arrow_entity.png");

    protected ResourceLocation getEntityTexture(EntityArrow p_180550_1_) {
        return arrowTextures;
    }
}

