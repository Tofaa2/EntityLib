package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.player.Equipment;
import com.github.retrooper.packetevents.protocol.player.EquipmentSlot;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityEquipment;
import me.tofaa.entitylib.EntityLib;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.tofaa.entitylib.extras.VersionChecker.verifyVersion;

public class WrapperEntityEquipment {

    private static final EquipmentSlot[] EQUIPMENT_SLOTS = EquipmentSlot.values();

    private final WrapperLivingEntity entity;
    private boolean notifyChanges = true;

    // 0 = main hand, 1 = offhand, 2 = boots, 3 = leggings, 4 = chestplate, 5 = helmet
    private final ItemStack[] equipment = new ItemStack[6];

    public WrapperEntityEquipment(WrapperLivingEntity entity) {
        this.entity = entity;
        Arrays.fill(equipment, ItemStack.EMPTY);
    }

    public void setHelmet(@Nullable ItemStack itemStack) {
        equipment[5] = itemStack == null ? ItemStack.EMPTY : itemStack;
        refresh();
    }

    public void setChestplate(@Nullable ItemStack itemStack) {
        equipment[4] = itemStack == null ? ItemStack.EMPTY : itemStack;
        refresh();
    }

    public void setLeggings(@Nullable ItemStack itemStack) {
        equipment[3] = itemStack == null ? ItemStack.EMPTY : itemStack;
        refresh();
    }

    public void setBoots(@Nullable ItemStack itemStack) {
        equipment[2] = itemStack == null ? ItemStack.EMPTY : itemStack;
        refresh();
    }

    public void setMainHand(@Nullable ItemStack itemStack) {
        equipment[0] = itemStack == null ? ItemStack.EMPTY : itemStack;
        refresh();
    }

    public void setOffhand(@Nullable ItemStack itemStack) {
        equipment[1] = itemStack == null ? ItemStack.EMPTY : itemStack;
        refresh();
    }

    public void setItem(@NotNull EquipmentSlot slot, @Nullable ItemStack itemStack) {
        equipment[slot.ordinal()]  = itemStack == null ? ItemStack.EMPTY : itemStack;
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
            equipment.add(new Equipment(EQUIPMENT_SLOTS[i], itemStack));
        }
        return new WrapperPlayServerEntityEquipment(
                entity.getEntityId(),
                equipment
        );
    }


    public void refresh() {
        if (notifyChanges) {
            this.entity.sendPacketToViewers(createPacket());
        }
    }

    public boolean isNotifyingChanges() {
        return notifyChanges;
    }

    public void setNotifyChanges(boolean notifyChanges) {
        this.notifyChanges = notifyChanges;
        refresh();
    }
}
