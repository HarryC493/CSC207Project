package interface_adapter.user_profile;

import interface_adapter.ViewManagerModel;
import interface_adapter.register.RegisterState;
import use_case.user_profile.UserProfileOutputBoundary;
import use_case.user_profile.UserProfileOutputData;

public class UserProfilePresenter implements UserProfileOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final UserProfileViewModel userProfileViewModel;

    public UserProfilePresenter(ViewManagerModel viewManagerModel,
                                UserProfileViewModel userProfileViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.userProfileViewModel = userProfileViewModel;
    }

    @Override
    public void prepareSuccessView(UserProfileOutputData userProfileOutputData) {
        UserProfileState userProfileState = userProfileViewModel.getState();
        userProfileState.setUserID(userProfileOutputData.getUserID());
        userProfileState.setUsername(userProfileOutputData.getUsername());
        userProfileState.setPassword(userProfileOutputData.getPassword());
        userProfileState.setLocation(userProfileOutputData.getLocation());
        userProfileState.setErrorMessage("");
        this.userProfileViewModel.setState(userProfileState);
        this.userProfileViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(userProfileViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        UserProfileState userProfileState = userProfileViewModel.getState();
        userProfileState.setErrorMessage(error);
        userProfileViewModel.firePropertyChanged();
    }
}