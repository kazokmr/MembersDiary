package com.demo.data.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.jdbc.JdbcTestUtils;

class DatasourceEmbeddedConfigTest {
  
  @Test
  @DisplayName("members_diaryテーブルの初期登録状況を確認する")
  void insertMembersDiaryTest() {
    EmbeddedDatabase database = new DatasourceEmbeddedConfig().dataSource();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(database);
    int rowCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "members_diary");
    assertThat(rowCount).as("members_diaryテーブルの登録件数が20件なこと").isEqualTo(20);
  }
}