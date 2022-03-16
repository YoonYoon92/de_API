package com.saydept.api.spf.salePrice.salePriceChgReqFormInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.salePrice.salePriceChgReqFormInq.model.SalePriceChgReqFormInqModel;

@Mapper
public interface SalePriceChgReqFormInqMapper {


	List<SalePriceChgReqFormInqModel> selectSalePriceChgReqFormInqList(SalePriceChgReqFormInqModel request);
	
	List<SalePriceChgReqFormInqModel> selectDetailList(SalePriceChgReqFormInqModel request);

	

}