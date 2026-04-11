/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 */
package net.minecraft.theTitans.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.titan.EntityWitherzillaMinion;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.world.BiomeVoidDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVoid
extends BiomeGenBase {
    public BiomeGenVoid(int p_i1990_1_) {
        super(p_i1990_1_);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityWitherzillaMinion.class, 100, 12, 12));
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = Blocks.bedrock;
        this.theBiomeDecorator = new BiomeVoidDecorator();
    }

    @SideOnly(value=Side.CLIENT)
    public int getSkyColorByTemp(float p_76731_1_) {
        return 0;
    }
}

