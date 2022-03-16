package com.saydept.api.spf.selng.salesByTypeInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.selng.salesByTypeInq.model.SalesByTypeInqDetailModel;
import com.saydept.api.spf.selng.salesByTypeInq.model.SalesByTypeInqModel;
import com.saydept.api.spf.selng.salesByTypeInq.model.SalesByTypeInqParamModel;

@Mapper
public interface SalesByTypeInqMapper {


	List<SalesByTypeInqModel> selectSalesByTypeInqList(SalesByTypeInqParamModel request);
	
	SalesByTypeInqDetailModel selectSalesByTypeInqDetail(SalesByTypeInqParamModel request);


}