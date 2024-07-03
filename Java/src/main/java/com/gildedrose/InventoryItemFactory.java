package com.gildedrose;

public class InventoryItemFactory {

    public static InventoryItem create(final Item item) {
        return new AgedBrie(item.name, item.sellIn, item.quality);
    }
}
