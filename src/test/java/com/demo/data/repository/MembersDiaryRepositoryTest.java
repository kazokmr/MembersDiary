package com.demo.data.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.demo.config.jdbc.DatasourceEmbeddedConfig;
import com.demo.config.jdbc.JdbcConfig;
import com.demo.domain.entity.membersdiary.MembersDiary;
import com.demo.domain.repository.membersdiary.MembersDiaryRepository;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {DatasourceEmbeddedConfig.class, JdbcConfig.class, MembersDiaryRepository.class})
class MembersDiaryRepositoryTest {
  
  @Autowired
  MembersDiaryRepository repository;
  
  @Test
  @DisplayName("登録済みデータの検索テスト")
  void readMembersDiaryTest() {
    
    Optional<MembersDiary> optionalMemberDiary = repository.findById(1);
    assertThat(optionalMemberDiary.isPresent()).as("ID=1の情報が検索できる").isTrue();
    
    SoftAssertions soft = new SoftAssertions();
    MembersDiary memberDiary = optionalMemberDiary.get();
    soft.assertThat(memberDiary.getId()).as("Id").isEqualTo(1);
    soft.assertThat(memberDiary.getName()).as("Name").isEqualTo("和田 恵梨香");
    soft.assertThat(memberDiary.getBirthday()).as("Birthday").isEqualTo(LocalDate.of(1980, Month.JULY, 15));
    soft.assertThat(memberDiary.getBloodType()).as("BloodType").isEqualTo("O");
    soft.assertThat(memberDiary.getAddress()).as("Address").isEqualTo("東京都");
    soft.assertAll();
  }
  
  @Test
  @DisplayName("データの登録テスト")
  void createMembersDiaryTest() {
    
    MembersDiary createData = new MembersDiary(
        "岡 美枝子",
        LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse("1996-02-21")),
        "A",
        "大阪府"
    );
    
    repository.save(createData);
    
    Optional<MembersDiary> optionalMemberDiary = repository.findById(21);
    assertThat(optionalMemberDiary.isPresent()).as("ID=21の情報が検索できる").isTrue();
    
    SoftAssertions soft = new SoftAssertions();
    MembersDiary memberDiary = optionalMemberDiary.get();
    soft.assertThat(memberDiary.getId()).as("Id").isEqualTo(21);
    soft.assertThat(memberDiary.getName()).as("Name").isEqualTo("岡 美枝子");
    soft.assertThat(memberDiary.getBirthday()).as("Birthday").isEqualTo(LocalDate.of(1996, Month.FEBRUARY, 21));
    soft.assertThat(memberDiary.getBloodType()).as("BloodType").isEqualTo("A");
    soft.assertThat(memberDiary.getAddress()).as("Address").isEqualTo("大阪府");
    soft.assertAll();
  }
}