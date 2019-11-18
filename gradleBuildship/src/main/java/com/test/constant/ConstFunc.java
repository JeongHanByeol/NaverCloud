package com.test.constant;

import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConstFunc {

	/**
	 * 사용자 임의 객체 유효성 검사 에러 추가
	 * @param bindingResult 컨트롤러 내 BindingResult
	 * @param fieldName 필드명
	 * @param message 오류 메세지
	 */
	@SuppressWarnings("unchecked")
	public static void addError(BindingResult bindingResult, String fieldName, String message) {
		Map<String, Object> map = new ObjectMapper().convertValue(bindingResult.getTarget(), Map.class);
		bindingResult.addError(new FieldError(bindingResult.getObjectName(), fieldName, map.get(fieldName), false, null, null, message));
	}
}
