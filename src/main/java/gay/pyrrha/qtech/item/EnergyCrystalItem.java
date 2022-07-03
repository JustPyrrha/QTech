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

package gay.pyrrha.qtech.item;

import net.minecraft.item.Item;
import net.minecraft.util.Rarity;
import org.jetbrains.annotations.Range;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class EnergyCrystalItem extends Item {
    private final float rate;
    private final boolean uncrackable;
    public EnergyCrystalItem(@Range(from = 0, to = 1) float rate, Rarity rarity, boolean uncrackable) {
        super(new QuiltItemSettings()
                .group(ModItems.QTECH_GROUP)
                .rarity(rarity)
                .fireproof()
                .maxCount(1)
                .maxDamage((int) ((rate * 100) * 1000))
        );
        this.rate = rate;
        this.uncrackable = uncrackable;
    }

    public EnergyCrystalItem(@Range(from = 0, to = 1) float rate, Rarity rarity) {
        this(rate, rarity, false);
    }

    public float rate() {
        return this.rate;
    }

    public boolean uncrackable() {
        return this.uncrackable;
    }
}
