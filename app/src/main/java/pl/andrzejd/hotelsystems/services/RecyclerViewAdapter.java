package pl.andrzejd.hotelsystems.services;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import pl.andrzejd.hotelsystems.ApiClient;
import pl.andrzejd.hotelsystems.ApiInterface;
import pl.andrzejd.hotelsystems.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Service> mServices;
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<Service> mServices) {
        this.mServices = mServices;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Service service = mServices.get(i);

        viewHolder.textKey.setText(service.getName());
        viewHolder.textValue.setText("Price: " + service.getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return mServices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textKey, textValue;
        RelativeLayout parentLayout;
        Button orderButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textKey = itemView.findViewById(R.id.text_View_Key);
            textValue = itemView.findViewById(R.id.text_View_Value);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            orderButton = itemView.findViewById(R.id.order_Button);
            orderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Retrofit retrofit = ApiClient.getClient();
                    ApiInterface client = retrofit.create(ApiInterface.class);
                    Call<String> call = client.post(new NewOrder(1, Arrays.asList(1, 2)));

                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {;
                            Log.d("retrofit", "ok");
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.d("retrofit", t.toString());
                            t.printStackTrace();
                        }
                    });
                }
            });
        }
    }
}
