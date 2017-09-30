package isa.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONReader {

    public static void main(String[] args) throws FileNotFoundException, JSONException {

        String jsonData = "";
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("/home/ola/IdeaProjects/currencies.json"));
            while ((line = br.readLine()) != null) {
                jsonData += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        JSONObject obj = new JSONObject(jsonData);
        JSONObject baseCurrency = obj.getJSONObject("baseCurrency");
        BaseCurrency baseCurr = new BaseCurrency();
        baseCurr.setBaseCode(baseCurrency.getString("code"));
        baseCurr.setBaseName(baseCurrency.getString("name"));
        baseCurr.setBaseValue(baseCurrency.getDouble("value"));
        JSONArray array = obj.getJSONArray("currencies");
        ArrayList<TargetCurrency> targetCurrencyList = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            TargetCurrency targetCurrency = new TargetCurrency();
            targetCurrency.setCode(array.getJSONObject(i).getString("code"));
            targetCurrency.setName(array.getJSONObject(i).getString("name"));
            targetCurrency.setValue(array.getJSONObject(i).getDouble("value"));
            targetCurrencyList.add(targetCurrency);
        }



        System.out.println("Waluta podstawowa: " + baseCurrency);
        System.out.println("Inne waluty: " + targetCurrencyList);
        CurrencyCalculator calc = new CurrencyCalculator(baseCurr, targetCurrencyList);
        System.out.println("Przeliczona wartość w wybranej walucie to " + calc.convertCurrency());
    }
}