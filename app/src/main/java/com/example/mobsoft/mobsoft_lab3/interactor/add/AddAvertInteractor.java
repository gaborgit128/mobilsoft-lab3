package com.example.mobsoft.mobsoft_lab3.interactor.add;

/**
 * Created by Android on 2017. 04. 13..
 */
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Response;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.interactor.add.events.AddAdvertEvent;
import com.example.mobsoft.mobsoft_lab3.interactor.add.model.AddAdvertResult;
import com.example.mobsoft.mobsoft_lab3.model.Advert;
import com.example.mobsoft.mobsoft_lab3.network.advert.AdvertApi;
import com.example.mobsoft.mobsoft_lab3.repository.Repository;


public class AddAvertInteractor {

    @Inject
    AdvertApi advertApi;
    @Inject
    EventBus bus;

    public AddAvertInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void addAdverts(Advert advert) {

        AddAdvertEvent event = new AddAdvertEvent();

        Call<AddAdvertResult> artistsQueryCall = advertApi.advertCreate(advert);
        try {
            Response<AddAdvertResult> response = artistsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setAdvertAddedSuccessfully(response.body().isAdvertAddedSuccessfully());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
