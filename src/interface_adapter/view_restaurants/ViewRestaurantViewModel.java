package interface_adapter.view_restaurants;

import entity.Restaurant;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ViewRestaurantViewModel extends ViewModel {
    public static final String TITLE_LABEL = "View Restaurants";
    public static final String MESSAGE_LABEL = "Matched Results: ";
    public static final String RETURN_LABEL = "Return";
    public static final String SEARCH_LABEL = "Search";
    public static final String SORTANDFILTER_LABEL = "Sort and filter";
    private ViewRestaurantState state = new ViewRestaurantState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ViewRestaurantViewModel(){
        super("view restaurant");
    }

    public void setState(ViewRestaurantState state) {
        this.state = state;
    }

    public ViewRestaurantState getState() {
        return state;
    }
    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.state.setRestaurants(restaurants);
        firePropertyChanged();
    }
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("viewRestaurant", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
