package com.saydept.api.spf.saleNews.conerMmAvrageSaleInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.conerMmAvrageSaleInq.model.ConerMmAvrageSaleInqModel;
import com.saydept.api.spf.saleNews.conerMmAvrageSaleInq.model.ConerMmAvrageSaleInqParamModel;

@Mapper
public interface ConerMmAvrageSaleInqMapper {

	
	List<ConerMmAvrageSaleInqModel> selectConerMmAvrageSaleInqList(ConerMmAvrageSaleInqParamModel request);
	
	
	List<ConerMmAvrageSaleInqModel> selectConerMmAvrageSaleInqList2(ConerMmAvrageSaleInqParamModel request);





}