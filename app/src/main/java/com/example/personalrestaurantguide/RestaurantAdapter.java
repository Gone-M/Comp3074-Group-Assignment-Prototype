package com.example.personalrestaurantguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private final List<Restaurant> restaurantList;
    private final OnRestaurantActionListener actionListener;

    public interface OnRestaurantActionListener {
        void onEditClicked(Restaurant restaurant);
        void onDeleteClicked(Restaurant restaurant);
    }

    public RestaurantAdapter(List<Restaurant> restaurantList, OnRestaurantActionListener actionListener) {
        this.restaurantList = restaurantList;
        this.actionListener = actionListener;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_card, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        holder.nameTextView.setText(restaurant.getName());
        holder.addressTextView.setText(restaurant.getAddress());
        holder.phoneTextView.setText(restaurant.getPhone());
        holder.descriptionTextView.setText(restaurant.getDescription());
        holder.ratingTextView.setText("Rating: " + restaurant.getRating() + "/5");

        holder.editButton.setOnClickListener(v -> {
            if (actionListener != null) {
                actionListener.onEditClicked(restaurant);
            }
        });

        holder.deleteButton.setOnClickListener(v -> {
            if (actionListener != null) {
                actionListener.onDeleteClicked(restaurant);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, addressTextView, phoneTextView, descriptionTextView, ratingTextView;
        View editButton, deleteButton;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_name);
            addressTextView = itemView.findViewById(R.id.tv_address);
            phoneTextView = itemView.findViewById(R.id.tv_phone);
            descriptionTextView = itemView.findViewById(R.id.tv_description);
            ratingTextView = itemView.findViewById(R.id.tv_rating);
            editButton = itemView.findViewById(R.id.btn_edit);
            deleteButton = itemView.findViewById(R.id.btn_delete);
        }
    }
}
