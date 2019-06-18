package pl.andrzejd.hotelsystems.orders.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import pl.andrzejd.hotelsystems.OrdersActivity;
import pl.andrzejd.hotelsystems.R;
import pl.andrzejd.hotelsystems.orders.MyRecyclerViewAdapter;
import pl.andrzejd.hotelsystems.services.Service;

public class OrderServicesActivity extends AppCompatActivity implements OrderServicesAdapter.ItemClickListener{

    OrderServicesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_services);

        ArrayList<Service> services = new ArrayList<>();
        services.add( new Service(1,"Service1",1.0));
        services.add( new Service(2,"Service2",2.0));
        services.add( new Service(3,"Service3",3.0));
        services.add( new Service(4,"Service4",4.0));

        Button viewServices = findViewById(R.id.back_to_orders_button);
        viewServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OrdersActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rwOrderService);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderServicesAdapter(this, services);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
    }
}
