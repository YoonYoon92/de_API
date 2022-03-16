package com.saydept.api.spf.saleNews.directoryOfPartnersInq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.spf.saleNews.directoryOfPartnersInq.model.DirectoryOfPartnersInqModel;
import com.saydept.api.spf.saleNews.directoryOfPartnersInq.model.DirectoryOfPartnersInqParamModel;

@Mapper
public interface DirectoryOfPartnersInqMapper {

		//전체 목록 조회
		List<DirectoryOfPartnersInqModel> getDirectoryOfPartnersInqlist(DirectoryOfPartnersInqParamModel storeParam);
		

}
