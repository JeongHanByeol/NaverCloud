package com.test.dao;

import java.util.List;

import com.test.vo.UserInfoVo;

public interface UserInfoDao {
	public List<UserInfoVo> selectList() throws Exception;
	public int existsUserId(String userId);
	public void insert(UserInfoVo user);
}