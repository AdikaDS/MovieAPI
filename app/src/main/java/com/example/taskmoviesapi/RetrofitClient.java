package com.example.taskmoviesapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private APIMovie myAPIMovie;
    private final static String BASE_URL = "https://api.themoviedb.org/";

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPIMovie = retrofit.create(APIMovie.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public APIMovie getMyAPI() {
        return myAPIMovie;
    }

}
