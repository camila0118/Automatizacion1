package co.com.conduit.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

@DefaultUrl("http://angular.realworld.io/")
public class RegisterPage extends PageObject {

    @FindBy(xpath = "//a[@routerlink='/register']")
    WebElement link_signup;

    @FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[1]/input")
    WebElement txtUsername;

    @FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[2]/input")
    WebElement txtEmail;

    @FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[3]/input")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary pull-xs-right']")
    WebElement btnRegister;

    @FindBy(xpath = "/html/body/app-root/app-layout-header/nav/div/ul/li[4]/a")
    WebElement profile;

    public void singUp(Map<String,String>registerData){
        link_signup.click();
        txtUsername.sendKeys(registerData.get("username"));
        txtEmail.sendKeys(registerData.get("email"));
        txtPassword.sendKeys(registerData.get("password"));
        btnRegister.click();
    }

    public String validationName(){
        return profile.getText();
    }

}
