package com.saydept.api.app.appSayPlusSale;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.app.appSayPlusSale.model.AppSayPlusSaleModel;
import com.saydept.api.app.appSayPlusSale.model.AppSayPlusSaleParamModel;

@Mapper
public interface AppSayPlusSaleMapper {

		//전체 목록 조회
		List<AppSayPlusSaleModel> getAppSayPlusSalelist(AppSayPlusSaleParamModel storeParam);
		

}
