package co.com.conduit.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;


public class CriticalFlowArticlePage extends PageObject {

    //sign in
    LoginPage lp;

    //newArticle
    NewArticle na;

    //profile
    //@FindBy(xpath = "//a[@class='nav-link' and @href='/profile/Kevin12']")
    //WebElement btn_profile;

    @FindBy(xpath = "/html/body/app-root/app-home-page/div/div/div/div[1]/app-article-list/div[2]")
    WebElement messge;


    public void flujoArticulo(Map<String,String> data) throws InterruptedException {
        lp.login(data);
        na.publishArticle(data);
        na.editArticle(data);
        na.deleteArticle();
    }

    //validation message
    public String validationMessage(){
        return messge.getText();
    }


}
