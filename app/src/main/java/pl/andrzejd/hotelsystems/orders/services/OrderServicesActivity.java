package pl.andrzejd.hotelsystems.orders.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.andrzejd.hotelsystems.ApiClient;
import pl.andrzejd.hotelsystems.ApiInterface;
import pl.andrzejd.hotelsystems.OrdersActivity;
import pl.andrzejd.hotelsystems.R;
import pl.andrzejd.hotelsystems.orders.MyRecyclerViewAdapter;
import pl.andrzejd.hotelsystems.services.Service;
import pl.andrzejd.hotelsystems.services.ServiceResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrderServicesActivity extends AppCompatActivity implements OrderServicesAdapter.ItemClickListener{

    OrderServicesAdapter adapter;
    List<Service> mServices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_services);

        String orderId = getIntent().getStringExtra("ORDER_ID");
        getServices(orderId);

        RecyclerView recyclerView = findViewById(R.id.rwOrderService);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderServicesAdapter(this, mServices);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void getServices(String id){
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface client = retrofit.create(ApiInterface.class);
        Call<ServiceResponse> call = client.getOrderServices(id);

        call.enqueue(new Callback<ServiceResponse>() {
            @Override
            public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                ServiceResponse services = response.body();
                mServices.addAll(services);
                Log.d("retrofit", Integer.valueOf(mServices.size()).toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ServiceResponse> call, Throwable t) {
                Log.d("retrofit", t.toString());
                Toast.makeText(OrderServicesActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
    }
}
