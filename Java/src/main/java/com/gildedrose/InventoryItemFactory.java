package com.gildedrose;

import static com.gildedrose.AgedBrie.AGED_BRIE;
import static com.gildedrose.BackstagePass.BACKSTAGE_PASSES;
import static com.gildedrose.Conjured.CONJURED;
import static com.gildedrose.Sulfuras.SULFURAS;

public class InventoryItemFactory {

    public static InventoryItem create(final Item item) {
        if (isAgedBrie(item)) {
            return new AgedBrie(item.name, item.sellIn, item.quality);
        } else if (isBackstagePass(item)) {
            return new BackstagePass(item.name, item.sellIn, item.quality);
        } else if(isConjured(item)) {
            return new Conjured(item.name, item.sellIn, item.quality);
        } else if (isSulfuras(item)){
            return new Sulfuras(item.name, item.sellIn, item.quality);
        } else {
            return new RegularItem(item.name, item.sellIn, item.quality);
        }
    }

    private static boolean isAgedBrie(final Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private static boolean isBackstagePass(final Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private static boolean isSulfuras(final Item item) {
        return item.name.equals(SULFURAS);
    }

    private static boolean isConjured(final Item item) {
        return item.name.contains(CONJURED);
    }
}
