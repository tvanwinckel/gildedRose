package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConjuredTest {

    @Test
    void updateQualityOfConjuredItem_sellInNotExceeded_qualityDegradesTwiceAsFastAsNormal() {
        final Conjured conjured = new Conjured("Conjured Mana Cake", 3, 6);
        conjured.update();

        assertThat(conjured.getName()).isEqualTo("Conjured Mana Cake");
        assertThat(conjured.getSellIn()).isEqualTo(2);
        assertThat(conjured.getQuality()).isEqualTo(4);
    }

    @Test
    void updateQualityOfConjuredItem_sellInExceeded_qualityDegradesTwiceAsFastAsNormal() {
        final Conjured conjured = new Conjured("Conjured Mana Cake", 0, 6);
        conjured.update();

        assertThat(conjured.getName()).isEqualTo("Conjured Mana Cake");
        assertThat(conjured.getSellIn()).isEqualTo(-1);
        assertThat(conjured.getQuality()).isEqualTo(2);
    }

    @Test
    void updateQualityOfConjuredItem_qualityCanNotGoBelowZero() {
        final Conjured conjured = new Conjured("Conjured Mana Cake", 0, 0);
        conjured.update();

        assertThat(conjured.getName()).isEqualTo("Conjured Mana Cake");
        assertThat(conjured.getSellIn()).isEqualTo(-1);
        assertThat(conjured.getQuality()).isEqualTo(0);
    }
}
