package interface_adapter.user_profile;

public class UserProfileState {
    private String userID = "";
    private String username = "";
    private String password = "";
    private String location = "";
    private String errorMessage = "";

    public UserProfileState(UserProfileState copy) {
        userID = copy.userID;
        username = copy.username;
        password = copy.password;
        location = copy.location;
        errorMessage = copy.errorMessage;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public UserProfileState() {}

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}