/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.IWorldGenerator
 *  cpw.mods.fml.common.Loader
 *  danger.orespawn.OreSpawnMain
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.gen.feature.WorldGenMinable
 */
package net.minecraft.theTitans;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class SpawnEggOreGeneration
implements IWorldGenerator {
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int dimensionId = world.provider.dimensionId;
        if (Loader.isModLoaded((String)"OreSpawn") && dimensionId != -1 && dimensionId != 1 && dimensionId != 200 && dimensionId != 201 && TitanBlocks.MyOverlordScorpionPartSpawnBlock != null) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.MyOverlordScorpionPartSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.MyOverlordScorpionSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.MyMethuselahKrakenPartSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.MyMethuselahKrakenSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyBrutalflySpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyNastysaurusSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyPointysaurusSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCricketSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyFrogSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySpiderDriverSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCrabSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySpiderSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyBatSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCowSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyPigSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySquidSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyChickenSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCreeperSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySkeletonSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyZombieSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySlimeSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyGhastSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyZombiePigmanSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyEndermanSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCaveSpiderSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySilverfishSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyMagmaCubeSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyWitchSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySheepSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyWolfSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyMooshroomSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyOcelotSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyBlazeSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyWitherSkeletonSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyEnderDragonSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySnowGolemSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyIronGolemSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyWitherBossSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyGirlfriendSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyRedCowSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyGoldCowSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyEnchantedCowSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyMOTHRASpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyAloSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCryoSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCamaSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyVeloSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyHydroSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyBasilSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyDragonflySpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyEmperorScorpionSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyScorpionSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCaveFisherSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySpyroSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyBaryonyxSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyGammaMetroidSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCockateilSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyKyuubiSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyAlienSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyAttackSquidSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyWaterDragonSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyKrakenSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyLizardSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCephadromeSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyDragonSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyBeeSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyHorseSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyTrooperBugSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySpitBugSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyStinkBugSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyOstrichSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyGazelleSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyChipmunkSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCreepingHorrorSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyTerribleTerrorSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCliffRacerSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyTriffidSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyPitchBlackSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyLurkingTerrorSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyGodzillaPartSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyGodzillaSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySmallWormSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyMediumWormSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyLargeWormSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCassowarySpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCloudSharkSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyGoldFishSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyLeafMonsterSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyTshirtSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyEnderKnightSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyEnderReaperSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyBeaverSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyTRexSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyHerculesSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyMantisSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyStinkySpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyBoyfriendSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyTheKingPartSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyTheKingSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyEasterBunnySpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCaterKillerSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyMolenoidSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySeaMonsterSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MySeaViperSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyLeonSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyHammerheadSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyRubberDuckySpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyVillagerSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyCriminalSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyTheQueenPartSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, (Block)OreSpawnMain.MyTheQueenSpawnBlock, Blocks.stone, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
        }
    }

    private void generateOre(Random rand, World world, int chunkX, int chunkZ, Block state, Block generateIn, int veinSize, int veinsPerChunk, int maxY) {
        for (int vein = 0; vein < veinsPerChunk; ++vein) {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(maxY);
            int randPosZ = chunkZ + rand.nextInt(16);
            WorldGenMinable genMinable = new WorldGenMinable(state, veinSize, generateIn);
            genMinable.generate(world, rand, randPosX, randPosY, randPosZ);
        }
    }
}

