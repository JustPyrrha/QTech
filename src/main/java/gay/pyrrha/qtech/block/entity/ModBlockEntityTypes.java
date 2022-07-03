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

package gay.pyrrha.qtech.block.entity;

import gay.pyrrha.qtech.QTech;
import gay.pyrrha.qtech.block.ModBlocks;
import gay.pyrrha.qtech.utils.ModConstants;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

public class ModBlockEntityTypes {
    public static final BlockEntityType<CoalBurnerBlockEntity> COAL_BURNER = register("coal_burner", BlockEntityType.Builder.create(
            CoalBurnerBlockEntity::new,
            ModBlocks.COAL_BURNER
    ));

    public static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType.Builder<T> builder) {
        if(builder.blocks.size() == 0) {
            QTech.modInstance.logger.warn("[QTech] No blocks registered for BlockEntityType {}, fix this dumbass.", id);
        }
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModConstants.MOD_ID, id), builder.build(null));
    }

    public static void init() {}
}
