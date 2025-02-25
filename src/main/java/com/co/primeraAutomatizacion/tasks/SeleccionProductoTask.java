package com.co.primeraAutomatizacion.tasks;

import com.co.primeraAutomatizacion.interactions.WaitElement;
import com.co.primeraAutomatizacion.userinterfaces.LoginPage;
import com.co.primeraAutomatizacion.userinterfaces.SeleccionProductosPage;
import io.vavr.API;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleccionProductoTask implements Task {

    private final int productoNum;

    public SeleccionProductoTask(int productoNum) {
        this.productoNum = productoNum;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SeleccionProductosPage.BTN_HOME));


       switch (this.productoNum) {
           case 1:
               actor.attemptsTo(Click.on(SeleccionProductosPage.URL_PRODUCTO_1));
               break;

           case 2:
               actor.attemptsTo(Click.on(SeleccionProductosPage.URL_PRODUCTO_2));
               break;

           case 3:
                actor.attemptsTo(Click.on(SeleccionProductosPage.URL_PRODUCTO_3));
                break;
       }

        actor.attemptsTo(Click.on(SeleccionProductosPage.BTN_AGREGARPRODUCTO));
        WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), 5);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

       if(this.productoNum==3){
           actor.attemptsTo(Click.on(SeleccionProductosPage.BTN_CART));
           actor.attemptsTo(WaitElement.elementIsVisible(SeleccionProductosPage.COMPARE,10));
       }

    }

    public static SeleccionProductoTask seleccionarProducto(int productoNum) {
        return Tasks.instrumented(SeleccionProductoTask.class, productoNum);
    }
}

