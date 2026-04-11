/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.MathHelper
 */
package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

@SideOnly(value=Side.CLIENT)
public class ModelSkeletonLoyalist
extends ModelBiped {
    public boolean raiseArms;

    public ModelSkeletonLoyalist() {
        this(0.0f, false);
    }

    public ModelSkeletonLoyalist(float p_i46303_1_, boolean p_i46303_2_) {
        super(p_i46303_1_, 0.0f, 64, 32);
        if (!p_i46303_2_) {
            this.bipedRightArm = new ModelRenderer((ModelBase)this, 40, 16);
            this.bipedRightArm.addBox(-1.0f, -2.0f, -1.0f, 2, 12, 2, p_i46303_1_);
            this.bipedRightArm.setRotationPoint(-5.0f, 2.0f, 0.0f);
            this.bipedLeftArm = new ModelRenderer((ModelBase)this, 40, 16);
            this.bipedLeftArm.mirror = true;
            this.bipedLeftArm.addBox(-1.0f, -2.0f, -1.0f, 2, 12, 2, p_i46303_1_);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
            this.bipedRightLeg = new ModelRenderer((ModelBase)this, 0, 16);
            this.bipedRightLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2, p_i46303_1_);
            this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f, 0.0f);
            this.bipedLeftLeg = new ModelRenderer((ModelBase)this, 0, 16);
            this.bipedLeftLeg.mirror = true;
            this.bipedLeftLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2, p_i46303_1_);
            this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f, 0.0f);
        }
    }

    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
        EntitySkeletonMinion entityskeleton = (EntitySkeletonMinion)p_78086_1_;
        if (entityskeleton.ticksExisted % 1 == 0) {
            ItemStack itemstack = entityskeleton.getHeldItem();
            this.aimedBow = itemstack != null && itemstack.getItem() == Items.bow;
            this.raiseArms = entityskeleton.getAttackTarget() != null && entityskeleton.getDistanceSqToEntity((Entity)entityskeleton.getAttackTarget()) < 36.0 && (itemstack != null && itemstack.getItem() != Items.bow || itemstack == null);
        }
        super.setLivingAnimations((EntityLivingBase)entityskeleton, p_78086_2_, p_78086_3_, p_78086_4_);
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
        if (this.raiseArms) {
            float f6 = MathHelper.sin((float)(this.onGround * (float)Math.PI));
            float f7 = MathHelper.sin((float)((1.0f - (1.0f - this.onGround) * (1.0f - this.onGround)) * (float)Math.PI));
            this.bipedRightArm.rotateAngleZ = 0.0f;
            this.bipedLeftArm.rotateAngleZ = 0.0f;
            this.bipedRightArm.rotateAngleY = -(0.1f - f6 * 0.6f);
            this.bipedLeftArm.rotateAngleY = 0.1f - f6 * 0.6f;
            this.bipedRightArm.rotateAngleX = -1.5707964f;
            this.bipedLeftArm.rotateAngleX = -1.5707964f;
            this.bipedRightArm.rotateAngleX -= f6 * 1.2f - f7 * 0.4f;
            this.bipedLeftArm.rotateAngleX -= f6 * 1.2f - f7 * 0.4f;
            this.bipedRightArm.rotateAngleZ += MathHelper.cos((float)(p_78087_3_ * 0.09f)) * 0.05f + 0.05f;
            this.bipedLeftArm.rotateAngleZ -= MathHelper.cos((float)(p_78087_3_ * 0.09f)) * 0.05f + 0.05f;
            this.bipedRightArm.rotateAngleX += MathHelper.sin((float)(p_78087_3_ * 0.067f)) * 0.05f;
            this.bipedLeftArm.rotateAngleX -= MathHelper.sin((float)(p_78087_3_ * 0.067f)) * 0.05f;
        }
    }
}

