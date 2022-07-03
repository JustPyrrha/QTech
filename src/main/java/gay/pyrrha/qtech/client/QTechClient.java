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

package gay.pyrrha.qtech.client;

import gay.pyrrha.qtech.QTech;
import gay.pyrrha.qtech.client.screen.ModHandledScreens;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class QTechClient implements ClientModInitializer {

    @Override
    public void onInitializeClient(ModContainer mod) {
        long startTime = System.currentTimeMillis();
        QTech.modInstance.logger.info("[QTech] Initializing Client...");

        ModHandledScreens.init();

        QTech.modInstance.logger.info("[QTech] Initialized Client. (Took {}ms)", System.currentTimeMillis() - startTime);
    }
}
