package com.gildedrose;

import static com.gildedrose.UpdaterFactory.DEADLINE;
import static com.gildedrose.UpdaterFactory.MAX_ITEM_QUALITY;
import static java.lang.Math.min;

public class AgedBrieUpdater implements ItemUpdater {

    public void update(final Item item) {
        final int quality = item.sellIn > DEADLINE ? 1 : 2;
        item.quality = min(item.quality + quality, MAX_ITEM_QUALITY);
        item.sellIn = item.sellIn - 1;
    }
}
