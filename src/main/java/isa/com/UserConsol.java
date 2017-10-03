package isa.com;

import org.json.JSONException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserConsol {

    private Scanner scanner = new Scanner(System.in);
    private static final int READ_FILE = 1;
    private static final int CALCULATE = 2;
    private static final int EXIT = 3;
    private BaseCurrency baseCurrency;
    private ArrayList<TargetCurrency> targetCurrencyList;
    private String chosenCurrency;
    private Double amount;

    public void userMenu() {

        boolean quit = false;
        do {
            try {
                System.out.println("\nPRZELICZNIK WALUT\nWybierz jedną z dostępnych opcji\n" +
                        "1. Wczytaj plik z walutami\n2. Przelicz wybrane waluty\n3. Wyjście z programu\n");
                Integer userChoise = Integer.parseInt(scanner.nextLine());

                switch (userChoise) {
                    case READ_FILE:
                        System.out.println("Wczytaj plik z walutami\n");
                        JSONReader jsonReader = new JSONReader();
                        boolean isFileReadFine = false;
                        while (!isFileReadFine) {
                            System.out.println("Podaj sciezke pliku");
                            jsonReader.setPathFile(scanner.nextLine());
                            try {
                                baseCurrency = jsonReader.setBaseCurrencyValues(jsonReader.fileReader());
                                targetCurrencyList = jsonReader.setTargetCurrencyValues(jsonReader.fileReader());
                                isFileReadFine = true;
                            } catch (JSONException | FileNotFoundException e) {
                            }
                        }
                        System.out.println("Plik został wczytany\n");
                        System.out.println("Waluta podstawowa: " + baseCurrency + "\n");
                        System.out.println("Inne waluty: \n");
                        for (TargetCurrency e : targetCurrencyList) {
                            System.out.println(e);
                        }
                        break;
                    case CALCULATE:
                        System.out.println("Dostępne waluty: \n");
                        for (TargetCurrency e : targetCurrencyList) {
                            System.out.println(e.getCode() + " - " + e.getName());
                        }
                        System.out.println("\n Podaj kwote, którą chcesz przeliczyć");
                        amount = Double.parseDouble(scanner.nextLine());
                        System.out.println("\n Wybierz walute, którą chcesz otrzymać (np.USD): ");
                        chosenCurrency = scanner.nextLine();
                        try {
                            CurrencyCalculator calc = new CurrencyCalculator(baseCurrency, filtrList(), amount);
                            System.out.println("Przeliczona wartość w wybranej walucie to " + calc.convertCurrency());
                        } catch (IndexOutOfBoundsException a) {
                            System.out.println("Brak danych dla wybranej waluty. Spróbuj ponownie");
                        }

                        break;
                    case EXIT:
                        quit = true;
                        break;
                    default:
                        System.out.println("Wybrana opcja nie istnieje. Spróbuj ponownie");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wybrana opcja nie istnieje. Spróbuj ponownie");
            } catch (NullPointerException e) {
                System.out.println("Brak danych do obliczeń. Wczytaj plik");
            }
        }
        while (!quit);
    }

    public ArrayList<TargetCurrency> filtrList() {

        ArrayList<TargetCurrency> filterList = targetCurrencyList.stream()
                .filter(o -> o.getCode().contentEquals(chosenCurrency))
                .collect(Collectors.toCollection(ArrayList::new));
        return filterList;
    }
}