package use_case.sortAndfilter_restaurant;

import entity.Restaurant;
import use_case.sortAndfilter_restaurant.SortAndFilterResaturantInputData;
import use_case.sortAndfilter_restaurant.SortAndFilterRestaurantDataAccessInterface;

import java.util.ArrayList;

public class SortAndFilterRestaurantInteractor implements SortAndFilterRestaurantInputBoundary {
    final SortAndFilterRestaurantDataAccessInterface sortAndFilterRestaurantDataAccessObject;
    final SortAndFilterRestaurantOutputBoundary sortAndFilterRestaurantPresenter;

    public SortAndFilterRestaurantInteractor(SortAndFilterRestaurantDataAccessInterface sortAndFilterRestaurantDataAccessInterface, SortAndFilterRestaurantOutputBoundary sortAndFilterRestaurantOutputBoundary){
        this.sortAndFilterRestaurantDataAccessObject = sortAndFilterRestaurantDataAccessInterface;
        this.sortAndFilterRestaurantPresenter = sortAndFilterRestaurantOutputBoundary;
    }
    @Override
    public void execute(SortAndFilterResaturantInputData sortAndFilterResaturantInputData) {
        String category = sortAndFilterResaturantInputData.getCategory();
        if (!sortAndFilterRestaurantDataAccessObject.existsByName(restaurantName)) {
            sortAndFilterRestaurantPresenter.prepareFailView("There's no restaurant under this category, please try another one.");
        } else {
            ArrayList<Restaurant> restaurants = sortAndFilterRestaurantDataAccessObject.get(category);

            SortAndFilterRestaurantOutputData sortAndFilterRestaurantOutputData = new SortAndFilterRestaurantOutputData(restaurants, false);
            sortAndFilterRestaurantPresenter.prepareSuccessView(sortAndFilterRestaurantOutputData);
        }
    }
}
