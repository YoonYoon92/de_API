package com.saydept.api.sda.sleManageCt.ledgrSbManageCt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.sda.sleManageCt.ledgrSbManageCt.model.LedgrSbManageCtModel;
import com.saydept.api.sda.sleManageCt.ledgrSbManageCt.model.LedgrSbManageCtParamModel;

@Mapper
public interface LedgrSbManageCtMapper {

		//부 목록 조회
	List<LedgrSbManageCtModel> selectLedgrSbManageCtlist(LedgrSbManageCtParamModel storeParam);
//	List<LedgrSbManageCtModel> getLedgrSbManageCtlistA(LedgrSbManageCtParamModel storeParam);
		
}
