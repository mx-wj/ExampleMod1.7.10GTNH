/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityFlying
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;
import net.minecraft.theTitans.perf.PerfSection;
import net.minecraft.theTitans.perf.TitansPerf;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.IMinion;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityEnderColossusCrystal
extends EntityFlying
implements IMinion {
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    public int innerRotation;
    public EntityEnderColossus owner;

    public EntityEnderColossusCrystal(World p_i1735_1_) {
        super(p_i1735_1_);
        this.func_110163_bv();
        this.setSize(2.0f, 2.0f);
        this.innerRotation = this.rand.nextInt(100000);
        this.experienceValue = 10;
        this.isAirBorne = true;
        this.onGround = false;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 0xF000F0;
    }

    public float getBrightness(float p_70013_1_) {
        return 1.0f;
    }

    public void setDead() {
        super.setDead();
        if (this.owner != null) {
            --this.owner.numOfCrystals;
        }
    }

    protected void onDeathUpdate() {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.99;
        this.motionY *= 0.99;
        this.motionZ *= 0.99;
        this.motionY -= 0.1;
        if (this.isBurning()) {
            this.onGround = true;
        }
        if (!this.worldObj.isRemote && (this.isEntityInsideOpaqueBlock() || this.onGround || this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ).getMaterial().isSolid())) {
            int i;
            if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                int j;
                this.entityDropItem(new ItemStack(Blocks.glass, 1), 20.0f);
                this.entityDropItem(new ItemStack(Blocks.glass, 1), 28.0f);
                for (i = 50; i > 0; i -= j) {
                    j = EntityXPOrb.getXPSplit((int)i);
                    this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY + 20.0, this.posZ, j));
                }
            }
            for (i = 0; i < 200; ++i) {
                double d2 = this.rand.nextGaussian() * 0.02;
                double d0 = this.rand.nextGaussian() * 0.02;
                double d1 = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d2, d0, d1);
            }
            this.setDead();
            if (!this.worldObj.isRemote) {
                this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 6.0f, true);
            }
        }
    }

    public void onLivingUpdate() {
        long perfNs = TitansPerf.begin();
        try {
        super.onLivingUpdate();
        this.updateEnderColossusEnderCrystal();
        this.ignoreFrustumCheck = true;
        this.renderDistanceWeight = 100.0;
        ++this.innerRotation;
    
        }
        finally {
            TitansPerf.endWarn(PerfSection.ENTITY_TICK, this.getClass().getSimpleName() + "#onLivingUpdate", perfNs);
        }
    }

    protected void updateEntityActionState() {
        List list1111;
        double d0 = this.waypointX - this.posX;
        double d1 = this.waypointY - this.posY;
        double d2 = this.waypointZ - this.posZ;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;
        if (this.getDistanceSq(this.waypointX, this.waypointY, this.waypointZ) > 10000.0) {
            double d5 = MathHelper.sqrt_double((double)d3);
            this.motionX += d0 / d5 * 0.75 - this.motionX;
            this.motionY += d1 / d5 * 0.75 - this.motionY;
            this.motionZ += d2 / d5 * 0.75 - this.motionZ;
        }
        if (d3 < 1.0 || d3 > 20000.0) {
            if (this.owner != null) {
                this.waypointX = this.owner.posX + (double)((this.rand.nextFloat() * 4.0f - 2.0f) * (this.owner.width * 2.0f));
                this.waypointY = this.owner.posY + (double)this.owner.height + 48.0 + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 24.0f);
                this.waypointZ = this.owner.posZ + (double)((this.rand.nextFloat() * 4.0f - 2.0f) * (this.owner.width * 2.0f));
            } else {
                this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f);
                this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f);
                this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f);
            }
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3 = (double)MathHelper.sqrt_double((double)d3))) {
                if (d3 > 4048.0) {
                    this.motionX += d0 / d3 * 0.2;
                    this.motionY += d1 / d3 * 0.2;
                    this.motionZ += d2 / d3 * 0.2;
                } else {
                    this.motionX += d0 / d3 * 0.1;
                    this.motionY += d1 / d3 * 0.1;
                    this.motionZ += d2 / d3 * 0.1;
                }
            } else {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }
        if (this.owner == null && (list1111 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(256.0, 256.0, 256.0))) != null && !list1111.isEmpty()) {
            for (int i1 = 0; i1 < list1111.size(); ++i1) {
                Entity entity1 = (Entity)list1111.get(i1);
                if (entity1 == null || !(entity1 instanceof EntityEnderColossus) || ((EntityEnderColossus)entity1).numOfCrystals >= 20) continue;
                this.owner = (EntityEnderColossus)entity1;
                ++this.owner.numOfCrystals;
            }
        }
    }

    private boolean isCourseTraversable(double p_70790_1_, double p_70790_3_, double p_70790_5_, double p_70790_7_) {
        double d4 = (this.waypointX - this.posX) / p_70790_7_;
        double d5 = (this.waypointY - this.posY) / p_70790_7_;
        double d6 = (this.waypointZ - this.posZ) / p_70790_7_;
        AxisAlignedBB axisalignedbb = this.boundingBox.copy();
        int i = 1;
        while ((double)i < p_70790_7_) {
            axisalignedbb.offset(d4, d5, d6);
            if (!this.worldObj.getCollidingBoundingBoxes((Entity)this, axisalignedbb).isEmpty()) {
                return false;
            }
            ++i;
        }
        return true;
    }

    private void updateEnderColossusEnderCrystal() {
        if (this.owner != null) {
            if (this.isDead) {
                this.owner.attackEntityFromPart(this.owner.rightEye, new DamageSource("blindness").setDamageBypassesArmor().setDamageIsAbsolute(), 1000.0f);
                this.owner.hurtResistantTime = 0;
                this.owner.attackEntityFromPart(this.owner.leftEye, new DamageSource("blindness").setDamageBypassesArmor().setDamageIsAbsolute(), 1000.0f);
                this.owner.hurtResistantTime = 0;
                if (!this.owner.isStunned) {
                    ++this.owner.destroyedCrystals;
                }
                this.owner = null;
            } else if (this.isEntityAlive() && !this.owner.isStunned) {
                this.owner.heal(2.0f);
            }
        }
        if (this.owner == null && this.rand.nextInt(10) == 0) {
            float f = 256.0f;
            List<EntityEnderColossus> list = this.worldObj.getEntitiesWithinAABB(EntityEnderColossus.class, this.boundingBox.expand((double)f, (double)f, (double)f));
            EntityEnderColossus entityendercrystal = null;
            double d0 = Double.MAX_VALUE;
            for (EntityEnderColossus entityendercrystal1 : list) {
                double d1 = entityendercrystal1.getDistanceSqToEntity((Entity)this);
                if (!(d1 < d0)) continue;
                d0 = d1;
                entityendercrystal = entityendercrystal1;
            }
            this.owner = entityendercrystal;
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source.getEntity() instanceof EntityEndermanMinion || source.getEntity() instanceof EntityEnderColossus || source.getEntity() instanceof EntityDragon || source.getEntity() instanceof EntityEnderColossusCrystal || source.getEntity() instanceof EntityDragonMinion) {
            return false;
        }
        if (source.isExplosion() || source.isFireDamage()) {
            this.onGround = true;
        }
        return super.attackEntityFrom(source, amount);
    }

    protected String getHurtSound() {
        return "mob.irongolem.hit";
    }

    protected String getDeathSound() {
        return "mob.irongolem.death";
    }

    @Override
    public EnumMinionType getMinionType() {
        return EnumMinionType.SPECIAL;
    }
}

