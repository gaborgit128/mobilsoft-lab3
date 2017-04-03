package com.example.mobsoft.mobsoft_lab3.repository;


import android.content.Context;

import com.example.mobsoft.mobsoft_lab3.model.Advert;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 03..
 */



public interface Repository {

    void open(Context context);

    void close();

    List<Advert> getAdverts();

    void saveAdvert(Advert advert);

    void updateAdverts(List<Advert> advert);

    void removeAdvert(Advert advert);

    boolean isInDB(Advert advert);
}