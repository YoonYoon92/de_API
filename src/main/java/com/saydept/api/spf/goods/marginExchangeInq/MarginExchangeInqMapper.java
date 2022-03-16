package com.saydept.api.spf.goods.marginExchangeInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.goods.clsInq.model.ClsInqModel;
import com.saydept.api.spf.goods.marginExchangeInq.model.MarginExchangeInqModel;

@Mapper
public interface MarginExchangeInqMapper {

	MarginExchangeInqModel selectMarginExchangeInq(MarginExchangeInqModel request);

	List<MarginExchangeInqModel> selectMarginExchangeInqList(MarginExchangeInqModel request);

	//코너목록조회
	List<MarginExchangeInqModel> selectConerList(MarginExchangeInqModel request);
		
}