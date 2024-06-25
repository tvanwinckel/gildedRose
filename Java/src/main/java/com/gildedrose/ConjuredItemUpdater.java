package com.gildedrose;

import static com.gildedrose.ItemUpdater.DEADLINE;
import static com.gildedrose.ItemUpdater.MIN_ITEM_QUALITY;
import static java.lang.Math.max;

public class ConjuredItemUpdater implements Updater {

    public void update(final Item item) {
        final int quality = item.sellIn > DEADLINE ? 2 : 4;
        item.quality = max(item.quality - quality, MIN_ITEM_QUALITY);
        item.sellIn = item.sellIn - 1;
    }
}
