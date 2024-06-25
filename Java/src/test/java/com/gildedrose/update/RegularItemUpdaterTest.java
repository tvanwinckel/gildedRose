package com.gildedrose.update;

import com.gildedrose.Item;
import com.gildedrose.update.RegularItemUpdater;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegularItemUpdaterTest {

    @Test
    void updateQuality() {
        final Item item = new Item("+5 Dexterity Vest", 10, 20);
        final RegularItemUpdater itemUpdater = new RegularItemUpdater();

        itemUpdater.update(item);

        assertThat(item.name).isEqualTo("+5 Dexterity Vest");
        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(19);
    }

    @Test
    void updateQuality_sellInExceeded_qualityDegragedsTwiceAsFast() {
        final Item item = new Item("+5 Dexterity Vest", 0, 20);
        final RegularItemUpdater itemUpdater = new RegularItemUpdater();

        itemUpdater.update(item);

        assertThat(item.name).isEqualTo("+5 Dexterity Vest");
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(18);
    }

    @Test
    void updateQuality_qualityCanNotBeNegative() {
        final Item item = new Item("+5 Dexterity Vest", 10, 0);
        final RegularItemUpdater itemUpdater = new RegularItemUpdater();

        itemUpdater.update(item);


        assertThat(item.name).isEqualTo("+5 Dexterity Vest");
        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(0);
    }
}
