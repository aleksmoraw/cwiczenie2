package isa.com;


import java.util.ArrayList;
import java.util.Scanner;

public class UserConsol {

    private Scanner scanner = new Scanner(System.in);

    public void userMenu () {

        System.out.println("PRZELICZNIK WALUT\nWybierz jedną z dostępnych opcji\n" +
                "1. Wczytaj plik z walutami\n2. Przelicz wybrane waluty\n3. Wyjście z programu\n");
        Integer userChoise = Integer.parseInt(scanner.nextLine());

        switch(userChoise) {
            case 1:
                System.out.println("Wczytaj plik z walutami\n\nPodaj ścieżkę pliku");
                JSONReader jsonReader = new JSONReader();
                jsonReader.setPathFile(scanner.nextLine());
                BaseCurrency baseCurrency = jsonReader.setBaseCurrencyValues(jsonReader.fileReader());
                ArrayList<TargetCurrency> targetCurrencyList = jsonReader.setTargetCurrencyValues(jsonReader.fileReader());
                System.out.println("Plik został wczytany");
                System.out.println("Waluta podstawowa: " + baseCurrency);
                System.out.println("Inne waluty: " + targetCurrencyList);
                break;
            case 2:
                break;
        }




    }


        }




   



