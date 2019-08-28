package com.example.magicleapcoffee.connection;

import com.example.magicleapcoffee.data.Coffee;

import io.reactivex.Observable;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ObservableCoffeeService {
    @GET("coffees")
    Observable<List<Coffee>> getCoffees();

    @GET("coffees/{coffeeId}")
    Observable<Coffee> getCoffee(@Path("coffeeId") String coffeeId);
}
