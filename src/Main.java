import propertytaxcalculator.Property;
import propertytaxcalculator.PropertyOwner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<PropertyOwner> propertyOwners = new ArrayList<>();

        System.out.print("Quantos proprietários: ");
        int quantityOwner = sc.nextInt();

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
                System.out.print("Tipo: (Residencial / Comercial): ");
                sc.nextLine();
                String type = sc.nextLine();

                System.out.print("Valor : ");
                double value = sc.nextDouble();

                System.out.print("Anos: ");
                int yearsOld = sc.nextInt();


                Property prop = new Property(type,value, yearsOld);
                propertyOwner.getProperties().add(prop);
            }

            propertyOwners.add(propertyOwner);
        }
        for (PropertyOwner propertyOwner : propertyOwners) {
            propertyOwner.displaySummary();
        }
    }
}