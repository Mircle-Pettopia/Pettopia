package com.yedam.pettopia.admin.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.pettopia.admin.ProductVO;
import com.yedam.pettopia.admin.mapper.ProductMapper;
import com.yedam.pettopia.admin.service.ProductService;
import com.yedam.pettopia.common.FileUtil;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductMapper productMapper;

	@Override
	public List<ProductVO> selectPrdAllList() {
		return productMapper.selectPrdAllList();
	}

	@Override
	public int insertPrdCount() {
		return productMapper.insertPrdCount();
	}

	@Override
	public int salePrdCount() {
		return productMapper.salePrdCount();
	}

	@Override
	public int stopSalePrdCount() {
		return productMapper.stopSalePrdCount();
	}

	@Override
	public int insertPrd(ProductVO vo) {
	    int result = productMapper.insertPrd(vo);
	    if(result == 1) {
	    	if(vo.getImg() != null) {
	    		for(int i = 0; i < vo.getImg().length; i++) {
	    			String filename = FileUtil.fileupload(vo.getImg()[i]);
	    			
	    			vo.setPrdtImg(filename);
	    			result = productMapper.insertImg(vo);
	    		}
	    	}
	    	
	    	// 대표 이미지 업로드
	    	String filename = FileUtil.fileupload(vo.getImgMain());
			
	    	vo.setIsMain("Y");
			vo.setPrdtImg(filename);
			System.out.println("여기출력 " + vo);
			result = productMapper.insertImg(vo);
	        
	    } else {
	        return 0;
	    }
	    return 1;
	}


	@Override
	public ProductVO selectDetailList(ProductVO vo) {
		return productMapper.selectDetailList(vo);
	}

//	@Override
//	public int insertImg(ProductVO vo) {
//		return productMapper.insertImg(vo);
//	}
}
