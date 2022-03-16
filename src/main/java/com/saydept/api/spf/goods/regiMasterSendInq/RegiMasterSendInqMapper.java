package com.saydept.api.spf.goods.regiMasterSendInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqModel;
import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqParamModel;
import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqSearchModel;

@Mapper
public interface RegiMasterSendInqMapper {

		//전체 목록 조회
		List<RegiMasterSendInqModel> getRegiMasterSendInqlist(RegiMasterSendInqParamModel storeParam);
		
		//포스 목록 조회
		List<RegiMasterSendInqSearchModel> getRegiMasterSendInqSearchList(RegiMasterSendInqSearchModel storeParam);
		
}
