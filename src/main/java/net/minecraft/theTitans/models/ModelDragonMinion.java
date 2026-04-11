/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class ModelDragonMinion
extends ModelBase {
    private ModelRenderer head;
    private ModelRenderer spine;
    private ModelRenderer jaw;
    private ModelRenderer body;
    private ModelRenderer rearLeg;
    private ModelRenderer frontLeg;
    private ModelRenderer rearLegTip;
    private ModelRenderer frontLegTip;
    private ModelRenderer rearFoot;
    private ModelRenderer frontFoot;
    private ModelRenderer wing;
    private ModelRenderer wingTip;
    private float partialTicks;
    private static final String __OBFID = "CL_00000870";

    public ModelDragonMinion(float p_i1169_1_) {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.setTextureOffset("body.body", 0, 0);
        this.setTextureOffset("wing.skin", -56, 88);
        this.setTextureOffset("wingtip.skin", -56, 144);
        this.setTextureOffset("rearleg.main", 0, 0);
        this.setTextureOffset("rearfoot.main", 112, 0);
        this.setTextureOffset("rearlegtip.main", 196, 0);
        this.setTextureOffset("head.upperhead", 112, 30);
        this.setTextureOffset("wing.bone", 112, 88);
        this.setTextureOffset("head.upperlip", 176, 44);
        this.setTextureOffset("jaw.jaw", 176, 65);
        this.setTextureOffset("frontleg.main", 112, 104);
        this.setTextureOffset("wingtip.bone", 112, 136);
        this.setTextureOffset("frontfoot.main", 144, 104);
        this.setTextureOffset("neck.box", 192, 104);
        this.setTextureOffset("frontlegtip.main", 226, 138);
        this.setTextureOffset("body.scale", 220, 53);
        this.setTextureOffset("head.scale", 0, 0);
        this.setTextureOffset("neck.scale", 48, 0);
        this.setTextureOffset("head.nostril", 112, 0);
        float f1 = -16.0f;
        this.head = new ModelRenderer((ModelBase)this, "head");
        this.head.addBox("upperlip", -6.0f, -1.0f, -8.0f + f1, 12, 5, 16);
        this.head.addBox("upperhead", -8.0f, -8.0f, 6.0f + f1, 16, 16, 16);
        this.head.mirror = true;
        this.head.addBox("scale", -5.0f, -12.0f, 12.0f + f1, 2, 4, 6);
        this.head.addBox("nostril", -5.0f, -3.0f, -6.0f + f1, 2, 2, 4);
        this.head.mirror = false;
        this.head.addBox("scale", 3.0f, -12.0f, 12.0f + f1, 2, 4, 6);
        this.head.addBox("nostril", 3.0f, -3.0f, -6.0f + f1, 2, 2, 4);
        this.jaw = new ModelRenderer((ModelBase)this, "jaw");
        this.jaw.setRotationPoint(0.0f, 4.0f, 8.0f + f1);
        this.jaw.addBox("jaw", -6.0f, 0.0f, -16.0f, 12, 4, 16);
        this.head.addChild(this.jaw);
        this.spine = new ModelRenderer((ModelBase)this, "neck");
        this.spine.addBox("box", -5.0f, -5.0f, -5.0f, 10, 10, 10);
        this.spine.addBox("scale", -1.0f, -9.0f, -3.0f, 2, 4, 6);
        this.body = new ModelRenderer((ModelBase)this, "body");
        this.body.setRotationPoint(0.0f, 4.0f, 8.0f);
        this.body.addBox("body", -12.0f, 0.0f, -16.0f, 24, 24, 64);
        this.body.addBox("scale", -1.0f, -6.0f, -10.0f, 2, 6, 12);
        this.body.addBox("scale", -1.0f, -6.0f, 10.0f, 2, 6, 12);
        this.body.addBox("scale", -1.0f, -6.0f, 30.0f, 2, 6, 12);
        this.wing = new ModelRenderer((ModelBase)this, "wing");
        this.wing.setRotationPoint(-12.0f, 5.0f, 2.0f);
        this.wing.addBox("bone", -56.0f, -4.0f, -4.0f, 56, 8, 8);
        this.wing.addBox("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wingTip = new ModelRenderer((ModelBase)this, "wingtip");
        this.wingTip.setRotationPoint(-56.0f, 0.0f, 0.0f);
        this.wingTip.addBox("bone", -56.0f, -2.0f, -2.0f, 56, 4, 4);
        this.wingTip.addBox("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wing.addChild(this.wingTip);
        this.frontLeg = new ModelRenderer((ModelBase)this, "frontleg");
        this.frontLeg.setRotationPoint(-12.0f, 20.0f, 2.0f);
        this.frontLeg.addBox("main", -4.0f, -4.0f, -4.0f, 8, 24, 8);
        this.frontLegTip = new ModelRenderer((ModelBase)this, "frontlegtip");
        this.frontLegTip.setRotationPoint(0.0f, 20.0f, -1.0f);
        this.frontLegTip.addBox("main", -3.0f, -1.0f, -3.0f, 6, 24, 6);
        this.frontLeg.addChild(this.frontLegTip);
        this.frontFoot = new ModelRenderer((ModelBase)this, "frontfoot");
        this.frontFoot.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.frontFoot.addBox("main", -4.0f, 0.0f, -12.0f, 8, 4, 16);
        this.frontLegTip.addChild(this.frontFoot);
        this.rearLeg = new ModelRenderer((ModelBase)this, "rearleg");
        this.rearLeg.setRotationPoint(-16.0f, 16.0f, 42.0f);
        this.rearLeg.addBox("main", -8.0f, -4.0f, -8.0f, 16, 32, 16);
        this.rearLegTip = new ModelRenderer((ModelBase)this, "rearlegtip");
        this.rearLegTip.setRotationPoint(0.0f, 32.0f, -4.0f);
        this.rearLegTip.addBox("main", -6.0f, -2.0f, 0.0f, 12, 32, 12);
        this.rearLeg.addChild(this.rearLegTip);
        this.rearFoot = new ModelRenderer((ModelBase)this, "rearfoot");
        this.rearFoot.setRotationPoint(0.0f, 31.0f, 4.0f);
        this.rearFoot.addBox("main", -9.0f, 0.0f, -20.0f, 18, 6, 24);
        this.rearLegTip.addChild(this.rearFoot);
    }

    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
        this.partialTicks = p_78086_4_;
    }

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        float f15;
        GL11.glPushMatrix();
        EntityDragonMinion entitydragon = (EntityDragonMinion)p_78088_1_;
        float f6 = entitydragon.prevAnimTime + (entitydragon.animTime - entitydragon.prevAnimTime) * this.partialTicks;
        this.jaw.rotateAngleX = (float)(Math.sin(f6 * (float)Math.PI * 2.0f) + 1.0) * 0.2f;
        float f7 = (float)(Math.sin(f6 * (float)Math.PI * 2.0f - 1.0f) + 1.0);
        f7 = (f7 * f7 * 1.0f + f7 * 2.0f) * 0.05f;
        GL11.glTranslatef((float)0.0f, (float)(f7 - 2.0f), (float)-3.0f);
        GL11.glRotatef((float)(f7 * 2.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        float f8 = -30.0f;
        float f10 = 0.0f;
        float f11 = 1.5f;
        double[] adouble = entitydragon.getMovementOffsets(6, this.partialTicks);
        float f12 = this.updateRotations(entitydragon.getMovementOffsets(5, this.partialTicks)[0] - entitydragon.getMovementOffsets(10, this.partialTicks)[0]);
        float f13 = this.updateRotations(entitydragon.getMovementOffsets(5, this.partialTicks)[0] + (double)(f12 / 2.0f));
        f8 += 2.0f;
        float f14 = f6 * (float)Math.PI * 2.0f;
        f8 = 20.0f;
        float f9 = -12.0f;
        for (int i = 0; i < 5; ++i) {
            double[] adouble1 = entitydragon.getMovementOffsets(5 - i, this.partialTicks);
            f15 = (float)Math.cos((float)i * 0.45f + f14) * 0.15f;
            this.spine.rotateAngleY = this.updateRotations(adouble1[0] - adouble[0]) * (float)Math.PI / 180.0f * f11;
            this.spine.rotateAngleX = f15 + (float)(adouble1[1] - adouble[1]) * (float)Math.PI / 180.0f * f11 * 5.0f;
            this.spine.rotateAngleZ = -this.updateRotations(adouble1[0] - (double)f13) * (float)Math.PI / 180.0f * f11;
            this.spine.rotationPointY = f8;
            this.spine.rotationPointZ = f9;
            this.spine.rotationPointX = f10;
            f8 = (float)((double)f8 + Math.sin(this.spine.rotateAngleX) * 10.0);
            f9 = (float)((double)f9 - Math.cos(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            f10 = (float)((double)f10 - Math.sin(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            this.spine.render(p_78088_7_);
        }
        this.head.rotationPointY = f8;
        this.head.rotationPointZ = f9;
        this.head.rotationPointX = f10;
        double[] adouble2 = entitydragon.getMovementOffsets(0, this.partialTicks);
        this.head.rotateAngleY = this.updateRotations(adouble2[0] - adouble[0]) * (float)Math.PI / 180.0f * 1.0f;
        this.head.rotateAngleZ = -this.updateRotations(adouble2[0] - (double)f13) * (float)Math.PI / 180.0f * 1.0f;
        this.head.render(p_78088_7_);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-f12 * f11 * 1.0f), (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glTranslatef((float)0.0f, (float)-1.0f, (float)0.0f);
        this.body.rotateAngleZ = 0.0f;
        this.body.render(p_78088_7_);
        for (int j = 0; j < 2; ++j) {
            GL11.glEnable((int)2884);
            f15 = f6 * (float)Math.PI * 2.0f;
            this.wing.rotateAngleX = 0.125f - (float)Math.cos(f15) * 0.2f;
            this.wing.rotateAngleY = 0.25f;
            this.wing.rotateAngleZ = (float)(Math.sin(f15) + 0.125) * 0.8f;
            this.wingTip.rotateAngleZ = -((float)(Math.sin(f15 + 2.0f) + 0.5)) * 0.75f;
            this.rearLeg.rotateAngleX = 1.0f + f7 * 0.1f;
            this.rearLegTip.rotateAngleX = 0.5f + f7 * 0.1f;
            this.rearFoot.rotateAngleX = 0.75f + f7 * 0.1f;
            this.frontLeg.rotateAngleX = 1.3f + f7 * 0.1f;
            this.frontLegTip.rotateAngleX = -0.5f - f7 * 0.1f;
            this.frontFoot.rotateAngleX = 0.75f + f7 * 0.1f;
            this.wing.render(p_78088_7_);
            this.frontLeg.render(p_78088_7_);
            this.rearLeg.render(p_78088_7_);
            GL11.glScalef((float)-1.0f, (float)1.0f, (float)1.0f);
            if (j != 0) continue;
            GL11.glCullFace((int)1028);
        }
        GL11.glPopMatrix();
        GL11.glCullFace((int)1029);
        GL11.glDisable((int)2884);
        float f16 = -((float)Math.sin(f6 * (float)Math.PI * 2.0f)) * 0.0f;
        f14 = f6 * (float)Math.PI * 2.0f;
        f8 = 10.0f;
        f9 = 60.0f;
        f10 = 0.0f;
        adouble = entitydragon.getMovementOffsets(11, this.partialTicks);
        for (int k = 0; k < 12; ++k) {
            adouble2 = entitydragon.getMovementOffsets(12 + k, this.partialTicks);
            f16 = (float)((double)f16 + Math.sin((float)k * 0.45f + f14) * (double)0.05f);
            this.spine.rotateAngleY = (this.updateRotations(adouble2[0] - adouble[0]) * f11 + 180.0f) * (float)Math.PI / 180.0f;
            this.spine.rotateAngleX = f16 + (float)(adouble2[1] - adouble[1]) * (float)Math.PI / 180.0f * f11 * 5.0f;
            this.spine.rotateAngleZ = this.updateRotations(adouble2[0] - (double)f13) * (float)Math.PI / 180.0f * f11;
            this.spine.rotationPointY = f8;
            this.spine.rotationPointZ = f9;
            this.spine.rotationPointX = f10;
            f8 = (float)((double)f8 + Math.sin(this.spine.rotateAngleX) * 10.0);
            f9 = (float)((double)f9 - Math.cos(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            f10 = (float)((double)f10 - Math.sin(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            this.spine.render(p_78088_7_);
        }
        GL11.glPopMatrix();
    }

    private float updateRotations(double p_78214_1_) {
        while (p_78214_1_ >= 180.0) {
            p_78214_1_ -= 360.0;
        }
        while (p_78214_1_ < -180.0) {
            p_78214_1_ += 360.0;
        }
        return (float)p_78214_1_;
    }
}

