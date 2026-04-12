/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityLargeFireball
 *  net.minecraft.entity.projectile.EntitySmallFireball
 *  net.minecraft.entity.projectile.EntitySnowball
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityLightningBall;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWebShot;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.entity.titan.IEntityMultiPartTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EntityBlazeMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBlazeTitan
extends EntityTitan
implements IEntityMultiPartTitan {
    private float heightOffset = 32.0f;
    private int heightOffsetUpdateTime;
    public boolean shouldBurn;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart[] rods = new EntityTitanPart[12];

    public EntityBlazeTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0f, 8.0f);
        this.rods[0] = new EntityTitanPart(worldIn, this, "rod1", 2.0f, 8.0f);
        this.rods[1] = new EntityTitanPart(worldIn, this, "rod2", 2.0f, 8.0f);
        this.rods[2] = new EntityTitanPart(worldIn, this, "rod3", 2.0f, 8.0f);
        this.rods[3] = new EntityTitanPart(worldIn, this, "rod4", 2.0f, 8.0f);
        this.rods[4] = new EntityTitanPart(worldIn, this, "rod5", 2.0f, 8.0f);
        this.rods[5] = new EntityTitanPart(worldIn, this, "rod6", 2.0f, 8.0f);
        this.rods[6] = new EntityTitanPart(worldIn, this, "rod7", 2.0f, 8.0f);
        this.rods[7] = new EntityTitanPart(worldIn, this, "rod8", 2.0f, 8.0f);
        this.rods[8] = new EntityTitanPart(worldIn, this, "rod9", 2.0f, 8.0f);
        this.rods[9] = new EntityTitanPart(worldIn, this, "rod10", 2.0f, 8.0f);
        this.rods[10] = new EntityTitanPart(worldIn, this, "rod11", 2.0f, 8.0f);
        this.rods[11] = new EntityTitanPart(worldIn, this, "rod12", 2.0f, 8.0f);
        this.partArray = new EntityTitanPart[]{this.head, this.rods[0], this.rods[1], this.rods[2], this.rods[3], this.rods[4], this.rods[5], this.rods[6], this.rods[7], this.rods[8], this.rods[9], this.rods[10], this.rods[11]};
        this.shouldParticlesBeUpward = true;
        this.setSize(8.0f, 8.0f);
        this.experienceValue = 50000;
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        this.worldObj.spawnEntityInWorld((Entity)this.head);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[0]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[1]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[2]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[3]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[4]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[5]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[6]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[7]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[8]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[9]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[10]);
        this.worldObj.spawnEntityInWorld((Entity)this.rods[11]);
    }

    @Override
    protected void applyEntityAI() {
        this.tasks.addTask(4, (EntityAIBase)new AIFireballAttack());
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.BlazeTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public float getEyeHeight() {
        return 4.0f;
    }

    public boolean isArmored() {
        return this.getHealth() <= this.getMaxHealth() / 4.0f || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    @Override
    public int getMinionCap() {
        return 120;
    }

    @Override
    public int getPriestCap() {
        return 60;
    }

    @Override
    public int getZealotCap() {
        return 20;
    }

    @Override
    public int getTemplarCap() {
        return 8;
    }

    @Override
    protected void fall(float p_70069_1_) {
    }

    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != ((Object)((Object)this.head)).getClass() && p_70686_1_ != ((Object)((Object)this.rods[0])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[1])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[2])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[3])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[4])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[5])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[6])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[7])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[8])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[9])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[10])).getClass() && p_70686_1_ != ((Object)((Object)this.rods[11])).getClass() && p_70686_1_ != EntityTitanFireball.class && p_70686_1_ != EntityBlazeMinion.class && p_70686_1_ != EntityBlazeTitan.class;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(250) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.BlazeTitanMinionSpawnrate;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)Byte.valueOf((byte)0));
    }

    @Override
    public int getParticleCount() {
        return 40;
    }

    @Override
    public String getParticles() {
        if (this.rand.nextInt(this.isWet() ? 2 : 6) == 0) {
            return "explode";
        }
        return "largesmoke";
    }

    @Override
    public int getRegenTime() {
        return 10;
    }

    @Override
    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.AVERAGE;
    }

    protected String getLivingSound() {
        return "thetitans:titanBlazeBreathe";
    }

    @Override
    protected String getHurtSound() {
        return "thetitans:titanBlazeGrunt";
    }

    @Override
    protected String getDeathSound() {
        return "thetitans:titanBlazeDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 0xF000F0;
    }

    public float getBrightness(float p_70013_1_) {
        return 1.0f;
    }

    @Override
    public double getSpeed() {
        return 0.5 + (double)this.getExtraPower() * 0.001;
    }

    @Override
    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        double d2;
        double d1;
        double d0;
        int i;
        switch (this.rand.nextInt(2)) {
            case 0: {
                this.setCustomNameTag("\u00a7cBlaze Titan");
                break;
            }
            case 1: {
                this.setCustomNameTag("\u00a76Blaze Titan");
            }
        }
        this.isAirBorne = true;
        this.onGround = false;
        if (this.worldObj.isRemote && this.deathTicks < this.getThreashHold()) {
            for (i = 0; i < this.getParticleCount(); ++i) {
                if (this.shouldParticlesBeUpward) {
                    this.worldObj.spawnParticle(this.getParticles(), this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY - 16.0 + this.rand.nextDouble() * 16.0, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                    continue;
                }
                this.worldObj.spawnParticle(this.getParticles(), this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY - 16.0 + this.rand.nextDouble() * 16.0, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0);
            }
            if (TheTitans.NightmareMode && this.rand.nextInt(20) == 0) {
                for (i = 0; i < 2; ++i) {
                    this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY - 16.0 + this.rand.nextDouble() * 16.0, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
                }
            }
        }
        for (i = 0; i < 8; ++i) {
            d0 = this.posX + (double)(this.rand.nextFloat() * 8.0f - 4.0f);
            d1 = this.posY + (double)(this.rand.nextFloat() * 20.0f);
            d2 = this.posZ + (double)(this.rand.nextFloat() * 8.0f - 4.0f);
            if (this.worldObj.isRemote || !this.worldObj.getBlock((int)d0, (int)d1 + (int)this.getEyeHeight(), (int)d2).isOpaqueCube() && !this.worldObj.getBlock((int)d0, (int)d1 + (int)this.getEyeHeight(), (int)d2).getMaterial().isLiquid()) continue;
            this.setPosition(this.posX, this.posY + 0.1, this.posZ);
        }
        for (int in = 0; in < 1000; ++in) {
            d0 = this.posX + (double)(this.rand.nextFloat() * 8.0f - 4.0f);
            d1 = this.posY - (double)this.rand.nextInt(20);
            d2 = this.posZ + (double)(this.rand.nextFloat() * 8.0f - 4.0f);
            if (this.worldObj.isRemote || !this.worldObj.getBlock((int)d0, (int)d1, (int)d2).isOpaqueCube() && !this.worldObj.getBlock((int)d0, (int)d1, (int)d2).getMaterial().isLiquid()) continue;
            this.motionY = 0.25;
        }
        if (this.ticksExisted > 5) {
            int i2;
            float f = this.renderYawOffset * (float)Math.PI / 180.0f;
            float f6 = (float)this.ticksExisted * (float)Math.PI * 0.008f + 0.15f;
            for (i2 = 0; i2 < 4; ++i2) {
                this.rods[i2].setLocationAndAngles(this.posX - (double)(MathHelper.cos((float)(f6 + f)) * 10.0f), this.posY - (double)(4.0f + MathHelper.cos((float)((float)(i2 * 2 + this.ticksExisted) * 0.03f))), this.posZ - (double)(MathHelper.sin((float)(f6 + f)) * 10.0f), 0.0f, 0.0f);
                f6 += 1.0f;
            }
            f6 = 0.7853982f + (float)this.ticksExisted * (float)Math.PI * -0.005f - 1.4f;
            for (i2 = 4; i2 < 8; ++i2) {
                this.rods[i2].setLocationAndAngles(this.posX - (double)(MathHelper.cos((float)(f6 + f)) * 7.0f), this.posY - (double)(10.0f + MathHelper.cos((float)((float)(i2 * 3 + this.ticksExisted) * 0.05f))), this.posZ - (double)(MathHelper.sin((float)(f6 + f)) * 7.0f), 0.0f, 0.0f);
                f6 += 1.0f;
            }
            f6 = 0.47123894f + (float)this.ticksExisted * (float)Math.PI * 0.003f - 0.8f;
            for (i2 = 8; i2 < 12; ++i2) {
                this.rods[i2].setLocationAndAngles(this.posX - (double)(MathHelper.cos((float)(f6 + f)) * 4.0f), this.posY - (double)(17.0f + MathHelper.cos((float)(((float)i2 * 1.5f + (float)this.ticksExisted) * 0.02f))), this.posZ - (double)(MathHelper.sin((float)(f6 + f)) * 4.0f), 0.0f, 0.0f);
                f6 += 1.0f;
            }
            this.head.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
            for (int u = 0; u < this.getParticleCount(); ++u) {
                for (int w = 0; w < this.rods.length; ++w) {
                    this.worldObj.spawnParticle(this.getParticles(), this.rods[w].posX + (this.rand.nextDouble() - 0.5) * (double)this.rods[w].width, this.rods[w].posY + this.rand.nextDouble() * (double)this.rods[w].height, this.rods[w].posZ + (this.rand.nextDouble() - 0.5) * (double)this.rods[w].width, 0.0, 0.0, 0.0);
                }
            }
            if (this.isEntityAlive()) {
                this.collideWithEntities(this.head, this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.head.boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[0], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[0].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[1], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[1].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[2], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[2].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[3], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[3].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[4], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[4].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[5], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[5].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[6], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[6].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[7], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[7].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[8], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[8].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[9], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[9].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[10], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[10].boundingBox.expand(1.0, 0.0, 1.0)));
                this.collideWithEntities(this.rods[11], this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.rods[11].boundingBox.expand(1.0, 0.0, 1.0)));
            }
            this.destroyBlocksInAABB(this.head.boundingBox);
            this.destroyBlocksInAABB(this.rods[0].boundingBox);
            this.destroyBlocksInAABB(this.rods[1].boundingBox);
            this.destroyBlocksInAABB(this.rods[2].boundingBox);
            this.destroyBlocksInAABB(this.rods[3].boundingBox);
            this.destroyBlocksInAABB(this.rods[4].boundingBox);
            this.destroyBlocksInAABB(this.rods[5].boundingBox);
            this.destroyBlocksInAABB(this.rods[6].boundingBox);
            this.destroyBlocksInAABB(this.rods[7].boundingBox);
            this.destroyBlocksInAABB(this.rods[8].boundingBox);
            this.destroyBlocksInAABB(this.rods[9].boundingBox);
            this.destroyBlocksInAABB(this.rods[10].boundingBox);
            this.destroyBlocksInAABB(this.rods[11].boundingBox);
            for (int k = 0; k < this.partArray.length; ++k) {
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.partArray[k].boundingBox.expand(0.5, 0.5, 0.5));
                if (list == null || list.isEmpty()) continue;
                for (int j = 0; j < list.size(); ++j) {
                    Entity entity = (Entity)list.get(j);
                    if (!(!(entity instanceof EntityFireball) || ((EntityFireball)entity).shootingEntity == this || entity instanceof EntitySmallFireball || entity instanceof EntityLightningBall || entity instanceof EntityGargoyleTitanFireball || entity instanceof EntityWebShot)) {
                        ((EntityFireball)entity).attackEntityFrom(DamageSource.causeThornsDamage((Entity)this), 0.0f);
                    }
                    if (entity instanceof EntityTitanFireball && ((EntityTitanFireball)entity).shootingEntity != null && ((EntityTitanFireball)entity).shootingEntity != this) {
                        ((EntityTitanFireball)entity).onImpactPublic((EntityLivingBase)this);
                    }
                    if (entity instanceof EntityGargoyleTitanFireball) {
                        this.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                        net.minecraft.theTitans.util.FastExplosion.newExplosion(this.worldObj, (Entity)(((EntityGargoyleTitanFireball)entity).shootingEntity != null ? ((EntityGargoyleTitanFireball)entity).shootingEntity : (EntityGargoyleTitanFireball)entity), ((EntityGargoyleTitanFireball)entity).posX, ((EntityGargoyleTitanFireball)entity).posY, ((EntityGargoyleTitanFireball)entity).posZ, 8.0f, false, false);
                        this.attackEntityFromPart(this.partArray[i2], DamageSource.causeFireballDamage((EntityFireball)((EntityGargoyleTitanFireball)entity), (Entity)(((EntityGargoyleTitanFireball)entity).shootingEntity != null ? ((EntityGargoyleTitanFireball)entity).shootingEntity : (EntityGargoyleTitanFireball)entity)), 1000.0f);
                        entity.setDead();
                    }
                    if (entity instanceof EntityHarcadiumArrow) {
                        this.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                        this.attackEntityFromPart(this.partArray[i2], DamageSourceExtra.causeHarcadiumArrowDamage((EntityHarcadiumArrow)entity, (Entity)(((EntityHarcadiumArrow)entity).shootingEntity != null ? ((EntityHarcadiumArrow)entity).shootingEntity : (EntityHarcadiumArrow)entity)), 500.0f);
                        entity.setDead();
                    }
                    if (entity instanceof EntityWebShot && ((EntityWebShot)entity).shootingEntity != this) {
                        this.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                        this.attackEntityFromPart(this.partArray[i2], DamageSourceExtra.causeAntiTitanDamage((Entity)(((EntityWebShot)entity).shootingEntity != this ? ((EntityWebShot)entity).shootingEntity : (EntityWebShot)entity)), 300.0f);
                        int i1 = MathHelper.floor_double((double)this.partArray[i2].posY);
                        int i11 = MathHelper.floor_double((double)this.partArray[i2].posX);
                        int j1 = MathHelper.floor_double((double)this.partArray[i2].posZ);
                        boolean flag = false;
                        for (int l1 = -2 - this.rand.nextInt(4); l1 <= 2 + this.rand.nextInt(4); ++l1) {
                            for (int i22 = -2 - this.rand.nextInt(4); i22 <= 2 + this.rand.nextInt(4); ++i22) {
                                for (int h = -2; h <= 2 + this.rand.nextInt(5); ++h) {
                                    int j2 = i11 + l1;
                                    int k1 = i1 + h;
                                    int l = j1 + i22;
                                    Block block1 = this.worldObj.getBlock(j2, k1, l);
                                    if (block1.isOpaqueCube()) continue;
                                    this.worldObj.setBlock(j2, k1, l, Blocks.web);
                                }
                            }
                        }
                        entity.setDead();
                    }
                    if (!(entity instanceof EntitySnowball)) continue;
                    this.playSound("thetitans:titanpunch", 10.0f, 1.0f);
                    this.attackEntityFromPart(this.partArray[k], DamageSource.causeThrownDamage((Entity)((EntitySnowball)entity), (Entity)(((EntitySnowball)entity).getThrower() != null ? ((EntitySnowball)entity).getThrower() : (EntitySnowball)entity)), 25.0f);
                    entity.setDead();
                    if (this.hurtResistantTime <= 15) continue;
                    this.hurtResistantTime = 15;
                }
            }
        }
        if (TheTitans.NightmareMode) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1800.0 + (double)(this.getExtraPower() * 40));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80000.0 + (double)(this.getExtraPower() * 4000));
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(600.0 + (double)(this.getExtraPower() * 20));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40000.0 + (double)(this.getExtraPower() * 2000));
        }
        if (this.numMinions < this.getMinionCap() && (this.rand.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityBlazeMinion entitychicken = new EntityBlazeMinion(this.worldObj);
            entitychicken.setMinionType(0);
            entitychicken.setLocationAndAngles(this.posX, this.posY - 2.0, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numMinions;
        }
        if (this.numPriests < this.getPriestCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityBlazeMinion entitychicken = new EntityBlazeMinion(this.worldObj);
            entitychicken.setMinionType(1);
            entitychicken.setLocationAndAngles(this.posX, this.posY - 2.0, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numPriests;
        }
        if (this.numZealots < this.getZealotCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityBlazeMinion entitychicken = new EntityBlazeMinion(this.worldObj);
            entitychicken.setMinionType(2);
            entitychicken.setLocationAndAngles(this.posX, this.posY - 2.0, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numZealots;
        }
        if (this.numBishop < this.getBishopCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityBlazeMinion entitychicken = new EntityBlazeMinion(this.worldObj);
            entitychicken.setMinionType(3);
            entitychicken.setLocationAndAngles(this.posX, this.posY - 2.0, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numBishop;
        }
        if (this.numTemplar < this.getTemplarCap() && (this.rand.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.getHealth() > 0.0f && !this.worldObj.isRemote && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityBlazeMinion entitychicken = new EntityBlazeMinion(this.worldObj);
            entitychicken.setMinionType(4);
            entitychicken.setLocationAndAngles(this.posX, this.posY - 2.0, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitychicken);
            ++this.numTemplar;
        }
        if (this.worldObj.isRemote && this.rand.nextInt(48) == 0) {
            this.worldObj.playSound(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "fire.fire", 10.0f + this.rand.nextFloat(), this.rand.nextFloat() * 0.3f + 0.2f, false);
        }
        if (this.getAttackTarget() != null && !this.worldObj.isRemote) {
            this.faceEntity((Entity)this.getAttackTarget(), 5.0f, 180.0f);
            this.getMoveHelper().setMoveTo(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 20.0);
            if (this.posY < this.getAttackTarget().posY + 20.0) {
                if (this.motionY < 0.0) {
                    this.motionY = 0.0;
                }
                this.motionY += (0.8 - this.motionY) * 0.8;
            }
        } else if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.25;
        }
        super.onLivingUpdate();
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    @Override
    protected void updateAITasks() {
        long perfNs = TitansPerf.begin();
        try {
        if (this.getInvulTime() < 0) {
            EntityLivingBase entitylivingbase;
            --this.heightOffsetUpdateTime;
            if (this.heightOffsetUpdateTime <= 0) {
                this.heightOffsetUpdateTime = 300;
                this.heightOffset = 40.0f + (float)this.rand.nextGaussian() * 16.0f;
            }
            if ((entitylivingbase = this.getAttackTarget()) != null && entitylivingbase.posY + (double)entitylivingbase.getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset) {
                this.motionY += (0.9 - this.motionY) * 0.9;
                this.isAirBorne = true;
            }
        }
        super.updateAITasks();
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_AI, this.getClass().getSimpleName() + "#updateAITasks", perfNs);
        }
    }

    public void fall(float distance, float damageMultiplier) {
    }

    protected Item getDropItem() {
        return Items.blaze_rod;
    }

    public int getVerticalFaceSpeed() {
        return 180;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            EntityItem entityitem;
            int l;
            for (int x = 0; x < 32; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.worldObj, this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.setPosition(this.posX, this.posY + 4.0, this.posZ);
                entitylargefireball.motionY += 1.0;
                entitylargefireball.setXPCount(18000);
                this.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
            }
            for (l = 0; l < 144 + this.rand.nextInt(144 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.blaze_rod));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 96 + this.rand.nextInt(96 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.blaze_powder));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 64 + this.rand.nextInt(64 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.coal));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 24 + this.rand.nextInt(64 + p_70628_2_) + p_70628_2_; ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.gold_ingot));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 16 + this.rand.nextInt(24 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.emerald));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 16 + this.rand.nextInt(24 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Items.diamond));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            for (l = 0; l < 1 + this.rand.nextInt(8 + p_70628_2_); ++l) {
                entityitem = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(TitanItems.harcadium));
                entityitem.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
            }
            if (this.rand.nextInt(5) == 0) {
                EntityItem entityitem2 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.bedrock));
                entityitem2.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem2);
            }
            if (this.rand.nextInt(5) == 0) {
                EntityItem entityitem3 = new EntityItem(this.worldObj, this.posX + (double)(this.rand.nextFloat() * 12.0f - 6.0f), this.posY + 10.0 + (double)(this.rand.nextFloat() * 10.0f), this.posZ + (double)(this.rand.nextFloat() * 12.0f - 6.0f), new ItemStack(Blocks.bedrock));
                entityitem3.delayBeforeCanPickup = 40;
                this.worldObj.spawnEntityInWorld((Entity)entityitem3);
            }
        }
    }

    protected void addRandomArmor() {
        this.dropItem(Items.brewing_stand, 64);
    }

    public boolean func_70845_n() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void func_70844_e(boolean p_70844_1_) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        b0 = p_70844_1_ ? (byte)(b0 | 1) : (byte)(b0 & 0xFFFFFFFE);
        this.dataWatcher.updateObject(16, (Object)b0);
    }

    public boolean isBurning() {
        return this.func_70845_n() && this.hurtResistantTime < 20;
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    public Entity[] getParts() {
        return this.partArray;
    }

    @Override
    public boolean handleLavaMovement() {
        return false;
    }

    protected void collideWithEntity(Entity p_82167_1_) {
        if (!(p_82167_1_ instanceof EntitySmallFireball) || !(p_82167_1_ instanceof EntityLargeFireball)) {
            p_82167_1_.applyEntityCollision((Entity)this);
        }
    }

    @Override
    public StatBase getAchievement() {
        return TitansAchievments.blazetitan;
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 3.0f;
        }
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source.getEntity() instanceof EntityBlazeMinion || source.getEntity() instanceof EntityBlazeTitan) {
            return false;
        }
        if (source.isFireDamage()) {
            this.heal(amount);
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    protected void inactDeathAction() {
        if (!this.worldObj.isRemote) {
            this.playSound("mob.blaze.death", this.getSoundVolume(), this.getSoundPitch());
            if (this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(true, 0);
                this.dropEquipment(true, 0);
                this.dropRareDrop(1);
            }
            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.worldObj);
            entitytitan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(9);
        }
    }

    @Override
    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        this.func_82195_e(source, amount);
        return true;
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return this.attackEntityFrom(p_82195_1_, p_82195_2_);
    }

    public World func_82194_d() {
        return this.worldObj;
    }

    class AIFireballAttack
    extends EntityAIBase {
        private EntityBlazeTitan field_179469_a;
        private int field_179467_b;
        private int field_179468_c;

        public AIFireballAttack() {
            this.field_179469_a = EntityBlazeTitan.this;
            this.setMutexBits(4);
        }

        public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.field_179469_a.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive();
        }

        public void startExecuting() {
            this.field_179467_b = 0;
            this.field_179469_a.func_70844_e(true);
        }

        public void resetTask() {
            this.field_179469_a.func_70844_e(false);
        }

        public void updateTask() {
            --this.field_179468_c;
            EntityLivingBase entitylivingbase = this.field_179469_a.getAttackTarget();
            double d0 = this.field_179469_a.getDistanceSqToEntity((Entity)entitylivingbase);
            if (d0 <= this.field_179469_a.getMeleeRange()) {
                if (this.field_179468_c <= 0) {
                    this.field_179468_c = 30;
                    float f = (float)this.field_179469_a.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                    int i = this.field_179469_a.getKnockbackAmount();
                    this.field_179469_a.attackChoosenEntity((Entity)entitylivingbase, f, i);
                    if (entitylivingbase.height > 6.0f || entitylivingbase instanceof EntityTitan) {
                        this.field_179469_a.attackChoosenEntity((Entity)entitylivingbase, f, i);
                        this.field_179469_a.attackChoosenEntity((Entity)entitylivingbase, f, i);
                        this.field_179469_a.attackChoosenEntity((Entity)entitylivingbase, f, i);
                        this.field_179469_a.attackChoosenEntity((Entity)entitylivingbase, f, i);
                        this.field_179469_a.attackChoosenEntity((Entity)entitylivingbase, f, i);
                    }
                }
            } else if (d0 > this.field_179469_a.getMeleeRange()) {
                double d1 = entitylivingbase.posX - this.field_179469_a.posX;
                double d2 = entitylivingbase.posY - (this.field_179469_a.posY + (double)(this.field_179469_a.height * 0.5f));
                double d3 = entitylivingbase.posZ - this.field_179469_a.posZ;
                if (this.field_179468_c <= 0) {
                    ++this.field_179467_b;
                    if (this.field_179467_b == 1) {
                        this.field_179468_c = this.field_179469_a.isArmored() ? 10 : 20 + this.field_179469_a.getRNG().nextInt(40);
                    } else if (this.field_179467_b <= 4) {
                        this.field_179468_c = 6;
                    } else {
                        this.field_179468_c = this.field_179469_a.isArmored() ? 10 : 20 + this.field_179469_a.getRNG().nextInt(40);
                        this.field_179467_b = 0;
                    }
                    if (this.field_179467_b > 1) {
                        float f = MathHelper.sqrt_float((float)MathHelper.sqrt_double((double)d0)) * 0.75f;
                        this.field_179469_a.playSound("thetitans:titanGhastFireball", 100.0f, 1.1f);
                        for (int i = 0; i < 100; ++i) {
                            EntityTitanFireball entitylargefireball = new EntityTitanFireball(this.field_179469_a.worldObj, (EntityLivingBase)this.field_179469_a, d1 + this.field_179469_a.getRNG().nextGaussian() * (double)f, d2, d3 + this.field_179469_a.getRNG().nextGaussian() * (double)f, 2);
                            double d8 = 10.0;
                            Vec3 vec3 = this.field_179469_a.getLook(1.0f);
                            entitylargefireball.posX = this.field_179469_a.posX + vec3.xCoord * d8;
                            entitylargefireball.posY = this.field_179469_a.posY + 4.0 + vec3.yCoord * d8;
                            entitylargefireball.posZ = this.field_179469_a.posZ + vec3.zCoord * d8;
                            this.field_179469_a.worldObj.spawnEntityInWorld((Entity)entitylargefireball);
                            entitylargefireball.setFireballID(2);
                            if (this.field_179469_a.getRNG().nextInt(50) != 0) continue;
                            net.minecraft.theTitans.util.FastExplosion.newExplosion(this.field_179469_a.worldObj, (Entity)this.field_179469_a, entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 4.0f, false, false);
                            entitylivingbase.attackEntityFrom(DamageSourceExtra.lightningBolt, 49.0f);
                            float f2 = (float)EntityBlazeTitan.this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                            int i1 = EntityBlazeTitan.this.getKnockbackAmount();
                            EntityBlazeTitan.this.attackChoosenEntity((Entity)entitylivingbase, f2, i1);
                            this.field_179469_a.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.field_179469_a.worldObj, this.field_179469_a.posX, this.field_179469_a.posY + (double)this.field_179469_a.getEyeHeight(), this.field_179469_a.posZ, 1.0f, 0.8f, 0.0f));
                            this.field_179469_a.worldObj.addWeatherEffect((Entity)new EntityGammaLightning(this.field_179469_a.worldObj, entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0f, 0.8f, 0.0f));
                        }
                    }
                }
            } else {
                this.field_179469_a.getNavigator().clearPathEntity();
            }
            super.updateTask();
        }
    }
}

