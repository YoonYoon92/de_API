package com.saydept.api.spf.saleNews.periodyearMmSaleAnalys;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.periodyearMmSaleAnalys.model.PeriodyearMmSaleAnalysModel;
import com.saydept.api.spf.saleNews.periodyearMmSaleAnalys.model.PeriodyearMmSaleAnalysParamModel;

@Mapper
public interface PeriodyearMmSaleAnalysMapper {

		//전체 목록 조회
		List<PeriodyearMmSaleAnalysModel> getPeriodyearMmSaleAnalyslist(PeriodyearMmSaleAnalysParamModel storeParam);
		

}
