package com.gildedrose;

import static com.gildedrose.ItemUpdater.AGED_BRIE;
import static com.gildedrose.ItemUpdater.BACKSTAGE_PASSES;

public class UpdaterFactory {

    public static Updater of(final Item item) {
        if (isAgedBrie(item)) {
            return new AgedBrieUpdater();
        } else if (isBackstagePass(item)){
            return new BackstagePassUpdater();
        } else {
            return new SulfurasUpdater();
        }
    }

    private static boolean isAgedBrie(final Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private static boolean isBackstagePass(final Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }
}
