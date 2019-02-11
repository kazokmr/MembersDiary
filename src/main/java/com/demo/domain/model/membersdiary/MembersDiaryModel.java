package com.demo.domain.model.membersdiary;

import com.demo.domain.entity.membersdiary.MembersDiary;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MembersDiaryModel {
  
  private final MembersDiary membersDiary;
  
  public MembersDiaryModel(MembersDiary membersDiary) {
    this.membersDiary = membersDiary;
  }
  
  public String getName() {
    return membersDiary.getName();
  }
  
  public String getBirthday() {
    return DateTimeFormatter.ofPattern("uuuu/MM/dd").format(membersDiary.getBirthday());
  }
  
  public String getBloodType() {
    return membersDiary.getBloodType();
  }
  
  public String getAddress() {
    return membersDiary.getAddress();
  }
}
