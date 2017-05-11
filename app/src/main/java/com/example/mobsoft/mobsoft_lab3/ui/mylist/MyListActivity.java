package com.example.mobsoft.mobsoft_lab3.ui.mylist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.R;
import com.example.mobsoft.mobsoft_lab3.model.Advert;
import com.example.mobsoft.mobsoft_lab3.ui.mylist.adapter.AllListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android on 2017. 03. 24..
 */

public class MyListActivity extends AppCompatActivity implements MyListScreen {

    public static final String LIST_TYPE = "LIST_TYPE";
    public static final int ALL_ADVERTS = 0;
    public static final int MY_ADVERTS = 1;

    @Inject
    MyListPresenter myListresenter;

    @BindView(R.id.adverts_list)
    RecyclerView advertsRecycler;

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

        if (isOnlyMyList) {
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
    public void displayAdverts(List<Advert> adverts) {
        advertsRecycler.setAdapter(new AllListAdapter(adverts, isOnlyMyList));
    }
}
