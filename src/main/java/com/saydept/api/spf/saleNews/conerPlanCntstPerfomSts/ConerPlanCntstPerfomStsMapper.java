package com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts.model.ConerPlanCntstPerfomStsModel;
import com.saydept.api.spf.saleNews.eventHallSaleInq.model.EventHallSaleInqModel;
import com.saydept.api.spf.saleNews.eventHallSaleInq.model.EventHallSaleInqSearchModel;

@Mapper
public interface ConerPlanCntstPerfomStsMapper {


	List<ConerPlanCntstPerfomStsModel> selectConerPlanCntstPerfomStsList(ConerPlanCntstPerfomStsModel request);
	//조회(부)
	List<ConerPlanCntstPerfomStsModel> PcList(ConerPlanCntstPerfomStsModel request);
		
		
	ArrayList<ConerPlanCntstPerfomStsModel> selectConerPlanCntstPerfomStsList1();
	

}