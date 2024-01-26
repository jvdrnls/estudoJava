package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;


import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of products: ");
        int n = sc.nextInt();
        List<Product> list = new ArrayList<>();

        for (int i = 1; i<=n; i++) {
           System.out.println("Product #" + i + " data: ");
           System.out.print("Common, used or imported? (c/u/i)? ");
           char c = sc.next().charAt(0);

           sc.nextLine();
           System.out.print("Name: ");
           String name = sc.nextLine();

           System.out.print("Price: ");
           double price = sc.nextDouble();

           if (c == 'c') {
               Product product = new Product(name,price);
               list.add(product);
           } else if (c == 'u') {
               DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
               System.out.print("Manufacture date: ");
               String dateString = sc.next();
               LocalDate manufactureDate = LocalDate.parse(dateString, fmt1);
               Product product = new UsedProduct(name, price, manufactureDate);
               list.add(product);

           } else if (c == 'i') {
               System.out.print("Customs fee: ");
               double customsFee = sc.nextDouble();
               Product product = new ImportedProduct(name, price, customsFee);
               list.add(product);
           }
        }

        System.out.println("PRICE TAGS: ");
        for (Product product : list) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}
