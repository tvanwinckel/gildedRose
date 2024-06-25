package com.gildedrose;

import static com.gildedrose.ItemUpdater.AGED_BRIE;

public class UpdaterFactory {

    public static Updater of(final Item item) {
        if (isAgedBrie(item)) {
            return new AgedBrieUpdater();
        } else {
            return new BackstagePassUpdater();
        }
    }

    private static boolean isAgedBrie(final Item item) {
        return item.name.equals(AGED_BRIE);
    }
}
