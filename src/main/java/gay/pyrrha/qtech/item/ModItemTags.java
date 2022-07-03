package gay.pyrrha.qtech.item;

import gay.pyrrha.qtech.utils.ModConstants;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ModItemTags {
    public static final TagKey<Item> ENERGY_CRYSTAL = register("energy_crystals");

    public static TagKey<Item> register(String id) {
        return TagKey.of(Registry.ITEM_KEY, new Identifier(ModConstants.MOD_ID, id));
    }

    public static void init() {}
}
