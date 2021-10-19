package com.gildedrose;

public class BackstagePassesItem extends Item {

  private static final int DOUBLED_QUALITY_SELL_IN_INDEX = 11;
  private static final int TRIPLED_QUALITY_SELL_IN_INDEX = 6;

  public BackstagePassesItem(final ItemName name, final SellIn sellIn, final Quality quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    quality.increase();

    if (sellIn.isLessThan(DOUBLED_QUALITY_SELL_IN_INDEX)) {
      quality.increase();
    }

    if (sellIn.isLessThan(TRIPLED_QUALITY_SELL_IN_INDEX)) {
      quality.increase();
    }

    sellIn.decrease();

    if (sellIn.isNegative()) {
      quality.reset();
    }
  }
}
