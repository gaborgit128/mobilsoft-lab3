package com.example.mobsoft.mobsoft_lab3.ui.main.adapter;

import android.support.annotation.StringRes;

import com.example.mobsoft.mobsoft_lab3.R;

public enum MenuItem {
    CREATE_ADVERT(R.string.main_label_creating_advert, R.string.main_creating_advert),
    LIST_OWN_ADVERT(R.string.main_label_my_advert, R.string.main_my_advert),
    LIST_ALL_ADVERT(R.string.main_label_all_advert, R.string.main_all_advert),
    ABOUT(R.string.main_label_about, R.string.main_about);

    @StringRes
    private int description;

    @StringRes
    private int buttonTitle;

    MenuItem(int description, int buttonTitle) {
        this.description = description;
        this.buttonTitle = buttonTitle;
    }

    public int getDescription() {
        return description;
    }

    public int getButtonTitle() {
        return buttonTitle;
    }
}
