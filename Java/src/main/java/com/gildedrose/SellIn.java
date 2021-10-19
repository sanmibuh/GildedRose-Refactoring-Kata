package com.gildedrose;

import java.util.Objects;

public class SellIn implements Comparable<Integer> {

  private int value;

  private SellIn(final int value) {
    this.value = value;
  }

  public static SellIn of(final int value) {
    return new SellIn(value);
  }

  public void decrease() {
    value--;
  }

  public boolean isNegative() {
    return value < 0;
  }

  public boolean isLessThan(final int o) {
    return compareTo(o) < 0;
  }

  @Override
  public int compareTo(final Integer o) {
    return Integer.compare(value, o);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final SellIn sellIn = (SellIn) o;
    return value == sellIn.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

}
