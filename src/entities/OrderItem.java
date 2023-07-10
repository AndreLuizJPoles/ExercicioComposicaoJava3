package entities;

public class OrderItem {
    private Integer quantity;
    private Product product;
    private Double price;

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        price = product.getPrice();
    }

    public OrderItem() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return product.getName() + ", " +
                "$" + String.format("%.2f", price) + ", " +
                "Quantity: " + quantity + ", " +
                "Subtotal: $" + String.format("%.2f", subTotal());
    }

    public Double subTotal(){
        return quantity * price;
    }
}
