package com.gildedrose;

public class BackstagePassesItem extends Item {

  public BackstagePassesItem(final String name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (quality < 50) {
      quality = quality + 1;

      if (sellIn < 11) {
        if (quality < 50) {
          quality = quality + 1;
        }
      }

      if (sellIn < 6) {
        if (quality < 50) {
          quality = quality + 1;
        }
      }
    }

    sellIn = sellIn - 1;

    if (sellIn < 0) {
      quality = quality - quality;
    }
  }
}
