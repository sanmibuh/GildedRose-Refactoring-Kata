package com.gildedrose;

public class AgedItem extends Item {

  public AgedItem(final ItemName name, final SellIn sellIn, final Quality quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    sellIn.decrease();

    if (quality.compareTo(MAX_QUALITY) < 0) {
      quality.increase();

      if (sellIn.isNegative() && quality.compareTo(MAX_QUALITY) < 0) {
        quality.increase();
      }
    }
  }
}
