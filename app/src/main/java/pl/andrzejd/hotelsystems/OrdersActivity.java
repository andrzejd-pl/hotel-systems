package pl.andrzejd.hotelsystems;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.andrzejd.hotelsystems.orders.MyRecyclerViewAdapter;
import pl.andrzejd.hotelsystems.orders.OrderResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrdersActivity extends AppCompatActivity  implements MyRecyclerViewAdapter.ItemClickListener{

    MyRecyclerViewAdapter adapter;
    List<Order> mOrders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        adapter = new MyRecyclerViewAdapter(this, mOrders);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setClickListener(this);

        getAllOrders();
    }

    private void getAllOrders(){
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface client = retrofit.create(ApiInterface.class);
        Call<OrderResponse> call = client.getOrders();

        call.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                OrderResponse orders = response.body();
                mOrders.addAll(orders);
                Log.d("retrofit", Integer.valueOf(mOrders.size()).toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                Log.d("retrofit", t.toString());
                Toast.makeText(OrdersActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position).getOrderId() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
