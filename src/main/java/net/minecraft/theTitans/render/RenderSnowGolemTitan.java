/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelSnowMan
 *  net.minecraft.client.renderer.RenderBlocks
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.IItemRenderer$ItemRenderType
 *  net.minecraftforge.client.IItemRenderer$ItemRendererHelper
 *  net.minecraftforge.client.MinecraftForgeClient
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderSnowGolemTitan
extends RenderLiving {
    private static final ResourceLocation snowManTextures = new ResourceLocation("textures/entity/snowman.png");
    private ModelSnowMan snowmanModel;

    public RenderSnowGolemTitan() {
        super((ModelBase)new ModelSnowMan(), 0.5f);
        this.snowmanModel = (ModelSnowMan)this.mainModel;
        this.setRenderPassModel((ModelBase)this.snowmanModel);
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        GL11.glRotatef((float)(180.0f - p_77043_3_), (float)0.0f, (float)1.0f, (float)0.0f);
        if (p_77043_1_.deathTime > 0) {
            float f3 = ((float)p_77043_1_.deathTime + p_77043_4_ - 1.0f) / 20.0f * 1.6f;
            if ((f3 = MathHelper.sqrt_float((float)f3)) > 1.0f) {
                f3 = 1.0f;
            }
            GL11.glScalef((float)(1.0f + f3 * 1.05f), (float)(1.0f - f3 * 0.5f), (float)(1.0f + f3 * 1.05f));
        }
    }

    protected void renderEquippedItems(EntitySnowGolemTitan p_77029_1_, float p_77029_2_) {
        super.renderEquippedItems((EntityLivingBase)p_77029_1_, p_77029_2_);
        Calendar calendar = Calendar.getInstance();
        ItemStack itemstack = calendar.get(2) + 1 == 10 && calendar.get(5) >= 29 && calendar.get(5) <= 31 ? new ItemStack(p_77029_1_.getHealth() <= p_77029_1_.getMaxHealth() / 2.0f ? Blocks.end_portal_frame : Blocks.ender_chest, 1) : new ItemStack(p_77029_1_.getHealth() <= p_77029_1_.getMaxHealth() / 2.0f || p_77029_1_.getInvulTime() > 0 && (p_77029_1_.getInvulTime() > 60 || p_77029_1_.getInvulTime() / 5 % 2 != 1) ? Blocks.pumpkin : Blocks.lit_pumpkin, 1);
        if (itemstack.getItem() instanceof ItemBlock) {
            boolean is3D;
            GL11.glPushMatrix();
            this.snowmanModel.head.postRender(0.0625f);
            IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer((ItemStack)itemstack, (IItemRenderer.ItemRenderType)IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl = is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (is3D || RenderBlocks.renderItemIn3d((int)Block.getBlockFromItem((Item)itemstack.getItem()).getRenderType())) {
                float f1 = 0.625f;
                GL11.glTranslatef((float)0.0f, (float)-0.3437f, (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glScalef((float)f1, (float)(-f1), (float)f1);
            }
            if (p_77029_1_.getHealth() > p_77029_1_.getMaxHealth() / 4.0f) {
                this.renderManager.itemRenderer.renderItem((EntityLivingBase)p_77029_1_, itemstack, 0);
            }
            GL11.glPopMatrix();
        }
    }

    protected void renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_) {
        this.renderEquippedItems((EntitySnowGolemTitan)p_77029_1_, p_77029_2_);
    }

    protected ResourceLocation func_180587_a(EntitySnowGolemTitan p_180587_1_) {
        return snowManTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.func_180587_a((EntitySnowGolemTitan)entity);
    }

    protected void func_180592_a(EntitySnowGolemTitan p_180592_1_, float p_180592_2_) {
        float f1 = 16.0f;
        int i = p_180592_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 10.0f;
        }
        GL11.glScalef((float)f1, (float)f1, (float)f1);
        GL11.glTranslatef((float)0.0f, (float)0.0275f, (float)0.0f);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntitySnowGolemTitan)p_77041_1_, p_77041_2_);
    }

    public void func_180579_a(EntitySnowGolemTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.doRender((EntityLiving)p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySnowGolemTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySnowGolemTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySnowGolemTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

