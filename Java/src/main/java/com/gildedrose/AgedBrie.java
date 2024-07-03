package com.gildedrose;

public class AgedBrie implements InventoryItem {

    public static final String AGED_BRIE = "Aged Brie";

    private String name;
    private int sellIn;
    private int quality;
    public AgedBrie(final String name, final int sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
