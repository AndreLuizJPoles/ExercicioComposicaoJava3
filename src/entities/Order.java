package entities;

import enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;
    private List<OrderItem> items= new ArrayList<>();
    private Client client;

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Order() {
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

        public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String toString() {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMMARY\n");
        sb.append("Order moment: " + formatter1.format(moment) + "\n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client:" + client + "\n");
        sb.append( "Order items:\n");
        for(OrderItem orderItem : items){
            sb.append(orderItem + "\n");
        }
        sb.append(total());

        return sb.toString();
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        double sum = 0;
        for(OrderItem item : items){
            sum += item.subTotal();
        }
        return sum;
    }
}
