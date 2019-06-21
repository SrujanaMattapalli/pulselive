package com.e.pulselvetest.service;

import com.e.pulselvetest.model.Data;
import com.e.pulselvetest.model.Details;
import com.e.pulselvetest.model.Item;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface DataAPI {

    @GET("contentList.json")
    Call<Data> getResults();

    @GET("content/{id}.json")
    Call<Details> getSelfData(@Path("id") String id);
}
