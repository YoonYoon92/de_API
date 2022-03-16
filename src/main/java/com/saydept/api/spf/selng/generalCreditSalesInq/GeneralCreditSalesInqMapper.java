package com.saydept.api.spf.selng.generalCreditSalesInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqModel;
import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqParamModel;
import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqTrModel;

@Mapper
public interface GeneralCreditSalesInqMapper {


	List<GeneralCreditSalesInqModel> selectGeneralCreditSalesInqList(GeneralCreditSalesInqParamModel request);

	List<GeneralCreditSalesInqTrModel> selectGeneralCreditSalesInqListTr(GeneralCreditSalesInqParamModel request);
	
	GeneralCreditSalesInqParamModel selectGeneralCreditSalesInqListM06(GeneralCreditSalesInqParamModel request);

	GeneralCreditSalesInqParamModel selectGeneralCreditSalesInqListM07(GeneralCreditSalesInqParamModel request);
	
}