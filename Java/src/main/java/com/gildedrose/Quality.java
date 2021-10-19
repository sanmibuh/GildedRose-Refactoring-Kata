package com.gildedrose;

import java.util.Objects;

public class Quality {

  private static final int MIN_QUALITY = 0;
  private static final int MAX_QUALITY = 50;

  private int value;

  private Quality(final int value) {
    this.value = value;
  }

  public static Quality of(final int value) {
    return new Quality(value);
  }

  public void increase() {
    if (compareTo(MAX_QUALITY) < 0) {
      value++;
    }
  }

  public void decrease() {
    if (compareTo(MIN_QUALITY) > 0) {
      value--;
    }
  }

  public void reset() {
    value = 0;
  }
  
  private int compareTo(final int o) {
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
    final Quality quality = (Quality) o;
    return value == quality.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
