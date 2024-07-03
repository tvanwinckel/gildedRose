package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.AgedBrie.AGED_BRIE;
import static org.assertj.core.api.Assertions.assertThat;

class InventoryItemFactoryTest {

    @Test
    void createInventoryItem_agedBrie() {
        final Item item = new Item(AGED_BRIE, 0, 0);

        final InventoryItem inventoryItem = InventoryItemFactory.create(item);
        assertThat(inventoryItem).isInstanceOf(AgedBrie.class);
    }
}
