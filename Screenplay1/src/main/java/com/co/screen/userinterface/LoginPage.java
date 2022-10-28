package com.co.screen.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target TXT_USERNAME = Target.the("enter the username")
            .locatedBy("//input[@id='user-name']");

    public static final Target TXT_PASSWORD = Target.the("enter the password")
            .locatedBy("//input[@id='password']");

    public static final Target BTN_LOGIN = Target.the("click the button")
            .locatedBy("//input[@id='login-button']");



}
