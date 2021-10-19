package com.gildedrose;

public final class TexttestFixture {

  public static void main(final String[] args) {
    System.out.println("OMGHAI!");

    final Item[] items = new Item[]{
        new RegularItem(ItemName.of("+5 Dexterity Vest"), SellIn.of(10), Quality.of(20)), //
        new AgedItem(ItemName.of("Aged Brie"), SellIn.of(2), Quality.of(0)), //
        new RegularItem(ItemName.of("Elixir of the Mongoose"), SellIn.of(5), Quality.of(7)), //
        new LegendaryItem(ItemName.of("Sulfuras, Hand of Ragnaros"), SellIn.of(0), Quality.of(80)), //
        new LegendaryItem(ItemName.of("Sulfuras, Hand of Ragnaros"), SellIn.of(-1), Quality.of(80)),
        new BackstagePassesItem(ItemName.of("Backstage passes to a TAFKAL80ETC concert"), SellIn.of(15),
            Quality.of(20)),
        new BackstagePassesItem(ItemName.of("Backstage passes to a TAFKAL80ETC concert"), SellIn.of(10),
            Quality.of(49)),
        new BackstagePassesItem(ItemName.of("Backstage passes to a TAFKAL80ETC concert"), SellIn.of(5), Quality.of(49)),
        new ConjuredItem(ItemName.of("Conjured Mana Cake"), SellIn.of(3), Quality.of(6))};

    final GildedRose app = new GildedRose(items);

    int days = 2;
    if (args.length > 0) {
      days = Integer.parseInt(args[0]) + 1;
    }

    for (int i = 0; i < days; i++) {
      System.out.println("-------- day " + i + " --------");
      System.out.println("name, sellIn, quality");
      for (final Item item : items) {
        System.out.println(item);
      }
      System.out.println();
      app.updateQuality();
    }
  }

}
