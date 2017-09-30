package isa.com;

import java.util.ArrayList;

public class CurrencyCalculator {

    private Double amount = 100.00;
    private Double targetAmount;
    private BaseCurrency baseCurrency;
    private ArrayList<TargetCurrency> targetCurrencyList;

    public CurrencyCalculator(BaseCurrency baseCurrency, ArrayList<TargetCurrency> targetCurrencyList) {
        this.baseCurrency = baseCurrency;
        this.targetCurrencyList = targetCurrencyList;
    }

    public Double convertCurrency(){

        targetAmount = baseCurrency.getBaseValue()*amount*targetCurrencyList.get(0).getValue();
        return targetAmount;
    }

}
