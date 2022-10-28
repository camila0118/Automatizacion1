package com.co.screen2.userinterfaces;

import net.bytebuddy.implementation.Implementation;
import net.serenitybdd.screenplay.targets.Target;


public class LoginPage {

    public static final Target TXT_EMAIL = Target.the("enter in the email").locatedBy("//input [@name='_user']");
    public static final Target TXT_PASSWORD = Target.the("enter in the password").locatedBy("//input [@name='_pass']");
    public static final Target BTN_ENTER = Target.the("enter in he page").locatedBy("//button [@id='rcmloginsubmit']");

}
