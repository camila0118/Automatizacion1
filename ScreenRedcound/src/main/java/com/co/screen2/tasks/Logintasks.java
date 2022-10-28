package com.co.screen2.tasks;

import com.co.screen2.userinterfaces.LoginPage;
import com4j.CLSCTX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Logintasks implements Task {

    private String email = System.getProperty("email");
    private String password = System.getProperty("password");
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(email).into(LoginPage.TXT_EMAIL));
        actor.attemptsTo(Enter.theValue(password).into(LoginPage.TXT_PASSWORD));
        actor.attemptsTo(Click.on(LoginPage.BTN_ENTER));
    }

    public static Logintasks enter() {
        return Tasks.instrumented(Logintasks.class);
    }

}
