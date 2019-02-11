package com.demo.domain.repository.membersdiary;

import com.demo.domain.entity.membersdiary.MembersDiary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersDiaryRepository extends CrudRepository<MembersDiary, Integer> {
}
