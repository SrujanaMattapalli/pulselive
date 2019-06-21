package com.e.pulselvetest.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class DataService {
    private Retrofit retrofit = null;
    /**
     * This method creates a new instance of the API interface.
     *
     * @return The API interface
     */
    public DataAPI getAPI() {
        String BASE_URL = "http://dynamic.pulselive.com/test/native/";
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit.create(DataAPI.class);
    }
}
