package propertytaxcalculator;

import java.util.Objects;

public class Property {
    private String type;
    private double value;
    private int yearsOld;

    public Property(String type, double value, int yearsOld) {
        this.type = type;
        this.value = value;
        this.yearsOld = yearsOld;
    }

    public String getType() {
        return type;
    }


    public double getValue() {
        return value;
    }


    public int getYearsOld() {
        return yearsOld;
    }

    public double taxProperty() {
        return Objects.equals(getType(), "Residencial") ? getValue() * 0.01 :
                Objects.equals(getType(), "Comercial") ? getValue() * 0.015 : 0.0;
        /*
        if(Objects.equals(getType(), "Residencial")){
            return getValue() * 0.01;
        }else if(Objects.equals(getType(), "Comercial")){
            return getValue() * 0.015;
        }else{
            return 0.0;
        }

         */
    }

    public double serviceCharge() {
        return getYearsOld() <= 20 ? getValue() * 0.01 : getValue() * 0.02;
    }

    public double grossTax() {
        return taxProperty() + serviceCharge();
    }

}
