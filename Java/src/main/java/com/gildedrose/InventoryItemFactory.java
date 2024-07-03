package com.gildedrose;

import static com.gildedrose.AgedBrie.AGED_BRIE;

public class InventoryItemFactory {

    public static InventoryItem create(final Item item) {
        if (isAgedBrie(item)) {
            return new AgedBrie(item.name, item.sellIn, item.quality);
        } else {
            return new BackstagePass(item.name, item.sellIn, item.quality);
        }
    }

    private static boolean isAgedBrie(final Item item) {
        return item.name.equals(AGED_BRIE);
    }
}
