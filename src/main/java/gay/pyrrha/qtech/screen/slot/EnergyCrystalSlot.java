package gay.pyrrha.qtech.screen.slot;

import gay.pyrrha.qtech.item.ModItemTags;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class EnergyCrystalSlot extends Slot {

    public EnergyCrystalSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return matches(stack);
    }

    public static boolean matches(ItemStack stack) {
        return stack.isIn(ModItemTags.ENERGY_CRYSTAL);
    }

    @Override
    public int getMaxItemCount() {
        return 1;
    }
}
