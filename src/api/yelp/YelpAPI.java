package api.yelp;

import api.Search.SearchCriteria;
import api.response.MultipleRestaurantResponse;
import api.response.SingleRestaurantResponse;
import entity.Restaurant;

import java.util.ArrayList;

public class YelpAPI implements YelpApiServices {
    private static final YelpAPIClient yelpAPIClient = new YelpAPIClient(new YelpURLs());

    @Override
    public ArrayList<Restaurant> getRestaurants(SearchCriteria criteria) {
        yelpAPIClient.allRestaurantsMatching(criteria);
        MultipleRestaurantResponse multipleRestaurantResponse = new MultipleRestaurantResponse(yelpAPIClient.getResponseBody());
        return multipleRestaurantResponse.getRestaurants();
    }

    @Override
    public ArrayList<Restaurant> getLocalRestaurants(String location) {
        SearchCriteria criteria = new SearchCriteria.Builder().setLocation(location).build();
        return getRestaurants(criteria);
    }

    @Override
    public Restaurant getRestaurantByID(String id) {
        yelpAPIClient.RestaurantIDMatching(id);
        SingleRestaurantResponse singleRestaurantResponse = new SingleRestaurantResponse(yelpAPIClient.getResponseBody());
        return singleRestaurantResponse.getRestaurant();
    }
    public ArrayList<Restaurant> getRestaurantByName(String location, String restaurantName) {
        SearchCriteria criteria = new SearchCriteria.Builder()
                .setLocation(location)
                .setName(restaurantName)
                .build();
        return getRestaurants(criteria);
    }

//    public ArrayList<Review> getReviews(String id) {}
}