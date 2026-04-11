/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeDecorator
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package net.minecraft.theTitans.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.world.WorldGenGroundTurretTowers;
import net.minecraft.theTitans.world.WorldGenMortarTurretTowers;
import net.minecraft.theTitans.world.WorldGenTurretTowers;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeVoidDecorator
extends BiomeDecorator {
    protected World worldObj;
    protected WorldGenerator turretGen = new WorldGenTurretTowers(Blocks.bedrock);
    protected WorldGenerator turretGen2 = new WorldGenGroundTurretTowers(Blocks.bedrock);
    protected WorldGenerator turretGen3 = new WorldGenMortarTurretTowers(Blocks.bedrock);

    protected void genDecorations(BiomeGenBase p_150513_1_) {
        int k;
        int j;
        int i;
        this.generateOres();
        if (this.randomGenerator.nextInt(2) == 0) {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            k = this.currentWorld.getTopSolidOrLiquidBlock(i, j);
            this.turretGen.generate(this.currentWorld, this.randomGenerator, i, k, j);
        }
        if (this.randomGenerator.nextInt(2) == 0) {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            k = this.currentWorld.getTopSolidOrLiquidBlock(i, j);
            this.turretGen2.generate(this.currentWorld, this.randomGenerator, i, k, j);
        }
        if (this.randomGenerator.nextInt(5) == 0) {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            k = this.currentWorld.getTopSolidOrLiquidBlock(i, j);
            this.turretGen3.generate(this.currentWorld, this.randomGenerator, i, k, j);
        }
        if (this.chunk_X == 0 && this.chunk_Z == 0) {
            EntityWitherzilla witherzilla = new EntityWitherzilla(this.currentWorld);
            witherzilla.setLocationAndAngles(0.0, 200.0, 0.0, this.randomGenerator.nextFloat() * 360.0f, 0.0f);
            this.currentWorld.spawnEntityInWorld((Entity)witherzilla);
        }
    }
}

