package pl.andrzejd.hotelsystems.orders;

import java.util.ArrayList;
import java.util.List;

import pl.andrzejd.hotelsystems.Order;

public class OrderResponse extends ArrayList<Order> {

    public List<Order> getOrders() {
        return this;
    }
}