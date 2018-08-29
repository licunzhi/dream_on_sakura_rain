package com.sakura.BuilderPattern;

import com.sakura.BuilderPattern.impl.ChickenBurger;
import com.sakura.BuilderPattern.impl.Coke;
import com.sakura.BuilderPattern.impl.Pepsi;
import com.sakura.BuilderPattern.impl.VegBurger;

public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}