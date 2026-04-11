/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.WorldProvider
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.WorldChunkManagerHell
 *  net.minecraft.world.chunk.IChunkProvider
 *  scala.util.Random
 */
package net.minecraft.theTitans.world;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.world.ChunkProviderVoid;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import scala.util.Random;

public class WorldProviderVoid
extends WorldProvider {
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell((BiomeGenBase)TheTitans.voidland, 0.0f);
        this.worldChunkMgr.getBiomeGenAt(0, 0).setDisableRain().setTemperatureRainfall(2.0f, 0.0f);
        this.dimensionId = 200;
        this.hasNoSky = true;
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderVoid(this.worldObj, this.worldObj.getSeed());
    }

    public float calculateCelestialAngle(long p_76563_1_, float p_76563_3_) {
        return 0.5f;
    }

    @SideOnly(value=Side.CLIENT)
    public float[] calcSunriseSunsetColors(float p_76560_1_, float p_76560_2_) {
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 getFogColor(float p_76562_1, float p_76562_2) {
        Random rand = new Random();
        ArrayList allPlayerList = Lists.newArrayList((Iterable)this.worldObj.loadedEntityList);
        EntityWitherzilla witherzilla = null;
        if (allPlayerList != null && !allPlayerList.isEmpty()) {
            for (int i1 = 0; i1 < allPlayerList.size(); ++i1) {
                Entity entity = (Entity)allPlayerList.get(i1);
                if (!(entity instanceof EntityWitherzilla) || entity.worldObj.provider != this) continue;
                witherzilla = (EntityWitherzilla)entity;
            }
        }
        EntityPlayer player = this.worldObj.getClosestPlayer(0.0, 0.0, 0.0, -1.0);
        float pi = (float)Math.PI;
        double dou1 = MathHelper.cos((float)((float)player.ticksExisted * 0.05f + pi * 1.0f));
        double dou2 = MathHelper.sin((float)((float)player.ticksExisted * 0.05f + pi * 2.0f));
        double dou3 = -((double)MathHelper.cos((float)((float)player.ticksExisted * 0.05f + pi * 3.0f)));
        return witherzilla != null ? (witherzilla.deathTicks > 0 ? Vec3.createVectorHelper((double)1.0, (double)1.0, (double)1.0) : Vec3.createVectorHelper((double)dou1, (double)dou2, (double)dou3)) : Vec3.createVectorHelper((double)0.09, (double)0.09, (double)0.09);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean isSkyColored() {
        return false;
    }

    public boolean canRespawnHere() {
        return false;
    }

    public boolean isSurfaceWorld() {
        return false;
    }

    public boolean canBlockFreeze(int x, int y, int z, boolean byWater) {
        return false;
    }

    public boolean canSnowAt(int x, int y, int z, boolean checkLight) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public float getCloudHeight() {
        return 128.0f;
    }

    public boolean canCoordinateBeSpawn(int p_76566_1_, int p_76566_2_) {
        return this.worldObj.getTopBlock(p_76566_1_, p_76566_2_).getMaterial().blocksMovement();
    }

    public ChunkCoordinates getEntrancePortalLocation() {
        return new ChunkCoordinates(100, 50, 0);
    }

    public int getAverageGroundLevel() {
        return 50;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean doesXZShowFog(int p_76568_1_, int p_76568_2_) {
        return true;
    }

    public String getDimensionName() {
        return "The Void";
    }

    public String getInternalNameSuffix() {
        return "_void";
    }

    public String getWelcomeMessage() {
        return "Entering your DOOM!";
    }

    public String getDepartMessage() {
        return "Leaving the Void.";
    }
}

