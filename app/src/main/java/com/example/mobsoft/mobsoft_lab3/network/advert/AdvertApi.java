package com.example.mobsoft.mobsoft_lab3.network.advert;

/**
 * Created by Android on 2017. 05. 03..
 */



import com.example.mobsoft.mobsoft_lab3.model.Advert;

import retrofit2.Call;
import retrofit2.http.*;


public interface AdvertApi {

    /**
     * Create a new instance of the model and persist it into the data source.
     *
     * @param data Model instance data
     * @return Call<Void>
     */

    @POST("Advert")
    Call<Void> todoCreate(
            @Body Advert data
    );


}
