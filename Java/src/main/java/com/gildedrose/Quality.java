package com.gildedrose;

import java.util.Objects;

public class Quality {

  private static final int MIN_QUALITY = 0;
  private static final int MAX_QUALITY = 50;

  private static final Quality EMPTY_QUALITY = new Quality(MIN_QUALITY);

  private final int value;

  private Quality(final int value) {
    this.value = value;
  }

  public static Quality of(final int value) {
    return new Quality(value);
  }

  public static Quality empty() {
    return EMPTY_QUALITY;
  }

  public Quality increase() {
    if (value < MAX_QUALITY) {
      return new Quality(value + 1);
    }
    return this;
  }

  public Quality decrease() {
    if (value > MIN_QUALITY) {
      return new Quality(value - 1);
    }
    return this;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Quality quality = (Quality) o;
    return value == quality.value;
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
