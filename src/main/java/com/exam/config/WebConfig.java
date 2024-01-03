package com.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.exam.interceptor.LoginCheckInterceptor;

@Configuration // servlet-context.xml
public class WebConfig implements WebMvcConfigurer {

  /*
   * <mvc:interceptors> <mvc:interceptor> <mvc:mapping path="/loginCheck/*"/> <ref bean="xxx"/>
   * </mvc:interceptor>
   * 
   */
  @Autowired
  LoginCheckInterceptor interceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(interceptor).addPathPatterns("/mypage", "/write", "/apply", "/retrieve");
  }

  // <mvc:view-controller path="/mypage" view-name="main" />

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {

  }

 


}
