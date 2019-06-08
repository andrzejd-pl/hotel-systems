package pl.andrzejd.hotelsystems.services;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pl.andrzejd.hotelsystems.R;

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textKey = itemView.findViewById(R.id.text_View_Key);
            textValue = itemView.findViewById(R.id.text_View_Value);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
