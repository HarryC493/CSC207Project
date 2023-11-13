package use_case.sortAndfilter_restaurant;

public class SortAndFilterResaturantInputData {
    final private String category;

    public SortAndFilterResaturantInputData(String category){
        this.category = category;
    }

    String getCategory() {
        return category;
    }

}
