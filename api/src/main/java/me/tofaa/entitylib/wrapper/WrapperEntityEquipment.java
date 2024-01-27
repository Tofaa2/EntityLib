package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.player.Equipment;
import com.github.retrooper.packetevents.protocol.player.EquipmentSlot;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityEquipment;
import me.tofaa.entitylib.EntityLib;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.tofaa.entitylib.extras.VersionChecker.verifyVersion;

public class WrapperEntityEquipment {

    private static final EquipmentSlot[] EQUIPMENT_SLOTS = EquipmentSlot.values();

    private final WrapperLivingEntity entity;


    // 0 = main hand, 1 = offhand, 2 = boots, 3 = leggings, 4 = chestplate, 5 = helmet
    private final ItemStack[] equipment = new ItemStack[6];

    public WrapperEntityEquipment(WrapperLivingEntity entity) {
        this.entity = entity;
        Arrays.fill(equipment, ItemStack.EMPTY);
    }

    public void setHelmet(@NotNull ItemStack itemStack) {
        equipment[5] = itemStack;
        refresh();
    }

    public void setChestplate(@NotNull ItemStack itemStack) {
        equipment[4] = itemStack;
        refresh();
    }

    public void setLeggings(@NotNull ItemStack itemStack) {
        equipment[3] = itemStack;
        refresh();
    }

    public void setBoots(@NotNull ItemStack itemStack) {
        equipment[2] = itemStack;
        refresh();
    }

    public void setMainHand(@NotNull ItemStack itemStack) {
        equipment[0] = itemStack;
        refresh();
    }

    public void setOffhand(@NotNull ItemStack itemStack) {
        verifyVersion(ServerVersion.V_1_9, "Offhand is only supported on 1.9+");
        equipment[1] = itemStack;
        refresh();
    }

    public void setItem(@NotNull EquipmentSlot slot, @NotNull ItemStack itemStack) {
        equipment[slot.ordinal()]  = itemStack;
        refresh();
    }

    public @NotNull ItemStack getItem(@NotNull EquipmentSlot slot) {
        ItemStack itemStack = equipment[slot.ordinal()];
        if (itemStack == null) {
            return ItemStack.EMPTY;
        }
        return itemStack;
    }

    public @NotNull ItemStack getHelmet() {
        return getItem(EquipmentSlot.HELMET);
    }

    public @NotNull ItemStack getChestplate() {
        return getItem(EquipmentSlot.CHEST_PLATE);
    }

    public @NotNull ItemStack getLeggings() {
        return getItem(EquipmentSlot.LEGGINGS);
    }

    public @NotNull ItemStack getBoots() {
        return getItem(EquipmentSlot.BOOTS);
    }

    public @NotNull ItemStack getMainHand() {
        return getItem(EquipmentSlot.MAIN_HAND);
    }

    public @NotNull ItemStack getOffhand() {
        verifyVersion(ServerVersion.V_1_9, "Offhand is only supported on 1.9+");
        return getItem(EquipmentSlot.OFF_HAND);
    }

    public WrapperPlayServerEntityEquipment createPacket() {
        List<Equipment> equipment = new ArrayList<>();
        for (int i = 0; i < this.equipment.length; i++) {
            ItemStack itemStack = this.equipment[i];
            if (itemStack == null || itemStack.equals(ItemStack.EMPTY)) continue;
            equipment.add(new Equipment(EQUIPMENT_SLOTS[i], itemStack));
        }
        return new WrapperPlayServerEntityEquipment(
                entity.getEntityId(),
                equipment
        );
    }


    public void refresh() {
        this.entity.sendPacketToViewers(createPacket());
    }

}
