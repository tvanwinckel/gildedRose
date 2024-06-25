package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.UpdaterFactory.BACKSTAGE_PASSES;
import static org.assertj.core.api.Assertions.assertThat;

class BackstagePassUpdaterTest {

    @Test
    void updateQuality_sellInAbove10_normalIncreaseInQuality() {
        final Item item = new Item(BACKSTAGE_PASSES, 15, 20);
        final BackstagePassUpdater updater = new BackstagePassUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(BACKSTAGE_PASSES);
        assertThat(item.sellIn).isEqualTo(14);
        assertThat(item.quality).isEqualTo(21);
    }

    @Test
    void updateQuality_sellInBelow11_increaseInQualityTwiceAsFast() {
        final Item item = new Item(BACKSTAGE_PASSES, 10, 20);
        final BackstagePassUpdater updater = new BackstagePassUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(BACKSTAGE_PASSES);
        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(22);
    }

    @Test
    void updateQuality_sellInBelow6_increaseInQualityTriceAsFast() {
        final Item item = new Item(BACKSTAGE_PASSES, 5, 20);
        final BackstagePassUpdater updater = new BackstagePassUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(BACKSTAGE_PASSES);
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(23);
    }

    @Test
    void updateQuality_sellInExceeded_qualityZero() {
        final Item item = new Item(BACKSTAGE_PASSES, 0, 20);
        final BackstagePassUpdater updater = new BackstagePassUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(BACKSTAGE_PASSES);
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void updateQuality_qualityCanNotSurpass50() {
        final Item item = new Item(BACKSTAGE_PASSES, 3, 50);
        final BackstagePassUpdater updater = new BackstagePassUpdater();

        updater.update(item);

        assertThat(item.name).isEqualTo(BACKSTAGE_PASSES);
        assertThat(item.sellIn).isEqualTo(2);
        assertThat(item.quality).isEqualTo(50);
    }
}
