package com.model;

public class Custody {

    public String securityId;
    public String securityIdType;
    public int quantity;
    public float price;
    public float marketValueBase;
    public float marketValueLocal;
    public String broker;
    public String currency;
    public String effectiveDate;
    public String fundId;


    // Getters and setters and toString method go here.

    public Custody() {
    }

    public Custody(String securityId, String securityIdType, int quantity, float price, float marketValueBase,
                   float marketValueLocal, String broker, String currency, String effectiveDate, String fundId) {
        this.securityId = securityId;
        this.securityIdType = securityIdType;
        this.quantity = quantity;
        this.price = price;
        this.marketValueBase = marketValueBase;
        this.marketValueLocal = marketValueLocal;
        this.broker = broker;
        this.currency = currency;
        this.effectiveDate = effectiveDate;
        this.fundId = fundId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    @Override
    public String toString() {
        return "Custody [securityId=" + securityId + ", securityIdType=" + securityIdType + ", quantity=" + quantity +
                ", price=" + price + ", marketValueBase=" + marketValueBase +  ", marketValueLocal=" + marketValueLocal + "]";
    }
}
