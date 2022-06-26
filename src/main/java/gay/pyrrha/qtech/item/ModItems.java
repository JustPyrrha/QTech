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
    public static final Item T1_ENERGY_CRYSTAL = register("t1_energy_crystal", new EnergyCrystalItem(0.05f, Rarity.COMMON));
    public static final Item T2_ENERGY_CRYSTAL = register("t2_energy_crystal", new EnergyCrystalItem(0.10f, Rarity.COMMON));
    public static final Item T3_ENERGY_CRYSTAL = register("t3_energy_crystal", new EnergyCrystalItem(0.25f, Rarity.UNCOMMON));
    public static final Item T4_ENERGY_CRYSTAL = register("t4_energy_crystal", new EnergyCrystalItem(0.50f, Rarity.RARE));
    public static final Item T5_ENERGY_CRYSTAL = register("t5_energy_crystal", new EnergyCrystalItem(1.00f, Rarity.EPIC));
    public static final Item T6_ENERGY_CRYSTAL = register("t6_energy_crystal", new EnergyCrystalItem(0.25f, Rarity.UNCOMMON, true));
    public static final Item T7_ENERGY_CRYSTAL = register("t7_energy_crystal", new EnergyCrystalItem(0.50f, Rarity.RARE, true));
    public static final Item T8_ENERGY_CRYSTAL = register("t8_energy_crystal", new EnergyCrystalItem(1.00f, Rarity.EPIC,true));
    public static final Item CRACKED_T1_ENERGY_CRYSTAL = register("cracked_t1_energy_crystal", new CrackedEnergyCrystalItem(Rarity.COMMON));
    public static final Item CRACKED_T2_ENERGY_CRYSTAL = register("cracked_t2_energy_crystal", new CrackedEnergyCrystalItem(Rarity.COMMON));
    public static final Item CRACKED_T3_ENERGY_CRYSTAL = register("cracked_t3_energy_crystal", new CrackedEnergyCrystalItem(Rarity.UNCOMMON));
    public static final Item CRACKED_T4_ENERGY_CRYSTAL = register("cracked_t4_energy_crystal", new CrackedEnergyCrystalItem(Rarity.RARE));
    public static final Item CRACKED_T5_ENERGY_CRYSTAL = register("cracked_t5_energy_crystal", new CrackedEnergyCrystalItem(Rarity.EPIC));

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
