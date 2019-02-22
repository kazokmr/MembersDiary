package com.demo.domain.model.membersdiary;

import static java.time.format.DateTimeFormatter.ofPattern;

import com.demo.domain.entity.membersdiary.MembersDiary;
import java.io.Serializable;

public class MembersDiaryModel implements Serializable {
  
  private static final long serialVersionUID = -6810611005782289073L;
  
  private final MembersDiary membersDiary;
  
  public MembersDiaryModel(MembersDiary membersDiary) {
    this.membersDiary = membersDiary;
  }
  
  public String getName() {
    return membersDiary.getName();
  }
  
  public String getBirthday() {
    return ofPattern("uuuu/MM/dd").format(membersDiary.getBirthday());
  }
  
  public String getBloodType() {
    return membersDiary.getBloodType();
  }
  
  public String getAddress() {
    return membersDiary.getAddress();
  }
}
