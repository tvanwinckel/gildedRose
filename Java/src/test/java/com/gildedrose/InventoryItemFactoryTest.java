package com.gildedrose;

import com.gildedrose.inventory.AgedBrie;
import com.gildedrose.inventory.BackstagePass;
import com.gildedrose.inventory.Conjured;
import com.gildedrose.inventory.InventoryUpdate;
import com.gildedrose.inventory.InventoryItemFactory;
import com.gildedrose.inventory.RegularItem;
import com.gildedrose.inventory.Sulfuras;
import org.junit.jupiter.api.Test;

import static com.gildedrose.inventory.AgedBrie.AGED_BRIE;
import static com.gildedrose.inventory.BackstagePass.BACKSTAGE_PASSES;
import static com.gildedrose.inventory.Conjured.CONJURED;
import static com.gildedrose.inventory.Sulfuras.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;

class InventoryItemFactoryTest {

    @Test
    void createInventoryItem_agedBrie() {
        final Item item = new Item(AGED_BRIE, 0, 0);

        final InventoryUpdate inventoryItem = InventoryItemFactory.from(item);
        assertThat(inventoryItem).isInstanceOf(AgedBrie.class);
    }

    @Test
    void createInventoryItem_backstagePass() {
        final Item item = new Item(BACKSTAGE_PASSES, 0, 0);

        final InventoryUpdate inventoryItem = InventoryItemFactory.from(item);
        assertThat(inventoryItem).isInstanceOf(BackstagePass.class);
    }

    @Test
    void createInventoryItem_sulfuras() {
        final Item item = new Item(SULFURAS, 0, 0);

        final InventoryUpdate inventoryItem = InventoryItemFactory.from(item);
        assertThat(inventoryItem).isInstanceOf(Sulfuras.class);
    }

    @Test
    void createInventoryItem_conjured() {
        final Item item = new Item(CONJURED, 0, 0);

        final InventoryUpdate inventoryItem = InventoryItemFactory.from(item);
        assertThat(inventoryItem).isInstanceOf(Conjured.class);
    }

    @Test
    void createInventoryItem_regularItem() {
        final Item item = new Item("+5 Dexterity Vest", 0, 0);

        final InventoryUpdate inventoryItem = InventoryItemFactory.from(item);
        assertThat(inventoryItem).isInstanceOf(RegularItem.class);
    }
}
