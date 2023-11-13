package use_case.sortAndfilter_restaurant;

public interface SortAndFilterRestaurantOutputBoundary {
    void prepareSuccessView(SortAndFilterRestaurantOutputData resaturantInputData);
    void prepareFailView(String error);
}
