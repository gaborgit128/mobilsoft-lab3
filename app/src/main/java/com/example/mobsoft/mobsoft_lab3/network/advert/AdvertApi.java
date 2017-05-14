package com.example.mobsoft.mobsoft_lab3.network.advert;


import com.example.mobsoft.mobsoft_lab3.interactor.add.model.AddAdvertResult;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.AdvertListResponse;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.DeleteAdvertRequest;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.DeleteAdvertResponse;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.FetchAdvertRequest;
import com.example.mobsoft.mobsoft_lab3.model.Advert;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AdvertApi {

    /**
     * Create a new instance of the model and persist it into the data source.
     *
     * @param data        Model instance data
     * @return Call<Advert>
     */

    @POST("Adverts/create")
    Call<AddAdvertResult> advertCreate(@Body Advert data);

    @POST("Adverts/modify")
    Call<AddAdvertResult> advertModify(@Body Advert data);

    @POST("Adverts/delete")
    Call<DeleteAdvertResponse> deleteAdvert(@Body DeleteAdvertRequest deleteAdvertRequest);

    @POST("Adverts/list")
    Call<AdvertListResponse> fetchList(@Body FetchAdvertRequest fetchAdvertRequest);
}
