package pl.andrzejd.hotelsystems.services;

import java.util.ArrayList;
import java.util.List;

import pl.andrzejd.hotelsystems.services.Service;

public class ServiceResponse extends ArrayList<Service> {
//    @SerializedName("services")
//    private List<Service> services;

    public List<Service> getServices() {
        return this;
    }

//    public void setResults(List<Service> services) {
//        this = services;
//    }

}