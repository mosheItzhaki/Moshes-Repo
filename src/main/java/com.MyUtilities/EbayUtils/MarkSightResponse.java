package com.MyUtilities.EbayUtils;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;

/**
 *
 *  Created by moshe on 21/05/2017.
 */

public class MarkSightResponse {

    @SerializedName("isQuickStats")
    private boolean isQuickStats;

    @SerializedName("categories")
    private LinkedList<EbayCategory> ebayCategories;

    public LinkedList<EbayCategory> getEbayCategories() {
        return ebayCategories;
    }

    public boolean isQuickStats() {
        return isQuickStats;
    }

    public void setEbayCategories(LinkedList<EbayCategory> ebayCategories) {
        this.ebayCategories = ebayCategories;
    }

    public void setQuickStats(boolean quickStats) {
        isQuickStats = quickStats;
    }

}

