package com.example.mobsoft.mobsoft_lab3.ui.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobsoft.mobsoft_lab3.R;
import com.example.mobsoft.mobsoft_lab3.ui.about.AboutActivity;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddActivity;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.MyListActivity;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MainMenuViewHolder> {

    private List<MenuItem> menuItemList = Arrays.asList(MenuItem.values());
    private Context context;

    public MainMenuAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MainMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_menu, parent, false);
        return new MainMenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainMenuViewHolder holder, int position) {
        MenuItem item = menuItemList.get(position);

        final Intent intent = new Intent();

        switch (item) {
            case CREATE_ADVERT:
                intent.setClass(context, AddActivity.class);
                break;
            case ABOUT:
                intent.setClass(context, AboutActivity.class);
                break;
            case LIST_ALL_ADVERT:
                intent.setClass(context, MyListActivity.class);
                break;
            case LIST_OWN_ADVERT:
                intent.putExtra(MyListActivity.LIST_TYPE, MyListActivity.MY_ADVERTS);
                intent.setClass(context, MyListActivity.class);
                break;
        }

        holder.description.setText(item.getDescription());

        holder.actionButton.setText(item.getButtonTitle());
        holder.actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    public static class MainMenuViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.menu_item_action)
        Button actionButton;

        @BindView(R.id.menu_item_description)
        TextView description;

        public MainMenuViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
