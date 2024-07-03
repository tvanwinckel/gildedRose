package com.gildedrose;

public class BackstagePass implements InventoryItem {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private String name;
    private int sellIn;
    private int quality;

    public BackstagePass(final String name, final int sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public void update() {

    }
}
