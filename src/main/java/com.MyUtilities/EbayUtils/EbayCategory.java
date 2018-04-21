package com.MyUtilities.EbayUtils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by moshe on 21/05/2017.
 */
public class EbayCategory {

    @SerializedName("category")
    private String categoryName;

    @SerializedName("sold")
    private int NumOfSoldProducts;

    @SerializedName("unsold")
    private int NumOfUnsoldProduct;

    @SerializedName("sellthrough")
    private String sellsPercentage;

    public int getNumOfSoldProducts() {
        return NumOfSoldProducts;
    }
    public int getNumOfUnsoldProduct() {
        return NumOfUnsoldProduct;
    }
    public float getSellsPercentage() {
        return Float.valueOf(sellsPercentage.replace("%",""));
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setNumOfSoldProducts(int numOfSoldProducts) {
        NumOfSoldProducts = numOfSoldProducts;
    }

    public void setNumOfUnsoldProduct(int numOfUnsoldProduct) {
        NumOfUnsoldProduct = numOfUnsoldProduct;
    }

    public void setSellsPercentage(String sellsPercentage) {
        this.sellsPercentage = sellsPercentage;
    }
}
