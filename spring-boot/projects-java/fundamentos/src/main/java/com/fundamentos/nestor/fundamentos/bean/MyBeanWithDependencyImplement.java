package com.fundamentos.nestor.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {
    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 1;
        System.out.println(myOperation.suma(numero));
        System.out.println("Hola desde la implementación con un bean dependency");
    }
}
