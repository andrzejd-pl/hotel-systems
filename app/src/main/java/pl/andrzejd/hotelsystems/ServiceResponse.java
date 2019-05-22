package pl.andrzejd.hotelsystems;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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