package co.com.conduit.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;


public class LoginPage extends PageObject {

    @FindBy(xpath = "/html/body/app-root/app-layout-header/nav/div/ul/li[2]/a")
    WebElement link_signIn;

    @FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[2]/input")
    WebElement txtEmail;

    @FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[3]/input")
    WebElement txtPassword;

    @FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/button")
    WebElement btnLogin;

    public void login(Map<String,String> data){
        link_signIn.click();
        txtEmail.sendKeys(data.get("email"));
        txtPassword.sendKeys((data.get("password")));
        btnLogin.click();
    }


}
