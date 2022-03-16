package com.saydept.api.spf.saleNews.clsPlnNetSaleSlt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.clsPlnNetSaleSlt.model.ClsPlnNetSaleSltModel;
import com.saydept.api.spf.saleNews.clsPlnNetSaleSlt.model.ClsPlnNetSaleSltParamModel;

@Mapper
public interface ClsPlnNetSaleSltMapper {

		//전체 목록 조회
		List<ClsPlnNetSaleSltModel> getClsPlnNetSaleSltlist(ClsPlnNetSaleSltParamModel storeParam);
		

}
