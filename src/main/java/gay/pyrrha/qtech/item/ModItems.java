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

package gay.pyrrha.qtech.item;

import gay.pyrrha.qtech.block.ModBlocks;
import gay.pyrrha.qtech.utils.ModConstants;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {

    // Meta
    public static final Item QTECH_ICON_ITEM = register("qtech_icon", new Item(new QuiltItemSettings().rarity(Rarity.EPIC)));
    public static final ItemGroup QTECH_GROUP = QuiltItemGroup.createWithIcon(new Identifier(ModConstants.MOD_ID, "group"), QTECH_ICON_ITEM::getDefaultStack);

    // energy crystals
    public static final Item COMMON_ENERGY_CRYSTAL                = register("common_energy_crystal",                new EnergyCrystalItem(0.05f, Rarity.COMMON));
    public static final Item UNCOMMON_ENERGY_CRYSTAL              = register("uncommon_energy_crystal",              new EnergyCrystalItem(0.10f, Rarity.COMMON));
    public static final Item RARE_ENERGY_CRYSTAL                  = register("rare_energy_crystal",                  new EnergyCrystalItem(0.25f, Rarity.UNCOMMON));
    public static final Item EXQUISITE_ENERGY_CRYSTAL             = register("exquisite_energy_crystal",             new EnergyCrystalItem(0.50f, Rarity.RARE));
    public static final Item MAJESTIC_ENERGY_CRYSTAL              = register("majestic_energy_crystal",              new EnergyCrystalItem(1.00f, Rarity.EPIC));
    public static final Item UNCRACKABLE_RARE_ENERGY_CRYSTAL      = register("uncrackable_rare_energy_crystal",      new EnergyCrystalItem(0.25f, Rarity.UNCOMMON, true));
    public static final Item UNCRACKABLE_EXQUISITE_ENERGY_CRYSTAL = register("uncrackable_exquisite_energy_crystal", new EnergyCrystalItem(0.50f, Rarity.RARE, true));
    public static final Item UNCRACKABLE_MAJESTIC_ENERGY_CRYSTAL  = register("uncrackable_majestic_energy_crystal",  new EnergyCrystalItem(1.00f, Rarity.EPIC,true));
    public static final Item CRACKED_COMMON_ENERGY_CRYSTAL        = register("cracked_common_energy_crystal",        new CrackedEnergyCrystalItem(Rarity.COMMON));
    public static final Item CRACKED_UNCOMMON_ENERGY_CRYSTAL      = register("cracked_uncommon_energy_crystal",      new CrackedEnergyCrystalItem(Rarity.COMMON));
    public static final Item CRACKED_RARE_ENERGY_CRYSTAL          = register("cracked_rare_energy_crystal",          new CrackedEnergyCrystalItem(Rarity.UNCOMMON));
    public static final Item CRACKED_EXQUISITE_ENERGY_CRYSTAL     = register("cracked_exquisite_energy_crystal",     new CrackedEnergyCrystalItem(Rarity.RARE));
    public static final Item CRACKED_MAJESTIC_ENERGY_CRYSTAL      = register("cracked_majestic_energy_crystal",      new CrackedEnergyCrystalItem(Rarity.EPIC));

    // Block Items
    public static final Item COAL_BURNER = register(ModBlocks.COAL_BURNER, QTECH_GROUP);

    private static Item register(Block block, ItemGroup group) {
        return register(Registry.BLOCK.getId(block), new BlockItem(block, new Item.Settings().group(group)));
    }

    public static Item register(Block block) {
        return register(Registry.BLOCK.getId(block), new BlockItem(block, new Item.Settings()));
    }
    private static Item register(String id, Item item) {
        return register(new Identifier(ModConstants.MOD_ID, id), item);
    }

    private static <T extends Item> T register(Identifier id, T item) {
        if(item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registry.ITEM, id, item);
    }
    public static void init() {}
}
