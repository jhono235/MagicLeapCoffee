package com.example.magicleapcoffee.connection;

import android.util.Log;

import com.example.magicleapcoffee.data.Coffee;
import com.example.magicleapcoffee.events.CoffeeEvent;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CoffeeObserver implements Observer <Coffee> {
    public static final String TAG = CoffeeObserver.class.getSimpleName();

    private Coffee coffee;

    @Override
    public void onSubscribe(Disposable d) {


    }

    @Override
    public void onNext(Coffee coffee) {
        this.coffee = coffee;


    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: ", e);

    }

    @Override
    public void onComplete() {
        EventBus.getDefault().post(new CoffeeEvent(coffee));

    }
}
