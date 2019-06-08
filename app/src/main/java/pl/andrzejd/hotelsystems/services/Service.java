package pl.andrzejd.hotelsystems.services;

import com.google.gson.annotations.SerializedName;

public class Service {

    @SerializedName("serviceId")
    int serviceId;
    @SerializedName("name")
    String name;
    @SerializedName("price")
    Double price;

    public Service(int serviceId, String name, Double price) {
        this.serviceId = serviceId;
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getName() {
        return name;
    }
}
