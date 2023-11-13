package interface_adapter.view_favourites;


import java.util.ArrayList;

public class ViewFavouritesState {
    private String username;
    private String password;
    private ArrayList<String> favourites;
    private String noFavouritesMessage;

    public ViewFavouritesState(){};

    public ViewFavouritesState(ViewFavouritesState copy) {
        username = copy.username;
        password = copy.password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getFavourites() {
        return favourites;
    }
    public void setFavourites(ArrayList<String> favourites) {
        this.favourites = favourites;
    }

    public String getNoFavouritesMessage() {
        return noFavouritesMessage;
    }
    public void setNoFavourites(String noFavouritesMessage){
        this.noFavouritesMessage = noFavouritesMessage;
    }

}
