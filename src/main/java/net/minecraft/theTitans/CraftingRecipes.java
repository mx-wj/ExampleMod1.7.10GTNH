/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.Loader
 *  cpw.mods.fml.common.registry.GameRegistry
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 */
package net.minecraft.theTitans;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.theTitans.TitanItems;

public final class CraftingRecipes {
    public static void initCrafting() {
        GameRegistry.addSmelting((Block)TitanBlocks.copper_ore, (ItemStack)new ItemStack(TitanItems.copperIngot), (float)2.0f);
        GameRegistry.addSmelting((Block)TitanBlocks.tin_ore, (ItemStack)new ItemStack(TitanItems.tinIngot), (float)2.0f);
        GameRegistry.addSmelting((Block)TitanBlocks.chromium_ore, (ItemStack)new ItemStack(TitanItems.chromiumIngot), (float)3.0f);
        GameRegistry.addSmelting((Block)TitanBlocks.magnesium_ore, (ItemStack)new ItemStack(TitanItems.magnesiumIngot), (float)3.0f);
        GameRegistry.addSmelting((Block)TitanBlocks.lead_ore, (ItemStack)new ItemStack(TitanItems.leadIngot), (float)3.0f);
        GameRegistry.addSmelting((Block)TitanBlocks.silver_ore, (ItemStack)new ItemStack(TitanItems.silverIngot), (float)5.0f);
        GameRegistry.addSmelting((Block)TitanBlocks.platinum_ore, (ItemStack)new ItemStack(TitanItems.platinumIngot), (float)10.0f);
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.pleasantBladeBrew, 1), (Object[])new Object[]{TitanItems.pleasantBladeLeaf, Items.glass_bottle, Items.carrot, Items.fermented_spider_eye});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.steelIngot, 1), (Object[])new Object[]{TitanItems.chromiumIngot, TitanItems.magnesiumIngot, Items.iron_ingot, Items.coal});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.bronzeIngot, 1), (Object[])new Object[]{TitanItems.copperIngot, TitanItems.tinIngot});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.diamondString, 4), (Object[])new Object[]{Items.diamond, Items.diamond});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.harcadiumWaflet, 9), (Object[])new Object[]{TitanItems.harcadiumWafer});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.harcadiumWafer, 9), (Object[])new Object[]{TitanItems.harcadiumNugget});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.harcadiumNugget, 9), (Object[])new Object[]{TitanItems.harcadium});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.harcadium, 9), (Object[])new Object[]{TitanBlocks.harcadium_block});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.voidItem, 9), (Object[])new Object[]{TitanBlocks.void_block});
        GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(Blocks.bedrock, 9), (Object[])new Object[]{TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(Items.ender_pearl, 64), (Object[])new Object[]{"HHH", "H H", "HHH", Character.valueOf('H'), TitanItems.harcadiumWaflet});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumWafer), (Object[])new Object[]{"HHH", "HHH", "HHH", Character.valueOf('H'), TitanItems.harcadiumWaflet});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumNugget), (Object[])new Object[]{"HHH", "HHH", "HHH", Character.valueOf('H'), TitanItems.harcadiumWafer});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadium), (Object[])new Object[]{"HHH", "HHH", "HHH", Character.valueOf('H'), TitanItems.harcadiumNugget});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goldenCookie, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.gold_ingot, Character.valueOf('P'), Items.cookie});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goldenCookie, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.gold_block, Character.valueOf('P'), Items.cookie});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goldenBread, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.gold_ingot, Character.valueOf('P'), Items.bread});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goldenBread, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.gold_block, Character.valueOf('P'), Items.bread});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goldenPotatoe, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.gold_ingot, Character.valueOf('P'), Items.baked_potato});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goldenPotatoe, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.gold_block, Character.valueOf('P'), Items.baked_potato});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goldenMelon, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.gold_ingot, Character.valueOf('P'), Items.melon});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goldenMelon, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.gold_block, Character.valueOf('P'), Items.melon});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goldenPumpkinPie, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.gold_ingot, Character.valueOf('P'), Items.pumpkin_pie});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goldenPumpkinPie, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.gold_block, Character.valueOf('P'), Items.pumpkin_pie});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondApple, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.diamond, Character.valueOf('P'), Items.apple});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondApple, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.diamond_block, Character.valueOf('P'), Items.apple});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondCookie, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.diamond, Character.valueOf('P'), Items.cookie});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondCookie, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.diamond_block, Character.valueOf('P'), Items.cookie});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondBread, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.diamond, Character.valueOf('P'), Items.bread});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondBread, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.diamond_block, Character.valueOf('P'), Items.bread});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondPotatoe, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.diamond, Character.valueOf('P'), Items.baked_potato});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondPotatoe, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.diamond_block, Character.valueOf('P'), Items.baked_potato});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondMelon, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.diamond, Character.valueOf('P'), Items.melon});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondMelon, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.diamond_block, Character.valueOf('P'), Items.melon});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondPumpkinPie, 1, 0), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Items.diamond, Character.valueOf('P'), Items.pumpkin_pie});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.diamondPumpkinPie, 1, 1), (Object[])new Object[]{"GGG", "GPG", "GGG", Character.valueOf('G'), Blocks.diamond_block, Character.valueOf('P'), Items.pumpkin_pie});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanBlocks.harcadium_block), (Object[])new Object[]{"HHH", "HHH", "HHH", Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanBlocks.void_block), (Object[])new Object[]{"HHH", "HHH", "HHH", Character.valueOf('H'), TitanItems.voidItem});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanBlocks.bedrock_block), (Object[])new Object[]{"HHH", "HHH", "HHH", Character.valueOf('H'), Blocks.bedrock});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.copperAxe), (Object[])new Object[]{"HH ", "HD ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.copperIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.copperPickaxe), (Object[])new Object[]{"HHH", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.copperIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.copperSpade), (Object[])new Object[]{" H ", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.copperIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.copperHoe), (Object[])new Object[]{"HH ", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.copperIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.copperSword), (Object[])new Object[]{" H ", " H ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.copperIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.copperHelmet), (Object[])new Object[]{"HHH", "H H", Character.valueOf('H'), TitanItems.copperIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.copperChestplate), (Object[])new Object[]{"H H", "HHH", "HHH", Character.valueOf('H'), TitanItems.copperIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.copperLeggings), (Object[])new Object[]{"HHH", "H H", "H H", Character.valueOf('H'), TitanItems.copperIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.copperBoots), (Object[])new Object[]{"H H", "H H", Character.valueOf('H'), TitanItems.copperIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.tinAxe), (Object[])new Object[]{"HH ", "HD ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.tinIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.tinPickaxe), (Object[])new Object[]{"HHH", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.tinIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.tinSpade), (Object[])new Object[]{" H ", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.tinIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.tinHoe), (Object[])new Object[]{"HH ", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.tinIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.tinSword), (Object[])new Object[]{" H ", " H ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.tinIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.tinHelmet), (Object[])new Object[]{"HHH", "H H", Character.valueOf('H'), TitanItems.tinIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.tinChestplate), (Object[])new Object[]{"H H", "HHH", "HHH", Character.valueOf('H'), TitanItems.tinIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.tinLeggings), (Object[])new Object[]{"HHH", "H H", "H H", Character.valueOf('H'), TitanItems.tinIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.tinBoots), (Object[])new Object[]{"H H", "H H", Character.valueOf('H'), TitanItems.tinIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.bronzeAxe), (Object[])new Object[]{"HH ", "HD ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.bronzePickaxe), (Object[])new Object[]{"HHH", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.bronzeSpade), (Object[])new Object[]{" H ", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.bronzeHoe), (Object[])new Object[]{"HH ", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.bronzeSword), (Object[])new Object[]{" H ", " H ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.bronzeHelmet), (Object[])new Object[]{"HHH", "H H", Character.valueOf('H'), TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.bronzeChestplate), (Object[])new Object[]{"H H", "HHH", "HHH", Character.valueOf('H'), TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.bronzeLeggings), (Object[])new Object[]{"HHH", "H H", "H H", Character.valueOf('H'), TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.bronzeBoots), (Object[])new Object[]{"H H", "H H", Character.valueOf('H'), TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.steelAxe), (Object[])new Object[]{"HH ", "HD ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.steelIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.steelPickaxe), (Object[])new Object[]{"HHH", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.steelIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.steelSpade), (Object[])new Object[]{" H ", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.steelIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.steelHoe), (Object[])new Object[]{"HH ", " D ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.steelIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.steelSword), (Object[])new Object[]{" H ", " H ", " D ", Character.valueOf('D'), Items.stick, Character.valueOf('H'), TitanItems.steelIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.steelHelmet), (Object[])new Object[]{"HHH", "H H", Character.valueOf('H'), TitanItems.steelIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.steelChestplate), (Object[])new Object[]{"H H", "HHH", "HHH", Character.valueOf('H'), TitanItems.steelIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.steelLeggings), (Object[])new Object[]{"HHH", "H H", "H H", Character.valueOf('H'), TitanItems.steelIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.steelBoots), (Object[])new Object[]{"H H", "H H", Character.valueOf('H'), TitanItems.steelIngot});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumAxe), (Object[])new Object[]{"HH ", "HD ", " D ", Character.valueOf('D'), Items.diamond, Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumPickaxe), (Object[])new Object[]{"HHH", " D ", " D ", Character.valueOf('D'), Items.diamond, Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumSpade), (Object[])new Object[]{" H ", " D ", " D ", Character.valueOf('D'), Items.diamond, Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumHoe), (Object[])new Object[]{"HH ", " D ", " D ", Character.valueOf('D'), Items.diamond, Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumSword), (Object[])new Object[]{" H ", " H ", " D ", Character.valueOf('D'), Items.diamond, Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumHelmet), (Object[])new Object[]{"HHH", "H H", Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumChestplate), (Object[])new Object[]{"H H", "HHH", "HHH", Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumLeggings), (Object[])new Object[]{"HHH", "H H", "H H", Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumBoots), (Object[])new Object[]{"H H", "H H", Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.growthSerum, 2), (Object[])new Object[]{"RNR", "FBF", "GRG", Character.valueOf('R'), Items.rotten_flesh, Character.valueOf('N'), Items.nether_star, Character.valueOf('F'), Items.fire_charge, Character.valueOf('B'), Items.glass_bottle, Character.valueOf('G'), Items.ghast_tear});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.teleporter), (Object[])new Object[]{"WWW", "SSS", " S ", Character.valueOf('W'), new ItemStack(Items.skull, 1, 1), Character.valueOf('S'), Blocks.soul_sand});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.teleporter2), (Object[])new Object[]{"GOG", "ONO", "GOG", Character.valueOf('G'), Blocks.gold_block, Character.valueOf('O'), Blocks.obsidian, Character.valueOf('N'), Items.nether_star});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goodTurret), (Object[])new Object[]{"S", "O", "B", Character.valueOf('S'), new ItemStack(Items.skull, 1, 1), Character.valueOf('O'), Blocks.obsidian, Character.valueOf('B'), Blocks.bedrock});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goodTurret2), (Object[])new Object[]{"SOS", " B ", Character.valueOf('S'), new ItemStack(Items.skull, 1, 1), Character.valueOf('O'), Blocks.obsidian, Character.valueOf('B'), Blocks.bedrock});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.goodTurret3), (Object[])new Object[]{" A ", "NBN", " G ", Character.valueOf('A'), TitanItems.goodTurret, Character.valueOf('G'), TitanItems.goodTurret2, Character.valueOf('B'), Blocks.beacon, Character.valueOf('N'), Items.nether_star});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.chaff, 8), (Object[])new Object[]{"PWP", "WPW", "PWP", Character.valueOf('P'), Items.paper, Character.valueOf('W'), Items.wheat});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumBow), (Object[])new Object[]{" HS", "H S", " HS", Character.valueOf('S'), TitanItems.diamondString, Character.valueOf('H'), TitanItems.harcadium});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.harcadiumArrow, 4), (Object[])new Object[]{"H", "D", "F", Character.valueOf('H'), TitanItems.harcadium, Character.valueOf('D'), Items.diamond, Character.valueOf('F'), Items.feather});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.adminiumAxe), (Object[])new Object[]{"HH ", "HD ", " D ", Character.valueOf('D'), Blocks.bedrock, Character.valueOf('H'), TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.adminiumPickaxe), (Object[])new Object[]{"HHH", " D ", " D ", Character.valueOf('D'), Blocks.bedrock, Character.valueOf('H'), TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.adminiumSpade), (Object[])new Object[]{" H ", " D ", " D ", Character.valueOf('D'), Blocks.bedrock, Character.valueOf('H'), TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.adminiumHoe), (Object[])new Object[]{"HH ", " D ", " D ", Character.valueOf('D'), Blocks.bedrock, Character.valueOf('H'), TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.adminiumSword), (Object[])new Object[]{" H ", " H ", " D ", Character.valueOf('D'), Blocks.bedrock, Character.valueOf('H'), TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.adminiumHelmet), (Object[])new Object[]{"BBB", "B B", Character.valueOf('B'), new ItemStack(TitanBlocks.bedrock_block)});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.adminiumChestplate), (Object[])new Object[]{"H H", "BVB", "BBB", Character.valueOf('B'), new ItemStack(TitanBlocks.bedrock_block), Character.valueOf('V'), TitanBlocks.void_block, Character.valueOf('H'), TitanBlocks.harcadium_block});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.adminiumLeggings), (Object[])new Object[]{"BHB", "B B", "B B", Character.valueOf('B'), new ItemStack(TitanBlocks.bedrock_block), Character.valueOf('H'), TitanBlocks.harcadium_block});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.adminiumBoots), (Object[])new Object[]{"B B", "B B", Character.valueOf('B'), new ItemStack(TitanBlocks.bedrock_block)});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.voidAxe), (Object[])new Object[]{"HH ", "HD ", " D ", Character.valueOf('D'), TitanItems.harcadium, Character.valueOf('H'), TitanItems.voidItem});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.voidPickaxe), (Object[])new Object[]{"HHH", " D ", " D ", Character.valueOf('D'), TitanItems.harcadium, Character.valueOf('H'), TitanItems.voidItem});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.voidSpade), (Object[])new Object[]{" H ", " D ", " D ", Character.valueOf('D'), TitanItems.harcadium, Character.valueOf('H'), TitanItems.voidItem});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.voidHoe), (Object[])new Object[]{"HH ", " D ", " D ", Character.valueOf('D'), TitanItems.harcadium, Character.valueOf('H'), TitanItems.voidItem});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.voidSword), (Object[])new Object[]{" H ", " H ", " D ", Character.valueOf('D'), TitanItems.harcadium, Character.valueOf('H'), TitanItems.voidItem});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.voidHelmet), (Object[])new Object[]{"HHH", "H H", Character.valueOf('H'), TitanItems.voidItem});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.voidChestplate), (Object[])new Object[]{"H H", "HHH", "HHH", Character.valueOf('H'), TitanItems.voidItem});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.voidLeggings), (Object[])new Object[]{"HHH", "H H", "H H", Character.valueOf('H'), TitanItems.voidItem});
        GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanItems.voidBoots), (Object[])new Object[]{"H H", "H H", Character.valueOf('H'), TitanItems.voidItem});
        if (Loader.isModLoaded((String)"OreSpawn")) {
            GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.OverlordScorpionEgg), (Object[])new Object[]{TitanBlocks.MyOverlordScorpionSpawnBlock, Items.water_bucket});
            GameRegistry.addShapelessRecipe((ItemStack)new ItemStack(TitanItems.MethuselahKrakenEgg), (Object[])new Object[]{TitanBlocks.MyMethuselahKrakenSpawnBlock, Items.water_bucket});
            GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanBlocks.MyMethuselahKrakenSpawnBlock), (Object[])new Object[]{"HHH", "HHH", "HHH", Character.valueOf('H'), TitanBlocks.MyMethuselahKrakenPartSpawnBlock});
            GameRegistry.addShapedRecipe((ItemStack)new ItemStack(TitanBlocks.MyOverlordScorpionSpawnBlock), (Object[])new Object[]{"HHH", "HHH", "HHH", Character.valueOf('H'), TitanBlocks.MyOverlordScorpionPartSpawnBlock});
        }
    }
}

