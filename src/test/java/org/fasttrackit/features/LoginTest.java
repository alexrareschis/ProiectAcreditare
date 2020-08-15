package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void testValidLoginWithEmailAddress(){

        loginSteps.navigateToLogin();
        loginSteps.loginDetails(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        loginSteps.clickRememberMe();
        loginSteps.clickLogin();
        loginSteps.checkIfLoggedIn("Hello automation.team (not automation.team? Log out)");
    }

    @Test
    public void testInvalidLogin(){
        loginSteps.navigateToLogin();
        loginSteps.loginDetails(Constants.USER_EMAIL2, Constants.USER_PASSWORD2);
        loginSteps.clickRememberMe();
        loginSteps.clickLogin();
        loginSteps.checkIfInvalidLogin("ERROR: Invalid username. Lost your password?");
    }

    @Test
    public void testValidLoginWithUsername(){

        loginSteps.navigateToLogin();
        loginSteps.loginDetails("automation.team","AUTOteam2020!" );
        loginSteps.clickRememberMe();
        loginSteps.clickLogin();
        loginSteps.checkIfLoggedIn("Hello automation.team (not automation.team? Log out)");
    }
}
