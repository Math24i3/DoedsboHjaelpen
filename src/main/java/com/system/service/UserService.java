package com.system.service;


import com.system.model.User;

public interface UserService {
    public void saveUser(User user);
    public boolean issUserAlreadyPresent(User user);
    public User currentUser(String email);
}
