package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.BackstagePass.BACKSTAGE_PASSES;
import static org.assertj.core.api.Assertions.assertThat;

class BackstagePassTest {

    @Test
    void updateQualityOfBackstagePass_sellInAbove10_normalIncreaseInQuality() {
        final BackstagePass backstagePass = new BackstagePass(BACKSTAGE_PASSES, 15, 20);
        backstagePass.update();

        assertThat(backstagePass.getName()).isEqualTo(BACKSTAGE_PASSES);
        assertThat(backstagePass.getSellIn()).isEqualTo(14);
        assertThat(backstagePass.getQuality()).isEqualTo(21);
    }

    @Test
    void updateQualityOfBackstagePass_sellInBelow11_increaseInQualityTwiceAsFast() {
        final BackstagePass backstagePass = new BackstagePass(BACKSTAGE_PASSES, 10, 20);
        backstagePass.update();

        assertThat(backstagePass.getName()).isEqualTo(BACKSTAGE_PASSES);
        assertThat(backstagePass.getSellIn()).isEqualTo(9);
        assertThat(backstagePass.getQuality()).isEqualTo(22);
    }

    @Test
    void updateQualityOfBackstagePass_sellInBelow6_increaseInQualityTriceAsFast() {
        final BackstagePass backstagePass = new BackstagePass(BACKSTAGE_PASSES, 5, 20);
        backstagePass.update();

        assertThat(backstagePass.getName()).isEqualTo(BACKSTAGE_PASSES);
        assertThat(backstagePass.getSellIn()).isEqualTo(4);
        assertThat(backstagePass.getQuality()).isEqualTo(23);
    }

    @Test
    void updateQualityOfBackstagePass_sellInExceeded_qualityZero() {
        final BackstagePass backstagePass = new BackstagePass(BACKSTAGE_PASSES, 0, 20);
        backstagePass.update();

        assertThat(backstagePass.getName()).isEqualTo(BACKSTAGE_PASSES);
        assertThat(backstagePass.getSellIn()).isEqualTo(-1);
        assertThat(backstagePass.getQuality()).isEqualTo(0);
    }

}
