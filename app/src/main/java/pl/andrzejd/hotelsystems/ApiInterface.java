package pl.andrzejd.hotelsystems;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("services")
    Call<ServiceResponse> getServices();

    @POST("order")
    Call<Order> post(@Body Order order);
}