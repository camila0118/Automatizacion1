package com.co.outline.steps;

import net.thucydides.core.annotations.Step;
import com.co.outline.pages.LoginPage;

public class LoginStep {

   LoginPage loginpage;

   @Step
    public void openPage(){
    loginpage.open();
   }


    @Step
    public void DataLogin( String user){
       loginpage.getDriver().findElement(loginpage.getTXT_USERNAME()).sendKeys(user);


   }

   @Step
   public void Datalogin1 (String password){
       loginpage.getDriver().findElement(loginpage.getTXT_PASSWORD()).sendKeys(password);
   }


   @Step
    public void click(){
       loginpage.getDriver().findElement(loginpage.getBTN_LOGIN()).click();
   }


}
