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

package gay.pyrrha.qtech;

import gay.pyrrha.qtech.block.ModBlocks;
import gay.pyrrha.qtech.block.entity.ModBlockEntityTypes;
import gay.pyrrha.qtech.item.ModItemTags;
import gay.pyrrha.qtech.item.ModItems;
import gay.pyrrha.qtech.screen.ModScreenHandlers;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QTech implements ModInitializer {
    public static QTech modInstance;
    public Logger logger = LoggerFactory.getLogger(QTech.class);

    @Override
    public void onInitialize(ModContainer mod) {
        long startTime = System.currentTimeMillis();
        logger.info("[QTech] Initializing...");
        logger.info("Trans Rights are Human Rights. \uD83C\uDFF3\uFE0F\u200D\u26A7\uFE0F");
        modInstance = this;

        ModItemTags.init();
        ModItems.init();
        ModBlocks.init();
        ModBlockEntityTypes.init();
        ModScreenHandlers.init();

        logger.info("[QTech] Initialized. (Took {}ms)", System.currentTimeMillis() - startTime);
    }
}

