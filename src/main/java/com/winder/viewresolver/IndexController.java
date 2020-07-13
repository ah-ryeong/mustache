package com.winder.viewresolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  //IoC
public class IndexController {

	@GetMapping({"","/"})
	public String index(Model model) {
		String name ="winter";
		int num = 10;
		String password = "1234";
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		model.addAttribute("password", password);
		
		// => /viewresolver/src/main/resources/templates/index.mustache
		return "Index";
	}
	
	@GetMapping("/model/data")
	public String modelData(Model model) { // DI 하기
		Member member = Member.builder()
				.id(1)
				.username("winter")
				.phone("01012341234")
				.build();
		model.addAttribute("member", member);
		
		return "modelData";
	}
	
	@GetMapping("/model/array")
	public String modelArray(Model model) { // DI 하기
		Member member1 = Member.builder()
				.id(1)
				.username("winter")
				.phone("01012341234")
				.build();
		
		Member member2 = Member.builder()
				.id(2)
				.username("sunny")
				.phone("01012345678")
				.build();
		
		List<Member> members = new ArrayList<>();
		members.add(member1);
		members.add(member2);
		model.addAttribute("members", members);
		model.addAttribute("user", true); // 반전 출력
		
		return "modelArray"; // modelArray로 데이터 또는 파일을 가지고 이동
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "layout";
	}
	
}
