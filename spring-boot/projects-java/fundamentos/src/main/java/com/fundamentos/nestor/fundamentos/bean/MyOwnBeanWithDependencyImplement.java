package com.fundamentos.nestor.fundamentos.bean;

import java.util.List;

public class MyOwnBeanWithDependencyImplement implements MyOwnBeanWithDependency{
    private MyOwnOperation myOwnOperation;


    public MyOwnBeanWithDependencyImplement(MyOwnOperation myOwnOperation) {
        this.myOwnOperation = myOwnOperation;
    }

    @Override
    public void displayElements() {
        System.out.println("Llamamos a MyOwnOperationImplement para generar lista aleatoria");
        List<Integer> randomNums = this.myOwnOperation.generateRandomElements(100,10);
        randomNums.forEach(System.out::println);
        System.out.println("Hola desde mi implementación de un bean con dependencia usando Streams y Listas");
    }
}
