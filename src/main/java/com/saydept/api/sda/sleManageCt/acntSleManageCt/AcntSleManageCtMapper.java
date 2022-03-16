package com.saydept.api.sda.sleManageCt.acntSleManageCt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.sda.sleManageCt.acntSleManageCt.model.AcntSleManageCtModel;
import com.saydept.api.sda.sleManageCt.acntSleManageCt.model.AcntSleManageCtParamModel;

@Mapper
public interface AcntSleManageCtMapper {

		//부 목록 조회
	List<AcntSleManageCtModel> selectAcntSleManageCtlist(AcntSleManageCtParamModel storeParam);
//	List<AcntSleManageCtModel> getAcntSleManageCtlistA(AcntSleManageCtParamModel storeParam);
		
}
