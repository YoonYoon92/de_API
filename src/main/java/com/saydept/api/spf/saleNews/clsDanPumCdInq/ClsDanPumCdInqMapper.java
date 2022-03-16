package com.saydept.api.spf.saleNews.clsDanPumCdInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.clsDanPumCdInq.model.ClsDanPumCdInqModel;
import com.saydept.api.spf.saleNews.clsDanPumCdInq.model.ClsDanPumCdInqParamModel;

@Mapper
public interface ClsDanPumCdInqMapper {

		//전체 목록 조회
		List<ClsDanPumCdInqModel> getClsDanPumCdInqlist(ClsDanPumCdInqParamModel storeParam);
		

}
