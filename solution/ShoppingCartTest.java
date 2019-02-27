package com.intuit.pcg.training;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by prajendran1 on 6/12/18.
 */
public class ShoppingCartTest {

    @Test
    public void shouldReturnFinalPriceForMultipleItems(){

        List<Item> items = createItems();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setItems(items);
//        when(items.get(0).calculateCost()).thenReturn(900);
//        when(items.get(1).calculateCost()).thenReturn(216);
//        when(items.get(2).calculateCost()).thenReturn(226);
//        when(items.get(3).calculateCost()).thenReturn(2592);
//        when(items.get(4).calculateCost()).thenReturn(1130);
        int totalPrice = shoppingCart.calculateTotalPrice();
        assertEquals(900+216+226+2592+1130, totalPrice);
    }

    private List<Item> createItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(createItem("item 1", 300, 3, TaxStatus.TAX_EXEMPT));
        items.add(createItem("item 2", 100, 2, TaxStatus.OTHER));
        items.add(createItem("item 3", 200, 1, TaxStatus.LUXURY));
        items.add(createItem("item 4", 600, 4, TaxStatus.OTHER));
        items.add(createItem("item 5", 500, 2, TaxStatus.LUXURY));
        return items;

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