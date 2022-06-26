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

package gay.pyrrha.qtech;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import org.quiltmc.loader.api.QuiltLoader;

import java.io.IOException;
import java.nio.file.Files;

public class ModConfig {
    public static Codec<ModConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("config_version").forGetter(config -> config.configVersion)
    ).apply(instance, ModConfig::new));

    private final int configVersion;

    public ModConfig(int configVersion) {
        this.configVersion = configVersion;
    }

    public ModConfig() {
        this(1);
    }

    public static ModConfig load() {
        var path = QuiltLoader.getConfigDir().resolve("qtech.json");
        if(!Files.exists(path)) {
            var config = new ModConfig();
            var result = CODEC.encodeStart(JsonOps.INSTANCE, config).result();
            if(result.isPresent()) {
                try {
                    Files.writeString(path, new GsonBuilder().setPrettyPrinting().create().toJson(result.get()));
                } catch (IOException e) {
                    QTech.modInstance.logger.warn("[QTech] Failed saving default config.", e);
                }
            } else {
                QTech.modInstance.logger.warn("[QTech] Failed saving default config.");
            }
            return new ModConfig();
        } else {
            try {
                var raw = Files.readString(path);
                var json = JsonParser.parseString(raw);
                var result = CODEC.decode(JsonOps.INSTANCE, json).map(Pair::getFirst);
                var error = result.error();
                error.ifPresent(e -> QTech.modInstance.logger.warn("[QTech] Failed loading config: {}", e.message()));
                return result.result().orElseGet(ModConfig::new);
            } catch (IOException e) {
                QTech.modInstance.logger.warn("[QTech] Failed loading config.", e);
                return new ModConfig();
            }
        }
    }
}
