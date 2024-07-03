package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.AgedBrie.AGED_BRIE;
import static com.gildedrose.BackstagePass.BACKSTAGE_PASSES;
import static com.gildedrose.Conjured.CONJURED;
import static com.gildedrose.Sulfuras.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;

class InventoryItemFactoryTest {

    @Test
    void createInventoryItem_agedBrie() {
        final Item item = new Item(AGED_BRIE, 0, 0);

        final InventoryItem inventoryItem = InventoryItemFactory.from(item);
        assertThat(inventoryItem).isInstanceOf(AgedBrie.class);
    }

    @Test
    void createInventoryItem_backstagePass() {
        final Item item = new Item(BACKSTAGE_PASSES, 0, 0);

        final InventoryItem inventoryItem = InventoryItemFactory.from(item);
        assertThat(inventoryItem).isInstanceOf(BackstagePass.class);
    }

    @Test
    void createInventoryItem_sulfuras() {
        final Item item = new Item(SULFURAS, 0, 0);

        final InventoryItem inventoryItem = InventoryItemFactory.from(item);
        assertThat(inventoryItem).isInstanceOf(Sulfuras.class);
    }

    @Test
    void createInventoryItem_conjured() {
        final Item item = new Item(CONJURED, 0, 0);

        final InventoryItem inventoryItem = InventoryItemFactory.from(item);
        assertThat(inventoryItem).isInstanceOf(Conjured.class);
    }

    @Test
    void createInventoryItem_regularItem() {
        final Item item = new Item("+5 Dexterity Vest", 0, 0);

        final InventoryItem inventoryItem = InventoryItemFactory.from(item);
        assertThat(inventoryItem).isInstanceOf(RegularItem.class);
    }
}
