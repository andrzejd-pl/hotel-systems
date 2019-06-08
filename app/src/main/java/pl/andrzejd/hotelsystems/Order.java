package pl.andrzejd.hotelsystems;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import pl.andrzejd.hotelsystems.services.Service;

public class Order {

    @SerializedName("orderId")
    int orderId;
    @SerializedName("data")
    Date data;
    private List<Service> orderedServices;


    public Order(int orderId, int userId, List<Service> orderedServices) {
        this.orderId = orderId;
        this.orderedServices = orderedServices;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Service> getOrderedServices() {
        return orderedServices;
    }

    public void setOrderedServices(List<Service> orderedServices) {
        this.orderedServices = orderedServices;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
