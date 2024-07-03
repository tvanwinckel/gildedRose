package com.gildedrose;

import com.gildedrose.inventory.RegularItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegularItemTest {

    @Test
    void updateQualityOfRegularItem() {
        final RegularItem item = new RegularItem("+5 Dexterity Vest", 10, 20);
        item.update();

        assertThat(item.getName()).isEqualTo("+5 Dexterity Vest");
        assertThat(item.getSellIn()).isEqualTo(9);
        assertThat(item.getQuality()).isEqualTo(19);
    }

    @Test
    void updateQualityOfRegularItem_sellInExceeded_qualityDegradesTwiceAsFast() {
        final RegularItem item = new RegularItem("+5 Dexterity Vest", 0, 20);
        item.update();

        assertThat(item.getName()).isEqualTo("+5 Dexterity Vest");
        assertThat(item.getSellIn()).isEqualTo(-1);
        assertThat(item.getQuality()).isEqualTo(18);
    }

    @Test
    void updateQualityOfRegularItem_qualityCantBeNegative() {
        final RegularItem item = new RegularItem("+5 Dexterity Vest", 10, 0);
        item.update();

        assertThat(item.getName()).isEqualTo("+5 Dexterity Vest");
        assertThat(item.getSellIn()).isEqualTo(9);
        assertThat(item.getQuality()).isEqualTo(0);
    }
}
