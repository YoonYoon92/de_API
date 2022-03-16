package com.saydept.api.spf.saleNews.corpSpecialtradSaleBrkNs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.corpSpecialtradSaleBrkNs.model.CorpSpecialtradSaleBrkNsModel;
import com.saydept.api.spf.saleNews.corpSpecialtradSaleBrkNs.model.CorpSpecialtradSaleBrkNsParamModel;

@Mapper
public interface CorpSpecialtradSaleBrkNsMapper {

		//전체 목록 조회
		List<CorpSpecialtradSaleBrkNsModel> getCorpSpecialtradSaleBrkNslist(CorpSpecialtradSaleBrkNsParamModel storeParam);
		

}
