package entity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FavouritesList implements Iterable<Restaurant>{
    private final ArrayList<Restaurant> favouritesList;

    public FavouritesList(){
        this.favouritesList = new ArrayList<>();
    }

    public void add(Restaurant favourite){
        favouritesList.add(favourite);
    }

    public void remove(String restaurantID){
        favouritesList.removeIf(restaurant -> restaurant.getRestaurantID().equals(restaurantID));
    }

    public boolean isEmpty() {
        return favouritesList.isEmpty();
    }

    public boolean contains(String restaurantID) {
        for (Restaurant restaurant : favouritesList) {
            if (restaurant.getRestaurantID().equals(restaurantID)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        ArrayList<String> restaurantIds = new ArrayList<>();
        for (Restaurant favourite : favouritesList) {
            restaurantIds.add(favourite.getRestaurantID());
        }
        String result = String.join(",", restaurantIds);
        return result;
    }


    @NotNull
    @Override
    public Iterator<Restaurant> iterator() {
        return new FavouritesIterator();
    }

    private class FavouritesIterator implements Iterator<Restaurant>{
        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < favouritesList.size();
        }

        @Override
        public Restaurant next() {
            Restaurant res;
            try {
                res = favouritesList.get(current);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
            current += 1;
            return res;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            ArrayList<String> thisRestaurantIDs = new ArrayList<>();
            ArrayList<String> objRestaurantIDs = new ArrayList<>();
            for (Restaurant restaurant : ((FavouritesList) obj).favouritesList) {
                objRestaurantIDs.add(restaurant.getRestaurantID());
            }
            for (Restaurant restaurant : this.favouritesList){
                thisRestaurantIDs.add(restaurant.getRestaurantID());
            }
            return objRestaurantIDs.equals(thisRestaurantIDs);
        }
        return false;
    }
}