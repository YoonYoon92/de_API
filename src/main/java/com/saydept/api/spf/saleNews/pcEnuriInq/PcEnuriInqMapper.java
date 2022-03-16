package com.saydept.api.spf.saleNews.pcEnuriInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//import com.saydept.api.spf.goods.regiMasterSendInq.model.RegiMasterSendInqSearchModel;
import com.saydept.api.spf.saleNews.pcEnuriInq.model.PcEnuriInqModel;
import com.saydept.api.spf.saleNews.pcEnuriInq.model.PcEnuriInqParamModel;
import com.saydept.api.spf.saleNews.pcEnuriInq.model.PcEnuriInqSearchModel;

@Mapper
public interface PcEnuriInqMapper {

		//전체 목록 조회
		List<PcEnuriInqModel> getPcEnuriInqlist(PcEnuriInqParamModel storeParam);
		
		//포스 목록 조회
		List<PcEnuriInqSearchModel> getPcEnuriInqSearchList(PcEnuriInqSearchModel storeParam);
				
		//사유 목록 조회
		List<PcEnuriInqSearchModel> getPcEnuriInqSearchList2(PcEnuriInqSearchModel storeParam);
		

}
