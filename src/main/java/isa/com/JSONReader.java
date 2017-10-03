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

    private String pathFile;

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public JSONObject fileReader() throws FileNotFoundException, JSONException {
        JSONObject obj = new JSONObject();
        String jsonData = "";
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(pathFile)); //"/home/ola/IdeaProjects/currencies.json"
            while ((line = br.readLine()) != null) {
                jsonData += line + "\n";
            }
        } catch (IOException e) {
            System.out.println("Brak pliku\n");
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            obj = new JSONObject(jsonData);
        } catch (JSONException j) {

        }
        return obj;
    }

    public BaseCurrency setBaseCurrencyValues(JSONObject obj) {

        JSONObject baseCurr = obj.getJSONObject("baseCurrency");
        BaseCurrency baseCurrency = new BaseCurrency();
        baseCurrency.setBaseCode(baseCurr.getString("code"));
        baseCurrency.setBaseName(baseCurr.getString("name"));
        baseCurrency.setBaseValue(baseCurr.getDouble("value"));
        return baseCurrency;
    }

    public ArrayList<TargetCurrency> setTargetCurrencyValues(JSONObject obj) {

        JSONArray array = obj.getJSONArray("currencies");
        ArrayList<TargetCurrency> targetCurrencyList = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            TargetCurrency targetCurrency = new TargetCurrency();
            targetCurrency.setCode(array.getJSONObject(i).getString("code"));
            targetCurrency.setName(array.getJSONObject(i).getString("name"));
            targetCurrency.setValue(array.getJSONObject(i).getDouble("value"));
            targetCurrencyList.add(targetCurrency);
        }
        return targetCurrencyList;
    }
}