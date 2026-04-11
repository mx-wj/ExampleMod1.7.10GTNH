/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.BlockDirectional
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IIcon
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityGargoyle;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMagicPumpkin
extends BlockDirectional {
    private boolean field_149985_a;
    @SideOnly(value=Side.CLIENT)
    private IIcon field_149984_b;
    @SideOnly(value=Side.CLIENT)
    private IIcon field_149986_M;

    public BlockMagicPumpkin(boolean p_i45419_1_) {
        super(Material.gourd);
        this.setTickRandomly(true);
        this.field_149985_a = p_i45419_1_;
        this.setCreativeTab(TheTitans.titansTab);
    }

    @SideOnly(value=Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return p_149691_1_ == 1 ? this.field_149984_b : (p_149691_1_ == 0 ? this.field_149984_b : (p_149691_2_ == 2 && p_149691_1_ == 2 ? this.field_149986_M : (p_149691_2_ == 3 && p_149691_1_ == 5 ? this.field_149986_M : (p_149691_2_ == 0 && p_149691_1_ == 3 ? this.field_149986_M : (p_149691_2_ == 1 && p_149691_1_ == 4 ? this.field_149986_M : this.blockIcon)))));
    }

    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        EntityPlayer player = p_149726_1_.getClosestPlayer((double)p_149726_2_, (double)p_149726_3_, (double)p_149726_4_, 16.0);
        if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.iron_block && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.redstone_block) {
            boolean flag1;
            boolean flag = p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_) == Blocks.stone && p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_) == Blocks.stone;
            boolean bl = flag1 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1) == Blocks.stone && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1) == Blocks.stone;
            if (flag || flag1) {
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                if (flag) {
                    p_149726_1_.setBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                } else {
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                }
                EntityGargoyle entityirongolem = new EntityGargoyle(p_149726_1_);
                entityirongolem.setPlayerCreated(true);
                entityirongolem.setGargoyleType(0);
                entityirongolem.setLocationAndAngles((double)p_149726_2_ + 0.5, (double)p_149726_3_ - 1.95, (double)p_149726_4_ + 0.5, player != null ? player.rotationYaw + 180.0f : 0.0f, 0.0f);
                entityirongolem.rotationYawHead = entityirongolem.rotationYaw;
                entityirongolem.waypointX = p_149726_2_;
                entityirongolem.waypointY = (double)p_149726_3_ - 3.0;
                entityirongolem.waypointZ = p_149726_4_;
                p_149726_1_.spawnEntityInWorld((Entity)entityirongolem);
                for (int l = 0; l < 120; ++l) {
                    p_149726_1_.spawnParticle("snowballpoof", (double)p_149726_2_ + p_149726_1_.rand.nextDouble(), (double)(p_149726_3_ - 2) + p_149726_1_.rand.nextDouble() * 3.9, (double)p_149726_4_ + p_149726_1_.rand.nextDouble(), 0.0, 0.0, 0.0);
                }
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                if (flag) {
                    p_149726_1_.notifyBlockChange(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                } else {
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0));
                }
            }
        } else if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.sandstone && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.redstone_block) {
            boolean flag1;
            boolean flag = p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_) == Blocks.sandstone && p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_) == Blocks.sandstone;
            boolean bl = flag1 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1) == Blocks.sandstone && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1) == Blocks.sandstone;
            if (flag || flag1) {
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                if (flag) {
                    p_149726_1_.setBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                } else {
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                }
                EntityGargoyle entityirongolem = new EntityGargoyle(p_149726_1_);
                entityirongolem.setPlayerCreated(true);
                entityirongolem.setGargoyleType(1);
                entityirongolem.setLocationAndAngles((double)p_149726_2_ + 0.5, (double)p_149726_3_ - 1.95, (double)p_149726_4_ + 0.5, player != null ? player.rotationYaw + 180.0f : 0.0f, 0.0f);
                entityirongolem.rotationYawHead = entityirongolem.rotationYaw;
                entityirongolem.waypointX = p_149726_2_;
                entityirongolem.waypointY = (double)p_149726_3_ - 3.0;
                entityirongolem.waypointZ = p_149726_4_;
                p_149726_1_.spawnEntityInWorld((Entity)entityirongolem);
                for (int l = 0; l < 120; ++l) {
                    p_149726_1_.spawnParticle("snowballpoof", (double)p_149726_2_ + p_149726_1_.rand.nextDouble(), (double)(p_149726_3_ - 2) + p_149726_1_.rand.nextDouble() * 3.9, (double)p_149726_4_ + p_149726_1_.rand.nextDouble(), 0.0, 0.0, 0.0);
                }
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                if (flag) {
                    p_149726_1_.notifyBlockChange(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                } else {
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0));
                }
            }
        } else if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.obsidian && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.diamond_block) {
            boolean flag1;
            boolean flag = p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_) == Blocks.obsidian && p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_) == Blocks.obsidian;
            boolean bl = flag1 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1) == Blocks.obsidian && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1) == Blocks.obsidian;
            if (flag || flag1) {
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                if (flag) {
                    p_149726_1_.setBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                } else {
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                }
                EntityGargoyle entityirongolem = new EntityGargoyle(p_149726_1_);
                entityirongolem.setPlayerCreated(true);
                entityirongolem.setGargoyleType(2);
                entityirongolem.setLocationAndAngles((double)p_149726_2_ + 0.5, (double)p_149726_3_ - 1.95, (double)p_149726_4_ + 0.5, player != null ? player.rotationYaw + 180.0f : 0.0f, 0.0f);
                entityirongolem.rotationYawHead = entityirongolem.rotationYaw;
                entityirongolem.waypointX = p_149726_2_;
                entityirongolem.waypointY = (double)p_149726_3_ - 3.0;
                entityirongolem.waypointZ = p_149726_4_;
                p_149726_1_.spawnEntityInWorld((Entity)entityirongolem);
                for (int l = 0; l < 120; ++l) {
                    p_149726_1_.spawnParticle("snowballpoof", (double)p_149726_2_ + p_149726_1_.rand.nextDouble(), (double)(p_149726_3_ - 2) + p_149726_1_.rand.nextDouble() * 3.9, (double)p_149726_4_ + p_149726_1_.rand.nextDouble(), 0.0, 0.0, 0.0);
                }
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                if (flag) {
                    p_149726_1_.notifyBlockChange(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                } else {
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0));
                }
            }
        } else if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.diamond_block && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.redstone_block) {
            boolean flag1;
            boolean flag = p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_) == Blocks.gold_block && p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_) == Blocks.gold_block;
            boolean bl = flag1 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1) == Blocks.gold_block && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1) == Blocks.gold_block;
            if (flag || flag1) {
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                if (flag) {
                    p_149726_1_.setBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                } else {
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                }
                EntityGargoyle entityirongolem = new EntityGargoyle(p_149726_1_);
                entityirongolem.setPlayerCreated(true);
                entityirongolem.setGargoyleType(3);
                entityirongolem.setLocationAndAngles((double)p_149726_2_ + 0.5, (double)p_149726_3_ - 1.95, (double)p_149726_4_ + 0.5, player != null ? player.rotationYaw + 180.0f : 0.0f, 0.0f);
                entityirongolem.rotationYawHead = entityirongolem.rotationYaw;
                entityirongolem.waypointX = p_149726_2_;
                entityirongolem.waypointY = (double)p_149726_3_ - 3.0;
                entityirongolem.waypointZ = p_149726_4_;
                p_149726_1_.spawnEntityInWorld((Entity)entityirongolem);
                for (int l = 0; l < 120; ++l) {
                    p_149726_1_.spawnParticle("snowballpoof", (double)p_149726_2_ + p_149726_1_.rand.nextDouble(), (double)(p_149726_3_ - 2) + p_149726_1_.rand.nextDouble() * 3.9, (double)p_149726_4_ + p_149726_1_.rand.nextDouble(), 0.0, 0.0, 0.0);
                }
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                if (flag) {
                    p_149726_1_.notifyBlockChange(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                } else {
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0));
                }
            }
        } else if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.iron_block && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.redstone_block) {
            boolean flag1;
            boolean flag = p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_) == Blocks.iron_block && p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_) == Blocks.iron_block;
            boolean bl = flag1 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1) == Blocks.iron_block && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1) == Blocks.iron_block;
            if (flag || flag1) {
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                if (flag) {
                    p_149726_1_.setBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                } else {
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                }
                EntityGargoyle entityirongolem = new EntityGargoyle(p_149726_1_);
                entityirongolem.setPlayerCreated(true);
                entityirongolem.setGargoyleType(4);
                entityirongolem.setLocationAndAngles((double)p_149726_2_ + 0.5, (double)p_149726_3_ - 1.95, (double)p_149726_4_ + 0.5, player != null ? player.rotationYaw + 180.0f : 0.0f, 0.0f);
                entityirongolem.rotationYawHead = entityirongolem.rotationYaw;
                entityirongolem.waypointX = p_149726_2_;
                entityirongolem.waypointY = (double)p_149726_3_ - 3.0;
                entityirongolem.waypointZ = p_149726_4_;
                p_149726_1_.spawnEntityInWorld((Entity)entityirongolem);
                for (int l = 0; l < 120; ++l) {
                    p_149726_1_.spawnParticle("snowballpoof", (double)p_149726_2_ + p_149726_1_.rand.nextDouble(), (double)(p_149726_3_ - 2) + p_149726_1_.rand.nextDouble() * 3.9, (double)p_149726_4_ + p_149726_1_.rand.nextDouble(), 0.0, 0.0, 0.0);
                }
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                if (flag) {
                    p_149726_1_.notifyBlockChange(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                } else {
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0));
                }
            }
        } else if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.obsidian && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.redstone_block) {
            boolean flag1;
            boolean flag = p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_) == Blocks.end_stone && p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_) == Blocks.end_stone;
            boolean bl = flag1 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1) == Blocks.end_stone && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1) == Blocks.end_stone;
            if (flag || flag1) {
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                if (flag) {
                    p_149726_1_.setBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                } else {
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                }
                EntityGargoyle entityirongolem = new EntityGargoyle(p_149726_1_);
                entityirongolem.setPlayerCreated(true);
                entityirongolem.setGargoyleType(5);
                entityirongolem.setLocationAndAngles((double)p_149726_2_ + 0.5, (double)p_149726_3_ - 1.95, (double)p_149726_4_ + 0.5, player != null ? player.rotationYaw + 180.0f : 0.0f, 0.0f);
                entityirongolem.rotationYawHead = entityirongolem.rotationYaw;
                entityirongolem.waypointX = p_149726_2_;
                entityirongolem.waypointY = (double)p_149726_3_ - 3.0;
                entityirongolem.waypointZ = p_149726_4_;
                p_149726_1_.spawnEntityInWorld((Entity)entityirongolem);
                for (int l = 0; l < 120; ++l) {
                    p_149726_1_.spawnParticle("snowballpoof", (double)p_149726_2_ + p_149726_1_.rand.nextDouble(), (double)(p_149726_3_ - 2) + p_149726_1_.rand.nextDouble() * 3.9, (double)p_149726_4_ + p_149726_1_.rand.nextDouble(), 0.0, 0.0, 0.0);
                }
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                if (flag) {
                    p_149726_1_.notifyBlockChange(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                } else {
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0));
                }
            }
        } else if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.gold_block && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.redstone_block) {
            boolean flag1;
            boolean flag = p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_) == Blocks.nether_brick && p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_) == Blocks.nether_brick;
            boolean bl = flag1 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1) == Blocks.nether_brick && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1) == Blocks.nether_brick;
            if (flag || flag1) {
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                if (flag) {
                    p_149726_1_.setBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                } else {
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0), 0, 2);
                }
                EntityGargoyle entityirongolem = new EntityGargoyle(p_149726_1_);
                entityirongolem.setPlayerCreated(true);
                entityirongolem.setGargoyleType(6);
                entityirongolem.setLocationAndAngles((double)p_149726_2_ + 0.5, (double)p_149726_3_ - 1.95, (double)p_149726_4_ + 0.5, player != null ? player.rotationYaw + 180.0f : 0.0f, 0.0f);
                entityirongolem.rotationYawHead = entityirongolem.rotationYaw;
                entityirongolem.waypointX = p_149726_2_;
                entityirongolem.waypointY = (double)p_149726_3_ - 3.0;
                entityirongolem.waypointZ = p_149726_4_;
                p_149726_1_.spawnEntityInWorld((Entity)entityirongolem);
                for (int l = 0; l < 120; ++l) {
                    p_149726_1_.spawnParticle("snowballpoof", (double)p_149726_2_ + p_149726_1_.rand.nextDouble(), (double)(p_149726_3_ - 2) + p_149726_1_.rand.nextDouble() * 3.9, (double)p_149726_4_ + p_149726_1_.rand.nextDouble(), 0.0, 0.0, 0.0);
                }
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 2, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                if (flag) {
                    p_149726_1_.notifyBlockChange(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, BlockMagicPumpkin.getBlockById((int)0));
                } else {
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, BlockMagicPumpkin.getBlockById((int)0));
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, BlockMagicPumpkin.getBlockById((int)0));
                }
            }
        }
    }

    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
        return p_149742_1_.getBlock(p_149742_2_, p_149742_3_, p_149742_4_).isReplaceable((IBlockAccess)p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && World.doesBlockHaveSolidTopSurface((IBlockAccess)p_149742_1_, (int)p_149742_2_, (int)(p_149742_3_ - 1), (int)p_149742_4_);
    }

    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
        int l = MathHelper.floor_double((double)((double)(p_149689_5_.rotationYaw * 4.0f / 360.0f) + 2.5)) & 3;
        p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, l, 2);
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        this.field_149986_M = p_149651_1_.registerIcon(this.getTextureName() + "_face_" + (this.field_149985_a ? "on" : "off"));
        this.field_149984_b = p_149651_1_.registerIcon(this.getTextureName() + "_top");
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
    }
}

