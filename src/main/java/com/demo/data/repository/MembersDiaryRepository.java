package com.demo.data.repository;

import com.demo.data.domain.MembersDiary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersDiaryRepository extends CrudRepository<MembersDiary, Integer> {
}
