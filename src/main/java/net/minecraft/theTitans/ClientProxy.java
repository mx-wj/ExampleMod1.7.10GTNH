/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.client.registry.RenderingRegistry
 *  cpw.mods.fml.common.Loader
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelZombie
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderGiantZombie
 *  net.minecraft.client.renderer.entity.RenderSnowball
 *  net.minecraft.item.Item
 *  net.minecraft.potion.Potion
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.MinecraftForgeClient
 *  net.minecraftforge.common.MinecraftForge
 */
package net.minecraft.theTitans;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderGiantZombie;
import net.minecraft.client.renderer.entity.RenderSnowball;
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
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.theTitans.CommonProxy;
import net.minecraft.theTitans.TitanBossBarGui;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitanPotions;
import net.minecraft.theTitans.models.ModelSlimeTitan;
import net.minecraft.theTitans.render.RenderBlazeTitan;
import net.minecraft.theTitans.render.RenderCaveSpiderTitan;
import net.minecraft.theTitans.render.RenderChaff;
import net.minecraft.theTitans.render.RenderCreeperTitan;
import net.minecraft.theTitans.render.RenderDragonMinion;
import net.minecraft.theTitans.render.RenderEnderColossus;
import net.minecraft.theTitans.render.RenderEnderColossusCrystal;
import net.minecraft.theTitans.render.RenderGammaLightning;
import net.minecraft.theTitans.render.RenderGargoyleTitanFireball;
import net.minecraft.theTitans.render.RenderGhastGuard;
import net.minecraft.theTitans.render.RenderGhastTitan;
import net.minecraft.theTitans.render.RenderGiantArrow;
import net.minecraft.theTitans.render.RenderHarcadiumArrow;
import net.minecraft.theTitans.render.RenderLavaSpit;
import net.minecraft.theTitans.render.RenderLightningBall;
import net.minecraft.theTitans.render.RenderMagmaCubeTitan;
import net.minecraft.theTitans.render.RenderMethuselahKraken;
import net.minecraft.theTitans.render.RenderOmegafish;
import net.minecraft.theTitans.render.RenderOverlordScorpion;
import net.minecraft.theTitans.render.RenderProtoBall;
import net.minecraft.theTitans.render.RenderSkeletonTitan;
import net.minecraft.theTitans.render.RenderSlimeTitan;
import net.minecraft.theTitans.render.RenderSnowGolemTitan;
import net.minecraft.theTitans.render.RenderSpiderTitan;
import net.minecraft.theTitans.render.RenderTitanFireball;
import net.minecraft.theTitans.render.RenderTitanPart;
import net.minecraft.theTitans.render.RenderTitanSpirit;
import net.minecraft.theTitans.render.RenderUltimaIronGolemTitan;
import net.minecraft.theTitans.render.RenderWebShot;
import net.minecraft.theTitans.render.RenderWitherMinion;
import net.minecraft.theTitans.render.RenderWitherTurret;
import net.minecraft.theTitans.render.RenderWitherTurretGround;
import net.minecraft.theTitans.render.RenderWitherTurretMortar;
import net.minecraft.theTitans.render.RenderWitherzilla;
import net.minecraft.theTitans.render.RenderWitherzillaMinion;
import net.minecraft.theTitans.render.RenderXPBomb;
import net.minecraft.theTitans.render.RenderZombiePigmanTitan;
import net.minecraft.theTitans.render.RenderZombieTitan;
import net.minecraft.theTitans.render.items.RenderBlazeTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderCaveSpiderTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderChargedCreeperTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderCreeperTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderEnderColossusSpawnEgg;
import net.minecraft.theTitans.render.items.RenderGhastTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderMagmaCubeTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderOmegafishSpawnEgg;
import net.minecraft.theTitans.render.items.RenderOptimaAxe;
import net.minecraft.theTitans.render.items.RenderSkeletonTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderSlimeTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderSnowGolemTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderSpiderJockeyTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderSpiderTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderUltimaBlade;
import net.minecraft.theTitans.render.items.RenderUltimaIronGolemTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderWitherJockeyTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderWitherSkeletonTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderWitherzillaSpawnEgg;
import net.minecraft.theTitans.render.items.RenderZombiePigmanTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderZombieTitanSpawnEgg;
import net.minecraft.theTitans.render.minions.RenderBlazeMinion;
import net.minecraft.theTitans.render.minions.RenderCaveSpiderMinion;
import net.minecraft.theTitans.render.minions.RenderCreeperMinion;
import net.minecraft.theTitans.render.minions.RenderEndermanMinion;
import net.minecraft.theTitans.render.minions.RenderGhastMinion;
import net.minecraft.theTitans.render.minions.RenderPigZombieMinion;
import net.minecraft.theTitans.render.minions.RenderSilverfishMinion;
import net.minecraft.theTitans.render.minions.RenderSkeletonMinion;
import net.minecraft.theTitans.render.minions.RenderSpiderMinion;
import net.minecraft.theTitans.render.minions.RenderZombieMinion;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy
extends CommonProxy {
    public static Potion electricJudgment;
    public static Potion creeperTitanRadiation;
    public static Potion advancedWither;
    public static Potion death;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        death = new TitanPotions(28, true, 0).setIconIndex(1, 2).setPotionName("potion.death");
        electricJudgment = new TitanPotions(29, true, 14270531).setIconIndex(2, 2).setPotionName("potion.electricJudgment");
        creeperTitanRadiation = new TitanPotions(30, true, 28165).setIconIndex(6, 0).setPotionName("potion.radiation");
        advancedWither = new TitanPotions(31, true, 0).setIconIndex(1, 2).setPotionName("potion.advancedWither");
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @Override
    public void registerItemRenderers() {
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.ultimaBlade, (IItemRenderer)new RenderUltimaBlade());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.optimaAxe, (IItemRenderer)new RenderOptimaAxe());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggOmegafish, (IItemRenderer)new RenderOmegafishSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggCaveSpiderTitan, (IItemRenderer)new RenderCaveSpiderTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggSpiderTitan, (IItemRenderer)new RenderSpiderTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggSlimeTitan, (IItemRenderer)new RenderSlimeTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggMagmaCubeTitan, (IItemRenderer)new RenderMagmaCubeTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggSpiderJockeyTitan, (IItemRenderer)new RenderSpiderJockeyTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggSkeletonTitan, (IItemRenderer)new RenderSkeletonTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggZombieTitan, (IItemRenderer)new RenderZombieTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggCreeperTitan, (IItemRenderer)new RenderCreeperTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggChargedCreeperTitan, (IItemRenderer)new RenderChargedCreeperTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggZombiePigmanTitan, (IItemRenderer)new RenderZombiePigmanTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggBlazeTitan, (IItemRenderer)new RenderBlazeTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggWitherJockeyTitan, (IItemRenderer)new RenderWitherJockeyTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggWitherSkeletonTitan, (IItemRenderer)new RenderWitherSkeletonTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggSnowGolemTitan, (IItemRenderer)new RenderSnowGolemTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggUltimaIronGolemTitan, (IItemRenderer)new RenderUltimaIronGolemTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggGhastTitan, (IItemRenderer)new RenderGhastTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggEnderColossus, (IItemRenderer)new RenderEnderColossusSpawnEgg());
        MinecraftForgeClient.registerItemRenderer((Item)TitanItems.eggWitherzilla, (IItemRenderer)new RenderWitherzillaSpawnEgg());
    }

    @Override
    public void registerRenderThings() {
        MinecraftForge.EVENT_BUS.register((Object)new TitanBossBarGui(Minecraft.getMinecraft()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverfishMinion.class, (Render)new RenderSilverfishMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityCaveSpiderMinion.class, (Render)new RenderCaveSpiderMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntitySpiderMinion.class, (Render)new RenderSpiderMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieMinion.class, (Render)new RenderZombieMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonMinion.class, (Render)new RenderSkeletonMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperMinion.class, (Render)new RenderCreeperMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityPigZombieMinion.class, (Render)new RenderPigZombieMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazeMinion.class, (Render)new RenderBlazeMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityGhastMinion.class, (Render)new RenderGhastMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityEndermanMinion.class, (Render)new RenderEndermanMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityGhastGuard.class, (Render)new RenderGhastGuard());
        RenderingRegistry.registerEntityRenderingHandler(EntityGiantZombieBetter.class, (Render)new RenderGiantZombie((ModelBase)new ModelZombie(), 0.5f, 6.0f));
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherMinion.class, (Render)new RenderWitherMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityDragonMinion.class, (Render)new RenderDragonMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherzillaMinion.class, (Render)new RenderWitherzillaMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherTurret.class, (Render)new RenderWitherTurret());
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherTurretGround.class, (Render)new RenderWitherTurretGround());
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherTurretMortar.class, (Render)new RenderWitherTurretMortar());
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderColossusCrystal.class, (Render)new RenderEnderColossusCrystal());
        RenderingRegistry.registerEntityRenderingHandler(EntityHarcadiumArrow.class, (Render)new RenderHarcadiumArrow());
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonTitanGiantArrow.class, (Render)new RenderGiantArrow());
        RenderingRegistry.registerEntityRenderingHandler(EntityChaff.class, (Render)new RenderChaff());
        RenderingRegistry.registerEntityRenderingHandler(EntityXPBomb.class, (Render)new RenderXPBomb());
        RenderingRegistry.registerEntityRenderingHandler(EntityTitanPart.class, (Render)new RenderTitanPart());
        RenderingRegistry.registerEntityRenderingHandler(EntityGammaLightning.class, (Render)new RenderGammaLightning());
        RenderingRegistry.registerEntityRenderingHandler(EntityProtoBall.class, (Render)new RenderProtoBall());
        RenderingRegistry.registerEntityRenderingHandler(EntityLightningBall.class, (Render)new RenderLightningBall(8.0f));
        RenderingRegistry.registerEntityRenderingHandler(EntityTitanFireball.class, (Render)new RenderTitanFireball());
        RenderingRegistry.registerEntityRenderingHandler(EntityGargoyleTitanFireball.class, (Render)new RenderGargoyleTitanFireball());
        RenderingRegistry.registerEntityRenderingHandler(EntityLavaSpit.class, (Render)new RenderLavaSpit());
        RenderingRegistry.registerEntityRenderingHandler(EntityTitanSpirit.class, (Render)new RenderTitanSpirit());
        RenderingRegistry.registerEntityRenderingHandler(EntityWebShot.class, (Render)new RenderWebShot(4.0f));
        RenderingRegistry.registerEntityRenderingHandler(EntityGrowthSerum.class, (Render)new RenderSnowball(TitanItems.growthSerum));
        if (Loader.isModLoaded((String)"OreSpawn")) {
            RenderingRegistry.registerEntityRenderingHandler(EntityOverlordScorpion.class, (Render)new RenderOverlordScorpion());
            RenderingRegistry.registerEntityRenderingHandler(EntityMethuselahKraken.class, (Render)new RenderMethuselahKraken());
        }
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowGolemTitan.class, (Render)new RenderSnowGolemTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntitySlimeTitan.class, (Render)new RenderSlimeTitan(new ModelSlimeTitan(16), new ModelSlimeTitan(0), 0.25f));
        RenderingRegistry.registerEntityRenderingHandler(EntityMagmaCubeTitan.class, (Render)new RenderMagmaCubeTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverfishTitan.class, (Render)new RenderOmegafish());
        RenderingRegistry.registerEntityRenderingHandler(EntityCaveSpiderTitan.class, (Render)new RenderCaveSpiderTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntitySpiderTitan.class, (Render)new RenderSpiderTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieTitan.class, (Render)new RenderZombieTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonTitan.class, (Render)new RenderSkeletonTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperTitan.class, (Render)new RenderCreeperTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityPigZombieTitan.class, (Render)new RenderZombiePigmanTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazeTitan.class, (Render)new RenderBlazeTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityGhastTitan.class, (Render)new RenderGhastTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderColossus.class, (Render)new RenderEnderColossus());
        RenderingRegistry.registerEntityRenderingHandler(EntityIronGolemTitan.class, (Render)new RenderUltimaIronGolemTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherzilla.class, (Render)new RenderWitherzilla());
    }
}

