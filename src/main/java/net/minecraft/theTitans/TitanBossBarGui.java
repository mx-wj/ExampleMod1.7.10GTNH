/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.eventhandler.SubscribeEvent
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.theTitans;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityBlazeTitan;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityMagmaCubeTitan;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySlimeTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

public class TitanBossBarGui
extends Gui {
    private Minecraft mc;
    private static ResourceLocation texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/witherzilla.png");

    public TitanBossBarGui(Minecraft mc) {
        this.mc = mc;
    }

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent event) {
        if (event.isCancelable()) {
            return;
        }
        int u = 0;
        int v = 0;
        String outstring = null;
        int color = 0xF9F9F9;
        FontRenderer fr = this.mc.fontRenderer;
        int barWidth = 182;
        int namey = 10;
        int barHeight = 5;
        int y = 0;
        float fade = 1.0f;
        float gfHealth = 0.0f;
        boolean flag = true;
        Entity entity = null;
        EntityClientPlayerMP player = null;
        if (this.mc.playerController.enableEverythingIsScrewedUpMode()) {
            return;
        }
        player = this.mc.thePlayer;
        if (player == null) {
            return;
        }
        List list = player.worldObj.loadedEntityList;
        if (list != null && !list.isEmpty()) {
            for (int j = 0; j < list.size(); ++j) {
                int x;
                int barWidthFilled;
                int width;
                ScaledResolution res;
                entity = (Entity)list.get(j);
                if (entity == null || entity.isDead || !(entity instanceof EntityTitan)) continue;
                EntityTitan e = (EntityTitan)entity;
                outstring = e.getCommandSenderName();
                gfHealth = e.getHealth() / e.getMaxHealth();
                flag = !e.getWaiting() && !e.isInvisible();
                fade = !e.isEntityAlive() ? 0.25f : 1.0f;
                if (e instanceof EntitySnowGolemTitan) {
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/snow_golem_titan.png");
                    barWidth = 185;
                    barHeight = 27;
                    color = 0xBCBCBC;
                    y = 0;
                    namey = y + 20;
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntitySlimeTitan) {
                    if (e instanceof EntityMagmaCubeTitan) {
                        barWidth = 193;
                        barHeight = 19;
                        y = 17;
                        namey = y + 12;
                        color = 0xFCFC00;
                        texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/magma_cube_titan.png");
                    } else {
                        barWidth = 189;
                        barHeight = 22;
                        y = 14;
                        namey = y + 9;
                        color = 5349438;
                        texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/slime_titan.png");
                    }
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntitySilverfishTitan) {
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/omegafish.png");
                    barWidth = 185;
                    barHeight = 33;
                    color = 0x303030;
                    y = 7;
                    namey = y + 26;
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntitySpiderTitan) {
                    barWidth = 187;
                    barHeight = 23;
                    color = 11013646;
                    if (e instanceof EntityCaveSpiderTitan) {
                        y = 21;
                        namey = y + 16;
                        texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/cave_spider_titan.png");
                    } else {
                        y = 26;
                        namey = y + 16;
                        texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/spider_titan.png");
                    }
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntitySkeletonTitan && ((EntitySkeletonTitan)e).getSkeletonType() != 1) {
                    barWidth = 185;
                    barHeight = 24;
                    color = 0xC1C1C1;
                    y = 31;
                    namey = y + 17;
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/skeleton_titan.png");
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntityZombieTitan) {
                    barWidth = 185;
                    barHeight = 22;
                    color = 7969893;
                    y = 40;
                    namey = y + 17;
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/zombie_titan.png");
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntityCreeperTitan) {
                    barWidth = 216;
                    barHeight = 33;
                    color = 894731;
                    y = 44;
                    namey = y + 17;
                    texture = ((EntityCreeperTitan)e).getPowered() ? new ResourceLocation("thetitans", "textures/entities/titans/bossbars/charged_creeper_titan.png") : new ResourceLocation("thetitans", "textures/entities/titans/bossbars/creeper_titan.png");
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntityPigZombieTitan) {
                    barWidth = 185;
                    barHeight = 27;
                    color = 15373203;
                    y = 47;
                    namey = y + 20;
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/zombie_pigman_titan.png");
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntityBlazeTitan) {
                    barWidth = 185;
                    barHeight = 34;
                    color = 16167425;
                    y = 50;
                    namey = y + 25;
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/blaze_titan.png");
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntitySkeletonTitan && ((EntitySkeletonTitan)e).getSkeletonType() == 1) {
                    barWidth = 185;
                    barHeight = 24;
                    color = 0x494949;
                    y = 48;
                    namey = y + 33;
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/wither_skeleton_titan.png");
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntityGhastTitan) {
                    barWidth = 185;
                    barHeight = 32;
                    color = 0xBCBCBC;
                    y = 46;
                    namey = y + 43;
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/ghast_titan.png");
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntityIronGolemTitan) {
                    barWidth = 191;
                    barHeight = 26;
                    color = 0x6E6E6E;
                    y = 55;
                    namey = y + 40;
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/ultima_iron_golem_titan.png");
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntityEnderColossus) {
                    barWidth = 193;
                    barHeight = 23;
                    color = 13369594;
                    y = 62;
                    namey = y + 36;
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/ender_colossus.png");
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, 0xF9F9F9);
                    }
                }
                if (e instanceof EntityWitherzilla) {
                    barWidth = 185;
                    barHeight = 32;
                    color = 0xF000F0 - (int)(MathHelper.cos((float)((float)e.ticksExisted * 0.05f)) * 1.572888E7f);
                    y = 46;
                    namey = y + 61;
                    fade = 1.0f + MathHelper.cos((float)((float)e.ticksExisted * 0.2f)) * 0.3f;
                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/witherzilla.png");
                    res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                    width = res.getScaledWidth();
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                    x = width / 2 - barWidth / 2;
                    if (flag) {
                        fr.drawStringWithShadow((int)e.getHealth() + "/" + (int)e.getMaxHealth(), width / 2 - fr.getStringWidth((int)e.getHealth() + "/" + (int)e.getMaxHealth()) / 2, namey + 10, color);
                    }
                }
                if (outstring == null) {
                    return;
                }
                if (!flag) continue;
                res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                width = res.getScaledWidth();
                barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                x = width / 2 - barWidth / 2;
                this.mc.renderEngine.bindTexture(texture);
                GL11.glColor4f((float)fade, (float)fade, (float)fade, (float)1.0f);
                if (e.getTitanStatus() == EnumTitanStatus.GREATER) {
                    GL11.glScalef((float)1.25f, (float)1.25f, (float)1.25f);
                    x = width / 3 - barWidth / 3 - 6;
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                }
                if (e.getTitanStatus() == EnumTitanStatus.GOD) {
                    GL11.glScalef((float)1.5f, (float)1.5f, (float)1.5f);
                    x = width / 4 - barWidth / 4 - 12;
                    barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                }
                GL11.glEnable((int)2977);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                this.drawTexturedModalRect(x, y, u, v, barWidth, barHeight);
                if (barWidthFilled > 0) {
                    this.drawTexturedModalRect(x, y, u, v + barHeight, barWidthFilled, barHeight);
                }
                GL11.glDisable((int)3042);
                if (e.getTitanStatus() == EnumTitanStatus.GREATER) {
                    GL11.glScalef((float)0.8f, (float)0.8f, (float)0.8f);
                }
                if (e.getTitanStatus() == EnumTitanStatus.GOD) {
                    GL11.glScalef((float)0.6666667f, (float)0.6666667f, (float)0.6666667f);
                }
                fr.drawStringWithShadow(outstring, width / 2 - fr.getStringWidth(outstring) / 2, namey, color);
            }
        }
    }
}

