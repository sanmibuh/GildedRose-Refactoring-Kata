package com.gildedrose;

public class AgedItem extends Item {

  public AgedItem(final ItemName name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    sellIn--;

    if (quality < MAX_QUALITY) {
      quality++;

      if (sellIn < 0 && quality < MAX_QUALITY) {
        quality++;
      }
    }
  }
}
