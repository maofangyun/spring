package com.mfy.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
  @Autowired
  private UserMapper userMapper;

  @Transactional
  public List<User> query() {
    // TODO 测试spring事务
    return userMapper.query();
  }
}
