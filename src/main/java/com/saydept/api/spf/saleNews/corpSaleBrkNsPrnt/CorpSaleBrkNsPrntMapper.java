package com.saydept.api.spf.saleNews.corpSaleBrkNsPrnt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.corpSaleBrkNsPrnt.model.CorpSaleBrkNsPrntModel;
import com.saydept.api.spf.saleNews.corpSaleBrkNsPrnt.model.CorpSaleBrkNsPrntParamModel;

@Mapper
public interface CorpSaleBrkNsPrntMapper {

		//전체 목록 조회
		List<CorpSaleBrkNsPrntModel> getCorpSaleBrkNsPrntlist(CorpSaleBrkNsPrntParamModel storeParam);
		

}
