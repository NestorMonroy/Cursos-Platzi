package com.fundamentos.nestor.fundamentos.configuration;

import com.fundamentos.nestor.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation() {
        // new instancia la implementación
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationWithDependency(MyOperation myOperation) {
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public MyOwnOperation beanOperationMyOwn() {
        return new MyOwnOperationImplement();
    }

    @Bean
    public MyOwnBeanWithDependency beanOperationMyOwnWithDependency(MyOwnOperation myOwnOperation){
        return new MyOwnBeanWithDependencyImplement(myOwnOperation);
    }


}
