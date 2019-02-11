package com.demo.domain.service.membersdiary;

import com.demo.config.jdbc.DatasourceEmbeddedConfig;
import com.demo.config.jdbc.JdbcConfig;
import com.demo.config.transaction.TransactionManagerConfig;
import com.demo.domain.entity.membersdiary.MembersDiary;
import java.util.stream.StreamSupport;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {DatasourceEmbeddedConfig.class, JdbcConfig.class, TransactionManagerConfig.class})
class MembersDiaryServiceTest {
  
  @Autowired
  MembersDiaryService membersDiaryService;
  
  @Test
  @DisplayName("全件検索テスト")
  void findAllTest() {
    
    Iterable<MembersDiary> membersDiary = membersDiaryService.findAll();
    
    SoftAssertions soft = new SoftAssertions();
    
    long count = StreamSupport.stream(membersDiary.spliterator(), false).count();
    soft.assertThat(count).as("検索総件数は20件").isEqualTo(20);
    
    StreamSupport.stream(membersDiary.spliterator(), false).forEach(
        diary -> {
          soft.assertThat(diary.getId()).as("Id").isNotNull();
          soft.assertThat(diary.getName()).as("Name").isNotNull();
          soft.assertThat(diary.getBirthday()).as("Birthday").isNotNull();
          soft.assertThat(diary.getBloodType()).as("BloodType").isNotNull();
          soft.assertThat(diary.getAddress()).as("Address").isNotNull();
        }
    );
    
    soft.assertAll();
  }
}