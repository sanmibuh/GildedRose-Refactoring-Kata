package com.gildedrose;

import java.util.Objects;

public abstract class Item {

  protected static final int MIN_QUALITY = 0;
  protected static final int MAX_QUALITY = 50;

  private final ItemName name;

  protected int sellIn;

  protected int quality;

  protected Item(final ItemName name, final int sellIn, final int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public abstract void updateQuality();

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Item item = (Item) o;
    return sellIn == item.sellIn && quality == item.quality && name.equals(item.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, sellIn, quality);
  }

  @Override
  public String toString() {
    return name + ", " + sellIn + ", " + quality;
  }
}
