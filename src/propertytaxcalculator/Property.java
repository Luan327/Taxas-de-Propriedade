package propertytaxcalculator;

public class Property {
    private String type;
    private double value;
    private int yearsOld;

    public Property(String type, double value, int yearsOld) {
        this.type = type;;
        this.value = value;
        this.yearsOld = yearsOld;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
}
