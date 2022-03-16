package com.saydept.api.spf.puchas.buyReqFormInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.puchas.buyReqFormInq.model.BuyReqFormInqModel;

@Mapper
public interface BuyReqFormInqMapper {

	BuyReqFormInqModel selectBuyReqFormInq(BuyReqFormInqModel request);

	List<BuyReqFormInqModel> selectBuyReqFormInqList(BuyReqFormInqModel request);
	
	List<BuyReqFormInqModel> selectDetailList(BuyReqFormInqModel request);

	

}