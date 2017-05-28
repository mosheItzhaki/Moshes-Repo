package Tests;

import com.MyUtilities.EbayUtils.*;
import com.MyUtilities.PrintUtils;
import com.ebay.sdk.handler.EBayServiceHandlerResolver;
import com.ebay.soap.eBLBaseComponents.AddDisputeRequestType;
import com.ebay.soap.eBLBaseComponents.EBayAPIInterfaceService;
import com.ebay.soap.eBLBaseComponents.GetAccountRequestType;
import com.ebay.soap.eBLBaseComponents.MailOptionsTypeCodeType;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.types.FacebookType;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by moshe on 10/04/2017.
 */

public class TestUtil {

    public static void main(String[] args) throws IOException {

        String searchData = "Spinner";
        for (EbayCategoryType categoryType : EbayCategoryType.values()) {
            if (categoryType != EbayCategoryType.ALL_CATEGORIES) {
                try {
                    PrintUtils.printBlueln("****************************************************************");
                    System.out.println("Searching in category: " + categoryType);
                    MarkSightApi query = new MarkSightApi(searchData, categoryType);
                    GraphedDataPerCategory averageOfSoldItemsPrice = query.searchMarkSightSpecific();

                    int maxValue = 0;
                    for (int i = 0; i < averageOfSoldItemsPrice.getWeekDayGraph().size(); i++) {
                        if (averageOfSoldItemsPrice.getWeekDayGraph().get(DayOfWeek.values()[i].toString()).getTotalSalesPerDay() > maxValue) {
                            maxValue = averageOfSoldItemsPrice.getWeekDayGraph().get(DayOfWeek.values()[i].toString()).getTotalSalesPerDay();
                        }
                    }
                    for (int i = 0; i < averageOfSoldItemsPrice.getWeekDayGraph().size(); i++) {
                        if (averageOfSoldItemsPrice.getWeekDayGraph().get(DayOfWeek.values()[i].toString()).getTotalSalesPerDay() == maxValue) {
                            System.out.println("Search best sold on " + DayOfWeek.values()[i].name() + ", with number of sold items : " + maxValue);
                            for (int n = 0; n < averageOfSoldItemsPrice.getGraphTotal().length; n++) {
                                if (averageOfSoldItemsPrice.getGraphTotal()[n].getNumberOfSoldItems() > 100){

                                    PrintUtils.printPurple(""+averageOfSoldItemsPrice.getGraphTotal()[n].getNumberOfSoldItems());
                                    PrintUtils.printPurpleln(": " + averageOfSoldItemsPrice.getGraphTotal()[n].getName());
                                }else {
                                    System.out.print(averageOfSoldItemsPrice.getGraphTotal()[n].getNumberOfSoldItems());
                                    System.out.println(": " + averageOfSoldItemsPrice.getGraphTotal()[n].getName());

                                }
                            }

                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    continue;
                }

                PrintUtils.printBlueln("****************************************************************");

            }
        }
    }

    public void facebook(){
        FacebookClient facebookClient;

    }

}


