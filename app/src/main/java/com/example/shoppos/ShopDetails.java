package com.example.shoppos;

public class ShopDetails {

    String userPhone, shopName, userPassword;

    public ShopDetails() {
    }

    public ShopDetails(String userPhone, String shopName, String userPassword) {
        this.userPhone = userPhone;
        this.shopName = shopName;
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
