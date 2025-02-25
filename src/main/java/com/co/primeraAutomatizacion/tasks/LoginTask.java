package com.co.primeraAutomatizacion.tasks;

import com.co.primeraAutomatizacion.interactions.WaitElement;
import com.co.primeraAutomatizacion.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.co.primeraAutomatizacion.utils.Credenciales.CLAVE;
import static com.co.primeraAutomatizacion.utils.Credenciales.USUARIO;

public class LoginTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LoginPage.BTN_LOGIN));
        actor.attemptsTo(Enter.theValue(USUARIO).into(LoginPage.TXT_USERNAME));
        actor.attemptsTo(Enter.theValue(CLAVE).into(LoginPage.TXT_PASSWORD));
        actor.attemptsTo(Click.on(LoginPage.BTN_LOGININ));
        actor.attemptsTo(WaitElement.elementIsClickable(LoginPage.COMPARE,10));


    }

    public static LoginTask enterCredencial(){
        return Tasks.instrumented(LoginTask.class);
    }
}
