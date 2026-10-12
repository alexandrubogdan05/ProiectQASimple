package tests;

import pages.CartPage;
import pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SauceDemoTests extends BaseTest {

    @Test
    public void test1_AdaugareInCosSiVerificarePret() {
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);

        // 1. Autentificare cu date valide
        loginPage.autentificare("standard_user", "secret_sauce");

        // 2. Adaugare produs in cos si deschidere cos
        cartPage.adaugaBackpackInCos();
        cartPage.deschideCosul();

        // 3. Verificari (Assertions)
        Assertions.assertEquals("Sauce Labs Backpack", cartPage.getNumeProdusInCos(), "Numele produsului difera!");
        Assertions.assertEquals("$29.99", cartPage.getPretProdusInCos(), "Pretul difera!");
    }

    @Test
    public void test2_LoginEsuatCuParolaGresita() {
        LoginPage loginPage = new LoginPage(driver);

        // 1. Incercare autentificare cu parola invalida
        loginPage.autentificare("standard_user", "parola_gresita");

        // 2. Verificare mesaj de eroare
        String mesajEroare = loginPage.getErrorMessageText();
        Assertions.assertTrue(mesajEroare.contains("Username and password do not match"),
                "Mesajul de eroare afisat nu este cel corect!");
    }
}