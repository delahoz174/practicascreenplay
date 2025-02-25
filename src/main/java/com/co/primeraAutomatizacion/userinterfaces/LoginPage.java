package com.co.primeraAutomatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target BTN_LOGIN =Target.the("Login")
            .locatedBy("//a[@id='login2']");

    public static final Target TXT_USERNAME = Target.the("ingresar usuario")
            .locatedBy("//input[@id='loginusername']");

    public static final Target TXT_PASSWORD = Target.the(("Ingresar contraseña"))
            .locatedBy("//input[@id='loginpassword']");

    public static final Target BTN_LOGININ = Target.the("Clic en el boton de login")
            .locatedBy("//*[@id='logInModal']/div/div/div[3]/button[2]");

    public static final Target COMPARE = Target.the("clic en el elemento welcome")
            .locatedBy("//a[@id='nameofuser']");
}
