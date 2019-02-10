package com.demo.data.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
import javax.sql.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

class JdbcConfigTest {
  
  private JdbcConfig jdbcConfig = new JdbcConfig();
  private DataSource dataSource = new DatasourceEmbeddedConfig().dataSource();
  
  @Test
  @DisplayName("JdbcTemplateBeanが作られることをテストする")
  void JdbcTemplateTest() throws NoSuchMethodException {
    Method jdbcTemplateMethod = JdbcConfig.class.getMethod("jdbcTemplate", DataSource.class);
    Bean bean = jdbcTemplateMethod.getAnnotation(Bean.class);
    assertThat(bean).as("@Beanアノテーションが付与されている").isNotNull();
    
    JdbcTemplate jdbcTemplate = jdbcConfig.jdbcTemplate(dataSource);
    assertThat(jdbcTemplate).as("JDBCTemplateが得られること").isNotNull();
  }
  
}