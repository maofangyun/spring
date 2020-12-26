package com.mfy.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.mfy.test")
@ComponentScan("com.mfy.test")
@EnableTransactionManagement
public class MybatisTest {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MybatisTest.class);
    UserService bean = ac.getBean(UserService.class);
    System.out.println(bean.query());
  }

}
