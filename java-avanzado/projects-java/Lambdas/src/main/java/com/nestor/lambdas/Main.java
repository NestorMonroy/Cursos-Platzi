package com.nestor.lambdas;

public class Main {
    public static void main(String[] args) {
        OnOneListener onOneListener = new OnOneListener() {
            @Override
            public void onOne(String message) {
                System.out.println("Hola" + message );
            }
        };

        OnOneListener onOneListener1 = (String message) -> {
            System.out.println("Hola " + message );
        };

        onOneListener.onOne("Sin lambda()");
        onOneListener1.onOne("Con lambda()");

        OnOneListener onOneListener2 = message -> System.out.println("Tu mensaje " + message);


    }

}
