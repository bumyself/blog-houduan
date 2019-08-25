package com.linminrui.blog.service;

import com.linminrui.blog.po.User;

public interface UserService {
    public User findUserByUserNameAndPassword(String username, String password);
}
