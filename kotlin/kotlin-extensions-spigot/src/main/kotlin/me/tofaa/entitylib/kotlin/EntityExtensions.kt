package me.tofaa.entitylib.kotlin

import com.github.retrooper.packetevents.wrapper.PacketWrapper
import io.github.retrooper.packetevents.util.SpigotConversionUtil
import me.tofaa.entitylib.EntityLib
import me.tofaa.entitylib.EntityLibAPI
import me.tofaa.entitylib.Platform
import me.tofaa.entitylib.spigot.SpigotEntityLibAPI
import me.tofaa.entitylib.wrapper.WrapperEntity
import me.tofaa.entitylib.wrapper.WrapperEntityEquipment
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

fun JavaPlugin.getEntityLibApi(): EntityLibAPI<SpigotEntityLibAPI> {
    return EntityLib.getApi<SpigotEntityLibAPI>()!!
}

fun JavaPlugin.getEntityLibPlatform(): Platform<*> {
    return EntityLib.getPlatform()!!
}

fun WrapperEntity.asBukkitEntity(location: Location): Entity {
    val world = location.world ?: throw IllegalArgumentException("Location world is null");
    val entity = world.spawnEntity(location, SpigotConversionUtil.toBukkitEntityType(this.entityType));
    // TODO: Copy entity data
    return entity;
}

fun WrapperEntity.sendPacketToViewersAndCallback(packet: PacketWrapper<*>, callback: () -> Unit) {
    this.sendPacketsToViewers(packet);
    callback();
}

fun WrapperEntity.sendPacketsToViewersAndCallback(vararg packets: PacketWrapper<*>, callback: () -> Unit) {
    this.sendPacketsToViewers(*packets);
    callback();
}

fun Entity.asWrapperEntity(location: Location): WrapperEntity {
    return EntityLib.getApi<SpigotEntityLibAPI>().cloneEntity(this, SpigotConversionUtil.fromBukkitLocation(location));
}

fun Entity.asWrapperEntity(): WrapperEntity {
    return asWrapperEntity(this.location);
}

fun WrapperEntityEquipment.setMainHand(stack: ItemStack) {
    this.mainHand = SpigotConversionUtil.fromBukkitItemStack(stack);
}

fun WrapperEntityEquipment.setOffHand(stack: ItemStack) {
    this.offhand = SpigotConversionUtil.fromBukkitItemStack(stack);
}

fun WrapperEntityEquipment.setHelmet(stack: ItemStack) {
    this.helmet = SpigotConversionUtil.fromBukkitItemStack(stack);
}

fun WrapperEntityEquipment.setChestplate(stack: ItemStack) {
    this.chestplate = SpigotConversionUtil.fromBukkitItemStack(stack);
}

fun WrapperEntityEquipment.setLeggings(stack: ItemStack) {
    this.leggings = SpigotConversionUtil.fromBukkitItemStack(stack);
}

fun WrapperEntityEquipment.setBoots(stack: ItemStack) {
    this.boots = SpigotConversionUtil.fromBukkitItemStack(stack);
}