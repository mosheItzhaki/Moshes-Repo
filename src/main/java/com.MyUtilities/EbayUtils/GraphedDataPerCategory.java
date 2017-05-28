package com.MyUtilities.EbayUtils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Object;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by moshe on 22/05/2017.
 */
public class GraphedDataPerCategory {

    @SerializedName("graphedItems")
   private String totalNumberOfListedItems;

    @SerializedName("isQuickStats")
    private boolean isQuickStats;

    @SerializedName("solditems")
    private String numberOfSoldItems;

    @SerializedName("unsolditems")
    private String numberOfUnsoldItems;

    @SerializedName("sellthrough")
    private String salesRatePercentage;

    @SerializedName("graph")
    private GraphTotal[] graphTotal;

    @SerializedName("dailyStats")
    private Map<String, DailySalesGraph> weekDayMap;

    @SerializedName("average")
    private String averageOfSoldItemsPrice;

    public String getAverageOfSoldItemsPrice() {
        return averageOfSoldItemsPrice;
    }

    public boolean isQuickStats() {
        return isQuickStats;
    }

    public Map<String, DailySalesGraph> getWeekDayGraph() {
        return weekDayMap;
    }

    public String getNumberOfSoldItems() {

        return numberOfSoldItems.replace("Sold/Unsold<br/>","");
    }

    public int getNumberOfUnsoldItems() {

        return Integer.parseInt(numberOfSoldItems.replace("Unsold items<br/>",""));

    }

    public float getSalesRatePercentage() {
        return Float.parseFloat(salesRatePercentage.replace("Sell through<br/>","").replace("%",""));
    }

    public int getTotalNumberOfListedItems() {
        return Integer.parseInt(totalNumberOfListedItems.replace("Graph Shows<br/>","").replace(" items",""));
    }

    public void setAverageOfSoldItemsPrice(String averageOfSoldItemsPrice) {
        this.averageOfSoldItemsPrice = averageOfSoldItemsPrice;
    }

    public void setNumberOfSoldItems(String numberOfSoldItems) {
        this.numberOfSoldItems = numberOfSoldItems;
    }

    public void setNumberOfUnsoldItems(String numberOfUnsoldItems) {
        this.numberOfUnsoldItems = numberOfUnsoldItems;
    }

    public void setSalesRatePercentage(String salesRatePercentage) {
        this.salesRatePercentage = salesRatePercentage;
    }

    public void setTotalNumberOfListedItems(String totalNumberOfListedItems) {
        this.totalNumberOfListedItems = totalNumberOfListedItems;
    }

    public GraphTotal[] getGraphTotal() {
        return graphTotal;
    }

    private void setGraphTotal(GraphTotal[] graphTotal) {
        this.graphTotal = graphTotal;
    }

    public class GraphTotal {
        @SerializedName("Name")
      private String name;

        @SerializedName("Value")
      private int numberOfSoldItems;

        public void setName(String name) {
            this.name = name;
        }

        public void setNumberOfSoldItems(int numberOfSoldItems) {
            this.numberOfSoldItems = numberOfSoldItems;
        }


        public int getNumberOfSoldItems() {
            return numberOfSoldItems;
        }

        public String getName() {
            return name.replace("\n*","");
        }
    }

    public class DailySalesGraph{

        @SerializedName("total")
        private int totalSalesPerDay;

        @SerializedName("totAmount")
        private String sumOfSalesPerDay;

        @SerializedName("avg")
        private String averagePricePerItem;

        @SerializedName("sellthrough")
       private String salesPercentagePerDay;

        public void setAveragePricePerItem(String averagePricePerItem) {
            this.averagePricePerItem = averagePricePerItem;
        }

        public void setSalesPercentagePerDay(String salesPercentagePerDay) {
            this.salesPercentagePerDay = salesPercentagePerDay;
        }

        public void setSumOfSalesPerDay(String sumOfSalesPerDay) {
            this.sumOfSalesPerDay = sumOfSalesPerDay;
        }

        public void setTotalSalesPerDay(int totalSalesPerDay) {
            this.totalSalesPerDay = totalSalesPerDay;
        }

        public float getSalesPercentagePerDay() {
            return Float.parseFloat(salesPercentagePerDay.replace("%",""));
        }

        public float getSumOfSalesPerDay() {
            return Float.parseFloat(sumOfSalesPerDay.replace("$",""));
        }

        public int getTotalSalesPerDay() {
            return totalSalesPerDay;
        }

        public float getAveragePricePerItem() {
            return Float.parseFloat(averagePricePerItem.replace("$",""));
        }
    }
}

