package com.gildedrose;

import com.gildedrose.update.ItemUpdater;
import com.gildedrose.update.UpdaterFactory;

import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> {
            final ItemUpdater updater = UpdaterFactory.of(item);
            updater.update(item);
        });

    }
}
