package com.demo.domain.service.membersdiary;

import com.demo.domain.entity.membersdiary.MembersDiary;

public interface MembersDiaryService {
  Iterable<MembersDiary> findAll();
}
