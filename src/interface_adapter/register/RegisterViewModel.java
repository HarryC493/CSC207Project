package interface_adapter.register;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RegisterViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Register View";
    public static final String USERNAME_LABEL = "Choose username";
    public static final String PASSWORD_LABEL = "Choose password";
    public static final String REPEAT_PASSWORD_LABEL = "Enter password again";

    public static final String LOCATION_LABEL = "Choose your city";

    public static final String REGISTER_BUTTON_LABEL = "Register";
    public static final String CANCEL_BUTTON_LABEL = "Log in";

    private RegisterState state = new RegisterState();

    public RegisterViewModel() {
        super("sign up");
    }

    public void setState(RegisterState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Register Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public RegisterState getState() {
        return state;
    }
}

