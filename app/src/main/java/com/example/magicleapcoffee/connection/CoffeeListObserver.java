package com.example.magicleapcoffee.connection;

import android.util.Log;

import com.example.magicleapcoffee.data.Coffee;
import com.example.magicleapcoffee.events.CoffeeListEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CoffeeListObserver implements Observer<List<Coffee>> {

    private static final String TAG = CoffeeListObserver.class.getSimpleName();

    private List<Coffee> coffees;

    @Override
    public void onSubscribe(Disposable d) {


    }

    @Override
    public void onNext(List<Coffee> coffees) {
        this.coffees = coffees;
    }



    @Override
    public void onError(Throwable e) {


    }

    @Override
    public void onComplete() {
        EventBus.getDefault().post(new CoffeeListEvent(coffees));

    }
}
