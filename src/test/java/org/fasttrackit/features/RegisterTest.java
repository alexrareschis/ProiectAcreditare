package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.RegisterSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Steps
    private RegisterSteps registerSteps;

    @Test
    public void testValidRegister(){
        registerSteps.navigateToMyAccPage();
        registerSteps.createAccount(Constants.USER_EMAIL,Constants.USER_PASSWORD);
        registerSteps.clickRegister();
        registerSteps.checkIfRegistered("Hello automation.team (not automation.team? Log out)");
    }

    @Test
    public void testInvalidEmailAddressRegister(){
        registerSteps.navigateToMyAccPage();
        registerSteps.createAccount(Constants.USER_EMAIL2, Constants.USER_PASSWORD);
        registerSteps.clickRegister();
        registerSteps.checkIfValidRegisterEmailAddress("Error: Please provide a valid email address.");
    }

    @Test
    public void testRegisterWithoutPassword(){
        registerSteps.navigateToMyAccPage();
        registerSteps.createAccount("automation.test@gmail.com", "");
        registerSteps.clickRegister();
        registerSteps.checkIfValidRegisterEmailAddress("Error: Please enter an account password.");
    }

    @Test
    public void testIfPossibleToRegisterWithSameEmailAddress(){
        registerSteps.navigateToMyAccPage();
        registerSteps.createAccount(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        registerSteps.clickRegister();
        registerSteps.checkIfValidRegisterEmailAddress("Error: An account is already registered with your email address. Please log in.");
    }


}
