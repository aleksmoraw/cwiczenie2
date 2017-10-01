package isa.com;


import java.util.ArrayList;
import java.util.Scanner;

public class UserConsol {

    private Scanner scanner = new Scanner(System.in);
    private static final int READ_FILE = 1;
    private static final int CALCULATE = 2;
    private static final int EXIT = 3;
    private BaseCurrency baseCurrency;
    ArrayList<TargetCurrency> targetCurrencyArrayList;

    public void userMenu() {

        boolean quit = false;
        do {
            System.out.println("\nPRZELICZNIK WALUT\nWybierz jedną z dostępnych opcji\n" +
                    "1. Wczytaj plik z walutami\n2. Przelicz wybrane waluty\n3. Wyjście z programu\n");
            Integer userChoise = Integer.parseInt(scanner.nextLine());

            switch (userChoise) {
                case READ_FILE:
                    System.out.println("Wczytaj plik z walutami\n\nPodaj ścieżkę pliku");
                    JSONReader jsonReader = new JSONReader();
                    jsonReader.setPathFile(scanner.nextLine());
                    BaseCurrency baseCurrency = jsonReader.setBaseCurrencyValues(jsonReader.fileReader());
                    ArrayList<TargetCurrency> targetCurrencyList = jsonReader.setTargetCurrencyValues(jsonReader.fileReader());
                    System.out.println("Plik został wczytany\n");
                    System.out.println("Waluta podstawowa: " + baseCurrency + "\n");
                    System.out.println("Inne waluty: \n");
                    for (TargetCurrency e:targetCurrencyList) {
                        System.out.println(e);
                    }
                    break;
                case CALCULATE:
                    System.out.println("Dostępne waluty: ");
                    //CurrencyCalculator calc = new CurrencyCalculator(baseCurrency, targetCurrencyList);
                    //System.out.println("Przeliczona wartość w wybranej walucie to " + calc.convertCurrency());
                    break;
                case EXIT:
                    quit = true;
                    break;

            }

        }   while (!quit) ;





    }
}




   



