package org.cakepowered.mod.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.tileentity.*;
import org.cakepowered.api.enchantment.Enchantments;
import org.cakepowered.api.tileentity.TileEntities;

public class ApiFiller {

    public static void registerTileEntities() {
        TileEntities.BANNER = ForgeInterface.getTileEntity(new TileEntityBanner());
        TileEntities.COMMAND_BLOCK = ForgeInterface.getTileEntity(new TileEntityCommandBlock());
        TileEntities.COMPARATOR = ForgeInterface.getTileEntity(new TileEntityComparator());
        TileEntities.DAYLIGHT_DETECTOR = ForgeInterface.getTileEntity(new TileEntityDaylightDetector());
        TileEntities.ENCHANTMENT_TABLE = ForgeInterface.getTileEntity(new TileEntityEnchantmentTable());
        TileEntities.ENDER_CHEST = ForgeInterface.getTileEntity(new TileEntityEnderChest());
        TileEntities.END_PORTAL = ForgeInterface.getTileEntity(new TileEntityEndPortal());
        TileEntities.FLOWER_POT = ForgeInterface.getTileEntity(new TileEntityFlowerPot());
        TileEntities.BEACON = ForgeInterface.getTileEntity(new TileEntityBeacon());
        TileEntities.BREWING_STAND = ForgeInterface.getTileEntity(new TileEntityBrewingStand());
        TileEntities.CHEST = ForgeInterface.getTileEntity(new TileEntityChest());
        TileEntities.DISPENSER = ForgeInterface.getTileEntity(new TileEntityDispenser());
        TileEntities.DROPPER = ForgeInterface.getTileEntity(new TileEntityDropper());
        TileEntities.FURNACE = ForgeInterface.getTileEntity(new TileEntityFurnace());
        TileEntities.HOPPER = ForgeInterface.getTileEntity(new TileEntityHopper());
        TileEntities.SPAWNER = ForgeInterface.getTileEntity(new TileEntityMobSpawner());
        TileEntities.NOTEBLOCK = ForgeInterface.getTileEntity(new TileEntityNote());
        TileEntities.SIGN = ForgeInterface.getTileEntity(new TileEntitySign());
        TileEntities.SKULL = ForgeInterface.getTileEntity(new TileEntitySkull());
    }

    public static void registerEnchantments() {
        Enchantments.protection = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("protection"));
        Enchantments.fireProtection = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("fireProtection"));
        Enchantments.featherFalling = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("featherFalling"));
        Enchantments.blastProtection = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("blastProtection"));
        Enchantments.projectileProtection = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("projectileProtection"));
        Enchantments.respiration = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("respiration"));
        Enchantments.aquaAffinity = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("aquaAffinity"));
        Enchantments.thorns = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("thorns"));
        Enchantments.depthStrider = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("depthStrider"));
        Enchantments.sharpness = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("sharpness"));
        Enchantments.smite = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("smite"));
        Enchantments.baneOfArthropods = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("baneOfArthropods"));
        Enchantments.knockback = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("knockback"));
        Enchantments.fireAspect = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("fireAspect"));
        Enchantments.looting = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("looting"));
        Enchantments.efficiency = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("efficiency"));
        Enchantments.silkTouch = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("silkTouch"));
        Enchantments.unbreaking = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("unbreaking"));
        Enchantments.fortune = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("fortune"));
        Enchantments.power = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("power"));
        Enchantments.punch = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("punch"));
        Enchantments.flame = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("flame"));
        Enchantments.infinity = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("infinity"));
        Enchantments.luckOfTheSea = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("luckOfTheSea"));
        Enchantments.lure = ForgeInterface.getEnchantment(Enchantment.getEnchantmentByLocation("lure"));
    }
}
