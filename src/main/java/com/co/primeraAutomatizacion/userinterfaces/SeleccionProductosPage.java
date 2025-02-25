package com.co.primeraAutomatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SeleccionProductosPage {


    public static final Target BTN_HOME = Target.the("boton home")
            .locatedBy("//*[@id=\"navbarExample\"]/ul/li[1]/a");

    public static final Target URL_PRODUCTO_1 = Target.the("seleccion producto 1")
            .locatedBy("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a");

    public static final Target URL_PRODUCTO_2 = Target.the("seleccion producto 2")
            .locatedBy("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a");

    public static final Target URL_PRODUCTO_3 = Target.the("seleccion producto 3")
            .locatedBy("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a");

    public static  final Target BTN_AGREGARPRODUCTO = Target.the("agregar producto")
            .locatedBy("//*[@id=\"tbodyid\"]/div[2]/div/a");

    public static final Target BTN_CART = Target.the("boton del carrito")
            .locatedBy("#cartur");

    public static final Target COMPARE = Target.the("clic en el valor")
            .locatedBy("//*[@id=\"totalp\"]");

}
