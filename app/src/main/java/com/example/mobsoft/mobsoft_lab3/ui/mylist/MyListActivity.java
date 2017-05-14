package com.example.mobsoft.mobsoft_lab3.ui.mylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.R;
import com.example.mobsoft.mobsoft_lab3.model.Advert;
import com.example.mobsoft.mobsoft_lab3.ui.add.AddActivity;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.adapter.AllListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android on 2017. 03. 24..
 */

public class MyListActivity extends AppCompatActivity implements MyListScreen, AllListAdapter.OnAdvertClickListener {

    public static final String LIST_TYPE = "LIST_TYPE";
    public static final int ALL_ADVERTS = 0;
    public static final int MY_ADVERTS = 1;

    @Inject
    MyListPresenter myListresenter;

    @BindView(R.id.adverts_list)
    RecyclerView advertsRecycler;

    private AllListAdapter allListAdapter;

    private boolean isOnlyMyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adverts);
        ButterKnife.bind(this);

        MobSoftApplication.injector.inject(this);

        isOnlyMyList = getIntent().getIntExtra(LIST_TYPE, ALL_ADVERTS) == MY_ADVERTS;

        advertsRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        myListresenter.attachScreen(this);
        allListAdapter = new AllListAdapter(null, isOnlyMyList);
        advertsRecycler.setAdapter(allListAdapter);

        if (isOnlyMyList) {
            allListAdapter.setOnAdvertClickListener(this);
            myListresenter.getMyAdverts();
        } else {
            myListresenter.showAllAdverts();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        myListresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(@StringRes int text) {
        showMessage(getString(text));
    }

    @Override
    public void displayAdverts(List<Advert> adverts) {
        allListAdapter.setAdvertList(adverts);
    }

    @Override
    public void deleteMyAdvert(int advertId) {
        myListresenter.deleteAdvert(advertId);
    }

    @Override
    public void modifyAdvert(Advert advert) {
        Intent intent = new Intent();
        intent.setClass(this, AddActivity.class);
        intent.putExtra(AddActivity.EXTRA_COST, advert.getCost());
        intent.putExtra(AddActivity.EXTRA_DESCRIPTION, advert.getDescription());
        intent.putExtra(AddActivity.EXTRA_TITLE, advert.getTitle());
        intent.putExtra(AddActivity.EXTRA_ID, advert.getId());

        startActivity(intent);
    }

    @Override
    public void advertDeleted() {
    }
}
