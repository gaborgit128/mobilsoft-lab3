package com.example.mobsoft.mobsoft_lab3.mock.interceptors;

/**
 * Created by Android on 2017. 05. 03..
 */

import android.net.Uri;

import com.example.mobsoft.mobsoft_lab3.interactor.add.model.AddAdvertResult;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.AdvertListResponse;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.DeleteAdvertRequest;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.DeleteAdvertResponse;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.FetchAdvertRequest;
import com.example.mobsoft.mobsoft_lab3.model.Advert;
import com.example.mobsoft.mobsoft_lab3.model.User;
import com.example.mobsoft.mobsoft_lab3.network.NetworkConfig;
import com.example.mobsoft.mobsoft_lab3.utils.GsonHelper;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.mobsoft.mobsoft_lab3.mock.interceptors.MockHelper.makeResponse;


public class AdvertMock {

    private static final int OTHER_USER_ID = 1000;
    private static final int MY_ID = 1992;

    private static List<Advert> adverts = new ArrayList<>();

    static {
        User user = new User("Paulin", OTHER_USER_ID);
        Advert advert1 = new Advert("Computer", 10000, "Computer in good shape to sell");
        advert1.setUser(user);
        advert1.setId(-1);

        Advert advert2 = new Advert("House", 10000000, "Nice family house what I wanna sell for a kind and nice person");
        advert2.setUser(user);
        advert2.setId(-2);

        adverts.add(advert1);
        adverts.add(advert2);
    }

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Adverts/create") && request.method().equals("POST")) {
            String requestJson = MockHelper.bodyToString(request);
            Advert newAdvert = GsonHelper.getGson().fromJson(requestJson, Advert.class);

            if (newAdvert.getId() == -1) {
                newAdvert.setUser(new User("Gabor", 1992));
                newAdvert.setId(adverts.size());

                adverts.add(newAdvert);
            } else {
                for (Advert advert : adverts) {
                    if (advert.getId().equals(newAdvert.getId())) {
                        advert.setCost(newAdvert.getCost());
                        advert.setTitle(newAdvert.getTitle());
                        advert.setDescription(newAdvert.getDescription());
                    }
                }
            }

            AddAdvertResult addAdvertResult = new AddAdvertResult();
            addAdvertResult.setAdvertAddedSuccessfully(true);

            responseString = GsonHelper.getGson().toJson(addAdvertResult);
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Adverts/delete") && request.method().equals("POST")) {
            String requestJson = MockHelper.bodyToString(request);

            DeleteAdvertRequest deleteAdvertRequest = GsonHelper.getGson().fromJson(requestJson, DeleteAdvertRequest.class);

            DeleteAdvertResponse deleteAdvertResponse = new DeleteAdvertResponse();
            deleteAdvertResponse.setDeletionSuccessfull(false);
            for (Advert advert : adverts) {
                if (advert.getId() == deleteAdvertRequest.getAdvertId()) {
                    adverts.remove(advert);

                    deleteAdvertResponse.setDeletionSuccessfull(true);
                    break;
                }
            }
            responseString = GsonHelper.getGson().toJson(deleteAdvertResponse);
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Adverts/list") && request.method().equals("POST")) {
            String requestJson = MockHelper.bodyToString(request);

            FetchAdvertRequest fetchAdvertRequest = GsonHelper.getGson().fromJson(requestJson, FetchAdvertRequest.class);

            AdvertListResponse advertListResponse = new AdvertListResponse();

            List<Advert> resultAdverts = new ArrayList<>();
            if (fetchAdvertRequest.getUserId() != 0) {
                for (int i = 0; i < adverts.size(); i++) {
                    if (adverts.get(i).getUser().getId() == fetchAdvertRequest.getUserId()) {
                        resultAdverts.add(adverts.get(i));
                    }
                }
            } else {
                resultAdverts = adverts;
            }

            advertListResponse.setAdvertList(resultAdverts);
            responseString = GsonHelper.getGson().toJson(advertListResponse);
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
