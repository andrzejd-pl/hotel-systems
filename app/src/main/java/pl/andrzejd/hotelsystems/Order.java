package pl.andrzejd.hotelsystems;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import pl.andrzejd.hotelsystems.services.Service;

public class Order {

    @SerializedName("orderId")
    int orderId;
    @SerializedName("userId")
    int userId;
    @SerializedName("date")
    Date date;

    public Order(int orderId, int userId, Date date) {
        this.orderId = orderId;
        this.userId = userId;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
