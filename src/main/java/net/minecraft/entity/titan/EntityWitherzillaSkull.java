package net.minecraft.entity.titan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityWitherzillaSkull extends EntityWitherSkull {
    public EntityWitherzillaSkull(World world) {
        super(world);
    }

    public EntityWitherzillaSkull(World world, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
        super(world, shooter, accelX, accelY, accelZ);
    }

    @Override
    protected void onImpact(MovingObjectPosition mop) {
        if (this.worldObj.isRemote) {
            this.setDead();
            return;
        }

        EntityLivingBase shooter = this.shootingEntity;
        DamageSource source = shooter != null ? DamageSource.causeMobDamage(shooter) : DamageSource.magic;

        if (mop.entityHit != null && mop.entityHit != shooter) {
            mop.entityHit.attackEntityFrom(source, 18.0F);
            if (mop.entityHit instanceof EntityLivingBase) {
                ((EntityLivingBase)mop.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, 200, 2));
            }
        }

        AxisAlignedBB box = this.boundingBox.expand(4.0D, 2.0D, 4.0D);
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, box);
        for (int i = 0; i < list.size(); ++i) {
            Entity e = (Entity)list.get(i);
            if (e == null || e == shooter || e == mop.entityHit || !e.isEntityAlive()) {
                continue;
            }
            if (e instanceof EntityWitherzilla || e instanceof EntityWitherzillaMinion || e instanceof EntityWitherTurret || e instanceof EntityWitherTurretGround || e instanceof EntityWitherTurretMortar) {
                continue;
            }
            double distSq = this.getDistanceSqToEntity(e);
            if (distSq > 36.0D) {
                continue;
            }
            float dmg = distSq < 9.0D ? 12.0F : 8.0F;
            e.attackEntityFrom(source, dmg);
            if (e instanceof EntityLivingBase) {
                ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.wither.id, 100, 1));
            }
        }

        this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0F, 0.8F + this.rand.nextFloat() * 0.2F);
        for (int i = 0; i < 12; ++i) {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.rand.nextGaussian() * 0.1D, this.rand.nextGaussian() * 0.1D, this.rand.nextGaussian() * 0.1D);
        }
        this.setDead();
    }
}
