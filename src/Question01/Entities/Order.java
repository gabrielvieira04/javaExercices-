package Question01.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Order {
    private LocalDate moment;
    private String status;
    private Client client;
    private LinkedList <OrderItem> items = new LinkedList<>();
    private OrderItem orderItem;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Order() {
        this.moment = LocalDate.now();
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addItem(int quantity, String name, double price ) {
        OrderItem item = new OrderItem(quantity, name, price);
        items.add(item);
    }

    public void removeItem(String name) {
        for (OrderItem item : items) {
            if (item.product.getName().equals(name)) {
                items.remove(item);
            } else {
                System.out.println("Item not found");
            }
        }
    }

    public LinkedList<OrderItem> getItems() {
        return items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(String name, String email, LocalDate BirthDate) {
        client = new Client(name, email, BirthDate);
    }

    public double Total(){
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "----------------------------------\n"+
                "Order items: " + getItems() + "\n" +
                "Total Price: " + Total() + "\n" +
                "Order Date: " + getMoment().format(formatter) +"\n"+
                "Order Status: " + getStatus() + "\n" +
                "Client :" + getClient() + "\n" +
                "----------------------------------";
    }
}
