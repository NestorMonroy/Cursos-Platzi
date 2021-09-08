package com.fundamentos.nestor.fundamentos.component;

import org.springframework.stereotype.Component;

//Anotamos la clase con @Component
@Component
public class ComponentImplement implements ComponentDependency {

    //Implementamos el método de la dependencia
    @Override
    public void saludar() {
        System.out.println("Hola Nestor, desde mi componente");
    }
}
