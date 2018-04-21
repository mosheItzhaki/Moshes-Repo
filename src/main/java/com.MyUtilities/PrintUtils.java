package com.MyUtilities;

/**
 * Created by moshe on 27/05/2017.
 */
public class PrintUtils {

    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";
    //Reset code
    private static final String RESET = "\u001B[0m";


    public static void printGreen(String string){
        System.out.print(GREEN+string+RESET);
    }
    public static void printGreenln(String string){
        System.out.println(GREEN+string+RESET);
    }

    public static void printYellow(String string){
        System.out.print(YELLOW+string+RESET);
    }

    public static void printYellowln(String string){
        System.out.println(YELLOW+string+RESET);
    }
    public static void printCYAN(String string){
        System.out.print(CYAN+string+RESET);
    }

    public static void printCYANln(String string){
        System.out.println(CYAN+string+RESET);
    }

    public static void printBlue(String string){
        System.out.print(BLUE+string+RESET);
    }

    public static void printBlueln(String string){
        System.out.println(BLUE+string+RESET);
    }
    public static void printPurple(String string){
        System.out.print(PURPLE+string+RESET);
    }

    public static void printPurpleln(String string){
        System.out.println(PURPLE+string+RESET);
    }

    public static void printRed(String string){
        System.out.print(RED+string+RESET);
    }
    public static void printRedln(String string){
        System.out.println(RED+string+RESET);
    }

}
