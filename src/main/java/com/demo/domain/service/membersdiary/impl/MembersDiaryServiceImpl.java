package com.demo.domain.service.membersdiary.impl;

import com.demo.domain.entity.membersdiary.MembersDiary;
import com.demo.domain.repository.membersdiary.MembersDiaryRepository;
import com.demo.domain.service.membersdiary.MembersDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MembersDiaryServiceImpl implements MembersDiaryService {
  
  MembersDiaryRepository membersDiaryRepository;
  
  @Autowired
  public MembersDiaryServiceImpl(MembersDiaryRepository membersDiaryRepository) {
    this.membersDiaryRepository = membersDiaryRepository;
  }
  
  @Override
  @Transactional(readOnly = true)
  public Iterable<MembersDiary> findAll() {
    return membersDiaryRepository.findAll();
  }
}
