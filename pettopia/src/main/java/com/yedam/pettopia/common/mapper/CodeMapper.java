package com.yedam.pettopia.common.mapper;

import java.util.List;

import com.yedam.pettopia.common.CodeVO;

public interface CodeMapper {
	// 공통코드 조회
	public List<CodeVO> selectCode(String coCd);
	
}
