package isa.com;

import java.util.ArrayList;

public class CurrencyCalculator {

    private Double amount;
    private Double targetAmount;
    private BaseCurrency baseCurrency;
    private ArrayList<TargetCurrency> targetCurrencyList;

    public CurrencyCalculator(BaseCurrency baseCurrency, ArrayList<TargetCurrency> targetCurrencyList, Double amount) {
        this.amount = amount;
        this.baseCurrency = baseCurrency;
        this.targetCurrencyList = targetCurrencyList;
    }

    public Double convertCurrency() {
        targetAmount = baseCurrency.getBaseValue() * amount * targetCurrencyList.get(0).getValue();
        return targetAmount;
    }
}