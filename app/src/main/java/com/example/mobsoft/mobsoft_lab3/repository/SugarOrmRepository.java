package com.example.mobsoft.mobsoft_lab3.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import com.example.mobsoft.mobsoft_lab3.model.Advert;


/**
 * Created by mobsoft on 2017. 04. 03..
 */



public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Advert> getAdverts() {
        return SugarRecord.listAll(Advert.class);
    }

    @Override
    public void saveAdvert(Advert advert) {
        SugarRecord.saveInTx(advert);
    }


    //TODO
    @Override
    public void updateAdverts(List<Advert> adverts) {
        List<Advert> favourites = getAdverts();
        List<Advert> toUpdate = new ArrayList<>(favourites.size());
        for (Advert favourite : favourites) {
            for (Advert add : adverts) {
                if (add.getId().equals(favourite.getId())) {
                    toUpdate.add(add);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeAdvert(Advert advert) {
        SugarRecord.deleteInTx(advert);
    }

    @Override
    public boolean isInDB(Advert advert) {
        return SugarRecord.findById(Advert.class, advert.getId()) != null;
    }

}
