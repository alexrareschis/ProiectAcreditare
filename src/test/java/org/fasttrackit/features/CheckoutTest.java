package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.CheckoutSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class CheckoutTest extends BaseTest {

    @Steps
    private CartSteps cartSteps;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private CheckoutSteps checkoutSteps;




    @Test
    public void verifyCheckoutTest(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASSWORD,
                "Hello automation.team (not automation.team? Log out)");
        cartSteps.navigateToShop();
        cartSteps.addSpecificProductsToCart();
        cartSteps.navigateToCart();
        cartSteps.proceedToCheckout();
        checkoutSteps.validBillingInfo("Team", "AII", "Romania",
                "Somewhere in the City", "CLUJ",
                "CJ","RO2020","+47451234456",Constants.USER_EMAIL);
        checkoutSteps.clickOnPlaceOrder();
        checkoutSteps.checkOrderReceived("Thank you. Your order has been received.");

    }

    @Test
    public void verifyCheckoutWithoutPhoneNumberTest(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASSWORD,
                "Hello automation.team (not automation.team? Log out)");
        cartSteps.navigateToShop();
        cartSteps.addSpecificProductsToCart();
        cartSteps.navigateToCart();
        cartSteps.proceedToCheckout();
        checkoutSteps.validBillingInfo("Team", "AII", "Romania",
                "Somewhere in the City", "CLUJ",
                "CJ","RO2020","",Constants.USER_EMAIL);
        checkoutSteps.clickOnPlaceOrder();
        checkoutSteps.verifyImpossibleToCheckout("Billing Phone is a required field.");

    }
}
