package com.saydept.api.app.appSayPlusPointExt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saydept.api.app.appSayPlusPointExt.model.AppSayPlusPointExtModel;
import com.saydept.api.app.appSayPlusPointExt.model.AppSayPlusPointExtParamModel;

@Mapper
public interface AppSayPlusPointExtMapper {

		//전체 목록 조회
		List<AppSayPlusPointExtModel> getAppSayPlusPointExtlist(AppSayPlusPointExtParamModel storeParam);
		

}
