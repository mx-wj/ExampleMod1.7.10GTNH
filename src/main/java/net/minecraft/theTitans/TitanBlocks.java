/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.Loader
 *  cpw.mods.fml.common.registry.GameRegistry
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 */
package net.minecraft.theTitans;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.blocks.BlockCompactBedrock;
import net.minecraft.theTitans.blocks.BlockCustomNonSmeltingOre;
import net.minecraft.theTitans.blocks.BlockCustomOre;
import net.minecraft.theTitans.blocks.BlockHarcadiumBlock;
import net.minecraft.theTitans.blocks.BlockHarcadiumOre;
import net.minecraft.theTitans.blocks.BlockMalgrumCrop;
import net.minecraft.theTitans.blocks.BlockNetherCoalOre;
import net.minecraft.theTitans.blocks.BlockNetherDiamondOre;
import net.minecraft.theTitans.blocks.BlockNetherGoldOre;
import net.minecraft.theTitans.blocks.BlockNetherStoneOre;
import net.minecraft.theTitans.blocks.BlockOreEgg;
import net.minecraft.theTitans.blocks.BlockPleasantBladeCrop;
import net.minecraft.theTitans.blocks.BlockVoidBlock;
import net.minecraft.theTitans.blocks.BlockVoidOre;

public class TitanBlocks {
    public static Block copper_ore;
    public static Block tin_ore;
    public static Block chromium_ore;
    public static Block magnesium_ore;
    public static Block lead_ore;
    public static Block silver_ore;
    public static Block platinum_ore;
    public static Block harcadium_ore;
    public static Block harcadium_ore_end_stone;
    public static Block harcadium_ore_obsidian;
    public static Block void_ore;
    public static Block void_ore_end_stone;
    public static Block void_ore_obsidian;
    public static Block adamantium_ore;
    public static Block nether_stone_ore;
    public static Block nether_coal_ore;
    public static Block nether_gold_ore;
    public static Block nether_diamond_ore;
    public static Block harcadium_block;
    public static Block void_block;
    public static Block bedrock_block;
    public static Block malgrumCrop;
    public static Block pleasantBladeCrop;
    public static Block magic_pumpkin;
    public static Block stoneperch;
    public static Block sandstoneperch;
    public static Block obsidianperch;
    public static Block goldperch;
    public static Block ironperch;
    public static Block endstoneperch;
    public static Block netherbrickperch;
    public static Block MyOverlordScorpionPartSpawnBlock;
    public static Block MyOverlordScorpionSpawnBlock;
    public static Block MyMethuselahKrakenPartSpawnBlock;
    public static Block MyMethuselahKrakenSpawnBlock;

    public static void init() {
        copper_ore = new BlockCustomOre(0, "copper_ore", 3.0f, 5.0f);
        tin_ore = new BlockCustomOre(0, "tin_ore", 3.0f, 5.0f);
        chromium_ore = new BlockCustomOre(1, "chromium_ore", 3.0f, 5.0f);
        magnesium_ore = new BlockCustomOre(1, "magnesium_ore", 3.0f, 5.0f);
        lead_ore = new BlockCustomOre(1, "lead_ore", 5.0f, 5.0f);
        silver_ore = new BlockCustomOre(1, "silver_ore", 5.0f, 10.0f);
        platinum_ore = new BlockCustomOre(2, "platinum_ore", 5.0f, 15.0f);
        nether_stone_ore = new BlockNetherStoneOre(Material.rock);
        nether_coal_ore = new BlockNetherCoalOre(Material.rock);
        nether_gold_ore = new BlockNetherGoldOre(Material.rock);
        nether_diamond_ore = new BlockNetherDiamondOre(Material.rock);
        harcadium_ore = new BlockHarcadiumOre(Material.rock, "harcadium_ore");
        harcadium_ore_end_stone = new BlockHarcadiumOre(Material.rock, "harcadium_ore_end_stone");
        harcadium_ore_obsidian = new BlockHarcadiumOre(Material.rock, "harcadium_ore_obsidian");
        harcadium_block = new BlockHarcadiumBlock(Material.iron, "harcadium_block");
        void_ore = new BlockVoidOre(Material.rock, "void_ore");
        void_ore_end_stone = new BlockVoidOre(Material.rock, "void_ore_end_stone");
        void_ore_obsidian = new BlockVoidOre(Material.rock, "void_ore_obsidian");
        void_block = new BlockVoidBlock(Material.iron, "void_block");
        bedrock_block = new BlockCompactBedrock(Material.rock, "bedrock_compact");
        adamantium_ore = new BlockCustomNonSmeltingOre(0, "adamantium_ore", -1.0f, 1.0E9f, TitanItems.adamantium, 1000000000, 1000000000);
        malgrumCrop = new BlockMalgrumCrop().setBlockName("malgrum").setBlockTextureName("thetitans:malgrum");
        pleasantBladeCrop = new BlockPleasantBladeCrop().setBlockName("pleasant_blade").setBlockTextureName("thetitans:pleasant_blade");
        TitanBlocks.registerBlock(nether_stone_ore);
        TitanBlocks.registerBlock(nether_coal_ore);
        TitanBlocks.registerBlock(nether_gold_ore);
        TitanBlocks.registerBlock(nether_diamond_ore);
        TitanBlocks.registerBlock(copper_ore);
        TitanBlocks.registerBlock(tin_ore);
        TitanBlocks.registerBlock(chromium_ore);
        TitanBlocks.registerBlock(magnesium_ore);
        TitanBlocks.registerBlock(lead_ore);
        TitanBlocks.registerBlock(silver_ore);
        TitanBlocks.registerBlock(platinum_ore);
        TitanBlocks.registerBlock(harcadium_ore);
        TitanBlocks.registerBlock(harcadium_ore_end_stone);
        TitanBlocks.registerBlock(harcadium_ore_obsidian);
        TitanBlocks.registerBlock(harcadium_block);
        TitanBlocks.registerBlock(void_ore);
        TitanBlocks.registerBlock(void_ore_end_stone);
        TitanBlocks.registerBlock(void_ore_obsidian);
        TitanBlocks.registerBlock(void_block);
        TitanBlocks.registerBlock(bedrock_block);
        TitanBlocks.registerBlock(adamantium_ore);
        TitanBlocks.registerBlock(malgrumCrop);
        TitanBlocks.registerBlock(pleasantBladeCrop);
        if (Loader.isModLoaded((String)"OreSpawn")) {
            MyOverlordScorpionPartSpawnBlock = new BlockOreEgg("oreoverlordscorpionpart");
            MyOverlordScorpionSpawnBlock = new BlockOreEgg("oreoverlordscorpion");
            MyMethuselahKrakenPartSpawnBlock = new BlockOreEgg("oreelderkrakenpart");
            MyMethuselahKrakenSpawnBlock = new BlockOreEgg("oreelderkraken");
            TitanBlocks.registerBlock(MyOverlordScorpionPartSpawnBlock);
            TitanBlocks.registerBlock(MyOverlordScorpionSpawnBlock);
            TitanBlocks.registerBlock(MyMethuselahKrakenPartSpawnBlock);
            TitanBlocks.registerBlock(MyMethuselahKrakenSpawnBlock);
        }
    }

    private static void registerBlock(Block block) {
        GameRegistry.registerBlock((Block)block, (String)block.getUnlocalizedName().substring(5));
    }
}

