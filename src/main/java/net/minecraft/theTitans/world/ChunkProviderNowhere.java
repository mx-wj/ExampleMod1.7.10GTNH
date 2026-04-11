/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.eventhandler.Event
 *  cpw.mods.fml.common.eventhandler.Event$Result
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockFalling
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.IProgressUpdate
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.ChunkPosition
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldType
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.gen.MapGenBase
 *  net.minecraft.world.gen.NoiseGenerator
 *  net.minecraft.world.gen.NoiseGeneratorOctaves
 *  net.minecraft.world.gen.feature.WorldGenDungeons
 *  net.minecraft.world.gen.structure.MapGenMineshaft
 *  net.minecraft.world.gen.structure.MapGenNetherBridge
 *  net.minecraft.world.gen.structure.MapGenVillage
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.terraingen.ChunkProviderEvent$InitNoiseField
 *  net.minecraftforge.event.terraingen.ChunkProviderEvent$ReplaceBiomeBlocks
 *  net.minecraftforge.event.terraingen.InitMapGenEvent$EventType
 *  net.minecraftforge.event.terraingen.PopulateChunkEvent$Post
 *  net.minecraftforge.event.terraingen.PopulateChunkEvent$Pre
 *  net.minecraftforge.event.terraingen.TerrainGen
 *  org.apache.logging.log4j.LogManager
 */
package net.minecraft.theTitans.world;

import cpw.mods.fml.common.eventhandler.Event;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.world.MapGenCavesNowhere;
import net.minecraft.theTitans.world.MapGenRavineNowhere;
import net.minecraft.theTitans.world.WorldGenNowhereDungeon;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenNetherBridge;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import org.apache.logging.log4j.LogManager;

public class ChunkProviderNowhere
implements IChunkProvider {
    private Random voidRNG;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    public NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    private World voidWorld;
    private double[] densities;
    private BiomeGenBase[] biomesForGeneration;
    private final float[] parabolicField;
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;
    double[] field_147427_d;
    double[] field_147428_e;
    double[] field_147425_f;
    double[] field_147426_g;
    int[][] field_73219_j = new int[32][32];
    private WorldType field_147435_p;
    private MapGenBase caveGenerator = new MapGenCavesNowhere();
    private MapGenVillage villageGenerator = new MapGenVillage();
    private MapGenBase ravineGenerator = new MapGenRavineNowhere();
    public MapGenNetherBridge genNetherBridge = new MapGenNetherBridge();
    private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();

    public ChunkProviderNowhere(World p_i2007_1_, long p_i2007_2_) {
        this.genNetherBridge = (MapGenNetherBridge)TerrainGen.getModdedMapGen((MapGenBase)this.genNetherBridge, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.NETHER_BRIDGE);
        this.caveGenerator = TerrainGen.getModdedMapGen((MapGenBase)this.caveGenerator, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.CAVE);
        this.villageGenerator = (MapGenVillage)TerrainGen.getModdedMapGen((MapGenBase)this.villageGenerator, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.VILLAGE);
        this.mineshaftGenerator = (MapGenMineshaft)TerrainGen.getModdedMapGen((MapGenBase)this.mineshaftGenerator, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.MINESHAFT);
        this.ravineGenerator = TerrainGen.getModdedMapGen((MapGenBase)this.ravineGenerator, (InitMapGenEvent.EventType)InitMapGenEvent.EventType.RAVINE);
        this.voidWorld = p_i2007_1_;
        this.voidRNG = new Random(p_i2007_2_);
        this.densities = new double[825];
        this.noiseGen1 = new NoiseGeneratorOctaves(this.voidRNG, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.voidRNG, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.voidRNG, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.voidRNG, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.voidRNG, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.voidRNG, 16);
        this.densities = new double[825];
        NoiseGenerator[] noiseGens = new NoiseGenerator[]{this.noiseGen1, this.noiseGen2, this.noiseGen3, this.noiseGen4, this.noiseGen5, this.noiseGen6};
        noiseGens = TerrainGen.getModdedNoiseGenerators((World)p_i2007_1_, (Random)this.voidRNG, (NoiseGenerator[])noiseGens);
        this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
        this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
        this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
        this.noiseGen4 = (NoiseGeneratorOctaves)noiseGens[3];
        this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
        this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
        this.parabolicField = new float[25];
        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k <= 2; ++k) {
                float f;
                this.parabolicField[j + 2 + (k + 2) * 5] = f = 10.0f / MathHelper.sqrt_float((float)((float)(j * j + k * k) + 0.2f));
            }
        }
    }

    private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
        double d0 = 684.412;
        double d1 = 684.412;
        double d2 = 512.0;
        double d3 = 512.0;
        this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0, 200.0, 0.5);
        this.field_147427_d = this.noiseGen3.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001, 4.277575000000001, 8.555150000000001);
        this.field_147428_e = this.noiseGen1.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412, 684.412, 684.412);
        this.field_147425_f = this.noiseGen2.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412, 684.412, 684.412);
        boolean flag1 = false;
        boolean flag = false;
        int l = 0;
        int i1 = 0;
        double d4 = 8.5;
        for (int j1 = 0; j1 < 5; ++j1) {
            for (int k1 = 0; k1 < 5; ++k1) {
                float f = 0.0f;
                float f1 = 0.0f;
                float f2 = 0.0f;
                int b0 = 2;
                BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
                for (int l1 = -b0; l1 <= b0; ++l1) {
                    for (int i2 = -b0; i2 <= b0; ++i2) {
                        BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
                        float f3 = biomegenbase1.rootHeight;
                        float f4 = biomegenbase1.heightVariation;
                        if (this.field_147435_p == WorldType.AMPLIFIED && f3 > 0.0f) {
                            f3 = 1.0f + f3 * 2.0f;
                            f4 = 1.0f + f4 * 4.0f;
                        }
                        float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0f);
                        if (biomegenbase1.rootHeight > biomegenbase.rootHeight) {
                            f5 /= 2.0f;
                        }
                        f += f4 * f5;
                        f1 += f3 * f5;
                        f2 += f5;
                    }
                }
                f /= f2;
                f1 /= f2;
                f = f * 0.9f + 0.1f;
                f1 = (f1 * 4.0f - 1.0f) / 8.0f;
                double d12 = this.field_147426_g[i1] / 8000.0;
                if (d12 < 0.0) {
                    d12 = -d12 * 0.3;
                }
                if ((d12 = d12 * 3.0 - 2.0) < 0.0) {
                    if ((d12 /= 2.0) < -1.0) {
                        d12 = -1.0;
                    }
                    d12 /= 1.4;
                    d12 /= 2.0;
                } else {
                    if (d12 > 1.0) {
                        d12 = 1.0;
                    }
                    d12 /= 8.0;
                }
                ++i1;
                double d13 = f1;
                double d14 = f;
                d13 += d12 * 0.2;
                d13 = d13 * 8.5 / 8.0;
                double d5 = 8.5 + d13 * 4.0;
                for (int j2 = 0; j2 < 33; ++j2) {
                    double d6 = ((double)j2 - d5) * 12.0 * 128.0 / 256.0 / d14;
                    if (d6 < 0.0) {
                        d6 *= 4.0;
                    }
                    double d7 = this.field_147428_e[l] / 512.0;
                    double d8 = this.field_147425_f[l] / 512.0;
                    double d9 = (this.field_147427_d[l] / 10.0 + 1.0) / 2.0;
                    double d10 = MathHelper.denormalizeClamp((double)d7, (double)d8, (double)d9) - d6;
                    if (j2 > 29) {
                        double d11 = (float)(j2 - 29) / 3.0f;
                        d10 = d10 * (1.0 - d11) + -10.0 * d11;
                    }
                    this.densities[l] = d10;
                    ++l;
                }
            }
        }
    }

    public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_, BiomeGenBase[] biomesForGeneration2) {
        int b0 = 63;
        this.func_147423_a(p_147424_1_ * 4, 0, p_147424_2_ * 4);
        for (int k = 0; k < 4; ++k) {
            int l = k * 5;
            int i1 = (k + 1) * 5;
            for (int j1 = 0; j1 < 4; ++j1) {
                int k1 = (l + j1) * 33;
                int l1 = (l + j1 + 1) * 33;
                int i2 = (i1 + j1) * 33;
                int j2 = (i1 + j1 + 1) * 33;
                for (int k2 = 0; k2 < 32; ++k2) {
                    double d0 = 0.125;
                    double d1 = this.densities[k1 + k2];
                    double d2 = this.densities[l1 + k2];
                    double d3 = this.densities[i2 + k2];
                    double d4 = this.densities[j2 + k2];
                    double d5 = (this.densities[k1 + k2 + 1] - d1) * d0;
                    double d6 = (this.densities[l1 + k2 + 1] - d2) * d0;
                    double d7 = (this.densities[i2 + k2 + 1] - d3) * d0;
                    double d8 = (this.densities[j2 + k2 + 1] - d4) * d0;
                    for (int l2 = 0; l2 < 8; ++l2) {
                        double d9 = 0.25;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for (int i3 = 0; i3 < 4; ++i3) {
                            int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
                            int short1 = 256;
                            j3 -= short1;
                            double d14 = 0.25;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;
                            for (int k3 = 0; k3 < 4; ++k3) {
                                double d;
                                d15 += d16;
                                p_147424_3_[j3 += short1] = d15 > 0.0 ? Blocks.obsidian : null;
                            }
                            d10 += d12;
                            d11 += d13;
                        }
                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    @Deprecated
    public void func_147421_b(int p_147421_1_, int p_147421_2_, Block[] p_147421_3_, BiomeGenBase[] p_147421_4_) {
        this.replaceBiomeBlocks(p_147421_1_, p_147421_2_, p_147421_3_, p_147421_4_, new byte[p_147421_3_.length]);
    }

    public void replaceBiomeBlocks(int p_147421_1_, int p_147421_2_, Block[] p_147421_3_, BiomeGenBase[] p_147421_4_, byte[] meta) {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks((IChunkProvider)this, p_147421_1_, p_147421_2_, p_147421_3_, meta, p_147421_4_, this.voidWorld);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return;
        }
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                int b0 = 1;
                int i1 = -1;
                Block block = Blocks.obsidian;
                Block block1 = Blocks.obsidian;
                for (int j1 = 127; j1 >= 0; --j1) {
                    int k1 = (l * 16 + k) * 128 + j1;
                    Block block2 = p_147421_3_[k1];
                    if (block2 != null && block2.getMaterial() != Material.air) {
                        if (block2 != Blocks.stone) continue;
                        if (i1 == -1) {
                            if (b0 <= 0) {
                                block = null;
                                block1 = Blocks.obsidian;
                            }
                            i1 = b0;
                            if (j1 >= 0) {
                                p_147421_3_[k1] = block;
                                continue;
                            }
                            p_147421_3_[k1] = block1;
                            continue;
                        }
                        if (i1 <= 0) continue;
                        --i1;
                        p_147421_3_[k1] = block1;
                        continue;
                    }
                    i1 = -1;
                }
            }
        }
    }

    public Chunk loadChunk(int p_73158_1_, int p_73158_2_) {
        return this.provideChunk(p_73158_1_, p_73158_2_);
    }

    public Chunk provideChunk(int p_73154_1_, int p_73154_2_) {
        this.voidRNG.setSeed((long)p_73154_1_ * 341873128712L + (long)p_73154_2_ * 132897987541L);
        Block[] ablock = new Block[65536];
        byte[] abyte = new byte[65536];
        this.biomesForGeneration = this.voidWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
        this.func_147424_a(p_73154_1_, p_73154_2_, ablock, this.biomesForGeneration);
        this.caveGenerator.func_151539_a((IChunkProvider)this, this.voidWorld, p_73154_1_, p_73154_2_, ablock);
        this.ravineGenerator.func_151539_a((IChunkProvider)this, this.voidWorld, p_73154_1_, p_73154_2_, ablock);
        this.genNetherBridge.func_151539_a((IChunkProvider)this, this.voidWorld, p_73154_1_, p_73154_2_, ablock);
        this.villageGenerator.func_151539_a((IChunkProvider)this, this.voidWorld, p_73154_1_, p_73154_2_, ablock);
        this.mineshaftGenerator.func_151539_a((IChunkProvider)this, this.voidWorld, p_73154_1_, p_73154_2_, ablock);
        this.replaceBiomeBlocks(p_73154_1_, p_73154_2_, ablock, this.biomesForGeneration, abyte);
        Chunk chunk = new Chunk(this.voidWorld, ablock, abyte, p_73154_1_, p_73154_2_);
        byte[] abyte1 = chunk.getBiomeArray();
        for (int k = 0; k < abyte1.length; ++k) {
            abyte1[k] = (byte)this.biomesForGeneration[k].biomeID;
        }
        chunk.generateSkylightMap();
        return chunk;
    }

    private double[] initializeNoiseField(double[] p_73187_1_, int p_73187_2_, int p_73187_3_, int p_73187_4_, int p_73187_5_, int p_73187_6_, int p_73187_7_) {
        ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField((IChunkProvider)this, p_73187_1_, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return event.noisefield;
        }
        if (p_73187_1_ == null) {
            p_73187_1_ = new double[p_73187_5_ * p_73187_6_ * p_73187_7_];
        }
        double d0 = 684.412;
        double d1 = 684.412;
        this.noiseData4 = this.noiseGen4.generateNoiseOctaves(this.noiseData4, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 1.121, 1.121, 0.5);
        this.noiseData5 = this.noiseGen5.generateNoiseOctaves(this.noiseData5, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 200.0, 200.0, 0.5);
        this.noiseData1 = this.noiseGen3.generateNoiseOctaves(this.noiseData1, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, (d0 *= 2.0) / 80.0, d1 / 160.0, d0 / 80.0);
        this.noiseData2 = this.noiseGen1.generateNoiseOctaves(this.noiseData2, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0, d1, d0);
        this.noiseData3 = this.noiseGen2.generateNoiseOctaves(this.noiseData3, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0, d1, d0);
        int k1 = 0;
        int l1 = 0;
        for (int i2 = 0; i2 < p_73187_5_; ++i2) {
            for (int j2 = 0; j2 < p_73187_7_; ++j2) {
                double d3;
                double d2 = (this.noiseData4[l1] + 256.0) / 512.0;
                if (d2 > 1.0) {
                    d2 = 1.0;
                }
                if ((d3 = this.noiseData5[l1] / 8000.0) < 0.0) {
                    d3 = -d3 * 0.3;
                }
                d3 = d3 * 3.0 - 2.0;
                float f = (float)(i2 + p_73187_2_ - 0) / 1.0f;
                float f1 = (float)(j2 + p_73187_4_ - 0) / 1.0f;
                float f2 = 100.0f - MathHelper.sqrt_float((float)(f * f + f1 * f1)) * 8.0f;
                if (f2 > 80.0f) {
                    f2 = 80.0f;
                }
                if (f2 < -100.0f) {
                    f2 = -100.0f;
                }
                if (d3 > 1.0) {
                    d3 = 1.0;
                }
                d3 /= 8.0;
                d3 = 0.0;
                if (d2 < 0.0) {
                    d2 = 0.0;
                }
                d2 += 0.5;
                d3 = d3 * (double)p_73187_6_ / 16.0;
                ++l1;
                double d4 = (double)p_73187_6_ / 2.0;
                for (int k2 = 0; k2 < p_73187_6_; ++k2) {
                    double d10;
                    double d5 = 0.0;
                    double d6 = ((double)k2 - d4) * 8.0 / d2;
                    if (d6 < 0.0) {
                        d6 *= -1.0;
                    }
                    double d7 = this.noiseData2[k1] / 512.0;
                    double d8 = this.noiseData3[k1] / 512.0;
                    double d9 = (this.noiseData1[k1] / 10.0 + 1.0) / 2.0;
                    d5 = d9 < 0.0 ? d7 : (d9 > 1.0 ? d8 : d7 + (d8 - d7) * d9);
                    d5 -= 8.0;
                    d5 += (double)f2;
                    int b0 = 2;
                    if (k2 > p_73187_6_ / 2 - b0) {
                        d10 = (float)(k2 - (p_73187_6_ / 2 - b0)) / 64.0f;
                        if (d10 < 0.0) {
                            d10 = 0.0;
                        }
                        if (d10 > 1.0) {
                            d10 = 1.0;
                        }
                        d5 = d5 * (1.0 - d10) + -3000.0 * d10;
                    }
                    if (k2 < (b0 = 8)) {
                        d10 = (float)(b0 - k2) / ((float)b0 - 1.0f);
                        d5 = d5 * (1.0 - d10) + -30.0 * d10;
                    }
                    p_73187_1_[k1] = d5;
                    ++k1;
                }
            }
        }
        return p_73187_1_;
    }

    public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
        return true;
    }

    public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
        int j2;
        int i2;
        int l1;
        int k1;
        BlockFalling.fallInstantly = true;
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(p_73153_1_, this.voidWorld, this.voidWorld.rand, p_73153_2_, p_73153_3_, false));
        int k = p_73153_2_ * 16;
        int l = p_73153_3_ * 16;
        BiomeGenBase biomegenbase = this.voidWorld.getBiomeGenForCoords(k + 16, l + 16);
        this.voidRNG.setSeed(this.voidWorld.getSeed());
        long i1 = this.voidRNG.nextLong() / 2L * 2L + 1L;
        long j1 = this.voidRNG.nextLong() / 2L * 2L + 1L;
        this.voidRNG.setSeed((long)p_73153_2_ * i1 + (long)p_73153_3_ * j1 ^ this.voidWorld.getSeed());
        boolean flag = false;
        flag = this.villageGenerator.generateStructuresInChunk(this.voidWorld, this.voidRNG, p_73153_2_, p_73153_3_);
        this.genNetherBridge.generateStructuresInChunk(this.voidWorld, this.voidRNG, p_73153_2_, p_73153_3_);
        this.mineshaftGenerator.generateStructuresInChunk(this.voidWorld, this.voidRNG, p_73153_2_, p_73153_3_);
        biomegenbase.decorate(this.voidWorld, this.voidRNG, k, l);
        for (k1 = 0; k1 < 100; ++k1) {
            l1 = k + this.voidRNG.nextInt(16) + 8;
            i2 = this.voidRNG.nextInt(256);
            j2 = l + this.voidRNG.nextInt(16) + 8;
            new WorldGenNowhereDungeon().generate(this.voidWorld, this.voidRNG, l1, i2, j2);
        }
        for (k1 = 0; k1 < 800; ++k1) {
            l1 = k + this.voidRNG.nextInt(16) + 8;
            i2 = this.voidRNG.nextInt(256);
            j2 = l + this.voidRNG.nextInt(16) + 8;
            new WorldGenDungeons().generate(this.voidWorld, this.voidRNG, l1, i2, j2);
        }
        if (this.voidRNG.nextInt(50000) == 0) {
            l1 = k + this.voidRNG.nextInt(16) + 8;
            j2 = l + this.voidRNG.nextInt(16) + 8;
            i2 = this.voidWorld.getTopSolidOrLiquidBlock(l1, j2);
            EntityEnderColossus witherzilla = new EntityEnderColossus(this.voidWorld);
            witherzilla.setLocationAndAngles(l1, i2, j2, 0.0f, 0.0f);
            LogManager.getLogger(TheTitans.class).info("Found a succesfully spawned Ender Colossus at " + l1 + ", " + i2 + ", " + j2 + ", spawning.");
            this.voidWorld.spawnEntityInWorld((Entity)witherzilla);
        }
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(p_73153_1_, this.voidWorld, this.voidWorld.rand, p_73153_2_, p_73153_3_, false));
        BlockFalling.fallInstantly = false;
    }

    public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
        return true;
    }

    public void saveExtraData() {
    }

    public boolean unloadQueuedChunks() {
        return false;
    }

    public boolean canSave() {
        return true;
    }

    public String makeString() {
        return "RandomLevelSource";
    }

    public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
        if (p_73155_1_ == EnumCreatureType.monster) {
            if (this.genNetherBridge.hasStructureAt(p_73155_2_, p_73155_3_, p_73155_4_)) {
                return this.genNetherBridge.getSpawnList();
            }
            if (this.genNetherBridge.func_142038_b(p_73155_2_, p_73155_3_, p_73155_4_) && this.voidWorld.getBlock(p_73155_2_, p_73155_3_ - 1, p_73155_4_) == Blocks.nether_brick) {
                return this.genNetherBridge.getSpawnList();
            }
        }
        BiomeGenBase biomegenbase = this.voidWorld.getBiomeGenForCoords(p_73155_2_, p_73155_4_);
        return biomegenbase.getSpawnableList(p_73155_1_);
    }

    public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
        return null;
    }

    public int getLoadedChunkCount() {
        return 0;
    }

    public void recreateStructures(int p_82695_1_, int p_82695_2_) {
        this.villageGenerator.func_151539_a((IChunkProvider)this, this.voidWorld, p_82695_1_, p_82695_2_, (Block[])null);
        this.genNetherBridge.func_151539_a((IChunkProvider)this, this.voidWorld, p_82695_1_, p_82695_2_, (Block[])null);
        this.mineshaftGenerator.func_151539_a((IChunkProvider)this, this.voidWorld, p_82695_1_, p_82695_2_, (Block[])null);
    }
}

