package propertytaxcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PropertyOwner {
    private String name;
    private int age;
    private List<Property> properties;

    public PropertyOwner() {
    }

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
        if (age > 60 && properties.size() > 1) {
            valorTaxas *= 0.80;
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

        if (properties.size() > 1 && age > 60) {
            System.out.println("Desconto 20%");
        } else {
            System.out.println("Sem desconto");
        }
        System.out.printf("Total a pagar: %.2f%n ", discount());
    }

    public void entradaDados(List<PropertyOwner> propertyOwners) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos proprietários: ");
        int quantityOwner = sc.nextInt();

        String type = "";
        int tipo = 0;

        for (int i = 0; i < quantityOwner; i++) {
            System.out.print("Nome proprietário: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Idade: ");
            int age = sc.nextInt();

            PropertyOwner propertyOwner = new PropertyOwner(name, age);

            System.out.print("\nQuantas propriedades " + name + " Possui? ");
            int quantityproperties = sc.nextInt();

            for (int j = 0; j < quantityproperties; j++) {

                do {
                    System.out.println("Selecione o tipo do Imóvel:");
                    System.out.println("1 - Residencial");
                    System.out.println("2 - Comercial");
                    System.out.print("Entre com o tipo : ");
                    tipo = sc.nextInt();
                    if (tipo == 1) {
                        type = "Residencial";
                    } else if (tipo == 2) {
                        type = "Comercial";
                    } else {
                        System.out.println("Tipo incorreto, selecione ( 1 ou 2 )");
                    }
                } while (tipo != 1 && tipo != 2);

                System.out.print("Valor: ");
                double value = sc.nextDouble();

                System.out.print("Anos: ");
                int yearsOld = sc.nextInt();
                System.out.println();

                Property prop = new Property(type, value, yearsOld);
                propertyOwner.getProperties().add(prop);

            }
            propertyOwners.add(propertyOwner);
        }
        for (PropertyOwner owner : propertyOwners) {
            owner.displaySummary();
        }
        sc.close();
    }
}
