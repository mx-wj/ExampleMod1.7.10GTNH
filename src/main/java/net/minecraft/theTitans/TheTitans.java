/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.IWorldGenerator
 *  cpw.mods.fml.common.Loader
 *  cpw.mods.fml.common.Mod
 *  cpw.mods.fml.common.Mod$EventHandler
 *  cpw.mods.fml.common.Mod$Instance
 *  cpw.mods.fml.common.Mod$Metadata
 *  cpw.mods.fml.common.ModMetadata
 *  cpw.mods.fml.common.SidedProxy
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.event.FMLServerStartingEvent
 *  cpw.mods.fml.common.registry.GameRegistry
 *  net.minecraft.command.ICommand
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnumEnchantmentType
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.Item
 *  net.minecraft.util.EnumChatFormatting
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraftforge.common.DimensionManager
 *  net.minecraftforge.common.config.Configuration
 *  net.minecraftforge.common.util.EnumHelper
 *  org.apache.logging.log4j.Logger
 */
package net.minecraft.theTitans;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.command.ICommand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.theTitans.CommandClearMinions;
import net.minecraft.theTitans.CommonProxy;
import net.minecraft.theTitans.SpawnEggOreGeneration;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitanStructureGenerator;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.theTitans.TitansOreGeneration;
import net.minecraft.theTitans.ench.EnchantmentDurability;
import net.minecraft.theTitans.ench.EnchantmentFerocity;
import net.minecraft.theTitans.ench.EnchantmentKnockup;
import net.minecraft.theTitans.ench.EnchantmentManiac;
import net.minecraft.theTitans.ench.EnchantmentShurakin;
import net.minecraft.theTitans.ench.EnchantmentTitanSlayer;
import net.minecraft.theTitans.ench.EnchantmentUnstablility;
import net.minecraft.theTitans.world.BiomeGenNowhere;
import net.minecraft.theTitans.world.BiomeGenVoid;
import net.minecraft.theTitans.world.WorldProviderNowhere;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.theTitans.perf.TitansPerf;
import net.minecraft.theTitans.perf.TitansPerfTicker;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import org.apache.logging.log4j.Logger;

@Mod(modid="thetitans", name="The Titans Mod", version="0.495")
public class TheTitans {
    public static final String MODNAME = "The Titans Mod";
    public static final String MODID = "thetitans";
    public static final String VERSION = "0.495";
    public static final String CLIENT = "net.minecraft.theTitans.ClientProxy";
    public static final String SERVER = "net.minecraft.theTitans.ServerProxy";
    public static final ResourceLocation genericTitanWhiteTexture32x64 = new ResourceLocation("thetitans", "textures/entities/32x64_disintigration.png");
    public static final ResourceLocation genericTitanWhiteTexture64x64 = new ResourceLocation("thetitans", "textures/entities/64x64_disintigration.png");
    @SidedProxy(clientSide="net.minecraft.theTitans.ClientProxy", serverSide="net.minecraft.theTitans.CommonProxy")
    public static CommonProxy proxy;
    @Mod.Metadata
    public static ModMetadata meta;
    @Mod.Instance(value="thetitans")
    public static TheTitans modInstance;
    public static final CreativeTabs titansTab;
    public static final BiomeGenVoid voidland;
    public static final BiomeGenNowhere nowhere;
    private Logger logger;
    public static final int VOID_DIMENSION_ID = 200;
    public static final int NOWHERE_DIMENSION_ID = 201;
    public static final Enchantment turretEnchant1;
    public static final Enchantment turretEnchant2;
    public static final Enchantment turretEnchant3;
    public static final Enchantment turretEnchant4;
    public static final Enchantment turretEnchant5;
    public static final Enchantment titanSlaying;
    public static final Enchantment hammer;
    public static int OmegafishMinionSpawnrate;
    public static int SpiderTitanMinionSpawnrate;
    public static int CaveSpiderTitanMinionSpawnrate;
    public static int SlimeTitanMinionSpawnrate;
    public static int MagmaCubeTitanMinionSpawnrate;
    public static int ZombieTitanMinionSpawnrate;
    public static int PigZombieTitanMinionSpawnrate;
    public static int SkeletonTitanMinionSpawnrate;
    public static int CreeperTitanMinionSpawnrate;
    public static int BlazeTitanMinionSpawnrate;
    public static int WitherSkeletonTitanMinionSpawnrate;
    public static int EnderColossusMinionSpawnrate;
    public static int GhastTitanMinionSpawnrate;
    public static int WitherzillaMinionSpawnrate;
    public static int UltimaIronGolemMinionSpawnrate;
    public static int GargoyleKingMinionSpawnrate;
    public static int SnowGolemMinionSpawnrate;
    public static boolean NightmareMode;
    public static boolean TotalDestructionMode;
    public static boolean TitansFFAMode;
    private static final TitansPerfTicker PERF_TICKER = new TitansPerfTicker();
    public static final EnumRarity godly;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        this.logger = e.getModLog();
        proxy.preInit(e);
        this.logger.info("Loading The Titans...");
        this.logger.debug("Pre Initialization started!");
        Configuration config = new Configuration(e.getSuggestedConfigurationFile());
        config.load();
        NightmareMode = config.get("general", "Nightmare Mode", false).getBoolean(NightmareMode);
        TotalDestructionMode = config.get("general", "Enable Gods of Destruction Mode", false).getBoolean(TotalDestructionMode);
        OmegafishMinionSpawnrate = config.get("general", "OmegafishMinionSpawnrate", 10).getInt();
        SpiderTitanMinionSpawnrate = config.get("general", "SpiderTitanMinionSpawnrate", 10).getInt();
        CaveSpiderTitanMinionSpawnrate = config.get("general", "CaveSpiderTitanMinionSpawnrate", 10).getInt();
        SlimeTitanMinionSpawnrate = config.get("general", "SlimeTitanMinionSpawnrate", 30).getInt();
        MagmaCubeTitanMinionSpawnrate = config.get("general", "MagmaCubeTitanMinionSpawnrate", 30).getInt();
        ZombieTitanMinionSpawnrate = config.get("general", "ZombieTitanMinionSpawnrate", 5).getInt();
        PigZombieTitanMinionSpawnrate = config.get("general", "PigZombieTitanMinionSpawnrate", 10).getInt();
        SkeletonTitanMinionSpawnrate = config.get("general", "SkeletonTitanMinionSpawnrate", 10).getInt();
        CreeperTitanMinionSpawnrate = config.get("general", "CreeperTitanMinionSpawnrate", 10).getInt();
        BlazeTitanMinionSpawnrate = config.get("general", "BlazeTitanMinionSpawnrate", 15).getInt();
        WitherSkeletonTitanMinionSpawnrate = config.get("general", "WitherSkeletonTitanMinionSpawnrate", 10).getInt();
        GhastTitanMinionSpawnrate = config.get("general", "GhastTitanMinionSpawnrate", 15).getInt();
        EnderColossusMinionSpawnrate = config.get("general", "EnderColossusMinionSpawnrate", 5).getInt();
        WitherzillaMinionSpawnrate = config.get("general", "WitherzillaMinionSpawnrate", 5).getInt();
        UltimaIronGolemMinionSpawnrate = config.get("general", "UltimaIronGolemMinionSpawnrate", 30).getInt();
        GargoyleKingMinionSpawnrate = config.get("general", "GargoyleKingMinionSpawnrate", 30).getInt();
        SnowGolemMinionSpawnrate = config.get("general", "SnowGolemMinionSpawnrate", 30).getInt();
        TitansPerf.ENABLED = config.get("perf", "Enable Titans Perf", false).getBoolean(false);
        TitansPerf.LOG_SLOW_CALLS = config.get("perf", "Log Slow Calls", true).getBoolean(true);
        TitansPerf.DUMP_INTERVAL_TICKS = config.get("perf", "Dump Interval Ticks", 200).getInt(200);
        TitansPerf.SLOW_CALL_NS = (long)(config.get("perf", "Slow Call Warn Ms", 5.0).getDouble(5.0) * 1000000.0);
        config.save();
        this.logger.debug("Finished pre-init for The Titans!");
        DimensionManager.registerProviderType((int)200, WorldProviderVoid.class, (boolean)false);
        DimensionManager.registerDimension((int)200, (int)200);
        DimensionManager.registerProviderType((int)201, WorldProviderNowhere.class, (boolean)false);
        DimensionManager.registerDimension((int)201, (int)201);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand((ICommand)new CommandClearMinions());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        if (TitansPerf.ENABLED) {
            FMLCommonHandler.instance().bus().register((Object)PERF_TICKER);
            this.logger.info("TitansPerf enabled: dumpInterval={} ticks slowWarnMs={}", new Object[]{TitansPerf.DUMP_INTERVAL_TICKS, (double)TitansPerf.SLOW_CALL_NS / 1000000.0});
        }
        proxy.registerRenders();
        this.logger.debug("Initialization started!");
        TitansAchievments.addAchievments();
        Enchantment.addToBookList((Enchantment)turretEnchant1);
        Enchantment.addToBookList((Enchantment)turretEnchant2);
        Enchantment.addToBookList((Enchantment)turretEnchant3);
        Enchantment.addToBookList((Enchantment)turretEnchant4);
        Enchantment.addToBookList((Enchantment)turretEnchant5);
        Enchantment.addToBookList((Enchantment)titanSlaying);
        Enchantment.addToBookList((Enchantment)hammer);
        BiomeGenBase.explorationBiomesList.remove((Object)voidland);
        BiomeGenBase.explorationBiomesList.remove((Object)nowhere);
        GameRegistry.registerWorldGenerator((IWorldGenerator)new TitansOreGeneration(), (int)100);
        GameRegistry.registerWorldGenerator((IWorldGenerator)new TitanStructureGenerator(), (int)10000);
        if (Loader.isModLoaded((String)"OreSpawn")) {
            GameRegistry.registerWorldGenerator((IWorldGenerator)new SpawnEggOreGeneration(), (int)100);
        }
        this.logger.debug("Finished init for The Titans!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
        this.logger.debug("Post Initialization started!");
        proxy.registerRenderThings();
        proxy.registerItemRenderers();
        this.logger.debug("Finished post-init for The Titans!");
        this.logger.info("Finished The Titans!");
    }

    static {
        titansTab = new CreativeTabs(MODID){

            public Item getTabIconItem() {
                return TitanItems.growthSerum;
            }
        };
        voidland = (BiomeGenVoid)new BiomeGenVoid(169).setColor(986895).setBiomeName("Void Island").setDisableRain().setTemperatureRainfall(2.0f, 0.0f);
        nowhere = (BiomeGenNowhere)new BiomeGenNowhere(170).setColor(3278130).setBiomeName("The Nowhere").setDisableRain().setTemperatureRainfall(0.0f, 0.0f);
        turretEnchant1 = new EnchantmentDurability(249, new ResourceLocation("healing"), 10, EnumEnchantmentType.weapon);
        turretEnchant2 = new EnchantmentFerocity(250, new ResourceLocation("damage"), 10, EnumEnchantmentType.weapon);
        turretEnchant3 = new EnchantmentManiac(251, new ResourceLocation("shootingSpeed"), 5, EnumEnchantmentType.weapon);
        turretEnchant4 = new EnchantmentUnstablility(252, new ResourceLocation("explosivePower"), 2, EnumEnchantmentType.weapon);
        turretEnchant5 = new EnchantmentShurakin(253, new ResourceLocation("skullSpeed"), 1, EnumEnchantmentType.weapon);
        titanSlaying = new EnchantmentTitanSlayer(254, new ResourceLocation("titankiller"), 10);
        hammer = new EnchantmentKnockup(255, new ResourceLocation("hammer"), 5);
        TitansFFAMode = false;
        godly = EnumHelper.addRarity((String)"GODLY", (EnumChatFormatting)EnumChatFormatting.DARK_PURPLE, (String)"Godly");
    }
}

