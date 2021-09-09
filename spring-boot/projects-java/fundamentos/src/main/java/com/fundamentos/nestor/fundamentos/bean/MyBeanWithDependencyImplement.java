package com.fundamentos.nestor.fundamentos.bean;

import com.fundamentos.nestor.fundamentos.FundamentosApplication;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Estamos en el método printWithDependency");// Estar en un aplicativo
        int numero = 1;
        LOGGER.debug("El numero enviado como parámetro a la dependencia operacion es : " + numero);
        System.out.println(myOperation.suma(numero));
        System.out.println("Hola desde la implementación con un bean dependency");
    }
}
