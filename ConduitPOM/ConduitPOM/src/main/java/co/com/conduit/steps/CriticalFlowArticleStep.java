package co.com.conduit.steps;

import co.com.conduit.pages.CriticalFlowArticlePage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class CriticalFlowArticleStep {

    CriticalFlowArticlePage cfap;

    @Step
    public void callFlujoArticulo(Map<String,String> data) throws InterruptedException {
        cfap.flujoArticulo(data);
    }

    @Step
    public void compareMessage(String message){
        Assert.assertEquals(cfap.validationMessage(), message);
    }
}
