package com.example.moonlightpartner;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rm.rmswitch.RMTristateSwitch;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {


    private ArrayList<MyListData> listdata;
    Context context;

    // RecyclerView recyclerView;
    public MyListAdapter(ArrayList<MyListData> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if (listdata.size()>0) {

            MainActivity.txt_no_orders.setVisibility(View.GONE);

            holder.orderID.setText("#" + Integer.toString(listdata.get(position).getOrderId()));
            holder.customerName.setText(listdata.get(position).getCustomerName());
            holder.customerAddress.setText(listdata.get(position).getCustomerAddress());
            holder.customerNumber.setText(listdata.get(position).getCustomerNumber());

            List<String> foodIDs = listdata.get(position).getFoodID();
            Log.v("tempadapter",""+foodIDs);
            List<String> foodQuantities = listdata.get(position).getFoodQuantity();
            String title = new String();
            int totalprice = 0;

            //reading all foodTitles from foodID array
            for(int i=0;i<foodIDs.size();i++) {
                int itemID = Integer.parseInt(foodIDs.get(i));
                int itemQuantity = Integer.parseInt(foodQuantities.get(i));

                Product product = FoodItems.getCatalog().get(itemID);
                title = title + "\n" + product.getTitle() + " x " + itemQuantity;

                totalprice += (itemQuantity * product.getPrice());
            }

            holder.foodItem.setText(title);
            holder.subtotalPrice.setText("Rs. " + totalprice);


            holder.rmswitcher.addSwitchObserver(new RMTristateSwitch.RMTristateSwitchObserver() {
                @Override
                public void onCheckStateChange(RMTristateSwitch switchView, int state) {
                    Toast.makeText(context,state == RMTristateSwitch.STATE_LEFT?"LEFT":state==RMTristateSwitch.STATE_MIDDLE?"MIDDLE":"RIGHT",Toast.LENGTH_LONG).show();
                }
            });

        }

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView orderID, customerName, customerAddress, customerNumber, subtotalPrice, foodItem;
        public RMTristateSwitch rmswitcher;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.orderID = (TextView) itemView.findViewById(R.id.txt_ordernumber);
            this.customerName = (TextView) itemView.findViewById(R.id.txt_customer_name);
            this.customerAddress = (TextView) itemView.findViewById(R.id.txt_customer_address);
            this.customerNumber = (TextView) itemView.findViewById(R.id.txt_customer_number);
            this.subtotalPrice = (TextView) itemView.findViewById(R.id.subtotal_price);
            this.foodItem = (TextView) itemView.findViewById(R.id.food_item);
            this.cardView = (CardView) itemView.findViewById(R.id.cardview);
            this.rmswitcher = (RMTristateSwitch) itemView.findViewById(R.id.switch_process);
        }
    }
}