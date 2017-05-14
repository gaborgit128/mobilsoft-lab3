package com.example.mobsoft.mobsoft_lab3.ui.mylist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobsoft.mobsoft_lab3.R;
import com.example.mobsoft.mobsoft_lab3.model.Advert;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllListAdapter extends RecyclerView.Adapter<AllListAdapter.AllListViewHolder> {

    private List<Advert> advertList;
    private boolean isOnlyMyList;

    private OnAdvertClickListener onAdvertClickListener;

    public AllListAdapter(List<Advert> advertList, boolean isOnlyMyList) {
        if (advertList == null) {
            this.advertList = new ArrayList<>();
        } else {
            this.advertList = advertList;
        }

        this.isOnlyMyList = isOnlyMyList;
    }

    @Override
    public AllListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_adverts, parent, false);
        return new AllListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AllListViewHolder holder, int position) {
        final Advert advertItem = advertList.get(position);

        holder.itemName.setText(advertItem.getTitle());
        holder.price.setText(String.valueOf(advertItem.getCost()));
        holder.description.setText(advertItem.getDescription());

        if (isOnlyMyList) {
            holder.modify.setVisibility(View.VISIBLE);
            holder.modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onAdvertClickListener != null) {
                        onAdvertClickListener.modifyAdvert(advertList.get(holder.getAdapterPosition()));
                    }
                }
            });
            holder.delete.setVisibility(View.VISIBLE);
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onAdvertClickListener != null) {
                        onAdvertClickListener.deleteMyAdvert(advertList.get(holder.getAdapterPosition()).getId());
                        advertList.remove(holder.getAdapterPosition());
                        notifyItemRemoved((holder.getAdapterPosition()));
                    }
                }
            });
        } else {
            holder.modify.setVisibility(View.GONE);
            holder.modify.setOnClickListener(null);
            holder.delete.setVisibility(View.GONE);
            holder.delete.setOnClickListener(null);
        }
    }

    @Override
    public int getItemCount() {
        return advertList.size();
    }

    public void setAdvertList(List<Advert> advertList) {
        this.advertList = advertList;
        notifyDataSetChanged();
    }

    public void setOnAdvertClickListener(OnAdvertClickListener onAdvertClickListener) {
        this.onAdvertClickListener = onAdvertClickListener;
    }

    public static class AllListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_advert_item_name)
        TextView itemName;

        @BindView(R.id.list_item_advert_item_delete)
        Button delete;

        @BindView(R.id.list_item_advert_item_modify)
        Button modify;

        @BindView(R.id.list_item_advert_item_price)
        TextView price;

        @BindView(R.id.list_item_advert_item_description)
        TextView description;

        public AllListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnAdvertClickListener {
        void deleteMyAdvert(int advertId);

        void modifyAdvert(Advert advert);
    }
}
