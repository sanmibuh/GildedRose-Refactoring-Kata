package com.gildedrose;

public class BackstagePassesItem extends Item {

  private static final int DOUBLED_QUALITY_SELL_IN_INDEX = 11;
  private static final int TRIPLED_QUALITY_SELL_IN_INDEX = 6;

  public BackstagePassesItem(final String name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (quality < MAX_QUALITY) {
      quality++;

      if (sellIn < DOUBLED_QUALITY_SELL_IN_INDEX && quality < MAX_QUALITY) {
        quality++;
      }

      if (sellIn < TRIPLED_QUALITY_SELL_IN_INDEX && quality < MAX_QUALITY) {
        quality++;
      }
    }

    sellIn--;

    if (sellIn < 0) {
      quality = MIN_QUALITY;
    }
  }
}
