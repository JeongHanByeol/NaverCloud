package com.test.service;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.test.constant.ConstFunc;
import com.test.dao.UserInfoDao;
import com.test.vo.UserInfoVo;

/**
 * 사용자 정보 서비스
 * @author 정보기술팀
 *
 */
@Service
public class UserInfoService {
	
	@Resource
	private UserInfoDao userInfoDao;
	
	/**
	 * 사용자 등록 시 유효성 검사 체크
	 * @param userInfoVo
	 * @param bindingResult
	 */
	public void validInsert(UserInfoVo userInfoVo, BindingResult bindingResult) {
		if (0 < userInfoDao.existsUserId(userInfoVo.getUserId()))
			ConstFunc.addError(bindingResult, "userId", "존재하는 아이디 입니다.");
	}

	/**
	 * 사용자 정보 등록
	 * @param userInfoVo
	 * @return
	 */
	public void insert(UserInfoVo userInfoVo) {
		
		try {
			
			if (userInfoVo.getUserHeight() == null)
				userInfoVo.setUserHeight(0f);
			if (userInfoVo.getUserWeight() == null)
				userInfoVo.setUserWeight(0f);
			if (userInfoVo.getJoinDate() == null)
				userInfoVo.setJoinDate(LocalDateTime.now());
			
			userInfoDao.insert(userInfoVo);
			
		} catch (Exception e) {
			
		}
	}
}