package com.example.mobsoft.mobsoft_lab3.ui.mylist;

import android.support.annotation.StringRes;

import com.example.mobsoft.mobsoft_lab3.model.Advert;

import java.util.List;

/**
 * Created by Android on 2017. 03. 24..
 */

public interface MyListScreen {
    void showMessage(String text);

    void showMessage(@StringRes int text);

    void displayAdverts(List<Advert> adverts);

    void advertDeleted();
}
