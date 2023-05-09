package com.yedam.pettopia.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.common.CodeVO;
import com.yedam.pettopia.common.mapper.CodeMapper;
import com.yedam.pettopia.common.service.CodeService;

@Service
public class CodeServiceImpl implements CodeService{

	@Autowired
	CodeMapper codeMapper;
	
	// 여러 그룹코드들의 상세코드 조회
	@Override
	public Map<String, List<CodeVO>> getCodes(String... gpCdlist) {
		Map<String, List<CodeVO>> map = new HashMap<String, List<CodeVO>>();
		for(String gpCd : gpCdlist) {
			map.put(gpCd, codeMapper.selectCode(gpCd));
		}
		return map;
	}

}
