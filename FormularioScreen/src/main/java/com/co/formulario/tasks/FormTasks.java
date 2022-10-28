package com.co.formulario.tasks;

import com.co.formulario.models.DataForm;
import com.co.formulario.userinterfaces.FormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FormTasks implements Task {

    DataForm dataForm;

    public FormTasks (DataForm dataForm){
        this.dataForm = dataForm;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue().into(FormPage.TXT_NAME));
        actor.attemptsTo(Enter.theValue().into(FormPage.TXT_EMAIL));
        actor.attemptsTo(Enter.theValue().into(FormPage.TXT_ADRESS));
        actor.attemptsTo(Enter.theValue().into(FormPage.TXT_ADRESS_PERMANENT));
        actor.attemptsTo(Click.on(FormPage.BTN_SUBMIT));
    }

 public static FormTasks enter(DataForm dataForm){
        return Tasks.instrumented(FormTasks.class, dataForm);
 }

}
