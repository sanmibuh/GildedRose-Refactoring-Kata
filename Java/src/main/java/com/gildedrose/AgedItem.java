package com.gildedrose;

public class AgedItem extends Item {

  public AgedItem(final String name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (quality < 50) {
      quality = quality + 1;
    }

    sellIn = sellIn - 1;

    if (sellIn < 0) {
      if (quality < 50) {
        quality = quality + 1;
      }
    }
  }
}
