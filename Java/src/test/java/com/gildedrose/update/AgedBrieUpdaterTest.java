package com.gildedrose.update;

import com.gildedrose.Item;
import com.gildedrose.update.AgedBrieUpdater;
import org.junit.jupiter.api.Test;

import static com.gildedrose.update.UpdaterFactory.AGED_BRIE;
import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieUpdaterTest {
    @Test
    void updateQuality() {
        final Item item = new Item(AGED_BRIE, 2, 0);
        final AgedBrieUpdater updater = new AgedBrieUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(AGED_BRIE);
        assertThat(item.sellIn).isEqualTo(1);
        assertThat(item.quality).isEqualTo(1);
    }

    @Test
    void updateQuality_sellInExceeded_qualityIncreasesTwiceAsFast() {
        final Item item = new Item(AGED_BRIE, 0, 0);
        final AgedBrieUpdater updater = new AgedBrieUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(AGED_BRIE);
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(2);
    }

    @Test
    void updateQuality_qualityCanNotSurpass50() {
        final Item item = new Item(AGED_BRIE, 0, 50);
        final AgedBrieUpdater updater = new AgedBrieUpdater();

        updater.update(item);


        assertThat(item.name).isEqualTo(AGED_BRIE);
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(50);
    }
}
