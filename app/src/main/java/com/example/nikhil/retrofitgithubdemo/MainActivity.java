package com.example.nikhil.retrofitgithubdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 5: Retrofit instance

        Retrofit retrofit =  new Retrofit.Builder()
                                 .baseUrl(Api.base_url)
                                 .addConverterFactory(GsonConverterFactory.create()).build();


        //todo 6: API

        Api api = retrofit.create(Api.class);


        //todo 7: Call method

        Call<SampleJson> call = api.getUser();

        //todo 8: Calling our API

        call.enqueue(new Callback<SampleJson>() {
            @Override
            public void onResponse(Call<SampleJson> call, Response<SampleJson> response) {

                           //todo 9: This is our userr object

                           SampleJson userr  = response.body();

                Log.d("login",userr.getLogin());
                Log.d("html_url",userr.getHtmlUrl());

            }

            @Override
            public void onFailure(Call<SampleJson> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
            }
        });
    }
}
