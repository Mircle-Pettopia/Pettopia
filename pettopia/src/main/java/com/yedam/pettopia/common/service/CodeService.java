package com.yedam.pettopia.common.service;

import java.util.List;
import java.util.Map;

import com.yedam.pettopia.common.CodeVO;

public interface CodeService {
	// 여러 그룹코드들의 상세코드 조회
	public Map<String, List<CodeVO>> getCodes(String ... gpcdlist);
}
