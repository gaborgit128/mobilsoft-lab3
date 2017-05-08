package com.example.mobsoft.mobsoft_lab3.network.advert;


import com.example.mobsoft.mobsoft_lab3.model.Advert;




import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;


import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdvertApi {

    /**
     * Create a new instance of the model and persist it into the data source.
     *
     * @param accessToken User access token
     * @param data Model instance data
     * @return Call<Advert>
     */

    @POST("Adverts")
    Call<Advert> advertCreate(
            @Query("accessToken") String accessToken, @Body Advert data
    );


    /**
     * Count instances of the model.
     *
     * @return Call<String> OK üzenet
     */

    @GET("Adverts/count")
    Call<String> advertsCount();



    /**
     * Find a model instance by id from the data source.
     *
     * @param id Model id
     * @return Call<Advert>
     */

    @GET("Adverts/{id}")
    Call<Advert> advertFindById(
            @Path("id") BigDecimal id
    );


    /**
     * Check whether a model instance exists in the data source.
     *
     * @param id Model id
     * @return Call<String> OK üzenet
     */

    @HEAD("Adverts/{id}")
    Call<String> advertExistsHeadAdvertsId(
            @Path("id") BigDecimal id
    );


    /**
     * Update attributes for a model instance and persist it into the data source.
     *
     * @param accessToken User access token
     * @param id PersistedModel id
     * @param data An object of model property name/value pairs
     * @return Call<Advert>
     */

    @PUT("Adverts/{id}")
    Call<Advert> advertPrototypeUpdateAttributes(
            @Query("accessToken") String accessToken, @Path("id") BigDecimal id, @Body Advert data
    );


    /**
     * Delete a model instance by id from the data source.
     *
     * @param id Model id
     * @param accessToken User access token
     * @return Call<String> OK üzenet
     */

    @DELETE("Adverts/{id}")
    Call<String> advertDeleteById(
            @Path("id") BigDecimal id, @Query("accessToken") String accessToken
    );


    /**
     * Queries favorites of User.
     *
     * @param id User id
     * @return Call<List<Advert>>
     */

    @GET("Users/{id}/adverts")
    Call<List<Advert>> userPrototypeGetMyadverts(
            @Path("id") BigDecimal id
    );


    /**
     * Counts favorites of SziaUser.
     *
     * @param id User id
     * @return Call<String> OK üzenet
     */

    @GET("Users/{id}/adverts/count")
    Call<String> userPrototypeCountMyadverts(
            @Path("id") BigDecimal id
    );


}
