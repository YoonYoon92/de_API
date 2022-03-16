package com.saydept.api.spf.excel.dayAggregation;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.excel.dayAggregation.model.DayAggregationModel;
import com.saydept.api.spf.excel.dayAggregation.model.DayAggregationParamModel;

@Mapper
public interface DayAggregationMapper {

	DayAggregationModel selectDayAggregation(DayAggregationModel request);

	List<DayAggregationModel> selectDayAggregationList(DayAggregationParamModel request);
	List<DayAggregationModel> selectDayAggregationList2(DayAggregationParamModel request);
	List<DayAggregationModel> selectDayAggregationList3(DayAggregationParamModel request);
	

}