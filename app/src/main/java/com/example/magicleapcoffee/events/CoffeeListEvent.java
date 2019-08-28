package com.example.magicleapcoffee.events;

import com.example.magicleapcoffee.data.Coffee;

import java.util.List;

public class CoffeeListEvent {

    List<Coffee> coffees;

    public CoffeeListEvent(List<Coffee> coffee){
        this.coffees = coffee;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }


}
