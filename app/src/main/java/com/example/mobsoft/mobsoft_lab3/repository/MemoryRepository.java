package com.example.mobsoft.mobsoft_lab3.repository;

import android.content.Context;

import com.example.mobsoft.mobsoft_lab3.model.Advert;
import com.example.mobsoft.mobsoft_lab3.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 03..
 */


public class MemoryRepository implements Repository {

    private static final long MINUTE = 60 * 1000;

    public static List<Advert> adverts;

    @Override
    public void open(Context context) {
        User user = new User("Paulin", 100);
        Advert advert1 = new Advert("Computer", 10000, "Computer in good shape to sell");
        advert1.setUser(user);
        advert1.setId(-1);

        Advert advert2 = new Advert("House", 10000000, "Nice family house what I wanna sell for a kind and nice person");
        advert2.setUser(user);
        advert2.setId(-2);

        adverts.add(advert1);
        adverts.add(advert2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Advert> getAdverts() {
        return adverts;
    }

    @Override
    public void saveAdvert(Advert advert) {
        adverts.add(advert);

    }

    @Override
    public void updateAdverts(List<Advert> adverts) {
        for (int i = 0; i < this.adverts.size(); i++) {
            Advert advert = this.adverts.get(i);
            for (Advert add : adverts) {
                if (add.getId().equals(advert.getId())) {
                    this.adverts.set(i, advert);
                }
            }
        }
    }

    @Override
    public void removeAdvert(Advert advert) {
        adverts.remove(advert);
    }

    @Override
    public boolean isInDB(Advert advert) {
        return adverts.contains(advert);
    }

}

