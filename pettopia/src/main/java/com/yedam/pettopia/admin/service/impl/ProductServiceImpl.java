package com.yedam.pettopia.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.pettopia.admin.OptionVO;
import com.yedam.pettopia.admin.ProductVO;
import com.yedam.pettopia.admin.mapper.ProductMapper;
import com.yedam.pettopia.admin.service.ProductService;
import com.yedam.pettopia.common.FileUtil;

@Service
public class ProductServiceImpl implements ProductService {

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
	@Transactional
	public int insertPrd(ProductVO vo) {
		// 상품 insert
		int result = productMapper.insertPrd(vo);
		if (result == 1) {
			// 이미지 업로드
			if (vo.getImg() != null) {
				for (int i = 0; i < vo.getImg().length; i++) {
					String filename = FileUtil.fileupload(vo.getImg()[i]);

					vo.setPrdtImg(filename);
					result = productMapper.insertImg(vo);
				}
			}

			if (vo.getImgMain() != null) {
				// 대표 이미지 업로드
				String filename = FileUtil.fileupload(vo.getImgMain());

				vo.setIsMain("Y");
				vo.setPrdtImg(filename);
				result = productMapper.insertImg(vo);
			}

			// 옵션 insert
			if (vo.getOption() != null) {
				ObjectMapper objectMapper = new ObjectMapper();

				try {
					OptionVO[] list = objectMapper.readValue(vo.getOption(), OptionVO[].class);
					System.out.println(list[0]);
					for (int i = 0; i < list.length; i++) {
						list[i].setPrdtId(vo.getPrdtId());
						productMapper.insertOption(list[i]);

						// 옵션 detail insert
						for (int j = 0; j < list[i].getOptionVal().size(); j++) {
							list[i].getOptionVal().get(j).setOptId(list[i].getOptId());
							productMapper.insertOptionDetail(list[i].getOptionVal().get(j));
						}
					}

				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		} else {
			return 0;
		}
		return result;
	}

	@Override
	@Transactional
	public int deleteProduct(ProductVO vo) {
		int result = productMapper.deleteProduct(vo);
		if (result == 1) {
			result = productMapper.deletePrdImg(vo);
			result = productMapper.deleteOptionDetail(vo.getPrdtId());
			result = productMapper.deleteOption(vo.getPrdtId());
		}
		return result;
	}

	@Override
	public List<ProductVO> selectSaleSt() {
		return productMapper.selectSaleSt();
	}

	@Override
	public List<ProductVO> selectLcate() {
		return productMapper.selectLcate();
	}

	@Override
	public List<ProductVO> selectScate(ProductVO vo) {
		return productMapper.selectScate(vo);
	}

	@Override
	public Map<String, Object> selectDetailList(String prdtId) {
		Map<String, Object> map = new HashMap<>();
		ProductVO vo = productMapper.selectDetailList(prdtId);
		map.put("product", vo);
		map.put("imgList", productMapper.selectImg(prdtId));
		map.put("sCatList", productMapper.selectScate(vo));
		map.put("optionList", productMapper.selectOption(prdtId));
		map.put("optionDetailList", productMapper.selectOptionDetail(prdtId));
		return map;
	}

	@Override
	public List<ProductVO> searchList(ProductVO vo) {
		return productMapper.searchList(vo);
	}

	@Override
	public Map<String, Integer> currentPrd() {
		Map<String, Integer> map = new HashMap<>();
		map.put("allPrd", productMapper.insertPrdCount());
		map.put("salePrd", productMapper.salePrdCount());
		map.put("stopPrd", productMapper.stopSalePrdCount());
		return map;
	}

	@Override
	@Transactional
	public int updatePrd(ProductVO vo) {
		// 상품 update
		int result = productMapper.updatePrd(vo);
		if (result == 1) {
			// 이미지 업로드
			if (vo.getImg() != null) {
				// 기존 이미지 삭제
				productMapper.deletePrdImg(vo);
				
				for (int i = 0; i < vo.getImg().length; i++) {
					String filename = FileUtil.fileupload(vo.getImg()[i]);

					vo.setPrdtImg(filename);
					result = productMapper.insertImg(vo);
				}
			}

			if (vo.getImgMain() != null) {
				// 대표 이미지 업로드
				String filename = FileUtil.fileupload(vo.getImgMain());

				vo.setIsMain("Y");
				vo.setPrdtImg(filename);
				result = productMapper.insertImg(vo);
			}

			// 옵션 insert
			if (vo.getOption() != null) {
				// 기존 옵션 삭제
				productMapper.deleteOptionDetail(vo.getPrdtId());
				productMapper.deleteOption(vo.getPrdtId());
				
				ObjectMapper objectMapper = new ObjectMapper();

				try {
					OptionVO[] list = objectMapper.readValue(vo.getOption(), OptionVO[].class);
					System.out.println(list[0]);
					for (int i = 0; i < list.length; i++) {
						list[i].setPrdtId(vo.getPrdtId());
						productMapper.insertOption(list[i]);

						// 옵션 detail insert
						for (int j = 0; j < list[i].getOptionVal().size(); j++) {
							list[i].getOptionVal().get(j).setOptId(list[i].getOptId());
							productMapper.insertOptionDetail(list[i].getOptionVal().get(j));
						}
					}

				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		} else {
			return 0;
		}
		return result;
	}

}
