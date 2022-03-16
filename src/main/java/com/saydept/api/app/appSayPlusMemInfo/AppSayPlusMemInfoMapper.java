package com.saydept.api.app.appSayPlusMemInfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.app.appSayPlusMemInfo.model.AppSayPlusMemInfoModel;
import com.saydept.api.app.appSayPlusMemInfo.model.AppSayPlusMemInfoParamModel;

@Mapper
public interface AppSayPlusMemInfoMapper {

		//전체 목록 조회
		List<AppSayPlusMemInfoModel> getAppSayPlusMemInfolist(AppSayPlusMemInfoParamModel storeParam);
		AppSayPlusMemInfoModel getAppSayPlusMemlostPoint(AppSayPlusMemInfoModel infoparam);

}
