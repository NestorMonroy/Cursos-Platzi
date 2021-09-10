package com.fundamentos.nestor.fundamentos.configuration;

import com.fundamentos.nestor.fundamentos.caseUse.GetUser;
import com.fundamentos.nestor.fundamentos.caseUse.GetUserImplement;
import com.fundamentos.nestor.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImplement(userService);
    }
}
