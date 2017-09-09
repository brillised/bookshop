package com.huihuang.dao;

import java.util.List;

import com.huihuang.javabean.User;

public interface UserDao {
	boolean addUser(User user);
	boolean delUser(Integer delId);
	boolean upUser(Integer no,User user);
	List<User> selectUser(Integer no,User user);
}
