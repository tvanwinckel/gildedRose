package com.gildedrose;

import static com.gildedrose.ItemUpdater.DEADLINE;
import static com.gildedrose.ItemUpdater.MAX_ITEM_QUALITY;
import static com.gildedrose.ItemUpdater.MIN_ITEM_QUALITY;
import static java.lang.Math.min;

public class BackstagePassUpdater implements Updater {

    public void update(final Item item) {
        item.quality = item.sellIn > DEADLINE ? calculateBackstagePassItemQuality(item) : MIN_ITEM_QUALITY;
        item.sellIn = item.sellIn - 1;
    }

    private static int calculateBackstagePassItemQuality(final Item item) {
        final int quality;
        if (item.sellIn < 6) {
            quality = 3;
        } else if (item.sellIn < 11) {
            quality = 2;
        } else {
            quality = 1;
        }
        return min(item.quality + quality, MAX_ITEM_QUALITY);
    }
}
