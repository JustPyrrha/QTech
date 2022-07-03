/*
 * Copyright (C) 2022 Pyrrha "JustPyrrha" Wills
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package gay.pyrrha.qtech.screen;

import gay.pyrrha.qtech.screen.slot.EnergyCrystalSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.tag.ItemTags;

public class CoalBurnerScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    private final Slot fuelSlot;
    private final Slot crystalSlot;
    private final Slot adapterSlot; //todo(JustPyrrha, 03/07/22): actually implement these lmao

    public CoalBurnerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(3));
    }

    public CoalBurnerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandlers.COAL_BURNER, syncId);
        checkSize(inventory, 3);
        this.inventory = inventory;

        this.fuelSlot    = this.addSlot(new Slot(inventory, 0, 26,  35));
        this.crystalSlot = this.addSlot(new EnergyCrystalSlot(inventory, 1, 80,  35));
        this.adapterSlot = this.addSlot(new Slot(inventory, 2, 134, 35));

        for(int j = 0; j < 3; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for(int j = 0; j < 9; ++j) {
            this.addSlot(new Slot(playerInventory, j, 8 + j * 18, 142));
        }
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        var stack = ItemStack.EMPTY;
        var slot = this.slots.get(index);
        if(slot.hasStack()) {
            var slotStack = slot.getStack();
            stack = slotStack.copy();

            if(index >= 0 && index <= 2) {
                // burner -> *
                if(!this.insertItem(slotStack, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickTransfer(slotStack, stack);
            } else if(
                    this.fuelSlot.canInsert(slotStack) ||
                    this.crystalSlot.canInsert(slotStack) ||
                    this.adapterSlot.canInsert(slotStack)
            ) {
                // * -> burner
                if(!this.insertItem(slotStack, 0, 3, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 2 && index < 30) {
                // inventory -> hotbar
                if(!this.insertItem(slotStack, 30, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 30 && index < 39) {
                // hotbar -> *
                if(!this.insertItem(slotStack, 3, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(slotStack, 3, 39, false)) {
                // remaining slots
                return ItemStack.EMPTY;
            }

            if(slotStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if(slotStack.getCount() == stack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, slotStack);
        }

        return stack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
