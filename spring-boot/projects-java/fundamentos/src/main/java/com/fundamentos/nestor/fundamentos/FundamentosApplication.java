package com.fundamentos.nestor.fundamentos;

import com.fundamentos.nestor.fundamentos.bean.MyBean;
import com.fundamentos.nestor.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.nestor.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.nestor.fundamentos.bean.MyOwnBeanWithDependency;
import com.fundamentos.nestor.fundamentos.component.ComponentDependency;
import com.fundamentos.nestor.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
    //Inyección de dependencias con Spring
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyOwnBeanWithDependency myOwnBeanWithDependency;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;

    //Creamos el constructor de la clase, al tener una dependencia que está implementando dos clases se utiliza
    // @Qualifier para seleccionar la dependencia que necesitamos**
    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyOwnBeanWithDependency myOwnBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myOwnBeanWithDependency = myOwnBeanWithDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    //Método de la interfaz CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        //Lamamos a la implementación
        componentDependency.saludar();
        myBean.print();
        myBeanWithDependency.printWithDependency();
        myOwnBeanWithDependency.displayElements();
        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail() + "-" +userPojo.getPassword());

    }
}
