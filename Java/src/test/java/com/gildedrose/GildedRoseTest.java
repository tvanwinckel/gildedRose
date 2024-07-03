package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.inventory.AgedBrie.AGED_BRIE;
import static com.gildedrose.inventory.BackstagePass.BACKSTAGE_PASSES;
import static com.gildedrose.inventory.Sulfuras.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
}
