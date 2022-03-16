package com.saydept.api.spf.saleNews.rcptNoDanPumInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.rcptNoDanPumInq.model.RcptNoDanPumInqModel;
import com.saydept.api.spf.saleNews.rcptNoDanPumInq.model.RcptNoDanPumInqParamModel;
import com.saydept.api.spf.saleNews.rcptNoDanPumInq.model.RcptNoDanPumInqSearchModel;

@Mapper
public interface RcptNoDanPumInqMapper {

		//전체 목록 조회
		List<RcptNoDanPumInqModel> getRcptNoDanPumInqlist(RcptNoDanPumInqParamModel storeParam);
		
		//포스 목록 조회
		List<RcptNoDanPumInqSearchModel> getRcptNoDanPumInqSearchList(RcptNoDanPumInqSearchModel storeParam);
		
}
