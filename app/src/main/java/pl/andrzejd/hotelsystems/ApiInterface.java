package pl.andrzejd.hotelsystems;

import pl.andrzejd.hotelsystems.orders.OrderResponse;
import pl.andrzejd.hotelsystems.services.NewOrder;
import pl.andrzejd.hotelsystems.services.ServiceResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("services")
    Call<ServiceResponse> getAllServices();

    @POST("orders")
    Call<String> post(@Body NewOrder order);

    @GET("orders/user1")
    Call<OrderResponse> getOrders();

    @GET("services")
    Call<ServiceResponse> getOrderServices();

}