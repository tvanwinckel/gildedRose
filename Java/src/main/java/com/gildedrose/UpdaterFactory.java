package com.gildedrose;

public class UpdaterFactory {

    public static Updater of(final Item item) {
        return new AgedBrieUpdater();
    }
}
