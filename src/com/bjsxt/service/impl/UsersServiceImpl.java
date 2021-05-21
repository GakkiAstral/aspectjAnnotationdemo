package com.bjsxt.service.impl;

import com.bjsxt.service.UsersService;

public class UsersServiceImpl implements UsersService {
    @Override
    public void addUsers(String username) {
        System.out.println("AddUsers "+username);
    }
}
