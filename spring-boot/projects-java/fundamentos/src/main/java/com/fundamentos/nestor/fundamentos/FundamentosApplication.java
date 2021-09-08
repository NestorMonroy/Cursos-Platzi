package com.fundamentos.nestor.fundamentos;

import com.fundamentos.nestor.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
    //Inyección de dependencias con Spring
    private ComponentDependency componentDependency;

    //Creamos el constructor de la clase, al tener una dependencia que está implementando dos clases se utiliza
    // @Qualifier para seleccionar la dependencia que necesitamos  **
    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency) {
        this.componentDependency = componentDependency;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    //Método de la interfaz CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        //Lamamos a la implementación
        componentDependency.saludar();
    }
}
