package com.example.mobsoft.mobsoft_lab3.network;

/**
 * Created by Android on 2017. 05. 03..
 */

import com.example.mobsoft.mobsoft_lab3.network.advert.AdvertApi;
import com.example.mobsoft.mobsoft_lab3.utils.GsonHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public AdvertApi provideAdvertApi(Retrofit retrofit) {
        return retrofit.create(AdvertApi.class);
    }


}
