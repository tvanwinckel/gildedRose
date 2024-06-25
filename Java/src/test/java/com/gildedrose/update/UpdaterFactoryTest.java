package com.gildedrose.update;

import com.gildedrose.Item;
import com.gildedrose.update.AgedBrieUpdater;
import com.gildedrose.update.BackstagePassUpdater;
import com.gildedrose.update.ConjuredItemUpdater;
import com.gildedrose.update.ItemUpdater;
import com.gildedrose.update.RegularItemUpdater;
import com.gildedrose.update.SulfurasUpdater;
import com.gildedrose.update.UpdaterFactory;
import org.junit.jupiter.api.Test;

import static com.gildedrose.update.UpdaterFactory.AGED_BRIE;
import static com.gildedrose.update.UpdaterFactory.BACKSTAGE_PASSES;
import static com.gildedrose.update.UpdaterFactory.CONJURED;
import static com.gildedrose.update.UpdaterFactory.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;

class UpdaterFactoryTest {

//    Types of updaters:
//        - aged brie
//        - backstage pass
//        - sulfuras
//        - conjured items
//      - regular items


    @Test
    void createUpdaterBasedOnItem_agedBrie() {
        final Item item = new Item(AGED_BRIE, 0, 0);
        final ItemUpdater updater = UpdaterFactory.of(item);

        assertThat(updater).isInstanceOf(AgedBrieUpdater.class);
    }

    @Test
    void createUpdaterBasedOnItem_backstagePass() {
        final Item item = new Item(BACKSTAGE_PASSES, 0, 0);
        final ItemUpdater updater = UpdaterFactory.of(item);

        assertThat(updater).isInstanceOf(BackstagePassUpdater.class);
    }

    @Test
    void createUpdaterBasedOnItem_sulfuras() {
        final Item item = new Item(SULFURAS, 0, 0);
        final ItemUpdater updater = UpdaterFactory.of(item);

        assertThat(updater).isInstanceOf(SulfurasUpdater.class);
    }

    @Test
    void createUpdaterBasedOnItem_conjuredItem() {
        final Item item = new Item(CONJURED, 0, 0);
        final ItemUpdater updater = UpdaterFactory.of(item);

        assertThat(updater).isInstanceOf(ConjuredItemUpdater.class);
    }

    @Test
    void createUpdaterBasedOnItem_regularItem() {
        final Item item = new Item("", 0, 0);
        final ItemUpdater updater = UpdaterFactory.of(item);

        assertThat(updater).isInstanceOf(RegularItemUpdater.class);
    }
}
