package com.saydept.api.spf.saleNews.creditCardApprInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.creditCardApprInq.model.CreditCardApprInqModel;
import com.saydept.api.spf.saleNews.creditCardApprInq.model.CreditCardApprInqParamModel;

@Mapper
public interface CreditCardApprInqMapper {

		//전체 목록 조회
		List<CreditCardApprInqModel> getCreditCardApprInqlist(CreditCardApprInqParamModel storeParam);
		

}
