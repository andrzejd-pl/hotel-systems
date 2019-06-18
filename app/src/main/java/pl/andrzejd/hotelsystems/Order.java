package pl.andrzejd.hotelsystems;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class Order {

    @SerializedName("orderId")
    @Expose
    int orderId;
    @SerializedName("userId")
    @Expose
    int userId;
    @SerializedName("data")
    @Expose
    Timestamp data;

    public Order(int orderId, int userId, Timestamp date) {
        this.orderId = orderId;
        this.userId = userId;
        this.data = date;
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

    public Timestamp getDate() {
        return data;
    }

    public void Timestamp(Timestamp date) {
        this.data = date;
    }
}
