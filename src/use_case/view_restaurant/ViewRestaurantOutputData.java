package use_case.view_restaurant;

import entity.Restaurant;

import java.util.ArrayList;

public class ViewRestaurantOutputData {
    private String username;
    private String userID;
    private String password;
    private ArrayList<Restaurant> restaurants;

    public ViewRestaurantOutputData(String userID, String username, String password,
                                    ArrayList<Restaurant> restaurants) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.restaurants = restaurants;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Restaurant> getLocalRestaurants() {
        return restaurants;
    }
}
