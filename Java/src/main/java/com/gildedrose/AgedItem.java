package com.gildedrose;

public class AgedItem extends Item {

  public AgedItem(final ItemName name, final SellIn sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    sellIn.decrease();

    if (quality < MAX_QUALITY) {
      quality++;

      if (sellIn.isNegative() && quality < MAX_QUALITY) {
        quality++;
      }
    }
  }
}
