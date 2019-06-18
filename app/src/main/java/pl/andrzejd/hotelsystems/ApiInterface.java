package pl.andrzejd.hotelsystems;

import pl.andrzejd.hotelsystems.orders.OrderResponse;
import pl.andrzejd.hotelsystems.services.NewOrder;
import pl.andrzejd.hotelsystems.services.ServiceResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("services")
    Call<ServiceResponse> getAllServices();

    @POST("orders")
    Call<String> post(@Body NewOrder order);

    @GET("orders/user1")
    Call<OrderResponse> getOrders();

    @GET("/orders/service/{orderId}")
    Call<ServiceResponse> getOrderServices(@Path("orderId") String orderId);

}