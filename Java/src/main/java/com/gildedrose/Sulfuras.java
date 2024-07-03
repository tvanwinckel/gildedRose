package com.gildedrose;

public class Sulfuras implements InventoryItem {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private String name;
    private int sellIn;
    private int quality;

    public Sulfuras(final String name, final int sellIn, final int quality) {
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
