package com.saydept.api.spf.selng.cornerMarginChgSalesInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.selng.cornerMarginChgSalesInq.model.CornerMarginChgSalesInqModel;
import com.saydept.api.spf.selng.cornerMarginChgSalesInq.model.CornerMarginChgSalesInqParamModel;

@Mapper
public interface CornerMarginChgSalesInqMapper {


	List<CornerMarginChgSalesInqModel> selectCornerMarginChgSalesInqList(CornerMarginChgSalesInqParamModel request);

}