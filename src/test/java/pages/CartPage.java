package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    // Elementele HTML din pagina de Cos si Produse
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartProductName = By.className("inventory_item_name");
    private By cartProductPrice = By.className("inventory_item_price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actiuni pe pagina de Cos
    public void adaugaBackpackInCos() {
        driver.findElement(addToCartButton).click();
    }

    public void deschideCosul() {
        driver.findElement(cartIcon).click();
    }

    public String getNumeProdusInCos() {
        return driver.findElement(cartProductName).getText();
    }

    public String getPretProdusInCos() {
        return driver.findElement(cartProductPrice).getText();
    }
}