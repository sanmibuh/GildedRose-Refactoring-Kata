package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GildedRoseTest {

  @Test
  void should_decrease_the_quality_and_sellin() {
    final ItemName itemName = ItemName.of("foo");
    final Item[] items = new Item[]{new RegularItem(itemName, 10, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new RegularItem(itemName, 9, 4);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_decrease_the_quality_twice_fast_when_negative_sellin() {
    final ItemName itemName = ItemName.of("foo");
    final Item[] items = new Item[]{new RegularItem(itemName, -1, 6)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new RegularItem(itemName, -2, 4);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_not_decrease_the_quality_if_is_zero() {
    final ItemName itemName = ItemName.of("foo");
    final Item[] items = new Item[]{new RegularItem(itemName, 0, 0)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new RegularItem(itemName, -1, 0);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_increase_the_quality_with_aged_brie_item() {
    final ItemName itemName = ItemName.of("Aged Brie");
    final Item[] items = new Item[]{new AgedItem(itemName, 10, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new AgedItem(itemName, 9, 6);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_not_increase_the_quality_if_is_fifty() {
    final ItemName itemName = ItemName.of("Aged Brie");
    final Item[] items = new Item[]{new AgedItem(itemName, 10, 50)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new AgedItem(itemName, 9, 50);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_sulfuras_item_never_decreases_quality_nor_sellin() {
    final ItemName itemName = ItemName.of("Sulfuras, Hand of Ragnaros");
    final Item[] items = new Item[]{new LegendaryItem(itemName, 10, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new LegendaryItem(itemName, 10, 5);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_backstages_increases_quality_with_selling_more_than_ten() {
    final ItemName itemName = ItemName.of("Backstage passes to a TAFKAL80ETC concert");
    final Item[] items = new Item[]{
        new BackstagePassesItem(itemName, 11, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new BackstagePassesItem(itemName, 10, 6);
    assertEquals(expected, app.getItems()[0]);
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 9, 8, 7, 6})
  void should_backstages_increases_by_two_quality_with_selling_between_ten_and_six(final int sellin) {
    final ItemName itemName = ItemName.of("Backstage passes to a TAFKAL80ETC concert");
    final Item[] items = new Item[]{
        new BackstagePassesItem(itemName, sellin, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new BackstagePassesItem(itemName, sellin - 1,
        7);
    assertEquals(expected, app.getItems()[0]);
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 4, 3, 2, 1})
  void should_backstages_increases_by_three_quality_with_selling_less_than_five(final int sellin) {
    final ItemName itemName = ItemName.of("Backstage passes to a TAFKAL80ETC concert");
    final Item[] items = new Item[]{
        new BackstagePassesItem(itemName, sellin, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new BackstagePassesItem(itemName, sellin - 1,
        8);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_backstages_drop_quality_to_zero_with_selling_zero() {
    final ItemName itemName = ItemName.of("Backstage passes to a TAFKAL80ETC concert");
    final Item[] items = new Item[]{
        new BackstagePassesItem(itemName, 0, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new BackstagePassesItem(itemName, -1, 0);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_conjured_items_decrease_the_quality_twice_fast_as_regular() {
    final ItemName itemName = ItemName.of("Conjured");
    final Item[] items = new Item[]{new ConjuredItem(itemName, 10, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new ConjuredItem(itemName, 9, 3);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_conjured_items_decrease_the_quality_twice_fast_when_negative_sellin_as_regular() {
    final ItemName itemName = ItemName.of("Conjured");
    final Item[] items = new Item[]{new ConjuredItem(itemName, -1, 6)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new ConjuredItem(itemName, -2, 2);
    assertEquals(expected, app.getItems()[0]);
  }

}
