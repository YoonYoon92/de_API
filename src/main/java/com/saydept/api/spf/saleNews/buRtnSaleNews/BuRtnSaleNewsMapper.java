package com.saydept.api.spf.saleNews.buRtnSaleNews;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.buRtnSaleNews.model.BuRtnSaleNewsModel;
import com.saydept.api.spf.saleNews.buRtnSaleNews.model.BuRtnSaleNewsParamModel;

@Mapper
public interface BuRtnSaleNewsMapper {

		//null 목록 조회
		List<BuRtnSaleNewsModel> getNulllist(BuRtnSaleNewsParamModel storeParam);
		
		//점 목록 조회
		List<BuRtnSaleNewsModel> getJumlist(BuRtnSaleNewsParamModel storeParam);
		
		//부 목록 조회
		List<BuRtnSaleNewsModel> getBulist(BuRtnSaleNewsParamModel storeParam);
		
		//팀 목록 조회
		List<BuRtnSaleNewsModel> getTimlist(BuRtnSaleNewsParamModel storeParam);

}
