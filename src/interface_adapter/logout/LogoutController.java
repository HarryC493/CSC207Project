package interface_adapter.logout;

import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInputData;

public class LogoutController {
    final LogoutInputBoundary logoutInteractor;

    public LogoutController(LogoutInputBoundary logoutInteractor){
        this.logoutInteractor = logoutInteractor;
    }

    public void execute(String username){
        LogoutInputData inputData = new LogoutInputData(username);
        logoutInteractor.execute(inputData);
    }
}
