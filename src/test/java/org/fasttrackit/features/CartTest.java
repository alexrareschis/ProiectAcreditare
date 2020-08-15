package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.ShopPage;
import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

import java.util.Random;

public class CartTest extends BaseTest {

    @Steps
    private CartSteps cartSteps;
    @Steps
    private ShopPage shopPage;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private HomePage homePage;


    @Test
    public void addRandomProductToCart() {
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASSWORD,
                "Hello automation.team (not automation.team? Log out)");
        cartSteps.navigateToShop();
        Random rand = new Random();
        int n = rand.nextInt(10);
        String name = shopPage.getNameOfElement(n);
        cartSteps.addProductToCart(n);
        cartSteps.viewProductInCart(n);
        cartSteps.checkIfCartPage();
        cartSteps.verifyProductInCart(name);
    }

    @Test
    public void verifyTotalPriceOfProductsInCartTest(){

        cartSteps.navigateToShopFromHome();
        cartSteps.addSpecificProductsToCart();
        cartSteps.navigateToCart();
        cartSteps.verifyTotalProductPricesInCart();
    }







}
