/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 */
package net.minecraft.theTitans;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoundHandler {
    public static void onEntityPlay(String name, World world, Entity entityName, float volume, float pitch) {
        world.playSoundAtEntity(entityName, "thetitans:" + name, volume, pitch);
    }
}

