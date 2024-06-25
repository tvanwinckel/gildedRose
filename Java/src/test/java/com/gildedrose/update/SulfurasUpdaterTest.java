package com.gildedrose.update;

import com.gildedrose.Item;
import com.gildedrose.update.SulfurasUpdater;
import org.junit.jupiter.api.Test;

import static com.gildedrose.update.UpdaterFactory.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;

class SulfurasUpdaterTest {

    @Test
    void updateQuality_sellInAndQualityNeverChange() {
        final Item item = new Item(SULFURAS, 20, 80);
        final SulfurasUpdater updater = new SulfurasUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(SULFURAS);
        assertThat(item.sellIn).isEqualTo(20);
        assertThat(item.quality).isEqualTo(80);
    }
}
