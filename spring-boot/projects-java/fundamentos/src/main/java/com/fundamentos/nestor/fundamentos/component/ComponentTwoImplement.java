package com.fundamentos.nestor.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    //Implementa la misma dependencia
    @Override
    public void saludar() {
        System.out.println("Hola nestor desde el componente 2");
    }
}
