package com.saydept.api.scd.custmer.tradingAreaMemberInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.scd.custmer.tradingAreaMemberInq.model.TradingAreaMemberInqModel;

@Mapper
public interface TradingAreaMemberInqMapper {

	TradingAreaMemberInqModel selectTradingAreaMemberInq(TradingAreaMemberInqModel request);
	//상권별조회 - 상권구분 x - 지역구분 x
	List<TradingAreaMemberInqModel> TradingAreaList(TradingAreaMemberInqModel request);
	//상권별조회 - 상권구분 o - 지역구분 x
	List<TradingAreaMemberInqModel> TradingAreaList2(TradingAreaMemberInqModel request);
	//상권별조회 - 상권구분 o - 지역구분 o
	List<TradingAreaMemberInqModel> TradingAreaList3(TradingAreaMemberInqModel request);
	//아파트조회
	List<TradingAreaMemberInqModel> TradingAreaList4(TradingAreaMemberInqModel request);
	
	List<TradingAreaMemberInqModel> tradingAreaCdList(TradingAreaMemberInqModel request);
	
	
	List<TradingAreaMemberInqModel> areaCdList(TradingAreaMemberInqModel request);
}