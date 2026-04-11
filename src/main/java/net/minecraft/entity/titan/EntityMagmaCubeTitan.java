/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.monster.EntityMagmaCube
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.titan.EntitySlimeTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityMagmaCubeTitan
extends EntitySlimeTitan {
    public EntityMagmaCubeTitan(World worldIn) {
        super(worldIn);
        this.shouldParticlesBeUpward = true;
    }

    @Override
    protected void applyEntityAI() {
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.MagmaCubeTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    @Override
    protected String getSlimeParticle() {
        return "flame";
    }

    @Override
    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != EntityMagmaCube.class && p_70686_1_ != EntityMagmaCubeTitan.class;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(50) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.MagmaCubeTitanMinionSpawnrate;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public boolean handleLavaMovement() {
        return false;
    }

    @Override
    protected boolean makesSoundOnLand() {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 0xF000F0;
    }

    public float getBrightness(float p_70013_1_) {
        return 1.0f;
    }

    @Override
    protected String func_180487_n() {
        return "flame";
    }

    @Override
    protected EntitySlime createProtoInstance() {
        return new EntityMagmaCube(this.worldObj);
    }

    @Override
    protected EntitySlimeTitan createInstance() {
        return new EntityMagmaCubeTitan(this.worldObj);
    }

    @Override
    protected Item getDropItem() {
        return Items.magma_cream;
    }

    public boolean isBurning() {
        return false;
    }

    @Override
    protected int getJumpDelay() {
        return super.getJumpDelay() * 4;
    }

    @Override
    protected String getDeathSound() {
        return "mob.magmacube.jump";
    }

    @Override
    protected void alterSquishAmount() {
        this.squishAmount *= 0.95f;
    }

    @Override
    protected void jump() {
        this.motionY = 4.0 + (double)((float)this.getSlimeSize() * 0.33f);
        this.isAirBorne = true;
        if (this.getAttackTarget() != null) {
            double d01 = this.getAttackTarget().posX - this.posX;
            double d11 = this.getAttackTarget().posZ - this.posZ;
            float f21 = MathHelper.sqrt_double((double)(d01 * d01 + d11 * d11));
            double hor = 1.0 + (double)((float)this.getSlimeSize() * 0.25f);
            this.motionX = d01 / (double)f21 * hor * hor + this.motionX * hor;
            this.motionZ = d11 / (double)f21 * hor * hor + this.motionZ * hor;
        }
    }

    protected void func_180466_bG() {
        this.motionY = 2.5f + (float)this.getSlimeSize() * 0.05f;
        this.isAirBorne = true;
        if (this.getAttackTarget() != null) {
            double d01 = this.getAttackTarget().posX - this.posX;
            double d11 = this.getAttackTarget().posZ - this.posZ;
            float f21 = MathHelper.sqrt_double((double)(d01 * d01 + d11 * d11));
            double hor = 1.0 + (double)((float)this.getSlimeSize() * 0.25f);
            this.motionX = d01 / (double)f21 * hor * hor + this.motionX * hor;
            this.motionZ = d11 / (double)f21 * hor * hor + this.motionZ * hor;
        }
    }

    protected boolean canDamagePlayer() {
        return true;
    }

    @Override
    protected int getAttackStrength() {
        if (TheTitans.NightmareMode) {
            return this.getSlimeSize() * 180;
        }
        return this.getSlimeSize() * 60;
    }

    @Override
    protected String getJumpSound() {
        return "mob.magmacube.big";
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (source.isFireDamage()) {
            this.heal(amount);
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }
}

