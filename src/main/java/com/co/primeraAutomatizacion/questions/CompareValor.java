package com.co.primeraAutomatizacion.questions;

import com.co.primeraAutomatizacion.userinterfaces.LoginPage;
import com.co.primeraAutomatizacion.userinterfaces.SeleccionProductosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class CompareValor implements Question <String>{
    @Override
    public String answeredBy(Actor actor){
        return Text.of(SeleccionProductosPage.COMPARE).viewedBy(actor).asString();
    }

    public static CompareValor compare(){
        return new CompareValor();
    }
}
