package com.example.magicleapcoffee.connection;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    public static final String BASE_URL = "https://demo6983184.mockable.io/";

    public static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //converts call objects to observables
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    public static ObservableCoffeeService getObsService(){
        return getRetrofitInstance().create(ObservableCoffeeService.class);

    }




}
