package com.mirea.kt.android2023.myapplication;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TelephoneAdapter extends RecyclerView.Adapter<TelephoneAdapter.ViewHolder> {
    ArrayList<Telephone> telephones;
    private static final String TAG = "TelephoneAdapter";
    public TelephoneAdapter(ArrayList<Telephone> telephones) {
        this.telephones = telephones;
        Log.d(TAG, "TelephoneAdapter: TelephoneAdapter");
        Log.d(TAG, "TelephoneAdapter: " + getItemCount());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_telephone, parent,
                false);
        Log.d(TAG, "onCreateViewHolder: view holder is created");
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TelephoneAdapter.ViewHolder holder, int position) {
        Telephone telephone = telephones.get(position);
        Log.d(TAG, "onBindViewHolder: " + position);
        holder.model.setText("model: " + telephone.getModel());
        holder.serial.setText("serial: " + telephone.getSerial());
        holder.price.setText(telephone.getPrice().toString() + "$");
        Log.d(TAG, "onBindViewHolder: view holder is bound");
    }

    @Override
    public int getItemCount() {
        return telephones.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView model;
        private final TextView serial;
        private final TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            model = itemView.findViewById(R.id.tvShowModel);
            serial = itemView.findViewById(R.id.tvShowSerial);
            price = itemView.findViewById(R.id.tvShowPrice);
            Log.d(TAG, "ViewHolder: holder");
        }
    }
}
