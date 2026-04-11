/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.Loader
 *  cpw.mods.fml.common.registry.EntityRegistry
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityList$EntityEggInfo
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.entity.boss.EntityWither
 *  net.minecraft.entity.monster.EntityBlaze
 *  net.minecraft.entity.monster.EntityCaveSpider
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntitySilverfish
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.world.biome.BiomeGenBase
 */
package net.minecraft.theTitans;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.orespawnaddon.EntityMethuselahKraken;
import net.minecraft.entity.orespawnaddon.EntityOverlordScorpion;
import net.minecraft.entity.titan.EntityBlazeTitan;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntityChaff;
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityGrowthSerum;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityLavaSpit;
import net.minecraft.entity.titan.EntityLightningBall;
import net.minecraft.entity.titan.EntityMagmaCubeTitan;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntityProtoBall;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySkeletonTitanGiantArrow;
import net.minecraft.entity.titan.EntitySlimeTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWebShot;
import net.minecraft.entity.titan.EntityWitherTurret;
import net.minecraft.entity.titan.EntityWitherTurretGround;
import net.minecraft.entity.titan.EntityWitherTurretMortar;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EntityWitherzillaMinion;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titanminion.EntityBlazeMinion;
import net.minecraft.entity.titanminion.EntityCaveSpiderMinion;
import net.minecraft.entity.titanminion.EntityCreeperMinion;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
import net.minecraft.entity.titanminion.EntityGhastGuard;
import net.minecraft.entity.titanminion.EntityGhastMinion;
import net.minecraft.entity.titanminion.EntityGiantZombieBetter;
import net.minecraft.entity.titanminion.EntityPigZombieMinion;
import net.minecraft.entity.titanminion.EntitySilverfishMinion;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.entity.titanminion.EntitySpiderMinion;
import net.minecraft.entity.titanminion.EntityWitherMinion;
import net.minecraft.entity.titanminion.EntityZombieMinion;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.biome.BiomeGenBase;

public class RenderTheTitans {
    public static void TheTitans() {
    }

    public static void registerEntity() {
        RenderTheTitans.createEntityWithEgg(EntitySilverfishMinion.class, "SilverfishMinion", 0x6E6E6E, 0x303030);
        RenderTheTitans.createEntityWithEgg(EntityCaveSpiderMinion.class, "CaveSpiderMinion", 803406, 11013646);
        RenderTheTitans.createEntityWithEgg(EntitySpiderMinion.class, "SpiderMinion", 3419431, 11013646);
        RenderTheTitans.createEntityWithEgg(EntityZombieMinion.class, "ZombieMinion", 44975, 7969893);
        RenderTheTitans.createEntityWithEgg(EntityGiantZombieBetter.class, "GiantMinion", 44975, 5870909);
        RenderTheTitans.createEntityWithEgg(EntitySkeletonMinion.class, "SkeletonMinion", 0xC1C1C1, 0x494949);
        RenderTheTitans.createEntityWithEgg(EntityWitherMinion.class, "WitherMinion", 0x141414, 0x1C1C1C);
        RenderTheTitans.createEntityWithEgg(EntityCreeperMinion.class, "CreeperMinion", 894731, 0);
        RenderTheTitans.createEntityWithEgg(EntityPigZombieMinion.class, "PigZombieMinion", 15373203, 5009705);
        RenderTheTitans.createEntityWithEgg(EntityGhastGuard.class, "GhastGuard", 0xF9F9F9, 0xBCBCBC);
        RenderTheTitans.createEntityWithEgg(EntityBlazeMinion.class, "BlazeMinion", 16167425, 16775294);
        RenderTheTitans.createEntityWithEgg(EntityGhastMinion.class, "GhastMinion", 0xF9F9F9, 0xBCBCBC);
        RenderTheTitans.createEntityWithEgg(EntityEndermanMinion.class, "EndermanMinion", 0x161616, 0);
        RenderTheTitans.createEntityWithEgg(EntityDragonMinion.class, "EnderDragonMinion", 0x161616, 13369594);
        RenderTheTitans.createEntityWithEgg(EntityEnderColossusCrystal.class, "EnderColossusCrystal", 0xEEEEEE, 13369594);
        RenderTheTitans.createEntityWithEgg(EntityWitherTurret.class, "WitherTurret", 0x141414, 0x1C1C1C);
        RenderTheTitans.createEntityWithEgg(EntityWitherTurretGround.class, "WitherTurretGround", 0x141414, 0x1C1C1C);
        RenderTheTitans.createEntityWithEgg(EntityWitherTurretMortar.class, "WitherTurretMortar", 0x141414, 0x1C1C1C);
        RenderTheTitans.createEntityWithEgg(EntityWitherzillaMinion.class, "WitherBossMinion", 0x141414, 0x1C1C1C);
        RenderTheTitans.createEgg(53, 44975, 5870909);
        RenderTheTitans.createEgg(63, 0x161616, 13369594);
        RenderTheTitans.createEgg(64, 0x141414, 0x1C1C1C);
        if (Loader.isModLoaded((String)"OreSpawn")) {
            RenderTheTitans.createEntity(EntityOverlordScorpion.class, "OverlordScorpion");
            RenderTheTitans.createEntity(EntityMethuselahKraken.class, "MethuselahKraken");
        }
        RenderTheTitans.createProjectile(EntityGrowthSerum.class, "GrowthSerum");
        RenderTheTitans.createEntity(EntityChaff.class, "Chaff");
        RenderTheTitans.createProjectile(EntityTitanFireball.class, "TitanFireball");
        RenderTheTitans.createProjectile(EntityGargoyleTitanFireball.class, "GargoyleTitanFireball");
        RenderTheTitans.createProjectile(EntityLavaSpit.class, "LavaSpit");
        RenderTheTitans.createEntity(EntityGammaLightning.class, "GammaLightning");
        RenderTheTitans.createEntity(EntityTitanPart.class, "TitanPart");
        RenderTheTitans.createProjectile(EntityWebShot.class, "WebShot");
        RenderTheTitans.createProjectile(EntityXPBomb.class, "XPBomb");
        RenderTheTitans.createProjectile(EntityLightningBall.class, "LightningBall");
        RenderTheTitans.createProjectile(EntityProtoBall.class, "ProtoBall");
        RenderTheTitans.createEntity(EntityTitanSpirit.class, "TitanSpirit");
        RenderTheTitans.createProjectile(EntityHarcadiumArrow.class, "ArrowHarcadium");
        RenderTheTitans.createProjectile(EntitySkeletonTitanGiantArrow.class, "ArrowGiant");
        RenderTheTitans.createTitan(EntitySnowGolemTitan.class, "SnowManTitan");
        RenderTheTitans.createTitan(EntitySlimeTitan.class, "SlimeTitan");
        RenderTheTitans.createTitan(EntityMagmaCubeTitan.class, "LavaSlimeTitan");
        RenderTheTitans.createTitan(EntitySilverfishTitan.class, "SilverfishTitan");
        RenderTheTitans.createTitan(EntityCaveSpiderTitan.class, "CaveSpiderTitan");
        RenderTheTitans.createTitan(EntitySpiderTitan.class, "SpiderTitan");
        RenderTheTitans.createTitan(EntitySkeletonTitan.class, "SkeletonTitan");
        RenderTheTitans.createTitan(EntityZombieTitan.class, "ZombieTitan");
        RenderTheTitans.createTitan(EntityCreeperTitan.class, "CreeperTitan");
        RenderTheTitans.createTitan(EntityPigZombieTitan.class, "PigZombieTitan");
        RenderTheTitans.createTitan(EntityBlazeTitan.class, "BlazeTitan");
        RenderTheTitans.createTitan(EntityGhastTitan.class, "GhastTitan");
        RenderTheTitans.createTitan(EntityEnderColossus.class, "EndermanTitan");
        RenderTheTitans.createTitan(EntityIronGolemTitan.class, "VillagerGolemTitan");
        RenderTheTitans.createTitan(EntityWitherzilla.class, "WitherBossTitan");
        EntityRegistry.addSpawn(EntityBlaze.class, (int)50, (int)2, (int)2, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])new BiomeGenBase[]{BiomeGenBase.hell});
        EntityRegistry.addSpawn(EntitySkeleton.class, (int)20, (int)1, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])new BiomeGenBase[]{BiomeGenBase.hell});
        EntityRegistry.addSpawn(EntityWither.class, (int)1, (int)1, (int)1, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])new BiomeGenBase[]{BiomeGenBase.hell});
        EntityRegistry.addSpawn(EntityIronGolem.class, (int)1, (int)1, (int)1, (EnumCreatureType)EnumCreatureType.creature, (BiomeGenBase[])new BiomeGenBase[]{BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.savanna});
        EntityRegistry.addSpawn(EntitySilverfish.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])RenderTheTitans.getSpawnBiomes());
        EntityRegistry.addSpawn(EntityCaveSpider.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])RenderTheTitans.getSpawnBiomes());
        EntityRegistry.addSpawn(EntityGiantZombieBetter.class, (int)1, (int)1, (int)1, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])RenderTheTitans.getSpawnBiomes());
        EntityRegistry.addSpawn(EntityZombieMinion.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])RenderTheTitans.getSpawnBiomes());
        EntityRegistry.addSpawn(EntitySpiderMinion.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])RenderTheTitans.getSpawnBiomes());
        EntityRegistry.addSpawn(EntitySkeletonMinion.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])RenderTheTitans.getSpawnBiomePlusHell());
        EntityRegistry.addSpawn(EntityCreeperMinion.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])RenderTheTitans.getSpawnBiomes());
        EntityRegistry.addSpawn(EntitySilverfishMinion.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])RenderTheTitans.getSpawnBiomes());
        EntityRegistry.addSpawn(EntityCaveSpiderMinion.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])RenderTheTitans.getSpawnBiomes());
        EntityRegistry.addSpawn(EntityEndermanMinion.class, (int)10, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])RenderTheTitans.getSpawnBiomesPlusEnd());
        EntityRegistry.addSpawn(EntityBlazeMinion.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])new BiomeGenBase[]{BiomeGenBase.hell});
        EntityRegistry.addSpawn(EntityPigZombieMinion.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])new BiomeGenBase[]{BiomeGenBase.hell});
        EntityRegistry.addSpawn(EntityGhastMinion.class, (int)100, (int)4, (int)4, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])new BiomeGenBase[]{BiomeGenBase.hell});
        EntityRegistry.addSpawn(EntityGhastGuard.class, (int)100, (int)1, (int)1, (EnumCreatureType)EnumCreatureType.monster, (BiomeGenBase[])new BiomeGenBase[]{BiomeGenBase.hell});
    }

    public static void createEntityWithEgg(Class entityClass, String entityName, int solidColor, int spotColor) {
        int randomId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID((Class)entityClass, (String)entityName, (int)randomId);
        EntityRegistry.registerModEntity((Class)entityClass, (String)entityName, (int)randomId, (Object)TheTitans.modInstance, (int)128, (int)1, (boolean)false);
        RenderTheTitans.createEgg(randomId, solidColor, spotColor);
    }

    public static void createEntity(Class entityClass, String entityName) {
        int randomId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID((Class)entityClass, (String)entityName, (int)randomId);
        EntityRegistry.registerModEntity((Class)entityClass, (String)entityName, (int)randomId, (Object)TheTitans.modInstance, (int)128, (int)1, (boolean)false);
    }

    public static void createProjectile(Class entityClass, String entityName) {
        int randomId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID((Class)entityClass, (String)entityName, (int)randomId);
        EntityRegistry.registerModEntity((Class)entityClass, (String)entityName, (int)randomId, (Object)TheTitans.modInstance, (int)256, (int)1, (boolean)true);
    }

    public static void createTitan(Class entityClass, String entityName) {
        int randomId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID((Class)entityClass, (String)entityName, (int)randomId);
        EntityRegistry.registerModEntity((Class)entityClass, (String)entityName, (int)randomId, (Object)TheTitans.modInstance, (int)1024, (int)1, (boolean)true);
    }

    private static void createEgg(int randomId, int solidColor, int spotColor) {
        EntityList.entityEggs.put(randomId, new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
    }

    public static BiomeGenBase[] getSpawnBiomes() {
        return new BiomeGenBase[]{BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.forestHills, BiomeGenBase.taigaHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge, BiomeGenBase.deepOcean, BiomeGenBase.stoneBeach, BiomeGenBase.coldBeach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.roofedForest, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.extremeHillsPlus, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mesaPlateau};
    }

    public static BiomeGenBase[] getSpawnBiomePlusHell() {
        return new BiomeGenBase[]{BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.forestHills, BiomeGenBase.taigaHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge, BiomeGenBase.deepOcean, BiomeGenBase.stoneBeach, BiomeGenBase.coldBeach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.roofedForest, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.extremeHillsPlus, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mesaPlateau, BiomeGenBase.hell};
    }

    public static BiomeGenBase[] getSpawnBiomesPlusEnd() {
        return new BiomeGenBase[]{BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.forestHills, BiomeGenBase.taigaHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge, BiomeGenBase.deepOcean, BiomeGenBase.stoneBeach, BiomeGenBase.coldBeach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.roofedForest, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.extremeHillsPlus, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mesaPlateau, BiomeGenBase.sky};
    }
}

