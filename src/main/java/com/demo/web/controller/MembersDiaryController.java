package com.demo.web.controller;

import com.demo.domain.entity.membersdiary.MembersDiary;
import com.demo.domain.model.membersdiary.MembersDiaryModel;
import com.demo.domain.service.membersdiary.MembersDiaryService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MembersDiaryController {
  
  private final MembersDiaryService membersDiaryService;
  
  @Autowired
  public MembersDiaryController(MembersDiaryService membersDiaryService) {
    this.membersDiaryService = membersDiaryService;
  }
  
  @GetMapping("/list")
  public String list(Model model) {
    Iterable<MembersDiary> membersDiary = membersDiaryService.findAll();
    // 画面に必要な項目のみ抽出したリストを返す
    List<MembersDiaryModel> membersDiaryModels =
        StreamSupport.stream(membersDiary.spliterator(), false)
            .sorted(Comparator.comparingInt(MembersDiary::getId))
            .map(MembersDiaryModel::new)
            .collect(Collectors.toList());
    model.addAttribute("membersDiary", membersDiaryModels);
    return "list";
  }
}
