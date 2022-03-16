package com.saydept.api.scd.custmer.tradingAreaPostInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.scd.custmer.tradingAreaPostInq.model.TradingAreaPostInqModel;

@Mapper
public interface TradingAreaPostInqMapper {

	TradingAreaPostInqModel selectTradingAreaPostInq(TradingAreaPostInqModel request);

	List<TradingAreaPostInqModel> selectTradingAreaPostInqList(TradingAreaPostInqModel request);

	List<TradingAreaPostInqModel> tradingAreaCdList(TradingAreaPostInqModel request);

}