package use_case.sortAndfilter_restaurant;

import entity.Restaurant;

public interface SortAndFilterRestaurantDataAccessInterface {
    boolean existsByName(String identifier);
    String getCategories(String category);
}
