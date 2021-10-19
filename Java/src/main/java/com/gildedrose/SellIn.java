package com.gildedrose;

import java.util.Objects;

public class SellIn {

  private final int value;

  private SellIn(final int value) {
    this.value = value;
  }

  public static SellIn of(final int value) {
    return new SellIn(value);
  }

  public SellIn decrease() {
    return new SellIn(value - 1);
  }

  public boolean isNegative() {
    return value < 0;
  }

  public boolean isLessThan(final int o) {
    return value < o;
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

  @Override
  public String toString() {
    return String.valueOf(value);
  }

}
