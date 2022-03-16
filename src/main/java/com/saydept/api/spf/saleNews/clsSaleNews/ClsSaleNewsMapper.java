package com.saydept.api.spf.saleNews.clsSaleNews;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.clsSaleNews.model.ClsSaleNewsModel;
import com.saydept.api.spf.saleNews.clsSaleNews.model.ClsSaleNewsParamModel;

@Mapper
public interface ClsSaleNewsMapper {

		//부 목록 조회
	List<ClsSaleNewsModel> getClsSaleNewslist(ClsSaleNewsParamModel storeParam);
	List<ClsSaleNewsModel> getClsSaleNewslistA(ClsSaleNewsParamModel storeParam);
		
}
