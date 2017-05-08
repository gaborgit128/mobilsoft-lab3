package com.example.mobsoft.mobsoft_lab3.network.advert;


        import com.example.mobsoft.mobsoft_lab3.model.Advert;
        import com.example.mobsoft.mobsoft_lab3.model.Credential;
        import com.example.mobsoft.mobsoft_lab3.model.User;



        import retrofit2.Call;
        import retrofit2.http.*;

        import okhttp3.RequestBody;

        import java.math.BigDecimal;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public interface UserApi {

    /**
     * Create a new instance of the model and persist it into the data source.
     *
     * @param data Model instance data
     * @return Call<User>
     */

    @POST("Users")
    Call<User> userCreate(
            @Body Credential data
    );


    /**
     * Login a user with username/email and password.
     *
     * @param credentials
     * @return Call<String> OK üzenet
     */

    @POST("Users/login")
    Call<String> userLogin(
            @Body Credential credentials
    );


    /**
     * Logout a user with access token.
     *
     * @param accessToken User access token
     * @return Call<Void>
     */

    @POST("Users/logout")
    Call<Void> userLogout(
            @Query("accessToken") String accessToken
    );


    /**
     * Find a model instance by id from the data source.
     *
     * @param id Model id
     * @return Call<User>
     */

    @GET("Users/{id}")
    Call<User> userFindById(
            @Path("id") BigDecimal id
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

