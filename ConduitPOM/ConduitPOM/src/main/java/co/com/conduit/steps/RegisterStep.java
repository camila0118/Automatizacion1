package co.com.conduit.steps;

import co.com.conduit.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class RegisterStep {

    RegisterPage rp;

    @Step
    public void openWebSite(){

        rp.open();
    }

    @Step
    public void callSignUp(Map<String,String> registerData){
        rp.singUp(registerData);
    }

    @Step
    public void validationProfile(String username){
        Assert.assertEquals(rp.validationName(), username);
    }

}
