package com.fundamentos.nestor.fundamentos.caseUse;

import com.fundamentos.nestor.fundamentos.entity.User;
import com.fundamentos.nestor.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
