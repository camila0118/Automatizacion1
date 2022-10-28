package com.co.screen.tasks;

import com.co.screen.models.Credentials;
import com.co.screen.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginTasks implements Task {

    Credentials credentials;

    public LoginTasks(Credentials credentials) {
        this.credentials = credentials;
    }

    private String username = System.getProperty("username");
    private String password = System.getProperty("password");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(credentials.getUsername()).into(LoginPage.TXT_USERNAME));
        actor.attemptsTo(Enter.theValue(credentials.getPassword()).into(LoginPage.TXT_PASSWORD));
        actor.attemptsTo(Click.on(LoginPage.BTN_LOGIN));

    }

    public static LoginTasks enter(Credentials credentials) {
        return Tasks.instrumented(LoginTasks.class, credentials);
    }

}
