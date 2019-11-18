package com.test.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.service.UserInfoService;
import com.test.vo.UserInfoVo;

@Controller
@RequestMapping("/user/*")
public class UserInfoController {
	
	@Resource
	private UserInfoService userInfoService;

	@GetMapping("insert")
	public void insert(UserInfoVo userInfoVo, Model model) {
		model.addAttribute("userInfoVo", userInfoVo);
	}

	@PostMapping("insert")
	public void insert(@Valid UserInfoVo userInfoVo, BindingResult bindingResult, Model model) {
		userInfoService.validInsert(userInfoVo, bindingResult);
		if (!bindingResult.hasErrors())
			userInfoService.insert(userInfoVo);
		model.addAttribute("userInfoVo", userInfoVo);
	}
}