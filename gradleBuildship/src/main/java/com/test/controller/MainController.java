package com.test.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String main(Model model) throws Exception {
		Timestamp time1 = new Timestamp(System.currentTimeMillis());
		model.addAttribute("time1", time1);
		model.addAttribute("getDay1", time1.getDay());
		model.addAttribute("getDate1", time1.getDate());
		model.addAttribute("getMonth1", time1.getMonth());
		
		LocalDateTime time2 = LocalDateTime.now();
		model.addAttribute("time2", time2);
		model.addAttribute("getDay2", time2.getDayOfWeek());
		model.addAttribute("getDate2", time2.getDayOfMonth());
		model.addAttribute("getMonth2", time2.getMonth());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		model.addAttribute("formatter", time2.format(formatter));
		
		return "main";
	}

	@GetMapping(value = {"/popup/", "/popup/main"})
	public ModelAndView popupMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("popup/main");
		return mv;
	}

	@GetMapping(value = "/popup/sub")
	public String popupSub() {
		return "popup/sub";
	}
}