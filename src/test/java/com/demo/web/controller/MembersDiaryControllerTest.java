package com.demo.web.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.demo.config.jdbc.DatasourceEmbeddedConfig;
import com.demo.config.jdbc.JdbcConfig;
import com.demo.config.transaction.TransactionManagerConfig;
import com.demo.config.web.MvcConfig;
import com.demo.domain.model.membersdiary.MembersDiaryModel;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.ui.ExtendedModelMap;

@SpringJUnitWebConfig(classes = {DatasourceEmbeddedConfig.class, JdbcConfig.class, TransactionManagerConfig.class, MvcConfig.class})
class MembersDiaryControllerTest {
  
  @Autowired
  MembersDiaryController membersDiaryController;
  
  @Test
  @DisplayName("Viewに出力するModelの項目を確認する")
  void membersDiaryModelTest() {
    ExtendedModelMap modelMap = new ExtendedModelMap();
    String viewName = membersDiaryController.list(modelMap);
    Object membersDiaryModel = modelMap.get("membersDiary");
    
    // モデルオブジェクトの確認
    assertThat(membersDiaryModel).as("ModelがNULLでは無い").isNotNull();
    assertThat(membersDiaryModel).isInstanceOf(List.class);
    
    List<MembersDiaryModel> modelList = (List<MembersDiaryModel>) membersDiaryModel;
    assertThat(modelList.size()).as("リストのサイズは20").isEqualTo(20);
    
    SoftAssertions soft = new SoftAssertions();
    modelList.stream()
        .forEach(model -> {
              soft.assertThat(model.getName()).as("名前が取れる").isNotNull();
              soft.assertThat(model.getBirthday()).as("生年月日が取れる").isNotNull();
              soft.assertThat(model.getBloodType()).as("血液型が取れる").isNotNull();
              soft.assertThat(model.getAddress()).as("都道府県が取れる").isNotNull();
            }
        );
    soft.assertAll();
  }
}