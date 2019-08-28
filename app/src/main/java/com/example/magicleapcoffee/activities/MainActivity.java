package com.example.magicleapcoffee.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import com.example.magicleapcoffee.CoffeeRvAdapter;
import com.example.magicleapcoffee.R;
import com.example.magicleapcoffee.connection.CoffeeListObserver;
import com.example.magicleapcoffee.connection.RetrofitHelper;
import com.example.magicleapcoffee.data.Coffee;
import com.example.magicleapcoffee.events.CoffeeListEvent;

import java.util.ArrayList;
import java.util.List;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG_ACTION_MAIN";
    ArrayList<Coffee> coffeeArrayList = new ArrayList<>();
    RecyclerView rvCoffeeList;
    CoffeeRvAdapter adapter;
    DividerItemDecoration dividerItemDecoration;

    RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        layoutManager = new LinearLayoutManager(this);
        adapter = new CoffeeRvAdapter(coffeeArrayList, this);
        dividerItemDecoration = new DividerItemDecoration(this, ((LinearLayoutManager) layoutManager).getOrientation());

        rvCoffeeList = findViewById(R.id.rvCoffeeList);
        rvCoffeeList.setLayoutManager(layoutManager);
        rvCoffeeList.setAdapter(adapter);
        rvCoffeeList.addItemDecoration(dividerItemDecoration);
        RetrofitHelper.getObsService();

        initRxJavaCall();




    }

    public void initRxJavaCall(){
        RetrofitHelper.getObsService().getCoffees()
              .observeOn(AndroidSchedulers.mainThread())
               .subscribeOn(Schedulers.io())
               .subscribe(new CoffeeListObserver());
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
    public void onCoffeeListEvent(CoffeeListEvent event){
        adapter.setData((ArrayList<Coffee>) event.getCoffees());
    }



}
