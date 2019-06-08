package pl.andrzejd.hotelsystems.services;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class NewOrder {

    @SerializedName("userId")
    int userId;
    @SerializedName("services")
    List<Integer> services;

    public NewOrder(int userId, List<Integer> services) {
        this.userId = userId;
        this.services = services;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getServices() {
        return services;
    }

    public void setServices(List<Integer> services) {
        this.services = services;
    }
}
