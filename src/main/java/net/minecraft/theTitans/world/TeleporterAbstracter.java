/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.LongHashMap
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.ChunkCoordIntPair
 *  net.minecraft.world.Teleporter
 *  net.minecraft.world.Teleporter$PortalPosition
 *  net.minecraft.world.WorldServer
 */
package net.minecraft.theTitans.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterAbstracter
extends Teleporter {
    private final WorldServer worldServerInstance;
    private final Random random;
    private final LongHashMap destinationCoordinateCache = new LongHashMap();
    private final List destinationCoordinateKeys = new ArrayList();

    public TeleporterAbstracter(WorldServer par1WorldServer) {
        super(par1WorldServer);
        this.worldServerInstance = par1WorldServer;
        this.random = new Random(par1WorldServer.getSeed());
    }

    public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
        if (this.worldServerInstance.provider.dimensionId != 1) {
            if (!this.placeInExistingPortal(par1Entity, par2, par4, par6, par8)) {
                this.makePortal(par1Entity);
                this.placeInExistingPortal(par1Entity, par2, par4, par6, par8);
            }
        } else {
            int i = MathHelper.floor_double((double)par1Entity.posX);
            int j = MathHelper.floor_double((double)par1Entity.posY) - 1;
            int k = MathHelper.floor_double((double)par1Entity.posZ);
            int b0 = 1;
            int b1 = 0;
            for (int l = -2; l <= 2; ++l) {
                for (int i1 = -2; i1 <= 2; ++i1) {
                    for (int j1 = -1; j1 < 3; ++j1) {
                        int k1 = i + i1 * b0 + l * b1;
                        int l1 = j + j1;
                        int i2 = k + i1 * b1 - l * b0;
                        boolean bl = j1 < 0;
                    }
                }
            }
            par1Entity.setLocationAndAngles((double)i, (double)j, (double)k, par1Entity.rotationYaw, 0.0f);
            par1Entity.motionZ = 0.0;
            par1Entity.motionY = 0.0;
            par1Entity.motionX = 0.0;
        }
    }

    public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
        int k1;
        int short1 = 128;
        double d3 = -1.0;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = MathHelper.floor_double((double)par1Entity.posX);
        int i1 = MathHelper.floor_double((double)par1Entity.posZ);
        long j1 = ChunkCoordIntPair.chunkXZ2Int((int)l, (int)i1);
        boolean flag = true;
        if (this.destinationCoordinateCache.containsItem(j1)) {
            Teleporter.PortalPosition portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.getValueByKey(j1);
            d3 = 0.0;
            i = portalposition.posX;
            j = portalposition.posY;
            k = portalposition.posZ;
            portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag = false;
        } else {
            for (k1 = l - short1; k1 <= l + short1; ++k1) {
                double d5 = (double)k1 + 0.5 - par1Entity.posX;
                for (int l1 = i1 - short1; l1 <= i1 + short1; ++l1) {
                    double d6 = (double)l1 + 0.5 - par1Entity.posZ;
                    for (int i2 = this.worldServerInstance.getActualHeight() - 1; i2 >= 0; --i2) {
                    }
                }
            }
        }
        if (d3 >= 0.0) {
            if (flag) {
                this.destinationCoordinateCache.add(j1, (Object)this.new PortalPosition(i, j, k, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(j1);
            }
            double d8 = (double)i + 0.5;
            double d9 = (double)j + 0.5;
            double d4 = (double)k + 0.5;
            int j2 = -1;
            int k2 = par1Entity.getTeleportDirection();
            if (j2 > -1) {
                boolean flag2;
                int i3 = Direction.offsetX[j2];
                int l2 = Direction.rotateLeft[j2];
                int k3 = Direction.offsetX[l2];
                int j3 = Direction.offsetZ[j2];
                int l3 = Direction.offsetZ[l2];
                boolean flag1 = !this.worldServerInstance.isAirBlock(i + i3 + k3, j, k + j3 + l3) || !this.worldServerInstance.isAirBlock(i + i3 + k3, j + 1, k + j3 + l3);
                boolean bl = flag2 = !this.worldServerInstance.isAirBlock(i + i3, j, k + j3) || !this.worldServerInstance.isAirBlock(i + i3, j + 1, k + j3);
                if (flag1 && flag2) {
                    j2 = Direction.rotateOpposite[j2];
                    l2 = Direction.rotateOpposite[l2];
                    i3 = Direction.offsetX[j2];
                    j3 = Direction.offsetZ[j2];
                    k3 = Direction.offsetX[l2];
                    l3 = Direction.offsetZ[l2];
                    k1 = i - k3;
                    d8 -= (double)k3;
                    int i4 = k - l3;
                    d4 -= (double)l3;
                    flag1 = !this.worldServerInstance.isAirBlock(k1 + i3 + k3, j, i4 + j3 + l3) || !this.worldServerInstance.isAirBlock(k1 + i3 + k3, j + 1, i4 + j3 + l3);
                    flag2 = !this.worldServerInstance.isAirBlock(k1 + i3, j, i4 + j3) || !this.worldServerInstance.isAirBlock(k1 + i3, j + 1, i4 + j3);
                }
                float f1 = 0.5f;
                float f2 = 0.5f;
                if (!flag1 && flag2) {
                    f1 = 1.0f;
                } else if (flag1 && !flag2) {
                    f1 = 0.0f;
                } else if (flag1 && flag2) {
                    f2 = 0.0f;
                }
                d8 += (double)((float)k3 * f1 + f2 * (float)i3);
                d4 += (double)((float)l3 * f1 + f2 * (float)j3);
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                float f6 = 0.0f;
                if (j2 == k2) {
                    f3 = 1.0f;
                    f4 = 1.0f;
                } else if (j2 == Direction.rotateOpposite[k2]) {
                    f3 = -1.0f;
                    f4 = -1.0f;
                } else if (j2 == Direction.rotateRight[k2]) {
                    f5 = 1.0f;
                    f6 = -1.0f;
                } else {
                    f5 = -1.0f;
                    f6 = 1.0f;
                }
                double d10 = par1Entity.motionX;
                double d11 = par1Entity.motionZ;
                par1Entity.motionX = d10 * (double)f3 + d11 * (double)f6;
                par1Entity.motionZ = d10 * (double)f5 + d11 * (double)f4;
                par1Entity.rotationYaw = par8 - (float)(k2 * 90) + (float)(j2 * 90);
            } else {
                par1Entity.motionZ = 0.0;
                par1Entity.motionY = 0.0;
                par1Entity.motionX = 0.0;
            }
            par1Entity.setLocationAndAngles(d8, d9, d4, par1Entity.rotationYaw, par1Entity.rotationPitch);
            return true;
        }
        return false;
    }

    public boolean makePortal(Entity par1Entity) {
        boolean flag;
        double d3;
        double d4;
        int j4;
        int k4;
        int l3;
        int i4;
        int j3;
        int k3;
        int l2;
        int i3;
        int k2;
        double d2;
        int j2;
        double d1;
        int i2;
        int b0 = 16;
        double d0 = -1.0;
        int i = MathHelper.floor_double((double)par1Entity.posX);
        int j = MathHelper.floor_double((double)par1Entity.posY);
        int k = MathHelper.floor_double((double)par1Entity.posZ);
        int l = i;
        int i1 = j;
        int j1 = k;
        int k1 = 0;
        int l1 = this.random.nextInt(4);
        for (i2 = i - b0; i2 <= i + b0; ++i2) {
            d1 = (double)i2 + 0.5 - par1Entity.posX;
            for (j2 = k - b0; j2 <= k + b0; ++j2) {
                d2 = (double)j2 + 0.5 - par1Entity.posZ;
                block2: for (k2 = this.worldServerInstance.getActualHeight() - 1; k2 >= 0; --k2) {
                    if (!this.worldServerInstance.isAirBlock(i2, k2, j2)) continue;
                    while (k2 > 0 && this.worldServerInstance.isAirBlock(i2, k2 - 1, j2)) {
                        --k2;
                    }
                    for (i3 = l1; i3 < l1 + 4; ++i3) {
                        l2 = i3 % 2;
                        k3 = 1 - l2;
                        if (i3 % 4 >= 2) {
                            l2 = -l2;
                            k3 = -k3;
                        }
                        for (j3 = 0; j3 < 3; ++j3) {
                            for (i4 = 0; i4 < 4; ++i4) {
                                for (l3 = -1; l3 < 4; ++l3) {
                                    k4 = i2 + (i4 - 1) * l2 + j3 * k3;
                                    j4 = k2 + l3;
                                    int l4 = j2 + (i4 - 1) * k3 - j3 * l2;
                                    if (l3 < 0 && !this.worldServerInstance.getBlock(k4, j4, l4).getMaterial().isSolid() || l3 >= 0 && !this.worldServerInstance.isAirBlock(k4, j4, l4)) continue block2;
                                }
                            }
                        }
                        d4 = (double)k2 + 0.5 - par1Entity.posY;
                        d3 = d1 * d1 + d4 * d4 + d2 * d2;
                        if (!(d0 < 0.0) && !(d3 < d0)) continue;
                        d0 = d3;
                        l = i2;
                        i1 = k2;
                        j1 = j2;
                        k1 = i3 % 4;
                    }
                }
            }
        }
        if (d0 < 0.0) {
            for (i2 = i - b0; i2 <= i + b0; ++i2) {
                d1 = (double)i2 + 0.5 - par1Entity.posX;
                for (j2 = k - b0; j2 <= k + b0; ++j2) {
                    d2 = (double)j2 + 0.5 - par1Entity.posZ;
                    block10: for (k2 = this.worldServerInstance.getActualHeight() - 1; k2 >= 0; --k2) {
                        if (!this.worldServerInstance.isAirBlock(i2, k2, j2)) continue;
                        while (k2 > 0 && this.worldServerInstance.isAirBlock(i2, k2 - 1, j2)) {
                            --k2;
                        }
                        for (i3 = l1; i3 < l1 + 2; ++i3) {
                            l2 = i3 % 2;
                            k3 = 1 - l2;
                            for (j3 = 0; j3 < 4; ++j3) {
                                for (i4 = -1; i4 < 4; ++i4) {
                                    l3 = i2 + (j3 - 1) * l2;
                                    k4 = k2 + i4;
                                    j4 = j2 + (j3 - 1) * k3;
                                    if (i4 < 0 && !this.worldServerInstance.getBlock(l3, k4, j4).getMaterial().isSolid() || i4 >= 0 && !this.worldServerInstance.isAirBlock(l3, k4, j4)) continue block10;
                                }
                            }
                            d4 = (double)k2 + 0.5 - par1Entity.posY;
                            d3 = d1 * d1 + d4 * d4 + d2 * d2;
                            if (!(d0 < 0.0) && !(d3 < d0)) continue;
                            d0 = d3;
                            l = i2;
                            i1 = k2;
                            j1 = j2;
                            k1 = i3 % 2;
                        }
                    }
                }
            }
        }
        int i5 = l;
        int j5 = i1;
        j2 = j1;
        int k5 = k1 % 2;
        int l5 = 1 - k5;
        if (k1 % 4 >= 2) {
            k5 = -k5;
            l5 = -l5;
        }
        if (d0 < 0.0) {
            if (i1 < 70) {
                i1 = 70;
            }
            if (i1 > this.worldServerInstance.getActualHeight() - 10) {
                i1 = this.worldServerInstance.getActualHeight() - 10;
            }
            j5 = i1;
            for (k2 = -1; k2 <= 1; ++k2) {
                for (i3 = 1; i3 < 3; ++i3) {
                    for (l2 = -1; l2 < 3; ++l2) {
                        k3 = i5 + (i3 - 1) * k5 + k2 * l5;
                        j3 = j5 + l2;
                        i4 = j2 + (i3 - 1) * l5 - k2 * k5;
                        flag = l2 < 0;
                    }
                }
            }
        }
        for (k2 = 0; k2 < 4; ++k2) {
            for (i3 = 0; i3 < 4; ++i3) {
                for (l2 = -1; l2 < 4; ++l2) {
                    k3 = i5 + (i3 - 1) * k5;
                    j3 = j5 + l2;
                    i4 = j2 + (i3 - 1) * l5;
                    flag = i3 == 0 || i3 == 3 || l2 == -1 || l2 == 3;
                }
            }
            for (i3 = 0; i3 < 4; ++i3) {
                for (l2 = -1; l2 < 4; ++l2) {
                    k3 = i5 + (i3 - 1) * k5;
                    j3 = j5 + l2;
                    i4 = j2 + (i3 - 1) * l5;
                }
            }
        }
        return true;
    }

    public void removeStalePortalLocations(long par1) {
        if (par1 % 100L == 0L) {
            Iterator iterator = this.destinationCoordinateKeys.iterator();
            long j = par1 - 600L;
            while (iterator.hasNext()) {
                Long olong = (Long)iterator.next();
                Teleporter.PortalPosition portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.getValueByKey(olong.longValue());
                if (portalposition != null && portalposition.lastUpdateTime >= j) continue;
                iterator.remove();
                this.destinationCoordinateCache.remove(olong.longValue());
            }
        }
    }
}

