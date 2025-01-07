package Question01.Entities;

public class OrderItem {
    private int quantity;
    private double price;
    Product product;

    public OrderItem(Integer quantity, String name, double price) {
        this.quantity = quantity;
        setProduct(name, price);
        setPrice();
    }

    public void setProduct(String name, double price) {
        product = new Product(name, price);
    }

    public double subTotal() {
        return product.getPrice() * quantity;
    }

    public void setPrice() {
        this.price = subTotal();
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return product.toString()+", Subtotal = " + subTotal();
    }
}
