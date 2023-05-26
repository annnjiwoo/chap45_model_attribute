package com.javalab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.javalab.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;
/**
 * @SessionAttributes("member")
 *  - 여러 메소드에서 model에 값을 저장할 때 "member"라는 
 *  이름으로 저장되는 값이 있으면 세션에도 저장하라는 뜻.
 */
@Controller
@SessionAttributes("member")
@Slf4j
public class SessionAttrController {
   
   // 어플리케이션 시작과 동시에 기본적으로 호출되는 Url "/"
   @GetMapping("/")
   public String home() {      
      log.info("home");      
      return "redirect:form";   
   }
      
   @GetMapping("/formRest")
   public String getMemberList(Model model) {      
      MemberVo member = new MemberVo();
      member.setId("dragon");
      member.setName("홍길동");
      member.setAge(21);
      member.setBloodType("o");
      member.setGender("남");
       
      //model에 "member"라는 이름으로 저장하면
      //세션에도 member객체가 생성된다.
      model.addAttribute("member", member);      
      return "sessionAttribute";
   } //
}
