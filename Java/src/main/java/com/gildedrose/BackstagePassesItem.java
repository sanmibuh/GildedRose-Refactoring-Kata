package com.gildedrose;

public class BackstagePassesItem extends Item {

  private static final int DOUBLED_QUALITY_SELL_IN_INDEX = 11;
  private static final int TRIPLED_QUALITY_SELL_IN_INDEX = 6;

  public BackstagePassesItem(final ItemName name, final SellIn sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (quality < MAX_QUALITY) {
      quality++;

      if (sellIn.isLessThan(DOUBLED_QUALITY_SELL_IN_INDEX) && quality < MAX_QUALITY) {
        quality++;
      }

      if (sellIn.isLessThan(TRIPLED_QUALITY_SELL_IN_INDEX) && quality < MAX_QUALITY) {
        quality++;
      }
    }

    sellIn.decrease();

    if (sellIn.isNegative()) {
      quality = MIN_QUALITY;
    }
  }
}
