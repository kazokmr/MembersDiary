package com.demo;

import com.demo.config.jdbc.DatasourceEmbeddedConfig;
import com.demo.config.jdbc.JdbcConfig;
import com.demo.config.transaction.TransactionManagerConfig;
import com.demo.config.web.MvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }
  
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{DatasourceEmbeddedConfig.class, JdbcConfig.class, TransactionManagerConfig.class, MvcConfig.class};
  }
  
  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
