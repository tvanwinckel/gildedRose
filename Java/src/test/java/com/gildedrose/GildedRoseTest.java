package com.gildedrose;

import org.junit.jupiter.api.Test;

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

    @Test
    void updateQualityOfRegularItem() {
        final Item item = new Item("+5 Dexterity Vest", 10, 20);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("+5 Dexterity Vest");
        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(19);
    }

    @Test
    void updateQualityOfRegularItem_sellInExceeded_qualityDegradesTwiceAsFast() {
        final Item item = new Item("+5 Dexterity Vest", 0, 20);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("+5 Dexterity Vest");
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(18);
    }

    @Test
    void updateQualityOfRegularItem_qualityCantBeNegative() {
        final Item item = new Item("+5 Dexterity Vest", 10, 0);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("+5 Dexterity Vest");
        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void updateQualityOfAgedBrie() {
        final Item item = new Item("Aged Brie", 2, 0);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("Aged Brie");
        assertThat(item.sellIn).isEqualTo(1);
        assertThat(item.quality).isEqualTo(1);
    }

    @Test
    void updateQualityOfAgedBrie_sellInExceeded_qualityIncreasesTwiceAsFast() {
        final Item item = new Item("Aged Brie", 0, 0);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("Aged Brie");
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(2);
    }

    @Test
    void updateQualityOfAgedBrie_qualityCanNotSurpass50() {
        final Item item = new Item("Aged Brie", 0, 50);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("Aged Brie");
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void updateQualityOfSulfuras_sellInAndQualityNeverChange() {
        final Item item = new Item("Sulfuras, Hand of Ragnaros", 20, 80);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("Sulfuras, Hand of Ragnaros");
        assertThat(item.sellIn).isEqualTo(20);
        assertThat(item.quality).isEqualTo(80);
    }

    @Test
    void updateQualityOfBackstagePass_sellInAbove10_normalIncreaseInQuality() {
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(item.sellIn).isEqualTo(14);
        assertThat(item.quality).isEqualTo(21);
    }

    @Test
    void updateQualityOfBackstagePass_sellInBelow11_increaseInQualityTwiceAsFast() {
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(22);
    }

    @Test
    void updateQualityOfBackstagePass_sellInBelow6_increaseInQualityTriceAsFast() {
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(23);
    }

    @Test
    void updateQualityOfBackstagePass_sellInExceeded_qualityZero() {
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(0);
    }

}
