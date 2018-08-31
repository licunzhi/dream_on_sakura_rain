package com.sakura.creationalPatterns.BuilderPattern;

import com.sakura.creationalPatterns.BuilderPattern.impl.ChickenBurger;
import com.sakura.creationalPatterns.BuilderPattern.impl.Coke;
import com.sakura.creationalPatterns.BuilderPattern.impl.Pepsi;
import com.sakura.creationalPatterns.BuilderPattern.impl.VegBurger;

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
