package com.gildedrose;

import static com.gildedrose.UpdaterFactory.DEADLINE;
import static com.gildedrose.UpdaterFactory.MIN_ITEM_QUALITY;
import static java.lang.Math.max;

public class RegularItemUpdater implements Updater {

    public void update(final Item item) {
        final int quality = item.sellIn > DEADLINE ? 1 : 2;
        item.quality = max(item.quality - quality, MIN_ITEM_QUALITY);
        item.sellIn = item.sellIn - 1;
    }
}
