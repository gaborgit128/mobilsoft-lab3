package com.example.mobsoft.mobsoft_lab3.mock.interceptors;


import android.net.Uri;

import com.example.mobsoft.mobsoft_lab3.interactor.login.model.LoginResult;
import com.example.mobsoft.mobsoft_lab3.network.NetworkConfig;
import com.example.mobsoft.mobsoft_lab3.utils.GsonHelper;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.mobsoft.mobsoft_lab3.mock.interceptors.MockHelper.makeResponse;

public class UserMock {

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Users/login") && request.method().equals("POST")) {
            LoginResult loginResult = new LoginResult();
            loginResult.setLoginSuccessfull(true);

            responseString = GsonHelper.getGson().toJson(loginResult);
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
