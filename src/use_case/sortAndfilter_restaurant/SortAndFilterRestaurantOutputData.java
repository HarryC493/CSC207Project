package use_case.sortAndfilter_restaurant;

import entity.Restaurant;

import java.util.ArrayList;

public class SortAndFilterRestaurantOutputData {
    private final ArrayList<Restaurant> restaurants;
    private boolean useCaseFailed;

    public SortAndFilterRestaurantOutputData(ArrayList<Restaurant> restaurants, boolean useCaseFailed){
        this.restaurants = restaurants;
        this.useCaseFailed = useCaseFailed;
    }
    public ArrayList<Restaurant> getRestaurants(){
        return restaurants;
    }
}
