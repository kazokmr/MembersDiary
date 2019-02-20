package com.demo.config.jdbc;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

class DatasourceEmbeddedConfigTest {
  
  @Test
  @DisplayName("members_diaryテーブルの初期登録状況を確認する")
  void insertMembersDiaryTest() {
    DataSource dataSource = new DatasourceEmbeddedConfig().dataSource();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    int rowCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "members_diary");
    assertThat(rowCount).as("members_diaryテーブルの登録件数が20件なこと").isEqualTo(20);
  }
}