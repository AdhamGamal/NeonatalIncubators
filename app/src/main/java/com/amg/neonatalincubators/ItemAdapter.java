package com.amg.neonatalincubators;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashSet;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private ArrayList<Item> items;
    private Context context;
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();


    public ItemAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder implements OnClickListener {

        @BindView(R.id.hospital_name)
        TextView HOSPITAL_NAME;
        @BindView(R.id.hospital_name1)
        TextView HOSPITAL_NAME1;
        //        @BindView(R.id.button1) TextView TOTAL_NURSERY_NO;
        @BindView(R.id.number)
        TextView FREE_NURSERY_NO;
        @BindView(R.id.price)
        TextView PRICE;
        @BindView(R.id.nursery_type)
        TextView NURSERY_TYPE;
        @BindView(R.id.location)
        TextView HOSPITAL_LOCATION;
        @BindView(R.id.city)
        TextView HOSPITAL_CITY;
        @BindView(R.id.phone)
        TextView HOSPITAL_PHONE;
        //        @BindView(R.id.rate) RatingBar RATE;
        @BindView(R.id.hospital_image)
        ImageView HOSPITAL_IMAGE;
        @BindView(R.id.nursery_image)
        ImageView NURSERY_IMAGE;

        public ItemHolder(View itemView) {
            super(itemView);
            FoldingCell cell = (FoldingCell) itemView;
            ButterKnife.bind(this, cell);
            cell.setOnClickListener(this);

        }

        public void onBind(int position) {
            HOSPITAL_NAME.setText(items.get(position).getHOSPITAL_NAME());
            HOSPITAL_NAME1.setText(items.get(position).getHOSPITAL_NAME());
            FREE_NURSERY_NO.setText(items.get(position).getFREE_NURSERY_NO() + "");
            PRICE.setText(items.get(position).getPRICE() + " LE");
            NURSERY_TYPE.setText(items.get(position).getNURSERY_TYPE());
//            RATE.setRating(items.get(position).getRATE());
            NURSERY_IMAGE.setImageDrawable(items.get(position).getNURSERY_IMAGE());
            HOSPITAL_LOCATION.setText(items.get(position).getHOSPITAL_LOCATION());
            HOSPITAL_CITY.setText(items.get(position).getHOSPITAL_CITY());
            HOSPITAL_PHONE.setText(items.get(position).getHOSPITAL_PHONE());
            HOSPITAL_IMAGE.setImageDrawable(items.get(position).getHOSPITAL_IMAGE());

            Log.e(">>>>>>>>>>>>>", position + " -- " + items.get(position).getHOSPITAL_NAME());

        }

        public void registerToggle(int position) {
            if (unfoldedIndexes.contains(position))
                registerFold(position);
            else
                registerUnfold(position);
        }

        public void registerFold(int position) {
            unfoldedIndexes.remove(position);
        }

        public void registerUnfold(int position) {
            unfoldedIndexes.add(position);
        }


        @Override
        public void onClick(View view) {
            ((FoldingCell) view).toggle(false);
            registerToggle(getAdapterPosition());
        }
    }
}