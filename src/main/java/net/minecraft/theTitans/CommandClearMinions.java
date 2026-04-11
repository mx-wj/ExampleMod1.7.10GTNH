/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.command.CommandBase
 *  net.minecraft.command.ICommandSender
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.item.EntityFallingBlock
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.ChatComponentTranslation
 *  net.minecraft.util.IChatComponent
 */
package net.minecraft.theTitans;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titanminion.ITemplar;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class CommandClearMinions
extends CommandBase {
    public String getCommandName() {
        return "clearMinions";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "commands.killminions.usage";
    }

    public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) {
        EntityPlayerMP entityplayermp = CommandClearMinions.getCommandSenderAsPlayer((ICommandSender)p_71515_1_);
        p_71515_1_.addChatMessage((IChatComponent)new ChatComponentTranslation("commands.killminions.processing", new Object[0]));
        List list = entityplayermp.worldObj.loadedEntityList;
        if (list != null && !list.isEmpty()) {
            for (int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity = (Entity)list.get(i1);
                if (entity == null || (entity.isEntityAlive() || entity instanceof EntityTitan || entity instanceof EntityTitanSpirit) && entity.getClass() != (Class)EntityList.stringToClassMapping.get("MutantCreatures.SpiderPig") && entity.getClass() != (Class)EntityList.stringToClassMapping.get("Scorpion") && entity.getClass() != (Class)EntityList.stringToClassMapping.get("PurplePower") && !(entity instanceof ITemplar) && !(entity instanceof EntitySlime) && !(entity instanceof EntityFallingBlock) && !(entity instanceof EntityHarcadiumArrow) && !(entity instanceof EntityArrow) && !(entity instanceof EntityFireball) && !(entity instanceof EntityTNTPrimed) && !(entity instanceof EntityItem) && !(entity instanceof EntityXPOrb) && !(entity instanceof EntityThrowable)) continue;
                entity.setDead();
                entity.isDead = true;
            }
        }
        p_71515_1_.addChatMessage((IChatComponent)new ChatComponentTranslation("commands.killminions.success", new Object[0]));
    }
}

