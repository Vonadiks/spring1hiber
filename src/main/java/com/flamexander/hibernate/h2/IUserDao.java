package com.flamexander.hibernate.h2;

import java.util.List;

public interface IUserDao {
    User findById(Long id);
    List<User> findAll();
    User save(User user);
    // ...
}
