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


                propertyOwners.add(propertyOwner);
            }
        }
        for (PropertyOwner propertyOwner : propertyOwners) {
            propertyOwner.displaySummary();
            System.out.println();
        }
    }
}