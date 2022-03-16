package com.saydept.api.spf.selng.singleItemSalesInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.selng.singleItemSalesInq.model.SingleItemSalesInqModel;
import com.saydept.api.spf.selng.singleItemSalesInq.model.SingleItemSalesInqParamModel;

@Mapper
public interface SingleItemSalesInqMapper {


	List<SingleItemSalesInqModel> selectSingleItemSalesInqList(SingleItemSalesInqParamModel request);

	List<SingleItemSalesInqParamModel> selectStoreComboLargeCatList();
	
	List<SingleItemSalesInqParamModel> selectStoreComboMidiumCatList(SingleItemSalesInqParamModel request);
	
	List<SingleItemSalesInqParamModel> selectStoreComboSmallCatList(SingleItemSalesInqParamModel request);
	

}