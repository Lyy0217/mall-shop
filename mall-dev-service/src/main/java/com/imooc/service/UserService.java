package com.imooc.service;

public interface UserService {
    /**
     * 判断用户名是否存在
     * @param userName
     * @return
     */
    public boolean queryUsernameIsExit(String userName);
}
