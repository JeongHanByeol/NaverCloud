package com.test.vo;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserInfoVo {
	@NotBlank(message = "아이디를 입력해주세요.")
	private String userId;
	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String userPw;
	@NotBlank(message = "이름를 입력해주세요.")
	private String userName;
	private Float userHeight;
	private Float userWeight;
	private LocalDateTime joinDate;
}