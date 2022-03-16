package com.saydept.api.spf.saleNews.eventHallSaleInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.eventHallSaleInq.model.EventHallSaleInqModel;
import com.saydept.api.spf.saleNews.eventHallSaleInq.model.EventHallSaleInqSearchModel;

@Mapper
public interface EventHallSaleInqMapper {

	EventHallSaleInqModel selectEventHallSaleInq(EventHallSaleInqModel request);
     
	//행사장목록 조회
	List<EventHallSaleInqSearchModel> PcList(EventHallSaleInqSearchModel request);
	//행사장목록 조회
	List<EventHallSaleInqSearchModel> SearchEventlist(EventHallSaleInqSearchModel request);
	//행사매출 조회(점)
	List<EventHallSaleInqModel> EventHallSaleInqListJum(EventHallSaleInqSearchModel request);
	//행사매출 조회(부)
	List<EventHallSaleInqModel> EventHallSaleInqListBu(EventHallSaleInqSearchModel request);
	//행사매출 조회(부)
	List<EventHallSaleInqModel> EventHallSaleInqListPc(EventHallSaleInqSearchModel request);
}