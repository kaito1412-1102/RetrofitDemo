package com.example.retrofitdemo.request;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static RequestApi requestApi = retrofit.create(RequestApi.class);

    public static RequestApi getRequestApi() {
        return requestApi;
    }
}
