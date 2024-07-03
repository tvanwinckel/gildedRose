package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.AgedBrie.AGED_BRIE;
import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieTest {

    @Test
    void updateQualityOfAgedBrie() {
        final AgedBrie agedBrie = new AgedBrie(AGED_BRIE, 2, 0);
        agedBrie.update();

        assertThat(agedBrie.getName()).isEqualTo(AGED_BRIE);
        assertThat(agedBrie.getSellIn()).isEqualTo(1);
        assertThat(agedBrie.getQuality()).isEqualTo(1);
    }

    @Test
    void updateQualityOfAgedBrie_sellInExceeded_qualityIncreasesTwiceAsFast() {
        final AgedBrie agedBrie = new AgedBrie(AGED_BRIE, 0, 0);
        agedBrie.update();

        assertThat(agedBrie.getName()).isEqualTo(AGED_BRIE);
        assertThat(agedBrie.getSellIn()).isEqualTo(-1);
        assertThat(agedBrie.getQuality()).isEqualTo(2);
    }

    @Test
    void updateQualityOfAgedBrie_qualityCanNotSurpass50() {
        final AgedBrie agedBrie = new AgedBrie(AGED_BRIE, 0, 50);
        agedBrie.update();

        assertThat(agedBrie.getName()).isEqualTo(AGED_BRIE);
        assertThat(agedBrie.getSellIn()).isEqualTo(-1);
        assertThat(agedBrie.getQuality()).isEqualTo(50);
    }
}
