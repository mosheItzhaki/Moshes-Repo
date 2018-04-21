package com.MyUtilities.EbayUtils;

/**
 * Created by moshe on 20/05/2017.
 */
public enum EbayCategoryType {
    COINS_AND_PAPER_MONEY("Coins & Paper Money",11116),
    ART("Art",550),
    BABY("Baby",2984),
    ALL_CATEGORIES("All Categories",0),
    BOOKS("Books",267),
    BUSINESS_AND_INDUSTRIAL("Business and Industrial",12576),
    CAMERAS_AND_PHOTO("Cameras and Photo",625),
    CELLPHONES_AND_PDA("Cellphones and PDA's",15032),
    CLOTHING_SHOES_AND_ACCESSORIES("Clothing Shoes And Accessories",11450),
    COLLECTIBLES("Collectibles",1),
    COMPUTERS_AND_NETWORKING("Computers and Networking",58058),
    CONSUMER_ELECTRONICS("Consumer Electronics",293),
    CRAFTS("Crafts",14339),
    ENTERTAINMENT_MEMORABILIA("Entertainment Memorabilia",11232),
    DOLLS_AND_BEARS("Dolls and Bears",237),
    DVDS_AND_MOVIES("DVDs And Movies",11232),
    GIFT_CARDS_AND_COUPONS("Gift Cards And Coupons",172008),
    HEALTH_AND_BEAUTY("Health And Beauty",26395),
    HOME_AND_GARDEN("Home and Garden",11700),
    MUSIC("Music",11233),
    MUSICAL_INSTRUMENTS("Musical Instruments",619),
    PET_SUPPLIES("Pet supplies",1281),
    POTTERY_AND_GLASS("Pottery And Glass",870),
    SPECIALTY_SERVICES("Specialty Services",316),
    SPORTING_GOODS("Sporing goods",382),
    SPORTS_MEM_CARDS_AND_FAN_SHOP("Sports Mem, Cards And Fan Shop",64482),
    STAMPS("Stamps",260),
    TICKETS("Tickets",1305),
    TOYS_AND_HOBBIES("Toys And Hobbies",220),
    JEWELRY_AND_WATCHES("Jewelry And Watches",281),
    TRAVEL("Travel",3252),
    VIDEO_GAMES("Video Games",1249),
    EVERYTHING_ELSE("Everything Else",99),
    ANTIQUES("Antiques",20081);


    private String categoryName;
    private int categoryNumber;

    EbayCategoryType(String categoryName,int categoryNumber){
     this.categoryName =categoryName;
        this.categoryNumber = categoryNumber;
    }


    @Override
    public String toString() {
        return categoryName;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }



}
