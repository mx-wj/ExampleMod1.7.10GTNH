/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.WeightedRandomChestContent
 *  net.minecraftforge.common.ChestGenHooks
 */
package net.minecraft.theTitans;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.CraftingRecipes;
import net.minecraft.theTitans.RenderTheTitans;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class CommonProxy {
    public void registerRenders() {
    }

    public void preInit(FMLPreInitializationEvent e) {
        RenderTheTitans.registerEntity();
        TitanItems.init();
        TitanBlocks.init();
        this.registerItemRenderers();
        this.registerRenderThings();
        CraftingRecipes.initCrafting();
        TitanItems.enumToolMaterialCopper.setRepairItem(new ItemStack(TitanItems.copperIngot));
        TitanItems.enumArmorMaterialCopper.customCraftingMaterial = TitanItems.copperIngot;
        TitanItems.enumToolMaterialTin.setRepairItem(new ItemStack(TitanItems.tinIngot));
        TitanItems.enumArmorMaterialTin.customCraftingMaterial = TitanItems.tinIngot;
        TitanItems.enumToolMaterialBronze.setRepairItem(new ItemStack(TitanItems.bronzeIngot));
        TitanItems.enumArmorMaterialBronze.customCraftingMaterial = TitanItems.bronzeIngot;
        TitanItems.enumToolMaterialSteel.setRepairItem(new ItemStack(TitanItems.steelIngot));
        TitanItems.enumArmorMaterialSteel.customCraftingMaterial = TitanItems.steelIngot;
        TitanItems.enumToolMaterialHarcadium.setRepairItem(new ItemStack(TitanItems.harcadium));
        TitanItems.enumArmorMaterialHarcadium.customCraftingMaterial = TitanItems.harcadium;
        TitanItems.enumToolMaterialAbsence.setRepairItem(new ItemStack(TitanItems.voidItem));
        TitanItems.enumArmorMaterialAbsence.customCraftingMaterial = TitanItems.voidItem;
        ChestGenHooks.getInfo((String)"mineshaftCorridor").addItem(new WeightedRandomChestContent(TitanItems.pleasantBladeSeed, 0, 2, 4, 10));
        ChestGenHooks.getInfo((String)"mineshaftCorridor").addItem(new WeightedRandomChestContent(TitanItems.malgrumSeeds, 0, 1, 1, 1));
        ChestGenHooks.getInfo((String)"strongholdCrossing").addItem(new WeightedRandomChestContent(TitanItems.pleasantBladeSeed, 0, 1, 4, 10));
        ChestGenHooks.getInfo((String)"strongholdCorridor").addItem(new WeightedRandomChestContent(TitanItems.pleasantBladeSeed, 0, 1, 4, 10));
        ChestGenHooks.getInfo((String)"strongholdCrossing").addItem(new WeightedRandomChestContent(TitanItems.malgrumSeeds, 0, 1, 1, 1));
        ChestGenHooks.getInfo((String)"strongholdCorridor").addItem(new WeightedRandomChestContent(TitanItems.malgrumSeeds, 0, 1, 1, 1));
        ChestGenHooks.getInfo((String)"dungeonChest").addItem(new WeightedRandomChestContent(TitanItems.pleasantBladeSeed, 0, 1, 4, 10));
        ChestGenHooks.getInfo((String)"pyramidDesertyChest").addItem(new WeightedRandomChestContent(TitanItems.pleasantBladeSeed, 0, 1, 4, 10));
        ChestGenHooks.getInfo((String)"villageBlacksmith").addItem(new WeightedRandomChestContent(TitanItems.pleasantBladeSeed, 0, 2, 4, 10));
        ChestGenHooks.getInfo((String)"villageBlacksmith").addItem(new WeightedRandomChestContent(TitanItems.pleasantBladeLeaf, 0, 2, 4, 10));
        ChestGenHooks.getInfo((String)"villageBlacksmith").addItem(new WeightedRandomChestContent(TitanItems.pleasantBladeFlower, 0, 1, 1, 2));
        ChestGenHooks.getInfo((String)"villageBlacksmith").addItem(new WeightedRandomChestContent(TitanItems.pleasantBladeBrew, 0, 1, 1, 2));
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    public void registerItemRenderers() {
    }

    public void registerRenderThings() {
    }
}

