package com.gildedrose;

public class UpdaterFactory {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured";
    public static final int MAX_ITEM_QUALITY = 50;
    public static final int MIN_ITEM_QUALITY = 0;
    public static final int DEADLINE = 0;

    public static Updater of(final Item item) {
        if (isAgedBrie(item)) {
            return new AgedBrieUpdater();
        } else if (isBackstagePass(item)){
            return new BackstagePassUpdater();
        } else if (isSulfuras(item)){
            return new SulfurasUpdater();
        } else if (isConjured(item)){
            return new ConjuredItemUpdater();
        } else {
            return new RegularItemUpdater();
        }
    }

    private static boolean isAgedBrie(final Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private static boolean isBackstagePass(final Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private static boolean isSulfuras(final Item item) {
        return item.name.equals(SULFURAS);
    }

    private static boolean isConjured(final Item item) {
        return item.name.contains(CONJURED);
    }
}
