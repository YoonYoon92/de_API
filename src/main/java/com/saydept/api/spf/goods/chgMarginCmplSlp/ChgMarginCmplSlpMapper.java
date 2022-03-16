package com.saydept.api.spf.goods.chgMarginCmplSlp;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.goods.chgMarginCmplSlp.model.ChgMarginCmplSlpModel;
import com.saydept.api.spf.goods.chgMarginCmplSlp.model.ChgMarginCmplSlpParamModel;

@Mapper
public interface ChgMarginCmplSlpMapper {

		//전체 목록 조회
		List<ChgMarginCmplSlpModel> getChgMarginCmplSlplist(ChgMarginCmplSlpParamModel storeParam);
		

}
