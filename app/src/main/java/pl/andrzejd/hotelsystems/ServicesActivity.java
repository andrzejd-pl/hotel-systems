package pl.andrzejd.hotelsystems;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class ServicesActivity extends AppCompatActivity {
    private RecyclerViewAdapter mAdapter;
    private ArrayList<Service> mServices = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new RecyclerViewAdapter(this, mServices);
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(ServicesActivity.this, DividerItemDecoration.VERTICAL));
        addAllServices();

        MobileAds.initialize(this, "ca-app-pub-5073529030491450~4979234130");
        AdView mAdView;
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("650CC3BEEB61A55E6CE7ECF8E7F3092F").build();

        mAdView.loadAd(adRequest);

    }

    private void addAllServices() {
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface client = retrofit.create(ApiInterface.class);
        Call<ServiceResponse> call = client.getServices();

        call.enqueue(new Callback<ServiceResponse>() {
            @Override
            public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                ServiceResponse services = response.body();
                mServices.addAll(services);
                Log.d("retrofit", Integer.valueOf(mServices.size()).toString());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ServiceResponse> call, Throwable t) {
                Log.d("retrofit", t.toString());
                Toast.makeText(ServicesActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
