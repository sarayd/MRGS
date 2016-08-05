package com.mrgs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gy on 2016. 8. 3..
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private List<Order> orderList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView number;
        public TextView name;
        public TextView price;
        public ViewHolder(View itemView) {
            super(itemView);
            number = (TextView) itemView.findViewById(R.id.order_number);
            name = (TextView) itemView.findViewById(R.id.order_name);
            price = (TextView) itemView.findViewById(R.id.order_price);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Order order = orderList.get(position);
        holder.number.setText("" + position);
        holder.name.setText(order.getName());
        holder.price.setText(order.getPrice());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public void addOrder(Order order) {
        orderList.add(order);
        notifyDataSetChanged();
    }
}
