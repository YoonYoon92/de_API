package com.saydept.api.spf.org.nonSalesCornerByPeriodMgt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtClassClosedModel;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtCornerClosedModel;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtModel;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtParamModel;

@Mapper
public interface NonSalesCornerByPeriodMgtMapper {
	
	//미사용 코너 리스트
	List<NonSalesCornerByPeriodMgtModel> selectNonSalesCornerByPeriodList(NonSalesCornerByPeriodMgtParamModel request);	
	
	//미사용 클래스 리스트 
	List<NonSalesCornerByPeriodMgtClassClosedModel> selectClassList(NonSalesCornerByPeriodMgtCornerClosedModel request);
	
	//미사용 코너 폐기 update
	int updateNonSalesCornerClosed(NonSalesCornerByPeriodMgtCornerClosedModel request);
	
	//미사용 클래스 폐기 update
	int updateNonSalesClassClosed(NonSalesCornerByPeriodMgtClassClosedModel request);	
	
	//미사용 단품 폐기 update
	int updateNonSalesDanpumClosed(NonSalesCornerByPeriodMgtClassClosedModel request);
	
	//폐기 클래스전송 내역 update
	int updateNonSalesClassSendClosed(NonSalesCornerByPeriodMgtClassClosedModel request);
	
	//폐기 클래스전송 내역 insert
	int insertNonSalesClassSendClosed(NonSalesCornerByPeriodMgtClassClosedModel request);
}
