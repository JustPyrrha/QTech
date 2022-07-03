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

package gay.pyrrha.qtech.block;

import gay.pyrrha.qtech.utils.ModConstants;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block COAL_BURNER = register("coal_burner", new CoalBurnerBlock(AbstractBlock.Settings.of(Material.REPAIR_STATION)));

    public static <T extends Block> T register(String id, T block) {
        return Registry.register(Registry.BLOCK, new Identifier(ModConstants.MOD_ID, id), block);
    }

    public static void init() {}
}
