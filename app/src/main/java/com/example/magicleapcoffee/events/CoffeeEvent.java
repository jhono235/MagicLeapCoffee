package com.example.magicleapcoffee.events;

import com.example.magicleapcoffee.data.Coffee;

public class CoffeeEvent {

    Coffee coffee;

    public CoffeeEvent(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
