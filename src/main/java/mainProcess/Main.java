package mainProcess;

import coinPack.*;

import java.awt.*;
import java.io.File;
import java.util.Scanner;


public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ResultsList list = new ResultsList();                           //initiate result list

        boolean startAgain = true;                                      //user's choice to stay / exit
        System.out.println("Welcome to currency converter");

        //loop for multiple currency conversions

        while (startAgain == true) {
            Coin coin = firstScreen();                                  //first screen
            double result = secondScreen(coin);                         //second screen
            Result coinResult = new Result(coin.getClass().getSimpleName(), coin.getTotalValue());   //make result object
            list.addList(coinResult);                                   //save result in list

            startAgain = thirdScreen(result, coin);                     //third screen - outputs "startAgain" choice
        }
        forthScreen(list);                                              //forth screen

    }


    //first screen methode - user's currency choice

    private static Coin firstScreen() {

        int choose = -1;
        System.out.println("Please choose an option(1/2): \n" +
                "  1. Dollars to Shekels \n" +
                "  2. Shekels to Dollars \n" +
                "  3. Shekels to Euro");
        try {
            choose = scan.nextInt();                                    // validates input
        } catch (Exception e) {
            scan = new Scanner(System.in);
            System.out.println("invalid choice, please try again");
            return (firstScreen());                                     // start method again until input is valid
        }
        Coin coin = null;
        switch (choose) {
            case (-1) -> {
                break;
            }
            case 1 -> {
                coin = CoinFactory.getCoin("ILS");
            }
            case 2 -> {
                coin = CoinFactory.getCoin("USD");
            }
            case 3 -> {
                coin = CoinFactory.getCoin("EURO");
            }
            default -> {
                System.out.println("invalid choice, please try again"); //ask again when input invalid
                return (firstScreen());                                 // start method again until input is valid
            }
        }

        return coin;
    }

    //second screen methode - gets user's amount, returns total value

    private static double secondScreen(Coin coin) {
        scan = new Scanner(System.in);                                  //new scanner object
        double amount;
        System.out.println("Please enter an amount to convert");
        try {
            amount = scan.nextDouble();                                 //user's amount input
            if (amount < 0) {                                           //converts only positive amount
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("invalid input, please try again");
        return (secondScreen(coin));                                    // start method again until input is valid
        }
    return (coin.calculate(amount));                                    //returns total converted result

    }

    //third screen - prints result, returns user's choice (convert again / exit)

    private static boolean thirdScreen(double result, Coin coin) {
        scan = new Scanner(System.in);                                  //new scanner object
        System.out.println("Result is: " + result + " " + coin.getClass().getSimpleName());      //print result

        System.out.println("Start Again? (Y / N )");
        String again;
        try {
            again = scan.nextLine();                                    // user's input
        } catch (Exception e) {
            System.out.println("invalid choice, please try again");
            return (thirdScreen(result, coin));                         // start method again until input is valid
        }


        switch (again) {
            case "Y" -> {
                return true;
            }
            case "N" -> {
                return false;
            }
            default -> {
                System.out.println("invalid choice, please try again");
                return thirdScreen(result, coin);                        // start method again until input is valid
            }
        }

    }

    //forth screen - print conversions, write to "results.txt"

    private static void forthScreen(ResultsList list) {
        System.out.println("Thanks for using our currency converter\n Your last currency conversions: ");
        list.printList();
        list.writeToTFile();

        Desktop desktop = Desktop.getDesktop();
        try{
        desktop.open(new File("results.txt"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}