/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.Loader
 *  net.minecraft.command.IEntitySelector
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityWither
 *  net.minecraft.entity.monster.EntityBlaze
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntityGhast
 *  net.minecraft.entity.monster.EntityMagmaCube
 *  net.minecraft.entity.monster.EntitySilverfish
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.monster.EntityZombie
 *  net.minecraft.entity.player.EntityPlayer
 *  thehippomaster.MutantCreatures.MutantCreeper
 *  thehippomaster.MutantCreatures.MutantEnderman
 *  thehippomaster.MutantCreatures.MutantSkeleton
 *  thehippomaster.MutantCreatures.MutantZombie
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.common.Loader;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityBlazeTitan;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.entity.titan.EntityGargoyleTitan;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityMagmaCubeTitan;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySlimeTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titan.EnumTitanStatus;
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
import net.minecraft.entity.titanminion.IMinion;
import thehippomaster.MutantCreatures.MutantCreeper;
import thehippomaster.MutantCreatures.MutantEnderman;
import thehippomaster.MutantCreatures.MutantSkeleton;
import thehippomaster.MutantCreatures.MutantZombie;

public interface ITitan {
    public static final IEntitySelector SearchForAThingToKill = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            if (p_179983_1_ == null) {
                return false;
            }
            if (p_179983_1_ instanceof EntityTitanSpirit) {
                return false;
            }
            if (!(!(p_179983_1_ instanceof EntityTitan) || p_179983_1_ instanceof EntitySnowGolemTitan || p_179983_1_ instanceof EntityIronGolemTitan || p_179983_1_ instanceof EntityGargoyleTitan || p_179983_1_ instanceof EntityWitherzilla)) {
                return false;
            }
            if (p_179983_1_ instanceof IMinion) {
                return false;
            }
            if (p_179983_1_ instanceof EntityPlayer && ((EntityPlayer)p_179983_1_).capabilities.isCreativeMode) {
                return false;
            }
            if (p_179983_1_.getClass() == (Class)EntityList.stringToClassMapping.get("MutantCreatures.MutantCreeper") || p_179983_1_.getClass() == (Class)EntityList.stringToClassMapping.get("MutantCreatures.MutantEnderman") || p_179983_1_.getClass() == (Class)EntityList.stringToClassMapping.get("MutantCreatures.MutantSkeleton") || p_179983_1_.getClass() == (Class)EntityList.stringToClassMapping.get("MutantCreatures.MutantZombie") || p_179983_1_ instanceof EntityZombie || p_179983_1_ instanceof EntitySkeleton || p_179983_1_ instanceof EntitySpider || p_179983_1_ instanceof EntityCreeper || p_179983_1_ instanceof EntityEnderman || p_179983_1_ instanceof EntityBlaze || p_179983_1_ instanceof EntityGhast || p_179983_1_ instanceof EntityWither || p_179983_1_ instanceof EntityDragon || p_179983_1_ instanceof EntitySilverfish || p_179983_1_ instanceof EntitySlime || p_179983_1_ instanceof EntityGiantZombieBetter) {
                return false;
            }
            return p_179983_1_.isEntityAlive();
        }
    };
    public static final IEntitySelector BlazeTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityBlazeMinion) && !(p_179983_1_ instanceof EntityBlazeTitan);
        }
    };
    public static final IEntitySelector CaveSpiderTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityCaveSpiderMinion) && !(p_179983_1_ instanceof EntityCaveSpiderTitan);
        }
    };
    public static final IEntitySelector CreeperTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityCreeperMinion) && !(p_179983_1_ instanceof EntityCreeperTitan) || Loader.isModLoaded((String)"MutantCreatures") && !(p_179983_1_ instanceof MutantCreeper);
        }
    };
    public static final IEntitySelector EnderColossusSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityEndermanMinion) && !(p_179983_1_ instanceof EntityEnderColossus) && !(p_179983_1_ instanceof EntityDragon) && !(p_179983_1_ instanceof EntityDragonMinion) && !(p_179983_1_ instanceof EntityEnderColossusCrystal) || Loader.isModLoaded((String)"MutantCreatures") && !(p_179983_1_ instanceof MutantEnderman);
        }
    };
    public static final IEntitySelector GhastTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityGhastMinion) && !(p_179983_1_ instanceof EntityGhastTitan);
        }
    };
    public static final IEntitySelector MagmaCubeTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityMagmaCube) && (!(p_179983_1_ instanceof EntityMagmaCubeTitan) || p_179983_1_ instanceof EntitySlimeTitan);
        }
    };
    public static final IEntitySelector PigZombieTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityPigZombieMinion) && !(p_179983_1_ instanceof EntityGhastGuard) && !(p_179983_1_ instanceof EntityPigZombieTitan);
        }
    };
    public static final IEntitySelector SilverfishTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntitySilverfishMinion) && !(p_179983_1_ instanceof EntitySilverfishTitan);
        }
    };
    public static final IEntitySelector SkeletonTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntitySkeletonMinion) && !(p_179983_1_ instanceof EntitySkeletonTitan) && !(p_179983_1_ instanceof EntityWitherMinion) || Loader.isModLoaded((String)"MutantCreatures") && !(p_179983_1_ instanceof MutantSkeleton);
        }
    };
    public static final IEntitySelector SlimeTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntitySlime && !(p_179983_1_ instanceof EntityMagmaCube) || p_179983_1_ instanceof EntitySlimeTitan && !(p_179983_1_ instanceof EntityMagmaCubeTitan));
        }
    };
    public static final IEntitySelector SpiderTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntitySpiderMinion) && (!(p_179983_1_ instanceof EntitySpiderTitan) || p_179983_1_ instanceof EntityCaveSpiderTitan);
        }
    };
    public static final IEntitySelector ZombieTitanSorter = new IEntitySelector(){

        public boolean isEntityApplicable(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityZombieMinion) && !(p_179983_1_ instanceof EntityZombieTitan) && !(p_179983_1_ instanceof EntityGiantZombieBetter) || Loader.isModLoaded((String)"MutantCreatures") && !(p_179983_1_ instanceof MutantZombie);
        }
    };

    public EnumTitanStatus getTitanStatus();
}

