package com.example.mobsoft.mobsoft_lab3.interactor.mylist;

import com.example.mobsoft.mobsoft_lab3.MobSoftApplication;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.events.GetAdvertsEvent;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.events.RemoveMyAdvertEvent;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.AdvertListResponse;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.DeleteAdvertRequest;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.DeleteAdvertResponse;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.FetchAdvertRequest;
import com.example.mobsoft.mobsoft_lab3.network.advert.AdvertApi;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Android on 2017. 04. 13..
 */

public class GetMyAdvertsInteractor {

    @Inject
    AdvertApi advertApi;
    @Inject
    EventBus bus;

    public GetMyAdvertsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void fetchAdverts(FetchAdvertRequest fetchAdvertRequest) {
        GetAdvertsEvent event = new GetAdvertsEvent();

        Call<AdvertListResponse> artistsQueryCall = advertApi.fetchList(fetchAdvertRequest);
        try {
            Response<AdvertListResponse> response = artistsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setAdverts(response.body().getAdvertList());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void deleteAdvert(int advertId) {
        DeleteAdvertRequest deleteAdvertRequest = new DeleteAdvertRequest();
        deleteAdvertRequest.setAdvertId(advertId);
        RemoveMyAdvertEvent event = new RemoveMyAdvertEvent();

        Call<DeleteAdvertResponse> artistsQueryCall = advertApi.deleteAdvert(deleteAdvertRequest);
        try {
            Response<DeleteAdvertResponse> response = artistsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setDeletionSuccessfull(response.body().isDeletionSuccessfull());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
