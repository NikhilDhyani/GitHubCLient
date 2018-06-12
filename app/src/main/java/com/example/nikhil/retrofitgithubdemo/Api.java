package com.example.nikhil.retrofitgithubdemo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by NIKHIL on 13-06-2018.
 */

public interface Api {

    //todo 3: Enter base url

    String base_url = "https://api.github.com/users/";

    //todo 4: Enter end point and method. Ex: Get, Post etc.

    @GET("defunkt")
    Call<SampleJson> getUser();
}
