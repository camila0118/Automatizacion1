package co.com.conduit.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class NewArticle extends PageObject {

    @FindBy(xpath = "//a[@class='nav-link' and @routerlink='/editor']")
    WebElement link_newArticle;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[1]/input")
    WebElement txtTitleArticle;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[2]/input")
    WebElement txtAboutArticle;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[3]/textarea")
    WebElement txtDescriptionArticle;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[4]/input")
    WebElement txtTagsArticle;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/button")
    WebElement btnPublishArticle;

    //new article

    public void publishArticle(Map<String,String> data) throws InterruptedException {
        link_newArticle.click();
        txtTitleArticle.sendKeys(data.get("titleArticle"));
        Thread.sleep(2000);
        txtAboutArticle.sendKeys(data.get("articleTopic"));
        Thread.sleep(2000);
        txtDescriptionArticle.sendKeys(data.get("description"));
        Thread.sleep(2000);
        txtTagsArticle.sendKeys(data.get("tags") + Keys.ENTER);
        Thread.sleep(2000);
        btnPublishArticle.click();
        Thread.sleep(2000);
    }

    //edit article

    @FindBy(xpath = "//a[@class='btn btn-sm btn-outline-secondary']")
    WebElement link_edit_article;


    public void editArticle(Map<String,String> data){
        link_edit_article.click();
        txtTitleArticle.sendKeys(Keys.CONTROL+"A");
        txtTitleArticle.sendKeys(data.get("newtitleArticle"));
        txtAboutArticle.sendKeys(Keys.CONTROL+"A");
        txtAboutArticle.sendKeys(data.get("newarticleTopic"));
        txtDescriptionArticle.sendKeys(Keys.CONTROL+"A");
        txtDescriptionArticle.sendKeys(data.get("newdescription"));
        btnPublishArticle.click();
    }

    //delete article

    @FindBy(xpath = "/html/body/app-root/app-article-page/div/div[1]/div/app-article-meta/div/span[1]/button")
    WebElement btn_delete_article;

    public void deleteArticle(){
        btn_delete_article.click();
    }

}
