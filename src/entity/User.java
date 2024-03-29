package entity;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class User extends CommonUser implements UserInterface {
    private String password;
    private final LocalDateTime creationTime;
    private String location;
    private FavouritesList favouritesList;
    private ReviewList reviewsList;

    public User(String userID, String username, String password, String location,
                LocalDateTime creationTime){
        super(userID, username);
        this.password = password;
        this.location = location;
        this.creationTime = creationTime;
        this.favouritesList = new FavouritesList();
        this.reviewsList = new ReviewList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public FavouritesList getFavouritesList() {
        return favouritesList;
    }

    @Override
    public ReviewList getReviewsList() {
        return reviewsList;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void addToFavourites(Restaurant restaurant){
        favouritesList.add(restaurant);
    }

    @Override
    public void removeFavourite(String restaurantID){
        favouritesList.remove(restaurantID);
    }

    @Override
    public void addReview(Review review){
        reviewsList.add(review);
    }

    @Override
    public void removeReview(Review review){
        reviewsList.remove(review);
    }

    @Override
    public void setFavouritesList(FavouritesList favouritesList) {
        this.favouritesList = favouritesList;
    }

    public void setPassword(String newpassword) {this.password = newpassword;}
}