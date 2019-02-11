package com.demo.domain.entity.membersdiary;

import java.time.LocalDate;
import java.util.Objects;
import org.springframework.data.annotation.Id;

public class MembersDiary {
  
  @Id
  private Integer id;
  private String name;
  private LocalDate birthday;
  private String bloodType;
  private String address;
  
  public MembersDiary(String name, LocalDate birthday, String bloodType, String address) {
    this.name = name;
    this.birthday = birthday;
    this.bloodType = bloodType;
    this.address = address;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public LocalDate getBirthday() {
    return birthday;
  }
  
  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }
  
  public String getBloodType() {
    return bloodType;
  }
  
  public void setBloodType(String bloodType) {
    this.bloodType = bloodType;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  @Override
  public String toString() {
    return "MembersDiary{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", birthday=" + birthday +
        ", bloodType='" + bloodType + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MembersDiary that = (MembersDiary) o;
    return id.equals(that.id);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
