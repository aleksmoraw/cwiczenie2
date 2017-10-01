package isa.com;

public class BaseCurrency {

    private String baseCode;
    private String baseName;
    private Double baseValue;

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public Double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(Double baseValue) {
        this.baseValue = baseValue;
    }

    @Override
    public String toString() {
        return " Kod='" + baseCode + '\'' +
                ", Nazwa='" + baseName + '\'' +
                ", Wartość=" + baseValue +
                '}';
    }
}

