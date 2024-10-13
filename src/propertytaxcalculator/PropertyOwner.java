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

    public double discount() {
        double valorTaxas = 0.0;

        for (Property property : properties) {
            valorTaxas += property.grossTax();
        }
        if (getAge() > 60 && properties.size() > 1) {
            valorTaxas = valorTaxas * 0.80;
        }
        return valorTaxas;
    }

    public void displaySummary() {
        System.out.println("Proprietário: " + getName());
        System.out.println("Idade: " + getAge());
        System.out.println("Propriedades: ");


        for (Property property : properties) {
            System.out.printf(" - Tipo: %s, Valor R$ %.2f, Anos: %d%n ",
                    property.getType(),
                    property.getValue(),
                    property.getYearsOld());
            System.out.printf("imposto: R$ %.2f, Manutenção: R$ %.2f%n ",
                    property.taxProperty(),
                    property.serviceCharge());

            System.out.printf("Total de taxas sem desconto: R$ %.2f%n ", property.grossTax());
            System.out.println();
        }
        if (properties.size() > 1) {
            System.out.println("Desconto 20%");
        } else {
            System.out.println("Sem desconto");
        }
        System.out.printf("Total a pagar: %.2f ", discount());
    }
}
