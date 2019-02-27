package com.intuit.pcg.training;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by prajendran1 on 6/12/18.
 */
public class ItemTest {

    @Test
    public void shouldCalculateTaxForDifferentTypeOfItems(){
        Item item = createItem("item 1", 300, 1, TaxStatus.LUXURY);
        int finalCost = item.calculateCost();
        assertEquals(339, finalCost);

        Item item2 = createItem("item 2", 200, 1, TaxStatus.TAX_EXEMPT);
        int finalCost2 = item2.calculateCost();
        assertEquals(200, finalCost2);

        Item item3 = createItem("item 3", 500, 1, TaxStatus.OTHER);
        int finalCost3 = item3.calculateCost();
        assertEquals(540, finalCost3);
    }

    @Test
    public void shouldCalculateTaxForDifferentTypeOfItemsInMultipleQuantities(){
        Item item = createItem("item 1", 300, 3, TaxStatus.LUXURY);
        int finalCost = item.calculateCost();
        assertEquals(1017, finalCost);

        Item item2 = createItem("item 2", 200, 4, TaxStatus.TAX_EXEMPT);
        int finalCost2 = item2.calculateCost();
        assertEquals(800, finalCost2);

        Item item3 = createItem("item 3", 500, 2, TaxStatus.OTHER);
        int finalCost3 = item3.calculateCost();
        assertEquals(1080, finalCost3);
    }

    private Item createItem(String itemName, int price, int quantity, TaxStatus taxStatus) {
        Item item = new Item();
        item.setName(itemName);
        item.setPrice(price);
        item.setUnit(quantity);
        item.setTaxStatus(taxStatus);
        return item;
    }

}