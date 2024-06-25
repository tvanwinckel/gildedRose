package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemUpdater.AGED_BRIE;
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
        final Updater updater = UpdaterFactory.of(item);

        assertThat(updater).isInstanceOf(AgedBrieUpdater.class);
    }

}
