package com.fundamentos.nestor.fundamentos.caseUse;


import com.fundamentos.nestor.fundamentos.entity.User;
import com.fundamentos.nestor.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
