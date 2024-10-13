package propertytaxcalculator;

import java.util.ArrayList;
import java.util.List;

public class PropertyOwner {
    private String name;
    private int age;
    private List<Property> properties;

    public PropertyOwner(String name, int age) {
        this.name = name;
        this.age = age;
        this.properties = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public double descount() {
        double valorTaxas = 0.0;

        for (Property property : properties) {
            valorTaxas += property.grossTax();
        }
        if(getAge() > 60 && properties.size() > 1){
            valorTaxas = valorTaxas * 0.80;
        }
        return valorTaxas;
    }
}
