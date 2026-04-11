/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityWitherTurretMortar;
import net.minecraft.theTitans.models.ModelWitherMortar;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderWitherTurretMortar
extends RenderLiving {
    private static final ResourceLocation witherTextures = new ResourceLocation("textures/entity/wither/wither.png");
    private ModelWitherMortar modelTurret;

    public RenderWitherTurretMortar() {
        super((ModelBase)new ModelWitherMortar(), 1.25f);
    }

    protected void func_180592_a(EntityWitherTurretMortar p_180592_1_, float p_180592_2_) {
        GL11.glScalef((float)2.5f, (float)2.5f, (float)2.5f);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntityWitherTurretMortar)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation getEntityTexture(EntityWitherTurretMortar entity) {
        return witherTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityWitherTurretMortar)entity);
    }
}

