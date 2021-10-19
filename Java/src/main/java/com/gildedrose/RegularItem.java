package com.gildedrose;

public class RegularItem extends Item {

  public RegularItem(final String name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (quality > 0) {
      quality -= 1;
    }
    sellIn -= 1;

    if (sellIn < 0) {
      if (quality > 0) {
        quality -= 1;
      }
    }
  }
}
