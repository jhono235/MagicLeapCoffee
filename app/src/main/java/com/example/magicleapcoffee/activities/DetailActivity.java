package com.example.magicleapcoffee.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.magicleapcoffee.R;
import com.example.magicleapcoffee.connection.CoffeeListObserver;
import com.example.magicleapcoffee.connection.CoffeeObserver;
import com.example.magicleapcoffee.connection.RetrofitHelper;
import com.example.magicleapcoffee.data.Coffee;
import com.example.magicleapcoffee.events.CoffeeEvent;
import com.example.magicleapcoffee.events.CoffeeListEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity {
    TextView tvName, tvDescription, tvLastUpdated;
    ImageView imgPicture;

    String passedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        passedId = intent.getStringExtra("passedId");
        tvName = findViewById(R.id.tvNameDetail);
        tvDescription = findViewById(R.id.tvDetailDetail);
        tvLastUpdated = findViewById(R.id.tvLastUpdatedAt);
        imgPicture = findViewById(R.id.imgDetailsPic);

        initRxJavaCall();
    }

    public void initRxJavaCall(){
        RetrofitHelper.getObsService().getCoffee(passedId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CoffeeObserver());
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCoffeeEvent(CoffeeEvent event){
        Coffee coffee = event.getCoffee();
        tvName.setText(coffee.getName());
        tvDescription.setText(coffee.getDesc());
        //tvLastUpdated.setText(DateFormat.getDateInstance().format(coffee.getLastUpdatedAt()));

        Glide
                .with(this)
                .load(coffee.getImageUrl())
                .into(imgPicture);


    }




    }

