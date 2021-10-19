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

      if (sellIn.compareTo(DOUBLED_QUALITY_SELL_IN_INDEX) < 0 && quality < MAX_QUALITY) {
        quality++;
      }

      if (sellIn.compareTo(TRIPLED_QUALITY_SELL_IN_INDEX) < 0 && quality < MAX_QUALITY) {
        quality++;
      }
    }

    sellIn.decrease();

    if (sellIn.isNegative()) {
      quality = MIN_QUALITY;
    }
  }
}
