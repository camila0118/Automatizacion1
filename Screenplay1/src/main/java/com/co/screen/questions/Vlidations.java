package com.co.screen.questions;

import com.co.screen.userinterface.LoginPage;
import com.co.screen.userinterface.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class Vlidations implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ProductPage.LBL_CAPTURE_TEXT).viewedBy(actor).asBoolean();
    }

    public static Vlidations compare(){
        return new Vlidations();
    }
}
