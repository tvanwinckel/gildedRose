package com.gildedrose.update;

import com.gildedrose.Item;
import com.gildedrose.update.ConjuredItemUpdater;
import org.junit.jupiter.api.Test;

import static com.gildedrose.update.UpdaterFactory.CONJURED;
import static org.assertj.core.api.Assertions.assertThat;

class ConjuredItemUpdaterTest {

    @Test
    void updateQuality_sellInNotExceeded_qualityDegradesTwiceAsFastAsNormal() {
        final Item item = new Item(CONJURED, 3, 6);
        final ConjuredItemUpdater updater = new ConjuredItemUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(CONJURED);
        assertThat(item.sellIn).isEqualTo(2);
        assertThat(item.quality).isEqualTo(4);
    }

    @Test
    void updateQuality_sellInExceeded_qualityDegradesTwiceAsFastAsNormal() {
        final Item item = new Item(CONJURED, 0, 6);
        final ConjuredItemUpdater updater = new ConjuredItemUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(CONJURED);
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(2);
    }

    @Test
    void updateQuality_qualityCanNotGoBelowZero() {
        final Item item = new Item(CONJURED, 0, 0);
        final ConjuredItemUpdater updater = new ConjuredItemUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(CONJURED);
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(0);
    }
}
