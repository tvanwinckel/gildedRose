package com.gildedrose;

import com.gildedrose.inventory.InventoryItem;
import com.gildedrose.inventory.InventoryItemFactory;

class GildedRose {


    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            final InventoryItem inventoryItem = InventoryItemFactory.from(item);
            inventoryItem.update();

            updateOriginalItemReference(item, inventoryItem);
        }
    }

    private void updateOriginalItemReference(final Item item, final InventoryItem inventoryItem) {
        item.sellIn = inventoryItem.getSellIn();
        item.quality = inventoryItem.getQuality();
    }
}
