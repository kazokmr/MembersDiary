package com.demo.config.jdbc;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DatasourceEmbeddedConfig {
  
  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
        .generateUniqueName(true)
        .setType(EmbeddedDatabaseType.H2)
        .setScriptEncoding("UTF-8")
        .ignoreFailedDrops(true)
        .addScript("classpath:/sql/schema.sql")
        .addScripts("classpath:/sql/data.sql")
        .build();
  }
}
