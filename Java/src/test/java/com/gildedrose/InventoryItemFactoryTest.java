package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InventoryItemFactoryTest {

    @Test
    void createInventoryItem_agedBrie() {
        final InventoryItem inventoryItem = InventoryItemFactory.create(item);
        assertThat(inventoryItem).isInstanceOf(AgedBrie.class);
    }
}
