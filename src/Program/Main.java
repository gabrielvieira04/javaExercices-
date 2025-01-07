package Program;
import Program.Entities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.println("enter client name: ");
        String name = sc.nextLine();
        System.out.println("enter client email: ");
        String email = sc.nextLine();
        System.out.println("enter client birthday dd/MM/yyyy: ");
        String birthDay = sc.nextLine();
        LocalDate clientBirthday = LocalDate.parse(birthDay, formatter);

        order.setClient(name, email, clientBirthday);

        System.out.println("Enter order Status: ");
        String orderStatus = sc.nextLine();
        order.setStatus(orderStatus);

        System.out.println("How many items will be in the order ? ");
        int target = sc.nextInt();

        for (int i = 0; i < target; i++) {
            System.out.println("Product #");
            System.out.println("Quantidade: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            System.out.println("Name: ");
            String productName = sc.nextLine();

            System.out.println("Price: ");
            double price = sc.nextDouble();

            order.addItem(quantity, productName, price);
        }
      

        System.out.println(order);



        }
    }
