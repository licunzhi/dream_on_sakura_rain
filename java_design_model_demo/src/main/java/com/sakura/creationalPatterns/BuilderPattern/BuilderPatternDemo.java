package com.sakura.creationalPatterns.BuilderPattern;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        /**
         * BuilderPattern:
         *      just like if we go to restaurant to eat, wo should to order some meals
         *      the process we do is always some steps:
         *      first-we may choose the food we want
         *      second-we will get the price of the foods
         *      finally-we pay for the meal
         *
         * in order to make the operation has no relation with certain food
         * so we do spilt the food method alone
         * even make the pack way alone
         * by doing like that, wo just need to code a class like factory to use
         * different way to produce different object
         * and then wo need to know the difference between FactoryPattern and BuilderPattern
         * is FactoryPattern just to produce object and then do nothing
         * but BuilderPattern get the object and then do some necessary operation
         * all of the object include object param in the Builder
         * by use the method in builder we can finally get the information we want
         * even we can use the param info do some calculate
         * so we can recognize the BuilderPattern do more based on FactoryPattern
         *
         */
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " +vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }
}
