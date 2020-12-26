/**
 * Copyright 2010-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mfy.test;

import java.util.List;

import org.apache.ibatis.annotations.Select;

/**
 * 由于使用了MapperFactoryBean的getObject()来生成UserMapper的代理对象,
 * 在扫描mapper接口,生成beanDefinition时,会将beanClass设置成MapperFactoryBean.class,
 * 因此用ac.getBean(UserMapper.class)调用,生成的是MapperFactoryBean对象,所以,为了避免这种情况,
 * spring会事先调用ac.getBean("userMapper"),生成UserMapper的代理对象,再次调用ac.getBean(UserMapper.class),
 * 就没有问题了
 * */
public interface UserMapper {

  @Select("SELECT username,sex FROM user")
  List<User> query();
}
