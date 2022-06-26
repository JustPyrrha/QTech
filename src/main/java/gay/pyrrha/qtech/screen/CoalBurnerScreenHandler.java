/*
 * Copyright (C) 2022  JustPyrrha
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

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class CoalBurnerScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public CoalBurnerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(3));
    }

    public CoalBurnerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandlers.COAL_BURNER, syncId);
        checkSize(inventory, 2);
        this.inventory = inventory;
        this.addSlot(new Slot(inventory, 0, 26,  35));
        this.addSlot(new Slot(inventory, 1, 80,  35));
        this.addSlot(new Slot(inventory, 2, 134, 35));

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

            // todo(@JustPyrrha, 20/06/22): Filter slots.

            slot.onQuickTransfer(slotStack, stack);

            if(slotStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if(stack.getCount() == slotStack.getCount()) {
                return ItemStack.EMPTY;
            }
        }

        return stack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
