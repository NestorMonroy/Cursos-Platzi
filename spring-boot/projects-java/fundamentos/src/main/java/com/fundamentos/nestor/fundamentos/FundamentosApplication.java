package com.fundamentos.nestor.fundamentos;

import com.fundamentos.nestor.fundamentos.bean.MyBean;
import com.fundamentos.nestor.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.nestor.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.nestor.fundamentos.bean.MyOwnBeanWithDependency;
import com.fundamentos.nestor.fundamentos.component.ComponentDependency;
import com.fundamentos.nestor.fundamentos.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

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
        System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());

        try {
            int value = 10 / 0;
            LOGGER.debug("Mi valor: " + value);
        } catch (Exception e) {
            LOGGER.error("Esto es un error al dividir entre 0 " + e.getMessage());
        }
    }
}
