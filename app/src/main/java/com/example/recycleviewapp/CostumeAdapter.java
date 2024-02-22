package com.example.recycleviewapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class CostumeAdapter extends RecyclerView.Adapter<CostumeAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataset;
    private ArrayList<DataModel> filteredList;

    public CostumeAdapter(ArrayList<DataModel> dataset) {
        this.dataset = dataset;
        this.filteredList = new ArrayList<>(dataset);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

//    @SuppressLint("NotifyDataSetChanged")
    @SuppressLint("NotifyDataSetChanged")
    public void filter(String query) {
        filteredList.clear();
        if(query.isEmpty()) {
            filteredList.addAll(dataset);
        } else {
            query = query.toLowerCase();
            for(DataModel item : dataset) {
                if(item.getName().toLowerCase().contains(query) || item.getDescription().toLowerCase().contains(query)) {
                    filteredList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CostumeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CostumeAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewName.setText(filteredList.get(position).getName());
        holder.textViewDescription.setText(filteredList.get(position).getDescription());
        holder.imageView.setImageResource(filteredList.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataModel data = filteredList.get(position);
                PopupMessageDialog popupMessageDialog = new PopupMessageDialog(v.getContext());
                popupMessageDialog.setData(data.getName(), data.getDescription(), data.getImage());
                popupMessageDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }
}
