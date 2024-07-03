package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.inventory.Sulfuras.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;

class SulfurasTest {

    @Test
    void updateQualityOfSulfuras_sellInAndQualityNeverChange() {
        final Item item = new Item(SULFURAS, 20, 80);
        final Item[] items = new Item[] {item};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(item.name).isEqualTo(SULFURAS);
        assertThat(item.sellIn).isEqualTo(20);
        assertThat(item.quality).isEqualTo(80);
    }

}
