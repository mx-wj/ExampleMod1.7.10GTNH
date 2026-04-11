/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package net.minecraft.entity.titan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityWebShot;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EntityCaveSpiderMinion;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;

public class EntityCaveSpiderTitan
extends EntitySpiderTitan {
    public boolean isSubdued;

    public EntityCaveSpiderTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 5.6f, 5.6f);
        this.thorax = new EntityTitanPart(worldIn, this, "thorax", 4.2f, 4.2f);
        this.abdomen = new EntityTitanPart(worldIn, this, "abdomen", 8.4f, 5.6f);
        this.rightlegs = new EntityTitanPart(worldIn, this, "rightleg", 8.4f, 5.6f);
        this.leftlegs = new EntityTitanPart(worldIn, this, "leftleg", 8.4f, 5.6f);
        this.partArray = new EntityTitanPart[]{this.head, this.thorax, this.abdomen, this.rightlegs, this.leftlegs};
        this.setSize(16.0f, 10.0f);
        this.experienceValue = 9000 + this.getExtraPower() * 350;
        worldIn.spawnEntityInWorld((Entity)this.head);
        worldIn.spawnEntityInWorld((Entity)this.thorax);
        worldIn.spawnEntityInWorld((Entity)this.abdomen);
        worldIn.spawnEntityInWorld((Entity)this.rightlegs);
        worldIn.spawnEntityInWorld((Entity)this.leftlegs);
    }

    @Override
    protected void applyEntityAI() {
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        if (TheTitans.TitansFFAMode) {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.CaveSpiderTitanSorter));
        } else {
            this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }
    }

    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.setPosition(this.posX, this.posY + (8.8 + (double)this.getExtraPower() * 0.1), this.posZ);
        }
    }

    @Override
    public int getMinionCap() {
        return 180;
    }

    @Override
    public int getPriestCap() {
        return 80;
    }

    @Override
    public int getZealotCap() {
        return 20;
    }

    @Override
    public int getTemplarCap() {
        return 4;
    }

    protected boolean isMovementBlocked() {
        return this.isSubdued && this.riddenByEntity == null ? true : super.isMovementBlocked();
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.isSubdued = tagCompund.getBoolean("Subdued");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("Subdued", this.isSubdued);
    }

    @Override
    public boolean canBeCollidedWith() {
        return this.isStunned || this.isSubdued;
    }

    @Override
    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && this.getAttackTarget() != null ? super.shouldMove() : false;
    }

    @Override
    public double getSpeed() {
        return (this.getBonusID() == 1 ? 0.65 : 0.6) + (double)this.getExtraPower() * 0.001;
    }

    @Override
    public boolean canAttackClass(Class p_70686_1_) {
        return p_70686_1_ != ((Object)((Object)this.head)).getClass() && p_70686_1_ != ((Object)((Object)this.thorax)).getClass() && p_70686_1_ != ((Object)((Object)this.abdomen)).getClass() && p_70686_1_ != ((Object)((Object)this.rightlegs)).getClass() && p_70686_1_ != ((Object)((Object)this.leftlegs)).getClass() && p_70686_1_ != EntityWebShot.class && p_70686_1_ != EntityCaveSpiderMinion.class && p_70686_1_ != EntityCaveSpiderTitan.class;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(50) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    @Override
    public int getMinionSpawnRate() {
        return TheTitans.CaveSpiderTitanMinionSpawnrate;
    }

    @Override
    public void attackChoosenEntity(Entity damagedEntity, float damage, int knockbackAmount) {
        super.attackChoosenEntity(damagedEntity, damage, knockbackAmount);
        if (damagedEntity instanceof EntityLivingBase) {
            ((EntityLivingBase)damagedEntity).addPotionEffect(new PotionEffect(Potion.poison.id, 800, 3));
        }
    }

    @Override
    public float getEyeHeight() {
        return 7.28f;
    }

    public boolean interact(EntityPlayer p_70085_1_) {
        ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();
        p_70085_1_.swingItem();
        if (this.isStunned && !this.isSubdued) {
            if (itemstack != null && itemstack.getItem() == Items.golden_apple) {
                this.isSubdued = true;
                this.worldObj.playSoundAtEntity((Entity)this, "random.levelup", 10.0f, 1.0f);
                p_70085_1_.addChatMessage((IChatComponent)new ChatComponentText(this.getCustomNameTag() + " has been subdued by " + p_70085_1_.getCommandSenderName()));
                return super.interact(p_70085_1_);
            }
        } else if (this.isSubdued) {
            if (itemstack == null && p_70085_1_.ridingEntity == null) {
                p_70085_1_.mountEntity((Entity)this);
            } else if (itemstack != null) {
                if (itemstack.getItem() == Items.cooked_chicken) {
                    AnimationAPI.sendAnimPacket(this, 3);
                    this.setAnimID(3);
                }
                if (itemstack.getItem() == Items.bone) {
                    AnimationAPI.sendAnimPacket(this, 9);
                    this.setAnimID(9);
                }
            }
        }
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }

    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase && this.isSubdued) {
            this.setAttackTarget(null);
            this.rotationPitch = this.riddenByEntity.rotationPitch;
            this.rotationYawHead = ((EntityLivingBase)this.riddenByEntity).rotationYawHead;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            p_70612_1_ = ((EntityLivingBase)this.riddenByEntity).moveStrafing;
            p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward;
            if (((EntityLivingBase)this.riddenByEntity).moveForward > 0.0f) {
                this.addVelocity((double)(-MathHelper.sin((float)(((EntityLivingBase)this.riddenByEntity).rotationYawHead * (float)Math.PI / 180.0f))) * this.getSpeed(), 0.0, (double)MathHelper.cos((float)(((EntityLivingBase)this.riddenByEntity).rotationYawHead * (float)Math.PI / 180.0f)) * this.getSpeed());
            }
            if (((EntityLivingBase)this.riddenByEntity).moveForward < 0.0f) {
                this.addVelocity((double)(-MathHelper.sin((float)(((EntityLivingBase)this.riddenByEntity).rotationYawHead * (float)Math.PI / 180.0f))) * -this.getSpeed(), 0.0, (double)MathHelper.cos((float)(((EntityLivingBase)this.riddenByEntity).rotationYawHead * (float)Math.PI / 180.0f)) * -this.getSpeed());
            }
            if (this.onGround && ((EntityLivingBase)this.riddenByEntity).rotationPitch < -80.0f) {
                this.jump();
            }
            if (!this.worldObj.isRemote) {
                super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
            }
            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f4 = MathHelper.sqrt_double((double)(d1 * d1 + d0 * d0)) * 4.0f;
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4f;
            this.limbSwing += this.limbSwingAmount;
        } else {
            super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
        }
    }
}

