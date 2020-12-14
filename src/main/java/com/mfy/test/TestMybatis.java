package com.mfy.test;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.mfy.test")
@ComponentScan("com.mfy.test")
public class TestMybatis {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestMybatis.class);
    UserService bean = ac.getBean(UserService.class);
    System.out.println(bean.query());
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    PooledDataSource dataSource = new PooledDataSource();
    dataSource.setDriver("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://47.96.126.175:3306/localtest?useSSL=false&serverTimezone=UTC");
    dataSource.setUsername("root");
    dataSource.setPassword("#lzdong#p");
    factoryBean.setDataSource(dataSource);
    return factoryBean.getObject();
  }
}
