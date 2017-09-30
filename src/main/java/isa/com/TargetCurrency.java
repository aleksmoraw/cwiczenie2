package isa.com;

public class TargetCurrency {

      private String code;
      private String name;
      private Double value;

      public String getCode() {
            return code;
      }

      public void setCode(String code) {
            this.code = code;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public Double getValue() {
            return value;
      }

      public void setValue(Double value) {
            this.value = value;
      }

      @Override
      public String toString() {
            return "TargetCurrency{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", value=" + value +
                    '}';

      }
}

