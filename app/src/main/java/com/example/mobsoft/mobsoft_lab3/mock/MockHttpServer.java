package com.example.mobsoft.mobsoft_lab3.mock;

/**
 * Created by Android on 2017. 05. 03..
 */


import com.example.mobsoft.mobsoft_lab3.mock.interceptors.MockInterceptor;

import okhttp3.Request;
import okhttp3.Response;

public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}
