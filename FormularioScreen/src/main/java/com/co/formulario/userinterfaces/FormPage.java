package com.co.formulario.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FormPage {

    public static final Target TXT_NAME = Target.the("enter in the name").locatedBy("//input[@id= 'userName']");
    public static final Target TXT_EMAIL = Target.the("enter in the emal").locatedBy("//input[@id= 'userEmail']");
    public static final Target TXT_ADRESS = Target.the("enter in the adress").locatedBy("//textarea[@id= 'currentAddress']");
    public static final Target TXT_ADRESS_PERMANENT = Target.the("enter in the adress permanent").locatedBy("//textarea[@id= 'permanentAddress']");
    public static final Target BTN_SUBMIT = Target.the("click in th e button").locatedBy("//button[@id= 'submit']");


}
