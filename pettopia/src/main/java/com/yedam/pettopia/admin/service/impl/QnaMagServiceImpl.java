package com.yedam.pettopia.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.admin.QnaMagVO;
import com.yedam.pettopia.admin.mapper.QnaMagMapper;
import com.yedam.pettopia.admin.service.QnaMagService;

@Service
public class QnaMagServiceImpl implements QnaMagService {

	@Autowired
	QnaMagMapper qnaMagMapper;

	@Override
	public List<QnaMagVO> qnaAllList() {
		return qnaMagMapper.qnaAllList();
	}

	@Override
	public Map<String, Integer> qstStCnt() {
		Map<String, Integer> map = new HashMap<>();
		map.put("qstStCnt1", qnaMagMapper.qstStCnt1()); // 답변 대기
		map.put("qstStCnt2", qnaMagMapper.qstStCnt2()); // 답변 완료
		
		return map;
	}

	@Override
	public int insertQnaReply(QnaMagVO vo) {
		return qnaMagMapper.insertQnaReply(vo);
	}
}
