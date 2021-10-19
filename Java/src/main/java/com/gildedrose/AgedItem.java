package com.gildedrose;

public class AgedItem extends Item {

  public AgedItem(final String name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    sellIn--;

    if (quality < 50) {
      quality++;

      if (sellIn < 0 && quality < 50) {
        quality++;
      }
    }
  }
}
