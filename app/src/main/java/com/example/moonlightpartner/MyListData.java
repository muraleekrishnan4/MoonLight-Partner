package com.example.moonlightpartner;


import java.util.List;

public class MyListData{
    private String customerName,customerAddress,customerNumber;
    List<String> foodID,foodQuantity;
    private int orderId;

    public MyListData(String customerName, String customerAddress, String customerNumber, List<String> foodID, List<String> foodQuantity, int orderId) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerNumber = customerNumber;
        this.foodID = foodID;
        this.foodQuantity = foodQuantity;
        this.orderId = orderId;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<String> getFoodID() {
        return foodID;
    }

    public void setFoodID(List<String> foodID) {
        this.foodID = foodID;
    }

    public List<String> getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(List<String> foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}