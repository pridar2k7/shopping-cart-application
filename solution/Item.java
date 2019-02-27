package com.intuit.pcg.training;

/**
 * Created by prajendran1 on 6/12/18.
 */
public class Item {

    private String name;
    private Integer price;
    private int unit;
    private TaxStatus taxStatus;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setTaxStatus(TaxStatus taxStatus) {
        this.taxStatus = taxStatus;
    }

    public int calculateCost() {
        int costBeforeTax = price * unit;
        if(TaxStatus.LUXURY.equals(taxStatus)) {
            return (costBeforeTax + ((costBeforeTax * 13) / 100));
        } else if(TaxStatus.OTHER.equals(taxStatus)) {
            return (costBeforeTax + ((costBeforeTax * 8) / 100));
        } else {
            return costBeforeTax;
        }
    }
}
