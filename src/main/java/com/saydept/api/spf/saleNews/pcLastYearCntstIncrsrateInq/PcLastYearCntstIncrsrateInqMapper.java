package com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model.PcLastYearCntstIncrsrateInqModel;
import com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model.PcLastYearCntstIncrsrateInqParamModel;


@Mapper
public interface PcLastYearCntstIncrsrateInqMapper {


	//코너 목록 조회
	List<PcLastYearCntstIncrsrateInqModel> getAll(PcLastYearCntstIncrsrateInqParamModel storeParam);
	//존 목록 조회
	List<PcLastYearCntstIncrsrateInqParamModel> selectzoneStoreList(PcLastYearCntstIncrsrateInqParamModel storeParam);
	
	
}