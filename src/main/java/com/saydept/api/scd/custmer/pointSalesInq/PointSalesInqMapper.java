package com.saydept.api.scd.custmer.pointSalesInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.scd.custmer.pointSalesInq.model.PointSalesInqModel;

@Mapper
public interface PointSalesInqMapper {

	PointSalesInqModel selectPointSalesInq(PointSalesInqModel request);
	
	PointSalesInqModel pointInform(PointSalesInqModel request);

	List<PointSalesInqModel> selectPointSalesInqList(PointSalesInqModel request);

	int updatePointSalesInq(PointSalesInqModel request);

	int insertPointSalesInq(PointSalesInqModel request);

	int savePointSalesInq(PointSalesInqModel request);

	int deletePointSalesInq(PointSalesInqModel request);

}